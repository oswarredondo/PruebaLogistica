Ext.define('MyDesktop.store.StoreTiposBusquedaClientes', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [

		        {"idtipo":"00", "descripcion":"Ver todos"},
		       // {"idtipo":"04", "descripcion":"Por Solo Fiscal"},
				{"idtipo":"01", "descripcion":"Por R.F.C"},
				{"idtipo":"02", "descripcion":"Razon Social"},
				{"idtipo":"03", "descripcion":"Numero Cliente"}
			]
});