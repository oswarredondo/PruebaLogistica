Ext.define('MyDesktop.models.ModeloOrganizacion', {
    extend: 'Ext.data.Model',
	fields: [
	         {name: 'identidad', type: 'string'},      
			 {name: 'idorganizacion', type: 'string'},
			 {name: 'descripcion', type: 'string'},
			 {name: 'estatus', type: 'string'}
	   ]
});