﻿Ext.define('MyDesktop.grid.GridEtiquetasConfiguradas', {    extend: 'Ext.grid.Panel',    requires: [        'Ext.grid.column.Action',        'Ext.grid.plugin.CellEditing',        'Ext.form.field.Text',        'Ext.toolbar.TextItem'    ],    stateful: true,    collapsible: false,    multiSelect: true,    stateId: 'stateGridEtiquetasConfiguradas',    // MIO    idsUsados:undefined,    idsInvalidos:undefined,	selType: 'checkboxmodel',    selModel: {        injectCheckbox: 0,        pruneRemoved: false    },    listeners: {        beforeselect: function(grid, record, index, eOpts) {        	        	var TF = this.validarDatos(record);        	        	if(TF == false){        		        		mensajeAlert("Uno o mas registros que intento seleccionar" +        				"ya fueron procesados, solo podran marcarse los que aun " +        				"no han sido procesados");        		        		return TF;        		        	}else{        		            	var TF = this.validarDatosInvalidos(record);            	            	if(TF == false){            		            		mensajeAlert("Este registros que intento seleccionar" +            				" no puede ser procesado debido a que el convenio asociado ya a expirado o cuenta con un seguro inexistente");            		            		return TF;            		            	}else{            		            		return TF;            		            	}        		        	}        	        }    },    //FIN MIO    viewConfig: {        stripeRows: false,        enableTextSelection: true,        getRowClass: function(record) {         	    		var regreso = "";        	        	var dato = record.get('idregistrodatos');        	        	if(this.idsUsados == undefined || this.idsUsados == ""){//        		regreso = 'adult-row';        		        	}else{        		            	var arreglo = this.idsUsados.split(",");            	            	            	for(i=0;i<arreglo.length;i++){            		                    if (dato == arreglo[i]) {//replace this with your logic.                    	regreso =  'adult-row';                    	                    	break;                    	                    }else{//                    	regreso = 'adult-row';                    	                    }            		            	}        		        	}        	        	if(this.idsInvalidos == undefined || this.idsInvalidos == ""){//        		regreso = 'adult-row';        		        	}else{        		            	var arreglo = this.idsInvalidos.split(",");            	            	            	for(i=0;i<arreglo.length;i++){            		                    if (dato == arreglo[i]) {//replace this with your logic.                    	regreso =  'child-row';                    	                    	break;                    	                    }else{//                    	regreso = 'adult-row';                    	                    }            		            	}        		        	}        	        	return regreso;//            return record.get('cantidad_total') < 2 ? 'child-row' : 'adult-row';         }     },	id:undefined,	isConsulta:false,    initComponent: function () {    	    	this.idsUsados = "";		this.myScope = this;		var myscope_main = this;		this.store = Ext.create('MyDesktop.store.StoreEtiquetasRotuladas',{});//		this.selType= 'checkboxmodel';//	    this.selModel: {//	        injectCheckbox: 0,//	        pruneRemoved: false//	    };		var globalKeyMap_eti_config = new Ext.KeyMap(document); 		globalKeyMap_eti_config.accessKey = function(key, handler, scope) { 		    var h = function(n, e) { 		        e.preventDefault(); 		        handler.call(scope || this, n, e); 		    }; 		    this.on(key, h, scope); 		};				this.on('render', function() { 						globalKeyMap_eti_config.accessKey({key:'e',ctrl:true, alt:false}, myscope_main.eliminar, myscope_main); 			globalKeyMap_eti_config.accessKey({key:'o',ctrl:true, alt:false}, function(){				 				  var rows =  this.getView().getSelectionModel().getSelection();				  if(rows.length <=0){			     		 Ext.Msg.alert('Verificar',"Seleccione el registro que desea consultar");			     		return;			      }                  myscope_main.showWindowsContenidoObserva(rows[0].get('uuid'), rows[0].get('idregistrodatos'));							}, myscope_main); 			globalKeyMap_eti_config.accessKey({key:'m',ctrl:true, alt:false}, function(){				 				  var rows =  this.getView().getSelectionModel().getSelection();				  if(rows.length <=0){			     		 Ext.Msg.alert('Verificar',"Seleccione el registro que desea consultar");			     		return;			      }                myscope_main.showWindowsMedidas(rows[0].get('uuid'), rows[0].get('idregistrodatos'));							}, myscope_main); 						globalKeyMap_eti_config.accessKey({key:'s',ctrl:true, alt:false}, function(){				 				  var rows =  this.getView().getSelectionModel().getSelection();				  if(rows.length <=0){			     		 Ext.Msg.alert('Verificar',"Seleccione el registro que desea consultar");			     		return;			      }              myscope_main.showWindowsSeguroOpcional(rows[0].get('uuid'), rows[0].get('idregistrodatos'));							}, myscope_main); 						globalKeyMap_eti_config.accessKey({key:'a',ctrl:true, alt:false}, function(){				 				  var rows =  this.getView().getSelectionModel().getSelection();				  if(rows.length <=0){			     		 Ext.Msg.alert('Verificar',"Seleccione el registro que desea consultar");			     		return;			      }				  myscope_main.showWindowsAdicionales(rows[0].get('uuid'), rows[0].get('idregistrodatos'));							}, myscope_main); 						        }     );     						this.features= [{	            //id: 'group',	           // ftype: 'groupingsummary',	              ftype: 'summary',	              /* groupHeaderTpl: '{uuid}',	            hideGroupedHeader: true,	            enableGroupingMenu: false*/	        }];  	                this.columns = [                        Ext.create('Ext.grid.RowNumberer',{width:40}),                        {text     : 'UUID',width: 250,sortable : true,dataIndex: 'uuid', hidden:true },						{text     : 'Remitente',width: 280,sortable : true,                        	dataIndex: 'razonsocialorigen',renderer:this.renderRemitente},						{text     : 'Destinatario',width: 280,sortable : true,dataIndex: 'razonsocialdes',                        		renderer:this.renderDestino},  						{text     : 'Servicio',width: 150,sortable : true,dataIndex: 'tarifa_servicio'},//renderer: this.renderAdicionales},						{text     : 'Convenio',width: 150,sortable : true,dataIndex: 'idconvenio',hidden:true },						{text     : 'Ocurre?',width: 80,sortable : true,dataIndex: 'es_ocurre', renderer:this.renderDatosGenerales},						{text     : 'Multiple?',width: 80,sortable : true,dataIndex: 'es_multiple',renderer:this.renderDatosGenerales},						//{text     : 'Entrega',width: 80,sortable : true,dataIndex: 'nacional',renderer:this.renderDatosGenerales},						{text     : 'Asegurado?',width: 90,sortable : true,dataIndex: 'tiene_seguro',renderer:this.renderDatosGenerales},						{text     : 'Adicionales',width: 150,sortable : true,dataIndex: 'adicionales'},						{text     : 'Cant.Etiq.',width: 85,sortable : true,dataIndex: 'cantidad_total', tooltip:'Cantidad total de etiquetas a imprimir', 							summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {								return  '<b><font color=green>' +value + ' Eti.</font></b>';			            	}			            },			            						{text     : 'PF. Total',width: 95,sortable : true,dataIndex: 'pesofisico_total', tooltip:'Peso Físico Total',			            	renderer:function (value, metaData, record, rowIndex, colIndex,store){			            		return value.toFixed(2);			            	},							summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {								return  '<b><font color=#868A08>'+value.toFixed(2) + ' KG</font></b>';			            	}							},						{text     : 'Peso Vol. Total',width: 110,sortable : true,dataIndex: 'pesovolumetrico_total', tooltip:'Peso Volumetrico Total',							renderer:function (value, metaData, record, rowIndex, colIndex,store){			            		return value.toFixed(2);			            	},							summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {								return  '<b><font color=grey>'+value.toFixed(2) + ' KG</font></b>';			            	}								},												{				            xtype:'actioncolumn', 				            width:200,				            items: [													             {				                icon: './resources/images48x48/CloseRed16x16.png',				                tooltip: 'Borrar registro',				               				                handler: function(grid, rowIndex, colIndex) {//				                    var rows =  myscope_main.getView().getSelectionModel().getSelection();				                    				                    var rec = grid.getStore().getAt(rowIndex);				                    //				                 	if(rows.length <=0){//				                 		 Ext.Msg.alert('Verificar',"Seleccione los registros que desea eliminar");//				                 		return;//				                 	}				            						                	 Ext.MessageBox.confirm('Confirmacion', '¿Desea borrar el registro seleccionado?', function(id, text){				                   		if ( (id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){ //				                   			if(rows.length === 0){  //step 3//				                   				return ;//				                   			}				                   							        	       			var conn = new Ext.data.Connection();				        				   	conn.request({				        				   				scope:myscope_main, 				        									method:'POST',				        									defaultHeaders:{'_csrf_header':hv,"_csrf":vt },				        									params:{"idregistrodatos":rec.get('idregistrodatos'),"_csrf":vt},				        								url: './rotular_etiquetas/deleteLineaJson' ,				        								success: function(response, opts) {				        									myscope_main.buscar(rec.get('uuid'));				        								},				        								failure: function(response, opts) {				        					       			if (response.responseText!=undefined){				        					       				var obj = Ext.decode(response.responseText);				        					       				if (obj.message!=undefined){				        					       					mensajeAlert(obj.message);				        						       			}				        						       		}				        				       							        								}				        				   		}); 				                   			////				                   			if(rows.length < 1){////				                   				////				                   				myscope_main.getView().getStore().remove(rows[0])////				                   				////				                   			}else{////				                   				////				                   				for(i = o; i < rows.length; i++){////				                   					////				                   					myscope_main.getView().getStore().remove(rows[i]);////				                   					////				                   				}////				                   				////				                   			}////				                   			//				                   			myscope_main.getView().getStore().remove(rows);  //step 4////				                   			myscope_main.commitInfo();				                   		}				                   	 },myscope_main);				                	 				                }                				            },				           				            				            {xtype:'tbseparator'},				            { 				                icon: './resources/images48x48/Stationery-0232x32.png',				                tooltip: 'Medidas',				                handler: function(grid, rowIndex, colIndex) {				                    var rec = grid.getStore().getAt(rowIndex);				                    myscope_main.showWindowsMedidas(rec.get('uuid'), rec.get('idregistrodatos'));				                    				                }                				            },				            				            				            {xtype:'tbseparator'},				            {				                icon: './resources/images48x48/Editor16x16Green.png',				                tooltip: 'Observacion/Contenido',				                handler: function(grid, rowIndex, colIndex) {				                    var rec = grid.getStore().getAt(rowIndex);				                    myscope_main.showWindowsContenidoObserva(rec.get('uuid'), rec.get('idregistrodatos'));				                    				                }                				            },				            {xtype:'tbseparator'},				            {				                icon: './resources/images48x48/Cube-ShieldYellow16x16.png',				                tooltip: 'Seguro',				                handler: function(grid, rowIndex, colIndex) {				                    var rec = grid.getStore().getAt(rowIndex);				                    if (rec.get('tiene_seguro')=='SI' ){				                    	myscope_main.showWindowsSeguroOpcional(rec.get('uuid'), rec.get('idregistrodatos'),rec.get('idconvenio'));				                    					                    }else{				                    	mensajeWarning("Registro no tiene configurado seguro opcional");				                    	return;				                    }				                }                				            },				            {xtype:'tbseparator'},				            {				                icon: './resources/images48x48/Align-Horizontal-Center16x16.png',				                tooltip: 'Adicionales',				                handler: function(grid, rowIndex, colIndex) {				                    var rec = grid.getStore().getAt(rowIndex);			                    	myscope_main.showWindowsAdicionales(rec.get('uuid'), rec.get('idregistrodatos'),			                    			rec.get('idconvenio'));				                    					                   				                }                				            }				            				            /*,				            {xtype:'tbseparator'},				            {				                icon: './resources/images48x48/Chequ16x16Purple.png',				                tooltip: 'COD',				                hidden:checkEnable('sistema.btn.rotular.manejo.cod'),				                handler: function(grid, rowIndex, colIndex) {				                    var rec = grid.getStore().getAt(rowIndex);				                    if (rec.get('es_cod')=='SI' ){				                    					                    }else{				                    	mensajeWarning("Registro no tiene configurado COD");				                    	return;				                    }				                }                				            }*/				            				            ]				        }				];			this.callParent();    },           showWindowsSeguroOpcional:function(uuid, idregistro, idconvenio){		var gridSeguroAmparadoEtiquetas= new MyDesktop.grid.GridSeguroAmparadoEtiquetas({    		frame:false, border:false,idRotulacion:'',isConsulta:false,    		hidden_cp:true, hidden_garmax:true, flex:2, layout:'fit',    		uuid:uuid,idregistro:idregistro,idconvenio:idconvenio		}); 	    			var datos_window = new Ext.Window({			width    : 645,			height   : 400,			title	: 'Datos de Seguro Opcional',			closable:true,			layout:'fit',			resizable:false,			modal:true,			items: [gridSeguroAmparadoEtiquetas] ,			headerPosition: 'right'		}); 		datos_window.show();	},    showWindowsAdicionales:function(uuid, idregistro, idconvenio){    	var myscope=this;		var grid_adicionales= new MyDesktop.grid.GridAdicional({			height   : 190,frame:true, border:true,			hidden_cp:true, hidden_garmax:true,    		frame:false, border:false,idRotulacion:'',isConsulta:false,    		hidden_cp:true, hidden_garmax:true, flex:2, layout:'fit',    		uuid:uuid,idregistro:idregistro		}); 			var datos_window = new Ext.Window({						width    : 550,			height   : 400,			title	: 'Datos de servicios Adicionales',			closable:true,			layout:'fit',			resizable:false,			modal:true,			items: [grid_adicionales] ,			listeners:{				close: function( panel, eOpts ){					myscope.buscar(uuid);				}							},				buttons:[				    {text:'Guardar Cambios', iconCls:'reload_blue', handler: function(){  				    							 	var rows = grid_adicionales.getRowsSelected();						 								if (rows.length<=0){																mensajeAlert("Seleccione el registro al que va a modificar el precio");																return;															}						 							 	var idregistro = rows[0].get('idregistro');;						 								var precio = rows[0].get('precio');																				 	var conn = new Ext.data.Connection();						 								conn.request({																		url: './catalogo/adicionales/update' ,									method:'POST',									defaultHeaders:{'_csrf_header':hv,"_csrf":vt },									params:{idregistro: idregistro,precio: precio,"_csrf":vt},									success: function(response, opts) {										var obj = Ext.decode(response.responseText);										grid_adicionales.getStore().reload();									},									failure: function(response, opts) {						    			if (response.responseText!=undefined){						    				var obj = Ext.decode(response.responseText);						    				if (obj.message!=undefined){						    					mensajeAlert(obj.message);							       			}							       		}																		}								});													}						},						{xtype:'tbfill'},			        {text:'Borrar', iconCls:'activo', handler: function(){  					 	var rows = grid_adicionales.getRowsSelected();					 	var idregistros = '';					 	for(i=0;i<rows.length;i++){					 		if ((rows[i].get('tipo')=='1') || (rows[i].get('tipo')==1)){					 			mensajeAlert("Adicional " + rows[i].get('descripcion') + " es de tipo requerido, no puede ser borrado." )					 			return;					 		}					 		idregistros = idregistros + rows[i].get('idregistro') +",";						}					 	var conn = new Ext.data.Connection();						conn.request({																url: './catalogo/adicionales/delete' ,								method:'POST',								defaultHeaders:{'_csrf_header':hv,"_csrf":vt },															params:{idregistros: idregistros,"_csrf":vt},								success: function(response, opts) {									var obj = Ext.decode(response.responseText);									grid_adicionales.getStore().reload();								},								failure: function(response, opts) {					    			if (response.responseText!=undefined){					    				var obj = Ext.decode(response.responseText);					    				if (obj.message!=undefined){					    					mensajeAlert(obj.message);						       			}						       		}																}							});											}					},			         {text:'Agregar', iconCls:'agregar', handler: function(){			        	 	var store = Ext.create('MyDesktop.store.StoreAdicionales',{			        	 			baseParams:{uuid:this.uuid,	idregistro:this.idregistro},			        	 			proxy: {			        	 		        type: 'ajax',			        	 		        api: {			        	 		            read: './catalogo/adicionales/getDatosDisponibles'			        	 		        },			        	 		        reader: {			        	 		                 type: 'json',			        	 		                 successProperty: 'success',			        	 		                 root : 'proxiArray',			        	 		                 messageProperty: 'message',			        	 		                 totalProperty : 'totalCount',			        	 		        },			        	 			}			        	 				        	 		}			 				);			        	 	store.getProxy().setExtraParam("uuid", uuid);			        	 	store.getProxy().setExtraParam("idregistrodatos", idregistro);			        	 	store.getProxy().setExtraParam("idconvenio", idconvenio);			        	 		  	        			 var grid_adicionales_new= new MyDesktop.grid.GridAdicional({			        				height   : 190,frame:true, border:true,			        				hidden_cp:true, hidden_garmax:true,			        	    		frame:false, border:false,idRotulacion:'',isConsulta:true,			        	    		hidden_cp:true, hidden_garmax:true, flex:2, layout:'fit',			        	    		uuid:uuid,idregistro:idregistro,mystore:store			        			}); 	  	        					        			var datos_window_new  = new Ext.Window({			        				width    : 550,			        				height   : 300,			        				title	: 'Datos de Servicios Adicionales',			        				closable:true,			        				layout:'fit',			        				resizable:false,			        				modal:true,			        				items: [grid_adicionales_new] ,			        				buttons:[			        				         			        				         {text:'Seleccionar', iconCls:'activo', handler: function(){  			        				        	 	var rows = grid_adicionales_new.getRowsSelected();			        				        	 	if (rows.length>0){			        				        	 		var conn = new Ext.data.Connection();			        				        	 		var ideconvenio = '';			        				        	 		var idadicional = '';			        				        	 		var iddregistrodatos='';			        				        	 					        				        	 		for(i=0;i<rows.length;i++){			        				        	 			idadicional = idadicional + rows[i].get('idadicionaldetalle') +",";			        				        	 		}		        				        	 			conn.request({		        				        	 				method:'POST',		        				        	 				defaultHeaders:{'_csrf_header':hv,"_csrf":vt },		        		 									url: './catalogo/adicionales/insert' ,		        		 									params:{idregistros: idadicional, uuid: uuid,idregistrodatos:idregistro,"_csrf":vt},		        		 									success: function(response, opts) {		        		 										var obj = Ext.decode(response.responseText);		        		 										grid_adicionales.getStore().reload();		        		 										datos_window_new.close();		        		 									},		        		 									failure: function(response, opts) {		        		 						       			if (response.responseText!=undefined){		        		 						       				var obj = Ext.decode(response.responseText);		        		 						       				if (obj.message!=undefined){		        		 						       					mensajeAlert(obj.message);		        		 							       			}		        		 							       		}		        		 					       					        		 								}		        		 					   		});			        		 					   					        				        	 	}else{			        				        	 		mensajeAlert("Seleccione los registros a insertar.")			        				        	 		return;			        				        	 	}			        				        	 			        				         	}			        				         }			        				],			        				headerPosition: 'right'			        			}); 			        			datos_window_new.show();			        		},			         	}			         			      ],							headerPosition: 'right'		}); 		datos_window.show();	},    showWindowsContenidoObserva:function(uuid, idregistro){		var gridObservacionContenidoEtiquetas= new MyDesktop.grid.GridObservacionContenidoEtiquetas({    		frame:false, border:false,idRotulacion:'',isConsulta:false,    		hidden_cp:true, hidden_garmax:true, flex:2, layout:'fit',    		uuid:uuid,idregistro:idregistro		}); 	    			var datos_window = new Ext.Window({			width    : 750,			height   : 400,			title	: 'Observacion/Contenido',			closable:true,			layout:'fit',			resizable:false,			modal:true,			items: [gridObservacionContenidoEtiquetas] ,			headerPosition: 'right'		}); 		datos_window.show();	},	showWindowsMedidas:function(uuid, idregistro){		var myscope = this;		var gridMedidasPesoEtiquetas= new MyDesktop.grid.GridMedidasPesoEtiquetas({    		frame:false, border:false,idRotulacion:'',isConsulta:false,    		hidden_cp:true, hidden_garmax:true, flex:2, layout:'fit',    		uuid:uuid,idregistro:idregistro,    				}); 	    			var datos_window = new Ext.Window({			width    : 550,			height   : 400,			title	: 'Medidas',			closable:true,			layout:'fit',			resizable:false,			modal:true,			items: [gridMedidasPesoEtiquetas] ,			headerPosition: 'right',			listeners:{				close: function( panel, eOpts ){					myscope.buscar(uuid);				}							}			}); 		datos_window.show();	},		agregar:function(){				  var rec = new MyDesktop.models.ModeloAdicionales({			  identificador: 0,			  clave:'',			  descripcion: '',			  precio:0.0,			  tipo:'0'	        }), edit = this.editing;	      edit.cancelEdit();	      this.store.insert(0, rec);	        edit.startEditByPosition({	            row: 0,	            column: 1	      });	        	},	modificar:function(){		var rows =  this.getView().getSelectionModel().getSelection();     	if(rows.length <=0){     		Ext.Msg.alert('Verificar',"Debe de Seleccionar solo un registro para modificar");     		return;     	}		if(rows.length >1){     		Ext.Msg.alert('Verificar',"Seleccione solamente un registro a modificar");     		return;     	}			},			eliminar:function(){		var rows =  this.getView().getSelectionModel().getSelection();     	if(rows.length <=0){     		 Ext.Msg.alert('Verificar',"Seleccione los registros que desea eliminar");     		return;     	}		    	 Ext.MessageBox.confirm('Confirmacion', '¿Desea borrar los registros seleccionados?', function(id, text){       		if ( (id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){        			if(rows.length === 0){  //step 3       				return ;       			}       			this.getView().getStore().remove(rows);  //step 4       			this.commitInfo();       		}       	 },this);     	     	     	 				},	showDetails:function(){			var rows =  this.getView().getSelectionModel().getSelection();     	if(rows.length <=0){     		Ext.Msg.alert('Verificar',"Debe de Seleccionar solo un registro para visualizar");     		return;     	}		if(rows.length >1){     		Ext.Msg.alert('Verificar',"Seleccione solamente un registro a visualizar");     		return;     	}		},	loadInfo:function(){		this.getView().getStore().load();		},	commitInfo:function(){		this.getView().getStore().save( );		this.getView().getStore().commitChanges();		},	saveInfo:function(){		this.getView().getStore().save( );		this.getView().getStore().commitChanges();		this.loadInfo();		},	getRowsSelected:function(){		return this.getView().getSelectionModel().getSelection();	},		renderRemitente:function (value, metaData, record, rowIndex, colIndex,			store) {		var error =[1, 4,5];		var suf = '_rem';		metaData.tdAttr = 'data-qtip="' +		formatoRemDesTipTablaRotular(metaData, record,suf,error) + '"';		return record.get('razonsocial'+suf ) + "-" + record.get('contacto'+suf );			},		renderDestino:function (value, metaData, record, rowIndex, colIndex,			store) {				var error =[2, 4,5];			var suf = '_des';			metaData.tdAttr = 'data-qtip="' +			formatoRemDesTipTablaRotular(metaData, record,suf,error) + '"';			return record.get('razonsocial'+suf ) + "-" + record.get('contacto'+suf );					},		renderDatosGenerales:function (value, metaData, record, rowIndex, colIndex,			store) {		 var error =[3,4,5];		 	metaData.tdAttr = 'data-qtip="' +		 	formatoDatosGeneralesTabla(metaData, record,error, true) + '"';			return value;	},		renderAdicionales:function(value, metaData, record, rowIndex,			colIndex, store) {		var tip = 	"<table width=400 border=0>"+			  "<tr>"+			   " <td bgcolor=#CCCCCC>Cantidad</td>"+			   " <td  >"+record.get('cantidad')+"</td>"+			   " <td bgcolor=#CCCCCC>Servicio</td>"+			"	<td  >"+ record.get('descripcionservicio') +"</td>"+			"  </tr>"+			"    <tr>"+			"    <td  bgcolor=#CCCCCC>Contenido</td>"+			"    <td  >"+ record.get('contenido') +"</td>"+			"    <td  bgcolor=#CCCCCC>Peso</td>"+			"	<td  >"+ record.get('peso')+"</td>"+			"  </tr>"+			"    <tr>"+			"    <td  bgcolor=#CCCCCC>Entrega</td>"+			"    <td >"+ record.get('entrega')+"</td>"+			"    <td  bgcolor=#CCCCCC>Con Retorno</td>"+			"	<td  >"+ record.get('tiene_retorno')+"</td>"+			"  </tr>"+			"    <tr>"+			"    <td  bgcolor=#CCCCCC>Referencia</td>"+			"    <td >"+ record.get('referencia')+"</td>"+			"    <td  bgcolor=#CCCCCC>Observacion</td>"+			"	<td >"+ record.get('observacion')+"</td>"+			"  </tr>"+			"    <tr>"+			"    <td  bgcolor=#CCCCCC>Ocurre</td>"+			"    <td  >"+ record.get('ocurre')+"</td>"+			"    <td bgcolor=#CCCCCC>Multipes</td>"+			"	<td  >"+ record.get('multiples')+"</td>"+			"  </tr>"+			"    <tr>"+			"    <td  bgcolor=#CCCCCC>Monto Asegurado </td>"+			"    <td  >"+ record.get('montoseguro')+"</td>"+			"    <td  bgcolor=#CCCCCC>Monto</td>"+			"	<td >"+ record.get('montocod') + "</td>"+			"  </tr>"+			"</table>";		return tip;//value;	},	buscar:function(uuid){				this.getView().getStore().reload(					{						params:{uuid:uuid},//						callback:function(record,options,success){//							this.idsUsados = '1';////							this.idsUsados = ids;//							// if (r.length<=0){//								 /*Ext.Msg.show({//									 title: 'Aviso',//									 msg: 'No existe información con el criterio de busqueda selecionado.',//									 modal: false,//									 icon: Ext.Msg.INFO,//									 buttons: Ext.Msg.OK						//								 });  //								*///							 //}//						 }	  					});				this.getView().idsUsados = this.idsUsados;		this.getView().idsInvalidos = this.idsInvalidos;		},	eliminarSet:function(uuid){		/*Creamos una conexion al metodo getDireccionIndividual para verificar si cuenta com solo una dieccion*/		var conn = new Ext.data.Connection();	   	conn.request({	   				scope:this, 						method:'POST',						defaultHeaders:{'_csrf_header':hv,"_csrf":vt },						params:{'uuid':uuid,"_csrf":vt},					url: './rotular_etiquetas/deleteRotulacionSet' ,					success: function(response, opts) {																	},					failure: function(response, opts) {		       			if (response.responseText!=undefined){		       				var obj = Ext.decode(response.responseText);		       				if (obj.message!=undefined){		       					mensajeAlert(obj.message);			       			}			       		}	       								}	   		}); 		},	recibeIdsUsados:function(ids){ 				if(this.idsUsados == undefined || this.idsUsados == ""){						this.idsUsados = ids;					}else{						this.idsUsados = this.idsUsados + "," + ids;					}	},	/* Con este metodo validamos que la variable global que tenemos obtenga	 * los datos que mandamos y se encarga de organizarlos de la siguiente manera	 * 1,2,3,4,5 con la finalidad de no tener problemas al hacer un split */	recibeIdsInvalidos:function(ids){ 				if(this.idsInvalidos == undefined || this.idsInvalidos == ""){						this.idsInvalidos = ids;					}else{						this.idsInvalidos = this.idsInvalidos + "," + ids;					}	},	validarDatos:function(record){				var regreso;    	    	var dato = record.get('idregistrodatos');    	    	if(this.idsUsados == undefined || this.idsUsados == ""){    		    		regreso = true;    		    	}else{    		        	var arreglo = this.idsUsados.split(",");        	        	        	for(i=0;i<arreglo.length;i++){        		                if (dato == arreglo[i]) {                                   	regreso =  false;                	                	break;                	                }else{                	                	regreso = true;                	                }        		        	}    		    	}    	    	return regreso;    		},	/* Con este metodo validamos que si se encuentra o no el registro en nuestra variable global	 * y con esto saber si debemos pintar del color el registro o no */	validarDatosInvalidos:function(record){				var regreso;    	    	var dato = record.get('idregistrodatos');    	    	if(this.idsInvalidos == undefined || this.idsInvalidos == ""){    		    		regreso = true;    		    	}else{    		        	var arreglo = this.idsInvalidos.split(",");        	        	        	for(i=0;i<arreglo.length;i++){        		                if (dato == arreglo[i]) {                                   	regreso =  false;                	                	break;                	                }else{                	                	regreso = true;                	                }        		        	}    		    	}    	    	return regreso;    		}//,//	validarRegistros:function(uuid,datos_window){//		var myscope_main = this;//		var conn = new Ext.data.Connection();//			conn.request({// 				method:'POST',// 				defaultHeaders:{'_csrf_header':hv,"_csrf":vt },//					url: './rotular_etiquetas/validarDatosRegistro' ,//					params:{uuid: uuid,"_csrf":vt},//					success: function(response, opts) {//						var obj = Ext.decode(response.responseText);//						//						myscope_main.recibeIdsInvalidos(obj.message);//						//						myscope_main.buscar(uuid);//						//						datos_window.close();//					},//					failure: function(response, opts) {//		       			if (response.responseText!=undefined){//		       				var obj = Ext.decode(response.responseText);//		       				if (obj.message!=undefined){//		       					mensajeAlert(obj.message);//			       			}//			       		}//	       			//				}//	   		});//		//	}	});