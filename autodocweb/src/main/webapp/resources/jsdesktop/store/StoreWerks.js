Ext.define('MyDesktop.store.StoreWerks', {	extend: 'Ext.data.Store',    model: 'MyDesktop.models.ModeloWerks',    autoDestroy: false,    loadMask : true,	autoSave: false,    autoSync: false,    autoLoad: true,	idProperty: 'werks',  	proxy: {        	type: 'ajax',        	api: {	            read: './facturaresumen/getWerks'        	},        	reader: {                 type: 'json',                 successProperty: 'success',                 root : 'proxiArray',                 messageProperty: 'message',                 totalProperty : 'totalCount',        	}        },        sorters: [{            property: 'werks',            direction: 'ASC'        }]});