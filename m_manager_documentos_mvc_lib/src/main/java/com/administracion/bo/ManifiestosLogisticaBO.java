/**
 * 
 */
package com.administracion.bo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.consecutivos.bo.AdminConsecutivosBO;
import com.administracion.ibo.IManifiestoLogisticaBO;
import com.administracion.ibo.IParamsSistemaBO;
import com.administracion.idao.IConexionDAOJDBC;
import com.administracion.idao.IManifiestoEtiquetasDAO;
import com.administracion.jasperreport.IPrintReport;
import com.administracion.jasperreport.utils.ConstantesIReport;
import com.innovargia.salesmanager.dtos.MetaDatoCatalogoDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.Fechas;
import com.innovargia.utils.FechasTimeStamp;
import com.innovargia.utils.UtilsStrings;
import com.servicio.constantes.ConstantesGenerales;
import com.servicio.dtos.DocumentoConsultaDTO;
import com.servicio.dtos.ManifiestoDTO;

/**
 * @author Adrian Morales Ruaro
 *
 */
@Service
public class ManifiestosLogisticaBO implements IManifiestoLogisticaBO {
	private static final Logger logger = LoggerFactory.getLogger(ManifiestosLogisticaBO.class);

	private static final String idSistema = ConstantesGenerales.ID_SKY4SOL;
	@Autowired
	IManifiestoEtiquetasDAO manifiestoDAO;

	@Autowired
	AdminConsecutivosBO boConsecutivo;

	@Autowired
	IParamsSistemaBO iParamsSistemaBO;

	@Autowired
	IConexionDAOJDBC iReportesDAOJDBC;

	@Autowired
	IPrintReport iPrintReport;

	/**
	 * 
	 */
	public ManifiestosLogisticaBO() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.administracion.bo.IManifiestoLogisticaBO#getConcentradoAsignadas(com.
	 * servicio.dtos.ManifiestoDTO, com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public String generaManifiestoMovimiento(ManifiestoDTO manifiesto, UsuarioDTO usuario, String prefijo_manif)
			throws Exception {

		// Obtiene el consecutivo del manifiesto
		String doc_manif = boConsecutivo.getConsecutivoDocumento(manifiesto.getTipoDocumento(),
				usuario.entidad.getIdentidad(), usuario.organizacion.getIdorganizacion());

		// Si no existe dado de alta toma los datos de la fecha para generar un
		// consecutivo
		if (doc_manif == null) {
			doc_manif = Fechas.getFechaFormato("yyMMddhhmmssSS");
		}

		doc_manif = (prefijo_manif == null ? "" : prefijo_manif.trim().toUpperCase())
				+ UtilsStrings.completa(usuario.entidad.getIdentidad() + "", '0', 3, 1)
				+ UtilsStrings.completa(usuario.organizacion.getIdorganizacion() + "", '0', 3, 1) + doc_manif;

		manifiesto.setManifiesto(doc_manif);

		// Si llega a este punto regresa el numero de manifiesto agregado
		return doc_manif;
	}

