Ext.define('MyDesktop.store.StoreTipoLeyendaAcuse', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
		        {"idtipo":1, "descripcion":"SOLO LEYENDA"},
				{"idtipo":0, "descripcion":"CREAR NUEVA ETIQUETA"}
			]
});