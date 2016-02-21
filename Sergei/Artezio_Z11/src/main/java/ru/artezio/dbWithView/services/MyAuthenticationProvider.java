package ru.artezio.dbWithView.services;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.artezio.dbWithView.db_helpers.DBHelperDAO;
import ru.artezio.dbWithView.models.User;
import ru.artezio.dbWithView.springhelpers.SingletonContext;

import java.util.*;

@Service("provider")
public class MyAuthenticationProvider implements AuthenticationProvider {

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

    @Transactional
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();
        List<GrantedAuthority> authorities = new ArrayList<>();
        User user = validateLogin(login, password);
        if (user != null) {
            authorities.add(new SimpleGrantedAuthority(user.getRole()));
            return new UsernamePasswordAuthenticationToken(login, password, authorities);
        } else {
            return null;
        }
    }

    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
