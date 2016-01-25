package ru.artezio.dbWithView.db_helpers;

import ru.artezio.dbWithView.models.TreeBranch;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс позволяющий работать с таблицей treetable в БД
 */
public class DBTreeHelper extends DBHelper<TreeBranch> {

    @Override
    protected String executeDeleteQuery() {
        return "DELETE FROM treetable";
    }

    @Override
    protected int executeUpdateQuery(TreeBranch branch, Statement stmt) throws SQLException {
        return stmt.executeUpdate("INSERT INTO treetable(" +
                "             id , title, parent_id)" +
                "    VALUES ('" + branch.getId() + "','" + branch.getText() + "','" +
                branch.getParentId() + "');");
    }

    @Override
    protected List<TreeBranch> executeSelectQuery(Statement stm) throws SQLException{
        List<TreeBranch> listBranches = new ArrayList<TreeBranch>();
        String sql = "SELECT * FROM treetable";
        stm.executeQuery(sql);
        ResultSet  rs = stm.getResultSet();
        while (rs.next()) {
            listBranches.add(new TreeBranch(rs.getInt(1), rs.getString(2), rs.getInt(3)));
        }
        return listBranches;
    }
}
