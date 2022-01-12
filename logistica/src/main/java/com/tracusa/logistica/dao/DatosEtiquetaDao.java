/**
 * 
 */
package com.tracusa.logistica.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.tracusa.logistica.model.DatosEtiqueta;
import com.tracusa.logistica.model.Entrega;
import com.tracusa.logistica.interfase.dao.IDatosEtiquetaDao;
import com.tracusa.logistica.interfase.dao.IEntregaDao;

/**
 * @author aruaro
 *
 */
@Repository
public class DatosEtiquetaDao extends JdbcDaoSupport implements IDatosEtiquetaDao  {

    
    private static final Logger logger = LoggerFactory
		.getLogger(DatosEtiquetaDao.class);

    

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
    /**
     * 
     */
	@Autowired	
    public DatosEtiquetaDao(DataSource dataSource) {
	
	setDataSource(dataSource);
	this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
			dataSource);
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	
	}

    /* (non-Javadoc)
     * @see com.innovargia.ws.dao.IDatosEtiquetaDao#insert(com.innovargia.ws.dto.DatosEtiqueta)
     */
    @Override
    public int insert(DatosEtiqueta obj) throws Exception{
	 logger.info("EntregaDao create insert.");
	 
	 String query =  "INSERT INTO rotulacion_etiqueta_excel("
	 	+ " fechacreacion,razonsocial_rem, contacto_rem, calle_rem, numinterior_rem, "
	 	+ " numexterior_rem, colonia_rem, municipio_rem, estado_rem, ciudad_rem, "
	 	+ " cp_rem, telefono_rem, celular_rem, rfc_rem, email_rem, razonsocial_des, "
	 	+ " contacto_des, calle_des, numinterior_des, numexterior_des, colonia_des,"
	 	+ " municipio_des, estado_des, ciudad_des, cp_des, telefono_des, "
	 	+ " celular_des, rfc_des, email_des, es_ocurre, tiene_seguro, nacional, "
	 	+ " es_multiple, numpiezas, pesofisico, largo, ancho, alto, contenido,"
	 	+ " observacion, referencia, valor_asegurado, valordeclarado)"
	 	+ " VALUES (current_timestamp,"+
	 	 "'" + obj.remitente.getRazonsocial() + "','" + obj.remitente.getContacto()+
	 	 "','" +obj.remitente.getCalle()+ "','"  +obj.remitente.getNuminterior()+ "'," +
	 	 "'" +obj.remitente.getNumexterior()+ "','" + obj.remitente.getColonia()+ "','" + 
	 	obj.remitente.getMunicipio()+ "','" + obj.remitente.getEstado() + "','" +obj.remitente.getCiudad()+ "'," +
	 	 "'" +obj.remitente.getCp()+ "','" + obj.remitente.getTelefono()+ "','" +obj.remitente.getCelular()+ "','" + 
	 	obj.remitente.getRfc()+ "','"+ obj.remitente.getEmail()+ "','" +
	 	obj.destinatario.getRazonsocial()+ "','" +
	 	obj.destinatario.getContacto()+ "','" +  obj.destinatario.getCalle()+ "','" + 
	 	obj.destinatario.getNuminterior()+ "','" +  obj.destinatario.getNumexterior()+ "','" +  
	 	obj.destinatario.getColonia()+ "','" +
	 	obj.destinatario.getMunicipio()+ "','" +  obj.destinatario.getEstado()+ "','" +
	 	obj.destinatario.getCiudad()+ "','" +  obj.destinatario.getCp() +"','"+  obj.destinatario.getTelefono()+ "','" +
	 	obj.destinatario.getCelular()+ "','" +  obj.destinatario.getRfc()+ "','" + 
	 	obj.destinatario.getEmail()+ "','" +  obj.getEs_ocurre()+ "','" + obj.getTiene_seguro()+ "','" +
	 	obj.getNacional()+ "'," + "'" + obj.getEs_multiple()+ "'," + obj.getNumpiezas() + "," + obj.getPesofisico()+ "," +
	 	obj.getLargo()+ "," + obj.getAncho()+ "," + obj.getAlto()+ ",'" + obj.getContenido()+ "','" +
	 	obj.getObservacion()+ "','" + obj.getReferencia()+ "'," +  obj.getValor_asegurado() + "," +  
	 	obj.getValordeclarado() +  ")";


		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
			obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (DataAccessException dae) {
			logger.debug("error insert:" + dae.getMessage());
		}
		
	return 0;
    }
    
   
}
