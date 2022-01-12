Ext.define('MyDesktop.store.StoreTemplateRotacion', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
				{"idtipo":"0", "descripcion":"0 grados"},
				{"idtipo":"45", "descripcion":"45 grados"},
				{"idtipo":"90", "descripcion":"90 grados"},
				{"idtipo":"135", "descripcion":"135 grados"},
				{"idtipo":"180", "descripcion":"180 grados"},
				{"idtipo":"270", "descripcion":"270 grados"},
				{"idtipo":"360", "descripcion":"360 grados"}
			]
});