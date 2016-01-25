package ru.artezio.dbWithView.servlets;

import com.google.gson.Gson;
import ru.artezio.dbWithView.db_helpers.DBClientsHelper;
import ru.artezio.dbWithView.db_helpers.DBHelper;
import ru.artezio.dbWithView.db_helpers.DBTreeHelper;
import ru.artezio.dbWithView.uploaders.Uploader;
import ru.artezio.dbWithView.uploaders.CSVUploader;
import ru.artezio.dbWithView.uploaders.XSLUploader;
import ru.artezio.dbWithView.models.ObjectForJSON;

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
        DBHelper helper = null;
        if (req.getParameter("clear") != null && req.getParameter("clear").equals("1")) {
            helper = new DBClientsHelper();
            helper.deleteTable();
        }

        if (req.getParameter("clear") != null && req.getParameter("clear").equals("2")) {
            helper = new DBTreeHelper();
            helper.deleteTable();
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/ImportTables.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int lenghtFileName = 0;
        ObjectForJSON obj = new ObjectForJSON();
        Uploader fileUpload = null;
        Part filePart = req.getPart("file");
        try {
            if (filePart != null && filePart.getSubmittedFileName() != null) {
                lenghtFileName = filePart.getSubmittedFileName().length();
                //Если фал xls то в список, если csv то в дерево
                if (filePart.getSubmittedFileName().substring(lenghtFileName - 3, lenghtFileName).equals("xls")) {
                    fileUpload = new XSLUploader();
                    fileUpload.uploadFile(filePart, obj);
                } else if (filePart.getSubmittedFileName().substring(lenghtFileName - 3, lenghtFileName).equals("csv")) {
                    fileUpload = new CSVUploader();
                    fileUpload.uploadFile(filePart, obj);
                } else {
                    obj.setStatus("Ошибка в расширении файла");
                    obj.setCountUploadRecords(0);
                    obj.setSizeFile(filePart.getSize());
                }
            } else {
                obj.setStatus("Файл не выбран");
                obj.setCountUploadRecords(0);
                obj.setSizeFile(0);
            }
        } finally {
            String json = new Gson().toJson(obj);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("utf-8");
            resp.getWriter().write(json);
            resp.getWriter().flush();
        }

    }
}

