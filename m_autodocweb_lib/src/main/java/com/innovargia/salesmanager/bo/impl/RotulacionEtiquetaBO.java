package com.innovargia.salesmanager.bo.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.administracion.consecutivos.bo.AdminConsecutivosBO;
import com.administracion.dto.AdicionalDTO;
import com.administracion.dto.DetalleVenta;
import com.administracion.dto.VentaDTO;
import com.administracion.ibo.ICoberturaBO;
import com.administracion.ibo.IParamsSistemaBO;
import com.administracion.idao.IParamsSistemaDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.innovargia.documentos.dtos.Envio;
import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.ConvenioContratoDetalleDTO;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.dtos.MetaDatoCatalogoDTO;
import com.innovargia.salesmanager.dtos.RemDes;
import com.innovargia.salesmanager.dtos.TarifaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IRotulacionEtiquetasDatosBO;
import com.innovargia.salesmanager.idao.IRotulacionEtiquetasDatosDAO;
import com.innovargia.utils.UUIDUniqueCreator;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.UtilsStrings;
import com.servicio.constantes.ConstantesGenerales;
import com.servicio.dtos.ManifiestoDTO;
import com.servicio.search.ibo.IBusquedaAdicionalBO;

import ar.com.unisolutions.bo.IDireccioneBO;
import ar.com.unisolutions.bo.IMercanciaBO;
import ar.com.unisolutions.dto.Direccion;

@Service
public class RotulacionEtiquetaBO implements IRotulacionEtiquetasDatosBO {

	private static final Logger logger = LoggerFactory.getLogger(RotulacionEtiquetaBO.class);

	@Autowired
	IRotulacionEtiquetasDatosDAO iRotulacionEtiquetasDatosDAO;
	@Autowired
	ICoberturaBO iCoberturaBO;
	@Autowired
	IBusquedaAdicionalBO iAdicionalBO;
	@Autowired
	IParamsSistemaBO iParamsSistemaBO;
	@Autowired
	IParamsSistemaDAO iParamsSistemaDAO;

	@Autowired
	AdminConsecutivosBO boConsecutivo;

	@Autowired
	IMercanciaBO iMercanciaBO;
	
	@Autowired
	IDireccioneBO iDireccioneBO;
	
	public RotulacionEtiquetaBO() {

	}

	@Override
	public int insert(EtiquetaRotulacionDTO etiqueta) throws Exception {
		// TODO Auto-generated method stub

		// Valida Cobertura y actualiza los transbordos
		CruceCoberturaDTO cob = cob = new CruceCoberturaDTO();
		cob.setIdcoorigen(etiqueta.getCp_rem());
		cob.setIdcodestino(etiqueta.getCp_des());

		try {
			cob = iCoberturaBO.getCobertura(cob);
			etiqueta.setKms_origen_destino(cob.getKms());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.debug("Error:" + e.getMessage());
		}
		
		etiqueta.setIdproducto(etiqueta.getContenido().isEmpty() ? "01010101":etiqueta.getContenido());
		etiqueta.setContenido(iMercanciaBO.getMercanciaById(etiqueta.getIdproducto()));
		
		/* CAMBIO UNIGIS IDREMDES*/
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json_data = gson.toJson(etiqueta);

		etiqueta.setJson_data(json_data);
		
		int idregistro = iRotulacionEtiquetasDatosDAO.insert(etiqueta);

		List<AdicionalDTO> lista = new ArrayList<AdicionalDTO>();
		if (etiqueta.getTiporotucacion().equals(ConstantesGenerales.MANEJO_CONVENIO)) {
			lista = iAdicionalBO.getRegistrosDisponiblesConvenio(etiqueta.getIdconvenio(), etiqueta.getUuid(),
					idregistro);
		} else {
			lista = iAdicionalBO.getRegistrosDisponiblesFolios(etiqueta.getUuid(), idregistro);
		}
		// Solo los requeridos
		for (AdicionalDTO adicionalDTO : lista) {
			if (adicionalDTO.getTipo() == 1) {
				adicionalDTO.setUuid(etiqueta.getUuid());
				adicionalDTO.setIddregistrodatos(idregistro);

				iAdicionalBO.insert(adicionalDTO);
			}

		}
		return idregistro;
	}

	@Override
	public int insertLineaVolumenCOD(EtiquetaRotulacionDTO etiqueta) throws Exception {
		// TODO Auto-generated method stub
		return iRotulacionEtiquetasDatosDAO.insertLineaVolumenCOD(etiqueta);
	}

	@Override
	public int insertLineaAdicional(EtiquetaRotulacionDTO etiqueta) throws Exception {
		// TODO Auto-generated method stub
		return iRotulacionEtiquetasDatosDAO.insertLineaAdicional(etiqueta);
	}

