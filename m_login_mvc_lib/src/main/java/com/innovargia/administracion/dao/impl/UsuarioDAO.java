package com.innovargia.administracion.dao.impl;

import java.sql.SQLException;
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
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.innovargia.administracion.idao.IUsuarioDAO;
import com.innovargia.administracion.rowmapper.AgrupamientoRowMapper;
import com.innovargia.administracion.rowmapper.UsuarioCuentaRowMapper;
import com.innovargia.administracion.rowmapper.UsuarioRowMapper;
import com.innovargia.salesmanager.dtos.AgrupamientoDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.UsuarioCuentaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.constantes.CondicionNivelPerfil;

@Repository
public class UsuarioDAO extends JdbcDaoSupport implements IUsuarioDAO {

	final String sql_ = "SELECT * FROM caUsuarios ";

	private static final Logger logger = LoggerFactory
			.getLogger(UsuarioDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public UsuarioDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}




	@Override
	public List<UsuarioDTO> getRegistros(UsuarioDTO usuario) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<UsuarioCuentaDTO> getRegistrosCuentaCliente(BusquedaDTO busqueda) throws Exception {
		List<UsuarioCuentaDTO> lista = new ArrayList<UsuarioCuentaDTO>();
		String sql = sql_ + " WHERE identidad=? AND idorganizacion=? AND numcliente=?";

		lista = jdbcTemplate.query(sql,new Object[]{busqueda.getIdentidad(),busqueda.getIdorganizacion(),busqueda.getNumcliente()}, new UsuarioCuentaRowMapper());
		return lista;

	}

	
	
	@Override
	public UsuarioDTO get(UsuarioCuentaDTO usuario) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTO getUsuarioLogin(UsuarioDTO usuario) throws Exception {

		UsuarioDTO usuario_db =null;
		String sql =  "SELECT usuario.*, canivelusuario.descripcion as descripcionpuesto FROM ("+
				"SELECT  c.*,d.nombrearchivo as archivoperso FROM (" +
	        "				SELECT a.*,b.nombrearchivo as archivomedia FROM (" +
	        "				   SELECT DISTINCT causuarios.identidad,causuarios.idorganizacion, " +
	        "					 causuarios.numcliente,causuarios.nombre," +
	        "					 causuarios.login,causuarios.password, " +
	        "					 causuarios.logo,causuarios.estatus,caperfil.descripcion, caperfil.nivel, " +
	        "					 causuarios.idoficina,causuarios.numempleado,causuarios.siglasplaza ," +
	        "					 causuarios.formatoetimedia, causuarios.formatoetiperso,causuarios.nivelpuesto,"
	        + " causuarios.wallpaper,causuarios.wallpaperstretch,idagrupamiento,visibilidad " +
	        "					 FROM causuarios, caperfil where causuarios.idperfil = caperfil.idperfil AND  " +
//	        "					 Login='"  + usuario.getLogin() + "' AND Password IN ('" +  usuario.getPassword() + "','" + usuario.getPsha1() + "') "+
"					 Login=? " + (usuario.getEstatus()==90000?" AND Password IN (?,?) ":
    	"")+
	        "				) a LEFT OUTER JOIN caentidadformatoeti b ON a.identidad = b.identidad AND  a.formatoetimedia= b.formatoetiqueta" +
	        "			) c LEFT OUTER JOIN  caentidadformatoeti d ON c.identidad = d.identidad AND  c.formatoetiperso= d.formatoetiqueta 	" +
	        ")usuario LEFT OUTER JOIN canivelusuario ON usuario.nivelpuesto = canivelusuario.idnivelusuario";
		  
		try {
			Object[] arr_params = new Object[]{ usuario.getLogin()};
			if (usuario.getEstatus()==90000){
				arr_params = new Object[]{ usuario.getLogin(),usuario.getPassword(),usuario.getPsha1()};
			}else{
				
			}
					
			usuario_db =   this.jdbcTemplate
					.queryForObject(sql,arr_params, new UsuarioRowMapper());

		} catch (Exception dae) {
			logger.error("Error getUsuarioLogin:" + dae.getMessage());
			return null;
		}
		return usuario_db;
	}
	
