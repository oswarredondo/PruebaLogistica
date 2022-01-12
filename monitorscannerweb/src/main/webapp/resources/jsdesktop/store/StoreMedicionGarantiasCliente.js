Ext.define('MyDesktop.store.StoreMedicionGarantiasCliente', {
	extend : 'Ext.data.Store',
	model : 'MyDesktop.models.ModeloMedicionGarantiasCliente',
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
			read : '../indicadores/getMedicionGarantiaPorCliente'

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
