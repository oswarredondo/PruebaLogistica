Ext.define('MyDesktop.store.StoreTiposBusquedaDocumentoEtiquetasShort', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
		        {"idtipo":"1", "descripcion":"ID GUIA"},
				{"idtipo":"3", "descripcion":"RAZON SOCIAL DESTINO"},
				{"idtipo":"4", "descripcion":"REFERENCIA"},
				{"idtipo":"15", "descripcion":"CONTENIDO"},
		        {"idtipo":"16", "descripcion":"GUIA INTERNACIONAL"},
		        {"idtipo":"17", "descripcion":"GUIA CASAMIENTO"},
		        {"idtipo":"18", "descripcion":"CONSECUTIVO"},
		        {"idtipo":"32", "descripcion":"GUÍA MADRE"}

			]
});