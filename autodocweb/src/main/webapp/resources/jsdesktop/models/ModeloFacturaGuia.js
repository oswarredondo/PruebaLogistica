Ext.define('MyDesktop.models.ModeloFacturaGuia', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'razonsocial', type: 'string'}, 
		   {name: 'iddocumento', type: 'string'},
		   {name: 'fecha', type: 'string'}, 
		   {name: 'tipo', type: 'string'},  
		   {name: 'referencia', type: 'string'},   
		   {name: 'fechaentrega', type: 'string'}, 
		   {name: 'factura', type: 'string'}, 
		   {name: 'isfacturada', type: 'string'},
		   {name: 'estatus', type: 'string'},
		   {name: 'tiposervicio', type: 'string'},
		   {name: 'marcafactura', type: 'string'},
		   {name: 'zonaori', type: 'string'},
		   {name: 'zonades', type: 'string'},
		   {name: 'zonaventa', type: 'string'},
		   {name: 'largo', type: 'string'},
		   {name: 'ancho', type: 'integer'},
		   {name: 'alto', type: 'integer'},
		   {name: 'pesofisico', type: 'string'},
		   {name: 'pesovolumetrico', type: 'string'},
		   {name: 'precio', type: 'string'},
		   {name: 'fechacorte', type: 'string'}
		]
});