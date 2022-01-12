/**
 * 
 */
package com.innovargia.administracion.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.administracion.ibo.IManifiestoLogisticaBO;
import com.innovargia.salesmanager.dtos.LogHistoriaDTO;
import com.innovargia.salesmanager.dtos.LogMovimientoProcesadoDTO;
import com.innovargia.salesmanager.dtos.UsuarioDTO;
import com.innovargia.salesmanager.ibo.ILogMovimientosProcesadosBO;
import com.innovargia.utils.ConstantesAdminSale;
import com.innovargia.utils.MimeTypes;
import com.innovargia.utils.UtilsRequest;
import com.innovargia.utils.UtilsStrings;
import com.servicio.dtos.DocumentoConsultaDTO;
import com.servicio.dtos.ManifiestoDTO;

/**
 * @author Adrian Morales Ruaro
 *         /manifiestomovimientos/consultaRegistrosManifiesto
 */
@RequestMapping("/manifiestomovimientos")
@Controller
public class ManifiestoMovimientosController {

	private static final Logger logger = LoggerFactory.getLogger(ManifiestoMovimientosController.class);

	@Autowired
	IManifiestoLogisticaBO manifiestosBO;
	@Autowired
	ILogMovimientosProcesadosBO iLogMovimientosProcesadosBO;

	public static String _TIPODOCUMENTO = "ORDENSERV";
	private int POSICION_FINAL_MANIF = 32000;

