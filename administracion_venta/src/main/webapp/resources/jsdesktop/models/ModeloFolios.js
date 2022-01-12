Ext.define('MyDesktop.models.ModeloFolios', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'idregistro', type: 'string'},
		   {name: 'idServicio', type: 'string'},
		   {name: 'descripcionServicio', type: 'string'},
		   {name: 'numCliente', type: 'string'},
		   {name: 'cantidadUtilizada', type: 'int'},
		   {name: 'cantidadAsignada', type: 'int'},
		   {name: 'peso', type: 'int'}
		   
		  
		]
});