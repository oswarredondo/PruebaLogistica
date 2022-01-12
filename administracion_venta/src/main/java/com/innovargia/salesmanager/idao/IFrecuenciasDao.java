package com.innovargia.salesmanager.idao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.innovargia.documentos.dtos.Frecuencias;
import com.innovargia.documentos.dtos.Regional;
import com.innovargia.salesmanager.dtos.UsuarioDTO;

public interface IFrecuenciasDao {

	/**
	 * Obtiene los datos de la frecuencia de acuerdo al tipo de servicio y cp indicados por el usuario
	 * Siempre devuelve la frecuencia con mayor prioridad que se encuentre. ejemplo:
	 * 
	 * Si existen frecuencias para diferentes mensajerias el mismo CP= 09230 y Garantia 1, si al consultarlo
	 * se obtienen tres registros como:
	 * 
	 * REDPACK --> PRIORIDAD 1
	 * ESTAFETA --> PRIORIDAD 3
	 * DHL-->--> PRIORIDAD 2
	 * 
	 * La consulta devolveria solo el registro perteneciente a REDPACK por tener una mayor prioridad de entrega
	 * 
	 * @param cp Código postal que se desea consultar
	 * @param idserv identificador del servicio que se esta contratando
	 * @throws SQLException
	 * @return una instancia de Frecuencias con los datos encontrados o null en caso de no encontrar 
	 * frecuencia 
	 */
	public abstract Frecuencias getFrecuenciaCP(String cp, String idgarantia,
			UsuarioDTO usuario);//fin de getFrecuenciaCP

	/**
	 * Obtiene las frecuencias de entrega de un cp destino de acuerdo a los folios de servicios asignados
	 * a una cuenta de cliente asociado a un usuario.
	 * 
	 * Si encuentra frecuencias correspondientes a los folios asigandos a una cuenta devuelve un arreglo con 
	 * todas las frecuencias
	 * @param cp
	 * @param usuario
	 * @return
	 * @throws SQLException
	 */
	public abstract List<Frecuencias> getFrecuenciasCPFoliosUsuario(String cp,
			UsuarioDTO usuario) throws SQLException;

	/**
	 * Obtiene los datos de todas las  frecuencias de acuerdo al tipo de garantia y cp indicados por el usuario
	 * en caso de que no se indique garantia se obtienen todas las frecuencias para el cp solicitado.
	 * 
	 * Si la garantia se manda en null se devuelven todas las garantias amparadas por el CP indicado, los CPs
	 * devueltos son de la entidad y organizacion asignada al usuario
	 *
	 * @param cp Código postal que se desea consultar
	 * @param idgarantia identificador del servicio que se esta contratando
	 * @throws SQLException
	 *  @return un objeto ArrayList con instancias de Frecuencias con los datos encontrados o una lista vacia
	 *  en caso de no encontrar información
	 */
	public abstract  List<Frecuencias> getFrecuenciasCP(String cp, String idgarantia,
			UsuarioDTO usuario) throws SQLException;//fin de getFrecuenciasCP

	/**
	 *  Obtiene los datos de Regionales origen y destino, para determinar si hay cobertura de 
	 *  entrega entre un estado origen y un destino. Si existe se obtiene el tipo de servicio
	 *  para verificar si existe garantia de entrega para el servicio seleccionado
	 * @param reginalOri regional origen de acuerdo a su cp origen
	 * @param regionalDes regional destino de acuerdo a su cp destino
	 * @return una instancia de {@link Regional} con los datos encontrados
	 */
	public abstract Regional getGarantiaRegional(int regionalOri,
			int regionalDes);//fin de getGarantiaRegional
	
	
   	public Frecuencias getFrecuenciasEntregaCP(String cp)throws SQLException;

   	    public Frecuencias getRutaAsignada(String cp)throws SQLException;
}