Ext.define('MyDesktop.form.PanelRotularEtiqueta', {
 extend: 'Ext.panel.Panel',
    xtype: 'panelrotularetiqueta-form',
    frame: true,
    border:true,
    width: 400,
    border: false,
    bodyPadding: 0,
    fieldDefaults: {
       // labelAlign: 'top',
        labelWidth: 100,
        labelStyle: 'font-weight:bold'
    },
	showReadOnly:false,
    defaults: {
        anchor: '100%',
        margins: '0 0 0 0'
    },
    uuid:undefined,
	autoScroll:true,
	grid_etiquetas:undefined,
	initComponent: function () {
		//Depura los registros de rotulos temporales
		var conn = new Ext.data.Connection();
   		conn.request({
   				scope:this, 
				url: './rotular_etiquetas/depuraRotulacionTemporal' ,
				method:'POST',
					defaultHeaders:{'_csrf_header':hv,"_csrf":vt },
					params:{"_csrf":vt},
				success: function(response, opts) {
					var obj = Ext.decode(response.responseText);

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
		   		
		
		this.uuid =  generateUUID();

		this.myscope=this;
		var myscope = this;
		myscope.grid_etiquetas= new MyDesktop.grid.GridEtiquetasConfiguradas({
			isConsulta:false,
	        border:false,
	        frame:false	
		});
		myscope.actualizar();
		
		/*this.tbar=[
		       {xtype:'label' , html:'Imprimir como:'},
		           {
	                      xtype: 'combobox', fieldLabel: 'Imprimir como:',  editable :false, name: 'tipo',
	                      store: Ext.create('MyDesktop.store.StoreTiposImpresionFormato',{}),width: 350,
	                      valueField: 'idtipo', displayField: 'descripcion',enforceMaxLength:true,
	      				  maxLength:30, typeAhead: true, queryMode: 'local',  allowBlank: false, emptyText: ''
					 }
					 {xtype:'tbfill'},
				
					{xtype:'tbseparator'}
					
		           ];
			,*/
					 this.bbar=[	 	
					{
						text : titulo_btn_agregar,
						iconCls : 'add32x32',
						scope:this,
						handler : this.agregar, 
						tooltip : 'Agrega registro a la tabla de impresión'
					},
					{xtype:'tbseparator'},
					{
						text : titulo_btn_importar,
						iconCls : 'upload32x32',
						scope:this,
						handler : this.importar, 
						tooltip : 'Importa Datos de un archivo de Excel para impresión'
					},
					{xtype:'tbseparator'},
					{
						text : titulo_btn_limpiar,
						iconCls : 'garbage32x32',
						handler :this.limpiar ,
						scope:this,
						tooltip : 'Limpia los registos de la tabla de impresión'
					},
					{xtype:'tbseparator'},
					{
						text : 'Seleccionar Sets Existentes',
						iconCls : 'database_blue',
						handler :this.muestraSets,
						scope:this,
						tooltip : 'Sets de Rotulación existentes'
					},
					{xtype:'tbseparator'},
					{
						text :titulo_btn_actualizar,
						iconCls : 'reload32x32',
						scope:this,
						handler :this.actualizar,
						tooltip : 'Actualiza los folios disponibles'
					},
					{xtype:'tbseparator'},
					{
						text : titulo_btn_reimprimir,
						iconCls : 'reprint16x16blue',
						scope:this,
						handler :this.reimprimir,
						tooltip : 'Muestra las impresiones del usuario en el día para poder reimprimir'
					},
					{xtype:'tbfill'},
					{
						text : 'Guardar Set',
						iconCls : 'database_blue',
						handler :this.guardaset,
						scope:this,
						tooltip : 'Guarda el set configurado de rotulación'
					},

					{xtype:'tbseparator'},
					{
						text : titulo_btn_imprimir,
						iconCls : 'print32x32',
						handler :this.imprimir,
						scope:this,
						tooltip : 'Inicia la rotulacion de las etiquetas'
					}
					
			  ];
			
			
		this.items= [
		             this.grid_etiquetas
		];
		
		myscope.actualizar();
		this.callParent();
		
	},
	muestraSets:function(){
		var myscope=this;
		
		var gridSetRotulacionEtiquetas = new MyDesktop.grid.GridSetRotulacionEtiquetas({
    		layout:'fit'
		}); 
		
		
		var datos_window = new Ext.Window({
			width    : 350,
			height   : 350,
			title	: 'Set de Rotulacion existentes',
			closable:true,
			resizable:false,
			modal:true,
			layout:'fit',
			items: [gridSetRotulacionEtiquetas],
			buttons: [ 
			        {text:'Seleccionar' ,iconCls : 'activo',  scope:myscope, handler:function(){
			        		var row = gridSetRotulacionEtiquetas.getRowsSelected();
			        		if ((row!=undefined)&&(row.length>0)){
			        			myscope.uuid = row[0].get('uuid');
			        			myscope.grid_etiquetas.buscar( row[0].get('uuid'));
								datos_window.close();
			        		}
			        	}
			        }
			
			],
			headerPosition: 'right'
		}); 
		datos_window.show();
	},
	guardaset:function(){
		var myscope=this;
		 Ext.MessageBox.confirm(titulo_confirmar,'Desea guardar el set de trabajo configurado?', 
				 function(id, text){
	       			if ( (id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){ 
		       			 Ext.MessageBox.show({
		       	           title: 'Identificar Set',
		       	           msg: 'Agrege el identificador del Set a Guardar:',
		       	           width:300,
		       	           buttons: Ext.MessageBox.OKCANCEL,
		       	           multiline: true,
		       	           fn:   function showResultText(btn, text){
		       	        	   if ( (btn === 'yes')  || (btn === 'si') || (btn === 'y' ) || 
		       	        			   (btn === 's' ) || (btn === 'ok' ) || (btn === 'OK' )){ 
		       	        		   
		       	        		var conn = new Ext.data.Connection();
	 					   		conn.request({
	 					   				scope:myscope, 
	 									url: './rotular_etiquetas/insertRotulacionSet' ,
	 									method:'POST',
	 									defaultHeaders:{'_csrf_header':hv,"_csrf":vt },
	 									params:{uuid: myscope.uuid, descripcion:text,"_csrf":vt},
	 									success: function(response, opts) {
	 										var obj = Ext.decode(response.responseText);
	 										mensajeConfirm("Se guardo el set "+ text + ", correctamente.");
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
		       	            
		       	           }
		       	       });
	       			}
		 });
		 
	},
	importar:function(){
		var myscope=this;
		
		 Ext.MessageBox.confirm(titulo_confirmar,'Se limpiará la información actual,¿Desea continuar?', 
				 function(id, text){
	       			if ( (id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){ 
	       				
	       				myscope.grid_etiquetas.getStore().removeAll();
	       				depuraCleanUUID(myscope.uuid);
	       				
						var uuid = generateUUID();
						var gridImportarRotualcion = new MyDesktop.grid.GridImportarRotualcion({
				    		height   : 190, //frame:true, border:false,title:'Servicios',
				    		layout:'fit', forceFit : true,
				    		uuid:uuid
						}); 
						var datos_window = new Ext.Window({
							width    : 1000,
							height   : 555,
							title	: 'Importar datos para Etiqueta',
							closable:false,
							maximizable:false,
							resizable:false,
							modal:true,
							layout:'fit', 
							items: [
							        gridImportarRotualcion 
							],
							dockedItems: [{
							    xtype: 'toolbar',
							    dock: 'bottom',
							    items: [
							        {xtype:'tbfill'},
							        {
										text : titulo_btn_cancelar,
										tooltip : 'Cancela la importación de registros a rotular',
										iconCls : 'deleteRed16x16', 
										handler : function(){
									    	 Ext.MessageBox.confirm('Confirmar','La información importada será eliminada,¿Desea continuar?', 
													 function(id, text){
										       			if ( (id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){ 
										       				myscope.grid_etiquetas.getStore().removeAll();
										       				depuraCleanUUID(myscope.uuid);
										       				datos_window.close();
										       				//reinicia el UUID
													   		myscope.uuid =  generateUUID();	
										       		}
											 }, this);
									    	 
											
										}
									},
									{text:titulo_btn_guardar, iconCls : 'activo', 
											handler:function(){
									    	 Ext.MessageBox.confirm(titulo_confirmar,'Solo los registros sin error serán  ' + 
									    			 'procesados para rotulación,¿Desea continuar?', 
													 function(id, text){
										       			if ( (id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){ 
										       				
										       				var conn = new Ext.data.Connection();
														   		conn.request({
																		url: './rotular_etiquetas_importar/procesarRegistrosCorrectos' ,
																		method:'POST',
																		defaultHeaders:{'_csrf_header':hv,"_csrf":vt },
																		params:{uuid:uuid,"_csrf":vt},
																		success: function(response, opts) {
																			var obj = Ext.decode(response.responseText);
																			myscope.actualizar();
																			datos_window.close();
																		},
																		failure: function(response, opts) {
															       			if (response.responseText!=undefined){
															       				var obj = Ext.decode(response.responseText);
															       				if (obj.message!=undefined){
															       					mensajeAlert(obj.message);
																       			}
																       		}
															       			datos_window.close();
														       			
																		}
														   		}); 
														   		myscope.uuid =  uuid
														   		
										       		}
											 }, this);
				
								  		}
									}
							    ]
							}],
							
							headerPosition: 'right'
						}); 
						datos_window.show();
		
	     			}
		    });
	},
    agregar:function(){
    	var my_scope=this;
    	var uuid =  this.uuid==undefined?generateUUID(): this.uuid;
    	var idregistro = -1;

    	var forma_remitente = new MyDesktop.form.FormDatosClienteDireccion({
    		height   : 415, sufijo:'_rem', idtipodireccion:'REM',title:'Remitente', showBtnSalvar:true, 
    		btnTitleSalvar:titulo_btn_guardar_remitente
		});  
    	var forma_destinatario = new MyDesktop.form.FormDatosClienteDireccion({
    		sufijo:'_des', idtipodireccion:'DES',height   : 415, title:'Destinatario',showBtnSalvar:true, 
    		btnTitleSalvar:titulo_btn_guardar_destinatario
		}); 
    	var forma_configuraciondados = new MyDesktop.form.FormPropiedadesEtiquetas({
    		height   : 415, title:titulo_generales
		}); 
	
    	 var tabs = Ext.widget('tabpanel', {
    	       
    	        width: 600,
    	        height   : 545,
    	        activeTab: 0,
    	        defaults :{
    	            bodyPadding: 10
    	        },
    	        layout:'fit',
    	        tabPosition: 'bottom',
    			
 	 	       bbar:[
 	 	             {
					
						text :titulo_verificar_cobertura ,
						tooltip : 'Verifica que los de origen destino tienen cobertua',
						iconCls : 'minitruck16x16', 
						handler : function(){
							var cporigen = forma_remitente.getValueField('cp_rem');
							var cpdestino = forma_destinatario.getValueField('cp_des');
							
							if ((cpdestino=='') || (cporigen=='')){
								mensajeWarning("Debe capturar el CP del remitente y destino");
								return;
							}
							
							validaCobetura(cporigen,cpdestino);
						}
 	 	             } ,
 	 	             {xtype:'tbfill'},
 	 	             	{
							
							text :titulo_consultar_frecuencias ,
							tooltip : 'Consulta la frecuencia del CP destino seleccionado',
							iconCls : 'parcel48', 
							handler : function(){
								
								var cpdestino = forma_destinatario.getValueField('cp_des');
								if (cpdestino==''){
									mensajeWarning("Debe capturar el CP destino");
									return;
								}
								
								var gridFrecuenciasEntrega= new MyDesktop.grid.GridFrecuenciasEntrega({
						    		frame:false, border:false,idRotulacion:'',isConsulta:false,
						    		hidden_cp:true, hidden_garmax:true, flex:2, layout:'fit',
						    		cpdestino:cpdestino,tipobusqueda:1
								}); 
							
						    	
								var datos_window = new Ext.Window({
									width    : 700,
									height   : 300,
									title	: titulo_consultar_frecuencias,
									closable:true,
									layout:'fit',
									resizable:false,
									modal:true,
									items: [gridFrecuenciasEntrega] ,
									headerPosition: 'right'
								}); 
								datos_window.show();
							}
						},
 	 	             /*,
 	 	               {
 							
 							text : "Cancelar",
 							tooltip : 'Cancela la creacion del registro de rotulacion',
 							iconCls : 'deleteRed16x16', 
 							handler : function(){
 								datos_window.close();
 							}
 						}  */ 
 	 	            {
 						
 						text : titulo_btn_guardar,
 						tooltip : 'Guarda los datos para rotulación',
 						iconCls : 'activo', 
 						handler : function(){
 							forma_configuraciondados.updateFieldCte(uuid,'uuid');
 							forma_configuraciondados.updateFieldCte(0,'idregistro');
 							if (!forma_remitente.validaForma()){
 								mensajeAlert("Capture los datos requeridos de remitente");
 								return;
 							}
 							if (!forma_destinatario.isValid()){
 								mensajeAlert("Capture los datos requeridos de destinatario");
 								return;
 							}
 							if (!forma_configuraciondados.isValid()){
 								mensajeAlert("Capture los datos requeridos de generales");
 								return;
 							}
 							//Valida si es ocurre
 						
 							if ((forma_destinatario.getValueField('es_ocurre_des') == 'true' )|| (forma_destinatario.getValueField('es_ocurre_des') == true)){
 									if (forma_destinatario.getValueField('idoficina_des') ==''){
 										mensajeAlert("Se ha seleccionado servicio ocurre debe seleccionar una oficina receptora.");
 		 								return;
 									}
    	 					}
 							var forme1 = forma_remitente.getCampoValor();
 							var forme2 = forma_destinatario.getCampoValor();
 							var forme3 = forma_configuraciondados.getCampoValor();
 							var forme  = Ext.Object.merge(forme1,forme2,forme3);
 							
  							var conn = new Ext.data.Connection();
 					   		conn.request({
 					   				scope:my_scope, 
 									url: './rotular_etiquetas/updateRegistroDatos' ,
 									method:'POST',
 									defaultHeaders:{'_csrf_header':hv,"_csrf":vt },
 									params:forme,
 									success: function(response, opts) {
 										var obj = Ext.decode(response.responseText);
 										
 										my_scope.grid_etiquetas.buscar(uuid);
 										datos_window.close();

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
 					}
 	 	            
 	 	            ] ,
    	        items: [
    	                forma_remitente,
    				       forma_destinatario,
    				       forma_configuraciondados//,
    				       //grdi_folios,
    				       //grid_frecuencia,
    				       //grid_adicionales
    	                
    	                ]
    	    });
    	
		var datos_window = new Ext.Window({
			width    : 650,
			height   : 555,
			title	: titulo_configuracion_etiqueta,
			closable:true,
			resizable:false,
			modal:true,
			
			items: [
			        	tabs 
			],
			
			headerPosition: 'right'
		}); 
		datos_window.show();
     
    
	},
	actualizar:function(){
		this.grid_etiquetas.buscar(this.uuid);
	},
	eliminar:function(){
		 Ext.MessageBox.confirm(titulo_confirmar,'Desea eliminar los registros seleccionados?', 
				 function(id, text){
	       			if ( (id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){ 
	       			
	       		}
		 }, this);
	},
	reimprimir:function(){
		
		var grid_reimpresion= new MyDesktop.grid.GridReimpresionEtiquetas({}); 
	
    	
		var datos_window_re = new Ext.Window({
			width    : 750,
			height   : 400,
			title	: titulo_reimprimir,
			closable:true,
			layout:'fit',
			resizable:false,
			modal:true,
			items: [grid_reimpresion] ,
			headerPosition: 'right',
			buttons:[
			         {
			        	 text:titulo_btn_imprimir, 
			        	 iconCls:'print32x32',handler:function(){
				
				var rows = grid_reimpresion.getRowsSelected();
				if (rows.length<=0){
					mensajeAlert("Seleccione el registro que desea reimprimir");
					return;
				}
				if (rows.length>1){
					mensajeAlert("Seleccione solo un registro para reimprimir");
					return;
				}
				visorPDF('utils-win-vista-pdf_reimpresion'+ rows[0].get('idregistro'),
						"Visor PDF" ,"./imprime_etiquetas/viewPDFArchivoReimpresion?idregistro=" + rows[0].get('idregistro'));

				}
				
			}]
		}); 
		datos_window_re.show();
		
		
	},
	imprimir:function(){
		var rows = this.grid_etiquetas.getRowsSelected();
		if (rows.length<=0){
			mensajeAlert("Seleccione los registros que desea imprimir");
			return;
		}
		
		//Obtiene los id
		var idregistrodatos='';
		for(i=0;i<rows.length;i++){
			idregistrodatos=idregistrodatos+rows[i].get('idregistrodatos')+',';
			
		}
		
		if (idregistrodatos==''){
			mensajeAlert("Seleccione los registros que desea imprimir");
			return;
		}
		
		
		var conn = new Ext.data.Connection();
   		conn.request({
   				scope:this, 
				url: './imprime_etiquetas/creaDocumengtoEtiqueta' ,
				timeOut:9999999,
				timeout:9999999,
				method:'POST',
				defaultHeaders:{'_csrf_header':hv,"_csrf":vt },
				
				params:{idregistro:idregistrodatos,"_csrf":vt},
				success: function(response, opts) {
					var obj = Ext.decode(response.responseText);
					if (obj.pdffile!=undefined){
       					//Muestra el PDF
						visorPDF('utils-win-vista-pdf_cotizaciones'+ idregistrodatos,
								"Visor PDF" ,"./imprime_etiquetas/viewPDFArchivo?uuid=" + obj.uuid);
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
		
		
	},
	limpiar:function() {
		var myscope=this;
		 Ext.MessageBox.confirm(titulo_confirmar,'Desea limpiar la información de la tabla de impresión?', 
				 function(id, text){
	       			if ( (id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){ 
	       				//myscope.grid_etiquetas.getStore().removeAll();
	       				//depuraCleanUUID(myscope.uuid);
 
					   	//reinicia el UUID
					   	myscope.uuid =  generateUUID();	
					   	myscope.grid_etiquetas.buscar(myscope.uuid);
	       		}
		 }, this);
		 

	},
	configurarCOD:function(){
		var grid_frecuencia = new MyDesktop.grid.GridCODCobroAmparadoEtiquetas({
    		frame:false, border:false,idRotulacion:'',isConsulta:false,
    		hidden_cp:true, hidden_garmax:true, flex:2, layout:'fit'
		}); 
	
    	
		var datos_window = new Ext.Window({
			width    : 400,
			height   : 400,
			title	: 'Configuración COD',
			closable:true,
			layout:'fit',
			resizable:false,
			modal:true,
			items: [grid_frecuencia	],
			headerPosition: 'right'
		}); 
		datos_window.show();
	},
	seguroAmparado:function(){
		var grid_seguro= new MyDesktop.grid.GridSeguroAmparadoEtiquetas({
    		frame:false, border:false,idRotulacion:'',isConsulta:false,
    		hidden_cp:true, hidden_garmax:true, flex:2, layout:'fit'
		}); 
	
    	
		var datos_window = new Ext.Window({
			width    : 550,
			height   : 400,
			title	: 'Seguro Amparado',
			closable:true,
			layout:'fit',
			resizable:false,
			modal:true,
			items: [grid_seguro] ,
			headerPosition: 'right'
		}); 
		datos_window.show();
	}

	
	
});