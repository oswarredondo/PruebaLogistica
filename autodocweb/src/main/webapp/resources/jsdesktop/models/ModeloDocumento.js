Ext.define('MyDesktop.models.ModeloDocumento', {
        extend: 'Ext.data.Model',
        requires: [
                   'MyDesktop.models.ModeloRemitente', 
                   'MyDesktop.models.ModeloDestinatario',
                   'Ext.data.association.HasMany',
                   'Ext.data.association.BelongsTo'],
		fields: [  
		        { name:'idDocumentoMadre'}, 
				{ name:'idDocumento'},
				{ name:'idDocumentoPadre'},
				{ name:'unidadreparto'},
				{ name:'pos_manif' , type:'int'},
				{ name:'idGuiaCasamiento'},    
				{ name:'idGuiaDevolucion'},
				{ name:'numCliente'},
				{ name:'login'},
				{ name:'idOficina'},
				{ name:'idServicio'},
				{ name:'idTipoCobro'},
				{ name:'idTipoPago'},
				{ name:'idAdicional'},
				{ name:'idTerminalOrigen'},
				{ name:'idTerminalDestino'},
				{ name:'idTipoDocumento'},
				{ name:'fechaCreacion'},
				{ name:'comentario'},
				{ name:'estatus'},
				{ name:'referencia'},
				{ name:'valorDeclarado'},
				{ name:'pesoBruto'},
				{ name:'pesoVolumetrico'},
				{ name:'volumen'},
				{ name:'sobrePeso'},
				{ name:'largo'},
				{ name:'ancho'},
				{ name:'alto'},
				{ name:'iva'},
				{ name:'precioZona'},
				{ name:'factura'},
				{ name:'isfactura'},
				{ name:'pedimento'},
				{ name:'aduana'},
				{ name:'tipoEmbalaje'},
				{ name:'contenidoDeclarado'},
				{ name:'enrutamiento'},
				{ name:'marcaFactura'},
				{ name:'marcaRetornoDocumento'},
				{ name:'consecutivo'},
				{ name:'numPiezas'},
				{ name:'porcentajeIva'},
				{ name:'porcentajeRetencion'},
				{ name:'observaciones'},
				{ name:'zonaOri'},
				{ name:'zonaDes'},
				{ name:'ruta'},
				{ name:'manifiesto'},
				{ name:'fechaManifiesto'},
				{ name:'cita'},
				{ name:'horaCita'},
				{ name:'fechaCita'},
				{ name:'embarque'},
				{ name:'delivery'},
				{ name:'fecharecoleccion'}, 
				{ name:'servicio'},
				{ name:'descripcio_servicio'},
				{ name:'datos_carta'},
				{ name:'descripcion_garantia'},
				{ name:'idEnvio'},
				{ name:'siglasOrigen'},
				{ name:'razonSocialDestino'},
				{ name:'razonSocialRemitente'},
				{ name:'razonSocialFacturacion'},
				{ name:'razonSocialRecoleccion'},
				{ name:'ciaSeguro'},
				{ name:'numPoliza'},
				{ name:'inciso'},
				{ name:'fechaAsignacion'},
				{ name:'fechaLimite'},
				{ name:'quienSolcita'},
				{ name:'telefonoQuienSolicita'},
				{ name:'emailQuienSolicita'},
				{ name:'flejado'},
				{ name:'transportista'},
				{ name:'isdevolucion'},
				{ name:'isrevisado'},
				{ name:'isenviadocte'},
				{ name:'isrechazado'},
				{ name:'isliberado'},
				{ name:'isexistenota'},
				{ name:'remitente'},
				{name: 'destinatario' },
				{ name:'encargado'},
				{ name:'idAutonumerico'},
				{ name:'idAutonumericoAlmacen'},
				{ name:'idAutonumericoTipoAlmacen'},
				{ name:'tipoDireccion'},
				{ name:'estatus'},
				{ name:'estatus_int'},
				{ name:'quienRecibe'},
				{ name:'fechaConfirmacion'},
				{ name:'guiainternacional'},
				{ name:'es_nacional'},
				{ name:'tiporecepcion'},
				{ name:'latitud'},
				{ name:'longitud'},
				{ name:'idguiamadremultiple'},
				{ name:'descripcionError'},
				{ name:'razonsocial'}
					
		  
		],
		 hasMany: [
			{
			    model: 'MyDesktop.models.ModeloDestinatario',
			    name: 'destinatario', 
			    associationKey:'idDocumento'
			},
		    {
		        model: 'MyDesktop.models.ModeloRemitente',
		        name: 'remitente',
		        associationKey:'idDocumento'
		    }
		    
		    
		  ]
});