package ru.artezio.dbWithView.uploaders;

import org.springframework.web.multipart.MultipartFile;
import ru.artezio.dbWithView.db_helpers.DBHelperDAO;
import ru.artezio.dbWithView.files_helpers.FilesHelperInterface;
import ru.artezio.dbWithView.dto.ObjectForJSON;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public abstract class Uploader<T> {

    public abstract ObjectForJSON uploadFile(MultipartFile file);

    protected final void createRecordInDB(MultipartFile file, List<T> list, FilesHelperInterface fileHelper,
                                          DBHelperDAO hibernate, ObjectForJSON obj) {
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
