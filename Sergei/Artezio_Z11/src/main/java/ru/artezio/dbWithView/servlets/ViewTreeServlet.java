package ru.artezio.dbWithView.servlets;

import ru.artezio.dbWithView.models.TreeNode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewTreeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tree = TreeNode.createTree();
        req.setAttribute("tree",tree);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/ViewTree.jsp");
        if (dispatcher != null){
            dispatcher.forward(req, resp);
        }
    }
}
