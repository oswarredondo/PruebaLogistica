Ext.define('MyDesktop.form.FormDatosEtiqueta', {
 extend: 'Ext.form.Panel',
    xtype: 'clienterdireccion-form',
    frame: false,
    width: 400,
    border: false,
    bodyPadding: 10,
	method:'POST',
    fieldDefaults: {
       // labelAlign: 'top',
        labelWidth: 100,
        labelStyle: 'font-weight:bold'
    },
	comboTipos:undefined,
	showReadOnly:false,
    defaults: {
        anchor: '100%',
        margins: '0 0 10 0'
    },
	forma: undefined,
	myscope:undefined,
	 layout: 'column',
	idcliente:undefined,
	operacion:undefined,
	main_grid:undefined, 
	main_window:undefined,
	//indica el sufijo que debe tener el nombre del campo, esto sirve apara poder identificar remy destino
	sufijo:'', 
	autoScroll:true,
	initComponent: function () {
		var main_grid = this.main_grid;
		var operacion_aplicar = this.operacion;
		var idcliente_id = this.idcliente==undefined?'':this.idcliente;
	
		
		this.comboTipos = Ext.create('MyDesktop.store.StoreTiposPersona',{});
		this.myscope=this;
		var scope_main = this;

		this.items= [
		  {xtype : 'hidden', name:"_csrf", value:vt},
		             {xtype:'hidden', name:'iddireccion'},
		             {xtype:'hidden', name:'identificador' , value:idcliente_id},
		            
				  		{
							xtype: 'fieldset',
							columnWidth:.295,
							title: titulo_remitente,
							defaultType: 'textfield',	
							width:800,
							defaults: {
								anchor: '100%'
							},
							items: [
								{  xtype: 'myUpperCaseTextField', name: 'rfc_rem',
									fieldLabel: fieldForzoso(field_rfc),emptyText: '',allowBlank: false,enforceMaxLength:true,maxLength:20},
					             {  xtype: 'myUpperCaseTextField', name: 'razonsocial_rem',
										fieldLabel: fieldForzoso(field_razonsocial),
										emptyText: '',allowBlank: false,enforceMaxLength:true,maxLength:40},
								    {xtype: 'myUpperCaseTextField', flex: 4,
											fieldLabel: fieldForzoso(field_atencion),name:'atencion_rem',
											width:100,margins: '0 0 0 0',allowBlank: true,
								    	enforceMaxLength:true,maxLength:40},
					             {  xtype: 'myUpperCaseTextField', name: 'calle_rem',
								    		fieldLabel: fieldForzoso(field_calle),emptyText: '',
								    		allowBlank: false,enforceMaxLength:true,maxLength:40},
					             {xtype: 'myUpperCaseTextField', flex: 1,
								    			fieldLabel: fieldForzoso(field_numinterior),name:'numinterior_rem',width:100, 
									margins: '0 0 0 5',enforceMaxLength:true,maxLength:10,allowBlank: false},
									{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: field_numexterior,name:'numexterior_rem',width:100,
										margins: '0 0 0 5',enforceMaxLength:true,maxLength:10},
								{
									xtype: 'fieldcontainer',
									labelStyle: 'font-weight:bold;padding:0',
									layout: 'hbox',
									emptyText: field_cp,
									defaultType: 'textfield',
									fieldDefaults: {
										//labelAlign: 'top'
									},
									items: [
									   
									        {xtype: 'myUpperCaseTextField',  flex: 2,fieldLabel: fieldForzoso(field_cp),name:'cp_rem',width:100, 
									        	margins: '0 0 0 0',enforceMaxLength:true,maxLength:5,allowBlank: false },
									        { xtype:'button', flex: 1,width:80,  margins: '0 0 0 5',  iconCls:'buscar_white',text:titulo_btn_buscar,
									        		scope:this.myscope,id:'btnBuscarCP_'+this.id,
					       								handler:this.showGridCps}
									]
								},
							
								{
									xtype: 'fieldcontainer',
									labelStyle: 'font-weight:bold;padding:0',
									layout: 'hbox',
									emptyText: field_colonia,
									defaultType: 'textfield',
									fieldDefaults: {
										//labelAlign: 'top'
									},
									items: [
									   
											{xtype: 'myUpperCaseTextField', flex: 2,fieldLabel: 
												
												fieldForzoso(fieldColonia),name:'colonia_rem',
												width:100,margins: '0 0 0 0',enforceMaxLength:true,maxLength:50,allowBlank: false},
												  { xtype:'button', flex: 1,width:80,  margins: '0 0 0 5', 
													iconCls:'buscar_white',text:titulo_btn_buscar,
									        		scope:this.myscope,id:'btnBuscarColonia_'+this.id,
					       								handler:this.showGridCps}
									]
								},
								{
									xtype: 'fieldcontainer',
									labelStyle: 'font-weight:bold;padding:0',
									layout: 'hbox',
									emptyText: field_municipio,
									defaultType: 'textfield',
									fieldDefaults: {
										//labelAlign: 'top'
									},
									items: [
									   
											{xtype: 'myUpperCaseTextField', flex: 2,
												fieldLabel: fieldForzoso(field_municipio),name:'municipio_rem',width:100, 
												margins: '0 0 0 0',enforceMaxLength:true,maxLength:50,allowBlank: false},
												  { xtype:'button', flex: 1,width:80,  margins: '0 0 0 5', 
													iconCls:'buscar_white',text:titulo_btn_buscar,
									        		scope:this.myscope,id:'btnBuscarMunicipio_'+this.id,
					       								handler:this.showGridCps}	
									]
								},
							{xtype: 'myUpperCaseTextField', flex: 1,
									fieldLabel: field_estado,name:'estado_rem',width:100,  margins: '0 0 0 0',
									enforceMaxLength:true,maxLength:40},
							{xtype: 'myUpperCaseTextField', flex: 1,
									fieldLabel: field_telefono,name:'telefono_rem',width:100,  margins: '0 0 0 0',
										enforceMaxLength:true,maxLength:30},
							{xtype: 'myUpperCaseTextField', flex: 1,
									fieldLabel: field_celular,name:'celular_rem',width:100,  margins: '0 0 0 0',
											enforceMaxLength:true,maxLength:20},
							{xtype: 'myUpperCaseTextField', flex: 1,
									fieldLabel: field_correoe,name:'email_rem',width:100,  margins: '0 0 0 0',
												enforceMaxLength:true,maxLength:30}
							
							]
					
					},
					{
						xtype: 'fieldset',
						title: 'Datos Destinatario',
						columnWidth:.295,
						defaultType: 'textfield',	
						defaults: {
							anchor: '100%'
						},
						items: [
							{  xtype: 'myUpperCaseTextField', name: 'rfc_des',
								fieldLabel: fieldForzoso(field_rfc),emptyText: '',
								allowBlank: false,enforceMaxLength:true,maxLength:20},
					         {  xtype: 'myUpperCaseTextField', name: 'razonsocial_des',
									fieldLabel: fieldForzoso(field_razonsocial),
									emptyText: '',allowBlank: false,enforceMaxLength:true,maxLength:40},
							    {xtype: 'myUpperCaseTextField', flex: 4,
										fieldLabel: field_atencion,name:'atencion_des',width:100,margins: '0 0 0 0',
										allowBlank: true,
							    	enforceMaxLength:true,maxLength:40},
					         {  xtype: 'myUpperCaseTextField', name: 'calle_des',
							    		fieldLabel: fieldForzoso(field_calle),emptyText: '',
							    		allowBlank: false,enforceMaxLength:true,maxLength:40},
					         {xtype: 'myUpperCaseTextField', flex: 1,
							    			fieldLabel: fieldForzoso(field_numinterior),name:'numinterior_des',
							    			width:100, 
								margins: '0 0 0 5',enforceMaxLength:true,maxLength:10,allowBlank: false},
								{xtype: 'myUpperCaseTextField', flex: 1,
									fieldLabel: field_numexterior,name:'numexterior_des',width:100,
									margins: '0 0 0 5',enforceMaxLength:true,maxLength:10},
							{
								xtype: 'fieldcontainer',
								labelStyle: 'font-weight:bold;padding:0',
								layout: 'hbox',
								emptyText: field_cp,
								defaultType: 'textfield',
								fieldDefaults: {
									//labelAlign: 'top'
								},
								items: [
								   
								        {xtype: 'myUpperCaseTextField',  flex: 2,
								        	fieldLabel: fieldForzoso(field_cp),name:'cp_des',width:100, 
								        	margins: '0 0 0 0',enforceMaxLength:true,maxLength:5,allowBlank: false },
								        { xtype:'button', flex: 1,width:80,  margins: '0 0 0 5',  
								        		iconCls:'buscar_white',text:titulo_btn_buscar,
								        		scope:this.myscope,id:'btnBuscarCP_des'+this.id,
					   								handler:this.showGridCps}
								]
							},
						
							{
								xtype: 'fieldcontainer',
								labelStyle: 'font-weight:bold;padding:0',
								layout: 'hbox',
								emptyText: field_colonia,
								defaultType: 'textfield',
								fieldDefaults: {
									//labelAlign: 'top'
								},
								items: [
								   
										{xtype: 'myUpperCaseTextField', flex: 2,
											fieldLabel: fieldForzoso(field_colonia),name:'colonia_des',
											width:100,margins: '0 0 0 0',enforceMaxLength:true,maxLength:50,allowBlank: false},
											  { xtype:'button', flex: 1,width:80,  margins: '0 0 0 5',  
												iconCls:'buscar_white',text:titulo_btn_buscar,
								        		scope:this.myscope,id:'btnBuscarColonia_des'+this.id,
					   								handler:this.showGridCps}
								]
							},
							{
								xtype: 'fieldcontainer',
								labelStyle: 'font-weight:bold;padding:0',
								layout: 'hbox',
								emptyText: field_municipio,
								defaultType: 'textfield',
								fieldDefaults: {
									//labelAlign: 'top'
								},
								items: [
								   
										{xtype: 'myUpperCaseTextField', flex: 2,
											fieldLabel: fieldForzoso(field_municipio),name:'municipio_des',
											width:100, 
											margins: '0 0 0 0',enforceMaxLength:true,maxLength:50,allowBlank: false},
											  { xtype:'button', flex: 1,width:80,  margins: '0 0 0 5',  
												iconCls:'buscar_white',text:titulo_btn_buscar,
								        		scope:this.myscope,id:'btnBuscarMunicipio_des'+this.id,
					   								handler:this.showGridCps}	
								]
							},
						{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: field_estado,name:'estado_des',width:100,  margins: '0 0 0 0',
								enforceMaxLength:true,maxLength:40},
						{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: field_telefono,name:'telefono_des',width:100,  margins: '0 0 0 0',
									enforceMaxLength:true,maxLength:30},
						{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: field_celular,name:'celular_des',width:100,  margins: '0 0 0 0',
										enforceMaxLength:true,maxLength:20},
						{ flex: 1,fieldLabel: field_correoe,
											name:'email_des',width:100,  margins: '0 0 0 0',
											enforceMaxLength:true,maxLength:30,vtype: 'email'}
						
						]
					
					
					}
		];
		this.tbar=[
			 {
					
					text : titulo_btn_buscar,
					iconCls : 'buscar_blue',
					handler : this.buscaInfoDirecciones
				}, {
					
					text : titulo_btn_guardar,
					tooltip : tooltip_guardar_datos,
					iconCls : 'save_blue', 
					handler : this.saveDatosCliente
				},
				{
					
					text : titulo_btn_oficinas,
					tooltip : tooltip_oficinas_ocurres,
					iconCls : 'contactos_blue',
					handler : this.buscaInfoOficinas 
				} ,
				{
					
					text : titulo_btn_ubicacion_mapa,
					tooltip : tooltip_google_maps,
					iconCls : 'map_blue',
					handler : this.searchGMAP 
				}
			];
	
		/*this.buttons= [
				{ hidden: this.showReadOnly, text: 'Salvar', iconCls:'activo',handler:function() {
						var form = this.up('form').getForm();
						if (form.isValid()) {
							var out = [];
							Ext.Object.each(form.getValues(), function(key, value){
								out.push(key + '=' + value);
							});
							var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Agregando informaci�n espere..."});
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
									
									alertMsg('Error' , action.result.message);
								}
							});
						
							
						}else{
							alertMsg('Complete los campos requeridos.');
						}
					}
			}//,
			//{text: 'Salir'},
		];*/
	
		this.callParent();
		
	},
	 searchGMAP:function(){
		//En base al sufijo se realiza la actualizacion de los campos
		 //y la obtenci�n de datos
		var datos =  "latitud=&longitud=&colonia=Paraiso&municipio=Iztapalapa&cp=09230"+
				"&estado=DF&pais=Mexico&isadministracion=false&calle=Ligero de Toluca"+
				"&idoficina=&telefono=&nombre=";
		showGMapWindows(datos,'','');
			
	 },
	 buscaInfoOficinas:function(){
	 },
	 saveDatosCliente:function(){
		 
	 },
	
	buscaInfoDirecciones:function(){
		
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
		var scope_main=this;
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
		
		var gridcps = Ext.create('MyDesktop.grid.GridConsultaCPs', { 
			isEditable:true,
			cp_field:'cp'+scope_main.sufijo ,colonia_field:'colonia'+scope_main.sufijo,
			municipio_field:'municipio'+scope_main.sufijo,estado_field:'estado'+scope_main.sufijo,
			fields: fields,form:Ext.getCmp(this.id).getForm(),
			tipoconsulta:tipoconsulta,patron:patron,
			cp:patron, colonia:patron,municipio: patron
		}); 
		  
		var buscacps_window = new Ext.Window({
				width    : 880,height   : 350,
				layout   : 'border',
				title	: titulo_btn_consulta_cps,
				closable:false,
				headerPosition: 'left',
				items    : [
				   {items   : gridcps,layout :'fit',region :'center',height   : 100}
				   ],
				buttons: [
					{text   : titulo_btn_salir,
						handler: function(){buscacps_window.close();}}
		        ]
			}); 
		gridcps.setScopeWin(buscacps_window);	
		 buscacps_window.show();
	
	},
	
	setIdCliente:function(idcliente){
		this.idcliente=idcliente;
		
		//actualiza el dato del campo
		this.updateFieldCte(idcliente,'identificador');
	},
	setMainWindow:function(mainwin){
		this.main_window= mainwin;
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
	}
	
});