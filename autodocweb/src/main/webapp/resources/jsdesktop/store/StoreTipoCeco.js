/**
 * 
 */
Ext.define('MyDesktop.store.StoreTipoCeco', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
	        	{"idtipo":"984005", "descripcion":"México"},
				{"idtipo":"986005", "descripcion":"León"},
				{"idtipo":"980005", "descripcion":"Guadalajara"},
				{"idtipo":"982005", "descripcion":"Monterrey"}
			]
});