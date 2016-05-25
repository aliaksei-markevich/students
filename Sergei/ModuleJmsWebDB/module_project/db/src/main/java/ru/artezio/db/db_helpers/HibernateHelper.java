package ru.artezio.db.db_helpers;

import javafx.util.Pair;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import ru.artezio.db.dto.ObjectForJSON;
import ru.artezio.db.models.Client;
import ru.artezio.db.models.Position;
import ru.artezio.db.models.TreeBranch;


import java.util.*;


public class HibernateHelper<T> implements HibernateDAO<T> {

    private Class<T> type;

    public Class<T> getType() {
        return type;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }


    private final HibernateTemplate template;

    @Autowired
    public HibernateHelper(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public List<T> exportFromDB() {return (List<T>) this.template.find("from " + type.getSimpleName());
    }

    @Transactional
    @Override
    public void importToDB(List<T> list, ObjectForJSON obj) {
        int count = 0;
        Session session = this.template.getSessionFactory().openSession();
        session.beginTransaction();
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            session.save(iterator.next());
            count++;
        }
        session.getTransaction().commit();
        obj.setCountUploadRecords(count);
        session.close();
    }

    @Transactional
    @Override
    public void clearTable() {
        this.template.deleteAll(this.template.find("from " + type.getSimpleName()));
        if (this.type.getSimpleName().equals("Client")) {
            this.template.getSessionFactory().getCurrentSession().createSQLQuery("alter sequence sq_global restart with 1").executeUpdate();
        }
    }


    @Override
    public List exportFromDBWithString(String value) {
        Session session = this.template.getSessionFactory().openSession();
        value = value + "%";
        List results;
        if (type.getSimpleName().equals("Client")) {
            results = session.createCriteria(Client.class, "client")
                    .add(Restrictions.like("client.lastName", value))
                    .setProjection(Projections.projectionList()
                            .add(Projections.property("client.lastName"), "clientLastName")
                            .add(Projections.property("client.idClient"), "clientIdClient")
                    )
                    .list();
        } else {
            results = session.createCriteria(TreeBranch.class, "branch")
                    .add(Restrictions.like("branch.text", value))
                    .setProjection(Projections.projectionList()
                            .add(Projections.property("branch.text"), "clientLastName")
                            .add(Projections.property("branch.id"), "clientIdClient")
                    )
                    .list();
        }
        session.close();
        return convertToPairList(results);
    }

    @Transactional
    @Override
    public void saveModel(T item) {
        this.template.save(item);
    }

    private List<Pair> convertToPairList(List<Object[]> queryList) {
        List<Pair> listPair = new ArrayList<Pair>();
        Iterator<Object[]> iterator = queryList.iterator();
        while (iterator.hasNext()) {
            Object[] item = iterator.next();
            listPair.add(new Pair(item[0], item[1]));
        }
        return listPair;

    }

    @Override
    public Object getEntity(int index) {
        Session session = this.template.getSessionFactory().openSession();
        Object entity = session.load(Position.class, index);
        session.close();
        return entity;
    }
}
