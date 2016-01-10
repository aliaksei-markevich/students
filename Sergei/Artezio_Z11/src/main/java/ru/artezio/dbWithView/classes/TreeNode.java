package ru.artezio.dbWithView.classes;

import ru.artezio.dbWithView.models.TreeBranch;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
     * Метод берет ветви из БД и заносит их в перемсуннею allBranches
     */
    private static void exportBranchesFromDB() {
        Connection conn = null;
        ResultSet rs = null;
        Statement s = null;
        try {
            conn = ControllerForTables.getConnection();
            String sql = "SELECT * FROM treetable";
            s = conn.createStatement();
            s.executeQuery(sql);
            rs = s.getResultSet();
            while (rs.next()) {
                allBranches.add(new TreeBranch(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                s.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Метод возвращает строку для постройки denytree
     *
     * @return строку для denytree
     */
    public static String createTree() {
        allBranches = new ArrayList<TreeBranch>();
        boolean firstRootBranch = true;
        exportBranchesFromDB();
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
     * @param sb строка в которую записывается само дерево
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
