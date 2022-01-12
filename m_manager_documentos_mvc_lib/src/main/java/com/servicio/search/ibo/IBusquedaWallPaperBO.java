package com.servicio.search.ibo;

import java.util.List;

import com.innovargia.salesmanager.dtos.WallPaperDTO;

public interface IBusquedaWallPaperBO {


	public abstract List<WallPaperDTO> getRegistros(WallPaperDTO wallpaper)
			throws Exception;

	public abstract WallPaperDTO get(WallPaperDTO wallpaper) throws Exception;

}