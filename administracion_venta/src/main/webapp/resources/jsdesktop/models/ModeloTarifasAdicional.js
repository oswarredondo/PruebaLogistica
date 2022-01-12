Ext.define('MyDesktop.models.ModeloTarifasAdicional', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'idtarifa', type: 'string'},
		   {name: 'idconvenio', type: 'string'},
		   {name: 'idadicionaldetalle', type: 'string'},
		   {name: 'idadicional', type: 'string'},
		   {name: 'descuento', type: 'float'},
		   {name: 'precio', type: 'float'},
		   {name: 'estatus', type: 'integer'},
		   {name: 'descripcion', type: 'string'},
		   {name: 'claveadicional', type: 'string'},
		   {name: 'tipoincremento', type: 'integer'}
		   

		] 
});