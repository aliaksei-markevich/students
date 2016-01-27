package ru.artezio.dbWithView.db_helpers;

import ru.artezio.dbWithView.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс позволяющий работать с таблицей пользователей в БД
 */
public class DBUsersHelper extends DBHelper<User> {
    @Override
    protected int executeUpdateQuery(User element, Statement stmt) throws SQLException {
        return 0;
    }

    @Override
    protected String executeDeleteQuery() {
        return null;
    }

    @Override
    protected List<User> executeSelectQuery(Statement stm) throws SQLException {
        List<User> listUsers = new ArrayList<User>();
        String sql = "SELECT * FROM users_site";
        stm.executeQuery(sql);
        ResultSet rs = stm.getResultSet();
        while (rs.next()) {
            listUsers.add(new User(rs.getString(2), rs.getString(3)));
        }
        return listUsers;
    }
}