	@Override
	public UsuarioDTO getUsuarioDeCliente(UsuarioDTO usuario) throws Exception {

		UsuarioDTO usuario_db =null;
		String sql =  "SELECT usuario.*, canivelusuario.descripcion as descripcionpuesto FROM ("+
				"SELECT  c.*,d.nombrearchivo as archivoperso FROM (" +
	        "				SELECT a.*,b.nombrearchivo as archivomedia FROM (" +
	        "				   SELECT DISTINCT causuarios.identidad,causuarios.idorganizacion, " +
	        "					 causuarios.numcliente,causuarios.nombre," +
	        "					 causuarios.login,causuarios.password, " +
	        "					 causuarios.logo,causuarios.estatus,caperfil.descripcion, caperfil.nivel, " +
	        "					 causuarios.idoficina,causuarios.numempleado,causuarios.siglasplaza ," +
	        "					 causuarios.formatoetimedia, causuarios.formatoetiperso,causuarios.nivelpuesto,"
	        + " causuarios.wallpaper,causuarios.wallpaperstretch,idagrupamiento,visibilidad " +
	        "					 FROM causuarios, caperfil where causuarios.idperfil = caperfil.idperfil AND  " +
	        "					 Login=? AND numcliente= ? "+
	        "				) a LEFT OUTER JOIN caentidadformatoeti b ON a.identidad = b.identidad AND  a.formatoetimedia= b.formatoetiqueta" +
	        "			) c LEFT OUTER JOIN  caentidadformatoeti d ON c.identidad = d.identidad AND  c.formatoetiperso= d.formatoetiqueta 	" +
	        ")usuario LEFT OUTER JOIN canivelusuario ON usuario.nivelpuesto = canivelusuario.idnivelusuario";
		  
		try {
			usuario_db =   this.jdbcTemplate
					.queryForObject(sql, new Object[] {usuario.getLogin(), usuario.getNumCliente()}, new UsuarioRowMapper());

		} catch (Exception dae) {
			logger.error("Error getUsuarioLogin:" + dae.getMessage());
			return null;
		}
		return usuario_db;
	}

	/**
	 * Actualiza la contrase�a de acceso del usuario, para restringirle el
	 * acceso, la contrase�a ya debe venir codificada
	 * 
	 * @return la cantidad de registros afectados
	 */
	@Override
	public void updatePassword(UsuarioDTO user) throws Exception {
		String sql = "UPDATE causuarios SET Password=? WHERE NumCliente=? AND Login=? ";

		try {
			jdbcTemplate.update(sql, new Object[] {
					user.getPassword(), user.getNumCliente(),
					user.getLogin() });

		} catch (Exception dae) {
			logger.error("Error al actualizar registro:" + dae.getMessage());
		}

	}// fin de updateEstado
	

	@Override
	public void updateWallPaper(UsuarioDTO user) throws Exception {
		String sql = "UPDATE causuarios SET wallpaper=? WHERE NumCliente=? AND Login=? ";

		try {
			jdbcTemplate.update(sql, new Object[] {
					user.getWallpaper(), user.getNumCliente(),
					user.getLogin() });

		} catch (Exception dae) {
			logger.error("Error al actualizar registro:" + dae.getMessage());
		}

	}// fin de updateEstado

