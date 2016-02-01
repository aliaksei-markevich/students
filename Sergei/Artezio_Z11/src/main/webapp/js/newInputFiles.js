;var i = 2;
var afterElement;
function addInputFile() {
    //  document.getElementById('form_inner').innerHTML = document.getElementById('form_inner').innerHTML +
    //      "<br><input type='file' id='uploadFile" + i + "' size='50'/><input id='uploadButton"+i+"' type='button' onclick='uploadFiles("+i+")' value='Загрузить'/><br>";
    if ($("span").is("#span" + (i - 1))) {
        afterElement = "#span" + (i - 1);
    }
    else {
        afterElement = "#uploadButton" + (i - 1);
    }
    if (i == 2 && afterElement == "#uploadButton1") {
        $("<br><br><input type='file' id='uploadFile" + i + "' size='50'/><input id='uploadButton" + i +
            "' type='button' onclick='uploadFiles(" + i + ")' value='Загрузить'/><br>").insertAfter("#addInput");
    }
    else {
        $("<br><br><input type='file' id='uploadFile" + i + "' size='50'/><input id='uploadButton" + i +
            "' type='button' onclick='uploadFiles(" + i + ")' value='Загрузить'/><br>").insertAfter(afterElement);
    }
    i++;
    if (i > 5) $("#addInput").hide();
}