	/**
	 * 
	 */
	public ManifiestoMovimientosController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/generaManifiestoEntradas")
	public @ResponseBody Map<String, ? extends Object> generaManifiestoEntradas(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		// Verifica si el usuario tiene una sesion valida
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		String str_manifiesto = "";
		try {
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			String tiporegistro = request.getParameter("tiporegistro");

			if (!"01".equals(tiporegistro) && !"02".equals(tiporegistro) && !"03".equals(tiporegistro)
					&& !"21".equals(tiporegistro)) {
				throw new Exception("TIPO DE MOVIMIENTO INVALIDO [" + tiporegistro + "] ..");
			}
			List<LogHistoriaDTO> contadores = null;
			String plaza = request.getParameter("plaza");
			plaza = UtilsStrings.formateaCadenaComillas(plaza);

			String tipotranslado = "A";// request.getParameter("tipotranslado");
			String local_foraneo = request.getParameter("tipotranslado");
			if ("A".equals(tipotranslado)) {
				tipotranslado = null;
			}

			if ("01".equals(tiporegistro)) {
				contadores = iLogMovimientosProcesadosBO.getGuiasViajeRutaEntradas(request.getParameter("viaje"),
						request.getParameter("tramo"), tipotranslado, false, plaza, tiporegistro);
			} else if ("02".equals(tiporegistro)) {
				contadores = iLogMovimientosProcesadosBO.getGuiasViajeRutaEntradas(request.getParameter("viaje"),
						request.getParameter("tramo"), tipotranslado, false, plaza, tiporegistro);
			} else if ("03".equals(tiporegistro)) {

				contadores = iLogMovimientosProcesadosBO.getGuiasViajeRutaEntradas(request.getParameter("viaje"),
						request.getParameter("tramo"), null, false, plaza, tiporegistro);
			} else if ("21".equals(tiporegistro)) {

				contadores = iLogMovimientosProcesadosBO.getGuiasViajeRutaEntradas(request.getParameter("viaje"),
						request.getParameter("tramo"), null, false, plaza, tiporegistro);
			}

			if (contadores.size() <= 0) {
				throw new Exception("NO EXISTE INFORMACION PENDIENTE QUE MANIFESTAR PARA LOS CRITERIOS SELECCIONADOS");
			}

			/* Se reciben todas las variables del request */
			String viaje = request.getParameter("viaje");
			String tramo = request.getParameter("tramo");
			String ruta = request.getParameter("ruta");
			String deptodes = request.getParameter("deptodes");
			String corrida = request.getParameter("corrida");
			String guias = request.getParameter("guias");
			String depto = request.getParameter("depto");

			String manifiesto_viaje = request.getParameter("manifiesto_viaje");
			String manifiesto_tramo = request.getParameter("manifiesto_tramo");
			String manifiesto_supervisor = request.getParameter("manifiesto_supervisor");
			String manifiesto_operador1 = request.getParameter("manifiesto_operador1");
			String manifiesto_operador2 = request.getParameter("manifiesto_operador2");
			String manifiesto_economico = request.getParameter("manifiesto_economico");
			String manifiesto_cincho = request.getParameter("manifiesto_cincho");

			String enrutamiento = request.getParameter("manifiesto_cincho");

			String tipoDoc = getTipoDocto(tiporegistro, local_foraneo);
			String prefijo = getTipoSufijo(tiporegistro);
			if (tipoDoc == null) {
				throw new Exception("TIPO DE DOCUMENTO INVALIDO");
			}

			String idGuia = "";
			String manifiestoCreado = "";
			String manifiestosFinales = "";
			int auxExclude = 0;

			String[] guiasExcluidas = guias.split(",");
			int exAux = 0;

			/* Recorremos la lista con todos los datos del grid */
			for (int i = 0; i < contadores.size(); i++) {

				/* Obtenemos el dato madre */
				String esMadre = contadores.get(i).getIddocumentomadre();

				/*
				 * En caso de ser madre tendra un dato id en caso de no ser
				 * tendra NA
				 */
				if (!esMadre.equals("NA")) {

					idGuia = "";

					for (int k = 0; k < guiasExcluidas.length; k++) {

						/*
						 * Verificamos que el id madre no se haya seleccionado
						 * para excluirlo
						 */
						if (("'"+esMadre+"'").equals(guiasExcluidas[k])) {

							exAux = 1;

							break;

						} else {

							exAux = 0;

						}
					}

					/* En caso de que el dato no sea excluido */
					if (exAux != 1) {
						
						idGuia = esMadre;
						
						/* Se inicializa el manifiesto en "" */
						str_manifiesto = "";

							manifiestoCreado = crearManifiestos(usuario, str_manifiesto,

									viaje, tramo, ruta, deptodes, corrida, guias, depto, tipotranslado, plaza,

									manifiesto_viaje, manifiesto_tramo, manifiesto_supervisor, manifiesto_operador1,
									manifiesto_operador2, manifiesto_economico, manifiesto_cincho,

									enrutamiento,

									tiporegistro, local_foraneo,

									idGuia, esMadre);

							/*
							 * Un vez terminando de recorrerlas guias hijas
							 * deuna guia amdre asignamos el distintivo Madre
							 * ysu manifiestopara poder diferenciarlo de un
							 * manifiesto individual
							 */
							manifiestoCreado = "Madre," + manifiestoCreado;

							/*
							 * En caso de que la variable donde se guardan los
							 * manifiestos finales se encuentre vacia, eso
							 * quiere decir que es el primer manifiesto generado
							 */
							if (manifiestosFinales.equals("")) {

								/*
								 * agregamos el distintivo y manifiesto pero no
								 * ponemos ~ ya que puede pasar que solo sea un
								 * manifiesto
								 */
								manifiestosFinales = manifiestoCreado;

							} else {

								/*
								 * En caso de que la variable donde se guardan
								 * los manifiestos finales ya cuente con algo,
								 * esto nos quier decir que ya seproceso un
								 * manifiesto por lo cual agregams nuestro
								 * siguiente manifiesto procesado separados por
								 * ~
								 */
								manifiestosFinales = manifiestosFinales + "~" + manifiestoCreado;

							}

						
					}
					/* En caso de que no sea una guia madre */
				} else {

					/* Se obtiene el id de la guia */
					idGuia = esMadre;
					guias = "";
					
					for (int n = i; n < contadores.size(); n++) {

						for (int m = 0; m < guiasExcluidas.length; m++) {

							if (("'"+contadores.get(n).getIdenvio()+"'").equals(guiasExcluidas[m])) {
								
								auxExclude = 1;
								
								break;
								

							}

						}
						
						if(auxExclude == 0){
							
							if (guias == "") {

								/* Obtenemos el id de la guia */
								guias = "'"+contadores.get(n).getIdenvio()+"'";

							} else {

								/* Obtenemos el id de la guia */
								guias = guias + "," +"'"+contadores.get(n).getIdenvio()+"'";

							}
							
						}
						
						auxExclude = 0;
						
				}
					
					
					manifiestoCreado = crearManifiestos(usuario, str_manifiesto,

							viaje, tramo, ruta, deptodes, corrida, guias, depto, tipotranslado, plaza,

							manifiesto_viaje, manifiesto_tramo, manifiesto_supervisor, manifiesto_operador1,
							manifiesto_operador2, manifiesto_economico, manifiesto_cincho,

							enrutamiento,

							tiporegistro, local_foraneo,

							idGuia, esMadre);

					/*
					 * Un vez terminando de procesar la guia asignamos el
					 * distintivo individual y su manifiestopara poder
					 * diferenciarlo de un manifiesto madre
					 */
					manifiestoCreado = "Individual," + manifiestoCreado;

					/*
					 * en caso de quenop haya guias procesadas anteriormente en
					 * nuestra variable ponemos nuestro distintivo ymanifiesto
					 * en la variable pero sin ~ ya que puedepasar que solo se
					 * agregeundato
					 */
					if (manifiestosFinales.equals("")) {

						manifiestosFinales = manifiestoCreado;

					} else {

						/*
						 * En caso de que la variable donde se guardan los
						 * manifiestos finales ya cuente con algo, esto nos
						 * quier decir que ya seproceso un manifiesto por lo
						 * cual agregams nuestro siguiente manifiesto procesado
						 * separados por ~
						 */
						manifiestosFinales = manifiestosFinales + "~" + manifiestoCreado;

					}

					break;

				}
			}

			// /* Recorremos la lista con todos los datos del grid */
			// for (int i = 0; i < contadores.size(); i++) {
			//
			// /* Obtenemos el dato madre */
			// String esMadre = contadores.get(i).getIddocumentomadre();
			//
			// /*
			// * En caso de ser madre tendra un dato id en caso de no ser
			// * tendra NA
			// */
			// if (!esMadre.equals("NA")) {
			//
			// for (int k = 0; k < guiasExcluidas.length; k++) {
			//
			// /*
			// * Verificamos que el id madre no se haya seleccionado
			// * para excluirlo
			// */
			// if (esMadre.equals(guiasExcluidas[k])) {
			//
			// exAux = 1;
			//
			// break;
			//
			// } else {
			//
			// exAux = 0;
			//
			// }
			// }
			//
			// /* En caso de que el dato no sea excluido */
			// if (exAux != 1) {
			//
			// /* Se inicializa el manifiesto en "" */
			// str_manifiesto = "";
			//
			// List<LogHistoriaDTO> datosMadre = new
			// ArrayList<LogHistoriaDTO>();
			//
			// /*
			// * Traemos todas las guias individuales que ampara
			// * nuestra guia madre
			// */
			// datosMadre =
			// iLogMovimientosProcesadosBO.getGuiasViajeRutaEntradasMadre(
			// request.getParameter("viaje"), request.getParameter("tramo"),
			// null, false, plaza,
			// tiporegistro, esMadre);
			//
			// /*
			// * Recorremos los datos que obtenimos de la guia madre
			// */
			// for (int j = 0; j < datosMadre.size(); j++) {
			//
			// /* Obtenemos el id de la guia */
			// idGuia = datosMadre.get(j).getIdenvio();
			//
			// /*
			// * Verificamos que el id no se encuentre en la lista
			// * de guia a excluir
			// */
			// for (int l = 0; l < guiasExcluidas.length; l++) {
			//
			// if (idGuia == guiasExcluidas[l]) {
			//
			// exAux = 1;
			//
			// break;
			//
			// } else {
			//
			// exAux = 0;
			//
			// }
			//
			// }
			//
			// /* En caso de que no sea una guia excluida */
			// if (exAux != 1) {
			//
			// /*
			// * Mandamos a llamar al metodo que realizara
			// * todo el proceso y enviamos los dos que
			// * obtenemos del request en caso de ser un
			// * manifiesto nuevo str_manifiesto estara vacio
			// * en caso de seguir con la misma guia madre,
			// * str_manifiesto tendra el mismo manifiesto
			// * para todas las guias hijas
			// */
			//
			// /*
			// * si str_manifiesto esta vacio el metodo creara
			// * autoimaticamente un manifiesto nuevo el cual
			// * almacenaremos en manifiestoCreado
			// */
			// manifiestoCreado = crearManifiestos(usuario, str_manifiesto,
			//
			// viaje, tramo, ruta, deptodes, corrida, null, depto,
			// tipotranslado, plaza,
			//
			// manifiesto_viaje, manifiesto_tramo, manifiesto_supervisor,
			// manifiesto_operador1,
			// manifiesto_operador2, manifiesto_economico, manifiesto_cincho,
			//
			// enrutamiento,
			//
			// tiporegistro, local_foraneo,
			//
			// idGuia);
			//
			// /*
			// * Esto se hace con el fin de asignar todas las
			// * guias hijas de una guia madre al mismo
			// * manifiesto
			// */
			// str_manifiesto = manifiestoCreado;
			//
			// }
			//
			// }
			//
			// str_manifiesto = "";
			//
			// /*
			// * Un vez terminando de recorrerlas guias hijas deuna
			// * guia amdre asignamos el distintivo Madre ysu
			// * manifiestopara poder diferenciarlo de un manifiesto
			// * individual
			// */
			// manifiestoCreado = "Madre," + manifiestoCreado;
			//
			// /*
			// * En caso de que la variable donde se guardan los
			// * manifiestos finales se encuentre vacia, eso quiere
			// * decir que es el primer manifiesto generado
			// */
			// if (manifiestosFinales.equals("")) {
			//
			// /*
			// * agregamos el distintivo y manifiesto pero no
			// * ponemos ~ ya que puede pasar que solo sea un
			// * manifiesto
			// */
			// manifiestosFinales = manifiestoCreado;
			//
			// } else {
			//
			// /*
			// * En caso de que la variable donde se guardan los
			// * manifiestos finales ya cuente con algo, esto nos
			// * quier decir que ya seproceso un manifiesto por lo
			// * cual agregams nuestro siguiente manifiesto
			// * procesado separados por ~
			// */
			// manifiestosFinales = manifiestosFinales + "~" + manifiestoCreado;
			//
			// }
			//
			// }
			//
			// /* En caso de que no sea una guia madre */
			// } else {
			//
			// /* Se obtiene el id de la guia */
			// idGuia = contadores.get(i).getIdenvio();
			//
			// /*
			// * Verificamos que el id no se encuentre en la lista de guia
			// * a excluir
			// */
			// for (int m = 0; m < guiasExcluidas.length; m++) {
			//
			// if (idGuia.equals(guiasExcluidas[m])) {
			//
			// exAux = 1;
			//
			// break;
			//
			// } else {
			//
			// exAux = 0;
			//
			// }
			//
			// }
			//
			// /* En caso de que no sea una guia excluida */
			// if (exAux != 1) {
			//
			// /*
			// * Mandamos a llamar al metodo que realizara todo el
			// * proceso y enviamos los dos que obtenemos del request
			// * en caso de ser un manifiesto nuevo str_manifiesto
			// * estara vacio en caso de seguir con la misma guia
			// * madre, str_manifiesto tendra el mismo manifiesto para
			// * todas las guias hijas
			// */
			//
			// /*
			// * si str_manifiesto esta vacio el metodo creara
			// * autoimaticamente un manifiesto nuevo el cual
			// * almacenaremos en manifiestoCreado
			// */
			// manifiestoCreado = crearManifiestos(usuario, str_manifiesto,
			//
			// viaje, tramo, ruta, deptodes, corrida, null, depto,
			// tipotranslado, plaza,
			//
			// manifiesto_viaje, manifiesto_tramo, manifiesto_supervisor,
			// manifiesto_operador1,
			// manifiesto_operador2, manifiesto_economico, manifiesto_cincho,
			//
			// enrutamiento,
			//
			// tiporegistro, local_foraneo,
			//
			// idGuia);
			//
			// /*
			// * Esto se hace con el fin de asignar todas las guias
			// * hijas de una guia madre al mismo manifiesto
			// */
			// str_manifiesto = manifiestoCreado;
			//
			// }
			//
			// /*
			// * Aqui Solamente creamos un manifiesto y lo agregamos a la
			// * variable de manifiestos finales, esto quiere decir que
			// * asi seN 1, 5 0 100 Guias individuales, todas seran
			// * procesadas y enlazadas al un mismo manifiesto
			// */
			//
			// /*
			// * En caso de que la guia haya sido procesada y
			// * auxManifiesto sea 0
			// */
			// if (exAux != 1 && auxManifiesto == 0) {
			//
			// /*
			// * Un vez terminando de procesar la guia asignamos el
			// * distintivo individual y su manifiestopara poder
			// * diferenciarlo de un manifiesto madre
			// */
			// manifiestoCreado = "Individual," + manifiestoCreado;
			//
			// /*
			// * en caso de quenop haya guias procesadas anteriormente
			// * en nuestra variable ponemos nuestro distintivo
			// * ymanifiesto en la variable pero sin ~ ya que
			// * puedepasar que solo se agregeundato
			// */
			// if (manifiestosFinales.equals("")) {
			//
			// manifiestosFinales = manifiestoCreado;
			//
			// /*
			// * Si ya secreo un manifiesto y se agrego a la
			// * variable ponemos auxManifiesto igual a uno para
			// * con esto saber que ya existe el manifiesto y no
			// * repetirlo
			// */
			// auxManifiesto = 1;
			//
			// } else {
			//
			// /*
			// * En caso de que la variable donde se guardan los
			// * manifiestos finales ya cuente con algo, esto nos
			// * quier decir que ya seproceso un manifiesto por lo
			// * cual agregams nuestro siguiente manifiesto
			// * procesado separados por ~
			// */
			// manifiestosFinales = manifiestosFinales + "~" + manifiestoCreado;
			//
			// /*
			// * Si ya secreo un manifiesto y se agrego a la
			// * variable ponemos auxManifiesto igual a uno para
			// * con esto saber que ya existe el manifiesto y no
			// * repetirlo
			// */
			// auxManifiesto = 1;
			//
			// }
			//
			// }
			//
			// }
			//
			// // manifiestosFinales = manifiestosFinales + manifiestoCreado +
			// // "~" ;
			// //
			// // if(str_manifiesto == null){
			// //
			// // if(!manifiestosFinales.contains(manifiestoCreado)){
			// //
			// // manifiestosFinales = manifiestosFinales + manifiestoCreado +
			// // "~" ;
			// // }
			// //
			// //
			// // }else if((i == (contadores.size() - 1)) && str_manifiesto !=
			// // null){
			// //
			// // manifiestosFinales = manifiestosFinales + "Individual," +
			// // manifiestoCreado;
			// //
			// // }
			//
			// }AQUI

			// String viaje = request.getParameter("viaje");
			// String tramo = request.getParameter("tramo");
			// String ruta = request.getParameter("ruta");
			// String deptodes = request.getParameter("deptodes");
			// String corrida = request.getParameter("corrida");
			// String guia = request.getParameter("guias");
			// String depto = request.getParameter("depto");
			//
			// String manifiesto_viaje =
			// request.getParameter("manifiesto_viaje");
			// String manifiesto_tramo =
			// request.getParameter("manifiesto_tramo");
			// String manifiesto_supervisor =
			// request.getParameter("manifiesto_supervisor");
			// String manifiesto_operador1 =
			// request.getParameter("manifiesto_operador1");
			// String manifiesto_operador2 =
			// request.getParameter("manifiesto_operador2");
			// String manifiesto_economico =
			// request.getParameter("manifiesto_economico");
			// String manifiesto_cincho =
			// request.getParameter("manifiesto_cincho");
			//
			// String enrutamiento = request.getParameter("manifiesto_cincho");
			//
			// String tipoDoc = getTipoDocto(tiporegistro,local_foraneo);
			// String prefijo = getTipoSufijo(tiporegistro);
			// if (tipoDoc == null) {
			// throw new Exception("TIPO DE DOCUMENTO INVALIDO");
			// }
			//
			//
			// ManifiestoDTO manifiesto_buscar = new ManifiestoDTO();
			// manifiesto_buscar.setViaje(request.getParameter("viaje"));
			// manifiesto_buscar.setTramo(request.getParameter("tramo"));
			// manifiesto_buscar.setRuta(request.getParameter("ruta"));
			// manifiesto_buscar.setIdoficina(request.getParameter("deptodes"));
			// manifiesto_buscar.setCorrida(request.getParameter("corrida"));
			//
			//
			// manifiesto_buscar.setTipotranslado(tipotranslado);
			// manifiesto_buscar.setIdDocumento(UtilsStrings.formateaCadenaComillas(request.getParameter("guias")));
			// manifiesto_buscar.setLogin(usuario.getLogin());
			// manifiesto_buscar.setTipoDocumento(tipoDoc);
			// manifiesto_buscar.setLogin(usuario.getLogin());
			//
			// str_manifiesto =
			// manifiestosBO.generaManifiestoMovimiento(manifiesto_buscar,
			// usuario, prefijo);
			//
			// manifiesto_buscar.setManifiesto(str_manifiesto);
			//
			// ManifiestoDTO manifiesto = new ManifiestoDTO();
			// manifiesto.setViaje(request.getParameter("manifiesto_viaje"));
			// manifiesto.setTramo(request.getParameter("manifiesto_tramo"));
			// manifiesto.setSupervisor(request
			// .getParameter("manifiesto_supervisor"));
			// manifiesto.setOperador1(request
			// .getParameter("manifiesto_operador1"));
			// manifiesto.setOperador2(request
			// .getParameter("manifiesto_operador2"));
			// manifiesto.setEconomico(request
			// .getParameter("manifiesto_economico"));
			// manifiesto.setCincho(request.getParameter("manifiesto_cincho"));
			//
			// manifiesto.setEnrutamientoTransportista(request
			// .getParameter("enrutamiento"));
			// manifiesto.setRuta(request.getParameter("ruta"));
			// manifiesto.setCorrida(request.getParameter("corrida"));
			//
			// manifiesto.setTipoDocumento(tipoDoc);
			// manifiesto.setManifiesto(str_manifiesto);
			// iLogMovimientosProcesadosBO.insertManifiestoMovimiento(manifiesto);
			//
			// LogMovimientoProcesadoDTO movimiento = new
			// LogMovimientoProcesadoDTO();
			// movimiento.setTipomovimiento(tiporegistro);
			// movimiento.setManifiesto(str_manifiesto);
			// movimiento.setViaje(request.getParameter("viaje"));
			// movimiento.setTramo(request.getParameter("tramo"));
			// movimiento.setViaje(request.getParameter("viaje"));
			// movimiento.setTramo(request.getParameter("tramo"));
			//
			// movimiento.setPlazaenvia(plaza);
			// movimiento.setRuta(request.getParameter("ruta"));
			// movimiento.setDepto(request.getParameter("depto"));
			//
			//
			// movimiento.setLogin(usuario.getLogin());
			// iLogMovimientosProcesadosBO.update(movimiento,
			// request.getParameter("guias"));
			//
			// List<LogHistoriaDTO> guias_manif=
			// iLogMovimientosProcesadosBO.getGuiasManifiesto(str_manifiesto);
			// if (guias_manif.size()>0){
			// if (str_manifiesto != null) {
			// manifiesto.setManifiesto(str_manifiesto);
			// manifiesto.setTipoDocumento(tipoDoc);
			// muestrarManifiestoPDF(manifiesto, response, false, usuario);
			//
			// } else {
			// throw new Exception("Error al actualizar manifiestos");
			// }
			// }else{
			// iLogMovimientosProcesadosBO.deleteManifiesto(movimiento);
			// throw new Exception("NO EXISTEN REGISTROS PARA GENERAR EL
			// MANIFIESTO.");
			//
			// }
			// Crea el manifiesto invocando a jaspert
			modelMap.put("success", true);
			modelMap.put("message", manifiestosFinales);

		} catch (Exception dae) {
			muestrarError(dae.getMessage(), response);

		}

		return modelMap;

	}

