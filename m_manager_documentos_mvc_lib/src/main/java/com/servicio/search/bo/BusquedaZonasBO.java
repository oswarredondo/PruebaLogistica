/**
 * 
 */
package com.servicio.search.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.idao.ICPZonaDao;
import com.innovargia.documentos.dtos.Frecuencias;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.dtos.Zona;
import com.servicio.search.ibo.IBusquedaZonasBO;
import com.servicio.search.idao.IBusquedaFrecuenciasDao;
import com.servicio.search.idao.IBusquedaZonaDao;

/**
 * @author Adrian Morales Ruaro
 * 
 */
@Service
public class BusquedaZonasBO implements IBusquedaZonasBO {
	@Autowired
	IBusquedaZonaDao zonaDao;
	@Autowired
	ICPZonaDao icpZonaDao;
	@Autowired
	IBusquedaFrecuenciasDao frecuenciaDao;

	
	private static final Logger logger = LoggerFactory
			.getLogger(BusquedaZonasBO.class);
	
    /**
     * Manda un mensaje a la bitacora, como debug
     */
    private void debug(String mensaje){
    	logger.debug( mensaje);
    }//fin de debug
	
	/**
	 * 
	 */
	public BusquedaZonasBO() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.servicio.search.bo.IZonasBO#getListaZonas(java.lang.String, com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public ArrayList<Zona> getListaZonas(String idzona, UsuarioDTO usuario)
			throws SQLException {
		ArrayList<Zona> lista = new ArrayList<Zona>();
	

		return zonaDao.getListaZonas(idzona, usuario);
	}

	/* (non-Javadoc)
	 * @see com.servicio.search.bo.IZonasBO#getCruceZonas(java.lang.String, java.lang.String, com.innovargia.salesmanager.dtos.UsuarioDTO, java.lang.String)
	 */
	@Override
	public Zona getCruceZonas(String zonaori, String zonades, UsuarioDTO usuario,String idgarantia)
			throws SQLException {
		ArrayList<Zona> lista = new ArrayList<Zona>();

		return icpZonaDao.getCruceZona(zonaori, zonades, usuario,idgarantia);
	}

	/* (non-Javadoc)
	 * @see com.servicio.search.bo.IZonasBO#getCruceZonasPorCPs(java.lang.String, java.lang.String, com.innovargia.salesmanager.dtos.UsuarioDTO, java.lang.String)
	 */
	@Override
	public Zona getCruceZonasPorCPs(String cpori, String cpdes, UsuarioDTO usuario,String idgarantia)
			throws Exception {
		
				
		ArrayList<Zona> lista = new ArrayList<Zona>();
	
		
		Frecuencias origenFrecuencia  = frecuenciaDao.getFrecuenciaCP(cpori, null, usuario);
		Frecuencias destinoFrecuencia = frecuenciaDao.getFrecuenciaCP(cpdes, idgarantia, usuario);
		
		//Verifica si existen ambas frecuencias		
		if ((origenFrecuencia == null) || (destinoFrecuencia == null)) {
			debug("origenFrecuencia:" + origenFrecuencia + ", destinoFrecuencia:"+ destinoFrecuencia);
			return null;
		}


		//Obtiene cruce zonas
		Zona zona = icpZonaDao.getCruceZona(origenFrecuencia.getIdterminal(), 
				destinoFrecuencia.getIdterminal(),usuario,idgarantia);
		if (zona==null) {
			debug("CruceZona IS NULL, IdTerminalOrigen:" + origenFrecuencia.getIdterminal() + ",IdterminalDestino:" + destinoFrecuencia.getIdterminal()
					+ ",Garantia:" +idgarantia );
			return null;

		}
		
		//Obtiene Zona Venta
		Zona zonaVenta = icpZonaDao.getZonaVenta(origenFrecuencia.getZonaventa(), 
				destinoFrecuencia.getZonaventa(),usuario,idgarantia);
		
		//Obtiene cruce zonas
		if (zonaVenta==null) {
			
			debug("ZonaVenta IS NULL  ZonaVentaOrigen:" + origenFrecuencia.getIdterminal() + ",FZonaVentaDestino:" + destinoFrecuencia.getIdterminal()
					+ ",Garantia:" +idgarantia );
			return null;

		}
		//Regresa los datos de enrutamiento
		zona.setZonaVenta(zonaVenta.getZonaVenta());
		
		//Agrega la ruta de entrega en destino
		zona.getRutaDestinoEntrega().setIdruta(destinoFrecuencia.getRutaEnt());
		return zona;

	}
}
