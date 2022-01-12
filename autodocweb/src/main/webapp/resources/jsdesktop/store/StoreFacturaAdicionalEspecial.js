Ext.define('MyDesktop.store.StoreFacturaAdicionalEspecial', {	extend: 'Ext.data.Store',    model: 'MyDesktop.models.ModeloFacturaResumen',    autoDestroy: false,    loadMask : true,	autoSave: false,    autoSync: false,    autoLoad: true,	idProperty: 'cp',  	proxy: {        	type: 'ajax',        	api: {	            read: './factura/materialespecial/getDatos'        	},        	reader: {                 type: 'json',                 successProperty: 'success',                 root : 'proxiArray',                 messageProperty: 'message',                 totalProperty : 'totalCount',        	},        	writer: {            	 type: 'json',                 writeAllFields: true,                 encode: false,                 root: 'proxiArray'        	},        	listeners: {             exception: function(proxy, response, operation){                 }        	},        	afterRequest: function (request, success)         	{                 //Verifica las llamadas                 if (request.action == 'read') {                     this.readCallback(request);                 }                                  else if (request.action == 'create') {                     this.createCallback(request);                 }                                  else if (request.action == 'update') {                     this.updateCallback(request);                 }                                  else if (request.action == 'destroy') {                     this.deleteCallback(request);                 }         	},         	readCallback: function (request) {                 if (!request.operation.success)  {}             }         },         sorters: [{            property: 'identificador',            direction: 'ASC'        }]});