	@RequestMapping("/generaManifiestoSalidasFXC")
	public @ResponseBody Map<String, ? extends Object> generaManifiestoSalidasFXC(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		// Verifica si el usuario tiene una sesion valida
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		String str_manifiesto = null;
		try {
			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			String manifiesto = request.getParameter("manifiesto") == null ? "" : request.getParameter("manifiesto");
			if ((manifiesto.trim().length() <= 0) || (!manifiesto.startsWith("SA"))) {
				throw new Exception("MANIFIESTO " + manifiesto + " NO CORRESPONDE A UN MANIFIESTO DE SALIDA.");
			}

			List<LogHistoriaDTO> contadores = iLogMovimientosProcesadosBO.getGuiasManifiesto(manifiesto);
			if (contadores.size() <= 0) {
				throw new Exception("NO EXISTE INFORMACION CORRESPONDIENTE AL MANIFIESTO DE SALIDA " + manifiesto);
			}

			// String tipoDoc = "MANIF_SALIDASFXC";

			String tipoDoc = getTipoDocto("FXC", "");
			// String prefijo = getTipoSufijo("FXC");

			String manifiesto_fxc = manifiesto.replaceFirst("SA", "FC");
			String manifiesto_salida = request.getParameter("manifiesto");

			// Para cada guia encontrada copia la correspondiente a
			// la tabla de movimientomanifiestomonto ya con el nuevo manifiesto
			ManifiestoDTO manif_salidas = new ManifiestoDTO();
			manif_salidas.setManifiesto(manifiesto_salida);

			ManifiestoDTO manif_fxc = new ManifiestoDTO();
			manif_fxc.setManifiesto(manifiesto_fxc);

			ManifiestoDTO manif_datos = new ManifiestoDTO();
			manif_datos.setViaje(request.getParameter("manifiesto_viaje"));
			manif_datos.setTramo(request.getParameter("manifiesto_tramo"));
			manif_datos.setSupervisor(request.getParameter("manifiesto_supervisor"));
			manif_datos.setOperador1(request.getParameter("manifiesto_operador1"));
			manif_datos.setOperador2(request.getParameter("manifiesto_operador2"));
			manif_datos.setEconomico(request.getParameter("manifiesto_economico"));
			manif_datos.setCincho(request.getParameter("manifiesto_cincho"));

			manif_datos.setEnrutamientoTransportista(request.getParameter("enrutamiento"));
			manif_datos.setRuta(request.getParameter("ruta"));

			manif_datos.setTipoDocumento(tipoDoc);
			manif_datos.setManifiesto(manif_fxc.getManifiesto());
			iLogMovimientosProcesadosBO.insertManifiestoMovimiento(manif_datos);
			iLogMovimientosProcesadosBO.insertManifiestoMovimientoFXC(manif_salidas, manif_fxc);

			List<LogHistoriaDTO> guias_manif = iLogMovimientosProcesadosBO
					.getGuiasManifiestoFXC(manif_fxc.getManifiesto());
			manif_datos = new ManifiestoDTO();
			if (guias_manif.size() > 0) {
				manif_datos.setManifiesto(manif_fxc.getManifiesto());
				manif_datos.setTipoDocumento(tipoDoc);
				muestrarManifiestoPDF(manif_datos, response, false, usuario);
			} else {
				LogMovimientoProcesadoDTO obj = new LogMovimientoProcesadoDTO();
				obj.setManifiesto(manif_fxc.getManifiesto());
				iLogMovimientosProcesadosBO.deleteManifiestoFX(obj);
				throw new Exception("NO EXISTEN REGISTROS PARA GENERAR EL MANIFIESTO.");

			}
			// Crea el manifiesto invocando a jaspert

			modelMap.put("success", true);
			modelMap.put("message", "Correcto");

		} catch (Exception dae) {
			muestrarError(dae.getMessage(), response);

		}

		return modelMap;

	}

