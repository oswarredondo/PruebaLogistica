Ext.define('MyDesktop.models.ModeloRegistrosProcesados', {
        extend: 'Ext.data.Model',
		fields: [
		         
		   {name: 'plazaenvia', type: 'string'},      
		   {name: 'servidor', type: 'string'},
		   {name: 'cliente', type: 'string'},
		   {name: 'archivo', type: 'string'},
		   {name: 'transmitido', type: 'string'},
		   {name: 'fechaproceso', type: 'string'},
		   {name: 'guia', type: 'string'},
		   {name: 'msgstatus', type: 'string'},
		   {name: 'tipoerror', type: 'string'},
		   {name: 'llavetransmision', type: 'string'},
		   {name: 'tipoincremento', type: 'string'},
		   {name: 'manifiesto', type: 'string'},
		   {name: 'ruta', type: 'string'},
		   {name: 'viaje', type: 'string'},
		   {name: 'tipomovimiento', type: 'string'},
		   {name: 'cantidad', type: 'int'},
		   {name: 'depto', type: 'string'},
		   {name: 'registro', type: 'string'},
		   {name: 'viaje_corrida', type: 'string'}
		   
		   
		   
		   
		  
		]
});