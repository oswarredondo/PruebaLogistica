package com.innovargia.salesmanager.bo.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovargia.salesmanager.dtos.WallPaperDTO;
import com.innovargia.salesmanager.ibo.IWallPaperBO;
import com.innovargia.salesmanager.idao.IWallPaperDAO;

@Service
public class WallPaperBO  implements IWallPaperBO {

	private static final Logger logger = LoggerFactory
			.getLogger(WallPaperBO.class);


	@Autowired
	IWallPaperDAO iWallPaperDAO;
	public WallPaperBO(){
		
	}
	@Override
	public void insert(WallPaperDTO wallpaper) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(WallPaperDTO wallpaper) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateEstatus(WallPaperDTO wallpaper) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(WallPaperDTO wallpaper) throws Exception {
		// TODO Auto-generated method stub
		
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
