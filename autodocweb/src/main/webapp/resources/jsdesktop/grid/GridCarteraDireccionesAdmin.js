 /**
 * Grid para la consulta de historia o mivimientos
 * de un pedido, guia, solicitud, etc
 */
Ext.define('MyDesktop.grid.GridCarteraDireccionesAdmin', {
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
           stateId: 'stateGridCarteraDireccionesAdmin',

           viewConfig: {
               stripeRows: true,
               enableTextSelection: true
           },
	idfolio:'',
	url:'',
	isConsulta:true,
	mainwindow:undefined,
	constructor: function(config) {
		 //Configura las propiedades
		 this.callParent(arguments);
	     this.initConfig(config);
	     return this;
	},
	
	tipo_str:undefined,
	patron_busqueda:undefined,
	tipo:undefined,
	combo_tipos_busqueda:undefined,
	combo_modalidad:undefined,
	combo_usuarios:undefined,
	initComponent: function(config) {
		var myScope = this;
		this.loadMask=true;
		this.store = Ext.create('MyDesktop.store.StoreCarteraDirecciones',{
			proxy: {
		        type: 'ajax',
		        api: {
		            read: './rotular_etiquetas/carteraremdes/getDirecciones',
		            destroy:'./rotular_etiquetas/carteraremdes/deleteJson'	
		          },
		        reader: {
		                 type: 'json',
		                 successProperty: 'success',
		                 root : 'proxiArray',
		                 messageProperty: 'message',
		                 totalProperty : 'totalCount',
		        },
		        writer: {
		            	 type: 'json',
		                 writeAllFields: true,
		                 encode: false,
		                 root: 'proxiArray'
		        }
			}
			
		});
		
		this.selType= 'checkboxmodel';
		var sm = Ext.create('Ext.selection.CheckboxModel',{mode : 'SINGLE'});
		this.selModel= sm;

        this.columns = [
            { header   : 'Tipo',  width    : 80, sortable : true, hidden:false, dataIndex: 'tipoDireccion'   },
            { header   : 'R.F.C',  width    : 150, sortable : true, hidden:false, dataIndex: 'rfc'   },
			{ header   : 'Razon Social',  width    : 150, sortable : true, hidden:false, dataIndex: 'razonSocial'   },
			{ header   : 'Atención',  width    : 150, sortable : true, hidden:false, dataIndex: 'atencion'   },
			{ header   : 'Calle',  width    : 150, sortable : true, hidden:false, dataIndex: 'calle'   },
			{ header   : '#Interior',  width    : 100, sortable : true, hidden:false, dataIndex: 'numinterior'   },
			{ header   : '#Exterior',  width    : 100, sortable : true, hidden:false, dataIndex: 'numexterior'   },
			{ header   : 'Colonia',  width    : 150, sortable : true, hidden:false, dataIndex: 'colonia'   },
			{ header   : 'Ciudad',  width    : 150, sortable : true, hidden:false, dataIndex: 'ciudad'   },
			{ header   : 'Municipio',  width    : 150, sortable : true, hidden:false, dataIndex: 'municipio'   },
			{ header   : 'Estado',  width    : 150, sortable : true, hidden:false, dataIndex: 'estado'   },
			{ header   : 'C.P',  width    : 70, sortable : true, hidden:false, dataIndex: 'cp'   },
			{ header   : 'Telefono',  width    : 150, sortable : true, hidden:false, dataIndex: 'telefono'   },
			{ header   : 'Celular',  width    : 150, sortable : true, hidden:false, dataIndex: 'numcelular'   },
			{ header   : 'Correo',  width    : 150, sortable : true, hidden:false, dataIndex: 'correoe'   }
			];
        	
        	/*Se crea un combobox para poner odos los usuarios de la misma identidad organizacion y num de cliente*/
	        this.combo_usuarios= Ext.create('Ext.form.ComboBox', {
				fieldLabel: '',
				name: 'idUsuario',  
				disabled: false,
				editable:false,
				forceSelection:true,
				store: Ext.create('MyDesktop.store.StoreUsuarioDirecciones',{}) ,
				queryMode: 'local',
				emptyText: 'Seleccione Usuario',
				displayField: 'login',
				valueField: 'login'
	        }); 
	        this.combo_usuarios.store.sort('login', 'ASC');
	        this.combo_tipos_busqueda= Ext.create('Ext.form.ComboBox', {
				fieldLabel: '',
				disabled: false,
				editable:false,
				forceSelection:true,
				store: Ext.create('MyDesktop.store.StoreTiposBusquedaRemDes',{}) ,
				queryMode: 'local',
				emptyText: 'Seleccione Tipo',
				displayField: 'descripcion',
				valueField: 'idtipo',
				value:'1'	
	        });
	        
	        this.combo_modalidad= Ext.create('Ext.form.ComboBox', {
				fieldLabel: '',
				disabled: false,
				editable:false,
				forceSelection:true,
				store: Ext.create('MyDesktop.store.StoreTiposModalidadCarteraRemDes',{}) ,
				queryMode: 'local',
				emptyText: 'Seleccione Tipo',
				displayField: 'descripcion',
				valueField: 'idtipo',
				value:'AMBOS'	
	        });
	        
	        /*Se crea un txtlabel y se agrega un tooltip*/
	        this.patron_busqueda = Ext.create('MyDesktop.objetos.TextFieldUpperCase',{inputAttrTpl: " data-qtip='<p>Escribe <b>%</b> para buscar todos</p>" +
	        		"<p>Escribe <b>A</b> o <b>Angel</b> para buscar datos que contengan dicha palabra o letra</p>" +
	        		"<p>Escribe <b>1</b> u <b>11</b> buscar datos que contengan dicho numero</p>'"});

	        this.tbar=[
	                    {xtype: 'label', text:'Usuarios:'	},
	                    this.combo_usuarios,
	                   	{xtype: 'label', text:'Incluir solo:'	},
	                   	this.combo_modalidad,
						{xtype: 'label', text:'Buscar por:'	},
						this.combo_tipos_busqueda,
						{xtype: 'label', text:'Patrón:'	},
						this.patron_busqueda,
						{ iconCls: 'buscar_blue',handler:this.filtraInfo, scope:this},
						
					];
	        
   		 	this.bbar=[
			           
					{ text: 'Agregar',iconCls: 'agregar',handler:this.agregar, scope:myScope },

					{xtype:'tbseparator'},
					{ text: 'Modificar',iconCls: 'editar',handler:this.modificar,scope:myScope },
					
					{xtype:'tbseparator'},
					{ text: 'Borrar',iconCls: 'borrar',handler:this.eliminar,scope:myScope },
					
					{xtype:'tbfill'},
					{xtype:'tbseparator'},
					{
							text : 'Importar Direcciones Masivas',
							iconCls : 'upload32x32',
							scope:myScope,
							handler : myScope.importar, 
							
							tooltip : 'Importa Datos de un archivo de Excel para su registro'
					},

			];
   		 
   		
        
        this.callParent(arguments);  

		//Carga los datos despues de haber definido el grdi
        this.on('afterlayout', this.loadStore, this, {
            delay: 1,
            single: true
        });
	},
	filtraInfo:function(){
		
		if (this.patron_busqueda.getValue()==''){
			mensajeAlert("Debe indicar el patrón a buscar");
     		return;
		}
		
		if (this.combo_usuarios.getValue() == '' || this.combo_usuarios.getValue() == null){
			mensajeAlert("Debe indicar el usuario a buscar");
     		return;
		}
		
		this.getView().getStore().reload(
				{
					params:{
						numcliente:this.combo_usuarios.getValue(), 
						tipo:this.combo_tipos_busqueda.getValue(),
						patron_busqueda:this.patron_busqueda.getValue(),
						tipo_str:this.combo_modalidad.getValue()
					},
					callback:function(r,options,success){
						 if (r.length<=0){
							 mensajeWarning('No existe información con el criterio de busqueda selecionado.');  
							
						 }
					 }	  
				});
	},
	agregar:function(){
		
		var login = this.combo_usuarios.getValue();
		
		/*Validamos que se seleccione un usuario*/
		if (login == "" || login == null){
				mensajeAlert("Debe indicar un usuario");
					return;
			}
		
		//Crea una forma de clientes para agregar los datos
		var forma_agregar = Ext.create('MyDesktop.form.FormCarteraDirecciones',
				{id:'agregar_cliente',operacion:'insert', main_grid:this,login: login }); 
		
		var main_window = Ext.create('widget.window', {
			title: "Agregar Datos Dirección",
			iconCls: 'agregar',
			width: 400,
			height: 500,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: forma_agregar
			
		});
		main_window.show();
		forma_agregar.setMainWindow(main_window);
	},
	modificar:function(){
		
		var login = this.combo_usuarios.getValue();
		
		var rows =  this.getView().getSelectionModel().getSelection();
     	if(rows.length <=0){
     		mensajeAlert("Debe de Seleccionar solo un registro para modificar");
     		return;
     	}
		if(rows.length >1){
     		mensajeAlert("Seleccione solamente un registro a modificar");
     		return;
     	}

		/*for (i=0;i<rows.length;i++){
     		if (rows[i].get('estatus')==3){
     			mensajeAlert("Registro "+rows[i].get('razonSocial')+ " esta bloqueado, operación inválida.");
         		return;
     		}	
			
		}*/
		
		//Crea una forma de clientes para agregar los datos
		var forma_modificar = Ext.create('MyDesktop.form.FormCarteraDirecciones',{
			operacion:'update',main_grid:this,login: login}); 
		forma_modificar.updateCampos(rows[0]);
		setValorFormaField('_csrf', forma_modificar,vt);
		var main_window = Ext.create('widget.window', {
			
			title: "Modificar Datos Dirección",
			width: 400,
			iconCls: 'editar',
			height: 500,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: forma_modificar
			
		});
		forma_modificar.setMainWindow(main_window);
		main_window.show();
	
		
	},
	
	
	eliminar:function(){
		var rows =  this.getView().getSelectionModel().getSelection();
     	if(rows.length <=0){
     		mensajeAlert("Debe de Seleccionar solo un registro para eliminar");
     		return;
     	}
		if(rows.length >1){
     		mensajeAlert("Seleccione solamente un registro a eliminar");
     		return;
     	}
		var myscope = this;
		 Ext.MessageBox.confirm('Confirmacion', '¿Desea borrar los registros seleccionados?', function(id, text){
	       		if ( (id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){ 
	       			if(rows.length === 0){  //step 3
	       				return ;
	       			}
	       			//deleteSyncStore(myscope,myscope.getView().getStore(),rows );
	       			var conn = new Ext.data.Connection();
				   	conn.request({
				   				scope:myscope, 
									method:'POST',
									defaultHeaders:{'_csrf_header':hv,"_csrf":vt },
									params:{idregistro: rows[0].get("idregistro"), "_csrf":vt},
								url: './rotular_etiquetas/carteraremdes/delete' ,
								success: function(response, opts) {
									myscope.reloadInfo();
								},
								failure: function(response, opts) {
					       			if (response.responseText!=undefined){
					       				var obj = Ext.decode(response.responseText);
					       				if (obj.message!=undefined){
					       					mensajeAlert(obj.message);
						       			}
						       		}
				       			
								}
				   		});  
	       			
	       			
	       		}
	       	 },myscope);
		 
	}, 
	importar:function(){
		
		var gridImportarRotualcion = Ext.create('MyDesktop.grid.GridImportarDirecciones',{
    		height   : 190 //frame:true, border:false,title:'Servicios',
		}); 
		
		var datos_import_window = new Ext.Window({
			width    : 1300,
			height   : 555,
			title	: 'Importar datos para Direcciones',
			closable:true,
			layout:'fit',
			resizable:false,
			modal:true,
			items: [
			        gridImportarRotualcion 
			],
			headerPosition: 'right'
		}); 
		
		datos_import_window.show();
		
	},
	loadInfo:function(){
		this.getView().getStore().load();
	
	},
	reloadInfo:function(){
		this.getView().getStore().reload();
	
	},
	getRowsSelected:function(){
		return this.getView().getSelectionModel().getSelection();
	},

	setScopeWin:function(win){
		this.mainwindow=win;
	},
	commitInfo:function(){
		this.getView().getStore().save( );
		this.getView().getStore().commitChanges();
	
	}
	
});

