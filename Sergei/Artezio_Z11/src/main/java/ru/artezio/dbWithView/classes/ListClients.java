package ru.artezio.dbWithView.classes;

import ru.artezio.dbWithView.models.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс позволяющий достать клиентво из Бд
 */
public class ListClients {

    /**
     * Метод возвращает коллекцию клиенктов из БД
     * @return
     */
    static public List<Client> receiptClientsFromDB() {
        List<Client> listClients = new ArrayList<Client>();
        Connection conn = null;
        ResultSet rs = null;
        Statement s = null;
        try {
            conn = ControllerForTables.getConnection();
            String sql = "SELECT * FROM Клиенты";
            s = conn.createStatement();
            s.executeQuery(sql);
            rs = s.getResultSet();
            while (rs.next()) {
                listClients.add(new Client(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
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
        return listClients;
    }

}
