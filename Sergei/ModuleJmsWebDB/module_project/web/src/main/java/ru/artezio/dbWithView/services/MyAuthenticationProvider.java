package ru.artezio.dbWithView.services;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import ru.artezio.db.db_helpers.HibernateDAO;
import ru.artezio.db.models.User;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@Service("provider")
public class MyAuthenticationProvider implements AuthenticationProvider {

    static private final Logger log = (Logger) LoggerFactory.getLogger(AuthenticationProvider.class);

    @Autowired
    @Qualifier("dbHelperUserSite")
    public HibernateDAO dbHelper;

    private  Map<String, User> getUsers() {
        log.info("Получение списка пользователей");
        List<User> listUsers = dbHelper.exportFromDB();
        Map<String, User> mapUsers = new HashMap<String, User>();
        Iterator<User> iteratorUsers = listUsers.iterator();
        while (iteratorUsers.hasNext()) {
            User user = iteratorUsers.next();
            mapUsers.put(user.getName(), user);
        }
        return mapUsers;
    }

    private User validateLogin(String name, String password) {
        Map<String, User> users= getUsers();
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

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<GrantedAuthority> authorities = new ArrayList<>();
        User user = validateLogin(login, password);
        if (user != null) {
            authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
            MDC.put("login",login);
            MDC.put("password",password);
            log.info("АУНТЕФИКАЦИЯ");
            return new UsernamePasswordAuthenticationToken(login, password, authorities);
        } else {
            return null;
        }
    }

    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
