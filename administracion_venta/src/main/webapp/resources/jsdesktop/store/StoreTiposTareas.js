Ext.define('MyDesktop.store.StoreTiposTareas', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion','image'],
		data : [
		        {"idtipo":"NOTIFICACION", "descripcion":"NOTIFICACION", "image":"Message-Edit16x16Red.png"},
		        {"idtipo":"ALERTA", "descripcion":"ALERTA","image":"Warning-Message16x16Red.png"},
		        {"idtipo":"AVISO", "descripcion":"AVISO", "image":"Message-Information16x16Yellow.png"},
				{"idtipo":"SOLICITUD", "descripcion":"SOLICITUD", "image":"Messages16x16Blue.png"}
			]
});