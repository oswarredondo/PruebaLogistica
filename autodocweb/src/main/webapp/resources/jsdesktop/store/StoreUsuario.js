Ext.define('MyDesktop.store.StoreUsuario', {        extend: 'Ext.data.Store',        autoDestroy: true,        model: 'MyDesktop.models.ModeloUsuario',	    proxy: {	            type: 'ajax',				url : './catalogo/usuario/getUsuariosCuenta',	            reader: {	                type: 'json',	                root: 'proxiArray'	            }	    },	    autoLoad: false,        sorters: [{            property: 'nombre',            direction: 'ASC'        }]		});