/**
 * 
 */
package com.servicio.search.dao;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.administracion.rowmapper.ConvenioRowMapper;
import com.innovargia.salesmanager.dtos.ConvenioContratoDTO;
import com.servicio.search.idao.IConvenioContratoDAO;


/**
 * @author aruaro
 * 
 */
@Repository
public class BusquedaConvenioDAO extends JdbcDaoSupport implements IConvenioContratoDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(BusquedaConvenioDAO.class);

	final String sql_ = "select b.*,cadescuento.nombre as descripcionDescuento from (	"
			+ "	select a.*, catarifas.nombre descripcionTarifarango from "
			+ " caconvenio a left outer join catarifas ON a.idtarifa = catarifas.idtarifa	"
			+ ") b  left outer join cadescuento ON b.iddescuento = cadescuento.iddescuento ";

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public BusquedaConvenioDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	/* (non-Javadoc)
	 * @see com.servicio.search.bo.IConvenioContratoDAO#get(com.innovargia.salesmanager.dtos.ConvenioContratoDTO)
	 */
	@Override
	public ConvenioContratoDTO get(ConvenioContratoDTO obj) throws Exception {
		String sql = "select caconvenio.*,caoficinacontrol.siglasplaza "
			+ " from caconvenio left outer join caoficinacontrol ON "
			+ " caconvenio.idoficinacontrol= caoficinacontrol.identificador WHERE idconvenio = ?";
		try {
			return this.jdbcTemplate.queryForObject(sql,
					new ConvenioRowMapper(), obj.getIdconvenio());
		} catch (Exception dae) {
			logger.error("Error get:" + dae.getMessage());
			return null;
		}
	}

	
}
