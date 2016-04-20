package ru.artezio.db.db_helpers;


import ru.artezio.db.dto.ObjectForJSON;

import java.util.List;

/**
 * Класс использующий hibernate для работы с таблицами в бд
 *
 * @param <T> Объекты, которые будут использоваться для записи и чтения из БД
 */
public interface HibernateDAO<T> {
    List exportFromDBWithString(String value);
    List<T> exportFromDB();
    void importToDB(List<T> list, ObjectForJSON obj);
    void clearTable();
    void saveModel(T item);
    Object getEntity(int index);
}
