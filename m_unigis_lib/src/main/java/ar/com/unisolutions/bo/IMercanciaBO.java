package ar.com.unisolutions.bo;

import java.util.List;

import ar.com.unisolutions.dto.MercanciaSat;

public interface IMercanciaBO {

	List<MercanciaSat> getMercancia() throws Exception;

	String getMercanciaById(String clavemcia) throws Exception;

}
