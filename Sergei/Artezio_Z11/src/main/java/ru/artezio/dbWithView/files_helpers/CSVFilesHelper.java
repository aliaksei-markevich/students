package ru.artezio.dbWithView.files_helpers;

import au.com.bytecode.opencsv.CSVReader;
import ru.artezio.dbWithView.models.ObjectForJSON;
import ru.artezio.dbWithView.models.TreeBranch;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс позволяющий считывать объекты с файла CSV
 */
public class CSVFilesHelper implements FilesHelperInterface<TreeBranch> {

    public  List<TreeBranch> createElements(InputStream inputStream, ObjectForJSON obj) {

        CSVReader reader = null;
        String[] nextLine;
        String encoding = "UTF8";
        List<TreeBranch> listBranches = new ArrayList<TreeBranch>();
        try {
            reader = new CSVReader(new InputStreamReader(inputStream, encoding), ',');
            while ((nextLine = reader.readNext()) != null) {
                listBranches.add(new TreeBranch(Integer.parseInt(nextLine[0]), nextLine[1], Integer.parseInt(nextLine[2])));
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setStatus("Ошибка в чтении csv файла");
        } finally {
            try {
                inputStream.close();
                reader.close();
            }
            catch (IOException e){
                e.printStackTrace();
                obj.setStatus("Ошибка в закрытии потока");
            }
            finally {
                return listBranches;
            }
        }
    }
}
