Ext.define('MyDesktop.store.StoreCentrosOperativos', {
        extend: 'Ext.data.Store',
		fields: ['identificador', 'descripcion'],
		data : [
				{"identificador":"MEX", "descripcion":"MEXICO"},
				{"identificador":"GDL", "descripcion":"GUADALAJARA"},
				{"identificador":"MTY", "descripcion":"MONTERREY"},
				{"identificador":"LEN", "descripcion":"LEON"},
				{"identificador":"ALL", "descripcion":"TODOS"}
			]
});