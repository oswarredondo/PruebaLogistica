Ext.define('MyDesktop.form.FormReporteDevoluciones', {
 extend: 'Ext.form.Panel',
    xtype: 'reporte-devoluciones-ocurre-form',
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
	usuariosesion:undefined,
	method:'POST',
	initComponent: function () {
		
		var scope_grid_origen = this.grid_scope;
    	var operacion_aplicar = this.operacion;
    	
		
		this.fieldDefaults= {
             labelAlign: 'right',
             labelWidth: 90,
             msgTarget: 'qtip'
         };
		this.defaultType= 'textfield';
        var scope_my = this; 
		
		this.items= [
		               {xtype : 'hidden', name:"_csrf", value:vt},
                 {
               	  xtype: 'datefield',
               	  fieldLabel: field_fechadevolucion,name: 'fechaexpira',allowBlank: false,
               	  	maxValue: new Date(),width: 300, readOnly:this.showReadOnly, value:new Date()
                 }
                
				
			];
		
		  this.buttons= [
          
		        {
		        hidden:this.showReadOnly,
				text: titulo_btn_salvar ,
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
							var myMask = new Ext.LoadMask(Ext.getBody(), {msg:msg_generando_infomacion_espere});
							myMask.show();

							
							form.submit({
								clientValidation: true,
								url: './tareas/'+operacion_aplicar ,
								success: function(form, action) {
									myMask.hide( );
									myMask.disable();
									mensajeConfirm(action.result.message);
									if (scope_grid_pricipal!=undefined){
										scope_grid_pricipal.loadInfo();
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