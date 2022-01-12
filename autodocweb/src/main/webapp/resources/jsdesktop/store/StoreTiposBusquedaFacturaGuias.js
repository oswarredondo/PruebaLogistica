/**
 * 
 */
Ext.define('MyDesktop.store.StoreTiposBusquedaFacturaGuias', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
	        	{"idtipo":"1", "descripcion":"FECHA DE CORTE FAC."},
				{"idtipo":"2", "descripcion":"ID GUIA"}
			]
});