
Ext.define('MyDesktop.store.StoreTipoSolucionAgenda', {
    extend: 'Ext.data.Store',
	fields: ['idtipo'],
	data : [
			{"idtipo":"ENTREGADO"},
			{"idtipo":"SOLICITAR DOCUMENTOS PARA GARANTIA"},
			{"idtipo":"SOLICITAR DOCUMENTOS PARA EXTRAVIO"},
			{"idtipo":"OTRO"}
		]
});

