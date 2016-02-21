package ru.artezio.dbWithView.dto;

public class ObjectForJSON {
    String status = "OK";
    int countUploadRecords;
    long sizeFile;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCountUploadRecords() {
        return countUploadRecords;
    }

    public void setCountUploadRecords(int countUploadRecords) {
        this.countUploadRecords = countUploadRecords;
    }

    public long getSizeFile() {
        return sizeFile;
    }

    public void setSizeFile(long sizeFile) {
        this.sizeFile = sizeFile;
    }
}
