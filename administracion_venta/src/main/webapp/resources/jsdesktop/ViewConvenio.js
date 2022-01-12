/*!
 *Contiene el funcionamiento para la administracion de los descuentos
 */

Ext.define('MyDesktop.ViewConvenio', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'convenio-win',

    init : function(){
        this.launcher = {
            text: 'Convenio',
            iconCls:'convenio_blue'
        }
    },
    meses:undefined,
	grid_adicionales:undefined,
	grid_lineas:undefined,
    grid_convenios:undefined,
    form_convenios:undefined,
    form_firmas:undefined,
    form_datosrevision:undefined,
	myScope:undefined,
	combo_tipos_busqueda:undefined,
	grid_materialempaque:undefined,
	grid_detalle_rango_descuentoxfactura:undefined,

	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope=this;
		
		
		
		
		
		this.grid_lineas= Ext.create('MyDesktop.view.GridCotizacionDetalle' ,
				{title: 'L�neas', iconCls:'lineas_blue',
					disabled:!checkEnable('solo.actualiza.numcliente.en.convenio')
				}
		); 
		
		this.grid_adicionales= Ext.create('MyDesktop.view.GridTarifaAdicional',
				{ title: 'Adicionales',  iconCls: 'catalogos_blue',
					disabled:!checkEnable('solo.actualiza.numcliente.en.convenio')
				}
		); 
		
		this.grid_materialempaque= Ext.create('MyDesktop.grid.GridMaterialEmpaque',
				{ title: 'Material Empaque',  iconCls: 'catalogos_blue',
					disabled:!checkEnable('solo.actualiza.numcliente.en.convenio')
				}
		); 
		
		this.grid_detalle_rango_descuentoxfactura= Ext.create('MyDesktop.grid.GridDescuentoFactura',
				{ispantallaconvenio:true, title:'Rango de Descuentos por Facturaci�n',
					disabled:!checkEnable('solo.actualiza.numcliente.en.convenio')
				}); 
		//idconvenio:undefined,
		//ispantallaconvenio:false,
        if(!win){
        	
        	//Define las busquedas para los descuentos
			this.meses= Ext.create('Ext.form.ComboBox', {
				fieldLabel: '',
				 width: 150,
				disabled: false,
				editable:false,
				//forceSelection:true,
				store: Ext.create('MyDesktop.store.StoreMeses',{}) ,
				queryMode: 'local',
				emptyText: '',
				displayField: 'descripcion',
				valueField: 'idtipo'
			});
			
        	//Define las busquedas para los descuentos
			this.combo_tipos_busqueda= Ext.create('Ext.form.ComboBox', {
				fieldLabel: '',
				 width: 150,
				disabled: false,
				editable:false,
				//forceSelection:true,
				store: Ext.create('MyDesktop.store.StoreTiposBusquedaCotizacion',{}) ,
				queryMode: 'local',
				emptyText: 'Seleccione orden',
				displayField: 'descripcion',
				valueField: 'idtipo'
			});
			this.combo_tipos_busqueda.setValue("05");
			//this.combo_tipos_busqueda.setRawValue("Ref.B�squeda");
	
			this.grid_cotizaciones = new MyDesktop.view.GridConvenios({
					autoScroll: true,
					forceFit    : true,
					scrollOffset: 0,
					getTotalWidth: function() {
						return "auto";
					}
	  
			});
			this.grid_cotizaciones.getSelectionModel().on('selectionchange', function(sm, selectedRecord) {
				 if (selectedRecord.length) {
					 //Actualiza los datos de lineas y adicionales
					 var permiteacceso = selectedRecord[0].data.estatus=='3'?false:true;
					 this.grid_lineas.loadInfoWithId(selectedRecord[0].data.idconvenio,permiteacceso);
					 this.grid_adicionales.loadInfoWithId(selectedRecord[0].data.idconvenio,permiteacceso);
					 this.grid_materialempaque.loadInfoWithId(selectedRecord[0].data.idconvenio,permiteacceso);
					 
					 var rows = sm.getSelection();
					 this.form_convenios.updateCampos(rows[0]);
					 
					 this.form_firmas.updateCampos(rows[0]); 
					 this.form_datosrevision.updateCampos(rows[0]); 
					 
				
					 this.grid_detalle_rango_descuentoxfactura.setIdConvenio(selectedRecord[0].data.idconvenio);
					 this.grid_detalle_rango_descuentoxfactura.buscarDatos(selectedRecord[0].data.idconvenio);

				 }
			},this);
			
			this.grid_cotizaciones.getSelectionModel().on('selected', function(sm, selectedRecord) {
				 if (selectedRecord.length) {
					 //Actualiza los datos de lineas y adicionales
					 var permiteacceso = selectedRecord[0].data.estatus=='3'?false:true;
					 this.grid_lineas.loadInfoWithId(selectedRecord[0].data.idconvenio,permiteacceso);
					 this.grid_adicionales.loadInfoWithId(selectedRecord[0].data.idconvenio,permiteacceso);
					 this.grid_materialempaque.loadInfoWithId(selectedRecord[0].data.idconvenio,permiteacceso);
					 
					 var rows = sm.getSelection();
					 this.form_convenios.updateCampos(rows[0]);
					 
					 this.form_firmas.updateCampos(rows[0]); 
					 this.form_datosrevision.updateCampos(rows[0]); 
				
					 this.grid_detalle_rango_descuentoxfactura.setIdConvenio(selectedRecord[0].data.idconvenio);
					 this.grid_detalle_rango_descuentoxfactura.buscarDatos(selectedRecord[0].data.idconvenio);
					
				 }
			},this);
			
			
			this.form_convenios = new MyDesktop.view.FormConvenio({
				  title: 'Datos Convenio', iconCls: 'convenio_blue',operacion:'update',
				  enebleSaveOnlyNumClient:tieneOpcion('solo.actualiza.numcliente.en.convenio')
			});
		
			this.form_firmas = new MyDesktop.view.FormFirmasAutorizacionCotizacion({
				  title: 'Datos Firmas', iconCls: 'signature_blue',operacion:'update',main_grid:this,
				  disabled:!checkEnable('solo.actualiza.numcliente.en.convenio')
			});
			
		
			this.form_datosrevision = new MyDesktop.view.FormDireccionRevision({
				  title: 'Datos Revisi�n', iconCls: 'auto_archivo_blue',operacion:'update',scope_view_pricipal:this,
				  disabled:!checkEnable('solo.actualiza.numcliente.en.convenio')
			});
			
			var misdeatlles = Ext.create('widget.window', {
	  				title: 'Caracteristicas Convenio ',  //+ rows[0].get('idconvenio')+ '</em> ',
	  				width: 750,
	  				height: 400,
	  				modal:true,
	  				closable: false,
	  				maximized :true,
	  				plain: true,
	  				headerPosition: 'right',
	  			  layout: 'fit',
	  				items: [
	  				        {
							    xtype: 'tabpanel',
							    plain: true,
							    region: 'center',
							    margins: '0 5 5 5',
							    activeTab: 0,
								layout: 'fit',
								   tabPosition: 'bottom',
							    items: [
							            this.form_convenios  ,
					                    this.grid_lineas,this.grid_adicionales,
					                    this.form_datosrevision,this.form_firmas,
					                    this.grid_materialempaque,
					                    this.grid_detalle_rango_descuentoxfactura
							      ]
	  				        	}
	  				        ],
					bbar:[
					      {xtype:'tbfill'},
						  {text:'Cerrar Ventana', handler:function(){
							  misdeatlles.hide();
						  	}
					      }]
				});
			
			
		    win = desktop.createWindow({
				
                id: this.id,
                title:'Convenio',
                iconCls: 'convenio_blue',
                //animCollapse:false,
                border:false,
                constrainHeader:false,
                closable: true,
                closeAction: 'hide',
				width: 1300,
                minWidth: 350,
            	maximized :true,
				maximizable:false,
                height: 700,
				layout: 'fit',
  				items:[
  				       
  					
  						{
  				                  
  				                     height: 300,
  				                     maxSize: 150,
  				                     layout: 'fit',
  				                     margins: '5 5 0 5',
  				                     bodyStyle: 'padding:10px;',
  				                     split: true,
	  				                   tbar:[
	  					  					{xtype: 'label', text:'Buscar por:'	},
	  					  					this.combo_tipos_busqueda,
	  					  					{xtype: 'label', text:'Patr�n:'	},
	  					  					{xtype: 'myUpperCaseTextField' , id:'idpatronbusquedaconvenio', allowBlank: false, width: 100},
	  					  					{xtype: 'label', text:'Mes:'	},
	  					  					this.meses,
	  					  					{
	  								            xtype: 'datefield',
	  								            id:'idfechadocumentoconvenio',
	  								            fieldLabel: 'Fecha',
	  								            name:'fechainicialcotizacion',
	  								            format: 'd-m-Y',
	  								            labelWidth: 80,
	  								            width: 190
	  					  					}, 
	  					  					
	  					  					{ iconCls: 'buscar_blue',handler:this.filtrar, scope:this.myScope},
	  					  					{ text:'Mostrar Datos Convenio',scope:this.myScope,handler:function(){
	  					  							var rows =  this.grid_cotizaciones.getSelectionModel().getSelection();
	  					  							if(rows.length <=0){
			  					  			     		mensajeAlert("Debe de Seleccionar un registro existente. ");
			  					  			     		return;
			  					  			     	}
			  					  					if(rows.length >1){
			  					  			     		mensajeAlert("Seleccione solamente un registro. ");
			  					  			     		return;
			  					  			     	}
			  					  					
				  					  				if (rows[0].get('estatus')==ESTATUS_INACTIVA){
					  					  				mensajeAlert("Registro esta dado de baja operación inválida.");
					  					  	     		return;
					  					  			}
		
					  					  			if(rows[0].get('estatus') ==ESTATUS_CERRADO){
					  					  	     		mensajeAlert("Registro " + rows[0].get('nombre') + " fue cerrado previamente, operación inválida");
					  					  	     		return;
					  					  	     	}
						  					  		if(rows[0].get('estatus') ==ESTATUS_AUTORIZADO){
						  								mensajeAlert("Cotización ya autorizada, operación inválida");
						  					     		return;
						  					     	}
					  					  				misdeatlles.show();
			  					  				
	  					  						
	  					  						}
	  					  					},
	  					  				 {xtype: 'tbfill'},
	  					  					{
	  					  						xtype: 'buttongroup', // <--- grouping the buttons
	  					  						border:false,
	  					  						items:[
	  													{ text:'Cierra convenio', tooltip: 'Cierra una cotización que no pudo ser completada',
	  														iconCls: 'garbage_red',disabled:checkEnable('sistema.btn.cerrar.convenio'),
	  														handler:this.cerrar, scope:this.myScope },
	  														{xtype:'tbseparator'},
	  					  			  					{ tooltip: 'Mostrar PDF',iconCls: 'pdf_blue',handler:this.showPDFDetails, scope:this.myScope },
	  					  			  					{ tooltip: 'Atar Archivo',iconCls: 'attach_blue',handler:this.showAttachment, scope:this.myScope },
	  					  			  					{ tooltip: 'Enviar Email',iconCls: 'user_email_blue',handler:this.sendMail, scope:this.myScope },
	  					  			  					{ tooltip: 'Historia/Movimientos',iconCls: 'history_blue',handler:this.showHistory, scope:this.myScope }
	
	  					  						       ]
	  					  					}
	  					  			],
	  					  			bbar:[ 
	  					  			     { text: 'Autorizar',disabled:checkEnable('sistema.btn.autorizar.convenio'),
	  					  			    	 iconCls: 'estatus40',handler:this.autorizar,scope:this.myScope },
	  					  			     {xtype:'tbseparator'},	 
	  					  			     { text: 'A Documentación',disabled:checkEnable('sistema.btn.a.documentacion.convenio'),
		  					  			    	 iconCls: 'estatus20',handler:this.adocumentacion,scope:this.myScope },
		  					  			 {xtype:'tbseparator'},   	 
		  					  			 { text: 'A Revisión',disabled:checkEnable('sistema.btn.a.revision.convenio'),
			  					  			    	 iconCls: 'estatus30',handler:this.arevision,scope:this.myScope },     	 
	  					  			      {xtype: 'tbfill'},
	  									//{ text: 'Modificar',iconCls: 'editar',handler:this.modificar,scope:this.myScope },
	  					  			  //{xtype:'tbseparator'},
	  									//{ text: 'Desactivar',iconCls: 'borrar',handler:this.desactivar,scope:this.myScope },
	  									//{ text: 'Activar',iconCls: 'activo',handler:this.activar,scope:this.myScope },
	  					  			  //{xtype:'tbseparator'},
	  									 { text: 'Reasignar',disabled:checkEnable("sistema.btn.reasignar.convenio"),
						  			    	 iconCls: 'man_blue',handler:this.reasignar,scope:this.myScope }
	
	  					  				],
  				                     items:[this.grid_cotizaciones]
  				                 }
  				       
  				       
  				  ]
            });
			
			
        }
        return win;
    },
    
    adocumentacion:function(){
		var rows =  this.grid_cotizaciones.getSelectionModel().getSelection();
    	if (rows[0].get('estatus')==ESTATUS_INACTIVA){
			mensajeAlert("Registro esta dado de baja operación inválida.");
     		return;
		}
		if(rows[0].get('estatus') ==ESTATUS_CERRADO){
     		mensajeAlert("Registro " + rows[0].get('nombre') + " fue cerrado previamente, operación inválida");
     		return;
     	}
		this.grid_cotizaciones.cambiaestatus(ESTATUS_EN_DOCUMENTACION,this);
	},
	arevision:function(){
		var rows =  this.grid_cotizaciones.getSelectionModel().getSelection();
    	if (rows[0].get('estatus')==ESTATUS_INACTIVA){
			mensajeAlert("Registro esta dado de baja operación inválida.");
     		return;
		}
		if(rows[0].get('estatus') ==ESTATUS_CERRADO){
     		mensajeAlert("Registro " + rows[0].get('nombre') + " fue cerrado previamente, operación inválida");
     		return;
     	}
		
		this.grid_cotizaciones.cambiaestatus(ESTATUS_REVISION,this);
	},
	cerrar:function(){
		var rows =  this.grid_cotizaciones.getSelectionModel().getSelection();
    	if (rows[0].get('estatus')==ESTATUS_INACTIVA){
			mensajeAlert("Registro esta dado de baja operación inválida.");
     		return;
		}
		if(rows[0].get('estatus') ==ESTATUS_CERRADO){
     		mensajeAlert("Registro " + rows[0].get('nombre') + " fue cerrado previamente, operación inválida");
     		return;
     	}
		
		this.grid_cotizaciones.cerrar(this);
	},
    autorizar:function(){
    	var rows =  this.grid_cotizaciones.getSelectionModel().getSelection();
    	if (rows[0].get('estatus')==ESTATUS_INACTIVA){
			mensajeAlert("Registro esta dado de baja operación inválida.");
     		return;
		}
		if(rows[0].get('estatus') ==ESTATUS_CERRADO){
     		mensajeAlert("Registro " + rows[0].get('nombre') + " fue cerrado previamente, operación inválida");
     		return;
     	}
		this.grid_cotizaciones.autorizar(this);
	},
	
	
	agregar:function(){
		this.grid_cotizaciones.agregar();
	},
	modificar:function(){
		this.grid_cotizaciones.modificar(this);
	},
	eliminar:function(){
		this.grid_cotizaciones.eliminar();
	},
	
	filtrar:function(){
	    	var fecha  = Ext.getCmp('idfechadocumentoconvenio').getRawValue();
	    	var patron  = Ext.getCmp('idpatronbusquedaconvenio').getValue();
	    	var tipo_busqueda = this.combo_tipos_busqueda.getValue();
	    	
	    	
	    	
	    	var mes = this.meses.getValue()==undefined?'':this.meses.getValue();
	    	
	    	if (tipo_busqueda == '03'){
	    		if  (fecha.trim().length<=0){ 
	    			alertMsg("Verifique", "Capture la fecha del documento.");
	    			return;	
	    		}
	    	}else if (tipo_busqueda == '05'){
	    			
		    		if  (mes.trim().length<=0){ 
		    			mensajeAlert("Seleccione un mes de la lista disponible.");
		    			return;	
		    		}	
	    	}else{
	    		if  (patron.trim().length<=0){ 
	    			mensajeAlert("Capture el dato que desea buscar.");
	    			return;	
	    		}
	    	}
	    	this.grid_cotizaciones.buscar(tipo_busqueda,fecha,patron,mes);
	    },
    desactivar:function(){
		this.grid_cotizaciones.desactivar(this);
	},
	activar:function(){
		this.grid_cotizaciones.activar(this);
	},
	sendMail:function(){
		
		var rows =  this.grid_cotizaciones.getSelectionModel().getSelection();
     	if(rows.length <=0){
     		mensajeAlert("Debe de Seleccionar un registro existente. ");
     		return;
     	}
		if(rows.length >1){
     		mensajeAlert("Seleccione solamente un registro. ");
     		return;
     	}
		if (rows[0].get('estatus')==ESTATUS_INACTIVA){
			mensajeAlert("Registro esta dado de baja operación inválida.");
     		return;
		}

		if(rows[0].get('estatus') ==ESTATUS_CERRADO){
     		mensajeAlert("Registro " + rows[0].get('nombre') + " fue cerrado previamente, operación inválida");
     		return;
     	}
		//Crea la ventana para el envio de correo
		//Crea una forma de clientes para agregar los datos
		var forma_sendmail_cotizacion = Ext.create('MyDesktop.view.FormSendMail',
				{
					url_sender:'../cotizacionpreconvenio/sendMail', 
					idconvenio:rows[0].get('idconvenio')
				}); 
		var win_archivos_adjuntos = Ext.create('widget.window', {
			title: "Envio Notificaci�n Cotizaci�n Cliente",
			width: 500,
			height: 300,
			iconCls:'user_email_blue',
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: forma_sendmail_cotizacion
			
		}).show();
		
	},
	showPDFDetails:function(){

		var rows =  this.grid_cotizaciones.getSelectionModel().getSelection();
     	if(rows.length <=0){
     		mensajeAlert("Debe de Seleccionar registro a visualizar. ");
     		return;
     	}
		if(rows.length >1){
     		mensajeAlert("Seleccione solamente un registro a visualizar. ");
     		return;
     	}
		
		visorPDF(
				'utils-win-vistaprevia-pdf_file_cotizacion'+ rows[0].get('idconvenio')+rows[0].get('fechadocumento'),
				"Visor PDF: " + rows[0].get('nombre'),
				"../convenio/viewPDFArchivo?idconvenio="+rows[0].get('idconvenio'));

		
	},
	showAttachment:function(){
		var rows =  this.grid_cotizaciones.getSelectionModel().getSelection();
     	if(rows.length <=0){
     		mensajeAlert("Debe de seleccionar un registro a visualizar. ");
     		return;
     	}
		if(rows.length >1){
     		mensajeAlert("Seleccione solamente un registro a visualizar. ");
     		return;
     	}
		
		var identificador_str = rows[0].get('idconvenio')+","+ rows[0].get('idcotizacionorigen');
		var tipodocto_str = "COTIZACION,CONVENIO";
		var grid_historia_attachement = new MyDesktop.view.GridAttachment({
			autoScroll: true,
			forceFit    : true,
			isConsulta:false,
			idtipodocumento: rows[0].get('estadoactualdoc') ,
			identificador:rows[0].get('idconvenio'),
			ids_str:identificador_str,
			tipos_docs_str:tipodocto_str, 
			scrollOffset: 0,
			getTotalWidth: function() {
				return "auto";
			}
		});

		
		grid_historia_attachement.loadInfo();
		
		var win_archivos_adjuntos = Ext.create('widget.window', {
			id:'utils-win-agregar-cliente',
			title: "Archivos Adjuntos",
			width: 800,
			height: 350,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: grid_historia_attachement
			
		});
		
		win_archivos_adjuntos.show();
		
	},
	showHistory:function(){
		var rows =  this.grid_cotizaciones.getSelectionModel().getSelection();
     	if(rows.length <=0){
     		mensajeAlert("Debe de Seleccionar solo un registro a visualizar. ");
     		return;
     	}
		if(rows.length >1){
     		mensajeAlert("Seleccione solamente un registro a visualizar. ");
     		return;
     	}
		
		var columnas =  [
			{text     : 'Movimiento',width: 100,sortable : false,dataIndex: 'tipomovimiento'},
			{text     : 'Fecha',width: 100,sortable : false,dataIndex: 'fecha'},
			{text     : 'Usuario',width: 80,sortable : false,dataIndex: 'login'},
			{text     : 'Observacion',width: 120,sortable : false,dataIndex: 'observacion'}
			
			];
		grid_historia_cotizaciones = new MyDesktop.view.GridHistoria({
			autoScroll: true,
			columnas:columnas,
			forceFit    : true,
			scrollOffset: 0,
			getTotalWidth: function() {
				return "auto";
			}

		});
		grid_historia_cotizaciones.loadInfo();
		
		var win_historia = Ext.create('widget.window', {
			id:'utils-win-agregar-cliente',
			title: "Modificar Datos Cotizaci�n",
			width: 800,
			height: 350,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: grid_historia_cotizaciones
			
		});
		var parametros = {idconvenio:rows[0].get('idconvenio')};
		//Si se desea cambiar el URL que despacha la solicitud
		//grid_historia_cotizaciones.getStore.getProxy().url = '';
		grid_historia_cotizaciones.buscar(parametros);
		
		win_historia.show()
		
	},
	showDetails:function(){
		var rows =  this.grid_cotizaciones.getSelectionModel().getSelection();
     	if(rows.length <=0){
     		mensajeAlert("Debe de Seleccionar solo un registro a visualizar. ");
     		return;
     	}
		if(rows.length >1){
     		mensajeAlert("Seleccione solamente un registro a visualizar. ");
     		return;
     	}

		if (rows[0].get('estatus')==ESTATUS_INACTIVA){
			mensajeAlert("Registro esta dado de baja no puede ser modificado. ");
     		return;
		}
		if(rows[0].get('estatus') ==ESTATUS_CERRADO){
     		mensajeAlert("Registro " + rows[0].get('nombre') + " fue cerrado previamente, operación inválida");
     		return;
     	}
		if(rows[0].get('tipo_precios')==1){
			mensajeAlert("Cotizaci�n configurada con toda la lista de precios, no es permitido el detalle.");
     		return;
     	}
		
		var isconsulta = rows[0].get('estatus')==ESTATUS_AUTORIZADO?true:false;
		
		//Crea una forma de clientes para agregar los datos
		var grid_detalle_conveio_precios= Ext.create('MyDesktop.view.GridCotizacionDetalle',
				{
					id:this.id+'grid_convenio_detalle',
					isConsulta:isconsulta,
					idconvenio:rows[0].get('idconvenio'),
					idrangoenvios:rows[0].get('idrangoenvios')
				}
		); 
		grid_detalle_conveio_precios.loadInfo();
		var myscope = this;
		//grid_rangos_tarifa_servicio_adicional.buscar();
		//forma_showdetails.updateFieldReadOnly(rows[0]);
		var win__detalle_conveio_precios = Ext.create('widget.window', {
			id:'utils-win-grid_adicionales_para_tarifa',
			title: "Detalles Lineas ",
			width: 1000,
			height: 400,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: grid_detalle_conveio_precios,
			
		});
		win__detalle_conveio_precios.show();
		
	},
	showDetailsAdicionales:function(){
		var rows =  this.grid_cotizaciones.getSelectionModel().getSelection();
     	if(rows.length <=0){
     		mensajeAlert("Debe de Seleccionar solo un registro que desea visualizar");
     		return;
     	}
		if(rows.length >1){
			mensajeAlert("Seleccione solamente un registro.");
     		return;
     	}

		if (rows[0].get('estatus')==ESTATUS_INACTIVA){
			mensajeAlert("Registro esta dado de baja no puede ser modificado. ");
     		return;
		}

		if(rows[0].get('estatus') ==ESTATUS_CERRADO){
     		mensajeAlert("Registro " + rows[0].get('nombre') + " fue cerrado previamente, operación inválida");
     		return;
     	}
		/*for(i=0;i<rows.length;i++){
     		if(rows[i].get('estatus') ==2){
         		Ext.Msg.alert('Verificar',"Registro " + rows[i].get('nombre') + " fue convertido a un convenio, operación inválida");
         		return;
         	}
    		
     	}*/
		//verifica si la operacion solo es de consulta cuando ya se 
		//cuando ya se ha autorizado
		var isconsulta = rows[0].get('estatus')==ESTATUS_AUTORIZADO?true:false;
		
		//Crea una forma de clientes para agregar los datos
		var grid_rangos_tarifa_servicio_adicional= Ext.create('MyDesktop.view.GridTarifaAdicional',
				{
					id:'showdetails_tarifa_rango_id',
					isConsulta:isconsulta,
					idconvenio:rows[0].get('idconvenio'),
					idservicio:rows[0].get('idservicio'),
					idformapago:rows[0].get('idformapago')
				}
		); 
		
		Ext.create('widget.window', {
			id:'utils-win-agregar-tarifa-rango-serv-adicional',
			title: "Detalles Adicionales: "+rows[0].get('nombre'),
			width: 750,
			height: 400,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: grid_rangos_tarifa_servicio_adicional
		}).show();
	},
	reasignar:function(){
		this.grid_cotizaciones.reasignar(this);
	}
	/*transformar:function(){
		var rows =  this.grid_cotizaciones.getSelectionModel().getSelection();
	 	if(rows.length <=0){
	 		mensajeAlert("Debe de Seleccionar un registro existente. ");
	 		return;
	 	}
		if(rows.length >1){
	 		mensajeAlert("Seleccione solamente un registro. ");
	 		return;
	 	}
		if (rows[0].get('estatus')==ESTATUS_INACTIVA){
			mensajeAlert("Registro esta dado de baja operación inválida.");
	 		return;
		}
		if(rows[0].get('estatus') ==ESTATUS_CERRADO){
	 		mensajeAlert("Registro " + rows[0].get('nombre') + " fue cerrado previamente, operación inválida");
	 		return;
	 	}
		
	 	for(i=0;i<rows.length;i++){
	 		if(rows[i].get('estatus') ==ESTATUS_TRANSFORMACION_CONVENIO){
	 			mensajeAlert("Registro " + rows[i].get('nombre') + " ya fue convertido a un convenio, operación inválida");
	     		return;
	     	}
			
	 	}
		
		var my_scope= this;
		var conn = new Ext.data.Connection();
		var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Agregando informaci�n espere..."});
		myMask.show();
			conn.request({
					scope:my_scope, 
				url: '../cotizacionpreconvenio/transformaAConvenio' ,
				params:{idconvenio:rows[0].get('idconvenio')},
				success: function(response, opts) {
					myMask.hide( );
					myMask.disable();
					
					var obj = Ext.decode(response.responseText);
					if (obj.idconvenio!=undefined){
						mensajeConfirm( action.result.message);
					}
					
					my_scope.filtrar();
				},
				failure: function(response, opts) {
	       			if (response.responseText!=undefined){
	       				var obj = Ext.decode(response.responseText);
	       				if (obj.message!=undefined){
	       					mensajeAlert(obj.message);
		       			}
		       		}
	   			
				}
			});  
		
	},*/
});
