/* $Id:  $
 *
 * Nombre del Proyecto:
 * Nombre del Programa: ServiciosDao.java
 * Responsable: Adri�n Morales Ruaro
 * Descripcion:  Acceso de a los datos de la tabla de Sercicios, empaques,
 * garantias
 *
 * $Log:$
 */
package com.administracion.dao; 

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.administracion.idao.IServiciosDao;
import com.administracion.rowmapper.ObjetoRowMapper;
import com.innovargia.documentos.dtos.Objeto;

/**
 *<CODE>
 * Manejo de los datos de servicios, empaques y garantias
 *</CODE>
 * 
 * @author Adrian Morales Ruaro
 * @version $Id: $
 */
@Repository
public class ServiciosDao  extends JdbcDaoSupport implements IServiciosDao {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ServiciosDao.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ServiciosDao(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	/** Query Generico para obtener los datos del usuario */
	private static String SELECT_FORMATO = "SELECT IdFormato, Descripcion FROM caTipoFormato ";

	// private static String _SELECT_SERVICIO =
	//"SELECT IdServicio, Descripcion, PesoBase, FechaBaja FROM caTipoServicio ";

	private static String SELECT_TIPO_ENVIO = "SELECT IdTipoEnvio, Descripcion FROM caTipoEnvio ";

	private static String SELECT_TIPO_ADICIONAL = "SELECT IdAdicional, Descripcion FROM caAdicional ";

	private static String _SELECT_TIPO_GARANTIA = "SELECT IdGarantia, Descripcion FROM caTipoGarantia ";

	private static String SELECT_TIPO_FORMA_PAGO = "SELECT IdTipoPago,Descripcion from caFormaPago ";

	private String SELECT_FORMA_PAGO_GARANTIA = "SELECT IdServicio, Descripcion, IdGarantia, "
			+ "DescGarantia, HorasEntrega FROM viewFormaPagoGar  ";

	private String SELECT_GARANTIA = "SELECT IdGarantia, Descripcion, HorasEntrega FROM caTipoGarantia ";

	private String SELECT_SERVICIO = "SELECT IdServicio, Descripcion FROM caTipoServicio ";

	/** Creates nueva instancia de UsuarioDao */
	public ServiciosDao() {
	}

	// Obtiene el log de la aplicacion
	// private Logger logger = Bitacora.getBitacora();

	/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {
		logger.debug( mensaje);
	}// fin de debug


	/* (non-Javadoc)
	 * @see com.administracion.dao.IServiciosDao#getObjeto(java.lang.String, java.lang.String)
	 */
	@Override
	public Objeto getObjeto(String id, String query) throws SQLException {

     	List<Objeto> lista = jdbcTemplate.query(query, new Object[] {id},
	  				new ObjetoRowMapper());
     	for (Objeto objeto : lista) {
			return objeto;
		}
	    
     	return null;

	}// fin de getObjeto

	/* (non-Javadoc)
	 * @see com.administracion.dao.IServiciosDao#getObjeto(int, java.lang.String)
	 */
	@Override
	public Objeto getObjeto(int id, String query) throws SQLException {

		
		List<Objeto> lista = jdbcTemplate.query(query, new Object[] {id},
  				new ObjetoRowMapper());
	 	for (Objeto objeto : lista) {
			return objeto;
		}
	    
	 	return null;

	}// fin de getObjeto

	/* (non-Javadoc)
	 * @see com.administracion.dao.IServiciosDao#getFormatos(java.lang.String)
	 */
	@Override
	public Objeto getFormatos(String id) throws SQLException {

		String sql = SELECT_FORMATO + " WHERE IdFormato = ? ";
		try {
			return getObjeto(id, sql);
		} catch (SQLException sq) {
			throw sq;
		}
	}// fin de getEmpaque

	/*
	 * Verifica si existe el empaque/formatos buscado
	 * 
	 * @throws SQLException
	 * 
	 * @return una instancia de objeto con los datos requeridos o null en caso
	 * de que no exista ningun dato
	 */
	/* (non-Javadoc)
	 * @see com.administracion.dao.IServiciosDao#getFormaPago(java.lang.String)
	 */
	@Override
	public Objeto getFormaPago(String id) throws SQLException {
		// debug("BUSCANDO FORMA DE PAGO PARA->" + id);

		String sql = SELECT_TIPO_FORMA_PAGO + " WHERE IdTipoPago = ? ";
		//debug("sql->" + sql);

		try {
			if (id.trim().length() > 1) {
				//debug("id.trim().substring(1)->" + id.trim().substring(1));
				return getObjeto(id.trim().substring(1), sql);
			} else {
				//debug("id->" + id.trim());
				return getObjeto(id, sql);
			}
		} catch (SQLException sq) {
			throw sq;
		}
	}// fin de getEmpaque

	/* (non-Javadoc)
	 * @see com.administracion.dao.IServiciosDao#getAdicional(java.lang.String)
	 */
	@Override
	public Objeto getAdicional(String id) throws SQLException {

		String sql = SELECT_TIPO_ADICIONAL + " WHERE IdAdicional = ? ";
		try {
			return getObjeto(id, sql);
		} catch (SQLException sq) {
			throw sq;
		}
	}// fin de getEmpaque

	/* (non-Javadoc)
	 * @see com.administracion.dao.IServiciosDao#getDesFormatos(java.lang.String)
	 */
	@Override
	public String getDesFormatos(String id) throws SQLException {
		int iden;

		Objeto obj = getFormatos(id);

		if (obj == null) {
			return "DESCONOCIDO";
		}

		return obj.getDescripcion();

	}// fin de getEmpaque

	/* (non-Javadoc)
	 * @see com.administracion.dao.IServiciosDao#getDesFormaPago(java.lang.String)
	 */
	@Override
	public String getDesFormaPago(String id) throws SQLException {
		int iden;
		
		Objeto obj = getFormaPago(id);

		if (obj == null) {
			debug("ES NULO EL OBJETO ");
			return "DESCONOCIDO";
		}

		//debug("Descripcion " + obj.getDescripcion());
		return obj.getDescripcion();

	}// fin de getEmpaque

	/* (non-Javadoc)
	 * @see com.administracion.dao.IServiciosDao#getDesTipoEnvio(java.lang.String)
	 */
	@Override
	public String getDesTipoEnvio(String id) throws SQLException {
		int iden;

		Objeto obj = getTipoEnvio(id);

		if (obj == null) {
			return "DESCONOCIDO";
		}

		return obj.getDescripcion();

	}// fin de getTipoEnvio

	/* (non-Javadoc)
	 * @see com.administracion.dao.IServiciosDao#getDesTipoServicio(java.lang.String)
	 */
	@Override
	public String getDesTipoServicio(String id) throws SQLException {
		// int iden;

		if (id == null)
			return "DESCONOCIDO";

		String idservicio2= id.trim();
				
		if (id.trim().length() >= 2) {
			idservicio2 = id.trim().substring(0, 1);
		}
		MapSqlParameterSource params= new MapSqlParameterSource();
		params.addValue("idservicio1", id.trim());
		params.addValue("idservicio2", idservicio2);
		
		String query = "SELECT * FROM catiposervicio where IdServicio IN (:idservicio1,:idservicio2)";
		List<Objeto> lista = this.namedParameterJdbcTemplate.query(query,params,new ObjetoRowMapper());
		for (Objeto objeto : lista) {
			return objeto.getDescripcion();
		}

		return "DESCONOCIDO";

	}// fin de getTipoEnvio

	/* (non-Javadoc)
	 * @see com.administracion.dao.IServiciosDao#getDesAdicional(java.lang.String)
	 */
	@Override
	public String getDesAdicional(String id) throws SQLException {
		int iden;

		Objeto obj = getAdicional(id);

		if (obj == null) {
			return "DESCONOCIDO";
		}

		return obj.getDescripcion();

	}// fin de getTipoEnvio

	/* (non-Javadoc)
	 * @see com.administracion.dao.IServiciosDao#getDesGarantia(java.lang.String)
	 */
	@Override
	public String getDesGarantia(String id) throws SQLException {
		
		if (id == null)
			return "DESCONOCIDO";

		String idgarantia2= id.trim();
				
		if (id.trim().length() >= 2) {
			idgarantia2 = id.trim().substring(0, 1);
		}
		MapSqlParameterSource params= new MapSqlParameterSource();
		params.addValue("idgarantia1", id.trim());
		params.addValue("idgarantia2", idgarantia2);
		
		String query = "SELECT * FROM catipogarantia where IdGarantia IN (:idgarantia1,:idgarantia2)";
		List<Objeto> lista = this.namedParameterJdbcTemplate.query(query,params,new ObjetoRowMapper());
		for (Objeto objeto : lista) {
			return objeto.getDescripcion();
		}

		return "DESCONOCIDO";
		
		

	}// fin de getTipoEnvio

	/* (non-Javadoc)
	 * @see com.administracion.dao.IServiciosDao#getGarantia(java.lang.String)
	 */
	@Override
	public Objeto getGarantia(String id) throws SQLException {

		String sql = SELECT_GARANTIA + " WHERE IdGarantia = ? ";

		try {
			return getObjeto(id, sql);
		} catch (SQLException sq) {
			throw sq;
		}

	}// fin de getServicio

	/* (non-Javadoc)
	 * @see com.administracion.dao.IServiciosDao#getTipoEnvio(java.lang.String)
	 */
	@Override
	public Objeto getTipoEnvio(String id) throws SQLException {

		String sql = SELECT_TIPO_ENVIO + " WHERE IdTipoEnvio = ? ";
		try {
			return getObjeto(id, sql);
		} catch (SQLException sq) {
			throw sq;
		}
	}// fin de getGarantia

	/* (non-Javadoc)
	 * @see com.administracion.dao.IServiciosDao#getTipoServicio(java.lang.String)
	 */
	@Override
	public Objeto getTipoServicio(String id) throws SQLException {

		//debug("Tipo identidicador->" + id);

		String sql = SELECT_SERVICIO + " WHERE IdServicio ( ? ";
		try {
			return getObjeto(id, sql);
		} catch (SQLException sq) {
			throw sq;
		}
	}// fin de getGarantia

	/* (non-Javadoc)
	 * @see com.administracion.dao.IServiciosDao#getListaObjetos(int)
	 */
	@Override
	public ArrayList getListaObjetos(int _lista) throws SQLException {
		ArrayList lista = new ArrayList();

		/*PreparedStatement ps = null;
		ResultSet rs = null;
		Connection cnx = null;
		String sql = "";
		
		// Configura el query a ejecutar
		switch (_lista) {
		case Utils.TIPO_EMBAJALES:
			sql = SELECT_FORMATO;
			break;
		
		case Utils.TIPO_ENVIO:
			sql = SELECT_TIPO_ENVIO;
			break;
		case Utils.TIPO_SERVICIO:
			sql = SELECT_SERVICIO;
			break;
		case Utils.FORMATOS: // Para servicios o por defaul devuleve esta lista
			sql = SELECT_FORMATO;
			break;
		case Utils.TIPO_GARANTIA: // Para servicios o por defaul devuleve esta
			// lista
			// sql = SELECT_TIPO_GARANTIA + " ORDER BY IdGarantia ";
			sql = SELECT_GARANTIA + " ORDER BY IdGarantia ";
			break;
		case Utils.TIPO_ADICIONAL: // Para servicios o por defaul devuleve esta
			// lista
			sql = SELECT_TIPO_ADICIONAL + " ORDER BY IdAdicional ";
			break;

		default:
			sql = SELECT_FORMATO;
			break;

		}// fin del switch

		try {
			cnx = Conexion.getConexion();
			ps = cnx.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {
				// Crea el objeto del usuario
				lista.add(newObjeto(rs));
			}// fin del while

		} catch (SQLException sq) {
			debug("Error en lista de objetos-->" + sq.getMessage());
			throw sq;
		} finally {
			// Cierra recursos
			Conexion.closeRecursos(rs, ps, cnx);
		}*/
		return lista;
	}// fin de getListaObjetos

}// fin de ServiciosDao
