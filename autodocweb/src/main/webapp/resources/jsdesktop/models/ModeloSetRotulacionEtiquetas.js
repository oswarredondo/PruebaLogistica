Ext.define('MyDesktop.models.ModeloSetRotulacionEtiquetas', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'idregistro', type: 'string'},      
		   {name: 'login', type: 'string'},
		   {name: 'uuid', type: 'string'},
		   {name: 'fecharegistro', type: 'string'},
		   {name: 'descripcion', type: 'string'}

		]
});