	@Override
	public List<ManifiestoDTO> getConcentradoAsignadas(ManifiestoDTO manifiesto, UsuarioDTO usuario) throws Exception {
		return manifiestoDAO.getConcentradoCargaAsignada(manifiesto, usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.administracion.bo.IManifiestoLogisticaBO#getDetalleRuta(com.servicio.
	 * dtos.ManifiestoDTO, com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public List<DocumentoConsultaDTO> getDetalleRuta(ManifiestoDTO manifiesto, UsuarioDTO usuario) throws Exception {
		return manifiestoDAO.getDetalleRuta(manifiesto, usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.administracion.bo.IManifiestoLogisticaBO#
	 * getDetalleManifiestoEtiquetas(com.servicio.dtos.ManifiestoDTO,
	 * com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public List<DocumentoConsultaDTO> getDetalleManifiestoEtiquetas(ManifiestoDTO manifiesto, UsuarioDTO usuario)
			throws Exception {
		return manifiestoDAO.getDetalleManifiestoEtiquetas(manifiesto, usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.administracion.bo.IManifiestoLogisticaBO#
	 * consultaRegistrosParaManifiesto(com.servicio.dtos.ManifiestoDTO,
	 * com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public List<DocumentoConsultaDTO> consultaRegistrosParaManifiesto(ManifiestoDTO manifiesto, UsuarioDTO usuario)
			throws Exception {
		return manifiestoDAO.getDetalleRutaManifiesto(manifiesto, usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.administracion.bo.IManifiestoLogisticaBO#
	 * consultaRegistrosParaManifiestoEntrega(com.servicio.dtos.ManifiestoDTO,
	 * com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public List<DocumentoConsultaDTO> consultaRegistrosParaManifiestoEntrega(ManifiestoDTO manifiesto,
			UsuarioDTO usuario) throws Exception {
		return manifiestoDAO.getDetalleManifiestoentrega(manifiesto, usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.administracion.bo.IManifiestoLogisticaBO#
	 * insertManifiestoEntregaRegistros(com.servicio.dtos.ManifiestoDTO,
	 * java.util.ArrayList, com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public String insertManifiestoEntregaRegistros(ManifiestoDTO manifiesto, ArrayList<ManifiestoDTO> arr_manifiesto,
			UsuarioDTO usuario) throws Exception {

		// Obtiene el consecutivo del manifiesto
		String doc_manif = boConsecutivo.getConsecutivoDocumento(manifiesto.getTipoDocumento(),
				usuario.entidad.getIdentidad(), usuario.organizacion.getIdorganizacion());

		doc_manif = "ME" + UtilsStrings.completa(usuario.entidad.getIdentidad() + "", '0', 3, 1)
				+ UtilsStrings.completa(usuario.organizacion.getIdorganizacion() + "", '0', 3, 1) + doc_manif;

		manifiesto.setManifiesto(doc_manif);
		for (int i = 0; i < arr_manifiesto.size(); i++) {
			manifiestoDAO.insertManifiestoEntregaRegistros(arr_manifiesto.get(i), usuario, doc_manif);
		}

		// Si llega a este punto regresa el numero de manifiesto agregado
		return doc_manif;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.administracion.bo.IManifiestoLogisticaBO#
	 * updatePosicionUnidadRepartoRegistros(com.servicio.dtos.ManifiestoDTO,
	 * com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public void updatePosicionUnidadRepartoRegistros(ManifiestoDTO manifiesto, UsuarioDTO usuario) throws Exception {
		manifiestoDAO.updatePosicionUnidadRepartoRegistros(manifiesto, usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.administracion.bo.IManifiestoLogisticaBO#updateManifiestoRegistros(
	 * com.servicio.dtos.ManifiestoDTO,
	 * com.innovargia.salesmanager.dtos.UsuarioDTO, java.lang.String)
	 */
	@Override
	public String updateManifiestoRegistros(ManifiestoDTO manifiesto, UsuarioDTO usuario, String tipodocumento)
			throws Exception {

		String doc_manif = boConsecutivo.getConsecutivoDocumento(manifiesto.getTipoDocumento(),
				usuario.entidad.getIdentidad(), usuario.organizacion.getIdorganizacion());
		doc_manif = "MD" + UtilsStrings.completa(usuario.entidad.getIdentidad() + "", '0', 3, 1)
				+ UtilsStrings.completa(usuario.organizacion.getIdorganizacion() + "", '0', 3, 1) + doc_manif;

		manifiesto.setManifiesto(doc_manif);

		// Obtiene la fecha del sistema que indica la fecha en la que se esta
		// generando el manifiesto
		java.sql.Timestamp ts_FechaManifiesto = FechasTimeStamp.setTimestampNow();

		// Obtiene las fechas y las convierte
		java.sql.Timestamp ts_FechaIni = FechasTimeStamp.convertFechaToTimeStamp(manifiesto.getFechaini(), "00:00:00",
				FechasTimeStamp.FORMATO_FECHA_DD_MM_AAAA);

		java.sql.Timestamp ts_FechaFin = FechasTimeStamp.convertFechaToTimeStamp(manifiesto.getFechafin(), "23:50:00",
				FechasTimeStamp.FORMATO_FECHA_DD_MM_AAAA);

		// Ajusta
		manifiestoDAO.updateManifiestoRegistros(ts_FechaManifiesto, manifiesto.getManifiesto(), manifiesto.getRuta(),
				ts_FechaIni, ts_FechaFin, manifiesto.getEnrutamientoTransportista(), usuario, tipodocumento);

		// Si llega a este punto regresa el numero de manifiesto agregado
		return doc_manif;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.administracion.bo.IManifiestoLogisticaBO#
	 * updateManifiestoRegistrosEtiquetas(com.servicio.dtos.ManifiestoDTO,
	 * com.innovargia.salesmanager.dtos.UsuarioDTO, java.lang.String,
	 * java.lang.String[])
	 */
	@Override
	public String updateManifiestoRegistrosEtiquetas(ManifiestoDTO manifiesto, UsuarioDTO usuario, String tipodocumento,
			String[] arr_guias) throws Exception {

		String doc_manif = boConsecutivo.getConsecutivoDocumento(manifiesto.getTipoDocumento(),
				usuario.entidad.getIdentidad(), usuario.organizacion.getIdorganizacion());
		doc_manif = manifiesto.getPrefijo_manifiesto()
				+ UtilsStrings.completa(usuario.entidad.getIdentidad() + "", '0', 3, 1)
				+ UtilsStrings.completa(usuario.organizacion.getIdorganizacion() + "", '0', 3, 1) + doc_manif;

		manifiesto.setManifiesto(doc_manif);

		// Obtiene la fecha del sistema que indica la fecha en la que se esta
		// generando el manifiesto
		java.sql.Timestamp ts_FechaManifiesto = FechasTimeStamp.setTimestampNow();

		// Para cada registro de arreglo realiza la actualizacion del manifiesto
		String guia = "";
		String posicion = "";
		String[] guia_elem = null;
		ManifiestoDTO manifiesto_item = null;
		for (int i = 0; i < arr_guias.length; i++) {
			manifiesto_item = new ManifiestoDTO();
			manifiesto_item.setTipoDocumento(tipodocumento);

			guia_elem = arr_guias[i].split(",");
			manifiesto_item.setIdDocumento(guia_elem[0]);
			manifiesto_item.setPos_manif(guia_elem[1]);
			manifiesto_item.setManifiesto(doc_manif);
			if (manifiesto_item.getPos_manif() <= 0) {
				manifiesto_item.setPos_manif(32000);
			}
			if (guia_elem.length > 1) {
				manifiesto_item.setEnrutamientoTransportista(guia_elem[2]);
				manifiesto_item.setUnidadreparto(guia_elem[2]);
			}

			if (guia_elem[0].trim().length() > 0) {
				manifiestoDAO.updateManifiestoRegistrosEtiquetas(ts_FechaManifiesto, manifiesto_item, usuario,
						tipodocumento);
				manifiestoDAO.insertManifiestoEntregaRegistros(manifiesto_item, usuario, doc_manif);
			}

		}

		// Si llega a este punto regresa el numero de manifiesto agregado
		return doc_manif;
	}
	
	@Override
	public String updateManifiestoRegistrosEtiquetas(ManifiestoDTO manifiesto, 
			UsuarioDTO usuario, 
			String[] arr_guias) throws Exception {
		
		if ((manifiesto.getManifiesto()==null) || (manifiesto.getManifiesto().isEmpty())){

			String doc_manif = boConsecutivo.getConsecutivoDocumento(manifiesto.getTipoDocumento(),
					usuario.entidad.getIdentidad(), usuario.organizacion.getIdorganizacion());
			doc_manif = manifiesto.getPrefijo_manifiesto()
					+ UtilsStrings.completa(usuario.entidad.getIdentidad() + "", '0', 3, 1)
					+ UtilsStrings.completa(usuario.organizacion.getIdorganizacion() + "", '0', 3, 1) + doc_manif;

			manifiesto.setManifiesto(doc_manif);
			

		}
		//Agrega las guias
		for (String miguia : arr_guias) {
			manifiesto.setIdDocumento(miguia);
			manifiestoDAO.updateManifiestoRegistrosEtiquetas(
					null, manifiesto, usuario,
					manifiesto.getTipoDocumento());
			
			//Inserta los registros de entrega al manifiesto
			manifiestoDAO.insertManifiestoEntregaRegistros(manifiesto, 
					usuario, manifiesto.getManifiesto());
		}
	

		
		return manifiesto.getManifiesto();
		
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.administracion.bo.IManifiestoLogisticaBO#generarManifiestoPDF(com.
	 * servicio.dtos.ManifiestoDTO, java.util.Map,
	 * com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public byte[] generarManifiestoPDF(ManifiestoDTO manifiesto, Map<String, Object> parameters, UsuarioDTO usuario) {

		byte[] bytes = null;
		Connection cnx = null;
		try {

			// Guarda el archivo
			logger.debug("Generando reporte tipo :" + manifiesto.getTipoDocumento());
			String path_formatos_reporte_jasper = iParamsSistemaBO
					.getValorPropiedad(ConstantesGenerales.PATHIREPORTJASPER, ConstantesGenerales.ID_SKY4SOL);
			logger.debug("path_formatos_reporte_jasper :" + path_formatos_reporte_jasper);

			MetaDatoCatalogoDTO metaDocumento = boConsecutivo.getMetaDatoCatalogoDTO(manifiesto.getTipoDocumento(),
					usuario.entidad.getIdentidad(), usuario.organizacion.getIdorganizacion());
			logger.debug("Generando reporte tipo :" + metaDocumento.getFormatoiReport());

			if (metaDocumento != null) {
				String reportejasper = path_formatos_reporte_jasper + metaDocumento.getFormatoiReport();
				logger.debug("reportejasper :" + reportejasper);
				cnx = iReportesDAOJDBC.getConexion();
				bytes = iPrintReport.genera(ConstantesIReport.TIPO_PDF, parameters, reportejasper, cnx);

			}

			/*
			 * ByteArrayOutputStream byteArrayOutputStream = new
			 * ByteArrayOutputStream(); JasperPrint print =
			 * JasperFillManager.fillReport( reportejasper, parameters, cnx);
			 * JRExporter exporter = new
			 * net.sf.jasperreports.engine.export.JRPdfExporter();
			 * 
			 * exporter.setParameter(JRExporterParameter.JASPER_PRINT,print);
			 * exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,
			 * byteArrayOutputStream); exporter.exportReport(); bytes =
			 * byteArrayOutputStream.toByteArray();
			 * 
			 */

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			iReportesDAOJDBC.closeConecction(cnx);
		}
		return bytes;

	}

}
