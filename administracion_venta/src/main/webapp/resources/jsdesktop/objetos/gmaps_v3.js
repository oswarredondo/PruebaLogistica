/***
 * Obtiene la longitud y latitud de la direccion
 * 'calle,colonia,municipio cp, pais'
 * @param direccion
 */
function getLocation(address) {
    var geocoder = new google.maps.Geocoder();
   // var address = document.getElementById("txtAddress").value;
    geocoder.geocode({ 'address': address }, function (results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            var latitude = results[0].geometry.location.lat();
            var longitude = results[0].geometry.location.lng();
            return latitude+","+longitude;
        } else {
            alert("Request failed.");
            return "";
        }
    });
    
};
/***
 * Actualiza los datos de los campos de latitud y longitud
 * @param campo_latitud
 * @param campo_longitud
 * @param address
 */
function getLocation(campo_latitud, campo_longitud, address) {
    var geocoder = new google.maps.Geocoder();
   // var address = document.getElementById("txtAddress").value;
    geocoder.geocode({ 'address': address }, function (results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            var latitude = results[0].geometry.location.lat();
            var longitude = results[0].geometry.location.lng();
            
            campo_latitud.setValue(latitude);
            campo_latitud.setValue(campo_longitud);
            
        } 
    });
    
};