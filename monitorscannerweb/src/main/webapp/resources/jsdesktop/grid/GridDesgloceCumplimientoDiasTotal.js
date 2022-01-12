Ext.define('MyDesktop.grid.GridDesgloceCumplimientoDiasTotal', {
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
	stateId: 'stateGridDesgloceCumplimientoDiasTotal',
	myScope: undefined,
	viewConfig: {
		stripeRows: true,
		enableTextSelection: true
	},
	initComponent: function() {

		this.myScope = this;

		var caracter = "";
		
		if (this.tipo == 1) {

			this.store = Ext.create('MyDesktop.store.StoreDesgloceCumplimientoDiasTotal', {});
			
			caracter = '%'

		} else {
			
			this.store = Ext.create('MyDesktop.store.StoreDesgloceCumplimientoDiasTotalNum', {});
			
			caracter = 'Guias'

		}

		this.features = [{

			ftype: 'summary',

		}];


		this.columns = [

			{ text: 'Centro Operativo', width: 130, sortable: true, dataIndex: 'cop', align: 'center' },

			{
				text: 'Cantidad', width: 125, sortable: true, dataIndex: 'porcentaje', align: 'center',
				renderer: function(value, metaData, record, rowIndex, colIndex, store) {
					
					return this.tipo == 1 ? value + "%" : value;
					
				},
				summaryType: 'sum', summaryRenderer: function(value, summaryData, dataIndex) {

					return this.tipo == 1 ? '<b><font color=green>' + value.toFixed(2) + '%</font></b>' : '<b><font color=green>' + value + ' Guias</font></b>';

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