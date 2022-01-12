Ext.define('MyDesktop.store.StoreTipoCliente', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
				{"idtipo":"0", "descripcion":"PROSPECTO"},
				{"idtipo":"1", "descripcion":"CLIENTE"}
			]
});