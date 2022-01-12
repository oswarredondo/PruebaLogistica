package com.administracion.idao;

import java.sql.SQLException;

import com.innovargia.documentos.dtos.CODFXC;

public interface ICODDao {

    public abstract void updateEntregaCobro(CODFXC cod) throws SQLException;

    public abstract void updateDevolucion(CODFXC cod) throws SQLException;

    public abstract void insert(CODFXC cod) throws SQLException;
    public CODFXC getRegistrOcurres(String iddocumento) throws Exception;

}