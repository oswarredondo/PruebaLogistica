Ext.define('MyDesktop.store.StoreTiposDescuento', {
        extend: 'Ext.data.Store',
		fields: ['identificador', 'descripcion'],
		data : [
				{"identificador":"1", "descripcion":"CLIENTE"},
				{"identificador":"2", "descripcion":"TARIFA"},
				{"identificador":"3", "descripcion":"ZONA"},
				{"identificador":"4", "descripcion":"GLOBAL"}
			]
});