Ext.define('MyDesktop.models.ModeloMedicionGarantiasCliente', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'grupo', type: 'string'},      
		   {name: 'entrega', type: 'float'},
		   {name: 'transito', type: 'float'},
		   {name: 'demora', type: 'float'}
		]
});