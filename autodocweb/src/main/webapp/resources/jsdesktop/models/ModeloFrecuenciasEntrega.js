Ext.define('MyDesktop.models.ModeloFrecuenciasEntrega', {
        extend: 'Ext.data.Model',
		fields: [
//			{name: 'd_codigo'},{name: 'idterminal'},{name: 'idagrupador'},
//			{name: 'cp'},{name: 'idterminal'},{name: 'idagrupador'},
//			{name: 'zonaventa'},{name: 'lunes'},{name: 'martes'},{name: 'miercoles'},
//			{name: 'jueves'},{name: 'viernes'},{name: 'sabado'},{name: 'domingo'},
//			{name: 'periodicidad'},{name: 'observacion'},{name: 'ocurre'},{name: 'reexpedicion_e'},
//			{name: 'reexpedicion_r'},{name: 'ruta'},{name: 'garantiamax'},{name: 'identidad'},{name:'idruta'},
//			{name: 'idorganizacion'},{name: 'mismodia'},{name:'descripciongarantia'} ,
//			{name:'enrutamiento'} ,{name:'descripcionServicio'}
			
			{name: 'guiamadre', type:'string'},{name: '_csrf'},{name: 'uuid', type:'string'},{name: 'idregistro', type:'int'},
			{name: 'tiporotulo', type:'string'},{name: 'idservicio', type:'string'},{name: 'numpiezas', type:'int'},
			{name: 'contenido', type:'string'},{name: 'referencia', type:'string'},{name: 'nacional', type:'string'},
			{name: 'tipoempaque', type:'string'},{name: 'es_multiple', type:'string'},{name: 'tiene_retorno', type:'string'},
			{name: 'tiene_seguro', type:'string'},{name: 'valordeclarado', type:'float'},{name: 'valor_asegurado', type:'float'},
			{name: 'pesofisico', type:'float'},{name: 'largo', type:'int'},{name: 'alto', type:'int'},
			{name: 'ancho', type:'int'},{name: 'observacion', type:'string'},
			/* CAMBIO CITA EVIDENCIA MANIOBRA */
			{name: 'tiene_cita', type:'String'},{name: 'fecha_cita', type:'string'},{name: 'hora_cita', type:'string'}
			/* FIN CAMBIO */
			
			/* CAMBIO CITA EVIDENCIA MANIOBRA 
			{name: 'precioManiobra', type:'float'},{name: 'precioCitas', type:'float'},{name: 'precioEvidencia', type:'float'}
			FIN CAMBIO */

//			{name: 'guiaMadre'},{name: 'idServicio'},{name: 'numpiezas'},
//			{name: 'referencia'},{name: 'tipoEmpaque'},{name: 'pesoFisico'}
// 
		]
});