Ext.define('MyDesktop.store.StoreSINO', {
        extend: 'Ext.data.Store',
		fields: ['identificador', 'descripcion'],
		data : [
				{"identificador":"SI", "descripcion":"SI"},
				{"identificador":"NO", "descripcion":"NO"}
			]
});