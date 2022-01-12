/*!
 * Administracicion de tarifas
 */

Ext.define('MyDesktop.ViewEntidad', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'entidad-organizacion-win',

    init : function(){
        this.launcher = {
            text: 'Entidad/Organización',
            iconCls:'orgentidad_blue'
        }
    },
	gridentidad:undefined,
	organizacion:undefined,
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope= this;
		
		this.gridentidad  =  new MyDesktop.view.GridEntidad({id:this.id+'entidad_grid', title:'Entidades',border:true,iconCls:'entidad_blue'}); 
		this.organizacion = new MyDesktop.view.GridOrganizacion({id:this.id+'organizacion_grid',border:true,title:'Organización',
			iconCls:'organizacion_blue', gridentidad:this.gridentidad}); 
		this.gridentidad.on('select', function( grid, record, index, eOpts ){
						if (record.get('estatus') != 'A') {
							this.organizacion.reload(-1);
						}else{
							this.organizacion.reload(record.get('identidad'));
						}
				},this
				
		);
		

		if(!win){
			//Simple 'border layout' panel to house both grids
			var displayPanel = Ext.create('Ext.Panel', {
				width        : 800,
				height       : 300,
				layout       : {
					type: 'hbox',
					align: 'stretch',
					padding: 5
				},
				defaults     : { flex : 1 }, //auto stretch
				items        : [
					this.gridentidad,
					this.organizacion
				]
			});
			
				win = desktop.createWindow({
				
                id: this.id,
                title:'Entidad/Organización',
                iconCls: 'orgentidad_blue',
                //animCollapse:false,
                border:false,
				resizable:false,
				maximizable:false, 
                constrainHeader:false,
                closable: true,
                closeAction: 'hide',
                width: 950,
                minWidth: 350,
                height: 500,
				layout: 'fit',
				items:[
				       	displayPanel
				],
				bbar:[
		  			    { text: 'Mostrar Servicios',iconCls: 'detalles',handler:this.showDetailServicio, scope:this.myScope },		
				      ]
            });
        }
        return win;
    },
	agregar:function(){
		this.gridentidad.agregar();
	},
	modificar:function(){
		this.gridentidad.modificar();
	},
	eliminar:function(){
		this.gridentidad.eliminar();
	},
	showDetails:function(){
		this.gridentidad.showDetails();
	},
	showDetailServicio:function(){
		//Verifica si se ha seleccionado un perfil
		var myscope= this;
		
		var rows_entidad =  this.gridentidad.getSelectionModel().getSelection();
		var rows_organizacion =  this.organizacion.getSelectionModel().getSelection();
     	if ((rows_entidad.length <=0) || (rows_organizacion.length <=0)){
     		Ext.Msg.alert('Verificar',"Debe de seleccionar entidad y organizacion");
     		return;
     	}
     	if ((rows_entidad.length >1) || (rows_organizacion.length >1)){
     		Ext.Msg.alert('Verificar',"Solo debe seleccionar una entidad y una organizacion");
     		return;
     	}

		var identidad = rows_entidad[0].get('identidad');
		var idorganizacion = rows_organizacion[0].get('idorganizacion');
		
		var serviciosGridStore = Ext.create('MyDesktop.store.StoreServicio',
				{
					autoLoad:false,
					proxy: {
				        type: 'ajax',
				        url : '../catalogo/servicio/getServiosDisponibes',
				        reader: {
			                 type: 'json',
			                 successProperty: 'success',
			                 root : 'proxiArray',
			                 messageProperty: 'message',
			                 totalProperty : 'totalCount',
				        }
				    },
					baseParams:
					{
						isSeleccionados:false,
						identidad:identidad,
						idorganizacion:idorganizacion
					}
				}
		);

		serviciosGridStore.getProxy().setExtraParam("identidad", identidad);
		serviciosGridStore.getProxy().setExtraParam("idorganizacion", idorganizacion);
		serviciosGridStore.reload();
		
		var serviciosSeleccionadosGridStore = Ext.create('MyDesktop.store.StoreServicio',
				{
				autoLoad:false,
				proxy: {
			        type: 'ajax',
			        url : '../catalogo/tiposervicio/getDatos',
			        reader: {
		                 type: 'json',
		                 successProperty: 'success',
		                 root : 'proxiArray',
		                 messageProperty: 'message',
		                 totalProperty : 'totalCount',
			        }
			    },
				baseParams:
					{
						isSeleccionados:true,
						identidad:identidad,
						idorganizacion:idorganizacion
					}
				}
		);
		serviciosSeleccionadosGridStore.getProxy().setExtraParam("identidad", identidad);
		serviciosSeleccionadosGridStore.getProxy().setExtraParam("idorganizacion", idorganizacion);
		serviciosSeleccionadosGridStore.reload();
		
		var columns = [
			{text: "id",width: 60,sortable: true, dataIndex: 'idservicio',hidden:false},
			{text: "Descripcion",width: 200, sortable: true, dataIndex: 'descripcion',hidden:false},
			{text: "Codigoid",width: 70, sortable: true, dataIndex: 'codigoid',hidden:false}
			
		];
		
		var columns_seleccionados = [
		   			{text: "id",width: 60,sortable: true, dataIndex: 'idservicio',hidden:false},
		   			{text: "Descripcion",width: 200, sortable: true, dataIndex: 'descripcion',hidden:false},
		   			{text: "Codigoid",width: 80, sortable: true, dataIndex: 'codigoid',hidden:false},
		   			{text: "Retorno",width: 70, sortable: true, dataIndex: 'codigoid',hidden:false}
		   			
		   		];
				
		 
		// declare the source Grid
		var firstGrid = Ext.create('Ext.grid.Panel', {
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
						
						myscope.requestEliminaAgrega(identidad,idorganizacion,data.records[0],'delete',myscope);
					}
				}
			},
			store            : serviciosGridStore,
			columns          : columns,
			stripeRows       : true,
			title            : 'Servicio disponibles',
			margins          : '0 2 0 0'
		});

	

		// create the destination Grid
		var secondGrid = Ext.create('Ext.grid.Panel', {
			viewConfig: {
				plugins: {
					ptype: 'gridviewdragdrop',
					dragGroup: 'secondGridDDGroup',
					dropGroup: 'firstGridDDGroup'
				},
				listeners: {
					drop: function(node, data, dropRec, dropPosition) {
						myscope.requestEliminaAgrega(identidad,idorganizacion,data.records[0],'insert',myscope);
					}
				} 
			},
			store            : serviciosSeleccionadosGridStore,
			columns          : columns_seleccionados,
			stripeRows       : true,
			iconCls:'decrease_blue',
			title            : 'Servicios seleccionados',
			margins          : '0 0 0 3'
		});

		//Simple 'border layout' panel to house both grids
		var displayPanel = Ext.create('Ext.Panel', {
			width        : 800,
			height       : 300,
			layout       : {
				type: 'hbox',
				align: 'stretch',
				padding: 5
			},
			defaults     : { flex : 1 }, //auto stretch
			items        : [
				firstGrid,
				secondGrid
			]
		});
		
		//Agrega la ventana
		var win_perfilesopcion = Ext.widget('window', {
					iconCls:'lista_blue', title:'Servicios',closeAction: 'hide',closable:true, 
					width: 900,height: 400,minHeight: 150,frame:false, border:false,
					layout: 'fit', resizable: true, modal: true, items: displayPanel ,headerPosition: 'right'
		 });

		win_perfilesopcion.show();	
	},
	requestEliminaAgrega:function(identidad,idorganizacion,record,idopcion,myscope ){
		var my_url_servicio='';
		if (idopcion=='insert'){
			my_url_servicio = '../catalogo/tiposervicio/insert';
		}else if (idopcion=='delete'){
			my_url_servicio = '../catalogo/tiposervicio/delete';
		}else{
			return;
		}
		
		
		var parametros = "identidad="+identidad+"&idorganizacion="+idorganizacion+
		"&idservicio="+record.get('idservicio') +"&nombre="+record.get('nombre')+
		"&descripcion="+record.get('descripcion')+"&identificador=" + record.get('identificador');
		var url = '';
		
		my_url_servicio +=  "?" +parametros;
		var conn = new Ext.data.Connection();
		conn.request({
			url: my_url_servicio,
			timeout:99999999,
			success: function(response, opts) {
				var obj = Ext.decode(response.responseText);
				if (obj.error!=undefined){
					alertMsg("Error",obj.message);
				}
				
			},
			failure: function(response, opts) {
				alertMsg('Error','server-side failure with status code ' + response.status);
			}
		});
	}
	
});
