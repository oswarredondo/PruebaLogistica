/*!
 * Administracicion de tarifas
 */

Ext.define('MyDesktop.ViewPerfiles', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'perfiles-win',

    init : function(){
        this.launcher = {
           title: 'Perfiles',
           iconCls:'perfil_blue'
        }
    },
	myScope:undefined,
	entidadcombo:undefined,
	organizacioncombo:undefined,
	grid_perfiles:undefined,
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope= this;
		var scope_create = this;
		
		this.grid_perfiles  =  new MyDesktop.view.GridPerfiles({id:this.id+'perfiles_grid'}); 
		var storeorganizacion = Ext.create('MyDesktop.store.StoreOrganizacion',{});
		var storeentidad = Ext.create('MyDesktop.store.StoreEntidad',{}); 
	
		this.entidadcombo = Ext.create('Ext.form.field.ComboBox', {
		 	store: storeentidad,
			allowBlank:false,
			width: 260,
			valueField: 'identidad',
			forceSelection:true,
			triggerAction: 'all',  
			displayField: 'descripcion',
			triggerAction: 'all',
			emptyText: 'Seleccione entidad',
			editable:false
		}); 

		this.entidadcombo.on('select', function(combo, record,index) {
	    		var myscope = this;
	    		scope_create.grid_perfiles.getStore().removeAll(true);
	    		scope_create.grid_perfiles.getStore().load({
					params : {
						cat : 'mod',
						identidad : -1,
						idorganizacion : -1
					},
					callback : function(r, options, success) {
						
					}
				});
	    		
	    		//organizacioncombo.clearValue();
				this.organizacioncombo.getStore().load({
					params:{cat:'or', identidad:combo.getValue() },
					callback:function(r,options,success){
						myscope.organizacioncombo.enable();
					}
				});
    		}
    	,this);
		
		this.organizacioncombo = Ext.create('Ext.form.field.ComboBox', {
				allowBlank : false,
				width: 260,
				forceSelection : true,
				valueField : 'idorganizacion',
				disabled : true, // Step 1
				lazyRender : true,
				queryMode : 'local',
				store : storeorganizacion,
				editable : false,
				displayField : 'descripcion',
				triggerAction : 'all',
				mode : 'local', // Step 2
				emptyText : 'Seleccione organizacion',
				listeners : {
					select : function(combo, record, index) {
						scope_create.grid_perfiles.getStore().removeAll(true);
						scope_create.grid_perfiles.getStore().load({
							params : {
								cat : 'mod',
								identidad : scope_create.entidadcombo.getValue(),
								idorganizacion : scope_create.organizacioncombo.getValue()
							},
							callback : function(r, options, success) {
								
							}
						});

					}
				}

		}); 

		if(!win){
			win = desktop.createWindow({
				
                id: this.id,
                title: 'Perfiles',
                iconCls: 'perfil_blue',
                border:false,
                constrainHeader:false,
                closable: true,
                closeAction: 'hide',
                width: 900,
                minWidth: 350,
                height: 500,
				layout: 'fit',
				bbar:[
				    { iconCls: 'detalles',itemId: 'perfilopcion',text: 'Opciones',disabled: false,handler: this.showDetails, scope:scope_create},
				  	{xtype: 'tbfill'},
					{ iconCls: 'agregar', itemId: 'add',  text: 'Agregar',disabled: false, handler: this.agregar, scope:scope_create},
					{ iconCls: 'editar',itemId: 'edit',  text: 'Modificar', disabled: false, handler: this.modificar, scope:scope_create},
					{ text: 'Desactivar',iconCls: 'borrar',handler:this.desactivar,scope:scope_create },
					{ text: 'Activar',iconCls: 'activo',handler:this.activar,scope:scope_create }					
				  ],
				dockedItems: [
					{
						xtype: 'toolbar',
						dock: 'top',
						items: [
							  {xtype:'label', html:'Seleccione <b>Entidad</b>'},    
							this.entidadcombo, {xtype:'label', html:'y <b>Organización</b>'},  this.organizacioncombo     
						]
					}
				],
				items:[
					this.grid_perfiles
				]
			});	
        }
        return win;
    },
	agregar:function(){
		this.grid_perfiles.agregar( this.entidadcombo.getValue(),
				this.organizacioncombo.getValue()
				);
	},
	modificar:function(){
		this.grid_perfiles.modificar(this.entidadcombo.getValue(),
				this.organizacioncombo.getValue());
	},
	activar:function(){
		this.grid_perfiles.activar();
	},
	desactivar:function(){
		this.grid_perfiles.desactivar();
	},
	showDetails:function(){
		//Verifica si se ha seleccionado un perfil
		var myscope= this;
		
		var rows =  this.grid_perfiles.getSelectionModel().getSelection();
     	if(rows.length <=0){
     		Ext.Msg.alert('Verificar',"Debe de seleccionar solo un registro para modificar");
     		return;
     	}
		if(rows.length >1){
     		Ext.Msg.alert('Verificar',"Seleccione solamente un registro a modificar");
     		return;
     	}

		var idperfil = rows[0].get('idperfil');
		var identidad = rows[0].get('identidad');
		var idorganizacion = rows[0].get('idorganizacion');
		
		var firstGridStore = Ext.create('MyDesktop.store.StoreDataObject',
				{baseParams:
					{
						isSeleccionados:false,
						identidad:rows[0].get('identidad'),
						idorganizacion:rows[0].get('idorganizacion'),
						idperfil:rows[0].get('idperfil')
					}
				}
		);
		firstGridStore.getProxy().setExtraParam("isSeleccionados", false);
		firstGridStore.getProxy().setExtraParam("identidad", rows[0].get('identidad'));
		firstGridStore.getProxy().setExtraParam("idorganizacion", rows[0].get('idorganizacion'));
		firstGridStore.getProxy().setExtraParam("idperfil", rows[0].get('idperfil'));
		
		firstGridStore.load();
		
		var secondGridStore = Ext.create('MyDesktop.store.StoreDataObject',
				{baseParams:
					{
						isSeleccionados:true,
						identidad:rows[0].get('identidad'),
						idorganizacion:rows[0].get('idorganizacion'),
						idperfil:rows[0].get('idperfil')
					}
				}
		);
		secondGridStore.getProxy().setExtraParam("isSeleccionados", true);
		secondGridStore.getProxy().setExtraParam("identidad", rows[0].get('identidad'));
		secondGridStore.getProxy().setExtraParam("idorganizacion", rows[0].get('idorganizacion'));
		secondGridStore.getProxy().setExtraParam("idperfil", rows[0].get('idperfil'));
	
		secondGridStore.load();
		
		var columns = [
			{text: "identidad",width: 40,  flex : 1 ,sortable: true, dataIndex: 'identidad',hidden:true},
			{text: "idorganizacion",width: 40, sortable: true, dataIndex: 'idorganizacion',hidden:true},
			{text: "idmodulo",width: 40, sortable: true, dataIndex: 'idmodulo',hidden:true},
			{text: "Opcion",width: 60, sortable: true, dataIndex: 'idopcion'},
			{text: "Menu", width: 150, sortable: true, dataIndex: 'descripcion_modulo'},
			{text: "Opcion", width: 200, sortable: true, dataIndex: 'descripcion_opcion'},
			
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
						
						var tamano = data.records.length;
						
						if(tamano > 1){
							
							for(i = 0; i < tamano; i++){
								
								myscope.requestEliminaAgrega(
										identidad,
										idorganizacion,
										idperfil, 
										data.records[i].get('idmodulo'),
										data.records[i].get('idopcion'),
										'delete',myscope);
								
							}
							
						}else{
							
							myscope.requestEliminaAgrega(
									identidad,
									idorganizacion,
									idperfil, 
									data.records[0].get('idmodulo'),
									data.records[0].get('idopcion'),
									'delete',myscope);
							
						}
						
//						myscope.requestEliminaAgrega(
//								identidad,
//								idorganizacion,
//								idperfil, 
//								data.records[0].get('idmodulo'),
//								data.records[0].get('idopcion'),
//								'delete',myscope);
					}
				}
			},
			store            : firstGridStore,
			columns          : columns,
			stripeRows       : true,
			title            : 'Opciones disponibles',
			margins          : '0 2 0 0'
		});

	

		// create the destination Grid
		var secondGrid = Ext.create('Ext.grid.Panel', {
			multiSelect: true,
			viewConfig: {
				plugins: {
					ptype: 'gridviewdragdrop',
					dragGroup: 'secondGridDDGroup',
					dropGroup: 'firstGridDDGroup'
				},
				listeners: {
					drop: function(node, data, dropRec, dropPosition) {
						
						let tamano = data.records.length;
						
						if(tamano > 1){
							
							for(i=0; i < tamano; i++){
								
								myscope.requestEliminaAgrega(
										identidad,
										idorganizacion,
										idperfil, 
										data.records[i].get('idmodulo'),
										data.records[i].get('idopcion'),
										'insert',myscope);
								
							}
							
						}else{
							
							myscope.requestEliminaAgrega(
									identidad,
									idorganizacion,
									idperfil, 
									data.records[0].get('idmodulo'),
									data.records[0].get('idopcion'),
									'insert',myscope);
							
						}
						
//						myscope.requestEliminaAgrega(
//								identidad,
//								idorganizacion,
//								idperfil, 
//								data.records[0].get('idmodulo'),
//								data.records[0].get('idopcion'),
//								'insert',myscope);
						
						}
				} 
			},
			store            : secondGridStore,
			columns          : columns,
			stripeRows       : true,
			iconCls:'decrease_blue',
			title            : 'Opciones seleccionadas',
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
					iconCls:'lista_blue', title:'Opciones',closeAction: 'hide',closable:true, 
					width: 900,height: 400,minHeight: 150,frame:false, border:false,
					layout: 'fit', resizable: true, modal: true, items: displayPanel ,headerPosition: 'right'
		 });

		win_perfilesopcion.show();	
		
	},
	
	 requestEliminaAgrega: function (identidad,idorganizacion,idperfil,idmodulo,idopcion,tipo, scope){

			
			var parametros = "identidad="+identidad+"&idorganizacion="+idorganizacion+
			"&idperfil="+idperfil +"&tipo="+tipo+"&idmodulo="+idmodulo+"&idopcion="+idopcion;

			var conn = new Ext.data.Connection();
			conn.request({
				url: '../perfilopcion/getInsertDeleteDetallePerfil?'+parametros,
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
