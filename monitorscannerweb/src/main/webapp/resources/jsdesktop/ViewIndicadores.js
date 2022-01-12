Ext
	.define(
		'MyDesktop.ViewIndicadores',
		{
			extend: 'Ext.ux.desktop.Module',
			id: 'indicadores-procesamiento-win',
			requires: ['Ext.chart.*', 'Ext.data.JsonStore',
				'Ext.layout.container.Fit', 'Ext.window.MessageBox'],

			init: function() {
				
				this.launcher = {
					text: 'Indicadores Movimientos',
					iconCls: 'wallpaper_blue',
				}

			},

			createNewWindow: function() {

				this.activeWindow = "Garantia";
				
				var me = this, desktop = me.app.getDesktop();

				var DIA = new Date();
				var MES = DIA.getMonth() + 1;
				var YEAR = DIA.getFullYear();

				var combo_tipos_busqueda = Ext.create(
					'Ext.form.ComboBox', {
					fieldLabel: '',
					width: 150,
					disabled: false,
					editable: false,
					allowBlank: false,
					forceSelection: true,
					id: 'mes' + this.id,
					store: Ext.create(
						'MyDesktop.store.StoreMeses', {}),
					typeAhead: true,
					queryMode: 'local',
					emptyText: 'Seleccione mes',
					displayField: 'descripcion',
					valueField: 'identificador'
				});

				var combo_tipos_entregas = Ext.create(
					'Ext.form.ComboBox', {
					fieldLabel: '',
					width: 150,
					disabled: false,
					editable: false,
					allowBlank: false,
					forceSelection: true,
					id: 'tipo_' + this.id,
					store: Ext.create(
						'MyDesktop.store.StoreTipoEntrega',
						{}),
					typeAhead: true,
					queryMode: 'local',
					emptyText: 'Seleccione Tipo...',
					displayField: 'descripcion',
					valueField: 'identificador'
				});

				var combo_tipos_CO = Ext.create('Ext.form.ComboBox', {
					fieldLabel: '',
					width: 150,
					disabled: false,
					editable: false,
					allowBlank: false,
					forceSelection: true,
					id: 'co_' + this.id,
					store: Ext.create(
						'MyDesktop.store.StoreCentrosOperativos',
						{}),
					typeAhead: true,
					queryMode: 'local',
					emptyText: 'Seleccione C.O...',
					displayField: 'descripcion',
					valueField: 'identificador'
				});
				combo_tipos_busqueda.setValue(MES + "");

				this.grid_registros1 = new MyDesktop.grid.GridMedicionGarantiasCliente(
					{
						width: 600,
						heigth: 150,
						title: 'Medición de garantias por cliente',
						border: true,
						frame: false,
						flex: 1,
						layout: 'fit'
					});

				this.grid_registros2 = new MyDesktop.grid.GridMedicionCumplimientoGarantias(
					{
						width: 600,
						heigth: 150,
						title: 'Medición de cumplimiento de garantias',
						border: true,
						frame: false,
						flex: 1,
						layout: 'fit'
					});

				this.grid_registros3 = new MyDesktop.grid.GridMedicionCumplimientoGarantiasCO(
					{
						width: 600,
						heigth: 150,
						title: 'Cumplimiento de garantias por CO',
						border: true,
						frame: false,
						flex: 1,
						layout: 'fit'
					});

				this.grid1 = new MyDesktop.grid.GridTiempoEntregaCO(
					{
						width: 600,
						heigth: 200,
						title: 'Tiempo de entrega por CO',
						border: true,
						frame: false,
						flex: 1,
						layout: 'fit'
					});

				this.grid2 = new MyDesktop.grid.GridTiempoCrossDock(
					{
						width: 600,
						heigth: 200,
						title: 'Medición CrossDock',
						border: true,
						frame: false,
						flex: 1,
						layout: 'fit'
					});

				this.grid3 = new MyDesktop.grid.GridDemoraIngresoCOFinal(
					{
						width: 600,
						heigth: 200,
						title: 'Demora ingreso CO final',
						border: true,
						frame: false,
						flex: 1,
						layout: 'fit'
					});

				this.gridDesgloce = new MyDesktop.grid.GridDesgloceCumplimientoDias(
					{
						width: 300,
						heigth: 300,
						title: 'Desgloce de Cumplimientos por Día',
						border: true,
						frame: false,
						flex: 1,
						layout: 'fit',
						tipo: 1
					});

				this.gridDesglocePorcentaje = new MyDesktop.grid.GridDesgloceCumplimientoDias(
					{
						width: 300,
						heigth: 300,
						title: 'Desgloce de Cumplimientos por Día en Porcentaje',
						border: true,
						frame: false,
						flex: 1,
						layout: 'fit',
						tipo: 2
					});

				this.gridDesglocePorcentajeTotal = new MyDesktop.grid.GridDesgloceCumplimientoDiasTotal(
					{
						width: 150,
						heigth: 150,
						title: 'Porcentajes totales por COP',
						border: true,
						frame: false,
						flex: 1,
						layout: 'fit',
						tipo: 1
					});

				this.gridDesglocePorcentajeTotalNum = new MyDesktop.grid.GridDesgloceCumplimientoDiasTotal(
					{
						width: 150,
						heigth: 150,
						title: 'Guias totales por COP',
						border: true,
						frame: false,
						flex: 1,
						layout: 'fit',
						tipo: 2
					});

				this.gridMedicionPendientesMEX = new MyDesktop.grid.GridMedicionPendientesCO(
					{
						width: 150,
						heigth: 150,
						title: 'Medicion Pendientes de MEXICO',
						border: true,
						frame: false,
						flex: 1,
						layout: 'fit'
					});

				this.gridMedicionPendientesLEN = new MyDesktop.grid.GridMedicionPendientesCO(
					{
						width: 150,
						heigth: 150,
						title: 'Medicion Pendientes de LEON',
						border: true,
						frame: false,
						flex: 1,
						layout: 'fit'
					});

				this.gridMedicionPendientesMTY = new MyDesktop.grid.GridMedicionPendientesCO(
					{
						width: 150,
						heigth: 150,
						title: 'Medicion Pendientes de MONTERREY',
						border: true,
						frame: false,
						flex: 1,
						layout: 'fit'
					});

				this.gridMedicionPendientesGDL = new MyDesktop.grid.GridMedicionPendientesCO(
					{
						width: 150,
						heigth: 150,
						title: 'Medicion Pendientes de GUADALAJARA',
						border: true,
						frame: false,
						flex: 1,
						layout: 'fit'
					});

				this.gridMedicionIntentossMEX = new MyDesktop.grid.GridMedicionIntentosEntrega(
					{
						width: 150,
						heigth: 150,
						title: 'Intentos Entrega de MEXICO',
						border: true,
						frame: false,
						flex: 1,
						layout: 'fit'
					});

				this.gridMedicionIntentossLEN = new MyDesktop.grid.GridMedicionIntentosEntrega(
					{
						width: 150,
						heigth: 150,
						title: 'Intentos Entreg de LEON',
						border: true,
						frame: false,
						flex: 1,
						layout: 'fit'
					});

				this.gridMedicionIntentossMTY = new MyDesktop.grid.GridMedicionIntentosEntrega(
					{
						width: 150,
						heigth: 150,
						title: 'Intentos Entreg de MONTERREY',
						border: true,
						frame: false,
						flex: 1,
						layout: 'fit'
					});

				this.gridMedicionIntentossGDL = new MyDesktop.grid.GridMedicionIntentosEntrega(
					{
						width: 150,
						heigth: 150,
						title: 'Intentos Entreg de GUADALAJARA',
						border: true,
						frame: false,
						flex: 1,
						layout: 'fit'
					});

				var garantias = {
					title: 'Garantias',
					width: 1000,
					height: 700,
					border: false,
					layout: {
						type: 'hbox',
						align: 'stretch'
					},
					bodyStyle: {
						'background-color': '#FFF'
					},

					items: [{
						flex: 1,
						xtype: 'container',
						width: 500,
						layout: {
							type: 'vbox',
							align: 'stretch'

						},
						items: [me.grid_registros1, me.grid1]
					}, {
						flex: 1,
						xtype: 'container',
						width: 500,
						layout: {
							type: 'vbox',
							align: 'stretch'

						},
						items: [me.grid_registros2, me.grid2]
					}, {
						flex: 1,
						xtype: 'container',
						layout: {
							type: 'vbox',
							align: 'stretch',
							width: 500
						},
						items: [me.grid_registros3, me.grid3]
					}

					]
				};

				var tiempos_demoras = {
					title: 'Desgloce por Dias',
					width: 1000,
					height: 700,
					border: false,
					layout: {
						type: 'hbox',
						align: 'stretch'
					},
					bodyStyle: {
						'background-color': '#FFF'
					},

					items: [
						{
							flex: 4,
							xtype: 'container',
							width: 500,
							layout: {
								type: 'vbox',
								align: 'stretch'

							},
							items: [me.gridDesgloce, me.gridDesglocePorcentaje]
						}, {
							flex: 1,
							xtype: 'container',
							width: 500,
							layout: {
								type: 'vbox',
								align: 'stretch'

							},
							items: [me.gridDesglocePorcentajeTotalNum, me.gridDesglocePorcentajeTotal]
						}

					]
				};

				var Medicion = {
					title: 'Pendientes',
					width: 1000,
					height: 700,
					border: false,
					layout: {
						type: 'hbox',
						align: 'stretch'
					},
					bodyStyle: {
						'background-color': '#FFF'
					},

					items: [{
						flex: 1,
						xtype: 'container',
						width: 500,
						layout: {
							type: 'vbox',
							align: 'stretch'

						},
						items: [me.gridMedicionPendientesMEX, me.gridMedicionPendientesLEN]
					}, {
						flex: 1,
						xtype: 'container',
						width: 500,
						layout: {
							type: 'vbox',
							align: 'stretch'

						},
						items: [me.gridMedicionPendientesMTY, me.gridMedicionPendientesGDL]
					}

					]
				};

				var Intentos = {
					title: 'Intentos',
					width: 1000,
					height: 700,
					border: false,
					layout: {
						type: 'hbox',
						align: 'stretch'
					},
					bodyStyle: {
						'background-color': '#FFF'
					},

					items: [{
						flex: 1,
						xtype: 'container',
						width: 500,
						layout: {
							type: 'vbox',
							align: 'stretch'

						},
						items: [me.gridMedicionIntentossMEX, me.gridMedicionIntentossLEN]
					}, {
						flex: 1,
						xtype: 'container',
						width: 500,
						layout: {
							type: 'vbox',
							align: 'stretch'

						},
						items: [me.gridMedicionIntentossMTY, me.gridMedicionIntentossGDL]
					}

					]
				};

				var tab_menus = Ext.widget('tabpanel', {
					scope:me,
					activeTab: 0,
					width: 1000,
					height: 700,
					layout: 'fit',
					tabPosition: 'left',
					defaults: {
						autoScroll: true,
						bodyPadding: 10
					},
					items: [garantias, tiempos_demoras, Medicion, Intentos],
					listeners: {
						'render': function(obj, options) {

							this.items.each(function(i) {
								i.tab.on('click', function() {

									if (i.title == "Desgloce por Dias") {

										Ext.getCmp('htmlFI').hide();

										Ext.getCmp('idfechaInicial').hide();

										Ext.getCmp('htmlFF').hide();

										Ext.getCmp('idfechaFinal').hide();

										Ext.getCmp('htmlCO').hide();

										combo_tipos_CO.hide();

										Ext.getCmp('htmlTipoEntrega').hide();

										combo_tipos_entregas.hide();

										Ext.getCmp('htmlMesFatura').show();

										combo_tipos_busqueda.show();

										me.activeWindow = "Desgloce";

									} else if (i.title == "Garantias") {

										Ext.getCmp('htmlFI').show();

										Ext.getCmp('idfechaInicial').show();

										Ext.getCmp('htmlFF').show();

										Ext.getCmp('idfechaFinal').show();

										Ext.getCmp('htmlCO').show();

										combo_tipos_CO.show();

										Ext.getCmp('htmlTipoEntrega').show();

										combo_tipos_entregas.show();

										Ext.getCmp('htmlMesFatura').show();

										combo_tipos_busqueda.show();

										me.activeWindow = "Garantia";

									} else if (i.title == "Pendientes") {

										Ext.getCmp('htmlFI').show();

										Ext.getCmp('idfechaInicial').show();

										Ext.getCmp('htmlFF').show();

										Ext.getCmp('idfechaFinal').show();

										Ext.getCmp('htmlCO').hide();

										combo_tipos_CO.hide();

										Ext.getCmp('htmlTipoEntrega').hide();

										combo_tipos_entregas.hide();

										Ext.getCmp('htmlMesFatura').hide();

										combo_tipos_busqueda.hide();

										me.activeWindow = "Medicion";

									} else if (i.title == "Intentos") {

										Ext.getCmp('htmlFI').hide();

										Ext.getCmp('idfechaInicial').hide();

										Ext.getCmp('htmlFF').hide();

										Ext.getCmp('idfechaFinal').hide();

										Ext.getCmp('htmlCO').hide();

										combo_tipos_CO.hide();

										Ext.getCmp('htmlTipoEntrega').hide();

										combo_tipos_entregas.hide();

										Ext.getCmp('htmlMesFatura').show();

										combo_tipos_busqueda.show();

										me.activeWindow = "Intentos";

									}

								});
							});


						}

					}
				});

				return desktop.createWindow({
					id: me.id,
					title: 'Resumen Procesamiento',
					layout: 'fit',
					iconCls: 'wallpaper_blue',
					animCollapse: false,
					constrainHeader: true,
					maximized: true,
					maximizable: false,
					border: false,
					items: [tab_menus],
					dockedItems: [{
						dock: 'top',
						xtype: 'toolbar',
						items: [{
							xtype: 'tbspacer',
						}, {
							xtype: 'tbspacer',
						}, {
							xtype: 'tbspacer',
						}, {
							xtype: 'tbspacer',
						}, {
							xtype: 'label',
							id: 'htmlCO',
							html: 'Seleccione CO:'
						}, combo_tipos_CO, {
							xtype: 'label',
							id: 'htmlTipoEntrega',
							html: 'Seleccione Tipo de Entrega:'
						}, combo_tipos_entregas, {
							xtype: 'label',
							id: 'htmlMesFatura',
							html: 'Mes Facturación:'
						}, combo_tipos_busqueda, {
							xtype: 'tbseparator'
						}, {
							xtype: 'label',
							id: 'htmlFI',
							text: 'Fecha inicial:'
						}, {
							xtype: 'datefield',
							id: 'idfechaInicial',
							maxLength: 30,
							allowBlank: false,
							width: 110
						}, {
							xtype: 'tbspacer'
						}, {
							xtype: 'label',
							id: 'htmlFF',
							text: 'final:'
						}, {
							xtype: 'datefield',
							id: 'idfechaFinal',
							maxLength: 30,
							allowBlank: false,
							width: 110
						}, {
							//text:'Buscar',
							tooltip: 'Realiza la busqueda (CTRL+B)',
							iconCls: 'search_blue',
							handler: me.realizaConsulta,
							scope: this
						}]
					}]
				});

			},

			createWindow: function() {
				var win = this.app.getDesktop().getWindow(this.id);
				if (!win) {
					win = this.createNewWindow();
				}
				return win;
			},

			realizaConsulta: function() {

				var fechaInicio = Ext.getCmp('idfechaInicial').getValue();

				var fechaFin = Ext.getCmp('idfechaFinal').getValue();

				var centro_operativo = Ext.getCmp("co_" + this.id).getValue();

				var tipo_entrega = Ext.getCmp("tipo_" + this.id).getValue();

				var mes_recoleccion = Ext.getCmp("mes" + this.id).getValue();

				if (this.activeWindow == 'Garantia') {

					if (!fechaInicio || !fechaFin || !centro_operativo || !tipo_entrega || !mes_recoleccion) {

						mensajeAlert("Capture todos los datos generales requeridos");

						return;

					} else {

						this.grid_registros1.buscarInformacion(fechaInicio, fechaFin, centro_operativo, tipo_entrega, mes_recoleccion);

						this.grid_registros2.buscarInformacion(fechaInicio, fechaFin, centro_operativo, tipo_entrega, mes_recoleccion);

						this.grid_registros3.buscarInformacion(fechaInicio, fechaFin, centro_operativo, tipo_entrega, mes_recoleccion);

						this.grid1.buscarInformacion(fechaInicio, fechaFin, centro_operativo, tipo_entrega, mes_recoleccion);

						this.grid2.buscarInformacion(fechaInicio, fechaFin, centro_operativo, tipo_entrega, mes_recoleccion);

						this.grid3.buscarInformacion(fechaInicio, fechaFin, centro_operativo, tipo_entrega, mes_recoleccion);

					}

				} else if (this.activeWindow == 'Desgloce') {

					if (!mes_recoleccion) {

						mensajeAlert("Capture todos los datos generales requeridos");

						return;

					} else {

						this.gridDesgloce.buscarInformacion(fechaInicio, fechaFin, centro_operativo, tipo_entrega, mes_recoleccion);

						this.gridDesglocePorcentaje.buscarInformacion(fechaInicio, fechaFin, centro_operativo, tipo_entrega, mes_recoleccion);

						this.gridDesglocePorcentajeTotal.buscarInformacion(fechaInicio, fechaFin, centro_operativo, tipo_entrega, mes_recoleccion);

						this.gridDesglocePorcentajeTotalNum.buscarInformacion(fechaInicio, fechaFin, centro_operativo, tipo_entrega, mes_recoleccion);

					}

				} else if (this.activeWindow == 'Medicion') {

					if (!fechaInicio || !fechaFin) {

						mensajeAlert("Capture todos los datos generales requeridos");

						return;

					} else {

						this.gridMedicionPendientesMEX.buscarInformacion(fechaInicio, fechaFin, 'MEX', tipo_entrega, mes_recoleccion);

						this.gridMedicionPendientesLEN.buscarInformacion(fechaInicio, fechaFin, 'LEN', tipo_entrega, mes_recoleccion);

						this.gridMedicionPendientesMTY.buscarInformacion(fechaInicio, fechaFin, 'MTY', tipo_entrega, mes_recoleccion);

						this.gridMedicionPendientesGDL.buscarInformacion(fechaInicio, fechaFin, 'GDL', tipo_entrega, mes_recoleccion);

					}


				} else if (this.activeWindow == 'Intentos') {

					if (!mes_recoleccion) {

						mensajeAlert("Capture todos los datos generales requeridos");

						return;

					} else {

						this.gridMedicionIntentossMEX.buscarInformacion(fechaInicio, fechaFin, 'MEX', tipo_entrega, mes_recoleccion);

						this.gridMedicionIntentossLEN.buscarInformacion(fechaInicio, fechaFin, 'LEN', tipo_entrega, mes_recoleccion);

						this.gridMedicionIntentossMTY.buscarInformacion(fechaInicio, fechaFin, 'MTY', tipo_entrega, mes_recoleccion);

						this.gridMedicionIntentossGDL.buscarInformacion(fechaInicio, fechaFin, 'GDL', tipo_entrega, mes_recoleccion);

					}

				}

			}

		});
