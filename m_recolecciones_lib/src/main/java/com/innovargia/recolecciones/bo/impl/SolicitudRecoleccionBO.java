/**
 * 
 */
package com.innovargia.recolecciones.bo.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.dto.DiasSemanaMes;
import com.administracion.dto.SolicitudRecoleccion;
import com.administracion.ibo.IAdminConsecutivosBO;
import com.administracion.idao.IConexionDAOJDBC;
import com.administracion.idao.IParamsSistemaDAO;
import com.administracion.jasperreport.IPrintReport;
import com.administracion.jasperreport.utils.ConstantesIReport;
import com.innovargia.documentos.dtos.Frecuencias;
import com.innovargia.recolecciones.ibo.ISolicitudRecoleccionBO;
import com.innovargia.recolecciones.idao.ISolicitudRecoleccionDAO;
import com.innovargia.recolecciones.mappers.Estatus;
import com.innovargia.salesmanager.dtos.MetaDatoCatalogoDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.utils.Fechas;
import com.servicio.constantes.ConstantesGenerales;
import com.servicio.dtos.Movimiento;
import com.servicio.dtos.Ruta;
import com.servicio.search.ibo.IBusquedaFrecuenciasBO;

/**
 * @author Adrian Morales Ruaro
 * 
 */
@Service
public class SolicitudRecoleccionBO implements ISolicitudRecoleccionBO {

	private static final Logger logger = LoggerFactory.getLogger(SolicitudRecoleccionBO.class);

	@Autowired
	IParamsSistemaDAO iParamsSistemaDAO;

	@Autowired
	IAdminConsecutivosBO iAdminConsecutivosBO;

	@Autowired
	ISolicitudRecoleccionDAO solicitudRecoleccionDao;

	@Autowired
	IConexionDAOJDBC iReportesDAOJDBC;

	@Autowired
	IPrintReport iPrintReport;

	@Autowired
	IBusquedaFrecuenciasBO iFrecuenciasBO;

	/**
	 * 
	 */
	public SolicitudRecoleccionBO() {
		// TODO Auto-generated constructor stub
	}

	private String formatoId = "yyMMddkms";

	/**
	 * Crea un identificador para la solicitud o la recoleccion dependiendo del
	 * dia en que se este realizando en el siguiente formato. "R" + "yyMdkms"
	 * "S" + "yyMdkms"
	 * 
	 * @param idSolicitud
	 * @return
	 */
	private String getIdRecoleccion(boolean isSolcicitud, int contador) {
		String prefijo = "R";
		if (isSolcicitud) {
			prefijo = "S";
		}

		String formato = this.formatoId;
		String str_contador = "";
		if (contador > -1) {
			formato = "yyMMddhhmmss";
			str_contador = "" + contador;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
		return prefijo + simpleDateFormat.format(new Date()) + str_contador;
	}

	/**
	 * Crea un identificador para el manifiesto de recolecciones "M" + "yyMdkms"
	 * + contador
	 * 
	 * @param idSolicitud
	 * @return
	 */
	private String getIdManifiesto(int contador) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.formatoId);
		return "M" + simpleDateFormat.format(new Date()) + contador;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * getSolicitudesRecoleccion(com.administracion.dto.SolicitudRecoleccion)
	 */
	@Override
	public List<SolicitudRecoleccion> getSolicitudesRecoleccion(SolicitudRecoleccion solicitud) throws SQLException {
		return solicitudRecoleccionDao.getSolicitudesRecoleccion(solicitud);
	}

