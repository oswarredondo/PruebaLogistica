/*******************************************************
/* Autor : Luis León
/* Empresa: Tracusa
/* Fecha: 12/12/2018.
/* Fecha modoficación: 21/06/2018 
/* Numero de programa: 1.
/* Lenguaje: Java.
/* Descripción: Facturación por guias.
/********************************************************/
Ext.define('MyDesktop.grid.GridFacturaGuias', {
    extend: 'Ext.grid.Panel',
    requires: [
        'Ext.grid.column.Action',
        'Ext.grid.plugin.CellEditing',
        'Ext.form.field.Text',
        'Ext.toolbar.TextItem',
        'Ext.menu.Menu'
    ],
    stateful: true,
    collapsible: false,
    multiSelect: true,
    stateId: 'stateGridFacturaGuias',

    viewConfig: {
        stripeRows: true,
        enableTextSelection: true
    },
	uuid:undefined,
	idregistro:undefined,
	id:undefined,
	isConsulta:false,
	myScope:undefined,
	uuid:undefined,
	idregistro:undefined,
	mystore:undefined,
	isCancelar:true,
	icita:true,
	irechazo:true,
	encabezados:'',
	ismenuDesabled:false,
	customStore:undefined,
	ocultaBotonPDF:false,
	ocultaBotonExportar:false,
	isFueraSitio:false,
    initComponent: function () {
    
    	var ismenuDesabled=false;
    	var my_scope = this;
    	this.myScope = this;
    	console.log(this.idcontrol);
    	this.store = Ext.create('MyDesktop.store.StoreFacturaGuia',{
					baseParams:{
						idcontrol:this.idcontrol,
						idcontrolenvio:this.idcontrolenvio,
						factura:this.factura
						}
    			}) ;
    	
    	this.store.getProxy().setExtraParam("idcontrol", this.idcontrol);
    	this.store.getProxy().setExtraParam("idcontrolenvio", this.idcontrolenvio);
    	this.store.getProxy().setExtraParam("factura", this.factura);
		
		this.columns = [
                 		{
							menuDisabled: true,	sortable: false,
							xtype: 'actioncolumn',	width: 20,
							items: [
								{
									getClass: function(v, meta, rec) {
										if ((rec.get('estatus')!='C')){
											return 'ACTIVO';
										}else{
											return 'CANCELADA';
										}
									},
									getTip: function(v, meta, rec) {
										if (rec.get('estatus')=='A'){
											return 'SIN FACTURAR';
										}else if (rec.get('estatus')=='F'){
											return 'FACTURADO';
										}else if (rec.get('estatus')=='C'){
											return 'CANCELADA';
										}else if (rec.get('estatus')=='N'){
											return 'NOTA CREDITO';
										}else{
											return 'CANCELADA';
										}
									},
									handler: function(grid, rowIndex, colIndex) {}
								}
							]
						},
						{text     : 'Guia', width: 150, sortable : true, dataIndex: 'iddocumento', hidden:false},
						{text     : 'Servicio', width: 170, sortable : true, dataIndex: 'tiposervicio', hidden:false},
						{text     : 'Referencia', width: 100, sortable : true, dataIndex: 'referencia', hidden:false},
						{text     : 'Fecha Entrega', width: 120, sortable : true, dataIndex: 'fechaentrega', hidden:false},
                        //{text     : 'Fecha', width: 110, sortable : true, dataIndex: 'fecha', hidden:false},
						{text     : 'Origen', width: 90, sortable : true, dataIndex: 'zonaori', hidden:false},
						{text     : 'Destino', width: 90, sortable : true, dataIndex: 'zonades', hidden:false},
						{text     : 'Zona', width: 80, sortable : true, dataIndex: 'zonaventa', hidden:false},
						{text     : 'Largo', width: 80, sortable : true,dataIndex: 'largo', hidden:false},
						{text     : 'Ancho', width: 80, sortable : true,dataIndex: 'ancho', hidden:false},
						{text     : 'Alto', width: 80, sortable : true,dataIndex: 'alto', hidden:false},
						{text     : 'Peso', width: 80, sortable : true,dataIndex: 'pesofisico', hidden:false},
						{text     : 'Total', width: 80, sortable : true,dataIndex: 'precio', hidden:false},
						/* CAMBIO CITA EVIDENCIA MANIOBRA */
						{
							menuDisabled: true,	sortable: false,
							xtype: 'actioncolumn',	width: 50,
							items: [
								{
									getClass: function(v, meta, rec) {
										return 'RECEPOFICRECOL';
									},
									getTip: function(v, meta, rec) {
										return 'Adicionales';
									},
									handler: function(grid, rowIndex, colIndex) {
					                    var rec = grid.getStore().getAt(rowIndex);
					                    my_scope.showWindowsAdicionales(rec.get('iddocumento'));
					                    	
									}
								}
							]
						},
						/* FIN CAMBIO */
			];

    	//var today = new Date();

		/*var combo_tipos_busqueda= Ext.create('Ext.form.ComboBox', {
			fieldLabel: '',
			 width: 170,
			disabled: false,
			editable:false,
			id:'tipobusqueda'+this.id,
			store: Ext.create('MyDesktop.store.StoreTiposBusquedaFacturaGuias',{}),
			queryMode: 'local',
			emptyText: 'Seleccione orden',
			displayField: 'descripcion',
			valueField: 'idtipo'
		});
		combo_tipos_busqueda.setValue("1");
			
		var combo_tipos_estatus= Ext.create('Ext.form.ComboBox', {
			fieldLabel: '',
			width: 170,
			disabled: false,
			editable:false,
			id:'tipobusquedaestatus'+this.id,
			store: Ext.create('MyDesktop.store.StoreTiposBusquedaFacturaEstatus',{}),
			queryMode: 'local',
			emptyText: 'Seleccione orden',
			displayField: 'descripcion',
			valueField: 'idtipo'
		});
		combo_tipos_estatus.setValue("1");
			
		this.tbar =[
					{xtype:'label', text:'Buscar por:'},    
					combo_tipos_busqueda,
					{xtype:'tbseparator'},
					{xtype:'label', text:'Estatus:'}, 
					combo_tipos_estatus,
					{xtype:'tbseparator'},
		        		    {xtype:'hidden', id:'idencabezados', value:my_scope.encabezados },   
							{xtype:'label', text:'Buscar:'},    
							{xtype:'textfield', id:'iddatoabuscar'+my_scope.id, maxLength:500,allowBlank:true,width:150 },
							{xtype:'tbseparator'},
							/*{xtype:'label', text:'Fecha corte:'}, 
							{ xtype:'datefield',id:'fechacorte'+my_scope.id,maxLength:30,allowBlank:false,width:110 },
							{xtype:'tbspacer'},
					        { tooltip:'Realiza la búsqueda (CTRL+B)',iconCls:'search_blue', handler:my_scope.realizaConsulta, scope:this}  
			];*/

		//this.selType= 'checkboxmodel'; 

    	this.dockedItems= [
          		{ 
          			xtype: 'toolbar',
          			dock: 'bottom',
          			items: [
  			            {text: "PDF", tooltip:'Muestra el PDF creado con detalle',scope: my_scope, iconCls:'pdf_blue',handler:my_scope.reportepdf},
  			            {xtype:'tbspacer'},
  		           	    {text: "EXCEL",tooltip:'Exporta a Excel',scope: my_scope,iconCls:'excel_blue', handler:my_scope.exportarExcel, hidden:my_scope.ocultaBotonExportar}
  		           	    //{xtype:'tbfill'}
  		           	    /*{text: "Facturar",tooltip:'Crea factura', scope: my_scope,iconCls:'books_blue', disabled:checkEnable('btn.facturar.crear.factura'), handler:my_scope.facturar}*/
          			]
          		}
         ];
    	
    	this.bbar =[
			Ext.create('Ext.PagingToolbar', {
			    store: this.store,
			    displayInfo: true,
			    displayMsg: 'Desplegando {0} - {1} of {2}',
			    emptyMsg: "No se encontro información que desplegar"
			})
        ];
    	
		this.callParent();
    },
    
    reportepdf:function(){
		var my_scope = this;
		var registro = this.store.getCount();
		/*var tipoBusqueda = Ext.getCmp("tipobusqueda"+my_scope.id).getValue();
		var tipobusquedaestatus = Ext.getCmp("tipobusquedaestatus"+my_scope.id).getValue();
		var iddatoabuscar = Ext.getCmp('iddatoabuscar'+my_scope.id).getValue();*/
		
     	if(registro <= 0){
     		mensajeAlert("No se encontraron registros a descargar.");
     		return;
     	}else{
     		var url ="./facturaresumen/imprimirpdf";
    		url = url + "?idcontrol=" + this.idcontrol + "&tipo=" + this.tipo +
    		"&idcontrolenvio=" + this.idcontrolenvio + "&factura=" + this.factura + 
    		"&tipoB=pdf";
    		//"&tipoB=" + tipoBusqueda + "&estatus=" + tipobusquedaestatus + "&t_txt_oper=" + iddatoabuscar; 
    		visorPDF(
    				'utils-win-vistaprevia-pdf_controlfactura'+ this.idcontrolenvio,
    				"Visor PDF: " +  this.idcontrolenvio,url);
     	}
    }, 
    
    exportarExcel:function(){
    	var my_scope = this;
		var registro = this.store.getCount();
		/*var tipoBusqueda = "01";
		var tipobusquedaestatus = "01";
		var iddatoabuscar = "";*/
		
     	if(registro <= 0){
     		mensajeAlert("No se encontraron registros a descargar.");
     		return;
     	}else{
     		/*var url ="./facturaresumen/imprimirpdf";
    		url =url+"?idcontrol=" + this.idcontrol + "&tipo=" + this.tipo +
    		"&idcontrolenvio=" + this.idcontrolenvio + "&factura=" + this.factura + 
    		"&tipoB=xls";
			
    		showAndHideWindows(url);*/
    		
     		var url ="./facturaresumen/exportaConsultaExcelFA";
 			url = url + "?idcontrol=" + this.idcontrol + "&tipo=" + this.tipo +
        		"&idcontrolenvio=" + this.idcontrolenvio + "&factura=" + this.factura +
        		"&tipoB=xls";
        		//"&tipoB=" + tipoBusqueda + "&estatus=" + tipobusquedaestatus + "&t_txt_oper=" + iddatoabuscar; 
     		showAndHideWindows(url);
     	}
	},
    
    realizaConsulta:function(){
    	this.buscar(this);
    	
    },
    
	buscar:function(myscope){ 
		
		var tipoDocumento = 'ETIQU';
	    //var myscope = this;
		var buscapor='';
		var valor='';
		//var fechacorte='';
		var tipoBusqueda = Ext.getCmp("tipobusqueda"+myscope.id).getValue();
		var tipobusquedaestatus = Ext.getCmp("tipobusquedaestatus"+myscope.id).getValue();
		
		if ((tipoBusqueda == 4) || (tipoBusqueda == 5)){//Por tipo de documento
			if (!isValidValueCampo('iddatoabuscar'+myscope.id, 'Indique el dato que desea buscar')){
				return;
			}
		}
		/*if ((tipoBusqueda == 1)  || (tipoBusqueda == 2) || (tipoBusqueda == 3)){//Por rango de fechas
			if (!isValidValueCampoRaw('fechacorte'+myscope.id, 'Indique la fecha de corte')){
				return;
			}
		}
		var fechacorte = Ext.getCmp("fechacorte"+myscope.id);
		var datosFecha =  Ext.getCmp('fechacorte'+myscope.id).getRawValue().split('T');
		fechacorte = datosFecha[0];*/
	
		myscope.getView().getStore().reload(
			{
				params:{
					tipobusqueda:tipoBusqueda, 
					tipobusquedaestatus:tipobusquedaestatus,
					iddatoabuscar:Ext.getCmp('iddatoabuscar'+myscope.id).getValue(),
					tipoDocumento:tipoDocumento,
					//fechacorte:fechacorte,
					start:0
				},
				callback:function(r,options,success){
					 if (r.length<=0){
						 Ext.Msg.show({
							 title: 'Aviso',
							 msg: 'No existe información con el criterio de busqueda selecionado.',
							 modal: false,
							 icon: Ext.Msg.INFO,
							 buttons: Ext.Msg.OK						
						 });  
					 }
				 }	  
			});
    },    
    
    facturar:function(){
    	var my_scope = this;
    	var registro = my_scope.getRowSelected();
    	
    	var combo_cecos = Ext.create('Ext.form.ComboBox', {
    		fieldLabel: 'Facturar a',
    		width: 170,
    		disabled: false,
    		editable:false,
    		id:'tipoceco'+this.id,
    		store: Ext.create('MyDesktop.store.StoreTipoCeco',{}),
    		queryMode: 'local',
    		emptyText: 'Seleccione Ceco',
    		displayField: 'descripcion',
    		valueField: 'idtipo',
    		name:'prctr'
    	});
        combo_cecos.setValue("984005");
    	
    	if (registro==undefined){
    		mensajeAlert("Seleccione por lo menos un registro para poder facturar.");
    		return;
    	}else{
    		 var form = new Ext.form.Panel({
     		 	height: 400,
     		 	border: false,
     	        fieldDefaults: {
     	        	labelAlign: 'top',
     	        	labelWidth: 100,
     	        	labelStyle: 'font-weight:bold'
     	        },
     	        defaultType: 'myUpperCaseTextArea',
     	        bodyPadding: 5,	
     	        url:'./facturaresumen/facturar',
     	        method:'POST',
     	        items: [
     	               {xtype : 'hidden', name:"_csrf", value:vt},
     	                {
     	                	xtype:'hidden',
     	                	name:'idcontrol', 
     	                	value:this.idcontrol
     	                },
     	               {
     	                	xtype:'hidden',
     	                	name:'idcontrolenvio', 
     	                	value:this.idcontrolenvio
     	                },
     	                {
     	                	xtype:'hidden',
     	                	name:'factura',
     	                	value:this.factura
     	                },
     	                combo_cecos,
     	                /*{
     	                	xtype: 'fieldcontainer',
							labelStyle: 'font-weight:bold;padding:0',
							layout: 'hbox',
							emptyText: field_cp,
							defaultType: 'textfield',
							fieldDefaults: {
								//labelAlign: 'top'
							},
							defaults: {
								anchor: '100%'
							},
     	                	items: [
    								{xtype:'label', text:'Facturar a:  '},
    								{xtype:'tbseparator'},
   								 	{xtype:'tbspacer'}, 
    								combo_cecos
                           ]
     	                },*/  	                
     	                {
		     	        	xtype: 'myUpperCaseTextArea',
		     	        	fieldLabel: 'Obs. Niv. Posc.',
		     	            name: 't_txt_head',
		     	            anchor:'100%',
		     	            allowBlank:true,
		     	            maxLength:132
     	                },
     	                {
		     	        	xtype: 'myUpperCaseTextArea',
		     	        	fieldLabel: 'Obs. Generales',
		     	            name: 't_txt_oper', 
		     	            anchor: '100%',
		     	            allowBlank:true,
		     	            maxLength:132
     	                }],
     	    });    		 
    			
	     	 var  win = Ext.widget('window', {
	              title: 'CREAR FACTURA',
	              closeAction: 'hide',
	              width: 550,
	              height: 330,
	              layout: 'fit',
	              resizable: false,
	              modal: true,
	              items: form,
	              buttons: [
	                        {text: 'Finalizar',
                        	handler: function() {
		                      if (form.isValid()) {
	                    		 Ext.MessageBox.confirm(titulo_confirmar, "¿Desea generar la FACTURA " +
                     		 		"para este número de control ahora?", function(id, text){
             			       		if ((id === 'yes') || (id === 'si') || (id === 'y' ) || (id === 's' )){ 
             			       			var ventana = creaVentanaEspera ();
   	             			       		 form.submit({
   	                                         success: function(form, action) {
   	                                        	ventana.close();
	                                        	my_scope.reloadInfo();
	                                        	win.close();
   	                                        	/*ventana.close();
   	                                        	if (action.result.failure!=undefined){
     												mensajeAlert(action.result.failure);
     											}else{
     												my_scope.reloadInfo();
     											}
   	                                            win.close();*/
   	                                         },
   	                                         failure: function(form, action) {
   	                                        	ventana.close();
   	                                        	mensajeAlert(action.result.message);
   	                                            win.close();
   	                                         }
   	                                     });
             			       		}
                 		       	 },this);
		                      }
                        	}
	              }]
	     	 });
     	 	win.show(); 
    	}
    },
	
	getRowsSelected:function(){
		return this.getView().getSelectionModel().getSelection();
	},
	
	getRowSelected:function(){
		var rows =  this.getView().getSelectionModel().getSelection();
		if(rows.length >=1){
			return rows[0];
		}
		return undefined;
	},
	
	/* CAMBIO CITA EVIDENCIA MANIOBRA */
    showWindowsAdicionales:function(idregistro){
    	
    	var mainScope = this;
	 	var connUsuario = new Ext.data.Connection();
	 	
    	connUsuario.request({
//				url: './facturaresumen/validarUsuario' ,
    		    url: './catalogo/usuario/getPerfilUsuarioSesion',
				method:'POST',
				defaultHeaders:{'_csrf_header':hv,"_csrf":vt },
				params:{"_csrf":vt},
				success: function(response, opts) {
					
    				var obj = Ext.decode(response.responseText);
    				
    				if (obj.success){
    					
    					var myscope=this;
    			    	
    					var grid_adicionales= Ext.create('MyDesktop.grid.GridAdicionalPreFactura',{
    						height   : 190,frame:true, border:true,
    						hidden_cp:true, hidden_garmax:true,
    			    		frame:false, border:false,idRotulacion:'',isConsulta:false,
    			    		hidden_cp:true, hidden_garmax:true, flex:2, layout:'fit',idregistro:idregistro
    					}); 
    				
    					var datos_window = new Ext.Window({
    						
    						width    : 400,
    						height   : 400,
    						title	: 'Datos de servicios Adicionales',
    						closable:true,
    						layout:'fit',
    						resizable:false,
    						modal:true,
    						items: [grid_adicionales],
    						buttons:[
    							    {text:'Guardar Cambios', iconCls:'reload_blue', handler: function(){
    							    	
    								 	var rows = grid_adicionales.getRowsSelected();
    								 	
    									if (rows.length<=0){
    										
    										mensajeAlert("Seleccione el registro al que va a modificar el precio");
    										
    										return;
    										
    									}
    							    	
    							       	 Ext.MessageBox.confirm('Confirmacion', '<center>!ATENCION¡<center/><br/> <p>Esta a punto de generar un cambio al precio de un adicional.</p> <br/>' + 
    							       			 '<center>¿Desea continuar con el proceso?<center/>', function(id, text){
    							        		if ( (id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){
    							        			
    											 	var iddocumento = rows[0].get('idregistroadicional');
    											 	
    												var idadicional = rows[0].get('idadicional');
    												
    												var precio = rows[0].get('precio');
    																			
    											 	var conn = new Ext.data.Connection();
    											 	
    												conn.request({
    														
    														url: './catalogo/adicionales/updatePorGuia' ,
    														method:'POST',
    														defaultHeaders:{'_csrf_header':hv,"_csrf":vt },
    														params:{idregistroadicional: iddocumento,idadicional: idadicional,precio: precio,"_csrf":vt},
    														success: function(response, opts) {
    															
    															var obj = Ext.decode(response.responseText);
    															
    															grid_adicionales.getStore().reload();
    															
    														},
    														failure: function(response, opts) {
    											    			if (response.responseText!=undefined){
    											    				var obj = Ext.decode(response.responseText);
    											    				if (obj.message!=undefined){
    											    					mensajeAlert(obj.message);
    												       			}
    												       		}
    														
    														}
    													});

    								
    							        		}});
    							    	
    										}
    									}
    						         
    						      ],	
    					
    						headerPosition: 'right'
    					}); 
    					datos_window.show();
    					
	       			}else{
	       				
	       				mensajeAlert(obj.message);
	       				
	       			}
					
					
				},
				failure: function(response, opts) {
	    			if (response.responseText!=undefined){
	    				var obj = Ext.decode(response.responseText);
	    				if (obj.message!=undefined){
	    					mensajeAlert(obj.message);
		       			}
		       		}
				
				}
			});
	}
	/* FIN CAMBIO */
});