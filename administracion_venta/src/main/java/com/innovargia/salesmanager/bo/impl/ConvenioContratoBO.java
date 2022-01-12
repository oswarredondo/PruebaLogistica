/**
 * 
 */
package com.innovargia.salesmanager.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.administracion.dto.UsuarioConvenioFolio;
import com.innovargia.constantes.ConstantesUtils;
import com.innovargia.mail.EmailProperties;
import com.innovargia.mail.SendEMail;
import com.innovargia.salesmanager.dtos.BusquedaDTO;
import com.innovargia.salesmanager.dtos.CatalogoDTO;
import com.innovargia.salesmanager.dtos.ConvenioContratoDTO;
import com.innovargia.salesmanager.dtos.ConvenioContratoDetalleDTO;
import com.innovargia.salesmanager.dtos.CuentasDTO;
import com.innovargia.salesmanager.dtos.SistemaDTO;
import com.innovargia.salesmanager.dtos.TarifaAdicionalDTO;
import com.innovargia.salesmanager.dtos.UsuarioCuentaDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.IAdicionalesBO;
import com.innovargia.salesmanager.ibo.IConvenioContratoBO;
import com.innovargia.salesmanager.ibo.IConvenioContratoDetalleBO;
import com.innovargia.salesmanager.ibo.ICuentasClientesBO;
import com.innovargia.salesmanager.ibo.ITarifaAdicionalBO;
import com.innovargia.salesmanager.ibo.IUsuarioBO;
import com.innovargia.salesmanager.idao.IConvenioContratoDAO;
import com.innovargia.salesmanager.idao.IConvenioDescuentoFacturaDAO;
import com.innovargia.salesmanager.idao.IMaterialEmpaqueDAO;
import com.innovargia.salesmanager.idao.IParametrosSistemaDAO;
import com.innovargia.utils.CheckSumUtility;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.GeneradorPassword;
import com.innovargia.utils.UtilsStringFechas;

/**
 * @author aruaro
 * 
 */
@Service
public class ConvenioContratoBO implements IConvenioContratoBO {

	private static final Logger logger = LoggerFactory
			.getLogger(ConvenioContratoBO.class);

	@Autowired
	IConvenioContratoDAO convenioDAO;
	@Autowired
	ITarifaAdicionalBO iTarifaAdicionalBO; 
	@Autowired
	IAdicionalesBO iAdicionalesBO;
	@Autowired 
	IConvenioContratoDetalleBO iConvenioContratoDetalleBO;
	@Autowired 
	ICuentasClientesBO iCuentasClientesBO;
        @Autowired
        IUsuarioBO iUsuarioBO;
        @Autowired
	IParametrosSistemaDAO iParametrosSistemaDAO;
        @Autowired
        IMaterialEmpaqueDAO iMaterialEmpaqueDAO;
        
        @Autowired
        IConvenioDescuentoFacturaDAO iConvenioDescuentoFacturaDAO;

	
	public ConvenioContratoBO(){
		
	}

	@Override
	public void insert(ConvenioContratoDTO obj) throws Exception {
		Number consecutivo =  convenioDAO.insert(obj);
		try{
			CatalogoDTO catalogo = new CatalogoDTO();
			catalogo.setTipo("1");
			catalogo.setEstatus(-1);//Todos los regisytros
			List<CatalogoDTO> lista_adicionales =iAdicionalesBO.getRegistrosXTipo(catalogo);
			if (lista_adicionales.size()>0){
				TarifaAdicionalDTO tarifaadicional =null;
				
				for (CatalogoDTO catalogoDTO : lista_adicionales) {
					tarifaadicional = new TarifaAdicionalDTO();
					tarifaadicional.setIdadicional(catalogoDTO.getIdentificador());
					tarifaadicional.setIdtarifa(consecutivo.intValue());
					tarifaadicional.setIdconvenio(consecutivo.intValue());
					tarifaadicional.setPrecio(catalogoDTO.getPrecio());
					tarifaadicional.setClaveadicional(catalogoDTO.getClave());
					tarifaadicional.setEstatus(catalogoDTO.getTipo()); 
					iTarifaAdicionalBO.insert(tarifaadicional);

				}
				
				
			}
		}catch(Exception e){
			logger.debug("Error al crear la tarifa:" +e.getMessage());
		}
	}

	@Override
	public void update(ConvenioContratoDTO obj) throws Exception {
	  
	    
	    convenioDAO.update(obj);
		
	}
	@Override
	public void updateFirmas(ConvenioContratoDTO obj) throws Exception {
		convenioDAO.updateFirmas(obj);
		
	}
	
	@Override
	public void updateDatosRevision(ConvenioContratoDTO obj) throws Exception {
		convenioDAO.updateDatosRevision(obj);
	}

	@Override
	public void delete(ConvenioContratoDTO obj) throws Exception {
		convenioDAO.delete(obj);
		
	}

