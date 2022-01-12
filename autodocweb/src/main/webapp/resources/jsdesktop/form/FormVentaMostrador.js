Ext.define('MyDesktop.form.FormVentaMostrador', {
    extend: 'Ext.form.Panel',
    xtype: 'venta-mostrador-form',
    
    method:'POST',
    frame: false,
	border:false,
   // title: 'Register',
    bodyPadding: 10,
    autoScroll:true,
    width: 355,
   
    myscope:undefined,
    showReadOnly:false,
    operacion:undefined,
    idconvenio:undefined,
    scope_view_pricipal:undefined,
    fieldDefaults: {
        labelAlign: 'right',
        labelWidth: 115,
        msgTarget: 'side'
    },
    bodyPadding: 5,
    grid_adicionales:undefined,
    initComponent: function() {
    	
    	var operacion_aplicar = this.operacion;
    	var iseditablle =this.operacion=='update'?true:false;
    	
    	this.myscope= this;
    	var scopemy = this;
    	var scope_grid_pricipal = this.scope_view_pricipal;
    	
    	var  grid_adicionales =  Ext.create('MyDesktop.grid.GridAdicional',{
    		isConsulta:true,border:true, layout:'fit', height:200,width:200,
    		margins: '0 0 0 5'
    		
    	}); 
    	
    	this.grid_paquetes =  Ext.create('MyDesktop.grid.GridPaquetesDimensiones',{
    		isConsulta:true,border:true, layout:'fit', height:200,width:650,
    		margins: '0 0 0 5', columnWidth:.69
    		
    	}); 
	
    	this.bbar= [
    	     {xtype: 'tbfill'},   
         	{xtype: 'tbseparator'},
         	{text:'Limpiar'}, 
         	{xtype: 'tbseparator'},
			{text:'Calcular Precios'},    
    	     
            {
  	        	hidden:this.showReadOnly,
	  			text: 'Salvar',
	  			disabled: true,
	  			formBind: true,
	  			iconCls:'activo',
	  			handler:function() {
  					var form = this.up('form').getForm();
  					
  					if ( scopemy.getValueField('estatus')=='3'){
  						mensajeAlert("Convenio ya fue autorizado, no puede modificar datos");
  						return;
  					} 
  						if (form.isValid()) {
  							var out = [];
  							Ext.Object.each(form.getValues(), function(key, value){
  								out.push(key + '=' + value);
  							});
  							var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Actualizando informacion información espere..."});
  							myMask.show();

  							
  							form.submit({
  								clientValidation: true,
  								url: './convenio/' + operacion_aplicar,
  								success: function(form, action) {
  									myMask.hide( );
  									myMask.disable();
  									
  									if (action.result.cotizacion!=undefined){
  										mensajeConfirm("Se creo la cotización:" + action.result.cotizacion);
  									}else{
  										mensajeConfirm(action.result.message);
  										scope_grid_pricipal.filtrar();
  										
  									}
  									
  									if (operacion_aplicar=='update'){
  										if (scope_grid_pricipal!=undefined){
  											scope_grid_pricipal.filtrar();
  										}
  										
  									}
  									
  									if (operacion_aplicar=='insert'){
  										form.reset();
  									}
  									
  				
  								},
  								failure: function(form, action) {
  									myMask.hide( );
  									myMask.disable();
  									if ( (action.result!=undefined) && (action.result.message!=undefined)){
  										mensajeAlert(action.result.message);
  									}else{
  										//Busca si existe un response del servier
  										if (action.response.responseText!=null){
  											mensajeAlert( action.response.responseText);
  										}
  									}
  									
  								}
  							});
  						
  							
  						}else{
  							mensajeAlert('Complete los campos requeridos.');
  						}
  					}
  					  
            	}
            ];

	    this.items = [{
	            layout:'column',
	            items:[


						{
								xtype: 'fieldset',
								columnWidth:.3,
								title: 'Datos Remitente/Destino',
								defaultType: 'textfield',
								
								defaults: {
									anchor: '100%'
								},
								items: [
								  {xtype : 'hidden', name:"_csrf", value:vt},
								        {
						       				xtype: 'fieldset',
						       				title: 'Remitente',
						       				defaultType: 'textfield',
						       			
						       				defaults: {
						       					anchor: '100%'
						       				},
						       				items: [
													{  xtype: 'myUpperCaseTextField', name: 'razonsocial',emptyText: 'Razón Social',allowBlank: false,enforceMaxLength:true,maxLength:40},
													{  xtype: 'myUpperCaseTextField', name: 'atencion',emptyText: 'Atención',allowBlank: false,enforceMaxLength:true,maxLength:40},
													{  xtype: 'myUpperCaseTextField', name: 'rfc',emptyText: 'R.F.C',allowBlank: false,enforceMaxLength:true,maxLength:40},
													{  xtype: 'myUpperCaseTextField', name: 'calle',emptyText: 'Calle',allowBlank: false,enforceMaxLength:true,maxLength:40},
													{
														xtype: 'fieldcontainer',
														labelStyle: 'font-weight:bold;padding:0',
														layout: 'hbox',
														emptyText: 'Calle',
														defaultType: 'textfield',
														fieldDefaults: {
															labelAlign: 'top'
														},
														items: [
															{  xtype: 'myUpperCaseTextField',flex: 1, name: 'numexterior', emptyText:'Num. Exterior', allowBlank: false,enforceMaxLength:true,maxLength:10},
														   
															{  xtype: 'myUpperCaseTextField',flex: 2, name: 'numinterior', emptyText:'Num. Interior', allowBlank: true, margins: '0 0 0 5',enforceMaxLength:true,maxLength:10},
															{  xtype: 'myUpperCaseTextField',flex: 1, name: 'cp', emptyText:'C.P.', allowBlank: false, margins: '0 0 0 5',enforceMaxLength:true,maxLength:5 },
															{ xtype:'button', margins: '0 0 0 5',  iconCls:'buscar_white',id:'btnBuscarCPRem_'+this.id,
																handler: this.myscope.showGridCps,scope:this
															}
														]
													},
													{
														xtype: 'fieldcontainer',
														labelStyle: 'font-weight:bold;padding:0',
														layout: 'hbox',
														defaultType: 'textfield',
														fieldDefaults: {
															//labelAlign: 'top'
														},
														items: [
															{   xtype: 'myUpperCaseTextField',flex: 1, name: 'colonia', emptyText:'Colonia', allowBlank: false,enforceMaxLength:true,maxLength:40 },
															{ xtype:'button',  margins: '0 0 0 5',  iconCls:'buscar_white',id:'btnBuscarColoniaRem_'+this.id,
																handler: this.myscope.showGridCps,scope:this
															}
														]
													}, 
													{
														xtype: 'fieldcontainer',
														labelStyle: 'font-weight:bold;padding:0',
														layout: 'hbox',
														defaultType: 'textfield',
														fieldDefaults: {
															//labelAlign: 'top'
														},
														items: [
															{   xtype: 'myUpperCaseTextField',flex: 1, name: 'municipio', emptyText:'Del/Mun', allowBlank: false, margins: '0 0 0 5',enforceMaxLength:true,maxLength:40},
															{ xtype:'button',  margins: '0 0 0 5',  iconCls:'buscar_white',id:'btnBuscarMunicipioRem_'+this.id,
																handler: this.myscope.showGridCps,scope:this
															}
														]
													}, 
													{  xtype: 'myUpperCaseTextField',flex: 1, name: 'estado', emptyText:'Estado', allowBlank: false,enforceMaxLength:true,maxLength:40 },
													{  xtype: 'myUpperCaseTextField',flex: 1, xtype: 'textfield',margins: '0 0 0 5',emptyText:'Email',name: 'email',
														vtype: 'email',allowBlank: true,enforceMaxLength:true,maxLength:40},
													
													{  xtype: 'myUpperCaseTextField',flex: 1,name: 'telefono',emptyText:'Teléfono',allowBlank: true,enforceMaxLength:true,maxLength:40},
													{  xtype: 'myUpperCaseTextField',flex: 1,margins: '0 0 0 5',emptyText:'Móvil',name: 'movil',allowBlank: true,enforceMaxLength:true,maxLength:20}
						       				]
						       			},
						    	        {
						       				xtype: 'fieldset',
						       				title: 'Destino',
						       				defaultType: 'textfield',
						       				defaults: {
						       					anchor: '100%'
						       				},
						       				items: [
													{  xtype: 'myUpperCaseTextField', name: 'razonsocial',emptyText: 'Razón Social',allowBlank: false,enforceMaxLength:true,maxLength:40},

													{  xtype: 'myUpperCaseTextField', name: 'calle',emptyText: 'Calle',allowBlank: false,enforceMaxLength:true,maxLength:40},
													{
														xtype: 'fieldcontainer',
														labelStyle: 'font-weight:bold;padding:0',
														layout: 'hbox',
														emptyText: 'Calle',
														defaultType: 'textfield',
														fieldDefaults: {
															labelAlign: 'top'
														},
														items: [
															{  xtype: 'myUpperCaseTextField',flex: 1, name: 'numexterior', emptyText:'Num. Exterior', allowBlank: false,enforceMaxLength:true,maxLength:10},
														   
															{  xtype: 'myUpperCaseTextField',flex: 2, name: 'numinterior', emptyText:'Num. Interior', allowBlank: true, margins: '0 0 0 5',enforceMaxLength:true,maxLength:10},
															{  xtype: 'myUpperCaseTextField',flex: 1, name: 'cp', emptyText:'C.P.', allowBlank: false, margins: '0 0 0 5',enforceMaxLength:true,maxLength:5 },
															{ xtype:'button', margins: '0 0 0 5',  iconCls:'buscar_white',id:'btnBuscarCP_'+this.id,
																handler: this.myscope.showGridCps,scope:this
															}
														]
													},
													{
														xtype: 'fieldcontainer',
														labelStyle: 'font-weight:bold;padding:0',
														layout: 'hbox',
														defaultType: 'textfield',
														fieldDefaults: {
															labelAlign: 'top'
														},
														items: [
															{   xtype: 'myUpperCaseTextField',flex: 1, name: 'colonia', emptyText:'Colonia', allowBlank: false,enforceMaxLength:true,maxLength:40 },
															{ xtype:'button',  margins: '0 0 0 5',  iconCls:'buscar_white',id:'btnBuscarColonia_'+this.id,
																handler: this.myscope.showGridCps,scope:this
															}
														]
													}, 
													
													{
														xtype: 'fieldcontainer',
														labelStyle: 'font-weight:bold;padding:0',
														layout: 'hbox',
														defaultType: 'textfield',
														fieldDefaults: {
															labelAlign: 'top'
														},
														items: [
															
															{   xtype: 'myUpperCaseTextField',flex: 1, name: 'municipio', emptyText:'Del/Mun', allowBlank: false, margins: '0 0 0 5',enforceMaxLength:true,maxLength:40},
															{ xtype:'button',  margins: '0 0 0 5',  iconCls:'buscar_white',id:'btnBuscarMunicipio_'+this.id,
																handler: this.myscope.showGridCps,scope:this
															}
														]
													}, 
													{  xtype: 'myUpperCaseTextField',flex: 1, name: 'estado', emptyText:'Estado', allowBlank: false,enforceMaxLength:true,maxLength:40 },
													{  xtype: 'myUpperCaseTextField',flex: 1, xtype: 'textfield',margins: '0 0 0 5',emptyText:'Email',name: 'email',
														vtype: 'email',allowBlank: true,enforceMaxLength:true,maxLength:40},
													
													{  xtype: 'myUpperCaseTextField',flex: 1,name: 'telefono',emptyText:'Teléfono',allowBlank: true,enforceMaxLength:true,maxLength:40},
													{  xtype: 'myUpperCaseTextField',flex: 1,margins: '0 0 0 5',emptyText:'Móvil',name: 'movil',allowBlank: true,enforceMaxLength:true,maxLength:20}
						       				]
						       			}
								        
							]
						},
						scopemy.grid_paquetes,
						
						{
							xtype: 'fieldset',
		       				columnWidth:.3,
		       				width:200,
		       				title: 'Adicionales',
		       				defaultType: 'textfield',
		       				defaults: {
		       					anchor: '100%'
		       				},
		       				margins: '0 0 0 5',
		       				items: [
		       				   
		       				        grid_adicionales,
		       				     
		       				    
		       				        
		       						{
		       							xtype: 'fieldset',
		       							title: 'Datos Generales',
		       							defaultType: 'textfield',
		       							columnWidth:.3,
		       							defaults: {
		       								anchor: '100%'
		       							},
		       							items: [
		       							     {xtype: 'combobox',fieldLabel: 'Servicio',name: 'tipo_servicio',
		     									store: Ext.create('MyDesktop.store.StoreTipoContrato'),
		     									valueField: 'idtipo',
		     									forceSelection:true,
		     									displayField: 'descripcion',
		     									typeAhead: true,
		     									queryMode: 'local',
		     									emptyText: ''
		     								},
		       								
		       								{xtype:'label', html:'Covertura'},
		       								{
		       				                    xtype: 'radiogroup',
		       				                    anchor: 'none',
		       				                    layout: {
		       				                        autoFlex: false
		       				                    },
		       				                    defaults: {
		       				                        name: 'nacional',
		       				                        margin: '0 15 0 0'
		       				                    },
		       				                    items: [
		       				                            {inputValue: '1',boxLabel: 'Nacional',checked: true}, 
		       				                            {inputValue: '2',boxLabel: 'Internacional'}
		       				                    ]
		       				                },

											
		       								{ xtype: 'myUpperCaseTextArea', allowBlank:false, fieldLabel: 'Observaciones<font color=red>*</font>',
												name: 'observaciones', emptyText: '',height:50 }

		       								
		       							]
		       						}
		       				        
		       				        ]
							
						},
						
	       			
	       			{
	       				xtype: 'fieldset',
	       				columnWidth:.3,
		       				title: 'Totales',
	       				defaultType: 'textfield',
	       				defaults: {
	       					anchor: '100%'
	       				},
	       				margins: '0 0 0 5',
	       				items: [

	       						{
	       			                xtype: 'fieldset',
	       			                title: 'Forma de Pago',
	       			                layout: 'anchor',
	       			                defaults: {
	       			                    anchor: '100%'
	       			                },
	       			                items: [
	       			                        {
	       			                        	xtype: 'radiogroup',anchor: 'none',
	       			                        	layout: {autoFlex: false},
	       			                        	defaults: {name: 'ccType',margin: '0 15 0 0'},
	       			                        	items: [
	       			                        	        {inputValue: 'efctivo',boxLabel: 'EFECTIVO',checked: true}, 
	       			                        	        {inputValue: 'visa',boxLabel: 'VISA'},
	       			                        	        {inputValue: 'mastercard',boxLabel: 'MasterCard'}
	       			                        	        ]
	       			                        }, 
	       			                        {  xtype: 'textfield', name: 'ccName',fieldLabel: 'Num. Tarjeta',allowBlank: false}, 
	       			                        {
	       			                        	xtype: 'radiogroup',anchor: 'none',
	       			                        	layout: {autoFlex: false},
	       			                        	defaults: {name: 'ccType',margin: '0 15 0 0'},
	       			                        	items: [
	       			                        	        {inputValue: 'ninguna',boxLabel: 'NINGUNA',checked: true}, 
	       			                        	        {inputValue: 'ife',boxLabel: 'IFE'}
	       			                        	        ]
	       			                        },
	       			                        { xtype: 'textfield', name: 'ccNumber', fieldLabel: 'Identificación',flex: 1,
	       			                        	allowBlank: false,minLength: 15,maxLength: 16,enforceMaxLength: true,maskRe: /\d/}
	       			                  ]
	       			            },
								
												
							{
			       				xtype: 'fieldset',
			       				columnWidth:.3,
			       			
			       				title: 'Totales',
			       				defaultType: 'textfield',
			       				defaults: {
			       					anchor: '100%'
			       				},
			       				margins: '0 0 0 5',
			       				items: [
			       				        	{xtype: 'numberfield', flex: 1,fieldLabel: 'Total Sobrepeso',name:'credito',width:100,  margins: '0 0 0 0',enforceMaxLength:true,
											value: 0,maxValue: 365, minValue: 0 },
											{xtype: 'numberfield', flex: 1,fieldLabel: 'Total Adicionales',name:'credito',width:100,  margins: '0 0 0 0',enforceMaxLength:true,
												value: 0,maxValue: 365, minValue: 0 },
											{xtype: 'numberfield', flex: 1,fieldLabel: 'I.V.A',name:'credito',width:100,  margins: '0 0 0 0',enforceMaxLength:true,
													value: 0,maxValue: 365, minValue: 0 },
											{xtype: 'numberfield', flex: 1,fieldLabel: 'Descuento',name:'credito',width:100,  margins: '0 0 0 0',enforceMaxLength:true,
														value: 0,maxValue: 365, minValue: 0 },
											{xtype: 'numberfield', flex: 1,fieldLabel: 'Subtotal',name:'credito',width:100,  margins: '0 0 0 0',enforceMaxLength:true,
															value: 0,maxValue: 365, minValue: 0 },
											{xtype: 'numberfield', flex: 1,fieldLabel: 'Total',name:'credito',width:100,  margins: '0 0 0 0',enforceMaxLength:true,
																value: 0,maxValue: 365, minValue: 0 }
			       				        ]
							}
				
							
	       				]
	       			} 

				] 
    		}
		];

        this.callParent();
    },

	
	updateCampos:function(record){
		//alert(Ext.getCmp(this.id));
		var fields = Ext.getCmp(this.id).getForm().getFields( ) ;
		this.updateFieldName(record,fields);
						
	},
	updateFieldName:function(record, fields){
		var items = fields.items;
		var valor ="";
		for(i = 0; i < items.length; i++){
			field = items[i];
			if (field!=undefined){
				if (field.getName()!=undefined){
					//busca el nombre del campo que debe ser el mismo del nombre del campo de 
					//la forma
					valor = record.get(field.getName());
					if (valor!=undefined){
						//alert('Campo:' + field.getName() + ', valor:' +valor);
						field.setValue(valor);
					}else{
						field.setValue("");
					}
				
				}
			}
		}
	},
	updateFieldReadOnly:function(record){
	
		//alert(Ext.getCmp(this.id));
		var fields = Ext.getCmp(this.id).getForm().getFields( ) ;
		
		var items = fields.items;
		var valor ="";
		for(i = 0; i < items.length; i++){
			field = items[i];
			if (field!=undefined){
				if (field.getName()!=undefined){
					field.setReadOnly(true);				
				}
			}
		}
		
		this.updateCampos(record);
	},
	updateFieldCte:function(valor, campo){
		var fields = Ext.getCmp(this.id).getForm().getFields( ) ;
		
		var items = fields.items;
		for(i = 0; i < items.length; i++){
			field = items[i];
			if (field!=undefined){
				if ((field.getName()!=undefined) && (field.getName()==campo)){
					field.setValue(valor);				
				}
			}
		}
	},
	getValueField:function(campo){
		var fields = Ext.getCmp(this.id).getForm().getFields( ) ;
		var valor = '';
		var items = fields.items;
		for(i = 0; i < items.length; i++){
			field = items[i];
			if (field!=undefined){
				if ((field.getName()!=undefined) && (field.getName()==campo)){
					valor= field.getValue();				
				}
			}
		}
		return valor;
	},
		
	consultaclientes:function(){	
		var mysope=this;
		
		//Crea una forma de clientes para agregar los datos
		var grid_cte_cotizacion_consulta = Ext.create('MyDesktop.view.GridConsultaDireccionesCliente',{id:'grid_consulta_clientes_dir'}); 
		//grid_cte_cotizacion_consulta.setProxyURL('./catalogo/direccion/getDatosConsulta');
	
		var windows_consulta =Ext.create('widget.window', {
			id:'utils-win-consultar-clientes-cotizaciones-disponibles',
			title: "Clientes Disponibles",
			width: 1000,
			height: 400,
			modal:true,
			plain: true,
			layout: 'fit',
			iconCls:'clientes_white',
			items: grid_cte_cotizacion_consulta,
			buttons:[
				{iconCls:'seleccionar_white',text:'Seleccionar',handler:
					function(){
						var registro = grid_cte_cotizacion_consulta.getRegistro();
						if (registro!=undefined){
							mysope.updateFieldCte(registro.get('idcliente'), 'idcliente');
							mysope.updateFieldCte(registro.get('numcliente'), 'numcliente');
							
							mysope.updateFieldCte(registro.get('descripcion'), 'razonsocial_cte');
							mysope.updateFieldCte(registro.get('numcliente'), 'numcliente');
							mysope.updateFieldCte(registro.get('calle'), 'calle_cte');
							mysope.updateFieldCte(registro.get('numinterior'), 'numinterior_cte');
							mysope.updateFieldCte(registro.get('numexterior'), 'numexterior_cte');
							mysope.updateFieldCte(registro.get('cp'), 'cp_cte');
							mysope.updateFieldCte(registro.get('colonia'), 'colonia_cte');
							mysope.updateFieldCte(registro.get('municipio'), 'municipio_cte');
							mysope.updateFieldCte(registro.get('estado'), 'estado_cte');
							mysope.updateFieldCte(registro.get('email'), 'email_cte');
							mysope.updateFieldCte(registro.get('telefono'), 'telefono_cte');
							mysope.updateFieldCte(registro.get('movil'), 'movil_cte');
							windows_consulta.close();
						}else{
							Ext.Msg.alert('Verificar',"Seleccione registro de dirección.");
				     		return;
						}
					}
				}
			]
		}).show();
	},
	
	showGridCps: function(b, e){
		var fields = Ext.getCmp(this.id).getForm().getFields( ) ; 
		var tipoconsulta='cp'  ;
		var patron ='';
		var boton = b.id.split("_")[0];
		if (boton=='btnBuscarCP'){
			 tipoconsulta='cp'  ;
			 patron=getValueFormField('cp_cte',fields);   //Ext.getCmp('idcp').getValue();
		}else if (boton=='btnBuscarColonia'){
			 tipoconsulta='colonia'  ;
			 patron=getValueFormField('colonia_cte',fields);   //Ext.getCmp('idcolonia').getValue();
		}else if (boton=='btnBuscarMunicipio'){
			 tipoconsulta='municipio'  ;
			 patron=getValueFormField('municipio_cte',fields);   //Ext.getCmp('idmunicipio').getValue();
		}else{
			alert('Tipo de consulta inválida.');
		}		

		
		var gridcps = Ext.create('MyDesktop.view.GridConsultaCPs', { 
			id:'GridConsultaCPs_Consulta_Cotizaciones',
			isEditable:true,
			cp_field:'cp_cte' ,colonia_field:'colonia_cte', municipio_field:'municipio_cte',estado_field:'estado_cte',
			fields: fields,form:Ext.getCmp(this.id).getForm(),
			tipoconsulta:tipoconsulta,patron:patron,
			cp:patron, colonia:patron,municipio: patron
		}); 
		
		var buscacps_window = new Ext.Window({
				width    : 880,height   : 350,
				layout   : 'border',
				title	: 'Busqueda de códigos postales',
				closable:false,
				headerPosition: 'left',
				items    : [
				   {items   : gridcps,layout :'fit',region :'center',height   : 100}
				   ],
				buttons: [
					{text   : 'Salir',handler: function(){buscacps_window.close();}}
		        ]
			}); 
		gridcps.setScopeWin(buscacps_window);	
		 buscacps_window.show();
	
	},
	
	consultadescuentos:function(){
		var fields = Ext.getCmp(this.id).getForm().getFields( ) ;
		//Obtiene el valor del idcliente seleccionado
		var idcliente =getValueFormField('idcliente',fields);
		//Obtiene el valor del idcliente seleccionado
		var idtarifa =getValueFormField('idtarifa',fields);  
		
		var mysope=this;
		//Crea una forma de clientes para agregar los datos
		var grid_descuentos_consulta = Ext.create('MyDesktop.view.GridDescuentos',{id:'grid_consulta_descuentos_cotizacion'});  
		grid_descuentos_consulta.loadInfo();
		var wind_descuentos = Ext.create('widget.window', {
			id:'utils-win-consultar-descuentos-disponibles-cotizaciones',
			title: "Descuentos Disponibles",
			width: 900,
			height: 350,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			iconCls:'descuentos_white',
			items: grid_descuentos_consulta,
			buttons:[
				{iconCls:'seleccionar_white',text:'Seleccionar',handler:
					function(){
						var registro = grid_descuentos_consulta.getRegistro();
						if (registro!=undefined){
							mysope.updateFieldCte(registro.get('iddescuento'), 'iddescuento');
							mysope.updateFieldCte(registro.get('nombre' ), 'descripcionDescuento');
							  
							wind_descuentos.close();
						}else{
							Ext.Msg.alert('Verificar',"Seleccione registro de dirección.");
				     		return;
						}
					}
				}
				
			]
			
		});
		grid_descuentos_consulta.buscar(10,idcliente,idtarifa,'');
		wind_descuentos.show();
	},
	consultatarifas:function(){
		var mysope=this;
		//Crea una forma de clientes para agregar los datos
		var grid_tarifas = Ext.create('MyDesktop.view.GridTarifas',{id:'grid_consulta_tarifas_cotizacion'});  
		grid_tarifas.loadInfo();
		var wind_tarifas  = Ext.create('widget.window', {
			id:'utils-win-consultar-tarifas-disponibles-cotizaciones',
			title: "Tarifas Disponibles",
			width: 900,
			height: 350,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			iconCls:'tarifas_white',
			items: grid_tarifas,
			buttons:[
				{iconCls:'seleccionar_white',text:'Seleccionar',handler:
					function(){
						var registro = grid_tarifas.getRegistro();
						if (registro!=undefined){
							mysope.updateFieldCte(registro.get('idtarifa'), 'idtarifa');
							mysope.updateFieldCte(registro.get('nombre' ), 'descripcionTarifarango');
							wind_tarifas.close();
						}else{
							Ext.Msg.alert('Verificar',"Seleccione registro de dirección.");
				     		return;
						}
					}
				}
				
			]
			
		});
		grid_tarifas.buscar(10,'','','');
		
		wind_tarifas.show();

	},
	consultarangosenvios:function(){
		var mysope = this;
		var idtarifa = mysope.getValueField('idtarifa');

	
     	if(idtarifa==''){
     		Ext.Msg.alert('Verificar',"Debe seleccionar una tarifa disponible");
     		return;
     	}
		//Crea una forma de clientes para agregar los datos
		var grid_rangos_tarifa_servicio_cotizacion= Ext.create('MyDesktop.view.GridTarifasRangoEnvios',
				{
					id:'showdetails_tarifa_rango_cotizacion_coti',
					isConsulta:true,
					idtarifa:idtarifa
				}
		); 

		
		grid_rangos_tarifa_servicio_cotizacion.buscar();
		//forma_showdetails.updateFieldReadOnly(rows[0]);
		var mywin_rangos = Ext.create('widget.window', {
			id:'utils-win-agregar-tarifa-rango_cortiza',
			title: "Rango Envios Disponibles",
			width: 750,
			height: 350,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: grid_rangos_tarifa_servicio_cotizacion,
			buttons:[
						{iconCls:'seleccionar_white',text:'Seleccionar',handler:
							function(){
								var registro = grid_rangos_tarifa_servicio_cotizacion.getRegistro();
								if (registro!=undefined){
									var rango_envios = registro.get('idrangoinicial') + '-' + registro.get('idrangofinal'); 
									mysope.updateFieldCte(rango_envios, 'rangoenvios');
									mysope.updateFieldCte( registro.get('idrangoenvios'), 'idrangoenvios');
									mywin_rangos.close();
									
								}else{
									Ext.Msg.alert('Verificar',"Seleccione registro de dirección.");
						     		return;
								}
							}
						}
					]
		});
		mywin_rangos.show();
	}
});