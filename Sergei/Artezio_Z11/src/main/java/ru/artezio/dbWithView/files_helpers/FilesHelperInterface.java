package ru.artezio.dbWithView.files_helpers;

import ru.artezio.dbWithView.models.ObjectForJSON;

import java.io.InputStream;
import java.util.List;

public interface FilesHelperInterface<T> {
   List<T> createElements(InputStream inputStream, ObjectForJSON obj);
}
