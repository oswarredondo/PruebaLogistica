Ext.define('MyDesktop.store.StoreTiposEmpaques', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
				{"idtipo":"SOBRE", "descripcion":"SOBRE"},
				{"idtipo":"PAQUETE", "descripcion":"PAQUETE"},
				{"idtipo":"VALIJA", "descripcion":"VALIJA"},
				{"idtipo":"CAJA", "descripcion":"CAJA"},
				{"idtipo":"PALLET", "descripcion":"PALLET"},
				{"idtipo":"TUBO", "descripcion":"TUBO"},
				{"idtipo":"IRREGULAR", "descripcion":"FORMA IRREGULAR"},
				{"idtipo":"BIG TICKE", "descripcion":"BIG TICKET"},
				{"idtipo":"COLCHON INDIVIDUAL", "descripcion":"COLCHON INDIVIDUAL"},
				{"idtipo":"COLCHON KING SIZE", "descripcion":"COLCHON KING SIZE"},
				{"idtipo":"COLCHON MATRIMONIAL", "descripcion":"COLCHON MATRIMONIAL"},
				{"idtipo":"COLCHON QUEEN SIZE", "descripcion":"COLCHON QUEEN SIZE"},
				{"idtipo":"MOTOCICLETA", "descripcion":"MOTOCICLETA"},
				{"idtipo":"ALLET - LTL", "descripcion":"PALLET - LTL"},
				{"idtipo":"PAQUETE - SERVICIO EXPRESS", "descripcion":"PAQUETE - SERVICIO EXPRESS"},
				{"idtipo":"PAQUETE 1 A 6 PARES", "descripcion":"PAQUETE 1 A 6 PARES"},
				{"idtipo":"PAQUETE 10 A 12 PARES", "descripcion":"PAQUETE 10 A 12 PARES"},
				{"idtipo":"TAMBO", "descripcion":"TAMBO"}
				
			]
});