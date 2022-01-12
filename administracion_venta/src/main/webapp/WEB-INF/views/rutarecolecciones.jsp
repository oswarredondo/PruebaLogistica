


<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true&libraries=places"></script>
<style type="text/css">
#map_cover {
    height: 723px;
	clear:left;
	
}
#show_map_div {
    width: 100%;
    height: 100%;
}

#map-canvas {
	margin: 0;
	padding: 0;
	height: 400px;
	max-width: none;
}
#map-canvas img {
	max-width: none !important;
}
.gm-style-iw {
	width: 350px !important;
	top: 15px !important;
	left: 0px !important;
	background-color: #fff;
	box-shadow: 0 1px 6px rgba(178, 178, 178, 0.6);
	border: 1px solid rgba(72, 181, 233, 0.6);
	border-radius: 2px 2px 10px 10px;
}
#iw-container {
	margin-bottom: 10px;
}
#iw-container .iw-title {
	font-family: 'Open Sans Condensed', sans-serif;
	font-size: 22px;
	font-weight: 400;
	padding: 10px;
	background-color: #48b5e9;
	color: white;
	margin: 0;
	border-radius: 2px 2px 0 0;
}
#iw-container .iw-title-red {
	font-family: 'Open Sans Condensed', sans-serif;
	font-size: 22px;
	font-weight: 400;
	padding: 10px;
	background-color: #FFCA3333;
	color: white;
	margin: 0;
	border-radius: 2px 2px 0 0;
}

#iw-container .iw-title-yellow {
	font-family: 'Open Sans Condensed', sans-serif;
	font-size: 22px;
	font-weight: 400;
	padding: 10px;
	background-color: #FF946F00;
	color: white;
	margin: 0;
	border-radius: 2px 2px 0 0;
}
#iw-container .iw-title-blue{
	font-family: 'Open Sans Condensed', sans-serif;
	font-size: 22px;
	font-weight: 400;
	padding: 10px;
	background-color: #48b5e9;
	color: white;
	margin: 0;
	border-radius: 2px 2px 0 0;
}
#iw-container .iw-title-green{
	font-family: 'Open Sans Condensed', sans-serif;
	font-size: 22px;
	font-weight: 400;
	padding: 10px;
	background-color: #FF33CA44;
	color: white;
	margin: 0;
	border-radius: 2px 2px 0 0;
}
#iw-container .iw-content {
	font-size: 13px;
	line-height: 18px;
	font-weight: 400;
	margin-right: 1px;
	padding: 15px 5px 20px 15px;
	max-height: 140px;
	overflow-y: auto;
	overflow-x: hidden;
}
.iw-content img {
	float: right;
	margin: 0 5px 5px 10px;	
}
.iw-subTitle {
	font-size: 16px;
	font-weight: 700;
	padding: 5px 0;
}
.iw-bottom-gradient {
	position: absolute;
	width: 326px;
	height: 25px;
	bottom: 10px;
	right: 18px;
	background: linear-gradient(to bottom, rgba(255,255,255,0) 0%, rgba(255,255,255,1) 100%);
	background: -webkit-linear-gradient(top, rgba(255,255,255,0) 0%, rgba(255,255,255,1) 100%);
	background: -moz-linear-gradient(top, rgba(255,255,255,0) 0%, rgba(255,255,255,1) 100%);
	background: -ms-linear-gradient(top, rgba(255,255,255,0) 0%, rgba(255,255,255,1) 100%);
}
</style>
<script type="text/javascript">
function initialized() {
    var map;
    var bounds = new google.maps.LatLngBounds();
    var mapOptions = {
        mapTypeId: 'roadmap'
    };
                    
    // Display a map on the page with div id show_map_div
    map = new google.maps.Map(document.getElementById("show_map_div"), mapOptions);
    map.setTilt(45);
        
    // Multiple Markers - name,lat,long values
    var markers = [
					${markers}
				  ];
      //alert(markers);                  
    // Information Window To show content on markers
	var markers_info_content = [
				${markers_titles}
          ];
        
    // Display multiple markers on a map
    var infoWindow = new google.maps.InfoWindow(), marker, i;
    
	var pinColor = "18cecf"; //color of the markers
    var pinImage = new google.maps.MarkerImage("http://chart.apis.google.com/chart?chst=d_map_pin_letter&chld=%E2%80%A2|" + pinColor,
        new google.maps.Size(21, 34),
        new google.maps.Point(0,0),
        new google.maps.Point(10, 34));
	
    var iconBase = "../resources/images/" ;
    for( i = 0; i < markers.length; i++ ) {
		
        var position = new google.maps.LatLng(markers[i][1], markers[i][2]);
        bounds.extend(position);
		marker = new google.maps.Marker({
            			position: position,
            			map: map,
            			title: markers[i][0],
						icon: iconBase +  markers[i][3] + ".png"
       	});
		 
		
        // Allow each marker to have an information content box
        google.maps.event.addListener(marker, 'click', (function(marker, i) {
            return function() {
                infoWindow.setContent(markers_info_content[i][0]);
                infoWindow.open(map, marker);
            }
        })(marker, i));

        // Automatically center the map fitting all markers on the screen
        map.fitBounds(bounds);
    }

    // Set the zoom level as per your requirement currently it is 12
    var boundsListener = google.maps.event.addListener((map), 'bounds_changed', function(event) {
        this.setZoom(12);
        google.maps.event.removeListener(boundsListener);
    });
    
}

</script>
<div id="map_cover">
    <div id="show_map_div" class="mapping"></div>
</div>
<body onLoad="initialized()">