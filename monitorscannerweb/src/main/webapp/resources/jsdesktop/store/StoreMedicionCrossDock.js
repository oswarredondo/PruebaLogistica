Ext.define('MyDesktop.store.StoreMedicionCrossDock', {
	extend : 'Ext.data.Store',
	model : 'MyDesktop.models.ModeloMedicionCrossDock',
	autoDestroy : false,
	loadMask : true,
	autoSave : false,
	autoSync : false,
	autoLoad : false,
	idProperty : 'grupo',
	proxy : {
        type: 'ajax',
        timeout:99999999,
		api : {
			read : '../indicadores/getMedicionCrossDock'

		},
        reader: {
            type: 'json',
            successProperty: 'success',
            root : 'proxiArray',
            messageProperty: 'message',
            totalProperty : 'totalCount',
   },
	}
});
