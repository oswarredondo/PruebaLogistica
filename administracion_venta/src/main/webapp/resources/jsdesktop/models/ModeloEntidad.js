Ext.define('MyDesktop.models.ModeloEntidad', {
    extend: 'Ext.data.Model',
	fields: [
	         {name: 'identidad', type: 'string'},      
			 {name: 'descripcion', type: 'string'},
			 {name: 'estatus', type: 'string'}
	      ]
});