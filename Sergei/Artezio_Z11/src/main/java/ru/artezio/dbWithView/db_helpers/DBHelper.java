package ru.artezio.dbWithView.db_helpers;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.artezio.dbWithView.dto.ObjectForJSON;
import ru.artezio.dbWithView.models.Client;


import java.util.Iterator;
import java.util.List;

@Repository
public class DBHelper<T> implements DBHelperDAO<T> {

    private Class<T> type;

    public Class<T> getType() {
        return type;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }

    private final HibernateTemplate template;

    @Autowired
    public DBHelper(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public List<T> exportFromDB() {
        return (List<T>) this.template.find("from " + type.getSimpleName());
    }

    @Transactional
    @Override
    public void importToDB(List<T> list, ObjectForJSON obj) {
        int count = 0;
        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.template.save(iterator.next());
            count++;
        }
        System.out.println(count);
        obj.setCountUploadRecords(count);
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
    public Class<T> getMyType() {
        return null;
    }

}
