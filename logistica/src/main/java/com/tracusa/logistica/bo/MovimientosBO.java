/**
 * 
 */
package com.tracusa.logistica.bo;

import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.administracion.dto.RegistroInfo;
import com.tracusa.logistica.model.Caexcepcion;
import com.tracusa.logistica.model.CasamientoRespuesta;
import com.tracusa.logistica.model.CodigoErrorCasamiento;
import com.tracusa.logistica.model.Entrega;
import com.tracusa.logistica.model.Movimiento;
import com.tracusa.logistica.model.MovimientoRespuesta;
import com.tracusa.logistica.model.SiguienteMovimiento;
import com.tracusa.logistica.interfase.bo.IMovimientoBO;
import com.tracusa.logistica.interfase.dao.IMovimientoDao;

/**
 * @author aruaro
 *
 */
@Service
public class MovimientosBO implements IMovimientoBO {

    private static final Logger logger = LoggerFactory.getLogger(MovimientosBO.class);

    @Autowired
    IMovimientoDao iMovimientoDao;

    /**
    * 
    */
    public MovimientosBO() {

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.innovargia.ws.repo.interfase.IMovimientoDao#insert(com.innovargia.ws.
     * dto.Movimiento)
     */
    @Override
    public List<MovimientoRespuesta> insert(Movimiento obj) throws Exception {
	obj.setIdguia(obj.getIdguia().toUpperCase().trim());
	String[] arr_guias = obj.getIdguia().split("\n");
	// com.servicio.dtos.Entrega entregaDTO =null;
	int countGuias = 1;
	List<MovimientoRespuesta> lstMovimientosRespuesta = new ArrayList<>();
	MovimientoRespuesta movRespuesta = null;
	// Separa y agrega las guias
	for (String idguia : arr_guias) {
	    if ((idguia != null) && (idguia.trim().length() > 0)) {
		if (idguia.trim().length() <= 30) {
		    obj.setIdguia(idguia);
		    movRespuesta = new MovimientoRespuesta();
		    try {
			obj.setCveLog(obj.getCveLog() == null ? "" : obj.getCveLog());
			obj.setPlaza(obj.getPlaza() == null ? "" : obj.getPlaza());

			String request = iMovimientoDao.insert(obj);
			RegistroInfo registro = new RegistroInfo();
			registro.set_idpropietario(obj.getEmpleado());
			registro.set_servidor(obj.getPlaza() == null ? "REST" : obj.getPlaza());
			registro.set_idRegistro(obj.getTipoMovimiento());
			registro.set_plaza(obj.getPlaza() == null ? "RES" : obj.getPlaza());
			registro.setCantidad(1);

			iMovimientoDao.insertEstadisticasCarga(registro);

			if (!request.equals("200")) {

			    movRespuesta.setIdGuia(idguia);

			    movRespuesta.setMovimientoActual(convertToMovement(iMovimientoDao.movimientoActual(obj)));

			    movRespuesta.setLstSiguienteMovimiento(sigueinteMovimiento(request));

			    lstMovimientosRespuesta.add(movRespuesta);

			}

			/*
			 * if (request.equals("200") && countGuias == arr_guias.length) return request;
			 * if(countGuias == arr_guias.length) return request;
			 */
			// countGuias++;
		    } catch (Exception e) {
			logger.debug("Error al agregar el casamiento:" + e.getMessage());
			throw new Exception("Error al agregar el casamiento:" + e.getMessage());
		    }
		} else {
		    logger.debug("Guia :" + idguia.trim() + " tiene mas de 30 caracteres");
		}
	    }
	    // Agrega el atachment
	}
	return lstMovimientosRespuesta;
    }

