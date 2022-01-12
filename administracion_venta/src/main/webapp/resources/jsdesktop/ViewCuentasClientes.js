/*!
 * Ext JS Library 4.0
 * Copyright(c) 2006-2011 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 */

Ext.define('MyDesktop.ViewCuentasClientes', {
    extend: 'Ext.ux.desktop.Module',
    requires: [
        'Ext.tab.Panel'
    ],
    id:'cuentas-cliente-win',
    init : function(){
        this.launcher = {
            text: 'Clientes',
            iconCls:'manager'
        }
    },
    grid_cuentas_cliente:undefined,
	myScope:undefined,
	organizacioncombo:undefined,
	entidadcombo:undefined,
	grid_perfiles:undefined,
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope=this;
		this.combo_tipos_busqueda= Ext.create('Ext.form.ComboBox', {
					fieldLabel: '',
					disabled: false,
					editable:false,
					forceSelection:true,
					store: Ext.create('MyDesktop.store.StoreTiposBusquedaCuentasClientes',{}) ,
					queryMode: 'local',
					emptyText: 'Seleccione Tipo',
					displayField: 'descripcion',
					valueField: 'idtipo'
		});
		
		var storeorganizacion = Ext.create('MyDesktop.store.StoreOrganizacion',{});
		var storeentidad = Ext.create('MyDesktop.store.StoreEntidad',{}); 
	
		this.entidadcombo = Ext.create('Ext.form.field.ComboBox', {
		 	store: storeentidad,
		 	labelWidth: 50,
		 	fieldLabel: 'Entidad',
			allowBlank:false,
			width: 200,
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
				width: 335,
				labelWidth: 85,
				fieldLabel: 'Organizacion',
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
					}
				}

		},this); 

		this.grid_cuentas_cliente= new MyDesktop.view.GridCuentasClientes({id:'id_cuentas_cliente_admin', 
			identidad:this.identidad, idorganizacion:this.idorganizcion});
		
        if(!win){
        	
        	  win = desktop.createWindow({
        		id: this.id,
                title:'Cuentas Clientes',
                iconCls: 'manager',
                closable: true,
                closeAction: 'hide',
                width: 1200,
                height:500,
                border:true,
                defaults: {
                    labelWidth: 100
                },
                minWidth: 600,
				maximizable:true,
                layout: {
                    type: 'fit',
                    padding: 5
                },
                bbar:[
  				    { iconCls: 'usuarios_blue',itemId: 'usauriosopcion',text: 'Usuarios',disabled: false,handler: this.showDetailsUsuarios, scope:this.myScope },
                    {xtype: 'tbfill'},
                  	{ text: 'Agregar',iconCls: 'agregar',handler:this.agregar, scope:this.myScope },
						{ text: 'Modificar',iconCls: 'editar',handler:this.modificar,scope:this.myScope },
						{xtype:'tbseparator'},
						{ text: 'Desactivar',iconCls: 'borrar',handler:this.desactivar,scope:this.myScope },
						{ text: 'Activar',iconCls: 'activo',handler:this.activar,scope:this.myScope },
						{xtype:'tbseparator'},
						{xtype: 'label', text:'Manejo por:'	},
						{ text: 'Folios',handler:this.manejofolio,scope:this.myScope },
						{ text: 'Convenio',handler:this.manejoconvenio,scope:this.myScope },
						{xtype:'tbseparator'},
						{ text: 'Adm Folios',handler:this.adminfolios,scope:this.myScope },
                      ],
                tbar:[
              		this.entidadcombo,
            		this.organizacioncombo,
            		{xtype:'tbseparator'},
  					{xtype: 'label', text:'Buscar por:'	},
  					this.combo_tipos_busqueda,
  					{xtype: 'label', text:'Patron:'	},
  					{xtype: 'myUpperCaseTextField', id:'idpatronCliente', allowBlank: false},
  					{ iconCls: 'buscar_blue',handler:this.buscar, scope:this},
  				],
  				items:[this.grid_cuentas_cliente]
            });
        }
		
        // update panel body on selection change
        this.grid_cuentas_cliente.getSelectionModel().on('selectionchange', function(sm, selectedRecord) {
        
        },this);
        
        this.grid_cuentas_cliente.buscar(-1,'',-1,-1);
        
        return win;
    },
	reload:function(){
		var row = this.grid_clientes.getRowSelected();
		if (row!=undefined){
		}
	},
	buscar:function(){
		if ((this.entidadcombo.getValue()=='') || 
			(this.organizacioncombo.getValue()=='')){
			alertMsg('Verifique','Seleccione entidad y organizacion.');
			return;
		}
		//Busca los clientes de acuerdo al patrion seleccionado
		var tipobusqueda = (this.combo_tipos_busqueda.getValue()!=undefined &&
		Ext.util.Format.trim(this.combo_tipos_busqueda.getValue()) !='')?Ext.util.Format.trim(this.combo_tipos_busqueda.getValue()):'';
		
		var patronbusqueda = Ext.util.Format.trim(Ext.getCmp('idpatronCliente').getValue());
		if (tipobusqueda==''){
			tipobusqueda='00';
		}
		if (tipobusqueda!='00'){
			if (patronbusqueda==''){
				alertMsg('Verifique','Indique coincidencia a buscar.');
				return;
			}
		}
		//Limpia los grids e inicia la busqueda
		this.grid_cuentas_cliente.buscar(tipobusqueda,patronbusqueda,
				this.entidadcombo.getValue(),this.organizacioncombo.getValue());

	},
	//desactivar:function(){
	//	this.grid_clientes.desactivar(this);
	//},

	//activar:function(){
	//	this.grid_clientes.activar(this);
	//},
	 
	agregar:function(){
		
		if ((this.entidadcombo.getValue()=='') || 
				(this.organizacioncombo.getValue()=='') || 
				(this.entidadcombo.getValue()==null) || 
				(this.organizacioncombo.getValue()==null)){
				alertMsg('Verifique','Seleccione entidad y organizacion.');
				return;
			}
		this.grid_cuentas_cliente.agregar(this.entidadcombo.getValue(),this.organizacioncombo.getValue());

	},
	modificar:function(){

		if ((this.entidadcombo.getValue()=='') || 
				(this.organizacioncombo.getValue()=='') || 
				(this.entidadcombo.getValue()==null) || 
				(this.organizacioncombo.getValue()==null)){
				alertMsg('Verifique','Seleccione entidad y organizacion.');
				return;
			}
		this.grid_cuentas_cliente.modificar(this.entidadcombo.getValue(),this.organizacioncombo.getValue());
	},
	showDetailsUsuarios:function(){
		var rows =  this.grid_cuentas_cliente.getSelectionModel().getSelection();
		
		if(rows.length <=0){
     		Ext.Msg.alert('Verificar',"Debe de Seleccionar solo un registro para modificar");
     		return;
     	}
		if(rows.length >1){
     		Ext.Msg.alert('Verificar',"Seleccione solamente un registro a modificar");
     		return;
     	}
		
		if(rows[0].get('estatus') =='false'){
     		Ext.Msg.alert('Verificar',"Registro esta dado de baja, no puede ser modificado")
     		return;
     	}

		//Crea una forma de clientes para agregar los datos
		var gridoperacion_usuario =new MyDesktop.view.GridUsuarios(
				{
					id:this.id+'usuarios_grid',
					identidad:this.entidadcombo.getValue(),
					idorganizacion:this.organizacioncombo.getValue(),
					numcliente:rows[0].get('numCliente')
				});

		gridoperacion_usuario.reload(this.entidadcombo.getValue(),
				this.organizacioncombo.getValue(),rows[0].get('numCliente'));

		Ext.create('widget.window', {
			id:'utils-win-agregar-cliente',
			title: "Usuarios",
			width: 1200,
			height: 400,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: gridoperacion_usuario
			
		}).show();
	},
	showDetails:function(){
		var rows =  this.grid_cuentas_cliente.getSelectionModel().getSelection();
		
		if(rows.length <=0){
     		Ext.Msg.alert('Verificar',"Debe de Seleccionar solo un registro para modificar");
     		return;
     	}
		if(rows.length >1){
     		Ext.Msg.alert('Verificar',"Seleccione solamente un registro a modificar");
     		return;
     	}
		
		if(rows[0].get('estatus') =='false'){
     		Ext.Msg.alert('Verificar',"Registro esta dado de baja, no puede ser modificado")
     		return;
     	}
		
		this.grid_cuentas_cliente.showDetails();
	},
	
	activar:function(){
		
		this.activarFunction(this,
				this.grid_cuentas_cliente.getView().getSelectionModel().getSelection(),
				'Desea activar los registros seleccionados?','A');
			
	},
	desactivar:function(scopeview){
		this.activarFunction(this,
				this.grid_cuentas_cliente.getView().getSelectionModel().getSelection(),
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
	       				
	       				registros = registros+  rows[i].get('identificador')+ "|";
	       			}
	       			var conn = new Ext.data.Connection();
	       			conn.request({
	       				url: '../catalogo/cuentasclientes/cambiarestatus' ,
	       				params:{ids:registros, estatus:estatus},
	       				success: function(response, opts) {
	       					var obj = Ext.decode(response.responseText);
	       					if (obj.success==false){
	       						Ext.MessageBox.alert('Confirmaci�n',obj.message);
	       					}else{
	       						myscope.buscar();
	       					}
	       				},
	       					
	       				failure: function(response, opts) {
	       					Ext.Msg.alert('Error',response.responseText);

	       				}
	       			});
	       		}
	       	 },myscope);
		
		
	},
	manejofolio:function(){
		this.tipomanejo(this,
				this.grid_cuentas_cliente.getView().getSelectionModel().getSelection(),
					'Desea cambiar al tipo de manejo por FOLIOS?',0);

	},
	manejoconvenio:function(){
		this.tipomanejo(this,
				this.grid_cuentas_cliente.getView().getSelectionModel().getSelection(),
					'Desea cambiar al tipo de manejo por CONVENIO?',1);
		
		

	},
	tipomanejo:function(myscope,rows, mensaje, tipo){

     	if(rows.length <=0){
     		 Ext.MessageBox.alert('Verificar',"Seleccione el registro que desea modificar");
     		return;
     	}
    	if(rows.length >1){
    		 Ext.MessageBox.alert('Verificar',"Seleccione solamente un registro.");
    		return;
    	}
    	
		if(rows[0].get('estatus') =='false'){
     		Ext.Msg.alert('Verificar',"Registro esta dado de baja, no puede ser modificado")
     		return;
     	}
		 Ext.MessageBox.confirm('Confirmar',mensaje, function(id, text){
	       		if ( (id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){ 
	       			var conn = new Ext.data.Connection();
	       			conn.request({
	       				url: '../catalogo/cuentasclientes/cambiartipomanejo',
	       				params:{id:rows[0].get('identificador'), tipomanejo:tipo},
	       				success: function(response, opts) {
	       					var obj = Ext.decode(response.responseText);
	       					if (obj.success==false){
	       						Ext.MessageBox.alert('Confirmaci�n',obj.message);
	       					}else{
	       						myscope.buscar();
	       					}
	       				},
	       					
	       				failure: function(response, opts) {
	       					Ext.Msg.alert('Error',response.responseText);

	       				}
	       			});
	       		}
	       	 },myscope);
		
		
	},
	adminfolios:function(){
		var rows = this.grid_cuentas_cliente.getView().getSelectionModel().getSelection();
		if(rows.length <=0){
    		 Ext.MessageBox.alert('Verificar',"Seleccione el registro que desea modificar");
    		return;
    	}
		if(rows.length >1){
   		 Ext.MessageBox.alert('Verificar',"Seleccione solamente un registro.");
   		 return;
		}
		
		
		if(rows[0].get('estatus') =='false'){
     		Ext.Msg.alert('Verificar',"Registro esta dado de baja, no puede ser modificado")
     		return;
     	}
		
		if(rows[0].get('tipofolio')==1){
	   		 Ext.MessageBox.alert('Verificar',"El cliente seleccionado " +
	   		 		"tiene tipo de manejo por CONVENIO.");
	   		 return;
			}
		
		//muestra la pantalla de folios
		var grip_admfolios =new MyDesktop.view.GridManejoFolios(
				{
					id:this.id+'admfolios_grid',
					idcliente:rows[0].get('identificador'),
					numcliente:rows[0].get('numCliente'),
					identidad: rows[0].get('identidad'),
					idorganizacion: rows[0].get('idorganizacion')
				});
		
		grip_admfolios.buscar();
		
		Ext.create('widget.window', {
			id:'utils-win-admfolios-cliente',
			title: "Folios cliente " + rows[0].get('numcliente'),
			width: 900,
			height: 400,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: grip_admfolios
			
		}).show();
   		
	}
});
