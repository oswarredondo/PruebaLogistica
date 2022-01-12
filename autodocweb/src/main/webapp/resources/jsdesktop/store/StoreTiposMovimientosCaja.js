Ext.define('MyDesktop.store.StoreTiposMovimientosCaja', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
				{"idtipo":"0", "descripcion":"ENTRADA EFECTIVO"},
				{"idtipo":"1", "descripcion":"SALIDAD EFECTIVO"}
			]
});