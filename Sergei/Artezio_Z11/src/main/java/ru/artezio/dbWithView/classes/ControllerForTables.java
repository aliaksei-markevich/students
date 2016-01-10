package ru.artezio.dbWithView.classes;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import au.com.bytecode.opencsv.CSVReader;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;


/**
 * Класс реализующий импорт таблиц в бд
 */
public class ControllerForTables {

    /**
     * Получение соединение с бд
     *
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/artezio_db";
        String username = "postgres";
        String password = "root";
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * Метод импортирует из xls в БД
     */
    public static void importExcelToDB() {

        /**
         * Переменные для хранения значений таблицы
         */
        String lastName, firstName;
        int numberPhone, code;
        Connection conn = null;
        Statement stmt = null;
        InputStream in = null;
        HSSFWorkbook wb = null;

        //String s= new java.io.File("src\\main\\resources\\tables\\1.xls").getAbsolutePath();
        final String PATH_XLS_FILE = "E:\\Artezio\\dbJsJquery\\src\\main\\resources\\tables\\1.xls";
        try {
            in = new FileInputStream(PATH_XLS_FILE);
            wb = new HSSFWorkbook(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet = wb.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            while (it.hasNext()) {
                Row row = it.next();
                lastName = row.getCell(0).toString();
                firstName = row.getCell(1).toString();
                numberPhone = (int) row.getCell(2).getNumericCellValue();
                code = (int) row.getCell(3).getNumericCellValue();
                stmt.executeUpdate("INSERT INTO \"Клиенты\"(\n" +
                        " \"Фамилия клиента\", \"Имя клиента\", \"Телефон\", \"Какой-то код\")" +
                        "    VALUES ('" + lastName + "','" + firstName + "','" + numberPhone + "','" + code + "');");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                in.close();
                stmt.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Метод импортирует из csv в БД
     */
    public static void importCsvToDB() {

        CSVReader reader = null;
        Connection conn = null;
        Statement stmt = null;
        String s = "E:\\Artezio\\dbJsJquery\\src\\main\\resources\\tables\\3.csv";
        //String PATHCSV = new java.io.File("src\\main\\resources\\tables\\2.csv").getAbsolutePath();
        String[] nextLine;
        FileInputStream myInputStream = null;
        String encoding = "UTF8";
        try {
            myInputStream = new FileInputStream(s);
            reader = new CSVReader(new InputStreamReader(myInputStream, encoding), ',');
            conn = getConnection();
            stmt = conn.createStatement();
            while ((nextLine = reader.readNext()) != null) {
                stmt.executeUpdate("INSERT INTO treetable(" +
                        "             id , title, parent_id)" +
                        "    VALUES ('" + Integer.parseInt(nextLine[0]) + "','" + nextLine[1] + "','" + Integer.parseInt(nextLine[2]) + "');");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                myInputStream.close();
                reader.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Метод позволяет очистить таблицу в БД
     */
    public static void deleteTableClients(String tableName) {
        Connection conn = null;
        Statement s = null;
        try {
            conn = getConnection();
            String sql = "DELETE FROM "+tableName;
            if(tableName.equals("Клиенты")){
                sql+=";alter sequence sq_global restart;";
            }
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

}

