Ext.define('MyDesktop.store.StorePerfil', {        extend: 'Ext.data.Store',        autoDestroy: true,        model: 'MyDesktop.models.ModeloPerfil',	    proxy: {	            type: 'ajax',				url : '../perfilopcion/getPerfilesEntidadOrganizacion',	            reader: {	                type: 'json',	                root: 'proxiArray'	            }	    },	    autoLoad: true,        sorters: [{            property: 'idperfil',            direction: 'ASC'        }]					});