Ext.define('MyDesktop.store.StoreTipoIncremento', {
        extend: 'Ext.data.Store',
		fields: ['identificador', 'descripcion'],
		data : [
		        {"identificador":"0", "descripcion":"AMBOS"},
				{"identificador":"1", "descripcion":"SOLO AUMENTAR"},
				{"identificador":"2", "descripcion":"SOLO DISMINUIR"}
			]
});