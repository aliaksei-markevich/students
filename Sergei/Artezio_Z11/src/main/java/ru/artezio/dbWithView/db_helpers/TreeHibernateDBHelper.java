package ru.artezio.dbWithView.db_helpers;

import org.hibernate.Session;
import ru.artezio.dbWithView.models.TreeBranch;

import java.util.List;

public class TreeHibernateDBHelper extends DBHelper<TreeBranch>{

    public TreeHibernateDBHelper() {
        super();
    }

    @Override
    protected void executeDeleteQuery(Session session) {
        session.createQuery("delete from TreeBranch ").executeUpdate();
    }

    @Override
    protected List<TreeBranch> executeSelectQuery(Session session) {
        return session.createQuery("from TreeBranch").list();
    }
}
