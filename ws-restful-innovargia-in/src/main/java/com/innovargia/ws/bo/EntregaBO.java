/**
 * 
 */
package com.innovargia.ws.bo;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.dto.RegistroInfo;
import com.administracion.ibo.IParamsSistemaBO;
import com.innovargia.salesmanager.dtos.AttachmentDTO;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.utils.UUIDUniqueCreator;
import com.innovargia.ws.dto.CasamientoRespuesta;
import com.innovargia.ws.dto.CodigoErrorCasamiento;
import com.innovargia.ws.dto.Entrega;
import com.innovargia.ws.dto.RutaRequest;
import com.innovargia.ws.dto.RutaResponse;
import com.innovargia.ws.repo.interfase.bo.IEntregaBO;
import com.innovargia.ws.repo.interfase.bo.IFirmaFotoBO;
import com.innovargia.ws.repo.interfase.dao.IEntregaDao;
import com.innovargia.ws.repo.interfase.dao.IFirmaFotoDao;
import com.innovargia.ws.repo.interfase.dao.IMovimientoDao;
import com.servicio.constantes.ConstantesGenerales;
import com.servicio.dtos.Guia;

/**
 * @author aruaro
 *
 */
@Service
public class EntregaBO implements IEntregaBO {

	private static final Logger logger = LoggerFactory.getLogger(EntregaBO.class);

	@Autowired
	IEntregaDao iEntregaDao;
	@Autowired
	IFirmaFotoDao iFirmaFotoDao;

	@Autowired
	IParamsSistemaBO iParamsSistemaBO;

