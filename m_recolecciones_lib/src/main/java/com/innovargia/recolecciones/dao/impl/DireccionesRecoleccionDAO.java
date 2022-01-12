/**
 * 
 */
package com.innovargia.recolecciones.dao.impl;

import java.sql.SQLException;
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
import org.springframework.stereotype.Repository;

import com.administracion.rowmapper.RemDesRowMapper;
import com.innovargia.recolecciones.idao.IDireccionesRecoleccionDAO;
import com.innovargia.salesmanager.dtos.RemDes;

/**
 * @author Adrián
 *
 */
@Repository
public class DireccionesRecoleccionDAO  extends JdbcDaoSupport implements IDireccionesRecoleccionDAO{
	
	private static final Logger logger = LoggerFactory
			.getLogger(DireccionesRecoleccionDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 
	 */
	@Autowired
	public DireccionesRecoleccionDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	 /**Tipos de ordenamientos */
    public static final String ORDER_BY_RAZONSOCIAL =" ORDER BY RazonSocial ";
    /**Orden por IdRemDestino*/
    public static final String ORDER_BY_IDREMDES =" ORDER BY IdRemDes ";
    /**Orden por atencion*/
    public static final String ORDER_BY_ATENCION =" ORDER BY Atencion ";
    
    public static final String BUSCA_INICIO_CADENA = "1";
    public static final String BUSCA_FINAL_CADENA = "2";
    public static final String BUSCA_CUALQUIEN_LUGAR = "3";
    
    public static final String CAMPO_BUSCA_RAZONSOCIAL = "rs";
    public static final String CAMPO_BUSCA_ATENCION = "ate";
    public static final String CAMPO_BUSCA_RFC = "rfc";
    
    public static final int ORDER_X_RAZONSOCIAL = 2;
    public static final int ORDER_X_IDREMDES = 1;
    public static final int ORDER_X_ATENCION = 3;
    
    /**Query Generico para obtener los datos del usuario*/
    public static String SELECT="SELECT * FROM redirrecoleccion ";

	
	
   

	 /* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.IDireccionesRecoleccionDAO#buscaClientesRemDes(int, int, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, boolean)
	 */
    @Override
	public List<RemDes> buscaClientesRemDes(int identidad, int idorganizacion,String numcliente,String inicial, int ordernax,
    String campoBusqueda,String entre,boolean vertodasdirecciones) throws SQLException {
     
        List<RemDes> lista = new ArrayList<RemDes>();
        campoBusqueda = campoBusqueda == null?"":campoBusqueda;
        String sql = SELECT + " WHERE ";
        if (!vertodasdirecciones){
        	sql += " AND NumCliente=? ";
        }

        //Verifica si el usuario selecciono un patron de busqueda
        if ( (inicial!=null) && (inicial.trim().length()>0) ){
            
            inicial = inicial.trim().toUpperCase();
            
            //Configura el campo sobre el cual se realiza la busqueda
            if ( "".equals(campoBusqueda)){
               return lista;
            }else if(entre.trim().equals(BUSCA_CUALQUIEN_LUGAR)){ //Cuando es ambos toma remitente y atencion
                 sql+= "  ( RazonSocial LIKE '%" + inicial + 
                 "%' OR Atencion LIKE '%" + inicial +  "%' ) ";
            }else if (campoBusqueda.trim().equals(CAMPO_BUSCA_RAZONSOCIAL)){
                sql+= "  RazonSocial LIKE ";
            }else if (campoBusqueda.trim().equals(CAMPO_BUSCA_ATENCION )){
                sql+= "  Atencion LIKE ";
            }else if (campoBusqueda.trim().equals(CAMPO_BUSCA_RFC )){
            	sql+= "  RFC LIKE ";
            }
            
            //Indica la posicion de la cadena donde se realiza la busqueda
            if ( (entre==null) || (entre.trim().length()<0) ){
            	  return lista;
            }else if (entre.trim().equals(BUSCA_INICIO_CADENA)){
                sql+=  "'" + inicial+ "%'"; //Al inicio
            }else if (entre.trim().equals(BUSCA_FINAL_CADENA)){
                sql= sql + "'%" + inicial+ "'"; //Al final
            } else if (entre.trim().equals(BUSCA_CUALQUIEN_LUGAR)){
            	 sql= sql + "'%" + inicial+ "%'"; //Al final
            }
        }//fin del if de inicial 
        
        //Identifica el tipo de ordenamiento
        switch (ordernax){
            case 3:
                sql+= " " + ORDER_BY_ATENCION;
                break;
            case 2:
                sql+= " " + ORDER_BY_RAZONSOCIAL;
                break;
            case 1:
                sql+= " " + ORDER_BY_IDREMDES;
                break;
            default:
                sql+= " " + ORDER_BY_IDREMDES;
        }
        

		lista = jdbcTemplate.query(sql,new RemDesRowMapper());
		return lista;
		
      
    }//fin de getClientesRemDes
    
    /* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.IDireccionesRecoleccionDAO#update(com.innovargia.salesmanager.dtos.RemDes)
	 */
    @Override
	public void update(RemDes remdes)   throws SQLException {
    	
    	String query ="UPDATE redirrecoleccion SET razonsocial=:razonSocial,atencion=:atencion, " +
    	        "direccion=:direccion, colonia=:colonia, ciudad=:ciudad,estado=:estado,cp=:cp,"
    	        + "telefono=:telefono,rfc=:rfc, departamento=:depto, celular=:numcelular, "
    	        + "municipio=:municipio, correoe=:correoe " +
    	        " WHERE idregistro =" + remdes.getIdregistro();
    	
    	
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(remdes);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
        
       
    }//fin de updateEstado
    
    /* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.IDireccionesRecoleccionDAO#delete(com.innovargia.salesmanager.dtos.RemDes)
	 */
    @Override
	public void delete(RemDes remdes) throws SQLException {
    	
    	String query ="DELETE FROM redirrecoleccion WHERE idregistro=:idregistro  ";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(remdes);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}
		
		
        
    
    }//fin de delete
    
	/* (non-Javadoc)
	 * @see com.innovargia.recolecciones.dao.impl.IDireccionesRecoleccionDAO#insert(int, int, com.innovargia.salesmanager.dtos.RemDes)
	 */
    @Override
	public void insert(int identidad,int idorganizacion,RemDes remdes)   throws SQLException {
        
		String query = "INSERT INTO redirrecoleccion(numcliente, idremdes, razonsocial,"
				+ " atencion, direccion, colonia, ciudad, estado, cp, telefono, municipio, "
				+ " rfc, identidad, idorganizacion, celular, departamento,correoe)"
				+ " VALUES (:numCliente, :idRmDes, :razonSocial,"
				+ " :atencion, :direccion, :colonia, :ciudad, :estado, :cp, :telefono, :municipio, "
				+ " :rfc, " +identidad+ ", " + idorganizacion+ ", :numcelular, :depto,:correoe)";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				remdes);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (DataAccessException dae) {
			logger.error("error insert:" + dae.getMessage());
			if (dae.contains(DuplicateKeyException.class)) {
				throw new DuplicateKeyException("Registro Duplicado");
			} else {
				throw new DuplicateKeyException(dae.getMessage());
			}

		}
		
        
       
    }//fin de updateEstado
    
  
}
