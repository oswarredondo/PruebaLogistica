Ext.define('MyDesktop.view.FormUsuarios', {
 extend: 'Ext.form.Panel',
    xtype: 'usuario-cuenta-cliente-form',
    frame: false,
    width: 400,
    layout: 'anchor',
    border: false,
    bodyPadding: 10,
    fieldDefaults: {
       // labelAlign: 'top',
        labelWidth: 125,
        labelStyle: 'font-weight:bold'
    },
	comboTipos:undefined,
	showReadOnly:false,
    defaults: {
        anchor: '100%',
        margins: '0 0 10 0'
    },
    grid_scope:undefined,
	identidad:undefined,
	idorganizacion:undefined,
	consecutivo:undefined,
	isModificaPassword:false,
	numcliente:undefined,
	operacion:undefined,
	initComponent: function () {
		var scope_grid_origen = this.grid_scope;
    	var operacion_aplicar = this.operacion;
    	var isUpdate = operacion_aplicar=='update'?true:false;
    	
    	var store_tipos_agrupamiento= Ext.create('MyDesktop.store.StoreAgrupamiento',{});
		var store_visibilidad = Ext.create('MyDesktop.store.StoreVisibilidad',{}) ;
    	
    	var store_perfiles = Ext.create('MyDesktop.store.StorePerfil',
				{baseParams:{identidad:this.identidad,idorganizacion:this.idorganizacion,numCliente:this.numcliente}});
		store_perfiles.getProxy().setExtraParam("identidad", this.identidad);
		store_perfiles.getProxy().setExtraParam("idorganizacion", this.idorganizacion);
		store_perfiles.getProxy().setExtraParam("onlyActive", false);
		store_perfiles.load();
		
		//Se carga el combo para que pueda mostrar los datos al momento de setear el valor
		var store_tipos_nivel_usuario = Ext.create('MyDesktop.store.StoreNivelUsuario',
				{
					baseParams:{vertodos:'true'}
				}
		);
		store_tipos_nivel_usuario.getProxy().setExtraParam("vertodos",'true');
		store_tipos_nivel_usuario.load();
		
		this.fieldDefaults= {
             labelAlign: 'right',
             labelWidth: 90,
             msgTarget: 'qtip'
         };
		this.defaultType= 'textfield';
        var scope_my = this; 
		
		this.items= [
			    {xtype:'hidden', name:'identidad', value:this.identidad},
			    {xtype:'hidden', name:'idorganizacion', value:this.idorganizacion},
			    {xtype:'hidden', name:'consecutivo', value:this.consecutivo},
				{  xtype: 'myUpperCaseTextField',fieldLabel: 'Num. Cliente',  name: 'numcliente',allowBlank:false, maxLength:6,width:150,enforceMaxLength:true,value:this.numcliente, readOnly:true}, 
				{ xtype: 'myUpperCaseTextField',fieldLabel: 'Nombre',  name: 'nombre',allowBlank:false, maxLength:25,width:300 },
				{ xtype: 'myUpperCaseTextField',fieldLabel: 'Plaza',  name: 'siglasplaza',allowBlank:false, maxLength:3,width:300,enforceMaxLength:true },
				{ fieldLabel: 'Tabla Consecutivo', tooltip:'Si el usuario tiene su propia tabla de control de consecutivos indique su identificador',
					name: 'formatoetimedia',allowBlank:true, maxLength:20,width:300,enforceMaxLength:true },
				{ fieldLabel: 'Formato Eti Per.',  name: 'formatoetiperso',allowBlank:true, maxLength:20,width:300,enforceMaxLength:true },
				{ xtype: 'myUpperCaseTextField',fieldLabel: 'Id.Oficina',  name: 'idoficina',allowBlank:true, maxLength:4,width:300,enforceMaxLength:true },
				{ xtype: 'myUpperCaseTextField',fieldLabel: '#Empleado',  name: 'numempleado',allowBlank:true, maxLength:4,width:300 ,enforceMaxLength:true},
				{ xtype: 'myUpperCaseTextField',fieldLabel: 'Login',  name: 'login',allowBlank:true, maxLength:20,width:300,enforceMaxLength:true,
					regex: getValorParametroSistema('regex.esturctura.login.usuario'),allowBlank:false,
					regexText:'Login de usuario inv�lido debe ser ' + getValorParametroSistema('regex.esturctura.login.usuario'), readOnly:isUpdate },
				{ xtype: 'textfield',fieldLabel: 'E-mail', vtype: 'email',
						name: 'email',allowBlank:true, maxLength:40,width:300,enforceMaxLength:true },
				
				/*   {
                    xtype: 'combobox',
                    fieldLabel: 'Agrupaci�n',
                    editable :false,
                    name: 'idagrupamiento',
                    store: store_tipos_agrupamiento,
                    //store: Ext.create('MyDesktop.store.StoreAgrupamiento',{}),
                    valueField: 'idagrupamiento',
                    displayField: 'descripcion',
    				enforceMaxLength:true,
    				maxLength:30,
                    typeAhead: true,
                    queryMode: 'local',
                    allowBlank: false,
                  
                    emptyText: ''
                },*/

				{xtype: 'combobox',fieldLabel: 'Puesto',name: 'nivelpuesto',
                    store: store_tipos_nivel_usuario,
                    valueField: 'identificador',
                    displayField: 'descripcion',
    				enforceMaxLength:true,
    				maxLength:30,
    				width:300 ,
                    typeAhead: true,
                    queryMode: 'local',
                    allowBlank: false,
                    forceSelection: true,
                    emptyText: ''
                },
                {xtype: 'combobox',fieldLabel: 'Perfil',name: 'idperfil',
                    store: store_perfiles,
                    valueField: 'idperfil',
                    displayField: 'descripcion_perfil',
    				enforceMaxLength:true,
    				maxLength:30,
    				width:300 ,
                    typeAhead: true,
                    queryMode: 'local',
                    allowBlank: false,
                    forceSelection: true,
                    emptyText: ''
                },
                {
                    xtype: 'combobox',
                    fieldLabel: 'Visibilidad de Grupo',
                    editable :false,
                    name: 'visibilidad',
                    store: Ext.create('MyDesktop.store.StoreVisibilidad',{}),
                    valueField: 'identificador',
                    displayField: 'descripcion',
    				enforceMaxLength:true,
    				maxLength:30,
                    typeAhead: true,
                    queryMode: 'local',
                    allowBlank: false,
                    emptyText: ''
                }
                
			];
		this.buttons= [
		         {
		            text: 'Limpiar',iconCls:'limpiar_white',
		            scope: this,
		            handler: function(){
		                this.getForm().reset();
		            }
		        }, 

		        {
		            text: 'Guardar',iconCls:'activo',
		            scope: this,
		            handler:function() {
						var form = this.getForm();
						if (form.isValid()) {
							var out = [];
							Ext.Object.each(form.getValues(), function(key, value){
								out.push(key + '=' + value);
							});
							var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Agregando información espere..."});
							myMask.show();
							
							form.submit({
								clientValidation: true,
								url: '../catalogo/usuario/' + operacion_aplicar,
								success: function(form, action) {
									myMask.hide( );
									myMask.disable();
									mensajeConfirm(action.result.message);
									
									if (scope_grid_origen!=undefined){
										scope_grid_origen.reload(scope_grid_origen.identidad,
												scope_grid_origen.idorganizacion, 
												scope_grid_origen.numcliente);
								
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
											mensajeAlert(action.response.statusText +"-" + action.response.responseText);
										}
									}
								}
							});
						
							
						}else{
							mensajeWarning('Complete los campos requeridos.');
						}
					}
		        }];
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
	
	showGridCps: function(b, e){
		var fields = Ext.getCmp(this.id).getForm().getFields( ) ;
		var tipoconsulta='cp'  ;
		var patron ='';
		var boton = b.id.split("_")[0];
		if (boton=='btnBuscarCP'){
			 tipoconsulta='cp'  ;
			 patron=getValueFormField('cp',fields);   //Ext.getCmp('idcp').getValue();
		}else if (boton=='btnBuscarColonia'){
			 tipoconsulta='colonia'  ;
			 patron=getValueFormField('colonia',fields);   //Ext.getCmp('idcolonia').getValue();
		}else if (boton=='btnBuscarMunicipio'){
			 tipoconsulta='municipio'  ;
			 patron=getValueFormField('municipio',fields);   //Ext.getCmp('idmunicipio').getValue();
		}else{
			alert('Tipo de consulta inválida.');
		}		
		
		var gridcps = Ext.create('MyDesktop.view.GridConsultaCPs', { 
			isEditable:true,
			cp_field:'cp' ,colonia_field:'colonia', municipio_field:'municipio',estado_field:'estado',
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
	
	setIdCliente:function(idcliente){
		this.idcliente=idcliente;
	},
	consultaclientes:function(){	
		var mysope=this;
		
		//Crea una forma de clientes para agregar los datos
		var grid_cte_cuenta_cte_consulta = Ext.create('MyDesktop.view.GridConsultaDireccionesCliente',{id:'grid_con_cuenta_clientes_dir'}); 

		var windows_consulta_dir_cuenta_cliente =Ext.create('widget.window', {
			id:'utils-win-consultar-clientes-cotizaciones-disponibles',
			title: "Clientes Disponibles",
			width: 900,
			height: 400,
			modal:true,
			plain: true,
			layout: 'fit',
			iconCls:'clientes_white',
			items: grid_cte_cuenta_cte_consulta,
			buttons:[
				{iconCls:'seleccionar_white',text:'Seleccionar',handler:
					function(){
						var registro = grid_cte_cuenta_cte_consulta.getRegistro();
						if (registro!=undefined){
							mysope.updateFieldCte(registro.get('idcliente'), 'cuentaMaestra');
							mysope.updateFieldCte(registro.get('numcliente'), 'numCliente');
							mysope.updateFieldCte(registro.get('descripcion'), 'razonSocial');
							mysope.updateFieldCte(registro.get('telefono'), 'telefono');
							
							var calle= registro.get('calle')==undefined?"":registro.get('calle');
							var numinterior= registro.get('numinterior')==undefined?"":registro.get('numinterior');
							var numexterior= registro.get('numexterior')==undefined?"":registro.get('numexterior');
							calle = calle + " " + numinterior +" "+numexterior;
							mysope.updateFieldCte(calle, 'calle');
							

							mysope.updateFieldCte(registro.get('cp'), 'cp');
							mysope.updateFieldCte(registro.get('colonia'), 'colonia');
							mysope.updateFieldCte(registro.get('municipio'), 'municipio');
							mysope.updateFieldCte(registro.get('estado'), 'estado');
							windows_consulta_dir_cuenta_cliente.close();
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
			 patron=getValueFormField('cp',fields);   //Ext.getCmp('idcp').getValue();
		}else if (boton=='btnBuscarColonia'){
			 tipoconsulta='colonia'  ;
			 patron=getValueFormField('colonia',fields);   //Ext.getCmp('idcolonia').getValue();
		}else if (boton=='btnBuscarMunicipio'){
			 tipoconsulta='municipio'  ;
			 patron=getValueFormField('municipio',fields);   //Ext.getCmp('idmunicipio').getValue();
		}else{
			alert('Tipo de consulta inválida.');
		}		

		
		var gridcps_cuenta_cte = Ext.create('MyDesktop.view.GridConsultaCPs', { 
			id:'GridConsultaCPs_Consulta_Cuenta_Cte',
			isEditable:true,
			cp_field:'cp' ,colonia_field:'colonia', municipio_field:'municipio',estado_field:'estado',
			fields: fields,form:Ext.getCmp(this.id).getForm(),
			tipoconsulta:tipoconsulta,patron:patron,
			cp:patron, colonia:patron,municipio: patron
		}); 
		
		var buscacps_cuenta_cte_window = new Ext.Window({
				width    : 880,height   : 350,
				layout   : 'border',
				title	: 'Busqueda de códigos postales',
				closable:false,
				headerPosition: 'left',
				items    : [
				   {items   : gridcps_cuenta_cte,layout :'fit',region :'center',height   : 100}
				   ],
				buttons: [
					{text   : 'Salir',handler: function(){buscacps_cuenta_cte_window.close();}}
		        ]
			}); 
		gridcps_cuenta_cte.setScopeWin(buscacps_cuenta_cte_window);	
		buscacps_cuenta_cte_window.show();
	
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

	
});