Ext.define('MyDesktop.models.ModeloPaquete', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'tipoempaque', type: 'string'},
		   {name: 'alto', type: 'float'},
		   {name: 'ancho', type: 'float'},      
		   {name: 'largo', type: 'float'},
		   {name: 'pesofisico', type: 'integer'},
		   {name: 'volumen', type: 'float'},
		   {name: 'isseguroopcional', type: 'string'},
		   {name: 'contenido', type: 'string'},
		   {name: 'factura', type: 'string'},
		   {name: 'valordeclarado', type: 'float'},
		   {name: 'cantidad', type: 'integer'}
		  
		 
		  
		]
});