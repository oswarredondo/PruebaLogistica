/**
 * 
 */
package com.innovargia.servicio.tracking.rest.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.innovargia.ws.repo.interfase.dao.IServicioDatosDAO;
import com.innovargia.ws.tracking.rest.dto.ConsultarTrackingRequest;
import com.innovargia.ws.tracking.rest.dto.Envio;
import com.innovargia.ws.tracking.rest.dto.UsuarioDTO;
import com.innovargia.ws.tracking.rest.rowmaps.EnvioRowMapper;
import com.innovargia.ws.tracking.rest.rowmaps.UsuarioRowMapper;

/**
 * @author Adri�n
 * 
 */
@Repository
public class ServicioDatosDAO extends JdbcDaoSupport implements IServicioDatosDAO {
	private static Logger logger = Logger.getLogger(ServicioDatosDAO.class);
    
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	private final String QUERY_DOC = "SELECT D.*,Devolucion.iddevolucion as iddevolucion FROM ("
			+ "		SELECT C.*,Casamiento.idcasamiento AS idcasamiento  FROM ("
			+ "			SELECT A.*, B.* FROM ( SELECT * FROM caDocumentos "
			+ "			LEFT OUTER JOIN Confirma ON caDocumentos.IdDocumento = Confirma.idguia ) A LEFT OUTER JOIN "
			+ "			(select distinct iddocumento as isnota  from viewEnviosConNotas ) B ON A.IdDocumento = B.isnota "
			+ "		) C LEFT OUTER JOIN Casamiento ON C.IdDocumento = Casamiento.IdGuia"
			+ "	) D LEFT OUTER JOIN Devolucion ON D.IdDocumento = Devolucion.IdGuia ";

    @Autowired	
	public ServicioDatosDAO(DataSource dataSource) {
	    	setDataSource(dataSource);
	    	this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	    	this.jdbcTemplate = new JdbcTemplate(dataSource);
	    	
	}
    
    @Override
	public UsuarioDTO getUsuario(UsuarioDTO usuario) throws Exception {

		try {
			SqlParameterSource paramMap = new BeanPropertySqlParameterSource(usuario);

			// Obtiene los datos de la orden de Servicio
			String sql = "SELECT identidad, idorganizacion, numcliente, idperfil, nombre, login,"
					+ "  password, logo, estatus, idoficina, numempleado, siglasplaza, "
					+ "       formatoetimedia, formatoetiperso  FROM causuarios WHERE login=:login AND"
					+ " numcliente=:numcte AND password=:password ";
			
			List<UsuarioDTO> usuarios = this.namedParameterJdbcTemplate.query(sql, paramMap, new UsuarioRowMapper());
			if (usuarios.size()>0){
				return usuarios.get(0);
			}

		} catch (Exception sqle) {
			logger.error("Error en getUsuario -->" + sqle.getMessage());
		} 
		return null;
		
	}
	
	private List<com.innovargia.ws.tracking.rest.dto.Envio> ejecutaQuery(String sql){
		try{
			return this.jdbcTemplate.query(sql, new EnvioRowMapper());
		}catch(Exception e){
			logger.debug("Errr ejecutaQuery:" + e.getMessage());
		}
		
		return new ArrayList<com.innovargia.ws.tracking.rest.dto.Envio>();
	}
	  
	/* (non-Javadoc)
	 * @see com.innovargia.ws.tracking.rest.dao.impl.IDocumentoDAO#busquedaXReferencia(com.consulta.ws.tracking.dto.ConsultarTrackingRequest, java.lang.String)
	 */
	@Override
	public List<com.innovargia.ws.tracking.rest.dto.Envio> busquedaXReferencia(ConsultarTrackingRequest request, String tipoDocumento) {
		
		try {
			
			// Obtiene los datos de la orden de Servicio
			String sql = QUERY_DOC + " WHERE referencia= '" + request.getReferencia() + "'" +
					 "AND numcliente='" + request.getCliente() +"'";

			if ((request.getFechainicial() != null) && (request.getFechafinal() != null)
					&& (request.getFechainicial().trim().length() > 0)
					&& (request.getFechafinal().trim().length() > 0)) {

				sql += "' AND fechacreacion >='" + request.getFechafinal() + "' AND fechacreacion<='"
						+ request.getFechafinal() + "'  ";
			}

			if (tipoDocumento != null) {
				sql += " AND idtipodocumento='" + tipoDocumento + "'";
			}
			return ejecutaQuery(sql);
			
			
			

		} catch (Exception sqle) {
			logger.error("Error en getInfoDocumento -->" + sqle.getMessage());
		} 

		return  new ArrayList<com.innovargia.ws.tracking.rest.dto.Envio>();

	}

