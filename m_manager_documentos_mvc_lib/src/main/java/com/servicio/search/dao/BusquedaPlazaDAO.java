package com.servicio.search.dao;

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

import com.administracion.rowmapper.CruceCoberturaRowMapper;
import com.administracion.rowmapper.PlazaRowMapper;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.salesmanager.dtos.PlazaDTO;
import com.servicio.search.idao.IBusquedaPlazaDAO;

@Repository
public class BusquedaPlazaDAO  extends JdbcDaoSupport implements IBusquedaPlazaDAO {
	
	private static final Logger logger = LoggerFactory
			.getLogger(BusquedaPlazaDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public BusquedaPlazaDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	final String  sql_ = "SELECT * FROM caplaza ";

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITerminoPago#insert(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public void insert(PlazaDTO catalogo) throws Exception {
		String query = "INSERT INTO caplaza(siglasplaza,descripcion,idsiglasco) " +
			       "VALUES(:siglasplaza, :descripcion, :idsiglasco)";
	
		
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				catalogo);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "idplaza" });
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

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IPlazaDAO#update(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public void update(PlazaDTO catalogo) throws Exception {
		String query = "UPDATE caplaza SET  nombre= :nombre, descripcion= :descripcion, idsiglasco=:idsiglasco WHERE " +
			       " siglasplaza = :siglasplaza";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IPlazaDAO#updateEstatus(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public void updateEstatus(PlazaDTO catalogo) throws Exception {
		String query = "UPDATE caplaza SET estatus= :estatus WHERE " +
			       " siglasplaza = :siglasplaza";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en updateEstatus: " + dae.getMessage());
		}
		
	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IPlazaDAO#delete(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public void delete(PlazaDTO catalogo) throws Exception {
		String query = "DELETE FROM caplaza WHERE " +
			       " identificador = :identificador";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(catalogo);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en delete: " + dae.getMessage());
		}
		
	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IPlazaDAO#getRegistros(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public List<PlazaDTO> getRegistros(PlazaDTO catalogo)
			throws Exception {
		List<PlazaDTO> lista = new ArrayList<PlazaDTO>();
		String sql = sql_;
		//Signidica que debe traer todos los registros
		if (catalogo.getEstatus()>-1){
			sql+= " WHERE estatus="+catalogo.getEstatus();
		}
		
		lista = jdbcTemplate.query(sql,new PlazaRowMapper());
		return lista;
	}
	
	
	@Override
	public List<PlazaDTO> getRegistrosPais() throws Exception {
		List<PlazaDTO> lista = new ArrayList<PlazaDTO>();
		
		lista = jdbcTemplate.query("select idpais as siglasplaza ,descripcion||'-' ||idpais as descripcion from capais   ",new PlazaRowMapper());
		return lista;
	}
	
	

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IPlazaDAO#get(com.innovargia.salesmanager.dtos.CatalogoDTO)
	 */
	@Override
	public PlazaDTO get(PlazaDTO catalogo) throws Exception {
		String sql = sql_ + " WHERE siglasplaza='"+ catalogo.getSiglasplaza()+ "'";
		List<PlazaDTO> lista = new ArrayList<PlazaDTO>();
		//Signidica que debe traer todos los registros
		if (catalogo.getEstatus()>-1){
			sql+= " WHERE estatus="+catalogo.getEstatus();
		}
		
		lista = jdbcTemplate.query(sql,new PlazaRowMapper());
		if (lista.size()>0){
			return lista.get(0);
		}
		return null;
	}
	
	@Override
	public CruceCoberturaDTO getCobertura(CruceCoberturaDTO catalogo) throws Exception {
		String sql = "SELECT * FROM cacruceoperacion WHERE idcoorigen='"+ catalogo.getIdcoorigen()+ "' AND " +
				" idcodestino='"+ catalogo.getIdcodestino()+ "'";
		  
		List<CruceCoberturaDTO> lista = new ArrayList<CruceCoberturaDTO>();
	
		lista = jdbcTemplate.query(sql,new CruceCoberturaRowMapper());
		if (lista.size()>0){
			return lista.get(0);
		}
		return null;
	}
	
	@Override
	public CruceCoberturaDTO getCoberturaConServicio(CruceCoberturaDTO catalogo) throws Exception {
		String sql = "SELECT * FROM cacruceoperacion WHERE idcoorigen='"+ catalogo.getIdcoorigen()+ "' AND " +
				" idcodestino='"+ catalogo.getIdcodestino()+ "' AND idservicio="+catalogo.getIdservicio();
		  
		List<CruceCoberturaDTO> lista = new ArrayList<CruceCoberturaDTO>();
	
		lista = jdbcTemplate.query(sql,new CruceCoberturaRowMapper());
		if (lista.size()>0){
			return lista.get(0);
		}
		return null;
	}
	
	

}
