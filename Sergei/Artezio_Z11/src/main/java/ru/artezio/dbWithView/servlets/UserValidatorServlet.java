package ru.artezio.dbWithView.servlets;

import org.springframework.context.support.AbstractApplicationContext;
import ru.artezio.dbWithView.db_helpers.DBHelperDAO;import ru.artezio.dbWithView.models.User;
import ru.artezio.dbWithView.springhelpers.SingletonContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserValidatorServlet extends HttpServlet {

    private static final Map<String, User> users = getUsers();

    private static Map<String, User> getUsers() {
        AbstractApplicationContext context = SingletonContext.getInstance();
        DBHelperDAO dbHelper = (DBHelperDAO) context.getBean("dbheleprueserssite");
        List<User> listUsers = dbHelper.exportFromDB();
        Map<String, User> mapUsers = new HashMap<String, User>();
        Iterator<User> iteratorUsers = listUsers.iterator();
        while (iteratorUsers.hasNext()) {
            User user = iteratorUsers.next();
            mapUsers.put(user.getName(), user);
        }
        return mapUsers;
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/Login.jsp");
        rd.forward(req, res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd;
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        User user = validateLogin(name, password);

        if (user == null) {
            rd = req.getRequestDispatcher("/views/LoginError.jsp");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            rd = req.getRequestDispatcher("/views/LoginSuccess.jsp");
        }

        rd.forward(req, res);
    }

    private User validateLogin(String name, String password) {

        if (name == null || password == null) {
            return null;
        }

        User user = users.get(name);

        if (user == null) {
            return null;
        }

        if (!user.getPassword().equals(password.trim())) {
            return null;
        }

        return user;
    }
}