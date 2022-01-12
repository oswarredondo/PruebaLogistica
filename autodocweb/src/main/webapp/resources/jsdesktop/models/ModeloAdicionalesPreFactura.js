Ext.define('MyDesktop.models.ModeloAdicionales', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'iddocumento', type: 'string'},
		   {name: 'idclaveadicional', type: 'string'},
		   {name: 'idadicional', type: 'string'},
		   {name: 'precio', type: 'string'},
		   {name: 'descripcion', type: 'string'},
		   {name: 'fechacreacion', type: 'string'},
		   {name: 'tipo', type: 'string'}
		]
});