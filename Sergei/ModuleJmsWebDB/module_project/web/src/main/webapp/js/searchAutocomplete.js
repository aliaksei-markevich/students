$(document).ready(function () {

    $('.autocomplete').each(function () {
        var urlQuery = $(this).data("url");
        $(this).autocomplete({
            source: function (request, response) {
                $.ajax({
                    type: 'POST',
                    url: urlQuery,
                    data: {
                        maxRows: 12,
                        textStartsWith: request.term
                    },
                    success: function (data) {
                       // console.log(data.length);
                        response($.map(data, function (item) {
                            return {
                                label: item.key,
                                val: item.value
                            }
                        }));
                    },
                    error: function(){
                        alert("error handler!");
                    }
                });
            },
            select: function (event, ui) {
                $(this).parent().find('input[type="text"]').val(ui.item.label);
                $(this).parent().find('input[type="hidden"]').val(ui.item.val);
                return false;
            },
            minLength: 1
        });
    })
});
