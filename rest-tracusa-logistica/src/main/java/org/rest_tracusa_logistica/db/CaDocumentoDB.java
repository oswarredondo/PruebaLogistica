package org.rest_tracusa_logistica.db;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.rest_tracusa_logistica.struct.Guide;
//import org.glassfish.jersey.internal.util.Base64;
import org.rest_tracusa_logistica.struct.UserKey;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.UUIDUniqueCreator;

public class CaDocumentoDB {

	public static String getExistDocumentGuia(String idCliente, String reference, String observations, Connect conn)
			throws Exception {

		try {
			conn.initDbConnection();
			ResultSet rsCaDoc = conn.select(
					"SELECT * FROM cadocumentos WHERE numcliente = '" + idCliente + "' AND referencia = '" + reference
							+ "' " + "AND observacion = '" + observations + "' ORDER BY (fechacreacion) DESC LIMIT 1");
			if (rsCaDoc.next())
				return rsCaDoc.getString("idDocumento");
			else
				return "";
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			conn.cerrarConexion();
		}
	}

	public static String getUsuarioFlexi(String idCliente, String reference, String observations, Connect conn)
			throws Exception {

		try {
			conn.initDbConnection();
			// ResultSet rsCaDoc = conn.select("SELECT COUNT(*)::varchar AS aux
			// FROM cacuenta WHERE razonsocial LIKE '%WAL%' AND numcliente = '"
			// + idCliente + "'");
			ResultSet rsCaDoc = conn
					.select("SELECT COUNT(*)::varchar AS aux FROM cacuenta WHERE razonsocial LIKE '%FLEXI%' AND numcliente = '"
							+ idCliente + "'");
			if (rsCaDoc.next())
				return rsCaDoc.getString("aux");
			else
				return "";
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			conn.cerrarConexion();
		}
	}

	public static String getUsuarioWalmart(String idCliente, String reference, String observations, Connect conn)
			throws Exception {

		try {
			conn.initDbConnection();
			ResultSet rsCaDoc = conn
					.select("SELECT COUNT(*)::varchar AS aux FROM cacuenta WHERE razonsocial LIKE '%WAL%' AND numcliente = '"
							+ idCliente + "'");
			// ResultSet rsCaDoc = conn.select("SELECT COUNT(*)::varchar AS aux
			// FROM cacuenta WHERE razonsocial LIKE '%FLEXI%' AND numcliente =
			// '" + idCliente + "'");
			if (rsCaDoc.next())
				return rsCaDoc.getString("aux");
			else
				return "";
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			conn.cerrarConexion();
		}
	}

