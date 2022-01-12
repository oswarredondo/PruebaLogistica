Ext.define('MyDesktop.models.ModeloNivelPuestoUsuario', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'identificador', type: 'string'},      
		   {name: 'idnivelusuario', type: 'integer'},
		   {name: 'descripcion', type: 'string'},
		   {name: 'visiblesiempre', type: 'integer'},
		   {name: 'maxdescadicional', type: 'float'},
		   {name: 'maxdesctarifas', type: 'float'}

		]
});