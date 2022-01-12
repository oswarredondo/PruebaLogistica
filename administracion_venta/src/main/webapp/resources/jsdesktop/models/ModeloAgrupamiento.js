Ext.define('MyDesktop.models.ModeloAgrupamiento', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'identificador', type: 'integer'},    
		   {name: 'idagrupamiento', type: 'integer'},      
		   {name: 'descripcion', type: 'string'},
		   {name: 'visualizatodo', type: 'integer'},
		   {name: 'idrelacion', type: 'string'},
		   {name: 'jefezona', type: 'string'},
		   {name: 'dirfinanzas', type: 'string'},
		   {name: 'creditocobranza', type: 'string'},
		   {name: 'gerentecomercial', type: 'string'}
		  
		]
}); 