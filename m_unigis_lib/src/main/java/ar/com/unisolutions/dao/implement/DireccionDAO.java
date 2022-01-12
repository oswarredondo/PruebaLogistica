package ar.com.unisolutions.dao.implement;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import ar.com.unisolutions.rowmapper.RemDesRowMapper;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.utils.UUIDUniqueCreator;

import ar.com.unisolutions.dao.IDireccionDAO;
import ar.com.unisolutions.dto.Direccion;
import ar.com.unisolutions.rowmapper.DireccionRowMapper;

@Repository
public class DireccionDAO extends JdbcDaoSupport implements IDireccionDAO {

	private static final Logger logger = LoggerFactory.getLogger(MercanciaDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public DireccionDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Direccion getDireccionDescripcion(int codigoPostal) throws Exception {

		try {
			String query = "SELECT C.c_cp, E.Descripcion AS estado, M.Descripcion as municipio FROM gbcodigopostal AS C "
					+ "INNER JOIN gbestado AS E ON C.c_estado = E.clave_sat "
					+ "INNER JOIN gbmunicipio AS M ON C.c_municipio = M.clave_sat AND E.idestado = M.idestado "
					+ "WHERE C.c_cp = ? LIMIT 1";

			return this.jdbcTemplate.queryForObject(query, new Object[] { codigoPostal }, new DireccionRowMapper());

		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
	}

	@Override
	public String getDirection(EtiquetaRotulacionDTO etiquetaRotulacionDTO) throws Exception {

		int validar;

		String idremdes;

		try {

			String sql = "SELECT COUNT(idremdes) FROM CAREMDES WHERE numcliente = '"
					+ etiquetaRotulacionDTO.getNumcliente() + "' AND login = '" + etiquetaRotulacionDTO.getLogin()
					+ "' AND razonsocial = '" + etiquetaRotulacionDTO.getRazonsocial_des() + "' " + "AND colonia = '"
					+ etiquetaRotulacionDTO.getColonia_des() + "' AND ciudad = '"
					+ etiquetaRotulacionDTO.getCiudad_des() + "' AND estado = '" + etiquetaRotulacionDTO.getEstado_des()
					+ "' " + "AND cp = '" + etiquetaRotulacionDTO.getCp_des() + "' AND telefono = '"
					+ etiquetaRotulacionDTO.getTelefono_des() + "' AND municipio = '"
					+ etiquetaRotulacionDTO.getMunicipio_des() + "' " + "AND numinterior = '"
					+ etiquetaRotulacionDTO.getNuminterior_des() + "' AND numexterior = '"
					+ etiquetaRotulacionDTO.getNumexterior_des() + "' ";

			validar = this.jdbcTemplate.queryForObject(sql, Integer.class);

			if (validar == 0) {

				idremdes = UUIDUniqueCreator.generateUUID();

				sql = "INSERT INTO caremdes( numcliente, idremdes,razonsocial, direccion, colonia, "
						+ "ciudad, estado, cp, telefono, municipio, rfc, identidad, idorganizacion, "
						+ "tipodireccion,numinterior,numexterior,"
						+ "celular,plazaoficina,login,fechacreacion,correoe) VALUES (:numcliente,'" + idremdes
						+ "',:razonsocial_des, :calle_des,"
						+ ":colonia_des, :ciudad_des, :estado_des,:cp_des,:telefono_des,:municipio_des,:rfc_des, :identidad,:idorganizacion,'DES',"
						+ ":numinterior_des,:numexterior_des,:celular_des,"
						+ "(SELECT siglasplaza FROM caUsuarios WHERE login =:numcliente),:login, CURRENT_TIMESTAMP,:email_des)";

				// Datos administracion de documentos
				SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(etiquetaRotulacionDTO);

				this.namedParameterJdbcTemplate.update(sql, parameterSource);

			} else {

				sql = "SELECT idremdes FROM CAREMDES WHERE numcliente = '" + etiquetaRotulacionDTO.getNumcliente()
						+ "' AND razonsocial = '" + etiquetaRotulacionDTO.getRazonsocial_des() + "' "
						+ "AND colonia = '" + etiquetaRotulacionDTO.getColonia_des() + "' AND ciudad = '"
						+ etiquetaRotulacionDTO.getCiudad_des() + "' AND estado = '"
						+ etiquetaRotulacionDTO.getEstado_des() + "' " + "AND cp = '"
						+ etiquetaRotulacionDTO.getCp_des() + "' AND telefono = '"
						+ etiquetaRotulacionDTO.getTelefono_des() + "' AND municipio = '"
						+ etiquetaRotulacionDTO.getMunicipio_des() + "' " + "AND numinterior = '"
						+ etiquetaRotulacionDTO.getNuminterior_des() + "' AND numexterior = '"
						+ etiquetaRotulacionDTO.getNumexterior_des() + "' "
						+ "AND tipodireccion = 'DES' ORDER BY fechacreacion DESC LIMIT 1";

				idremdes = this.jdbcTemplate.queryForObject(sql, String.class);

			}

			return idremdes;

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		}
	}

	@Override
	public String getSistemaEnvio(String idguia) throws Exception {

		try {
			String query = "SELECT sistema::TEXT FROM cadocumentos WHERE IDDOCUMENTO = ? LIMIT 1";

			return this.jdbcTemplate.queryForObject(query, new Object[] { idguia }, String.class);

		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void setLatLng(String lat, String lng, String idRemDes) {

		String query = "Update caremdes SET latitud = :lat, longitud = :lng WHERE idremdes = :idremdes";

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("lat", lat);
		parameterSource.addValue("lng", lng);
		parameterSource.addValue("idremdes", idRemDes);

		try {

			this.namedParameterJdbcTemplate.update(query, parameterSource);

		} catch (Exception dae) {

			logger.error("Error en update: " + dae.getMessage());

		}

	}

	@Override
	public List<RemDes> getDireccionRemDes(String uuid) throws Exception {
		
		try {
			
			List<RemDes> lista = new ArrayList<RemDes>();
			
			//String query = "SELECT latitud,longitud FROM caremdes WHERE idremdes = :uuid";
			
			String query = "SELECT * FROM caremdes WHERE idremdes = :uuid";
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			
			params.addValue("uuid", uuid);

			lista = this.namedParameterJdbcTemplate.query(query,params, new RemDesRowMapper());
			
			return lista;

		} catch (Exception e) {

			throw new Exception(e.getMessage());
		}
	}

	@Override
	public int getReexpedicion(String codigoPostal) throws Exception {
		
		int reexpedicion = 0; 
				
		try {

			String query = "SELECT frecuenciasentrega.reexpedicion_e FROM frecuenciasentrega WHERE frecuenciasentrega.d_codigo = ? LIMIT 1";

			reexpedicion = this.jdbcTemplate.queryForObject(query, new Object[] { codigoPostal }, Integer.class);

			return reexpedicion;
			
		} catch (Exception e) {

			//throw new Exception(e.getMessage());
		    return reexpedicion;
		}
		
	}
}
