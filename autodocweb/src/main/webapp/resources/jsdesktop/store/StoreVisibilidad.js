Ext.define('MyDesktop.store.StoreVisibilidad', {
        extend: 'Ext.data.Store',
		fields: ['identificador', 'descripcion'],
		data : [
				{"identificador":1, "descripcion":"PUEDE VER TODA LA INFORMACION"},
				{"identificador":0, "descripcion":"SOLO PUEDE VER SU INFORMACION"}
			]
});