Ext.define('MyDesktop.form.FormCierreAgendaOR', {
 extend: 'Ext.form.Panel',
    xtype: 'dia-semana-form',
    frame: false,
    width: 400,
    layout: 'anchor',
    border: false,
    bodyPadding: 10,
    fieldDefaults: {
       labelAlign: 'top',
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
	isCancelar:false,
	initComponent: function () {
		var scopemy=this;
		var scope_grid_origen = this.grid_scope;
    	var operacion_aplicar = this.operacion;
    	var elemento_cancelar_o_cerrar;
    	if (!this.isCancelar){
    		elemento_cancelar_o_cerrar=  {
                 xtype: 'combobox',
                 fieldLabel: 'Tipo Solución',
                 editable :false,
                 name: 'tiposolucion',
                 store: Ext.create('MyDesktop.store.StoreTipoSolucionAgenda',{}),
                 valueField: 'idtipo',
                 displayField: 'idtipo',
 				 enforceMaxLength:true,
 				 maxLength:30,
                 typeAhead: true,
                 queryMode: 'local',
                 allowBlank: false,
                 emptyText: '',
                 value:'ENTREGADO'
             };
    	}else{
    		elemento_cancelar_o_cerrar= {
    				xtype:'hidden', 
    				 name: 'tiposolucion',
    				value:'CANCELADO'
    					};
    	}
		this.items= [

				       {xtype:'hidden', name:'folio'},
				       elemento_cancelar_o_cerrar,
				        {
		    	            xtype: 'datefield', 	 
				            fieldLabel: 'Fecha evento ',
				            name: 'fechacierre',
				            allowBlank: false,
				            heigth:100
				        },
				        {
		    	            xtype: 'myUpperCaseTextArea', 	 
				            fieldLabel: 'Comentarios Finales ',
				            name: 'comentariocierre',
				            labelAlign: 'top',
				            allowBlank: false,
				            heigth:100
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
    	     								url: '../agendarastreo/updateCierre',
    	     								success: function(form, action) {
    	     									
    	     									ventana.close();
    	     									mensajeConfirm(action.result.message);
    	     									
    	     									if (scopemy.grid_scope!=undefined){
    	     										scopemy.grid_scope.realizaConsulta();
    	     									}
    	     									
    	     									if (scopemy.winprincipal!=undefined){
    	     										scopemy.winprincipal.close();
    	     									}
    
    	     								},
    	     								failure: function(form, action) {
    	     									ventana.close();
    	     									mensajeConfirm(action.result.message);
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