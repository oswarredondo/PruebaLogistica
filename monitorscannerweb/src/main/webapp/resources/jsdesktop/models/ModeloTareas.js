Ext.define('MyDesktop.models.ModeloTareas', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'idtarea', type: 'string'},      
		   {name: 'idtareaorigina', type: 'string'},
		   {name: 'idusuariogenero', type: 'string'},
		   {name: 'idusuarioresponsable', type: 'string'},
		   {name: 'fechasolicitud', type: 'string'},
		   {name: 'solicitud', type: 'string'},
		   {name: 'estatus', type: 'string'},
		   {name: 'tipo', type: 'string'},
		   {name: 'importancia', type: 'string'},
		   {name: 'fechacambioestatus', type: 'string'},
		   {name: 'solucion', type: 'string'},
		   {name: 'ambito', type: 'string'},
		   {name: 'fechaexpira', type: 'string'},
		   {name: 'idambitotarea', type: 'string'},
		   {name: 'titulo', type: 'string'}
		  
		]

});