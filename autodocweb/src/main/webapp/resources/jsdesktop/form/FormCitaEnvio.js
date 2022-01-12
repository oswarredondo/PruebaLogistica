Ext.define('MyDesktop.form.FormCitaEnvio', {
 extend: 'Ext.form.Panel',
    xtype: 'cita-envio-form',
    frame: false,
    width: 400,
    layout: 'anchor',
	method:'POST',
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
				{ xtype: 'datefield', name:'fechachita',fieldLabel: field_fecha,
					 format: 'd-m-Y', labelWidth: 80, width: 190},
				{ xtype:'timefield',name:'horacita',allowBlank:false,width:80 , format:'H:i'},
			    {  xtype: 'myUpperCaseTextField',fieldLabel: field_folio,  name: 'folio',allowBlank:false, maxLength:4,width:150}

			];
		
		this.buttons= [
						{  text: titulo_btn_salvar, iconCls:'activo',handler:function() {
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
										submitEmptyText: false,
										url: './catalogo/clientesrfc/' + operacion_aplicar,
										success: function(form, action) {
											myMask.hide( );
											myMask.disable();
											
											if (main_grid!=undefined){
												main_grid.buscar(0,0);
											}
											
											if (scope_main.main_window!=undefined){
												scope_main.main_window.close();
											}
											mensajeConfirm(action.result.message);
						
										},
										failure: function(form, action) {
											myMask.hide( );
											myMask.disable();
											
											alertMsg(titulo_alerta , action.result.message);
										}
									});
								
									
								}else{
									alertMsg(msg_datos_requeridos);
								}
							}
					}//,
					//{text: 'Salir'},
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

	
});