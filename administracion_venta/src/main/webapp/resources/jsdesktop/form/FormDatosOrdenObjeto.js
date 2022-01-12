Ext.define('MyDesktop.form.FormDatosOrdenObjeto', {
    extend: 'Ext.form.Panel',

    requires: [
        'Ext.form.FieldSet',
        'Ext.form.FieldContainer',
        'Ext.form.field.ComboBox',
        'Ext.form.field.Date',
        'Ext.button.Button',
        'Ext.form.field.Number'
    ],
    accion:'insert',
    main_window:undefined,
    main_grid:undefined,
    showTipoEmpaque:function(){
    	
    	var fields = this.getForm().getFields( ) ;
    	var gridcps = Ext.create('MyDesktop.grid.GridTipoEmpaque', {
    		clave:'idempaque',
    		descripcion:'idempaque',
    		fields:fields
    	});
    	var buscaemapques_window = new Ext.Window({
			width    : 300,height   : 300,
			layout   : 'border',
			title	: 'Tipo',
			closable:true,
			modal:true,
			headerPosition: 'right',
			items    : [
			   {items   : gridcps,layout :'fit',region :'center',height   : 100}
			   ],
			buttons: [
				{text   : 'Salir',handler: function(){buscaemapques_window.close();}}
	        ]
		}); 
    	gridcps.setMainWindow(buscaemapques_window);	
    	buscaemapques_window.show();

	
    },
	showGridDireccionCuenta: function(b, e){
		   
		var scope_main=this;
		var fields = Ext.getCmp(this.id).getForm().getFields( ) ;
		var campo_filtro='razonsocial'  ;
		var patron =getValueFormField('razonsocialcliente',fields);  
		 

		 
		var gridcps = Ext.create('MyDesktop.grid.GridDireccionRecoleccion', {
			showCuentas:true,
			fields: fields,form:Ext.getCmp(this.id).getForm(),
			campo_filtro:campo_filtro,
			patron:patron,
			cp:patron, colonia:patron,municipio: patron,
			scope_win:buscacps_window,
			
			idnumclientesol:'numcliente',
			idnumcontratosol:'contrato',
			idrazonsolsol:'razonsocialcliente',
			
        	//email  idtelefonosolicita idcelularsolicita idnumoficinasolicita
			razonsocial:'razonsocial',
			calle:'calle',
			telefono:'telefono',
			//fax:undefined,
			cp:'cp',
			colonia:'colonia',
			municipio:'municipio',
			estado:'estado',
			ciudad:'municipio',
			atencion:'preguntarpor',
			//rfc:undefined,
			depto:'departamento',
			numcelular:'celular'

		}); 
		  
		var buscacps_window = new Ext.Window({
				width    : 880,height   : 350,
				layout   : 'border',
				title	: 'Busqueda de códigos postales',
				closable:true,
				modal:true,
				headerPosition: 'right',
				items    : [
				   {items   : gridcps,layout :'fit',region :'center',height   : 100}
				   ],
				buttons: [
					{text   : 'Salir',handler: function(){buscacps_window.close();}}
		        ]
			}); 
		gridcps.setMainWindow(buscacps_window);	
		buscacps_window.show();
	
	},
    
	showGridDireccionRecol: function(b, e){
		var scope_main=this;
		var fields = Ext.getCmp(this.id).getForm().getFields( ) ;
		var campo_filtro='razonsocial'  ;
		var patron ='';
		var boton = b.id.split("_")[0]; 
		
		if (boton=='btnDireBuscarRazonSocial'){
			campo_filtro='razonsocial'  ;
			 patron=getValueFormField('razonsocial',fields);   //Ext.getCmp('idcp').getValue();
		}else if (boton=='btnDirBuscaAtencion'){
			campo_filtro='preguntarpor'  ;
			 patron=getValueFormField('atencion',fields);   //Ext.getCmp('idcolonia').getValue();
		}else if (boton=='btnDirBuscaRFC'){
			campo_filtro='rfc'  ;
			 patron=getValueFormField('idrfcrec',fields);   //Ext.getCmp('idmunicipio').getValue();
		}else{
			mensajeAlert('Tipo de consulta inválida.');
			return;
		}		
		 
		var gridcps = Ext.create('MyDesktop.grid.GridDireccionRecoleccion', { 
			fields: fields,form:Ext.getCmp(this.id).getForm(),
			showCuentas:false,
			campo_filtro:campo_filtro,
			patron:patron,
			cp:patron, colonia:patron,municipio: patron,
			scope_win:buscacps_window,
        	//email  idtelefonosolicita idcelularsolicita idnumoficinasolicita
			razonsocial:'razonsocial',
			calle:'calle',
			telefono:'telefono',
			//fax:undefined,
			cp:'cp',
			colonia:'colonia',
			municipio:'municipio',
			estado:'estado',
			ciudad:'municipio',
			atencion:'preguntarpor',
			//rfc:undefined,
			depto:'departamento',
			numcelular:'celular',
			idregistro:'idregistrodirrecol',
			correoe:'email'
			

		}); 
		  
		var buscacps_window = new Ext.Window({
				width    : 880,height   : 350,
				layout   : 'border',
				title	: 'Busqueda de códigos postales',
				closable:true,
				modal:true,
				headerPosition: 'right',
				items    : [
				   {items   : gridcps,layout :'fit',region :'center',height   : 100}
				   ],
				buttons: [
					{text   : 'Salir',handler: function(){buscacps_window.close();}}
		        ]
			}); 
		gridcps.setMainWindow(buscacps_window);	
		buscacps_window.show();
	
	},
  
    
	showGridCps: function(b, e){
		var scope_main=this;
		var fields = Ext.getCmp(this.id).getForm().getFields( ) ;
		var tipoconsulta='cp'  ;
		var patron ='';
		var boton = b.id.split("_")[0]; 
		
		if (boton=='btnBuscarCP'){
			 tipoconsulta='cp'  ;
			 patron=getValueFormField('cp',fields);   //Ext.getCmp('idcp').getValue();
		}else if (boton=='btnBuscarColonia'){
			 tipoconsulta='colonia'  ;
			 patron=getValueFormField('colonia',fields);   //Ext.getCmp('idcolonia').getValue();
		}else if (boton=='btnBuscarMunicipio'){
			 tipoconsulta='municipio'  ;
			 patron=getValueFormField('municipio',fields);   //Ext.getCmp('idmunicipio').getValue();
		}else{
			mensajeAlert('Tipo de consulta inválida.');
			return;
		}		
		    
		var gridcps = Ext.create('MyDesktop.view.GridConsultaCPs', { 
			isEditable:true,
			cp_field:'cp' ,colonia_field:'colonia',
			municipio_field:'municipio',estado_field:'estado',
			fields: fields,form:Ext.getCmp(this.id).getForm(),
			tipoconsulta:tipoconsulta,patron:patron,
			cp:patron, colonia:patron,municipio: patron,
			scope_win:buscacps_window
		}); 
		  
		var buscacps_window = new Ext.Window({
				width    : 880,height   : 350,
				layout   : 'border',
				title	: 'Busqueda de códigos postales',
				closable:true,
				modal:true,
				headerPosition: 'right',
				items    : [
				   {items   : gridcps,layout :'fit',region :'center',height   : 100}
				   ],
				buttons: [
					{text   : 'Salir',handler: function(){buscacps_window.close();}}
		        ]
			}); 
		gridcps.setScopeWin(buscacps_window);	
		 buscacps_window.show();
	
	},
    setMainWindow:function(main_window){
    	this.main_window=main_window;
    },
    
	verificaHoraSistema:function (){
		//Funciones para fechas para suma y resta de dias

		
		var conn = new Ext.data.Connection();
        conn.request({
            url: '../solicitudrecoleccion/obtenerHoraServidor',
            success: function(response, opts) {
			 var obj = Ext.decode(response.responseText);
			 if (obj.isOK==false){
					//alert("Se ha detectado la hora de corte de recolecciones su, recolecci�n ser� iniciada o se realizar� el d�a de "+(new Date()));
					//Ajusta la hora en el pie y header 
					var str_horacorte = '<font color="#8A0808">SE DETECTO HORA DE CORTE DE LAS ' + 
					obj.horacorte+ ', TODA RECOLECCION SERA CONFIGURADA PARA MAÑANA.</font>';
					var obj_cmp = Ext.getCmp('lbHoraServer_head');
					obj_cmp.setText( str_horacorte, false);
					
					
					obj_cmp = Ext.getCmp('lbHoraServer');
					obj_cmp.setText( "<font color='#0A122A'>Hora: "+obj.hora_str+"</font>", false);
					
					
					//Configura la fecha inicial y final con la fecha sumada en un dia 
					var hoy = new Date();
					var fecha_actual = hoy.addDays(1);

					//Actualiza la fecha actual
					Ext.getCmp('idfechaini').setMinValue(fecha_actual);
					//Ext.getCmp('idfechafinal').setMinValue(fecha_actual);
					//Ajusta la fecha de inicio 
					Ext.getCmp('idfechaini').setRawValue(obj.fecha);
					Ext.getCmp('idfechaini').setValue( fecha_actual ) ;
					//Verirfica si la fecha inicial es mayor a la final para 
					//Iniciarla con la misma fecha
				//	if (Ext.getCmp('idfechafinal').getValue()==Ext.getCmp('idfechaini').getValue()){
					//		Ext.getCmp('idfechafinal').setRawValue(obj.fecha);
					//	Ext.getCmp('idfechafinal').setValue( fecha_actual ) ;
					//	}

					//Mueve la fecha al dia inicial siguiente
			  }	else{
			    //Ajusta la hora en el pie y header
				Ext.getCmp('lbHoraServer_head').setText('Hora Servidor:'+  obj.hora_str);
				//Ext.getCmp('lbHoraServer_pie').setText('Hora Servidor:'+ obj.hora_str);
			  }
  
			 // console.debug(obj);
		   },
		   failure: function(response, opts) {
			  alert('server-side failure with status code ' + response.status);
		   }		
        });          
	},
	
	saveDatosCliente:function (b, e) {
		var myscope=this;
		var rfc = "";
		var fields = this.getForm().getFields( ) ; 
		// Arma el url solo sin validar que el usuario haya capturado
		// valores
		var url ='?rfc=' + rfc;
		url = url + '&razonsocial=' + getValueFormField('razonsocial',fields) ;
		url = url + '&atencion=' + getValueFormField('preguntarpor',fields);
		url = url + '&direccion=' + getValueFormField('calle',fields);
		url = url + '&colonia=' + getValueFormField('colonia',fields);
		url = url + '&cp=' + getValueFormField('cp',fields);
		url = url + '&municipio=' + getValueFormField('municipio',fields);
		url = url + '&estado=' + getValueFormField('estado',fields) ;
		url = url + '&telefono=' + getValueFormField('telefono',fields);
		url = url + '&email=' + getValueFormField('email',fields);
		url = url + '&idremdes=' + getValueFormField('idremdes',fields) ;
		url = url + '&departamento=' + getValueFormField('departamento',fields);
		url = url + '&celular=' + getValueFormField('celular',fields) ;
		url = url + '&idregistro=' + getValueFormField('idregistrodirrecol',fields) ;
		
		var cat = 'rec';
		
	    Ext.MessageBox.confirm('Confirma', '¿Desea salvar los datos capturados?', function(){

			var conn = new Ext.data.Connection();
			conn.request({
						url : "../direccionrecoleccion/saveClientesAgenda" + url,
						success : function(resp, opts) {

							mensajeConfirm("La informacion se guardo de forma correcta.");
						},
						failure : function(resp, opts) {

							mensajeAlert("Error al intentar guardar la informacion.");
							return;
						}
					});

       }, myscope);


	},
	
	insertRecoleccion:function (){
	
	},
	setVolumenTotal:function(me){  
		var fields = me.getForm().getFields( ) ; 
		
		var alto =getValueFormField('alto',fields);
		var ancho =getValueFormField('ancho',fields);
		var largo=getValueFormField('largo',fields);
		var numpiezas = getValueFormField('cantidadpzas',fields);
		var volumentotal = calculaVolumenTotal(ancho,alto,largo,numpiezas);
		setValueFormField('idvolumen',fields,volumentotal);
	},
	setPesoTotal:function(me){
		var fields = me.getForm().getFields( ) ; 

		var pesokg =getValueFormField('pesokg',fields);
		var numpiezas = getValueFormField('cantidadpzas',fields);
		var pesototal = calculaPesoTotal(pesokg,numpiezas);
		
		setValueFormField('idpesototal',fields,pesototal);
	},
	
	updateCampos:function(record){
		//alert(Ext.getCmp(this.id));
		var fields = Ext.getCmp(this.id).getForm().getFields( ) ;
		this.updateFieldName(record,fields);
						
	},
	
	updateFieldName:function(record, fields){
		var items = fields.items;
		var valor ="";
		for(i = 0; i < items.length; i++){
			field = items[i];
			if (field!=undefined){
				if (field.getName()!=undefined){
					//busca el nombre del campo que debe ser el mismo del nombre del campo de 
					//la forma
					valor = record.get(field.getName());
					if (valor!=undefined){
						//alert('Campo:' + field.getName() + ', valor:' +valor);
						field.setValue(valor);
					}else{
						field.setValue("");
					}
				
				}
			}
		}
	},
	updateCamposTipoEmpaque:function(valor){
		var fields = Ext.getCmp(this.id).getForm().getFields( ) ;
		
		setValueFormField('idempaque',fields,valor);
	}
	

});