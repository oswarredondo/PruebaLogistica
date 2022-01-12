Ext.define('MyDesktop.models.ModeloTarifas', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'idtarifa', type: 'string'},
		   {name: 'idserviciotarifa', type: 'string'},
		   {name: 'idserviciotarifazona', type: 'string'},
		   {name: 'idrangoenvios', type: 'string'},
		   {name: 'idtarifapeso', type: 'string'},

		   {name: 'idservicio', type: 'string'},
		   {name: 'idformapago', type: 'string'},
		   
		   {name: 'estatus', type: 'string'},
		   {name: 'numero', type: 'string'},
		   {name: 'nombre', type: 'string'},
		   {name: 'descripcion', type: 'string'},
		   {name: 'idservicio', type: 'string'},
		   {name: 'pesoinicial', type: 'integer'},
		   {name: 'pesofinal', type: 'integer'},
		   {name: 'sobrepeso', type: 'string'},
		   {name: 'pesoamparado', type: 'integer'},
     
		   {name: 'fechainicial', type: 'string'},
		   {name: 'fechafinal', type: 'string'},
		   {name: 'idrangoinicial', type: 'string'},
		   {name: 'idrangofinal', type: 'string'},
		   {name: 'zona', type: 'string'},
		   {name: 'kminicial', type: 'integer'},
		   {name: 'kmfinal', type: 'integer'},
		   {name: 'precio', type: 'float'},
		   {name: 'volumen', type: 'float'},
		   {name: 'preciokgsp', type: 'float'},
		   {name: 'descripciontarifa', type: 'string'},
		   {name: 'descripcionservicio', type: 'string'},
		  
		   {name: 'descripcionformapago', type: 'string'},
		   {name: 'es_visible_pdv', type: 'string'},
		   {name: 'es_default', type: 'boolean'}
		   
		   /* CAMBIO CITAS EVIDENCIAS MANIOBRAS
		   {name: 'preciocitas', type: 'float'},
		   {name: 'precioevidencia', type: 'float'}
		    FIN CAMBIO */

		] 
});