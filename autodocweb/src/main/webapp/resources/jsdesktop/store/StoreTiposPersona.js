Ext.define('MyDesktop.store.StoreTiposPersona', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
				{"idtipo":"MORAL", "descripcion":"MORAL"},
				{"idtipo":"FISICA", "descripcion":"FISICA"}
			]
});