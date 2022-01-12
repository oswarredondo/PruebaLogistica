Ext.define('MyDesktop.store.StoreTiposImportaciaTareas', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion','image'],
		data : [
		        {"idtipo":"URGENTE", "descripcion":"URGENTE",'image':'Flag16x16Red.png'},
				{"idtipo":"ALTO", "descripcion":"ALTO",'image':'Flag16x16Pink.png'},
				{"idtipo":"MEDIO", "descripcion":"MEDIO",'image':'Flag16x16Green.png'},
				{"idtipo":"BAJO", "descripcion":"BAJO",'image':'Flag16x16Yellow.png'}
			]
});