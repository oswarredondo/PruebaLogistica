Ext.define('MyDesktop.view.GridUsuarios', {
    extend: 'Ext.grid.Panel',
    requires: [
        'Ext.grid.column.Action'
    ],
    stateful: true,
    collapsible: false,
    multiSelect: true,
    stateId: 'stateGridUsuarios',

    viewConfig: {
        stripeRows: true,
        enableTextSelection: true
    },
	id:undefined,
	isConsulta:false,
	myScope:undefined,
	identidad:undefined,
	idorganizacion:undefined,
	numcliente:undefined,
	propiedadessistema:undefined,
    initComponent: function () {
		this.myScope = this;
		//Si el grid no es de consulta entonces muestra la barra para administrar los datos
		if (!this.isConsulta){
			this.tbar=[
						{ text: 'Cambiar Password',iconCls: 'password_blue',handler:this.cambiarContrasena,scope:this.myScope },
						{xtype: 'tbfill'},
						{xtype:'tbseparator'},
						{ text: 'Agregar',iconCls: 'agregar',handler:this.filtrar,handler:this.agregar, scope:this.myScope },
						{ text: 'Modificar',iconCls: 'editar',handler:this.modificar,scope:this.myScope },
						{xtype:'tbseparator'},
							{ text: 'Activar',iconCls: 'activo',handler:this.activar,scope:this.myScope },
						{ text: 'Desactivar',iconCls: 'desactivado',handler:this.desactivar,scope:this.myScope },
						{ text: 'Grupos',iconCls: 'GRUPO',handler:this.agrupamientos,scope:this.myScope },
						{ text: 'Convenios',iconCls: 'convenio_blue',handler:this.showConvenios,scope:this.myScope },
						{xtype:'tbseparator'},
						{ text: 'PDVs',iconCls: 'shoppingcar_blue',handler:this.showPDVsAsociados,scope:this.myScope, tooltip:'Muestra los PDVs asociados al usuario' }
			];
		}
		var store_tipos_agrupamiento= Ext.create('MyDesktop.store.StoreAgrupamiento',{});
		store_tipos_agrupamiento.load();
		var store_perfiles = Ext.create('MyDesktop.store.StorePerfil',
				{baseParams:{identidad:this.identidad,idorganizacion:this.idorganizacion,numCliente:this.numcliente}});
		store_perfiles.getProxy().setExtraParam("identidad", this.identidad);
		store_perfiles.getProxy().setExtraParam("idorganizacion", this.idorganizacion);
		store_perfiles.getProxy().setExtraParam("onlyActive", true);
		store_perfiles.load();
		
	
	
		//Se carga el combo para que pueda mostrar los datos al momento de setear el valor
		var store_tipos_nivel_usuario = Ext.create('MyDesktop.store.StoreNivelUsuario',
				{
					baseParams:{vertodos:'true'}
				}
		);
		store_tipos_nivel_usuario.getProxy().setExtraParam("vertodos",'true');
		store_tipos_nivel_usuario.load();
		
		this.store = Ext.create('MyDesktop.store.StoreUsuario',{
			baseParams:{identidad:this.identidad,idorganizacion:this.idorganizacion,numCliente:this.numcliente}
		});
		this.store.getProxy().setExtraParam("identidad", this.identidad);
		this.store.getProxy().setExtraParam("idorganizacion", this.idorganizacion);
		this.store.getProxy().setExtraParam("numCliente", this.numcliente);

		var sm = Ext.create('Ext.selection.CheckboxModel',{mode : 'SINGLE'});
		this.selModel= sm;
		this.selType= 'checkboxmodel';
        this.columns = [
			{ xtype: 'actioncolumn',width: 30,
                items: [
					{
						getClass: function(v, meta, rec) {          // Or return a class from a function
							if (rec.get('estatus') == 'A') {
								return 'activo' ;
							} else {
								return 'desactivado';
							}
						},
						handler: function(grid, rowIndex, colIndex) {
							var rec = storeperfiles.getAt(rowIndex);
							//alert(rec.get('idperfil')+ ":" +rec.get('descripcion') );
						}
					}
				]
			}, 
			/*{ text: 'Agrupamiento', width: 100, sortable : true, dataIndex: 'idagrupamiento',
				renderer:function(value, metaData, record, rowIndex, colIndex, store){

					var myrecord=undefined;
					if (store_tipos_agrupamiento.getCount() > 0) {
						store_tipos_agrupamiento.each(function(r) {
							//alert('value:' + value + ', r.data[idagrupamiento]:' +r.data['idagrupamiento'] );
							if (r.data['idagrupamiento'] == value) {
								myrecord = r;
							}
						});
					}
					if (myrecord!=undefined){
						return myrecord.get('descripcion');
					}
					return value;
				}
			}, */
			{ text: 'Nombre',width: 150, sortable : true,dataIndex: 'nombre', hidden:false},
			{ text: 'Perfil', width: 200, sortable : true, dataIndex: 'idperfil',
				renderer:function(value, metaData, record, rowIndex, colIndex, store){
					var myrecord=undefined;
					
					if (store_perfiles.getCount() > 0) {
						store_perfiles.each(function(r) {
							if (r.data['idperfil'] == value) {
								myrecord = r;
							}
						});
					}
					if (myrecord!=undefined){
						return myrecord.get('descripcion_perfil');
					}
					return value;
				}
			}, 
			{ text: 'Plaza', width: 80, sortable : true, dataIndex: 'siglasplaza'},
			{ text: 'F. Eti. Media', width: 80, sortable : true, dataIndex: 'formatoetimedia'},
			{ text: 'F. Eti. Media', width: 80, sortable : true, dataIndex: 'formatoetiperso'},
			{ text: 'Nivel', width: 100, sortable : true, dataIndex: 'nivelpuesto', 
				renderer:function(value, metaData, record, rowIndex, colIndex, store){
					var myrecord=undefined;
					if (store_tipos_nivel_usuario.getCount() > 0) {
						store_tipos_nivel_usuario.each(function(r) {
							if (r.data['identificador'] == value) {
								myrecord = r;
							}
						});
					}  
					if (myrecord!=undefined){
						return myrecord.get('descripcion');
					}
					return value;
				}	
			},
			{ text: 'Oficina', width: 80, sortable : true, dataIndex: 'idoficina'},
			{ text: 'Empleado', width: 80, sortable : true, dataIndex: 'numempleado'},
			{ text: 'Usuario/Login', width: 200, sortable : true, dataIndex: 'login'},
			{ text: 'E-mail', width: 150, sortable : true, dataIndex: 'email'}
			

		];
		
		

		this.callParent();
    },
    showPDVsAsociados:function(){
    	
    	
    	var rows =  this.getView().getSelectionModel().getSelection();
     	if(rows.length <=0){
     		mensajeAlert("Debe de Seleccionar solo un registro para modificar");
     		return;
     	}
		if(rows.length >1){
			mensajeAlert("Seleccione solamente un registro a modificar");
     		return;
     	}
		
    	var gridconvenios = Ext.create('MyDesktop.grid.GridUsuariosPDV',{
			login:rows[0].get('login'),
			numcliente:rows[0].get('numcliente'),
			identidad:rows[0].get('identidad'),
			idorganizacion:rows[0].get('idorganizacion')
		}); 
    
    	if ((rows[0].get('login')=='') || (rows[0].get('identidad')=='0') ||
    	(rows[0].get('idorganizacion')=='0') || (rows[0].get('numcliente')=='0')){
    		mensajeAlert("Usuario no esta configurado con Entidad, Organización, Numero de cliente, verifique");
     		return;
    	}
    	//gridagrupamientos.loadInfo();
		var vent = Ext.create('widget.window', {
			title: "PDVs Usuario:" +rows[0].get('login'),
			width: 250,
			height: 400,
			modal:true,
			iconCls:'shoppingcar_blue',
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: gridconvenios
			
		});
		vent.show();
		
    },
    showConvenios:function(){
    	var rows =  this.getView().getSelectionModel().getSelection();
     	if(rows.length <=0){
     		mensajeAlert("Debe de Seleccionar solo un registro para modificar");
     		return;
     	}
		if(rows.length >1){
			mensajeAlert("Seleccione solamente un registro a modificar");
     		return;
     	}
		
    	var gridconvenios = Ext.create('MyDesktop.grid.GridUsuariosConvenio',{
			login:rows[0].get('login'),
			numcliente:rows[0].get('numcliente'),
			identidad:rows[0].get('identidad'),
			idorganizacion:rows[0].get('idorganizacion')
		}); 
    
    	if ((rows[0].get('login')=='') || (rows[0].get('identidad')=='0') ||
    	(rows[0].get('idorganizacion')=='0') || (rows[0].get('numcliente')=='0')){
    		mensajeAlert("Usuario no esta configurado con Entidad, Organización, Numero de cliente, verifique");
     		return;
    	}
    	//gridagrupamientos.loadInfo();
		var vent = Ext.create('widget.window', {
			title: "Convenios Usuario:" +rows[0].get('login'),
			width: 400,
			height: 400,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: gridconvenios
			
		});
		vent.show();
    },
    agrupamientos:function(){
    	var rows =  this.getView().getSelectionModel().getSelection();
     	if(rows.length <=0){
     		mensajeAlert("Debe de Seleccionar solo un registro para modificar");
     		return;
     	}
		if(rows.length >1){
			mensajeAlert("Seleccione solamente un registro a modificar");
     		return;
     	}
		
    	var gridagrupamientos = Ext.create('MyDesktop.view.GridAgrupacionUsuario',{
			id:'agregar_agrupamiento_usuarios',login:rows[0].get('login')
		}); 
    	
    	//gridagrupamientos.loadInfo();
		Ext.create('widget.window', {
			title: "Agrupamientos Usuario",
			width: 400,
			height: 400,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: gridagrupamientos
			
		}).show();
    },
    
	agregar:function(){
		//Crea una forma de clientes para agregar los datos
		//TODO: Obtiener IdEntidad y IdOrganizacion y pasarlos como parametro
		var forma_agregar = Ext.create('MyDesktop.view.FormUsuarios',{
			id:'agregar_usuarios',height: 400, identidad: this.identidad,
			idorganizacion:this.idorganizacion, numcliente:this.numcliente,operacion:'insert',
			consecurivo:0, grid_scope:this
			}); 
		Ext.create('widget.window', {
			id:'utils-win-agregar-usuario',
			title: "Agregar Usuario",
			width: 450,
			height: 500,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: forma_agregar
			
		}).show();
	},
	modificar:function(){
		var rows =  this.getView().getSelectionModel().getSelection();
     	if(rows.length <=0){
     		Ext.Msg.alert('Verificar',"Debe de Seleccionar solo un registro para modificar");
     		return;
     	}
		if(rows.length >1){
     		Ext.Msg.alert('Verificar',"Seleccione solamente un registro a modificar");
     		return;
     	}

		//Crea una forma de clientes para agregar los datos
		var forma_modificar = Ext.create('MyDesktop.view.FormUsuarios',{id:'modificar_usuarios', 
			isModificaPassword:false,identidad: this.identidad,
			idorganizacion:this.idorganizacion, numcliente:this.numcliente,operacion:'update',
			consecutivo:rows[0].get('consecutivo'), grid_scope:this}); 
		forma_modificar.updateCampos(rows[0]);
		Ext.create('widget.window', {
			id:'utils-win-agregar-usuario',
			title: "Modificar Usuario",
			width: 450,
			height: 500,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: forma_modificar
			
		}).show();
	},
	
	
	eliminar:function(){
		var rows =  this.getView().getSelectionModel().getSelection();
     	if(rows.length <=0){
     		 Ext.Msg.alert('Verificar',"Seleccione los registros que desea eliminar");
     		return;
     	}
		
		if(!confirm('Desea desactivar los clientes seleccionados?')){
     		return;
     	}
		alert('Clientes desactivados');
	},
	cambiarContrasena:function(){
		var rows =  this.getView().getSelectionModel().getSelection();
		if(rows.length <=0){
     		Ext.Msg.alert('Verificar',"Debe de Seleccionar solo un registro para visualizar");
     		return;
     	}
		if(rows.length >1){
     		Ext.Msg.alert('Verificar',"Seleccione solamente un registro a visualizar");
     		return;
     	}
		var forma_showdetails = Ext.create('MyDesktop.view.FormPasswordUsuario',
				{id:'cambiar_password_usuarios_admin_grid',showReadOnly:false}); 
		//Crea una forma de clientes para agregar los datos
		forma_showdetails.updateCampos(rows[0]);
		Ext.create('widget.window', {
			id:'utils-win-agregar-cliente-cambiar-pasword-usuario',
			title: "Password",
			width: 460,
			height: 340,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: forma_showdetails
			
		}).show();
	},
	reload:function(identidad,idorganizacion, numcliente){
		this.getView().getStore().reload(
				{
					params:{identidad:identidad,idorganizacion:idorganizacion,numcliente:numcliente},
					callback:function(r,options,success){
						 if (r.length<=0){
						 }
					 }	  
				});
		
	},
	reloadClient:function(numcliente){
		this.getView().getStore().reload(
				{
					params:{numcliente:numcliente,iscliente:true},
					callback:function(r,options,success){
						 if (r.length<=0){
						 }
					 }	  
				});
		
	},
	activar:function(){
		
		this.activarFunction(this,
				this.getView().getSelectionModel().getSelection(),
				'Desea activar los registros seleccionados?','A');
			
	},
	desactivar:function(scopeview){
		this.activarFunction(this,
				this.getView().getSelectionModel().getSelection(),
					'Desea desactivar los registros seleccionados?','B');

	},
	
	activarFunction:function(myscope,rows, mensaje, estatus){

     	if(rows.length <=0){
     		 Ext.MessageBox.alert('Verificar',"Seleccione los registros que desea procesar");
     		return;
     	}
		
		 Ext.MessageBox.confirm('Confirmar',mensaje, function(id, text){
	       		if ( (id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){ 
	       			var registros ='';
	       			for (i=0;i<rows.length;i++){
	       				
	       				registros = registros+  rows[i].get('consecutivo')+ "|";
	       			}
	       			var conn = new Ext.data.Connection();
	       			conn.request({
	       				url: '../catalogo/usuario/cambiarestatus' ,
	       				params:{ids:registros, estatus:estatus},
	       				success: function(response, opts) {
	       					var obj = Ext.decode(response.responseText);
	       					if (obj.success==false){
	       						Ext.MessageBox.alert('Confirmaci�n',obj.message);
	       					}else{
	       						myscope.reload(myscope.identidad,
	       								myscope.idorganizacion, 
	       								myscope.numcliente);
	       					}
	       				},
	       					
	       				failure: function(response, opts) {
	       					Ext.Msg.alert('Error',response.responseText);

	       				}
	       			});
	       		}
	       	 },myscope);
		
		
	},
	
	getRow:function(){
		var rows =  this.getView().getSelectionModel().getSelection();
		if(rows.length >1){
			return rows[0];
		}
		return undefined;
	},
	
	getRowsSelected:function(){
		var rows =  this.getView().getSelectionModel().getSelection();
	
		return rows;
	}
	
	
});
