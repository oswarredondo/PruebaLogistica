Ext.define('MyDesktop.store.StoreMeses', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
		        {"idtipo":"01", "descripcion":"ENERO"},
				{"idtipo":"02", "descripcion":"FEBRERO"},
				{"idtipo":"03", "descripcion":"MARZO"},
				{"idtipo":"04", "descripcion":"ABRIL"},
				{"idtipo":"05", "descripcion":"MAYO"},
				{"idtipo":"06", "descripcion":"JUNIO"},
				{"idtipo":"07", "descripcion":"JULIO"},
				{"idtipo":"08", "descripcion":"AGOSTO"},
				{"idtipo":"09", "descripcion":"SEPTIEMBRE"},
				{"idtipo":"10", "descripcion":"OCTUBRE"},
				{"idtipo":"11", "descripcion":"NOVIEMBRE"},
				{"idtipo":"12", "descripcion":"DICIEMBRE"}
			]
});