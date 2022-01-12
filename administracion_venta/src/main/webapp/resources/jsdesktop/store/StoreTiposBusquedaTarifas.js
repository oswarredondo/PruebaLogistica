
Ext.define('MyDesktop.store.StoreTiposBusquedaTarifas', {
    extend: 'Ext.data.Store',
	fields: ['idtipo', 'descripcion'],
	data : [
			{"idtipo":"01", "descripcion":"Nombre"},
			{"idtipo":"02", "descripcion":"Descripcion"},
			{"idtipo":"03", "descripcion":"Servicio"},
			{"idtipo":"04", "descripcion":"Forma pago"},
			{"idtipo":"05", "descripcion":"Rango Fechas"} //Por default
		]
});