Ext.define('MyDesktop.store.StoreDesgloceCumplimientoDiasPorcentaje', {
	extend: 'Ext.data.Store',
	model: 'MyDesktop.models.ModeloDesgloceCumplimientoDias',
	autoDestroy: false,
	loadMask: true,
	autoSave: false,
	autoSync: false,
	autoLoad: false,
	idProperty: 'descripcion',
	proxy: {
		type: 'ajax',
		timeout: 99999999,
		api: {
			read: '../indicadores/getDesgloceCumplimientoDiasPorcentaje'
		},
		reader: {
			type: 'json',
			successProperty: 'success',
			root: 'proxiArray',
			messageProperty: 'message',
			totalProperty: 'totalCount',
		},
	}
});
