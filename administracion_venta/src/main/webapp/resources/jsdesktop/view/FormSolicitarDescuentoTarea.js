Ext.define('MyDesktop.view.FormSolicitarDescuentoTarea', {
    extend: 'Ext.form.Panel',
    xtype: 'register-tarea-form',

    frame: false,
	border:false,
    bodyPadding: 10,
    autoScroll:true,
	myscope:undefined,
    showReadOnly:false, //Configura la pantalla para que solo muestre los datos pero no permita cambiar la informacion
    operacion:undefined,
    idconvenio:undefined,
    fieldDefaults: {
        labelAlign: 'right',
        //labelWidth: 115,
        msgTarget: 'side'
    },
    tituloTarea:'',
    contenido:'',
    scope_view_pricipal:undefined,
    main_grid:undefined,
    idtarea:undefined,
    grid_usuarios_grupo_nivel:undefined,
    mostrarSoloUsuarioConNivelSuperior:false,
    showRespuesta:false,
    windowsform:undefined,
    initComponent: function() {
    	var operacion_aplicar = this.operacion;
    	var iseditablle =true;//this.operacion=='update'?true:false;
    	var scopemy=this;
    	this.myscope= this;
    	var scope_grid_pricipal = this.main_grid;
	    this.buttons= [
	       {
	                	  
	           			text: 'Seleccionar Usuarios Grupo',
	           			scope: scopemy,
	           			hidden:this.showReadOnly,
	           			handler:scopemy.getNivelAgrupacion
	        },           
	        {
	        hidden:this.showReadOnly,
			text: 'Salvar',
			disabled: true,
			formBind: true,
			iconCls:'activo',
			handler:function() {
					var form = this.up('form').getForm();
					//Verifica el tipo de ambito 
					var ambito = scopemy.getValueField('ambito');
						
					if ((ambito=='USUARIO') || 
						(ambito=='GRUPO') || 
						(ambito=='NIVEL') ){
						//Obtiene los registros seleccionados del grid
						
						var rows =  scopemy.grid_usuarios_grupo_nivel.getSelectionModel().getSelection();
						if(rows.length <=0){
							mensajeAlert("Debe seleccionar a los usuarios a los que desea notificar.");
							return;
						}
						
						var registros ='';
		       			for (i=0;i<rows.length;i++){
		       				
		       				registros = registros+  rows[i].get('login')+ ",";
		       			}

		       			scopemy.updateFieldCte(registros, 'idambitotarea');
						if ((scopemy.getValueField('idambitotarea')==undefined) || 
							(scopemy.getValueField('idambitotarea')=='') ){
							mensajeAlert("Debe seleccionar a los usuarios a los que desea notificar.");
	  						return;
						}
    	        		
    	        	}
        	        	
					var estatus = scopemy.getValueField('estatus');
					if ((estatus=='CANCELADA') || 
							(estatus=='CERRADA') || 
							(estatus=='REASIGNADA') || 
							(estatus=='RECHAZADA') 
						){
						if(scopemy.getValueField('solucion')==''){
							mensajeAlert("Debe capturar solución de la tarea.");
	  						return;
						}
						
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
								url: '../tareas/'+operacion_aplicar ,
								success: function(form, action) {
									myMask.hide( );
									myMask.disable();
									//mensajeConfirm(action.result.message);
									if (scope_grid_pricipal!=undefined){
										scope_grid_pricipal.loadInfo();
									}
									if (scopemy.windowsform!=undefined){
										scopemy.windowsform.close();
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
											mensajeAlert(action.response.statusText + ","+ action.response.responseText);
										}
									}
									
								}
							});
						
							
						}else{
							mensajeWarning('Complete los campos requeridos.');
						}
					}
		}];
		this.myscope= this;
		
		this.grid_usuarios_grupo_nivel = new MyDesktop.view.GridUsuariosDisponiblesTarea(
				{
					title:'Seleccione usuarios a enviar aviso.',width:650, height :200,
					mostrarSoloUsuarioConNivelSuperior:this.mostrarSoloUsuarioConNivelSuperior
				}
		);
        this.items = [
                   {xtype:'hidden', name:'idtarea'}, 
                   {xtype:'hidden', name:'idtareaorigina'}, 
                   
                   {
                 	  xtype: 'myUpperCaseTextField',fieldLabel: 'Titulo',name: 'titulo',allowBlank: false,width: 500,
                 	  enforceMaxLength:true,maxLength:50, value:scopemy.tituloTarea
                   },
                   {
                      xtype: 'combobox', fieldLabel: 'Tipo',  editable :false, name: 'tipo',
                      store: Ext.create('MyDesktop.store.StoreTiposTareas',{}),width: 300,
                      valueField: 'idtipo', displayField: 'descripcion',enforceMaxLength:true,
      				  maxLength:30, typeAhead: true, queryMode: 'local',  allowBlank: false, emptyText: '',
      				 readOnly:this.showReadOnly,
      				  listConfig: {
      					  getInnerTpl: function(displayField) {
      					  return '<img src="../resources/images/{image}"/> {' + displayField + '}';
      					  }
      				  }
                  },
                 /* {
                 	  xtype: 'myUpperCaseTextField',fieldLabel: 'Estatus',name: 'estatus',allowBlank: false,width: 500,
                 	  enforceMaxLength:true,maxLength:50, value:'ABIERTA',readOnly:true
                   },*/
                  {
                      xtype: 'combobox', fieldLabel: 'Estatus', editable :false, name: 'estatus',
                      store: Ext.create('MyDesktop.store.StoreTiposTareasEstatus',{}),width: 300,
                      valueField: 'idtipo',displayField: 'descripcion',enforceMaxLength:true,
                      maxLength:30, typeAhead: true, queryMode: 'local',  allowBlank: false, emptyText: '',
                      readOnly:this.showReadOnly,
                      listConfig: {
      					  getInnerTpl: function(displayField) {
      					  return '<img src="../resources/images/{image}"/> {' + displayField + '}';
      					  }
      				  }
                  },
                   {
                  	  xtype: 'myUpperCaseTextField',fieldLabel: 'Ámbito',name: 'ambito',allowBlank: false,width: 500,
                  	  enforceMaxLength:true,maxLength:50, value:'USUARIO',readOnly:true
                    },

                  {
                      xtype: 'combobox', fieldLabel: 'Importancia', editable :false, name: 'importancia',
                      store: Ext.create('MyDesktop.store.StoreTiposImportaciaTareas',{}),width: 300,
                      valueField: 'idtipo',displayField: 'descripcion',enforceMaxLength:true,
                      maxLength:30, typeAhead: true, queryMode: 'local',  allowBlank: false, emptyText: '',
                      readOnly:this.showReadOnly,
                      listConfig: {
      					  getInnerTpl: function(displayField) {
      					  return '<img src="../resources/images/{image}"/> {' + displayField + '}';
      					  }
      				  }
                  },
  				  {
                	  xtype: 'datefield',fieldLabel: 'Fecha Expira',name: 'fechaexpira',allowBlank: false,
                	  	minValue: new Date(),width: 300, readOnly:this.showReadOnly
                  },
                  {
                	  xtype: 'htmleditor',fieldLabel: 'Mensaje',name: 'solicitud',allowBlank: false, width:650,
                	    height: 150	, readOnly:this.showReadOnly,value:scopemy.contenido
                  },

                  this.grid_usuarios_grupo_nivel,
                  {
                	  xtype: 'hidden',fieldLabel: 'Usuarios',name: 'idambitotarea',allowBlank: 
                		  true,width: 300,
                	  enforceMaxLength:true,maxLength:50,readOnly:this.showReadOnly
                  },
                  {
  					xtype:'checkbox',
  					 readOnly:this.showReadOnly,
  					fieldLabel: 'Enviar correo',
  					name: 'enviarcorreo'
  				  },
                  {
                	  xtype: 'htmleditor',fieldLabel: 'Solución',name: 'solucion',allowBlank: false, width:650,
                	    height: 150	, hidden:!this.showRespuesta
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
					//alert("Encontrado:" +campo+", valor:" +  valor) ;
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
	getNivelAgrupacion:function(){
		var valorambito = this.getValueField('ambito');
		var scope = this;
		var combo=undefined;
		var valor='';
		if (valorambito=='GRUPO'){
			var store_tipos_agrupamiento= Ext.create('MyDesktop.store.StoreAgrupamiento',{});

			comboitem = {
			       	  xtype: 'combobox',fieldLabel: 'Grupo',name: 'idnivelgrupotareaadm',
			          store: store_tipos_agrupamiento,  valueField: 'idagrupamiento',
			          id:'nivelgrupotareaadm',
			          displayField: 'descripcion',enforceMaxLength:true,maxLength:30,width:300 ,
			          typeAhead: true, queryMode: 'local',allowBlank: false, forceSelection: true,
			           emptyText: '',
			           listeners: {
               	        select:function( combo, records, eOpts ){
               	        	//alert(records[0].data.idagrupamiento);
               	          }
			           }
			        };
		}else if (valorambito=='NIVEL'){
			//Se carga el combo para que pueda mostrar los datos al momento de setear el valor
			var store_tipos_nivel_usuario = Ext.create('MyDesktop.store.StoreNivelUsuario',
					{
						baseParams:{vertodos:'true'}
					}
			);
			store_tipos_nivel_usuario.getProxy().setExtraParam("vertodos",'true');
			store_tipos_nivel_usuario.load();
			comboitem = {
			       	  xtype: 'combobox',fieldLabel: 'Puesto',name: 'idnivelgrupotareaadm',
			       	 id:'nivelgrupotareaadm',
			             store: store_tipos_nivel_usuario,  valueField: 'identificador',
			             displayField: 'descripcion',enforceMaxLength:true,maxLength:30,width:300 ,
			             typeAhead: true, queryMode: 'local',allowBlank: false, forceSelection: true,
			             emptyText: '',
			             listeners: {
		               	        select:function( combo, records, eOpts ){
		               	        	//alert(records[0].data.identificador);
		               	          }
					           }
			         };
		}else{
			mensajeWarning('Seleccione grupo o puesto(nivel)');
			return;
		}
        var form = Ext.create('Ext.form.Panel', {
        	fieldDefaults: {
                labelWidth: 100
            },
        	items: [
        	     comboitem   
        	]
        	
        });
		var windows_tarea = Ext.create('widget.window', {
			id:'utils-win-datonivelgrupo-Tarea',
			title: "Seleccionar dato",
			iconCls: 'agregar',
			width: 400,
			height: 120	,
			modal:true,
			  bodyPadding: 10,
			plain: true,
			layout: 'fit',
			items: form,
			buttons:[
			         {
			        	text:'Seleccionar Valor',
			        	handler:function(){
			        		scope.updateFieldCte(Ext.getCmp('nivelgrupotareaadm').getValue(),'idambitotarea');
			        		windows_tarea.close();
			         	}
			         }
			    ]
			
		});
		windows_tarea.show();
	},
	
	setMainWindows:function(win){
		this.windowsform=win;
	}
	
});