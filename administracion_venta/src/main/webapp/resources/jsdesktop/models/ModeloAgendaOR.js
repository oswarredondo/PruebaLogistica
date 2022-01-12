Ext.define('MyDesktop.models.ModeloAgendaOR', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'folio', type: 'int'},
		   {name: 'quiencaptura', type: 'string'},      
		   {name: 'fechacaptura', type: 'string'},
		   {name: 'quiensolicita', type: 'string'},
		   {name: 'nombresolicita', type: 'string'},
		   {name: 'telefonosolicita', type: 'string'},
		   {name: 'iddocumento', type: 'string'},
		   {name: 'datosorigen', type: 'string'},
		   {name: 'datosdestino', type: 'string'},
		   {name: 'tipoproblema', type: 'string'},
		   {name: 'depto_que_atiende', type: 'string'},
		   {name: 'nombre_quien_atiende', type: 'string'},
		   {name: 'tiposolucion', type: 'string'},
		   {name: 'fechacierre', type: 'string'},
		   {name: 'estatus', type: 'string'},
		   {name: 'comentariocierre', type: 'string'},
		   {name: 'prioridad', type: 'string'}
		  
		]
});