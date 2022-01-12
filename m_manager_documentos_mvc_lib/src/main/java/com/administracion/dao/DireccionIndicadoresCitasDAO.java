/**
 * 
 */
package com.administracion.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.administracion.dto.DireccionIndicadorCita;
import com.administracion.idao.IDireccionIndicadoresCitasDAO;
import com.administracion.rowmapper.DireccionIndicadorCitaRowMapper;
import com.innovargia.salesmanager.dtos.UsuarioDTO;

/**
 * @author Adrian Morales Ruaro
 * 
 */
@Repository
public class DireccionIndicadoresCitasDAO extends JdbcDaoSupport implements IDireccionIndicadoresCitasDAO {

		private static final Logger logger = LoggerFactory
				.getLogger(DireccionIndicadoresCitasDAO.class);
	    
	
		private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		//private JdbcTemplate jdbcTemplate;
		
		@Autowired
		public DireccionIndicadoresCitasDAO(DataSource dataSource) {
			setDataSource(dataSource);
			this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
					dataSource);
			//this.jdbcTemplate = new JdbcTemplate(dataSource);
		}

	/* (non-Javadoc)
	 * @see com.administracion.dao.IDireccionIndicadoresCitasDAO#getIndicadorCitaCuentaCte(com.innovargia.salesmanager.dtos.UsuarioDTO, java.lang.String)
	 */
	@Override
	public DireccionIndicadorCita getIndicadorCitaCuentaCte(UsuarioDTO usuario, String customer)
			throws SQLException {
		List<DireccionIndicadorCita> lista= getListaIndicadorCitaCuentaCte(usuario,  customer);
		if (lista.size()>0){
			return lista.get(0);
		}
		return null;
		
	}// fin de getIndicadorCitaCuentaCte
	
	
	
	/* (non-Javadoc)
	 * @see com.administracion.dao.IDireccionIndicadoresCitasDAO#getListaIndicadorCitaCuentaCte(com.innovargia.salesmanager.dtos.UsuarioDTO, java.lang.String)
	 */
	@Override
	public List<DireccionIndicadorCita> getListaIndicadorCitaCuentaCte(UsuarioDTO usuario, String customer)
			throws SQLException {
		
		String sql = "SELECT * FROM caindicadorcitacuentacte WHERE identidad="
				+ usuario.entidad.getIdentidad() + " AND idorganizacion="
				+ usuario.organizacion.getIdorganizacion();

		if (customer != null) {
			sql += " AND customer='" + customer + "'";
		}

		try {
			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue("identidad", usuario.entidad.getIdentidad());
			params.addValue("organizacion", usuario.organizacion.getIdorganizacion());
			
			return this.namedParameterJdbcTemplate.query(sql,params,
					new DireccionIndicadorCitaRowMapper());
		} catch (Exception sq) {
			logger.debug(sq.getMessage());
		}

		return new ArrayList<DireccionIndicadorCita>();
		
	}// fin de getIndicadorCitaCuentaCte
	
	/* (non-Javadoc)
	 * @see com.administracion.dao.IDireccionIndicadoresCitasDAO#getListaDirIndicadorCitaBusqueda(com.innovargia.salesmanager.dtos.UsuarioDTO, java.lang.String, int)
	 */
	@Override
	public List<DireccionIndicadorCita> getListaDirIndicadorCitaBusqueda(UsuarioDTO usuario, String dato, int tipo)
			throws SQLException {

		String sql = "SELECT * FROM caindicadorcitacuentacte WHERE identidad=:identidad "+
				" AND idorganizacion=:idorganizacion ";
		List<DireccionIndicadorCita> lista = new ArrayList<DireccionIndicadorCita>();
		MapSqlParameterSource params = new MapSqlParameterSource();
		String like_dato = "%"+dato+"%";
		params.addValue("dato", like_dato);
		switch (tipo) {
			case 1: // por descripcion1
				sql += " AND descripcion1 LIKE :dato'";
				break;
			case 2: // por poblacion
				sql += " AND poblacion LIKE :dato";
				break;
			case 3: // por ruta
				sql += " AND ruta LIKE :dato";
				break;
			case 4: // por territorio
				sql += " AND terr =:terr";
				break;				
			case 5: // por ejecutivo cuenta
				sql += " AND ejecutivocuenta LIKE :dato";
				break;	
			case 6: // por gerente
				sql += " AND gerente LIKE :dato";
				break;
			case 7: // por frecuencia
				sql += " AND fecuencia LIKE :dato ";
				break;	
			case 8: // por indicador cita
				sql += " AND indicadorcita=:dato";
				params.addValue("indicadorcita", dato);
				break;
			case 9: // por indicador cita
				sql += " AND customer=:customer";
				params.addValue("customer", dato);
				break;		
			default:
				logger.debug("NO SE INDICAO TIPo DE BUSQUEDA VALIDO:" + tipo);
				return lista;
		}
		
		logger.debug("SQL:" + sql + " " + "dato_like:" +like_dato + ",dato:" +dato + ", tipo"+tipo + 
				",identidad:"+ usuario.entidad.getIdentidad() + ",idorganizacion:"+ 
				usuario.organizacion.getIdorganizacion());
		
		try {
			
			params.addValue("identidad", usuario.entidad.getIdentidad());
			params.addValue("organizacion", usuario.organizacion.getIdorganizacion());
			
			return this.namedParameterJdbcTemplate.query(sql,params,
					new DireccionIndicadorCitaRowMapper());
		} catch (Exception sq) {
			logger.debug(sq.getMessage());
		}

		return lista;
		
	}// fin de getIndicadorCitaCuentaCte

	/* (non-Javadoc)
	 * @see com.administracion.dao.IDireccionIndicadoresCitasDAO#insert(com.administracion.dto.DireccionIndicadorCita)
	 */
	@Override
	public void insert(DireccionIndicadorCita datos) throws SQLException {
		
		String query = "INSERT INTO caindicadorcitacuentacte(identidad, idorganizacion, numcliente, " +
				" ruta, typo, descripcion,poblacion, customer, descripcion1, terr, ejecutivocuenta, " +
				" telmovilejecutivocuenta,gerente, telmovilgerente, propietariocuenta," +
				" telmovilpropietario, nextel, obervacion, telefonocliente, fecuencia, diasentrega, "
				+ "diasdefactura, diasentregalinea1, rddcliente, mad, ttxdockcte, "
				+ "salidaslinea1, ruta1, estado, opcionxd, cp, indicadorcita) "
				
				
				+ " VALUES (:identidad, :idorganizacion, :numCliente, :ruta, :typo, :descripcion, :poblacion, :customer, :descripcion1, :terr,"
				+ " :ejecutivocuenta, :telmovilejecutivocuenta,:gerente, :telmovilgerente, :propietariocuenta, :telmovilpropietario,"
				+ " :nextel, :observacion, :telefonocliente, :fecuencia, :diasentrega,:diasdefactura, :diasentregalinea1,"
				+ " :rddcliente, :mad, :ttxdockcte, :salidaslinea1, :ruta1, :estado, :opcionxd, :cp, " +  datos.getIndicadorcita()+ ")";
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				datos);
		this.namedParameterJdbcTemplate.update(query, parameterSource);
		
	}

	/* (non-Javadoc)
	 * @see com.administracion.dao.IDireccionIndicadoresCitasDAO#update(com.administracion.dto.DireccionIndicadorCita)
	 */
	@Override
	public void update(DireccionIndicadorCita datos) throws SQLException {
		
		String query ="UPDATE caindicadorcitacuentacte  SET  ruta=:ruta, typo=:typo, " +
				" descripcion=:descripcion, poblacion=:poblacion,  descripcion1=:descripcion1, terr=:terr," +
				" ejecutivocuenta=:ejecutivocuenta, telmovilejecutivocuenta=:telmovilejecutivocuenta,"
				+ " gerente=:gerente, telmovilgerente=:telmovilgerente," +
				" propietariocuenta=:propietariocuenta, telmovilpropietario=:telmovilpropietario,"
				+ " nextel=:nextel, obervacion=:observacion," +
				" telefonocliente=:telefonocliente, fecuencia=:fecuencia, diasentrega=:diasentrega, diasdefactura=:diasdefactura," +
				" diasentregalinea1=:diasentregalinea1, rddcliente=:rddcliente, mad=:mad, ttxdockcte=:ttxdockcte, salidaslinea1=:salidaslinea1," +
				" ruta1=:ruta1, estado=:estado, opcionxd=:opcionxd, cp=:cp, indicadorcita= " +datos.getIndicadorcita()+
				" WHERE identidad=:identidad AND idorganizacion=:idorganizacion AND customer=:customer ";
				
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				datos);
		this.namedParameterJdbcTemplate.update(query, parameterSource);
		
		
		
	}

	/* (non-Javadoc)
	 * @see com.administracion.dao.IDireccionIndicadoresCitasDAO#delete(com.administracion.dto.DireccionIndicadorCita)
	 */
	@Override
	public void delete(DireccionIndicadorCita datos) throws SQLException {
		
		String query = "DELETE FROM caindicadorcitacuentacte " +
				" WHERE identidad=:identidad AND idorganizacion=:idorganizacion AND customer=:customer ";
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				datos);
		this.namedParameterJdbcTemplate.update(query, parameterSource);
		
	
	}
}
