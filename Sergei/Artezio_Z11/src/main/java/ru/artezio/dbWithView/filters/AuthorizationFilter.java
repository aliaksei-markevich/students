package ru.artezio.dbWithView.filters;

import ru.artezio.dbWithView.models.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        String url = ((HttpServletRequest) servletRequest).getRequestURI();
        switch (url) {
            case "/import": {
                if (!user.getName().equals("admin")) {
                    RequestDispatcher rd = req.getRequestDispatcher("/views/ErrorUser.jsp");
                    rd.forward(servletRequest, servletResponse);
                    return;
                }
                break;
            }
            case "/viewList":
            case "/viewTree":
            case "/login": {
                break;
            }
            default: {
                if(!url.substring(0,4).equals("/js/") && !url.substring(0,5).equals("/css/") &&
                        !url.substring(0,7).equals("/image/")){
                    RequestDispatcher rd = req.getRequestDispatcher("/views/ErrorJSP.jsp");
                    rd.forward(servletRequest, servletResponse);
                }
            }
        }

    filterChain.doFilter(servletRequest,servletResponse);
}

    public void destroy() {

    }
}
