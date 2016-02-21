package ru.artezio.dbWithView.db_helpers;

import org.springframework.orm.hibernate4.HibernateTemplate;
import ru.artezio.dbWithView.dto.ObjectForJSON;

import java.util.List;

/**
 * Класс использующий hibernate для работы с таблицами в бд
 *
 * @param <T> Объекты, которые будут использоваться для записи и чтения из БД
 */
public interface DBHelperDAO<T> {
    List<T> exportFromDB();
    void importToDB(List<T> list, ObjectForJSON obj);
    void clearTable();
    Class<T> getMyType();
}
