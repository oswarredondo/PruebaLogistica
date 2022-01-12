/*!
 *Contiene el funcionamiento para la administracion de los descuentos
 */

Ext.define('MyDesktop.ViewDescuentoDetalleTipo', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],
    id:'detalle-descuentos-tarifa-cliente-zona-win',
    init : function(){
        /*this.launcher = {
            text: 'Detalle Descuentos',
            iconCls:'ordenservicio_blue'
        }*/
    },

	myScope:undefined,
	iddescuento:undefined, //identificador del descuento que se esta trabajando
	tipo:undefined, //Indica si el tipo es de Cliente, Tarifa, Zona
	url_store_disponibles:undefined,
	url_store_seleccionados:undefined,
	title:undefined,
	title_disponibles:undefined,
	title_seleccionados:undefined,
	gridStoreDisponibles:undefined,
	gridStoreSeleccionados:undefined,
	
	createWindow : function(parametros){
	

        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope=this;
		var scope_fn =this;
		this.iddescuento=  parametros.iddescuento;
		
		this.tipo = parametros.tipo;
		var columns = [
			{text: "Id",width: 70, ortable: true, dataIndex: 'identificador',hidden:false},
			{text: "Descripcion",width: 330, sortable: true, dataIndex: 'descripcion',hidden:false}
		];
		
		
		this.gridStoreDisponibles = Ext.create('MyDesktop.store.StoreDescuentosTipoDetalle',{baseParams:{iddescuento:parametros.iddescuento, tipo:parametros.tipo}}); 
		this.gridStoreSeleccionados  = Ext.create('MyDesktop.store.StoreDescuentosTipoDetalle',{baseParams:{iddescuento:parametros.iddescuento, tipo:parametros.tipo}}); 
		if (( parametros.url_store_disponibles!=undefined) &&  ( parametros.url_store_disponibles!='')){
			this.gridStoreDisponibles.getProxy().url = parametros.url_store_disponibles;
			this.gridStoreDisponibles.getProxy().setExtraParam("iddescuento", parametros.iddescuento);
			this.gridStoreDisponibles.getProxy().setExtraParam("tipo", parametros.tipo);
			
		}
		//this.gridStoreDisponibles.load();
		
		if (( parametros.url_store_seleccionados!=undefined) &&  ( parametros.url_store_seleccionados!='')){
			this.gridStoreSeleccionados.getProxy().url =  parametros.url_store_seleccionados;
			this.gridStoreSeleccionados.getProxy().setExtraParam("iddescuento", parametros.iddescuento);
			this.gridStoreSeleccionados.getProxy().setExtraParam("tipo", parametros.tipo);
		}
		//this.gridStoreSeleccionados.load();
		
		// declare the source Grid
		var gridDisponibles = Ext.create('Ext.grid.Panel', {
			multiSelect: true,
			iconCls:'increase_blue',
			viewConfig: {
				plugins: {
					ptype: 'gridviewdragdrop',
					dragGroup: 'firstGridDDGroup',
					dropGroup: 'secondGridDDGroup'
				},
				listeners: {
					drop: function(node, data, dropRec, dropPosition) {
						for(i=0;i<data.records.length;i++){ 
							//Manda la solicitud para eliminar 
							scope_fn.requestEliminaAgrega(parametros.iddescuento,data.records[0].get('identificador'),parametros.tipo, 'delete', scope_fn);
						}
					}
				}
			},
			store            : this.gridStoreDisponibles,
			columns          : columns,
			stripeRows       : true,
			title            :  parametros.title_disponibles,
			margins          : '0 2 0 0'
		});
		
		// create the destination Grid
		var gridSeleccionados = Ext.create('Ext.grid.Panel', {
			viewConfig: {
				plugins: {
					ptype: 'gridviewdragdrop',
					dragGroup: 'secondGridDDGroup',
					dropGroup: 'firstGridDDGroup'
				},
				listeners: {
					drop: function(node, data, dropRec, dropPosition) {
						for(i=0;i<data.records.length;i++){ 
							//Manda la solicitud para agregar 
							scope_fn.requestEliminaAgrega(parametros.iddescuento,data.records[0].get('identificador'),parametros.tipo, 'insert',scope_fn);
						}
					}
				}
			},
			store            : this.gridStoreSeleccionados,
			columns          : columns,
			stripeRows       : true,
			iconCls:'decrease_blue',
			title            : parametros.title_seleccionados,
			margins          : '0 0 0 3'
		});
		
		var displayPanel = Ext.create('Ext.Panel', {
			width        : 680,
			height       : 300,
			layout       : {
				type: 'hbox',
				align: 'stretch',
				padding: 5
			},
			defaults     : { flex : 1 }, //auto stretch
			items        : [
				gridDisponibles,
				gridSeleccionados
			]
		});
		
		//Carga los datos
		this.reload();
        if(!win){
		    win = desktop.createWindow({
                id: this.id,
				iconCls:'lista_blue', 
				title: parametros.title,
				closeAction: 'hide',
				closable:true, 
				maximizable:false,
				minimizable:false,			
				width: 870,
				height: 400,
				minHeight: 150,
				frame:false, 
				border:false,
				layout: 'fit', 
				resizable: false, 
				modal: true, 
				headerPosition: 'right',
				items: displayPanel 
            });
        }
        return win;
    },
    
    reload:function(){
    	this.gridStoreDisponibles.load();
    	this.gridStoreSeleccionados.load();
    },
    
    requestEliminaAgrega: function (iddescuento,identificador,tipo, operacion, scope){

		var parametros = "iddescuento="+iddescuento+"&identificador="+identificador+
			"&tipo="+tipo;

		var conn = new Ext.data.Connection();
		conn.request({
			url: '../descuentodetalle/' + operacion+ '?'+parametros,
			timeout:60000,
			success: function(response, opts) {
				var obj = Ext.decode(response.responseText);
				
				if (obj.success!=undefined){
					//alertMsg("Exito",obj.message);
					scope.reload();
				}
				if (obj.error!=undefined){
					//Ext.example.msg(obj.error, obj.message);
					alertMsg("Error",obj.message);
				}
				
			},
			failure: function(response, opts) {
				alertMsg('Error','server-side failure with status code ' + response.status);
			}
		});
	}
});
