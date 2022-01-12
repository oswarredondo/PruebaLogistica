Ext.define('MyDesktop.view.FormTarifasRangoZona', {
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
     initComponent: function(){
		 this. buttons= [{hidden: this.showReadOnly,
            text: 'Limpiar',iconCls:'limpiar_white',
            scope: this,
            handler: this.onResetClick
        }, {
			hidden: this.showReadOnly,
            text: 'Guardar',iconCls:'activo',
            scope: this,
            handler: this.onCompleteClick
        }];		
		Ext.apply(this, {
			items: [
				{
					 xtype: 'myUpperCaseTextField',
					allowBlank: false,
					fieldLabel: 'Zona',
					name: 'zona',
					emptyText: 'Indique Zona'
				},
				{
					xtype : 'numberfield',
					fieldLabel: 'KM inicial',
					name: 'kminicial',
					value: 0,
					minValue: 0,
					maxValue: 99999
				},
				{
					xtype : 'numberfield',
					fieldLabel: 'KM Final',
					name: 'kmfinal',
					value: 1,
					minValue: 1,
					maxValue: 99999
				},
				{
					xtype : 'numberfield',
					fieldLabel: 'Precio',
					name: 'precio',
					value: 1,
					minValue: 1,
					maxValue: 99999
				}
			]
		 
		 });
		 
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
	}
});