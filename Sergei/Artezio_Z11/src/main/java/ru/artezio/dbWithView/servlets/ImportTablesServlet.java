package ru.artezio.dbWithView.servlets;

import ru.artezio.dbWithView.classes.ControllerForTables;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ImportTablesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/ImportTables.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //проверка какая из кнопок была нажата
        if (req.getParameter("buttonXls") != null) {
            ControllerForTables.importExcelToDB();
        } else {
            ControllerForTables.importCsvToDB();
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/ImportTables.jsp");
        dispatcher.forward(req, resp);
    }
}
