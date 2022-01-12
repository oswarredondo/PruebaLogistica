Ext.define('MyDesktop.store.StoreDiasSemana', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
		        {"idtipo":1, "descripcion":"LUNES"},
		        {"idtipo":2, "descripcion":"MARTES"},
		        {"idtipo":3, "descripcion":"MIERCOLES"},
		        {"idtipo":4, "descripcion":"JUEVES"},
		        {"idtipo":5, "descripcion":"VIERNES"},
		        {"idtipo":6, "descripcion":"SABADO"},
		        {"idtipo":0, "descripcion":"DOMINGO"}
			]
});

