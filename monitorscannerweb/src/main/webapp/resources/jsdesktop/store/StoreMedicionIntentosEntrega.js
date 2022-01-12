Ext.define('MyDesktop.store.StoreMedicionIntentosEntrega', {
	extend: 'Ext.data.Store',
	model: 'MyDesktop.models.ModeloMedicionIntentosEntrega',
	autoDestroy: false,
	loadMask: true,
	autoSave: false,
	autoSync: false,
	autoLoad: false,
	idProperty: 'estatus',
	proxy: {
		type: 'ajax',
		timeout: 99999999,
		api: {
			read: '../indicadores/getMedicionIntentosEntrega'
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
