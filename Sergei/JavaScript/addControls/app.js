$(document).ready(function () {
    var divId = 1;

    $('#typeControls', 'div#firstPart').change(function () {
        if ($('#typeControls option:selected', 'div#firstPart').val() == 'email') {
            $('.count').css('visibility', 'visible');
        } else {
            $('.count').css('visibility', 'hidden');
        }
        $('.mask').css('visibility', 'visible');
        $('#addControl').css('visibility', 'visible');
        $('#count', 'div#firstPart').val('');
        $('#mask', 'div#firstPart').val('');
    });

    $('#addControl').click(function () {

        var $typeControls = $('#typeControls');
        var label = $typeControls.find('option:selected').text();
        var value = $typeControls.find('option:selected').val();
        var mask = $("#mask").val();

        if (value == 'email') {
            var countParts = $('#count', 'div#firstPart').val();
            var partsMask = mask.split(/\.|@/);
            var countPartsMask = partsMask.length;

            //если вдруг начинается с . или @ ))
            for (var j = 0; j < partsMask.length; j++) {
                if (partsMask[j] == '') countPartsMask--;
            }
            if (countParts != countPartsMask) {
                alert('Не совпадает число частей, укажите их правильно');
                return;
            }
        }

        $('<div/>').attr({id: 'Control' + divId}).appendTo('#secondPart').html(label);
        $('<label/>').attr({for: 'controlStr'}).appendTo('#Control' + divId);
        $('<input/>').attr({
            type: 'text',
            id: 'controlStr',
            name: 'test',
            placeholder: mask
        }).data('mask', mask).
        data('typeElement', value).appendTo('#Control' + divId);
        $('<input/>').attr({type: 'button', id: 'buttonControl', value: "OK"}).appendTo('#Control' + divId);
        $('<span/>').attr({id: 'viewTextControl', value: mask, title: mask}).appendTo('#Control' + divId).html(mask);
        $('<input/>').attr({type: 'button', id: 'deleteControl', value: "Delete"}).appendTo('#Control' + divId);
        $('#controlStr', 'div#Control' + divId).on('input', changeStrNumber);
        $('#deleteControl', 'div#Control' + divId).click(deleteControl);
        $('#buttonControl', 'div#Control' + divId).click(checkControl);
        divId++;
    });

    function changeStrNumber() {
        var mask = $(this).data("mask");
        var inputStr = $(this).val();
        var result = '';
        var count = 0;
        var oldResultStr = $(this).parent().find('#viewTextControl').text();
        if (inputStr == '') {
            $(this).parent().find('#viewTextControl').text(mask);
            return;
        }

        //Только числа
        if ($(this).data('typeElement') != 'email') {
            if (inputStr.charAt(0) == ' ') {
                $(this).val($(this).val().slice(0, -1));
                console.log('Начните ввод с цифры');
                return;
            }
            if (isNaN(inputStr[inputStr.length - 1])) {
                $(this).val($(this).val().slice(0, -1));
                console.log('Это не число');
                return;
            }
        }

        for (var j = 0; j < inputStr.length + 1; j++) {
            for (var i = j + count; i < mask.length; i++) {

                if (mask.charAt(i) == '_' && inputStr.charAt(j) == ' ') {
                    $(this).val($(this).val().slice(0, -1));
                    console.log('Пробел только вместо спец символах');
                    return;
                }
                else if (mask.charAt(i) == '_' && inputStr.charAt(j) != ' ' && inputStr.charAt(j) != '') {
                    result += inputStr.charAt(j);
                    break;
                }
                else if (mask.charAt(i) != '_' && inputStr.charAt(j) == ' ') {
                    result += mask.charAt(i);
                    break;
                }
                else {
                    result += mask.charAt(i);
                    count++;
                }
            }

        }

        if ((oldResultStr == result || inputStr.length > mask.length)
            && inputStr.charAt(inputStr.length - 1) != ' '
            && result.indexOf('_') < 0) {
            $(this).val($(this).val().slice(0, -1));
            console.log('Слишком много символов');
        }

        $(this).parent().find('#viewTextControl').text(result);
    }

    function deleteControl() {
        $(this).parent().remove();
    }

    function checkControl() {
        var checkStr = $(this).parent().find('#viewTextControl').text();
        return checkStr.indexOf('_') < 0 ? alert('Все нормально') : alert('Надо еще ввести символы');
    }
});