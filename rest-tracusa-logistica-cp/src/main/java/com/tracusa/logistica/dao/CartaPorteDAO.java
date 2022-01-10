package com.tracusa.logistica.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import com.tracusa.logistica.interfaces.dao.ICartaPorteDAO;
import com.tracusa.logistica.model.CartaPorteResumen;
import com.tracusa.logistica.model.DetalleFactura;
import com.tracusa.logistica.model.FacturaCCP;
import com.tracusa.logistica.rowmapper.FacturaCCPRowMapper;

@Repository
public class CartaPorteDAO extends JdbcDaoSupport implements ICartaPorteDAO {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CartaPorteDAO(DataSource dataSource) {

	setDataSource(dataSource);
	this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    @Override
    public int createMarcaFactura(CartaPorteResumen cartaPorteResumen) throws Exception {

	String query = "INSERT INTO ccp_factura (idviaje, fecha, cliente, estatus, referencia) VALUES (:idViaje, NOW()::date, :cliente, :estatus, :referencia)";

	KeyHolder keyHolder = new GeneratedKeyHolder();

	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(cartaPorteResumen);

	logger.debug("Query:" + query);

	try {

	    this.namedParameterJdbcTemplate.update(query, parameterSource, keyHolder, new String[] { "idcontrol" });

	    Number idcontrol = keyHolder.getKey();

	    return idcontrol.intValue();

	} catch (Exception dae) {

	    logger.error("error insert:" + dae.getMessage());

	    throw new Exception(dae.getMessage());

	}

    }

    @Override
    public void marcarGuias(int idControl, String factura, String lstDocumentos) {

	String query;

	if (factura.equals("")) {

	    query = "UPDATE ccp_factura SET estatus = ? WHERE idcontrol = ?";

	    this.jdbcTemplate.update(query, new Object[] { "E", idControl });

	} else {

	    query = "UPDATE ccp_factura SET factura = ?, estatus = ? WHERE idcontrol = ?";

	    this.jdbcTemplate.update(query, new Object[] { factura, "F", idControl });

	    query = "UPDATE cadocumentos SET marcafactura = ?, factura = ? WHERE iddocumento IN (?) ";

	    this.jdbcTemplate.update(query, new Object[] { idControl, factura, lstDocumentos });

	}

    }

    @Override
    public String getClientNumber(String rfc) throws Exception {

	try {

	    String query;

	    query = "SELECT numcliente FROM caclientesrfc WHERE rfc = ?";

	    return this.jdbcTemplate.queryForObject(query, new Object[] { rfc }, String.class);

	} catch (Exception dae) {

	    logger.error("error insert:" + dae.getMessage());

	    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
		    "Error RFC: " + rfc + " not found in BD.");

	}

    }

    @Override
    public String getIdViaje(String NoDocumento) throws Exception {

	try {

	    String query;

	    query = "SELECT idviaje FROM ccp_factura WHERE factura = ?";

	    return this.jdbcTemplate.queryForObject(query, new Object[] { NoDocumento }, String.class);

	} catch (Exception dae) {

	    logger.error("error select:" + dae.getMessage());

	    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
		    "Error Factura: " + NoDocumento + " not found in BD.");

	}

    }

    @Override
    public void updateMarcaFactura(int idControl, String factura, String mensaje) {

	String query;

	query = "UPDATE ccp_factura SET factura = ?, estatus = ?, mensaje = ? WHERE idcontrol = ?";

	this.jdbcTemplate.update(query, new Object[] { factura, factura.equals("") ? "A" : "F", mensaje, idControl });

    }

    @Override
    public List<FacturaCCP> getClientesViaje(String idviaje) throws Exception {

	List<FacturaCCP> lstResult = new ArrayList<>();

	try {

	    String query;

	    query = "SELECT * FROM ccp_factura WHERE idviaje = :idviaje AND estatus != 'F'";

	    //query = "SELECT * FROM ccp_factura WHERE idcontrol = :idviaje";

	    MapSqlParameterSource params = new MapSqlParameterSource();
	    params.addValue("idviaje", Integer.parseInt(idviaje));

	    lstResult = this.namedParameterJdbcTemplate.query(query, params, new FacturaCCPRowMapper());

	    return lstResult;

	} catch (Exception dae) {

	    logger.error("error select:" + dae.getMessage());

	    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
		    "Error Viaje: " + idviaje + " not found in BD.");

	}

    }

    @Override
    public String getReferenciaViaje(String NoDocumento) throws Exception {

	try {

	    String query;

	    query = "SELECT referencia FROM ccp_factura WHERE factura = ?";

	    return this.jdbcTemplate.queryForObject(query, new Object[] { NoDocumento }, String.class);

	} catch (Exception dae) {

	    logger.error("error select:" + dae.getMessage());

	    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
		    "Error Factura: " + NoDocumento + " not found in BD.");

	}

    }

    @Override
    public void timbrarMarcaFactura(DetalleFactura detalleFactura) {

	String query;

	if (!detalleFactura.getPdf().trim().equals("")) {

	    query = "UPDATE ccp_factura SET estatus = ?, mensaje = CONCAT(mensaje , '/' , ?) WHERE factura = ?";

	    this.jdbcTemplate.update(query,
		    new Object[] { "T", detalleFactura.getMensaje(), detalleFactura.getDoc_contable() });

	} else {

	    query = "UPDATE ccp_factura SET mensaje = CONCAT(mensaje , '/' , ?) WHERE factura = ?";

	    this.jdbcTemplate.update(query, new Object[] { detalleFactura.getMensaje(),detalleFactura.getDoc_contable() });

	}

    }
}
