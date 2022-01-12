package com.administracion.jasperreport;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.ireport.web.dto.ParameterDTO;

public interface IPrintReport {

	public abstract byte[] genera(String tipo, Map<String, Object> parameters,
			String reportejasper, Connection cnx) throws Exception;
	
	public List<Object> getCamposForma(String pathFile) throws Exception;
	public List<Object> getCamposForma(String pathFile, UsuarioDTO usuario) throws Exception;
	public  List<ParameterDTO> getParametros(String pathFile) throws Exception;
	public byte[] genera(String tipo,Map<String,Object> parameters,String reportejasper  ) throws Exception;
	public Object getObjectParams(ParameterDTO parametro, String value );
	public String getObjectParamsString(ParameterDTO parametro, String value );

}