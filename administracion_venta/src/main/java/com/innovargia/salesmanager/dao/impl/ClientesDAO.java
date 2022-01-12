/**
 * 
 */
package com.innovargia.salesmanager.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.ClientesDTO;
import com.innovargia.salesmanager.idao.IClientesDAO;
import com.innovargia.salesmanager.mappers.ClientesRowMapper;

/**
 * @author aruaro
 * 
 */
@Repository
public class ClientesDAO extends JdbcDaoSupport implements IClientesDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(ClientesDAO.class);
	
	final String  sql_ = "select distinct caclientefacturacion.*,cagrupocliente.idgrupocliente as clavegrupo,"
			+ " cagrupocliente.nombre as descripciongrupocliente,logincreador from caclientefacturacion LEFT OUTER JOIN cagrupocliente "
			+ "ON caclientefacturacion.idgrupo = cagrupocliente.identificador ";

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ClientesDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IClientesDAO#insert(com.innovargia.salesmanager.dtos.ClientesDTO)
	 */
	@Override
	public void insert(ClientesDTO obj) throws Exception{
		
		String query = "INSERT INTO public.caclientefacturacion( "
				+ "idgrupo, numcliente, descripcion, referencia, "
				+ "rfc, estatus, observacion,tipopersona,tipocliente,logincreador,clasificacion) "
				+ "VALUES( :idgrupo, :numcliente, :descripcion, :referencia, "
				+ ":rfc, 1, :observacion,:tipopersona,:tipocliente,:logincreador,:clasificacion)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);
		
		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "idcliente" });
			//return keyHolder.getKey();
		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
			if (dae.contains(DuplicateKeyException.class)) {
				throw new DuplicateKeyException("Registro Duplicado");
			} else {
				throw new DuplicateKeyException(dae.getMessage());
			}

		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IClientesDAO#update(com.innovargia.salesmanager.dtos.ClientesDTO)
	 */
	@Override
	public void update(ClientesDTO obj) throws Exception{
		
		String query = "UPDATE caclientefacturacion SET idgrupo= :idgrupo, numcliente = :numcliente,"
				+ "descripcion = :descripcion,referencia=:referencia,"
				+ "rfc= :rfc,observacion= :observacion, tipopersona=:tipopersona,"
				+ "tipocliente=:tipocliente,clasificacion=:clasificacion  "
				+ " WHERE idcliente = :idcliente";
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en update: " + dae.getMessage());
		}
		
		
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IClientesDAO#update(com.innovargia.salesmanager.dtos.ClientesDTO)
	 */
	@Override
	public void updateUsuarioCreador(ClientesDTO obj) throws Exception{
		
		String query = "UPDATE caclientefacturacion SET logincreador= :logincreador "
				+ " WHERE idcliente = :idcliente";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en update: " + dae.getMessage());
		}
		
		
	}
	@Override
	public void updateEstatus(ClientesDTO obj) throws Exception {
		String query = "UPDATE caclientefacturacion SET estatus= :estatus"
				+ " WHERE " +
			       " idcliente = :idcliente";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IClientesDAO#delete(com.innovargia.salesmanager.dtos.ClientesDTO)
	 */
	@Override
	public void delete(ClientesDTO obj) throws Exception{
		String query = "DELETE FROM caclientefacturacion  WHERE " +
			       " idcliente = :idcliente";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
	}
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IClientesDAO#getRegistros(com.innovargia.salesmanager.dtos.ClientesDTO)
	 */
	@Override
	public List<ClientesDTO> getRegistros(BusquedaDTO obj) throws Exception{
		List<ClientesDTO> lista = new ArrayList<ClientesDTO>();
		String sql = sql_;
		
		
		if (obj.getUsuario().getVisibilidad()==0){
			sql += " WHERE logincreador ='"+ obj.getUsuario().getLogin() + "'"; 
		}else{
			//Verifica que solo pueda ver documentos de los usuarios que estan dentro del agrupamiento del 
			//usuario y que tengan un puesto menor o igual al del usuario	
			sql += " WHERE login  IN("
					+ "		SELECT distinct login FROM viewagrupacionusuarios "
					+ "     WHERE login='" + obj.getUsuario().getLogin()
					+ "' AND nivelpuesto>=" + obj.getUsuario().getNivelPuesto() + "	)";

		}
		
		// Signidica que debe traer todos los registros
		if (obj.getEstatus() > -1) {
			sql += " AND estatus=" + obj.getEstatus();
		}
				
		logger.info("sql busqueda clientes: " + sql);
		lista = jdbcTemplate.query(sql,new ClientesRowMapper());
		return lista;
	}
	@Override
	public List<ClientesDTO> getBusquedaRegistros(BusquedaDTO obj) throws Exception{
		List<ClientesDTO> lista = new ArrayList<ClientesDTO>();
		String sql = sql_;
		
		//Signidica que debe traer todos los registros
		String where ="";
		if (obj.getTipo()==1){// POR RFC
			where += " caclientefacturacion.rfc LIKE '" + obj.getPatron_busqueda() + "%'";
		}
		if (obj.getTipo()==2){//Por Razon Social
			where += " caclientefacturacion.descripcion LIKE '" + obj.getPatron_busqueda() + "%'";
		}
		if (obj.getTipo()==3){//Por Razon Social
			where += " caclientefacturacion.numcliente LIKE '" + obj.getPatron_busqueda() + "%'";
		}
		
		if (obj.getTipo()==4){//SOLO FISCAL
			where += " caclientefacturacion.tipopersona='FISCAL'";
		}


		//Si la visibilidad del usuario es 0 solo puede ver sus clientes creados por el usuario
		String and_="";
		if (obj.getUsuario().getVisibilidad()==0){
			if (where.trim().length()>0){
				and_=" AND ";
			}
			where += and_ + " caclientefacturacion.logincreador ='"+ obj.getUsuario().getLogin() + "'";	
			
			
		}else{
			//Busca solo loc clientes que esten asignado a los grupos a los que el usuario esta 
			//Asignado y el nivel del usuario sea el mismo o menor al del usurio de se sesión
			if (where.trim().length()>0){
				and_=" AND ";
			}
			where +=  and_ + "  caclientefacturacion.logincreador  IN("
					+ "		SELECT distinct login FROM viewagrupacionusuarios  "
					+ "     WHERE idagrupamiento IN (SELECT idagrupamiento FROM"
					+ "		 viewagrupacionusuarios WHERE login='"+ obj.getUsuario().getLogin() + "' ) AND "
							+ " nivelpuesto>=" +
					obj.getUsuario().getNivelPuesto() + " )";

			
		}
		//Agrega el where
		if (where.trim().length()>0){
			sql = sql + " WHERE "+ where;
		}
		logger.info("sql busqueda clientes: " + sql);
		lista = jdbcTemplate.query(sql,new ClientesRowMapper());
		return lista;
	}
	


	@Override
	public ClientesDTO get(BusquedaDTO obj) throws Exception {
		String sql = sql_ + " WHERE idcliente = ?";
		try {
			return this.jdbcTemplate.queryForObject(sql,
					new ClientesRowMapper(), obj.getIdentificador_str());
		} catch (Exception dae) {
			logger.error("Error get:" + dae.getMessage());
			return null;
		}
	}


	@Override
	public void setTipoCliente(ClientesDTO obj) throws Exception {
		String query = "UPDATE caclientefacturacion SET tipocliente= :tipocliente"
				+ " WHERE " +
			       " idcliente = :idcliente";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}
	



}
