package com.servicio.search.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.servicio.dtos.OficinasDTO;
import com.servicio.search.ibo.IBusquedaPDVsBO;
import com.servicio.search.idao.IBusquedaOficinasReceptorasDao;

@Service
public class BusquedaPDV implements IBusquedaPDVsBO {

    public BusquedaPDV() {
	// TODO Auto-generated constructor stub
    }

    @Autowired
    IBusquedaOficinasReceptorasDao iOficinasReceptorasDao;

    private static final Logger logger = LoggerFactory
	    .getLogger(BusquedaPDV.class);

    @Override
    public List<OficinasDTO> getOficinasReceptoras(BusquedaDTO busqueda)
	    throws SQLException {
	// TODO Auto-generated method stub
	return iOficinasReceptorasDao.getOficinasReceptoras(busqueda);
    }

    @Override
    public List<OficinasDTO> getOficinasReceptorasPDVCaja(BusquedaDTO busqueda)
	    throws SQLException {
	return iOficinasReceptorasDao.getOficinasReceptorasPDVCaja(busqueda);
    }

    @Override
    public List<OficinasDTO> getOficinasReceptorasConOcurre(BusquedaDTO busqueda)
	    throws SQLException {

	return iOficinasReceptorasDao.getOficinasReceptorasConOcurre(busqueda);
    }

    @Override
    public List<OficinasDTO> getPDVAsignadosAlUsuario(BusquedaDTO busqueda)
	    throws SQLException {
	if (busqueda.getTipo()==1){ //Oficinas de un usuario
	    return iOficinasReceptorasDao.getPDVAsignadosAlUsuario(busqueda);
	}else if (busqueda.getTipo()==2){//Usuarios Asignados a una oficina
	    return iOficinasReceptorasDao.getUsuarioAsignadosAlPDV(busqueda);
	}
	
	return new ArrayList<OficinasDTO>();
	
    }

    @Override
    public void insert(OficinasDTO objeto) throws Exception {

    }

    @Override
    public List<OficinasDTO> getOficinasReceptorasPDVs(BusquedaDTO busqueda)
	    throws SQLException {
	// TODO Auto-generated method stub
	return iOficinasReceptorasDao.getOficinasReceptorasPDVs(busqueda);
    }

    @Override
    public OficinasDTO getOficinaReceptora(BusquedaDTO busqueda)
	    throws SQLException {
	// TODO Auto-generated method stub
	return iOficinasReceptorasDao.getOficinaReceptora(busqueda);
    }

}
