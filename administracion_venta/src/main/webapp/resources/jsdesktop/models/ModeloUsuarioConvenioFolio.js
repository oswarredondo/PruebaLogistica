Ext.define('MyDesktop.models.ModeloUsuarioConvenioFolio', {
        extend: 'Ext.data.Model',
		fields: [
		    {name: 'idregistro', type: 'int'},
		    {name: 'identidad', type: 'int'},
		    {name: 'idorganizacion', type: 'int'},
		    {name: 'idconvenio', type: 'int'},
		    {name: 'cantidad', type: 'int'},
		    {name: 'utilizada', type: 'int'},
		    {name: 'restante', type: 'int'},
		    {name: 'numcliente', type: 'string'},
		    {name: 'login', type: 'string'},
		    {name: 'idservicio', type: 'string'}

		]
});