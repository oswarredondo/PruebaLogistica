Ext.define('MyDesktop.view.FormDetalleCotizacion', {
    extend: 'Ext.form.Panel',
    xtype: 'register-detalle-cotizacion-form',

    frame: false,
	border:false,
    bodyPadding: 10,
    autoScroll:true,
    width: 355,
	myscope:undefined,
    showReadOnly:false,
   
    operacion:undefined,
    fieldDefaults: {
        labelAlign: 'right',
        labelWidth: 115,
        msgTarget: 'side'
    },
    idconvenio:undefined,
    idrangoenvios:undefined,
    store_plazas:undefined,
    scope_view_pricipal:undefined,
    initComponent: function() {
    	var operacion_aplicar = this.operacion;
    	this.myscope= this;
    	var scope_grid_pricipal = this.scope_view_pricipal;
    	this.store_plazas=Ext.create('MyDesktop.store.StorePlaza',{});
    	this.store_plazas.load();
    	
	    this.buttons= [
		
			{hidden:this.showReadOnly,
			text: 'Salvar',
			disabled: true,
			formBind: true,
			iconCls:'activo',
			handler:function() {
					var form = this.up('form').getForm();
						if (form.isValid()) {
							var out = [];
							Ext.Object.each(form.getValues(), function(key, value){
								out.push(key + '=' + value);
							});
							var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Agregando información espere..."});
							myMask.show();

							
							form.submit({
								clientValidation: true,
								url: '../cotizacionconveniodetalle/' + operacion_aplicar,
								//params:{idconvenio:this.idconvenio},
								success: function(form, action) {
									myMask.hide( );
									myMask.disable();
									
									if (action.result.cotizacion!=undefined){
										alertMsg('Confirmación',"Se creo la cotización:" + action.result.cotizacion);
									}else{
										alertMsg('Confirmación' , action.result.message);
									}
									
									if (scope_grid_pricipal!=undefined){
										scope_grid_pricipal.loadInfo();
									}
									form.reset();
									
				
								},
								failure: function(form, action) {
									myMask.hide( );
									myMask.disable();
									if ( (action.result!=undefined) && (action.result.message!=undefined)){
										alertMsg('Error' , action.result.message);
									}else{
										//Busca si existe un response del servier
										if (action.response.responseText!=null){
											alertMsg(action.response.statusText , action.response.responseText);
										}
									}
									
								}
							});
						
							
						}else{
							alertMsg('Verifique' ,'Complete los campos requeridos.');
						}
					}
		}];
		this.myscope= this;
        this.items = [
                      {xtype:'hidden', name:'idconvenio', value:this.idconvenio}	,			
			{
			    xtype: 'fieldset',
			    title: 'Selección de Origen/Destino',
			    layout: 'anchor',
			    defaults: {
			        anchor: '100%'
			    },
			    items: [
			            {
							xtype: 'myUpperCaseTextField',
							fieldLabel: 'Comentario',
	                        name: 'comentario', 
						    maxLength:40,
						    minLength:1,
						    required:false,
						    allowBlank: true,
						    enforceMaxLength:true
						},	
			            {
                            xtype: 'combobox',
                            fieldLabel: 'Origen',
                            name: 'siglasori', 
                            store: Ext.create('MyDesktop.store.StorePlaza',{}),
                            valueField: 'siglasplaza',
                            displayField: 'descripcion',
            				enforceMaxLength:true,
            				maxLength:30,
                            typeAhead: true,
                            queryMode: 'local',
                            allowBlank: true,
                            emptyText: ''
                        },
                        {
                            xtype: 'combobox',
                            fieldLabel: 'Destino',
                            name: 'siglasdes', 
                            store: Ext.create('MyDesktop.store.StorePlaza',{}),
                            valueField: 'siglasplaza',
                            displayField: 'descripcion',
            				enforceMaxLength:true,
            				maxLength:30,
                            typeAhead: true,
                            queryMode: 'local',
                            allowBlank: true,
                            emptyText: ''
                        },
                        {
                            xtype: 'container',
                            layout: 'hbox',
                            margin: '0 0 5 0',
                            items: [
                           
		                            {
		                                xtype: 'fieldcontainer',
		                                fieldLabel: 'Cobertura KM',
		                                labelWidth: 100,
		                                layout: 'hbox',
		                                items: [
													{xtype: 'numberfield',    width: 150,name:'coberturakm',
														 margins: '0 6 6 9',allowBlank: false, readOnly:false } ,
		                                            { xtype:'button',  iconCls:'buscar_white',scope:this.myscope,
		                    							handler: function(){
		                    								//Obtiene las siglas origen
		                    								this.consultacobertura('destino');
		                    							}
		                    						} 
		        						]
		                            }
	    						
	                            ]
	                        }
	                   
					]
    			} ,   
    			
        		{
        			    xtype: 'fieldset',
        			    title: 'Peso/Sobre Peso',
        			    layout: 'anchor',
        			    defaults: {
        			        anchor: '100%'
        			    },
        			    items: [
        					{
                                xtype: 'container',
                                layout: 'hbox',
                                margin: '0 0 5 0',
                                items: [
                               
    		                            {
    		                                xtype: 'fieldcontainer',
    		                                fieldLabel: 'Peso',
    		                                labelWidth: 100,
    		                                layout: 'hbox',
    		                                items: [
    		                                        {xtype: 'numberfield', width: 150,name: 'peso',
    		                                        	allowBlank: false,   margins: '0 6 4 0',enforceMaxLength:true,maxLength:5, 
    		                                        	readOnly:false } ,
    		                                            { xtype:'button',tooltip:'Muestra rangos de pesos disponibles',
    		                                        		iconCls:'buscar_white',scope:this.myscope,
    		                    							handler: function(){
    		                    								//Obtiene las siglas origen
    		                    								this.consultarangospesos('destino');
    		                    							}
    		                    						} 
    		        						]
    		                            }
    	    						
    	                            ]
    	                        },
    	                        {
    	                            xtype: 'container',
    	                            layout: 'hbox',
    	                            margin: '0 0 5 0',
    	                            hidden:true,
    	                            items: [
    		                            {
    		                                xtype: 'fieldcontainer',
    		                                fieldLabel: 'Sobre Peso',
    		                                labelWidth: 100,
    		                                layout: 'hbox',
    		                                items: [
    		                                        {xtype: 'numberfield',   width: 150,name:'sobrepeso',
    		                                        	 margins: '0 6 5 0',allowBlank: true, readOnly:true, value:0 }
    		        						]
    		                            }
    	                            ]
    	                        }
        					]
            			},
            			{
            			    xtype: 'fieldset',
            			    title: 'Dimensiones',
            			    layout: 'anchor',
            			    labelWidth: 75,
            			    margin: '0 0 5 0',
            			    defaults: {
            			        anchor: '100%'
            			    },
            			    items: [
            			            {
                                        xtype: 'container',
                                        layout: 'hbox',
                                        margin: '0 0 5 0',
                                        items: [
                                       
            		                            {
            		                                xtype: 'fieldcontainer',
            		                                labelWidth: 50,
            		                                fieldDefaults: {
            		    								labelAlign: 'top'
            		    							},
            		                                layout: 'hbox',
            		                                items: [
														{xtype: 'numberfield',   fieldLabel: 'Alto',  width: 90,name:'alto',
															 margins: '0 6 6 9',allowBlank: false, readOnly:false },
														{xtype: 'numberfield',    fieldLabel: 'Ancho', width: 90,name:'ancho',
														   	 margins: '0 6 6 9',allowBlank: false, readOnly:false },
														{xtype: 'numberfield',    fieldLabel: 'Largo', width: 90,name:'largo',
														       	 margins: '0 6 6 9',allowBlank: false, readOnly:false },
            		        						]
            		                            }
            	    						
            	                            ]
            	                        }  
									   /*,{
                                                 xtype: 'container',
                                                 layout: 'hbox',
                                                 margin: '0 0 5 0',
                                                 items: [
                                                
                     		                            {
                     		                                xtype: 'fieldcontainer',
                     		                                fieldLabel: 'Vol.',
                     		                                labelWidth: 75,
                     		                                layout: 'hbox',
                     		                                items: [
                     		                                        {xtype: 'myUpperCaseTextField', width: 90,name: 'volumen',
                     		                                        	allowBlank: false,   margins: '0 6 4 0',enforceMaxLength:true,maxLength:5, 
                     		                                        	readOnly:false } ,
                     		                                            { xtype:'button',  iconCls:'buscar_white',scope:this.myscope,
                     		                    							handler: function(){
                     		                    								//Obtiene las siglas origen
                     		                    								this.consultasiglas('destino');
                     		                    							}
                     		                    						} 
                     		        						]
                     		                            }
                     	    						
                     	                            ]
                     	                        } */ 	 
            					]
                		}
            			/*,{
            			    xtype: 'fieldset',
            			    title: 'Cobertura/Precio',
            			    layout: 'anchor',
            			    labelWidth: 75,
            			    margin: '0 0 5 0',
            			    defaults: {
            			        anchor: '100%'
            			    },
            			    items: [
            			         
                                        	 {
                                                 xtype: 'container',
                                                 layout: 'hbox',
                                                 margin: '0 0 5 0',
                                                 items: [
                                                
                     		                            {
                     		                                xtype: 'fieldcontainer',
                     		                                fieldLabel: 'Precio',
                     		                                labelWidth: 75,
                     		                                fieldDefaults: {
                     		                                	//labelAlign: 'top'
                     		                                },
                     		                                layout: 'hbox',
                     		                                items: [
                     		                                        {xtype: 'numberfield', width: 90,name: 'precio',
                     		                                        	allowBlank: false,   margins: '0 6 4 0',enforceMaxLength:true,maxLength:5, 
                     		                                        	readOnly:false } ,
                     		                                            { xtype:'button',  iconCls:'buscar_white',scope:this.myscope,
                     		                    							handler: function(){
                     		                    								//Obtiene las siglas origen
                     		                    								this.consultasiglas('destino');
                     		                    							}
                     		                    						} 
                     		        						]
                     		                            }
                     	    						
                     	                            ]
                     	                        }   	 
            					]
                		}*/
                	
                  
        ];
        this.callParent();
    },
    consultarangospesos:function(){

		//Crea una forma de clientes para agregar los datos
		var grid_rangos_peso_tarifa_servicio= Ext.create('MyDesktop.view.GridTarifaPeso',
				{
					id:'showdetails_tarifa_rango_peso_consulta',
					isConsulta:true,
					idrangoenvios:this.idrangoenvios
				}
		); 
		
		grid_rangos_peso_tarifa_servicio.buscar();
		//forma_showdetails.updateFieldReadOnly(rows[0]);
		Ext.create('widget.window', {
			id:'utils-win-agregar-tarifa-rango_peso-consulta',
			title: "Detalles Rangos Peso Tarifa",
			width: 550,
			height: 500,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: grid_rangos_peso_tarifa_servicio
		}).show();
    	
    },
    consultasobrepeso:function(){
    	//Obtiene el sobre peso dado el peso por usuario 
    	//y de acuerdo al rango de envios seleccionado
    	var peso = this.getValueField('peso');  
    	
    	if (peso==''){
    		alertMsg('Verificar',"Capture el peso.");
     		return;
    	}
    	
    	//verifica la cobertura
    	var myscope=this;
    	var conn = new Ext.data.Connection();
   		conn.request({
   				scope:myscope, 
				url: '../tarifapeso/getSobrePeso' ,
				params:{idrangoenvios:this.idrangoenvios,peso:peso},
				timeOut:9999,
				success: function(response, opts) {
				
					var obj = Ext.decode(response.responseText);
					if (obj.sobrepeso!=undefined){
						myscope.updateFieldCte(obj.sobrepeso, 'sobrepeso');
					}else{
						alertMsg('Error','No existe tabla de pesos definida para el rango seleccionado');
						myscope.updateFieldCte(0, 'sobrepeso');
					}
				},
				failure: function(response, opts) {
	       			if (response.responseText!=undefined){
	       				var obj = Ext.decode(response.responseText);
	       				if (obj.message!=undefined){
	       					alertMsg('Error',obj.message);
		       			}
		       		}
       			
				}
   		});  
    	
    },
    consultacobertura:function(){
    	//Obtiene la cobertura de acuerdo al centro operativo origen y destino seleccionados
    	var plazaori = this.getValueField('siglasori');  
    	var plazades = this.getValueField('siglasdes');
    	
    	if ((plazaori=='') || (plazades=='')){
    		alertMsg('Verificar',"Debe seleccionar origen y destino para verificar cobertura.");
     		return;
    	}
    	//Obtiene el centro operativo para el origen y destino
    	var idcoorigen = '';  
    	var idcodestino = '';
    	this.store_plazas.each(function(r) {
    		
			if (r.data['siglasplaza'] == plazaori) {
				//alert('data:' + r.data['siglasplaza'] + ",plazaori:" +plazaori + ",idsiglasco:"+r.data['idcentrooperativo']);
				idcoorigen = r.data['idcentrooperativo'];
			}
			if (r.data['siglasplaza'] == plazades) {
				//alert('data:' + r.data['siglasplaza'] + ",plazades:" +plazaori + ",idsiglasco:"+r.data['idcentrooperativo']);
				idcodestino = r.data['idcentrooperativo'];
			}
		});
    	if (idcoorigen==''){
    		alertMsg('Verificar',"Origen no tiene  asignado un centro operativo.");
     		return;
    	}
    	if (idcodestino==''){
    		alertMsg('Verificar',"Destino no tiene  asignado un centro operativo.");
     		return;
    	}
    	
    	//verifica la cobertura
    	var myscope=this;
    	var conn = new Ext.data.Connection();
   		conn.request({
   				scope:myscope, 
				url: '../catalogos/datos/getCoberturaCotizacion' ,
				params:{idcoorigen:idcoorigen,idcodestino:idcodestino},
				timeOut:9999,
				success: function(response, opts) {
				
					var obj = Ext.decode(response.responseText);
					if (obj.kms!=undefined){
						myscope.updateFieldCte(obj.kms, 'coberturakm');
					}else{
						Ext.Msg.alert('Error','No existe cobertura para origen-destino.');
					}
				},
				failure: function(response, opts) {
	       			if (response.responseText!=undefined){
	       				var obj = Ext.decode(response.responseText);
	       				if (obj.message!=undefined){
	       					Ext.Msg.alert('Error',obj.message);
		       			}
		       		}
       			
				}
   		});  
    	
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
	getSiglas:function(b,e){
		var name_cp_field= '';
		if (b.id=='cporigen'+this.id){
			name_cp_field='cporigen';
		}else if (b.id=='cpodestino'+this.id){
			name_cp_field='cpodestino';
		}else{
			return;
		}
		var gridcps = Ext.create('MyDesktop.view.GridConsultaCPs', { 
			showMenuBusqueda:true,
			cp_field:name_cp_field 
		}); 
		  
		var buscacps_SiglasOrigen_window = new Ext.Window({
				width    : 880,height   : 350,
				layout   : 'border',
				title	: 'Busqueda de códigos postales',
				closable:false,
				headerPosition: 'left',
				items    : [
				   {items   : gridcps,layout :'fit',region :'center',height   : 100}
				   ],
				buttons: [
					{text   : 'Salir',handler: function(){buscacps_SiglasOrigen_window.close();}}
		        ]
			}); 
		gridcps.setScopeWin(buscacps_SiglasOrigen_window);	
		buscacps_SiglasOrigen_window.show();
	},
	

	consultaclientes:function(){	
		var mysope=this;
		
		//Crea una forma de clientes para agregar los datos
		var grid_cte_cotizacion_consulta = Ext.create('MyDesktop.view.GridConsultaDireccionesCliente',{id:'grid_consulta_clientes_dir'}); 
		//grid_cte_cotizacion_consulta.setProxyURL('../catalogo/direccion/getDatosConsulta');
	
		var windows_consulta =Ext.create('widget.window', {
			id:'utils-win-consultar-clientes-cotizaciones-disponibles',
			title: "Clientes Disponibles",
			width: 900,
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
							
							mysope.updateFieldCte(registro.get('calle'), 'calle_cte');
							mysope.updateFieldCte(registro.get('numinterior'), 'numinterior_cte');
							mysope.updateFieldCte(registro.get('numexterior'), 'numexterior_cte');
							mysope.updateFieldCte(registro.get('cp'), 'cp_cte');
							mysope.updateFieldCte(registro.get('colonia'), 'colonia_cte');
							mysope.updateFieldCte(registro.get('municipio'), 'municipio_cte');
							mysope.updateFieldCte(registro.get('estado'), 'estado_cte');
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
		alert('idtarifa:' + idtarifa);
	
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
		Ext.create('widget.window', {
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
									
								}else{
									Ext.Msg.alert('Verificar',"Seleccione registro de dirección.");
						     		return;
								}
							}
						}
					]
		}).show();
	}
});