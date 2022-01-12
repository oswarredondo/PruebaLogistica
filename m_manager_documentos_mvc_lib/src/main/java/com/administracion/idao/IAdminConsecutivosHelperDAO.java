package com.administracion.idao;

import java.sql.SQLException;

import com.innovargia.salesmanager.dtos.MetaDatoCatalogoDTO;

public interface IAdminConsecutivosHelperDAO {

    public abstract String getConsecutivo(MetaDatoCatalogoDTO meta)
	    throws SQLException;

    public abstract boolean existeTablaConsecutivos(MetaDatoCatalogoDTO meta)
	    throws Exception;

}