Ext.define('MyDesktop.models.ModeloFacturaResumen', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'idcontrol', type: 'string'}, 
		   {name: 'dia', type: 'string'}, 
		   {name: 'cliente', type: 'string'}, 
		   {name: 'login', type: 'string'}, 
		   {name: 'idcontrolenvio', type: 'string'},  
		   {name: 'login_cancela', type: 'string'},   
		   {name: 'fecha_cancela', type: 'string'}, 
		   {name: 'factura', type: 'string'}, 
		   {name: 'mes', type: 'string'},
		   {name: 'estatus', type: 'string'},
		   {name: 'nombreMes', type: 'string'},
		   {name: 'anio', type: 'string'},
		   {name: 'cantidad', type: 'string'},
		   {name: 'login_notacredito', type: 'string'},
		   {name: 'fecha_notacredito', type: 'string'},
		   {name: 'fac_nota', type: 'string'},
		   
		   
		   {name: 'idregistro', type: 'integer'},
		   {name: 'idmaterial', type: 'integer'},
		   {name: 'nombre', type: 'string'},
		   {name: 'descripcion', type: 'string'},
		   {name: 'observacion', type: 'string'},
		   {name: 'tipo', type: 'string'},
		   {name: 'precio', type: 'float'}
		]
});