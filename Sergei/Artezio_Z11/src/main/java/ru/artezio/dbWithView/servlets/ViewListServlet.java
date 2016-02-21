package ru.artezio.dbWithView.servlets;

import org.springframework.context.support.AbstractApplicationContext;
import ru.artezio.dbWithView.db_helpers.DBHelperDAO;
import ru.artezio.dbWithView.springhelpers.SingletonContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ViewListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AbstractApplicationContext context = SingletonContext.getInstance();
        DBHelperDAO dbHelper = (DBHelperDAO) context.getBean("dbheleprclients");
        req.setAttribute("data", dbHelper.exportFromDB());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/ViewList.jsp");
        if (dispatcher != null) {
            dispatcher.forward(req, resp);
        }
    }
}

