Ext.define('MyDesktop.grid.GridMedicionIntentosEntrega', {
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
	stateId: 'stateGridMedicionIntentosEntrega',
	myScope: undefined,
	viewConfig: {
		stripeRows: true,
		enableTextSelection: true
	},
	initComponent: function() {

		this.myScope = this;

		this.store = Ext.create('MyDesktop.store.StoreMedicionIntentosEntrega', {});

		this.features = [{

			ftype: 'summary',

		}];


		this.columns = [

			{ text: 'Semana', width: 160, sortable: true, dataIndex: 'semana', align: 'center' },

			{
				text: '1 Intento', width: 160, sortable: true, dataIndex: 'intento1', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {

					return value.toFixed(2) + "%";

				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {

					var total = this.store.getCount() * 100

					total = (value * 100) / total;

					return '<b><font color=green>' + total.toFixed(2) + '%</font></b>';

				}
			},

			{
				text: '2 Intentos', width: 160, sortable: true, dataIndex: 'intento2', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {

					return value.toFixed(2) + "%";

				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {

					var total = this.store.getCount() * 100

					total = (value * 100) / total;

					return '<b><font color=green>' + total.toFixed(2) + '%</font></b>';

				}
			},

			{
				text: '3 o mas Intentos', width: 160, sortable: true, dataIndex: 'masDe3', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {

					return value.toFixed(2) + "%";

				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {

					var total = this.store.getCount() * 100

					total = (value * 100) / total;

					return '<b><font color=green>' + total.toFixed(2) + '%</font></b>';

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