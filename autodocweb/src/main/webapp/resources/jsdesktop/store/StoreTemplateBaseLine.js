Ext.define('MyDesktop.store.StoreTemplateBaseLine', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
		        {"idtipo":"-1", "descripcion":"Ninguno"},
				{"idtipo":"1", "descripcion":"Arriba"},
				{"idtipo":"0", "descripcion":"Abajo"},
			]
});