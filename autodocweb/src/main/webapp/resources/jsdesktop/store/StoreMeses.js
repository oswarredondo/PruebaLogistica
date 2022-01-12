Ext.define('MyDesktop.store.StoreMeses', {
        extend: 'Ext.data.Store',
		fields: ['identificador', 'descripcion'],
		data : [
				{"identificador":"1", "descripcion":"ENERO"},
				{"identificador":"2", "descripcion":"FEBRERO"},
				{"identificador":"3", "descripcion":"MARZO"},
				{"identificador":"4", "descripcion":"ABRIL"},
				{"identificador":"5", "descripcion":"MAYO"},
				{"identificador":"6", "descripcion":"JUNIO"},
				{"identificador":"7", "descripcion":"JULIO"},
				{"identificador":"8", "descripcion":"AGOSTO"},
				{"identificador":"9", "descripcion":"SEPTIEMBRE"},
				{"identificador":"10", "descripcion":"OCTUBRE"},
				{"identificador":"11", "descripcion":"NOVIEMBRE"},
				{"identificador":"12", "descripcion":"DICIEMBRE"}
			]
});