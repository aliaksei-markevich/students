package ru.artezio.jms.files_helpers;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.artezio.db.db_helpers.HibernateDAO;
import ru.artezio.db.dto.AnotherId;
import ru.artezio.db.dto.ObjectForJSON;
import ru.artezio.db.models.Client;
import ru.artezio.db.models.Position;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Component("xslFilesHelper")
public class XSLFilesHelper implements FilesHelper<Client> {

    @Autowired
    @Qualifier("dbHelperPosition")
    public HibernateDAO dbHelper;

    public List<Client> createElements(InputStream inputStream, ObjectForJSON obj) {

        String lastName, firstName;
        int numberPhone;
        AnotherId code;
        List<Client> listClients = new ArrayList<>();
        HSSFWorkbook wb;
        try {
            wb = new HSSFWorkbook(inputStream);
            Sheet sheet = wb.getSheetAt(0);
            for (Row row : sheet) {
                lastName = row.getCell(0).toString();
                firstName = row.getCell(1).toString();
                numberPhone = (int) row.getCell(2).getNumericCellValue();
                code = new AnotherId((int) row.getCell(3).getNumericCellValue(),
                        (int) row.getCell(4).getNumericCellValue(),
                        (int) row.getCell(5).getNumericCellValue());
                Client client = new Client(lastName, firstName, numberPhone, code);
                if (row.getCell(7).toString().indexOf(",") > 0) {
                    String[] numbersOfPositions = row.getCell(7).toString().split(",");
                    for (String numberOfPosition : numbersOfPositions) {
                        int index = (int) Math.floor(Integer.parseInt(numberOfPosition.trim()));
                        client.addPosition((Position) dbHelper.getEntity(index));
                    }
                } else {
                    client.addPosition((Position) dbHelper.getEntity((int) row.getCell(7).getNumericCellValue()));
                }
                listClients.add(client);
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
