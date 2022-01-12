Ext.define('MyDesktop.models.ModeloMedicionCumplimientoGarantias', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'grupo', type: 'string'},      
		   {name: 'si_cumplio', type: 'float'},
		   {name: 'no_cumplio', type: 'float'}
		]
});