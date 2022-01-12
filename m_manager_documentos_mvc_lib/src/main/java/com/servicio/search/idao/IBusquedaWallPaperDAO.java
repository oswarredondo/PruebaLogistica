package com.servicio.search.idao;

import java.util.List;

import com.innovargia.salesmanager.dtos.WallPaperDTO;

public interface IBusquedaWallPaperDAO {


	public abstract List<WallPaperDTO> getRegistros(WallPaperDTO wallpaper)
			throws Exception;

	public abstract WallPaperDTO get(WallPaperDTO wallpaper) throws Exception;

}