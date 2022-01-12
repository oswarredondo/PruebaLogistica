Ext.define('MyDesktop.models.ModeloDetalleConvenio', {
        extend: 'Ext.data.Model',
		fields: [
		   
		   {name: 'idconvenio', type: 'string'},
		   {name: 'idconveniodetalle', type: 'string'},
		   {name: 'cporigen', type: 'string'},
		   {name: 'siglasori', type: 'string'},
		   {name: 'cpodestino', type: 'string'},
		   {name: 'siglasdes', type: 'string'},
		   {name: 'coberturakm', type: 'integer'}, 
		   {name: 'ancho', type: 'float'},
		   {name: 'alto', type: 'float'},
		   {name: 'largo', type: 'float'},
		   {name: 'volumen', type: 'float'},
		   {name: 'sobrepeso', type: 'float'},
		   {name: 'peso', type: 'float'}, 
		   {name: 'pesobase', type: 'float'}, 
		   {name: 'precio', type: 'float'},
		   {name: 'precio_real', type: 'float'},
		   {name: 'preciosobrepeso', type: 'float'},
		   {name: 'descuento', type: 'float'},
		   {name: 'volumen', type: 'float'},
		   {name: 'comentario', type: 'string'}
		   

		   
		]
});