	private void muestrarManifiestoPDF(ManifiestoDTO manifiesto, HttpServletResponse response, boolean isReimpresion,
			UsuarioDTO usuario) throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		// Obtiene todos los parametros
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("P_MANIFIESTO", manifiesto.getManifiesto());
		logger.info("Manifiesto etiquetas P_MANIFIESTO:" + manifiesto.getManifiesto());

		// Cuandose trata de una re
		if (isReimpresion) {
			parameters.put("REIMPRESION", com.innovargia.utils.Fechas.Fecha());
		} else {
			parameters.put("REIMPRESION", "");
		}

		byte[] bytes = manifiestosBO.generarManifiestoPDF(manifiesto, parameters, usuario);

		// Incializamos el array
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ServletOutputStream out = response.getOutputStream();

		bos.write(bytes);

		response.setContentType("application/pdf");
		response.setContentLength(bos.size());
		out.write(bos.toByteArray());
		out.flush();
		bos.close();
		out.close();
		response.flushBuffer();

	}

	private void muestrarError(String error, HttpServletResponse response) throws IOException {

		if ((error == null) || (error.trim().length() <= 0)) {
			error = "No se puede mostrar el reporte solicitado, verifique con el administrador.";
		}
		byte[] bytes = error.getBytes();

		// Incializamos el array
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ServletOutputStream out = response.getOutputStream();

		bos.write(bytes);

		response.setContentType(MimeTypes.getMimeType("*.html"));
		response.setContentLength(bos.size());
		out.write(bos.toByteArray());
		out.flush();
		bos.close();
		out.close();
		response.flushBuffer();

	}

	@RequestMapping("/consultaRegistrosManifiesto")
	public @ResponseBody Map<String, ? extends Object> consultaRegistrosParaManifiestoEntrega(
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		try {

			UtilsRequest.displayParametros(request);
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			String manifiesto = request.getParameter("manifiesto");

			List<LogHistoriaDTO> contadores = iLogMovimientosProcesadosBO.getGuiasManifiesto(manifiesto);

			modelMap.put("proxiArray", contadores);
			modelMap.put("totalCount", contadores.size());
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");

		} catch (Exception dae) {
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
	}

	@RequestMapping("/reimprimeManifiesto")
	public @ResponseBody Map<String, ? extends Object> reimprimeManifiesto(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		// Verifica si el usuario tiene una sesion valida
		UtilsRequest.displayParametros(request);
		UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));

		try {

			if (usuario == null) {
				throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH);
			}
			String tiporegistro = request.getParameter("tipomanifiesto");
			String manifiesto_str = request.getParameter("manifiesto");
			// String tipoDoc=null;
			ManifiestoDTO manifiesto = new ManifiestoDTO();

			String local_foraneo = request.getParameter("tipotranslado");
			String tipoDoc = getTipoDocto(tiporegistro, local_foraneo);

			String sufijo = getTipoSufijo(tiporegistro) == null ? null : getTipoSufijo(tiporegistro);

			if (sufijo == null) {
				throw new Exception("TIPO DE MANIFIESTO INVALIDO SUFIJO INVALIDO [" + manifiesto_str + "]");
			}

			if (!manifiesto_str.startsWith(sufijo)) {
				throw new Exception("TIPO DE MANIFIESTO INVALIDO -SUFIJO- [" + tiporegistro + "]");
			}

			manifiesto.setManifiesto(manifiesto_str); // request.getParameter("manifiesto"));
			// if (request.getParameter("tipomanifiesto")==null){
			if (tipoDoc == null) {
				throw new Exception("TIPO DE MANIFIESTO INVALIDO [" + tiporegistro + "]");
			}

			manifiesto.setTipoDocumento(tipoDoc);

			muestrarManifiestoPDF(manifiesto, response, true, usuario);
		} catch (Exception dae) {
			muestrarError(dae.getMessage(), response);

		}

		return modelMap;

	}
	
	@RequestMapping("/consultaRutaManifiesto")
	public @ResponseBody Map<String, ? extends Object> consultaRutaManifiesto(
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		HashMap<String, Object> modelMap = new HashMap<String, Object>();

		try {

			UtilsRequest.displayParametros(request);
			UsuarioDTO usuario = ConstantesAdminSale.getSession(request.getSession(true));
			String manifiesto = request.getParameter("manifiesto");

			List<LogHistoriaDTO> contadores = iLogMovimientosProcesadosBO.getGuiasRutaManifiesto(manifiesto);

			modelMap.put("proxiArray", contadores);
			modelMap.put("totalCount", contadores.size());
			modelMap.put("success", true);
			modelMap.put("message", "Correcto");

		} catch (Exception dae) {
			modelMap.put("message", dae.getMessage());

		}
		return modelMap;
	}
	
	private String getTipoDocto(String tiporegistro, String tipotranslado) {
		tipotranslado = tipotranslado == null ? "" : tipotranslado.trim().toUpperCase();
		String tipoDoc = null;
		if ("01".equals(tiporegistro)) {
			tipoDoc = "MANIF_ENTRADAS" + tipotranslado;
		} else if ("02".equals(tiporegistro)) {
			tipoDoc = "MANIF_SALIDAS" + tipotranslado;
		} else if ("03".equals(tiporegistro)) {
			tipoDoc = "MANIF_MOV_LOCALES";
		} else if ("21".equals(tiporegistro)) {
			tipoDoc = "MANIF_RECOLREALIZADA";
		} else if ("FXC".equals(tiporegistro)) {
			tipoDoc = "MANIF_SALIDASFXC";
		}

		return tipoDoc;
	}

	private String getTipoSufijo(String tiporegistro) {
		String prefijo = null;
		if ("01".equals(tiporegistro)) {
			prefijo = "EN";
		} else if ("02".equals(tiporegistro)) {
			prefijo = "SA";
		} else if ("03".equals(tiporegistro)) {
			prefijo = "ML";
		} else if ("21".equals(tiporegistro)) {
			prefijo = "REC";
		} else if ("FXC".equals(tiporegistro)) {
			prefijo = "FXC";
		}
		return prefijo;
	}

	/*
	 * @RequestMapping("/applyAsignaAManifiesto") public @ResponseBody
	 * Map<String, ? extends Object> applyAsignaAManifiesto( HttpServletRequest
	 * request, HttpServletResponse response) throws Exception {
	 * 
	 * HashMap<String, Object> modelMap = new HashMap<String, Object>();
	 * 
	 * // Verifica si el usuario tiene una sesion valida
	 * UtilsRequest.displayParametros(request); UsuarioDTO usuario =
	 * ConstantesAdminSale.getSession(request .getSession(true));
	 * 
	 * String str_manifiesto = null; try {
	 * 
	 * if (usuario == null) { throw new
	 * Exception(ConstantesAdminSale.MSG_SESSION_FINISH); }
	 * 
	 * ManifiestoDTO manifiesto = new ManifiestoDTO();
	 * manifiesto.setRuta(request.getParameter("ruta"));
	 * manifiesto.setLogin(request.getParameter("login"));
	 * manifiesto.setFechaini(request.getParameter("fechaini"));
	 * manifiesto.setFechafin(request.getParameter("fechafin"));
	 * manifiesto.setEnrutamientoTransportista(request.getParameter(
	 * "enrutamiento")); manifiesto.setTipoDocumento("MANIFIESTO");
	 * 
	 * str_manifiesto =
	 * manifiestosBO.updateManifiestoRegistros(manifiesto,usuario,
	 * request.getParameter("tipodocumento"));
	 * 
	 * String unidad_reparto =""; String pos_manif=""; //Actualiza los datos de
	 * cada guia solo en el caso de que se hayan dado de alta los datos de if
	 * (request.getParameter("guias")!=null){ String[] arr_guias =
	 * request.getParameter("guias").trim().split("\\|",-1); String[]
	 * arr_documentos_marca= null; //Recorre cada unos de los registros for (int
	 * i=0;i<arr_guias.length;i++){
	 * 
	 * arr_documentos_marca=arr_guias[i].trim().split(",",-1); //Actualiza los
	 * datos de la guia if (arr_documentos_marca.length>=3){ manifiesto = new
	 * ManifiestoDTO(); manifiesto.setManifiesto(str_manifiesto); //Checa
	 * documento if (arr_documentos_marca[0]!=null){
	 * manifiesto.setIdDocumento(arr_documentos_marca[0]); //Verifica unidad
	 * reparto if ((arr_documentos_marca[1]!=null) &&
	 * (arr_documentos_marca[1].trim().length()>0)){ try{
	 * manifiesto.setPos_manif(Integer.parseInt(arr_documentos_marca[1])); //Si
	 * la posicion es cero indica la posicion 32000 paa que se vaya al //final
	 * del manifiesto //La posicion 32000 indica que no se ha personalizado por
	 * lo que va al ultimo del manifiesto //posicion_num =
	 * posicion_num==0?32000:posicion_num; //Solo para registros que hayan
	 * sufrido cambios if (manifiesto.getPos_manif()==0){
	 * manifiesto.setPos_manif(POSICION_FINAL_MANIF); } }catch(Exception e){
	 * manifiesto.setPos_manif(POSICION_FINAL_MANIF); }
	 * 
	 * }else{ manifiesto.setPos_manif(POSICION_FINAL_MANIF); }
	 * 
	 * if ((arr_documentos_marca[2]!=null) &&
	 * (arr_documentos_marca[2].trim().length()>0)){
	 * manifiesto.setUnidadreparto(arr_documentos_marca[2]); } //Actualiza datos
	 * complementarios
	 * manifiestosBO.updatePosicionUnidadRepartoRegistros(manifiesto, usuario);
	 * 
	 * 
	 * } }
	 * 
	 * }
	 * 
	 * } //Crea el manifiesto invocando a jaspert if (str_manifiesto!=null){
	 * manifiesto.setManifiesto(str_manifiesto);
	 * manifiesto.setTipoDocumento("MANIFIESTO"); muestrarManifiestoPDF(
	 * manifiesto, response,false,usuario);
	 * 
	 * }else{ throw new Exception("Error al actualizar manifiestos"); }
	 * 
	 * 
	 * 
	 * modelMap.put("success", true); modelMap.put("message", "Correcto");
	 * 
	 * 
	 * } catch (Exception dae) { muestrarError(dae.getMessage(),response);
	 * 
	 * }
	 * 
	 * return modelMap;
	 * 
	 * }
	 */

	/**
	 * Asigna todos los envios seleccionados de etiquetas para ser manifestados
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */

	/*
	 * @RequestMapping("/applyAsignaAManifiestoEtiquetas") public @ResponseBody
	 * Map<String, ? extends Object> applyAsignaAManifiestoEtiquetas(
	 * HttpServletRequest request, HttpServletResponse response) throws
	 * Exception {
	 * 
	 * HashMap<String, Object> modelMap = new HashMap<String, Object>();
	 * 
	 * // Verifica si el usuario tiene una sesion valida
	 * UtilsRequest.displayParametros(request); UsuarioDTO usuario =
	 * ConstantesAdminSale.getSession(request .getSession(true));
	 * 
	 * 
	 * ManifiestoDTO manifiesto = new ManifiestoDTO();
	 * manifiesto.setRuta(request.getParameter("ruta"));
	 * manifiesto.setLogin(request.getParameter("login"));
	 * manifiesto.setFechaini(request.getParameter("fechaini"));
	 * manifiesto.setFechafin(request.getParameter("fechafin"));
	 * manifiesto.setEnrutamientoTransportista(request.getParameter(
	 * "enrutamiento")); manifiesto.setTipoDocumento("MANIFIESTO");
	 * 
	 * String str_manifiesto = null; try{
	 * 
	 * 
	 * //String unidad_reparto =""; //String pos_manif=""; //Actualiza los datos
	 * de cada guia solo en el caso de que se hayan dado de alta los datos de if
	 * (request.getParameter("guias")!=null){ String[] arr_guias =
	 * request.getParameter("guias").trim().split("\\|",-1); str_manifiesto =
	 * manifiestosBO.updateManifiestoRegistrosEtiquetas(manifiesto,usuario,
	 * request.getParameter("tipodocumento"),arr_guias); }
	 * 
	 * //Crea el manifiesto invocando a jaspert if (str_manifiesto!=null){
	 * manifiesto.setManifiesto(str_manifiesto);
	 * manifiesto.setTipoDocumento("MANIFIESTO"); muestrarManifiestoPDF(
	 * manifiesto, response,false,usuario);
	 * 
	 * }else{ throw new Exception("Error al actualizar manifiestos");
	 * 
	 * }
	 * 
	 * 
	 * modelMap.put("success", true); modelMap.put("message", "Correcto");
	 * 
	 * 
	 * } catch (Exception dae) { muestrarError(dae.getMessage(),response);
	 * 
	 * }
	 * 
	 * return modelMap; }
	 * 
	 * 
	 * 
	 * 
	 * @RequestMapping("/applyAsignaAManifiestoEntregaTransportista")
	 * public @ResponseBody Map<String, ? extends Object>
	 * applyAsignaAManifiestoEntregaTransportista( HttpServletRequest request,
	 * HttpServletResponse response) throws Exception {
	 * 
	 * HashMap<String, Object> modelMap = new HashMap<String, Object>();
	 * 
	 * // Verifica si el usuario tiene una sesion valida
	 * UtilsRequest.displayParametros(request); UsuarioDTO usuario =
	 * ConstantesAdminSale.getSession(request .getSession(true));
	 * 
	 * String documentos =
	 * request.getParameter("guias")==null?"":request.getParameter("guias");
	 * String[] arr_documentos = documentos.split("\\|");
	 * 
	 * ManifiestoDTO manifiesto = null; String tipodocumento_registros =
	 * request.getParameter("tipodocumento"); //Tipo documento enviado de
	 * acuerdo a la tabla de caTipoDcoumento ArrayList<ManifiestoDTO>
	 * arr_manifiesto = new ArrayList<ManifiestoDTO>(); for (int i = 0; i <
	 * arr_documentos.length; i++) { manifiesto = new ManifiestoDTO();
	 * manifiesto.setIdDocumento(arr_documentos[i]);
	 * manifiesto.setTipoDocumento(tipodocumento_registros);
	 * arr_manifiesto.add(manifiesto); }
	 * 
	 * try{ ManifiestoDTO datos_manifiesto_consecutivo = new ManifiestoDTO();
	 * datos_manifiesto_consecutivo.setTipoDocumento("MANIFENTR");
	 * 
	 * String str_manifiesto = manifiestosBO.updateManifiestoRegistrosEtiquetas(
	 * datos_manifiesto_consecutivo,usuario, tipodocumento_registros
	 * ,arr_documentos ); if (str_manifiesto!=null){
	 * datos_manifiesto_consecutivo.setManifiesto(str_manifiesto);
	 * muestrarManifiestoPDF( datos_manifiesto_consecutivo,
	 * response,false,usuario);
	 * 
	 * }else{ throw new Exception("Error al actualizar manifiestos");
	 * 
	 * }
	 * 
	 * 
	 * modelMap.put("success", true); modelMap.put("message", "Correcto");
	 * 
	 * 
	 * } catch (Exception dae) { muestrarError(dae.getMessage(),response); }
	 * 
	 * return modelMap; }
	 * 
	 */

	/**
	 * Obtiene el detalle de la carga asiganda o pendiente de un usuario o
	 * usuarios para impresion de manifiesto de etiquetas
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */

	/*
	 * @RequestMapping("/consultaRegistrosEtiquetasCarga") public @ResponseBody
	 * Map<String, ? extends Object> consultaRegistrosEtiquetasCarga(
	 * HttpServletRequest request, HttpServletResponse response) throws
	 * Exception {
	 * 
	 * HashMap<String, Object> modelMap = new HashMap<String, Object>();
	 * 
	 * // Verifica si el usuario tiene una sesion valida
	 * UtilsRequest.displayParametros(request); UsuarioDTO usuario =
	 * ConstantesAdminSale.getSession(request .getSession(true));
	 * 
	 * 
	 * 
	 * 
	 * try { ManifiestoDTO manifiesto = new ManifiestoDTO();
	 * 
	 * String login = ((request.getParameter("login")==null) ||
	 * ("".equals(request.getParameter("login"))))?null:request.getParameter(
	 * "login").trim().toUpperCase();
	 * 
	 * //Si el nivel del usuario es Usuario entonces solo obtene //la
	 * informacion del usuario de sesion String nivel =
	 * usuario.perfil_Dto.getNivel(); if ("U".equals(nivel)){ login =
	 * usuario.getLogin(); } List<DocumentoConsultaDTO> lista = new
	 * ArrayList<DocumentoConsultaDTO>(); manifiesto.setLogin(login);
	 * manifiesto.setTipoDocumento("ETIQU");
	 * manifiesto.setFechaini(request.getParameter("fechaini"));
	 * manifiesto.setFechafin(request.getParameter("fechafin"));
	 * manifiesto.setSoloSinManifestar(request.getParameter("sinManifiestar"));
	 * if (manifiesto.getFechaini()!=null){
	 * manifiesto.setFechaini(manifiesto.getFechaini()+ " 00:00:00");
	 * manifiesto.setFechafin(manifiesto.getFechafin()+" 23:59:59"); lista =
	 * manifiestosBO.getDetalleManifiestoEtiquetas(manifiesto, usuario); }
	 * 
	 * modelMap.put("success", true); modelMap.put("message", "Correcto");
	 * modelMap.put("totalCount", lista.size()); modelMap.put("proxiArray",
	 * lista);
	 * 
	 * 
	 * } catch (Exception dae) { modelMap.put("success", false);
	 * modelMap.put("message", dae.getMessage());
	 * 
	 * }
	 * 
	 * return modelMap;
	 * 
	 * }
	 */

	/*
	 * @RequestMapping("/consultaRegistrosParaManifiesto") public @ResponseBody
	 * Map<String, ? extends Object> consultaRegistrosParaManifiesto(
	 * HttpServletRequest request, HttpServletResponse response) throws
	 * Exception {
	 * 
	 * HashMap<String, Object> modelMap = new HashMap<String, Object>();
	 * 
	 * // Verifica si el usuario tiene una sesion valida
	 * UtilsRequest.displayParametros(request); UsuarioDTO usuario =
	 * ConstantesAdminSale.getSession(request .getSession(true));
	 * 
	 * List<DocumentoConsultaDTO> lista = new ArrayList<DocumentoConsultaDTO>();
	 * 
	 * // Obtiene los registros para el manifiesto ManifiestoDTO manifiesto =
	 * new ManifiestoDTO(); manifiesto.setRuta(request.getParameter("ruta"));
	 * manifiesto.setTipoDocumento(_TIPODOCUMENTO);
	 * manifiesto.setFechaini(request.getParameter("fechaini"));
	 * manifiesto.setFechafin(request.getParameter("fechafin"));
	 * manifiesto.setPreAsigandoPendiente(request
	 * .getParameter("preAsigandoPendiente"));
	 * manifiesto.setSoloSinManifestar(request.getParameter("sinManifiestar"));
	 * 
	 * try {
	 * 
	 * if (usuario == null) { throw new
	 * Exception(ConstantesAdminSale.MSG_SESSION_FINISH); }
	 * 
	 * if ((manifiesto.getFechaini() == null) || (manifiesto.getRuta() == null))
	 * { throw new Exception(ConstantesAdminSale.MSG_SESSION_FINISH); } else {
	 * lista = manifiestosBO.consultaRegistrosParaManifiesto( manifiesto,
	 * usuario);
	 * 
	 * modelMap.put("success", true); modelMap.put("message", "Correcto");
	 * modelMap.put("totalCount", lista.size()); modelMap.put("proxiArray",
	 * lista); }
	 * 
	 * } catch (Exception dae) { modelMap.put("success", false);
	 * modelMap.put("message", dae.getMessage());
	 * 
	 * }
	 * 
	 * return modelMap; }
	 */
	public String crearManifiestos(UsuarioDTO usuario,

			String str_manifiesto,

			String viaje, String tramo, String ruta, String deptodes, String corrida, String guias, String depto,
			String tipotranslado, String plaza,

			String manifiesto_viaje, String manifiesto_tramo, String manifiesto_supervisor, String manifiesto_operador1,
			String manifiesto_operador2, String manifiesto_economico, String manifiesto_cincho,

			String enrutamiento,

			String tiporegistro, String local_foraneo,

			String idGuia, String esMadre) throws Exception {

//		int aux = 0;

		String tipoDoc = getTipoDocto(tiporegistro, local_foraneo);
		String prefijo = getTipoSufijo(tiporegistro);
		if (tipoDoc == null) {
			throw new Exception("TIPO DE DOCUMENTO INVALIDO");
		}

		ManifiestoDTO manifiesto_buscar = new ManifiestoDTO();
		manifiesto_buscar.setViaje(viaje);
		manifiesto_buscar.setTramo(tramo);
		manifiesto_buscar.setRuta(ruta);
		manifiesto_buscar.setIdoficina(deptodes);
		manifiesto_buscar.setCorrida(corrida);

		manifiesto_buscar.setTipotranslado(tipotranslado);
		manifiesto_buscar.setIdDocumento(UtilsStrings.formateaCadenaComillas(guias));
		manifiesto_buscar.setLogin(usuario.getLogin());
		manifiesto_buscar.setTipoDocumento(tipoDoc);
		manifiesto_buscar.setLogin(usuario.getLogin());

		str_manifiesto = manifiestosBO.generaManifiestoMovimiento(manifiesto_buscar, usuario, prefijo);

		manifiesto_buscar.setManifiesto(str_manifiesto);

		ManifiestoDTO manifiesto = new ManifiestoDTO();
		manifiesto.setViaje(manifiesto_viaje);
		manifiesto.setTramo(manifiesto_tramo);
		manifiesto.setSupervisor(manifiesto_supervisor);
		manifiesto.setOperador1(manifiesto_operador1);
		manifiesto.setOperador2(manifiesto_operador2);
		manifiesto.setEconomico(manifiesto_economico);
		manifiesto.setCincho(manifiesto_cincho);

		manifiesto.setEnrutamientoTransportista(enrutamiento);
		manifiesto.setRuta(ruta);
		manifiesto.setCorrida(corrida);

		manifiesto.setTipoDocumento(tipoDoc);
		manifiesto.setManifiesto(str_manifiesto);


		iLogMovimientosProcesadosBO.insertManifiestoMovimiento(manifiesto);


		LogMovimientoProcesadoDTO movimiento = new LogMovimientoProcesadoDTO();
		movimiento.setTipomovimiento(tiporegistro);
		movimiento.setManifiesto(str_manifiesto);
		movimiento.setViaje(viaje);
		movimiento.setTramo(tramo);
		movimiento.setViaje(viaje);
		movimiento.setTramo(tramo);

		movimiento.setPlazaenvia(plaza);
		movimiento.setRuta(ruta);
		movimiento.setDepto(depto);

		/*
		 * Agregamos elid dela guia a elobjeto movimientos para asi saber cual
		 * guia es la que se va a realizar update
		 */
		movimiento.setGuia(idGuia);

		movimiento.setLogin(usuario.getLogin());

		iLogMovimientosProcesadosBO.update(movimiento, guias);

		List<LogHistoriaDTO> guias_manif = iLogMovimientosProcesadosBO.getGuiasManifiesto(str_manifiesto);
		if (guias_manif.size() > 0) {
			if (str_manifiesto != null) {
				manifiesto.setManifiesto(str_manifiesto);
				manifiesto.setTipoDocumento(tipoDoc);
				// muestrarManifiestoPDF(manifiesto, response, false, usuario);

			} else {
				throw new Exception("Error al actualizar manifiestos");
			}
		} else {
			iLogMovimientosProcesadosBO.deleteManifiesto(movimiento);
			throw new Exception("NO EXISTEN REGISTROS PARA GENERAR EL MANIFIESTO.");

		}

		return str_manifiesto;
	}

}
