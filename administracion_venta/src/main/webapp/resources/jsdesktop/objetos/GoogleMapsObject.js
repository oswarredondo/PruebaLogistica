Ext.define('MyDesktop.objetos.GoogleMapsObject', {
	 requires: [
	            'Ext.ux.GMapPanel'
	        ],
	        
	location:undefined,
	geocoder:undefined,
    map:undefined,
    
    longitud:undefined,
	latitud:undefined,
	colonia:undefined,
	calle:undefined,
	municipio:undefined,
	pais:undefined,
	estado:undefined,
	cp:undefined,
	nombre:undefined,
	telefono:undefined,
	nombre:undefined,
	idoficina:undefined,
	field_longitud:undefined,
	field_latitud:undefined, 
    listeners: {
        change: function (obj, newValue) {
           // console.log(newValue);
           // obj.setRawValue(newValue.toUpperCase());
        }
     },
	getLocation:function(){
		
	},
	
	lat:undefined,
	long:undefined,
	initComponent:function() {
        this.geocoder = new google.maps.Geocoder();
      /*  var latlng = new google.maps.LatLng(-34.397, 150.644);
        var mapOptions = {
          zoom: 15,
          center: latlng,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        }
		//Inicializa el espacio donde va a dejar la informacion
        this.map = new google.maps.Map(document.getElementById('map_latlog'), mapOptions);
		/*
		 var marker = new google.maps.Marker({
            position: latlng,
            map: this.map,
           title: "GoogleMaps"
        });*/
		 
		
		 /*google.maps.event.addListener(marker, 'click', function(event) {
			infowindow.open(map,marker);
        });*/

    },
    /**
     * codeAddress('<%=calle%>,<%=colonia%>,<%=municipio%> <%=cp%>, <%=pais%>')
     */
    getLatitud:function(){
    	return this.latitud;
    },
    getLongitud:function(){
    	return this.longtitud;
    },
    getAltitud:function(){
    	
    },
    /**
     * codeAddress('<%=calle%>,<%=colonia%>,<%=municipio%> <%=cp%>, <%=pais%>')
     */
    codeAddress: function (address, fn ) {
    	 var myscope=this;
        /*this.geocoder.geocode( { 'address': address}, function(results, status) {
	          if (status == google.maps.GeocoderStatus.OK) {
	           // this.map.setCenter(results[0].geometry.location);
	            this.location = results[0].geometry.location;

	           // var marker = new google.maps.Marker({
	           //     map: this.map,
	            //    position: results[0].geometry.location
	           // })
	            //Obtiene la longitud y latitud
	      		 if (myscope.field_longitud!=undefined){
	      			  myscope.field_longitud.setValue(results[0].geometry.location.lng());
	      			  alert(myscope.field_longitud.getValue());
	  	            }
	  	            if (myscope.field_latitud!=undefined){
	  	            	myscope.field_latitud.setValue(results[0].geometry.location.lat());
	  	              alert(myscope.field_latitud.getValue());
	  	            }
	  	          
	          } else {
	            alert('Geocode was not successful for the following reason: ' + status);
	          }
        });*/
      },
      getCoordenadas: function (callenumero,colonia,municipio, cp, estado, pais,
    		  longitud , latitud) {
    	  var myscope=this;
    	  var direccion = callenumero +', ' + colonia +',' +municipio+',' +cp +',' + pais ;
    	 
    	  var geocoder = new google.maps.Geocoder();

    	  geocoder.geocode( { 'address': direccion}, function(results, status) {

    	    if (status == google.maps.GeocoderStatus.OK) {
    	    	this.lat = results[0].geometry.location.lat();
    	    	this.long = results[0].geometry.location.lat();
	  	          
    	    	 if (longitud!=undefined){
    	    		 longitud.setValue(results[0].geometry.location.lng());
	      			
	  	            }
	  	            if (latitud!=undefined){
	  	            	latitud.setValue(results[0].geometry.location.lat());
	  	             
	  	            }
    	    } else {
    	    	mensajeAlert("Error al obtener los datos: " + status);
    	    }
    	  });
    	  
    	  this.codeAddress(direccion);
      },
      
      showMapConDireccion:function (callenumero,colonia,municipio, cp, estado, pais,
    		  longitud_ , latitud_){
    	  var direccion = callenumero +', ' + colonia +',' +municipio+',' +cp +',' + pais ;
    	  
    	  var mapwin = Ext.create('Ext.window.Window', {
              autoShow: true,
              layout: 'fit',
              title: 'Dirección:' +direccion,
              width:650,
              height:600,
              border: false,
              items: {
                  xtype: 'gmappanel',
                  center: {
                      geoCodeAddr: direccion,
                      marker: {title: direccion}
                  }
              }
          });
    	  
    	  
    	 
    	 
      
      },
      showMapConLatitudLongitud:function (longitud_ , latitud_){
    	  var latlog_ = "longitud: " + longitud_ +",latitud:" + latitud_;
    	  var infowindow = new google.maps.InfoWindow({
    		  content:"Hello World!"
    		  });
    	  var mapwin = Ext.create('Ext.Window', {
              layout: 'fit',
              title: 'GMap Window:' +latlog_,
             
              width: 650,
			   height:450,
			   minimizable: false,
			   maximizable: false,
			   closable:true,
            
              border: false,
              x: 80,
              y: 80,
              items: {
                  xtype: 'gmappanel',
                  //id: 'mymap',
                  zoomLevel: 14,
                  gmapType: 'map',
                  mapConfOpts: ['enableScrollWheelZoom','enableDoubleClickZoom','enableDragging'],
                  mapControls: ['GSmallMapControl','GMapTypeControl'],
                  setCenter: {
                	  lat: latitud_,
                      lng: longitud_,
                      marker: {
                    	  title: latlog_,
                    	  clickable:true,
                    	  infoWindow:infowindow
                      }
                  },
                  maplisteners: {
                	 move :function(o,e){
                		 alert(this);
                        
                     },
                  	click: function(mevt){
                  		Ext.Msg.alert('Lat/Lng of Click', mevt.latLng.lat() + ' / ' + mevt.latLng.lng());
                  		var input = Ext.get('ac').dom,
				    			sw = new google.maps.LatLng(39.26940,-76.64323),
				    			ne = new google.maps.LatLng(39.38904,-76.54848),
				    			bounds = new google.maps.LatLngBounds(sw,ne);
				    		var options = {
				    			location: mevt.latLng,
				    			radius: '1000',
								types: ['geocode']
							};
                  	}
                  }
              }
          });
    	  
    	  /*var mapwin = Ext.create('Ext.Window', {
              layout: 'fit',
              title: 'GMap Window:' +latlog_,
              width:450,
              height:450,
              border: false,
              items: {
                  xtype: 'gmappanel',
                  id: 'mymap',
                  zoomLevel: 14,
                  gmapType: 'map',
                  mapConfOpts: ['enableScrollWheelZoom','enableDoubleClickZoom','enableDragging'],
                  mapControls: ['GSmallMapControl','GMapTypeControl'],
                  setCenter: {
                      lat: latitud_,
                      lng: longitud_,
                      marker: {title: latlog_}
                  },
                  maplisteners: {
                  	click: function(mevt){
                  		Ext.Msg.alert('Lat/Lng of Click', mevt.latLng.lat() + ' / ' + mevt.latLng.lng());
                  		var input = Ext.get('ac').dom,
				    			sw = new google.maps.LatLng(latitud_,longitud_),
				    			ne = new google.maps.LatLng(39.38904,-76.54848),
				    			bounds = new google.maps.LatLngBounds(sw,ne);
				    		var options = {
				    			location: mevt.latLng,
				    			radius: '1000',
								types: ['geocode']
							};
                  	}
                  }
              }
          });*/
    	  
    	  mapwin.show();
      },
     
      getInfoAddress: function (marker,direccion){

			var html = '<div class="iwgeoad"><table><tbody>'+
	          	  '<tr><td><div class="head"><div class="title">'+nombre+'</div></div>'+
			   '<div class="head"><div class="title">Dir:'+direccion + '</div></div>'+
			  '</td></tr></tbody></table></div>';

	          	

    	  return html;
		}
	
	
});