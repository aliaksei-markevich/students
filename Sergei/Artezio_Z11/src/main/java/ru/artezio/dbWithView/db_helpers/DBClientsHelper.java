package ru.artezio.dbWithView.db_helpers;

import ru.artezio.dbWithView.models.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс позволяющий работать с таблицей Клиентов в БД
 */
public class DBClientsHelper extends DBHelper<Client> {

    @Override
    protected int executeUpdateQuery(Client client, Statement stmt) throws SQLException {
        return stmt.executeUpdate("INSERT INTO \"Клиенты\"(\n" +
                " \"Фамилия клиента\", \"Имя клиента\", \"Телефон\", \"Какой-то код\")" +
                "    VALUES ('" + client.getLastName() + "','" + client.getFirstName() + "','" +
                client.getNumberPhone() + "','" + client.getAnotherId() + "');");
    }

    @Override
    protected String executeDeleteQuery() {
        return "DELETE FROM Клиенты" + ";alter sequence sq_global restart;";
    }

    @Override
    protected List<Client> executeSelectQuery(Statement stm) throws SQLException {
        List<Client> listClients = new ArrayList<Client>();
        String sql = "SELECT * FROM Клиенты";
        stm.executeQuery(sql);
        ResultSet rs = stm.getResultSet();
        while (rs.next()) {
            listClients.add(new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
        }
        return listClients;
    }
}
