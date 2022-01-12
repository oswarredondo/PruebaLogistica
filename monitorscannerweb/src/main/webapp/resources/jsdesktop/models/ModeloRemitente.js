Ext.define('MyDesktop.models.ModeloRemitente', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'idDocumento', type: 'string'},      
		   {name: 'razonSocial', type: 'string'},
		   {name: 'atencion', type: 'string'},
		   {name: 'direccion', type: 'string'},
		   {name: 'calle', type: 'string'},
		   {name: 'colonia', type: 'string'},
		   {name: 'ciudad', type: 'string'},
		   {name: 'estado', type: 'string'},
		   {name: 'municipio', type: 'string'},
		   {name: 'cp', type: 'string'},
		   {name: 'telefono', type: 'string'},
		   {name: 'pais', type: 'string'},
		   {name: 'entrecalles', type: 'string'},
		   {name: 'correoe', type: 'string'},
		   {name: 'rfc', type: 'string'}
		]
});