/** * Esta es utilizada para cuando se desea ver las direcciones de clientes en  * otras pantrallas que no sea administracion de clientes como en cotizaciones * */Ext.define('MyDesktop.view.GridConsultaDireccionesCliente', {    extend: 'Ext.grid.Panel',    requires: [        'Ext.grid.column.Action'    ],    stateful: true,    collapsible: false,    multiSelect: true,    stateId: 'stateGridDireccionesClientesConsulta',    viewConfig: {        stripeRows: true,        enableTextSelection: true    },	id:undefined,	isConsulta:false,	myScope:undefined,	idcliente:undefined, 	numcliente:undefined,	ocultaFiltros:false,	store_dir:undefined,	hiddenAttention:true,	hiddenRFC:true,    initComponent: function () {    	    	if (!this.ocultaFiltros){    		this.combo_tipos_busqueda= Ext.create('Ext.form.ComboBox', {    			fieldLabel: '',    			disabled: false,    			editable:false,    			forceSelection:true,    			store: Ext.create('MyDesktop.store.StoreTiposBusquedaClientes',{}) ,    			queryMode: 'local',    			emptyText: 'Seleccione Tipo',    			displayField: 'descripcion',    			valueField: 'idtipo'    		});    		this.tbar=[    				{    						xtype: 'buttongroup', // <--- grouping the buttons    						items:[    						           								{xtype: 'label', text:'Buscar por:'	},    								this.combo_tipos_busqueda,    								{xtype: 'label', text:'Patrón:'	},    								{xtype: 'myUpperCaseTextField',  id:'idpatronClienteconsulta', allowBlank: false},    								{ iconCls: 'buscar_blue',handler:this.buscar, scope:this},    								{xtype: 'tbfill'}    																	           						       ]    				}           				    			];    	}    			this.myScope = this;		if (this.store_dir!=undefined){			this.store = this.store_dir;		}else{			this.store = Ext.create('MyDesktop.store.StoreDireccionClienteConsulta',{});		}				this.selType= 'checkboxmodel';        this.columns = [                                               {text     : 'Clasificacion',width     : 150,sortable : true,dataIndex: 'clasificacion'},                        {text     : 'R.F.C',width     : 120,sortable : false,dataIndex: 'rfc', hidden:this.hiddenRFC},                        {text     : 'Razon Social',width     : 200,sortable : true,dataIndex: 'descripcion'},                         {text     : 'Atenci�n',width:150,sortable : true,dataIndex: 'atencion', hidden:this.hiddenAttention},						{text     : 'Calle',width     : 200,sortable : true,dataIndex: 'calle'},						{text     : 'Num Int.',width     : 80,sortable : true,dataIndex: 'numinterior'},						{text     : 'Num Ext.',width     : 80,sortable : true,dataIndex: 'numexterior'}, 												{text     : 'Colonia',width     : 200,sortable : true,dataIndex: 'colonia'},						{text     : 'Municipio',width     : 180,sortable : true,dataIndex: 'municipio'},						{text     : 'Estado',width     : 180,sortable : true,dataIndex: 'estado'},						{text     : 'C.P',width     : 80,sortable : true,dataIndex: 'cp'},						{text     : 'Observaciones',width     : 80,sortable : true,dataIndex: 'observacion'}															];			this.callParent();    },	setProxyURL:function(url){		//Actualiza el URL para poder redireccionar el cargado de datos		this.getView().getStore().getProxy().url = url;		this.getView().getStore().reload();	},	reload:function(idcliente){		this.getView().getStore().reload(				{					params:{idcliente:idcliente},					callback:function(r,options,success){						 if (r.length<=0){						 }					 }	  				});			},	setIdCliente:function(idcliente){		this.idCliente = idcliente;	},	getRegistro:function(){		var rows =  this.getView().getSelectionModel().getSelection();		if(rows.length >0){			return rows[0];		}		return undefined;	},	buscarDireccionesCliente:function(tipobusqueda, patronbusqueda,direccionesatencionfacturacion){		this.getView().getStore().reload(				{					params:{tipobusqueda:tipobusqueda,						direccionesatencionfacturacion:direccionesatencionfacturacion==undefined?'':true,						patronbusqueda:patronbusqueda},					callback:function(r,options,success){						 if (r.length<=0){							 Ext.Msg.show({								 title: 'Aviso',								 msg: 'No existe informaci�n con el criterio de busqueda selecionado.',								 modal: false,								 icon: Ext.Msg.INFO,								 buttons: Ext.Msg.OK													 });  													 }					 }	  				});	},	buscar:function(tipobusqueda, patronbusqueda,direccionesatencionfacturacion){				//Busca los clientes de acuerdo al patrion seleccionado		var tipobusqueda = (this.combo_tipos_busqueda.getValue()!=undefined &&		Ext.util.Format.trim(this.combo_tipos_busqueda.getValue()) !='')?Ext.util.Format.trim(this.combo_tipos_busqueda.getValue()):'';				var patronbusqueda = Ext.util.Format.trim(Ext.getCmp('idpatronClienteconsulta').getValue());				if (tipobusqueda==''){			tipobusqueda='00';		}		if (tipobusqueda!='00'){			if (patronbusqueda==''){				alertMsg('Verifique','Indique coincidencia a buscar.');				return;			}		}		this.getView().getStore().reload(					{						params:{tipobusqueda:tipobusqueda,							direccionesatencionfacturacion:direccionesatencionfacturacion==undefined?'':true,							patronbusqueda:patronbusqueda},						callback:function(r,options,success){							 if (r.length<=0){								 Ext.Msg.show({									 title: 'Aviso',									 msg: 'No existe información con el criterio de busqueda selecionado.',									 modal: false,									 icon: Ext.Msg.INFO,									 buttons: Ext.Msg.OK														 });  															 }						 }	  					});	},	});