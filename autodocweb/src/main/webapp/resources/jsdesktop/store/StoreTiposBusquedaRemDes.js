Ext.define('MyDesktop.store.StoreTiposBusquedaRemDes', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
		        {"idtipo":"1", "descripcion":"RAZON SOCIAL"},
				{"idtipo":"2", "descripcion":"ATENCION"},
				{"idtipo":"3", "descripcion":"CALLE"},
				{"idtipo":"4", "descripcion":"COLONIA"},
				{"idtipo":"5", "descripcion":"CP"}
			]
	
});