Ext.define('MyDesktop.ViewRotuladorEtiquetas', {
	extend: 'Ext.ux.desktop.Module',

	requires: [
		'Ext.tab.Panel'
	],

	id: 'rotulador-config-etiquetas-win',

	init: function() {
		this.launcher = {
			text: 'Configuración de Etiquetas',
			iconCls: 'opcion_consultaetiqueta'
		}
	},
	grid_clientes: undefined,
	grid_contactos: undefined,
	grid_convenios: undefined,
	grid_localizacion: undefined,
	myScope: undefined,
	grid_etiquetas: undefined,
	autoScroll: true,
	grid_etiquetas: undefined,
	createWindow: function() {


		this.myScope = this;
		//Depura los registros de rotulos temporales
		var conn = new Ext.data.Connection();
		conn.request({
			scope: this,
			url: './rotular_etiquetas/depuraRotulacionTemporal',
			method: 'POST',
			defaultHeaders: { '_csrf_header': hv, "_csrf": vt },
			params: { "_csrf": vt },

			success: function(response, opts) {
				var obj = Ext.decode(response.responseText);

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


		this.uuid = generateUUID();

		this.myscope = this;
		var myscope = this;
		myscope.grid_etiquetas = new MyDesktop.grid.GridEtiquetasConfiguradas({
			isConsulta: false,
			border: false,
			frame: false
		});


		myscope.actualizar();

		var desktop = this.app.getDesktop();
		var win = desktop.getWindow(this.id);

		if (!win) {

			win = desktop.createWindow({

				id: myscope.id,
				title: 'Configuración Etiquetas',
				iconCls: 'tag16x16',
				border: false,
				constrainHeader: false,
				closable: true,
				closeAction: 'hide',
				width: 1200,
				maximized: true,
				maximizable: false,
				layout: 'fit',

				items: [
					this.grid_etiquetas
				],
				bbar: [
					{
						text: 'Agregar',
						iconCls: 'add32x32',
						scope: myscope,
						handler: myscope.agregar,
						tooltip: 'Agrega registro a la tabla de impresion',

					},
					{ xtype: 'tbseparator' },
					{
						text: 'Importar',
						iconCls: 'upload32x32',
						scope: myscope,
						handler: myscope.importar,
						tooltip: 'Importa Datos de un archivo de Excel para impresion',

					}],
				dockedItems: [
					{
						dock: 'right',
						xtype: 'toolbar',
						border: true,
						items: [
							{
								xtype: 'fieldset',
								flex: 1,
								height: 150,
								title: 'Etiqueta de tipo',
								defaultType: 'radio', // each item will be a radio button
								layout: 'anchor',
								defaults: {

									hideEmptyLabel: true
								},
								items: [
									{
										checked: true,
										boxLabel: 'AutoDocWeb',
										id: 'etiquetatipo_autodocweb',
										name: 'etiquetatipo',
										inputValue: 'AUTODOC'
									},
									{
										boxLabel: 'ESTAFETA',
										//disabled:checkEnable('mensajeria-estafeta-opcion'),
										hidden: checkEnable('mensajeria-estafeta-opcion'),
										id: 'etiquetatipo_estafeta',
										name: 'etiquetatipo',
										inputValue: 'ESTAFETA'
									}, {
										boxLabel: 'DHL',
										hidden: checkEnable('mensajeria-dhl-opcion'),
										id: 'etiquetatipo_dhl',
										name: 'etiquetatipo',
										inputValue: 'DHL'
									}, {
										boxLabel: 'FEDEX',
										hidden: checkEnable('mensajeria-fedex-opcion'),
										id: 'etiquetatipo_fedex',
										name: 'etiquetatipo',
										inputValue: 'FEDEX'
									},
									{
										boxLabel: 'REDPACK',
										hidden: checkEnable('mensajeria-redpack-opcion'),
										id: 'etiquetatipo_redpack',
										name: 'etiquetatipo',
										inputValue: 'REDPACK'
									},
									{
										boxLabel: 'UPS',
										hidden: checkEnable('mensajeria-ups-opcion'),
										id: 'etiquetatipo_ups',
										name: 'etiquetatipo',
										inputValue: 'UPS'
									}
								]

							},
							{ xtype: 'tbseparator' },
							{
								text: 'Reimprimir',
								iconCls: 'reprint16x16blue',
								scope: myscope,
								handler: myscope.reimprimir,
								tooltip: 'Muestra las impresiones del usuario en el día para poder reimprimir'
							},
							{ xtype: 'tbseparator' },
							{
								text: 'Consulta CPs',
								iconCls: 'search_blue',
								handler: function() {
									windowsConsultaCPS();
								},
								scope: myscope,
								tooltip: 'Consulta de Colonias y Codigos Postales'
							},
							{ xtype: 'tbseparator' },
							{
								text: 'Guía madre',
								iconCls: 'print32x32',
								handler: myscope.imprimirGuiaMadre,
								scope: myscope,
								tooltip: 'Genera e imprime guía madre'
							},
							{ xtype: 'tbseparator' },
							{
								text: 'Guías multiples',
								iconCls: 'print32x32',
								handler: myscope.imprimirGuiaMultiple,
								scope: myscope,
								tooltip: 'Genera e imprime guías multiple'
							},
							{ xtype: 'tbseparator' },
							{
								text: 'Imprimir',
								iconCls: 'print32x32',
								handler: myscope.imprimir,
								scope: myscope,
								tooltip: 'Inicia la rotulacion de las etiquetas'
							}
						]
					},


				],
				bbar: [
					{
						text: 'Agregar',
						iconCls: 'add32x32',
						scope: myscope,
						tooltip: 'Agrega registro a la tabla de impresion',
						handler: myscope.agregar,
					},
					{ xtype: 'tbseparator' },
					{
						text: 'Importar',
						iconCls: 'upload32x32',
						scope: myscope,
						handler: myscope.importar,
						tooltip: 'Importa Datos de un archivo de Excel para impresion'
					},

					{ xtype: 'tbseparator' },
					{
						text: 'Limpiar',
						iconCls: 'garbage32x32',
						handler: myscope.limpiar,
						scope: myscope,
						tooltip: 'Limpia los registos de la tabla de impresion'
					},
					{ xtype: 'tbseparator' },
					{
						text: 'Sets Existentes',
						iconCls: 'database_blue',
						handler: myscope.muestraSets,
						scope: myscope,
						tooltip: 'Sets de Rotulación existentes'
					},
					{ xtype: 'tbseparator' },
					{
						text: 'Actualizar',
						iconCls: 'reload32x32',
						scope: myscope,
						handler: myscope.actualizar,
						tooltip: 'Actualiza los folios disponibles'
					},

					{
						text: 'Guardar Set',
						iconCls: 'database_blue',
						handler: myscope.guardaset,
						scope: myscope,
						tooltip: 'Guarda el set configurado de rotulación'
					}





				]
			});
		}



		return win;
	},
	muestraSets: function() {
		var myscope = this;

		var gridSetRotulacionEtiquetas = new MyDesktop.grid.GridSetRotulacionEtiquetas({
			layout: 'fit'
		});


		var datos_window = new Ext.Window({
			width: 350,
			height: 350,
			title: 'Set de Rotulacion existentes',
			closable: true,
			resizable: false,
			modal: true,
			layout: 'fit',
			items: [gridSetRotulacionEtiquetas],
			buttons: [
				{
					text: 'Elminar', iconCls: 'garbage32x32', scope: myscope, handler: function() {

						Ext.MessageBox.confirm('Confirmar', 'Desea eliminar el set de trabajo configurado?',
							function(id, text) {
								if ((id === 'yes') || (id === 'si') || (id === 'y') || (id === 's')) {

									var row = gridSetRotulacionEtiquetas.getRowsSelected();
									if ((row != undefined) && (row.length > 0)) {
										myscope.uuid = row[0].get('uuid');
										myscope.grid_etiquetas.eliminarSet(row[0].get('uuid'));
										gridSetRotulacionEtiquetas.getStore().reload();
									}

								}
							});

					}
				},
				{ xtype: 'tbfill' },
				{
					text: 'Seleccionar', iconCls: 'activo', scope: myscope, handler: function() {

						var row = gridSetRotulacionEtiquetas.getRowsSelected();

						if ((row != undefined) && (row.length > 0)) {

							/* Se obtiene el uuid del setter seleccionado */
							myscope.uuid = row[0].get('uuid');

							/* Vamos a nuestro controlador y obtenemos los convenios que se ecunetran activos
							 * para este cliente, en caso de que algun  dato del seter tenga un convenio que
							 * ya no este ativo o que cuente con algun seguro no autoriado, regresaremos a la vista
							 * y lo pintaremos de rojo indicando que ese dato no se podra utilizar*/
							var conn = new Ext.data.Connection();

							conn.request({
								method: 'POST',
								defaultHeaders: { '_csrf_header': hv, "_csrf": vt },
								url: './rotular_etiquetas/validarDatosRegistro',
								params: { uuid: myscope.uuid, "_csrf": vt },
								success: function(response, opts) {

									/* Obtenemos la variable del controlador */
									var obj = Ext.decode(response.responseText);

									/* accedemos a la vista y mandamos un string con los ids de los datos
									 * que no son validos y se pintaran de rojo */
									myscope.grid_etiquetas.recibeIdsInvalidos(obj.message);

									//			        							myscope.buscar(uuid);
									/* Vamos a la vista y mostramos los datos */
									myscope.grid_etiquetas.buscar(row[0].get('uuid'));

									/* Cerramos la ventana de seleccion de los setters */
									datos_window.close();

									if (obj.message != "") {

										mensajeAlert('Algunos datos cuentan con convenios fuera de tiempo, seran señalados con color rojo');

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


						}
					}
				}

			],
			headerPosition: 'right'
		});
		datos_window.show();
	},
	guardaset: function() {
		var myscope = this;
		Ext.MessageBox.confirm('Confirmar', 'Desea guardar el set de trabajo configurado?',
			function(id, text) {
				if ((id === 'yes') || (id === 'si') || (id === 'y') || (id === 's')) {
					Ext.MessageBox.show({
						title: 'Identificar Set',
						msg: 'Agrege el identificador del Set a Guardar:',
						width: 300,
						buttons: Ext.MessageBox.OKCANCEL,
						multiline: true,
						fn: function showResultText(btn, text) {
							if ((btn === 'yes') || (btn === 'si') || (btn === 'y') ||
								(btn === 's') || (btn === 'ok') || (btn === 'OK')) {

								var conn = new Ext.data.Connection();
								conn.request({
									scope: myscope,
									url: './rotular_etiquetas/insertRotulacionSet',
									method: 'POST',
									defaultHeaders: { '_csrf_header': hv, "_csrf": vt },
									params: { uuid: myscope.uuid, descripcion: text, "_csrf": vt },
									success: function(response, opts) {
										var obj = Ext.decode(response.responseText);
										mensajeConfirm("Se guardo el set " + text + ", correctamente.");
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

						}
					});
				}
			});

	},
	importar: function() {
		var myscope = this;

		Ext.MessageBox.confirm('Confirmar', 'Se limpiará la informacion actual,Desea continuar?',
			function(id, text) {
				if ((id === 'yes') || (id === 'si') || (id === 'y') || (id === 's')) {

					myscope.uuid = generateUUID();
					myscope.grid_etiquetas.buscar(myscope.uuid);

					var uuid = generateUUID();
					var gridImportarRotualcion = new MyDesktop.grid.GridImportarRotualcion({
						height: 190, //frame:true, border:false,title:'Servicios',
						layout: 'fit', forceFit: true,
						uuid: uuid
					});
					var datos_window = new Ext.Window({
						width: 1000,
						height: 555,
						title: 'Importar datos para Etiqueta',
						closable: false,
						maximizable: false,
						resizable: false,
						modal: true,
						layout: 'fit',
						items: [
							gridImportarRotualcion
						],
						dockedItems: [{
							xtype: 'toolbar',
							dock: 'bottom',
							items: [
								{ xtype: 'tbfill' },
								{
									text: "Cancelar",
									tooltip: 'Cancela la importación de registros a rotular',
									iconCls: 'deleteRed16x16',
									handler: function() {
										Ext.MessageBox.confirm('Confirmar', 'La informacion importada será eliminada,Desea continuar?',
											function(id, text) {
												if ((id === 'yes') || (id === 'si') || (id === 'y') || (id === 's')) {
													myscope.grid_etiquetas.getStore().removeAll();
													depuraCleanUUID(myscope.uuid);
													datos_window.close();
													//reinicia el UUID
													myscope.uuid = generateUUID();
												}
											}, this);


									}
								},
								{
									text: 'Guardar', iconCls: 'activo',
									handler: function() {
										Ext.MessageBox.confirm('Confirmar', 'Solo los registros sin error serán  ' +
											'procesados para rotulación,¿Desea continuar?',
											function(id, text) {
												if ((id === 'yes') || (id === 'si') || (id === 'y') || (id === 's')) {
													var ventana = creaVentanaEspera();
													var conn = new Ext.data.Connection();
													conn.request({
														url: './rotular_etiquetas_importar/procesarRegistrosCorrectos',
														method: 'POST',
														defaultHeaders: { '_csrf_header': hv, "_csrf": vt },
														params: { uuid: uuid, "_csrf": vt },
														success: function(response, opts) {
															var obj = Ext.decode(response.responseText);
															myscope.actualizar();
															datos_window.close();
															ventana.close();
														},
														failure: function(response, opts) {
															if (response.responseText != undefined) {
																var obj = Ext.decode(response.responseText);
																if (obj.message != undefined) {
																	mensajeAlert(obj.message);
																}
															}
															datos_window.close();
															ventana.close();
														}
													});
													myscope.uuid = uuid

												}
											}, this);

									}
								}
							]
						}],

						headerPosition: 'right'
					});
					datos_window.show();

				}
			});
	},
	agregar: function() {

		var my_scope = this;


		var uuid = this.uuid == undefined ? generateUUID() : this.uuid;


		var idregistro = -1;

		var forma_remitente = new MyDesktop.form.FormDatosClienteDireccion({
			height: 415, sufijo: '_rem', idtipodireccion: 'REM', title: 'Remitente', showBtnSalvar: true,
			btnTitleSalvar: 'Guardar Remitente'
		});

		var forma_destinatario = new MyDesktop.form.FormDatosClienteDireccion({
			height: 415, sufijo: '_des', idtipodireccion: 'DES', title: 'Destinatario', showBtnSalvar: true,
			btnTitleSalvar: 'Guardar Destinatario'
		});

		var forma_configuraciondados = new MyDesktop.form.FormPropiedadesEtiquetas({
			height: 415, title: 'Generales', remitente: forma_remitente, destinatario: forma_destinatario,
			btnTitleSalvar: 'Agregar Guía a tabla', showBtnSalvar: true
		});

		var globalKeyMap_tab = new Ext.KeyMap(document);
		globalKeyMap_tab.accessKey = function(key, handler, scope) {
			var h = function(n, e) {
				e.preventDefault();
				handler.call(scope || this, n, e);
			};
			this.on(key, h, scope);

		};

		var tabs = Ext.widget('tabpanel', {

			width: 710,
			height: 610,
			activeTab: 0,
			defaults: {
				bodyPadding: 10
			},
			layout: 'fit',
			tabPosition: 'bottom',

			bbar: [

				{ xtype: 'tbfill' },

				{

					text: "Guardar ",
					tooltip: 'Guarda los datos para rotulación',
					iconCls: 'activo',
					id: 'idsavedatosrotular' + my_scope.id,
					handler: function() {

						if (!forma_remitente.validaForma()) {
							mensajeAlert("Capture los datos requeridos de remitente, en caso de estar todo en forma recuerde que debe seleccionar direcciones registradas en nuestro sistema y no haber redactado la suya sin registrarla.");
							return;
						}
						if (!forma_destinatario.isValid()) {
							mensajeAlert("Capture los datos requeridos de destinatario, en caso de estar todo en forma recuerde que debe seleccionar direcciones registradas en nuestro sistema y no haber redactado la suya sin registrarla.");
							return;
						}
						if (!forma_configuraciondados.isValid()) {
							mensajeAlert("Capture los datos requeridos de generales");
							return;
						}

						if ((forma_destinatario.getValueField('es_ocurre_des') == 'true') || (forma_destinatario.getValueField('es_ocurre_des') == true)) {
							if (forma_destinatario.getValueField('idoficina_des') == '') {
								mensajeAlert("Se ha seleccionado servicio ocurre debe seleccionar una oficina receptora.");
								return;
							}
						}
						
						/* Trae los datos de la tabla de guia madre */
						var datosGrid = forma_configuraciondados.formToGrid();

						/* Obtenemos el tamaño de la tabla */
						var tamanoGrid = datosGrid.getCount();

						/* En caso de que la tabla de guias no tenga datos */
						if (tamanoGrid == 0 || tamanoGrid == null) {

							Ext.Msg.alert('Verificar', "Por favor asegurese de tener datos en su tabla de guias");

							return;

						}

						/* Variables necesarias */
						var datosStore;
						var forme1;
						var forme2;
						var forme3;
						var forme;
						var cont = 0;

						forma_configuraciondados.activarTxt();

						/* Repetimos el proceso dependiendo del tamaño de la tabla */
						for (cont = 0; cont < tamanoGrid; cont++) {

							/* Usamos el count para iterar los datos dentro de la tabla */
							datosStore = datosGrid.getAt(cont);

							/* Aqui obtenemos todos los datos por medio del nombre
							   y asi le asignamos esevalor a cada textbox del fromulario
							   ya que usar el modelo de datosdirecto del 'datosStore' daba error */
							forma_configuraciondados.updateFieldCte(datosStore.get('_csrf'), '_csrf');
							forma_configuraciondados.updateFieldCte(uuid, 'uuid');
							forma_configuraciondados.updateFieldCte(0, 'idregistro');
							forma_configuraciondados.updateFieldCte(datosStore.get('tiporotulo'), 'tiporotulo');
							forma_configuraciondados.updateFieldCte(datosStore.get('idservicio'), 'idservicio');
							forma_configuraciondados.updateFieldCte(datosStore.get('numpiezas'), 'numpiezas');
							forma_configuraciondados.updateFieldCte(datosStore.get('contenido'), 'contenido');
							forma_configuraciondados.updateFieldCte(datosStore.get('referencia'), 'referencia');
							forma_configuraciondados.updateFieldCte(datosStore.get('nacional'), 'nacional');
							forma_configuraciondados.updateFieldCte(datosStore.get('tipoempaque'), 'tipoempaque');
							forma_configuraciondados.updateFieldCte(datosStore.get('es_multiple'), 'es_multiple');
							forma_configuraciondados.updateFieldCte(datosStore.get('tiene_retorno'), 'tiene_retorno');
							forma_configuraciondados.updateFieldCte(datosStore.get('tiene_seguro'), 'tiene_seguro');
							forma_configuraciondados.updateFieldCte(datosStore.get('valordeclarado'), 'valordeclarado');
							forma_configuraciondados.updateFieldCte(datosStore.get('valor_asegurado'), 'valor_asegurado');
							forma_configuraciondados.updateFieldCte(datosStore.get('pesofisico'), 'pesofisico');
							forma_configuraciondados.updateFieldCte(datosStore.get('largo'), 'largo');
							forma_configuraciondados.updateFieldCte(datosStore.get('alto'), 'alto');
							forma_configuraciondados.updateFieldCte(datosStore.get('ancho'), 'ancho');
							forma_configuraciondados.updateFieldCte(datosStore.get('observacion'), 'observacion');
							forma_configuraciondados.updateFieldCte(datosStore.get('tiene_cita'), 'tiene_cita');
							forma_configuraciondados.updateFieldCte(datosStore.get('fecha_cita'), 'fecha_cita');
							forma_configuraciondados.updateFieldCte(datosStore.get('hora_cita'), 'hora_cita');

							/* Extraemos los datos de los 3 forms y los combinamos en una sola variable */
							forme1 = forma_remitente.getCampoValor();
							forme2 = forma_destinatario.getCampoValor();
							forme3 = forma_configuraciondados.getCampoValor();
							forme = Ext.Object.merge(forme1, forme2, forme3);

							/* Instanciamos la vista de nuevo para poder acceder al metodo */
							var metodo = new MyDesktop.ViewRotuladorEtiquetas;

							/* Mandamos el form combinado el uuid unico y el scope */
							metodo.insertarenGridEtiqueta(forme, uuid, my_scope);


						}/*termina for */

						/* Cerramos la ventana */
						datos_window.close();

					}

				}

			],
			items: [
				forma_remitente,
				forma_destinatario,
				forma_configuraciondados//,

			]
		});

		var datos_window = new Ext.Window({
			width: 760,
			height: 620,
			title: 'Configuración Etiqueta',
			closable: true,
			resizable: false,
			modal: true,

			items: [
				tabs
			],

			headerPosition: 'right'
		});
		datos_window.show();


	},
	actualizar: function() {
		this.grid_etiquetas.buscar(this.uuid);
	},
	eliminar: function() {
		Ext.MessageBox.confirm('Confirmar', 'Desea eliminar los registros seleccionados?',
			function(id, text) {
				if ((id === 'yes') || (id === 'si') || (id === 'y') || (id === 's')) {

				}
			}, this);
	},
	reimprimir: function() {

		var grid_reimpresion = new MyDesktop.grid.GridReimpresionEtiquetas({});


		var datos_window_re = new Ext.Window({
			width: 750,
			height: 400,
			title: 'Reimprimir',
			closable: true,
			layout: 'fit',
			resizable: false,
			modal: true,
			items: [grid_reimpresion],
			headerPosition: 'right',
			buttons: [{
				text: 'imprimir', iconCls: 'print32x32', handler: function() {

					var rows = grid_reimpresion.getRowsSelected();
					if (rows.length <= 0) {
						mensajeAlert("Seleccione el registro que desea reimprimir");
						return;
					}

					var idregistrodatos = '';

					for (i = 0; i < rows.length; i++) {

						if (rows.length == 1) {

							idregistrodatos = rows[i].get('idregistro') + ",";

							break;

						} else if (i == 0) {

							idregistrodatos = rows[i].get('idregistro');

						} else {

							idregistrodatos = idregistrodatos + "," + rows[i].get('idregistro');

						}
					}

					visorPDF('utils-win-vista-pdf_reimpresion' + idregistrodatos,
						"Visor PDF", "./imprime_etiquetas/viewPDFArchivoReimpresion?idregistro=" + idregistrodatos);

				}

			}]
		});
		datos_window_re.show();


	},
	imprimir: function() {
		var myscope = this;
		var rows = this.grid_etiquetas.getRowsSelected();

		var idsUsados = "";

		if (rows.length <= 0) {
			mensajeAlert("Seleccione los registros que desea imprimir");
			return;
		}

		//Obtiene los id
		var idregistrodatos = '';

		for (i = 0; i < rows.length; i++) {

			if (rows[i].get('es_multiple') != "SI") {

				idregistrodatos = idregistrodatos + rows[i].get('idregistrodatos') + ',';

			} else {

				mensajeAlert("<center><h2><b>Guia MULTIPLE detectada.</b></h2></center>"
					+ "<center>Este proceso es unicamente para guias uitarias NO multiples, revise sus guias e intetne de nuevo.</center>");

				return;

			}

		}

		if (idregistrodatos == '') {
			mensajeAlert("Seleccione los registros que desea imprimir");
			return;
		}


		idsUsados = idregistrodatos;

		var tipoenlace = Ext.getCmp('etiquetatipo_estafeta').getGroupValue();


		if (tipoenlace == 'AUTODOC') {
			myscope.ejecuta_imprime(idregistrodatos, tipoenlace, "n");
		} else {
			if (rows.length > 1) {
				mensajeAlert("El tipo de impresion por " + tipoenlace + " " +
					"solo imprimir un registro a la vez, verifique");
				return;
			}
			Ext.MessageBox.confirm('Confirmar', 'Este tipo de impresion solo permite ' +
				' imprimir una guía por linea, ¿Desea Continuar?',
				function(id, text) {
					if ((id === 'yes') || (id === 'si') ||
						(id === 'y') || (id === 's')) {
						myscope.ejecuta_imprime(idregistrodatos, tipoenlace, "n");
					}
				},
				myscope);
		}


		this.grid_etiquetas.recibeIdsUsados(idsUsados);
		myscope.actualizar();
		myscope.grid_etiquetas.getSelectionModel().deselectAll();


	},

	ejecuta_imprime: function(idregistrodatos, tipoenlace, esmadre) {
		var ventana = creaVentanaEspera();
		var conn = new Ext.data.Connection();
		conn.request({
			scope: this,
			url: './imprime_etiquetas/creaDocumengtoEtiqueta',
			timeOut: 9999999,
			timeout: 9999999,
			method: 'POST',
			defaultHeaders: { '_csrf_header': hv, "_csrf": vt },
			params: { idregistro: idregistrodatos, tipoenlace: tipoenlace, "_csrf": vt, esmadre: esmadre },
			success: function(response, opts) {
				ventana.close();
				var obj = Ext.decode(response.responseText);
				if (obj.pdffile != undefined) {
					this.creaOrdenPedido(idregistrodatos, obj.uuid);
				} else {
					mensajeAlert(obj.message);
				}

			},
			failure: function(response, opts) {
				ventana.close();
				if (response.responseText != undefined) {
					var obj = Ext.decode(response.responseText);
					if (obj.message != undefined) {
						mensajeAlert(obj.message);
					}
				}

			}
		});
	},
	creaOrdenPedido: function(idregistrodatos, uuid) {
		var ventana = creaVentanaEspera();
		var conn = new Ext.data.Connection();
		conn.request({
			scope: this,
			url: './api_unigis/crearOrdenesPedido',
			timeOut: 9999999,
			timeout: 9999999,
			method: 'POST',
			defaultHeaders: { '_csrf_header': hv, "_csrf": vt },
			params: { uuid: uuid, "_csrf": vt },
			success: function(response, opts) {
				ventana.close();
				var obj = Ext.decode(response.responseText);
				if (obj.message != undefined || obj.message == "Correcto") {
					//Muestra el PDF
					visorPDF('utils-win-vista-pdf_cotizaciones' + idregistrodatos,
						"Visor PDF", "./imprime_etiquetas/viewPDFArchivo?uuid=" + uuid);
				} else {

					mensajeAlert(obj.message);

				}

			},
			failure: function(response, opts) {
				ventana.close();
				if (response.responseText != undefined) {
					var obj = Ext.decode(response.responseText);
					if (obj.message != undefined) {
						mensajeAlert(obj.message);
					}
				}

			}
		});
	},
	limpiar: function() {
		var myscope = this;
		Ext.MessageBox.confirm('Confirmar', 'Desea limpiar la informacion de la tabla de impresion?',
			function(id, text) {
				if ((id === 'yes') || (id === 'si') || (id === 'y') || (id === 's')) {

					//reinicia el UUID
					myscope.uuid = generateUUID();
					myscope.grid_etiquetas.buscar(myscope.uuid);
				}
			}, this);


	},
	configurarCOD: function() {
		var grid_frecuencia = new MyDesktop.grid.GridCODCobroAmparadoEtiquetas({
			frame: false, border: false, idRotulacion: '', isConsulta: false,
			hidden_cp: true, hidden_garmax: true, flex: 2, layout: 'fit'
		});


		var datos_window = new Ext.Window({
			width: 400,
			height: 400,
			title: 'Configuración COD',
			closable: true,
			layout: 'fit',
			resizable: false,
			modal: true,
			items: [grid_frecuencia],
			headerPosition: 'right'
		});
		datos_window.show();
	},
	seguroAmparado: function() {
		var grid_seguro = new MyDesktop.grid.GridSeguroAmparadoEtiquetas({
			frame: false, border: false, idRotulacion: '', isConsulta: false,
			hidden_cp: true, hidden_garmax: true, flex: 2, layout: 'fit'
		});


		var datos_window = new Ext.Window({
			width: 550,
			height: 400,
			title: 'Seguro Amparado',
			closable: true,
			layout: 'fit',
			resizable: false,
			modal: true,
			items: [grid_seguro],
			headerPosition: 'right'
		});
		datos_window.show();
	},

	insertarenGridEtiqueta: function(forme, uuid, my_scope) {

		try {

			var conn_verifica = new Ext.data.Connection();
			Ext.override(Ext.data.Connection, { timeout: 999999 });
			conn_verifica.request({
				scope: my_scope,
				url: './rotular_etiquetas/validaCoberturaOrigenDestino',
				method: 'POST',
				defaultHeaders: { '_csrf_header': hv, "_csrf": vt },
				params: forme,
				success: function(response, opts) {

					var obj = Ext.decode(response.responseText);

					if (obj.success == false) {
						mensajeAlert(obj.message);
						return;
					}
					var ventana = creaVentanaEspera();
					var conn = new Ext.data.Connection();
					conn.request({
						scope: my_scope,
						url: './rotular_etiquetas/updateRegistroDatos',
						method: 'POST',
						defaultHeaders: { '_csrf_header': hv, "_csrf": vt },
						params: forme,
						success: function(response, opts) {


							ventana.close();

							var obj = Ext.decode(response.responseText);

							my_scope.grid_etiquetas.buscar(uuid);


						},
						failure: function(response, opts) {
							ventana.close();
							if (response.responseText != undefined) {
								var obj = Ext.decode(response.responseText);
								if (obj.message != undefined) {
									mensajeAlert(obj.message);
								}
							}

						}
					});



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



		} catch (error) {

		}

	},
	imprimirGuiaMadre: function() {

		var myscope = this;

		var rowsP = this.grid_etiquetas.getRowsSelected();

		var etiquetasTotalesP = 0;

		var idsUsados = "";

		if (rowsP.length <= 0) {

			mensajeAlert("Seleccione los registros que desea imprimir");

			return;

		}


		for (i = 0; i < rowsP.length; i++) {

			etiquetasTotalesP = etiquetasTotalesP + rowsP[i].get('cantidad_total');

			if (idsUsados == "") {

				if (rowsP.length == 1) {

					idsUsados = rowsP[i].get('idregistrodatos') + ',';

				} else {

					idsUsados = rowsP[i].get('idregistrodatos');

				}

			} else {

				idsUsados = idsUsados + "," + rowsP[i].get('idregistrodatos');

			}

		}

		if (etiquetasTotalesP <= 1) {

			mensajeAlert("Para generar una guia madre se necesitan almenos 2 etiquetas");

			return;

		}

		var REM = rowsP[0].get('razonsocial_rem') + "-" + rowsP[0].get('contacto_rem');
		var DES = rowsP[0].get('razonsocial_des') + "-" + rowsP[0].get('contacto_des');

		/* PARA SEGUROS */
		var tiene_seguro = rowsP[0].get('tiene_seguro');
		var idconvenio = rowsP[0].get('idconvenio');

		/* PARA MULTIPLE */
		var es_multiple = rowsP[0].get('es_multiple');

		for (j = 0; j < rowsP.length; j++) {

			var REMCOMP = rowsP[j].get('razonsocial_rem') + "-" + rowsP[j].get('contacto_rem');
			var DESCOMP = rowsP[j].get('razonsocial_des') + "-" + rowsP[j].get('contacto_des')

			var tiene_seguro_comp = rowsP[j].get('tiene_seguro');

			var idconvenio_comp = rowsP[j].get('idconvenio');

			if ((REM != REMCOMP) || (DES != DESCOMP)) {

				mensajeAlert("<center><h2><b>Remitente o Destinatario distintos.</b></h2></center>"
					+ "<center>Para generar una guia tanto remitente como destinatario deben coincidir en todas las guias hijas.</center>");

				return;

			}
		}

		Ext.MessageBox.confirm('Confirmacion', '<center>!ATENCION¡<center/><br/> Esta a punto de generar una guia madre para sus ' +
			etiquetasTotalesP + ' etiquetas totales, este proceso creara solo su etiqueta de guia madre ' +
			' ,si desea imprimir sus etiquetas individuales debera acceder a ellas por medio del boton de reimprimir.<br/>' +
			'<center>¿Desea continuar con el proceso?<center/>', function(id, text) {
				if ((id === 'yes') || (id === 'si') || (id === 'y') || (id === 's')) {


					//Obtiene los id
					var idregistrodatos = '';

					var rows = myscope.grid_etiquetas.getRowsSelected();

					for (i = 0; i < rows.length; i++) {

						idregistrodatos = idregistrodatos + rows[i].get('idregistrodatos') + ',';

					}

					if (idregistrodatos == '') {


						mensajeAlert("Seleccione los registros que desea imprimir");

						return;

					}

					var tipoenlace = Ext.getCmp('etiquetatipo_estafeta').getGroupValue();

					if (tipoenlace == 'AUTODOC') {

						myscope.ejecuta_imprime(idregistrodatos, tipoenlace, "s");
						this.grid_etiquetas.recibeIdsUsados(idsUsados);
						myscope.actualizar();
						myscope.grid_etiquetas.getSelectionModel().deselectAll();

					} else {

						if (rows.length > 1) {

							mensajeAlert("El tipo de impresion por " + tipoenlace + " " +
								"solo imprimir un registro a la vez, verifique");

							return;

						}

						Ext.MessageBox.confirm('Confirmar', 'Este tipo de impresion solo permite ' +
							' imprimir una guía por linea, ¿Desea Continuar?',
							function(id, text) {
								if ((id === 'yes') || (id === 'si') ||
									(id === 'y') || (id === 's')) {
									myscope.ejecuta_imprime(idregistrodatos, tipoenlace, "s");
									this.grid_etiquetas.recibeIdsUsados(idsUsados);
									myscope.actualizar();
									myscope.grid_etiquetas.getSelectionModel().deselectAll();
								}
							},
							myscope);
					}

				}

			}, this);

	},
	imprimirGuiaMultiple: function() {

		var myscope = this;

		var rowsP = this.grid_etiquetas.getRowsSelected();

		var etiquetasTotalesP = 0;

		var idsUsados = "";

		if (rowsP.length <= 0) {

			mensajeAlert("Seleccione los registros que desea imprimir");

			return;

		}


		for (i = 0; i < rowsP.length; i++) {

			etiquetasTotalesP = etiquetasTotalesP + rowsP[i].get('cantidad_total');

			if (idsUsados == "") {

				if (rowsP.length == 1) {

					idsUsados = rowsP[i].get('idregistrodatos') + ',';

				} else {

					idsUsados = rowsP[i].get('idregistrodatos');

				}

			} else {

				idsUsados = idsUsados + "," + rowsP[i].get('idregistrodatos');

			}

		}

		if (etiquetasTotalesP <= 1) {

			mensajeAlert("Para generar una guia multiple se necesitan almenos 2 etiquetas");

			return;

		}

		var REM = rowsP[0].get('razonsocial_rem') + "-" + rowsP[0].get('contacto_rem');
		var DES = rowsP[0].get('razonsocial_des') + "-" + rowsP[0].get('contacto_des');

		/* PARA SEGUROS */
		var tiene_seguro = rowsP[0].get('tiene_seguro');
		var idconvenio = rowsP[0].get('idconvenio');

		/* PARA MULTIPLE */
		var pesovolu = rowsP[0].get('pesovolumetrico_total');
		var pesofis = rowsP[0].get('pesofisico_total');

		for (j = 0; j < rowsP.length; j++) {

			var REMCOMP = rowsP[j].get('razonsocial_rem') + "-" + rowsP[j].get('contacto_rem');
			var DESCOMP = rowsP[j].get('razonsocial_des') + "-" + rowsP[j].get('contacto_des')

			var tiene_seguro_comp = rowsP[j].get('tiene_seguro');

			var idconvenio_comp = rowsP[j].get('idconvenio');

			if ((REM == REMCOMP) && (DES == DESCOMP)) {

				if (rowsP[j].get('es_multiple') == "NO") {

					mensajeAlert("<center><h2><b>Guia NO multiple detectada.</b></h2></center>"
						+ "<center>Este proceso es unicamente para guias multiples, revise sus guias e intetne de nuevo.</center>");

					return;

				}

				if (idconvenio != idconvenio_comp) {

					mensajeAlert("<center><h2><b>Servicios Diferentes.</b></h2></center>"
						+ "<center>Para una guia multiple es necesario que todas las guias esten ligadas al mismo servicio de envio.</center>");

					return;

				}

				if ((pesovolu != rowsP[j].get('pesovolumetrico_total')) || (pesofis != rowsP[j].get('pesofisico_total'))) {

					mensajeAlert("<center><h2><b>Diferencia de Pesos.</b></h2></center>"
						+ "<center>Para una guia multiple es necesario que todas las guias cuenten con el mismo peso fisico y volumetrico.</center>");

					return;

				}

			} else {

				mensajeAlert("<center><h2><b>Remitente o Destinatario distintos.</b></h2></center>"
					+ "<center>Para generar una guia tanto remitente como destinatario deben coincidir en todas las guias hijas.</center>");

				return;

			}
		}

		Ext.MessageBox.confirm('Confirmacion', '<center>!ATENCION¡<center/><br/> Esta a punto de generar guias multiples para sus ' +
			etiquetasTotalesP + ' etiquetas totales.<br/><br/>' +
			'<center>¿Desea continuar con el proceso?<center/>', function(id, text) {
				if ((id === 'yes') || (id === 'si') || (id === 'y') || (id === 's')) {


					//Obtiene los id
					var idregistrodatos = '';

					var rows = myscope.grid_etiquetas.getRowsSelected();

					for (i = 0; i < rows.length; i++) {

						idregistrodatos = idregistrodatos + rows[i].get('idregistrodatos') + ',';

					}

					if (idregistrodatos == '') {


						mensajeAlert("Seleccione los registros que desea imprimir");

						return;

					}

					var tipoenlace = Ext.getCmp('etiquetatipo_estafeta').getGroupValue();

					if (tipoenlace == 'AUTODOC') {

						myscope.ejecuta_imprime(idregistrodatos, tipoenlace, "n");
						this.grid_etiquetas.recibeIdsUsados(idsUsados);
						myscope.actualizar();
						myscope.grid_etiquetas.getSelectionModel().deselectAll();

					} else {

						if (rows.length > 1) {

							mensajeAlert("El tipo de impresion por " + tipoenlace + " " +
								"solo imprimir un registro a la vez, verifique");

							return;

						}

						Ext.MessageBox.confirm('Confirmar', 'Este tipo de impresion solo permite ' +
							' imprimir una guía por linea, ¿Desea Continuar?',
							function(id, text) {
								if ((id === 'yes') || (id === 'si') ||
									(id === 'y') || (id === 's')) {
									myscope.ejecuta_imprime(idregistrodatos, tipoenlace, "n");
									this.grid_etiquetas.recibeIdsUsados(idsUsados);
									myscope.actualizar();
									myscope.grid_etiquetas.getSelectionModel().deselectAll();
								}
							},
							myscope);
					}

				}

			}, this);

	}
});
