function deleteFile() {
    var nameFile = $(this).parent().find('a').text();
    var parentDiv = $(this).parent();
    $.ajax({
        type: 'GET',
        data: {'nameFile': nameFile},
        contentType: "application/json; charset=utf-8",
        dataType: 'JSON',
        success: function () {
            parentDiv.hide();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("Произошла ошибка");
        }
    });
}

$(document).ready(function () {
    $('input').click(deleteFile);
});