	@Autowired
	IMovimientoDao iMovimientoDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.innovargia.ws.repo.interfase.IEntregaDao#insert(com.innovargia.ws.dto
	 * .Entrega)
	 */
	@Override
	public CasamientoRespuesta insert(Entrega obj) throws Exception {

		logger.info("EntregaBO create insert.");

		obj.setIdguia(obj.getIdguia().toUpperCase().trim());

		String[] arr_guias = obj.getIdguia().split("\n");

		com.servicio.dtos.Entrega entregaDTO = null;

		int request = 0;
		
		String nombre_archivo = "";
		
		CodigoErrorCasamiento cec;
		
		CasamientoRespuesta casRespuesta = new CasamientoRespuesta();
		
		List<CodigoErrorCasamiento> lstErrores = new ArrayList<>();

		AttachmentDTO attac_nota = new AttachmentDTO();
		
		attac_nota.setLogin("RESTFUL");
		attac_nota.setIdtipodocumento("ETIQU");
		
		for (String idguia : arr_guias) {

			if ((idguia != null) && (idguia.trim().length() > 0)) {

				obj.setIdguia(idguia);

				request = insertaDatosEntrega(obj);
				/*
				 * 1 = Tiene entrega
				 * 5 = Procede a entrega
				 * 2 = No Tiene salida (no se permite entrega)
				 * 0 = Error
				 * */

				if(request != 5){
					
					cec = new CodigoErrorCasamiento();
					
					switch (request) {
					case 1:
						
						cec.setIdGuia(idguia);
						
						cec.setCodigoError(request);
						
						cec.setDescripcionError("La guia ya tiene entrega");
						
						break;

					case 2:
						
						cec.setIdGuia(idguia);
						
						cec.setCodigoError(request);
						
						cec.setDescripcionError("La guia no tiene salida (no se permite entrega)");
						
						break;
						
					case 0:
						
						cec.setIdGuia(idguia);
						
						cec.setCodigoError(request);
						
						cec.setDescripcionError("Error interno");
						
						break;
					}
					
					lstErrores.add(cec);
					
				}else{
					
					nombre_archivo = UUIDUniqueCreator.generateUUID() + ".png";

					attac_nota.setDescripcion("FIRMA ENTREGA");
					attac_nota.setFecha(obj.getFecha());
					attac_nota.setNombre_archivo(nombre_archivo);
					attac_nota.setBase64(obj.getFirmaBase64());
					attac_nota.setIdentificador(idguia);
					
					iFirmaFotoDao.insert(attac_nota);
					
					attac_nota.setDescripcion("EVIDENCIA 1");
					attac_nota.setNombre_archivo(nombre_archivo);
					attac_nota.setBase64(obj.getEvidencia1Base64());
					
					iFirmaFotoDao.insert(attac_nota);
					
					attac_nota.setDescripcion("EVIDENCIA 2");
					attac_nota.setNombre_archivo(nombre_archivo);
					attac_nota.setBase64(obj.getEvidencia2Base64());
					
					iFirmaFotoDao.insert(attac_nota);

					attac_nota.setDescripcion("EVIDENCIA 3");
					attac_nota.setNombre_archivo(nombre_archivo);
					attac_nota.setBase64(obj.getEvidencia3Base64());
					
					iFirmaFotoDao.insert(attac_nota);

					
				}
				

			}

		}
		
		casRespuesta.setCode(lstErrores.isEmpty() ? "200" : "201");
		
		casRespuesta.setLstErrores(lstErrores);

		return casRespuesta;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.innovargia.ws.repo.interfase.IEntregaDao#update(com.innovargia.ws.dto
	 * .Entrega)
	 */
	@Override
	public int update(Entrega obj) throws Exception {

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.innovargia.ws.repo.interfase.IEntregaDao#delete(com.innovargia.ws.dto
	 * .Entrega)
	 */
	@Override
	public int delete(Entrega obj) throws Exception {

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.innovargia.ws.repo.interfase.IEntregaDao#select(com.innovargia.ws.dto
	 * .Entrega)
	 */
	@Override
	public List<Entrega> select(Entrega obj) throws Exception {

		return new ArrayList<Entrega>();
	}

	@Override
	public CasamientoRespuesta insertConfirmacionGuiasManif(Entrega obj) throws Exception {
		logger.info("EntregaBO create insertConfirmacionGuiasManif.");
		obj.setIdguia(obj.getIdguia().toUpperCase().trim());
		String[] arr_manif = obj.getIdguia().split("\n");
		
		int request = 0;
		
		String nombre_archivo = "";
		
		CodigoErrorCasamiento cec;
		
		CasamientoRespuesta casRespuesta = new CasamientoRespuesta();
		
		List<CodigoErrorCasamiento> lstErrores = new ArrayList<>();

		AttachmentDTO attac_nota = new AttachmentDTO();
		
		attac_nota.setLogin("RESTFUL");
		attac_nota.setIdtipodocumento("ETIQU");
		

		String idmanif_tmp = obj.getIdguia();
		List<Guia> _guias = null;
		for (String mymanif : arr_manif) {
			if ((mymanif != null) && (mymanif.trim().length() > 0)) {
				// Busca guias pertenecientes a un manifiestos si existe
				// asigna a cada guia la confirmacion
				_guias = iEntregaDao.select(mymanif);
				logger.debug("Confirmacion guias asociadas al manifiesto " + mymanif);
				for (Guia guia : _guias) {
					
					logger.debug("Confirmacion guia:" + guia.getGuia());
					
					obj.setIdguia(guia.getGuia());
					
					request = insertaDatosEntrega(obj);
					
					/*
					 * 1 = Tiene entrega
					 * 5 = Procede a entrega
					 * 2 = No Tiene salida (no se permite entrega)
					 * 0 = Error
					 * */

					if(request != 5){
						
						cec = new CodigoErrorCasamiento();
						
						switch (request) {
						case 1:
							
							cec.setIdGuia(obj.getIdguia());
							
							cec.setCodigoError(request);
							
							cec.setDescripcionError("La guia ya tiene entrega");
							
							break;

						case 2:
							
							cec.setIdGuia(obj.getIdguia());
							
							cec.setCodigoError(request);
							
							cec.setDescripcionError("La guia no tiene salida (no se permite entrega)");
							
							break;
							
						case 0:
							
							cec.setIdGuia(obj.getIdguia());
							
							cec.setCodigoError(request);
							
							cec.setDescripcionError("Error interno");
							
							break;
						}
						
						lstErrores.add(cec);
						
					}else{
						
						nombre_archivo = UUIDUniqueCreator.generateUUID() + ".png";

						attac_nota.setDescripcion("FIRMA ENTREGA");
						attac_nota.setFecha(obj.getFecha());
						attac_nota.setNombre_archivo(nombre_archivo);
						attac_nota.setBase64(obj.getFirmaBase64());
						attac_nota.setIdentificador(obj.getIdguia());
						
						iFirmaFotoDao.insert(attac_nota);
						
						attac_nota.setDescripcion("EVIDENCIA 1");
						attac_nota.setNombre_archivo(nombre_archivo);
						attac_nota.setBase64(obj.getEvidencia1Base64());
						
						iFirmaFotoDao.insert(attac_nota);
						
						attac_nota.setDescripcion("EVIDENCIA 2");
						attac_nota.setNombre_archivo(nombre_archivo);
						attac_nota.setBase64(obj.getEvidencia2Base64());
						
						iFirmaFotoDao.insert(attac_nota);

						attac_nota.setDescripcion("EVIDENCIA 3");
						attac_nota.setNombre_archivo(nombre_archivo);
						attac_nota.setBase64(obj.getEvidencia3Base64());
						
						iFirmaFotoDao.insert(attac_nota);

						
					}
					
				}

			}
		}

		obj.setIdguia(idmanif_tmp);
		
		casRespuesta.setCode(lstErrores.isEmpty() ? "200" : "201");
		
		casRespuesta.setLstErrores(lstErrores);

		return casRespuesta;
		
	}

	/***
	 * Inserta los datos de entrega y log
	 * 
	 * @param obj
	 */
	private int insertaDatosEntrega(Entrega obj) {
		
		try {
			
			int isInserted = iEntregaDao.insert(obj);
			
			if (isInserted == 5) {
				
				iEntregaDao.update(obj);

				RegistroInfo registro = new RegistroInfo();
				registro.set_idpropietario(obj.getEmpleado());
				registro.set_servidor(obj.getPlaza() == null ? "REST" : obj.getPlaza());
				registro.set_idRegistro("05");
				registro.set_plaza(obj.getPlaza() == null ? "RES" : obj.getPlaza());

				iMovimientoDao.insertEstadisticasCarga(registro);
			}
			
			return isInserted;
			
		} catch (Exception e) {
			
			logger.debug("Error al agregar la entrega:" + e.getMessage());
			
			return 0;
			
		}
	}

	@Override
	public List<RutaResponse> getRutas(RutaRequest ruta) throws Exception {
		
		return iEntregaDao.getRutas(ruta);
	}

}
