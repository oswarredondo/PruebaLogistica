package com.innovargia.salesmanager.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.administracion.rowmapper.DocumentoConsultaDTORowMapper;
import com.innovargia.documentos.dtos.Envio;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.idao.IRotulacionEtiquetasDatosDAO;
import com.innovargia.utils.UUIDUniqueCreator;

@Repository
public class RotularEtiquetaDAO extends JdbcDaoSupport implements IRotulacionEtiquetasDatosDAO {

	final String sql_ = "SELECT identificador,idadicional AS clave,"
			+ " descripcion,estatus,precio, tipo,tipoincremento FROM caadicional";

	private static final Logger logger = LoggerFactory.getLogger(RotularEtiquetaDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public RotularEtiquetaDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void UpdateDocumentoUnigis(String iddocumento, int unigis_status) {

		String query = "UPDATE cadocumentos SET unigis_status = :unigis_status WHERE iddocumento = :iddocumento";

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("unigis_status", unigis_status);
		parameterSource.addValue("iddocumento", iddocumento);

		try {

			this.namedParameterJdbcTemplate.update(query, parameterSource);

		} catch (Exception dae) {

			logger.error("Error en update: " + dae.getMessage());

		}

	}

	@Override
	public String getDeposito(String codigo) {

		String deposito = "";

		String query = "SELECT idagrupador FROM frecuenciasentrega WHERE d_codigo = '" + codigo
				+ "' AND garantiamax = '2'";

		try {

			deposito = jdbcTemplate.queryForObject(query, String.class);

		} catch (Exception dae) {

			logger.error("Error en update: " + dae.getMessage());

		}

		return deposito;

	}

	@Override
	public String getFehaCreacion(String iddocumento) {

		String FCreacion = "";

		String query = "SELECT fechacreacion FROM cadocumentos WHERE iddocumento = '" + iddocumento + "'";

		try {

			FCreacion = jdbcTemplate.queryForObject(query, String.class);

		} catch (Exception dae) {

			logger.error("Error en update: " + dae.getMessage());

		}

		return FCreacion;
	}

	public String getDirection(Envio etiquetaRotulacionDTO) {

		List<String> lstRemDes = new ArrayList<>();
		
		String idremdes = "";

		try {

			String query = "SELECT idremdes FROM CAREMDES WHERE numcliente = '" + etiquetaRotulacionDTO.getNumCliente()
					+ "' AND razonsocial = '" + etiquetaRotulacionDTO.getRazonSocialDe() + "' " + "AND colonia = '"
					+ etiquetaRotulacionDTO.getColoniaDe() + "' AND ciudad = '" + etiquetaRotulacionDTO.getMunicipioDe()
					+ "' AND estado = '" + etiquetaRotulacionDTO.getEstadoDe() + "' " + "AND cp = '"
					+ etiquetaRotulacionDTO.getCpDe()
					+ "' AND municipio = '" + etiquetaRotulacionDTO.getMunicipioDe() + "' " + "AND numinterior = '"
					+ etiquetaRotulacionDTO.destinatario.getNuminterior() + "' AND numexterior = '"
					+ etiquetaRotulacionDTO.destinatario.getNumexterior() + "' "
					+ "AND tipodireccion = 'DES' ORDER BY fechacreacion DESC LIMIT 1";

			lstRemDes = this.jdbcTemplate.query(query, new RowMapper() {
			      public Object mapRow(ResultSet resultSet, int i) throws SQLException {
			          return resultSet.getString(1);
			        }
			      });

			if (lstRemDes.size() == 0) {

				 idremdes = UUIDUniqueCreator.generateUUID();

				query = "INSERT INTO caremdes( numcliente, idremdes," + " razonsocial, direccion, colonia, "
						+ "  ciudad, estado, cp, telefono, municipio, rfc," + " identidad, idorganizacion, "
						+ " tipodireccion,numinterior,numexterior,"
						+ "celular,plazaoficina,login,fechacreacion,correoe)" + "    VALUES ('"
						+ etiquetaRotulacionDTO.getNumCliente() + "','" + idremdes + "' , '"
						+ etiquetaRotulacionDTO.getRazonSocialDe() + "', '"
						+ etiquetaRotulacionDTO.destinatario.getCalle() + "', '" + etiquetaRotulacionDTO.getColoniaDe()
						+ "', " + "'" + etiquetaRotulacionDTO.getMunicipioDe() + "', '"
						+ etiquetaRotulacionDTO.getEstadoDe() + "', '" + etiquetaRotulacionDTO.getCpDe() + "', '"
						+ etiquetaRotulacionDTO.getTelefonoDe() + "', '" + etiquetaRotulacionDTO.getMunicipioDe()
						+ "', '" + etiquetaRotulacionDTO.getRFCDe() + "', '"
						+ etiquetaRotulacionDTO.destinatario.getIdentidad() + "', '"
						+ etiquetaRotulacionDTO.destinatario.getIdorganizacion() + "',  " + "'DES','"
						+ etiquetaRotulacionDTO.destinatario.getNuminterior() + "','"
						+ etiquetaRotulacionDTO.destinatario.getNumexterior() + "','"
						+ etiquetaRotulacionDTO.destinatario.getTelefono2()
						+ "',(SELECT siglasplaza FROM caUsuarios WHERE login ='" + etiquetaRotulacionDTO.getNumCliente()
						+ "'),'" + etiquetaRotulacionDTO.getNumCliente() + "', current_timestamp,'"
						+ etiquetaRotulacionDTO.destinatario.getCorreoe() + "')";

				jdbcTemplate.execute(query);

			}else{
				
				idremdes = lstRemDes.get(0);
				
			}
			
			

		} catch (Exception dae) {

			logger.error("Error en update: " + dae.getMessage());

		}

		return idremdes;
	}
}
