Ext.define('MyDesktop.models.ModeloRegimen', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'identificador', type: 'string'},
		   {name: 'descripcion', type: 'string'},
		   {name: 'estatus', type: 'string'},
		   {name: 'nombre', type: 'string'}
		]
});