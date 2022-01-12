Ext.define('MyDesktop.store.StoreSINO', {
        extend: 'Ext.data.Store',
		fields: ['identificador', 'descripcion'],
		data : [
				{"identificador":"1", "descripcion":"SI"},
				{"identificador":"0", "descripcion":"NO"}
			]
});