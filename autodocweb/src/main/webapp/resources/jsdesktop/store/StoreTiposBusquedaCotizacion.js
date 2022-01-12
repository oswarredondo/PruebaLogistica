
Ext.define('MyDesktop.store.StoreTiposBusquedaCotizacion', {
    extend: 'Ext.data.Store',
	fields: ['idtipo', 'descripcion'],
	data : [
			{"idtipo":"01", "descripcion":"Ref, Búsqueda"},
			{"idtipo":"02", "descripcion":"Razón Social"},
			{"idtipo":"03", "descripcion":"Fecha"},
			{"idtipo":"05", "descripcion":"Mes"},
			{"idtipo":"04", "descripcion":"Id"}
		]
});