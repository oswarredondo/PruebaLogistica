
package com.administracion.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import org.krysalis.barcode4j.tools.Length;
import org.springframework.jdbc.core.RowMapper;

import com.innovargia.rotulacion.dtos.EtiquetaRotulacionDTO;
import com.innovargia.salesmanager.dtos.CruceCoberturaDTO;
import com.innovargia.utils.ArrayElementos;
import com.innovargia.utils.FechasTimeStamp;
import com.innovargia.utils.UtilsStringFechas;
import com.innovargia.utils.sql.ResultSetUtils;
import com.servicio.dtos.Cobertura;
import com.servicio.dtos.DocumentoDTO;
import com.servicio.dtos.Zona;

public class EtiquetaRotularDTORowMapper implements RowMapper<EtiquetaRotulacionDTO>{

	String formatofecha = "dd-MM-yyyy HH:mm:ss";
	public EtiquetaRotularDTORowMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public EtiquetaRotulacionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		EtiquetaRotulacionDTO obj  =new EtiquetaRotulacionDTO();
		obj.setIddocumento(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("iddocumento",rs)));
		
		obj.setIdrangotarifa(ResultSetUtils.getRSInt("idrangotarifa", rs) );
		obj.setIdzonatarifa(ResultSetUtils.getRSInt("idzonatarifa", rs) );
		obj.setIdpesotarifa(ResultSetUtils.getRSInt("idpesotarifa", rs) );
		
		obj.setIdconveniodetalle(ResultSetUtils.getRSInt("idconveniodetalle", rs) );
		obj.setIdconvenio(ResultSetUtils.getRSInt("idconvenio",rs) ); 
		obj.setIdtarifa(ResultSetUtils.getRSInt("idtarifa",rs) ); 
		
		obj.setRuta(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("ruta",rs)));  
		
		obj.setPrecio_unitario(ResultSetUtils.getRSFloat("precio_unitario",rs) ); 
		obj.setCargo_adicional(ResultSetUtils.getRSFloat("cargo_adicional",rs) ); 
		obj.setImporte_servicio(ResultSetUtils.getRSFloat("importe_servicio",rs) ); 
		
		obj.setPesobase(ResultSetUtils.getRSInt("pesobase", rs) );
		
		obj.setLinea_consecutivo(ResultSetUtils.getRSInt("linea_consecutivo",rs) );
		obj.setUuid(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("uuid",rs)));
		obj.setIdproducto(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idproducto",rs)));
		obj.setIdoficina(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idoficina",rs)));
		obj.setOficinacontrol(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("oficinacontrol",rs)));
		obj.setIdservicio(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idservicio",rs)));
		obj.setIdtipocobro(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idtipocobro",rs)));

		obj.setIdadicional(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idadicional",rs)));
		
		obj.setPesobase(ResultSetUtils.getRSInt("pesobase", rs) );
		obj.setIdterminalori(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idterminalori",rs)));
		obj.setIdterminaldes(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idterminaldes",rs)));
		obj.setIdtipodocumento(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("idtipodocumento",rs)));
		obj.setFechacreacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("fechacreacion",rs)));
		obj.setReferencia(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("referencia",rs)));
		obj.setLogin(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("login",rs)));
		obj.setFactura(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("factura",rs)));
		obj.setAduana(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("pedimento",rs)));
		obj.setAduana(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("aduana",rs)));
		obj.setTipodeembalaje(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("tipodeembalaje",rs)));
		obj.setContenido(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("contenido",rs)));
		obj.setEnrutamiento(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("enrutamiento",rs)));
		obj.setObservacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("observacion",rs)));  
		obj.setZonaori(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("zonaori",rs)));
		obj.setZonades(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("zonades",rs)));
		obj.setTransportista(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("transportista",rs)));
		
		obj.setRazonsocial_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("razonsocial_rem",rs)));
		obj.setContacto_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("contacto_rem",rs)));
		obj.setCalle_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("calle_rem",rs)));
		obj.setColonia_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("colonia_rem",rs)));
		obj.setMunicipio_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("municipio_rem",rs)));
		obj.setCiudad_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("estado_rem",rs)));
		obj.setEstado_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("estado_rem",rs)));
		obj.setCp_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("cp_rem",rs)));
		obj.setTelefono_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("telefono_rem",rs)));
		obj.setCelular_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("celular_rem",rs)));
		obj.setRfc_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("rfc_rem",rs)));
		obj.setEmail_rem(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("email_rem",rs)));
		obj.setNuminterior_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("numinterior_rem",rs))); 
		obj.setNumexterior_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("numexterior_rem",rs))); 
		/* CAMBIO UNIGIS IDREMDES */
		obj.setIdRmDes_rem(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("idRmDes_rem",rs)));
		
		obj.setRazonsocial_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("razonsocial_des",rs)));
		obj.setContacto_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("contacto_des",rs)));
		obj.setCalle_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("calle_des",rs)));
		obj.setColonia_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("colonia_des",rs)));
		obj.setMunicipio_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("municipio_des",rs)));
		obj.setCiudad_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("estado_des",rs)));
		obj.setEstado_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("estado_des",rs)));
		obj.setCp_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("cp_des",rs)));
		obj.setTelefono_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("telefono_des",rs)));
		obj.setCelular_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("celular_des",rs)));
		obj.setRfc_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("rfc_des",rs)));
		obj.setEmail_des(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("email_des",rs)));
		obj.setNuminterior_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("numinterior_des",rs))); 
		obj.setNumexterior_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("numexterior_des",rs)));
		/* CAMBIO UNIGIS IDREMDES */
		obj.setIdRmDes_des(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("idRmDes_des",rs)));

		
		obj.setTiene_seguro(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("tiene_seguro",rs)));
		obj.setFactura_producto(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("factura_producto",rs)));
		
		obj.setFactura_producto_cod(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("factura_producto_cod",rs)));
		obj.setEs_ocurre(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("es_ocurre",rs)));
		
		obj.setNumcliente(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("numcliente",rs)));
		obj.setDescripcion(UtilsStringFechas.limpiaCadenaToUpper(ResultSetUtils.getRSString("descripcion",rs)));
		obj.setServiciotarifa(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("serviciotarifa",rs)));
		
		obj.setIdregistrodatos(ResultSetUtils.getRSInt("idregistrodatos",rs) );
		obj.setIdregistro(ResultSetUtils.getRSInt("idregistro",rs) );
		obj.setLargo(ResultSetUtils.getRSInt("largo",rs) );		  
		obj.setAncho(ResultSetUtils.getRSInt("ancho",rs) );
		obj.setAlto(ResultSetUtils.getRSInt("alto",rs) );

		obj.setVolumenamparado(ResultSetUtils.getRSFloat("volumenamparado", rs) );
		obj.setPesoamparado(ResultSetUtils.getRSFloat("pesoamparado", rs) ); 
		
		
		obj.setNumpiezas(ResultSetUtils.getRSInt("numpiezas",rs) );
		obj.setCantidad_total(ResultSetUtils.getRSInt("cantidad_total",rs) );  
		
		if (obj.getCantidad_total()<=0){
		    obj.setCantidad_total(obj.getNumpiezas());
		}
		obj.setIdentidad(ResultSetUtils.getRSInt("identidad",rs) );
		obj.setIdorganizacion(ResultSetUtils.getRSInt("idorganizacion",rs) );
		obj.setIdregistro_set(ResultSetUtils.getRSInt("idregistro_set",rs) ); 

		obj.setTiporotucacion(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("tiporotucacion",rs))); 
		
		obj.setValordeclarado(ResultSetUtils.getRSFloat("valordeclarado",rs) ); 
		obj.setPreciozona(ResultSetUtils.getRSFloat("preciozona",rs) ); 
		obj.setIva(ResultSetUtils.getRSFloat("iva",rs) ); 
		obj.setPesofisico(ResultSetUtils.getRSFloat("pesofisico",rs) ); 
		obj.setPesovolumetrico(ResultSetUtils.getRSFloat("pesovolumetrico",rs) ); 
		obj.setPesomayor(ResultSetUtils.getRSFloat("pesomayor",rs) ); 
		obj.setKms_origen_destino(ResultSetUtils.getRSFloat("kms_origen_destino",rs) ); 
		obj.setValor_asegurado(ResultSetUtils.getRSFloat("valor_asegurado",rs) ); 
		
		String descripcion_servicio = UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("descripcion_servicio",rs));
		descripcion_servicio = descripcion_servicio==null?"": descripcion_servicio.trim();
		
		String descripciongarantia =UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("descripciongarantia",rs));
		descripciongarantia = descripciongarantia==null?"": descripciongarantia.trim();
				
		obj.setDescripciongarantia(descripciongarantia); 
		
		obj.setDescripcion_servicio(descripcion_servicio + " " + descripciongarantia);  
		
		obj.setSiglasorigen(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("siglasorigen",rs))); 
		obj.setSiglasdestino(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("siglasdestino",rs)));  

		obj.setTiene_retorno(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("tiene_retorno",rs))); 
		obj.setEs_cod(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("es_cod",rs))); 
		obj.setEs_ocurre(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("es_ocurre",rs))); 
		obj.setEs_multiple(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("es_multiple",rs))); 
		obj.setTiporotulo(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("tiporotulo",rs))); 
		obj.setNacional(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("nacional",rs))); 
		obj.setTipoempaque(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("tipoempaque",rs))); 
		
		obj.setFactura_producto_asegurado(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("factura_producto_asegurado",rs))); 
		
		
		obj.setPesofisico_total(ResultSetUtils.getRSFloat("pesofisico_total",rs) );  
		obj.setPesovolumetrico_total(ResultSetUtils.getRSFloat("pesovolumetrico_total",rs) );   
		
		//Obtiene el datos de JSON
		obj.setJson_data(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("json_data",rs)));
		obj.setRemite(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("remite",rs))); 
		obj.setDestino(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("destinatario",rs)));  
		obj.setCantidad(ResultSetUtils.getRSInt("cantidad",rs) );  
		
		String enrutamientos = UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("enrutamientos",rs));
		 List<CruceCoberturaDTO> lista_transbordos = new ArrayList<CruceCoberturaDTO>();
		 CruceCoberturaDTO cobertura = null;
		
		if (enrutamientos!=null){
			String[] arr_enrutamiento = enrutamientos.split(",");
			String[] arr_enruta_plaza =null;
			if ((arr_enrutamiento!=null) && (arr_enrutamiento.length>0)){
				for (String enruta : arr_enrutamiento) {
					if ((enruta!=null) && (enruta.trim().length() >0)){
						cobertura = new CruceCoberturaDTO();
						arr_enruta_plaza = enruta.split("-");
						if (arr_enruta_plaza.length>1){
						    cobertura.setIdcoorigen(ArrayElementos.getString(arr_enruta_plaza,0));
						    cobertura.setIdcodestino(ArrayElementos.getString(arr_enruta_plaza,1)); 
						    cobertura.setTipo_transporte(ArrayElementos.getString(arr_enruta_plaza,2));
						    cobertura.setKms(ArrayElementos.getString(arr_enruta_plaza,3)); 
						}
						cobertura.setEnrutamiento(enruta);
						lista_transbordos.add(cobertura);
					}
				}
			}
		}
		
		obj.setArr_transbordos(lista_transbordos);
		obj.setAdicionales(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("adicionales",rs))); 
		
		obj.setNombreservicio(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("nombreservicio",rs))); 
		obj.setTarifa_servicio(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("tarifa_servicio",rs))); 

		obj.setPais_des(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("pais_des",rs)));  
		obj.setPais_rem(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("pais_rem",rs)));   
		
		obj.setCodigopais_des(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("codigopais_des",rs)));  
		obj.setCodigopais_rem(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("codigopais_rem",rs)));  

		
		//Verifica el calculo de los precios
		String calculaprecios = UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("calculaprecios",rs));  
		float precio_unitario =0;
		if (calculaprecios!=null){
		    
		    //km_amparados| precio_km_amparado|float_peso_actual|sobre_peso|precio_sobre_peso|precio_km_adicional_sp|precio_por_km
		    String[] arr_datos = calculaprecios.split("-");
		    precio_unitario = ArrayElementos.getFloat(arr_datos, 1)/ArrayElementos.getFloat(arr_datos, 0);
		    for (CruceCoberturaDTO cobertura_item : lista_transbordos) {
			cobertura_item.setCalculaprecios(calculaprecios);              
			//cobertura_item.setKms(ArrayElementos.getFloat(arr_datos, 0) );
			cobertura_item.setPrecio(ArrayElementos.getFloat(arr_datos, 1) ); 
			cobertura_item.setPrecio_unitario(precio_unitario );
			
		    }
		}
		
		obj.setDimensionmedida(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("dimensionmedida",rs)));
		obj.setPesomedida(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("pesomedida",rs)));
		obj.setTipocambio(ResultSetUtils.getRSFloat("tipocambio",rs) ); 
		obj.setValor_a_cobrar_cod(ResultSetUtils.getRSFloat("valor_a_cobrar_cod",rs) );
		obj.setValor_a_cobrar(ResultSetUtils.getRSFloat("valor_a_cobrar",rs) );
		obj.setPrecio_seguro(ResultSetUtils.getRSFloat("precio_seguro",rs) ); 
		obj.setEs_fxc(ResultSetUtils.getRSBoolean("es_fxc", rs));
		
		obj.setTiene_cita(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("tiene_cita", rs)));
		obj.setFecha_cita(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("fecha_cita", rs))); 
		obj.setHora_cita(UtilsStringFechas.convierteCadenaTrimNULL(ResultSetUtils.getRSString("hora_cita", rs))); 
		
		 return obj;
	}

}
