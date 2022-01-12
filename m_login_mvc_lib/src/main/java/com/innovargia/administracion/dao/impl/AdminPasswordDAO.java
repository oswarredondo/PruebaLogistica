package com.innovargia.administracion.dao.impl;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.innovargia.administracion.idao.IAdminPasswordDAO;


@Repository
public class AdminPasswordDAO extends JdbcDaoSupport implements IAdminPasswordDAO {

	private static final Logger logger = LoggerFactory.getLogger(AdminPasswordDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public AdminPasswordDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/* (non-Javadoc)
	 * @see com.innovargia.administracion.dao.impl.IAdminPasswordDAO#insertBitacoraAcceso(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void insertBitacoraAcceso(String login, String modulo, String password) throws Exception {
		String sql ="INSERT INTO bitacora_acceso(login, password, modulo, fecha) "
				+ "    VALUES (:login, :password, :modulo, current_timestamp)";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("modulo", modulo);
		params.addValue("login", login);
		params.addValue("password", password);
		
		this.namedParameterJdbcTemplate.update(sql, params);
	}

	/* (non-Javadoc)
	 * @see com.innovargia.administracion.dao.impl.IAdminPasswordDAO#insertHistorial(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void insertHistorial(String login, String password,String estado) throws Exception {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("login", login);
		params.addValue("password", password);
		params.addValue("estado", estado);
		
		
		
		//Inserta e nuevo password
		String  sql = "INSERT INTO control_loginpassword(login, password, fecha, estado) "
				+ "  VALUES (:login, :password, current_date, :estado)";
		
		
		try{
			this.namedParameterJdbcTemplate.update(sql, params);
			
			//Actualiza todos los password anteriores como historial y deja el actual como activo
			sql = "UPDATE control_loginpassword SET estado='H' WHERE login = :login AND password!=:password";
			this.namedParameterJdbcTemplate.update(sql, params);
			
		}catch(DuplicateKeyException e){
			logger.debug("Ya existe dado de alta el historial");
			throw new Exception("Ya existe dado de alta el historial");
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}

	}

	/* (non-Javadoc)
	 * @see com.innovargia.administracion.dao.impl.IAdminPasswordDAO#existeLoginPass(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean existeLoginPass(String login, String password) throws Exception {

		String sql="SELECT count(*) FROM  control_loginpassword where login=:login and password=:password AND "
				+ "estado NOT IN ('H')";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("login", login);
		params.addValue("password", password);
		int cantidad = this.namedParameterJdbcTemplate.queryForObject(sql, params,Integer.class);
		
		if (cantidad>0){
			//indica que el login y password ya fueron capturados
			return true;
		}
		//indica que el login y password ya fueron no han capturados
		return false;
	}
	@Override
	public String estadoLoginPass(String login, String password) throws Exception {

		String sql="SELECT estado FROM  control_loginpassword where login=:login and password=:password";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("login", login);
		params.addValue("password", password);
		String estado = null;
		try{
			estado = this.namedParameterJdbcTemplate.queryForObject(sql, params,String.class);
		}catch(Exception e){
			logger.debug("Error:" + e.getMessage());
		}
	
		
		return estado;
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.administracion.dao.impl.IAdminPasswordDAO#cambiaEstatus()
	 */
	@Override
	public void cambiaEstatus()throws Exception {
		//String sql ="select *,DATE_PART('day', current_timestamp - fecha) dias "
		//		+ "from control_loginpassword where DATE_PART('day', current_timestamp - fecha)>60";
		String sql = "update control_loginpassword SET estado='C' where  DATE_PART('day', current_timestamp - fecha)>60";
		int cant = this.jdbcTemplate.update(sql);
	
		logger.debug("Contraseñas caducas ya con mas de 60 dias:" + cant);
		
	}
}