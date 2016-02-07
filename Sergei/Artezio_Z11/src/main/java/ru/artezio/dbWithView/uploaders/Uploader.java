package ru.artezio.dbWithView.uploaders;

import ru.artezio.dbWithView.db_helpers.DBHelper;
import ru.artezio.dbWithView.files_helpers.FilesHelperInterface;
import ru.artezio.dbWithView.models.ObjectForJSON;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public abstract class Uploader<T> {

    public abstract void uploadFile(Part file, ObjectForJSON obj);

    protected final void createRecordInDB(Part file, List<T> list, FilesHelperInterface fileHelper,
                                          DBHelper hibernate, ObjectForJSON obj) {
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            list = fileHelper.createElements(inputStream, obj);
            hibernate.importToDB(list, obj);
        } catch (IOException e) {
            e.printStackTrace();
            obj.setStatus("Ошибка в потоке");
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                obj.setStatus("Ошибка в закрытии потока");
            }
        }
    }
}