    @Override
    public CasamientoRespuesta insertCasamiento(Movimiento obj) throws Exception {
	obj.setIdguia(obj.getIdguia().toUpperCase().trim());
	String[] arr_guias = obj.getIdguia().split("\n");
	com.servicio.dtos.Entrega entregaDTO = null;
	String idcasamiento = obj.getGuiaCasamiento();
	int request = 0;

	CasamientoRespuesta casRespuesta = new CasamientoRespuesta();
	CodigoErrorCasamiento errorCasamiento = null;
	List<CodigoErrorCasamiento> lstErrores = new ArrayList<>();

	// Separa y agrega las guias
	for (String idguia : arr_guias) {
	    if ((idguia != null) && (idguia.trim().length() > 0)) {
		if (idguia.trim().length() <= 30) {

		    obj.setIdguia(idcasamiento);
		    obj.setGuiaCasamiento(idguia);
		    try {

			request = iMovimientoDao.insertCasamiento(obj);

			if (request != 9) {

			    errorCasamiento = construirRespuesta(String.valueOf(request));

			    errorCasamiento.setIdGuia(idguia);

			    lstErrores.add(errorCasamiento);

			}

		    } catch (Exception e) {
			logger.debug("Error al agregar el casamiento:" + e.getMessage());
		    }
		} else {
		    logger.debug("Guia :" + idguia.trim() + " tiene mas de 30 caracteres");
		}
	    }
	    // Agrega el atachment
	}

	casRespuesta.setCode(lstErrores.isEmpty() ? "200" : "201");

	casRespuesta.setLstErrores(lstErrores);

	return casRespuesta;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.innovargia.ws.repo.interfase.IMovimientoDao#update(com.innovargia.ws.
     * dto.Movimiento)
     */
    @Override
    public int update(Movimiento obj) throws Exception {

	return 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.innovargia.ws.repo.interfase.IMovimientoDao#delete(com.innovargia.ws.
     * dto.Movimiento)
     */
    @Override
    public int delete(Movimiento obj) throws Exception {

	return 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.innovargia.ws.repo.interfase.IMovimientoDao#select(com.innovargia.ws.
     * dto.Movimiento)
     */
    @Override
    public List<Caexcepcion> select(String movType) throws Exception {

	return iMovimientoDao.select(movType);

    }

    public List<SiguienteMovimiento> sigueinteMovimiento(String movimientos) {

	List<SiguienteMovimiento> lstMovimientos = new ArrayList<>();

	if (movimientos.contains("|")) {

	    String[] arregloMovimientos = movimientos.split("\\|");

	    for (String nextMovement : arregloMovimientos) {

		lstMovimientos.add(convertToMovement(nextMovement));

	    }

	} else {

	    lstMovimientos.add(convertToMovement(movimientos));

	}

	return lstMovimientos;
    }

    public SiguienteMovimiento convertToMovement(String movimiento) {

	SiguienteMovimiento sm = new SiguienteMovimiento();

	switch (movimiento) {
	// declaración case
	// los valores deben ser del mismo tipo de la expresión
	case "21":

	    sm.setCodigo(21);

	    sm.setMovimiento("RECOLECCION");

	    break;

	case "1":

	    sm.setCodigo(1);

	    sm.setMovimiento("ENTRADA");

	    break;

	case "03":

	    sm.setCodigo(03);

	    sm.setMovimiento("NO EXITOSO");

	    break;

	case "2":

	    sm.setCodigo(2);

	    sm.setMovimiento("SALIDA FORANEA");

	    break;

	case "24":

	    sm.setCodigo(24);

	    sm.setMovimiento("SALIDA REPARTO");

	    break;

	case "4":

	    sm.setCodigo(4);

	    sm.setMovimiento("NO EXITOSO");

	    break;

	case "9":

	    sm.setCodigo(9);

	    sm.setMovimiento("CASAMIENTO");

	    break;
	}

	return sm;
    }

    public CodigoErrorCasamiento construirRespuesta(String codigo) {

	CodigoErrorCasamiento cec = new CodigoErrorCasamiento();

	switch (codigo) {
	// declaración case
	// los valores deben ser del mismo tipo de la expresión
	case "6":

	    cec.setCodigoError(6);

	    cec.setDescripcionError("Ya se encuentra el casamiento entre guias");

	    break;

	case "5":

	    cec.setCodigoError(5);

	    cec.setDescripcionError("La guia ya se encuentra casada con la guia");

	    break;

	case "3":

	    cec.setCodigoError(3);

	    cec.setDescripcionError("La guia ya esta casada con otra guia");

	    break;

	case "4":

	    cec.setCodigoError(4);

	    cec.setDescripcionError("La guia de casamiento contiene movimientos");

	    break;

	}

	return cec;
    }

}
