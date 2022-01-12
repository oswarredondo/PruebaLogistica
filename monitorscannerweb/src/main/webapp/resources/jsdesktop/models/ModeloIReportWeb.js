Ext.define('MyDesktop.models.ModeloIReportWeb', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'nombre', type: 'string'},      
		   {name: 'id', type: 'string'},
		   {name: 'descripcion', type: 'string'},
		   {name: 'nivel', type: 'string'},
		   {name: 'idconexion', type: 'string'},
		   {name: 'idregistro', type: 'int'}
		   
		  
		]
});