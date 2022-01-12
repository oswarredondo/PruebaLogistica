Ext.define('MyDesktop.models.ModeloDataObject', {
    extend: 'Ext.data.Model',
	fields: [
	         {name: 'identidad', type: 'string'},      
			 {name: 'idorganizacion', type: 'string'},
			 {name: 'idmodulo', type: 'string'},
			 {name: 'idopcion', type: 'string'},
			 {name: 'idsistema', type: 'string'},


			 {name: 'descripcion_perfil', type: 'string'},
			 {name: 'descripcion_opcion', type: 'string'},
			 {name: 'descripcion_modulo', type: 'string'},
			 
			 {name: 'identificador', type: 'string'},
			 {name: 'descripcion', type: 'string'},
			 {name: 'clave', type: 'string'},
			 {name: 'consecutivo', type: 'int'}
		]
});