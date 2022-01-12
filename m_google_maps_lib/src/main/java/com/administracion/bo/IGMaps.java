package com.administracion.bo;

import com.google.code.geocoder.model.LatLng;
import com.innovargia.salesmanager.dtos.RemDes;

public interface IGMaps {

    /***
     * Devuelve los datos de longitud y latitud de una direccion en 
     * Reverse Geocoding
     * @param direccion
     * @return
     */
    public abstract LatLng getLocation(RemDes direccion);

    /***
     * Devuelve los datos de longitud y latitud de una direccion en 
     * Reverse Geocoding
     * @param direccion
     * @return
     */
    public abstract LatLng getLocation(String direccion);

}