	@Override
	public List<ConvenioContratoDTO> getRegistros(BusquedaDTO obj)
			throws Exception {
		// TODO Auto-generated method stub
		return convenioDAO.getRegistros(obj);
	}

	@Override
	public ConvenioContratoDTO get(ConvenioContratoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		return convenioDAO.get(obj);
	}

	@Override
	public void updateEstatus(ConvenioContratoDTO obj) throws Exception {
		// TODO Auto-generated method stub
		convenioDAO.updateEstatus(obj);
	}

	@Override
	@Transactional
	public int transformaCotizacion(ConvenioContratoDTO obj) throws Exception {
		
		//Obtiene la lista de Lineas del convenio
		ConvenioContratoDetalleDTO detalle = new ConvenioContratoDetalleDTO();
		detalle.setIdconvenio(obj.getIdconvenio());
		List<ConvenioContratoDetalleDTO> lista_detalle =iConvenioContratoDetalleBO.getRegistros(detalle);
		
		//Obtiene los adicionales
		TarifaAdicionalDTO adicional = new TarifaAdicionalDTO();
		adicional.setIdconvenio(obj.getIdconvenio());
		List<TarifaAdicionalDTO> lista_adicionales = iTarifaAdicionalBO.getRegistros(adicional);
		
		// Cambia der estatus la cotizacion
		obj.setEstatus(ConstantesUtils.ESTATUS_TRANSFORMACION_CONVENIO);
		convenioDAO.updateEstatus(obj);
		
		//Inserta el nuevo documento con los mismos datos de la cotizacion
		//pero ahora como convenio
		obj.setEstatus(ConstantesUtils.ESTATUS_EN_DOCUMENTACION);
		obj.setIdcotizacionorigen(obj.getIdconvenio());
		obj.setEstadoactualdoc(ConstantesAdminSale.DOC_CONVENIO);
		obj.setFechadocumento(UtilsStringFechas.obtenerFechaActual("yyyy-MM-dd") );
		Number  consecutivo = convenioDAO.insert(obj);
	
		//Agrega los adicionales con el numero de convenio
		for (TarifaAdicionalDTO tarifaAdicionalDTO : lista_adicionales) {
			tarifaAdicionalDTO.setIdconvenio(consecutivo.intValue());
			iTarifaAdicionalBO.insert(tarifaAdicionalDTO);
		}
		//Agrega las lineas 
		for (ConvenioContratoDetalleDTO detalle_Dto : lista_detalle) {
			detalle_Dto.setIdconvenio(consecutivo.intValue());
			iConvenioContratoDetalleBO.insertLineaCotizacionAConvenio(detalle_Dto);
		}
		
		//Agrega los datos de Materiales y Empaques al nuevo convenio
		iMaterialEmpaqueDAO.insertRegistrosContizacionAConvenio(obj.getIdconvenio(),
			consecutivo.intValue());
		
		//Agrega todos los registros de Descuentos por facturacion
		iConvenioDescuentoFacturaDAO.insertRegistrosDescuentoXFacturacion(obj.getIdconvenio(),
			consecutivo.intValue());
		
		//regresa el numero de convenio
		return consecutivo.intValue();
		
	}

	@Override
	public void updateUsuarioCreador(ConvenioContratoDTO obj) throws Exception {
		convenioDAO.updateUsuarioCreador(obj);
		
	}
	
