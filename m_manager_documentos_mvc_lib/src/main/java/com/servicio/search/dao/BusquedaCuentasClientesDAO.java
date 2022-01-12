/**
 * 
 */
package com.servicio.search.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.administracion.rowmapper.CuentasClienteConexionRowMapper;
import com.administracion.rowmapper.CuentasClienteRowMapper;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CuentasConexionMensajeriaDTO;
import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.servicio.search.idao.IBusquedaCuentasClientesDAO;

/**
 * @author aruaro
 * 
 */
@Repository
public class BusquedaCuentasClientesDAO extends JdbcDaoSupport implements IBusquedaCuentasClientesDAO { 

	private static final Logger logger = LoggerFactory
			.getLogger(BusquedaCuentasClientesDAO.class);
	
	final String  sql_ = "SELECT identidad, idorganizacion, numcliente, razonsocial, atencion, "
			+ " calle, colonia, municipio, ciudad, cp, telefono, fax, email, "
			+ " depto, persona, estatus, observacion, tipocliente, rfc, cveunica,"
			+ " cuentamaestra, vertodasdirecciones, oborganizacion, estado, contrato,identificador,tipofolio FROM cacuenta ";

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public BusquedaCuentasClientesDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public CuentasDTO getDatosCliente(BusquedaDTO obj) throws Exception{
		List<CuentasDTO> lista = new ArrayList<CuentasDTO>();
		String sql = "SELECT * FROM clientes WHERE numcliente ='" + obj.getIdentificador_str()+ "'";
		
		lista = jdbcTemplate.query(sql,new CuentasClienteRowMapper());
		if (lista.size()>0){
			return lista.get(0);
		}
		return null;
	}
	
	
	@Override
	public CuentasConexionMensajeriaDTO getDatosConexionCliente(BusquedaDTO obj) throws Exception{
		List<CuentasConexionMensajeriaDTO> lista = new ArrayList<CuentasConexionMensajeriaDTO>();
		String sql = "SELECT * FROM caclienteconexioncarrier WHERE "
				+ "numcliente ='" + obj.getNumcliente() + "' AND mensajeria='" + 
				obj.getIdentificador_str()+"'";
		
		lista = jdbcTemplate.query(sql,new CuentasClienteConexionRowMapper());
		if (lista.size()>0){
			return lista.get(0);
		}
		return null;
	}
	@Override
	public List<CuentasConexionMensajeriaDTO> getDatosConexionClientes(BusquedaDTO obj) throws Exception{
		List<CuentasConexionMensajeriaDTO> lista = new ArrayList<CuentasConexionMensajeriaDTO>();
		String sql = "SELECT * FROM caclienteconexioncarrier";
		
		lista = jdbcTemplate.query(sql,new CuentasClienteConexionRowMapper());
		return lista;
	}
		
	@Override
	public List<CuentasDTO> getBusquedaRegistros(BusquedaDTO obj) throws Exception{
		List<CuentasDTO> lista = new ArrayList<CuentasDTO>();
		String sql = sql_;

		//Signidica que debe traer todos los registros
		String where ="";
		String where_entidad_organizacion ="identidad="+ obj.getIdentidad() + 
					" AND idorganizacion=" + obj.getIdorganizacion() ;
		
		if (obj.getTipo()==0){//VER TODOS
		}else if (obj.getTipo()==1){//R.F.C
			where += " rfc LIKE '" + obj.getPatron_busqueda() + "%'";
		}else if (obj.getTipo()==2){//RAZON SOCIAL
			where += " razonsocial LIKE '" + obj.getPatron_busqueda() + "%'";
		}else if (obj.getTipo()==3){//NUM CLIENTE
			where += " numcliente LIKE '" + obj.getPatron_busqueda() + "%'";
		}else if (obj.getTipo()==4){//COLONIA
			where += " colonia LIKE '" + obj.getPatron_busqueda() + "%'";
		}else if (obj.getTipo()==5){//MUNICIPIO
			where += " municipio LIKE '" + obj.getPatron_busqueda() + "%'";
		}else if (obj.getTipo()==6){//ESTADO
			where += " estado LIKE '" + obj.getPatron_busqueda() + "%'";
		}else if (obj.getTipo()==7){//ATENCION
			where += " atencion LIKE '" + obj.getPatron_busqueda() + "%'";
		}else if (obj.getTipo()==99){//numero cliente	
			where += " atencion LIKE '" + obj.getPatron_busqueda() + "%'";
		}else{
			return lista;
		}

		if (where.trim().length()>0){
			sql = sql + " WHERE " + where_entidad_organizacion+ " AND " + where;
		}else{
			sql = sql + " WHERE " +where_entidad_organizacion;
		}
	

		lista = jdbcTemplate.query(sql,new CuentasClienteRowMapper());
		return lista;
	}
	



}
