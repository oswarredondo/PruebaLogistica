Ext.define('MyDesktop.models.ModeloContactos', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'idcontacto', type: 'integer'},
		   {name: 'idcliente', type: 'integer'},
		   {name: 'estatus', type: 'string'},
		   {name: 'nombre', type: 'string'},
		   {name: 'apellido', type:'string'},
		   {name: 'puesto', type: 'string'},
		   {name: 'utilizadircliente', type: 'integer'},
		   {name: 'calle', type: 'string'},
		   {name: 'numinterior', type: 'string'},
		   {name: 'numexterior', type: 'string'},
		   {name: 'cp', type: 'string'},
		   {name: 'colonia', type: 'string'},
		   {name: 'municipio', type: 'string'},
		   {name: 'estado', type: 'string'},
		   {name: 'email', type: 'string'},
		   {name: 'telefono', type: 'string'},
		   {name: 'telefono2', type: 'string'},
		   {name: 'movil', type: 'string'},
		   {name: 'comentario', type: 'string'},
		   {name: 'clasificacion', type: 'string' },
		   {name: 'extencion', type: 'string' }

		]
});