Ext.define('MyDesktop.store.StoreTiposBusquedaPaquetes', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
		        {"idtipo":"00", "descripcion":"Por Guía"},
				{"idtipo":"01", "descripcion":"Por Cliente"},
				{"idtipo":"02", "descripcion":"Por Rango fechas"},
				{"idtipo":"02", "descripcion":"Por Referencia"},
				{"idtipo":"02", "descripcion":"Por Factura"},
			]
});