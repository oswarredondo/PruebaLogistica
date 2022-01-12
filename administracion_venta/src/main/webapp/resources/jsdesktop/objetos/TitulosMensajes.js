var tipo_documento_etiqueta = 'ETIQU';
var tipo_producto_adicional = 'ADICIONAL';
var tipo_internacional = 'INTERNACIONAL';
var tipo_nacional = 'NACIONAL';

var TIPO_SERVICIO ='SERVICIO';
var TIPO_AMBAS ='AMBAS';

var TIPO_VALIJA ='VALIJA';
var TIPO_PAQUETE ='PAQUETE';
var TIPO_SOBRE ='SOBRE';

var TIPO_SI ='SI';
var TIPO_NO ='NO';

var numero_maximo_etiquetas_imprimir =1000;
var valor_declarado_maximo = 50000;

var cantidad_restriccion_venta_prepagado =25;    //YA ES UN PARAMETRO DEL SISTEMA
var IDTIPO__CONTADO=1;
var IDTIPO__FXC=5;
var IDTIPO__PREPAGADO=3;
var IDTIPO__CONTRATO=2;


//Titulos pantallas y ventanas
var titulo_detalle_venta = 'Detalle Venta';
var titulo_detalle_venta_realizada = 'Datos Venta Realizada';
var titulo_oficinas_usuarios_asigandos = 'Oficinas y usuarios asignados';
var titulo_oficinas_administracion_clientes  = 'Administración de Clientes';
var titulo_cartera_clientes  = 'Cartera de Clientes';
var titulo_datos_usuario_sesion = 'Datos de Usuario de Sesion';
var titulo_consulta_etiquetas  = 'Consulta de Etiquetas';
var titulo_consulta_etiquetas_ups  = 'Consulta Guias UPS';
var titulo_recepcion_codfxc = 'Recepción COD/FXC';
var titulo_usuarios = 'Usuarios';
var titulo_cotizacion_envios = 'Cotizaciones Envios';
var titulo_ireport = 'IReport Web';
var titulo_manifiesto_etiquetas = 'Manifiesto Etiquetas';
var titulo_movimientos_caja ='Movimientos de Caja';
var titulo_ocurres ='Ocurres';
var titulo_oficinas_pdv = 'Oficina PDV';
var titulo_oficinas_receptoras = 'Oficina Receptoras';
var titulo_busqueda_oficinas_receptoras = 'Busqueda Oficina';
var titulo_recepcion_prepagado = 'Recep. Prepagado';
var titulo_cambio_password = 'Cambiar Password';
var titulo_venta_internacional= 'Venta Internacional';
var titulo_venta_internacional_diaria= 'Venta Diaria Internacional';
var titulo_venta_pdv = 'Venta PDV';
var titulo_consulta_cps = 'Consulta Consulta CPs';

var titulo_venta_prepago = 'Venta Prepago';
var titulo_detalle_recepcion_prepago = 'Detalle Recepción';
var titulo_carta_factura = 'Carta Factura';

var titulo_confirmar = 'CONFIRMAR';
var titulo_aviso = 'AVISO';
var titulo_alerta = 'ALERTA';


var titulo_autodoc_sitio = 'Auto Documentación en Sitio';
var titulo_datos_facturacion = 'Datos de facturación';
var titulo_recepcion_envios = 'Recepción Envíos';

var titulo_rotulacion_existente = 'Set de Rotulacion existentes';
var titulo_set_trabajo = "Set de trabajo";

var titulo_importar_datos = 'Importar datos';
var titulo_remitente = 'Remitente';
var titulo_destinatario = 'Destinatario';
var titulo_generales= 'Generales';
var titulo_reimprimir= 'Reimprimir';
var titulo_configuracion_etiqueta= 'Configuración Etiqueta';
var titulo_configuracion_cod=  'Configuración COD';
var titulo_seguro_amparado=  'Seguro Amparado';
var titulo_documentacion_contrato=  'Documentación Contrato';
var titulo_adicional_envio = "Adicional Envio";
var titulo_adicional_servicio = "Adicional Servicio";

var titulo_cotizacion_contado = "Cotización Contado";
var titulo_cotizacion_prepago = "Cotización Prepagado";
var titulo_cotizacion_fxc = "Cotización FXC";


var titulo_utilerias ="Utilerias";
var titulo_template_wizard ="Wizard Template";
var titulo_template_detalle ="Template Detalle";
var titulo_templates ="Template";
var  titulo_detalle_contenido = 'Detalle Contenido';

