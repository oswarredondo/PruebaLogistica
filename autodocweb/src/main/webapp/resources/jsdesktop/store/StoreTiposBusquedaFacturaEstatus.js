/**
 * 
 */
Ext.define('MyDesktop.store.StoreTiposBusquedaFacturaEstatus', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
	        	{"idtipo":"1", "descripcion":"CON MOVIMIENTO"},
		        {"idtipo":"2", "descripcion":"ENTREGADA"},
				{"idtipo":"3", "descripcion":"ENTREGADA CON EVIDENCIA"},
	        	{"idtipo":"4", "descripcion":"ASEGURADA CON MOVIMIENTO"},
		        {"idtipo":"5", "descripcion":"ASEGURADA Y ENTREGADA"},
				{"idtipo":"6", "descripcion":"ASEGURADA Y ENTREGADA CON EVIDENCIA"}
			]
});