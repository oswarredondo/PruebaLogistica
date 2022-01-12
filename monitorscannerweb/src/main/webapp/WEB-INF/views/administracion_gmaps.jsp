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
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<script type="text/javascript" src="http://maps.google.com/maps/api/js?key=AIzaSyAB0T8tEHohBEDNgZ12pYMBBcfkA7PyUfM&sensor=false"></script>
<script type="text/javascript">
var geocoder;
var map;
var marker;
var dir ='<%=direccion%>';

  geocoder = new google.maps.Geocoder();
  
  //var address = document.getElementById('city_country').value;
  geocoder.geocode( { 'address': '<%=direccion%>'}, function(results, status) {
    if (status == google.maps.GeocoderStatus.OK) {
      map = new google.maps.Map(document.getElementById('mapCanvas'), {
    		zoom: 16,
            streetViewControl: true,
          mapTypeControlOptions: {
        style: google.maps.MapTypeControlStyle.HORIZONTAL_BAR,
              mapTypeIds:[google.maps.MapTypeId.HYBRID, google.maps.MapTypeId.ROADMAP] 
    },
    center: results[0].geometry.location,
    mapTypeId: google.maps.MapTypeId.ROADMAP
  });
      map.setCenter(results[0].geometry.location);
      marker = new google.maps.Marker({
          map: map,
          position: results[0].geometry.location,
          draggable: true,
          title: ""+results[0].geometry.location
      });
      updateMarkerPosition(results[0].geometry.location);
      geocodePosition(results[0].geometry.location);
        
      // Add dragging event listeners.
  google.maps.event.addListener(marker, 'dragstart', function() {
    updateMarkerAddress('Dragging...');
  });
      
  google.maps.event.addListener(marker, 'drag', function() {
    updateMarkerStatus('Dragging...');
    marker.setTitle(marker.getPosition() +"");
    updateMarkerPosition(marker.getPosition());
  });
  
  google.maps.event.addListener(marker, 'dragend', function() {
    updateMarkerStatus('Drag ended');
    geocodePosition(marker.getPosition());
   

   
      map.panTo(marker.getPosition()); 
      marker.setTitle(  dir + ','+marker.getPosition());
  });
  
  google.maps.event.addListener(map, 'click', function(e) {
    updateMarkerPosition(e.latLng);
    geocodePosition(marker.getPosition());
    marker.setPosition(e.latLng);
   
  	map.panTo(marker.getPosition()); 
  }); 
  
    } else {
      alert('Geocode was not successful for the following reason: ' + status);
    }
  });

/***
 *  A continuación se indica la lista completa de las direcciones que ha devuelto la consulta anterior.
	results[0].formatted_address: "275-291 Bedford Ave, Brooklyn, NY 11211, USA",
	results[1].formatted_address: "Williamsburg, NY, USA",
	results[2].formatted_address: "New York 11211, USA",
	results[3].formatted_address: "Kings, New York, USA",
	results[4].formatted_address: "Brooklyn, New York, USA",
	results[5].formatted_address: "New York, New York, USA",
	results[6].formatted_address: "New York, USA",
	results[7].formatted_address: "United States"
    */

function geocodePosition(pos) {
  geocoder.geocode({
    latLng: pos
  }, function(responses) {
    if (responses && responses.length > 0) {
    	
      updateMarkerAddress(responses[0].formatted_address);
    } else {
    	
      updateMarkerAddress('No se puede determinar la direccion con la posicion indicada.');
    }
  });
}

function updateMarkerStatus(str) {
  //document.getElementById('markerStatus').innerHTML = str;
}

function updateMarkerPosition(latLng) {
  document.getElementById('info').innerHTML = [
    latLng.lat(),
    latLng.lng()
  ].join(', ');
}

function updateMarkerAddress(str) {
	
  document.getElementById('address').innerHTML = str;
  //dir =document.getElementById('address').innerHTML;
}
  
</script>
  <style>
  #mapCanvas {
    width: 800px;
    height: 490px;
    float: left;
  }
  #infoPanel {
    float: left;
    margin-left: 10px;
  }
  #infoPanel div {
    margin-bottom: 5px;
  }
    </style>
</head>
<body>
  <body>
  <div id="mapCanvas"></div>
  <div id="infoPanel">
  	<!--  
    <b>Marker status:</b>
    <div id="markerStatus"><i>Click and drag the marker.</i></div>
    -->
    <b>Geo Localizaci&oacute;n actual:</b>
    <div id="info"></div>
    <b>Direcci&oacute;n m&aacute;s cercano:</b>
    <div id="address"></div>
  </div>
</body>
</html>