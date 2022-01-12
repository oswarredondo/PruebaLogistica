Ext.define('MyDesktop.view.GridParametrosConfiguracion', {    extend: 'Ext.grid.Panel',    requires: [        'Ext.grid.column.Action',        'Ext.grid.plugin.CellEditing',        'Ext.form.field.Text',        'Ext.toolbar.TextItem'    ],    stateful: true,    collapsible: false,    multiSelect: true,    stateId: 'stateGridParametrosConfiguracion',    viewConfig: {        stripeRows: true,        enableTextSelection: true    },	id:undefined,	isConsulta:false,	myScope:undefined,	idsistema:undefined,    initComponent: function () {    	    	 this.editing = Ext.create('Ext.grid.plugin.CellEditing',{clicksToEdit: 1});		 this.plugins = this.editing;				this.store = Ext.create('MyDesktop.store.StoreParametrosConfiguracion',{			baseParams:{				idsistema:this.idsistema			}		});				this.store.getProxy().setExtraParam("idsistema", this.idsistema);				this.selType= 'checkboxmodel';        this.columns = [						{text     : 'Sistema',width: 200,							sortable : true,dataIndex: 'idSistema'						},											{text     : 'Parametro',width: 250,							sortable : true,dataIndex: 'idpropertie'						},						{text     : 'Valor',width: 550,sortable : true,dataIndex: 'valor',							field: {								xtype: 'textfield',			                    maxLength:250,			                    minLength:1,			                    required:true,			                    enforceMaxLength:true							}							}																					];        				this.callParent();    },	agregar:function(){		 	        	},	modificar:function(){					},			eliminar:function(){			},	showDetails:function(){			},	loadInfo:function(){		this.getView().getStore().load();		},	commitInfo:function(){		this.getView().getStore().save( );		this.getView().getStore().commitChanges();		},	saveInfo:function(){		this.getView().getStore().save( );		this.getView().getStore().commitChanges();		this.loadInfo();		},	getRowsSelected:function(){		return this.getView().getSelectionModel().getSelection();	}	});