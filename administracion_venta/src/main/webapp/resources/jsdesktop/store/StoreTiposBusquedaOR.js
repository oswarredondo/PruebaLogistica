Ext.define('MyDesktop.store.StoreTiposBusquedaOR', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
				{"idtipo":"10", "descripcion":"FOLIO ORDEN"},
				{"idtipo":"20", "descripcion":"GUIA"},
				{"idtipo":"30", "descripcion":"TELEFONO"},
				{"idtipo":"40", "descripcion":"NOMBRE QUIEN RECLAMA"}

			]
});