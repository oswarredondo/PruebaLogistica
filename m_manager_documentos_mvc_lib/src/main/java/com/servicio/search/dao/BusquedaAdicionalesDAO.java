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

import com.administracion.dto.AdicionalDTO;
import com.administracion.rowmapper.AdicionalDTOMapper;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.servicio.search.idao.IBusquedaAdicionalDAO;

@Repository
public class BusquedaAdicionalesDAO extends JdbcDaoSupport implements IBusquedaAdicionalDAO  {

	private static final Logger logger = LoggerFactory
			.getLogger(BusquedaAdicionalesDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public BusquedaAdicionalesDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/* (non-Javadoc)
	 * @see com.servicio.search.dao.IAdicionalDAO#insert(com.administracion.dto.AdicionalDTO)
	 */
	@Override
	public void insert(AdicionalDTO adicional) throws Exception {

		String query = "INSERT INTO rotulacion_etiqueta_adicionales("
				+ "iddregistrodatos, idregistroadicional, uuid, idadicional, precio, descripcion, fechacreacion, tipo)"
				+ " VALUES (:iddregistrodatos, :idregistroadicional, :uuid, :idadicional,"
				+ " :precio, :descripcion,current_timestamp, :tipo)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				adicional);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "idregistro" });
			
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
	 * @see com.servicio.search.dao.IAdicionalDAO#delete(com.administracion.dto.AdicionalDTO)
	 */
	@Override
	public void delete(AdicionalDTO adicional) throws Exception {
		String query = "DELETE FROM rotulacion_etiqueta_adicionales WHERE " +
			       " idregistro = :idregistro";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(adicional);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.debug("Error en delete: " + dae.getMessage());
		}
		
	}


	/* (non-Javadoc)
	 * @see com.servicio.search.dao.IAdicionalDAO#getRegistrosDisponiblesConvenio(int)
	 */
	@Override
	public List<AdicionalDTO> getRegistrosDisponiblesConvenio(int idconvenio, String uuid, int iddregistrodatos )
			throws Exception {
		List<AdicionalDTO> lista = new ArrayList<AdicionalDTO>();
		String sql = "select caadicional.identificador as idadicional,"
				+ " caadicional.idadicional  as idregistroadicional ,caadicional.descripcion, "+
				" caconvenioadicional.idadicionaldetalle, descuento, caconvenioadicional.precio, "
				+ " caconvenioadicional.estatus as tipo "+
				" from caconvenioadicional  left outer join  caadicional on  "+
				"  caconvenioadicional.idadicional =  caadicional.identificador where idconvenio=" +idconvenio+" and  "+
				"   caconvenioadicional.idadicional NOT IN "
				+ "	("
				+ "		SELECT distinct idadicional FROM rotulacion_etiqueta_adicionales where"
				+ "		 uuid='" + uuid+ "' and iddregistrodatos=" + iddregistrodatos
						+ " )";
	
		lista = jdbcTemplate.query(sql,new AdicionalDTOMapper());
		return lista;
	}
	
	@Override
	public AdicionalDTO getRegistroIdAdicionalConvenio(int idadicionaldetalle)
			throws Exception {
		List<AdicionalDTO> lista = new ArrayList<AdicionalDTO>();
		String sql = "select caadicional.identificador as idadicional,"
				+ " caadicional.idadicional  as idregistroadicional ,caadicional.descripcion, "+
				" caconvenioadicional.idadicionaldetalle, descuento, caconvenioadicional.precio, "
				+ " caconvenioadicional.estatus as tipo "+
				" from caconvenioadicional  left outer join  caadicional on  "+
				"  caconvenioadicional.idadicional =  caadicional.identificador "
				+ "where caconvenioadicional.idadicionaldetalle ="+idadicionaldetalle ;
	
		lista = jdbcTemplate.query(sql,new AdicionalDTOMapper());
		if (lista.size()>0){
			return lista.get(0);
		}
		return null;
	}
	
	@Override
	public List<AdicionalDTO> getAdicinalesConvenio(int idconvenio) throws Exception {
		List<AdicionalDTO> lista = new ArrayList<AdicionalDTO>();
		String sql = "select caadicional.identificador as idadicional,"
				+ " caadicional.idadicional  as idregistroadicional ,caadicional.descripcion, "+
				" caconvenioadicional.idadicionaldetalle, descuento, caconvenioadicional.precio, "
				+ " caconvenioadicional.estatus as tipo "+
				" from caconvenioadicional  left outer join  caadicional on  "+
				"  caconvenioadicional.idadicional =  caadicional.identificador "
				+ "where caconvenioadicional.idconvenio ="+idconvenio ;
	  
		logger.debug("SQL:" + sql);
		lista = jdbcTemplate.query(sql,new AdicionalDTOMapper());

		return lista;
	}
	
	@Override
	public List<AdicionalDTO> getRegistrosAdicionalesNorequeridos( int tipo)
			throws Exception {
		List<AdicionalDTO> lista = new ArrayList<AdicionalDTO>();
		String sql = "select *, idadicional as idregistroadicional from caadicional where tipo=" + tipo;
		
		
		lista = jdbcTemplate.query(sql,new AdicionalDTOMapper());
		return lista;
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see com.servicio.search.dao.IAdicionalDAO#getRegistrosDisponiblesFolios(java.lang.String)
	 */
	@Override
	public List<AdicionalDTO> getRegistrosDisponiblesFolios(String uuid, int idregistrodatos)
			throws Exception {
		List<AdicionalDTO> lista = new ArrayList<AdicionalDTO>();
		String sql = "select * from caadicional where identificador NOT IN ("
				+ "	SELECT idadicional  FROM rotulacion_etiqueta_adicionales where uuid ='" +
					uuid +"' and iddregistrodatos= " + idregistrodatos+ ")";
	
		lista = jdbcTemplate.query(sql,new AdicionalDTOMapper());
		return lista;
	}
	

	/* (non-Javadoc)
	 * @see com.servicio.search.dao.IAdicionalDAO#getRegistrosSeleccionados(java.lang.String)
	 */
	@Override
	public List<AdicionalDTO> getRegistrosSeleccionados(String uuid, int iddregistrodatos)
			throws Exception {
		List<AdicionalDTO> lista = new ArrayList<AdicionalDTO>();
		String sql = "select * from rotulacion_etiqueta_adicionales where uuid='" + uuid +
				"' AND iddregistrodatos="+	iddregistrodatos ;
	
		lista = jdbcTemplate.query(sql,new AdicionalDTOMapper());
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see com.servicio.search.dao.IAdicionalDAO#getRegistrosSeleccionadosConvenio(int)
	 */
	@Override
	public List<AdicionalDTO> getRegistrosSeleccionadosConvenio(int idconvenio)
			throws Exception {
		List<AdicionalDTO> lista = new ArrayList<AdicionalDTO>();
		String sql = "select caadicional.identificador,caadicional.idadicional,caadicional.descripcion, "+
				" caconvenioadicional.idadicionaldetalle, descuento, caconvenioadicional.precio, caadicional.tipo "+
				" from caconvenioadicional  left outer join  caadicional on  "+
				"  caconvenioadicional.idadicional =  caadicional.identificador where idconvenio=" +idconvenio;
	
		lista = jdbcTemplate.query(sql,new AdicionalDTOMapper());
		return lista;
	}
	
	
	@Override
	public List<AdicionalDTO> getRegistroAdicional( String idadicional)	throws Exception {
		List<AdicionalDTO> lista = new ArrayList<AdicionalDTO>();
		String sql = "select *, idadicional as idregistroadicional from caadicional "
				+ "where idadicional='" + idadicional + "'";
		
		
		lista = jdbcTemplate.query(sql,new AdicionalDTOMapper());
		return lista;
	}

	@Override
	public List<AdicionalDTO> getRegistroAdicional( int identificador)	throws Exception {
		List<AdicionalDTO> lista = new ArrayList<AdicionalDTO>();
		String sql = "select *, idadicional as idregistroadicional from caadicional "
				+ "where identificador=" + identificador;
		
		
		lista = jdbcTemplate.query(sql,new AdicionalDTOMapper());
		return lista;
	}
	
	@Override
	public void update(AdicionalDTO adicionalDTO) throws Exception {
		
		String query = "UPDATE rotulacion_etiqueta_adicionales SET precio= :precio WHERE idregistro = :idregistro";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(adicionalDTO);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
	}
	
	@Override
	public void updatePorGuia(AdicionalDTO adicionalDTO) throws Exception {
		
		String query = "UPDATE cadocumentoadicionales SET precio = :precio WHERE iddocumento = :idregistroadicional AND idadicional = :idadicional";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(adicionalDTO);
	
		try{
			
			this.namedParameterJdbcTemplate.update(query, parameterSource);
			
		}catch(Exception dae){
			
			logger.error("Error en updateEstatus: " + dae.getMessage());
			
		}
		
	}
	
	@Override
	public List<AdicionalDTO> getRegistrosSeleccionadosPorGuia(String iddocumento) {
		
		List<AdicionalDTO> lista = new ArrayList<AdicionalDTO>();
		
		String sql = "select iddocumento AS idregistroadicional, descripcion, precio, idadicional from cadocumentoadicionales "
				+ "where iddocumento= '" + iddocumento +"'" ;
		
		lista = jdbcTemplate.query(sql,new AdicionalDTOMapper());
		
		return lista;
		
	}

}
