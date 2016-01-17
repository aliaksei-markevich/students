package ru.artezio.dbWithView.servlets;

import ru.artezio.dbWithView.classes.ControllerForTables;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig(maxFileSize = 16177215)
public class ImportTablesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("clear")!=null && req.getParameter("clear").equals("1") ) ControllerForTables.deleteTableClients("Клиенты");
        if(req.getParameter("clear")!=null && req.getParameter("clear").equals("2")) ControllerForTables.deleteTableClients("treetable");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/ImportTables.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int lenghtFileName=0;
        Part filePart = req.getPart("file");
        if (filePart != null) {
            lenghtFileName=filePart.getSubmittedFileName().length();
            //для проверки
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            System.out.println(filePart.toString());
            System.out.println(filePart.getSubmittedFileName());
        }
        //Если фал xls то в список, если csv то в дерево
        if (filePart.getSubmittedFileName().substring(lenghtFileName-3,lenghtFileName).equals("xls") ) {
            ControllerForTables.importExcelToDB(filePart.getInputStream());
        } else if (filePart.getSubmittedFileName().substring(lenghtFileName-3,lenghtFileName).equals("csv")) {
            ControllerForTables.importCsvToDB(filePart.getInputStream());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/ImportTables.jsp");
        dispatcher.forward(req, resp);
    }
}