var  titulo_excluir_ocurre = 'Excluir los ocurres confirmados ó devueltos';
//// Mensajes
var msg_sesion_usuario_invalida = "Usuario no ha iniciado Sesion con algun PDV disponible.";
var msg_seleccione_servicios_adicionales= "Seleccione servicios o adicionales para la operación.";
var msg_seleccione_adicionales= "Seleccione los servicios adicionales que desea agregar.";
var msg_seleccione_registros= "Seleccione los registros a operar.";
var msg_seleccione_registros_solo_uno= "Seleccione un solo registro a operar.";

var msg_totalapagar = "Total de la venta inválida, agregue servicios a vender";
var msg_uuid_invalido = "Identificador de Sesion inválido.";
var msg_forma_pago = 'Forma pago inválida, seleccione una válida';
var msg_banco= 'Seleccione el banco';
var msg_numero_tarjeta= "Indique numero de tarjeta";
var msg_captura_rem_des  = '¿Los datos capturados REM/DES y Carta Factura son correctos, desea generar venta ahora?';

var msg_cliente_a_facturar = "Capture los datos del cliente a facturar";
var msg_rfc_cliente = "Capture el RFC del cliente";
var msg_cantidad = "Cantidad inválida.";
var msg_set = 'Agregue el identificador del Set a Guardar';
var msg_datos_requeridos_remitente = "Capture los datos requeridos de remitente";
var msg_datos_requeridos_destinatario ="Capture los datos requeridos de destinatario";
var msg_datos_requeridos_remmitente_destinatario ="Capture los datos requeridos de remitente y destinatario";
var msg_datos_requeridos_telefono= "El Tel.  debe contener al menos 10 posiciones.";

var msg_confiracion_salvar_datos = 'Se guardo la información de forma correcta.';
var msg_dato_a_consultar ="Capture el dato que desea consultar.";
var msg_dato_a_consultar_razon_social ="Capture la razon social .";
var msg_dato_a_consultar_atencion ="Capture atención .";
var msg_dato_a_consultar_rfc ="Capture R.F.C .";

var msg_datos_requeridos ="Capture los datos requeridos";
var msg_consulta_invalida ='Tipo de consulta inválida.';

var msg_patron_consulta_invalida  = "Debe indicar el patrón a buscar";

var msg_datos_requeridos_generales ="Capture los datos requeridos generales";
var msg_datos_oficina_ocurre ="Se ha seleccionado servicio ocurre debe seleccionar una oficina receptora.";
var msg_datos_tarifa_valida ="Seleccione el servicio que se desea adquirir";
var msg_registro_a_imprimir = "Seleccione el registro que desea imprimir";
var msg_registro_solo_un_reg_imprimir = "Seleccione solo un registro para imprimir";
var msg_datos_acceso_autodoc=  'Documentación Contrato';

var msg_confirmar_recepcion = '¿Desea terminar la recepción de enviós?';
var msg_confirmar_limpiar_datos = '¿Desea limpiar datos para nueva operación?';
var msg_confirmar_eliminar_datos = '¿Desea eliminar los datos seleccionados?';
var msg_guardar_datos = '¿Desea guardar los datos, ahora?';
var msg_generar_venta= '¿Desea Generar la venta ahora?';
var msg_guardar_cartera_direcciones= '¿Desea guardar registro en la cartera de direcciones?';
var msg_rotulacion_importar  = 'Solo los registros sin error serán procesados para rotulación,¿Desea continuar?';

var msg_internacional_restriccion =  "Ya existe un servicio capturado, debe realizar la venta y después generar nuevos servicios.";
var msg_prepagado_restriccion =  'Para el tipo prepago debe adquirir al menos '+cantidad_restriccion_venta_prepagado +' etiquetas.';
var msg_valor_seguro_restriccion ="Valor declarado excede el límite de $50,000.00, verifique";

var msg_generando_infomacion_espere ="Actulizando información espere...";
var msg_valor_declarado = "Valor declarado inválido, verifique";
var msg_valor_cod = "Valor a Cobrar de COD inválido";
var msg_valor_peso = "Peso debe ser mayor de Cero";

var msg_valor_dimensiones = "Indique las dimensiones del Paquete.";

var msg_no_existen_registros_disponibles = 'No existen servicios disponibles para el criterio de consulta.';

