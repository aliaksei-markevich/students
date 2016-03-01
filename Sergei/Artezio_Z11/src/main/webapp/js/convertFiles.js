;
function convertFiles() {
    var input = $(this).parent().find("input[type='file']");
    var fd = new FormData();
    fd.append('file', input.prop('files')[0]);
    $.ajax({
        type: 'POST',
        url: '/convert',
        data: fd,
        processData: false,
        contentType: false,
        dataType: 'text',
        success: function (path) {
            var indexOf = path.lastIndexOf('/') + 1;
            $("<a/>", {
                text: path.substr(indexOf, path.length - indexOf),
                href: path,
            }).appendTo('div');
            alert("Файл создан");
        },
        error: function () {
            alert("Все плохо");
        }
    });
}
