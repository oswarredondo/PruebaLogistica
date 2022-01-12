Ext.define('MyDesktop.store.StoreTipoDireccionCartera', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
				{"idtipo":"REM", "descripcion":"REMITENTE"},
				{"idtipo":"DES", "descripcion":"DESTINATARIO"},
				{"idtipo":"AMBOS", "descripcion":"AMBOS"}
			]
});