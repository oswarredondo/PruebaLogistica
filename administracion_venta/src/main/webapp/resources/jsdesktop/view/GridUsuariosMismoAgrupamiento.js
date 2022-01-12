Ext.define('MyDesktop.view.GridUsuariosMismoAgrupamiento', {    extend: 'Ext.grid.Panel',    requires: [        'Ext.grid.column.Action'    ],    stateful: true,    collapsible: false,    multiSelect: true,    stateId: 'stateGridUsuariosMismoAgrupamiento',    viewConfig: {        stripeRows: true,        enableTextSelection: true    },	id:undefined,	isConsulta:false,	myScope:undefined,	identidad:undefined,	idorganizacion:undefined,	numcliente:undefined,	mostrarSoloUsuarioConNivelSuperior:false,    initComponent: function () {		this.myScope = this;						this.store = Ext.create('MyDesktop.store.StoreUsuario',{			 autoLoad: true,			 proxy: {		            type: 'ajax',					url : '../catalogo/usuario/getUsuariosPertenicientesAlAgrupamiento',		            reader: {		                type: 'json',		                root: 'proxiArray'		            }		    }		});		var sm = Ext.create('Ext.selection.CheckboxModel',{mode : 'SINGLE'});		this.selModel= sm;		this.selType= 'checkboxmodel';        this.columns = [            { text: 'Usuario/Login', width: 140, sortable : true, dataIndex: 'login'},			{ text: 'Nombre',width: 200, sortable : true,dataIndex: 'nombre'}		];		this.callParent();    },	getRowSelected:function(){		var rows =  this.getView().getSelectionModel().getSelection();		if(rows.length >=1){			return rows[0];		}		return undefined;	},	getRows:function(){		var rows =  this.getView().getSelectionModel().getSelection();		if(rows.length >=1){			return rows;		}		return undefined;	}		});