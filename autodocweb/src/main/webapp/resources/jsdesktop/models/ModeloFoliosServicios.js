Ext.define('MyDesktop.models.ModeloFoliosServicios', {
        extend: 'Ext.data.Model',
		fields: [
				   {name: 'identificador'}, 
				   {name: 'idServicio'},
				   {name: 'descripcion'},
				   {name: 'cantidad'},
				   {name: 'numCliente'},
				   {name: 'descripcionServicio'},
				   {name: 'cantidadAsignada'},
				   {name: 'peso'},
				   {name: 'tipoRotulacion'},
				   {name: 'idconveniodetalle'}
		]
});