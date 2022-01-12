Ext.define('MyDesktop.models.ModeloEtiquetaImportar', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'identificador', type: 'string'},      
		   {name: 'clave', type: 'string'},
		   {name: 'descripcion', type: 'string'},
		   {name: 'precio', type: 'float'},
		   {name: 'tipo', type: 'string'}
		  
		]
});