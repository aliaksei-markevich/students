package ru.artezio.dbWithView.converters;

import org.springframework.web.multipart.MultipartFile;

public interface ConvertToXML {
    String convertFile(MultipartFile file, String pathFile);
}
