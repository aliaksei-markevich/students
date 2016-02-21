package ru.artezio.dbWithView.servlets;

import com.google.gson.Gson;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import ru.artezio.dbWithView.db_helpers.*;
import ru.artezio.dbWithView.springhelpers.SingletonContext;
import ru.artezio.dbWithView.uploaders.Uploader;
import ru.artezio.dbWithView.dto.ObjectForJSON;

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
        DBHelperDAO dbHelper = null;
        AbstractApplicationContext context = SingletonContext.getInstance();
        if (req.getParameter("clear") != null && req.getParameter("clear").equals("1")) {
            dbHelper = (DBHelperDAO) context.getBean("dbheleprclients");
            dbHelper.clearTable();
        }
        if (req.getParameter("clear") != null && req.getParameter("clear").equals("2")) {
            dbHelper = (DBHelperDAO) context.getBean("dbhelpertreetable");
            dbHelper.clearTable();
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/ImportTables.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int lenghtFileName = 0;
        AbstractApplicationContext context = SingletonContext.getInstance();
        ObjectForJSON obj = new ObjectForJSON();
        Uploader fileUpload = null;
       /* MultipartFile filePart = req.getPart("file");
        try {
            if (filePart != null && filePart.getSubmittedFileName() != null) {
                lenghtFileName = filePart.getSubmittedFileName().length();
                //Если фал xls то в список, если csv то в дерево
                if (filePart.getSubmittedFileName().substring(lenghtFileName - 3, lenghtFileName).equals("xls")) {
                    fileUpload = (Uploader) context.getBean("xsluploder");
                    fileUpload.uploadFile(filePart, obj);
                } else if (filePart.getSubmittedFileName().substring(lenghtFileName - 3, lenghtFileName).equals("csv")) {
                    fileUpload = (Uploader) context.getBean("csvuploder");
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
            resp.getWriter().flush();*/
        //}

    }
}

