Ext.define('MyDesktop.store.StoreTiposEmpaque', {
	extend: 'Ext.data.Store',
    model: 'MyDesktop.models.ModeloAdicionales',
    autoDestroy: false,
    loadMask : true,
	autoSave: false,
    autoSync: false,
    autoLoad: true,
	idProperty: 'descripcion',  
	proxy: {
        type: 'ajax',
        api: {
            read: '../catalogos/datos/getTiposEmpaques'
        },
        reader: {
                 type: 'json',
                 successProperty: 'success',
                 root : 'proxiArray',
                 messageProperty: 'message',
                 totalProperty : 'totalCount',
        },
        writer: {
            	 type: 'json',
                 writeAllFields: true,
                 encode: false,
                 root: 'proxiArray'
        },
        listeners: {
             exception: function(proxy, response, operation){
                     Ext.MessageBox.show({
                         title: 'REMOTE EXCEPTION',
                         msg: operation.getError(),
                         icon: Ext.MessageBox.ERROR,
                         buttons: Ext.Msg.OK
                     });
                 }
        },
        afterRequest: function (request, success) 
        {
                 //Verifica las llamadas
                 if (request.action == 'read') {
                     this.readCallback(request);
                 }
                 
                 else if (request.action == 'create') {
                     this.createCallback(request);
                 }
                 
                 else if (request.action == 'update') {
                     this.updateCallback(request);
                 }
                 
                 else if (request.action == 'destroy') {
                     this.deleteCallback(request);
                 }
         },
         readCallback: function (request) {
                 if (!request.operation.success) 
                 {
                     Ext.Msg.show(
                                     {
                                    	 title: 'Warning',
                                         msg: 'No se pudo leer la informacion',
                                         buttons: Ext.Msg.OK,
                                         icon: Ext.Msg.WARNING
                                     });
                 }
             }
         }, 
        sorters: [{
            property: 'identificador',
            direction: 'ASC'
        }]
});



/*Ext.define('MyDesktop.store.StoreTiposEmpaque', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
				 {
                    idtipo: '1',
                    descripcion: 'SOBRES'
                },
                {
                    idtipo: '2',
                    descripcion: 'PAQUETES'
                },
                {
                    idtipo: '3',
                    descripcion: 'CAJAS'
                },
                {
                    idtipo: '4',
                    descripcion: 'PALLETS'
                },
                {
                    idtipo: '5',
                    descripcion: 'TUBOS'
                },
                {
                    idtipo: '6',
                    descripcion: 'BULTOS'
                },
                {
                    idtipo: '7',
                    descripcion: 'VALIJAS'
                },
                {
                    idtipo: '8',
                    descripcion: 'IRREGULARES'
                }
			]
});*/
