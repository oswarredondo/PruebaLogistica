﻿Ext.define('MyDesktop.grid.GridHistoria', {    extend: 'Ext.grid.Panel',    stateful: true,    collapsible: false,    multiSelect: true,    stateId: 'stateGridHistoria',    viewConfig: {        stripeRows: true,        enableTextSelection: true    },	id:undefined,	iddocumento:'',	buscarHistoriaUps:false,	columnas:undefined,	customStore:undefined,	isFueraSitio:false,	idguiainternacional:'',	mensajeria:'',		initComponent: function () {		this.myScope = this;		var my_scope=this;		if (this.customStore == undefined){			this.store = Ext.create('MyDesktop.store.StoreHistoria',					{baseParams:{iddocumento:this.iddocumento, 						buscarHistoriaUps:this.buscarHistoriaUps}}					);		}else{			this.store = this.customStore;		}		this.store.getProxy().setExtraParam("iddocumento", this.iddocumento);		this.store.getProxy().setExtraParam("buscarHistoriaUps", this.buscarHistoriaUps);		this.store.getProxy().setExtraParam("idguiainternacional", this.idguiainternacional);		this.store.getProxy().setExtraParam("mensajeria", this.mensajeria);				if (this.columnas!=undefined){			this.columns=this.columnas; 					}else{			//Columnas por default			 this.columns = [								{									menuDisabled: true,	sortable: false,									xtype: 'actioncolumn',	width: 20,									items: [										{											getClass: function(v, meta, rec) {																								if ((rec.get('imagen_css') == undefined) || 														(rec.get('imagen_css') == '') 	){													return 'HISTORIA' ;												}else{													return rec.get('imagen_css');																								}											},											getTip: function(v, meta, rec) {												if ((rec.get('descripcion_estatus') == undefined) || 															(rec.get('descripcion_estatus') == '') 	){																									return 'HISTORIA' ;												}else{													return rec.get('descripcion_estatus');																								}																																			},											handler: function(grid, rowIndex, colIndex) {												 var rec = grid.getStore().getAt(rowIndex);												 my_scope.abreVentanaLocalizacionEventoRow(rec,my_scope);																																																	}										}									]								},								{text     : 'Movimiento',width: 120,sortable : true,dataIndex: 'descripcion'								},								{text     : 'Fecha',width: 160,sortable : true,dataIndex: 'fecha'},								{text     : 'Excepcion/Casamiento',width: 200,sortable : true,dataIndex: 'exclave'},								{text     : 'CEDIS',width: 130,sortable : true,dataIndex: 'plazaorigina'}, 								{text     : 'Plaza',width: 50,sortable : true,dataIndex: 'siglasplaza'},								{text     : 'Ruta',width: 70,sortable : true,dataIndex: 'ruta'},								{text     : 'Empleado',width: 100,sortable : true,dataIndex: 'empleado'}													];		}		       			this.callParent();    },	    abreVentanaLocalizacionEventoRow:function(row, scope){    			var my_scope = this;		var rows =  this.getView().getSelectionModel().getSelection();     	if(rows.length <=0){     		mensajeAlert("Debe de Seleccionar registro a visualizar. ");     		return;     	}		if(rows.length >1){     		mensajeAlert("Seleccione solamente un registro a visualizar. ");     		return;     	}		if ((rows[0].get('latitud') == '' ) || (rows[0].get('longitud') == '' )){			mensajeAlert("No existen datos de latitud y longitud a mostrar. ");     		return;		}		var url ="..";				if (this.isFueraSitio){			url =".";		}				url =url+"/gmapscontroller/gmapscoordenadas?latitud="+rows[0].get('latitud')+"&longitud="+rows[0].get('longitud');		visorPDF(				'utils-win-vistaprevia-historia_localizacion_envio'+ rows[0].get('idDocumento'),				"Localización Entrega[ " + rows[0].get('latitud') + "," + rows[0].get('longitud') +"]",url);    	    },     	loadInfo:function(){		this.getView().getStore().load();		},    buscar:function(parametros){    	if (parametros==undefined){    		parametros={};    	}		this.getView().getStore().reload(					{						params:parametros,						callback:function(r,options,success){							 if (r.length<=0){								 Ext.Msg.show({									 title: 'Aviso',									 msg: 'No existe información con el criterio de busqueda selecionado.',									 modal: false,									 icon: Ext.Msg.INFO,									 buttons: Ext.Msg.OK														 });  															 }						 }	  					});		},	});