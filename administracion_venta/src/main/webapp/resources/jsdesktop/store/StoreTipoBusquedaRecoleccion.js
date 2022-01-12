Ext.define('MyDesktop.store.StoreTipoBusquedaRecoleccion', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
				{"idtipo":"2", "descripcion":"RANGO DE FECHAS"},
				{"idtipo":"7", "descripcion":"ID ORDEN DE RECOLECION"},
				{"idtipo":"1", "descripcion":"NOMBRE SOLICITANTE"},
				{"idtipo":"3", "descripcion":"NUMERO DE CLIENTE"},
				{"idtipo":"4", "descripcion":"CONTRATO"},
				{"idtipo":"5", "descripcion":"RAZON SOCIAL RECOLECCION"},
				{"idtipo":"6", "descripcion":"ATENCION RECOLECCION"},
			]
});
