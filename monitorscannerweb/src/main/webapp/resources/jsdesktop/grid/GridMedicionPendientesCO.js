Ext.define('MyDesktop.grid.GridMedicionPendientesCO', {
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

		this.store = Ext.create('MyDesktop.store.StoreMedicionPendientesCO', {});

		this.features = [{

			ftype: 'summary',

		}];


		this.columns = [

			{ text: 'Centro Operativo', width: 160, sortable: true, dataIndex: 'estatus', align: 'center' },

			{
				text: 'En Almacen1', width: 100, sortable: true, dataIndex: 'almacen', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {

					return value;

				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {

					return '<b><font color=green>' + value + '</font></b>';

				}
			},
			{
				text: 'En Ruta', width: 100, sortable: true, dataIndex: 'ruta', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {

					return value;

				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {

					return '<b><font color=green>' + value + '</font></b>';

				}
			},
			{
				text: 'En Ruta Foranea', width: 100, sortable: true, dataIndex: 'rutaForanea', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {

					return value;

				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {

					return '<b><font color=green>' + value + '</font></b>';

				}
			},
			{
				text: 'Por Confirmar o Actualizar', width: 100, sortable: true, dataIndex: 'confirmaActualiza', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {

					return value;

				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {

					return '<b><font color=green>' + value + '</font></b>';

				}
			},
			{
				text: 'En Investigacion', width: 100, sortable: true, dataIndex: 'investigacion', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {

					return value;

				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {

					return '<b><font color=green>' + value + '</font></b>';

				}
			},
			{
				text: 'Entregada', width: 100, sortable: true, dataIndex: 'entrega', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {

					return value;

				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {

					return '<b><font color=green>' + value + '</font></b>';

				}
			},
			{
				text: 'Sin Movimientos', width: 100, sortable: true, dataIndex: 'sinMovimientos', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {

					return value;

				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {

					return '<b><font color=green>' + value + '</font></b>';

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