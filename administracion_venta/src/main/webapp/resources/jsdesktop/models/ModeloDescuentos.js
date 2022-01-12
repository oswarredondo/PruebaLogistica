Ext.define('MyDesktop.models.ModeloDescuentos', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'iddescuento', type: 'string'},
		   {name: 'identificador', type: 'string'},
		   {name: 'estatus', type: 'string'},
		   {name: 'nombre', type: 'string'},
		   {name: 'descripcion', type: 'string'},
		   {name: 'fechaalta', type: 'string'},
		   {name: 'fechaactivacion', type: 'string'},
		   {name: 'fechatermino', type: 'string'},
		   {name: 'descuentofijo', type: 'string'},
		   {name: 'porcentaje', type: 'string'},
		   {name: 'tipo', type: 'string'}, //1=cliente, 2=tarifa, 3=zona, 
		   {name: 'nivel', type: 'string'},
		   {name: 'idagrupamiento', type: 'integer'}
		   
		   
		   
		  
		]
});