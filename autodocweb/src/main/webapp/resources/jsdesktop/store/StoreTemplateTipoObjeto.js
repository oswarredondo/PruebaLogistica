Ext.define('MyDesktop.store.StoreTemplateTipoObjeto', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
				{"idtipo":"cb", "descripcion":"Codigo 128"},
				{"idtipo":"cbabove", "descripcion":"Codigo 128-Arriba"},
				{"idtipo":"pdf", "descripcion":"Codigo PDF"},
				{"idtipo":"label", "descripcion":"Etiqueta"},
				{"idtipo":"text", "descripcion":"Texto"},
				{"idtipo":"rectangle", "descripcion":"Rectangulo"},
				{"idtipo":"image", "descripcion":"image"}
			]
});