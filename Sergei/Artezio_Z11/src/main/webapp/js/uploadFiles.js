;
function uploadFiles(number) {
    var str = 'uploadFile' + number;
    var input = $("#" + str);
    var fd = new FormData();
    fd.append('file', input.prop('files')[0]);
    var object1;
    $.ajax({
        type: 'POST',
        url: '/import',
        data: fd,
        processData: false,
        contentType: false,
        dataType: 'json',
        success: function (data) {
            object1 = new ObjectFromJSON(data.status, data.countUploadRecords, data.sizeFile);
            object1.show();
            var errorMsg = "";
            if (object1.status != "OK") errorMsg = "с ошибкой ";

            if (number != 1 && !$("*").is("#span" + number)) {
                $("<br><span style='color:green' id='span" + number + "'>Загрузка выполнена " + errorMsg + object1.countUploadRecords + " строчек</span>").insertAfter("#uploadButton" + number);
            }
            else if (!$("*").is("#span" + number)) {
                $("<br><span style='color:green' id='span" + number + "'>Загрузка выполнена " + errorMsg + object1.countUploadRecords + " строчек</span>").insertAfter("#addInput");
            }
            else {
                $("#span" + number).text("Загрузка выполнена " + errorMsg + object1.countUploadRecords + " строчек");
            }

            if (object1.status != "OK") {
                $("#span" + number).css("color", "red");
            }
            else{
                $("#span" + number).css("color", "green");
            }

        },
        /* error: function (data) {
         object = new ObjectFromJSON(data.status, data.countUploadRecords, data.sizeFile);
         object.show();
         if (number != 1 && !$("span").is("#span" + number)) {
         $("<br><span style='color:red' id='span" + number + "'>Загрузка выполнена с ошибкой " + $(count).text() + "</span>").insertAfter("#uploadButton" + number);
         }
         else if (!$("span").is("#span" + number)) {
         $("<br><span style='color:red' id='span" + number + "'>Загрузка выполнена с ошибкой " + $(count).text() + "</span>").insertAfter("#addInput");
         }
         else {
         $("#span" + number).css("color", "red");
         $("#span" + number).text("Загрузка выполнена с ошибкой " + $(count).text());
         }
         alert('Request Status: ' + xhr.status + ' Status Text: ' + xhr.statusText + ' ' + xhr.responseText);
         }*/
    });
}
