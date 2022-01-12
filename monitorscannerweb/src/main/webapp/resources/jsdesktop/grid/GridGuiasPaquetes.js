 /**
 * Grid para la consulta de historia o mivimientos
 * de un pedido, guia, solicitud, etc
 */
Ext.define('MyDesktop.grid.GridGuiasPaquetes', {
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
           stateId: 'stateGridGuiasPaquetes',

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
		
		
        this.columns = [
			{id :'idsolicitud', header   : 'Guía',  width    : 90, sortable : false, hidden:true, dataIndex: 'idsolicitud' ,menuDisabled: true  },
			{id :'descripcion', header   : 'Recepción',  width    : 180, sortable : false, hidden:false, dataIndex: 'tiDescripcion' ,menuDisabled: true  },
			{id :'descripcion', header   : 'Recibe',  width    : 180, sortable : false, hidden:false, dataIndex: 'tiDescripcion' ,menuDisabled: true  },
			{id :'fecha', header   : 'Fecha',  width    : 120, sortable : false, hidden:false, dataIndex: 'fecha' ,menuDisabled: true  }
			        ];
        this.callParent(arguments);  

		//Carga los datos despues de haber definido el grdi
        this.on('afterlayout', this.loadStore, this, {
            delay: 1,
            single: true
        });
	}

});

