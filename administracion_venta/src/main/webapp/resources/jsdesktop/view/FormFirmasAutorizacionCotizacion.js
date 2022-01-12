Ext.define('MyDesktop.view.FormFirmasAutorizacionCotizacion', {
    extend: 'Ext.form.Panel',
    xtype: 'register-firmas-autorizacion-form',

    frame: false,
	border:false,
    bodyPadding: 10,
    autoScroll:true,
    width: 355,
	idcliente:undefined,
	myscope:undefined,
    showReadOnly:false,
    operacion:undefined,
    idconvenio:undefined,
    fieldDefaults: {
        labelAlign: 'right',
        labelWidth: 115,
        msgTarget: 'side'
    },
    scope_view_pricipal:undefined,
    main_grid:undefined,
    initComponent: function() {
    	var operacion_aplicar = this.operacion;
    	var iseditablle =this.operacion=='update'?true:false;
    	var scopemy=this;
    	this.myscope= this;
    	var scope_grid_pricipal = this.main_grid;
	    this.buttons= [
	        {
	        	text:'Firmas disponibles',
	        	iconCls:'signature_blue',
				handler:this.seleccionaDatosFirmas,
				scope:this
	        },           
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
							var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Agregando información espere..."});
							myMask.show();

							
							form.submit({
								clientValidation: true,
								url: '../convenio/updateFirmas' ,
								success: function(form, action) {
									myMask.hide( );
									myMask.disable();
									mensajeConfirm( action.result.message);
									if (scope_grid_pricipal!=undefined){
										scope_grid_pricipal.filtrar();
									}
									
				
								},
								failure: function(form, action) {
									myMask.hide( );
									myMask.disable();
									if ( (action.result!=undefined) && (action.result.message!=undefined)){
										mensajeAlert( action.result.message);
									}else{
										//Busca si existe un response del servier
										if (action.response.responseText!=null){
											mensajeAlert(action.response.responseText);
										}
									}
									
								}
							});
						
							
						}else{
							mensajeAlert('Complete los campos requeridos.');
						}
					}
		}];
		this.myscope= this;
        this.items = [
              {
				xtype: 'fieldset',
				title: 'Datos Firmas Autorización',
				defaultType: 'textfield',
				defaults: {
					anchor: '100%'
				},
				items: [
				        {xtype:'hidden', name:'idcliente' },
				        { xtype: 'hidden', allowBlank:true, fieldLabel: 'Convenio', name: 'estatus', readOnly:true },
					{ xtype: 'hidden', allowBlank:true, fieldLabel: 'Convenio', name: 'idconvenio', readOnly:true },
					//{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: 'Cliente',name:'clientefirma',width:100, 
					//	margins: '0 0 0 5',enforceMaxLength:true,maxLength:50,allowBlank: true },
						
					{
   						xtype: 'fieldcontainer',
   						labelStyle: 'font-weight:bold;padding:0',
   						layout: 'hbox',
   						fieldLabel: 'Cliente',
   						defaultType: 'textfield',
   						fieldDefaults: {
   							//labelAlign: 'top'
   						},
   						items: [
   						   
   						    {xtype: 'myUpperCaseTextField', flex: 3,name:'clientefirma',width:100,margins: '0 0 0 0',allowBlank: true, readOnly:true,
   						    	enforceMaxLength:true,maxLength:50},
   							{ xtype:'button', flex: 1, width:80, margins: '0 0 0 5',  iconCls:'buscar_white',text:'Buscar',scope:this.myscope,
   								handler: function(){
   									this.myscope.consultacontactos();
   								}
   							}
   						    
   						]
   					}, 
       					
					{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: 'Gerente Comercial',name:'gerentecomercialfirma',width:100, 
							margins: '0 0 0 5',enforceMaxLength:true,maxLength:50,allowBlank: true },
					{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: 'Jefe Zona',name:'jefezonafirma',width:100,
								margins: '0 0 0 5',enforceMaxLength:true,maxLength:50,allowBlank: true },
					{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: 'Coord. Cred. Cob.',name:'coordinadorcreditocobfirma',width:100,
									margins: '0 0 0 5',enforceMaxLength:true,maxLength:50,allowBlank: true },
					{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: 'Dir. Finanzas',name:'directoradmfinanzasfirma',width:100,
										margins: '0 0 0 5',enforceMaxLength:true,maxLength:50,allowBlank: true },
					{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: 'Ejecutivo V.',name:'ejecutivoventasfirma',width:100,
						margins: '0 0 0 5',enforceMaxLength:true,maxLength:50,allowBlank: true }					

									
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
	seleccionaDatosFirmas:function(){
		
		var myscope=this;
     	var gridfirmas = Ext.create('MyDesktop.view.GridDatosAgrupamiento',
     			{
     				isConsulta:true,
     				soloGruposParaUsuario:true
     			}
     	); 
     	
		var windows_cerrar = Ext.create('widget.window', {
			id:'utils-win-agregar-cliente',
			title: "Firmas disponibles",
			width: 900,
			height:300,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: gridfirmas,
			buttons:[
			         {text:'Seleccionar', handler:function(){
			        	   //Obtiene los registros seleccionados del grid
			        	   var registro = gridfirmas.getRowSelected();
			        	   if (registro==undefined){
			        		   mensajeAlert('Seleccione el registro deseado.');
			        		   return;
			        	   }
			        	   //Actualiza los campos con los valores del registro seleccionado
			        	   myscope.updateFieldCte(registro.get('dirfinanzas'), 'directoradmfinanzasfirma');
			        	   myscope.updateFieldCte(registro.get('gerentecomercial'), 'gerentecomercialfirma');
			        	   myscope.updateFieldCte(registro.get('jefezona'), 'jefezonafirma');
			        	   myscope.updateFieldCte(registro.get('creditocobranza'), 'coordinadorcreditocobfirma');
			        	   
			        	   windows_cerrar.close();
			         	}
			      }
			  ]
			
		});
		
		windows_cerrar.show();

	},
	consultacontactos:function(){	
		var mysope=this;
		
		var idcliente = mysope.getValueField('idcliente');
		if ((idcliente==undefined)||(idcliente=='')){
			mensajeWarning("Seleccione un cliente del catalogo");
			return;
		}
		
		//Crea una forma de clientes para agregar los datos
		var grid_cte_contacto_cotizacion_consulta = Ext.create('MyDesktop.view.GridContactos',{
			id:'grid_consulta_contacto_clientes_rev_dir',
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
			id:'utils-win-consultar-clientes-contacto-firmas',
			title: "Contactos Cliente ",
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
									'clientefirma');

							windows_consulta_contactos.close();
						}else{
							mensajeAlert("Seleccione registro de dirección.");
				     		return;
						}
					}
				}     
			]
		});
		windows_consulta_contactos.show();
		
	
	
	},
	setIdCliente:function(idcliente){
		this.idcliente=idcliente;
	}
});