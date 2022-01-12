package com.innovargia.salesmanager.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import com.innovargia.mail.EmailProperties;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.MetaDatoCatalogoDTO;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.salesmanager.idao.IParametrosSistemaDAO;
import com.innovargia.salesmanager.mappers.CatalogoRowMapper;
import com.innovargia.salesmanager.mappers.MetaDatoCatalogoRowMapper;
import com.innovargia.salesmanager.mappers.SistemaRowMapper;

@Repository
public class ParametrosSistemaDAO extends JdbcDaoSupport implements
		IParametrosSistemaDAO {
	

	final String sql_ = "SELECT identificador,idadicional AS clave,descripcion,estatus,precio FROM caadicional";

	private static final Logger logger = LoggerFactory
			.getLogger(ParametrosSistemaDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ParametrosSistemaDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public String getValorPropiedad(String idparametro, String idsistema)
			throws Exception {
		String sql = "SELECT IdPropertie, IdSistema,Valor FROM catPropertieSystem "
				+ " WHERE IdSistema='"	+ idsistema	+ "' AND IdPropertie='" + idparametro + "'";
		
		List<SistemaDTO> lista = new ArrayList<SistemaDTO>();
		
		try {
			lista = jdbcTemplate.query(sql,new SistemaRowMapper());
			if (lista.size()>0){
				SistemaDTO objeto =  lista.get(0);
				return objeto.getValor();
			}

		} catch (Exception e) {
			logger.error("Error :" + e.getMessage());
		
		}
		
		return null;
	}
	@Override
	public String getValorPropiedad(String idparametro,List<SistemaDTO> lista)
		throws Exception {
	    
	    if ((lista==null) || (lista.size()<=0)){
		return "";
	    }
	    for (SistemaDTO sistemaDTO : lista) {
		if (idparametro.equals(sistemaDTO.getIdpropertie())){
		    return sistemaDTO.getValor();
		}
		
	    }

	    return "";

	}
	@Override
	public int getValorPropiedadInt(String idparametro,List<SistemaDTO> lista)
		throws Exception {
	    
	    if ((lista==null) || (lista.size()<=0)){
		return -1;
	    }
	    for (SistemaDTO sistemaDTO : lista) {
		if (idparametro.equals(sistemaDTO.getIdpropertie())){
		    return Integer.parseInt(sistemaDTO.getValor());
		}
		
	    }

	    return -1;

	}
	
	
	@Override
	public int getValorPropiedadInt(String idparametro, String idsistema)
			throws Exception {
		String sql = "SELECT IdPropertie, IdSistema,Valor FROM catPropertieSystem "
				+ " WHERE IdSistema='"	+ idsistema	+ "' AND IdPropertie='" + idparametro + "'";
		
		List<SistemaDTO> lista = new ArrayList<SistemaDTO>();
		
		try {
			lista = jdbcTemplate.query(sql,new SistemaRowMapper());
			if (lista.size()>0){
				SistemaDTO objeto =  lista.get(0);
				
				return Integer.parseInt(objeto.getValor());
			}

		} catch (Exception e) {
			logger.error("Error :" + e.getMessage());
		
		}
		
		return -1;
	}

	@Override
	public SistemaDTO getPathsSistema(String idSistema, String numCliente)
			throws Exception {

		String sql = "SELECT DISTINCT * FROM catPathGenerales  "
				+ " WHERE IdSistema='" + idSistema + "'";

		List<SistemaDTO> lista = new ArrayList<SistemaDTO>();
		try {
			lista = jdbcTemplate.query(sql,new SistemaRowMapper());
			if (lista.size()>0){
				return lista.get(0);
			}
		} catch (Exception e) {
			logger.error("Error :" + e.getMessage());
			
		}
		return null;

	}
	
	
	@Override
	public  MetaDatoCatalogoDTO getDatosTipoDoc(String id, int identidad, int organizacion)
			throws Exception {
        String sql = "SELECT * FROM caTipoDocumento WHERE IdTipoDocumento = '" +id + "' AND identidad="+identidad;
 		
		List<MetaDatoCatalogoDTO> lista = new ArrayList<MetaDatoCatalogoDTO>();
		try {
			lista = jdbcTemplate.query(sql,new MetaDatoCatalogoRowMapper());
			if (lista.size()>0){
				return lista.get(0);
			}
		} catch (Exception e) {
			logger.error("Error :" + e.getMessage());
			
		}
		return null;

	}
	
	@Override
	public EmailProperties getPropiedadesEmail(EmailProperties propiedades,String sistema) throws SQLException {
		//Verifica si se mando un objeto nulo para poder crear uno nuevo
		if (propiedades==null){
			propiedades = new EmailProperties();
		}
		String sql = "SELECT idpropertie,valor FROM catPropertieSystem WHERE IdSistema='" +sistema+"'";
		List<Map<String,Object>> results = jdbcTemplate.queryForList(sql);
		for (Map m : results){
			propiedades.setPropiedad( m.get("idpropertie")+"",  m.get("valor")+"");
		} 
	
		return propiedades;

	}// Fin de getPropiedadesEmail

	@Override
	public void insert(SistemaDTO catalogo) throws Exception {
		String query = "INSERT INTO  catpropertiesystem (idsistema,idpropertie,valor)  VALUES " +
			       "(:idSistema,:idpropertie,:valor)";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	@Override
	public void update(SistemaDTO catalogo) throws Exception {
		String query = "UPDATE catpropertiesystem SET valor= :valor  WHERE " +
			       " idsistema = :idSistema AND idpropertie=:idpropertie";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	@Override
	public void delete(SistemaDTO catalogo) throws Exception {
		String query = "DELETE FROM  catpropertiesystem  WHERE " +
			       " idsistema = :idSistema AND idpropertie=:idpropertie";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	@Override
	public List<SistemaDTO> getRegistros( String idsistema)
			throws Exception {
		List<SistemaDTO> lista = new ArrayList<SistemaDTO>();
		String sql = "SELECT * FROM catpropertiesystem ORDER BY idsistema,idpropertie";
				
		lista = jdbcTemplate.query(sql,new SistemaRowMapper());
		return lista;
	}
	

}
