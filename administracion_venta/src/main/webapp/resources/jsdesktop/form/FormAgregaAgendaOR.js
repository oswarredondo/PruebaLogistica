Ext.define('MyDesktop.form.FormAgregaAgendaOR', {
 extend: 'Ext.form.Panel',
    xtype: 'agregado-agenda-form',
    frame: false,
    width: 650,
  
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
    winprincipal:undefined,
	operacion:undefined,
	idsolicitud:undefined,
	iddocumento:undefined,
	remite:undefined,
	destino:undefined,	
	isConGuia:false,
	initComponent: function () {
		var scopemy=this;
		
		var scope_grid_origen = this.grid_scope;
    	var operacion_aplicar = this.operacion;

		this.items= [
		
				            {xtype:'hidden', name:'folio', value:-1},
				             {
		    	                 xtype: 'combobox',
		    	                 fieldLabel: 'Prioridad',
		    	                 editable :false,
		    	                 name: 'prioridad',
		    	                 store: Ext.create('MyDesktop.store.StoreTiposPrioridad',{}),
		    	                 valueField: 'idtipo',
		    	                 displayField: 'idtipo',
		    	 				 enforceMaxLength:true,
		    	 				 maxLength:30,
		    	                 typeAhead: true,
		    	                 queryMode: 'local',
		    	                 allowBlank: false,
		    	                 emptyText: '',
		    	                 value:'MEDIA'
		    	             },
		    	             {
		    	                 xtype: 'combobox',
		    	                 fieldLabel: 'Tipo Problema',
		    	                 editable :false,
		    	                 name: 'tipoproblema',
		    	                 store: Ext.create('MyDesktop.store.StoreTiposProblemaAgenda',{}),
		    	                 valueField: 'idtipo',
		    	                 displayField: 'idtipo',
		    	 				 enforceMaxLength:true,
		    	 				 maxLength:30,
		    	                 typeAhead: true,
		    	                 queryMode: 'local',
		    	                 allowBlank: false,
		    	                 emptyText: '',
		    	                 value:'VERIFICACION DE ENTREGA'
		    	             },
		    	             
		    	             {
		    	                 xtype: 'combobox',
		    	                 fieldLabel: 'Reclama',
		    	                 editable :false,
		    	                 name: 'quiensolicita',
		    	                 store: Ext.create('MyDesktop.store.StoreTiposSolicitaOR',{}),
		    	                 valueField: 'idtipo',
		    	                 displayField: 'idtipo',
		    	 				 enforceMaxLength:true,
		    	 				 maxLength:30,
		    	                 typeAhead: true,
		    	                 queryMode: 'local',
		    	                 allowBlank: false,
		    	                 emptyText: '',
		    	                 value:'REMITENTE'
		    	             },
		    	             
				       {
		    	            xtype: 'myUpperCaseTextField', 	 
				            fieldLabel: 'Nombre ',
				            emptyText: 'Nombre de quien reclama',
				            name: 'nombresolicita',
				            maxLength:50,
				            allowBlank: false
				        },
				        {
		    	            xtype: 'myUpperCaseTextField', 	 
				            fieldLabel: 'Teléfono ',
				            emptyText: 'Tel de quien reclama',
				            name: 'telefonosolicita',
				            maxLength:50,
				            allowBlank: false
				        },
				       
				        
				        
				        {
                            xtype: 'fieldcontainer',
                            height: 26,
                            fieldLabel: '',
                            layout: {
                                type: 'hbox',
                                align: 'stretch'
                            },
                            items: [
                                {
                                    xtype: 'myUpperCaseTextField',
                                    width: 333,
                                    enforceMaxLength:true,
                                    fieldLabel: 'Guía',
                                    //allowBlank: false,
                                    name: 'iddocumento',
                                    readOnly:scopemy.isConGuia,
                                    value:scopemy.iddocumento,
                                    maxLength:30
                                }/*,
                                { 
                                    xtype: 'button',
                                    margins: '0 0 0 5',
                                    width: 35,
                                    iconCls:'buscar_blue',
                                    handler: this.showDatosGuia,
                                    scope:this
                                }*/
                            ]
                        },
                        {
                            xtype: 'fieldset',
                            title: 'Datos Rotulacion',
                            collapsible: false,
                            defaults: {
                                labelWidth: 89,
                                anchor: '100%',
                                labelAlign: 'top',
                                layout: {
                                    type: 'hbox',
                                    defaultMargins: {top: 0, right: 5, bottom: 0, left: 0}
                                }
                            },
                            items: [

                               
                                {
                                    xtype : 'fieldcontainer',
                                    combineErrors: true,
                                    msgTarget: 'side',
                                    fieldLabel: '',
                                    height:135,
                                    defaults: {
                                        hideLabel: false,
                                        labelAlign: 'top'
                                    },
                                    items : [
                                             
										{
										     xtype: 'myUpperCaseTextArea', 	 
										     fieldLabel: 'Remitente',
										     name: 'datosorigen',
										     allowBlank: true,
										     readOnly:scopemy.isConGuia,
										     flex : 1,
										     height:120,
										     value:scopemy.remite,
										     fieldStyle: {
										         'fontSize'     : '11px'
										       }
										
										 },
										 {
		            		    	            xtype: 'myUpperCaseTextArea', 	 
		            				            fieldLabel: 'Destinatario',
		            				            name: 'datosdestino',
		            				            allowBlank: true,
		            				            readOnly:scopemy.isConGuia,
		            				            flex : 1,
		            				            height:120,
		            				            value:scopemy.destino,
		            				            fieldStyle: {
		            				                'fontSize'     : '11px'
		            				              }
		            				            
		            				        }
                                    ]
                                }
                            ]
                        },

                        {
 		    	            xtype: 'myUpperCaseTextArea', 	 
 				            fieldLabel: 'Requerimiento',
 				            name: 'nota',
 				            allowBlank: false,
 				           
 				            height:100,
 				           labelAlign: 'top',
 				            fieldStyle: {
 				                'fontSize'     : '11px'
 				              }
 				        },
 				       {
  				            xtype: 'checkboxgroup',
 				            fieldLabel: 'Agregar a la Nota',
 				            cls: 'x-check-group-alt',
 				            // Distribute controls across 3 even columns, filling each row
 				            // from left to right before starting the next row
 				            columns: 2,
 				            items: [

 				                {boxLabel: 'Confirmación Entrega', name: 'cb-entrega', checked: true},
 				                {boxLabel: 'Ultimo Registro de Historia', name: 'cb-historia'}
 				            ]
 				        },
 				        {
 				            xtype: 'radiogroup',
 				            fieldLabel: 'Asignar caso a',
 				            cls: 'x-check-group-alt',
 				            items: [
 				                {boxLabel: 'Plaza Origen', name: 'rb-plaza', inputValue: 1},
 				                {boxLabel: 'Plaza Destino', name: 'rb-plaza', inputValue: 2, checked: true}
 				            ]
 				        }
                       
				        
				       
				        
				       
				        
				        
				        
	
			];
		
    		this.buttons= [
    	               {
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
    	     							var ventana = creaVentanaEspera ();
    	     							form.submit({
    	     								clientValidation: true,
    	     								timeOut:999999,
    	     								url: '../agendarastreo/'+operacion_aplicar,
    	     								success: function(form, action) {
    	     									
    	     									ventana.close();
    	     									
    	     									mensajeConfirm(action.result.message);
    	     									
    	     									if (scopemy.grid_scope!=undefined){
    	     										scopemy.grid_scope.reloadInfo();
    	     									}
    	     									
    	     									if (scopemy.winprincipal!=undefined){
    	     										scopemy.winprincipal.close();
    	     									}
    
    	     								},
    	     								failure: function(form, action) {
    	     									ventana.close();
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
		
		
	
		this.callParent();
		
	},
	showDatosGuia:function(){
		
	},
   setWinPrincipal:function(win){
	 this.winprincipal = win;  
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

	
});