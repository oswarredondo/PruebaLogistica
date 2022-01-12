Ext.define('MyDesktop.form.FormDatosClienteDireccion', {
	extend: 'Ext.form.Panel',
	xtype: 'clienterdireccion-form',
	frame: false,
	width: 400,
	layout: 'anchor',
	border: false,
	bodyPadding: 10,
	method: 'POST',
	fieldDefaults: {
		// labelAlign: 'top',
		labelWidth: 100,
		labelStyle: 'font-weight:bold'
	},
	comboTipos: undefined,
	showReadOnly: false,
	defaults: {
		anchor: '100%',
		margins: '0 0 10 0'
	},
	isImportar: false, //Indica si se va importar un archivo
	forma: undefined,
	myscope: undefined,
	defaultType: 'textfield',
	idcliente: undefined,
	operacion: undefined,
	main_grid: undefined,
	main_window: undefined,
	//indica el sufijo que debe tener el nombre del campo, esto sirve apara poder identificar remy destino
	sufijo: '',
	autoScroll: true,
	showBtnSalvar: false,
	btnTitleSalvar: titulo_btn_guardar,
	uuid: undefined,
	idregistro: undefined,
	idtipodireccion: undefined,
	isHabilitaPais: false,
	rfc: undefined,
	initComponent: function() {
		var main_grid = this.main_grid;
		var operacion_aplicar = this.operacion;
		var idcliente_id = this.idcliente == undefined ? '' : this.idcliente;


		this.comboTipos = Ext.create('MyDesktop.store.StoreTiposPersona', {});
		this.myscope = this;
		var scope_main = this;

		/*Creamos una conexion al metodo getDireccionIndividual para verificar si cuenta com solo una dieccion*/
		var conn = new Ext.data.Connection();
		conn.request({
			scope: scope_main,
			method: 'POST',
			defaultHeaders: { '_csrf_header': hv, "_csrf": vt },
			params: { "REMDES": this.idtipodireccion, "_csrf": vt },
			url: './rotular_etiquetas/carteraremdes/getDireccionIndividual',
			success: function(response, opts) {

				/*Decodificamos la repsuesta*/
				var obj = Ext.decode(response.responseText);

				/*Obtenemos el valor del parametro success True/False*/
				var TF = (obj.success);

				/*Obtenemos los datos del RED/DES*/
				var datos = (obj.message);

				/*Si el proceso es exitoso (TRUE)*/
				if (TF) {

					/*Split a los datos del REMDES*/
					var datosSplit = datos.split("~");

					/*Mandamos a llamar el metodo para poner los datos en su respectivo txtfield
					 * y pasamos el arreglo con los datos y el scope main*/
					this.setCampos(datosSplit, scope_main);
				}

			},
			failure: function(response, opts) {
				if (response.responseText != undefined) {
					var obj = Ext.decode(response.responseText);
					if (obj.message != undefined) {
						mensajeAlert(obj.message);
					}
				}

			}
		});

		this.items = [
			{ xtype: 'hidden', name: "_csrf", value: vt },
			{ xtype: 'hidden', name: 'iddireccion' },
			{ xtype: 'hidden', name: 'identificador', value: idcliente_id },
			/* CAMBIO UNIGIS IDREMDES */
			{
				xtype: 'textfield', flex: 2, fieldLabel: 'idRmDes', name: 'idRmDes' + scope_main.sufijo, width: 100,
				margins: '0 0 0 0', enforceMaxLength: true, maxLength: 40, allowBlank: false, hidden: true
			},

			{
				xtype: 'fieldcontainer',
				labelStyle: 'font-weight:bold;padding:0',
				layout: 'hbox',
				emptyText: '',
				defaultType: 'textfield',
				hidden: scope_main.sufijo == '_rem' ? true : false,
				fieldDefaults: {
					//labelAlign: 'top'
				},
				items: [
					/*
					{xtype: 'myUpperCaseTextField',  flex: 2,fieldLabel: fieldForzoso(field_rfc),name:'rfc'+scope_main.sufijo,width:100, 
					margins: '0 0 0 0',enforceMaxLength:true,maxLength:22,allowBlank: true },
					{
						xtype: 'button', flex: 1, width: 80, margins: '0 0 0 5', iconCls: 'buscar_white', text: titulo_btn_buscar,
						scope: this.myscope, id: 'btnRFC_' + this.id,
						handler: this.buscaDestinatario
					}
					*/
					{
						xtype: 'myUpperCaseTextField',
						id: 'id_rfc' + scope_main.sufijo,
						flex: 6,
						fieldLabel: fieldForzoso(field_rfc),
						name: 'rfc' + scope_main.sufijo,
						width: 100,
						margins: '0 0 0 0',
						enforceMaxLength: true,
						readOnly: scope_main.sufijo == '_rem' ? true : false,
						maxLength: 13,
						allowBlank: scope_main.sufijo == '_rem' ? true : false
					},
					{
						xtype: 'checkbox',
						id: 'id_check_rfc' + scope_main.sufijo,
						fieldLabel: 'GENERICO?',
						flex: 3,
						width: 80,
						margins: '0 0 0 5',
						listeners: {
							change: function() {

								var check = Ext.getCmp('id_check_rfc' + scope_main.sufijo).checked;

								if (check) {

									Ext.getCmp('id_rfc' + scope_main.sufijo).setValue('XAXX010101000');


								} else {

									Ext.getCmp('id_rfc' + scope_main.sufijo).setValue('');


								}
							}
						}
					}
				]
			},



			{
				xtype: 'fieldcontainer',
				labelStyle: 'font-weight:bold;padding:0',
				layout: 'hbox',
				emptyText: '',
				defaultType: 'textfield',
				fieldDefaults: {
					//labelAlign: 'top'
				},
				items: [

					{
						xtype: 'myUpperCaseTextField', flex: 2, fieldLabel: fieldForzoso(field_razonsocial), name: 'razonsocial' + scope_main.sufijo, width: 100,
						margins: '0 0 0 0', enforceMaxLength: true, maxLength: 40, allowBlank: false
					},
					{
						xtype: 'button', flex: 1, width: 80, margins: '0 0 0 5', iconCls: 'buscar_white', text: titulo_btn_buscar,
						scope: this.myscope, id: 'btnBuscarRazonSocial_' + this.id,
						handler: this.buscaDestinatario
					}
				]
			},
			{
				xtype: 'fieldcontainer',
				labelStyle: 'font-weight:bold;padding:0',
				layout: 'hbox',
				emptyText: '',
				defaultType: 'textfield',
				fieldDefaults: {
					//labelAlign: 'top' 
				},
				items: [

					{
						xtype: 'myUpperCaseTextField', flex: 2, fieldLabel: field_atencion, name: 'contacto' + scope_main.sufijo, width: 100,
						margins: '0 0 0 0', enforceMaxLength: true, maxLength: 40, allowBlank: false
					},
					{
						xtype: 'button', flex: 1, width: 80, margins: '0 0 0 5', iconCls: 'buscar_white', text: 'Buscar',
						scope: this.myscope, id: 'btnAtencion_' + this.id,
						handler: this.buscaDestinatario
					}
				]
			},

			// {xtype: 'myUpperCaseTextField', flex: 4,fieldLabel: 'Atencion',name:'contacto'+scope_main.sufijo,width:100,margins: '0 0 0 0',allowBlank: true,
			//   	enforceMaxLength:true,maxLength:40}, 
			{ xtype: 'myUpperCaseTextField', name: 'calle' + scope_main.sufijo, fieldLabel: fieldForzoso(field_calle), emptyText: '', allowBlank: false, enforceMaxLength: true, maxLength: 40 },
			{
				xtype: 'myUpperCaseTextField', flex: 1, fieldLabel: fieldForzoso(field_numexterior), name: 'numexterior' + scope_main.sufijo, width: 100,
				margins: '0 0 0 5', enforceMaxLength: true, maxLength: 15, allowBlank: false
			},
			{
				xtype: 'myUpperCaseTextField', flex: 1, fieldLabel: field_numinterior, name: 'numinterior' + scope_main.sufijo, width: 100,
				margins: '0 0 0 5', enforceMaxLength: true, maxLength: 10, allowBlank: true
			},

			{
				xtype: 'fieldcontainer',
				labelStyle: 'font-weight:bold;padding:0',
				layout: 'hbox',
				emptyText: field_cp,
				defaultType: 'textfield',
				fieldDefaults: {
					//labelAlign: 'top' 
				},
				items: [

					{
						xtype: 'myUpperCaseTextField', flex: 2, fieldLabel: fieldForzoso(field_cp), name: 'cp' + scope_main.sufijo, width: 100,
						margins: '0 0 0 0', enforceMaxLength: true, maxLength: 5, allowBlank: false
					},
					{
						xtype: 'button', flex: 1, width: 80, margins: '0 0 0 5', iconCls: 'buscar_white', text: titulo_btn_buscar,
						scope: this.myscope, id: 'btnBuscarCP_' + this.id,
						handler: this.buscaDestinatario
					}
				]
			},

			{
				xtype: 'fieldcontainer',
				labelStyle: 'font-weight:bold;padding:0',
				layout: 'hbox',
				emptyText: field_colonia,
				defaultType: 'textfield',
				fieldDefaults: {
					//labelAlign: 'top'
				},
				items: [

					{
						xtype: 'myUpperCaseTextField', flex: 2, fieldLabel: fieldForzoso(field_colonia), name: 'colonia' + scope_main.sufijo,
						width: 100, margins: '0 0 0 0', enforceMaxLength: true, maxLength: 50, allowBlank: false
					},
					{
						xtype: 'button', flex: 1, width: 80, margins: '0 0 0 5', iconCls: 'buscar_white', text: titulo_btn_buscar,
						scope: this.myscope, id: 'btnBuscarColonia_' + this.id,
						handler: this.buscaDestinatario
					}
				]
			},
			{
				xtype: 'fieldcontainer',
				labelStyle: 'font-weight:bold;padding:0',
				layout: 'hbox',
				emptyText: field_municipio,
				defaultType: 'textfield',
				fieldDefaults: {
					//labelAlign: 'top'  
				},
				items: [

					{
						xtype: 'myUpperCaseTextField', flex: 2, fieldLabel: fieldForzoso(field_municipio), name: 'municipio' + scope_main.sufijo, width: 100,
						margins: '0 0 0 0', enforceMaxLength: true, maxLength: 50, allowBlank: false
					},
					{
						xtype: 'button', flex: 1, width: 80, margins: '0 0 0 5', iconCls: 'buscar_white', text: titulo_btn_buscar,
						scope: this.myscope, id: 'btnBuscarMunicipio_' + this.id,
						handler: this.buscaDestinatario
					}
				]
			},
			{ xtype: 'myUpperCaseTextField', flex: 1, fieldLabel: field_estado, name: 'estado' + scope_main.sufijo, width: 100, margins: '0 0 0 0', enforceMaxLength: true, maxLength: 40 },
			//{xtype: 'myUpperCaseTextField', flex: 1,fieldLabel: 'Pa�s',name:'pais'+scope_main.sufijo,width:100,  margins: '0 0 0 0',enforceMaxLength:true,maxLength:40, value:'MEXICO'},

			{
				xtype: 'combobox',
				fieldLabel: fieldForzoso(field_pais),
				editable: false,
				name: 'pais' + scope_main.sufijo,
				store: Ext.create('MyDesktop.store.StorePlaza', {}),
				valueField: 'siglasplaza',
				displayField: 'descripcion',
				enforceMaxLength: true,
				readOnly: !this.isHabilitaPais,
				maxLength: 30,
				value: 'MEXICO',
				typeAhead: true,
				queryMode: 'local',
				allowBlank: false,
				emptyText: ''
			},


			{
				xtype: 'myUpperCaseTextField', flex: 1, fieldLabel: fieldForzoso(field_telefono),
				name: 'telefono' + scope_main.sufijo, width: 100, margins: '0 0 0 0',
				enforceMaxLength: true, maxLength: 10, allowBlank: false, regex: /^[0-9 \-]{1,}$/,
			},
			{
				xtype: 'myUpperCaseTextField', flex: 1, fieldLabel: field_celular,
				name: 'numcelular' + scope_main.sufijo, width: 100, margins: '0 0 0 0',
				enforceMaxLength: true, maxLength: 20, regex: /^[0-9 \-]{1,}$/,
			},
			{
				flex: 1, fieldLabel: field_correoe,
				name: 'correoe' + scope_main.sufijo, width: 100, margins: '0 0 0 0',
				enforceMaxLength: true, maxLength: 30, vtype: 'email'
			},
			/*{
				xtype : 'myUpperCaseTextField',
				flex : 1,
				fieldLabel : 'Latitud',
				id : 'latitud' + scope_main.sufijo,
				name : 'latitud' + scope_main.sufijo,
				width : 100,
				margins : '0 0 0 5',
				enforceMaxLength : true,
				maxLength : 50,
				allowBlank : true,
				readOnly : true
			}, { 
				xtype : 'myUpperCaseTextField',
				flex : 1,
				fieldLabel : 'Longitud',
				id : 'longitud' + scope_main.sufijo,
				name : 'longitud' + scope_main.sufijo,
				width : 100,
				margins : '0 0 0 5',
				enforceMaxLength : true,
				maxLength : 50,
				allowBlank : true,
				readOnly : true
			},*/


			{
				xtype: 'myUpperCaseTextField',
				name: 'descripcion',
				hidden: !this.isImportar,
				fieldLabel: field_descripcion,
				allowBlank: true
			}, {
				xtype: 'filefield',
				// id: 'form-file-fail'+scope_main.sufijo,
				emptyText: '',
				fieldLabel: '<font color=red>' + field_archivo_destino + '</font>',
				name: 'file_upload',
				allowBlank: true,
				hidden: !this.isImportar,
				buttonText: '',
				buttonConfig: {
					iconCls: 'folder_white'
				}
			},
			{
				xtype: 'checkbox',
				name: 'es_ocurre' + scope_main.sufijo,
				hidden: scope_main.sufijo == '_des' ? false : true,
				boxLabel: msg_es_ocurre,
				hideLabel: true,
				checked: false,
				margin: '0 0 10 0',
				scope: this,
				handler: function(box, checked) {
					if (checked) {
						scope_main.buscaInfoOficinasPdvOcurre(this);
						Ext.getCmp('btnBuscaInfoOficinas' + scope_main.id).enable();
						scope_main.updateFieldCte('', 'idoficina' + scope_main.sufijo);
					} else {
						Ext.getCmp('btnBuscaInfoOficinas' + scope_main.id).disable();
						scope_main.updateFieldCte('', 'idoficina' + scope_main.sufijo);
					}

				}

			},
			{
				xtype: 'fieldcontainer',
				labelStyle: 'font-weight:bold;padding:0',
				layout: 'hbox',
				emptyText: '',
				defaultType: 'textfield',
				hidden: scope_main.sufijo == '_des' ? false : true,
				fieldDefaults: {
					//labelAlign: 'top'
				},
				items: [

					{
						xtype: 'myUpperCaseTextField', flex: 2, fieldLabel: 'IdOficina', name: 'idoficina' + scope_main.sufijo, width: 100,
						margins: '0 0 0 0', enforceMaxLength: true, maxLength: 5, allowBlank: true, readOnly: true
					},
					{
						xtype: 'button', flex: 1, width: 80, margins: '0 0 0 5', iconCls: 'buscar_white', text: titulo_btn_buscar,
						scope: this.myscope, id: 'btnBuscaInfoOficinas' + this.id,
						handler: this.buscaInfoOficinas, disabled: true
					}
				]
			}


		];
		this.tbar = [
			/*{
				
				text : "Oficinas",
				tooltip : 'Consulta Oficinas',
				iconCls : 'opcion_carteraclientes',
				scope:this,
				handler : this.buscaInfoOficinasPdv
			} ,*/
			{

				text: titulo_btn_ubicacion_mapa,
				tooltip: tooltip_google_maps,
				iconCls: 'map_blue',
				scope: this,
				handler: this.searchGMAP
			},
			{ xtype: 'tbfill' }
			//				{
			//					 hidden: !this.showBtnSalvar,
			//					text :  this.btnTitleSalvar, 
			//					tooltip : tooltip_agregar_cartera_direcciones,
			//					iconCls : 'activo',
			//					scope:scope_main,
			//					handler : this.agregarRegistro 
			//				}
		];


		this.callParent();

	},

	agregarRegistro: function() {
		var form = this.getForm();
		if (!form.isValid()) {
			mensajeAlert(msg_datos_requeridos);
			return;
		}

		var myscope = this;
		Ext.MessageBox.confirm(titulo_confirmar, msg_guardar_cartera_direcciones,
			function(id, text) {
				if ((id === 'yes') || (id === 'si') || (id === 'y') || (id === 's')) {

					var razonsocial = myscope.getValueField('razonsocial' + myscope.sufijo);
					var numinterior = myscope.getValueField('numinterior' + myscope.sufijo);
					var telefono = myscope.getValueField('telefono' + myscope.sufijo);
					var email = myscope.getValueField('email' + myscope.sufijo);
					var cp = myscope.getValueField('cp' + myscope.sufijo);
					var colonia = myscope.getValueField('colonia' + myscope.sufijo);
					var municipio = myscope.getValueField('municipio' + myscope.sufijo);
					var estado = myscope.getValueField('estado' + myscope.sufijo);
					var calle = myscope.getValueField('calle' + myscope.sufijo);
					var contacto = myscope.getValueField('contacto' + myscope.sufijo);
					var numinterior = myscope.getValueField('numinterior' + myscope.sufijo);
					var numcelular = myscope.getValueField('numcelular' + myscope.sufijo);
					var rfc = myscope.getValueField('rfc' + myscope.sufijo);
					var numexterior = myscope.getValueField('numexterior' + myscope.sufijo);
					var correoe = myscope.getValueField('correoe' + myscope.sufijo);

					var metodo = myscope.sufijo == '_rem' ? 'insertaRemitente' : 'insertaDestinatario';
					var url = metodo + '?' + 'razonsocial' + myscope.sufijo + '=' + razonsocial +
						'&contacto' + myscope.sufijo + '=' + contacto +
						'&calle' + myscope.sufijo + '=' + calle +
						'&colonia' + myscope.sufijo + '=' + colonia +
						'&municipio' + myscope.sufijo + '=' + municipio +
						'&estado' + myscope.sufijo + '=' + estado +
						'&ciudad' + myscope.sufijo + '=' + municipio +
						'&cp' + myscope.sufijo + '=' + cp +
						'&telefono' + myscope.sufijo + '=' + telefono +
						'&celular' + myscope.sufijo + '=' + numcelular +
						'&rfc' + myscope.sufijo + '=' + rfc +
						//'&email'+ myscope.sufijo +'='+email+
						'&numinterior' + myscope.sufijo + '=' + numinterior +
						'&numexterior' + myscope.sufijo + '=' + numexterior +
						'&email' + myscope.sufijo + '=' + correoe;

					var conn = new Ext.data.Connection();
					conn.request({
						scope: myscope,
						method: 'POST',
						defaultHeaders: { '_csrf_header': hv, "_csrf": vt },
						params: { "_csrf": vt },
						url: './rotular_etiquetas/carteraremdes/' + url,
						success: function(response, opts) {
							var obj = Ext.decode(response.responseText);
							mensajeConfirm(msg_confirmar_guardar_cartera_direcciones);
						},
						failure: function(response, opts) {
							if (response.responseText != undefined) {
								var obj = Ext.decode(response.responseText);
								if (obj.message != undefined) {
									mensajeAlert(obj.message);
								}
							}

						}
					});

				}
			}, this);
	},
	searchGMAP: function() {

		var myscope = this;
		var latitud = this.getValueField('latitud' + this.sufijo);
		var longitud = this.getValueField('longitud' + this.sufijo);

		/* if ((latitud=='' ) || (longitud=='')){
			 myscope.getUbicacionMap();
			 mensajeWarning("Latitud y longitud calculadas, intente de nuevo");
			 return;
		 }*/



		var cp = myscope.getValueField('cp' + myscope.sufijo);
		var colonia = myscope.getValueField('colonia' + myscope.sufijo);
		var municipio = myscope.getValueField('municipio' + myscope.sufijo);
		var estado = myscope.getValueField('estado' + myscope.sufijo);
		var calle = myscope.getValueField('calle' + myscope.sufijo);
		var pais = 'MX';//myscope.getValueField('pais'+ myscope.sufijo);


		if ((cp != '') && (colonia != '') && (municipio != '') && (estado != '')) {
			//En base al sufijo se realiza la actualizacion de los campos
			//y la obtenci�n de datos
			var datos = "latitud= " + latitud + "&longitud=" + longitud + "&colonia=" + colonia + "&municipio=" + municipio + "&cp=" + cp +
				"&estado=" + estado + "&pais=MX&isadministracion=false&calle=" + calle +
				"&idoficina=&telefono=&nombre=";
			showGMapWindows(datos, '', '');

			//showGMapLatLongWindows(-99.09463690268552,  19.358901156334692);//latitud,longitud);

			//var maps_google = Ext.create('MyDesktop.objetos.GoogleMapsObject',{});
			/*maps_google.showMapConDireccion(calle,colonia,municipio, cp, estado, pais,
					  longitud , latitud);*/
			//var direccion = calle +', ' + colonia +',' +municipio+',' +cp +',' + pais ;
			//maps_google.showMapConLatitudLongitud(longitud , latitud,direccion);

		} else {
			mensajeWarning(msg_dato_a_consultar);
			return;
		}



	},

	buscaDestinatario: function(o, e) {
		var myscope = this;
		var boton = o.id.split("_")[0];
		var patron = myscope.getValueField('razonsocial' + myscope.sufijo);
		var tipoconsulta = 0;
		if (boton == 'btnBuscarRazonSocial') {
			myscope.getValueField('razonsocial' + myscope.sufijo);
			tipoconsulta = 1;
			if (patron == '') {
				mensajeAlert(msg_dato_a_consultar_razon_social);
				return;
			}
		} else if (boton == 'btnAtencion') {
			patron = myscope.getValueField('contacto' + myscope.sufijo);
			tipoconsulta = 2;
			if (patron == '') {
				mensajeAlert(msg_dato_a_consultar_atencion);
				return;
			}
		} else if (boton == 'btnBuscarCP') {
			patron = myscope.getValueField('cp' + myscope.sufijo);
			tipoconsulta = 5;
			if (patron == '') {
				mensajeAlert("Capture Codigo Postal");
				return;
			}
		} else if (boton == 'btnBuscarColonia') {
			patron = myscope.getValueField('colonia' + myscope.sufijo);
			tipoconsulta = 4;
			if (patron == '') {
				mensajeAlert("Capture Colonia");
				return;
			}
		} else if (boton == 'btnBuscarMunicipio') {
			patron = myscope.getValueField('municipio' + myscope.sufijo);
			tipoconsulta = 8;
			if (patron == '') {
				mensajeAlert("Capture Municipio");
				return;
			}
		} else {
			return;
		}

		myscope.buscaInfoCarteraRemDes(tipoconsulta, patron, myscope.idtipodireccion, myscope.sufijo, myscope);
	},
	buscaInfoCarteraRemDes: function(tipo_busqueda, patron, buscarporremdes, sufijo, myscope) {
		var fields = Ext.getCmp(this.id).getForm().getFields();
		var scope_main = this;

		var gridremitentes = Ext.create('MyDesktop.grid.GridCarteraDirecciones', {
			tipo_str: buscarporremdes, patron_busqueda: patron, tipo: tipo_busqueda, isConsulta: false,

			idremdes_field: 'idRmDes' + scope_main.sufijo,
			razonsocial_field: 'razonsocial' + scope_main.sufijo,
			numeroint_field: 'numinterior' + scope_main.sufijo,
			atencion_field: 'contacto' + scope_main.sufijo,
			numeroext_field: 'numexterior' + scope_main.sufijo,
			cp_field: 'cp' + scope_main.sufijo,
			colonia_field: 'colonia' + scope_main.sufijo,
			municipio_field: 'municipio' + scope_main.sufijo,
			estado_field: 'estado' + scope_main.sufijo,
			telefono_field: 'telefono' + scope_main.sufijo,
			numcelular_field: 'numcelular' + scope_main.sufijo,
			correoe_field: 'correoe' + scope_main.sufijo,
			ciudad_field: 'municipio' + scope_main.sufijo,
			calle_field: 'calle' + scope_main.sufijo,
			rfc_field: 'rfc' + scope_main.sufijo,
			fields: fields, form: Ext.getCmp(this.id).getForm()

		});
		gridremitentes.reloadInfo();

		var buscaroficinas_window = new Ext.Window({

			width: 950, height: 400,
			layout: 'border',
			title: titulo_cartera_clientes,
			closable: true,
			modal: true,
			iconCls: 'opcion_carteraclientes',
			headerPosition: 'right',
			items: [
				{ items: gridremitentes, layout: 'fit', region: 'center', height: 100 }
			],
			buttons: [
				{
					text: titulo_btn_salir, handler: function() {
						buscaroficinas_window.close();
					}
				},
				{
					text: 'Seleccionar', handler: function() {
						gridremitentes.selectRegistro();
					}
				}
			]

		});

		gridremitentes.setScopeWin(buscaroficinas_window);
		buscaroficinas_window.show();

	},
	buscaInfoOficinasPdvOcurre: function(scope) {
		this.buscaInfoOficinas(true, scope);
	},
	buscaInfoOficinasPdv: function() {
		this.buscaInfoOficinas(true, this);
	},
	buscaInfoOficinas: function(is_closable) {
		var fields = Ext.getCmp(this.id).getForm().getFields();
		var scope_main = this;

		var myscope = this;
		var gridoficinas1 = Ext.create('MyDesktop.grid.GridOficinasReceptoras', {
			calle_field: 'calle' + scope_main.sufijo, numero_field: 'numinterior' + scope_main.sufijo,
			telefono_field: 'telefono' + scope_main.sufijo,
			cp_field: 'cp' + scope_main.sufijo, colonia_field: 'colonia' + scope_main.sufijo,
			municipio_field: 'municipio' + scope_main.sufijo, estado_field: 'estado' + scope_main.sufijo,
			idoficina_field: 'idoficina' + scope_main.sufijo,
			fields: fields, form: Ext.getCmp(this.id).getForm()

		});

		var buscaroficinas_window1 = new Ext.Window({
			width: 950, height: 350,
			layout: 'border',
			title: titulo_busqueda_oficinas_receptoras,
			iconCls: 'contactos_blue',
			closable: true,
			iconCls: 'opcion_carteraclientes',
			headerPosition: 'right',
			modal: true,
			layout: 'fit',
			items: [
				gridoficinas1
			],
			buttons: [
				{
					text: titulo_btn_salir,
					handler: function() {
						buscaroficinas_window1.close();
					}
				}
			]

		});

		gridoficinas1.setScopeWin(buscaroficinas_window1);
		buscaroficinas_window1.show();

	},



	updateCampos: function(record) {
		//alert(Ext.getCmp(this.id));
		var fields = Ext.getCmp(this.id).getForm().getFields();
		this.updateFieldName(record, fields);

	},
	updateFieldName: function(record, fields) {
		var items = fields.items;
		var valor = "";
		for (i = 0; i < items.length; i++) {
			field = items[i];
			if (field != undefined) {
				if (field.getName() != undefined) {
					//busca el nombre del campo que debe ser el mismo del nombre del campo de 
					//la forma
					valor = record.get(field.getName());
					if (valor != undefined) {
						//alert('Campo:' + field.getName() + ', valor:' +valor);
						field.setValue(valor);
					} else {
						field.setValue("");
					}

				}
			}
		}
	},
	updateFieldReadOnly: function(record) {

		//alert(Ext.getCmp(this.id));
		var fields = Ext.getCmp(this.id).getForm().getFields();

		var items = fields.items;
		var valor = "";
		for (i = 0; i < items.length; i++) {
			field = items[i];
			if (field != undefined) {
				if (field.getName() != undefined) {
					field.setReadOnly(true);
				}
			}
		}

		this.updateCampos(record);
	},

	showGridCps: function(b, e) {
		var scope_main = this;
		var fields = Ext.getCmp(this.id).getForm().getFields();
		var tipoconsulta = 'cp';
		var patron = '';
		var boton = b.id.split("_")[0];

		if (boton == 'btnBuscarCP') {
			tipoconsulta = 'cp';
			patron = getValueFormField('cp' + scope_main.sufijo, fields);   //Ext.getCmp('idcp').getValue();
		} else if (boton == 'btnBuscarColonia') {
			tipoconsulta = 'colonia';
			patron = getValueFormField('colonia' + scope_main.sufijo, fields);   //Ext.getCmp('idcolonia').getValue();
		} else if (boton == 'btnBuscarMunicipio') {
			tipoconsulta = 'municipio';
			patron = getValueFormField('municipio' + scope_main.sufijo, fields);   //Ext.getCmp('idmunicipio').getValue();
		} else {
			mensajeAlert(msg_consulta_invalida);
			return;
		}

		var gridcps = Ext.create('MyDesktop.grid.GridConsultaCPs', {
			isEditable: true,
			cp_field: 'cp' + scope_main.sufijo, colonia_field: 'colonia' + scope_main.sufijo,
			municipio_field: 'municipio' + scope_main.sufijo, estado_field: 'estado' + scope_main.sufijo,
			fields: fields, form: Ext.getCmp(this.id).getForm(),
			tipoconsulta: tipoconsulta, patron: patron,
			cp: patron, colonia: patron, municipio: patron,
			scope_win: buscacps_window
		});

		var buscacps_window = new Ext.Window({
			width: 880, height: 350,
			layout: 'border',
			title: tooltip_consulta_cps,
			closable: true,
			modal: true,
			headerPosition: 'right',
			items: [
				{ items: gridcps, layout: 'fit', region: 'center', height: 100 }
			],
			buttons: [
				{ text: titulo_btn_salir, handler: function() { buscacps_window.close(); } }
			]
		});
		gridcps.setScopeWin(buscacps_window);
		buscacps_window.show();

	},

	setIdCliente: function(idcliente) {
		this.idcliente = idcliente;

		//actualiza el dato del campo
		this.updateFieldCte(idcliente, 'identificador');
	},
	setMainWindow: function(mainwin) {
		this.main_window = mainwin;
	},


	updateFieldCte: function(valor, campo) {
		var fields = Ext.getCmp(this.id).getForm().getFields();

		var items = fields.items;
		for (i = 0; i < items.length; i++) {
			field = items[i];
			if (field != undefined) {
				if ((field.getName() != undefined) && (field.getName() == campo)) {
					field.setValue(valor);
				}
			}
		}
	},
	setUUIDIdRegistro: function(uuid, idregistro) {
		this.uuid = uuid;
		this.idregistro = idregistro;
	},
	getCampoValor: function() {
		return this.getForm().getFieldValues();
	},
	validaForma: function() {
		return this.getForm().isValid();
	},
	getValueField: function(campo) {
		var fields = Ext.getCmp(this.id).getForm().getFields();
		var valor = '';
		var items = fields.items;
		for (i = 0; i < items.length; i++) {
			field = items[i];
			if (field != undefined) {
				if ((field.getName() != undefined) && (field.getName() == campo)) {
					valor = field.getValue();
				}
			}
		}
		return valor;
	},
	getUbicacionMap: function() {
		var cp = this.getValueField('cp' + this.sufijo);
		var colonia = this.getValueField('colonia'
			+ this.sufijo);
		var municipio = this.getValueField('municipio'
			+ this.sufijo);
		var estado = this.getValueField('estado' + this.sufijo);
		var numexterior = this.getValueField('numexterior'
			+ this.sufijo);
		var calle = this.getValueField('calle' + this.sufijo);
		var pais = this.getValueField('pais' + this.sufijo);

		var longitud = Ext.getCmp('longitud' + this.sufijo);
		var latitud = Ext.getCmp('latitud' + this.sufijo);

		var maps_google = Ext.create(
			'MyDesktop.objetos.GoogleMapsObject', {});
		maps_google.getCoordenadas(calle + " " + numexterior,
			colonia, municipio, cp, estado, pais, longitud,
			latitud);

	},
	setCampos: function(datos, scope_main) {

		/* Ejecutamos el metodo updateFieldCte para asignar el dato a su respectivo txtfield*/

		/* CAMBIO UNIGIS IDREMDES */
		this.updateFieldCte(datos[0], 'idRmDes' + scope_main.sufijo);

		this.updateFieldCte(datos[0], 'razonsocial' + scope_main.sufijo);

		this.updateFieldCte(datos[1], 'numinterior' + scope_main.sufijo);

		this.updateFieldCte(datos[2], 'contacto' + scope_main.sufijo);

		this.updateFieldCte(datos[3], 'numexterior' + scope_main.sufijo);

		this.updateFieldCte(datos[4], 'cp' + scope_main.sufijo);

		this.updateFieldCte(datos[5], 'colonia' + scope_main.sufijo);

		this.updateFieldCte(datos[6], 'municipio' + scope_main.sufijo);

		this.updateFieldCte(datos[7], 'estado' + scope_main.sufijo);

		this.updateFieldCte(datos[8], 'telefono' + scope_main.sufijo);

		this.updateFieldCte(datos[9], 'numcelular' + scope_main.sufijo);

		this.updateFieldCte(datos[10], 'correoe' + scope_main.sufijo);

		this.updateFieldCte(datos[11], 'ciudad' + scope_main.sufijo);

		this.updateFieldCte(datos[12], 'calle' + scope_main.sufijo);

		this.updateFieldCte(datos[13], 'rfc' + scope_main.sufijo);

	}
});