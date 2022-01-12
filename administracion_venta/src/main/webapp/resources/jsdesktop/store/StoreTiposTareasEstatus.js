Ext.define('MyDesktop.store.StoreTiposTareasEstatus', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion','image'],
		data : [
		        {"idtipo":"ABIERTA", "descripcion":"ABIERTA",'image':'Book-Open16x16Blue.png'},
				{"idtipo":"RECHAZADA", "descripcion":"RECHAZADA",'image':'Ignore16x16Blue.png'},
				{"idtipo":"REASIGNADA", "descripcion":"REASIGNADA",'image':'Account-Payable16x16Geen.png'},
				{"idtipo":"CERRADA", "descripcion":"CERRADA",'image':'Book-Close16x16Blue.png'},
				{"idtipo":"CANCELADA", "descripcion":"CANCELADA",'image':'Cancel16x16Red.png'},
				{"idtipo":"ACEPTADA", "descripcion":"ACEPTADA",'image':'Like16x16Blue.png'}
			]
});



