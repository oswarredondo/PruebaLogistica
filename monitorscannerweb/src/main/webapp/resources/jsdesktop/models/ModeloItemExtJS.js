Ext.define('MyDesktop.models.ModeloItemExtJS', {
        extend: 'Ext.data.Model',
		fields: [

		   {name: 'name', type: 'string'},      
		   {name: 'value', type: 'string'},
		   {name: 'xtype', type: 'string'},
		   {name: 'id', type: 'string'},
		   {name: 'fieldLabel', type: 'string'},
		   {name: 'anchor', type: 'string'},
		   {name: 'maxValue', type: 'float'},
		   {name: 'minValue', type: 'float'},
		   {name: 'decimalPrecision', type: 'int'},
		   {name: 'decimalSeparator', type: 'string'},
		   {name: 'checked', type: 'boolean'}
		]
});