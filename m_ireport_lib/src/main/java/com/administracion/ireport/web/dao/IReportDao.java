/**
 * 
 */
package com.administracion.ireport.web.dao;

import java.sql.SQLException;
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

import com.administracion.idao.IParamsSistemaDAO;
import com.administracion.ireport.web.idao.IIReportDao;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.ireport.web.dto.IReportDTO;
import com.ireport.web.rowmapper.IReportDTOMapper;

/**
 * @author Adrian Morales Ruaro
 *
 */
@Repository
public class IReportDao extends JdbcDaoSupport implements IIReportDao  {
	
	private static final Logger logger = LoggerFactory
			.getLogger(IReportDao.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	IParamsSistemaDAO iParamsSistemaDAO;
	
	@Autowired
	public IReportDao(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	/* (non-Javadoc)
	 * @see com.administracion.ireport.web.dao.IIReportDao#getReportes(com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
    @Override
	public List<IReportDTO> getReportes(UsuarioDTO usuario) throws SQLException {
    	
    	List<IReportDTO> lista = new ArrayList<IReportDTO>();
		String sql = "SELECT * FROM reReporteJaspert WHERE identidad=? AND idorganizacion=? ";
		//Signidica que debe traer todos los registros
		  logger.debug("sql:" + sql);
		lista = jdbcTemplate.query(sql,new Object[]{usuario.entidad.getIdentidad(),
				usuario.organizacion.getIdorganizacion()}, 
				new IReportDTOMapper());
		return lista;
	
    }//fin de getListaUsuarios
    
    @Override
	public List<IReportDTO> getReportesPDV() throws SQLException {
	    	
	    	List<IReportDTO> lista = new ArrayList<IReportDTO>();
			String sql = "SELECT * FROM reReporteJaspert WHERE vepdv=true";
			 logger.debug("sql:" + sql);
			lista = jdbcTemplate.query(sql,new IReportDTOMapper());
			return lista;
		
	    }//fin de getListaUsuarios
    
    @Override
   	public List<IReportDTO> getReportesMonitorScanner(UsuarioDTO usuario) throws Exception {
   	    	
   	    	List<IReportDTO> lista = new ArrayList<IReportDTO>();
   			String sql = "";
   			
   			String usuarios = iParamsSistemaDAO.getValorPropiedad("tracusa.usuarios.reporte.enviosoperados", "MONITOR");
   			
   			/*
   			if(usuario.getLogin().equals("MAVILLANUEVA") || usuario.getLogin().equals("PHUERTA") 
   					|| usuario.getLogin().equals("CNUNEZ") || usuario.getLogin().equals("AGARCIA")
   					|| usuario.getLogin().equals("LMONTER") || usuario.getLogin().equals("BRAMIREZ")
   					|| usuario.getLogin().equals("SSALGADO") || usuario.getLogin().equals("ICRUZ")
   					|| usuario.getLogin().equals("MSERRANO") || usuario.getLogin().equals("RPALMA")){
   					*/
   			if(usuarios.contains(usuario.getLogin())){
   				
   				sql = "SELECT * FROM rereportejaspert WHERE vemonitorscanner=true";
   				
   			}else{
   				
   				sql = "SELECT * FROM rereportejaspert WHERE vemonitorscanner=true AND descripcion != 'ENVIOS OPERADOS'";
   				
   			}
   			
   			 logger.debug("sql:" + sql);
   			lista = jdbcTemplate.query(sql,new IReportDTOMapper());
   			return lista;
   		
   	    }//fin de getListaUsuarios
	public List<IReportDTO> getReportesAdminVenta() throws SQLException {
	    	
	    	List<IReportDTO> lista = new ArrayList<IReportDTO>();
			String sql = "SELECT * FROM reReporteJaspert WHERE veadmiventa=true";
			 logger.debug("sql:" + sql);
			lista = jdbcTemplate.query(sql,new IReportDTOMapper());
			return lista;
		
	    }//fin de getListaUsuarios
	public List<IReportDTO> getReportesAutoDoc(UsuarioDTO usuario) throws SQLException {
	    	
	    	List<IReportDTO> lista = new ArrayList<IReportDTO>();
			String sql = "SELECT * FROM reReporteJaspert WHERE "
				+ " identidad=? AND idorganizacion=?  AND  veautodoc=true";
			 logger.debug("sql:" + sql);
			lista = jdbcTemplate.query(sql,new Object[]{usuario.entidad.getIdentidad(),
					usuario.organizacion.getIdorganizacion()},new IReportDTOMapper());
			return lista;
		
	    }//fin de getListaUsuarios
	public List<IReportDTO> getReportesRecolecciones() throws SQLException {
	    	
	    	List<IReportDTO> lista = new ArrayList<IReportDTO>();
			String sql = "SELECT * FROM reReporteJaspert WHERE verecolecciones=true";
			 logger.debug("sql:" + sql);
			lista = jdbcTemplate.query(sql,new IReportDTOMapper());
			return lista;
		
	    }//fin de getListaUsuarios
	 @Override
	public List<IReportDTO> getReportesIntegra() throws SQLException {
    	
    	List<IReportDTO> lista = new ArrayList<IReportDTO>();
		String sql = "SELECT * FROM reReporteJaspert WHERE verintegra=true";
		 logger.debug("sql:" + sql);
		lista = jdbcTemplate.query(sql,new IReportDTOMapper());
		return lista;
	
    }//fin de getListaUsuarios
    /* (non-Javadoc)
	 * @see com.administracion.ireport.web.dao.IIReportDao#getReporte(com.innovargia.salesmanager.dtos.UsuarioDTO, int)
	 */
    @Override
	public IReportDTO getReporte(UsuarioDTO usuario, int idReporte) throws SQLException {
        
    	List<IReportDTO> lista = new ArrayList<IReportDTO>();
		String sql = "SELECT * FROM reReporteJaspert WHERE "
				+ " identidad=? AND idorganizacion=? AND idrereportejaspert=?" ;
		//Signidica que debe traer todos los registros
		 logger.debug("sql:" + sql);
		lista = jdbcTemplate.query(sql,new Object[]{usuario.entidad.getIdentidad(),
				usuario.organizacion.getIdorganizacion(),idReporte},new IReportDTOMapper());
		if (lista.size()>0){
			return lista.get(0);
		}
		return null;
		
      
    }//fin de getReporte
    
    @Override
   	public IReportDTO getReporte( int idregistro) throws SQLException {
           
       	List<IReportDTO> lista = new ArrayList<IReportDTO>();
   		String sql = "SELECT * FROM reReporteJaspert WHERE idregistro=?" ;
   		//Signidica que debe traer todos los registros
   		 logger.debug("sql:" + sql);
   		lista = jdbcTemplate.query(sql,new Object[]{idregistro}, new IReportDTOMapper());
   		if (lista.size()>0){
   			return lista.get(0);
   		}
   		return null;
   		
         
       }//fin de getReporte
    
}
