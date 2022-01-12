Ext
		.define(
				'MyDesktop.view.FormCotizacion',
				{
					extend : 'Ext.form.Panel',
					xtype : 'register-form',

					frame : false,
					border : false,
					bodyPadding : 10,
					autoScroll : true,
					width : 355,
					myscope : undefined,
					showReadOnly : false,
					operacion : undefined,
					idconvenio : undefined,
					fieldDefaults : {
						labelAlign : 'right',
						labelWidth : 115,
						msgTarget : 'side'
					},
					scope_view_pricipal : undefined,
					winprincipal : undefined,
					initComponent : function() {
						var operacion_aplicar = this.operacion;
						var iseditablle = this.operacion == 'update' ? true
								: false;

						this.myscope = this;
						var scope_grid_pricipal = this.scope_view_pricipal;
						var mainscope_win = this;
						this.buttons = [
								{
									hidden : this.showReadOnly,
									text : 'Limpiar',
									iconCls : 'limpiar_white',
									scope : this,
									handler : function() {
										var form = this.getForm();
										form.reset();
									}
								},
								{
									hidden : this.showReadOnly,
									text : 'Salvar',
									disabled : true,
									formBind : true,
									iconCls : 'activo',
									handler : function() {
										var form = this.up('form').getForm();
										if (form.isValid()) {
											var out = [];
											Ext.Object.each(form.getValues(),
													function(key, value) {
														out.push(key + '='
																+ value);
													});
											var myMask = new Ext.LoadMask(
													Ext.getBody(),
													{
														msg : "Agregando información espere..."
													});
											myMask.show();

											form
													.submit({
														clientValidation : true,
														url : '../cotizacionpreconvenio/'
																+ operacion_aplicar,
														success : function(
																form, action) {
															myMask.hide();
															myMask.disable();

															if (operacion_aplicar == 'update') {
																if (scope_grid_pricipal != undefined) {
																	scope_grid_pricipal
																			.filtrar();
																}

															}

															if (operacion_aplicar == 'insert') {
																form.reset();
															}

															if (mainscope_win.winprincipal != undefined) {
																mainscope_win.winprincipal
																		.close();
															}

															if (action.result.cotizacion != undefined) {
																alertMsg(
																		'Confirmación',
																		"Se creo la cotización:"
																				+ action.result.cotizacion);
															} else {
																alertMsg(
																		'Confirmación',
																		action.result.message);
															}

														},
														failure : function(
																form, action) {
															myMask.hide();
															myMask.disable();
															if ((action.result != undefined)
																	&& (action.result.message != undefined)) {
																alertMsg(
																		'Error',
																		action.result.message);
															} else {
																// Busca si
																// existe un
																// response del
																// servier
																if (action.response.responseText != null) {
																	alertMsg(
																			action.response.statusText,
																			action.response.responseText);
																}
															}

														}
													});

										} else {
											alertMsg('Verifique',
													'Complete los campos requeridos.');
										}
									}
								} ];
						this.myscope = this;
						this.items = [ {
							xtype : 'fieldset',
							title : 'Datos Generales',
							defaultType : 'textfield',
							defaults : {
								anchor : '100%'
							},
							items : [ {
								xtype : 'hidden',
								allowBlank : true,
								fieldLabel : 'idconvenio',
								name : 'idconvenio',
								readOnly : true
							}, {
								xtype : 'hidden',
								allowBlank : true,
								fieldLabel : 'idcliente',
								name : 'idcliente',
								readOnly : true
							},

							// { xtype: 'hidden', allowBlank:false, fieldLabel:
							// 'Ref. búsqueda', name:
							// 'nombre',enforceMaxLength:true,maxLength:40 },
							// {xtype: 'datefield',fieldLabel: 'Fecha
							// Cotización',name: 'fechadocumento',allowBlank:
							// false,maxValue: new Date(),readOnly:iseditablle},
							{
								xtype : 'fieldcontainer',
								labelStyle : 'font-weight:bold;padding:0',
								layout : 'hbox',
								emptyText : 'Cliente',
								defaultType : 'textfield',
								fieldDefaults : {
								// labelAlign: 'top'
								},
								items : [ {
									xtype : 'hidden',
									flex : 3,
									name : 'numcliente',
									width : 100,
									margins : '0 0 0 1'
								}, {
									xtype : 'myUpperCaseTextField',
									flex : 3,
									fieldLabel : 'Razón Social',
									name : 'razonsocial_cte',
									width : 100,
									margins : '0 0 0 0',
									enforceMaxLength : true,
									maxLength : 50,
									readOnly : true
								}, {
									xtype : 'button',
									flex : 1,
									width : 80,
									margins : '0 0 0 5',
									iconCls : 'buscar_white',
									text : 'Buscar',
									scope : this.myscope,
									disabled : iseditablle,
									handler : function() {
										// Muestra el grid para la seccion de
										// los clientes
										this.consultaclientes();
									}
								} ]
							}, {
								xtype : 'myUpperCaseTextField',
								flex : 1,
								fieldLabel : 'R.F.C',
								name : 'rfc',
								width : 100,
								margins : '0 0 0 5',
								enforceMaxLength : true,
								maxLength : 40,
								readOnly : true
							},

							{
								xtype : 'fieldcontainer',
								labelStyle : 'font-weight:bold;padding:0',
								layout : 'hbox',
								emptyText : 'Cliente',
								defaultType : 'textfield',
								fieldDefaults : {
								// labelAlign: 'top'
								},
								items : [ {
									xtype : 'myUpperCaseTextField',
									flex : 3,
									fieldLabel : 'Contacto',
									name : 'contacto_cte',
									width : 100,
									margins : '0 0 0 0',
									enforceMaxLength : true,
									maxLength : 40,
									readOnly : true
								}, {
									xtype : 'button',
									flex : 1,
									width : 80,
									margins : '0 0 0 5',
									iconCls : 'buscar_white',
									text : 'Buscar',
									scope : this.myscope,
									disabled : iseditablle,
									handler : function() {
										// Muestra el grid para la seccion de
										// los clientes
										this.consultacontactos();
									}
								} ]
							}, {
								xtype : 'myUpperCaseTextField',
								flex : 1,
								fieldLabel : 'Calle',
								name : 'calle_cte',
								width : 100,
								margins : '0 0 0 5',
								enforceMaxLength : true,
								maxLength : 40,
								allowBlank : false,
								readOnly : true
							}, {
								xtype : 'myUpperCaseTextField',
								flex : 1,
								fieldLabel : 'Num.Exterior',
								name : 'numexterior_cte',
								width : 100,
								margins : '0 0 0 5',
								enforceMaxLength : true,
								maxLength : 10,
								readOnly : true
							}, {
								xtype : 'myUpperCaseTextField',
								flex : 1,
								fieldLabel : 'Num.Interior',
								name : 'numinterior_cte',
								width : 100,
								margins : '0 0 0 5',
								enforceMaxLength : true,
								maxLength : 10,
								readOnly : true
							}, {
								xtype : 'fieldcontainer',
								labelStyle : 'font-weight:bold;padding:0',
								layout : 'hbox',
								emptyText : 'C.P',
								defaultType : 'textfield',
								fieldDefaults : {
								// labelAlign: 'top'
								},
								items : [

								{
									xtype : 'myUpperCaseTextField',
									flex : 3,
									fieldLabel : 'C.P',
									name : 'cp_cte',
									width : 100,
									margins : '0 0 0 0',
									enforceMaxLength : true,
									maxLength : 5,
									allowBlank : false,
									readOnly : true
								} // ,
								// { xtype:'button', flex: 1,width:80, margins:
								// '0 0 0 5',
								// iconCls:'buscar_white',text:'Buscar',scope:this.myscope,id:'btnBuscarCP_'+this.id,
								// handler:this.showGridCps}
								]
							},

							{
								xtype : 'fieldcontainer',
								labelStyle : 'font-weight:bold;padding:0',
								layout : 'hbox',
								emptyText : 'Colonia',
								defaultType : 'textfield',
								fieldDefaults : {
								// labelAlign: 'top'
								},
								items : [

								{
									xtype : 'myUpperCaseTextField',
									flex : 3,
									fieldLabel : 'Colonia',
									name : 'colonia_cte',
									width : 100,
									margins : '0 0 0 0',
									enforceMaxLength : true,
									maxLength : 50,
									allowBlank : false,
									readOnly : true
								} // ,
								// { xtype:'button', flex: 1,width:80, margins:
								// '0 0 0 5',
								// iconCls:'buscar_white',text:'Buscar',scope:this.myscope,id:'btnBuscarColonia_'+this.id,
								// handler:this.showGridCps}
								]
							}, {
								xtype : 'fieldcontainer',
								labelStyle : 'font-weight:bold;padding:0',
								layout : 'hbox',
								emptyText : 'Municipio',
								defaultType : 'textfield',
								fieldDefaults : {
								// labelAlign: 'top'
								},
								items : [

								{
									xtype : 'myUpperCaseTextField',
									flex : 3,
									fieldLabel : 'Municipio',
									name : 'municipio_cte',
									width : 100,
									margins : '0 0 0 0',
									enforceMaxLength : true,
									maxLength : 50,
									allowBlank : false,
									readOnly : true
								} // ,
								// { xtype:'button', flex: 1,width:80, margins:
								// '0 0 0 5',
								// iconCls:'buscar_white',text:'Buscar',scope:this.myscope,id:'btnBuscarMunicipio_'+this.id,
								// handler:this.showGridCps}
								]
							}, {
								xtype : 'myUpperCaseTextField',
								flex : 1,
								fieldLabel : 'Estado',
								name : 'estado_cte',
								width : 100,
								margins : '0 0 0 0',
								enforceMaxLength : true,
								maxLength : 40,
								readOnly : true
							}, {
								xtype : 'myUpperCaseTextField',
								flex : 1,
								fieldLabel : 'Teléfono',
								name : 'telefono_cte',
								width : 100,
								margins : '0 0 0 0',
								enforceMaxLength : true,
								maxLength : 40,
								readOnly : true
							}, {
								xtype : 'myUpperCaseTextField',
								flex : 1,
								fieldLabel : 'Móvil',
								name : 'movil_cte',
								width : 100,
								margins : '0 0 0 0',
								enforceMaxLength : true,
								maxLength : 40,
								readOnly : true
							}, {
								xtype : 'textfield',
								vtype : 'email',
								flex : 1,
								fieldLabel : 'Email',
								name : 'email_cte',
								width : 100,
								margins : '0 0 0 0',
								enforceMaxLength : true,
								maxLength : 40,
								readOnly : true
							},

							// PARA SEGUROS
							{
								xtype : 'fieldcontainer',
								labelStyle : 'font-weight:bold;padding:0',
								layout : 'hbox',
								emptyText : 'Cliente',
								defaultType : 'textfield',
								fieldDefaults : {
								// labelAlign: 'top'
								},
								items : [ 
								 {
								xtype : 'checkboxfield',
								name : 'asegura',
								id: 'id_tiene_seguro',
								fieldLabel : 'Asegura?',
								boxLabel : '',
								listeners: {
									 change: function() {
										 
										 var check = Ext.getCmp('id_tiene_seguro').checked;
										 
										 if(check){
											 
											 Ext.getCmp('id_valor_asegurado').enable();
											 Ext.getCmp('btnSeguros').enable();
											 Ext.getCmp('id_valor_asegurado').setValue('0.05');
											 Ext.getCmp('idciaseguro').allowBlank = false;
											 Ext.getCmp('idciaseguro').validate();
											 
										 }else{
											 
											 Ext.getCmp('id_valor_asegurado').disable();
											 Ext.getCmp('btnSeguros').disable();
											 Ext.getCmp('id_valor_asegurado').setValue('0.00');
											 Ext.getCmp('idciaseguro').setValue('');
											 Ext.apply(idciaseguro,{allowBlank:true});
											 Ext.getCmp('idciaseguro').allowBlank = true;
											 Ext.getCmp('idciaseguro').validate();
											 
										 }
									 }
								}
							}, {
								xtype : 'numberfield',
								name : 'porcentaje_seguro',
								id : 'id_valor_asegurado',
								fieldLabel : 'Valor en %',
								allowBlank : false,
								flex : 1,
								width : 80,
								value : 0.00,
								minValue : 0.00,
								maxValue : 100,
								allowDecimals : true,
								decimalPrecision : 2,
								decimalSeparator : '.',
								disabled: true
							}, ]
							}

							]
						},

						{
							xtype : 'fieldset',
							title : 'Datos Tarifa/Descuento',
							defaultType : 'textfield',
							defaults : {
								anchor : '100%'
							},
							items : [ {
								xtype : 'checkboxfield',
								name : 'tipo_precios',
								fieldLabel : 'Precios',
								boxLabel : 'Toda la lista de precios'
							}, {
								xtype : 'fieldcontainer',
								labelStyle : 'font-weight:bold;padding:0',
								layout : 'hbox',
								emptyText : 'Tarifa',
								defaultType : 'textfield',
								fieldDefaults : {
									labelAlign : 'top'
								},
								items : [ {
									xtype : 'myUpperCaseTextField',
									flex : 1,
									name : 'idtarifa',
									margins : '0 0 0 5',
									allowBlank : false,
									readOnly : true
								},

								{
									xtype : 'myUpperCaseTextField',
									flex : 2,
									name : 'descripcionTarifarango',
									allowBlank : false,
									margins : '0 0 0 5',
									enforceMaxLength : true,
									maxLength : 40,
									readOnly : true
								}, {
									xtype : 'button',
									flex : 1,
									margins : '0 0 0 5',
									width : 80,
									iconCls : 'tarifas_white',
									text : 'Tarifas',
									scope : this.myscope,
									disabled : iseditablle,
									handler : function() {
										// Muestra el grid para la seccion de
										// los descuentos
										this.consultatarifas();
									}
								} ]
							}, {
								xtype : 'fieldcontainer',
								labelStyle : 'font-weight:bold;padding:0',
								layout : 'hbox',
								emptyText : 'Tarifa',
								defaultType : 'textfield',
								fieldDefaults : {
									labelAlign : 'top'
								},
								items : [ {
									xtype : 'myUpperCaseTextField',
									flex : 1,
									name : 'idrangoenvios',
									margins : '0 0 0 5',
									allowBlank : false,
									readOnly : true
								}, {
									xtype : 'myUpperCaseTextField',
									flex : 2,
									name : 'rangoenvios',
									allowBlank : false,
									margins : '0 0 0 5',
									enforceMaxLength : true,
									maxLength : 50,
									readOnly : false
								}, {
									xtype : 'button',
									flex : 1,
									margins : '0 0 0 5',
									width : 80,
									iconCls : 'detalles_white',
									text : 'Rangos',
									scope : this.myscope,
									disabled : false,
									handler : function() {
										// Muestra el grid para la seccion de
										// los descuentos
										this.consultarangosenvios();
									}
								} ]
							}, {
								xtype : 'fieldcontainer',
								labelStyle : 'font-weight:bold;padding:0',
								layout : 'hbox',
								emptyText : 'Descuento',
								defaultType : 'textfield',
								fieldDefaults : {
									labelAlign : 'top'
								},
								items : [ {
									xtype : 'myUpperCaseTextField',
									flex : 1,
									name : 'iddescuento',
									margins : '0 0 0 5',
									allowBlank : true,
									readOnly : true
								},

								{
									xtype : 'myUpperCaseTextField',
									flex : 2,
									name : 'descripcionDescuento',
									allowBlank : true,
									margins : '0 0 0 5',
									enforceMaxLength : true,
									maxLength : 40,
									readOnly : true
								}, {
									xtype : 'button',
									flex : 1,
									margins : '0 0 0 5',
									width : 80,
									iconCls : 'descuentos_white',
									text : 'Descuentos',
									scope : this.myscope,
									disabled : false,
									handler : function() {
										// Muestra el grid para la seccion de
										// los descuentos
										this.consultadescuentos();
									}
								} ]
								
							},
							{
								xtype : 'fieldcontainer',
								labelStyle : 'font-weight:bold;padding:0',
								layout : 'hbox',
								emptyText : 'Tarifa',
								defaultType : 'textfield',
								fieldDefaults : {
									labelAlign : 'top'
								},
								items : [ 
//								          {
//									xtype : 'myUpperCaseTextField',
//									flex : 1,
//									name : 'idciaseguro',
//									margins : '0 0 0 5',
//									allowBlank : false,
//									readOnly : true
//								}, 
								{
									xtype : 'myUpperCaseTextField',
									flex : 3,
									name : 'nombre_seguro',
									id : 'idciaseguro',
									allowBlank : true,
									margins : '0 0 0 5',
									enforceMaxLength : true,
									maxLength : 100,
									readOnly : true
								}, {
									xtype : 'button',
									id : 'btnSeguros',
									flex : 1,
									margins : '0 0 0 5',
									width : 80,
									iconCls : 'lista_white',
									text : 'Seguros',
									scope : this.myscope,
									disabled : true,
									handler : function() {
										// Muestra el grid para la seccion de
										// los descuentos
										this.consultaSeguros();
									}
								} ]
							}]
						},

						];

						this.callParent();
					},

					updateCampos : function(record) {
						// alert(Ext.getCmp(this.id));
						var fields = Ext.getCmp(this.id).getForm().getFields();
						this.updateFieldName(record, fields);

					},
					updateFieldName : function(record, fields) {
						var items = fields.items;
						var valor = "";
						for (i = 0; i < items.length; i++) {
							field = items[i];
							if (field != undefined) {
								if (field.getName() != undefined) {
									// busca el nombre del campo que debe ser el
									// mismo del nombre del campo de
									// la forma
									valor = record.get(field.getName());
									if (valor != undefined) {
//										 alert('Campo:' + field.getName() + ', valor:' +valor);
//										if(field.getName() == 'tiene_seguro'){
//											alert(valor);
//										}
										field.setValue(valor);
									} else {
										field.setValue("");
									}

								}
							}
						}
					},
					updateFieldReadOnly : function(record) {

						// alert(Ext.getCmp(this.id));
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
					updateFieldCte : function(valor, campo) {
						var fields = Ext.getCmp(this.id).getForm().getFields();

						var items = fields.items;
						for (i = 0; i < items.length; i++) {
							field = items[i];
							if (field != undefined) {
								if ((field.getName() != undefined)
										&& (field.getName() == campo)) {
									field.setValue(valor);
								}
							}
						}
					},
					getValueField : function(campo) {
						var fields = Ext.getCmp(this.id).getForm().getFields();
						var valor = '';
						var items = fields.items;
						for (i = 0; i < items.length; i++) {
							field = items[i];
							if (field != undefined) {
								if ((field.getName() != undefined)
										&& (field.getName() == campo)) {
									valor = field.getValue();
								}
							}
						}
						return valor;
					},
					consultacontactos : function() {
						var mysope = this;

						var idcliente = mysope.getValueField('idcliente');
						var razonsocial_cte = mysope
								.getValueField('razonsocial_cte');
						if ((idcliente == undefined) || (idcliente == '')) {
							mensajeWarning("Seleccione un cliente del catalogo");
							return;
						}

						// Crea una forma de clientes para agregar los datos
						var grid_cte_contacto_cotizacion_consulta = Ext.create(
								'MyDesktop.view.GridContactos', {
									id : 'grid_consulta_contacto_clientes_dir',
									idCliente : idcliente,
									isConsulta : true,
									isAutoLoad : false
								});
						grid_cte_contacto_cotizacion_consulta
								.setIdCliente(idcliente);
						grid_cte_contacto_cotizacion_consulta.reload(idcliente);
						grid_cte_contacto_cotizacion_consulta
								.getStore()
								.reload(
										{
											params : {
												idcliente : idcliente
											},
											callback : function(r, options,
													success) {
												if (r.length <= 0) {
													mensajeAlert('No existen contactos disponibles');
												}
											}
										});

						var windows_consulta_contactos = Ext
								.create(
										'widget.window',
										{
											id : 'utils-win-consultar-clientes-cotizaciones-disponibles',
											title : "Contactos Cliente "
													+ razonsocial_cte,
											width : 1000,
											height : 400,
											modal : true,
											plain : true,
											layout : 'fit',
											iconCls : 'contactos_blue',
											items : grid_cte_contacto_cotizacion_consulta,
											buttons : [ {
												iconCls : 'seleccionar_white',
												text : 'Seleccionar',
												handler : function() {
													var registro = grid_cte_contacto_cotizacion_consulta
															.getRegistro();
													if (registro != undefined) {
														mysope
																.updateFieldCte(
																		registro
																				.get('nombre')
																				+ " "
																				+ registro
																						.get('apellido'),
																		'contacto_cte');
														mysope
																.updateFieldCte(
																		registro
																				.get('movil'),
																		'movil_cte');
														mysope
																.updateFieldCte(
																		registro
																				.get('telefono'),
																		'telefono_cte');
														mysope
																.updateFieldCte(
																		registro
																				.get('email'),
																		'email_cte');

														windows_consulta_contactos
																.close();
													} else {
														mensajeAlert("Seleccione registro de dirección.");
														return;
													}
												}
											} ]
										});
						windows_consulta_contactos.show();

					},
					consultaclientes : function() {
						var mysope = this;

						// Crea una forma de clientes para agregar los datos
						var grid_cte_cotizacion_consulta = Ext
								.create(
										'MyDesktop.view.GridConsultaDireccionesCliente',
										{
											id : 'grid_consulta_clientes_dir'
										});
						// grid_cte_cotizacion_consulta.setProxyURL('../catalogo/direccion/getDatosConsulta');

						var windows_consulta = Ext
								.create(
										'widget.window',
										{
											id : 'utils-win-consultar-clientes-cotizaciones-disponibles',
											title : "Clientes Disponibles",
											width : 1000,
											height : 400,
											modal : true,
											plain : true,
											layout : 'fit',
											iconCls : 'clientes_white',
											items : grid_cte_cotizacion_consulta,
											buttons : [ {
												iconCls : 'seleccionar_white',
												text : 'Seleccionar',
												handler : function() {
													var registro = grid_cte_cotizacion_consulta
															.getRegistro();
													if (registro != undefined) {
														mysope
																.updateFieldCte(
																		registro
																				.get('idcliente'),
																		'idcliente');
														mysope
																.updateFieldCte(
																		registro
																				.get('numcliente'),
																		'numcliente');

														mysope
																.updateFieldCte(
																		registro
																				.get('descripcion'),
																		'razonsocial_cte');
														mysope
																.updateFieldCte(
																		registro
																				.get('numcliente'),
																		'numcliente');
														mysope
																.updateFieldCte(
																		registro
																				.get('calle'),
																		'calle_cte');
														mysope
																.updateFieldCte(
																		registro
																				.get('numinterior'),
																		'numinterior_cte');
														mysope
																.updateFieldCte(
																		registro
																				.get('numexterior'),
																		'numexterior_cte');
														mysope
																.updateFieldCte(
																		registro
																				.get('cp'),
																		'cp_cte');
														mysope
																.updateFieldCte(
																		registro
																				.get('colonia'),
																		'colonia_cte');
														mysope
																.updateFieldCte(
																		registro
																				.get('municipio'),
																		'municipio_cte');
														mysope
																.updateFieldCte(
																		registro
																				.get('estado'),
																		'estado_cte');
														// mysope.updateFieldCte(registro.get('email'),
														// 'email_cte');
														// mysope.updateFieldCte(registro.get('telefono'),
														// 'telefono_cte');
														// mysope.updateFieldCte(registro.get('movil'),
														// 'movil_cte');
														mysope
																.updateFieldCte(
																		registro
																				.get('rfc'),
																		'rfc');

														windows_consulta
																.close();
													} else {
														Ext.Msg
																.alert(
																		'Verificar',
																		"Seleccione registro de dirección.");
														return;
													}
												}
											} ]
										}).show();
					},

					showGridCps : function(b, e) {
						var fields = Ext.getCmp(this.id).getForm().getFields();
						var tipoconsulta = 'cp';
						var patron = '';
						var boton = b.id.split("_")[0];
						if (boton == 'btnBuscarCP') {
							tipoconsulta = 'cp';
							patron = getValueFormField('cp_cte', fields); //Ext.getCmp('idcp').getValue();
						} else if (boton == 'btnBuscarColonia') {
							tipoconsulta = 'colonia';
							patron = getValueFormField('colonia_cte', fields); //Ext.getCmp('idcolonia').getValue();
						} else if (boton == 'btnBuscarMunicipio') {
							tipoconsulta = 'municipio';
							patron = getValueFormField('municipio_cte', fields); //Ext.getCmp('idmunicipio').getValue();
						} else {
							alert('Tipo de consulta inválida.');
						}

						var gridcps = Ext
								.create(
										'MyDesktop.view.GridConsultaCPs',
										{
											id : 'GridConsultaCPs_Consulta_Cotizaciones',
											isEditable : true,
											cp_field : 'cp_cte',
											colonia_field : 'colonia_cte',
											municipio_field : 'municipio_cte',
											estado_field : 'estado_cte',
											fields : fields,
											form : Ext.getCmp(this.id)
													.getForm(),
											tipoconsulta : tipoconsulta,
											patron : patron,
											cp : patron,
											colonia : patron,
											municipio : patron
										});

						var buscacps_window = new Ext.Window({
							width : 880,
							height : 350,
							layout : 'border',
							title : 'Busqueda de códigos postales',
							closable : false,
							headerPosition : 'left',
							items : [ {
								items : gridcps,
								layout : 'fit',
								region : 'center',
								height : 100
							} ],
							buttons : [ {
								text : 'Salir',
								handler : function() {
									buscacps_window.close();
								}
							} ]
						});
						gridcps.setScopeWin(buscacps_window);
						buscacps_window.show();

					},

					consultadescuentos : function() {
						var fields = Ext.getCmp(this.id).getForm().getFields();
						//Obtiene el valor del idcliente seleccionado
						var idcliente = getValueFormField('idcliente', fields);
						//Obtiene el valor del idcliente seleccionado
						var idtarifa = getValueFormField('idtarifa', fields);

						var mysope = this;
						//Crea una forma de clientes para agregar los datos
						var grid_descuentos_consulta = Ext.create(
								'MyDesktop.view.GridDescuentos', {
									id : 'grid_consulta_descuentos_cotizacion'
								});
						grid_descuentos_consulta.loadInfo();
						var wind_descuentos = Ext
								.create(
										'widget.window',
										{
											id : 'utils-win-consultar-descuentos-disponibles-cotizaciones',
											title : "Descuentos Disponibles",
											width : 900,
											height : 350,
											modal : true,
											plain : true,
											headerPosition : 'right',
											layout : 'fit',
											iconCls : 'descuentos_white',
											items : grid_descuentos_consulta,
											buttons : [ {
												iconCls : 'seleccionar_white',
												text : 'Seleccionar',
												handler : function() {
													var registro = grid_descuentos_consulta
															.getRegistro();
													if (registro != undefined) {
														mysope
																.updateFieldCte(
																		registro
																				.get('iddescuento'),
																		'iddescuento');
														mysope
																.updateFieldCte(
																		registro
																				.get('nombre'),
																		'descripcionDescuento');

														wind_descuentos.close();
													} else {
														Ext.Msg
																.alert(
																		'Verificar',
																		"Seleccione registro de dirección.");
														return;
													}
												}
											}

											]

										});
						grid_descuentos_consulta.buscar(10, idcliente,
								idtarifa, '');
						wind_descuentos.show();
					},
					consultatarifas : function() {
						var mysope = this;
						//Crea una forma de clientes para agregar los datos
						var grid_tarifas = Ext.create(
								'MyDesktop.view.GridTarifas', {
									id : 'grid_consulta_tarifas_cotizacion',
									isConsulta : true
								});
						grid_tarifas.loadInfo();
						var wind_tarifas = Ext
								.create(
										'widget.window',
										{
											id : 'utils-win-consultar-tarifas-disponibles-cotizaciones',
											title : "Tarifas Disponibles",
											width : 900,
											height : 350,
											modal : true,
											plain : true,
											headerPosition : 'right',
											layout : 'fit',
											iconCls : 'tarifas_white',
											items : grid_tarifas,
											buttons : [ {
												iconCls : 'seleccionar_white',
												text : 'Seleccionar',
												handler : function() {
													var registro = grid_tarifas
															.getRegistro();
													if (registro != undefined) {
														mysope
																.updateFieldCte(
																		registro
																				.get('idtarifa'),
																		'idtarifa');
														mysope
																.updateFieldCte(
																		registro
																				.get('nombre'),
																		'descripcionTarifarango');
														wind_tarifas.close();
													} else {
														Ext.Msg
																.alert(
																		'Verificar',
																		"Seleccione registro de dirección.");
														return;
													}
												}
											}

											]

										});
						grid_tarifas.buscar(10, '', '', '');

						wind_tarifas.show();

					},
					consultarangosenvios : function() {
						var mysope = this;
						var idtarifa = mysope.getValueField('idtarifa');

						if (idtarifa == '') {
							Ext.Msg.alert('Verificar',
									"Debe seleccionar una tarifa disponible");
							return;
						}
						//Crea una forma de clientes para agregar los datos
						var grid_rangos_tarifa_servicio_cotizacion = Ext
								.create(
										'MyDesktop.view.GridTarifasRangoEnvios',
										{
											id : 'showdetails_tarifa_rango_cotizacion_coti',
											isConsulta : true,
											idtarifa : idtarifa
										});

						grid_rangos_tarifa_servicio_cotizacion.buscar();
						//forma_showdetails.updateFieldReadOnly(rows[0]);
						var mywin_rangos = Ext
								.create(
										'widget.window',
										{
											id : 'utils-win-agregar-tarifa-rango_cortiza',
											title : "Rango Envios Disponibles",
											width : 750,
											height : 350,
											modal : true,
											plain : true,
											headerPosition : 'right',
											layout : 'fit',
											items : grid_rangos_tarifa_servicio_cotizacion,
											buttons : [ {
												iconCls : 'seleccionar_white',
												text : 'Seleccionar',
												handler : function() {
													var registro = grid_rangos_tarifa_servicio_cotizacion
															.getRegistro();
													if (registro != undefined) {
														var rango_envios = registro
																.get('idrangoinicial')
																+ '-'
																+ registro
																		.get('idrangofinal');
														mysope.updateFieldCte(
																rango_envios,
																'rangoenvios');
														mysope
																.updateFieldCte(
																		registro
																				.get('idrangoenvios'),
																		'idrangoenvios');
														mywin_rangos.close();

													} else {
														Ext.Msg
																.alert(
																		'Verificar',
																		"Seleccione registro de dirección.");
														return;
													}
												}
											} ]
										});
						mywin_rangos.show();
					},
					consultaSeguros : function() {
						var mysope = this;

						//Crea una forma de clientes para agregar los datos
						var grid_consulta_seguros = Ext
								.create(
										'MyDesktop.view.GridSeguros');

						var mywin_rangos = Ext
								.create(
										'widget.window',
										{
											id : 'utils-win-agregar-tarifa-rango_cortiza',
											title : "Seguros Disponibles",
											width : 485,
											height : 350,
											modal : true,
											plain : true,
											headerPosition : 'right',
											layout : 'fit',
											items : grid_consulta_seguros,
											buttons : [ {
												iconCls : 'seleccionar_white',
												text : 'Seleccionar',
												handler : function() {
													var registro = grid_consulta_seguros
															.getRegistro();
													if (registro != undefined) {
														var nombre_seguro = registro
																.get('ciaseguro');
														mysope.updateFieldCte(
																nombre_seguro,
																'nombre_seguro');
														mywin_rangos.close();

													} else {
														Ext.Msg
																.alert(
																		'Verificar',
																		"Seleccione registro de dirección.");
														return;
													}
												}
											} ]
										});
						mywin_rangos.show();
					},
					setWinPrincipal : function(winp) {
						this.winprincipal = winp;
					}
				});