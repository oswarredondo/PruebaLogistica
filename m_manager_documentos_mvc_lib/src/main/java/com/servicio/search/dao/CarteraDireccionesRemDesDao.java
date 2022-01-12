package com.servicio.search.dao;

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
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.administracion.rowmapper.RemDesRowMapper;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.dtos.UsuarioCuentaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.mappers.UsuarioCuentaRowMapper;
import com.innovargia.utils.JsonPrint;
import com.servicio.constantes.CondicionNivelPerfil;
import com.servicio.search.idao.ICarteraDireccionesRemDesDao;

/**
 *<CODE>
 * Manejo de los datos de C�digos Postales
 *</CODE>
 *
 * @author Adrian Morales Ruaro
 * @version $Id: $
 */
@Repository
public class CarteraDireccionesRemDesDao  extends JdbcDaoSupport implements ICarteraDireccionesRemDesDao {
	
	private static final Logger logger = LoggerFactory
			.getLogger(CarteraDireccionesRemDesDao.class);
    

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public CarteraDireccionesRemDesDao(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	/* (non-Javadoc)
	 * @see com.servicio.search.dao.ICarteraDireccionesRemDesDao#getDirecconesRemDes(com.innovargia.salesmanager.dtos.BusquedaDTO)
	 */
	@Override
	public List<RemDes> getDirecconesRemDes(BusquedaDTO busqueda, UsuarioDTO usuario)throws SQLException {
	     if (busqueda.getTipo()<=0){
		 busqueda.setTipo(1);
	     }
		
		return busquedaRemDes( busqueda,  usuario);
    }
	@Override
	public List<RemDes> busquedaRemDes(BusquedaDTO busqueda, UsuarioDTO usuario)throws SQLException{
		
		List<RemDes> lista = new ArrayList<RemDes>();
		String sql ="";
		if (busqueda.isIspdv()){
		    sql = "SELECT * FROM caremdes WHERE ispdv=true  ";
		}else{
		    sql =" SELECT * FROM (	"
				+ "  	SELECT viewagrupacionusuarios.nivelpuesto,viewagrupacionusuarios.idperfil,"
				+ "		viewagrupacionusuarios.siglasplaza as siglasusuario,caremdes.* "
				+ "		FROM caremdes JOIN viewagrupacionusuarios ON "
				+ "		caremdes.login = viewagrupacionusuarios.login and "
				+ "		caremdes.identidad = viewagrupacionusuarios.identidad and"
				+ " 	caremdes.idorganizacion = viewagrupacionusuarios.idorganizacion and "
				+ "		caremdes.numcliente = viewagrupacionusuarios.numcliente AND "
				+ "		COALESCE(caremdes.ispdv,false)=false "
				+ ") datos WHERE "; 
		  //Todos los usuarios del agrupamiento
			if (usuario.getVisibilidad() == 0) {
				sql +=   "  login=:login  " ; //Solo muestra los datos de la siglas del usuario
			}else{
				//Puede ver toda la info de su nivel para abajo
				sql +=   "  nivelpuesto>= :nivelPuesto and numcliente=:numcliente";
			}
			
			if (CondicionNivelPerfil.condicionNivelUsuario(usuario) != null){
				sql += " AND " +CondicionNivelPerfil.condicionNivelUsuario(usuario);
			}else{
				logger.debug("No existe NIvel del perfil del usuario");
				return lista;    
			}
		}
		
		
		//Configura el tipo de busqueda
		String patron = busqueda.getPatron_busqueda() + "%";
		switch (busqueda.getTipo()) {
			case 1://Por Razon Social
				sql = sql + " AND razonsocial like :patron";
				break;
			case 2://Atenci�n
				sql = sql + " AND atencion like :patron";
				break;
			case 3://Calle
				sql = sql + " AND direccion like :patron";
				break;
			case 4://Colonia
				sql = sql + " AND colonia like :patron";
				break;	
			case 5://CP
//				patron = busqueda.getPatron_busqueda() ;
//				sql = sql + " AND cp = :patron";
				sql = sql + " AND cp like :patron";
				break;	
			case 6://RFC
				sql = sql + " AND rfc like :patron'";
				break;	
				
			case 7://Estado
				sql = sql + " AND estado like :patron";
				break;	
			case 8://municipio
				//sql = sql + " AND municipio like :patron";
				sql = sql + " AND ciudad like :patron";
				break;
			case 9://tel
				sql = sql + " AND telefono like :patron "
					+ "OR celular like :patron";
				break;			
			default:
				return lista;    
		}
		
		/** Verifica el tipo de consulta a realizar */
		if ("REM".equals(busqueda.getTipo_str())){
			sql = sql + " AND tipodireccion IN ('REM', 'AMBOS') ";
		}else if ("DES".equals(busqueda.getTipo_str())){
			sql = sql + " AND tipodireccion IN ('DES' , 'AMBOS')";
		}else if ("FAC".equals(busqueda.getTipo_str())){
			sql = sql + " AND tipodireccion IN ('FAC', 'AMBOS')";
		}
		
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("numcliente", usuario.getNumCliente());
		if(busqueda.getNumcliente() == null){
			params.addValue("login", usuario.getLogin());
		}else{
			params.addValue("login", busqueda.getNumcliente());
		}
		params.addValue("patron", patron);
		params.addValue("nivelPuesto", usuario.getNivelPuesto());
		
		logger.info("Busqueda direcciones:" + sql);
		JsonPrint.show(params);
		
		lista = this.namedParameterJdbcTemplate.query(sql,params, new RemDesRowMapper());
		
		return lista;
	}
	

    /* (non-Javadoc)
	 * @see com.servicio.search.dao.ICarteraDireccionesRemDesDao#insert(com.innovargia.salesmanager.dtos.RemDes)
	 */
	@Override
	public void insert(RemDes objeto, UsuarioDTO usuario) throws Exception {

		List<RemDes> lista = new ArrayList<RemDes>();
		
		/* Esta consulta nos ayuda con 2 cosas
		 * 1.- Para validar que exista el usuario al que vamos a insertar las direcciones dentro de la entidad y organisacion 
		 * del usuario que realiza el proceso
		 * 2.- Para validar que si dicho usuario ya existe no inserte una direccion repetida
		 * Funcion: Mediante un WHEN CASE primero verificamos que exista en la entidad y organizacion haciendo un select count
		 * si el conut devuelve 1 es decir que si existe y prosigue con el WHEN haciendo un select count al usuario con where en sus datos
		 * si el usuario devuelve mas de 1 o 1 quiere decir que ya existe dicha direccion agregada , si devuelve 0 quiere decir que
		 * no existe y podemos agregar la direccion */
		String queryValidar = "SELECT CASE WHEN validar = '1' THEN " + 
				"(SELECT ((count(*))::varchar)numcliente from CAREMDES " + 
				"WHERE login = '"+ objeto.getNumCliente() +"' AND identidad = :identidad AND idorganizacion = :idorganizacion " + 
				"AND numCliente = '" + usuario.getNumCliente() + "' AND rfc = :rfc AND direccion = :calle " +  
				"AND razonsocial = :razonSocial AND numexterior = :numexterior AND cp = :cp " + 
				"AND colonia = :colonia AND municipio = :municipio AND tipodireccion = :tipoDireccion) " + 
				"ELSE " + 
				"(select ((1)::varchar)numcliente) END " +  
				"from (select ((count(*))::varchar)validar from causuarios where login = '"+ objeto.getNumCliente() +"' AND identidad = '"+ objeto.getIdentidad() +"' AND idorganizacion = '" + objeto.getIdorganizacion() + "' AND numCliente = '"+ usuario.getNumCliente() +"')DATOS";
						
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(objeto);
		
		lista = this.namedParameterJdbcTemplate.query(queryValidar, parameterSource, new RemDesRowMapper());
		
		/*Mediante la validacion del query sabemos que si el numCliente = 1 no debemos insertar y si es 0 proseguimos con la insercion*/
		if (Integer.parseInt(lista.get(0).getNumCliente()) == 0) {
			
			/*Insert a direcciones*/
			String query = "INSERT INTO caremdes( numcliente, idremdes,"
					+ " razonsocial, atencion, direccion, colonia, " + "  ciudad, estado, cp, telefono, municipio, rfc,"
					+ " identidad, idorganizacion, " + " tipodireccion,numinterior,numexterior,"
					+ "celular,plazaoficina,login,fechacreacion,correoe,ispdv, latitud, longitud)" + "    VALUES ('"
					+ usuario.getNumCliente() + "', :idRmDes, :razonSocial, :atencion, :calle, :colonia, "
					+ "   :ciudad, :estado, :cp, :telefono, :municipio, :rfc, :identidad, :idorganizacion,  "
					+ ":tipoDireccion,:numinterior,:numexterior,:numcelular,(SELECT siglasplaza FROM caUsuarios WHERE login ='"
					+ objeto.getNumCliente() + "'),'" + objeto.getNumCliente()
					+ "', current_timestamp,:correoe, :pdv, :latitud, :longitud)";

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

		}

	}
    
    @Override
   	public void update(RemDes objeto) throws Exception {

   		String query = "UPDATE caremdes SET "
   				+ " razonsocial=:razonSocial, atencion=:atencion, direccion=:calle, colonia=:colonia, "
   				+ "  ciudad=:ciudad, estado=:estado, cp=:cp, telefono=:telefono, "
   				+ " municipio=:municipio, rfc=:rfc,tipodireccion=:tipoDireccion,"
   				+ " numinterior=:numinterior,numexterior=:numexterior,celular=:numcelular,"
   				+ " correoe=:correoe  WHERE idregistro = "+ objeto.getIdregistro();
   		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(objeto);

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
   		
   	}


	@Override
	public void delete(RemDes objeto) throws Exception {
		String query = "DELETE FROM caremdes  WHERE idregistro = "+ objeto.getIdregistro();
   		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(objeto);

   		try {
   			this.namedParameterJdbcTemplate.update(query, parameterSource);

   		} catch (DataAccessException dae) {
   			logger.error("error insert:" + dae.getMessage());
   			
   		}
		
	}
    
 }
