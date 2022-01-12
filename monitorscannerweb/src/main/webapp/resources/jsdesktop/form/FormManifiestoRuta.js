Ext.define('MyDesktop.form.FormManifiestoRuta', {
	extend : 'Ext.form.Panel',
	listapedidos:'',
	listapedidosparametro:'',
	constructor : function(config) {
		// Configura las propiedades
		this.callParent(arguments);
		this.initConfig(config);
		return this;
	},
	grid_principal:undefined,
	windows_principal:undefined,
	initComponent : function(config) {
		this.renderTo=Ext.getBody();
		//this.title= 'Datos de Manifiesto Ruta';
		this.autoHeight= false;
		this.height=380;
		this.width=900;
		this.bodyPadding=10;
		//this.id='formaManifiestoRutaPedido';
		this.defaults= {
	            anchor: '100%',
	            labelWidth: 130,
				labelAlign:'right'
	        };
			
		 var required = '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>';
		 
		this.items=[
		            {xtype:'hidden', id:'listapedidos', value:this.listapedidos,allowBlank: false},
		            {xtype:'hidden', id:'listapedidosparametro', value:this.listapedidosparametro,allowBlank: false},
		            
		            {
			    		xtype: 'textfielduppercase',fieldLabel: required+'Nombre Ruta',
			    		id: 'nombreruta',name: 'nombreruta',width:200,labelWidth: 100,
			    		allowBlank: false,maxLength:1,maxLength:50
			    	},
			    	 
			    	{
			    		xtype: 'textfielduppercase',fieldLabel: required+'Nombre Chofer',name: 'nombrechofer',	
			    		id: 'nombrechofer',	labelWidth: 100,	allowBlank: false,width: 200,
			    		maxLength:1,maxLength:50
			    	},
			    	{
			    		xtype: 'textfielduppercase',fieldLabel: required+'Tel. Chofer',name: 'telefonochofer',
			    		id: 'telefonochofer',	labelWidth: 100,allowBlank: false,width: 200,
			    		maxLength:1,maxLength:50
			    	},
			    	{
			    		xtype: 'textfielduppercase',fieldLabel: required+'Empresa',name: 'empresatranportista',
			    		id: 'empresatranportista',	labelWidth: 100,allowBlank: false,width: 200,
			    		maxLength:1,maxLength:50
			    	},
			    	{
			    		xtype: 'textfielduppercase',fieldLabel: required+'Placas',name: 'placas',
			    		id: 'placas',	labelWidth: 100,allowBlank: false,width: 200,
			    		maxLength:1,maxLength:30
			    	},
			    	{
			    		xtype: 'textfielduppercase',fieldLabel: required+'Tipo Vehiculo',name: 'tipovehiculo',
			    		id: 'tipovehiculo',	labelWidth: 100,allowBlank: false,width: 200,
			    		maxLength:1,maxLength:50
			    	}
	        ];
	        this.buttons= [
	            {text   : 'Generar Manifiesto',handler: this.submitForm, scope:this},
	            {text   : 'Reset',handler: function() {
	                    this.up('form').getForm().reset();
	                }
	            },
				
	        ];
	        
	        this.callParent(arguments);  
	},
	submitForm:function(){
		var scope_this = this;
		var fp =this.getForm();
		if(!fp.isValid()){
			//alert('Capture los catos requeridos');
			return;
		};
		
		 var listapedidos = Ext.getCmp('listapedidos').getValue(); 
		 var listapedidosparametro = Ext.getCmp('listapedidosparametro').getValue(); 
		 var nombreruta = Ext.getCmp('nombreruta').getValue(); 
		 var nombrechofer = Ext.getCmp('nombrechofer').getValue(); 
		 var telefonochofer = Ext.getCmp('telefonochofer').getValue(); 
		 var empresatranportista = Ext.getCmp('empresatranportista').getValue(); 
		 var placas = Ext.getCmp('placas').getValue(); 
		 var tipovehiculo = Ext.getCmp('tipovehiculo').getValue(); 
		
		 
		 //Manda la información al visor de etiquetas para que despliegue los datos
		 var url ='./picking.do?dispatch=generaManifiestoPedidos&nombreruta='+nombreruta+"&nombrechofer=" +nombrechofer+
		 '&telefonochofer='+ telefonochofer + "&empresatranportista=" +empresatranportista+
		 '&placas='+ placas + "&tipovehiculo=" +tipovehiculo+"&listapedidos="+listapedidos +
		 "&listapedidosparametro="+listapedidosparametro;
		 abrirVentanaVisorPDFs(url);
		 
		 /*Ext.create('Ext.window.Window', {
			    title: 'Visor de Manifiestoaa',
			    height: 500,
			    width: 600,
			   // maximizable:true,
			    maximized:true, 
			    floatable:false,
			    iconCls:'pdf_icon',
			    modal:true,
			    
			    layout: 'fit',
			    html: '<iframe src="' + url + '" style="width:100%;height:100%;border:none;"></iframe>',
		 }).show();*/
		 
		 
		 //scope_this.openWindowModalNoPDF(url,"ventana_manifiestos_pickin",500,600);
		 
		 scope_this.grid_principal.filtrarPedidosVeces(4);
		 scope_this.windows_principal.close();
		
	},
	openWindowModalNoPDF: function(theURL,winName,alto,ancho) { 
     	 var features='height='+alto+',width='+ancho+
     	 ',toolbar=yes,location=no,directories=no,status=no,menubar=yes,scrollbars=yes,resizable=no,modal=yes'
     	 
     	 var featuresWin="edge: Raised;center:Yes;help:No;resizable;dialogWidth:"+ancho+"px;dialogHeight:"+alto+"px";
          if (window.showModalDialog) {
     		//window.showModalDialog(theURL,winName,featuresWin);
     		window.open(theURL,winName,features);
          } else {
     		window.open(theURL,winName,features);
          }
     },
	setWindowsPrincipal:function(wind){
		this.windows_principal=wind;
	}
});