Ext.define('MyDesktop.models.ModeloUnidadAdministrativa', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'identificador', type: 'string'},
		   {name: 'nombre', type: 'string'},      
		   {name: 'clave', type: 'string'},
		   {name: 'descripcion', type: 'string'}
		]
});