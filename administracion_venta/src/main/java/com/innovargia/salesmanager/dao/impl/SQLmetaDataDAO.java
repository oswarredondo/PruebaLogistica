/**
 * 
 */
package com.innovargia.salesmanager.dao.impl;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.innovargia.salesmanager.dtos.SQLColumn;
import com.innovargia.salesmanager.idao.ISQLMetaDataDAO;

/**
 * @author aruaro
 * 
 */
@Repository
public class SQLmetaDataDAO extends JdbcDaoSupport implements ISQLMetaDataDAO {
	private static final Logger logger = LoggerFactory.getLogger(SQLmetaDataDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public SQLmetaDataDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * 
	 */
	public SQLmetaDataDAO() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.estafeta.afe.idao.ISQLMetaDataDAO#getMetaDataTable(java.lang.String)
	 */
	@Override
	public List<SQLColumn> getMetaDataTable(String table) {
		
		final List<SQLColumn> columns = new ArrayList<SQLColumn>();
		try{
			jdbcTemplate.query("SELECT top 1 * FROM " +table,new ResultSetExtractor<Integer>() {

			    @Override
			    public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {

			        ResultSetMetaData rsmd = rs.getMetaData();
			        String identReg = "identreg";
			        String idultimoMov = "idultimomov";
			                              
			        String columname="";
				    int columnCount = rsmd.getColumnCount();
				    for(int i = 1 ; i <= columnCount ; i++){
				        SQLColumn column = new SQLColumn();
				        columname = rsmd.getColumnName(i);
				        if (columname!=null){
				        	columname = columname.trim().toLowerCase();
				        	//Solo agrega las columnas propias de la tabla no las de control del AFE
				        	if (!identReg.equals(columname) && !idultimoMov.equals(columname)){
				        		  column.setName(rsmd.getColumnName(i));
								    column.setType(rsmd.getColumnTypeName(i));
								    columns.add(column);
				        	}
				        }
				    }
		
				    return columnCount; 
			
			    }

			});	
		}catch(Exception e){
			
		}
		
		
		return columns;
	}
}
