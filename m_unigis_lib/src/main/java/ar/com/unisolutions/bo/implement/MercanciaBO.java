package ar.com.unisolutions.bo.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.unisolutions.bo.IMercanciaBO;
import ar.com.unisolutions.dao.IMercanciaDAO;
import ar.com.unisolutions.dto.MercanciaSat;

@Service
public class MercanciaBO implements IMercanciaBO{

	@Autowired
	IMercanciaDAO iMercanciaDAO;
	
	@Override
	public List<MercanciaSat> getMercancia() throws Exception {
		
		return iMercanciaDAO.getMercancia();
		
	}

	@Override
	public String getMercanciaById(String clavemcia) throws Exception {
		
		return iMercanciaDAO.getMercanciaById(clavemcia);
		
	}

}
