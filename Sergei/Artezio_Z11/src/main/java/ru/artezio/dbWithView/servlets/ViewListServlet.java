package ru.artezio.dbWithView.servlets;

import ru.artezio.dbWithView.db_helpers.DBClientsHelper;
import ru.artezio.dbWithView.db_helpers.DBHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ViewListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBHelper helper=new DBClientsHelper();
        req.setAttribute("data",helper.exportFromDB());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/ViewList.jsp");
        if (dispatcher != null) {
            dispatcher.forward(req, resp);
        }
    }
}
