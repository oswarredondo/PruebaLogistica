/*!
 * Ext JS Library 4.0
 * Copyright(c) 2006-2011 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 */

Ext.define('MyDesktop.ViewClientes', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'clientes-win',

    init : function(){
        this.launcher = {
            text: 'Administracion de Clientes',
            iconCls:'manager'
        }
    },
	grid_clientes:undefined,
	grid_contactos:undefined,
    grid_convenios:undefined,
	grid_localizacion:undefined,
	//grid_usuarios:undefined,
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope=this;
		this.grid_contactos= new MyDesktop.view.GridContactos({
			isConsulta:false,
	        border:false,
	        frame:false, 
	        title: 'Contactos',
	        iconCls:'contactos_blue',
	        isAutoLoad:true
		});
		this.grid_direcciones= new MyDesktop.view.GridDirecciones({
			title: 'Direcciones',iconCls:'map_blue',
	        border:false,
	        frame:false});
		
	
		this.grid_clientes = new MyDesktop.view.GridClientes({  split: true,
		        region: 'north', height: 350,
		        border:false,
		        frame:false,
		    	grid_direcciones:this.grid_direcciones,
		    	grid_contactos:this.grid_contactos,
		        });
	
        var bookTplMarkup = [
		                       '<table>',
		                     
		                       
		                       '<tr>',
		                       '<td><th align="left">Grupo</th></td>',
		                       '<td align="left">({clavegrupo}) {descripcionGrupoCliente}</td></tr>',
		                       
		                       '<tr>',
		                       '<td><th align="left">Nombre</th></td>',
		                       '<td align="left">{descripcion}</td></tr>',
		                       
		                       '<tr>',
		                       '<td><th align="left">Referencia</th></td>',
		                       '<td align="left">{referencia}</td></tr>',
		                       
		                       '<tr><td><th align="left">Tipo</th></td>',
		                       '<td align="left"> {tipopersona}</td></tr>',
		                       
		                       '<tr><td><th align="left">R.F.C</th></td>',
		                       '<td align="left">{rfc}</td></tr>',
		                       '<tr><td><th align="left">Observacion</th></td>',
		                       '<td align="left">{observacion}</td></tr>',
		                       '<tr><td><th align="left">Creado por:</th></td>',
		                       '<td align="left">{logincreador}</td></tr>',
		                       '</table>',
		                       

		                   ];
		 var bookTpl = Ext.create('Ext.Template', bookTplMarkup);
		                   
		
        if(!win){
        	
        	  win = desktop.createWindow({
        		id: this.id,
                title:'Administración de Clientes',
                header: {
                   // titlePosition: 2,
                   // titleAlign: 'center'
                },
              
                iconCls: 'cuentas_cliente_blue',
                closable: true,
                closeAction: 'hide',
                width: 600,
                border:true,
                minWidth: 600,
            	maximized :true,
				maximizable:false,
                layout: {
                    type: 'border',
                    padding: 5
                },
                items: [{
                    region: 'west',
                    border:true,
                    width: 600,
                    floatable: false,
                    layout: 'fit',
                   
                    items: [
                            
                            Ext.create('Ext.Panel', {
                 		       
                            	  border:false,
                  		        frame:false,
                		        width: 650,
                		        height: 400,
                		        layout: 'fit',
                		        
                		        tbar:[
                	  						{ text: 'Agregar',iconCls: 'agregar',handler:this.agregar, scope:this.myScope },
                	  						{ text: 'Modificar',iconCls: 'editar',handler:this.modificar,scope:this.myScope },
                	  						{xtype:'tbseparator'},
                	  						{ text: 'Desactivar',iconCls: 'desactivado',handler:this.desactivar,scope:this.myScope },
                	  						{ text: 'Activar',iconCls: 'activo',handler:this.activar,scope:this.myScope }
                	  						
                	  				],
                	  			bbar:[
                	  			      
                	  			    { text: 'Bloquear',disabled:checkEnable('sistema.btn.bloquear.cliente'),
	  					  			    	 iconCls: 'password_blue',handler:this.bloquear,scope:this.myScope },
                	  			    {xtype:'tbseparator'},
                	  			  { text: 'Desbloquear',disabled:checkEnable('sistema.btn.bloquear.cliente'),
 					  			    	 iconCls: 'unlock_blue',handler:this.desbloquear,scope:this.myScope },
 					  			  {xtype:'tbseparator'},
 					  			  { text: 'Reasignar',disabled:checkEnable('sistema.btn.reasignar.cliente'),
					  			    	 iconCls: 'man_blue',handler:this.reasignar,scope:this.myScope }
                	  			],
                		        items: [
                		            this.grid_clientes/*, 
                		            {
									    id: 'detailPanelCliente',
									    title: 'Detalle',
									    region: 'center',
									    bodyPadding: 7,
									    layout: 'fit',
									    bodyStyle: "background: #ffffff;",
									    html: 'Seleccione registro de cliente para mostrar detalle'
									}*/
                		          ]
                		    })
                            ]
                }, {
                    region: 'center',
                    xtype: 'tabpanel',
                    border:false,
                    layout: 'fit',
                    border:false,
    		        frame:false,
                    items: [
                        this.grid_direcciones,
						this.grid_contactos
					]
                }]
            });
        }
		
        // update panel body on selection change
        this.grid_clientes.getSelectionModel().on('selectionchange', function(sm, selectedRecord) {
            if (selectedRecord.length) {
                //var detailPanel = Ext.getCmp('detailPanelCliente');
                //detailPanel.update(bookTpl.apply(selectedRecord[0].data));
                
                //Actualiza los registos de direcciones
                this.reloadDirecciones(selectedRecord[0].data.idcliente);
               
                //Actualiza los contactos
                this.reloadContactos(selectedRecord[0].data.idcliente);
                
               
               
            }
        },this);
        
        this.grid_clientes.buscar(-1,'');
        
        return win;
    },
    
    bloquear:function(){
    	this.grid_clientes.bloquear(3);
    },
    desbloquear:function(){
    	this.grid_clientes.bloquear(1);
    },
	reload:function(){
		var row = this.grid_clientes.getRowSelected();
		if (row!=undefined){
			this.grid_contactos.reload(row.get('idcliente'));
			this.grid_convenios.reload(row.get('idcliente'));
			this.grid_direcciones.reload(row.get('idcliente'));
		}
	},
	reloadDirecciones:function(idcliente){
		this.grid_direcciones.setIdCliente(idcliente);
		this.grid_direcciones.reload(idcliente);
	},
	reloadContactos:function(idcliente){
		this.grid_contactos.setIdCliente(idcliente);
		this.grid_contactos.reload(idcliente);
	},
	
	reloadUsuarios:function(idcliente){
		this.grid_usuarios.reloadClient(idcliente);
	},
	 //Carga los usuarios
    
	
	desactivar:function(){
		this.grid_clientes.desactivar();

	},
	activar:function(){
		this.grid_clientes.activar();

	},

	agregar:function(){
		this.grid_clientes.agregar();

	},
	modificar:function(){
		this.grid_clientes.modificar();
	},
	eliminar:function(){
		this.grid_clientes.eliminar();
	},
	showDetails:function(){
		this.grid_clientes.showDetails();
	},
	showDetailsDirecciones:function(){
		this.grid_clientes.showDetailsDirecciones();
	},
	
	reasignar:function(){
		this.grid_clientes.reasignar();
	}
});
