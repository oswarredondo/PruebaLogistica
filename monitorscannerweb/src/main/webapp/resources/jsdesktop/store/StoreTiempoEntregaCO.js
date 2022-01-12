Ext.define('MyDesktop.store.StoreTiempoEntregaCO', {
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
			read : '../indicadores/getTiempoEntregaPorCO'

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
