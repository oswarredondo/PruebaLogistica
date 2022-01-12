Ext.define('MyDesktop.store.StoreTiposEntregaTerritorio', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
				{"idtipo":"NACIONAL", "descripcion":"NACIONAL"},
				{"idtipo":"INTERNACIONAL", "descripcion":"INTERNACIONAL"}
			]
});