/*!
 *Contiene el funcionamiento para la administracion de los descuentos
 */

Ext.define('MyDesktop.ViewCotizacionesPreConvenio', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'cotizacion-pre-win',

    init : function(){
        this.launcher = {
            text: 'Cotizaciones',
            iconCls:'descuentos_blue'
        }
    },
	
	grid_descuentos:undefined,
	grid_contactos:undefined,
    grid_convenios:undefined,
	myScope:undefined,
	combo_tipos_busqueda:undefined,
	meses:undefined,
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope=this;
		
		this.meses= Ext.create('Ext.form.ComboBox', {
			fieldLabel: '',
			 width: 150,
			disabled: false,
			editable:false,
			//forceSelection:true,
			store: Ext.create('MyDesktop.store.StoreMeses',{}) ,
			queryMode: 'local',
			emptyText: '',
			displayField: 'descripcion',
			valueField: 'idtipo'
		});
		
		
        if(!win){
        	//Define las busquedas para los descuentos
			this.combo_tipos_busqueda= Ext.create('Ext.form.ComboBox', {
				fieldLabel: '',
				 width: 150,
				disabled: false,
				editable:false,
				//forceSelection:true,
				store: Ext.create('MyDesktop.store.StoreTiposBusquedaCotizacion',{}) ,
				queryMode: 'local',
				emptyText: 'Seleccione orden',
				displayField: 'descripcion',
				valueField: 'idtipo'
			});
			this.combo_tipos_busqueda.setValue("05");
			//this.combo_tipos_busqueda.setRawValue("Ref.B�squeda");
	
			this.grid_cotizaciones = new MyDesktop.view.GridCotizacionesPreConvenios({
					autoScroll: true,
					forceFit    : true,
					scrollOffset: 0,
					getTotalWidth: function() {
						return "auto";
					}
	  
			});
		
		    win = desktop.createWindow({
				
                id: this.id,
                title:'Cotizaciones',
                iconCls: 'cotizacion_blue',
                //animCollapse:false,
                border:false,
                constrainHeader:false,
                closable: true,
                closeAction: 'hide',
				width: 1300,
                minWidth: 350,
            	maximized :true,
				maximizable:false,
                height: 500,
				layout: 'fit',
				tbar:[
	  					{xtype: 'label', text:'Buscar por:'	},
	  					this.combo_tipos_busqueda,
	  					{xtype: 'label', text:'Patr�n:'	},
	  					{xtype: 'myUpperCaseTextField' , id:'idpatronbusquedacotizacion', allowBlank: false, width: 100},
	  					{xtype: 'label', text:'Mes:'	},
	  					this.meses,
	  					{
				            xtype: 'datefield',
				            id:'idfechadocumentocotizacion',
				            fieldLabel: 'Fecha',
				            name:'fechainicialcotizacion',
				            format: 'd-m-Y',
				            labelWidth: 80,
				            width: 190
	  					}, 
	  					
	  					{ iconCls: 'buscar_blue',handler:this.filtrar, scope:this.myScope},
	  					{xtype: 'tbfill'},
	  					{
	  						xtype: 'buttongroup', // <--- grouping the buttons
	  						items:[
									{ text:'Cerrar cotización', tooltip: 'Cierra una cotización que no pudo ser completada',iconCls: 'garbage_red',
											handler:this.cerrar, scope:this.myScope,disabled:checkEnable("sistema.btn.a.cerrar.cotizacion") },
	  						       	{xtype:'tbseparator'},
	  			  					{ tooltip: 'Muestra historial de solicitudes de descuento',iconCls: 'registros_blue',
	  			  						handler:this.showSolicitudesDescuento, scope:this.myScope },
	  			  				    {xtype:'tbseparator'},
	  			  					{ tooltip: 'Mostrar PDF',iconCls: 'pdf_blue',handler:this.showPDFDetails, scope:this.myScope },
	  			  					{ tooltip: 'Atar Archivo',iconCls: 'attach_blue',handler:this.showAttachment, scope:this.myScope },
	  			  					{ tooltip: 'Enviar Email',iconCls: 'user_email_blue',handler:this.sendMail, scope:this.myScope },
	  			  					{ tooltip: 'Historia/Movimientos',iconCls: 'history_blue',handler:this.showHistory, scope:this.myScope }

	  						       ]
	  					},

	  				],
	  			bbar:[
	  			    { text: 'Detalles Precios',iconCls: 'detalles',handler:this.showDetails, scope:this.myScope },		
					{xtype:'tbseparator'},
	  			    { text: 'Detalles Descuento X Fact.',iconCls: 'detalles',handler:this.showDetalleDescuentoXFactura, scope:this.myScope },		
					{xtype:'tbseparator'},
					{ text: 'Adicionales',iconCls: 'appointment_blue',handler:this.showDetailsAdicionales, scope:this.myScope },
					{xtype:'tbseparator'},
					{ text: 'Material Empaque',iconCls: 'catalogos_blue',handler:this.showDetailsMaterialEmpaque, scope:this.myScope },
					{xtype:'tbseparator'},
					{ text: 'Transf. a Convenio',iconCls: 'convenio_blue',handler:this.transformar,
						scope:this.myScope,disabled:checkEnable("sistema.btn.transformar.a.cotizacion") },
					{xtype:'tbfill'},
					{ text: 'Agregar',iconCls: 'agregar',handler:this.agregar, scope:this.myScope },
					{ text: 'Modificar',iconCls: 'editar',handler:this.modificar,scope:this.myScope,
						disabled:checkEnable("sistema.btn.modificar.cotizacion")},
					{xtype:'tbseparator'},
					{ text: 'Desactivar',iconCls: 'borrar',handler:this.desactivar,
						scope:this.myScope,disabled:checkEnable("sistema.btn.desactivar.cotizacion"), },
					{xtype:'tbseparator'},
					{ text: 'Activar',iconCls: 'activo',handler:this.activar,
						scope:this.myScope,disabled:checkEnable("sistema.btn.activar.cotizacion") },
					{xtype:'tbseparator'},
					{ text: 'Sol.Descuento',iconCls: 'manwork_blue',handler:this.solicitudTareaDescuento,scope:this.myScope },
					{xtype:'tbseparator'},
					{ text: 'Reasignar',disabled:checkEnable("sistema.btn.reasignar.cotizacion"),
		  			    	 iconCls: 'man_blue',handler:this.reasignar,scope:this.myScope }
					

  				],	
                items: [this.grid_cotizaciones]
            });
			
			
        }
        return win;
    },
    solicitudTareaDescuento:function(){
    	var rows =  this.grid_cotizaciones.getSelectionModel().getSelection();
     	if(rows.length <=0){
     		mensajeAlert("Debe de Seleccionar un registro existente. ");
     		return;
     	}
		if(rows.length >1){
     		mensajeAlert("Seleccione solamente un registro. ");
     		return;
     	}
		
		if (rows[0].get('estatus')==ESTATUS_INACTIVA){
			mensajeAlert("Registro esta dado de baja operaci�n inválida.");
     		return;
		}
		if(rows[0].get('estatus') ==ESTATUS_CERRADO){
     		mensajeAlert("Registro " + rows[0].get('nombre') + " fue cerrado o " +
     				"dada de baja  previamente, operación inválida");
     		return;
     	}
		
    	var contenido= 'Se solicita se autorice el descuento para la siguiente cotizaci�n:<br>'+
    	"Cliente:" +  rows[0].get('razonsocial_cte')+ '<br>'+
    	"Referencia:" +rows[0].get('nombre')+ '<br>'+
    	"#Cotizacion:" + rows[0].get('idconvenio')+ '<br>'+
    	"%Descuento solicitado: <b>INDIQUE PORCENTAJE</b>  %" ;
		var forma_solicitud_descuento = Ext.create('MyDesktop.view.FormSolicitarDescuentoTarea',
				{
					tituloTarea:'SOLICITUD DE DESCUENTIO PARA COTIZACION ' +rows[0].get('idconvenio'),
					contenido:contenido,
					operacion:'insert',
					idconvenio:rows[0].get('idconvenio'),
					//Solo los usuarios que tengan un nivel inmediato superior al del usuario de Sesión
					mostrarSoloUsuarioConNivelSuperior:true 
		}); 
		forma_solicitud_descuento.updateFieldCte('ABIERTA','estatus');
		forma_solicitud_descuento.updateFieldCte('URGENTE','importancia');
		forma_solicitud_descuento.updateFieldCte('SOLICITUD','tipo');
		
		var win_archivos_adjuntos = Ext.create('widget.window', {
			title: "Solicitud Descuento",
			width: 750,
			height: 610,
			iconCls:'agregar',
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: forma_solicitud_descuento
			
		});
		forma_solicitud_descuento.setMainWindows(win_archivos_adjuntos);
		win_archivos_adjuntos.show();
    	
    },
    showSolicitudesDescuento:function(){
    	
    	var store_cofigurado = Ext.create('MyDesktop.store.StoreTareas',{
			proxy: {
		        type: 'ajax',
		        api: {
		        	 read: '../tareas/getCreadasPorElUsuarioDeUnTipo'
		        },
		        reader: {
		                 type: 'json',
		                 successProperty: 'success',
		                 root : 'proxiArray',
		                 messageProperty: 'message',
		                 totalProperty : 'totalCount',
		        }
		      },
		      sorters: [{
		            property: 'importancia',
		            direction: 'DESC'
		        }]
			
			
		}); 
    	
    	var gridtareaspendientes_solicitudes = 
        	Ext.create('MyDesktop.view.GridTareaNotificacionAlertSolicitudsUsuario',{
        		 title: 'Tareas pendientes',store_cofigurado:store_cofigurado,showMostrarEditar:false
        });
    	
    	Ext.create('widget.window', {
			title: "Solicitudes Descuento",
			width: 850,
			height: 500,
			iconCls:'agregar',
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: gridtareaspendientes_solicitudes
			
		}).show();

    	
    },
	agregar:function(){
		this.grid_cotizaciones.agregar();
	},
	modificar:function(){
		this.grid_cotizaciones.modificar(this);
	},
	eliminar:function(){
		this.grid_cotizaciones.eliminar();
	},
	transformar:function(){
		var rows =  this.grid_cotizaciones.getSelectionModel().getSelection();
     	if(rows.length <=0){
     		mensajeAlert("Debe de Seleccionar un registro existente. ");
     		return;
     	}
		if(rows.length >1){
     		mensajeAlert("Seleccione solamente un registro. ");
     		return;
     	}
		if (rows[0].get('estatus')==ESTATUS_INACTIVA){
			mensajeAlert("Registro esta dado de baja operación inválida.");
     		return;
		}
		if(rows[0].get('estatus') ==ESTATUS_CERRADO){
     		mensajeAlert("Registro " + rows[0].get('nombre') +
     				" fue cerrado previamente, operación inválida");
     		return;
     	}
		
     	for(i=0;i<rows.length;i++){
     		if(rows[i].get('estatus') ==ESTATUS_TRANSFORMACION_CONVENIO){
     			mensajeAlert("Registro " + rows[i].get('nombre') +
     					" ya fue convertido a un convenio, operación inválida");
         		return;
         	}
    		
     	}
     	var my_scope= this;
     	
     	Ext.MessageBox.confirm('Confirmar','Desea tranformar la cotizaci�n en convenio, ya no podr� realizar ning�n cambio a la cotizaci�n seleccionada?', function(id, text){
    		if ( (id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){ 
    			var conn = new Ext.data.Connection();
    	    	var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Agregando información espere..."});
    			myMask.show();
    	   		conn.request({
    	   				scope:my_scope, 
    					url: '../cotizacionpreconvenio/transformaAConvenio' ,
    					params:{idconvenio:rows[0].get('idconvenio')},
    					success: function(response, opts) {
    						myMask.hide( );
    						myMask.disable();
    						
    						var obj = Ext.decode(response.responseText);
    						if (obj.idconvenio!=undefined){
    							alertMsg('Confirmación' , obj.message);
    						}
    						
    						my_scope.filtrar();
    					},
    					failure: function(response, opts) {
    		       			if (response.responseText!=undefined){
    		       				var obj = Ext.decode(response.responseText);
    		       				if (obj.message!=undefined){
    		       					Ext.Msg.alert('Error',obj.message);
    			       			}
    			       		}
    	       			
    					}
    	   		});  
    		}
     	},my_scope );
		
		
    
		
	},
	filtrar:function(){
	    	var fecha  = Ext.getCmp('idfechadocumentocotizacion').getRawValue();
	    	var patron  = Ext.getCmp('idpatronbusquedacotizacion').getValue();
	    	var tipo_busqueda = this.combo_tipos_busqueda.getValue();
	    	var mes = this.meses.getValue()==undefined?'':this.meses.getValue();
	    	
	    	if (tipo_busqueda == '03'){
	    		if  (fecha.trim().length<=0){ 
	    			mensajeAlert("Capture la fecha del documento.");
	    			return;	
	    		}
	    	}else if (tipo_busqueda == '05'){
    			
	    		if  (mes.trim().length<=0){ 
	    			mensajeAlert("Seleccione un mes de la lista disponible.");
	    			return;	
	    		}	
	    	}else if (tipo_busqueda == '04'){	
	    		if  (patron.trim().length<=0){ 
	    			mensajeAlert("Capture el dato que desea buscar.");
	    			return;	
	    		}
	    		if (isNaN(patron.trim())){
	    			mensajeAlert("Capture un valor v�lido de identificador.");
	    			return;	
	    		}
	    	}else{
	    		if  (patron.trim().length<=0){ 
	    			mensajeAlert("Capture el dato que desea buscar.");
	    			return;	
	    		}
	    	}
	    	this.grid_cotizaciones.buscar(tipo_busqueda,fecha,patron,mes);
	    },
    desactivar:function(){
		this.grid_cotizaciones.desactivar(this);
	},
	activar:function(){
		this.grid_cotizaciones.activar(this);
	},
	
	reasignar:function(){
		this.grid_cotizaciones.reasignar(this);
	},
	cerrar:function(){
		this.grid_cotizaciones.cerrar(this);
	},
	
	sendMail:function(){
		
		var rows =  this.grid_cotizaciones.getSelectionModel().getSelection();
     	if(rows.length <=0){
     		mensajeAlert("Debe de Seleccionar un registro existente. ");
     		return;
     	}
		if(rows.length >1){
			mensajeAlert("Seleccione solamente un registro. ");
     		return;
     	}
		if (rows[0].get('estatus')==ESTATUS_INACTIVA){
			mensajeAlert("Registro esta dado de baja operación inválida.");
     		return;
		}
		
		if(rows[0].get('estatus') ==ESTATUS_CERRADO){
     		mensajeAlert("Registro " + rows[0].get('nombre') + " fue cerrado previamente, operación inválida");
     		return;
     	}
		
		//Crea la ventana para el envio de correo
		//Crea una forma de clientes para agregar los datos
		var forma_sendmail_cotizacion = Ext.create('MyDesktop.view.FormSendMail',
				{
					url_sender:'../cotizacionpreconvenio/sendMail', 
					idconvenio:rows[0].get('idconvenio')
				}); 
		var win_archivos_adjuntos = Ext.create('widget.window', {
			title: "Envio Notificaci�n Cotización Cliente",
			width: 500,
			height: 300,
			iconCls:'user_email_blue',
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: forma_sendmail_cotizacion
			
		}).show();
		
	},
	showPDFDetails:function(){

		var rows =  this.grid_cotizaciones.getSelectionModel().getSelection();
     	if(rows.length <=0){
     		mensajeAlert("Debe de Seleccionar registro a visualizar. ");
     		return;
     	}
		if(rows.length >1){
     		mensajeAlert("Seleccione solamente un registro a visualizar. ");
     		return;
     	}
		
		visorPDF(
				'utils-win-vistaprevia-pdf_file_cotizacion'+ rows[0].get('idconvenio')+rows[0].get('fechadocumento'),
				"Visor PDF: " + rows[0].get('nombre'),
				"../cotizacionpreconvenio/viewPDFArchivo?idconvenio="+rows[0].get('idconvenio'));

		
	},
	showAttachment:function(){
		var rows =  this.grid_cotizaciones.getSelectionModel().getSelection();
     	if(rows.length <=0){
     		mensajeAlert("Debe de seleccionar un registro a visualizar. ");
     		return;
     	}
		if(rows.length >1){
     		mensajeAlert("Seleccione solamente un registro a visualizar. ");
     		return;
     	}
		

		var grid_historia_attachement = new MyDesktop.view.GridAttachment({
			autoScroll: true,
			forceFit    : true,
			isConsulta:false,
			idtipodocumento: rows[0].get('estadoactualdoc'),
			identificador:rows[0].get('idconvenio'),
			ids_str: rows[0].get('idconvenio'),
			tipos_docs_str: rows[0].get('estadoactualdoc'), 
			scrollOffset: 0,
			getTotalWidth: function() {
				return "auto";
			}
		});
		
		grid_historia_attachement.loadInfo();
		
		var win_archivos_adjuntos = Ext.create('widget.window', {
			id:'utils-win-agregar-cliente',
			title: "Archivos Adjuntos",
			width: 800,
			height: 350,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: grid_historia_attachement
			
		});
		
		win_archivos_adjuntos.show();
		
	},
	showHistory:function(){
		var rows =  this.grid_cotizaciones.getSelectionModel().getSelection();
     	if(rows.length <=0){
     		mensajeAlert("Debe de Seleccionar solo un registro a visualizar. ");
     		return;
     	}
		if(rows.length >1){
     		mensajeAlert("Seleccione solamente un registro a visualizar. ");
     		return;
     	}
		
		var columnas =  [
			{text     : 'Movimiento',width: 100,sortable : false,dataIndex: 'tipomovimiento'},
			{text     : 'Fecha',width: 100,sortable : false,dataIndex: 'fecha'},
			{text     : 'Usuario',width: 80,sortable : false,dataIndex: 'login'},
			{text     : 'Observacion',width: 120,sortable : false,dataIndex: 'observacion'}
			
			];
		grid_historia_cotizaciones = new MyDesktop.view.GridHistoria({
			autoScroll: true,
			columnas:columnas,
			forceFit    : true,
			scrollOffset: 0,
			getTotalWidth: function() {
				return "auto";
			}

		});
		grid_historia_cotizaciones.loadInfo();
		
		var win_historia = Ext.create('widget.window', {
			id:'utils-win-agregar-cliente',
			title: "Modificar Datos Cotizaci�n",
			width: 800,
			height: 350,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: grid_historia_cotizaciones
			
		});
		var parametros = {idconvenio:rows[0].get('idconvenio')};
		//Si se desea cambiar el URL que despacha la solicitud
		//grid_historia_cotizaciones.getStore.getProxy().url = '';
		grid_historia_cotizaciones.buscar(parametros);
		
		win_historia.show()
		
	},
	
	
	
	showDetalleDescuentoXFactura:function(){
		var rows =  this.grid_cotizaciones.getSelectionModel().getSelection();
     
		if (!this.valida(rows)){
			return;
		}
		
		var isconsulta = rows[0].get('estatus')==2?true:false;
		
		//Crea una forma de clientes para agregar los datos
		var grid_detalle_rango_descuentoxfactura= Ext.create('MyDesktop.grid.GridDescuentoFactura',
				{
					isConsulta:isconsulta,
					idconvenio:rows[0].get('idconvenio')
				}
		); 
		var myscope = this;
		grid_detalle_rango_descuentoxfactura.buscar();
		//forma_showdetails.updateFieldReadOnly(rows[0]);
		var win_detalle_rango_descuentoxfactura = Ext.create('widget.window', {
			title: "Detalles Rango Descuento Facturacion ",
			width: 600,
			height: 300,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: grid_detalle_rango_descuentoxfactura,
			
		});
		win_detalle_rango_descuentoxfactura.show();
		
	},
	
	showDetails:function(){
		var rows =  this.grid_cotizaciones.getSelectionModel().getSelection();
     
		if (!this.valida(rows)){
			return;
		}
		
		var isconsulta = rows[0].get('estatus')==ESTATUS_TRANSFORMACION_CONVENIO?true:false;
		
		//Crea una forma de clientes para agregar los datos
		var grid_detalle_conveio_precios= Ext.create('MyDesktop.view.GridCotizacionDetalle',
				{
					id:this.id+'grid_convenio_detalle',
					isConsulta:isconsulta,
					idconvenio:rows[0].get('idconvenio'),
					idrangoenvios:rows[0].get('idrangoenvios')
				}
		); 
		grid_detalle_conveio_precios.loadInfo();
		var myscope = this;
		//grid_rangos_tarifa_servicio_adicional.buscar();
		//forma_showdetails.updateFieldReadOnly(rows[0]);
		var win__detalle_conveio_precios = Ext.create('widget.window', {
			id:'utils-win-grid_adicionales_para_tarifa',
			title: "Detalles Lineas ",
			width: 1000,
			height: 400,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: grid_detalle_conveio_precios,
			
		});
		win__detalle_conveio_precios.show();
		
	},

	showDetailsMaterialEmpaque:function(){	
		var rows =  this.grid_cotizaciones.getSelectionModel().getSelection();
		if (! this.valida(rows)){
			return;
		}

		//verifica si la operacion solo es de consulta cuando ya se 
		//ha convertido la cotizacion a convenio
		var isconsulta = rows[0].get('estatus')==ESTATUS_TRANSFORMACION_CONVENIO?true:false;
		
		//Crea una forma de clientes para agregar los datos
		var grid_materialempaque= Ext.create('MyDesktop.grid.GridMaterialEmpaque',
				{
					idconvenio:rows[0].get('idconvenio')
				}
		); 
		
		grid_materialempaque.reload(rows[0].get('idconvenio'));
		grid_materialempaque.loadInfoWithId(rows[0].get('idconvenio'),true);
		Ext.create('widget.window', {
			title: "Materiales Empaque: "+rows[0].get('nombre'),
			width: 750,
			height: 400,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: grid_materialempaque
		}).show();
	},
	
	showDetailsAdicionales:function(){
		var rows =  this.grid_cotizaciones.getSelectionModel().getSelection();
		if (! this.valida(rows)){
			return;
		}

		//verifica si la operacion solo es de consulta cuando ya se 
		//ha convertido la cotizacion a convenio
		var isconsulta = rows[0].get('estatus')==ESTATUS_TRANSFORMACION_CONVENIO?true:false;
		
		//Crea una forma de clientes para agregar los datos
		var grid_rangos_tarifa_servicio_adicional= Ext.create('MyDesktop.view.GridTarifaAdicional',
				{
					id:'showdetails_tarifa_rango_id',
					isConsulta:isconsulta,
					idconvenio:rows[0].get('idconvenio'),
					idservicio:rows[0].get('idservicio'),
					idformapago:rows[0].get('idformapago')
				}
		); 
		
		Ext.create('widget.window', {
			id:'utils-win-agregar-tarifa-rango-serv-adicional',
			title: "Detalles Adicionales: "+rows[0].get('nombre'),
			width: 750,
			height: 400,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: grid_rangos_tarifa_servicio_adicional
		}).show();
	},
	valida:function(rows){
		if(rows.length <=0){
     		mensajeAlert("Debe de Seleccionar solo un registro que desea visualizar");
     		return false;
     	}
		if(rows.length >1){
			mensajeAlert("Seleccione solamente un registro.");
			return false;
     	}


		
		if (rows[0].get('estatus')==ESTATUS_INACTIVA){
			mensajeAlert("Registro esta dado de baja no puede ser modificado. ");
			return false;
		}
		if(rows[0].get('estatus') ==ESTATUS_AUTORIZADO){
     		mensajeAlert("Registro " + rows[0].get('nombre') + " ya fue autorizado, operación inválida");
     		return false;
     	}
		if(rows[0].get('estatus') ==ESTATUS_CERRADO){
     		mensajeAlert("Registro " + rows[0].get('nombre') + " fue cerrado ó dada de baja" + 
     				"previamente, operaci�n inválida");
     		return false;
     	}
		
		return true;
	}
});
