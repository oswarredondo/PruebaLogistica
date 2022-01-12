Ext.define('MyDesktop.grid.GridImportarRotualcion', {
    extend: 'Ext.Container',
    xtype : 'mainview',
    uuid:undefined,
    idservicio:undefined,
    storeReload :undefined,
    initComponent : function() {
    	var me = this;
    	var gRow = -1;
    	var id_grid = 'grid-pnl';
    	
    	if (this.uuid==undefined){
    		
    		this.uuid = generateUUID();
    	}
    	

    	Ext.define('Etiqueta',{
	       extend: 'Ext.data.Model',
			 fields: [
					    {name: 'esvalido',type: 'int'},   
					    {name: 'mensajeError',type: 'string'},
						{name: 'idregistro',type: 'int'},
						{name: 'uuid',type: 'string'}, 
						{name: 'razonsocial_rem',type: 'string'}, 
						{name: 'contacto_rem',type: 'string'}, 
						{name: 'calle_rem',type: 'string'}, 
						{name: 'numinterior_rem',type: 'string'},
						{name: 'numexterior_rem',type: 'string'},
						{name: 'colonia_rem',type: 'string'}, 
						{name: 'municipio_rem',type: 'string'}, 
						{name: 'estado_rem',type: 'string'}, 
						{name: 'ciudad_rem',type: 'string'}, 
						{name: 'cp_rem',type: 'string'}, 
						{name: 'telefono_rem',type: 'string'}, 
						{name: 'celular_rem',type: 'string'}, 
						{name: 'rfc_rem',type: 'string'}, 
						{name: 'email_rem',type: 'string'}, 
						{name: 'razonsocial_des',type: 'string'}, 
						{name: 'contacto_des',type: 'string'}, 
						{name: 'calle_des',type: 'string'}, 
						{name: 'numinterior_des',type: 'string'},
						{name: 'numexterior_des',type: 'string'},
						{name: 'colonia_des',type: 'string'}, 
						{name: 'municipio_des',type: 'string'}, 
						{name: 'estado_des',type: 'string'}, 
						{name: 'ciudad_des',type: 'string'}, 
						{name: 'cp_des',type: 'string'}, 
						{name: 'telefono_des',type: 'string'}, 
						{name: 'celular_des',type: 'string'}, 
						{name: 'email_des',type: 'string'}, 
						{name: 'es_ocurre',type: 'string'}, 
						{name: 'tiene_seguro',type: 'string'}, 
						{name: 'es_multiple',type: 'string'},
						{name: 'nacional',type: 'string'}, 
						{name: 'numpiezas',type: 'int'}, 
						{name: 'pesofisico',type: 'float'}, 
						{name: 'alto',type: 'int'}, 
						{name: 'ancho',type: 'int'}, 
						{name: 'largo',type: 'int'}, 
						{name: 'contenido',type: 'string'},
						{name: 'observacion',type: 'string'},
						{name: 'referencia',type: 'string'} 
					] 
			});
	
		var store_folios = Ext.create('MyDesktop.store.StoreFoliosServicios', {});
		
		store_folios.getProxy().setExtraParam("tipo_formulario");
		
    		var countryStore = Ext.create('MyDesktop.store.StoreEtiquetasRotularImportar', {
    			baseParams:{uuid:this.uuid},
    			listeners: {
    				load : function( store, records, successful, eOpts ){

    				}
    			}
    		});
    		countryStore.getProxy().setExtraParam("uuid", this.uuid);
    		this.storeReload =countryStore;
		
    		var scope_container = this;
    		Ext.apply(me, {
    			items:[{

		    xtype: 'gridpanel',
		    layout : 'fit',
		    height: 650,
		    forceFit : true,
		   // title: 'Grid-to-excel and excel-to-grid copy-paste in ExtJS 4.x',
		    xtype : 'grid',
		    id: id_grid,
		    store: countryStore,
		    layout : 'fit',
		    multiSelect : true,
			selType: 'checkboxmodel',
		    columns: [
		              Ext.create('Ext.grid.RowNumberer',{width:40}),
		             //{ text: 'Correcto',dataIndex: 'esvalido'},
		 			 { text: 'Remite',dataIndex: 'razonsocial_rem',
		 				 renderer:function (value, metaData, record, rowIndex, colIndex,
		 					store) {
		 					var error =[1, 4];
		 					var suf = '_rem';
			 				metaData.tdAttr = 'data-qtip="' +
			 				formatoRemDesTipTablaRotular(metaData, record,suf,error) + '"';
			 				return record.get('razonsocial'+suf ) + "-" + record.get('contacto'+suf );
		 				
		 				 }
		 			 }, 
					 { text: 'contacto_rem',dataIndex: 'contacto_rem', hidden:true}, 
					 { text: 'calle_rem',dataIndex: 'calle_rem', hidden:true}, 
			
					 { text: 'numinterior_rem',dataIndex: 'numinterior_rem', hidden:true},
					 { text: 'numexterior_rem',dataIndex: 'numexterior_rem' ,hidden:true},			
					 { text: 'colonia_rem',dataIndex: 'colonia_rem' ,hidden:true}, 
					 { text: 'municipio_rem',dataIndex: 'municipio_rem' ,hidden:true}, 
					 { text: 'estado_rem',dataIndex: 'estado_rem' ,hidden:true}, 
					 { text: 'ciudad_rem',dataIndex: 'ciudad_rem' ,hidden:true}, 
					 { text: 'cp_rem',dataIndex: 'cp_rem' ,hidden:true}, 
					 { text: 'telefono_rem',dataIndex: 'telefono_rem' ,hidden:true}, 
					 { text: 'celular_rem',dataIndex: 'celular_rem' ,hidden:true}, 
					 { text: 'rfc_rem',dataIndex: 'rfc_rem' ,hidden:true}, 
					 { text: 'email_rem',dataIndex: 'email_rem' ,hidden:true}, 
					
					 { text: 'Destino',dataIndex: 'razonsocial_des' ,hidden:false,
						 renderer:function (value, metaData, record, rowIndex, colIndex,
				 					store) {
					 				
					 				var error =[2, 4];
					 				var suf = '_des';
					 				metaData.tdAttr = 'data-qtip="' +
					 				formatoRemDesTipTablaRotular(metaData, record,suf,error) + '"';
					 				return record.get('razonsocial'+suf ) + "-" + record.get('contacto'+suf );
					 			
				 				
				 				 }
					 
					 }, 
					 { text: 'contacto_des',dataIndex: 'contacto_des' ,hidden:true}, 
					 { text: 'calle_des',dataIndex: 'calle_des' ,hidden:true}, 
					 { text: 'numinterior_des',dataIndex: 'numinterior_des' ,hidden:true},
					 { text: 'numexterior_des',dataIndex: 'numexterior_des' ,hidden:true},
					 { text: 'colonia_des',dataIndex: 'colonia_des' ,hidden:true}, 
					 { text: 'municipio_des',dataIndex: 'municipio_des' ,hidden:true}, 
					 { text: 'estado_des',dataIndex: 'estado_des' ,hidden:true}, 
					 { text: 'ciudad_des',dataIndex: 'ciudad_des' ,hidden:true}, 
					 { text: 'cp_des',dataIndex: 'cp_des' ,hidden:true}, 
					 { text: 'telefono_des',dataIndex: 'telefono_des' ,hidden:true}, 
					 { text: 'celular_des',dataIndex: 'celular_des' ,hidden:true}, 
					 { text: 'email_des',dataIndex: 'email_des' ,hidden:true},
					 { text: 'Es Ocurre?',dataIndex: 'es_ocurre',hidden:true}, 
					 { text: 'Datos Generales',dataIndex: 'tiene_seguro',  
						 renderer:function (value, metaData, record, rowIndex, colIndex,
			 					store) {
							 var error =[3,4];
						 	metaData.tdAttr = 'data-qtip="' +
						 	formatoDatosGeneralesTabla(metaData, record,error,false) + '"';
			 				return "Num Piezas"+record.get('numpiezas' ) + ", Es Ocurre?:" + 
			 				record.get('es_ocurre' ) + ",Tiene Seguro:"+record.get('tiene_seguro' ) + "...";
		 				
		 				 }
					 }, 
					 { text: 'Es Mutiple?',dataIndex: 'es_multiple',hidden:true},
					 { text: 'Entrega',dataIndex: 'nacional',hidden:true},
					 { text: 'numpiezas',dataIndex: 'numpiezas',hidden:true},
					 { text: 'pesofisico',dataIndex: 'pesofisico',hidden:true},
					 { text: 'largo',dataIndex: 'largo',hidden:true}, 
					 { text: 'ancho',dataIndex: 'ancho',hidden:true}, 
					 { text: 'alto',dataIndex: 'alto',hidden:true},
					 { text: 'contenido',dataIndex: 'contenido',hidden:true}, 
					 { text: 'observacion',dataIndex: 'observacion',hidden:true},  
					  { text: 'referencia',dataIndex: 'referencia',hidden:true}

				 ],
			tbar:[

						{
							
							xtype: 'combobox',
							//fieldLabel: '<font color=red>*</font>',
							name: 'nameservicio_rotulacion_importar',
							id: 'idservicio_rotulacion_importar',
							width:390,
							//labelWidth: 0,
							allowBlank: false,
							//store: Ext.create('MyDesktop.store.StoreFoliosServicios'),
							store: store_folios,
							forceSelection:true,
							valueField: 'idServicio',
							displayField: 'descripcionServicio',
							typeAhead: true,
							queryMode: 'local',
							emptyText: 'Seleccione Servicio *REQUERIDO',
							listeners:{
						         'select': function( combo, records, eOpts){
						        	 //Habilita el boton de salvar 
						        	 Ext.getCmp('btn_salvar_registro_importado_rotula').enable();
						        	 Ext.getCmp('btn_inportar_info_importado_rotula').enable();
						        	 Ext.getCmp('btn_inportar_info_importado_rotula_telcel').enable();
						        	 
						        	 Ext.getCmp('idservicio_rotulacion_importar').disable();
						        	 
						        	 me.idservicio = Ext.getCmp('idservicio_rotulacion_importar').getValue();
						        	 countryStore.getProxy().setExtraParam("idservicio", Ext.getCmp('idservicio_rotulacion_importar').getValue());
						         }
						    }
							
						},
						{xtype:'tbfill'},
					{
						
						text : "Borrar",
						tooltip : 'Borra los registros seleccionados',
						iconCls : 'deleteRed16x16', 
						scope:this,
						handler : function(){
							 var grid_ = Ext.getCmp('grid-pnl');
						     var store_grid = grid_.getStore();
						     
								var rows =  grid_.getSelectionModel().getSelection();
						     	if(rows.length <=0){
						     		 Ext.Msg.alert('Verificar',"Seleccione los registros que desea eliminar");
						     		return;
						     	}
								
						    	 Ext.MessageBox.confirm('Confirmacion', 'Desea borrar los registros seleccionados?', function(id, text){
						       		if ( (id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){ 
						       			if(rows.length === 0){  //step 3
						       				return ;
						       			}
						       			deleteSyncStore(grid_,store_grid,rows,true);
						       		}
						       	 },this);
						}
					},
					
					{xtype:'tbseparator'},
					{
						
						text : "Frecuencia",
						tooltip : 'Consulta la frecuencia del CP destino seleccionado',
						iconCls : 'parcel48', 
						scope:this,
						handler : function(){
							 var grid_ = Ext.getCmp('grid-pnl');
						     var store_grid = grid_.getStore();
						     
								var rows =  grid_.getSelectionModel().getSelection();
						     	if(rows.length <=0){
						     		 Ext.Msg.alert('Verificar',"Seleccione un registro para consultar");
						     		return;
						     	}
						     	if(rows.length >1){
						     		 Ext.Msg.alert('Verificar',"Seleccione solo un registro para consultar");
						     		return;
						     	}
						     	
						     	windowsFrecuenciaEntregaCPDestino(rows[0].get('cp_des'));
						}
					},
					
					{xtype:'tbseparator'},
						{
						
						text : "Cobertura",
						tooltip : 'Verifica que los de origen destino tienen cobertura para cada registro',
						iconCls : 'minitruck16x16', 
						scope:this,
						handler : function(){
							
							 var grid_ = Ext.getCmp('grid-pnl');
						     var store_grid = grid_.getStore();
						     
						     var rows =  grid_.getSelectionModel().getSelection();
						     if(rows.length <=0){
						    	mensajeAlert("Seleccione un registro para consultar");
						    	return;
						     }
						     	
						     var cporigen = rows[0].get('cp_rem');
						     var cpdestino = rows[0].get('cp_des');
							
						     if ((cpdestino=='') || (cporigen=='')){
								mensajeWarning("Debe capturar el CP del remitente y destino");
								return;
						     }
							
						     validaCobetura(cporigen,cpdestino);
						
						}
		          },
		          {xtype:'tbseparator'},
					{
						text : 'Salvar y Actualizar',
						id: 'btn_salvar_registro_importado_rotula',
						iconCls : 'view_blue',
						disabled :true,
						scope:this,
						handler :function(){
							 var grid_ = Ext.getCmp('grid-pnl');
						     var store_grid = grid_.getStore();
						     
						     var registros_modificadod = store_grid.getModifiedRecords( );
						     if ((registros_modificadod!=undefined) && (registros_modificadod.length>0)){
						    	  store_grid.sync({ 
									    success: function (proxy, operations) {
									    	 grid_.getStore().reload();
									    }, failure: function (proxy, operations) {
									    	 if (proxy.exceptions != undefined){
									    		 if (proxy.exceptions.length>0){
									    			 Ext.Msg.show(
							                             {
							                            	 title: 'Warning',
							                                 msg: proxy.exceptions[0].error,
							                                 buttons: Ext.Msg.OK,
							                                 icon: Ext.Msg.WARNING
							                             });
									    		 	}
									    		 }
									    	 grid_.getStore().rejectChanges();
									    }
									});
						     }else{
						    	 grid_.getStore().reload();
						     }

						},
						tooltip : 'Actualiza la tabla de datos'
					}
		    ],
		    bbar:[
					{
						text : 'Limpiar',
						iconCls : 'garbage32x32',
						scope:this,
						handler :function(){
							var myscope=this;
							
						     
					    	 Ext.MessageBox.confirm('Confirmar','Desea limpiar la información de la tabla importada?', 
									 function(id, text){
						       			if ( (id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){ 
						       				
						       				var conn = new Ext.data.Connection();
											conn.request({
													
													url: './rotular_etiquetas_importar/depuraImportados' ,
													method:'POST',
													defaultHeaders:{'_csrf_header':hv,"_csrf":vt },
													params:{uuid: scope_container.uuid,"_csrf":vt},
													success: function(response, opts) {
														var obj = Ext.decode(response.responseText);
														countryStore.reload()
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
							 }, this);
						},
						scope:this,
						tooltip : 'Limpia los registos de la tabla de impresión'
					},
					{xtype:'tbseparator'},
					{
						text : 'Importar TELCEL',
						iconCls : 'upload32x32',
						disabled:checkEnable('btn.importar.datos.telcel'),
						hidden:checkEnable('btn.importar.datos.telcel'),
						id: 'btn_inportar_info_importado_rotula_telcel',
						//disabled :true,
						scope:me,
						handler : function(){
					    	 Ext.MessageBox.confirm('Confirmacion',
					    			 'La información actual será sustituida por ' +
					    			 'la que desea importar de TELCEL, desea continuar?', function(id, text){
				       				var ventana = creaVentanaEspera ();
				       				var conn = new Ext.data.Connection();
								   		conn.request({
								   			    timeOut:9999999,
								   			    timeout:9999999,
												method:'POST',
												defaultHeaders:{'_csrf_header':hv,"_csrf":vt },
												url: './rotular_etiquetas_importar/importarDatosTelcel' ,
												params:{uuid:me.uuid , idtipodocumento:me.idservicio,"_csrf":vt },
												success: function(response, opts) {
													var obj = Ext.decode(response.responseText);
													ventana.close();
													//if (obj.success==false){
													mensajeConfirm(obj.message);
													//}
														if (obj.cantidad>0){
															me.loadInfo();
														}
													
													
													
												},
												failure: function(response, opts) {
													ventana.close();
									       			if (response.responseText!=undefined){
									       				var obj = Ext.decode(response.responseText);
									       				if (obj.message!=undefined){
									       					mensajeAlert(obj.message);
										       			}
										       		}
									       			
												}
								   		}); 
					     	 },this);

						}, 
						tooltip : 'Importa Datos de '
					},
					{
						
						text : "Importar EXCEL",
						disabled:checkEnable('btn.importar.datos.excel'),
						hidden:checkEnable('btn.importar.datos.excel'),
						tooltip : 'Cargar un archivo con EXCEL con la informacióna importar',
						iconCls : 'excel_blue', 
						id: 'btn_inportar_info_importado_rotula',
						//disabled :true,
						scope:this,
						handler : function(){
							
						    	 Ext.MessageBox.confirm('Confirmacion',
						    			 'La información actual será sustituida por ' +
						    			 'la que desea importar, desea continuar?', function(id, text){
						    		    
						    		   //Crea una forma de clientes para agregar los datos
										var forma_attachment = Ext.create('MyDesktop.form.FormUploadAttachment',
												{identificador:this.uuid,idtipodocumento:this.idservicio,gridscope:this,
											sendJSON:true,
											//url:'./rotular_etiquetas_importar/uploadEnviosExcel',
											url: './rotular_etiquetas_importar/uploadRowsJsonFile',
											descripcion_file:'IMPORTAR ARCHIVO'}); 
										
										var winimport = Ext.create('widget.window', {
											//id:'utils-win-agregar-cliente-attachment',
											title: "Importar Archivo",
											width: 450,
											iconCls: 'editar',
											height: 200,
											modal:true,
											plain: true,
											layout: 'fit',
											items: forma_attachment
											
										});
										forma_attachment.setWinImport(winimport);
										winimport.show();
						       	 },this);
						}
					},
					{xtype:'tbseparator'},
				   	{text: "Exportar Información",tooltip:'Exporta la info de la guia a Excel ',iconCls:'excel_blue', 
							handler:function(){
								showAndHideWindows('./rotular_etiquetas_importar/exportaInfoExcel?uuid='+
										scope_container.uuid);
							}

					},
					{xtype:'tbseparator'},
					{
						text : 'Consulta CPs',
						iconCls : 'search_blue',
						handler :function(){
							windowsConsultaCPS();
						},
						tooltip : 'Consulta de Colonias y Codigos Postales'
					},
		    ],
		    /*listeners: {
	
		    	cellclick: function(grid, td, cellIndex,record,tr,rowIndex) {
		    		gRow = rowIndex;
		    	},
	
	    		viewready: function( grid ) {
	    			var map = new Ext.KeyMap(grid.getEl(), 
		    			[{
			    			key: "c",
			    			ctrl:true,
			    			fn: function(keyCode, e) {
	
				    			var recs = grid.getSelectionModel().getSelection();
	
				    			if (recs && recs.length != 0) {
	
					    			var clipText = grid.getCsvDataFromRecs(recs);
	
					    			var ta = document.createElement('textarea');
	
					    			ta.id = 'cliparea';
					    			ta.style.position = 'absolute';
					    			ta.style.left = '-1000px';
					    			ta.style.top = '-1000px';
					    			ta.value = clipText;
					    			document.body.appendChild(ta);
					    			document.designMode = 'off';
	
					    			ta.focus();
					    			ta.select();
	
					    			setTimeout(function(){
	
					    					document.body.removeChild(ta);
	
					    			}, 100);
				    			}
			    			}
		    			},
		    			{
	    				
		    			key: "v",
		    			ctrl:true,
		    			fn: function() {
		    				var ventana = creaVentanaEspera ();
			    			var ta = document.createElement('textarea');
			    			ta.id = 'cliparea';
	
			    			ta.style.position = 'absolute';
			    			ta.style.left = '-1000px';
			    			ta.style.top = '-1000px';
			    			ta.value = '';
	
			    			document.body.appendChild(ta);
			    			document.designMode = 'off';
	
			    			setTimeout(function(){
	
			    				Ext.getCmp('grid-pnl').getRecsFromCsv(grid, ta);
			    			}, 100);
	
			    			ta.focus();
			    			ta.select();
			    			ventana.close();
			    		}
	    			}]);
	
	    		}
	
		    },

		    getCsvDataFromRecs: function(records) {
	
		    	var clipText = '';
	
		    	var currRow = countryStore.find('idregistro',records[0].data.id);
	
		    	for (var i=0; i<records.length; i++) {
	
			    	var index = countryStore.find('idregistro',records[i].data.id);
			    	var r = index;
	
			    	var rec = records[i];
			    	var cv = this.initialConfig.columns;
	
				    	for(var j=0; j < cv.length;j++) {
					    		var val = rec.data[cv[j].dataIndex];
					    		if (r === currRow) {
					    				clipText = clipText.concat(val,"\t");
					    		} else {
					    			currRow = r;
					    			clipText = clipText.concat("\n", val, "\t");
					    		}
				    	}
	
			    	}
	
			    	return clipText;
	
		    },

	    	getRecsFromCsv: function(grid, ta) {
	    		
	    		
	    		
		    	document.body.removeChild(ta);
	
		    	var del = '';
	
		    	if (ta.value.indexOf("\r\n")) {
		    		del = "\r\n";
		    	} else if (ta.value.indexOf("\n")) {
		    		del = "\n"
		    	}
	
		    	var rows = ta.value.split("\n");
		    	
		    	for (var i=0; i<rows.length; i++) {

		    		var cols = rows[i].split("\t");
			    	var columns = grid.initialConfig.columns;
	
			    	if (cols.length > columns.length)
			    		cols = cols.slice(0, columns.length-1)
	
			    	if (gRow === -1 ) {
			    		Ext.Msg.alert('Seleccione una celda para pegar e intente de nuevo!');
			    		return;
			    	}
	
			    	var cfg = {};
			    	var tmpRec = countryStore.getAt(gRow);
	
			    	var existing = false;
			    	if ( tmpRec ) {
				    	cfg = tmpRec.data;
				    	existing = true;
			    	}
	
			    	var l = cols.length;
			    	if ( cols.length > columns.length )
			    		l = columns.length;

			    	
			    	
			    	try {
			    		for (var j=0; j<l; j++) {
				        	if (cols[j] === "") {
					    		return;
					    	}
				        	if ( j in columns ) {
				        		cfg[columns[j].dataIndex] = cols[j];
				        	}
					    
				    	}
			    		me.storeInitialCount++;
				    	cfg['idregistro'] = me.storeInitialCount;
			    	}
			    	catch(err) {
			    		mensajeAlert(err.message);
			    	   return
			    	}

			    	var tmpRow = gRow;
			    	grid.getSelectionModel().clearSelections(true);
	
			    	var tmpRec = Ext.create('Etiqueta',cfg);
			    	if (existing)
			    		countryStore.removeAt(tmpRow);
			    	
			    	countryStore.insert(tmpRow, tmpRec);
			    	gRow = ++tmpRow;

			    	tmpRec.set('tiene_seguro',validaSINO(tmpRec.get('tiene_seguro')));
			    	tmpRec.set('es_cod',validaSINO(tmpRec.get('es_cod')));
			    	tmpRec.set('es_ocurre',validaSINO(tmpRec.get('es_ocurre')));
			    	tmpRec.set('es_multiple',validaSINO(tmpRec.get('es_multiple')));
			    	tmpRec.set('es_ocurre',validaSINO(tmpRec.get('es_ocurre')));
			    	tmpRec.set('nacional',validaTipoEntrega(tmpRec.get('nacional')));

			    	if (!validaSINO(tmpRec.get('razonsocial_rem'))||
			    		!validaSINO(tmpRec.get('calle_rem'))||
			    		!validaSINO(tmpRec.get('numinterior_rem'))||
			    		!validaSINO(tmpRec.get('cp_rem'))||
			    		!validaSINO(tmpRec.get('colonia_rem'))||
			    		!validaSINO(tmpRec.get('municipio_rem')) ){
			    		tmpRec.set('esvalido',1);
			    		
			    	}
			    
			    	if (!validaSINO(tmpRec.get('razonsocial_des'))||
				    		!validaSINO(tmpRec.get('calle_des'))||
				    		!validaSINO(tmpRec.get('numinterior_des'))||
				    		!validaSINO(tmpRec.get('cp_des'))||
				    		!validaSINO(tmpRec.get('colonia_des'))||
				    		!validaSINO(tmpRec.get('municipio_des')) ){
				    		tmpRec.set('esvalido',2);
				    }
			    	
			   
			  
			    	if ((tmpRec.get('numpiezas')==undefined) || (tmpRec.get('numpiezas')==0)){
			    		tmpRec.set('numpiezas',1);
			    	} 
	
		    	}
	
		    	if (gRow == countryStore.getCount()) {
			    	var RowRec = Ext.create('Etiqueta',{});
			    	countryStore.add(RowRec);
			    	countryStore.insert(countryStore.count(), RowRec);
		    	}
	
		    	gRow = 0;
		    	

		    }*/
	 
	 

		}
	]
	});

	me.callParent(arguments);
    },
    loadInfo:function(){
    	this.storeReload.load();
    },
    loadInfoCierra:function( ventana_principal){
    	var ventana = creaVentanaEspera ("Desplegando informacion, espere ...");
    	this.storeReload.load(
    			{
					//params:{},
					callback:function(r,options,success){
						ventana.close();
						 if (ventana_principal!=undefined){
							 ventana_principal.close();
						 }
					 }	  
				}		
    	);
    }
    

});