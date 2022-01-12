/**
 * 
 */
package com.servicio.search.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.administracion.rowmapper.CruceCoberturaRowMapper;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.servicio.dtos.Zona;
import com.servicio.search.idao.IBusquedaZonaDao;

/**
 * @author Adrian Morales Ruaro
 *
 */
@Repository
public class BusquedaZonaDao  extends JdbcDaoSupport implements IBusquedaZonaDao {
	
	private static final Logger logger = LoggerFactory
			.getLogger(BusquedaZonaDao.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public BusquedaZonaDao(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
    /**
     * Manda un mensaje a la bitacora, como debug
     */
    private void debug(String mensaje){
    	logger.debug( mensaje);
    }//fin de debug
	/**
	 * 
	 */
	public BusquedaZonaDao() {
		// TODO Auto-generated constructor stub
	}
	
	 /* (non-Javadoc)
	 * @see com.servicio.search.dao.IZonaDao#getListaZonas(java.lang.String, com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
    @Override
	public ArrayList<Zona> getListaZonas(String idzona,UsuarioDTO usuario)throws SQLException {
    	ArrayList<Zona> lista = new  ArrayList<Zona> ();
    	
    	String sql = "SELECT * FROM znZona WHERE identidad=? AND idorganizacion=?  ";
        if ((idzona!=null) && (idzona.trim().length()>0)){
        	sql = sql + " AND idzona=? ";
        }
        
        
        /*PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cnx = null;
        Zona zona = null;

        try {
            cnx = Conexion.getConexionCP();
            ps = cnx.prepareStatement(sql);
            
            int index =1;
            ps.setInt(index++,usuario.entidad.getIdentidad());
            ps.setInt(index++,usuario.organizacion.getIdorganizacion());

            if ((idzona!=null) && (idzona.trim().length()>0)){
            	 ps.setString(index++,idzona);
            }
          
            rs = ps.executeQuery();
           
            while (rs.next()) {
            	zona  =new Zona();
             
            	zona.setZona(rs.getString("idzona") );
            	zona.setDescripcion(rs.getString("descripcion") );
            	zona.setResponsable(rs.getString("responsable"));
            	zona.setEmail(rs.getString("email"));
            	zona.setTelefono(rs.getString("telefono") );
            	  
            	lista.add(zona);
            }
        } catch (SQLException sq) {
            throw sq;
        } finally {
            // Cierra recursos
            Conexion.closeRecursos(rs, ps, cnx);
        }
        debug("idzona" + 5 );*/
        return lista;
    }//fin de getListaZonas
    
    /* (non-Javadoc)
	 * @see com.servicio.search.dao.IZonaDao#getZona(java.lang.String, java.lang.String, com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
    @Override
	public Zona getZona(String idestado,String idmunicipio,UsuarioDTO usuario)throws SQLException {
    	ArrayList<Zona> lista = new  ArrayList<Zona> ();
    	
    	String sql = "SELECT * FROM znzonamunicipio WHERE identidad=? AND " +
    			" idorganizacion=? AND idmunicipio=? AND idestado=? ";
     
       /* PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cnx = null;
        Zona zona = null;

        try {
            cnx = Conexion.getConexionCP();
            ps = cnx.prepareStatement(sql);
            
            int index =1;
            
            ps.setInt(index++,usuario.entidad.getIdentidad());
            ps.setInt(index++,usuario.organizacion.getIdorganizacion());
            ps.setString(index++, idmunicipio);
            ps.setString(index++, idestado);

            rs = ps.executeQuery();
            while (rs.next()) {
            	zona  =new Zona();
            	zona.setZona(rs.getString("idzona") );
            	zona.setIdmunicipio(idmunicipio);
            	zona.setIdestado(idestado);
            	zona.setReexpedicion(rs.getInt("reexpedicion") );
            	return zona;
            }
        } catch (SQLException sq) {
            throw sq;
        } finally {
            // Cierra recursos
            Conexion.closeRecursos(rs, ps, cnx);
        }*/
        return null;
    }//fin de getZona
    
    
    /* (non-Javadoc)
	 * @see com.servicio.search.dao.IZonaDao#getTarifaZonaCobertura(com.servicio.dtos.Zona, com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
    @Override
	public void getTarifaZonaCobertura(Zona zona,UsuarioDTO usuario)throws SQLException {
    	ArrayList<Zona> lista = new  ArrayList<Zona> ();
    	
    	String sql = "SELECT * FROM znTarifa WHERE identidad=? AND " +
    			" idorganizacion=? AND zonaventa=? AND idservicio=? ";
     
       /* PreparedStatement ps = null;
        ResultSet rs = null;
        Connection cnx = null;

        try {
            cnx = Conexion.getConexionCP();
            ps = cnx.prepareStatement(sql);
            
            int index =1;
            
            ps.setInt(index++,usuario.entidad.getIdentidad());
            ps.setInt(index++,usuario.organizacion.getIdorganizacion());
            ps.setString(index++, zona.getZonaVenta());
            ps.setString(index++, zona.getIdservicio());

            rs = ps.executeQuery();
            while (rs.next()) {
            	zona.setPrecio(rs.getDouble("precio"));
            	zona.setP_inicial(rs.getInt("p_inicial"));
            	zona.setP_final(rs.getInt("p_final"));
            	zona.setKgadicional(rs.getDouble("kgadicional"));
            }
        } catch (SQLException sq) {
            throw sq;
        } finally {
            // Cierra recursos
            Conexion.closeRecursos(rs, ps, cnx);
        }*/

    }//fin de getTarifaZonaCobertura
    
    @Override
   	public List<CruceCoberturaDTO> getEnrutamientos(String siglasorigen, String siglasdestino, String garantiamax) throws Exception {
    	garantiamax = ((garantiamax!=null) && (garantiamax.trim().length())>1)? garantiamax.trim().substring(0, 1):garantiamax;
    	String query = "WITH RECURSIVE obtener_transbordos AS ("+
    			 "   ("+
    			"      SELECT idcoorigen, idcodestino, kms, idservicio, transbordo, tipo_transporte,"+
    			"         COALESCE(idcoorigen,'')||'|'|| "
    			+ "			(case  when transbordo  is null  then idcodestino  else transbordo end ) ||'|' || "
    			+ "		COALESCE(tipo_transporte,'') as enrutamiento "+
    			"       FROM cacruceoperacion "+
    			"      WHERE idcoorigen= '" + siglasorigen +"' AND idcodestino='" + siglasdestino +"' "+ 
    			(garantiamax!=null && !garantiamax.isEmpty()? " and garantiamax='"+ garantiamax +"'":"")+
    			"    )"+
    			"  UNION "+
    			"   SELECT cacruceoperacion.idcoorigen, cacruceoperacion.idcodestino,  "+
    			"   cacruceoperacion.kms, cacruceoperacion.idservicio, "+
    			"   cacruceoperacion.transbordo, cacruceoperacion.tipo_transporte, "+
    			"   COALESCE(cacruceoperacion.idcoorigen,'')||'|'|| "
    			+ "	case  when cacruceoperacion.transbordo  is null  then cacruceoperacion.idcodestino  "
    			+ "	else cacruceoperacion.transbordo end ||'|' || COALESCE(cacruceoperacion.tipo_transporte,'') "
    			+ "	as enrutamiento FROM obtener_transbordos ,"+
    			"    cacruceoperacion "+
    			"      WHERE cacruceoperacion.idcoorigen= obtener_transbordos.transbordo AND "
    			+ "		cacruceoperacion.idcodestino='" + siglasdestino +"'" +  
    			(garantiamax!=null && !garantiamax.isEmpty()? " and garantiamax='"+ garantiamax +"'":"")+
    			") SELECT * from obtener_transbordos";

    	logger.debug("SQL:" + query);
   		List<CruceCoberturaDTO> lista =	this.jdbcTemplate.query(query,new CruceCoberturaRowMapper());;
   		return lista;
   		
   	}
    
    @Override
	public int getSeguro(CruceCoberturaDTO catalogo)throws SQLException {
    	
    	String sql = "SELECT CASE WHEN asegura = 1 THEN (SELECT '1'::varchar AS idservicio) ELSE (SELECT '0'::varchar  AS idservicio) END " +
    			     "FROM CACONVENIO WHERE idconvenio = '"+ catalogo.getIdservicio() +"'";
    		
    	List<CruceCoberturaDTO> lista =	this.jdbcTemplate.query(sql,new CruceCoberturaRowMapper());
    		

    	return Integer.parseInt(lista.get(0).getIdservicio());
    }
    
    @Override
	public List<CruceCoberturaDTO> validarConvenioSeguro(String numCliente)throws SQLException {
    	
    	String sql = "SELECT idconvenio AS convenio,asegura AS idservicio FROM caconvenio WHERE NOW()::date BETWEEN fechainicio AND fechatermino AND numcliente = '"+ numCliente +"'";
    		
    	List<CruceCoberturaDTO> lista =	this.jdbcTemplate.query(sql,new CruceCoberturaRowMapper());
    		

    	return lista;
    }
}