	@Override
	public int insertRotulacionSet(EtiquetaRotulacionDTO etiqueta) throws Exception {
		// TODO Auto-generated method stub
		int idregistro_set = iRotulacionEtiquetasDatosDAO.insertRotulacionSet(etiqueta);
		etiqueta.setIdregistro_set(idregistro_set);
		iRotulacionEtiquetasDatosDAO.updateRotulacionIdRegistroSet(etiqueta);

		return idregistro_set;
	}

	@Override
	public void update(EtiquetaRotulacionDTO etiqueta) throws Exception {
		iRotulacionEtiquetasDatosDAO.update(etiqueta);

	}

	@Override
	public void updateCOD(EtiquetaRotulacionDTO etiqueta) throws Exception {
		iRotulacionEtiquetasDatosDAO.updateCOD(etiqueta);

	}

	@Override
	public void updateVolumen(EtiquetaRotulacionDTO etiqueta) throws Exception {
		iRotulacionEtiquetasDatosDAO.updateVolumen(etiqueta);
	}

	@Override
	public void updateSeguro(EtiquetaRotulacionDTO etiqueta) throws Exception {
		iRotulacionEtiquetasDatosDAO.updateSeguro(etiqueta);

	}

	@Override
	public void updateRegistroDatos(EtiquetaRotulacionDTO etiqueta) throws Exception {
		iRotulacionEtiquetasDatosDAO.updateRegistroDatos(etiqueta);

	}

	@Override
	public void updateRotulacionSet(EtiquetaRotulacionDTO etiqueta) throws Exception {
		iRotulacionEtiquetasDatosDAO.updateRotulacionSet(etiqueta);

	}

	@Override
	public void delete(EtiquetaRotulacionDTO etiqueta) throws Exception {
		iRotulacionEtiquetasDatosDAO.delete(etiqueta);

	}

	@Override
	public void deleteRegistrosUUID(EtiquetaRotulacionDTO etiqueta) throws Exception {
		iRotulacionEtiquetasDatosDAO.deleteRegistrosUUID(etiqueta);
	}

	@Override
	public void deleteRotulacionSet(EtiquetaRotulacionDTO etiqueta) throws Exception {

		iRotulacionEtiquetasDatosDAO.deleteRotulacionSet(etiqueta);

	}

	@Override
	public void deleteLinea(EtiquetaRotulacionDTO etiqueta) throws Exception {
		iRotulacionEtiquetasDatosDAO.deleteLinea(etiqueta);

	}

	@Override
	public void deleteLineaVolumenSeguroCOD(EtiquetaRotulacionDTO etiqueta) throws Exception {
		iRotulacionEtiquetasDatosDAO.deleteLineaVolumenSeguroCOD(etiqueta);

	}

	@Override
	public void deleteLineaAdicional(EtiquetaRotulacionDTO etiqueta) throws Exception {
		iRotulacionEtiquetasDatosDAO.deleteLineaAdicional(etiqueta);

	}

