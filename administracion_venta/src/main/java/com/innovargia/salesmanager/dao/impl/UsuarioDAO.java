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

import com.innovargia.salesmanager.dtos.AgrupamientoDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.UsuarioCuentaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.idao.IUsuarioDAO;
import com.innovargia.salesmanager.mappers.AgrupamientoRowMapper;
import com.innovargia.salesmanager.mappers.UsuarioCuentaRowMapper;
import com.innovargia.salesmanager.mappers.UsuarioRowMapper;
import com.innovargia.utils.UtilsStringFechas;

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
	public void insert(UsuarioCuentaDTO usuario) throws Exception {
		String query = "INSERT INTO causuarios(identidad, idorganizacion,"
				+ " numcliente, idperfil, nombre, login, password, logo, estatus, "
				+ "idoficina, numempleado, siglasplaza,formatoetimedia, formatoetiperso,"
				+ " nivelpuesto, wallpaper, wallpaperstretch, email,idagrupamiento, visibilidad) "
				+ " VALUES (:identidad, :idorganizacion,"
				+ " :numcliente, :idperfil, :nombre, :login, :password, :logo, 'A', "
				+ ":idoficina, :numempleado, :siglasplaza,:formatoetimedia, :formatoetiperso,"
				+ " :nivelpuesto, '', 0, :email,:idagrupamiento, :visibilidad)";
	
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				usuario);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "consecutivo" });
			
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
	public void update(UsuarioCuentaDTO usuario) throws Exception {

		String sql = "UPDATE causuarios SET  idperfil='" + usuario.getIdperfil()+"',"
				+ " nombre='" +  UtilsStringFechas.convierteCadenaTrimNULL(usuario.getNombre())+ 
				"', login='" +UtilsStringFechas.convierteCadenaTrimNULL(usuario.getLogin())+ "',"
						+ " idoficina='" +  usuario.getIdoficina()+
						"', numempleado='" +  UtilsStringFechas.convierteCadenaTrimNULL(usuario.getNumempleado())+ "',"
				+ " siglasplaza='" +  UtilsStringFechas.convierteCadenaTrimNULL(usuario.getSiglasplaza())+
				"',formatoetimedia='" +  UtilsStringFechas.convierteCadenaTrimNULL(usuario.getFormatoetimedia())+ "', "
				+ " formatoetiperso='" +  UtilsStringFechas.convierteCadenaTrimNULL(usuario.getFormatoetiperso())+
				"',nivelpuesto=" +  usuario.getNivelpuesto()+
				",email='" +  usuario.getEmail()+"'" +
				",idagrupamiento=" +  usuario.getIdagrupamiento()+
				",visibilidad="+  usuario.getVisibilidad() +
				" WHERE consecutivo="+ usuario.getConsecutivo();

		try {
			
			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuario);
			
			jdbcTemplate.update(sql);

		} catch (Exception dae) {
			logger.error("Error al actualizar registro:" + dae.getMessage());
		}

	}

	@Override
	public void updateEstatus(UsuarioCuentaDTO usuario) throws Exception {
		String sql = "UPDATE causuarios SET  estatus='" + usuario.getEstatus() + "'"
				+ " WHERE consecutivo="+ usuario.getConsecutivo();

		try {
			
			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
					usuario);
			
			jdbcTemplate.update(sql);

		} catch (Exception dae) {
			logger.error("Error al actualizar registro:" + dae.getMessage());
		}

	}

	@Override
	public void delete(UsuarioCuentaDTO usuario) throws Exception {
		String sql = "DELETE FROM causuarios WHERE consecutivo=:consecutivo";

		try {
			
			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
					usuario);
			
			jdbcTemplate.update(sql,parameterSource);

		} catch (Exception dae) {
			logger.error("Error al actualizar registro:" + dae.getMessage());
		}

	}

	@Override
	public List<UsuarioDTO> getRegistros(UsuarioDTO usuario) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<UsuarioCuentaDTO> getRegistrosCuentaCliente(BusquedaDTO busqueda) throws Exception {
		List<UsuarioCuentaDTO> lista = new ArrayList<UsuarioCuentaDTO>();
		String sql = sql_ + " WHERE identidad="+ busqueda.getIdentidad() + " AND idorganizacion=" +
		busqueda.getIdorganizacion() + " AND numcliente='" + busqueda.getNumcliente() +"'";

		lista = jdbcTemplate.query(sql,new UsuarioCuentaRowMapper());
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
	        "					 Login='"  + usuario.getLogin() +"' " + (usuario.getEstatus()==90000?" AND Password IN ('" +  usuario.getPassword() + "','" + usuario.getPsha1() + "') ":
	        	"")+
	       // "					 Login='"  + usuario.getLogin() + "' " +
	        "				) a LEFT OUTER JOIN caentidadformatoeti b ON a.identidad = b.identidad AND  a.formatoetimedia= b.formatoetiqueta" +
	        "			) c LEFT OUTER JOIN  caentidadformatoeti d ON c.identidad = d.identidad AND  c.formatoetiperso= d.formatoetiqueta 	" +
	        ")usuario LEFT OUTER JOIN canivelusuario ON usuario.nivelpuesto = canivelusuario.idnivelusuario LIMIT 1";
		  
		try {
			usuario_db =   this.jdbcTemplate
					.queryForObject(sql, new UsuarioRowMapper());

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
		String sql = "SELECT * FROM causuarios where nivelpuesto=:nivelPuesto";
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
		if (usuario.getSeleccionado()>0){
		    //Trae todos los registros de usuarios con el login indicando 
		    //y diferentes al consecutivo seleccionado
		    sql+= " AND consecutivo!=" +usuario.getSeleccionado();
		}
		
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
	public void insertConvenioUsuario(UsuarioCuentaDTO usuario, int idconvenio) throws Exception {
		String query = "INSERT INTO "
			+ "opusuarios_convenios(identidad, idorganizacion,"
			+ "numcliente,login,idconvenio) "
			+ "VALUES(" + usuario.getIdentidad()+", " +
			usuario.getIdorganizacion()+ ",'" + usuario.getNumcliente()
			+ "','"  + usuario.getLogin() + "'," + idconvenio+")";
	

		try {
			this.jdbcTemplate.update(query);

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
}
