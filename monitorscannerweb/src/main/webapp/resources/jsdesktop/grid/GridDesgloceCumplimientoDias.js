Ext.define('MyDesktop.grid.GridDesgloceCumplimientoDias', {
	extend: 'Ext.grid.Panel',
	requires: [
		'Ext.grid.column.Action',
		'Ext.grid.plugin.CellEditing',
		'Ext.form.field.Text',
		'Ext.toolbar.TextItem'
	],
	stateful: true,
	collapsible: false,
	multiSelect: true,
	tipo: undefined,
	stateId: 'stateGridDesgloceCumplimientoDias',
	myScope: undefined,
	viewConfig: {
		stripeRows: true,
		enableTextSelection: true
	},
	initComponent: function() {

		this.myScope = this;

		var caracter;

		if (this.tipo == 1) {

			this.store = Ext.create('MyDesktop.store.StoreDesgloceCumplimientoDias', {});

			caracter = 'Guias'

		} else {

			this.store = Ext.create('MyDesktop.store.StoreDesgloceCumplimientoDiasPorcentaje', {});

			caracter = '%'

		}


		this.features = [{

			ftype: 'summary',

		}];


		this.columns = [

			{ text: 'Centro Operativo', width: 160, sortable: true, dataIndex: 'descripcion', align: 'center' },

			{
				text: 'Dia 01', width: 100, sortable: true, dataIndex: 'dia01', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {

					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}

				}
			},

			{
				text: 'Dia 02', width: 100, sortable: true, dataIndex: 'dia02', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 03', width: 100, sortable: true, dataIndex: 'dia03', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 04', width: 142, sortable: true, dataIndex: 'dia04', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 05', width: 142, sortable: true, dataIndex: 'dia05', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 06', width: 142, sortable: true, dataIndex: 'dia06', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 07', width: 142, sortable: true, dataIndex: 'dia07', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 08', width: 142, sortable: true, dataIndex: 'dia08', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 09', width: 142, sortable: true, dataIndex: 'dia09', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 10', width: 142, sortable: true, dataIndex: 'dia10', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 11', width: 142, sortable: true, dataIndex: 'dia11', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 12', width: 142, sortable: true, dataIndex: 'dia12', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 13', width: 142, sortable: true, dataIndex: 'dia13', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 14', width: 142, sortable: true, dataIndex: 'dia14', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 15', width: 142, sortable: true, dataIndex: 'dia15', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 16', width: 142, sortable: true, dataIndex: 'dia16', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 17', width: 142, sortable: true, dataIndex: 'dia17', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 18', width: 142, sortable: true, dataIndex: 'dia18', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 19', width: 142, sortable: true, dataIndex: 'dia19', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 20', width: 142, sortable: true, dataIndex: 'dia20', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 21', width: 142, sortable: true, dataIndex: 'dia21', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 22', width: 142, sortable: true, dataIndex: 'dia22', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 23', width: 142, sortable: true, dataIndex: 'dia23', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 24', width: 142, sortable: true, dataIndex: 'dia24', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 25', width: 142, sortable: true, dataIndex: 'dia25', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 26', width: 142, sortable: true, dataIndex: 'dia26', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 27', width: 142, sortable: true, dataIndex: 'dia27', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 28', width: 142, sortable: true, dataIndex: 'dia28', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 29', width: 142, sortable: true, dataIndex: 'dia29', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 30', width: 142, sortable: true, dataIndex: 'dia30', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			},

			{
				text: 'Dia 31', width: 142, sortable: true, dataIndex: 'dia31', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					return this.myScope.tipo == 1 ? value : value.toFixed(2) + "%";
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {
					if (this.myScope.tipo == 1) {

						return '<b><font color=green>' + value + ' ' + caracter + '</font></b>';

					} else {

						return '<b><font color=green>' + value.toFixed(2) + ' ' + caracter + '</font></b>';

					}
				}
			}

		];

		this.callParent();
	},

	buscarInformacion: function(fecha_inicio, fecha_fin, centro_operativo, tipo_entrega, mes_recoleccion) {

		var myscope = this;

		myscope.getView().getStore().load(
			{
				params: {
					fecha_inicio: fecha_inicio,
					fecha_fin: fecha_fin,
					centro_operativo: centro_operativo,
					tipo_entrega: tipo_entrega,
					mes_recoleccion: mes_recoleccion

				}
			});

	}

});