	@Override
	public void creaCuentaAutoDoc(ConvenioContratoDTO convenio) throws Exception {
	    
	    List<SistemaDTO> prop_sistema = 
		    iParametrosSistemaDAO.getRegistros(ConstantesAdminSale.ID_SKY4SOL);
	    
		int identidad = iParametrosSistemaDAO.getValorPropiedadInt("entidad.default.clientes",prop_sistema ) ;
		int idorganizacion = iParametrosSistemaDAO.getValorPropiedadInt("organizacion.default.clientes",prop_sistema   ) ;
		int nivel = iParametrosSistemaDAO.getValorPropiedadInt("nivel.default.clientes",prop_sistema  ) ;
		String formatoetiqueta = iParametrosSistemaDAO.getValorPropiedad("formato.etiqueta.default.clientes",prop_sistema ) ;
		String idperfil  = iParametrosSistemaDAO.getValorPropiedad("perfil.default.clientes",prop_sistema ) ;
		String body_email_creacion_usuario = iParametrosSistemaDAO.getValorPropiedad("body.email.creacion.usuario.autodoc",prop_sistema ) ;
		String from_email = iParametrosSistemaDAO.getValorPropiedad("from.creacion.usuario.autodoc",prop_sistema ) ;
		String subject_email = iParametrosSistemaDAO.getValorPropiedad("subject.creacion.usuario.autodoc",prop_sistema ) ;

		
		
		//Crea la cuenta para autodocumentación
		BusquedaDTO busqueda = new BusquedaDTO();
		busqueda.setIdentidad(identidad);
		busqueda.setIdorganizacion(idorganizacion);
		busqueda.setNumcliente(convenio.getNumcliente());
		busqueda.setPatron_busqueda(convenio.getNumcliente());
		busqueda.setTipo(3); //Busqueda por numero de cliente
		List<CuentasDTO>  lista = iCuentasClientesBO.getBusquedaRegistros(busqueda);
		CuentasDTO cuenta =null;
		UsuarioCuentaDTO usuario =null;
		
		if (lista.size()<=0){
		    
		    //Agrega la cuenta
		    cuenta =  new CuentasDTO();
		    cuenta.setEstatus(true);
		    cuenta.setCuentabanco1(convenio.getNumcliente());
		    cuenta.setIdentidad(identidad);
		    cuenta.setIdorganizacion(idorganizacion);
		    cuenta.setRazonSocial(convenio.getRazonsocial_cte());
		    cuenta.setAtencion("");
		    cuenta.setNumCliente(convenio.getNumcliente());
		    cuenta.setCalle(convenio.getCalle_cte());
		    cuenta.setDireccion(convenio.getCalle_cte());
		    cuenta.setColonia(convenio.getColonia_cte());
		    cuenta.setMunicipio(convenio.getMunicipio_cte());
		    cuenta.setEstado(convenio.getEstado_cte());
		    cuenta.setCiudad(convenio.getMunicipio_cte());
		    cuenta.setCp(convenio.getCp_cte());
		    cuenta.setRfc(convenio.getRfc());
		    cuenta.setTelefono(convenio.getTelefono_cte());
		    cuenta.setContrato(convenio.getNumcliente());
		    cuenta.setCorreoe(convenio.getEmail_cte());
		    iCuentasClientesBO.insert(cuenta);
		    
		 
		    
		}else{
		    cuenta =  lista.get(0);
		}
		//Agrega un usuario por default, toma el dato 
		List<UsuarioCuentaDTO> lista_usuarios =
			iUsuarioBO.getRegistrosCuentaCliente(busqueda);
		
		 //"/[a-zA-Z]{3}[0-9]{7}/"	
		String cadena =  cuenta.getRazonSocial()!=null?
			   cuenta.getRazonSocial().trim():convenio.getRfc();
			   
		String login = GeneradorPassword.getLogin(cadena);
		String password = GeneradorPassword.getPassword(10);
		if (lista_usuarios.size()<=0){
		    List<String> lista_email = new ArrayList<String>();
		    usuario = new UsuarioCuentaDTO();
		   
		    usuario.setIdentidad(identidad);
		    usuario.setIdorganizacion(idorganizacion);
	            usuario.setLogin(login);
	            usuario.setNombre(usuario.getLogin());
	            usuario.setLogo("logoInferior.gif");
	            usuario.setNumcliente(convenio.getNumcliente());   
	            usuario.setEstatus("A");
	            usuario.setNivelpuesto(nivel);
	            usuario.setVisibilidad(0);
	            usuario.setFormatoetiperso(formatoetiqueta);
	            usuario.setIdperfil(idperfil);
	            usuario.setEmail(convenio.getEmail_cte());
	            usuario.setPassword(CheckSumUtility.encryptaPassWord( password.toUpperCase()));
		    iUsuarioBO.insert(usuario); 
		    
		    lista_usuarios.add(usuario);
		    lista_email.add(convenio.getEmail_cte());
		    body_email_creacion_usuario =body_email_creacion_usuario.replaceAll("@login", login);
		    body_email_creacion_usuario =body_email_creacion_usuario.replaceAll("@password", password);
		    
		   //Complementa la informacion de las propiedades del correo
		    EmailProperties email_propiedades = 
				   iParametrosSistemaDAO.getPropiedadesEmail(null, ConstantesAdminSale.ID_APP_MAIL);
			   
		    SendEMail.send(subject_email, 
			    lista_email, body_email_creacion_usuario, 
			    email_propiedades, from_email);
			
		}
		//Asigna a todos los usuarios el nuevo convenio
		for(UsuarioCuentaDTO user: lista_usuarios){
		    asignarConvenioAUsuario(user, convenio.getIdconvenio());
		}
		
		
		
	}

	@Override
	public void deleteUsuarioConvenioFolio(UsuarioConvenioFolio obj) throws Exception {
	    convenioDAO.deleteUsuarioConvenioFolio(obj);	    
	}

	@Override
	public List<UsuarioConvenioFolio> getConveniosUsuario(UsuarioDTO usuario)
		throws Exception {
	    // TODO Auto-generated method stub
	    return convenioDAO.getConveniosUsuario(usuario);
	}
	@Override
	public void asignarConvenioAUsuario(UsuarioCuentaDTO usuario, int idconvenio){
	    try {
		iUsuarioBO.insertConvenioUsuario(usuario, idconvenio);
	    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}

}
