Ext.define('MyDesktop.store.StoreMedicionCumplimientoGarantias', {
	extend : 'Ext.data.Store',
	model : 'MyDesktop.models.ModeloMedicionCumplimientoGarantias',
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
			read : '../indicadores/getMedicionCumplimientoGarantias'

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
