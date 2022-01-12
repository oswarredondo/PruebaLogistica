Ext.define('MyDesktop.models.ModeloReimpresionEtiqueta', {
        extend: 'Ext.data.Model',
		fields: [
     
		   {name: 'remite', type: 'string'},
		   {name: 'destino', type: 'string'},
		   {name: 'cantidad', type: 'float'},
		   {name: 'idregistro', type: 'string'},
		   {name: 'fechacreacion', type: 'string'}, 
		   {name: 'uuid', type: 'string'} 
		]
});