package ru.artezio.dbWithView.db_helpers;

import org.hibernate.Session;
import ru.artezio.dbWithView.models.Client;
import java.util.List;


public class ClientHibernateHelper extends DBHelper<Client> {

    public ClientHibernateHelper() {
        super();
    }

    @Override
    protected void executeDeleteQuery(Session session) {
        session.createQuery("delete from Client ").executeUpdate();
    }

    @Override
    protected List<Client> executeSelectQuery(Session session) {
        return session.createQuery("from Client").list();
    }
}
