Ext.define('MyDesktop.store.StoreDesgloceCumplimientoDias', {
	extend: 'Ext.data.Store',
	model: 'MyDesktop.models.ModeloDesgloceCumplimientoDias',
	autoDestroy: false,
	loadMask: true,
	autoSave: false,
	autoSync: false,
	autoLoad: false,
	idProperty: 'grupo',
	proxy: {
		type: 'ajax',
		timeout: 99999999,
		api: {
			read: '../indicadores/getDesgloceCumplimientoDias'
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
