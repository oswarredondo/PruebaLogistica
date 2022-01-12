Ext.define('MyDesktop.store.StoreEtiquetasTemplateDetalle', {	extend: 'Ext.data.Store',    model: 'MyDesktop.models.ModeloEtiquetasTemplate',    autoDestroy: false,    loadMask : true,	autoSave: true,    autoSync: true,    autoLoad: true,    method: 'POST',	idProperty: 'idregistro',  	proxy: {        type: 'ajax',               api: {            read: './template_etiquetas/getDatosTemplateDetalle',            update:'./template_etiquetas/updateJson',        },        reader: {                 type: 'json',                 successProperty: 'success',                 root : 'proxiArray',                 messageProperty: 'message',                 totalProperty : 'totalCount',        },        writer: {            	 type: 'json',                 writeAllFields: true,                 encode: false,                 root: 'proxiArray'        },        listeners: {             exception: function(proxy, response, operation){                     Ext.MessageBox.show({                         title: 'REMOTE EXCEPTION',                         msg: operation.getError(),                         icon: Ext.MessageBox.ERROR,                         buttons: Ext.Msg.OK                     });                 }        },        afterRequest: function (request, success)         {                 //Verifica las llamadas                /* if (request.action == 'read') {                     this.readCallback(request);                 }                                  else if (request.action == 'create') {                     this.createCallback(request);                 }                                  else if (request.action == 'update') {                     this.updateCallback(request);                 }                                  else if (request.action == 'destroy') {                     this.deleteCallback(request);                 }*/         },         readCallback: function (request) {                 if (!request.operation.success)                  {                    /* Ext.Msg.show(                                     {                                    	 title: 'Warning',                                         msg: 'No se pudo leer la informacion',                                         buttons: Ext.Msg.OK,                                         icon: Ext.Msg.WARNING                                     });*/                 }             }         },         sorters: [{            property: 'idregistro',            direction: 'ASC'        }]});