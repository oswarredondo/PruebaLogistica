Ext.define('MyDesktop.models.ModeloMaterialEmpaque', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'identificador', type: 'string'},   //contiene el id de materiales empaques   
		   {name: 'clave', type: 'string'},
		   {name: 'descripcion', type: 'string'},
		   {name: 'precio', type: 'float'},
		   {name: 'cantidad', type: 'integer'},
		   {name: 'idtipo', type: 'integer'} //contiene el idconvenio

		]
});