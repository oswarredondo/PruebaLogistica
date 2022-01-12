Ext.define('MyDesktop.models.ModeloDescuentoRangoFactura', {
        extend: 'Ext.data.Model',
		fields: [
		   
		   {name: 'idconveniodescfact', type: 'int'},
		   {name: 'idconvenio', type: 'int'},
		   {name: 'rangoinicial', type: 'int'},
		   {name: 'rangofinal', type: 'int'},
		   {name: 'descuento', type: 'int'},
		   {name: 'fechaevento', type: 'string'},
		   {name: 'login', type: 'string'}
		   
		   
		  
		]
});