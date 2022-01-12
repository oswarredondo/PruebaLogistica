package com.administracion.dao;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.administracion.dto.CartaFacturaDetalle;
import com.administracion.idao.ICartaPorteDAO;


@Repository
public class CartaPorteDAO extends JdbcDaoSupport implements ICartaPorteDAO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(CartaPorteDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	//private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CartaPorteDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		//this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.servicios.etiquetas.bo.ICartaPorteBO#insertCartaFacturaDocumento(com.administracion.dto.CartaFacturaDetalle)
	 */
	@Override
	public void insertCartaFacturaDocumento(CartaFacturaDetalle obj)
		throws Exception {
	    
	    
	    String query = "INSERT INTO cadocumentos_cartafactura("
	    	+ "  fechainsercion, iddocumento, idguiacarrier, shipmentid,factura, "
	    	+ " numcompra, terminosventa, razonexportacion, taxid_vat, nombrecontacto, "
	    	+ " callecontacto, coloniacontacto, cpcontacto, ciudadcontacto, paiscontacto, "
	    	+ " telefonocontacto, declaracion, instrucciones_especiales, celularcontacto, "
	    	+ "  emailcontacto) VALUES "
	    	+ " (current_timestamp, :iddocumento, :idguiacarrier, :shipmentid,  :factura, "
	    	+ " :numcompra, :terminosventa, :razonexportacion, :taxid_vat, :nombrecontacto, "
	    	+ " :callecontacto, :coloniacontacto, :cpcontacto, :ciudadcontacto, :paiscontacto, "
	    	+ " :telefonocontacto, :declaracion, :instrucciones_especiales, :celularcontacto, "
	    	+ "  :emailcontacto)";

		    
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en insertCartaFacturaDocumento: " + dae.getMessage());
		}

	}


	/* (non-Javadoc)
	 * @see com.innovargia.servicios.etiquetas.bo.ICartaPorteBO#insertCartaFacturaDetalleDocumento(com.administracion.dto.CartaFacturaDetalle)
	 */
	@Override
	public void insertCartaFacturaDetalleDocumento(CartaFacturaDetalle obj)
		throws Exception {
	    
	    
	      String query = "INSERT INTO cadocumentos_cartafactura_detalle("
	      		+ "iddocumento, cantidad, unidad_medida, descripcion, "
	      		+ "harm_codigo, c_o, valor_unitario, valor_total, fechacreacion, "
	      		+ "peso, tipo_mercancia, descripcion_mercancia, voumen, paqueteid)"
	      		+ " VALUES ( :iddocumento, :cantidad, :unidad_medida, :descripcion, "
	      		+ " :harm_codigo, :c_o, :valor_unitario, :valor_total, current_timestamp, "
	      		+ " :peso, :tipo_mercancia, :descripcion_mercancia, :voumen, :paqueteid)";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en insertCartaFacturaDetalleDocumento: " + dae.getMessage());
		}

	}

}
