Ext.define('MyDesktop.store.StoreTiposModalidadCarteraRemDes', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
		        {"idtipo":"REM", "descripcion":"REMITENTES"},
				{"idtipo":"DES", "descripcion":"DESTINATARIOS"},
				{"idtipo":"AMBOS", "descripcion":"AMBOS"}
			]
	
});