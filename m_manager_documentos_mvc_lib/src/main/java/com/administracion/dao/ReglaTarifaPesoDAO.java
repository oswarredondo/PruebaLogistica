package com.administracion.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.administracion.idao.IReglaTarifaPesoDAO;
import com.administracion.rowmapper.TarifaPesoRowMapper;
import com.innovargia.salesmanager.dtos.ConvenioContratoDetalleDTO;
import com.innovargia.salesmanager.dtos.TarifaDTO;

@Repository
public class ReglaTarifaPesoDAO  extends JdbcDaoSupport implements IReglaTarifaPesoDAO {
	private static final Logger logger = LoggerFactory
			.getLogger(ReglaTarifaPesoDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ReglaTarifaPesoDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	
	/* (non-Javadoc)
	 * @see com.administracion.dao.IReglaTarifaPeso#getRegistrosPesoDisponibles(com.innovargia.salesmanager.dtos.TarifaDTO, com.innovargia.salesmanager.dtos.ConvenioContratoDetalleDTO)
	 */
	@Override
	public List<TarifaDTO> getRegistrosPesoDisponibles(TarifaDTO tarifa,ConvenioContratoDetalleDTO obj) throws Exception {
		
		List<TarifaDTO> lista = new ArrayList<TarifaDTO>();

		float alto = 	obj!=null?obj.getAlto():0;
		float ancho = 	obj!=null?obj.getAncho():0;
		float largo = 	obj!=null?obj.getAncho():0;
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("alto", alto);
		params.addValue("ancho",ancho);
		params.addValue("largo", largo);
		params.addValue("pesoamparado", tarifa.getPesoamparado());
		params.addValue("idrangoenvios", tarifa.getIdrangoenvios());

		
		String sql = "SELECT idtarifapeso, pesoinicial,pesofinal, sobrepeso,getpesovolumetrico("
				+ ":alto,:ancho,:largo) AS pesovolumetrico FROM "
				+ " (SELECT *,:pesoamparado-pesoinicial as sobrepeso, "
				+ "(pesofinal-:pesoamparado )  as diferencia FROM "
				+ " catarifapeso WHERE 	idrangoenvios=:idrangoenvios AND "
				+ "(pesofinal-:pesoamparado) >=0 AND :pesoamparado-pesoinicial >=0 AND ("
				+ " pesofinal-:pesoamparado)>=0 "
						+ " order by sobrepeso desc ) a	order by idtarifapeso";			
		logger.debug("SQL:" + sql);				
		//SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(tarifa); 	
		lista =  this.namedParameterJdbcTemplate.query(sql, params, new TarifaPesoRowMapper());

		return lista;

	}

	/* (non-Javadoc)
	 * @see com.administracion.dao.IReglaTarifaPeso#getRegistrosVolumenDisponibles(com.innovargia.salesmanager.dtos.TarifaDTO, com.innovargia.salesmanager.dtos.ConvenioContratoDetalleDTO)
	 */
	@Override
	public List<TarifaDTO> getRegistrosVolumenDisponibles(TarifaDTO tarifa,ConvenioContratoDetalleDTO obj) throws Exception {
		
	    List<TarifaDTO> lista = new ArrayList<TarifaDTO>();
		float alto = 	obj!=null?obj.getAlto():0;
		float ancho = 	obj!=null?obj.getAncho():0;
		float largo = 	obj!=null?obj.getLargo():0;
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("alto", alto);
		params.addValue("ancho",ancho);
		params.addValue("largo", largo);
		params.addValue("pesoamparado", tarifa.getPesoamparado());
		params.addValue("idrangoenvios", tarifa.getIdrangoenvios());

		
		String sql = "select * from catarifapeso where volumen >0 and"
			+ "	 idrangoenvios=idrangoenvios and  "
				+ " getvolumen(:alto,:ancho,:largo)<=volumen "
				+ " order by pesoinicial,pesofinal, volumen limit 1";
		logger.debug("SQL:" + sql);								
		//SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(tarifa); 	
		lista =  this.namedParameterJdbcTemplate.query(sql, params, new TarifaPesoRowMapper());

		return lista;

	}
	
	@Override
	public List<TarifaDTO> getRegistrosRangosDisponibles(TarifaDTO tarifa) throws Exception {
		
	    List<TarifaDTO> lista = new ArrayList<TarifaDTO>();
	
	    MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("pesoamparado", tarifa.getPesoamparado());
		params.addValue("idrangoenviosinicial",tarifa.getIdrangoinicial());
		params.addValue("idrangoenviosinicial",tarifa.getIdrangoinicial());
		
		params.addValue("idrangoenviosinicial",tarifa.getIdrangoinicial());
		params.addValue("idrangoenviosfinal",tarifa.getIdrangofinal());
		params.addValue("idtarifa",tarifa.getIdtarifa());
		

		
		String sql = "SELECT idtarifa, idrangoenvios,idrangoinicial ,idrangofinal FROM "
				+ "catarifarangosenvios WHERE idtarifa IN ("
				+ "		SELECT idtarifa FROM catarifas where estatus=1 and es_visible_pdv=1 )"
				+ "	AND :idrangoenviosinicial>=idrangoinicial  AND "
				+ ":idrangoenviosfinal<=idrangofinal AND idtarifa=:idtarifa";
		
		logger.debug("SQL:" + sql);								
		//SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(tarifa); 	
		lista =  this.namedParameterJdbcTemplate.query(sql, params, new TarifaPesoRowMapper());

		return lista;

	}
	
	@Override
	public List<TarifaDTO> getRangosDisponiblesId(TarifaDTO tarifa) throws Exception {
		
	    List<TarifaDTO> lista = new ArrayList<TarifaDTO>();
	
		String sql = "SELECT idtarifa, idrangoenvios,idrangoinicial ,idrangofinal FROM "
				+ "catarifarangosenvios WHERE idtarifa IN ("
				+ "		SELECT idtarifa FROM catarifas where estatus=1 and es_visible_pdv=1 )"
				+ "	AND idrangoenvios=:idrangoenvios AND idtarifa=:idtarifa " ;
		logger.debug("SQL:" + sql);								
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(tarifa); 	
		lista =  this.namedParameterJdbcTemplate.query(sql, parameterSource, new TarifaPesoRowMapper());

		return lista;

	}
	
	/* (non-Javadoc)
	 * @see com.administracion.dao.IReglaTarifaPeso#getSobrePeso(com.innovargia.salesmanager.dtos.TarifaDTO)
	 */
	@Override
	public float getSobrePeso(TarifaDTO tarifa) throws Exception {
		// TODO Auto-generated method stub
		try{
			List<TarifaDTO> lista = getRegistrosPesoDisponibles( tarifa,null);
			if ((lista!=null) && (lista.size()>0)){
				return lista.get(0).getSobrepeso();
			}
		}catch(Exception e){
			logger.debug("Error al obtener el sobre peso:"+ e.getMessage());
		}

		return -1;
	}
	
	@Override
	public List<TarifaDTO> getListaPrecioPosibles(TarifaDTO tarifa)
			throws Exception {
		// TODO Auto-generated method stub

		List<TarifaDTO> lista = new ArrayList<TarifaDTO>();
		String sql = "select * from catarifaserviciozona where idserviciotarifa =:idtarifapeso "
				+ " AND kminicial<=:kminicial "
				+ " UNION "
				+ " select * from catarifaserviciozona where idserviciotarifa =:idtarifapeso "
				+ " AND kmfinal<=:kminicial  order by kmfinal desc ";
		
		logger.debug("SQL:" + sql);				
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				tarifa);
		lista = this.namedParameterJdbcTemplate.query(sql, parameterSource,
				new TarifaPesoRowMapper());

		return lista;
	}
	

}
