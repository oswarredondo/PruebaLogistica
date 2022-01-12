/*!
 * Admninistracion de movimientos de caja
 */

Ext.define('MyDesktop.ViewFacturaResumen', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'factura-resumen-win',

    init : function(){
        this.launcher = {
            text: 'Resumen Facturas',
            iconCls:'catalogos_blue'
        }
    },
	grid_operacion:undefined,
	myScope:undefined,
	
	createWindow : function(){
	
		var my_scope = this;
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope= this;
		
		//Indica el tipo de facturacion a TODO
		my_scope.tipofacturacion='1';
		var grid_facturas = new MyDesktop.grid.GridFacturaResumen({
			title:'Cortes Facturas Realizados'
		}); 
		
		var grid_clientes = new MyDesktop.grid.GridClientes({
			//title:'Cortes Facturas Realizados'
			layout: 'fit',
			display_portipo:true
			
		}); 
		
		var combo_tipos_estatus= Ext.create('Ext.form.ComboBox', {
			fieldLabel: '',
			width: 150,
			disabled: false,
			editable:false,
			id:'tipobusquedaestatus'+this.id,
			store: Ext.create('MyDesktop.store.StoreTiposBusquedaFacturaEstatus',{}),
			queryMode: 'local',
			emptyText: 'Seleccione orden',
			displayField: 'descripcion',
			valueField: 'idtipo'
		});
		combo_tipos_estatus.setValue("1");
		
		if(!win){
				/*win = desktop.createWindow({
				
                id: this.id,
                title:'Resumen Facturas',
                iconCls: 'catalogos_blue',
                //animCollapse:false,
                border:false,
                constrainHeader:false,
                closable: true,
                closeAction: 'hide',
                width: 920,
                minWidth: 1000,
                height: 600,
				layout: 'fit',
				
				items:[
					this.grid_operacion
				]
				
            });*/
			win = desktop.createWindow({
			 title: 'Cortes de Facturación por Cliente',
             header: {
                 titlePosition: 2,
                 titleAlign: 'center'
             },
             closable: true,
             closeAction: 'hide',
             width: 780,
             minWidth: 950,
         	maximized :true,
             height: 500,
            // tools: [{type: 'pin'}],
             layout: {
                 type: 'border',
                 padding: 5
             },
             items: [{
                 region: 'west',
                 title: 'Clientes',
                 width: 380,
                 split: true,
                 collapsible: true,
                 floatable: false,
             	layout: 'fit',
                 items:[grid_clientes],
	               dockedItems:[
	                            { 
									xtype: 'toolbar',
									dock: 'top',
									items:[
									       		{
											        xtype: 'radiogroup',
											        fieldLabel: 'Facturacion por',
											        // Arrange radio buttons into two columns, distributed vertically
											        columns: 3,
											        vertical: true,
											        id:'id_rb-tipofacturacion'+my_scope.id,
											        items: [
											            { boxLabel: 'CONTRATO', name: 'rb', inputValue: '1' , checked: true,   width: 130},
											            { boxLabel: 'CONSUMO', name: 'rb', inputValue: '2',  width: 110}
											            
											        ],
											        listeners: {
								                        change : function(obj, newValue, oldValue, eOpts){ 
								                        	var value=  Ext.getCmp('id_rb-tipofacturacion'+my_scope.id).items.get(0).getGroupValue()
								                        	my_scope.tipofacturacion=value;
								                        	grid_clientes.getConsultaClientesFacturacion(my_scope.tipofacturacion);
								                        	
								                         }
								                       }
											    }
									     ]
	                            },
	     	              		{ 
	     	              			xtype: 'toolbar',
	     	              			dock: 'bottom',
	     	              			items: [
	     	              			    {xtype: 'label', text:'Fecha:'	},
	     	              			    { xtype:'datefield',id:'idfechamarcado'+my_scope.id,maxLength:30,allowBlank:false,width:110},
	     	              			    combo_tipos_estatus,
	     	              			    {  tooltip:'Marca los documentos del cliente seleccionado ',
	      	      			            	scope: my_scope, iconCls:'signature_blue',
	      	      			            	disabled:checkEnable('btn.facturar.marcar.registros'),
	      	      			            	handler:function(){
	      	      			            		this.marcaregistroscorte(grid_clientes, 
	      	      			            			grid_facturas);
	      	      			            	
      	      			            		}
  	      			            		}	      	      			            
	     	              			  /*,
									    {text:'Buscar Ctes',iconCls:'buscar_blue', 
							            	handler:function(){
							            		grid_clientes.getConsultaClientesFacturacion(my_scope.tipofacturacion);
							            	},scope:this  }*/
	      	      			          
	     	              			]
	     	              		}
	     	             ]
             }, {
                 region: 'center',
                 xtype: 'tabpanel',
                 items: [grid_facturas]
             }]
         });
        }
		
		
		
        return win;
    },
    
    marcaregistroscorte:function(grid_clientes,grid_facturas){
		var my_scope = this;
		var cliente = grid_clientes.getRowSelected(); //Ext.getCmp('clientemarcado'+my_scope.id).getValue();
		if (cliente==undefined){
			mensajeAlert("Indique el numero de cliente a marcar.");
    		return;
		}
		if (!isValidValueCampoRaw('idfechamarcado'+my_scope.id, 'Indique la fecha corte')){
			return;
		}
		
		var tipobusquedaestatus = Ext.getCmp("tipobusquedaestatus"+my_scope.id).getValue();
		var textTipobusquedaestatus = Ext.getCmp("tipobusquedaestatus"+my_scope.id).getRawValue();
		
		Ext.MessageBox.confirm(titulo_confirmar, "¿Desea generar el siguientes corte?" +
				"<br/>Cliente: " + cliente.get('numCliente') +
				"<br/>Fecha corte: " + Ext.getCmp('idfechamarcado'+my_scope.id).getRawValue()  + 
				"<br/>Tipo guía: " + textTipobusquedaestatus + "<br/>", function(id, text){
	       		if ((id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){ 
	       			var ventana = creaVentanaEspera ();
	       			var conn = new Ext.data.Connection();
	       			Ext.override(Ext.data.Connection, { timeout: 999999 });
	       			 //Obtiene los datos de fecha inicial y final
	       			 conn.request({
	       					url:'./facturaresumen/marcarcorte',
	       					method:'POST',
	       					method:'POST',
	       					defaultHeaders:{'_csrf_header':hv,"_csrf":vt },
	       					params:{
	       							idformapago:my_scope.tipofacturacion,
	       							"_csrf":vt,
	       							idformapagofactura:my_scope.tipofacturacion,
	       							cliente:cliente.get('numCliente'),
	       							dia: Ext.getCmp('idfechamarcado'+my_scope.id).getRawValue(),
	       							estatus: tipobusquedaestatus
	       						},
	       					//form:'forma_resumen',
	       					success:function (response, opts){
	       						ventana.close();
	       							var obj = Ext.decode(response.responseText);
	       							
	       							if (response.failure!=undefined){
	       								mensajeAlert(response.failure);
	       							}else{
	       								grid_facturas.reloadInfo();
	       								//Muestra la pantalla de los adicionales especiales
	       								//grid_facturas.adicionalEspecial(response.idcontrol);
	       							}
	       							

	       						},
	       					failure:function (response, opts){
	       						ventana.close();
	       						var obj = Ext.decode(response.responseText);
	       						mensajeAlert("Error ",response.message);
	       					}
	       						
	       				});
	       		}
       	},this); 
	},
});
