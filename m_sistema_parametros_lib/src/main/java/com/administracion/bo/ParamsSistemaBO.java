package com.administracion.bo;



import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.administracion.ibo.IParamsSistemaBO;
import com.administracion.idao.IParamsSistemaDAO;
import com.innovargia.mail.EmailProperties;
import com.innovargia.salesmanager.dtos.SistemaDTO;

@Service
public class ParamsSistemaBO implements IParamsSistemaBO {
	@Autowired
	IParamsSistemaDAO IParamsSistemaDAO;

	@Override
	public String getValorPropiedad(String idparametro, String idsistema)
			throws Exception {
		// TODO Auto-generated method stub
		return IParamsSistemaDAO.getValorPropiedad(idparametro, idsistema);
	}

	@Override
	public SistemaDTO getPathsSistema(String idSistema, String numCliente)
			throws Exception {
		// TODO Auto-generated method stub
		return IParamsSistemaDAO.getPathsSistema(idSistema, numCliente);
	}

	@Override
	public void insert(SistemaDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		IParamsSistemaDAO.insert(catalogo);
	}

	@Override
	public void update(SistemaDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		IParamsSistemaDAO.update(catalogo);
	}

	@Override
	public void delete(SistemaDTO catalogo) throws Exception {
		// TODO Auto-generated method stub
		IParamsSistemaDAO.delete(catalogo);
	}

	@Override
	public List<SistemaDTO> getRegistros(String sistema) throws Exception {
		// TODO Auto-generated method stub
		return IParamsSistemaDAO.getRegistros(sistema);
	}

	@Override
	public int getValorPropiedadInt(String idparametro, String idsistema)
		throws Exception {
	    // TODO Auto-generated method stub
	    return IParamsSistemaDAO.getValorPropiedadInt(idparametro, idsistema);
	}

	@Override
	public String getValorPropiedad(String idparametro,
		List<SistemaDTO> lista) throws Exception {
	    // TODO Auto-generated method stub
	    return IParamsSistemaDAO.getValorPropiedad(idparametro, lista);
	}

	@Override
	public int getValorPropiedadInt(String idparametro,
		List<SistemaDTO> lista) throws Exception {
	    // TODO Auto-generated method stub
	    return 0;
	}
	@Override
	public EmailProperties getPropiedadesEmail(EmailProperties propiedades,String sistema) throws SQLException{
		return IParamsSistemaDAO.getPropiedadesEmail(propiedades, sistema);
	}
	
}
