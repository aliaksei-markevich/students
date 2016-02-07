package ru.artezio.dbWithView.db_helpers;

import org.hibernate.Session;
import ru.artezio.dbWithView.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс позволяющий работать с таблицей пользователей в БД
 */
public class UserHibernateDBHelper extends DBHelper<User> {
    public UserHibernateDBHelper() {
        super();
    }

    @Override
    protected void executeDeleteQuery(Session session) {
        session.createQuery("delete from TreeBranch ").executeUpdate();
    }

    @Override
    protected List<User> executeSelectQuery(Session session) {
        return session.createQuery("from User").list();
    }
}