	/* (non-Javadoc)
	 * @see com.innovargia.ws.tracking.rest.dao.impl.IDocumentoDAO#busquedaArrGuias(com.consulta.ws.tracking.dto.ConsultarTrackingRequest, java.lang.String, java.lang.String)
	 */
	@Override
	public List<Envio> busquedaArrGuias(ConsultarTrackingRequest request, String guias, String tipoDocumento) {
		try {
			// Obtiene los datos de la orden de Servicio
			String sql = QUERY_DOC + " WHERE iddocumento IN (" + guias + ") AND numcliente='"
					+ request.getCliente() + "'";
			if (tipoDocumento != null) {
				sql += " AND idtipodocumento='" + tipoDocumento + "'";
			}

			return ejecutaQuery(sql);

		} catch (Exception sqle) {
			logger.error("Error en getInfoDocumento -->" + sqle.getMessage());
		}

		return new ArrayList<com.innovargia.ws.tracking.rest.dto.Envio>();

	}

	/* (non-Javadoc)
	 * @see com.innovargia.ws.tracking.rest.dao.impl.IDocumentoDAO#busquedaFechaCreacionPorCliente(com.consulta.ws.tracking.dto.ConsultarTrackingRequest, java.lang.String)
	 */
	@Override
	public List<Envio> busquedaFechaCreacionPorCliente(ConsultarTrackingRequest request, String tipoDocumento) {
		
		try{
			// Obtiene los datos de la orden de Servicio
			String sql = QUERY_DOC + " WHERE numcliente = '" + request.getCliente()
					+ "' AND fechacreacion >='" + request.getFechainicial() + "' AND fechacreacion<='"
					+ request.getFechafinal() + "' ";
			if (tipoDocumento != null) {
				sql += " AND idtipodocumento='" + tipoDocumento + "'";
			}


			return ejecutaQuery(sql);

		} catch (Exception sqle) {
			logger.error("Error en getInfoDocumento -->" + sqle.getMessage());
		}

		return new ArrayList<com.innovargia.ws.tracking.rest.dto.Envio>();
	}

	/* (non-Javadoc)
	 * @see com.innovargia.ws.tracking.rest.dao.impl.IDocumentoDAO#obtieneDatosDeCasamiento(com.consulta.ws.tracking.dto.ConsultarTrackingRequest, java.lang.String)
	 */
	@Override
	public List<Envio> obtieneDatosDeCasamiento(ConsultarTrackingRequest request, String tipoDocumento) {
		try{
			 ;
			// Obtiene los datos de la orden de Servicio
			String sql = "select * from cadocumentos LEFT OUTER JOIN Confirma  ON "
					+ "cadocumentos.iddocumento =Confirma.idguia" + " "
					+ " where numcliente='" + request.getCliente() +"' AND iddocumento  IN  ("
					+ "SELECT  idguia FROM casamiento where" + " idcasamiento ='" + request.getGuiacasamiento() + "')";

			if (tipoDocumento != null) {
				sql += " AND idtipodocumento='" + tipoDocumento + "'";
			}


			return ejecutaQuery(sql);

		} catch (Exception sqle) {
			logger.error("Error en getInfoDocumento -->" + sqle.getMessage());
		}

		return new ArrayList<com.innovargia.ws.tracking.rest.dto.Envio>();

	}

	

	/* (non-Javadoc)
	 * @see com.innovargia.ws.tracking.rest.dao.impl.IDocumentoDAO#buscaArrGuiasMultiples(com.consulta.ws.tracking.dto.ConsultarTrackingRequest, java.lang.String)
	 */
	@Override
	public List<Envio> buscaArrGuiasMultiples(ConsultarTrackingRequest request, String idguiamadremultiple) {

		try {
			// Obtiene los datos de la orden de Servicio
			String sql = "select * from cadocumentos LEFT OUTER JOIN Confirma  ON "
					+ "cadocumentos.iddocumento =Confirma.idguia AND  es_multiple='SI' AND "
					+ " cadocumentos.idguiamadremultiple='" + idguiamadremultiple + "' "
							+ " WHERE cadocumentos.numcliente='" + request.getCliente() +"'";

			return ejecutaQuery(sql);

		} catch (Exception sqle) {
			logger.error("Error en getInfoDocumento -->" + sqle.getMessage());
		}

		return new ArrayList<com.innovargia.ws.tracking.rest.dto.Envio>();

	}

	@Override
	public String obtieneGuiaMadreMultiple(ConsultarTrackingRequest request, String idguiamadremultiple) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
