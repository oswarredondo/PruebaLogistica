Ext.define('MyDesktop.view.FormTarifas', {
    extend: 'Ext.form.Panel',
    xtype: 'login-form',

    frame:false,
	border:false,
    width: 320,
    bodyPadding: 10,
    
    defaultType: 'textfield',
    defaults: {
        anchor: '100%'
    },
    operacion:undefined,
    grid_principal:undefined,
	initComponent: function () {
		var operacion_aplicar = this.operacion;
		this.myscope=this;
		var myscope = this;
		
		
		var combo_forma_pago= Ext.create('Ext.form.ComboBox', {
			fieldLabel: 'Forma Pago',
			readOnly: false,
			editable:false,
			//forceSelection:true,
			store: Ext.create('MyDesktop.store.StoreFormaPago',{}) ,
			queryMode: 'local',
			emptyText: 'Seleccione Tipo',
			displayField: 'descripcion',
			valueField: 'clave',
			name:'idformapago'
		}); 
		
		var combo_forma_pago= Ext.create('Ext.form.ComboBox', {
			fieldLabel: 'Forma Pago',
			readOnly: this.operacion=='clonar'?true:false,
			editable:false,
			//forceSelection:true,
			store: Ext.create('MyDesktop.store.StoreFormaPago',{}) ,
			queryMode: 'local',
			emptyText: 'Seleccione Tipo',
			displayField: 'descripcion',
			valueField: 'clave',
			name:'idformapago'
		}); 
		
		var combo_servicio= Ext.create('Ext.form.ComboBox', {
			fieldLabel: 'Servicio',
			readOnly: this.operacion=='clonar'?true:false,
			editable:false,
			//forceSelection:true,
			store: Ext.create('MyDesktop.store.StoreServicio',{}) ,
			queryMode: 'local',
			emptyText: 'Seleccione Tipo',
			displayField: 'descripcion',
			valueField: 'idservicio',
			name:'idservicio'
		});  
		var combo_es_visible_pdv= Ext.create('Ext.form.ComboBox', {
			fieldLabel: 'Es visible en PDV?',
			readOnly: this.operacion=='clonar'?true:false,
			editable:false,
			//forceSelection:true,
			store: Ext.create('MyDesktop.store.StoreSINO',{}) ,
			queryMode: 'local',
			emptyText: 'Seleccione Tipo',
			displayField: 'descripcion',
			valueField: 'identificador',
			name:'es_visible_pdv',
			value:0
		});  
		
	    this.items= [
	            {xtype:'hidden', name:'idtarifa' },
	            
	            {
                    xtype: 'checkbox',
                    name: 'es_default',
                    boxLabel: 'Es Default?',
                    hideLabel: true,
                    checked: false,
                    margin: '0 0 10 0',
                    scope: this,
                    handler: function(box, checked){}
                },
	            {
						xtype: 'myUpperCaseTextField',
						name:'nombre',
						fieldLabel: 'Nombre',
						readOnly: this.operacion=='clonar'?true:false,
						enforceMaxLength:true,
				        maxLength:40,
				        minLength:1, 
				        required:true,
				        enforceMaxLength:true
				},
				{
						xtype: 'myUpperCaseTextField',
				        name:'descripcion',
				        fieldLabel: 'Descripcion',
				        readOnly: this.operacion=='clonar'?true:false,
						enforceMaxLength:true,
						maxLength:40,
				        minLength:1,
				        required:true,
				        enforceMaxLength:true
				},
				combo_forma_pago,
				combo_servicio,
				{
				            xtype: 'datefield',
				            fieldLabel: 'Fecha Inicial',
				            name:'fechainicial',
				            format: 'd-m-Y',
				            disabledDays: [0, 6],
				            disabledDaysText: 'Fechas iniciales no permitidas en fin de semana'
				},
				{
				            xtype: 'datefield',
				            fieldLabel: 'Fecha Final',
				            name:'fechafinal',
				            format: 'd-m-Y'
				},
			     

			    
				 {xtype: 'numberfield',name: 'porcentaje_incremento_precio', id:'porcentaje_incremento_precio'+myscope.id,fieldLabel: '% Precio Servicio',
					 hidden: this.operacion!='clonar'?true:false,
            		value: 0,	maxValue: 99,	allowDecimals:false,
            		required:true, minValue: 0,emptyText: '% Incremento Precio Servicio',
            		allowBlank: false,enforceMaxLength:true},
            		
            	 {xtype: 'numberfield',name: 'porcentaje_incremento_kgsobrepeso',id:'porcentaje_incremento_kgsobrepeso'+myscope.id,fieldLabel: '% Precio Kg SP',
   					 hidden: this.operacion!='clonar'?true:false,
               		value: 0,	maxValue: 99,	allowDecimals:false,
               		required:true, minValue: 0,emptyText: '% Incremento Precio Kg Sobre Peso',
               		},

				combo_es_visible_pdv
	    ]; 
	    
	    this.buttons= [
	                   {
		                	hidden: this.showReadOnly,
				            text: 'Limpiar',iconCls:'limpiar_white',
				            scope: this,
				            disabled: this.operacion=='clonar'?true:false,
				            handler: function(){
				            	var form = this.up('form').getForm();
				            	form.reset();
				            }
		                },
	   				{ hidden: this.showReadOnly, text:this.operacion=='clonar'?'Clonar':'Salvar',
	   						iconCls:'activo',handler:function() {
	   						var form = this.up('form').getForm();
	   						var invalidFields =  this.up('form').query("field{isValid()==false}");
	   						var porcentaje_incremento_precio =  Ext.getCmp('porcentaje_incremento_precio'+myscope.id).getValue();
	   						var porcentaje_incremento_kgsobrepeso =  Ext.getCmp('porcentaje_incremento_kgsobrepeso'+myscope.id).getValue();
	   						
	   						if  ((porcentaje_incremento_precio==undefined) || (porcentaje_incremento_precio=='null')){
	   							Ext.getCmp('porcentaje_incremento_precio'+myscope.id).setValue(0);
	   						}
	   						if  ((porcentaje_incremento_kgsobrepeso==undefined) || (porcentaje_incremento_kgsobrepeso=='null')) {
	   							Ext.getCmp('porcentaje_incremento_kgsobrepeso'+myscope.id).setValue(0);
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
	   								url: '../tarifas/' + operacion_aplicar,
	   								success: function(form, action) {
	   									myMask.hide( );
	   									myMask.disable();
	   									alertMsg('Confirmación',action.result.message);
	   									

	   				
	   								},
	   								failure: function(form, action) {
	   									myMask.hide( );
	   									myMask.disable();
	   									
	   									alertMsg('Error' , action.result.message);
	   								}
	   							});
	   						
	   							
	   						}else{
	   							alertMsg('Verifique' ,'Complete los campos requeridos.');
	   						}
	   					}
	   			}//,
	   			//{text: 'Salir'},
	   		];
	    
	    this.callParent();
		
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
					//alert('Campo:' + field.getName() + ', valor:' +valor);
					if (valor!=undefined){
						
						field.setValue(valor);
						
						if (field.getName() =='idservicio' ){
							
							field.getRawValue( record.get('descripcionservicio') );
						}
						if (field.getName() =='idformapago' ){
							
							field.getRawValue( record.get('descripcionformapago') );	
						}
						if (field.getName() =='es_visible_pdv' ){
							
							field.getValue( record.get('es_visible_pdv')+"" );	
						}
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
	

    
   
});