package com.innovargia.recolecciones.idao;

import java.sql.SQLException;
import java.util.List;

import com.administracion.dto.DiasSemanaMes;
import com.administracion.dto.SolicitudRecoleccion;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.dtos.Movimiento;
import com.servicio.dtos.Ruta;

public interface ISolicitudRecoleccionDAO {

    /**
     * Obtiene todas las solicitudes a las que se les deba realizar una orden de
     * recoleccion para posteriormente para cada una generar una Orden de
     * Recolección ya con su identificador correspondiente Este este utiulizado
     * por los procesos automaticos Recoleccion dependiendeo de la solicitud del
     * usuario
     * 
     * @param solicitud
     * @param isSolicitudRecoleccion
     * @return
     * @throws SQLException
     */
    public abstract List<SolicitudRecoleccion> obtieneOrdenesRecoleccionARealizar()
	    throws SQLException;

    /**
     * Obtiene todos los registros de rerecoleccion que tenga la ruta indicada y
     * la fecha de recolección sea la indica para poder agregarlos en la tabla
     * de manifiesto con el numero indicado
     * 
     * @param solicitud
     * @return
     * @throws SQLException
     */
    public abstract void agregaRecoleccionAManifesto(
	    SolicitudRecoleccion solicitud) throws SQLException;

    /**
     * Obtiene todas las rutas existentes para una plaza de acuerdo a las
     * ordenes de recoleccion generadas para un dia en particular y por la
     * organizacion y entidad de un usuario
     * 
     * @param solicitud
     * @return
     * @throws SQLException
     */
    public abstract List<SolicitudRecoleccion> getRutasOrdenesRecoleccion(
	    UsuarioDTO usuario) throws SQLException;

    /**
     * Obtiene todas las rutas que tienen una recoleccion en el dia actual, si
     * isShowAll= true muestra todas las rutas existentes isShowAll=false
     * muestra solo las rutas que tienen ordenes de recoleccion pendientes de
     * manifestar
     * 
     * @param solicitud
     * @param isSolicitudRecoleccion
     * @return
     * @throws SQLException
     */
    public abstract List<Ruta> getRutasConOrdenesRecoleccion(
	    UsuarioDTO usuario, boolean isShowAll) throws SQLException;

    /**
     * obtiene todas las plazas de una organizacion
     * 
     * @param usuario
     * @return
     * @throws SQLException
     */
    public abstract List<String> getPlazasOrganizacion(UsuarioDTO usuario)
	    throws SQLException;

    /**
     * Obtiene todas las ordenes de recolecciones de una ruta en el día actual,
     * devuelve un arreglo con todas las recolecciones creadas y que estan
     * activas o canceladas, que no han sido agregadas en un manifiesto
     * 
     * @param solicitud
     * @param isSolicitudRecoleccion
     * @return
     * @throws SQLException
     */
    public abstract List<SolicitudRecoleccion> getOrdenesRecoleccionRuta(
	    String ruta, UsuarioDTO usuario) throws SQLException;

    /**
     * Realiza la consulta para todas las solicitudes de recolecciones
     * 
     * @param idSolicitud
     * @return
     * @throws SQLException
     */
    public abstract List<SolicitudRecoleccion> getSolicitudesRecoleccion(
	    SolicitudRecoleccion solicitud) throws SQLException;

    /**
     * Realiza la consulta para todas las recolecciones
     * 
     * @param idSolicitud
     * @return
     * @throws SQLException
     */
    public abstract List<SolicitudRecoleccion> getRecoleccion(
	    SolicitudRecoleccion solicitud) throws SQLException;

    /**
     * 
     * @param solicitud
     * @param dias
     */
    public abstract void agregarSolicitudRecoleccion(
	    SolicitudRecoleccion solicitud, List<DiasSemanaMes> dias)
	    throws SQLException;

    /**
     * Actualiza los datos de una solicitud de recoleccion
     * 
     * @param solicitud
     * @param dias
     */
    public abstract void updateSolicitudRecoleccion(
	    SolicitudRecoleccion solicitud) throws SQLException;

    /**
     * Agrega uns Solicitud de Recoleccion ya sea semanal o mensual
     * 
     * @param solicitud
     * @param dias
     */
    public abstract int agregarSolicitudRecoleccion(
	    SolicitudRecoleccion solicitud) throws SQLException;

    /**
     * Actualiza recoleccion que se va a realizar en un fecha determinada
     * 
     * @param solicitud
     * @param dias
     */
    public abstract void updateRecoleccion(SolicitudRecoleccion solicitud)
	    throws SQLException;

    /**
     * Agrega una recoleccion que se va a realizar en un fecha determinada
     * 
     * @param solicitud
     * @param dias
     */
    public abstract int agregarRecoleccion(SolicitudRecoleccion solicitud)
	    throws SQLException;

