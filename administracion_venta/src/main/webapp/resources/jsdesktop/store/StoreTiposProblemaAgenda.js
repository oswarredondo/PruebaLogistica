
Ext.define('MyDesktop.store.StoreTiposProblemaAgenda', {
    extend: 'Ext.data.Store',
	fields: ['idtipo'],
	data : [
			{"idtipo":"VERIFICACION DE ENTREGA"},
			{"idtipo":"NO CONOCEN A LA PERSONA"},
			{"idtipo":"LLEGO DAÑADO"},
			{"idtipo":"LLEGO CON CONTENIDO INCOMPLETO"},
			{"idtipo":"CAMBIO DE DOMICILIO"},
			{"idtipo":"ENVIAR A OCURRE"},
			{"idtipo":"SOLICITUD DE CONFIRMACIÓN"},
			{"idtipo":"OTRO"}
		]
});