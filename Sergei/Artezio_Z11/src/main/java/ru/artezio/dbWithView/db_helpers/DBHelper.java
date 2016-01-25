package ru.artezio.dbWithView.db_helpers;

import ru.artezio.dbWithView.models.ObjectForJSON;

import java.sql.*;
import java.util.Iterator;
import java.util.List;

/**
 * Абстрактный класс для реализации классов, которые будут осуществлять работу с конекретной таблцой БД
 *
 * @param <T> Объекты, которые будут использоваться для записи и чтения из БД
 */
abstract public class DBHelper<T> {

    public final Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/artezio_db";
        String username = "postgres";
        String password = "root";
        return DriverManager.getConnection(url, username, password);
    }

    public final void importToDB(List<T> list, ObjectForJSON obj) {
        int count = 0;
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            Iterator<T> iterator = list.iterator();
            while (iterator.hasNext()) {
                T element = iterator.next();
                int updateCount = executeUpdateQuery(element, stmt);
                count += updateCount;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            obj.setStatus("Ошибка sql");
        } catch (Exception e) {
            e.printStackTrace();
            obj.setStatus("Exception error");
        } finally {
            try {
                conn.close();
                stmt.close();
            } catch (NullPointerException e) {
                e.printStackTrace();
                obj.setStatus("Ошибка Null");
            } catch (SQLException e) {
                e.printStackTrace();
                obj.setStatus("Ошибка SQL");
            } finally {
                obj.setCountUploadRecords(count);
            }
        }
    }

    public final List<T> exportFromDB() {
        List<T> list = null;
        Connection conn = null;
        Statement s = null;
        try {
            conn = getConnection();
            s = conn.createStatement();
            list = executeSelectQuery(s);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                return list;
            }
        }
    }

    public final void deleteTable() {
        Connection conn = null;
        Statement s = null;
        try {
            conn = getConnection();
            String sql = executeDeleteQuery();
            s = conn.createStatement();
            s.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected abstract int executeUpdateQuery(T element, Statement stmt) throws SQLException;

    protected abstract String executeDeleteQuery();

    protected abstract List<T> executeSelectQuery(Statement stm) throws SQLException;

}
