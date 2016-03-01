ymaps.ready(init);

function init() {
    // Данные о местоположении, определённом по IP
    var geolocation = ymaps.geolocation,
    // координаты
        coords = [geolocation.latitude, geolocation.longitude],
        myMap = new ymaps.Map('map', {
            center: coords,
            zoom: 10
        });

    myMap.geoObjects.add(
        new ymaps.Placemark(
            coords,
            {
                // В балуне: страна, город, регион.
                balloonContentHeader: geolocation.country,
                balloonContent: geolocation.city,
                balloonContentFooter: geolocation.region
            }
        )
    );

    recommendRegion();

}

function recommendRegion() {
    var $regionSelect = $('#regionSelect');
    var region = ymaps.geolocation.region;
    var collectionOptions = $('option', $regionSelect);
    for (var i = 0; i < collectionOptions.length; i++) {
        if (collectionOptions.get(i).label == region) {
            $regionSelect.val(collectionOptions.get(i).value);
            break;
        }
    }
}
