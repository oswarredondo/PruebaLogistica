Ext.define('MyDesktop.form.FormConvenioDescuentoFact', {
    extend: 'Ext.form.Panel',
    xtype: 'login-form',

    frame:false,
	border:false,
    width: 320,
    bodyPadding: 10,
    showReadOnly:false,
    defaultType: 'textfield',
    defaults: {
        anchor: '100%',
		labelWidth: 80
    },
    idconvenio:undefined,
    operacion:undefined,
    showReadOnly:true,
    grid_principal:undefined,
    idconveniodescfact:undefined,
     initComponent: function(){
    	 
    	 var operacion_aplicar = this.operacion;
 		var myscope= this;
 		
		 this. buttons= [
		                 /*{hidden: this.showReadOnly,
            text: 'Limpiar',iconCls:'limpiar_white',
            scope: this,
            handler: this.onResetClick
        }, */{
			hidden: this.showReadOnly,
            text: 'Guardar',iconCls:'activo',
            scope: this,
            handler: this.guardar
        }/*,
        {
			hidden: this.showReadOnly,
            text: 'Borrar',iconCls:'borrar',
            scope: this,
            handler: this.onCompleteClick
        }*/
        ];		
		//Ext.apply(this, {
		this.items= [
			        {xtype:'hidden', name:'idconveniodescfact', value:(this.idconveniodescfact==undefined?0:this.idconveniodescfact)},
			        {xtype:'hidden', name:'idconvenio', 
			        	value:(this.idconvenio==undefined?0:this.idconvenio)},
				
				{
					xtype : 'numberfield',
					fieldLabel: 'Rango Inicial',
					name: 'rangoinicial',
					value: 1,
					allowBlank:false,
					minValue: 1,
					maxValue: 999999
				},
				{
					xtype : 'numberfield',
					fieldLabel: 'Rango Final',
					name: 'rangofinal',
					value: 1,
					allowBlank:false,
					minValue: 1,
					maxValue: 999999
				},
				{
					xtype : 'numberfield',
					fieldLabel: 'Descuento',
					name: 'descuento',
					value: 1,
					allowBlank:false,
					minValue: 1,
					maxValue: 99
				}
			]
		 
		// });
		 
		 this.callParent();
	 },
	 
	guardar:function(){
		var form = this.getForm();
		var scope_gen= this;
		if (form.isValid()) {
					
			form.submit({
				clientValidation: true,
				url: '../convenio/descuentofactura/' + this.operacion,
				success: function(form, action) {
					/*if (this.operacion!='update'){
						form.reset();
					}
					if (scope_gen.winprincipal!=undefined){
						scope_gen.winprincipal.close();
					}
					mensajeConfirm(action.result.message);*/
					if (scope_gen.grid_principal!=undefined){
						scope_gen.grid_principal.buscar();
					}
					

				},
				failure: function(form, action) {
				
					mensajeAlert(action.result.message);
				}
			});
		
			
		}else{
			mensajeWarning('Complete los campos requeridos.');
		}
	} ,
   
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
	}
});