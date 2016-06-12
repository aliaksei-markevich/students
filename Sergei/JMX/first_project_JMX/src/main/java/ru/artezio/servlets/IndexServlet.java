package ru.artezio.servlets;

import ru.artezio.beans.MessageBeanMBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    @EJB
    MessageBeanMBean messageBeanMBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message",messageBeanMBean);
        req.getRequestDispatcher("jsp/index.jsp").forward(req, resp);
    }
}
