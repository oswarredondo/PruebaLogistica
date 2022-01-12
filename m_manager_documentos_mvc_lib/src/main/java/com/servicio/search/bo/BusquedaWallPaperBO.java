package com.servicio.search.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.WallPaperDTO;
import com.servicio.search.ibo.IBusquedaWallPaperBO;
import com.servicio.search.idao.IBusquedaWallPaperDAO;

@Service
public class BusquedaWallPaperBO  implements IBusquedaWallPaperBO {

	private static final Logger logger = LoggerFactory
			.getLogger(BusquedaWallPaperBO.class);


	@Autowired
	IBusquedaWallPaperDAO iWallPaperDAO;
	public BusquedaWallPaperBO(){
		
	}
	@Override
	public List<WallPaperDTO> getRegistros(WallPaperDTO wallpaper)
			throws Exception {
		// TODO Auto-generated method stub
		return iWallPaperDAO.getRegistros(wallpaper);
	}
	@Override
	public WallPaperDTO get(WallPaperDTO wallpaper) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
