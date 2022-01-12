Ext.define('MyDesktop.models.ModeloAdicionales', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'identificador', type: 'string'},      
		   {name: 'clave', type: 'string'},
		   {name: 'idregistro', type: 'string'},
		   {name: 'iddregistrodatos', type: 'string'},
		   {name: 'idregistroadicional', type: 'string'},
		   {name: 'idadicionaldetalle', type: 'string'},
		   {name: 'idadicional', type: 'string'},
		   {name: 'tipo', type: 'string'},
		   {name: 'precio', type: 'string'},
		   {name: 'descuento', type: 'string'},
		   {name: 'tipoincremento', type: 'string'},
		   {name: 'uuid', type: 'string'},
		   {name: 'descripcion', type: 'string'},
		   {name: 'fechacreacion', type: 'string'}
		]
});