	@Override
	public SolicitudRecoleccion getDocumentoSolicitudRecoleccion(SolicitudRecoleccion solicitud) throws SQLException {
		List<SolicitudRecoleccion> lista = solicitudRecoleccionDao.getSolicitudesRecoleccion(solicitud);

		if (lista.size() > 0) {
			return lista.get(0);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * getRecoleccion (com.administracion.dto.SolicitudRecoleccion)
	 */
	@Override
	public List<SolicitudRecoleccion> getRecoleccion(SolicitudRecoleccion solicitud) throws SQLException {

		return solicitudRecoleccionDao.getRecoleccion(solicitud);
	}

	@Override
	public SolicitudRecoleccion getDocumentoOrdenRecoleccion(SolicitudRecoleccion solicitud) throws SQLException {

		List<SolicitudRecoleccion> lista = solicitudRecoleccionDao.getRecoleccion(solicitud);
		if (lista.size() > 0) {
			return lista.get(0);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * agregaRecoleccionAManifesto(com.administracion.dto.SolicitudRecoleccion)
	 */
	@Override
	public void agregaRecoleccionAManifesto(SolicitudRecoleccion solicitud) throws SQLException {

		solicitudRecoleccionDao.agregaRecoleccionAManifesto(solicitud);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * agregaRecoleccionAManifesto(java.util.ArrayList,
	 * com.innovargia.salesmanager.dtos.UsuarioDTO, java.lang.String)
	 */
	@Override
	public List<String> agregaRecoleccionAManifesto(List<String> arr_rutas, UsuarioDTO usuario, String plaza,
			String fecha) throws SQLException {
		// Para cada ruta del arreglo genera un id de recoleccion y los agrega
		// en la tabla de
		// manifiestos
		int index = 1;
		SolicitudRecoleccion solicitudRecoleccion = new SolicitudRecoleccion();
		List<String> manifiestos = new ArrayList<String>();
		List<SolicitudRecoleccion> arr_recolecciones = new ArrayList<SolicitudRecoleccion>();
		// Para cada recoleccion se le agrega un indice con esto se mitiga el
		// posible choque
		// de identificadores
		String fechasystema = Fechas.formatoFecha(Calendar.getInstance(), "yyyy-MM-dd hh:mm:ss");
		Movimiento movimiento = new Movimiento();
		movimiento.setTipoRegistro("MM");
		movimiento.setFecha(fechasystema);
		movimiento.setClaveLogistica("");
		movimiento.setRuta("");
		movimiento.setEmpleado(usuario.getLogin());

		String manifiesto = "";
		for (String ruta : arr_rutas) {
			// obtiene los datos de las recolecciones que no
			// han sido manifestados
			arr_recolecciones = solicitudRecoleccionDao.getOrdenesRecoleccionRuta(ruta, plaza, fecha);
			manifiesto = getIdManifiesto(index++);
			for (SolicitudRecoleccion solicitud : arr_recolecciones) {
				// Solo las recolecciones que esten activas
				if ("A".equals(solicitud.getEstatus())) {
					solicitudRecoleccion.setIdregistro(solicitud.getIdregistro());
					solicitudRecoleccion.setIdrecoleccion(solicitud.getIdrecoleccion());
					solicitudRecoleccion.setRutaasignada(ruta);
					solicitudRecoleccion.setManifiesto(manifiesto);
					solicitudRecoleccion.setIdusuariocreador(usuario.getLogin());
					// Agrega el registro al manifieesto

					solicitudRecoleccionDao.agregaRecoleccionAManifesto(solicitudRecoleccion);
					// Agrega el manifiesto al arreglo
					manifiestos.add(solicitudRecoleccion.getManifiesto());

					// Indica Movimieto donde se agrega a manifiesto
					movimiento.setQuienrechaza("MANIF:" + solicitudRecoleccion.getManifiesto());
					movimiento.setIdsolicitud(solicitud.getIdrecoleccion());
					movimiento.setRuta(ruta);
					insertaMovimiento(movimiento);
				}

			}
		}
		return manifiestos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * getRutasOrdenesRecoleccion(com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public List<String> getRutasOrdenesRecoleccion(UsuarioDTO usuario) throws SQLException {
		List<SolicitudRecoleccion> arr_rutas_solicitud = solicitudRecoleccionDao.getRutasOrdenesRecoleccion(usuario);
		List<String> arr_rutas = new ArrayList<String>();
		for (SolicitudRecoleccion solicitudRecoleccion : arr_rutas_solicitud) {
			arr_rutas.add(solicitudRecoleccion.getRutaasignada());
		}
		return arr_rutas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * getRutasConOrdenesRecoleccion
	 * (com.innovargia.salesmanager.dtos.UsuarioDTO, boolean)
	 */
	@Override
	public List<Ruta> getRutasConOrdenesRecoleccion(UsuarioDTO usuario, boolean isShowAll) throws SQLException {
		return solicitudRecoleccionDao.getRutasConOrdenesRecoleccion(usuario, isShowAll);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * agregarSolicitudRecoleccion(com.administracion.dto.SolicitudRecoleccion,
	 * java.util.ArrayList)
	 */
	@Override
	public void agregarSolicitudRecoleccion(SolicitudRecoleccion solicitud, List<DiasSemanaMes> dias)
			throws SQLException {

		try {
			updatePlazaRuta(solicitud);
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}

		solicitud.setIdsolicitud(getIdRecoleccion(true, -1));
		solicitudRecoleccionDao.agregarSolicitudRecoleccion(solicitud, dias);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * updateRecoleccion(com.administracion.dto.SolicitudRecoleccion,
	 * java.util.ArrayList)
	 */
	@Override
	public void updateRecoleccion(SolicitudRecoleccion solicitud, List<DiasSemanaMes> dias) throws SQLException {
		try {
			updatePlazaRuta(solicitud);
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
		solicitudRecoleccionDao.updateRecoleccion(solicitud);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * updateSolicitudRecoleccion(com.administracion.dto.SolicitudRecoleccion,
	 * java.util.ArrayList)
	 */
	@Override
	public void updateSolicitudRecoleccion(SolicitudRecoleccion solicitud, List<DiasSemanaMes> dias)
			throws SQLException {
		try {
			updatePlazaRuta(solicitud);
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
		solicitudRecoleccionDao.updateSolicitudRecoleccion(solicitud);

		/*
		 * if (solicitud.getIdtiporecol()==
		 * Estatus.RECOL_PROGRAMADA_X_DIA_MSEMANA) {
		 * solicitudRecoleccionDao.modificarDiasSemanaSolicitudRecoleccion
		 * (solicitud.getIdsolicitud(),dias); }else
		 * if(solicitud.getIdtiporecol()== Estatus.RECOL_PROGRAMADA_X_DIA_MES){
		 * //Esporadica
		 * solicitudRecoleccionDao.modificarDiasMesSolicitudRecoleccion
		 * (solicitud.getIdsolicitud(),dias); }
		 */

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * agregarSolicitudRecoleccion(com.administracion.dto.SolicitudRecoleccion)
	 */
	@Override
	public void agregarSolicitudRecoleccion(SolicitudRecoleccion solicitud) throws SQLException {

		// Obtiene el numero de solicitud
		solicitud.setIdsolicitud(getIdRecoleccion(true, -1));
		try {
			updatePlazaRuta(solicitud);
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}
		solicitudRecoleccionDao.agregarSolicitudRecoleccion(solicitud);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * agregarRecoleccion(com.administracion.dto.SolicitudRecoleccion)
	 */
	@Override
	public void agregarRecoleccion(SolicitudRecoleccion solicitud) throws SQLException {
		solicitud.setIdrecoleccion(getIdRecoleccion(false, -1));
		solicitud.setIdsolicitud(solicitud.getIdrecoleccion());

		try {
			updatePlazaRuta(solicitud);
		} catch (Exception e) {
			throw new SQLException(e.getMessage());
		}

		solicitudRecoleccionDao.agregarRecoleccion(solicitud);

	}

	private void updatePlazaRuta(SolicitudRecoleccion solicitud) throws Exception {
		Frecuencias frecuencia;
		try {
			frecuencia = iFrecuenciasBO.getRutaAsignada(solicitud.getCp());

			if (frecuencia == null) {
				throw new SQLException("No existe frecuencia para al c�digo " + solicitud.getCp());
			}

			if ((solicitud.getPlaza() == null) || (solicitud.getPlaza().trim().length() <= 0)) {

				solicitud.setPlaza(frecuencia.getIdagrupador());
			}

			if ((solicitud.getRutaasignada() == null) || (solicitud.getRutaasignada().trim().length() <= 0)) {
				solicitud.setRutaasignada(frecuencia.getRutaEnt());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * cambiarEstatusRecoleccion(com.administracion.dto.SolicitudRecoleccion,
	 * com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public void cambiarEstatusRecoleccion(SolicitudRecoleccion solicitud, UsuarioDTO usuario) {
		solicitudRecoleccionDao.cambiarEstatusRecoleccion(solicitud, usuario);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * cambiarFechaRecoleccion(com.administracion.dto.SolicitudRecoleccion,
	 * com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public void cambiarFechaRecoleccion(SolicitudRecoleccion solicitud, UsuarioDTO usuario) {
		solicitudRecoleccionDao.modificarFechaRecoleccion(solicitud.getIdrecoleccion(), solicitud.getFecharecol(),
				usuario);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * agregarDiasSemanaSolicitudRecoleccion(java.lang.String,
	 * java.util.ArrayList)
	 */
	@Override
	public void agregarDiasSemanaSolicitudRecoleccion(String idSolicitud, List<DiasSemanaMes> dias) {
		solicitudRecoleccionDao.agregarDiasSemanaSolicitudRecoleccion(idSolicitud, dias);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * agregarDiasMesSolicitudRecoleccion(java.lang.String, java.util.ArrayList)
	 */
	@Override
	public void agregarDiasMesSolicitudRecoleccion(String idSolicitud, List<DiasSemanaMes> dias) {
		solicitudRecoleccionDao.agregarDiasMesSolicitudRecoleccion(idSolicitud, dias);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * modificarDiasSemanaSolicitudRecoleccion(java.lang.String,
	 * java.util.ArrayList)
	 */
	@Override
	public void modificarDiasSemanaSolicitudRecoleccion(String idSolicitud, List<DiasSemanaMes> dias) {
		solicitudRecoleccionDao.modificarDiasSemanaSolicitudRecoleccion(idSolicitud, dias);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * modificarDiasMesSolicitudRecoleccion(java.lang.String,
	 * java.util.ArrayList)
	 */
	@Override
	public void modificarDiasMesSolicitudRecoleccion(String idSolicitud, List<DiasSemanaMes> dias) {

		solicitudRecoleccionDao.modificarDiasMesSolicitudRecoleccion(idSolicitud, dias);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * modificarRutaRecoleccion(java.lang.String, java.lang.String,
	 * com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public void modificarRutaRecoleccion(String idrecoleccion, String ruta, UsuarioDTO usuario) {
		// Crea un arreglo con los datos de los clientes
		solicitudRecoleccionDao.modificarRutaRecoleccion(idrecoleccion, ruta, usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * modificarRutaSolicitudRecoleccion(java.lang.String, java.lang.String)
	 */
	@Override
	public void modificarRutaSolicitudRecoleccion(String idSolicitud, String ruta) {
		solicitudRecoleccionDao.modificarRutaSolicitudRecoleccion(idSolicitud, ruta);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * getOrdenesRecoleccionRuta(java.lang.String,
	 * com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public List<SolicitudRecoleccion> getOrdenesRecoleccionRuta(String ruta, UsuarioDTO usuario) throws SQLException {
		return solicitudRecoleccionDao.getOrdenesRecoleccionRuta(ruta, usuario);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * cambiarEstatusSolicitudRecoleccion(java.lang.String, java.lang.String)
	 */
	@Override
	public void cambiarEstatusSolicitudRecoleccion(String idSolicitud, String status) {
		solicitudRecoleccionDao.cambiarEstatusSolicitudRecoleccion(idSolicitud, status);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * insertaMovimiento(com.servicio.dtos.Movimiento)
	 */
	@Override
	public void insertaMovimiento(Movimiento movimiento) throws SQLException {
		solicitudRecoleccionDao.agregarMovimientoSolicitudRecoleccion(movimiento);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * agregarCancelacionSolicitudRecoleccion
	 * (com.administracion.dto.SolicitudRecoleccion)
	 */
	@Override
	public void agregarCancelacionSolicitudRecoleccion(SolicitudRecoleccion solicitud) {

		solicitudRecoleccionDao.agregarCancelacionSolicitudRecoleccion(solicitud);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * generarManifiestoPDF(java.util.ArrayList,
	 * com.innovargia.salesmanager.dtos.UsuarioDTO)
	 */
	@Override
	public byte[] generarManifiestoPDF(List<String> arr_manifiestos, UsuarioDTO usuario, String error) {

		byte[] bytes = null;
		Connection cnx = null;
		try {

			String str_manifiesto = "";
			for (int i = 0; i < arr_manifiestos.size(); i++) {
				str_manifiesto = str_manifiesto + "'" + arr_manifiestos.get(i) + "',";
			}
			if (str_manifiesto.endsWith(","))
				str_manifiesto = str_manifiesto.substring(0, str_manifiesto.length() - 1);

			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("manifiestos", str_manifiesto);
			parameters.put("login", usuario.getLogin());

			String path_formatos_reporte_jasper = iParamsSistemaDAO
					.getValorPropiedad(ConstantesGenerales.PATHIREPORTJASPER, ConstantesGenerales.ID_SKY4SOL);

			MetaDatoCatalogoDTO metaDocumento = iAdminConsecutivosBO.getMetaDatoCatalogoDTO("MANIFORRE",
					usuario.entidad.getIdentidad(), usuario.organizacion.getIdorganizacion());

			if (metaDocumento == null) {
				return null;
			}

			String reportejasper = path_formatos_reporte_jasper + metaDocumento.getFormatoiReport();
			logger.info("INVOCANDO REPORTE :" + reportejasper);
			cnx = iReportesDAOJDBC.getConexion();
			bytes = iPrintReport.genera(ConstantesIReport.TIPO_PDF, parameters, reportejasper, cnx);

			/*
			 * ByteArrayOutputStream byteArrayOutputStream = new
			 * ByteArrayOutputStream(); JasperPrint print =
			 * JasperFillManager.fillReport(reportejasper, parameters, cnx);
			 * JRExporter exporter = new
			 * net.sf.jasperreports.engine.export.JRPdfExporter();
			 * 
			 * exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			 * exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,
			 * byteArrayOutputStream); exporter.exportReport(); bytes =
			 * byteArrayOutputStream.toByteArray();
			 */

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Cierra recursos
			iReportesDAOJDBC.closeConecction(cnx);
		}
		return bytes;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * generarOrdenesRecoleccion()
	 */
	@Override
	public void generarOrdenesRecoleccion() throws SQLException {
		// Obtiene todas las solicitudes de recoleccion para un dia en partiular
		List<SolicitudRecoleccion> arr_solicitud = solicitudRecoleccionDao.generaOrdenesDeRecoleccionDiaria();
		int indice = 0;
		// Para cada recoleccion se le agrega un indice con esto se mitiga el
		// posible choque
		// de identificadores
		String fechasystema = Fechas.formatoFecha(Calendar.getInstance(), "yyyy-MM-dd hh:mm:ss");
		Movimiento movimiento = new Movimiento();
		movimiento.setTipoRegistro("MC");
		movimiento.setFecha(fechasystema);
		movimiento.setClaveLogistica("");
		movimiento.setRuta("");
		movimiento.setEmpleado("AUTOCRON");
		movimiento.setQuienrechaza("");

		// Agrega todos los registros
		Frecuencias frecuencia = null;
		for (SolicitudRecoleccion solicitud : arr_solicitud) {
			// Verifica si la cuenta esta bloqueada
			// Si no esta definida o es
			// Inserta la recoleccion
			solicitud.setIdrecoleccion(getIdRecoleccion(false, indice++));

			if (solicitud.getFechacancelacion() != null) {
				movimiento.setIdsolicitud(solicitud.getIdrecoleccion());
				solicitud.setEstatus("C");
				movimiento.setMotivo(solicitud.getMotivocancelacion());
				insertaMovimiento(movimiento);
			} else if ((solicitud.getCuenta_estatus() == null) || ("C".equals(solicitud.getCuenta_estatus()))) {
				movimiento.setIdsolicitud(solicitud.getIdrecoleccion());
				movimiento.setMotivo("CUENTA DADA DE BAJA O NO EXISTE.");
				solicitud.setEstatus("C");
				insertaMovimiento(movimiento);
			} else if ("L".equals(solicitud.getCuenta_estatus())) {
				movimiento.setIdsolicitud(solicitud.getIdrecoleccion());
				solicitud.setEstatus("L");
				movimiento.setMotivo("CUENTA BLOQUEADA.");
				insertaMovimiento(movimiento);
			} else if (solicitud.getEstatus().equals("C")) {
				movimiento.setIdsolicitud(solicitud.getIdrecoleccion());
				movimiento.setMotivo("RECOLECCION CANCELADA.");
				solicitud.setEstatus("C");
				insertaMovimiento(movimiento);
			}
			frecuencia = iFrecuenciasBO.getRutaAsignada(solicitud.getCp());
			if ((solicitud.getPlaza() == null) || (solicitud.getPlaza().trim().length() <= 0)) {
				solicitud.setPlaza(frecuencia.getIdagrupador());
			}

			if ((solicitud.getRutaasignada() == null) || (solicitud.getRutaasignada().trim().length() <= 0)) {
				solicitud.setRutaasignada(frecuencia.getRutaEnt());
			}

			// Agrega el registro a recoleccion
			solicitudRecoleccionDao.agregarRecoleccion(solicitud);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * getHistoriaRecoelccion(java.lang.String)
	 */
	@Override
	public List<Movimiento> getHistoriaRecoelccion(String idrecoleccion) {
		return solicitudRecoleccionDao.getHistoriaRecoelccion(idrecoleccion);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.innovargia.recolecciones.bo.impl.ISolicitudRecoleccionBO#
	 * getProgramacion (com.administracion.dto.SolicitudRecoleccion)
	 */
	@Override
	public List<DiasSemanaMes> getProgramacion(SolicitudRecoleccion solicitud) {
		List<DiasSemanaMes> programacion = new ArrayList<DiasSemanaMes>();

		if (solicitud.getIdtiporecol() == Estatus.RECOL_PROGRAMADA_X_DIA_MES) {
			programacion = solicitudRecoleccionDao.getProgramacionMensual(solicitud);
		} else if (solicitud.getIdtiporecol() == Estatus.RECOL_PROGRAMADA_X_DIA_MSEMANA) {
			programacion = solicitudRecoleccionDao.getProgramacionSemanal(solicitud);
		}
		return programacion;
	}

	@Override
	public void insertDiasMesSolicitudRecoleccion(DiasSemanaMes diasSemanaMes) {
		solicitudRecoleccionDao.insertDiasMesSolicitudRecoleccion(diasSemanaMes);

	}

	@Override
	public void insertDiasSemanaSolicitudRecoleccion(DiasSemanaMes diasSemanaMes) {
		solicitudRecoleccionDao.insertDiasSemanaSolicitudRecoleccion(diasSemanaMes);

	}

	@Override
	public void updateDiasMesSolicitudRecoleccion(DiasSemanaMes diasSemanaMes) {
		solicitudRecoleccionDao.updateDiasMesSolicitudRecoleccion(diasSemanaMes);

	}

	@Override
	public void updateDiasSemanaSolicitudRecoleccion(DiasSemanaMes diasSemanaMes) {
		solicitudRecoleccionDao.updateDiasSemanaSolicitudRecoleccion(diasSemanaMes);

	}

	@Override
	public void deleteDiasMesSolicitudRecoleccion(DiasSemanaMes diasSemanaMes) {
		solicitudRecoleccionDao.deleteDiasMesSolicitudRecoleccion(diasSemanaMes);

	}

	@Override
	public void deleteDiasSemanaSolicitudRecoleccion(DiasSemanaMes diasSemanaMes) {
		solicitudRecoleccionDao.deleteDiasSemanaSolicitudRecoleccion(diasSemanaMes);

	}

	@Override
	public List<Ruta> obtienePlazaTotal(String plaza, String fecha) throws SQLException {
		// TODO Auto-generated method stub
		return solicitudRecoleccionDao.obtienePlazaTotal(plaza, fecha);
	}

	@Override
	public List<Ruta> obtienePlazaRutasTotal(String plaza, String fecha) throws SQLException {
		// TODO Auto-generated method stub
		return solicitudRecoleccionDao.obtienePlazaRutasTotal(plaza, fecha);
	}

	@Override
	public SolicitudRecoleccion getSolicitudRecoleccionById(int idregistro, boolean isSolicitudRecoleccion)
			throws SQLException {
		// TODO Auto-generated method stub
		return solicitudRecoleccionDao.getSolicitudRecoleccionById(idregistro, isSolicitudRecoleccion);
	}

	@Override
	public void insertHistoriaRecoleccion(int idregistro, String tipoRegistro, String login, String quienrechaza,
			String motivo, boolean isSolicitudRecoleccion) {
		// Obtiene los dias de la programacion
		// ArrayList<DiasSemanaMes> dias = getDiasSolicitud(request);
		String fechasystema = Fechas.formatoFecha(Calendar.getInstance(), "yyyy-MM-dd hh:mm:ss");

		// Obtiene el movimiento de historia en caso de la actualizacion
		Movimiento movimiento = new Movimiento();
		movimiento.setTipoRegistro(tipoRegistro);
		movimiento.setFecha(fechasystema);
		movimiento.setClaveLogistica("");
		movimiento.setRuta("");
		movimiento.setEmpleado(login);
		movimiento.setQuienrechaza(quienrechaza);
		movimiento.setMotivo(motivo);

		try {
			SolicitudRecoleccion solicitud = getSolicitudRecoleccionById(idregistro, isSolicitudRecoleccion);
			String idsolicitud = "";
			if (solicitud != null) {
				idsolicitud = isSolicitudRecoleccion ? solicitud.getIdsolicitud() : solicitud.getIdrecoleccion();

				movimiento.setIdsolicitud(idsolicitud);
				insertaMovimiento(movimiento);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
