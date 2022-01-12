 /**
 *Muestra los paquetes que estan como ocurre
 */
Ext.define('MyDesktop.grid.GridPaquetesOcurre', {
    extend: 'Ext.grid.Panel',
    requires: [
               'Ext.grid.column.Action',
               'Ext.grid.plugin.CellEditing',
               'Ext.form.field.Text',
               'Ext.toolbar.TextItem'
           ],
           stateful: true,
           collapsible: false,
           multiSelect: true,
           stateId: 'stateGridPaquetesOcurre',

           viewConfig: {
               stripeRows: true,
               enableTextSelection: true
           },
	idfolio:'',
	url:'',
	constructor: function(config) {
		 //Configura las propiedades
		 this.callParent(arguments);
	     this.initConfig(config);
	     return this;
	},
	initComponent: function(config) {

		this.loadMask=true;
		this.store = Ext.create('MyDesktop.store.StoreMovimientosHistoria',{baseParams:{idfolio:this.idfolio,url:this.url}});
		this.store.getProxy().url=this.url;
		
		this.store.getProxy().setExtraParam("idfolio", this.idfolio);
		this.store.getProxy().setExtraParam("url", this.url);
		this.selType= 'checkboxmodel';
		this.tbar=[
						{ text:'Confirmación',tooltip: 'Confirmar',iconCls: 'pen_green',handler:this.confirmar, scope:this.myScope },
						{xtype:'tbfill'},
						{ text:'Devolución',tooltip: 'Decolución de Paquetes',iconCls: 'pen_red',handler:this.devolucion, scope:this.myScope },
						{ text:'Manif.Devolución',tooltip: 'Manifiesto de envios seleccionados para devolución',iconCls: 'appointment_blue',handler:this.manifiesto, scope:this.myScope }
			      ];
		
		
		
        this.columns = [
			{ header   : 'Guía',  width    : 90, sortable : false, hidden:true, dataIndex: 'idsolicitud' ,menuDisabled: true  },
			{ header   : 'Origen',  width    : 180, sortable : false, hidden:false, dataIndex: 'tiDescripcion' ,menuDisabled: true  },
			{ header   : 'Razón Soc/Atención',  width    : 180, sortable : false, hidden:false, dataIndex: 'tiDescripcion' ,menuDisabled: true  },
			{ header   : 'Destino',  width    : 180, sortable : false, hidden:false, dataIndex: 'tiDescripcion' ,menuDisabled: true  },
			{ header   : 'Razón Soc/Atención',  width    : 180, sortable : false, hidden:false, dataIndex: 'tiDescripcion' ,menuDisabled: true  },
			{ header   : 'Fecha Entrada',  width    : 180, sortable : false, hidden:false, dataIndex: 'tiDescripcion' ,menuDisabled: true  }
			        ];
        this.callParent(arguments);  

		//Carga los datos despues de haber definido el grdi
        this.on('afterlayout', this.loadStore, this, {
            delay: 1,
            single: true
        });
	},
	confirmar:function(){
		var forma_movimiento_caja = Ext.create('MyDesktop.form.FormConfirmacionOcurre',
				{grid_scope:this}); 
		var win_forma_movimiento_caja = Ext.create('widget.window', {
			title: "Confirmar Ocurre",
			width: 500,
			height: 250,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: forma_movimiento_caja
			
		});
		
		win_forma_movimiento_caja.show();
	        
	},
	devolucion:function(){
		var forma_movimiento_caja = Ext.create('MyDesktop.form.FormDevolucionOcurre',
				{grid_scope:this}); 
		var win_forma_movimiento_caja = Ext.create('widget.window', {
			title: "Devolución Ocurre",
			width: 500,
			height: 250,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: forma_movimiento_caja
			
		});
		
		win_forma_movimiento_caja.show();
	},
	manifiesto:function(){
		var forma_movimiento_caja = Ext.create('MyDesktop.form.FormReporteDevoluciones',
				{grid_scope:this}); 
		var win_forma_movimiento_caja = Ext.create('widget.window', {
			title:  "Reporte Devolución Ocurre",
			width: 350,
			height: 140,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: forma_movimiento_caja
			
		});
		
		win_forma_movimiento_caja.show();
	},
	

});

