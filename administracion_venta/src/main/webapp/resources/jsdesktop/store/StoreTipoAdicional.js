Ext.define('MyDesktop.store.StoreTipoAdicional', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
				{"idtipo":"1", "descripcion":"REQUERIDO"},
				{"idtipo":"2", "descripcion":"SERVICIO"},
				{"idtipo":"3", "descripcion":"ENVIO"}
			]
});