Ext.define('MyDesktop.store.StoreTiposBusquedaContactos', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
				{"idtipo":"01", "descripcion":"Por Nombre"},
				{"idtipo":"02", "descripcion":"Puesto"},
				{"idtipo":"03", "descripcion":"Direccion"}
			]
});