	@Override
	public List<UsuarioDTO> getUsuariosConNivel(UsuarioDTO usuario)
			throws Exception {
		List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
		String sql = "SELECT * FROM causuarios where nivelpuesto=:nivelpuesto";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuario);
		lista = namedParameterJdbcTemplate.query(sql,parameterSource,new UsuarioRowMapper());
		return lista;
	}

	@Override
	public List<UsuarioDTO> getUsuariosConGrupo(UsuarioDTO usuario)
			throws Exception {
		List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
		String sql = "SELECT * FROM causuarios where idagrupamiento=:idagrupamiento";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuario);
		lista = namedParameterJdbcTemplate.query(sql,parameterSource,new UsuarioRowMapper());
		return lista;
	}

	@Override
	public List<UsuarioDTO> getTodosLosUsuarios(boolean soloActivos) throws Exception {
		
		List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
		String sql = "SELECT * FROM causuarios";
		if (soloActivos){
			sql+= " WHERE estatus='A'";
		}

		lista = namedParameterJdbcTemplate.query(sql,new UsuarioRowMapper());
		return lista;

	}

	@Override
	public List<UsuarioDTO>   getUsuariosConLogin(UsuarioDTO usuario) throws Exception {
		
		List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
		String sql = "SELECT * FROM causuarios WHERE login=:login";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuario);
		
		lista = namedParameterJdbcTemplate.query(sql,parameterSource,new UsuarioRowMapper());
		return lista;

	}
	@Override
	public List<UsuarioDTO>   getUsuariosDeUnAgrupamiento(UsuarioDTO usuario) throws Exception {
		
		List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
		String sql = "SELECT distinct login,nombre FROM viewagrupacionusuarios WHERE idagrupamiento IN ("
				+ "		SELECT idagrupamiento FROM viewagrupacionusuarios   WHERE login=:login "
				+ "		) ORDER BY login";
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuario);
		
		
		
		lista = namedParameterJdbcTemplate.query(sql,parameterSource,new UsuarioRowMapper());
		if (lista.size()<=0){
		    logger.error("getUsuariosDeUnAgrupamiento: No existen grupos asociados al usuario "+usuario.getLogin());
		}
		return lista;

	}
	@Override
	public List<UsuarioDTO>   getUsuariosDeUnAgrupamientoYNivel(UsuarioDTO usuario) throws Exception {
		
		List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
		//Todos los usuarios del agrupamiento
		String sql = "SELECT distinct * FROM viewagrupacionusuarios WHERE idagrupamiento IN ("
				+ "		SELECT idagrupamiento FROM viewagrupacionusuarios   WHERE login=:login "
				+ "	) ";

		if (usuario.getVisibilidad() == 0) {
			sql +=   " AND  login=:login  ";
		}else{
			//Puede ver toda la info de su nivel para abajo
			sql +=   " AND nivelpuesto>= :nivelPuesto";
		}

		if (CondicionNivelPerfil.condicionNivelUsuario(usuario) != null){
			sql += " AND " +CondicionNivelPerfil.condicionNivelUsuario(usuario);
		}else{
			logger.debug("No existe NIvel del perfil del usuario");
			return lista;    
		}
		
		//Checa el ambito del perfil
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuario);
		lista = namedParameterJdbcTemplate.query(sql,parameterSource,new UsuarioRowMapper());
		
		if (lista.size()<=0){
		    logger.error("getUsuariosDeUnAgrupamientoYNivel: No existen grupos asociados al usuario "+usuario.getLogin());
		}
		return lista;

	}
	
	
	
	
	@Override
	public List<AgrupamientoDTO> getAgrupaciones(UsuarioDTO usuario) throws Exception {
		
		List<AgrupamientoDTO> lista = new ArrayList<AgrupamientoDTO>();
		String sql = ""
				+ "select caagrupamientousuario.idagrupamiento,caagrupamientousuario.login as idrelacion,"
				+ "caagrupadorjerarquias.descripcion,caagrupadorjerarquias.visualizatodo"
				+ " from caagrupamientousuario LEFT OUTER JOIN caagrupadorjerarquias"
				+ " ON caagrupamientousuario.idagrupamiento=caagrupadorjerarquias.idagrupamiento "
				+ " WHERE caagrupamientousuario.login=:login";
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuario);
		
		lista = namedParameterJdbcTemplate.query(sql,parameterSource,new AgrupamientoRowMapper());
		
		if (lista.size()<=0){
		    logger.error("getAgrupaciones: No existen grupos asociados al usuario "+usuario.getLogin());
		}
		return lista;

	}

	@Override
	public void insertAgrupamiento(AgrupamientoDTO obj) throws Exception {
		String query = "INSERT INTO caagrupamientousuario(idagrupamiento, login) VALUES(:idagrupamiento,:idrelacion)";
	
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
			
			//return keyHolder.getKey();
		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
		}
		
	}

	@Override
	public void deleteAgrupamiento(AgrupamientoDTO obj) throws Exception {
		String query = "DELETE FROM caagrupamientousuario WHERE idagrupamiento=:idagrupamiento AND login=:idrelacion ";

		try {
			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
			
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("Error al actualizar registro:" + dae.getMessage());
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IOrganizacionDAO#getEntidadOrganizacion(com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public void getEntidadOrganizacion(UsuarioDTO user) throws SQLException {


		String sql = " SELECT caEntidad.identidad,caOrganizacion.idorganizacion,caEntidad.Descripcion AS DescEntidad,caEntidad.Estatus as EstatusEntidad, "
				+ " caOrganizacion.Descripcion as DescOrganiza,caOrganizacion.Estatus AS EstatusOrganiza, "
				+ " caOrganizacion.logo AS LogoOrganiza,caCuenta.razonsocial,caCuenta.Estatus AS EstatusCuenta,"
				+ " caCuenta.vertodasdirecciones, caCuenta.cp  FROM caEntidad, caOrganizacion,caCuenta "
				+ " WHERE caEntidad.identidad = caOrganizacion.identidad AND caEntidad.identidad = caCuenta.identidad AND "
				+ " caOrganizacion.identidad = caCuenta.identidad AND caOrganizacion.idorganizacion= caCuenta.idorganizacion AND "
				+ " caEntidad.identidad=? and caOrganizacion.idorganizacion=? AND caCuenta.numcliente=?";

		List<UsuarioDTO>  lista  = jdbcTemplate.query(sql,new Object[]{
					user.entidad.getIdentidad(),
					user.organizacion.getIdorganizacion(),
					user.getNumCliente()}, 
				new UsuarioRowMapper());
		
		//Verifica si existe el registro 
		if (lista.size()>0){
			user.cuenta = lista.get(0).cuenta;
			user.cuenta.setNumCliente(user.getNumCliente());
			user.organizacion = lista.get(0).organizacion;
			user.entidad = lista.get(0).entidad;
		}
		
	
	}// fin de getClientesRemDes




	@Override
	public String getRfc(UsuarioDTO usuario) throws Exception {
		
		String sql = "SELECT rfc FROM caclientesrfc  WHERE numcliente='"+usuario.getNumCliente()+"'";
	
		return jdbcTemplate.queryForObject(sql, String.class);
	}
}
