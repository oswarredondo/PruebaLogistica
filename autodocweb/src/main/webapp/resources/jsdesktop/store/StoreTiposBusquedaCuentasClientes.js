Ext.define('MyDesktop.store.StoreTiposBusquedaCuentasClientes', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
		        {"idtipo":"00", "descripcion":"VER TODOS"},
		    	{"idtipo":"03", "descripcion":"NUM CLIENTE"},
				{"idtipo":"01", "descripcion":"R.F.C"},
				{"idtipo":"02", "descripcion":"RAZON SOCIAL"},
				{"idtipo":"07", "descripcion":"ATENCION"},
				{"idtipo":"04", "descripcion":"COLONIA"},
				{"idtipo":"05", "descripcion":"MUNICIPIO"},
				{"idtipo":"06", "descripcion":"ESTADO"}
				
			]
});