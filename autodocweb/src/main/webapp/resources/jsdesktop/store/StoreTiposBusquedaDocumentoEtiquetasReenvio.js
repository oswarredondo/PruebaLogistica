Ext.define('MyDesktop.store.StoreTiposBusquedaDocumentoEtiquetasReenvio', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
		        {"idtipo":"1", "descripcion":"ID GUIA"},
				{"idtipo":"2", "descripcion":"RANGO DE FECHAS"},
				{"idtipo":"15", "descripcion":"CONTENIDO"},
		        {"idtipo":"32", "descripcion":"GUÍA MADRE"}
			]
});