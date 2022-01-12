/**
 * 
 */
package com.administracion.bo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.GeocoderStatus;
import com.google.code.geocoder.model.LatLng;
import com.innovargia.salesmanager.dtos.RemDes;


/**
* Obtiene los datos de Longitud y Latitud de una direccion 
 * @author Adrian Morales Ruaro
 * 
 */
@Service 
public class GMaps implements IGMaps {

	private static final Logger logger = LoggerFactory
			.getLogger(GMaps.class);
	/**
	 * 
	 */
	public GMaps() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.administracion.bo.IGMaps#getLocation(com.innovargia.salesmanager.dtos.RemDes)
	 */
	@Override
	public LatLng getLocation(RemDes direccion){
		return setAddress( direccion.getDireccion()+ ", "+  direccion.getColonia() + ", " + direccion.getCp() + ", " + direccion.getEstado() );
	}
	/* (non-Javadoc)
	 * @see com.administracion.bo.IGMaps#getLocation(java.lang.String)
	 */
	@Override
	public LatLng getLocation(String direccion){
		return setAddress( direccion );
	}
	private LatLng setAddress(String adress){
	   
	
		//Calle, Colonia, CP Estado
		//Ejemplo:
		//"Antonio J Tirado, Ejercito de Oriente,09230 Mexico"
		try{
		    	Geocoder geocoder = new Geocoder();    
		    	//Ver codigo de lenguajes en 
		    	//https://spreadsheets.google.com/a/estafeta.com/pub?key=p9pdwsai2hDMsLkXsoM05KQ&gid=1
			GeocoderRequest geocoderRequest = 
				new GeocoderRequestBuilder().setAddress(adress).setLanguage("es").getGeocoderRequest();
			GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
			
			 if (geocoderResponse.getStatus() == GeocoderStatus.OK
				      & !geocoderResponse.getResults().isEmpty()) {
				      GeocoderResult geocoderResult =  
				        geocoderResponse.getResults().iterator().next();
				      LatLng latitudeLongitude =
				        geocoderResult.getGeometry().getLocation();
				      Float[] coords = new Float[2];
				      coords[0] = latitudeLongitude.getLat().floatValue();
				      coords[1] = latitudeLongitude.getLng().floatValue();
				      return latitudeLongitude;
				    }
		}catch(Exception e){
			logger.error("Error al obtener coordenadas " + e.getMessage());
		}
		
		
		return null;
	}
	
	
}
