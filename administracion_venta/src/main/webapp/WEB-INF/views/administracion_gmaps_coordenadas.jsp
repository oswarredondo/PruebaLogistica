 <% 
	boolean isAdministracion = request.getParameter("isadministracion")==null?false:Boolean.parseBoolean(request.getParameter("isadministracion"));
	String longitud = request.getParameter("longitud")==null?"":request.getParameter("longitud");
	String latitud = request.getParameter("latitud")==null?"":request.getParameter("latitud");
	String colonia = request.getParameter("colonia")==null?"":request.getParameter("colonia").trim().toUpperCase();
	String calle = request.getParameter("calle")==null?"":request.getParameter("calle").trim().toUpperCase();
	String municipio = request.getParameter("municipio")==null?"":request.getParameter("municipio").trim().toUpperCase();
	String pais = request.getParameter("pais")==null?"":request.getParameter("pais").trim().toUpperCase();
	String estado = request.getParameter("estado")==null?"":request.getParameter("estado").trim().toUpperCase();
	String cp = request.getParameter("cp")==null?"":request.getParameter("cp").trim().toUpperCase();
	String nombre = request.getParameter("nombre")==null?"":request.getParameter("nombre").trim().toUpperCase();
	String telefono = request.getParameter("telefono")==null?"":request.getParameter("telefono");
	String idoficina = request.getParameter("idoficina")==null?"":request.getParameter("idoficina");
	
	String direccion = calle +", " + colonia +"," +municipio+"," +cp +"," + pais ;
%> 


<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
      html { height: 100% }
      body { height: 100%; margin: 0; padding: 0 }
      #mapa_div { height: 100% }
    </style>
<script src="http://maps.googleapis.com/maps/api/js?key=AIzaSyAB0T8tEHohBEDNgZ12pYMBBcfkA7PyUfM&sensor=true"></script>
    <script type="text/javascript">
    var geocoder;
    var map;
    var infowindow = new google.maps.InfoWindow();
    var marker;
 
      function funcionClick() {
        if (marker.getAnimation() != null) {
          marker.setAnimation(null);
        } else {
          marker.setAnimation(google.maps.Animation.BOUNCE);
        }
      }
 
      function inicializar_mapa() {
    	  geocoder = new google.maps.Geocoder();
    	  
        var mapOptions = {
          center: new google.maps.LatLng(<%=latitud%>, <%=longitud%>),
          zoom: 17,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("mapa_div"),
            mapOptions);
        var pos = new google.maps.LatLng(<%=latitud%>, <%=longitud%>);
        //var latlng = new google.maps.LatLng(lat, lng);
        
        geocoder.geocode({'latLng': pos}, function(results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
              if (results[1]) {
                map.setZoom(17);
                marker = new google.maps.Marker({
                    position: pos,
                    map: map,
                    animation: google.maps.Animation.DROP
                });
                /*
                A continuación se indica la lista completa de las direcciones que ha devuelto la consulta anterior.
				results[0].formatted_address: "275-291 Bedford Ave, Brooklyn, NY 11211, USA",
				results[1].formatted_address: "Williamsburg, NY, USA",
				results[2].formatted_address: "New York 11211, USA",
				results[3].formatted_address: "Kings, New York, USA",
				results[4].formatted_address: "Brooklyn, New York, USA",
				results[5].formatted_address: "New York, New York, USA",
				results[6].formatted_address: "New York, USA",
				results[7].formatted_address: "United States"
                */
                infowindow.setContent(results[0].formatted_address+ '  [' + <%=latitud%> +',' +<%=longitud%> + ']');
                infowindow.open(map, marker);
              } else {
                alert('No results found');
              }
            } else {
              alert('Geocoder failed due to: ' + status);
            }
          });
 
       /*
 
        marker = new google.maps.Marker({
            position: pos,
            map: map,
            title:"Esto es un marcador",
            animation: google.maps.Animation.DROP
        }); */
 
       // marker.setIcon('https://dl.dropboxusercontent.com/u/20056281/Iconos/male-2.png');
        //google.maps.event.addListener(marker, 'click', funcionClick);
 
      }
    </script>
  </head>
  <body onload="inicializar_mapa()">
    <div id="mapa_div" style="width:100%; height:100%"></div>
  </body>
</html>

