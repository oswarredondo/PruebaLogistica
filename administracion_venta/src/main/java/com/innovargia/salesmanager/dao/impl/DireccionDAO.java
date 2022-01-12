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

import com.innovargia.salesmanager.dtos.DireccionDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.idao.IDireccionDAO;
import com.innovargia.salesmanager.mappers.DireccionRowMapper;

/**
 * @author aruaro
 * 
 */
@Repository
public class DireccionDAO extends JdbcDaoSupport implements IDireccionDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(DireccionDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	final String  sql_ = "SELECT * FROM cadireccionctefact ";

	@Autowired
	public DireccionDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insert(DireccionDTO obj) throws Exception {
		String query = "INSERT INTO cadireccionctefact(idcliente,calle,numinterior,numexterior,colonia,municipio,estado,"
				+ "email,telefono,movil,dirdefault,observacion, cp ,clasificacion) " +
			       "VALUES( :idcliente, :calle,:numinterior, :numexterior, :colonia,:municipio,"
			       + ":estado,:email,:telefono,:movil,:dirdefault,:observacion,:cp,:clasificacion)";

		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "iddireccion" });
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

	@Override
	public void update(DireccionDTO obj) throws Exception {
		String query = "UPDATE cadireccionctefact SET calle = :calle,numinterior = :numinterior,"
				+ "numexterior= :numexterior, colonia= :colonia,municipio= :municipio,"
			       + "estado = :estado,email= :email,telefono= :telefono,movil= :movil,"
			       + "dirdefault= :dirdefault, observacion=:observacion, clasificacion=:clasificacion "
				+ " WHERE " +
			       " iddireccion = :iddireccion";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	@Override
	public void delete(DireccionDTO obj) throws Exception {
		String query = "DELETE FROM cadireccionctefact  WHERE  iddireccion = :iddireccion";
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en delete: " + dae.getMessage());
		}
		
	}

	
	@Override
	public List<DireccionDTO> getRegistrosClienteFact(DireccionDTO obj, UsuarioDTO usuario) throws Exception {
	    
	    List<DireccionDTO> lista = new ArrayList<DireccionDTO>();
	    String sql = "SELECT distinct direcciones.*, "
	    	+ "cacontactoctefact.nombre|| cacontactoctefact.apellido as atencion,"
	    	+ " cacontactoctefact.email, cacontactoctefact.telefono, cacontactoctefact.extencion, "
	    	+ "cacontactoctefact.clasificacion FROM  ("
	    	+ "	select caclientefacturacion.idcliente,caclientefacturacion.rfc,"
	    	+ "	 caclientefacturacion.referencia,caclientefacturacion.descripcion,"
	    	+ "	caclientefacturacion.descripcion as razonSocial, "
	    	+ "	cadireccionctefact.calle,cadireccionctefact.colonia,"
	    	+ "	cadireccionctefact.municipio as ciudad,cadireccionctefact.estado,"
	    	+ "	cadireccionctefact.cp,cadireccionctefact.municipio,"
	    	+ "	cadireccionctefact.numinterior,cadireccionctefact.numexterior"
	    	+ "	from caclientefacturacion join cadireccionctefact"
	    	+ "	ON caclientefacturacion.idcliente= cadireccionctefact.idcliente AND caclientefacturacion.estatus=1 ";
	    
		if (obj.getIddireccion()==1){
	    	    //Por RFC
	    	    sql=sql+ " AND caclientefacturacion.rfc LIKE '"+ obj.getDescripcion() + "%'";
        	}else if (obj.getIddireccion()==2){
        		//Ranzon Social
        		sql=sql+ " AND caclientefacturacion.descripcion LIKE '"+ obj.getDescripcion() + "%'";
        	}else if (obj.getIddireccion()==10){//Solo las direcciones del cliente seleccionado
        		sql=sql+ " AND caclientefacturacion.idcliente = "+ obj.getIdcliente();
        	}
	    	
		sql+=  ") direcciones  JOIN cacontactoctefact ON direcciones.idcliente= cacontactoctefact.idcliente ";
	    
		logger.info("sql busqueda direcciones: " + sql);
		  sql+=  " order by idcliente";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj); 	
		lista =  this.namedParameterJdbcTemplate.query(sql, parameterSource, new DireccionRowMapper());
		
		return lista;
        	    
	    	
	    
	  
	   
	    
	}
	
	
	@Override
	public List<DireccionDTO> getRegistros(DireccionDTO obj, UsuarioDTO usuario) throws Exception {
		String sql = sql_ +  " WHERE  idcliente =  :idcliente";
		List<DireccionDTO> lista = new ArrayList<DireccionDTO>();
		
		if (usuario== null) return lista;
		
		if (obj.getDirdefault()==90){
			//Devuelve la combinacion de los registyros de clientes mas sus direcciones
			//solo de los clientes activos
			sql="select  caclientefacturacion.idcliente,idgrupo,numcliente,descripcion,referencia,"
					+ "rfc,estatus,caclientefacturacion.observacion,tipopersona, "
					+ " tipocliente, logincreador,cadireccionctefact.*  from caclientefacturacion left outer join cadireccionctefact "
					+ "ON caclientefacturacion.idcliente=cadireccionctefact.idcliente WHERE"
					+ " caclientefacturacion.estatus=1 " ;
			
			if (obj.getIddireccion()==1){
				//Por RFC
				sql=sql+ " AND caclientefacturacion.rfc LIKE '"+ obj.getDescripcion() + "%'";
			}else if (obj.getIddireccion()==2){
				//Ranzon Social
				sql=sql+ " AND caclientefacturacion.descripcion LIKE '"+ obj.getDescripcion() + "%'";
			}else if (obj.getIddireccion()==10){//Solo las direcciones del cliente seleccionado
				sql=sql+ " AND caclientefacturacion.idcliente = "+ obj.getIdcliente();
			}
			

			if (usuario.getVisibilidad()==0){
				sql +=  " AND caclientefacturacion.logincreador ='"+ usuario.getLogin() + "'";	
			}else{

				sql +=  " AND caclientefacturacion.logincreador  IN("
						+ "		SELECT distinct login FROM viewagrupacionusuarios  "
						+ "     WHERE idagrupamiento IN (SELECT idagrupamiento FROM"
						+ "		 viewagrupacionusuarios WHERE login='"+ usuario.getLogin() + "' ) AND "
								+ " nivelpuesto>=" +
						usuario.getNivelPuesto() + " )";


			}

		}
		logger.info("sql busqueda direcciones: " + sql);
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj); 	
		lista =  this.namedParameterJdbcTemplate.query(sql, parameterSource, new DireccionRowMapper());
		
		return lista;
	}


	@Override
	public List<DireccionDTO> getVerificaExistencia(DireccionDTO obj, UsuarioDTO usuario,String operacion) throws Exception {
		
		String sql="select cadireccionctefact.* from caclientefacturacion left outer join cadireccionctefact "
				+ "ON caclientefacturacion.idcliente=cadireccionctefact.idcliente WHERE"
				+ " cadireccionctefact.calle=:calle AND cadireccionctefact.numexterior=:numexterior AND"
				+ " cadireccionctefact.colonia=:colonia AND cadireccionctefact.cp=:cp AND "
				+ "cadireccionctefact.municipio=:municipio AND cadireccionctefact.estado=:estado";
		
		if (operacion.equals("I")){
			sql +=  " AND caclientefacturacion.logincreador ='"+ usuario.getLogin() + "'";	
		}else{
			sql +=  " AND caclientefacturacion.logincreador ='"+ usuario.getLogin() + "' AND cadireccionctefact.idcliente!="+obj.getIdcliente();	
		}
		   
		
		/*if (usuario.getVisibilidad()==0){
			sql +=  " AND caclientefacturacion.logincreador ='"+ usuario.getLogin() + "'";	
		}else{

			sql +=  " AND caclientefacturacion.logincreador  IN("
					+ "		SELECT distinct login FROM viewagrupacionusuarios  "
					+ "     WHERE idagrupamiento IN (SELECT idagrupamiento FROM"
					+ "		 viewagrupacionusuarios WHERE login='"+ usuario.getLogin() + "' ) AND "
							+ " nivelpuesto>=" +
					usuario.getNivelPuesto() + " )";


		}*/
		
		List<DireccionDTO> lista = new ArrayList<DireccionDTO>();
		logger.info("Calle: " + obj.getCalle() + ",NUMEXT:"+ obj.getNumexterior()+
				",Colonia:"+obj.getColonia() + ",CP:"+ obj.getCp() + ",Municipio:" + obj.getMunicipio() +
				",Estado:" + obj.getEstado() + ",Login:" +  usuario.getLogin()+ ",operacion:"+operacion);
		
		logger.info("sql busqueda direcciones: " + sql);
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj); 	
		lista =  this.namedParameterJdbcTemplate.query(sql, parameterSource, new DireccionRowMapper());
		
		return lista;
	}
	@Override
	public DireccionDTO get(DireccionDTO obj) throws Exception {
		String sql = sql_ + " WHERE iddireccion = ?";
		try {
			return this.jdbcTemplate.queryForObject(sql,
					new DireccionRowMapper(), obj.getIddireccion());
		} catch (Exception dae) {
			logger.error("Error get:" + dae.getMessage());
			return null;
		}
	}

	@Override
	public void updateEstatus(DireccionDTO obj) throws Exception {
		
		
	}
	


}
