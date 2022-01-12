Ext.define('MyDesktop.models.ModeloRegistros', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'identificador', type: 'string'},
		   {name: 'descripcion', type: 'string'},
		   {name: 'patron', type: 'string'}
		]
});