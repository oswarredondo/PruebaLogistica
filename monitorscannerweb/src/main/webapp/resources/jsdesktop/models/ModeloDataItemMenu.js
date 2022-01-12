Ext.define('MyDesktop.models.ModeloDataItemMenu', {
	extend: 'Ext.data.Model',
	fields: [
	{name: 'iconCls', type: 'string'},
	{name: 'windowId',type: 'string'},
	{name: 'text',    type: 'string'},
	{name: 'shortcut',    type: 'string'},
	{name: 'quickstart',    type: 'string'},
	{name: 'image',    type: 'string'},
	{name: 'idopcion',    type: 'string'},
	{name: 'descripcion_opcion',    type: 'string'},
	{name: 'iconCls',    type: 'string'},
	{name:'tooltip', type:'string'},
	{name:'menupadre', type:'string'}
                
	]
});