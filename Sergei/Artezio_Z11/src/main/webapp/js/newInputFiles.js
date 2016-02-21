;function addInputFile() {
    var $container = $("div#template", 'form').first().clone();
    $container.css("marginTop","10px");
    $container.attr('id','');
    $container.find("input[type='button']").click(uploadFiles);
    $container.appendTo('form');
    $container.show();
}