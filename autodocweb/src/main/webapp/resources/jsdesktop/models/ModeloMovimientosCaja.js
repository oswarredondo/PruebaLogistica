Ext.define('MyDesktop.models.ModeloMovimientosCaja', {
        extend: 'Ext.data.Model',
		fields: [
   
		 		{name: 'login',type: 'string'}, 
		 		{name: 'fecha',type: 'string'}, 
				{name: 'descripcion',type: 'string'}, 
				{name: 'cantidad',type: 'float'}, 
				{name: 'tipo',type: 'string'}
		]
});