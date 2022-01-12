package com.administracion.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.administracion.dto.DocumentoJson;
import com.administracion.idao.INotificacionesEmailDAO;
import com.administracion.notificacionemail.dto.NotificacionEmailDTO;
import com.administracion.rowmapper.DocumentoJsonDTOMapper;
import com.administracion.rowmapper.PlantillaNotificacionDTOMapper;

@Repository
public class NotificacionesEmailDAO  extends JdbcDaoSupport implements INotificacionesEmailDAO  {
	private final String QUERY_DOC = 
			"SELECT b.*,razonsocialorigen, atencionorigen," +
			" razonsocialdes, atenciondes,numcliente FROM ( "+
			"		select * from viewinfodocumento where numcliente  "  +
			"		IN (select distinct numcliente from cliente_notificacion)  "+
			"	) a JOIN (select * from cadocumentosjson ) b "  +
			" ON a.iddocumento = b.iddocumento and  COALESCE(seenvionotificacion,0)=0 "+
			" order by razonsocialdes, atenciondes";

	
	private static final Logger logger = LoggerFactory
			.getLogger(NotificacionesEmailDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;


	@Autowired
	public NotificacionesEmailDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/* (non-Javadoc)
	 * @see com.administracion.dao.INotificacionesEmailDAO#getEnviosANotificar()
	 */
	@Override
	public List<DocumentoJson> getEnviosANotificar() throws SQLException{
		String sql = QUERY_DOC;
		List<DocumentoJson> lista = null;
		try{
			lista =  jdbcTemplate.query(sql, new DocumentoJsonDTOMapper());
		}catch(Exception  e){
			logger.debug("ERROR NOTIFICACION EMAIL:" + e.getMessage());
			logger.debug("sql:" + sql);
		}
		
		return lista;
	

	}
	
	/* (non-Javadoc)
	 * @see com.administracion.dao.INotificacionesEmailDAO#updateSeEnvioNotificacion(java.lang.String)
	 */
	@Override
	public void updateSeEnvioNotificacion(String iddocumento)
			throws SQLException {

		String query = "UPDATE cadocumentosjson "
				+ "	SET seenvionotificacion=1 "
				+ " WHERE iddocumento=?" ;
		
		try{
			this.jdbcTemplate.update(query, new Object[]{iddocumento});
		}catch(Exception  e){
			logger.debug("ERROR UPDATE NOTIFICACION EMAIL:" + e.getMessage());
			logger.debug("sql:" + query);
		}

	}
	
	
	/* (non-Javadoc)
	 * @see com.administracion.dao.INotificacionesEmailDAO#getDatosEnvioNotificacionConfiguracion(java.lang.String)
	 */
	@Override
	public NotificacionEmailDTO getDatosEnvioNotificacionConfiguracion(String numliente)
			throws SQLException {

		String query = "SELECT * FROM cliente_notificacion WHERE numcliente=?";
		
		List<NotificacionEmailDTO> lista = null;
		try{
			lista =  jdbcTemplate.query(query, new Object[]{numliente}, new PlantillaNotificacionDTOMapper());
			if (lista.size()>0){
				return lista.get(0);
			}
		}catch(Exception  e){
			logger.debug("ERROR NOTIFICACION EMAIL:" + e.getMessage());
			logger.debug("sql:" + query);
		}
		return null;

	}
	

}
