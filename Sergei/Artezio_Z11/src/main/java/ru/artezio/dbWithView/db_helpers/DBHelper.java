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
 * Абстрактный класс для реализации классов, которые будут осуществлять работу с конекретной таблцой БД
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

    public final List<T> exportFromDB() {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            return session.createQuery("from "+getMyType().getSimpleName()).list();
        } finally {
            tx.commit();
            session.close();
        }
    }

    public Class<T> getMyType() {
        return this.type;
    }

    public final void importToDB(List<T> list, ObjectForJSON obj) {
        final Session session = factory.openSession();
        int count=0;
        Transaction tx = session.beginTransaction();
        Iterator<T> iterator = list.iterator();
        try {
            while (iterator.hasNext()){
                session.save(iterator.next());
                count++;}
        } catch (Exception e) {
            e.printStackTrace();
            obj.setStatus("Ошибка в importToDB добавить "+count+" строке");
        } finally {
            obj.setCountUploadRecords(count);
            tx.commit();
            session.close();
        }

    }

    public final void clearTable() {
        final Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.createQuery("delete from "+getMyType().getSimpleName()).executeUpdate();
        } finally {
            tx.commit();
            session.close();
        }

    }

}
