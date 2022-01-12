package com.administracion.ibo;

import java.sql.SQLException;

import com.innovargia.documentos.dtos.CODFXC;

public interface ICODBO {

    public abstract void updateEntregaCobro(CODFXC cod) throws SQLException;

    public abstract void updateDevolucion(CODFXC cod) throws SQLException;

    public abstract void insert(CODFXC cod) throws SQLException;
    public boolean esCOD(String servicio);
	  public CODFXC getRegistrOcurres(String iddocumento) throws Exception;

}