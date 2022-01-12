/**
 * 
 */
Ext.define('MyDesktop.store.StoreTipoSector', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
	        	{"idtipo":"1", "descripcion":"01"},
				{"idtipo":"2", "descripcion":"11"},
				{"idtipo":"3", "descripcion":"12"},
				{"idtipo":"4", "descripcion":"13"},
				{"idtipo":"5", "descripcion":"15"},
				{"idtipo":"6", "descripcion":"18"}
			]
});