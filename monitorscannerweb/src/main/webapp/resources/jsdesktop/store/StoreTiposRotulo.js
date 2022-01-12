Ext.define('MyDesktop.store.StoreTiposRotulo', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
				{"idtipo":"AMBAS", "descripcion":"AMBAS"},
				{"idtipo":"REMITENTE", "descripcion":"REMITENTE"},
				{"idtipo":"DESTINO", "descripcion":"DESTINO"}
			]
});