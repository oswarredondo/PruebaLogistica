package ar.com.unisolutions.dao;

import java.util.List;

import ar.com.unisolutions.dto.MercanciaSat;

public interface IMercanciaDAO {

	public List<MercanciaSat> getMercancia() throws Exception;
	
	public String getMercanciaById(String clavemcia) throws Exception;
	
}
