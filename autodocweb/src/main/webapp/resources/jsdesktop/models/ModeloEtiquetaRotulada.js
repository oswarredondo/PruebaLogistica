Ext.define('MyDesktop.models.ModeloEtiquetaRotulada', {
        extend: 'Ext.data.Model',
		fields: [
		    {name: 'esvalido',type: 'int'},   
		    {name: 'mensajeError',type: 'string'}, 
			{name: 'idregistrodatos',type: 'int'},
			{name: 'idregistro',type: 'int'},
			{name: 'uuid',type: 'string'}, 
			{name: 'idoficina',type: 'string'}, 
			{name: 'idservicio',type: 'string'}, 
			{name: 'idtipocobro',type: 'string'}, 
			{name: 'idformapago',type: 'string'}, 
			{name: 'idadicional',type: 'string'}, 
			{name: 'idterminalori',type: 'string'}, 
			{name: 'idterminaldes',type: 'string'}, 
			{name: 'idtipodocumento',type: 'string'}, 
			{name: 'fechacreacion',type: 'string'}, 
			{name: 'referencia',type: 'string'}, 
			{name: 'login',type: 'string'}, 
			{name: 'factura',type: 'string'}, 
			{name: 'pedimento',type: 'string'}, 
			{name: 'aduana',type: 'string'}, 
			{name: 'valordeclarado',type: 'float'}, 
			{name: 'tipodeembalaje',type: 'string'}, 
			{name: 'tipoempaque',type: 'string'}, 
			{name: 'contenido',type: 'string'}, 
			{name: 'enrutamiento',type: 'string'}, 
			{name: 'preciozona',type: 'float'}, 
			{name: 'iva',type: 'float'}, 
			{name: 'largo',type: 'int'}, 
			{name: 'ancho',type: 'int'}, 
			{name: 'alto',type: 'int'}, 
			{name: 'pesofisico',type: 'float'}, 
			{name: 'pesovolumetrico',type: 'float'}, 
			{name: 'numcliente',type: 'string'}, 
			{name: 'numpiezas',type: 'int'}, 
			{name: 'observacion',type: 'string'},  
			{name: 'zonaori',type: 'string'}, 
			{name: 'zonades',type: 'string'}, 
			{name: 'transportista',type: 'string'}, 
			{name: 'identidad',type: 'int'}, 
			{name: 'idorganizacion',type: 'int'}, 
			{name: 'razonsocial_rem',type: 'string'}, 
			{name: 'contacto_rem',type: 'string'}, 
			{name: 'calle_rem',type: 'string'}, 
			{name: 'colonia_rem',type: 'string'}, 
			{name: 'municipio_rem',type: 'string'}, 
			{name: 'estado_rem',type: 'string'}, 
			{name: 'ciudad_rem',type: 'string'}, 
			{name: 'cp_rem',type: 'string'}, 
			{name: 'telefono_rem',type: 'string'}, 
			{name: 'celular_rem',type: 'string'}, 
			{name: 'rfc_rem',type: 'string'}, 
			{name: 'email_rem',type: 'string'}, 
			{name: 'razonsocial_des',type: 'string'}, 
			{name: 'contacto_des',type: 'string'}, 
			{name: 'calle_des',type: 'string'}, 
			{name: 'colonia_des',type: 'string'}, 
			{name: 'municipio_des',type: 'string'}, 
			{name: 'estado_des',type: 'string'}, 
			{name: 'ciudad_des',type: 'string'}, 
			{name: 'cp_des',type: 'string'}, 
			{name: 'telefono_des',type: 'string'}, 
			{name: 'celular_des',type: 'string'}, 
			{name: 'rfc_des',type: 'string'}, 
			{name: 'email_des',type: 'string'}, 
			{name: 'tiene_seguro',type: 'string'}, 
			{name: 'valor_asegurado',type: 'float'}, 
			{name: 'factura_producto',type: 'string'}, 
			{name: 'es_cod',type: 'string'}, 
			{name: 'es_ocurre',type: 'string'}, 
			{name: 'valor_a_cobrar',type: 'float'}, 
			{name: 'factura_producto_cod',type: 'string'}, 
			{name: 'idregistro_set',type: 'int'}, 
			{name: 'factura_producto_asegurado',type: 'string'}, 
			{name: 'valor_a_cobrar_cod',type: 'float'}, 
			{name: 'es_multiple',type: 'string'},
			{name: 'es_ocurre',type: 'string'},
			{name: 'generaguiaestafeta',type: 'string'},
			
			{name: 'nacional',type: 'string'},
			{name: 'pesovolumetrico_total',type: 'float'},
			{name: 'pesofisico_total',type: 'float'},
			{name: 'cantidad_total',type: 'int'},
			
			{name: 'adicionales',type: 'string'},
			{name: 'descripcion',type: 'string'},
			{name: 'tarifa_servicio',type: 'string'},
			{name: 'nombreservicio',type: 'string'},
			 
			{name: 'pais_rem',type: 'string'},
			{name: 'pais_des',type: 'string'},
			 
			
			{name: 'descripcion_servicio',type: 'string'},
			{name: 'numinterior_rem',type: 'string'},
			{name: 'numexterior_rem',type: 'string'},
			{name: 'numinterior_des',type: 'string'},
			{name: 'numexterior_des',type: 'string'},
			{name: 'idconvenio',type: 'int'}
			
		
			


		  
		]
});