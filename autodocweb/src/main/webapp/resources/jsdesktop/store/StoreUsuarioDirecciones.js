Ext.define('MyDesktop.store.StoreUsuarioDirecciones', {        extend: 'Ext.data.Store',        autoDestroy: false,        loadMask : true,    	autoSave: false,        autoSync: false,        autoLoad: true,        model: 'MyDesktop.models.ModeloUsuario',	    proxy: {	            type: 'ajax',				url : './catalogo/usuario/getUsuariosCuentaDirecciones',	            reader: {	                type: 'json',	                root: 'proxiArray'	            }	    },        sorters: [{            property: 'nombre',            direction: 'ASC'        }]		});