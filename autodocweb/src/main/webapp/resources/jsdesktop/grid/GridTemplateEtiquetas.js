﻿Ext.define('MyDesktop.grid.GridTemplateEtiquetas', {    extend: 'Ext.grid.Panel',    requires: [        'Ext.grid.column.Action',        'Ext.grid.plugin.CellEditing',        'Ext.form.field.Text',        'Ext.toolbar.TextItem'    ],    stateful: true,    collapsible: false,    multiSelect: true,    stateId: 'stateGridTemplateEtiquetas',    viewConfig: {        stripeRows: true,        enableTextSelection: true    },	uuid:undefined,	idregistro:undefined,	id:undefined,	isConsulta:false,	myScope:undefined,	uuid:undefined,	idregistro:undefined,	main_detalle:undefined,	mystore:undefined,	    initComponent: function () {        	var mainscope=this;    	    	this.store = Ext.create('MyDesktop.store.StoreEtiquetasTemplate',{});		    	var sm = Ext.create('Ext.selection.CheckboxModel',{mode : 'SINGLE'});		this.selModel= sm;				this.selType= 'checkboxmodel';        this.columns = [																	{				            xtype:'actioncolumn', 				            width:60,				            items: [ 				                    {										icon: './resources/images48x48/Editor16x16Green.png',										tooltip: 'Editar línea',									   										handler: function(grid, rowIndex, colIndex) {											var rows =  grid.getSelectionModel().getSelection();											if(rows.length <=0){												mensajeAlert("Seleccione los registros que desea modificar");												return;											}											mainscope.modificar(rows[0],mainscope);										}                									},									{xtype:'tbseparator'},								 {									icon: './resources/images48x48/CloseRed16x16.png',									tooltip: 'Borrar línea',								   									handler: function(grid, rowIndex, colIndex) {										var rows =  grid.getSelectionModel().getSelection();										if(rows.length <=0){											mensajeAlert("Seleccione los registros que desea eliminar");											return;										}																				 Ext.MessageBox.confirm('Confirmacion', 'Desea borrar el registro seleccionado?', 												 function(id, text){											if ( (id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){ 												if(rows.length === 0){  													return ;												}																								var conn = new Ext.data.Connection();										   		conn.request({										   				scope:this, 														url: './template_etiquetas/deleteRegistroTemplate',														method:'POST',														defaultHeaders:{'_csrf_header':hv,"_csrf":vt },														params:{idregistro:rows[0].get('idregistro'),															idtemplate:rows[0].get('idtemplate'),															"_csrf":vt 														},														success: function(response, opts) {															var obj = Ext.decode(response.responseText);															mainscope.getView().getStore().reload(																	{																		params:{idtemplate:mainscope.idtemplate},																		callback:function(r,options,success){																			 if (r.length<=0){																				 Ext.Msg.show({																					 title: 'Aviso',																					 msg: 'No existe información con el criterio de busqueda selecionado.',																					 modal: false,																					 icon: Ext.Msg.INFO,																					 buttons: Ext.Msg.OK																										 });  																																							 }																		 }	  															});														},														failure: function(response, opts) {											       			if (response.responseText!=undefined){											       				var obj = Ext.decode(response.responseText);											       				if (obj.message!=undefined){											       					mensajeAlert(obj.message);												       			}												       		}										       																	}											   		});											}										 },mainscope);										 									}                								}				            ]				        },				        {text     : 'Template',width: 80, sortable : true,dataIndex: 'idtemplate'	},												{text     : 'Descripcion',width: 190,sortable : true,dataIndex: 'descripcion',							field: {								xtype: 'myUpperCaseTextField',			                    maxLength:30,			                    minLength:1,			                    required:true,			                    enforceMaxLength:true			                    			                    							}							},						{text     : 'Acuse',width: 80, sortable : true,dataIndex: 'acuseSoloLeyenda',  							renderer:mainscope.showAcuseLeyenda	},						{text     : 'Estructura Guia',width: 150, sortable : true,dataIndex: 'estructuraguia'},																						{text     : 'Ancho mm',width: 85,sortable : true,dataIndex: 'ancho'},						{text     : 'Alto mm',width: 85,sortable : true,dataIndex: 'alto'}																					];                this.bbar=[	                  					{						text : 'Agregar',						iconCls : 'add32x32',						scope:this,						handler : this.agregar, 						tooltip : 'Agrega nuevo template'					},					/*{xtype:'tbseparator'},					{						text : 'Reload Previo',						iconCls : 'add32x32',						scope:this,						handler : this.buscar, 						tooltip : 'Recarga los datos de template'					},*/					{xtype:'tbfill'},					{						text : 'Clonar',						iconCls : 'data_copy_blue',						scope:this,						handler : this.clonar, 						tooltip : 'Clona un template ya existente'					},					{						text : 'Reload',						iconCls : 'add32x32',						scope:this,						handler : this.buscar, 						tooltip : 'Recarga los datos de template'					},								];        	               			this.callParent();    },       showAcuseLeyenda:function(value, metaData, record, rowIndex, colIndex, store){    	if (record.get('acuseSoloLeyenda')==1){    		return  "SOLO LEYENDA" ;    	}else{    		return  "NUEVA ETIQUETA" ;    	}    	    },        clonar:function(){    		var myscope= this;    		    		var rows =  this.getView().getSelectionModel().getSelection();         	if(rows.length <=0){         		mensajeAlert("Seleccione plantilla que desea clonar");         		return;         	}    		if(rows.length >1){    			mensajeAlert("Seleccione solamente una plantilla ");         		return;         	}						var formpropiedades = new MyDesktop.form.FormTemplateEtiqueta({				operacion:'clonarTemplate',idtemplate:rows[0].get('idtemplate'),				idregistro:rows[0].get('idregistro'),idtemplateReadOnly:true,				isclonar:true,				main_detalle:myscope.main_detalle							});						formpropiedades.updateCampos(rows[0]);			setValorFormaField('_csrf', formpropiedades,vt);						var datos_window = new Ext.Window({				width    : 400,				height   : 220,				title	: 'Clonar Template',				closable:true,				layout:'fit',				resizable:false,				modal:true,				items: [formpropiedades] ,				headerPosition: 'right'			}); 			formpropiedades.setMainWindows(datos_window); 			formpropiedades.setMainGrid(myscope);			datos_window.show();    	    },	agregar:function(){		var myscope= this;				var formpropiedades = new MyDesktop.form.FormTemplateEtiqueta({			operacion:'creaRegistroTemplate',idtemplateReadOnly:false,			idregistro:0,main_detalle:myscope.main_detalle		});		setValorFormaField('_csrf', formpropiedades,vt);		var datos_window = new Ext.Window({			width    : 400,			height   : 230,			title	: 'Crear Template',			closable:true,			layout:'fit',			resizable:false,			modal:true,			items: [formpropiedades] ,			headerPosition: 'right'		}); 		formpropiedades.setMainWindows(datos_window); 		formpropiedades.setMainGrid(myscope);		datos_window.show();	        	},	modificar:function(registro,mainscope){		var myscope= mainscope;				var formpropiedades = new MyDesktop.form.FormTemplateEtiqueta({			operacion:'updateRegistroTemplate',idtemplate:myscope.idtemplate,			idregistro:registro.get('idregistro'),idtemplateReadOnly:true,			main_detalle:myscope.main_detalle					});		formpropiedades.updateCampos(registro);		setValorFormaField('_csrf', formpropiedades,vt);		var datos_window = new Ext.Window({			width    : 400,			height   : 230,			title	: 'Actualiza Template',			closable:true,			layout:'fit',			resizable:false,			modal:true,			items: [formpropiedades] ,			headerPosition: 'right'		}); 		formpropiedades.setMainWindows(datos_window); 		formpropiedades.setMainGrid(myscope);		datos_window.show();			},	buscar:function(){		this.main_detalle.buscar('');		this.getView().getStore().reload(				{										callback:function(r,options,success){						 if (r.length<=0){							/* Ext.Msg.show({								 title: 'Aviso',								 msg: 'No existe informaci�n con el criterio de busqueda selecionado.',								 modal: false,								 icon: Ext.Msg.INFO,								 buttons: Ext.Msg.OK													 }); */ 													 }					 }	  		});	},	loadInfo:function(){		this.getView().getStore().load();		},	commitInfo:function(){		this.getView().getStore().save( );		this.getView().getStore().commitChanges();		},	saveInfo:function(){		this.getView().getStore().save( );		this.getView().getStore().commitChanges();		this.loadInfo();		},	getRowsSelected:function(){		return this.getView().getSelectionModel().getSelection();	},	setUUIDIdRegistro:function(uuid,idregistro){		this.uuid=uuid;		this.idregistro = ideregistro;	}	});