Ext.define('MyDesktop.store.StoreMercanciaSat', {
	extend: 'Ext.data.Store',
	model: 'MyDesktop.models.ModeloMercanciaSat',
	autoDestroy: false,
	loadMask: true,
	autoSave: false,
    autoLoad: true,
    autoSync: true,
	idProperty: 'descripcionmcia',
	proxy: {
		type: 'ajax',
		api: {
			read: './api_unigis/getMercanciaSat'
		},
		reader: {
			type: 'json',
			successProperty: 'success',
			root: 'proxiArray',
			messageProperty: 'message',
			totalProperty: 'totalCount',
		},
		writer: {
			type: 'json',
			writeAllFields: true,
			encode: false,
			root: 'proxiArray'
		}
	},
	sorters: [{
		property: 'descripcionmcia',
		direction: 'ASC'
	}]
});

