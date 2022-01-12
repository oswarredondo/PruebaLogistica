Ext.define('MyDesktop.models.ModeloClavesExcepcion', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'identificador', type: 'string'},      
		   {name: 'clave', type: 'string'},
		   {name: 'descripcion', type: 'string'},
		   {name: 'imputable', type: 'string'}
		  
		]
});