var msg_autorizacion = "Convenio ya fue autorizado, no puede modificar datos";

var msg_cerrando_sesion = "Cerrando sesion de usuario espere";
var msg_confirmar_cerrar_sesion = '¿Desea salir de la aplicación ahora?';


var msg_sesion_activa = 'SESION USUARIO <font color="#04B404"><b>ACTIVA</b></font>';
var msg_sesion_inactiva = 'SESION USUARIO <font color="#8A0808"><b>INACTIVA</b></font>'

//Titulo Botones
var titulo_btn_guardar_datos = 'Guardar Datos';
var titulo_btn_guardar = 'Guardar';
var titulo_btn_guardar_remitente = 'Guardar Remitente';
var titulo_btn_guardar_destinatario = 'Guardar Destinatario';
var titulo_btn_venta_contado = 'Venta Contado';
var titulo_btn_venta_prepago = 'Venta Prepago';
var titulo_btn_venta_fxc = 'Venta FXC';
var titulo_btn_cambiar_password = 'Cambiar Password';
var titulo_btn_ver= 'Ver';
var titulo_btn_vista_previa= 'Visor/Vista Previa';
var titulo_btn_seleccionar = 'Seleccionar';
var titulo_btn_realizar_cobro_recepcion = 'Terminar recepción y realizar cobro';
var titulo_btn_venta = 'Realizar Venta';
var titulo_btn_nueva_venta = 'Nueva Venta';
var titulo_btn_recep_contrato= 'Recepcion Contrato';
var titulo_btn_recep_prepagado='Recepcion Prepagado';
var titulo_btn_recepciones_realizadas = 'Recepciones Realizadas';
var titulo_btn_agregar = "Agregar";
var titulo_btn_borrar = "Borrar";
var titulo_btn_modificar = "Modificar";
var titulo_btn_salvar = "Salvar";
var titulo_btn_buscar = "Buscar";
var titulo_btn_agregar_carta_factura = "Agregar Carta Factura";
var titulo_btn_agregar_linea = "Agregar Línea";
var titulo_btn_adicional_envio = "Adicional Envio";
var titulo_btn_reiniciar = 'Reiniciar';
var titulo_btn_limpir = 'Limpiar';
var titulo_btn_cancelar = 'Cancelar';
var titulo_btn_oficinas = 'Oficinas';
var titulo_btn_reimprimir = 'Reimprimir';
var titulo_btn_imprimir= 'Imprimir';
var titulo_btn_salir= 'Salir';
var titulo_btn_imprimir_manifiesto= 'Imprimir Manifiesto';
var titulo_btn_gnerar_manifiesto= 'Generar Manifiesto';
var titulo_btn_consulta_cps = 'Consulta CPs';

var titulo_btn_cotizar_lineas= 'Cotizar Líneas';
var titulo_btn_cotizar= 'Cotizar';

var titulo_btn_ubicacion_mapa= "Ver Ubicacion Mapa";

//Tooltip
var tooltip_salvar_venta_recepcion = 'Salva la venta actual y genera archivo de etiquetas';
var tooltip_inicia_captura_venta_contrato = 'Inicia la captura de datos para venta por contrato';
var tooltip_recepcion_autodoc = 'Recepcion de Envios que han sido generados por autodocumentación';
var tooltip_recepcion_prepagado = 'Recepcion de Envios Prepagado';
var tooltip_recepciones_realizadas =titulo_btn_recepciones_realizadas;
var tooltip_agregar_servicio =  'Agrega un servicio a la venta';
var tooltip_agregar_adicional =  'Agregar Servicio Adicional a la venta';
var tooltip_reinciar  = 'Limpia los registos para captura';
var tooltip_cancelar  = 'Cancela la operación que se esta realizando';
var tooltip_guardar_datos  = 'Guarda los datos';
var  tooltip_carta_factura = 'Modifica la carta factura del envio' ;
var  tooltip_consulta_cps = 'Consulta de Colonias y Codigos Postales' 
var  tooltip_cotizar_lineas = 'Cotización de lineas, previo a la venta' 
var tooltip_genera_lineas_cotizacion = 'Genera lineas para cotización';
var tooltip_google_maps = 'Muestra la direccion en GMAP';
var tooltip_agregar_cartera_direcciones = 'Agrega a cartera de direcciones.';
var tooltip_oficinas_ocurres = 'Muestra los datos de las oficinas ocurre';
