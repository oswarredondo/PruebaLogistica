Ext.define('MyDesktop.models.ModeloMedicionIntentosEntrega', {
        extend: 'Ext.data.Model',
		fields: [

			{name: 'semana', type:'string'},
			{name: 'intento1', type:'float'},
			{name: 'intento2', type:'float'},
			{name: 'masDe3', type:'float'}

		]
});