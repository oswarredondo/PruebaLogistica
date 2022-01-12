Ext.define('MyDesktop.form.FormBusquedaEnvio', {
 extend: 'Ext.form.Panel',
    xtype: 'usuario-cuenta-cliente-form',
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
        this.bbar= [
                    	{text:'Buscar'}    
                    
                    ];
        
        var gridMovimientosHistoria = 
        	Ext.create('MyDesktop.grid.GridMovimientosHistoria',{
        		 title: 'Historia',layout:'fit', height:300,width:200
        	});
        var gridGuiasPaquetes = 
        	Ext.create('MyDesktop.grid.GridGuiasPaquetes',{
        		 title: 'Paquetes',layout:'fit', height:210,width:200
        	});

        
		this.items= [
		      {
	                      xtype: 'combobox', fieldLabel: 'Búsqueda',  editable :false, name: 'tipo',
	                      store: Ext.create('MyDesktop.store.StoreMovimientosHistoria',{}),width: 300,
	                      valueField: 'idtipo', displayField: 'descripcion',enforceMaxLength:true,
	      				  maxLength:30, typeAhead: true, queryMode: 'local',  allowBlank: false, emptyText: '',
	      				 readOnly:this.showReadOnly
	            },
	            {  xtype: 'myUpperCaseTextField',fieldLabel: 'Patrón',  name: 'numcliente',allowBlank:false, maxLength:4,width:150,
					enforceMaxLength:true,value:this.numcliente, readOnly:true}, 
				{ xtype: 'datefield', name:'fechainicial',fieldLabel: 'F. Inicial',
						name:'fechainicialcotizacion', format: 'd-m-Y', labelWidth: 80, width: 190},
				{ xtype: 'datefield',  name:'fechafinal',fieldLabel: 'F. Final',
							name:'fechainicialcotizacion', format: 'd-m-Y', labelWidth: 80, width: 190},
							gridGuiasPaquetes,
							gridMovimientosHistoria			
		
							
				
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