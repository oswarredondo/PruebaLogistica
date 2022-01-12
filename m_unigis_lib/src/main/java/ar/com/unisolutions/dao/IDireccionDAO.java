package ar.com.unisolutions.dao;

import java.util.List;

import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.RemDes;

import ar.com.unisolutions.dto.Direccion;

public interface IDireccionDAO {

	public Direccion getDireccionDescripcion(int codigoPostal) throws Exception;
	
	public String getDirection(EtiquetaRotulacionDTO etiquetaRotulacionDTO) throws Exception;
	
	public String getSistemaEnvio(String idguia) throws Exception;
	
	public void setLatLng(String lat,  String lng, String idRemDes);
	
	public List<RemDes> getDireccionRemDes(String uuid) throws Exception;
	
	public int getReexpedicion(String codigoPostal) throws Exception;
}
