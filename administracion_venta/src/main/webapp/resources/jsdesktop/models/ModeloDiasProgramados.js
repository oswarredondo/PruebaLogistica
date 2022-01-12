Ext.define('MyDesktop.models.ModeloDiasProgramados', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'idregistro', type: 'string'},
		    {name: 'idsolicitud', type: 'string'},
		    {name: 'observacion', type: 'string'},
		    {name: 'diasemanames', type: 'int'},
		    
		    {name: 'hora', type: 'string'}
		]
});

