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
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.ClientesDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.idao.IClientesRFCsDAO;
import com.innovargia.salesmanager.mappers.ClientesRFCsRowMapper;

/**
 * @author aruaro
 *
 */
@Service
public class ClientesRFCsDAO  extends JdbcDaoSupport  implements IClientesRFCsDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(ClientesDAO.class);
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ClientesRFCsDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.idao.IClientesRFCsDAO#insert(com.innovargia.salesmanager.dtos.RemDes)
	 */
	@Override
	public void insert(RemDes obj) throws Exception {
		String query = "INSERT INTO caclientesrfc( "
				+ "rfc, numcliente, razonsocial, atencion, "
				+ "calle, numinterior, numexterior,colonia,ciudad,estado,cp, municipio,"
				+ " telefono, numcelular,extencion, movil,correoe, rotula, estatus) "
				+ "VALUES( :rfc, :numCliente, :razonSocial, :atencion, "
				+ ":calle, :numinterior, :numexterior,:colonia,:ciudad,:estado,:cp,:municipio,"
				+ ":telefono,:numcelular,:extencion,:movil,:correoe, :rotula, :estatus_int)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "identificador" });
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
	 * @see com.innovargia.salesmanager.idao.IClientesRFCsDAO#update(com.innovargia.salesmanager.dtos.RemDes)
	 */
	@Override
	public void update(RemDes obj) throws Exception {
	
		
		String query = "UPDATE caclientesrfc SET rfc=:rfc, numcliente=:numCliente, "
				+ "razonsocial=:razonSocial, atencion=:atencion, colonia=:colonia,"
				+ "calle=:calle, numinterior=:numinterior, numexterior=:numexterior,"
				+ "estado=:estado,cp=:cp,municipio=:municipio,ciudad=:ciudad,"
				+ "telefono=:telefono,numcelular=:numcelular,extencion=:extencion,"
				+ "movil=:movil,correoe=:correoe,rotula=:rotula WHERE identificador = :idAutonumerico";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en update: " + dae.getMessage());
		}

	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.idao.IClientesRFCsDAO#delete(com.innovargia.salesmanager.dtos.RemDes)
	 */
	@Override
	public void delete(RemDes obj) throws Exception {
		
		String query = "DELETE FROM caclientesrfc  WHERE identificador = :idAutonumerico";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en update: " + dae.getMessage());
		}

	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.idao.IClientesRFCsDAO#get(com.innovargia.salesmanager.dtos.BusquedaDTO)
	 */
	@Override
	public RemDes get(BusquedaDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.idao.IClientesRFCsDAO#getBusquedaRegistros(com.innovargia.salesmanager.dtos.BusquedaDTO)
	 */
	@Override
	public List<RemDes> getBusquedaRegistros(BusquedaDTO obj)
			throws Exception {
		List<RemDes> lista = new ArrayList<RemDes>();
		String sql = "SELECT * FROM caclientesrfc";
		
		
		String where ="";
		if (obj.getTipo()==0){//VER TODOS
		}else if (obj.getTipo()==1){//R.F.C
			where += " rfc LIKE '" + obj.getPatron_busqueda() + "%'";
		}else if (obj.getTipo()==2){//RAZON SOCIAL
			where += " razonsocial LIKE '" + obj.getPatron_busqueda() + "%'";
		}else if (obj.getTipo()==3){//NUM CLIENTE
			where += " numcliente LIKE '" + obj.getPatron_busqueda() + "%'";
		}else if (obj.getTipo()==4){//COLONIA
			where += " colonia LIKE '" + obj.getPatron_busqueda() + "%'";
		}else if (obj.getTipo()==5){//MUNICIPIO
			where += " municipio LIKE '" + obj.getPatron_busqueda() + "%'";
		}else if (obj.getTipo()==6){//ESTADO
			where += " estado LIKE '" + obj.getPatron_busqueda() + "%'";
		}else if (obj.getTipo()==7){//ATENCION
			where += " atencion LIKE '" + obj.getPatron_busqueda() + "%'";
		}else{
			return lista;
		}

		if (where.trim().length()>0){
			sql = sql + " WHERE " + where;
		}

		lista = jdbcTemplate.query(sql,new ClientesRFCsRowMapper());
		return lista;
	}

	@Override
	public void updateEstatus(ClientesDTO obj) throws Exception {
		String query = "UPDATE caclientesrfc SET estatus= :estatus"
				+ " WHERE " +
			       " identificador = :idcliente";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

}
