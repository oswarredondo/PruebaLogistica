package com.servicio.search.dao;

import java.sql.SQLException;
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
import org.springframework.stereotype.Repository;

import com.administracion.rowmapper.CruceCoberturaRowMapper;
import com.administracion.rowmapper.OficinasReceptorasRowMapper;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.servicio.dtos.OficinasDTO;
import com.servicio.search.idao.IBusquedaOficinasReceptorasDao;

/**
 * <CODE>
 * Manejo de los datos de Códigos Postales
 * </CODE>
 * 
 * @author Adrian Morales Ruaro
 * @version $Id: $
 */
@Repository
public class BusquedaOficinasReceptorasDao extends JdbcDaoSupport implements
	IBusquedaOficinasReceptorasDao {

    private static final Logger logger = LoggerFactory
	    .getLogger(BusquedaOficinasReceptorasDao.class);

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BusquedaOficinasReceptorasDao(DataSource dataSource) {
	setDataSource(dataSource);
	this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
		dataSource);
	this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.servicio.search.dao.ICarteraDireccionesRemDesDao#getDirecconesRemDes
     * (com.innovargia.salesmanager.dtos.BusquedaDTO)
     */
    @Override
    public List<OficinasDTO> getOficinasReceptoras(BusquedaDTO busqueda)
	    throws SQLException {

	List<OficinasDTO> lista = new ArrayList<OficinasDTO>();
	String sql = "SELECT * FROM caoficinas ";

	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
		busqueda);

	lista = this.namedParameterJdbcTemplate.query(sql, parameterSource,
		new OficinasReceptorasRowMapper());
	return lista;
    }
    
    @Override
    public OficinasDTO getOficinaReceptora(BusquedaDTO busqueda)
	    throws SQLException {

	List<OficinasDTO> lista = new ArrayList<OficinasDTO>();
	String sql = "SELECT distinct * FROM caoficinas where idoficina =:identificador_str" ;

	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
		busqueda);

	lista = this.namedParameterJdbcTemplate.query(sql, parameterSource,
		new OficinasReceptorasRowMapper());
	
	if (lista.size()>0){
	    return lista.get(0);
	}
	return null;
    }
    /*
     * (non-Javadoc)
     * 
     * @see
     * com.servicio.search.dao.ICarteraDireccionesRemDesDao#getDirecconesRemDes
     * (com.innovargia.salesmanager.dtos.BusquedaDTO) Solo oficinas activas que
     * sean de tipo PDV and que esten asignadas al usuario y que la caja no sea
     * null
     */
    @Override
    public List<OficinasDTO> getOficinasReceptorasPDVCaja(BusquedaDTO busqueda)
	    throws SQLException {

	List<OficinasDTO> lista = new ArrayList<OficinasDTO>();
	String sql = "select caoficinas.*,pdv_caja.idcaja,"
		+ " pdv_caja.descripcion,pdv_caja.estatus, pdv_caja.fechaapertura,"
		+ "pdv_caja.login,pdv_caja.fechacierre,pdv_caja.logincierre"
		+ " from caoficinas LEFT OUTER join pdv_caja on "
		+ "caoficinas.idoficina = pdv_caja.idoficina where"
		+ " caoficinas.estatus!='B' AND "
		+ " caoficinas.tipooficina=1 AND "
		+ " pdv_caja.idoficina IN ( "
		+ "	SELECT idoficina FROM pdv_usuario " + "	WHERE login='"
		+ busqueda.getUsuario().getLogin() + "') AND "
		+ " idcaja is not null";

	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
		busqueda);
	 logger.debug("sql:" + sql);
	lista = this.namedParameterJdbcTemplate.query(sql, parameterSource,
		new OficinasReceptorasRowMapper());
	return lista;
    }

    @Override
    public List<OficinasDTO> getOficinasReceptorasPDVs(BusquedaDTO busqueda)
	    throws SQLException {
	List<OficinasDTO> lista = new ArrayList<OficinasDTO>();
	String sql = "select caoficinas.* from caoficinas where estatus!='B' AND tipooficina=1";

	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
		busqueda);
	 logger.debug("sql:" + sql);
	lista = this.namedParameterJdbcTemplate.query(sql, parameterSource,
		new OficinasReceptorasRowMapper());
	return lista;
    }

    @Override
    public List<OficinasDTO> getOficinasReceptorasConOcurre(BusquedaDTO busqueda)
	    throws SQLException {

	List<OficinasDTO> lista = new ArrayList<OficinasDTO>();
	String sql = "select caoficinas.* from caoficinas where estatus!='B' AND"
		+ " tipooficina=1 AND esocurre=1";

	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
		busqueda);
	 logger.debug("sql:" + sql);
	lista = this.namedParameterJdbcTemplate.query(sql, parameterSource,
		new OficinasReceptorasRowMapper());
	return lista;
    }

    @Override
    public List<OficinasDTO> getPDVAsignadosAlUsuario(BusquedaDTO busqueda)
	    throws SQLException {

	List<OficinasDTO> lista = new ArrayList<OficinasDTO>();
	String sql = "select distinct caoficinas.*  "
		+ " from caoficinas LEFT OUTER join pdv_usuario on "
		+ "caoficinas.idoficina = pdv_usuario.idoficina where"
		+ " caoficinas.estatus!='B' AND "
		+ " caoficinas.tipooficina=1 AND pdv_usuario.login='"
		+ busqueda.getUsuario().getLogin() + "' ";

	 logger.debug("sql:" + sql);
	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
		busqueda);

	lista = this.namedParameterJdbcTemplate.query(sql, parameterSource,
		new OficinasReceptorasRowMapper());
	return lista;
    }
    
    @Override
    public List<OficinasDTO> getUsuarioAsignadosAlPDV(BusquedaDTO busqueda)
	    throws SQLException {

	List<OficinasDTO> lista = new ArrayList<OficinasDTO>();
	String sql = "select distinct idpdvusuario as idregistro,nombre,pdv_usuario.login "
		+ " from causuarios left outer join pdv_usuario on "
		+ " causuarios.login = pdv_usuario.login "
		+ " WHERE pdv_usuario.idoficina='"+busqueda.getPatron_busqueda()+"'" ;
	 logger.debug("sql:" + sql);

	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
		busqueda);

	lista = this.namedParameterJdbcTemplate.query(sql, parameterSource,
		new OficinasReceptorasRowMapper());
	return lista;
    }
    

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.servicio.search.dao.ICarteraDireccionesRemDesDao#insert(com.innovargia
     * .salesmanager.dtos.RemDes)
     */
    @Override
    public void insert(OficinasDTO objeto) throws Exception {

	String query = "INSERT INTO caremdes( numcliente, idremdes,"
		+ " razonsocial, atencion, direccion, colonia, "
		+ "  ciudad, estado, cp, telefono, municipio, rfc, identidad, idorganizacion, "
		+ " tipodireccion,numinterior,numexterior,celular)"
		+ "    VALUES (:numcliente, :idremdes, :razonsocial, :atencion, :direccion, :colonia, "
		+ "   :ciudad, :estado, :cp, :telefono, :municipio, :rfc, :identidad, :idorganizacion,  "
		+ ":tipodireccion,:numinterior,:numexterior,:celular)";

	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
		objeto);
	 logger.debug("sql:" + query);
	try {
	    this.namedParameterJdbcTemplate.update(query, parameterSource);

	} catch (DataAccessException dae) {
	    logger.error("error insert:" + dae.getMessage());
	    if (dae.contains(DuplicateKeyException.class)) {
		throw new DuplicateKeyException("Registro Duplicado");
	    } else {
		throw new DuplicateKeyException(dae.getMessage());
	    }

	}

    }

}
