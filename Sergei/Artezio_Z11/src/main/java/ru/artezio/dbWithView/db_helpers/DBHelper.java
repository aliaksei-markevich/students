package ru.artezio.dbWithView.db_helpers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.artezio.dbWithView.models.ObjectForJSON;
import ru.artezio.dbWithView.models.TreeBranch;

import java.sql.*;
import java.util.Iterator;
import java.util.List;

/**
 * Класс использующий hibernate для работы с таблицами в бд
 *
 * @param <T> Объекты, которые будут использоваться для записи и чтения из БД
 */
public class DBHelper<T> {

    private final Class<T> type;

    private final SessionFactory factory;

    public DBHelper(Class<T> type) {
        factory = new Configuration().configure().buildSessionFactory();
        this.type = type;
    }

    public interface Command<T> {
        T process(Session s);
    }

    private <T> T transaction(final Command<T> command) {
        final Session session = factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            return command.process(session);
        } finally {
            tx.commit();
            session.close();
        }
    }

    public final List<T> exportFromDB() {

        return transaction((Session session) -> session.createQuery("from " + type.getSimpleName()).list());
    }

    public Class<T> getMyType() {
        return this.type;
    }

    public final void importToDB(List<T> list, ObjectForJSON obj) {
        int count = 0;
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            transaction((Session session) -> session.save(iterator.next()));
            count++;
        }
        obj.setCountUploadRecords(count);
    }

    public final void clearTable() {
        transaction((Session session) -> session.createQuery("delete from " + getMyType().getSimpleName()).executeUpdate());
    }

}
