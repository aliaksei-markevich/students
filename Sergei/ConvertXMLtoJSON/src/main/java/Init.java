import java.io.*;


public class Init {

    static final String CHARSET_NAME = "UTF8";
    static final String BEGIN_TAG_CHARACTER = "<";
    static final String END_TAG_CHARACTER = ">";
    static final String BEGIN_CLOSE_TAG_CHARACTER = "<\\";
    static final String BEGIN_NODE_CHARACTER = "{";
    static final String END_NODE_CHARACTER = "}";
    static final String BEGIN_CLOSE_HEADER_TAG_CHARACTER = "<?";
    static final String END_CLOSE_HEADER_TAG_CHARACTER = "?>";
    static final String BEGIN_ARRAY = "[";
    static final String CLOSE_ARRAY = "]";
    static final String DOT = ".";
    static final String COMMA = ",";
    static final String TAB = "\t";
    static final String PATH_SAVE_JSON_FILE = "./json.json";

    static File xmlFile;
    static StringBuilder sbXMLFile;

    public static void main(String[] args) {
        try {
            getFile(args);
            getStringBuilderFromXMLFile();
            saveJsonToFile(convertXMLToJSON());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void getFile(String[] args) throws Exception {
        if (args.length == 0) {
            throw new Exception("Укажите аргумент");
        }
        xmlFile = new File(args[0]);
        if (!xmlFile.isFile() || !getFileExtension(xmlFile.getName()).equals("xml")) {
            throw new Exception("Путь или расширение плохие");
        }
    }

    private static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(DOT) + DOT.length();
        return fileName.substring(dotIndex);
    }

    private static void getStringBuilderFromXMLFile() throws Exception {
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(xmlFile), CHARSET_NAME));
            String str;
            sbXMLFile = new StringBuilder();
            while ((str = in.readLine()) != null) {
                sbXMLFile.append((str));
            }
            sbXMLFile = new StringBuilder(sbXMLFile.toString().replaceAll("  ", ""));
        } catch (Exception ex) {
            throw new Exception("Ошибка в открытии потока");
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                throw new Exception("Ошибка в закрытии потока");
            }
        }
    }

    private static String convertXMLToJSON() throws Exception {
        int rootLevel = 1;
        StringBuilder sbJSON = new StringBuilder();
        if (sbXMLFile.substring(0, BEGIN_CLOSE_HEADER_TAG_CHARACTER.length()).equals(BEGIN_CLOSE_HEADER_TAG_CHARACTER)) {
            deleteHeaderXML();
        }
        sbJSON.append(BEGIN_NODE_CHARACTER + "\n");
        sbJSON.append(parseXMLandCreateJSON(rootLevel, ""));
        sbJSON.append("\n" + END_NODE_CHARACTER);
        return sbJSON.toString();
    }

    private static void deleteHeaderXML() throws Exception {
        try {
            int lastIndexHeader = sbXMLFile.indexOf(END_CLOSE_HEADER_TAG_CHARACTER) + END_CLOSE_HEADER_TAG_CHARACTER.length();
            sbXMLFile.delete(0, lastIndexHeader);
        } catch (Exception ex) {
            throw new Exception("Ошибка в headerXML");
        }
    }

    private static String parseXMLandCreateJSON(int level, String nodeNameArray) throws Exception {
        StringBuilder sbHelpPart = new StringBuilder();
        StringBuilder sbMainJSON = new StringBuilder();
        String nodeName = getNodeNameWithDelete();
        boolean isMoreThenOneNode = false;
        boolean isValueNode = false;
        try {
            sbMainJSON.append(setNodeName(nodeNameArray, nodeName, level));
            while (!getCloseNodeName(nodeName).equals(nodeName)) {
                if (BEGIN_TAG_CHARACTER.charAt(0) == sbXMLFile.charAt(0)) {
                    if (isMoreThenOneNode) {
                        sbHelpPart.append(COMMA + "\n");
                    } else {
                        sbHelpPart.append(" " + BEGIN_NODE_CHARACTER + "\n");
                        isMoreThenOneNode = true;
                    }
                    sbHelpPart.append(parseXMLandCreateJSON(level + 1, ""));
                } else {
                    sbHelpPart.append(" \"").append(getNodeValueWithDelete()).append("\"");
                    isValueNode = true;
                }
            }
            sbXMLFile.delete(0, nodeName.length() + (BEGIN_CLOSE_TAG_CHARACTER + END_TAG_CHARACTER).length());
            //проверка на первый элемент в массиве
            String nextNodeName = getNodeName();
            if (sbXMLFile.length() >= nextNodeName.length() && nextNodeName.equals(nodeName) && !nodeName.equals(nodeNameArray)) {
                level++;
                sbMainJSON.append(" " + BEGIN_ARRAY + "\n").append(spaceTab(level));
            }
            sbMainJSON.append(sbHelpPart).append(checkNode(nodeName, nodeNameArray, level, isValueNode));
            return sbMainJSON.toString();
        } catch (Exception ex) {
            throw new Exception("Ошибка в xml файле");
        }
    }

    private static String checkNode(String nodeName, String nodeNameArray, int level, boolean isValueNode) throws Exception {
        boolean isCloseArray = false;
        StringBuilder sbTEmp = new StringBuilder();
        if (!isValueNode) {
            sbTEmp.append("\n").append(spaceTab(level)).append(END_NODE_CHARACTER);
        }
        while (getNodeName().equals(nodeName)) {
            isCloseArray = true;
            sbTEmp.append(parseXMLandCreateJSON(level, nodeName));
        }
        if (isCloseArray && !nodeName.equals(nodeNameArray)) {
            sbTEmp.append("\n").append(spaceTab(level - 1)).append(CLOSE_ARRAY);
        }
        return sbTEmp.toString();
    }

    private static String setNodeName(String nodeNameArray, String nodeName, int level) {
        String appendToSBMain;
        if (!nodeNameArray.equals(nodeName)) {
            appendToSBMain = spaceTab(level) + "\"" + nodeName + "\":";
        } else {
            appendToSBMain = COMMA + "\n" + spaceTab(level);
        }
        return appendToSBMain;
    }

    private static String getNodeName() {
        int startIndexSign = sbXMLFile.indexOf(BEGIN_TAG_CHARACTER);
        int finishIndexSign = sbXMLFile.indexOf(END_TAG_CHARACTER);
        String nodeName = "";
        if (startIndexSign >= 0 && finishIndexSign >= 0) {
            nodeName = sbXMLFile.substring(startIndexSign + 1, finishIndexSign);
        }
        return nodeName;
    }

    private static String getCloseNodeName(String nodeName) {
        return sbXMLFile.substring(BEGIN_CLOSE_TAG_CHARACTER.length(),
                nodeName.length() + BEGIN_CLOSE_TAG_CHARACTER.length());
    }

    private static String getNodeNameWithDelete() {
        String nodeName = getNodeName();
        sbXMLFile.delete(0, nodeName.length() + (BEGIN_TAG_CHARACTER + END_TAG_CHARACTER).length());
        return nodeName;
    }

    private static String getNodeValueWithDelete() {
        String nodeValue;
        int indexFinishValue = sbXMLFile.indexOf(BEGIN_TAG_CHARACTER);
        nodeValue = sbXMLFile.substring(0, indexFinishValue);
        sbXMLFile.delete(0, nodeValue.length());
        return nodeValue;
    }

    private static String spaceTab(int level) {
        String spaces = "";
        for (int i = 0; i < level; i++) {
            spaces += TAB;
        }
        return spaces;
    }

    private static void saveJsonToFile(String stJSON) throws Exception {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(PATH_SAVE_JSON_FILE));
            writer.write(stJSON);
        } catch (Exception e) {
            throw new Exception("Ошибка в записи файла");
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
                throw new Exception("Ошибка в закрытии потока");
            }
        }
    }

}

