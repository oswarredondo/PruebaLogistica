/**
 * 
 */
package com.innovargia.salesmanager.dao.impl;

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

import com.administracion.dto.UsuarioConvenioFolio;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.ClientesDTO;
import com.innovargia.salesmanager.dtos.ConvenioContratoDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.idao.IConvenioContratoDAO;
import com.innovargia.salesmanager.mappers.ConvenioContratoRowMapper;
import com.innovargia.salesmanager.mappers.UsuarioConvenioRowMapper;
import com.innovargia.utils.ConstantesAdminSale;

/**
 * @author aruaro
 * 
 */
@Repository
public class ConvenioContratoDAO extends JdbcDaoSupport implements
		IConvenioContratoDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(ConvenioContratoDAO.class);

	final String sql_ = "select b.*,cadescuento.nombre as descripcionDescuento from (	"
			+ "	select a.*, catarifas.nombre descripcionTarifarango from "
			+ " caconvenio a left outer join catarifas ON a.idtarifa = catarifas.idtarifa	"
			+ ") b  left outer join cadescuento ON b.iddescuento = cadescuento.iddescuento ";

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ConvenioContratoDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Number insert(ConvenioContratoDTO obj) throws Exception {
		String query = "INSERT INTO caconvenio(idoficinacontrol,idtipoconvenio,idformapago,"
				+ "idmetodopago,idcliente,idpoblacionpago, idcondicionpago,idtarifarango,"
				+ "idunidadadm,login,fechadocumento,iddescuento,"
				+ "nombre,observacion,estatus,rangoenvios,idrangoenvios, idtarifa,tipo_precios,"
				+ "contacto_cte,calle_cte,numinterior_cte,numexterior_cte,cp_cte,"
				+ "colonia_cte,municipio_cte,estado_cte,fechacreacionregis,numcliente,estadoactualdoc,"
				+ " razonsocial_cte ,telefono_cte,movil_cte, email_cte,clientelicitacion,idcotizacionorigen,rfc,asegura,nombre_seguro,porcentaje_seguro) "
				+ "VALUES(:idoficinacontrol,:idtipoconvenio,:idformapago,"
				+ ":idmetodopago,:idcliente,:idpoblacionpago, :idcondicionpago,:idtarifarango,"
				+ ":idunidadadm,:login,'"
				+ obj.getFechadocumento()
				+ "',:iddescuento,"
				+ ":nombre,:observacion,:estatus,:rangoenvios,:idrangoenvios, :idtarifa,:tipo_precios,"
				+ ":contacto_cte,:calle_cte,:numinterior_cte,:numexterior_cte,:cp_cte,"
				+ ":colonia_cte,:municipio_cte,:estado_cte,current_timestamp,'',:estadoactualdoc,"
				+ ":razonsocial_cte ,:telefono_cte,:movil_cte, :email_cte,:clientelicitacion,:idcotizacionorigen,:rfc,:asegura,:nombre_seguro,:porcentaje_seguro)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "idconvenio" });
			return keyHolder.getKey();
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
	public void update(ConvenioContratoDTO obj) throws Exception {
	    
		String query = "UPDATE caconvenio SET nombre = :nombre,calle_cte=:calle_cte,"
				+ "numinterior_cte=:numinterior_cte, numexterior_cte=:numexterior_cte,"
				+ "cp_cte=:cp_cte,colonia_cte=:colonia_cte,municipio_cte=:municipio_cte,contacto_cte=:contacto_cte,"
				+ "estado_cte=:estado_cte,idtarifa=:idtarifa,tipo_precios=:tipo_precios, "
				+ "rangoenvios=:rangoenvios,idrangoenvios=:idrangoenvios, rfc=:rfc,"
				+ "representantelegal=:representantelegal, credito=:credito,"
				+ "idcliente=:idcliente,fechadocumento='"
				+ obj.getFechadocumento() + "', telefono_cte=:telefono_cte , movil_cte=:movil_cte , email_cte=:email_cte,"
				+ "razonsocial_cte=:razonsocial_cte ,"
				+ "idoficinacontrol= :idoficinacontrol,"
				+ "idtipoconvenio= :idtipoconvenio,idformapago= :idformapago,"
				+ "idmetodopago= :idmetodopago,idpoblacionpago= :idpoblacionpago, "
				+ "idcondicionpago= :idcondicionpago,idtarifarango= :idtarifarango,"
				+ "idunidadadm= :idunidadadm,iddescuento= :iddescuento,"
				+ "observacion= :observacion, clientelicitacion= :clientelicitacion, "
				+ "diaspago= :diaspago, responsable_pago= :responsable_pago, "
				+ "email_resp_pago= :email_resp_pago,  "
				+ "nombrebanco= :nombrebanco, cuentabancaria= :cuentabancaria, "
				+ "clientefirma= :clientefirma, gerentecomercialfirma= :gerentecomercialfirma, "
				+ "jefezonafirma= :jefezonafirma, coordinadorcreditocobfirma= :coordinadorcreditocobfirma, "
				+ "directoradmfinanzasfirma= :directoradmfinanzasfirma, tipo_contrato=:tipo_contrato,numcliente=:numcliente,asegura=:asegura,nombre_seguro=:nombre_seguro,porcentaje_seguro=:porcentaje_seguro,";

		 		query = query+ (obj.getFecharevision()==null?"fecharevision=null, ":"fecharevision='" +obj.getFecharevision() +"',");
				query = query+ (obj.getFechaactivacion()==null?"fechaactivacion=null, ":"fechaactivacion='" +obj.getFechaactivacion() +"',");
				query = query+ (obj.getFechainicio()==null?"fechainicio=null, ":"fechainicio='" +obj.getFechainicio() +"',");
				query = query+ (obj.getFechatermino()==null?"fechatermino=null, ":"fechatermino='" +obj.getFechatermino() +"'");
				
				query = query+ " WHERE " + " idconvenio = :idconvenio";


		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}

	}

	@Override
	public void delete(ConvenioContratoDTO obj) throws Exception {
		String query = "DELETE FROM caconvenio  WHERE  idconvenio = :idconvenio";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("Error en delete: " + dae.getMessage());
		}

	}

	
	@Override
	public List<UsuarioConvenioFolio> getConveniosUsuario(UsuarioDTO usuario)
			throws Exception {
		List<UsuarioConvenioFolio> lista = new ArrayList<UsuarioConvenioFolio>();
		//Agrega el where
		String sql = "SELECT * FROM opusuarios_convenios where numcliente='" + usuario.getNumCliente()+ "' AND "
			+ " login='" + usuario.getLogin() + "'" ;
		logger.info("sql busqueda convenios: " + sql);
		lista = jdbcTemplate.query(sql, new UsuarioConvenioRowMapper());
		return lista;
		 
	}
	
	@Override
	public void deleteUsuarioConvenioFolio(UsuarioConvenioFolio obj) throws Exception {
		String query = "DELETE FROM opusuarios_convenios  WHERE  idregistro = :idregistro";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("Error en delete: " + dae.getMessage());
		}

	}
	
	
	@Override
	public List<ConvenioContratoDTO> getRegistros(BusquedaDTO busqueda)
			throws Exception {
		List<ConvenioContratoDTO> lista = new ArrayList<ConvenioContratoDTO>();
		String sql = sql_;
		String where = "";
		switch (busqueda.getTipo()) {
		case 1: // Por nombre
			where = " b.nombre LIKE '" + busqueda.getPatron_busqueda() + "%'";
			break;
		case 2: // Por Razon Social Cliente
			where = " razonsocial_cte LIKE '" + busqueda.getPatron_busqueda()
					+ "%'";
			break;
		case 3: // Por Fecha fechadocumento
			where = " fechadocumento = '" + busqueda.getFechainicial() + "'";
			break;
		case 4: // Por idconvenio
			where = " idconvenio = " + busqueda.getPatron_busqueda();
			break;
		case 5: // Por mes
			where = " date_part('month', fechadocumento) = " + busqueda.getMes();
			break;	
		case 6: // Por login de usuario
			where = " login = '" + busqueda.getPatron_busqueda() + "'";
			break;		
		default:
			break;
		}
		// Agrega al where el tipo del documento
		if (where.trim().length() > 0) {

			where = " WHERE " + where + " AND estadoactualdoc='"
					+ ConstantesAdminSale.DOC_CONVENIO + "'";
		} else {
			where = " estadoactualdoc='" + ConstantesAdminSale.DOC_CONVENIO
					+ "'";
		}
		
		// Significa que debe traer todos los registros
		if (busqueda.getEstatus() > -1) {
			where = where + " AND b.estatus IN (" + busqueda.getRestringe_datos_a_solo_estatus() + ")";
		}

		
		
		String and_="";
		//Verifica la visibilidad de los documentos de acuerdo a la zona asignada al 
		//usuario
		if (busqueda.getUsuario().getVisibilidad() == 0) {
			if (where.trim().length()>0){
				and_=" AND ";
			}
			where +=  and_  + "  Login ='" + busqueda.getUsuario().getLogin() + "'";
		} else {
			if (where.trim().length()>0){
				and_=" AND ";
			}
			// Busca solo loc clientes que esten asignado a los grupos a los que
			// el usuario esta
			// Asignado y el nivel del usuario sea el mismo o menor al del
			// usurio de se sesi�n
			
			where +=  and_ + "  login  IN("
					+ "		SELECT distinct login FROM viewagrupacionusuarios  "
					+ "     WHERE idagrupamiento IN (SELECT idagrupamiento FROM"
					+ "		 viewagrupacionusuarios WHERE login='"+ busqueda.getUsuario().getLogin() + "' ) AND "
							+ " nivelpuesto>=" +
							busqueda.getUsuario().getNivelPuesto() + " )";

		}
		
		/*if (busqueda.getRestringe_datos_a_solo_estatus().trim().length()>0){
		    if (where.trim().length()>0){
			and_=" AND ";
		    }
		    where +=  and_  + "  Login ='" + busqueda.getUsuario().getLogin() + "'";
		}*/
		//Agrega el where
		sql += where ;
		logger.info("sql busqueda convenios: " + sql);
		lista = jdbcTemplate.query(sql, new ConvenioContratoRowMapper());
		return lista;
	}

	@Override
	public ConvenioContratoDTO get(ConvenioContratoDTO obj) throws Exception {
		String sql = sql_ + " WHERE idconvenio = ?";
		try {
			return this.jdbcTemplate.queryForObject(sql,
					new ConvenioContratoRowMapper(), obj.getIdconvenio());
		} catch (Exception dae) {
			logger.error("Error get:" + dae.getMessage());
			return null;
		}
	}

	@Override
	public void updateEstatus(ConvenioContratoDTO obj) throws Exception {
		String query = "UPDATE caconvenio SET estatus= :estatus" + " WHERE "
				+ " idconvenio = :idconvenio";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("Error en updateEstatus: " + dae.getMessage());
		}

	}

	@Override
	public void updateFirmas(ConvenioContratoDTO obj) throws Exception {
		String query = "UPDATE caconvenio SET clientefirma= :clientefirma, "
				+ "gerentecomercialfirma=:gerentecomercialfirma,"
				+ "jefezonafirma=:jefezonafirma,coordinadorcreditocobfirma=:coordinadorcreditocobfirma,"
				+ "directoradmfinanzasfirma=:directoradmfinanzasfirma,"
				+ " ejecutivoventasfirma=:ejecutivoventasfirma " + " WHERE "
				+ " idconvenio = :idconvenio";
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("Error en updateFirmas: " + dae.getMessage());
		}

		
	}
	
	@Override
	public void updateDatosRevision(ConvenioContratoDTO obj) throws Exception {
		String query = "UPDATE caconvenio SET calle_rev= :calle_rev, "
				+ "colonia_rev=:colonia_rev,"
				+ "movil_rev=:movil_rev,"
				+ "telefono_rev=:telefono_rev,"
				+ "numinterior_rev=:numinterior_rev,"
				+ "numexterior_rev=:numexterior_rev,cp_rev=:cp_rev,"
				+ "municipio_rev=:municipio_rev,estado_rev=:estado_rev,"
				+ "responsable_rev=:responsable_rev,email_resp_rev=:email_resp_rev, "
				+ "diasrevision= :diasrevision  "
				+ " WHERE  idconvenio = :idconvenio";
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				obj);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("Error en updateFirmas: " + dae.getMessage());
		}
		
		
	}

	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.IClientesDAO#update(com.innovargia.salesmanager.dtos.ClientesDTO)
	 */
	@Override
	public void updateUsuarioCreador(ConvenioContratoDTO obj) throws Exception{
		
		String query = "UPDATE caconvenio SET login= :login "
				+ " WHERE idconvenio = :idconvenio";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(obj);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch(Exception dae){
			logger.error("Error en update: " + dae.getMessage());
		}
		
		
	}
	
}
