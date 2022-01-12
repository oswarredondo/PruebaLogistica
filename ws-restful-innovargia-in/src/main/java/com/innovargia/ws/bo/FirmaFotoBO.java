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

import com.administracion.ibo.IParamsSistemaBO;
import com.innovargia.salesmanager.dtos.AttachmentDTO;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.utils.UUIDUniqueCreator;
import com.innovargia.ws.dto.FirmaFoto;
import com.innovargia.ws.repo.interfase.bo.IFirmaFotoBO;
import com.innovargia.ws.repo.interfase.dao.IEntregaDao;
import com.innovargia.ws.repo.interfase.dao.IFirmaFotoDao;
import com.servicio.constantes.ConstantesGenerales;
import com.servicio.dtos.Guia;

/**
 * @author aruaro
 *
 */
@Service
public class FirmaFotoBO implements IFirmaFotoBO {

	private static final Logger logger = LoggerFactory.getLogger(FirmaFotoBO.class);

	@Autowired
	IFirmaFotoDao iFirmaFotoDao;

	@Autowired
	IParamsSistemaBO iParamsSistemaBO;
	
	@Autowired
	IEntregaDao iEntregaDao;

	public FirmaFotoBO() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.innovargia.ws.repo.interfase.IFirmaFotoDao#insert(com.innovargia.ws.
	 * dto.FirmaFoto)
	 */
	@Override
	public int insert(FirmaFoto obj) throws Exception {

		obj.setIdguia(obj.getIdguia().toUpperCase().trim());
		List<Guia> _guias = null;
		if ((obj.getIdguia() != null) && (obj.getImaBase64() != null)) {
			String[] arr_guias = obj.getIdguia().split("\n");
			try {

				logger.debug("insertando imagenes");
				// Agrega la imagen de la firma para cada guia en las NOTAs pero
				// solo
				// crea una imagen que sera compartida por todas las guias
				String nombre_archivo = UUIDUniqueCreator.generateUUID() + ".png";
				// Guarda el archivo
				SistemaDTO sistema = iParamsSistemaBO.getPathsSistema(ConstantesGenerales.ID_APP,
						ConstantesGenerales.NUM_CTE_APP);
			
				if (sistema != null) {
					String pathnamefile = sistema.getPathDocsPDFs() + nombre_archivo;

					if ((obj.getImaBase64() != null) && (obj.getImaBase64().trim().length() > 0)) {
						// "path.documentos.attachment"
						Base64 b = new Base64();
						byte[] imageBytes = b.decode(obj.getImaBase64());
						FileOutputStream fos = new FileOutputStream(pathnamefile);
						fos.write(imageBytes);
						fos.close();

						// Inserta la nota
						AttachmentDTO attac_nota = new AttachmentDTO();
						attac_nota.setDescripcion(obj.getNota());
						attac_nota.setNombre_archivo(nombre_archivo);
						attac_nota.setLogin("RESTFUL");
						attac_nota.setIdtipodocumento("ETIQU");
						attac_nota.setBase64(obj.getImaBase64());
						for (String idguia : arr_guias) {
							if ((idguia != null) && (idguia.trim().length() > 0)) {
								//Inserta la firma para el manifiesto o guia
								attac_nota.setIdentificador(idguia);
								iFirmaFotoDao.insert(attac_nota);
								
								//Busca guias pertenecientes a un manifiestos si existe 
								//asigna a cada guia la firma
								_guias = iEntregaDao.select(idguia);
								for (Guia miguia : _guias) {
									attac_nota.setIdentificador(miguia.getGuia());
									iFirmaFotoDao.insert(attac_nota);
								}
							}
						}

					}

				} else {
					logger.debug("Path para imagenes no configurado PathDocsPDFs");
				}
			} catch (Exception e) {
				logger.debug("Error al insertar las imagernes:" + e.getMessage());

			}
		}
		return 0;
	}

	private void insertFotosFirma(String[] arr_guias, String imaBase64) throws Exception {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.innovargia.ws.repo.interfase.IFirmaFotoDao#update(com.innovargia.ws.
	 * dto.FirmaFoto)
	 */
	@Override
	public int update(FirmaFoto obj) throws Exception {

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.innovargia.ws.repo.interfase.IFirmaFotoDao#delete(com.innovargia.ws.
	 * dto.FirmaFoto)
	 */
	@Override
	public int delete(FirmaFoto obj) throws Exception {

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.innovargia.ws.repo.interfase.IFirmaFotoDao#select(com.innovargia.ws.
	 * dto.FirmaFoto)
	 */
	@Override
	public List<FirmaFoto> select(FirmaFoto obj) throws Exception {

		return new ArrayList<FirmaFoto>();
	}

}
