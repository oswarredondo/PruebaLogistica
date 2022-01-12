Ext.define('MyDesktop.models.ModeloMedicionCumplimientoGarantiasCO', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'grupo', type: 'string'},      
		   {name: 'si_cumplio', type: 'float'},
		   {name: 'no_cumplio', type: 'float'}
		]
});