	public static List<EtiquetaRotulacionDTO> getConvenioTarifa(String idCliente, String idServicio, Connect conn)
			throws Exception {

		try {

			conn.initDbConnection();

			ResultSet rsCT = conn
					.select("SELECT a.idconvenio, b.idtarifa FROM caconvenio AS a INNER JOIN catarifas AS b ON a.idtarifa = b.idtarifa WHERE b.idservicio = '"
							+ idServicio
							+ "' AND idconvenio IN (SELECT idconvenio FROM opusuarios_convenios WHERE numcliente IN ('"
							+ idCliente
							+ "')) AND current_date>=a.fechainicio AND current_date<=a.fechatermino LIMIT 1");

			List<EtiquetaRotulacionDTO> lista_temp = new ArrayList<EtiquetaRotulacionDTO>();
			EtiquetaRotulacionDTO modelo_temp = new EtiquetaRotulacionDTO();
			;

			if (rsCT.next()) {
				modelo_temp.setIdconvenio(rsCT.getInt("idconvenio"));
				modelo_temp.setIdtarifa(rsCT.getInt("idtarifa"));
				lista_temp.add(modelo_temp);
				return lista_temp;
			} else {
				return lista_temp;
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			conn.cerrarConexion();
		}
	}

	public static String cotizacion(String cporigen, String cpdestino, UsuarioDTO usuario, Connect conn)
			throws Exception {

		String cotizacion = "";

		try {

			conn.initDbConnection();


			 ResultSet rsCaDoc = conn.select("SELECT cotizarPrecio('"+
			 cporigen +"','"+ cpdestino +"',"+ usuario.entidad.getIdentidad()
			 +""+ usuario.organizacion.getIdorganizacion() +",'"+
			 usuario.getNumCliente() +"','" + usuario.getLogin() + "')");

			//ResultSet rsCaDoc = conn.select("SELECT cotizarPrecio('36100','72420',1,1,'100476','TCO9471742')");

			if (rsCaDoc.next()) {

				cotizacion = rsCaDoc.getString("cotizarprecio");

			} else {

				cotizacion = "";

			}

			if (cotizacion == null || cotizacion.equals("")) {

				throw new Exception("Cotizacion vacia");

			} else {

				return cotizacion;

			}

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		} finally {

			conn.cerrarConexion();

		}

	}

	public static void setLog(UsuarioDTO usuario, Guide joGuide, int tipo, Connect conn) throws Exception {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		ResultSet rsCaDoc;

		String datos_json = gson.toJson(joGuide);

		try {

			if (usuario != null) {

				conn.initDbConnection();

				rsCaDoc = conn.select("SELECT procesarLOG(" + joGuide.getIdLOG() + ",'" + usuario.getNumCliente()
						+ "','" + usuario.getLogin() + "','" + datos_json + "','" + tipo + "')");

				if (rsCaDoc.next()) {

					joGuide.setIdLOG(String.valueOf(rsCaDoc.getInt("procesarlog")));

				} else {

					throw new Exception("Error al insertar en LOG");

				}

			}

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		} finally {

			conn.cerrarConexion();

		}

	}

	public static void updateLog(Guide joGuide, String iddocumento, Connect conn) throws Exception {

		String sql = "";
		
		conn.initDbConnection();

		try {

			conn.initDbConnection();

			sql = "UPDATE calog SET iddocumento = '"+ iddocumento +"', tipo_documento = '1', evento = '2' WHERE idlog = "+ joGuide.getIdLOG();

			conn.insert(sql);

		} catch (

		Exception e) {

			throw new Exception(e.getMessage());

		} finally {

			conn.cerrarConexion();

		}

	}

	public static String getDirection(EtiquetaRotulacionDTO etiquetaRotulacionDTO, Connect conn) throws Exception {

		String idremdes = "";

		try {

			String sql = "SELECT idremdes FROM CAREMDES WHERE numcliente = '" + etiquetaRotulacionDTO.getNumcliente()
					+ "' AND razonsocial = '" + etiquetaRotulacionDTO.getRazonsocial_des() + "' " + "AND colonia = '"
					+ etiquetaRotulacionDTO.getColonia_des() + "' AND ciudad = '"
					+ etiquetaRotulacionDTO.getCiudad_des() + "' AND estado = '" + etiquetaRotulacionDTO.getEstado_des()
					+ "' " + "AND cp = '" + etiquetaRotulacionDTO.getCp_des() + "' AND telefono = '"
					+ etiquetaRotulacionDTO.getTelefono_des() + "' AND municipio = '"
					+ etiquetaRotulacionDTO.getMunicipio_des() + "' " + "AND numinterior = '"
					+ etiquetaRotulacionDTO.getNuminterior_des() + "' AND numexterior = '"
					+ etiquetaRotulacionDTO.getNumexterior_des() + "' "
					+ "AND tipodireccion = 'DES' ORDER BY fechacreacion DESC LIMIT 1";

			conn.initDbConnection();

			ResultSet rsCaDoc = conn.select(sql);

			if (rsCaDoc.next()) {

				idremdes = rsCaDoc.getString("idremdes");

			}

			if (idremdes.equals("")) {

				idremdes = UUIDUniqueCreator.generateUUID();

				sql = "INSERT INTO caremdes( numcliente, idremdes," + " razonsocial, direccion, colonia, "
						+ "  ciudad, estado, cp, telefono, municipio, rfc," + " identidad, idorganizacion, "
						+ " tipodireccion,numinterior,numexterior,"
						+ "celular,plazaoficina,login,fechacreacion,correoe)" + "    VALUES ('"
						+ etiquetaRotulacionDTO.getNumcliente() + "','" + idremdes + "' , '"
						+ etiquetaRotulacionDTO.getRazonsocial_des() + "', '" + etiquetaRotulacionDTO.getCalle_des()
						+ "', '" + etiquetaRotulacionDTO.getColonia_des() + "', " + "'"
						+ etiquetaRotulacionDTO.getCiudad_des() + "', '" + etiquetaRotulacionDTO.getEstado_des()
						+ "', '" + etiquetaRotulacionDTO.getCp_des() + "', '" + etiquetaRotulacionDTO.getTelefono_des()
						+ "', '" + etiquetaRotulacionDTO.getMunicipio_des() + "', '"
						+ etiquetaRotulacionDTO.getRfc_des() + "', '" + etiquetaRotulacionDTO.getIdentidad() + "', '"
						+ etiquetaRotulacionDTO.getIdorganizacion() + "',  " + "'DES','"
						+ etiquetaRotulacionDTO.getNuminterior_des() + "','"
						+ etiquetaRotulacionDTO.getNumexterior_des() + "','" + etiquetaRotulacionDTO.getCelular_des()
						+ "',(SELECT siglasplaza FROM caUsuarios WHERE login ='" + etiquetaRotulacionDTO.getNumcliente()
						+ "'),'" + etiquetaRotulacionDTO.getNumcliente() + "', current_timestamp,'"
						+ etiquetaRotulacionDTO.getEmail_des() + "')";

				conn.insert(sql);

			}

			return idremdes;

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		} finally {

			conn.cerrarConexion();

		}
	}
}
