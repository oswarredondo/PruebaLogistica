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

import com.administracion.dto.TipoEmpaqueFormato;
import com.administracion.rowmapper.CatalogoRegistroRowMapper;
import com.administracion.rowmapper.PlazaRowMapper;
import com.administracion.rowmapper.TipoFormatoEmpaqueRowMapper;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.PlazaDTO;
import com.servicio.search.idao.IBusquedaCatalogoDAO;

@Repository
public class BusquedaCatalogoDAO extends JdbcDaoSupport implements IBusquedaCatalogoDAO  {

	private static final Logger logger = LoggerFactory
			.getLogger(BusquedaCatalogoDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public BusquedaCatalogoDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/* (non-Javadoc)
	 * @see com.servicio.search.dao.IBusquedaCatalogoDAO#getBancos()
	 */
	@Override
	public  List<CatalogoDTO> getBancos() throws Exception{
		List<CatalogoDTO> lista = new ArrayList<CatalogoDTO>();
		String sql = "SELECT descripcion as clave,descripcion FROM cabanco";
		lista = jdbcTemplate.query(sql,new CatalogoRegistroRowMapper()); 
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see com.servicio.search.dao.IBusquedaCatalogoDAO#getBancos()
	 */
	@Override
	public  List<CatalogoDTO> getTiposPagosCaja() throws Exception{
		List<CatalogoDTO> lista = new ArrayList<CatalogoDTO>();
		String sql = "SELECT * FROM catipomovimientocaja";
		lista = jdbcTemplate.query(sql,new CatalogoRegistroRowMapper()); 
		return lista;
	}
	
	
	@Override
	public  List<TipoEmpaqueFormato> getTiposFormatoEmpaque(boolean onlyPDV) throws Exception{
		List<TipoEmpaqueFormato> lista = new ArrayList<TipoEmpaqueFormato>();
		String sql = "SELECT * FROM catipoformato"
				+ (onlyPDV? " WHERE visiblepdv=1 ":"");
		lista = jdbcTemplate.query(sql,new TipoFormatoEmpaqueRowMapper());
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see com.servicio.search.dao.IBusquedaCatalogoDAO#getTipoIdentificacion()
	 */
	@Override
	public  List<CatalogoDTO> getTipoIdentificacion() throws Exception{
		List<CatalogoDTO> lista = new ArrayList<CatalogoDTO>();
		String sql = "SELECT clave as identificador, clave,descripcion FROM catipoidentificacion";
		lista = jdbcTemplate.query(sql,new CatalogoRegistroRowMapper()); 
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see com.servicio.search.dao.IBusquedaCatalogoDAO#getTipoPagoVenta(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public List<CatalogoDTO> getTipoPagoVenta(CatalogoDTO catalogo)
				throws Exception {
			List<CatalogoDTO> lista = new ArrayList<CatalogoDTO>();
			String sql = "SELECT clave as identificador,clave,"
				+ "descripcion FROM catipopagoventa ";
				
			
			lista = jdbcTemplate.query(sql,new CatalogoRegistroRowMapper());
			return lista;
		}
	    
	@Override
	public List<CatalogoDTO> getExcepcionespdv()
				throws Exception {
			List<CatalogoDTO> lista = new ArrayList<CatalogoDTO>();
			String sql = "select idexcepcion as clave, descripcion from caexcepcion s ";
				
			
			lista = jdbcTemplate.query(sql,new CatalogoRegistroRowMapper());
			return lista;
		}
	@Override
	public List<CatalogoDTO> getExcepciones()
		throws Exception {
        	List<CatalogoDTO> lista = new ArrayList<CatalogoDTO>();
        	String sql = "select idexcepcion as clave, descripcion from caexcepcion s ";
        		
        	
        	lista = jdbcTemplate.query(sql,new CatalogoRegistroRowMapper());
        	return lista;
	}
	
	@Override
	public List<CatalogoDTO> getServicioInternacional() throws Exception {
		List<CatalogoDTO> lista = new ArrayList<CatalogoDTO>();
		
		lista = jdbcTemplate.query("select idservicio as clave, descripcion as nombre ,"
			+ "descripcion from caserviciointernacional",new CatalogoRegistroRowMapper());
		return lista;
	}
	
	@Override
	public CatalogoDTO getServicioInternacional(String id) throws Exception {
		List<CatalogoDTO> lista = new ArrayList<CatalogoDTO>();
		
		lista = jdbcTemplate.query("select idservicio as clave, descripcion as nombre ,"
			+ "descripcion from caserviciointernacional where idservicio='" + id+"'",
			new CatalogoRegistroRowMapper());
		if (lista.size()>0){
		    return lista.get(0);
		}
		return null; 
	}

}
