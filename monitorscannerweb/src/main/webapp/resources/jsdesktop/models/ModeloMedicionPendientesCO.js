Ext.define('MyDesktop.models.ModeloMedicionPendientesCO', {
        extend: 'Ext.data.Model',
		fields: [

			{name: 'estatus', type:'string'},
			{name: 'almacen', type:'int'},
			{name: 'ruta', type:'int'},
			{name: 'rutaForanea', type:'int'},
			{name: 'confirmaActualiza', type:'int'},
			{name: 'investigacion', type:'int'},
			{name: 'entrega', type:'int'},
			{name: 'sinMovimientos', type:'int'}
	
		]
});