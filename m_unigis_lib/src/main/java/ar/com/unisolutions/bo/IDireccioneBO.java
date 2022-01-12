package ar.com.unisolutions.bo;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.http.client.ClientProtocolException;

import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.RemDes;

import ar.com.unisolutions.dto.Direccion;

public interface IDireccioneBO {

	Direccion getDireccionDescripcion(int codigoPostal) throws Exception;

	String getSistemaEnvio(String idguia) throws Exception;

	String getLatLng(String direccion, String idRemDes)
			throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException, InterruptedException, ExecutionException;

	List<RemDes> getDireccionRemDes(String uuid) throws Exception;

	int getReexpedicion(String codigoPostal) throws Exception;

	String getDirection(EtiquetaRotulacionDTO etiquetaRotulacionDTO) throws Exception;

}
