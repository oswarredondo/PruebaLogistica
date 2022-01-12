package com.administracion.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.administracion.dto.ITextObjeto;
import com.administracion.idao.ITemplateEtiquetaDAO;
import com.administracion.rowmapper.ITextObjetoMapper;
import com.administracion.rowmapper.MetaDatoCatalogoRowMapper;
import com.innovargia.custom.exception.DBException;
import com.innovargia.documentos.dtos.Envio;

@Repository
public class TemplateEtiquetaDAO extends JdbcDaoSupport implements ITemplateEtiquetaDAO  {

	final String  sql_ = "SELECT * FROM rotulacion_disenio_etiqueta";


	private static final Logger logger = LoggerFactory
			.getLogger(TemplateEtiquetaDAO.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public TemplateEtiquetaDAO(DataSource dataSource) {
		setDataSource(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
				dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITemplateEtiquetaDAO#insertTemplate(com.administracion.dto.ITextObjeto)
	 */
	@Override
	public int insertTemplate(ITextObjeto template) throws DBException {
		
		String query = "INSERT INTO rotulacion_disenio_etiqueta("
				+ " identidad, idorganizacion, idtemplate, descripcion,"
				+ " ancho, alto,acusesololeyenda,estructuraguia)"
				+ " VALUES (:identidad, :idorganizacion, :idtemplate, :descripcion, "
				+ " :ancho, :alto,:acuseSoloLeyenda,:estructuraguia)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				template);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "idregistro" });
			Number id =  keyHolder.getKey();
			return id.intValue();
		}catch (DuplicateKeyException dk){
			throw new DBException("Registro duplicado");
		} catch (Exception dae) {
			logger.error("error insertTemplate:" + dae.getMessage());
			throw new DBException("Error al tratar de insertar el registro, verifique con el administrador.");

		}
		
	}
	

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITemplateEtiquetaDAO#insertTemplateDetalle(com.administracion.dto.ITextObjeto)
	 */
	@Override
	public int insertTemplateDetalle(ITextObjeto template) throws DBException {
		
		String query = "INSERT INTO rotulacion_disenio_etiqueta_detalle("
				+ " idtemplate, identidad, idorganizacion, campo, type,"
				+ " etiqueta, x, y, width, heigth, border, rotation, font, fontsize,"
				+ "  baseline,bloque)"
				+ " VALUES (  :idtemplate, :identidad, :idorganizacion, :campo, :type, "
				+ " :etiqueta, :x, :y, :width, :heigth, :border, :rotation, :font, :fontsize, "
				+ " :baseline,:bloque)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(
				template);

		try {
			this.namedParameterJdbcTemplate.update(query, parameterSource,
					keyHolder, new String[] { "idregistro" });
			Number id =  keyHolder.getKey();
			return id.intValue();
		}catch (DuplicateKeyException dk){
			throw new DBException("Registro duplicado");
		} catch (Exception dae) {
			logger.error("error insertTemplateDetalle:" + dae.getMessage());
			throw new DBException("Error al tratar de insertar el registro, verifique con el administrador.");

		}
		
	}
	
	


	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITemplateEtiquetaDAO#updateTemplate(com.administracion.dto.ITextObjeto)
	 */
	@Override
	public void updateTemplate(ITextObjeto template) throws DBException {
		String query = "UPDATE rotulacion_disenio_etiqueta "
				+ "  SET  descripcion=:descripcion, "
				+ "  ancho=:ancho, alto=:alto, acusesololeyenda =:acuseSoloLeyenda,"
				+ " estructuraguia=:estructuraguia "
				+ " WHERE  idregistro=:idregistro";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(template);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch (DuplicateKeyException dk){
			throw new DBException("Registro duplicado");
		} catch (Exception dae) {
			logger.error("error updateTemplate:" + dae.getMessage());
			throw new DBException("Error al tratar de actualizar el registro, verifique con el administrador.");

		}
		
	}
	

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITemplateEtiquetaDAO#updateTemplateDetalle(com.administracion.dto.ITextObjeto)
	 */
	@Override
	public void updateTemplateDetalle(ITextObjeto template) throws DBException {
		String query = "UPDATE rotulacion_disenio_etiqueta_detalle"
				+ " SET  campo=:campo, type=:type, etiqueta=:etiqueta, "
				+ " x=:x, y=:y, width=:width,heigth=:heigth, border=:border, "
				+ " rotation=:rotation, font=:font,fontsize=:fontsize,"
				+ " baseline=:baseline,bloque=:bloque WHERE idregistro=:idregistro ";
	
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(template);
	
		try{
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		}catch (DuplicateKeyException dk){
			throw new DBException("Registro duplicado");
		} catch (Exception dae) {
			logger.error("error updateTemplateDetalle:" + dae.getMessage());
			throw new DBException("Error al tratar de actualizar el registro, verifique con el administrador.");

		}
		
	}

	


	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITemplateEtiquetaDAO#deleteTemplate(com.administracion.dto.ITextObjeto, com.administracion.dto.ITextObjeto)
	 */
	@Override
	public void deleteTemplate(ITextObjeto template, ITextObjeto templatedetalle) throws DBException {
		String query1 = "DELETE FROM rotulacion_disenio_etiqueta WHERE idregistro=:idregistro";
		String query2 = "DELETE FROM rotulacion_disenio_etiqueta_detalle WHERE idtemplate=:idtemplate";
		
	
		try{
			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(templatedetalle);
			this.namedParameterJdbcTemplate.update(query2, parameterSource);
			 parameterSource = new BeanPropertySqlParameterSource(template);
			this.namedParameterJdbcTemplate.update(query1, parameterSource);
		} catch (Exception dae) {
			logger.error("error deleteTemplate:" + dae.getMessage());
			throw new DBException("Error al tratar de borrar el registro, verifique con el administrador.");

		}
		
	}
	

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITemplateEtiquetaDAO#deleteTemplate(com.administracion.dto.ITextObjeto)
	 */
	@Override
	public void deleteTemplateDetalle(ITextObjeto template) throws DBException {
		String query = "DELETE FROM rotulacion_disenio_etiqueta_detalle WHERE idregistro=:idregistro";
		
	
		try{
			SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(template);
			
			this.namedParameterJdbcTemplate.update(query, parameterSource);
		} catch (Exception dae) {
			logger.error("error deleteTemplateDetalle:" + dae.getMessage());
			throw new DBException("Error al tratar de borrar el registro, verifique con el administrador.");

		}
		
	}
	
	
	@Override
	public List<Envio> getDatosTablaContenido(List<Envio> arrDatosTabla)throws DBException {
		
		/*DEBIDO A QUE NOS APOYAMMOS CON REGISTROS DELTEMPLATE DE BASE DE DATOS, ANTES DE CUALQUIE
		 * PROCESO LIMPIAMOS LOS REGISTROS EN LOS CUALES NOS APOYAMOS, ESTO DEBIDO A QUE AL MOMENTO
		 * DE ESCRIBIR EN EL PDF, NO SE NOS RECONOCEN SALTOS DE LINEA NI TABULACIONES POR LO CUAL 
		 * EL FORMATO DE GUIA MADRE QUE SE TENIA CONTEMPLADO NO SE VERIA COMO SE DESEA */
		
		/* LIMPIAMOS LOS REGISTROS DE APOYO */
		String limpiarDatos = " UPDATE rotulacion_disenio_etiqueta_detalle SET ETIQUETA = :datoLimpio WHERE IDREGISTRO IN (570,571,572,573) AND IDTEMPLATE = 'TRACUSA MADRE'";
		
		MapSqlParameterSource paramsLimpios = new MapSqlParameterSource();
		
		paramsLimpios.addValue("datoLimpio", "");
		
		this.namedParameterJdbcTemplate.update(limpiarDatos, paramsLimpios);
		
		/* ANTERIORMENTE EN LA REFERENCIA GUARDAMOS LOS TADOS SEPARADOS POR ~
		 * AQUI LOS OBTENEMOS Y LOS SPLITEAMOS PARA INSERTARLOS EN NUETROS
		 * REGISTROS DE APOYO */
		String[] arrDatos = arrDatosTabla.get(0).getReferencia().split("~");
		
		/* OBTENEMOS EL TAMAÑO DE EL ARREEGLO */
		int cont = (arrDatos.length -1); 
		
		/* ESTA VARIABLE NOS AYUDA YA QUE NUESTROS REGISTROS DE APOYO, TIENE IDS
		 * CONSECUTIVOS A 570 */
		int idRegistro = 570;
		
		/* CREAMOS LA CONSULTA DE UPDATE QUE HAREMOS PARA CADA REGISTRO DE APOYO Y LA REPETIMOS EN EL FOR
		 * PEROP CON DIFERENTE ID Y DATO */
		String sql = " UPDATE rotulacion_disenio_etiqueta_detalle SET ETIQUETA = :datos WHERE IDREGISTRO = :idRegistro AND IDTEMPLATE = 'TRACUSA MADRE'";
		
		
		arrDatosTabla.get(0).setReferencia(arrDatos[0]);
			
			/* CICLO DE REPETICIO0NES PARA EL UPDATE */
			for(int i = 1; i <= cont; i++){
				
				try {
					
					MapSqlParameterSource params = new MapSqlParameterSource();
					
					params.addValue("datos", arrDatos[i]);
					
					params.addValue("idRegistro", idRegistro);
					
					this.namedParameterJdbcTemplate.update(sql, params);
					
					/* VAMOS AUMENTANDO EL ID DE REGISTRO
					 * PARA USAR OTROREGISTRO DEAPOYO PREDEFINIDO */
					idRegistro++;

				} catch (Exception e) {
					
					logger.error("Error :" + e.getMessage());

				}
				
			}
			
		//REGRESAMOS LA MISMA LIUSTA QUE RECIBIMOS	
		return arrDatosTabla;
		
	}

	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITemplateEtiquetaDAO#getRegistrosTemplate(com.administracion.dto.ITextObjeto)
	 */
	@Override
	public List<ITextObjeto> getRegistrosTemplate(ITextObjeto template)throws DBException {
		List<ITextObjeto> lista = new ArrayList<ITextObjeto>();
		String sql = " select * from rotulacion_disenio_etiqueta ";
		
		try{
			if (template != null) {
				sql = sql + " WHERE idregistro= ?";
				// Signidica que debe traer todos los registros
				lista = jdbcTemplate.query(sql, new Object[] { template.getIdregistro() }, new ITextObjetoMapper());
			} else {

				// Signidica que debe traer todos los registros
				lista = jdbcTemplate.query(sql, new ITextObjetoMapper());
			}
		} catch (Exception dae) {
			logger.error("error getRegistrosTemplate:" + dae.getMessage());
			throw new DBException("Error al tratar de obtener el los datos del registro solicitado,"
					+ " verifique con el administrador.");

		}
		
		return lista;
	}
	

	@Override
	public List<ITextObjeto> getRegistrosTemplate(String idtemplate)throws DBException {
		List<ITextObjeto> lista = new ArrayList<ITextObjeto>();
		String sql = " select * from rotulacion_disenio_etiqueta ";
		try {
			if ((idtemplate != null) && (idtemplate.trim().length() > 0)) {
				sql = sql + "WHERE idtemplate=?";
				// Signidica que debe traer todos los registros
				lista = jdbcTemplate.query(sql, new Object[] { idtemplate }, new ITextObjetoMapper());
			} else {
				// Signidica que debe traer todos los registros
				lista = jdbcTemplate.query(sql, new ITextObjetoMapper());
			}

		} catch (Exception dae) {
			logger.error("error getRegistrosTemplate:" + dae.getMessage());
			throw new DBException("Error al tratar de obtener el los datos del registro solicitado,"
					+ " verifique con el administrador.");

		}

		
		return lista;
	}
	
	/* (non-Javadoc)
	 * @see com.innovargia.salesmanager.dao.impl.ITemplateEtiquetaDAO#getRegistrosLineas(com.administracion.dto.ITextObjeto)
	 */
	@Override
	public List<ITextObjeto> getRegistrosLineas(ITextObjeto template)throws DBException {
		List<ITextObjeto> lista = new ArrayList<ITextObjeto>();
		String sql = "  SELECT rotulacion_disenio_etiqueta_detalle.*,'var'|| rownum || '=' ||  linea  AS lineaplnatilla"
				+ " FROM rotulacion_disenio_etiqueta_detalle LEFT OUTER JOIN ("
				+ "	 select  idregistro,row_number() over (order by idregistro) as rownum,CASE "
				+ "		    WHEN type='cb' THEN    type || '|' || campo || '|' ||  x || '|' || y || '|' ||width|| '|' ||heigth|| '|' ||rotation|| '|' ||baseline "
				+ "		    WHEN type='cbabove' THEN type || '|' || campo || '|' ||  x || '|' || y || '|' ||width|| '|' ||heigth|| '|' ||rotation|| '|' ||baseline  "
				+ "		    WHEN type='label' THEN type || '|' || campo  || '|' || fontsize || '|' ||  x || '|' || y || '|' ||rotation|| '|' ||font|| '|' ||etiqueta"
				+ "		    WHEN type='text' THEN type || '|' ||  etiqueta || '|' || fontsize || '|' ||  x || '|' || y || '|' ||rotation|| '|' ||font|| '|' ||campo"
				+ "		    WHEN type='rectangle' THEN type || '|' ||  x || '|' || y || '|' ||width|| '|' ||heigth|| '|' ||border"
				+ "		    WHEN type='pdf' THEN  type || '|' || campo || '|' ||  x || '|' || y || '|' ||width|| '|' ||heigth|| '|' ||rotation  "
				+ "		    WHEN type='image' THEN type || '|' || campo || '|' ||  x || '|' || y "
				+ "		    ELSE ''"
				+ "	       END as linea"
				+ "	from rotulacion_disenio_etiqueta_detalle"
				+ ")lineas	ON rotulacion_disenio_etiqueta_detalle.idregistro=lineas.idregistro WHERE idtemplate=?";

		//Signidica que debe traer todos los registros
		try{
			lista = jdbcTemplate.query(sql,new Object[]{template.getIdtemplate()},new ITextObjetoMapper());
		} catch (Exception dae) {
			logger.error("error getRegistrosLineas:" + dae.getMessage());
			throw new DBException("Error al tratar de obtener el los datos del registro solicitado,"
					+ " verifique con el administrador.");

		}
		
		return lista;
	}
	
	
}
