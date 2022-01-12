
Ext.define('MyDesktop.store.StoreTiposBusquedaDescuentos', {
    extend: 'Ext.data.Store',
	fields: ['idtipo', 'descripcion'],
	data : [
			{"idtipo":"01", "descripcion":"Nombre"},
			{"idtipo":"02", "descripcion":"Descripcion"},
			{"idtipo":"03", "descripcion":"Fecha Activación"},
			{"idtipo":"04", "descripcion":"Fecha Termino"},
			{"idtipo":"05", "descripcion":"Rango Fechas"} //Por default
		]
});