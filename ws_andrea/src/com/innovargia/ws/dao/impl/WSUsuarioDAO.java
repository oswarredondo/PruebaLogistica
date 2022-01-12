/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovargia.ws.dao.impl;

import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.ws.dto.rowmapper.WSUsuarioRowMapper;
import java.util.ArrayList;
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
import com.innovargia.ws.idao.IWSUsuarioDAO;

/**
 *
 * @author aruaro
 */
@Repository
public class WSUsuarioDAO extends JdbcDaoSupport implements IWSUsuarioDAO {

    private static final Logger logger = LoggerFactory
            .getLogger(WSUsuarioDAO.class);

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public WSUsuarioDAO(DataSource dataSource) {
        setDataSource(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
                dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<UsuarioDTO> getUsuariosConLogin(UsuarioDTO usuario) throws Exception {

        List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
        String sql = "SELECT * FROM causuarios WHERE login=:login";
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(usuario);

        lista = namedParameterJdbcTemplate.query(sql, parameterSource, new WSUsuarioRowMapper());
        return lista;
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
	        "					 Login='"  + usuario.getLogin() + "' AND Password IN ('" +  usuario.getPassword() + "','" + usuario.getPsha1() + "') "+
	        "				) a LEFT OUTER JOIN caentidadformatoeti b ON a.identidad = b.identidad AND  a.formatoetimedia= b.formatoetiqueta" +
	        "			) c LEFT OUTER JOIN  caentidadformatoeti d ON c.identidad = d.identidad AND  c.formatoetiperso= d.formatoetiqueta 	" +
	        ")usuario LEFT OUTER JOIN canivelusuario ON usuario.nivelpuesto = canivelusuario.idnivelusuario";
		  
		try {
			usuario_db =   this.jdbcTemplate
					.queryForObject(sql, new WSUsuarioRowMapper());
			//Obtiene los datos del cliente al que pertenece el usuario
			//TODO: Esto debe ser en el BO
			//obj.setClienteUsuario(cliente.getDatosCliente( user ));
		} catch (Exception dae) {
			logger.error("Error getUsuarioLogin:" + dae.getMessage());
			return null;
		}
		return usuario_db;
	}

}
