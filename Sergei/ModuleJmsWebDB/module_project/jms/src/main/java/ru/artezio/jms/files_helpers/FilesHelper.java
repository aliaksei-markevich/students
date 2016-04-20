package ru.artezio.jms.files_helpers;

import ru.artezio.db.dto.ObjectForJSON;

import java.io.InputStream;
import java.util.List;

public interface FilesHelper<T> {
    List<T> createElements(InputStream inputStream, ObjectForJSON obj);
}
