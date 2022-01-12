Ext.define('MyDesktop.form.FormUsuariosSesion', {
 extend: 'Ext.form.Panel',
    xtype: 'usuario-cuenta-cliente-form',
    frame: false,
    width: 400,
    layout: 'anchor',
    border: false,
	method:'POST',
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
				{  xtype: 'myUpperCaseTextField',fieldLabel: 'Num. Cliente',  name: 'numcliente',allowBlank:false, maxLength:4,width:150,
					enforceMaxLength:true,value:this.numcliente, readOnly:true,value:this.usuariosesion.cliente_usuario_windows}, 
					
				{ xtype: 'myUpperCaseTextField',fieldLabel: 'Nombre',  name: 'nombre',allowBlank:false, maxLength:45,width:300,readOnly:true,
						value:this.usuariosesion.nombre_usuario_windows },
				{  xtype: 'myUpperCaseTextField',fieldLabel: 'Perfil',  name: 'perfil_usuario_windows',allowBlank:false, maxLength:4,width:150,
							enforceMaxLength:true,value:this.numcliente, readOnly:true,value:this.usuariosesion.perfil_usuario_windows}, 
				{ xtype: 'myUpperCaseTextField',fieldLabel: 'Puesto',  name: 'descripcionpuesto',allowBlank:true, maxLength:20,width:300,enforceMaxLength:true,
								readOnly:true , value:this.usuariosesion.descripcionpuesto}	,			
				{ xtype: 'myUpperCaseTextField',fieldLabel: 'Plaza',  name: 'siglasplaza',allowBlank:false, maxLength:3,width:300,enforceMaxLength:true,
							readOnly:true,value:this.usuariosesion.plaza_usuario },
					{ xtype: 'myUpperCaseTextField',fieldLabel: 'Id.Oficina',  name: 'idoficina',allowBlank:true, maxLength:4,width:300,
					enforceMaxLength:true,readOnly:true, value:this.usuariosesion.oficina_usuario },
				{ xtype: 'myUpperCaseTextField',fieldLabel: '#Empleado',  name: 'numempleado',allowBlank:true, maxLength:4,width:300 ,
						enforceMaxLength:true,readOnly:true, value:this.usuariosesion.numempleado_usuario},
				{ xtype: 'myUpperCaseTextField',fieldLabel: 'Login',  name: 'login',allowBlank:true, maxLength:20,width:300,enforceMaxLength:true,
							readOnly:true , value:this.usuariosesion.login_usuario_windows}
		
							
				
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