Ext.define('MyDesktop.store.StoreTiposBusquedaCPs', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
		        {"idtipo":"cp", "descripcion":"CP"},
				{"idtipo":"colonia", "descripcion":"COLONIA"},
				{"idtipo":"municipio", "descripcion":"MUNICIPIO"}
			]
});