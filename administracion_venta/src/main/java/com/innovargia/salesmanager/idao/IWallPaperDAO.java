package com.innovargia.salesmanager.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.WallPaperDTO;

public interface IWallPaperDAO {

	public abstract void insert(WallPaperDTO wallpaper) throws Exception;

	public abstract void update(WallPaperDTO wallpaper) throws Exception;

	public abstract void updateEstatus(WallPaperDTO wallpaper) throws Exception;

	public abstract void delete(WallPaperDTO wallpaper) throws Exception;

	public abstract List<WallPaperDTO> getRegistros(WallPaperDTO wallpaper)
			throws Exception;

	public abstract WallPaperDTO get(WallPaperDTO wallpaper) throws Exception;

}