    /**
     * Actualiza el estatus de la recoleccion que se esta realizando, solo
     * actualiza el estatus cuando el estatus actual no es L - LOCK - Bloqueado
     * en caso de que el usuario que solicita tiene un nivel de tipo A
     * (Administrador) podrá realizar esta actividad
     * 
     * @param solicitud
     * @param dias
     */
    // public void cambiarEstatusRecoleccion(SolicitudRecoleccion solicitud) {
    public abstract void cambiarEstatusRecoleccion(
	    SolicitudRecoleccion solicitud, UsuarioDTO usuario);

    /**
     * @param idSolicitud
     * @param dias
     */
    public abstract void agregarDiasSemanaSolicitudRecoleccion(
	    String idSolicitud, List<DiasSemanaMes> dias);

    /**
     * @param idSolicitud
     * @param dias
     */
    public abstract void agregarDiasMesSolicitudRecoleccion(String idSolicitud,
	    List<DiasSemanaMes> dias);

    /**
     * Agrega los dias de recoleccion de la semana
     * 
     * @param idSolicitud
     * @param dias
     */
    public abstract void modificarDiasSemanaSolicitudRecoleccion(
	    String idSolicitud, List<DiasSemanaMes> dias);

    /**
     * Agrega los dias de recoleccion del mes
     * 
     * @param idSolicitud
     * @param dias
     */
    public abstract void modificarDiasMesSolicitudRecoleccion(
	    String idSolicitud, List<DiasSemanaMes> dias);

    /**
     * Actualiza la ruta de la recoleccion solo cuando el estatus actual de la
     * orden es diferente de bloqueado 'L'. Si el usuario es de tipo
     * administrador entonces elimina esa restrinccion y permite realizar el
     * cambio
     * 
     * @param idSolicitud
     * @param ruta
     */
    public abstract void modificarRutaRecoleccion(String idrecoleccion,
	    String ruta, UsuarioDTO usuario);

    /**
     * Actualiza la fecha de la recoleccion
     * 
     * @param idSolicitud
     * @param fecha
     */
    public abstract void modificarFechaRecoleccion(String idrecoleccion,
	    String fecha, UsuarioDTO usuario);

    /**
     * Actualiza la ruta de una solicitud de recoleccion
     * 
     * @param idSolicitud
     * @param ruta
     */
    public abstract void modificarRutaSolicitudRecoleccion(String idSolicitud,
	    String ruta);

    /**
     * Cambia el estatus de una solicitud de una recoleccion
     * 
     * @param idSolicitud
     * 
     */
    public abstract void cambiarEstatusSolicitudRecoleccion(String idSolicitud,
	    String status);

    /**
     * Agrega la cancelacion de una de una solicitud de recoleccion
     * 
     * @param idSolicitud
     * 
     */
    public abstract void agregarCancelacionSolicitudRecoleccion(
	    SolicitudRecoleccion solicitud);

    /**
     * Agrega un movimiento a la historia de una recoleccion
     * 
     * @param idSolicitud
     * 
     */
    public abstract void agregarMovimientoSolicitudRecoleccion(
	    Movimiento movimiento);

    /***
     * Obtiene todas las recolecciones generadas en el dìa actual pero que no se
     * hayan generado anteriormente y no esten en ya generadas en rerecoleccion
     * 
     * @return
     */
    public abstract List<SolicitudRecoleccion> generaOrdenesDeRecoleccionDiaria();

    /**
     * Obtiene los datos de programacion semanal
     * 
     * @param solicitud
     * @return
     */
    public abstract List<DiasSemanaMes> getProgramacionSemanal(
	    SolicitudRecoleccion solicitud);

    /**
     * Obtiene los datos de programacion del mensual
     * 
     * @param solicitud
     * @return
     */
    public abstract List<DiasSemanaMes> getProgramacionMensual(
	    SolicitudRecoleccion solicitud);

    /**
     * Obtiene la historia de la recolecion
     * 
     * @param idrecoleccion
     * @return
     */
    public abstract List<Movimiento> getHistoriaRecoelccion(String idrecoleccion);

    public void insertDiasMesSolicitudRecoleccion(DiasSemanaMes diasSemanaMes);

    public void insertDiasSemanaSolicitudRecoleccion(DiasSemanaMes diasSemanaMes);

    public void updateDiasMesSolicitudRecoleccion(DiasSemanaMes diasSemanaMes);

    public void updateDiasSemanaSolicitudRecoleccion(DiasSemanaMes diasSemanaMes);

    public void deleteDiasMesSolicitudRecoleccion(DiasSemanaMes diasSemanaMes);

    public void deleteDiasSemanaSolicitudRecoleccion(DiasSemanaMes diasSemanaMes);

    public List<Ruta> obtienePlazaTotal(String plaza, String fecha)
	    throws SQLException;

    public List<Ruta> obtienePlazaRutasTotal(String plaza, String fecha)
	    throws SQLException;
    
    public SolicitudRecoleccion  getSolicitudRecoleccionById(int idregistro,
		boolean isSolicitudRecoleccion) throws SQLException;
    
    public List<SolicitudRecoleccion>  
    getOrdenesRecoleccionRuta(String ruta,String plaza, String fecha) throws SQLException ;

}