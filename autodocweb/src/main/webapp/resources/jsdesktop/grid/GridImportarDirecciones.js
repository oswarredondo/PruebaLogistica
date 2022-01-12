/**
 * Grid para la consulta de historia o mivimientos de un pedido, guia,
 * solicitud, etc
 */
Ext
		.define(
				'MyDesktop.grid.GridImportarDirecciones',
				{
					extend : 'Ext.grid.Panel',
					requires : [ 'Ext.grid.column.Action',
							'Ext.grid.plugin.CellEditing',
							'Ext.form.field.Text', 'Ext.toolbar.TextItem' ],
					stateful : true,
					collapsible : false,
					multiSelect : true,
					showBtnSalvar : false,
					stateId : 'stateGridImportarDirecciones',
					viewConfig : {
						stripeRows : false,
						enableTextSelection : true,
						getRowClass : function(record) {

							var color = "";

							var tipoDireccion = record.get('tipoDireccion');
							var rfc = record.get('rfc');
							var calle = record.get('calle');
							var numExterior = record.get('numexterior');
							var cp = record.get('cp');
							var colonia = record.get('colonia');
							var municipio = record.get('municipio');

							if (this.mensajeEstatus == undefined) {

								this.mensajeEstatus = true;

							}

							if (tipoDireccion == "" || rfc == "" || calle == ""
									|| numExterior == "" || cp == ""
									|| colonia == "" || municipio == "") {

								color = 'child-row';

								if (this.mensajeEstatus) {

									mensajeAlert('Algunos registros no cumplen con los datos obligatorios, revise su archivo porfavor');

									Ext.getCmp('idAgregar').disable();

									this.mensajeEstatus = false;
								}

							} else {

								if (this.mensajeEstatus) {

									Ext.getCmp('idAgregar').enable();

								}

							}

							return color;

						}
					},
					mensajeEstatus : true,
					idfolio : '',
					url : '',
					isConsulta : true,
					mainwindow : undefined,
					tipo_str : undefined,
					patron_busqueda : undefined,
					tipo : undefined,
					combo_tipos_busqueda : undefined,
					combo_modalidad : undefined,
					combo_usuarios : undefined,
					initComponent : function() {

						var myScope = this;
						this.loadMask = true;
						this.store = Ext
								.create(
										'MyDesktop.store.StoreCarteraDirecciones',
										{
											autoLoad : false,
											proxy : {
												type : 'ajax',
												api : {
													read : './rotular_etiquetas/carteraremdes/getDireccionesImport',
													destroy : './rotular_etiquetas/carteraremdes/deleteJson'
												},
												reader : {
													type : 'json',
													successProperty : 'success',
													root : 'proxiArray',
													messageProperty : 'message',
													totalProperty : 'totalCount',
												},
												writer : {
													type : 'json',
													writeAllFields : true,
													encode : false,
													root : 'proxiArray'
												}
											}

										});

						this.columns = [ {
							header : 'Usuario',
							width : 100,
							sortable : true,
							hidden : false,
							dataIndex : 'numCliente',
						}, {
							header : 'Tipo',
							width : 100,
							sortable : true,
							hidden : false,
							dataIndex : 'tipoDireccion'
						}, {
							header : 'R.F.C',
							width : 100,
							sortable : true,
							hidden : false,
							dataIndex : 'rfc'
						}, {
							header : 'Razon Social',
							width : 100,
							sortable : true,
							hidden : false,
							dataIndex : 'razonSocial'
						}, {
							header : 'Atención',
							width : 100,
							sortable : true,
							hidden : false,
							dataIndex : 'atencion'
						}, {
							header : 'Calle',
							width : 100,
							sortable : true,
							hidden : false,
							dataIndex : 'calle'
						}, {
							header : '#Interior',
							width : 100,
							sortable : true,
							hidden : false,
							dataIndex : 'numinterior'
						}, {
							header : '#Exterior',
							width : 100,
							sortable : true,
							hidden : false,
							dataIndex : 'numexterior'
						}, {
							header : 'Colonia',
							width : 100,
							sortable : true,
							hidden : false,
							dataIndex : 'colonia'
						}, {
							header : 'Ciudad',
							width : 100,
							sortable : true,
							hidden : false,
							dataIndex : 'ciudad'
						}, {
							header : 'Municipio',
							width : 100,
							sortable : true,
							hidden : false,
							dataIndex : 'municipio'
						}, {
							header : 'Estado',
							width : 100,
							sortable : true,
							hidden : false,
							dataIndex : 'estado'
						}, {
							header : 'C.P',
							width : 100,
							sortable : true,
							hidden : false,
							dataIndex : 'cp'
						}, {
							header : 'Telefono',
							width : 100,
							sortable : true,
							hidden : false,
							dataIndex : 'telefono'
						}, {
							header : 'Celular',
							width : 100,
							sortable : true,
							hidden : false,
							dataIndex : 'numcelular'
						}, {
							header : 'Correo',
							width : 100,
							sortable : true,
							hidden : false,
							dataIndex : 'correoe'
						}

						];

						this.bbar = [

								{
									text : 'Guardar Direcciones',
									iconCls : 'activo',
									id : 'idAgregar',
									disabled : true,
									handler : this.agregar,
									scope : myScope
								},
								{
									xtype : 'tbfill'
								},
								{
									text : 'Importar Archivo de Excel',
									iconCls : 'excel_blue',
									scope : myScope,
									handler : function() {

										Ext.MessageBox
												.confirm(
														'Confirmacion',
														'<p><center>La información actual será sustituida por '
																+ 'la que desea importar, desea continuar?</p></center>'
																+ '<p><center>Recuerda que solo se pueden leer un <b>maximo de 500 lineas.</b></p></center>',
														function(id, text) {

															if ((id === 'yes')
																	|| (id === 'si')
																	|| (id === 'y')
																	|| (id === 's')) {

																// Crea una
																// forma de
																// clientes para
																// agregar los
																// datos
																var forma_attachment = Ext
																		.create(
																				'MyDesktop.form.FormUploadAttachment',
																				{
																					identificador : this.uuid,
																					idtipodocumento : this.idservicio,
																					gridscope : this,
																					sendJSON : true,
																					// url:'./rotular_etiquetas_importar/uploadEnviosExcel',
																					url : './rotular_etiquetas/carteraremdes/uploadRowsJsonFile',
																					descripcion_file : 'IMPORTAR ARCHIVO'
																				});

																var winimport = Ext
																		.create(
																				'widget.window',
																				{
																					// id:'utils-win-agregar-cliente-attachment',
																					title : "Importar Archivo",
																					width : 450,
																					iconCls : 'editar',
																					height : 200,
																					modal : true,
																					plain : true,
																					layout : 'fit',
																					items : forma_attachment

																				});
																forma_attachment
																		.setWinImport(winimport);
																winimport
																		.show();

															}

														}, this);
									},
									tooltip : 'Importa Datos de un archivo de Excel para registrar'
								},

						];

						this.callParent();

					},
					filtraInfo : function() {

						if (this.patron_busqueda.getValue() == '') {
							mensajeAlert("Debe indicar el patrón a buscar");
							return;
						}

						if (this.combo_usuarios.getValue() == ''
								|| this.combo_usuarios.getValue() == null) {
							mensajeAlert("Debe indicar el usuario a buscar");
							return;
						}

						this
								.getView()
								.getStore()
								.reload(
										{
											params : {
												numcliente : this.combo_usuarios
														.getValue(),
												tipo : this.combo_tipos_busqueda
														.getValue(),
												patron_busqueda : this.patron_busqueda
														.getValue(),
												tipo_str : this.combo_modalidad
														.getValue()
											},
											callback : function(r, options,
													success) {
												if (r.length <= 0) {
													mensajeWarning('No existe información con el criterio de busqueda selecionado.');

												}
											}
										});
					},
					agregar : function() {

						Ext.MessageBox
								.confirm(
										'Confirmacion',
										'<p><center>La información actual será registrada a sus respectivos usuario, '
												+ 'si algun dato ya se encuentra registrado para el usuario, este sera omitido, desea continuar?</p></center>'
												+ '<p><center>Recuerda que solo se pueden insertar un <b>maximo de 500 lineas, si su archivo contiene mas '
												+ 'solo seran tomadas en cuenta las primeras 500 lineas. </b></p></center>',
										function(id, text) {

											if ((id === 'yes') || (id === 'si')
													|| (id === 'y')
													|| (id === 's')) {

												this.setLoading('Insertando datos');

												var conn = new Ext.data.Connection();
												conn
														.request({
															scope : this,
															method : 'POST',
															defaultHeaders : {
																'_csrf_header' : hv,
																"_csrf" : vt
															},
															params : {
																tipo : "masivo",
																"_csrf" : vt
															},
															timeout : 999999,
															url : './rotular_etiquetas/carteraremdes/insert',
															success : function(
																	response,
																	opts) {

																var obj = Ext
																		.decode(response.responseText);
																mensajeAlert(obj.message);
																this
																		.setLoading(false);
																this
																		.reloadInfo();
																Ext
																		.getCmp(
																				'idAgregar')
																		.disable();
																mensajeConfirm('<p><center>Direcciones agregadas correctamente a sus respectivos usuarios.</p></center>');

															},
															failure : function(
																	response,
																	opts) {
																if (response.responseText != undefined) {
																	var obj = Ext
																			.decode(response.responseText);
																	if (obj.message != undefined) {
																		this
																				.setLoading(false);
																		mensajeAlert(obj.message);
																	}
																}

															}
														});

											}

										}, this);

					},

					loadInfo : function() {
						this.getView().getStore().load();

					},
					reloadInfo : function() {
						this.getView().getStore().reload();

					},
					getRowsSelected : function() {
						return this.getView().getSelectionModel()
								.getSelection();
					},

					setScopeWin : function(win) {
						this.mainwindow = win;
					},
					commitInfo : function() {
						this.getView().getStore().save();
						this.getView().getStore().commitChanges();

					},
					loadInfoCierra : function(ventana_principal) {
						var ventana = creaVentanaEspera("Desplegando informacion, espere ...");
						this.mensajeEstatus = true;
						this.store.reload({
							// params:{},
							callback : function(r, options, success) {
								// ventana.close();
								// if (ventana_principal!=undefined){
								// ventana_principal.close();
								// }
							}
						});

						ventana.close();
						if (ventana_principal != undefined) {
							ventana_principal.close();
						}

						this.getView().mensajeEstatus = true;
					}
				});
