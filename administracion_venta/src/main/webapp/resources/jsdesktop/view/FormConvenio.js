Ext.define('MyDesktop.view.FormConvenio', {
    extend: 'Ext.form.Panel',
    xtype: 'register-form',
    
    
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
    winprincipal:undefined,
    enebleSaveOnlyNumClient:false,
    fieldDefaults: {
        labelAlign: 'right',
        labelWidth: 115,
        msgTarget: 'side'
    },

    initComponent: function() {
    	
    	var operacion_aplicar = this.operacion;
    	var iseditablle =this.operacion=='update'?true:false;
    	
    	this.myscope= this;
    	var scopemy = this;
    	var scope_grid_pricipal = this.scope_view_pricipal;
    	
    	var store_metodo_pago= Ext.create('MyDesktop.store.StoreMetodoPago',{});
    	var store_forma_pago= Ext.create('MyDesktop.store.StoreFormaPago',{});
    	var store_poblacion_pagadera= Ext.create('MyDesktop.store.StorePoblacionPagadera',{});
    	var store_oficina_control= Ext.create('MyDesktop.store.StoreOficinaControl',{});
    	var store_unidad_admionistrativoa= Ext.create('MyDesktop.store.StoreUnidadAdministrativa',{});
    	var store_condicionpago= Ext.create('MyDesktop.store.StoreCondicionPago',{});
    	var store_banco= Ext.create('MyDesktop.store.StoreBancos',{});


    	this.buttons= [
    	               {
    	            	    hidden:!scopemy.enebleSaveOnlyNumClient,
							text: 'Num. Cte SIPA',
							iconCls:'activo',
							handler:function() {
								var form = this.up('form').getForm();
			
								if ( scopemy.getValueField('estatus')=='3'){
									mensajeAlert("Convenio ya fue autorizado, no puede modificar datos");
									return;
								} 
								
								form.submit({
									clientValidation: true,
									url: '../convenio/' + operacion_aplicar,
									success: function(form, action) {
										if (operacion_aplicar=='update'){
											if (scope_grid_pricipal!=undefined){
												scope_grid_pricipal.filtrar();
											}
											
										}
										
										if (operacion_aplicar=='insert'){
											form.reset();
										}
										if (scopemy.winprincipal!=undefined){
											scopemy.winprincipal.close();
										}
										
										if (action.result.cotizacion!=undefined){
											mensajeConfirm("Se creo la cotizaci�n:" + action.result.cotizacion);
										}else{
											mensajeConfirm(action.result.message);
											scope_grid_pricipal.filtrar();
											
										}
									},
									failure: function(form, action) {
										
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
							}
    	               },			
            {
  	        	hidden:scopemy.enebleSaveOnlyNumClient,
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
  							var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Actualizando informacion informaci�n espere..."});
  							myMask.show();

  							
  							form.submit({
  								clientValidation: true,
  								url: '../convenio/' + operacion_aplicar,
  								success: function(form, action) {
  									myMask.hide( );
  									myMask.disable();

  									
  									if (operacion_aplicar=='update'){
  										if (scope_grid_pricipal!=undefined){
  											scope_grid_pricipal.filtrar();
  										}
  										
  									}
  									
  									if (operacion_aplicar=='insert'){
  										form.reset();
  									}
  									if (scopemy.winprincipal!=undefined){
  										scopemy.winprincipal.close();
  									}
  									
  									if (action.result.cotizacion!=undefined){
  										mensajeConfirm("Se creo la cotización:" + action.result.cotizacion);
  									}else{
  										mensajeConfirm(action.result.message);
  										scope_grid_pricipal.filtrar();
  										
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
  		}];

	    this.items = [{
	            layout:'column',
	            items:[
	                   {
	       				xtype: 'fieldset',
	       				columnWidth:.32,
	       				title: 'Datos Generales',
	       				defaultType: 'textfield',
	       				height:500,
	       				defaults: {
	       					anchor: '100%'
	       				},
	       				items: [ 	
	       				    {xtype:'hidden', name:'idcliente'},
	       				    { xtype: 'hidden', allowBlank:true, fieldLabel: 'Convenio', name: 'estatus', readOnly:true },
	       					{ xtype: 'hidden', allowBlank:true, fieldLabel: 'Convenio', name: 'idconvenio', readOnly:true },
	       					//{ xtype: 'myUpperCaseTextField', allowBlank:false, fieldLabel: 'Ref. b�squeda<font color=red>*</font>',
	       					//	name: 'nombre',enforceMaxLength:true,maxLength:40,allowBlank:false  },
	       				   // {xtype: 'myUpperCaseTextField', fieldLabel: 'Num. Cte SIPA<font color=red>*</font>',name:'numcliente',width:100,margins: '0 0 0 1',allowBlank:false,maxLength:5,readOnly:true  },
	       				    {
	       						xtype: 'fieldcontainer',
	       						labelStyle: 'font-weight:bold;padding:0',
	       						layout: 'hbox',
	       						fieldLabel: 'Num. Cte SIPA<font color=red>*</font>',
	       						defaultType: 'textfield',
	       						fieldDefaults: {
	       							//labelAlign: 'top'
	       						},
	       						items: [
	       						   
	       						    {xtype: 'myUpperCaseTextField', flex: 3,name:'numcliente',width:100,margins: '0 0 0 0',
	       						    	allowBlank: true, readOnly:false, enforceMaxLength:true,maxLength:20  },
	       							{ xtype:'button', flex: 1, width:80, margins: '0 0 0 5',  iconCls:'buscar_white',text:'',
	       						    	iconMask: true,
	       						 
	       						    	iconAlign:'center',            
	       						    	
	       						    	scope:this.myscope,
	       						    	disabled:checkEnable('sistema.btn.asignar.cliente.rfc.convenio'),
	       								handler: function(){
	       									//Muestra el grid para la seccion de los clientes
	       									this.consultaclientesrfcsipa();
	       								}
	       							}
	       						    
	       						]
	       					}, 
	       					
	       				    {xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: 'R.F.C',name:'rfc',width:100,  margins: '0 0 0 5',
	       						enforceMaxLength:true,maxLength:40, readOnly:false },
	       					
	       					{xtype: 'datefield',fieldLabel: 'Fecha Cotizaci�n<font color=red>*</font>',name: 'fechadocumento',allowBlank: false,maxValue: new Date(), readOnly:true},
	       					{
	       						xtype: 'fieldcontainer',
	       						labelStyle: 'font-weight:bold;padding:0',
	       						layout: 'hbox',
	       						fieldLabel: 'Raz�n Social<font color=red>*</font>',
	       						defaultType: 'textfield',
	       						fieldDefaults: {
	       							//labelAlign: 'top'
	       						},
	       						items: [
	       						   
	       						    {xtype: 'myUpperCaseTextField', flex: 3,name:'razonsocial_cte',width:100,margins: '0 0 0 0',allowBlank: false, readOnly:true  }/*,
	       							{ xtype:'button', flex: 1, width:80, margins: '0 0 0 5',  iconCls:'buscar_white',text:'Buscar',scope:this.myscope,
	       								handler: function(){
	       									//Muestra el grid para la seccion de los clientes
	       									this.consultaclientes();
	       								}
	       							}*/
	       						]
	       					}, 
	       					{
	    						xtype: 'fieldcontainer',
	    						labelStyle: 'font-weight:bold;padding:0',
	    						layout: 'hbox',
	    						emptyText: 'Cliente',
	    						defaultType: 'textfield',
	    						fieldDefaults: {
	    							//labelAlign: 'top'
	    						},
	    						items: [
	    						    {xtype: 'myUpperCaseTextField', flex: 4,fieldLabel: 'Contacto',name:'contacto_cte',width:100,margins: '0 0 0 0',
	    						    	enforceMaxLength:true,maxLength:40,readOnly:iseditablle, readOnly:true }//,
	    							/*{ xtype:'button', flex: 1, width:80, margins: '0 0 0 5',  iconCls:'buscar_white',text:'Buscar',
	    						    		scope:this.myscope,
	    								handler: function(){
	    									//Muestra el grid para la seccion de los clientes
	    									this.consultacontactos();
	    								}
	    							}*/
	    						]
	    					}, 
	       					{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: 'Calle<font color=red>*</font>',name:'calle_cte',width:100, margins: '0 0 0 5',
	       						enforceMaxLength:true,maxLength:40,allowBlank: false , readOnly:true},
	       					{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: 'Num.Interior',name:'numinterior_cte',width:100, 
	       							margins: '0 0 0 5',enforceMaxLength:true,maxLength:10, readOnly:true },
	       					{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: 'Num.Exterior',name:'numexterior_cte',width:100,
	       								margins: '0 0 0 5',enforceMaxLength:true,maxLength:10, readOnly:true },
	       					{
	       						xtype: 'fieldcontainer',
	       						labelStyle: 'font-weight:bold;padding:0',
	       						layout: 'hbox',
	       						emptyText: 'C.P',
	       						defaultType: 'textfield',
	       						fieldDefaults: {
	       							//labelAlign: 'top'
	       						},
	       						items: [
	       						   
	       						        {xtype: 'myUpperCaseTextField',  flex: 3,fieldLabel: 'C.P<font color=red>*</font>',name:'cp_cte',width:100, 
	       						        	margins: '0 0 0 0',enforceMaxLength:true,maxLength:5,allowBlank: false , readOnly:true}//,
	       							//{ xtype:'button', flex: 1,width:80,  margins: '0 0 0 5',  iconCls:'buscar_white',text:'Buscar',scope:this.myscope,id:'btnBuscarCP_'+this.id,
	       							//	handler:this.showGridCps}
	       						]
	       					},
	       					
	       					{
	       						xtype: 'fieldcontainer',
	       						labelStyle: 'font-weight:bold;padding:0',
	       						layout: 'hbox',
	       						emptyText: 'Colonia',
	       						defaultType: 'textfield',
	       						fieldDefaults: {
	       							//labelAlign: 'top'
	       						},
	       						items: [
	       						   
	       								{xtype: 'myUpperCaseTextField', flex: 3,fieldLabel: 'Colonia<font color=red>*</font>',name:'colonia_cte',
	       									width:100,margins: '0 0 0 0',enforceMaxLength:true,maxLength:50,allowBlank: false, readOnly:true }//,
	       							//{ xtype:'button', flex: 1,width:80,  margins: '0 0 0 5',  iconCls:'buscar_white',text:'Buscar',scope:this.myscope,id:'btnBuscarColonia_'+this.id,
	       							//	handler:this.showGridCps}
	       						]
	       					},
	       					{
	       						xtype: 'fieldcontainer',
	       						labelStyle: 'font-weight:bold;padding:0',
	       						layout: 'hbox',
	       						emptyText: 'Municipio',
	       						defaultType: 'textfield',
	       						fieldDefaults: {
	       							//labelAlign: 'top'
	       						},
	       						items: [
	       						   
	       								{xtype: 'myUpperCaseTextField', flex: 3,fieldLabel: 'Municipio<font color=red>*</font>',name:'municipio_cte',width:100, 
	       									margins: '0 0 0 0',enforceMaxLength:true,maxLength:50,allowBlank: false, readOnly:true }//,		
	       								//{ xtype:'button', flex: 1,width:80,  margins: '0 0 0 5',  iconCls:'buscar_white',text:'Buscar',scope:this.myscope,id:'btnBuscarMunicipio_'+this.id,
	       								//handler:this.showGridCps}
	       						]
	       					},
	       					{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: 'Estado',name:'estado_cte',width:100,  margins: '0 0 0 0',enforceMaxLength:true,maxLength:40, readOnly:true },
	       					{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: 'Tel�fono',name:'telefono_cte',width:100,  margins: '0 0 0 0',enforceMaxLength:true,maxLength:40 , readOnly:true},
	       					{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: 'M�vil',name:'movil_cte',width:100,  margins: '0 0 0 0',enforceMaxLength:true,maxLength:40, readOnly:true },
	       					{xtype: 'textfield',vtype: 'email' , flex: 1,fieldLabel: 'Email',name:'email_cte',width:100,  margins: '0 0 0 0',enforceMaxLength:true,maxLength:40 , readOnly:true},
							// PARA SEGUROS
							{
								xtype : 'fieldcontainer',
								labelStyle : 'font-weight:bold;padding:0',
								layout : 'hbox',
								emptyText : 'Cliente',
								defaultType : 'textfield',
								fieldDefaults : {
								// labelAlign: 'top'
								},
								items : [ 
								 {
								xtype : 'checkboxfield',
								name : 'asegura',
								id: 'id_tiene_seguro',
								fieldLabel : 'Asegura?',
								readOnly:true,
								boxLabel : ''
							}, {
								xtype : 'numberfield',
								name : 'porcentaje_seguro',
								id : 'id_valor_asegurado',
								fieldLabel : 'Valor en %',
								allowBlank : true,
								readOnly:true,
								flex : 1,
								width : 80,
								value : 0.00,
								minValue : 0.00,
								maxValue : 100,
								allowDecimals : true,
								decimalPrecision : 2,
								decimalSeparator : '.',
								disabled: false
							}, ]
							}

	       				]
	       			},
	       			
	       			{
	       				xtype: 'fieldset',
	       				columnWidth:.3,
	       				height:500,
	       				title: 'Datos Tarifa/Descuento/Pagos',
	       				defaultType: 'textfield',
	       				defaults: {
	       					anchor: '100%'
	       				},
	       				items: [
	       				        {
	       				            xtype: 'checkboxfield',
	       				            name: 'tipo_precios',
	       				            fieldLabel: 'Precios',
	       				            boxLabel: 'Toda la lista de precios'
	       				        },
	       						{
	       							xtype: 'fieldcontainer',
	       							labelStyle: 'font-weight:bold;padding:0',
	       							layout: 'hbox',
	       							emptyText: 'Tarifa',
	       							defaultType: 'textfield',
	       							fieldDefaults: {
	       								labelAlign: 'top'
	       							},
	       							items: [ 
	       								{xtype: 'myUpperCaseTextField', flex: 1,name:'idtarifa',  margins: '0 0 0 5',allowBlank: false, readOnly:true },
	       								
	       								{xtype: 'myUpperCaseTextField', flex: 3, name: 'descripcionTarifarango', allowBlank: false, margins: '0 0 0 5',enforceMaxLength:true,maxLength:40, readOnly:true },
	       								{ xtype:'button', flex: 1, margins: '0 0 0 5', width:80,iconCls:'tarifas_white',text:'',scope:this.myscope,disabled:true,
	       									handler: function(){
	       										//Muestra el grid para la seccion de los descuentos
	       										this.consultatarifas();
	       									}
	       								} 
	       							]
	       						}, 
	       						{
	       							xtype: 'fieldcontainer',
	       							labelStyle: 'font-weight:bold;padding:0',
	       							layout: 'hbox',
	       							emptyText: 'Tarifa',
	       							defaultType: 'textfield',
	       							fieldDefaults: {
	       								labelAlign: 'top'
	       							},
	       							items: [ 
	       							    {xtype: 'myUpperCaseTextField', flex: 1,name:'idrangoenvios', margins: '0 0 0 5',allowBlank: false, 
	       							    	readOnly:true},
	       								{xtype: 'myUpperCaseTextField', flex: 3, name: 'rangoenvios', allowBlank: false, margins: '0 0 0 5',
	       									enforceMaxLength:true,maxLength:50, readOnly:false },
	       								{ xtype:'button', flex: 1, margins: '0 0 0 5', width:80,iconCls:'detalles_white',text:'',scope:this.myscope,disabled:true,
	       									handler: function(){
	       										//Muestra el grid para la seccion de los descuentos
	       										this.consultarangosenvios();
	       									}
	       								} 
	       							]
	       						}, 
	       					{
	       						xtype: 'fieldcontainer',
	       						labelStyle: 'font-weight:bold;padding:0',
	       						layout: 'hbox',
	       						emptyText: 'Descuento',
	       						defaultType: 'textfield',
	       						fieldDefaults: {
	       							labelAlign: 'top'
	       						},
	       						items: [
	       							{xtype: 'myUpperCaseTextField', flex: 1,name:'iddescuento', margins: '0 0 0 5',allowBlank: false, readOnly:true },
	       							
	       							{xtype: 'myUpperCaseTextField', flex: 3, name: 'descripcionDescuento', allowBlank: false, margins: '0 0 0 5',enforceMaxLength:true,maxLength:40, readOnly:true },
	       							{ xtype:'button', flex: 1, margins: '0 0 0 5', width:80,iconCls:'descuentos_white',text:'',scope:this.myscope,disabled:true,
	       								handler: function(){
	       									//Muestra el grid para la seccion de los descuentos
	       									this.consultadescuentos();
	       								}
	       							}
	       						]
	       					},
	       					/* NOMBRE SEGURO */
							{
								xtype : 'fieldcontainer',
								labelStyle : 'font-weight:bold;padding:0',
								layout : 'hbox',
								emptyText : 'Tarifa',
								defaultType : 'textfield',
								fieldDefaults : {
									labelAlign : 'top'
								},
								items : [ 
								{
									xtype : 'myUpperCaseTextField',
									flex : 4,
									name : 'nombre_seguro',
									id : 'idciaseguro',
									allowBlank : true,
									margins : '0 0 0 5',
									enforceMaxLength : true,
									maxLength : 100,
									readOnly : true
								}, {
									xtype : 'button',
									id : 'btnSeguros',
									flex : 1,
									margins : '0 0 0 5',
									width : 80,
									iconCls : 'lista_white',
									text : '',
									scope : this.myscope,
									disabled : true,
									handler : function() {
										// Muestra el grid para la seccion de
										// los descuentos
										this.consultaSeguros();
									}
								} ]
							},
	       					{
	       						
								xtype: 'combobox',
								fieldLabel: 'Condiciones<font color=red>*</font>',
								name: 'idcondicionpago',
								allowBlank: false,
								store: store_condicionpago,// Ext.create('MyDesktop.store.StoreCondicionPago'),
								forceSelection:true,
								valueField: 'identificador',
								displayField: 'descripcion',
								typeAhead: true,
								queryMode: 'local',
								emptyText: 'Condiciones de Pago'
							},
							{
								xtype: 'combobox',
								fieldLabel: 'M�todo Pago<font color=red>*</font>',
								name: 'idmetodopago',
								allowBlank: false,
								store: store_metodo_pago,//Ext.create('MyDesktop.store.StoreMetodoPago'),
								valueField: 'identificador',
								displayField: 'descripcion',
								forceSelection:true,
								typeAhead: true,
								queryMode: 'local',
								emptyText: ''
							},
							{  
								xtype: 'combobox',
								fieldLabel: 'Forma Pago<font color=red>*</font>',
								name: 'idformapago',
								allowBlank: false,
								store: store_forma_pago,//Ext.create('MyDesktop.store.StoreFormaPago'),
								valueField: 'identificador',
								displayField: 'descripcion',
								typeAhead: true,
								queryMode: 'local',
								emptyText: ''
							},
							{
								xtype: 'combobox',
								fieldLabel: 'Poblaci�n Pag.<font color=red>*</font>',
								name: 'idpoblacionpago',
								store: store_poblacion_pagadera,//Ext.create('MyDesktop.store.StorePoblacionPagadera'),
								valueField: 'identificador',
								allowBlank: false,
								displayField: 'descripcion',
								forceSelection:true,
								typeAhead: true,
								queryMode: 'local',
								emptyText: ''
							},
							{  
								xtype: 'combobox',
								fieldLabel: 'Oficina de Ctrl<font color=red>*</font>',
								name: 'idoficinacontrol',
								allowBlank: false,
								store: store_oficina_control,//Ext.create('MyDesktop.store.StoreOficinaControl'),
								valueField: 'identificador',
								forceSelection:true,
								displayField: 'descripcion',
								typeAhead: true,
								queryMode: 'local',
								emptyText: ''
							},
							{
								xtype: 'combobox',
								fieldLabel: 'Cte. Licitaci�n<font color=red>*</font>',
								name: 'clientelicitacion',
								allowBlank: false,
								store: Ext.create('MyDesktop.store.StoreSINO'),
								valueField: 'identificador',
								displayField: 'descripcion',
								forceSelection:true,
								typeAhead: true,
								queryMode: 'local',
								emptyText: ''
							},
							 {xtype: 'combobox',fieldLabel: 'Unidad Admin.<font color=red>*</font>',name: 'idunidadadm',
								store: store_unidad_admionistrativoa,//Ext.create('MyDesktop.store.StoreUnidadAdministrativa'),
								allowBlank: false,
								valueField: 'identificador',
								forceSelection:true,
								displayField: 'descripcion',
								typeAhead: true,
								queryMode: 'local',
								emptyText: ''
							},
							{xtype: 'numberfield', flex: 1,fieldLabel: 'D�as de Credito',name:'credito',width:100,  margins: '0 0 0 0',enforceMaxLength:true,
									value: 0,maxValue: 365, minValue: 0 },

							
							 {xtype: 'combobox',fieldLabel: 'Banco<font color=red>*</font>',name: 'nombrebanco',
								store: store_banco,
								allowBlank: false,
								valueField: 'descripcion',
								forceSelection:true,
								displayField: 'descripcion',
								typeAhead: true,
								queryMode: 'local',
								emptyText: ''
							},
									
							//{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: 'Banco.',name:'nombrebanco',width:100,  margins: '0 0 0 0',enforceMaxLength:true,maxLength:40 },
							{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: 'Num. Cuenta.',name:'cuentabancaria',width:100,  
								margins: '0 0 0 0',enforceMaxLength:true,maxLength:4, regex:/^[0-9]{4}$/ }
							

							 
	       				]
	       			},   
					{
						xtype: 'fieldset',
						height:500,
						title: 'Otros',
						defaultType: 'textfield',
						columnWidth:.25,
						defaults: {
							anchor: '100%'
						},
						items: [
							//{ xtype: 'myUpperCaseTextField', allowBlank:false, fieldLabel: 'Rep. Legal<font color=red>*</font>', name: 'representantelegal', emptyText: '' },
	       					  {
	       						xtype: 'fieldcontainer',
	       						labelStyle: 'font-weight:bold;padding:0',
	       						layout: 'hbox',
	       						fieldLabel: 'Rep. Legal<font color=red>*</font>',
	       						defaultType: 'textfield',
	       						fieldDefaults: {
	       							//labelAlign: 'top'
	       						},
	       						items: [
	       						   
	       						    {xtype: 'myUpperCaseTextField', flex: 4,name:'representantelegal',width:100,margins: '0 0 0 0',allowBlank: true, readOnly:true  },
	       							{ xtype:'button', flex: 1, width:60, margins: '0 0 0 5',  iconCls:'buscar_white',text:'',scope:this.myscope,
	       								handler: function(){
	       									//Muestra el grid para la seccion de los clientes
	       									this.consultacontactosRepresentante();
	       								}
	       							}
	       						    
	       						]
	       					}, 
							
							 {xtype: 'combobox',fieldLabel: 'Tipo Contrato',name: 'tipo_contrato',
								store: Ext.create('MyDesktop.store.StoreTipoContrato'),
								valueField: 'idtipo',
								forceSelection:true,
								displayField: 'descripcion',
								typeAhead: true,
								queryMode: 'local',
								emptyText: ''
							},
							//{xtype: 'datefield',fieldLabel: 'Fecha Revisi�n<font color=red>*</font>',name: 'fecharevision',allowBlank: false},
							{xtype: 'datefield',fieldLabel: 'Fecha Inicio<font color=red>*</font>',name: 'fechainicio',allowBlank: false},
							//{xtype: 'datefield',fieldLabel: 'Fecha Activaci�n<font color=red>*</font>',name: 'fechaactivacion',allowBlank: false},
							{xtype: 'datefield',fieldLabel: 'Fecha Termino<font color=red>*</font>',name: 'fechatermino',allowBlank: false},
							{
								xtype: 'fieldset',
								height:450,
								title: 'Revisi�n/Pagos',
								defaultType: 'textfield',
								columnWidth:.3,
								defaults: {
									anchor: '100%'
								},
								items: [
													//{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: 'Dom. de Revisi�n',name:'diaspago',width:100,  margins: '0 0 0 0',enforceMaxLength:true,maxLength:40 },
									//{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: 'P. Qui�n Revisa',name:'responsable_rev',width:100,  margins: '0 0 0 0',enforceMaxLength:true,maxLength:40 },
									//{xtype: 'textfield',vtype: 'email' , flex: 1,fieldLabel: 'Email Qui�n Rev.',name:'email_resp_rev',width:100,  margins: '0 0 0 0',enforceMaxLength:true,maxLength:40 },
									{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: 'D�as Pago',name:'diaspago',width:100,  margins: '0 0 0 0',enforceMaxLength:true,maxLength:50 },
									//{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: 'Resp. Pago',name:'responsable_pago',width:100,  margins: '0 0 0 0',enforceMaxLength:true,maxLength:40 },
									  {
			       						xtype: 'fieldcontainer',
			       						labelStyle: 'font-weight:bold;padding:0',
			       						layout: 'hbox',
			       						fieldLabel: 'Resp. Pago',
			       						defaultType: 'textfield',
			       						fieldDefaults: {
			       							//labelAlign: 'top'
			       						},
			       						items: [
			       						   
			       						    {xtype: 'myUpperCaseTextField', flex: 4,name:'responsable_pago',width:100,margins: '0 0 0 0',allowBlank: true, readOnly:true  },
			       							{ xtype:'button', flex: 1, width:60, margins: '0 0 0 5',  iconCls:'buscar_white',text:'',scope:this.myscope,
			       								handler: function(){
			       									//Muestra el grid para la seccion de los clientes
			       									this.consultacontactosResponsableCampo();
			       								}
			       							}
			       						    
			       						]
			       					}, 
									{xtype: 'textfield',vtype: 'email' , flex: 1,fieldLabel: 'Email Resp.Pago.',name:'email_resp_pago',width:100,  margins: '0 0 0 0',enforceMaxLength:true,maxLength:40,readOnly:true  }
									
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
	consultacontactos:function(){	
		var mysope=this;
		
		var idcliente = mysope.getValueField('idcliente');
		var razonsocial_cte = mysope.getValueField('razonsocial_cte');
		if ((idcliente==undefined)||(idcliente=='')){
			mensajeWarning("Seleccione un cliente del catalogo");
			return;
		}
		
		//Crea una forma de clientes para agregar los datos
		var grid_cte_contacto_cotizacion_consulta = Ext.create('MyDesktop.view.GridContactos',{
			id:'grid_consulta_contacto_clientes_dir',
			idCliente:idcliente,
			isConsulta:true,
			 isAutoLoad:false
		}); 
		grid_cte_contacto_cotizacion_consulta.setIdCliente(idcliente);
		grid_cte_contacto_cotizacion_consulta.reload(idcliente);
		grid_cte_contacto_cotizacion_consulta.getStore().reload(
				{
					params:{idcliente:idcliente},
					callback:function(r,options,success){
						 if (r.length<=0){
							 mensajeAlert('No existen contactos disponibles');
						 }
					}	  
		});
	
		var windows_consulta_contactos =Ext.create('widget.window', {
			id:'utils-win-consultar-clientes-cotizaciones-disponibles',
			title: "Contactos Cliente "+ razonsocial_cte,
			width: 1000,
			height: 400,
			modal:true,
			plain: true,
			layout: 'fit',
 		    iconCls:'contactos_blue',
			items: grid_cte_contacto_cotizacion_consulta,
			buttons:[
				{iconCls:'seleccionar_white',text:'Seleccionar',handler:
					function(){
						var registro = grid_cte_contacto_cotizacion_consulta.getRegistro();
						if (registro!=undefined){
							mysope.updateFieldCte(registro.get('nombre') + " " + registro.get('apellido'),
									'contacto_cte');
							mysope.updateFieldCte(registro.get('movil') ,	'movil_cte');
							mysope.updateFieldCte(registro.get('telefono') ,	'telefono_cte');
							mysope.updateFieldCte(registro.get('email') ,	'email_cte');
							
							  
							windows_consulta_contactos.close();
						}else{
							mensajeAlert("Seleccione registro de direcci�n.");
				     		return;
						}
					}
				}
			]
		});
		windows_consulta_contactos.show();
		
	
	
	},	
	
	consultacontactosResponsableCampo:function(){
		var campoforma =["responsable_pago", 'email_resp_pago'];
		var campoStore =["responsable_pago",'email'];
		
		
		var mysope=this;
		mysope.updateFieldconsultacontactos(campoforma, campoStore,mysope);
	},
	consultacontactosRepresentante:function(){
		var campoforma =["representantelegal"];
		var campoStore =["representantelegal"];
		
		
		var mysope=this;
		mysope.updateFieldconsultacontactos(campoforma, campoStore,mysope);
	},
	updateFieldconsultacontactos:function(campoforma, campoStore,mysope){	

		
		var idcliente = mysope.getValueField('idcliente');
		var razonsocial_cte = mysope.getValueField('razonsocial_cte');
		if ((idcliente==undefined)||(idcliente=='')){
			mensajeWarning("Seleccione un cliente del catalogo");
			return;
		}
		
		//Crea una forma de clientes para agregar los datos
		var grid_cte_contacto_cotizacion_consulta = Ext.create('MyDesktop.view.GridContactos',{
			id:'grid_consulta_contacto_clientes_dir',
			idCliente:idcliente,
			isConsulta:true,
			 isAutoLoad:false
		}); 
		grid_cte_contacto_cotizacion_consulta.setIdCliente(idcliente);
		grid_cte_contacto_cotizacion_consulta.reload(idcliente);
		grid_cte_contacto_cotizacion_consulta.getStore().reload(
				{
					params:{idcliente:idcliente},
					callback:function(r,options,success){
						 if (r.length<=0){
							 mensajeAlert('No existen contactos disponibles');
						 }
					}	  
		});
	
		var windows_consulta_contactos =Ext.create('widget.window', {
			id:'utils-win-consultar-clientes-cotizaciones-disponibles',
			title: "Contactos Cliente "+ razonsocial_cte,
			width: 1000,
			height: 400,
			modal:true,
			plain: true,
			layout: 'fit',
 		    iconCls:'contactos_blue',
			items: grid_cte_contacto_cotizacion_consulta,
			buttons:[
				{iconCls:'seleccionar_white',text:'Seleccionar',handler:
					function(){
					campoforma, campoStore
						var registro = grid_cte_contacto_cotizacion_consulta.getRegistro();
						if (registro!=undefined){
							for	(index = 0; index < campoforma.length; ++index) {
								if (index==0){
									mysope.updateFieldCte(registro.get('nombre') + " " + registro.get('apellido'),
											campoforma[index]);
								}else{
									mysope.updateFieldCte(registro.get(campoStore[index]) ,
											campoforma[index]);
								}
								
							}
							windows_consulta_contactos.close();
						}else{
							mensajeAlert("Seleccione registro de direcci�n.");
				     		return;
						}
					}
				}
			]
		});
		windows_consulta_contactos.show();
		
	
	
	},	
	consultaclientesrfcsipa:function(){	
		var mysope=this;
		var rfc = mysope.getValueField('rfc');
		var razonsocial_cte = mysope.getValueField('razonsocial_cte');
		
		//Crea una forma de clientes para agregar los datos
		var grid_cte_rfc_consulta = Ext.create('MyDesktop.view.GridClientesRFCs',{id:'grid_rfc_consulta_clientes_dir',
			isConsulta:true}); 
		
		grid_cte_rfc_consulta.buscar(1, rfc);
		var windows_consulta =Ext.create('widget.window', {
			//id:'utils-win-consultar-clientes-rfc-disponibles',
			title: "Clientes Facturaci�n Disponibles",
			width: 1000,
			height: 400,
			modal:true,
			plain: true,
			layout: 'fit',
			iconCls:'clientes_white',
			items: grid_cte_rfc_consulta,
			buttons:[
				{iconCls:'seleccionar_white',text:'Seleccionar',handler:
					function(){
						var registro = undefined;
						
						var rows =  grid_cte_rfc_consulta.getSelectionModel().getSelection();
						if(rows.length >0){
							registro =  rows[0];
						}
						
						
						if (registro!=undefined){
							mysope.updateFieldCte(registro.get('numCliente'), 'numcliente');
							if ((rfc==undefined) || (rfc=='')){
								mysope.updateFieldCte(registro.get('rfc'), 'rfc');
							}
							if ((razonsocial_cte==undefined) || (razonsocial_cte=='')){
								mysope.updateFieldCte(registro.get('razonSocial'), 'razonsocial_cte');
							}
							
							
							windows_consulta.close();
						}else{
							Ext.Msg.alert('Verificar',"Seleccione registro de dirección.");
				     		return;
						}
					}
				}
			]
		});
		windows_consulta.show();
		grid_cte_rfc_consulta.buscar(1, rfc);
		
	},
	
	consultaclientes:function(){	
		var mysope=this;
		 var idcliente = mysope.getValueField('idcliente');
		 var numcliente = mysope.getValueField('numcliente');
		 var rfc = mysope.getValueField('rfc');
		//Crea una forma de clientes para agregar los datos
		var grid_cte_cotizacion_consulta = Ext.create('MyDesktop.view.GridConsultaDireccionesCliente',
				{
					id:'grid_consulta_clientes_dir',
					idcliente:idcliente, 
					numcliente:numcliente,
					ocultaFiltros:true
				}); 
		//grid_cte_cotizacion_consulta.buscarDireccionesCliente(numcliente);
		 	
		grid_cte_cotizacion_consulta.buscar('1', rfc);
		var windows_consulta =Ext.create('widget.window', {
			id:'utils-win-consultar-clientes-cotizaciones-disponibles',
			title: "Direcciones Disponibles",
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
							mysope.updateFieldCte(registro.get('rfc'), 'rfc');
							windows_consulta.close();
						}else{
							Ext.Msg.alert('Verificar',"Seleccione registro de direcci�n.");
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
							Ext.Msg.alert('Verificar',"Seleccione registro de direcci�n.");
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
	},
	setWinPrincipal:function(winp){
			this.winprincipal = winp;
		}

});