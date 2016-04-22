package ru.artezio.jms.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("factoryMethodForConverters")
public class FactoryMethodForConverters {

    @Autowired
    @Qualifier("XSLToXMLConverter")
    ConvertToXML xslConverter;

    @Autowired
    @Qualifier("CSVToXMLConverter")
    ConvertToXML csvConverter;

    public ConvertToXML getConverter(String originalFileName) throws Exception {
        ConvertToXML convertToXML;
        if (getExpansion(originalFileName).equals("csv")) {
            convertToXML = csvConverter;
        } else if (getExpansion(originalFileName).equals("xls")) {
            convertToXML = xslConverter;
        } else {
            throw new Exception("Данное расширение не поддерживается");
        }
        return convertToXML;
    }

    private String getExpansion(String originalFileName) {
        int lenghtFileName = originalFileName.length();
        return originalFileName.substring(lenghtFileName - 3, lenghtFileName);
    }
}
