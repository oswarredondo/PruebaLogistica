Ext.define('MyDesktop.store.StoreMedicionCumplimientoGarantiasCO', {
	extend : 'Ext.data.Store',
	model : 'MyDesktop.models.ModeloMedicionCumplimientoGarantiasCO',
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
			read : '../indicadores/getMedicionCumplimientoGarantiasCO'
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
