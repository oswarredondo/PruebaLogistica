Ext.define('MyDesktop.store.StoreTipoEntrega', {
        extend: 'Ext.data.Store',
		fields: ['identificador', 'descripcion'],
		data : [
				{"identificador":"1", "descripcion":"LOCAL"},
				{"identificador":"2", "descripcion":"FORANEA"},
				{"identificador":"3", "descripcion":"AMBAS"}
			]
});