Ext.define('MyDesktop.store.StoreCampos', {        extend: 'Ext.data.Store',        autoDestroy: true,        model: 'MyDesktop.models.ModeloServicio',        proxy: {            type: 'memory'        },        sorters: [{            property: 'identificador',            direction: 'ASC'        }],		 data: [			{identificador:'0001', descripcion:'Mi descripcion'}		]			});