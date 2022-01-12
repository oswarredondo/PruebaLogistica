Ext.define('MyDesktop.form.FormAsignarAgendaOR', {
 extend: 'Ext.form.Panel',
    xtype: 'dia-semana-form',
    frame: false,
    width: 400,
    layout: 'anchor',
    border: false,
    bodyPadding: 10,
    frame: true,
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
	initComponent: function () {
		var scopemy=this;
		var scope_grid_origen = this.grid_scope;
    	var operacion_aplicar = this.operacion;

		this.items= [
		             {xtype:'hidden', name:'folio'},
				{
				    xtype: 'fieldset',
				    title: 'Información',
				    defaultType: 'textfield',
				    defaults: {
				        width: 280
				    },
				    items: [
				       
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
		    	                 value:'MEDIO',
		    	                 readOnly:true
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
		    	                 value:'REMITENTE',
		    	                 readOnly:true
		    	             },
		    	             
				       {
		    	            xtype: 'myUpperCaseTextField', 	 
				            fieldLabel: 'Nombre ',
				            emptyText: 'Nombre de quien reclama',
				            name: 'nombresolicita',
				            maxLength:50,
				            allowBlank: false,
	    	                 readOnly:true
				        },
				        {
		    	            xtype: 'myUpperCaseTextField', 	 
				            fieldLabel: 'Teléfono ',
				            emptyText: 'Tel de quien reclama',
				            name: 'telefonosolicita',
				            maxLength:50,
				            allowBlank: false,
	    	                 readOnly:true
				        },
				       
				        
				        
				        {
                            xtype: 'myUpperCaseTextField',
                            width: 333,
                            enforceMaxLength:true,
                            fieldLabel: 'Guía',
                            allowBlank: false,
                            name: 'iddocumento',
                            maxLength:30,
	    	                readOnly:true
                        },
                        
                        {
		    	            xtype: 'myUpperCaseTextArea', 	 
				            fieldLabel: 'Datos Origen ',
				            name: 'datosorigen',
				            allowBlank: true,
				            readOnly:true,
				            heigth:100,
	    	                readOnly:true
				        },
				        {
                            xtype: 'datefield',
                            width: 180,
                            fieldLabel: 'Fecha Atiende',
                            labelWidth: 50,
                            allowBlank: false,
                          
                            name: 'fechacierre'
                        },
                        {
		    	            xtype: 'myUpperCaseTextField', 	 
				            fieldLabel: 'Depto Atiende',
				            name: 'depto_que_atiende',
				            allowBlank: true
				        },
				        {
		    	            xtype: 'myUpperCaseTextField', 	 
				            fieldLabel: 'Quién Atiende',
				            name: 'nombre_quien_atiende',
				            allowBlank: true
				        }
				        
				       
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
    	     							form.submit({
    	     								clientValidation: true,
    	     								url: '../agendarastreo/updateAtiende',
    	     								success: function(form, action) {
    	     									
    	     									
    	     									if (scopemy.grid_scope!=undefined){
    	     										scopemy.grid_scope.reloadInfo();
    	     									}
    	     									
    	     									if (scopemy.winprincipal!=undefined){
    	     										scopemy.winprincipal.close();
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