/**
 * 
 */
package com.administracion.ibo;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.innovargia.mail.EmailProperties;
import com.innovargia.salesmanager.dtos.SistemaDTO;

@Component
public interface IParamsSistemaBO {

	

	public String getValorPropiedad(String idparametro,String idsistema) throws Exception;
	

	public SistemaDTO getPathsSistema(String idSistema, String numCliente)
			throws Exception;
	

	public void insert(SistemaDTO catalogo) throws Exception;
	

	public void update(SistemaDTO catalogo) throws Exception;

	public void delete(SistemaDTO catalogo) throws Exception;
	
	public List<SistemaDTO> getRegistros(String sistema) throws Exception;
	
	public int  getValorPropiedadInt(String idparametro, String idsistema)throws Exception;
	public String getValorPropiedad(String idparametro,List<SistemaDTO> lista)
		throws Exception;
	public int getValorPropiedadInt(String idparametro,List<SistemaDTO> lista)
		throws Exception;
	
	
	public EmailProperties getPropiedadesEmail(EmailProperties propiedades,String sistema) throws SQLException;
	

}
