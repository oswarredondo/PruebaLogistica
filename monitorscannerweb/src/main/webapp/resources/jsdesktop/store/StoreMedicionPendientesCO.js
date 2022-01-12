Ext.define('MyDesktop.store.StoreMedicionPendientesCO', {
	extend: 'Ext.data.Store',
	model: 'MyDesktop.models.ModeloMedicionPendientesCO',
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
			read: '../indicadores/getMedicionPendientesCO'
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
