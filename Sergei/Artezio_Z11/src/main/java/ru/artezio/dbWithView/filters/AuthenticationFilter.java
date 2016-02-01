package ru.artezio.dbWithView.filters;

import ru.artezio.dbWithView.models.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AuthenticationFilter implements Filter {


    public void init(FilterConfig fConfig) throws ServletException {
    }


    public void destroy() {
    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            RequestDispatcher rd = req.getRequestDispatcher("/login");
            rd.forward(request, response);
            return;
        }
//        if(((HttpServletRequest) request).getRequestURI().equals("/import") && !user.getName().equals("root")){
//            RequestDispatcher rd = req.getRequestDispatcher("/views/ErrorUser.jsp");
//            rd.forward(request, response);
//            return;
//        }
        chain.doFilter(request, response);
    }

}
