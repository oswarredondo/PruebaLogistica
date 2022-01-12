/**
 * PerfilOpcionUsuarioDAO
 */
package com.innovargia.administracion.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.innovargia.administracion.idao.IPerfilOpcionUsuarioDAO;
import com.innovargia.administracion.rowmapper.PerfilOpcionRowMapper;
import com.innovargia.salesmanager.dtos.PerfilOpcionDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.UtilsStrings;

/**
 * @author Adrian Morales Ruaro
 * 
 */
@Repository
public class PerfilOpcionUsuarioDAO extends JdbcDaoSupport  implements IPerfilOpcionUsuarioDAO {
	private static final Logger logger = LoggerFactory
			.getLogger(PerfilOpcionUsuarioDAO.class);
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public PerfilOpcionUsuarioDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public List<PerfilOpcionDTO> getPerfiles(UsuarioDTO usuario,boolean onlyActive) throws Exception {
		
		String sql = "SELECT * FROM caperfil WHERE identidad=? AND idorganizacion=? "  ;
		if (onlyActive){
			 sql += " AND estatus='A'" ;
		}
		return 	jdbcTemplate.query(sql,new Object[]{usuario.entidad.getIdentidad(),
                   usuario.organizacion.getIdorganizacion()}, new PerfilOpcionRowMapper());

	}
			
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IPerfilOpcionUsuarioDAO#getOpcionesPerfil(java.lang.String, com.innovargia.salesmanager.dtos.UsuarioDTO, boolean, java.lang.String)
	 */
	@Override
	public List<PerfilOpcionDTO> getOpcionesPerfil(String idperfil,
			UsuarioDTO usuario, boolean isSeleccionados, String idsistema) throws Exception {

		String sql = "select * from  viewsistemamoduloopcion where idsistema=? and idopcion";
		if (!isSeleccionados){
			sql +=  "  NOT  ";
		}
		sql += " IN ( select idopcion from caperfilopcion where idPerfil=? AND identidad=? )";
		return 	jdbcTemplate.query(sql,new Object[]{idsistema,idperfil,usuario.entidad.getIdentidad()},
				new PerfilOpcionRowMapper());

	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IPerfilOpcionUsuarioDAO#getPerfilesXNivel(java.lang.String, com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public List<PerfilOpcionDTO> getPerfilesXNivel(String listaniveles,
			UsuarioDTO usuario) throws SQLException {
		
		String sql = "SELECT * FROM  caperfil ";
		if (listaniveles != null) {
			sql += " WHERE identidad=?  " + " AND nivel IN ("
					+ listaniveles + ")";
		}       
		
		return 	jdbcTemplate.query(sql,  
				new Object[]{usuario.entidad.getIdentidad()},new PerfilOpcionRowMapper());
	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IPerfilOpcionUsuarioDAO#getOpcionesPerfilAcceso(com.innovargia.salesmanager.dtos.UsuarioDTO, java.lang.String)
	 */
	@Override
	public PerfilOpcionDTO getOpcionesPerfilAcceso(UsuarioDTO usuario, String idmodulo)
			throws Exception {

		PerfilOpcionDTO perfil = null;
		String sql = "SELECT * FROM (" +
				" SELECT * FROM  causuarios LEFT OUTER JOIN  caPerfilOpcion ON causuarios.idperfil  = caPerfilOpcion.idperfil  " +
				" WHERE causuarios.login=? and causuarios.numcliente=? AND causuarios.identidad=? AND  " +
				" causuarios.idorganizacion=? ) a LEFT OUTER JOIN viewsistemamoduloopcion ON a.idopcion = viewsistemamoduloopcion.idopcion" +
				" WHERE a.idsistema =viewsistemamoduloopcion.idsistema AND a.idmodulo = viewsistemamoduloopcion.idmodulo ";
		
		// Se realiza esto para no modificar los datos ya existentes en el
		// perfil del usuario
		if (usuario.perfil_Dto == null) {
			perfil = new PerfilOpcionDTO();
		} else {
			perfil = usuario.perfil_Dto;
		}

		// Indica el modulo que se desea consultar
		if (idmodulo != null) {
			sql += " AND viewsistemamoduloopcion.idmodulo='" + idmodulo + "'";
		}

		List<PerfilOpcionDTO> lista =  jdbcTemplate.query(sql,  
				new Object[]{usuario.getLogin(),usuario.getNumCliente(),
				usuario.entidad.getIdentidad(), usuario.organizacion.getIdorganizacion()},new PerfilOpcionRowMapper());
		for (PerfilOpcionDTO perfilOpcionDTO : lista) {
			//Agrega el modulo 
			if (!perfil.arr_modulos.contains(perfilOpcionDTO.getIdmodulo())) {
				perfil.arr_modulos.add(perfilOpcionDTO.getIdmodulo());
			}
			//Agrega todos las opciones del perfil del usuario
			perfil.arr_perfiles.add(perfilOpcionDTO);
		}
		
		return perfil;

	}// fin de getOpcionesPerfilAcceso
	

	@Override
	public PerfilOpcionDTO getOpcionesPerfilAccesoWin(UsuarioDTO usuario, String idmodulo)
			throws Exception {

		PerfilOpcionDTO perfil = new PerfilOpcionDTO();

		// Se realiza esto para no modificar los datos ya existentes en el
		// perfil del usuario
		String sql = "SELECT * FROM (" +
				" SELECT * FROM  causuarios LEFT OUTER JOIN  caPerfilOpcion ON causuarios.idperfil  = caPerfilOpcion.idperfil  " +
				" WHERE causuarios.login=? and causuarios.numcliente=? AND causuarios.identidad=? AND  " +
				" causuarios.idorganizacion=? ) a LEFT OUTER JOIN viewsistemamoduloopcion ON a.idopcion = viewsistemamoduloopcion.idopcion" +
				" WHERE a.idsistema =viewsistemamoduloopcion.idsistema AND a.idmodulo = viewsistemamoduloopcion.idmodulo  AND windowid IS NOT NULL ";

		//Indica el modulo que se desea consultar
		if (idmodulo!=null){
			sql+= " AND viewsistemamoduloopcion.idmodulo='" + idmodulo +"' ";
		}
		
		
		List<PerfilOpcionDTO> lista = jdbcTemplate.query(sql,  
				new Object[]{usuario.getLogin(),usuario.getNumCliente(),
				usuario.entidad.getIdentidad(), usuario.organizacion.getIdorganizacion()},new PerfilOpcionRowMapper());
		for (PerfilOpcionDTO perfilOpcionDTO : lista) {
			perfil.arr_perfiles.add(perfilOpcionDTO);
		}
		
		return perfil;
		
	
	}// fin de getOpcionesPerfilAcceso
	
	@Override
	public PerfilOpcionDTO getModulosOpcionesPerfilAccesoWin(UsuarioDTO usuario, String idmodulo)
			throws Exception {

		PerfilOpcionDTO perfil = new PerfilOpcionDTO();

		// Se realiza esto para no modificar los datos ya existentes en el
		// perfil del usuario
		String sql = "SELECT * FROM (" +
				" SELECT * FROM  causuarios LEFT OUTER JOIN  caPerfilOpcion ON causuarios.idperfil  = caPerfilOpcion.idperfil  " +
				" WHERE causuarios.login=? and causuarios.numcliente=? AND causuarios.identidad=? AND  " +
				" causuarios.idorganizacion=? ) a LEFT OUTER JOIN viewsistemamoduloopcion ON a.idopcion = viewsistemamoduloopcion.idopcion" +
				" WHERE a.idsistema =viewsistemamoduloopcion.idsistema AND a.idmodulo = viewsistemamoduloopcion.idmodulo  AND windowid IS NOT NULL ";

		//Indica el modulo que se desea consultar
		if (idmodulo!=null){
			sql+= " AND viewsistemamoduloopcion.idmodulo='" + idmodulo +"' ";
		}
		
		
		List<PerfilOpcionDTO> lista = jdbcTemplate.query(sql,  
				new Object[]{usuario.getLogin(),usuario.getNumCliente(),
				usuario.entidad.getIdentidad(), usuario.organizacion.getIdorganizacion()},new PerfilOpcionRowMapper());
		for (PerfilOpcionDTO perfilOpcionDTO : lista) {
			perfil.arr_perfiles.add(perfilOpcionDTO);
		}
		
		return perfil;
		
	
	}// fin de getOpcionesPerfilAcceso
	
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IPerfilOpcionUsuarioDAO#isOpcionPerfilAcceso(com.innovargia.salesmanager.dtos.UsuarioDTO, java.lang.String)
	 */
	@Override
	public PerfilOpcionDTO isOpcionPerfilAcceso(UsuarioDTO usuario, String idopcion)
			throws Exception {

		PerfilOpcionDTO perfil = new PerfilOpcionDTO();

		// Se realiza esto para no modificar los datos ya existentes en el
		// perfil del usuario
		if (usuario.perfil_Dto == null) {
			perfil = new PerfilOpcionDTO();
		} else {
			perfil = usuario.perfil_Dto;
		}
		String sql = "SELECT * FROM  causuarios LEFT OUTER JOIN "
				+ " caPerfilOpcion ON causuarios.idperfil  = caPerfilOpcion.idperfil "
				+ " WHERE causuarios.login=? and causuarios.numcliente=? AND causuarios.identidad=? AND "
				+ " causuarios.idorganizacion=? AND idopcion=? ";

		List<PerfilOpcionDTO> lista = jdbcTemplate.query(sql,  
				new Object[]{usuario.getLogin(),usuario.getNumCliente(),
				usuario.entidad.getIdentidad(), usuario.organizacion.getIdorganizacion()},new PerfilOpcionRowMapper());
		for (PerfilOpcionDTO perfilOpcionDTO : lista) {
			perfil.arr_modulos.add(perfilOpcionDTO.getIdmodulo());
		}
		
		return perfil;
		
	}// fin de getOpcionesPerfilAcceso

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IPerfilOpcionUsuarioDAO#add(com.innovargia.salesmanager.dtos.PerfilOpcionDTO)
	 */
	@Override
	public void add(PerfilOpcionDTO perfil)	throws Exception {
		
		String sql = "INSERT INTO caperfil(idperfil, descripcion, " +
				"nivel, identidad, idorganizacion, estatus) VALUES (:idperfil, :descripcion_perfil,:nivel, "
				+ ":identidad, :idorganizacion,  'A')";
		
		try{
			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(perfil);
			namedParameterJdbcTemplate.update(sql, parameterSource);
	
		
		}catch(Exception dae){
			logger.error("Error al inserta registro:" + dae.getMessage());
		}
	
	
	}

	@Override
	public void delete(PerfilOpcionDTO perfil)	throws SQLException {
		
		String sql = "DELETE FROM caperfil WHERE consecutivo=?";
		
		try{
			jdbcTemplate.update(sql, new Object[] {
					perfil.getConsecutivo()
			});
		}catch(Exception dae){
			logger.error("Error al borrar registro:" + dae.getMessage());
		}
	
	}

	@Override
	public void updatePerfil(PerfilOpcionDTO perfil)	throws SQLException {
		
		String sql = "UPDATE caperfil SET Descripcion=?, nivel=?  WHERE consecutivo=?";
		
		try{
			jdbcTemplate.update(sql, new Object[] {
					UtilsStrings.nullChangeToUpperCase(perfil.getDescripcion_perfil()),
					UtilsStrings.nullChangeToUpperCase(perfil.getNivel()),
					perfil.getConsecutivo()
			});
	
		
		}catch(Exception dae){
			logger.error("Error al actualizar registro:" + dae.getMessage());
		}
		
		
	}

	@Override
	public void updateEstado(PerfilOpcionDTO perfil)	throws SQLException {
		
		String sql = "UPDATE caperfil SET estatus=? WHERE consecutivo=?";
		
		try{
			jdbcTemplate.update(sql, new Object[] {
					UtilsStrings.nullChangeToUpperCase(perfil.getEstatus()),
					perfil.getConsecutivo()
			});
	
		
		}catch(Exception dae){
			logger.error("Error al actualizar registro:" + dae.getMessage());
		}
	}
	

	@Override
	public void deleteOpcionPerfil(PerfilOpcionDTO perfil) throws SQLException{

		
		String sql = "DELETE FROM caperfilopcion WHERE identidad=? AND idorganizacion=?"
				+ " AND idperfil=? AND idopcion=?";
		
		try{
			jdbcTemplate.update(sql, new Object[]{ perfil.getIdentidad(),
					perfil.getIdorganizacion(),perfil.getIdperfil(),perfil.getIdopcion() });
		}catch(Exception dae){
			logger.error("Error al borrar registro:" + dae.getMessage());
		}
	}

	@Override
	public void addOpcionPerfil(PerfilOpcionDTO perfil) throws SQLException{

		
		String sql = "INSERT INTO caperfilopcion(idsistema, idmodulo, idperfil, " +
				"idopcion, identidad, idorganizacion)VALUES (:idsistema, :idmodulo, "
				+ ":idperfil, :idopcion,:identidad, :idorganizacion);";

		try{
			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(perfil);
			namedParameterJdbcTemplate.update(sql, parameterSource);
	
		
		}catch(Exception dae){
			logger.error("Error al inserta registro:" + dae.getMessage());
		}

	}

}
