$(document).ready(function() {

    $('#queryList').autocomplete({
        source: function(request, response){
            $.ajax({
                type: 'POST',
                url: '/search/client',
                data:{
                    maxRows: 12,
                    nameStartsWithClient: request.term // поисковая фраза
                },
                success: function(data){
                    response($.map(data, function(item){
                        return {
                            label: item.lastName,
                            val: item.idClient
                        }
                    }));
                }
            });
        },
        select: function (event, ui) {
            $('#queryList').val(ui.item.label);
            $('#indexList').val(ui.item.val);
            return false;
        },
        minLength: 1
    });

    $('#queryTree').autocomplete({
        source: function(request, response){
            $.ajax({
                type: 'POST',
                url: '/search/tree',
                data:{
                    maxRows: 12,
                    nameStartsWithTree: request.term
                },
                success: function(data){
                    response($.map(data, function(item){
                        return {
                            label: item.text,
                            val: item.id
                        }
                    }));
                }
            });
        },
        select: function (event, ui) {
            $('#queryTree').val(ui.item.label);
            $('#indexTree').val(ui.item.val);
            return false;
        },
        minLength: 1
    });

});
