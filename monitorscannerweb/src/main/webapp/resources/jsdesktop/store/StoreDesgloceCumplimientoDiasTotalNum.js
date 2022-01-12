Ext.define('MyDesktop.store.StoreDesgloceCumplimientoDiasTotalNum', {
	extend : 'Ext.data.Store',
	model : 'MyDesktop.models.ModeloDesgloceCumplimientoDiasTotal',
	autoDestroy : false,
	loadMask : true,
	autoSave : false,
	autoSync : false,
	autoLoad : false,
	idProperty : 'cop',
	proxy : {
        type: 'ajax',
        timeout:99999999,
		api : {
			read : '../indicadores/getDesgloceCumplimientoDiasTotalNum'
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