	@Override
	public List<EtiquetaRotulacionDTO> getRegistrosDatos(EtiquetaRotulacionDTO etiqueta) throws Exception {

		List<EtiquetaRotulacionDTO> lista = iRotulacionEtiquetasDatosDAO.getRegistrosDatos(etiqueta);

		// Valida Cobertura y actualiza los transbordos
		for (EtiquetaRotulacionDTO etiquetaRotulacionDTO : lista) {
			
			getArr_Transbordos(etiquetaRotulacionDTO);

		}

		return lista;
	}
	@Override
	public void getArr_Transbordos(EtiquetaRotulacionDTO etiquetaRotulacionDTO) {
		CruceCoberturaDTO cob = new CruceCoberturaDTO();
		cob.setIdcoorigen(etiquetaRotulacionDTO.getCp_rem());
		cob.setIdcodestino(etiquetaRotulacionDTO.getCp_des());

		try {
			cob = iCoberturaBO.getCobertura(cob);
			if (cob != null) {
				etiquetaRotulacionDTO.setArr_transbordos(cob.getLista_transbordos());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.debug("Error:" + e.getMessage());
		}

	}

	@Override
	public void validaRegistro(List<EtiquetaRotulacionDTO> lista) {
		for (EtiquetaRotulacionDTO etiquetaRotulacionDTO : lista) {
			validaRegistro(etiquetaRotulacionDTO);
			etiquetaRotulacionDTO.setEsimportacion(true);
		}
	}
	
	@Override
	public void validaRegistrosImport(List<EtiquetaRotulacionDTO> lista) {
		for (EtiquetaRotulacionDTO etiquetaRotulacionDTO : lista) {
			validaRegistrosImport(etiquetaRotulacionDTO);
			etiquetaRotulacionDTO.setEsimportacion(true);
		}
	}

	@Override
	public void validaEnrutamientoRegistro(EtiquetaRotulacionDTO eti) {
		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getSiglasorigen(), 3, 5)) {
			eti.setEsvalido(5);
			eti.setMensajeError("Siglas plaza origen invalidas");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getSiglasdestino(), 3, 5)) {
			eti.setEsvalido(5);
			eti.setMensajeError("Siglas plaza destino invalidas");
			return;
		}

		if ((eti.getArr_transbordos() == null) || (eti.getArr_transbordos().size() <= 0)) {
			eti.setEsvalido(5);
			eti.setMensajeError("No existe enrutamiento para origen destino seleccionados");
			return;
		}

	}

	@Override
	public void validaRegistro(EtiquetaRotulacionDTO eti) {
		eti.setEsvalido(0);
		
		if (eti.getNumpiezas() <= 0) {
			eti.setNumpiezas(1);
		}
		if (UtilsStrings.isVacio(eti.getNacional())) {
			eti.setNacional("NACIONAL");
		} else {
			if (!"NACIONAL".equals(eti.getNacional()) && !"INTERNACIONAL".equals(eti.getNacional())) {
				eti.setNacional("NACIONAL");
			}
		}

		if (UtilsStrings.isVacio(eti.getEs_multiple())) {
			eti.setEs_multiple("NO");
		} else {
			if (!"SI".equals(eti.getEs_multiple()) && !"NO".equals(eti.getEs_multiple())) {
				eti.setEs_multiple("NO");
			}
		}
		if (UtilsStrings.isVacio(eti.getTiene_retorno())) {
			eti.setTiene_retorno("NO");
		} else {
			if (!"SI".equals(eti.getTiene_retorno()) && !"NO".equals(eti.getTiene_retorno())) {
				eti.setTiene_retorno("NO");
			}
		}
		if (UtilsStrings.isVacio(eti.getTiene_seguro())) {
			eti.setTiene_seguro("NO");
		} else {
			if (!"SI".equals(eti.getTiene_seguro()) && !"NO".equals(eti.getTiene_seguro())) {
				eti.setTiene_seguro("NO");
			}
		}
		// Valida Remitente
		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getRazonsocial_rem(), 1, 50)) {
			eti.setEsvalido(1);
			eti.setMensajeError("Razon Social[1,50] invalida");
			return;
		}
		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getContacto_rem(), 1, 50)) {
			eti.setEsvalido(1);
			eti.setMensajeError("Contacto[1,50] invalida");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getCalle_rem(), 1, 100)) {
			eti.setEsvalido(1);
			eti.setMensajeError("Calle de Remitente[1,100] invalida");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getNuminterior_rem(), 0, 10)) {
			eti.setEsvalido(1);
			eti.setMensajeError("Numero Interior[0,10] invalido");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getNumexterior_rem(), 1, 10)) {
			eti.setEsvalido(1);
			eti.setMensajeError("Numero exterior[1,10] invalido");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getColonia_rem(), 1, 50)) {
			eti.setEsvalido(1);
			eti.setMensajeError("Colonia[1,50] invalida");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getCp_rem(), 5, 5)) {
			eti.setEsvalido(1);
			eti.setMensajeError("CP[5] invalido");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getMunicipio_rem(), 1, 50)) {
			eti.setEsvalido(1);
			eti.setMensajeError("Municipio[1,50] invalido");
			return;
		}

		// Valida Destino
		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getRazonsocial_des(), 1, 50)) {
			eti.setEsvalido(2);
			eti.setMensajeError("Razon Social[1,50] invalida");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getContacto_des(), 1, 50)) {
			eti.setEsvalido(1);
			eti.setMensajeError("Contacto Destino[1,50] invalida");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getCalle_des(), 1, 50)) {
			eti.setEsvalido(2);
			eti.setMensajeError("Calle de Destinatario[1,50] invalida");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getNuminterior_des(), 0, 10)) {
			eti.setEsvalido(2);
			eti.setMensajeError("Numero Interior[0,10] invalido");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getNumexterior_des(), 1, 50)) {
			eti.setEsvalido(2);
			eti.setMensajeError("Numero exterior[1,50] invalido");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getColonia_des(), 1, 50)) {
			eti.setEsvalido(2);
			eti.setMensajeError("Colonia[1,50] invalida");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getCp_des(), 5, 5)) {
			eti.setEsvalido(2);
			eti.setMensajeError("CP[5] invalido");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getColonia_des(), 1, 50)) {
			eti.setEsvalido(2);
			eti.setMensajeError("Municipio[1,50] invalido");
			return;
		}

		// Verifica si existe cobertura
		if ((eti.getArr_transbordos() == null) || (eti.getArr_transbordos().size() <= 0)) {
			getArr_Transbordos(eti);
			if ((eti.getArr_transbordos() == null) || (eti.getArr_transbordos().size() <= 0)) {
				eti.setEsvalido(4);
				eti.setMensajeError("No existe cobertura entre origen y destino seleccionados.");
			}

		}

		// Valida Generales
		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getRazonsocial_rem(), 1, 100)) {
			eti.setEsvalido(2);
			eti.setMensajeError("Contenido[1,100] es requerido");
		}
		
		
		if (eti.getPesovolumetrico_total() == 0) {
			
			if (eti.getLargo() == 0.0) {
				eti.setEsvalido(3);
				eti.setMensajeError("Largo invalida");
				return;
			}
			
			if (eti.getAlto() == 0.0) {
				eti.setEsvalido(3);
				eti.setMensajeError("Alto invalida");
				return;
			}
			
			if (eti.getAncho() == 0.0) {
				eti.setEsvalido(3);
				eti.setMensajeError("Ancho invalida");
				return;
			}
			
			//eti.setEsvalido(3);
			//eti.setMensajeError("Dimensiones invalidas");
			//return;
		}
		
		if (eti.getPesofisico_total() == 0) {
			
			if (eti.getPesofisico() == 0.0) {
				eti.setEsvalido(3);
				eti.setMensajeError("Peso Fisico invalida");
				return;
			}
			
			//eti.setEsvalido(3);
			//eti.setMensajeError("Peso invalido");
			//return;
		}
		
	}

	@Override
	public void validaRegistrosImport(EtiquetaRotulacionDTO eti) {
		eti.setEsvalido(0);
		
		if (eti.getNumpiezas() <= 0) {
			eti.setNumpiezas(1);
		}
		if (UtilsStrings.isVacio(eti.getNacional())) {
			eti.setNacional("NACIONAL");
		} else {
			if (!"NACIONAL".equals(eti.getNacional()) && !"INTERNACIONAL".equals(eti.getNacional())) {
				eti.setNacional("NACIONAL");
			}
		}

		if (UtilsStrings.isVacio(eti.getEs_multiple())) {
			eti.setEs_multiple("NO");
		} else {
			if (!"SI".equals(eti.getEs_multiple()) && !"NO".equals(eti.getEs_multiple())) {
				eti.setEs_multiple("NO");
			}
		}
		if (UtilsStrings.isVacio(eti.getTiene_retorno())) {
			eti.setTiene_retorno("NO");
		} else {
			if (!"SI".equals(eti.getTiene_retorno()) && !"NO".equals(eti.getTiene_retorno())) {
				eti.setTiene_retorno("NO");
			}
		}
		if (UtilsStrings.isVacio(eti.getTiene_seguro())) {
			eti.setTiene_seguro("NO");
		} else {
			if (!"SI".equals(eti.getTiene_seguro()) && !"NO".equals(eti.getTiene_seguro())) {
				eti.setTiene_seguro("NO");
			}
		}
		// Valida Remitente
		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getRazonsocial_rem(), 1, 50)) {
			eti.setEsvalido(1);
			eti.setMensajeError("Razon Social[1,50] invalida");
			return;
		}
		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getContacto_rem(), 1, 50)) {
			eti.setEsvalido(1);
			eti.setMensajeError("Contacto[1,50] invalida");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getCalle_rem(), 1, 100)) {
			eti.setEsvalido(1);
			eti.setMensajeError("Calle de Remitente[1,100] invalida");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getNuminterior_rem(), 0, 10)) {
			eti.setEsvalido(1);
			eti.setMensajeError("Numero Interior[0,10] invalido");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getNumexterior_rem(), 1, 10)) {
			eti.setEsvalido(1);
			eti.setMensajeError("Numero exterior[1,10] invalido");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getColonia_rem(), 1, 50)) {
			eti.setEsvalido(1);
			eti.setMensajeError("Colonia[1,50] invalida");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getCp_rem(), 5, 5)) {
			eti.setEsvalido(1);
			eti.setMensajeError("CP[5] invalido");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getMunicipio_rem(), 1, 50)) {
			eti.setEsvalido(1);
			eti.setMensajeError("Municipio[1,50] invalido");
			return;
		}

		// Valida Destino
		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getRazonsocial_des(), 1, 50)) {
			eti.setEsvalido(2);
			eti.setMensajeError("Razon Social[1,50] invalida");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getContacto_des(), 1, 50)) {
			eti.setEsvalido(1);
			eti.setMensajeError("Contacto Destino[1,50] invalida");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getCalle_des(), 1, 50)) {
			eti.setEsvalido(2);
			eti.setMensajeError("Calle de Destinatario[1,50] invalida");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getNuminterior_des(), 0, 10)) {
			eti.setEsvalido(2);
			eti.setMensajeError("Numero Interior[0,10] invalido");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getNumexterior_des(), 1, 50)) {
			eti.setEsvalido(2);
			eti.setMensajeError("Numero exterior[1,50] invalido");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getColonia_des(), 1, 50)) {
			eti.setEsvalido(2);
			eti.setMensajeError("Colonia[1,50] invalida");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getCp_des(), 5, 5)) {
			eti.setEsvalido(2);
			eti.setMensajeError("CP[5] invalido");
			return;
		}

		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getColonia_des(), 1, 50)) {
			eti.setEsvalido(2);
			eti.setMensajeError("Municipio[1,50] invalido");
			return;
		}

		// Verifica si existe cobertura
		if ((eti.getArr_transbordos() == null) || (eti.getArr_transbordos().size() <= 0)) {
			getArr_Transbordos(eti);
			if ((eti.getArr_transbordos() == null) || (eti.getArr_transbordos().size() <= 0)) {
				eti.setEsvalido(4);
				eti.setMensajeError("No existe cobertura entre origen y destino seleccionados.");
			}

		}

		// Valida Generales
		if (!UtilsStrings.isCorrectMinMaxLengthString(eti.getRazonsocial_rem(), 1, 100)) {
			eti.setEsvalido(2);
			eti.setMensajeError("Contenido[1,100] es requerido");
		}
		
		// Valida Pesos
		if (eti.getPesofisico() <= 0.0) {
			eti.setEsvalido(3);
			eti.setMensajeError("Peso Fisico invalida");
			return;
		}
		
		if (eti.getLargo() <= 0.0) {
			eti.setEsvalido(3);
			eti.setMensajeError("Largo invalida");
			return;
		}
		
		if (eti.getAlto() <= 0.0) {
			eti.setEsvalido(3);
			eti.setMensajeError("Alto invalida");
			return;
		}
		
		if (eti.getAncho() <= 0.0) {
			eti.setEsvalido(3);
			eti.setMensajeError("Ancho invalida");
			return;
		}
	}

	@Override
	public List<EtiquetaRotulacionDTO> getRegistrosDatosVolumen(EtiquetaRotulacionDTO etiqueta) throws Exception {
		// TODO Auto-generated method stub
		return iRotulacionEtiquetasDatosDAO.getRegistrosDatosVolumen(etiqueta);
	}

	@Override
	public List<EtiquetaRotulacionDTO> getRegistrosDatosAdicionales(EtiquetaRotulacionDTO etiqueta) throws Exception {
		// TODO Auto-generated method stub
		return iRotulacionEtiquetasDatosDAO.getRegistrosDatosAdicionales(etiqueta);
	}

	@Override
	public List<EtiquetaRotulacionDTO> getRegistrosDatosContenidoObserva(EtiquetaRotulacionDTO etiqueta)
			throws Exception {
		// TODO Auto-generated method stub
		return iRotulacionEtiquetasDatosDAO.getRegistrosDatosContenidoObserva(etiqueta);
	}

	@Override
	public List<EtiquetaRotulacionDTO> getRegistrosDatosSeguro(EtiquetaRotulacionDTO etiqueta) throws Exception {
		// TODO Auto-generated method stub
		return iRotulacionEtiquetasDatosDAO.getRegistrosDatosSeguro(etiqueta);
	}

	@Override
	public List<EtiquetaRotulacionDTO> getRegistrosDatosCOD(EtiquetaRotulacionDTO etiqueta) throws Exception {
		// TODO Auto-generated method stub
		return iRotulacionEtiquetasDatosDAO.getRegistrosDatosCOD(etiqueta);
	}

	@Override
	public void depuraUUID(EtiquetaRotulacionDTO etiqueta) throws Exception {
		iRotulacionEtiquetasDatosDAO.depuraUUID(etiqueta);

	}

	@Override
	public List<EtiquetaRotulacionDTO> getRegistrosSets(EtiquetaRotulacionDTO etiqueta) throws Exception {
		// TODO Auto-generated method stub
		return iRotulacionEtiquetasDatosDAO.getRegistrosSets(etiqueta);
	}

	@Override
	public List<EtiquetaRotulacionDTO> getRegistrosSetsUsuario(EtiquetaRotulacionDTO etiqueta) throws Exception {
		// TODO Auto-generated method stub
		return iRotulacionEtiquetasDatosDAO.getRegistrosSetsUsuario(etiqueta);
	}

	@Override
	public void depuraRotulacionesTemporales() throws Exception {
		iRotulacionEtiquetasDatosDAO.depuraRotulacionesTemporales();

	}

	@Override
	public List<EtiquetaRotulacionDTO> getRegistrosDatosEtiquetas(EtiquetaRotulacionDTO etiqueta) throws Exception {
		// TODO Auto-generated method stub
		return iRotulacionEtiquetasDatosDAO.getRegistrosDatosEtiquetas(etiqueta);
	}

	@Override
	public List<EtiquetaRotulacionDTO> getRegistrosDatosEtiquetasJsonGeneradas(UsuarioDTO usuario, String uuid)
			throws Exception {
		// TODO Auto-generated method stub
		return iRotulacionEtiquetasDatosDAO.getRegistrosDatosEtiquetasJsonGeneradas(usuario, uuid);

	}

	@Override
	public void deleteJSonEtiquetasGeneradas() throws Exception {
		iRotulacionEtiquetasDatosDAO.deleteJSonEtiquetasGeneradas();

	}

	@Override
	public int insertRotulacionEtiquetasGeneradas(EtiquetaRotulacionDTO etiqueta) throws Exception {
		// TODO Auto-generated method stub
		return iRotulacionEtiquetasDatosDAO.insertRotulacionEtiquetasGeneradas(etiqueta);
	}

	@Override
	public List<EtiquetaRotulacionDTO> getReimpresionRegistrosDatosEtiquetasJsonGeneradas(UsuarioDTO usuario,
			String fechaini, String fechafin) throws Exception {
		// TODO Auto-generated method stub
		return iRotulacionEtiquetasDatosDAO.getReimpresionRegistrosDatosEtiquetasJsonGeneradas(usuario, fechaini,
				fechafin);
	}

	@Override
	public List<EtiquetaRotulacionDTO> getReimpresionRegistrosDatosEtiquetasJsonGeneradas(String[] idregistro)
			throws Exception {
		// TODO Auto-generated method stub
		return iRotulacionEtiquetasDatosDAO.getReimpresionRegistrosDatosEtiquetasJsonGeneradas(idregistro);
	}

	@Override
	public List<EtiquetaRotulacionDTO> getReimpresionRegistrosDatosEtiquetasJsonGeneradas(String uuid)
			throws Exception {
		// TODO Auto-generated method stub
		return iRotulacionEtiquetasDatosDAO.getReimpresionRegistrosDatosEtiquetasJsonGeneradas(uuid);
	}
	@Override
	public List<EtiquetaRotulacionDTO> importFie(MultipartFile beanFile) throws Exception {
		List<EtiquetaRotulacionDTO> lista = new ArrayList<EtiquetaRotulacionDTO>();

		ByteArrayInputStream bis = new ByteArrayInputStream(beanFile.getBytes());
		// beanFile.getFileData().getBytes());
		Workbook workbook;
		try {
			logger.debug("Tama�o archivo :" + beanFile.getSize());

			FormulaEvaluator objFormulaEvaluator = null;
			if (beanFile.getOriginalFilename().endsWith("xls")) {
				workbook = new HSSFWorkbook(bis);

				objFormulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();
			} else if (beanFile.getOriginalFilename().endsWith("xlsx")) {

				workbook = new XSSFWorkbook(bis);
				// workbook = WorkbookFactory.create(bis);

				objFormulaEvaluator = workbook.getCreationHelper().createFormulaEvaluator();

			} else {
				throw new Exception("Archivo con extenci�n inv�lida solo son aceptados XLS � XLSX.");
			}
			DataFormatter objDefaultFormat = new DataFormatter();

			Sheet sheet = workbook.getSheetAt(0);
			logger.debug("Inicia configuracion de renglones del excel");
			for (Row row : sheet) {
				EtiquetaRotulacionDTO etiqueta = new EtiquetaRotulacionDTO();
				// System.out.println("Renglon:" + row.getRowNum());
				// El primer renglon son los encabezados
				if (row.getRowNum() > 0) {

					for (Cell cell : row) {
						setCampo(etiqueta, cell, objFormulaEvaluator, objDefaultFormat);
					}
					// validaRegistro(etiqueta);
					lista.add(etiqueta);
				}
			}
			logger.debug("Fin configuracion de renglones del excel");

		} catch (IOException e) {
			logger.debug("Error:" + e.getMessage());
			e.printStackTrace();
		}

		return lista;

	}

	private void setCampo(EtiquetaRotulacionDTO etiqueta, Cell cell, FormulaEvaluator objFormulaEvaluator,
			DataFormatter objDefaultFormat) {
		int indice = cell.getColumnIndex();
		objFormulaEvaluator.evaluate(cell); // This will evaluate the cell, And
											// any type of cell will return
											// string value
		String cellValueStr = objDefaultFormat.formatCellValue(cell, objFormulaEvaluator);
		// System.out.println("Celda indice:" + cell.getColumnIndex() + " ,Valor
		// cadena:" + cellValueStr);
		switch (indice) {
		case 0: // RAZONSOCIAL_REM
			etiqueta.setRazonsocial_rem(cellValueStr);
			break;
		case 1: // CONTACTO_REM
			etiqueta.setContacto_rem(cellValueStr);
			break;
		case 2: // CALLE_REM
			etiqueta.setCalle_rem(cellValueStr);
			break;
		case 3: // NUMINTERIOR_REM
			etiqueta.setNuminterior_rem(cellValueStr);
			break;
		case 4:// NUMEXTERIOR_REM
			etiqueta.setNumexterior_rem(cellValueStr);
			break;
		case 5:// COLONIA_REM
			etiqueta.setColonia_rem(cellValueStr);
			break;
		case 6:// MUNICIPIO_REM
			etiqueta.setMunicipio_rem(cellValueStr);
			break;
		case 7: // ESTADO_REM
			etiqueta.setEstado_rem(cellValueStr);
			break;
		case 8: // CIUDAD_REM
			etiqueta.setCiudad_rem(cellValueStr);
			break;
		case 9: // CP_REM
			etiqueta.setCp_rem(cellValueStr);

			break;
		case 10:// TELEFONO_REM
			etiqueta.setTelefono_rem(cellValueStr);

			break;
		case 11:// CELULAR_REM
			etiqueta.setCelular_rem(cellValueStr);
			break;
		case 12: // RFC_REM
			etiqueta.setRfc_rem(cellValueStr);
			break;
		case 13: // EMAIL_REM
			etiqueta.setEmail_rem(cellValueStr);
			break;
		case 14: // RAZONSOCIAL_DES
			etiqueta.setRazonsocial_des(cellValueStr);
			break;
		case 15:// CONTACTO_DES
			etiqueta.setContacto_des(cellValueStr);
			break;
		case 16:// CALLE_DES
			etiqueta.setCalle_des(cellValueStr);
			break;
		case 17: // NUMINTERIOR_DES
			etiqueta.setNuminterior_des(cellValueStr);
			break;
		case 18:// NUMEXTERIOR_DES
			etiqueta.setNumexterior_des(cellValueStr);
			break;
		case 19: // COLONIA_DES
			etiqueta.setColonia_des(cellValueStr);
			break;
		case 20: // MUNICIPIO_DES
			etiqueta.setMunicipio_des(cellValueStr);
			break;
		case 21: // ESTADO_DES
			etiqueta.setEstado_des(cellValueStr);
			break;
		case 22:// CIUDAD_DES
			etiqueta.setCiudad_des(cellValueStr);
			break;
		case 23: // CP_DES
			etiqueta.setCp_des(cellValueStr);
			break;
		case 24:// TELEFONO_DES
			etiqueta.setTelefono_des(cellValueStr);
			break;
		case 25: // CELULAR_DES
			etiqueta.setCelular_des(cellValueStr);
			break;
		case 26:// EMAIL_DES
			etiqueta.setEmail_des(cellValueStr);
			break;
		case 27: // ES COURRE
			etiqueta.setEs_ocurre(cellValueStr);
			break;
		case 28: // TIENE SEGURO
			etiqueta.setTiene_seguro(cellValueStr);
			break;
		case 29: // ENTREGA (NACIONAL/INTERNACIONAL)
			etiqueta.setNacional(cellValueStr);
			break;
		case 30: // ES MULTIPLE
			etiqueta.setEs_multiple(cellValueStr);
			break;
		case 31: // NUM PIEZAS
			etiqueta.setNumpiezas(cellValueStr);

			break;
		case 32: // PESO FISICO
			etiqueta.setPesofisico(cellValueStr);

			break;
		case 33: // LARGO
			etiqueta.setLargo(cellValueStr);

			break;
		case 34: // ANCHO
			etiqueta.setAncho(cellValueStr);

			break;
		case 35: // ALTO
			etiqueta.setAlto(cellValueStr);
			break;
		case 36: // CONTENIDO
			etiqueta.setContenido(cellValueStr);
			break;
		case 37: // OBSERVACION
			etiqueta.setObservacion(cellValueStr);
			break;
		case 38: // REFERENCIA
			etiqueta.setReferencia(cellValueStr);
			break;
		case 39: // Seguro
			etiqueta.setValor_asegurado(cellValueStr);
			break;
		case 40: // valordeclarado
			etiqueta.setValordeclarado(cellValueStr);
			break;
		default:
			break;
		}

	}

	private int getConsecutivoVentaAutoDoc(UsuarioDTO usuario)
			throws Exception {

		//Obtiene los el consecutivo
		boolean manejo_consecutivo_global = iParamsSistemaDAO.getValorPropiedadBoolean(
				ConstantesGenerales.MANEJO_POR_FOLIOS_VENTA_ES_GLOBAL,ConstantesGenerales.ID_SKY4SOL);
		
		String documento_consecutivo = ConstantesGenerales.CONSECUTIVO_VENTAGLOBAL;
		if (!manejo_consecutivo_global){
			//arma el consecutivo con los datos de la oficina
			documento_consecutivo = ConstantesGenerales.CONSECUTIVO_VENTAPDV + usuario.getIdoficina();
		}
		logger.debug("Buscando documento de consecutivo VENTA AUTODOC:" + documento_consecutivo+ 
				",Identidad"+usuario.entidad.getIdentidad()+
				",Idorganizacion"+usuario.organizacion.getIdorganizacion()
				);
		String consecutivo = boConsecutivo
				.getConsecutivoDocumento(
						documento_consecutivo,
						usuario.entidad.getIdentidad(),
						usuario.organizacion.getIdorganizacion());
		if (consecutivo==null){
			throw new Exception("Tabla de consecutivo "+ documento_consecutivo + " no existe configurada");
		}
		
		int idventa = 0;
		try{
			idventa = Integer.parseInt(consecutivo);
		}catch(Exception e){
			
			throw new Exception("Consecutivo de venta "+ consecutivo + " inválido.");
			
		}
		
		return idventa;
		
	}
	@Override
	public int insertVentaAutoDoc(VentaDTO venta, List<DetalleVenta> lista_detalleventa,
			List<Integer> ids_json_generdas, UsuarioDTO usuario, String json_data_envios, int cantidad)
					throws Exception {
		// TODO Auto-generated method stub
		int idventa = 0;
		venta.setUuid(UUIDUniqueCreator.generateUUID());
		idventa = getConsecutivoVentaAutoDoc(usuario);
		if (idventa<=0){
			throw new Exception("Tabla de Consecutivo folios no existe.");
		}
		
		try {

			
			venta.setIdfoliooficina(idventa);
			idventa = iRotulacionEtiquetasDatosDAO.insertVentaAutoDoc(venta);
			venta.setIdventa(idventa);

			for (DetalleVenta detalleVenta : lista_detalleventa) {
				detalleVenta.setIdventa(idventa);
				iRotulacionEtiquetasDatosDAO.insertDetalle(detalleVenta);
			}
			for (Integer idregistro : ids_json_generdas) {
				iRotulacionEtiquetasDatosDAO.updateIdVentaJsonGeneradas(idregistro, idventa);
			}
			// Inserta las guias para recepcion

			EtiquetaRotulacionDTO etiqueta = new EtiquetaRotulacionDTO();
			etiqueta.setIdoficina(usuario.getIdoficina());
			etiqueta.setSiglasorigen(usuario.getSiglasPlaza());
			etiqueta.setCantidad(cantidad);
			etiqueta.setUuid(venta.getUuid());
			etiqueta.setTiporotucacion("CONTRATO/CONVENIO");
			etiqueta.setIdventa(idventa);
			etiqueta.setLogin(usuario.getLogin_autodoc());
			etiqueta.setJson_data(json_data_envios);

			usuario.setLogin(usuario.getLogin_autodoc());

			ManifiestoDTO manifiesto = new ManifiestoDTO();
			String pre_fijo_manifiesto = iParamsSistemaBO.getValorPropiedad("prefijo_manifiesto.recepcion.contrato",
					ConstantesGenerales.ID_SKY4SOL);
			manifiesto.setPrefijo_manifiesto(pre_fijo_manifiesto == null ? "" : pre_fijo_manifiesto);
			manifiesto.setTipoDocumento("MANIFRECEPCIONPDV");
			manifiesto.setPdv(true);

			String doc_manif = manifiesto.getPrefijo_manifiesto()
					+ UtilsStringFechas.obtenerFechaActual("yyMMddhhmmssSSS");
			doc_manif = manifiesto.getPrefijo_manifiesto() + UtilsStrings.nullChange(usuario.getSiglasPlaza()) + "-"
					+ UtilsStrings.nullChange(usuario.getIdoficina()) + "-" + doc_manif;
			manifiesto.setManifiesto(doc_manif);

			iRotulacionEtiquetasDatosDAO.insertRotulacionEtiquetasRecepcion(etiqueta, "NACIONAL", doc_manif);
			iRotulacionEtiquetasDatosDAO.insertVentaAutoDocDetalleRecepcionManifiesto(venta, usuario, doc_manif);

		} catch (Exception e) {
			logger.error("Error al crear la venta de autodoc: " + e.getMessage());
		}

		return idventa;
	}

	@Override
	public ConvenioContratoDetalleDTO getDetalleConvenioRotulacion(int idconveniodetalle) throws Exception {
		 List<ConvenioContratoDetalleDTO>  arr = iRotulacionEtiquetasDatosDAO.getDetalleConvenioRotulacion(idconveniodetalle);
		
		 if (arr.size()>0){
			 return arr.get(0);
		 }else{
			 return new ConvenioContratoDetalleDTO();
		 }
		
	}

	@Override
	public List<CuentasDTO> getDatosClienteEntidad(BusquedaDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return iRotulacionEtiquetasDatosDAO.getDatosClienteEntidad(obj);
	}

	@Override
	public EtiquetaRotulacionDTO getRegistrosTarifaserviciozona(int idconvenio,int identidad,int idorganizacion,String numCliente,String login,float kms) throws Exception {
		// TODO Auto-generated method stub
		 return iRotulacionEtiquetasDatosDAO.getRegistrosTarifaserviciozona(idconvenio,identidad,idorganizacion,numCliente,login,kms) ;
	}

	@Override
	public void UpdateDocumentoUnigis(String iddocumento, int unigis_status) {
		
		iRotulacionEtiquetasDatosDAO.UpdateDocumentoUnigis(iddocumento, unigis_status);
		
	}

	@Override
	public void insertLog(String numCliente,String login, String iddocumento,int evento,String data,int tipodoc) {
		
		iRotulacionEtiquetasDatosDAO.insertLog(numCliente,login,iddocumento,evento,data,tipodoc);
		
	}

	@Override
	public String getDeposito(String codigo) {
		
		return iRotulacionEtiquetasDatosDAO.getDeposito(codigo);
		
	}

	@Override
	public String getDirection(Envio etiquetaRotulacionDTO) {
		
		return iRotulacionEtiquetasDatosDAO.getDirection(etiquetaRotulacionDTO);
		
	}

	@Override
	public void updateLogReenvio(String iddocumento) {
		
	 iRotulacionEtiquetasDatosDAO.updateLogReenvio(iddocumento);
		
	}
	
	
	
}
