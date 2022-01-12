Ext.define('MyDesktop.store.StoreTiposPerfiles', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
		        {"idtipo":"E", "descripcion":"ENTIDAD"},
				{"idtipo":"O", "descripcion":"ORGANIZACION"},
				{"idtipo":"C", "descripcion":"CLIENTE"},
				{"idtipo":"U", "descripcion":"USUARIO"}
			]
});