
Ext.define('MyDesktop.store.StoreTipoEstatusAgenda', {
    extend: 'Ext.data.Store',
	fields: ['idtipo', 'descripcion'],
	data : [
			//{"idtipo":"ABIERTO"},
			//{"idtipo":"EN PROCESO"},
			{"idtipo":"CANCELADO"},
			{"idtipo":"CERRADO"}
		]
});

