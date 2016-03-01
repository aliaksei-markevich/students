$(document).ready(function () {

    var errorRegion = 'Регион не выбран';


    function setCookie(name, value, countDay) {
        if (countDay) {
            var date = new Date;
            date.setDate(date.getDate() + countDay);
            var expires = '; expires=' + date.toUTCString();
        } else {
            expires = "";
        }
        document.cookie = name + 'Region=' + value + expires;
        location.reload()
    }

    $('#addRegionToCookies').click(function () {
        var regionSelectValue = $(this).prev().val();
        if (regionSelectValue == "") {
            alert(errorRegion);
        } else {
            setCookie($(this).data('user'), regionSelectValue, 1);
        }
    });

    $('#deleteRegionToCookies').click(function () {
            setCookie($(this).data('user'), "", -1);
        }
    );


});

