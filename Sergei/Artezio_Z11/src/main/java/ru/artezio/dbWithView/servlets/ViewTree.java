package ru.artezio.dbWithView.servlets;

import ru.artezio.dbWithView.classes.ControllerForTables;
import ru.artezio.dbWithView.classes.TreeNode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewTree extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("clear")!=null) ControllerForTables.deleteTableClients("treetable");
        String tree = TreeNode.createTree();
        req.setAttribute("tree",tree);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/ViewTree.jsp");
        if (dispatcher != null){
            dispatcher.forward(req, resp);
        }
    }
}
