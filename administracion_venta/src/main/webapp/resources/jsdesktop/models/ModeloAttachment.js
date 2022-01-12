Ext.define('MyDesktop.models.ModeloAttachment', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'identificador', type: 'string'},      
		   {name: 'nombre_archivo', type: 'string'},
		   {name: 'descripcion', type: 'string'},
		   {name: 'fecha', type: 'string'},
		   {name: 'login', type: 'string'},
		   {name: 'extension', type: 'string'},
		   {name: 'folio', type: 'int'},
		   {name: 'iddocumento', type: 'string'},   
		   {name: 'idtipodocumento', type: 'string'},  
		   {name: 'tipoarchivo', type: 'string'}
		  
		]
});