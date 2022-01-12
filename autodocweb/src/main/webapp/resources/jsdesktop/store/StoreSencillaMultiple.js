Ext.define('MyDesktop.store.StoreSencillaMultiple', {
        extend: 'Ext.data.Store',
		fields: ['identificador', 'descripcion'],
		data : [
				{"identificador":"SENCILLA", "descripcion":"TARIMA SENCILLA"},
				{"identificador":"DOBLE", "descripcion":"TARIMA DOBLE"}
			]
});