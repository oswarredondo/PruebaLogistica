/**
 * 
 */
package com.innovargia.ws.dao;

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

import com.innovargia.salesmanager.dtos.AttachmentDTO;
import com.innovargia.ws.dto.Entrega;
import com.innovargia.ws.dto.FirmaFoto;
import com.innovargia.ws.repo.interfase.dao.IFirmaFotoDao;

/**
 * @author aruaro
 *
 */
@Repository
public class FirmaFotoDao extends JdbcDaoSupport   implements IFirmaFotoDao {
    
    private static final Logger logger = LoggerFactory
  		.getLogger(FirmaFotoDao.class);
      
    
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
   	private JdbcTemplate jdbcTemplate;
   	
  

    /**
     * 
     */
   	@Autowired
    public FirmaFotoDao(DataSource dataSource) {
	
	setDataSource(dataSource);
	this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
			dataSource);
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	
    }
    
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IFirmaFotoDao#insert(com.innovargia.ws.dto.FirmaFoto)
     */
    @Override
    public int insert(AttachmentDTO obj) throws Exception{
	
	String query = "INSERT INTO caattachdocumento(identificador,nombre_archivo,"
		+ "descripcion,fecha,login,idtipodocumento,base64) " +
		       "VALUES(:identificador,:nombre_archivo,:descripcion,"
		       + "current_timestamp,:login,:idtipodocumento,"
		       + ":base64)";
	
	KeyHolder keyHolder = new GeneratedKeyHolder();
	SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
		obj);

	try {
		this.namedParameterJdbcTemplate.update(query, parameterSource,
				keyHolder, new String[] { "identificador" });
		
		//return keyHolder.getKey();
	} catch (DataAccessException dae) {
		logger.error("error insert:" + dae.getMessage());
		if (dae.contains(DuplicateKeyException.class)) {
			throw new DuplicateKeyException("Registro Duplicado");
		} else {
			throw new DuplicateKeyException(dae.getMessage());
		}

	}
	
	return 0;
    }
    
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IFirmaFotoDao#update(com.innovargia.ws.dto.FirmaFoto)
     */
    @Override
    public int update(FirmaFoto obj) throws Exception{
	
   	return 0;
       }
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IFirmaFotoDao#delete(com.innovargia.ws.dto.FirmaFoto)
     */
    @Override
    public int delete(FirmaFoto obj) throws Exception{
	
   	return 0;
       }
    /* (non-Javadoc)
     * @see com.innovargia.ws.repo.interfase.IFirmaFotoDao#select(com.innovargia.ws.dto.FirmaFoto)
     */
    @Override
    public List<FirmaFoto> select(FirmaFoto obj) throws Exception{
	
   	return new ArrayList<FirmaFoto>();
       }

}
