Ext.define('MyDesktop.view.FormUsuariosSesion', {
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
		
		this.items= [
				{  xtype: 'myUpperCaseTextField',fieldLabel: 'Num. Cliente',  name: 'numcliente',allowBlank:false, maxLength:6,width:150,
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
	
	showGridCps: function(b, e){
		var fields = Ext.getCmp(this.id).getForm().getFields( ) ;
		var tipoconsulta='cp'  ;
		var patron ='';
		var boton = b.id.split("_")[0];
		if (boton=='btnBuscarCP'){
			 tipoconsulta='cp'  ;
			 patron=getValueFormField('cp',fields);   //Ext.getCmp('idcp').getValue();
		}else if (boton=='btnBuscarColonia'){
			 tipoconsulta='colonia'  ;
			 patron=getValueFormField('colonia',fields);   //Ext.getCmp('idcolonia').getValue();
		}else if (boton=='btnBuscarMunicipio'){
			 tipoconsulta='municipio'  ;
			 patron=getValueFormField('municipio',fields);   //Ext.getCmp('idmunicipio').getValue();
		}else{
			alert('Tipo de consulta inválida.');
		}		
		
		var gridcps = Ext.create('MyDesktop.view.GridConsultaCPs', { 
			isEditable:true,
			cp_field:'cp' ,colonia_field:'colonia', municipio_field:'municipio',estado_field:'estado',
			fields: fields,form:Ext.getCmp(this.id).getForm(),
			tipoconsulta:tipoconsulta,patron:patron,
			cp:patron, colonia:patron,municipio: patron
		}); 
		  
		var buscacps_window = new Ext.Window({
				width    : 880,height   : 350,
				layout   : 'border',
				title	: 'Busqueda de códigos postales',
				closable:false,
				headerPosition: 'left',
				items    : [
				   {items   : gridcps,layout :'fit',region :'center',height   : 100}
				   ],
				buttons: [
					{text   : 'Salir',handler: function(){buscacps_window.close();}}
		        ]
			}); 
		gridcps.setScopeWin(buscacps_window);	
		 buscacps_window.show();
	
	},
	
	setIdCliente:function(idcliente){
		this.idcliente=idcliente;
	},
	consultaclientes:function(){	
		var mysope=this;
		
		//Crea una forma de clientes para agregar los datos
		var grid_cte_cuenta_cte_consulta = Ext.create('MyDesktop.view.GridConsultaDireccionesCliente',{id:'grid_con_cuenta_clientes_dir'}); 

		var windows_consulta_dir_cuenta_cliente =Ext.create('widget.window', {
			id:'utils-win-consultar-clientes-cotizaciones-disponibles',
			title: "Clientes Disponibles",
			width: 900,
			height: 400,
			modal:true,
			plain: true,
			layout: 'fit',
			iconCls:'clientes_white',
			items: grid_cte_cuenta_cte_consulta,
			buttons:[
				{iconCls:'seleccionar_white',text:'Seleccionar',handler:
					function(){
						var registro = grid_cte_cuenta_cte_consulta.getRegistro();
						if (registro!=undefined){
							mysope.updateFieldCte(registro.get('idcliente'), 'cuentaMaestra');
							mysope.updateFieldCte(registro.get('numcliente'), 'numCliente');
							mysope.updateFieldCte(registro.get('descripcion'), 'razonSocial');
							mysope.updateFieldCte(registro.get('telefono'), 'telefono');
							
							var calle= registro.get('calle')==undefined?"":registro.get('calle');
							var numinterior= registro.get('numinterior')==undefined?"":registro.get('numinterior');
							var numexterior= registro.get('numexterior')==undefined?"":registro.get('numexterior');
							calle = calle + " " + numinterior +" "+numexterior;
							mysope.updateFieldCte(calle, 'calle');
							

							mysope.updateFieldCte(registro.get('cp'), 'cp');
							mysope.updateFieldCte(registro.get('colonia'), 'colonia');
							mysope.updateFieldCte(registro.get('municipio'), 'municipio');
							mysope.updateFieldCte(registro.get('estado'), 'estado');
							windows_consulta_dir_cuenta_cliente.close();
						}else{
							Ext.Msg.alert('Verificar',"Seleccione registro de direcci�n.");
				     		return;
						}
					}
				}
			]
		}).show();
	},
	showGridCps: function(b, e){
		var fields = Ext.getCmp(this.id).getForm().getFields( ) ; 
		var tipoconsulta='cp'  ;
		var patron ='';
		var boton = b.id.split("_")[0];
		if (boton=='btnBuscarCP'){
			 tipoconsulta='cp'  ;
			 patron=getValueFormField('cp',fields);   //Ext.getCmp('idcp').getValue();
		}else if (boton=='btnBuscarColonia'){
			 tipoconsulta='colonia'  ;
			 patron=getValueFormField('colonia',fields);   //Ext.getCmp('idcolonia').getValue();
		}else if (boton=='btnBuscarMunicipio'){
			 tipoconsulta='municipio'  ;
			 patron=getValueFormField('municipio',fields);   //Ext.getCmp('idmunicipio').getValue();
		}else{
			alert('Tipo de consulta inválida.');
		}		

		
		var gridcps_cuenta_cte = Ext.create('MyDesktop.view.GridConsultaCPs', { 
			id:'GridConsultaCPs_Consulta_Cuenta_Cte',
			isEditable:true,
			cp_field:'cp' ,colonia_field:'colonia', municipio_field:'municipio',estado_field:'estado',
			fields: fields,form:Ext.getCmp(this.id).getForm(),
			tipoconsulta:tipoconsulta,patron:patron,
			cp:patron, colonia:patron,municipio: patron
		}); 
		
		var buscacps_cuenta_cte_window = new Ext.Window({
				width    : 880,height   : 350,
				layout   : 'border',
				title	: 'Busqueda de códigos postales',
				closable:false,
				headerPosition: 'left',
				items    : [
				   {items   : gridcps_cuenta_cte,layout :'fit',region :'center',height   : 100}
				   ],
				buttons: [
					{text   : 'Salir',handler: function(){buscacps_cuenta_cte_window.close();}}
		        ]
			}); 
		gridcps_cuenta_cte.setScopeWin(buscacps_cuenta_cte_window);	
		buscacps_cuenta_cte_window.show();
	
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