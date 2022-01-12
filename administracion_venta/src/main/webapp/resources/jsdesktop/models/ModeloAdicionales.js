Ext.define('MyDesktop.models.ModeloAdicionales', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'identificador', type: 'string'},      
		   {name: 'clave', type: 'string'},
		   {name: 'descripcion', type: 'string'},
		   {name: 'precio', type: 'float'},
		   {name: 'tipo', type: 'string'},
		   {name: 'tipoincremento', type: 'int'}
		   
		  
		]
});