package ru.artezio.dbWithView.models;

import ru.artezio.dbWithView.db_helpers.DBHelper;
import ru.artezio.dbWithView.db_helpers.DBTreeHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализующий "создание" дерева для denytree
 */
public class TreeNode {

    /**
     * Хранит все ветви дерева
     */
    private static List<TreeBranch> allBranches;

    /**
     * Метод возвращает строку для постройки denytree
     *
     * @return строку для denytree
     */
    public static String createTree() {
        allBranches = new ArrayList<TreeBranch>();
        boolean firstRootBranch = true;
        DBHelper helper = new DBTreeHelper();
        allBranches = helper.exportFromDB();
        StringBuffer sb = new StringBuffer();
        sb.delete(0, sb.length());
        sb.append("children: [\n");
        for (int i = 0; i < allBranches.size(); i++) {
            if (allBranches.get(i).getParentId() == 0) {
                if (firstRootBranch == false) sb.append(",\n");
                sb.append("{title: \"" + allBranches.get(i).getText() + "\"");
                checkChildrenBranches(sb, allBranches.get(i));
                firstRootBranch = false;
            }
            //System.out.println("----------------\n"+sb);
        }
        sb.append("]");
        //System.out.println("----------------\n"+sb);
        return sb.toString();
    }

    /**
     * Метод для проверки дочерних ветвей
     *
     * @param sb     строка в которую записывается само дерево
     * @param branch
     */
    private static void checkChildrenBranches(StringBuffer sb, TreeBranch branch) {
        boolean isFolder = false;
        boolean firstBranch = true;
        // System.out.println("----------------\n"+sb);
        for (int i = 0; i < allBranches.size(); i++) {
            if (allBranches.get(i).getParentId() == branch.getId()) {
                if (isFolder == false) {
                    sb.append(", isFolder: true,\n");
                    sb.append("children: [\n");
                    isFolder = true;
                }
                if (firstBranch == false) sb.append(",");
                sb.append("{title: \"" + allBranches.get(i).getText() + "\"");
                checkChildrenBranches(sb, allBranches.get(i));
                firstBranch = false;
            }
        }
        if (isFolder == true)
            sb.append("]");
        sb.append("}");
    }
}
