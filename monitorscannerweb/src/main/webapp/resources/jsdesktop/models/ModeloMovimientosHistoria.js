Ext.define('MyDesktop.models.ModeloMovimientosHistoria', {
        extend: 'Ext.data.Model',
		fields: [
		 		 {name: 'idregistro', type: 'string'},
			    {name: 'tipomovimiento', type: 'string'},
			    {name: 'fecha', type: 'string'},
			   {name: 'registro', type: 'string'},
			   {name: 'quienrealiza', type: 'string'},
			   {name: 'login', type: 'string'},
			   {name: 'idenvio', type: 'string'},
			   {name: 'descripcion', type: 'string'},
			   {name: 'exclave', type: 'string'},
			   {name: 'siglasplaza', type: 'string'},
			   {name: 'plazaorigina', type: 'string'},
			   {name: 'empleado', type: 'string'},
			   {name: 'ruta', type: 'string'}
			   
		  
		]
});