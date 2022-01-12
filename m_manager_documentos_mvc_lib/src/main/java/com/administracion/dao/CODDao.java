/**
 * 
 */
package com.administracion.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.administracion.idao.ICODDao;
import com.administracion.rowmapper.CODFXCRowMapper;
import com.innovargia.documentos.dtos.CODFXC;

/**
 * @author Adrian Morales Ruaro
 * 
 */
@Repository
public class CODDao extends JdbcDaoSupport implements ICODDao { 

	private static final Logger logger = LoggerFactory
			.getLogger(CODDao.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public CODDao(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	/* (non-Javadoc)
	 * @see com.administracion.dao.ICODDao#updateEntregaCobro(com.innovargia.documentos.dtos.COD)
	 */
	@Override
	public void updateEntregaCobro(CODFXC cod )throws SQLException{

		String sql = "UPDATE cadocumento_cod SET fecha_entrega=current_timestamp, "
			+ "login_entrega='"+ cod.getLogin_entrega()+"'," 
			+" numoficina_entrega='" + cod.getNumoficina_entrega()+"',"
			+ " valor_cobrado = " + cod.getValor_cobrado()+" where iddocumento='" + cod.getIddocumento()+ "'";
		try {
			this.jdbcTemplate.update(sql);
			
			
		} catch (Exception dae) {
		    logger.debug("error updateEntregaCobro:" + dae.getMessage());
		    dae.printStackTrace();
		}

	}
	
	/* (non-Javadoc)
	 * @see com.administracion.dao.ICODDao#updateDevolucion(com.innovargia.documentos.dtos.COD)
	 */
	@Override
	public void updateDevolucion(CODFXC cod )throws SQLException{

		String sql = "UPDATE cadocumento_cod SET fecha_devolucion=current_timestamp, "
			+ "login_devolucion='"+ cod.getLogin_entrega()+"'" 
			+"', numoficina_devolucion='" + cod.getNumoficina_entrega()+"'"
			+ " where iddocumento='" + cod.getIddocumento()+ "'";
		try {
			this.jdbcTemplate.update(sql);
		} catch (Exception dae) {
		    logger.debug("error updateDevolucion:" + dae.getMessage());
		    dae.printStackTrace();
		}

	}
	
	/* (non-Javadoc)
	 * @see com.administracion.dao.ICODDao#insert(com.innovargia.documentos.dtos.COD)
	 */
	@Override
	public void insert(CODFXC cod )
		throws SQLException {

        	String query = "INSERT INTO cadocumento_cod("
        			+ " iddocumento, fechacreacion, login_creo, numoficina_creo, valor_a_cobrar)  "
        			+ " VALUES (:iddocumento, current_timestamp, :login_creo, :numoficina_creo, :valor_a_cobrar)";
        
        	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
        		cod);
        
        	try {
        		this.namedParameterJdbcTemplate.update(query, parameterSource);
        	} catch (DataAccessException dae) {
        		logger.error("error insert:" + dae.getMessage());
        		 dae.printStackTrace();
        	}

	}
	@Override
	  public CODFXC getRegistrOcurres(String iddocumento) throws Exception {
		List<CODFXC> lista = new ArrayList<CODFXC>(); 
		String sql = " SELECT distinct * FROM cadocumento_cod WHERE iddocumento='" + iddocumento +"'";

		lista = this.namedParameterJdbcTemplate.query(sql, new CODFXCRowMapper());
		if (lista.size()>0){
		    return lista.get(0);
		}
		return null;
	    }


}
