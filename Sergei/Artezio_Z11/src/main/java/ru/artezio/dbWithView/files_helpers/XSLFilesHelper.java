package ru.artezio.dbWithView.files_helpers;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Component;
import ru.artezio.dbWithView.dto.AnotherId;
import ru.artezio.dbWithView.models.Client;
import ru.artezio.dbWithView.dto.ObjectForJSON;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Component("xslFilesHelper")
public class XSLFilesHelper implements FilesHelper<Client> {

    public List<Client> createElements(InputStream inputStream, ObjectForJSON obj) {

        String lastName, firstName;
        int numberPhone;
        AnotherId code;
        List<Client> listClients = new ArrayList<Client>();
        HSSFWorkbook wb = null;
        try {
            wb = new HSSFWorkbook(inputStream);

            Sheet sheet = wb.getSheetAt(0);
            Iterator<Row> it = sheet.iterator();
            while (it.hasNext()) {
                Row row = it.next();
                lastName = row.getCell(0).toString();
                firstName = row.getCell(1).toString();
                numberPhone = (int) row.getCell(2).getNumericCellValue();
                code = new AnotherId((int) row.getCell(3).getNumericCellValue(),
                        (int) row.getCell(4).getNumericCellValue(),
                        (int) row.getCell(5).getNumericCellValue());
                listClients.add(new Client(lastName, firstName, numberPhone, code));
            }
        } catch (Exception e) {
            e.printStackTrace();
            obj.setStatus("Ошибка в файлу");
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                obj.setStatus("Ошибка в закрытии потока");
            } finally {
                return listClients;
            }
        }
    }
}
