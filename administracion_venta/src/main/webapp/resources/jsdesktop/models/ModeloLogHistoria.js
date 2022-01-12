Ext.define('MyDesktop.models.ModeloLogHistoria', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'idregistro', type: 'string'},
		    {name: 'tipomovimiento', type: 'string'},
		    {name: 'fecha', type: 'string'},
		   {name: 'registro', type: 'string'},
		   {name: 'quienrealiza', type: 'string'},
		   {name: 'login', type: 'string'},
		   {name: 'observacion', type: 'string'},
		   
		   
		   {name: 'tipoRegistro', type: 'string'},
		   {name: 'tiDescripcion', type: 'string'},
		   {name: 'claveLogistica', type: 'string'},
		   {name: 'descripcionclave', type: 'string'},
		   {name: 'empleado', type: 'string'},
		   {name: 'siglasPlaza', type: 'string'},
		   {name: 'ruta', type: 'string'},
		   {name: 'idsolicitud', type: 'string'},
		   {name: 'guia', type: 'string'},
		   {name: 'origenRegistro', type: 'string'},
		   {name: 'quienrechaza', type: 'string'},
		   {name: 'motivo', type: 'string'},
		   {name: 'idCasamiento', type: 'string'}
		   
	  
		]
});
