
Ext.define('MyDesktop.store.StoreTiposSolicitaOR', {
    extend: 'Ext.data.Store',
	fields: ['idtipo'],
	data : [
			{"idtipo":"REMITENTE"},
			{"idtipo":"DESTINO"},
			{"idtipo":"OTRO"}
		]
});