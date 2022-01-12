Ext.define('MyDesktop.models.ModeloCotizacion', {
        extend: 'Ext.data.Model',
		fields: [
		   
		   
		   {name: 'idtarifa', type: 'int'},
		   {name: 'idtarifapeso', type: 'int'},
			{name: 'idserviciotarifa', type: 'int'},
			{name: 'idserviciotarifazona', type: 'int'},
			{name: 'idrangoenvios', type: 'int'},
			{name: 'estatus', type: 'int'},
			{name: 'idrangoinicial', type: 'int'},
			{name: 'idrangofinal', type: 'int'},
			
			{name: 'pesoamparado', type: 'float'},
			{name: 'pesoinicial', type: 'float'},
			{name: 'pesofinal', type: 'float'},
			
			
			{name: 'kminicial', type: 'float'},
			{name: 'kmfinal', type: 'float'},
			{name: 'precio', type: 'float'},
			{name: 'sobrepeso', type: 'float'},
			{name: 'preciokgsp', type: 'float'},
			{name: 'pesovolumetrico', type: 'float'},
			{name: 'preciounitarioporkm', type: 'float'},
			{name: 'cantidadenvios', type: 'float'},
			{name: 'kilometros', type: 'float'},
			
			{name: 'precioadicional', type: 'float'},
			{name: 'totalprecioenvios', type: 'float'},
			{name: 'totalsobrepeso', type: 'float'},
			
			{name: 'descripciontarifa', type: 'string'},
			{name: 'garantiamaxina', type: 'string'},
			{name: 'nombre', type: 'string'},
			{name: 'descripciongarantiamaxima', type: 'string'},
			{name: 'formapago', type: 'string'},
			{name: 'cporigen', type: 'string'},
			{name: 'cpdestino', type: 'string'},
		
			{name: 'zona', type: 'string'}
			
			
		   
		   
		  
		]
});