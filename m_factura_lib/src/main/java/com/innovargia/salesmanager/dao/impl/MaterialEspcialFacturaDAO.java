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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.administracion.dto.Factura;
import com.administracion.rowmapper.CuentasClienteRowMapper;
import com.innovargia.administracion.dto.LineaFacturaSAP;
import com.innovargia.administracion.dto.MaterialEspecialFactura;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.idao.IFacturaResumenDAO;
import com.innovargia.salesmanager.idao.IMaterialEspcialFacturaDAO;
import com.innovargia.salesmanager.mappers.FacturaResumenRowMapper;
import com.innovargia.salesmanager.mappers.LineaFacturaSAPRowMapper;
import com.innovargia.salesmanager.mappers.MaterialEspecialRowMapper;
import com.innovargia.utils.UtilsStrings;

/**
 * @author aruaro
 * 
 */
@Repository
public class MaterialEspcialFacturaDAO extends JdbcDaoSupport implements IMaterialEspcialFacturaDAO   {

	private static final Logger logger = LoggerFactory
			.getLogger(MaterialEspcialFacturaDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	
	@Autowired
	public MaterialEspcialFacturaDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}



	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IMaterialEspcialFacturaDAO#insert(com.innovargia.administracion.dto.MaterialEspecialFactura)
	 */
	@Override
	public int insert(MaterialEspecialFactura obj) throws Exception {
		String query = "INSERT INTO factura_cobroespecial("
				+ " idmaterial, idcontrol, observacion, cantidad, precio)"
				+ " VALUES (:idmaterial, :idcontrol, :observacion, :cantidad, :precio)";


		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);
		logger.debug("Query:" + query);
		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "idregistro" });
			Number id =  keyHolder.getKey();
			return id.intValue();
		} catch (Exception dae) {
			logger.error("error insert:" + dae.getMessage());
			throw new Exception(dae.getMessage());

		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IMaterialEspcialFacturaDAO#update(com.innovargia.administracion.dto.MaterialEspecialFactura)
	 */
	@Override
	public void update(MaterialEspecialFactura obj) throws Exception {
		
		String query ="UPDATE factura_cobroespecial SET "
				+ " idmaterial=:idmaterial, observacion=:observacion, "
				+ " cantidad=:cantidad, precio=:precio "
				+ " WHERE idregistro=:idregistro";

		logger.debug("Query:" + query);
		try {
			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
					obj);
			
			this.namedParameterJdbcTemplate.update(query,parameterSource);
			
		
		} catch (Exception dae) {
			logger.error("error insert:" + dae.getMessage());
			throw new Exception(dae.getMessage());

		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IMaterialEspcialFacturaDAO#delete(com.innovargia.administracion.dto.MaterialEspecialFactura)
	 */
	@Override
	public void delete(MaterialEspecialFactura obj) throws Exception {
		
		String query ="DELETE FROM factura_cobroespecial "
				+ " WHERE idregistro=:idregistro";

		logger.debug("Query:" + query);
		try {
			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
					obj);
			
			this.namedParameterJdbcTemplate.update(query,parameterSource);
			
		
		} catch (Exception dae) {
			logger.error("error insert:" + dae.getMessage());
			throw new Exception(dae.getMessage());

		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IMaterialEspcialFacturaDAO#deleteAll(com.innovargia.administracion.dto.MaterialEspecialFactura)
	 */
	@Override
	public void deleteAll(MaterialEspecialFactura obj) throws Exception {
		
		String query ="DELETE FROM factura_cobroespecial "
				+ " WHERE idcontrol=:idcontrol";

		logger.debug("Query:" + query);
		try {
			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
					obj);
			
			this.namedParameterJdbcTemplate.update(query,parameterSource);
			
		
		} catch (Exception dae) {
			logger.error("error insert:" + dae.getMessage());
			throw new Exception(dae.getMessage());

		}
		
	}


	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IMaterialEspcialFacturaDAO#getRegistros(com.innovargia.administracion.dto.MaterialEspecialFactura)
	 */
	@Override
	public List<MaterialEspecialFactura> getRegistros(MaterialEspecialFactura obj) throws Exception {
		List<MaterialEspecialFactura> lista = new ArrayList<MaterialEspecialFactura>();
		
		String sql = "select factura_cobroespecial.*, sapmaterial_especial.nombre "
				+ " FROM factura_cobroespecial JOIN   sapmaterial_especial "
				+ " ON factura_cobroespecial.idmaterial= sapmaterial_especial.idmaterial "
				+ " WHERE idcontrol=:idcontrol";
			 
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);
		lista =  namedParameterJdbcTemplate.query(sql,parameterSource,new MaterialEspecialRowMapper());
		return lista;
		
	}
	
	@Override
	public List<MaterialEspecialFactura> getRegistrosNoIncluidos(MaterialEspecialFactura obj) throws Exception {
		List<MaterialEspecialFactura> lista = new ArrayList<MaterialEspecialFactura>();
		
		String sql = "select * from sapmaterial_especial where idmaterial NOT"
				+ " IN ( SELECT idmaterial from factura_cobroespecial where idcontrol=:idcontrol)";
			 
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);
		lista =  namedParameterJdbcTemplate.query(sql,parameterSource,new MaterialEspecialRowMapper());
		return lista;
		
	}
	
	
	
	
	
}
