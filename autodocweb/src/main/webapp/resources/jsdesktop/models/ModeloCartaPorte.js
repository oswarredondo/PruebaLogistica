Ext.define('MyDesktop.models.ModeloCartaPorte', {
        extend: 'Ext.data.Model',
		fields: [  
		        { name:'idControl'}, 
				{ name:'idViaje'},
				{ name:'fecha'},
				{ name:'cliente'},
				{ name:'factura'},
				{ name:'estatus'},    
				{ name:'referencia'},
				{ name:'mensaje'}	
		  
		]
});