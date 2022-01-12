Ext.define('MyDesktop.store.StoreClasificacionCliente', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
		        {"idtipo":"FISCAL", "descripcion":"FISCAL"},
				{"idtipo":"REVISION", "descripcion":"REVISION"},
				{"idtipo":"PAGO", "descripcion":"PAGO"},
				{"idtipo":"OTROS", "descripcion":"OTROS"}
			]
});