;function ObjectFromJSON(status, countUploadRecords, sizeFile) {
    this.status = status;
    this.countUploadRecords = countUploadRecords;
    this.sizeFile = sizeFile;
}
ObjectFromJSON.prototype.show = function () {
    alert("Статус: "+this.status+"\n"+
        "Количество обновленных строк "+this.countUploadRecords+"\n"+
        "Размер файла "+this.sizeFile);
}