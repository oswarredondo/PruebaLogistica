Ext.define('MyDesktop.form.FormDiaMes', {
 extend: 'Ext.form.Panel',
    xtype: 'dia-semana-form',
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
    winprincipal:undefined,
	operacion:undefined,
	idsolicitud:undefined,
	initComponent: function () {
		var scopemy=this;
		var scope_grid_origen = this.grid_scope;
    	var operacion_aplicar = this.operacion;

		this.items= [
		        {xtype:'hidden', name:'idsolicitud', value:this.idsolicitud,	allowBlank: false},     
				{
					xtype: 'combobox',
					name: 'diasemanames',
					width:250,
					anchor: '100%',
					fieldLabel: 'Día',
					allowBlank: false,
					store: Ext.create('MyDesktop.store.StoreDiasMes',{}),
					forceSelection:true,
					editable:false,
					valueField: 'idtipo',
					displayField: 'descripcion',
					typeAhead: true,
					queryMode: 'local',
					emptyText: '',
					value:'1',
					 listeners: { 
						 select: function(combo, records, eOpts ){ 
						 },
					     change:function( obj, newValue, oldValue, eOpts )	{
					     
					     }
					 }
				},
				{xtype: 'myUpperCaseTextField', 
					fieldLabel:'Hora/Observacion',
					name:'observacion',
					allowBlank:false,maxLength:40
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
    	     								url: '../diassolicitud/insertDiaMes',
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