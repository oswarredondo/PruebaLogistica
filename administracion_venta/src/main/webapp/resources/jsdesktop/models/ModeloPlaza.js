Ext.define('MyDesktop.models.ModeloPlaza', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'identificador', type: 'string'},      
		   {name: 'siglasplaza', type: 'string'},
		   {name: 'descripcion', type: 'string'},
		   {name: 'idcentrooperativo', type: 'string'},
		   {name: 'total', type: 'string'},
		   {name: 'idruta', type: 'string'},
		   
		]
});