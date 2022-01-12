Ext.define('MyDesktop.store.StoreTipoRecoleccion', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
		        //{"idtipo":"0", "descripcion":"TODAS"},
		        {"idtipo":"1", "descripcion":"ORD. RECOL. X DIA SEMANA"},
		        {"idtipo":"2", "descripcion":"ORD. RECOL. X DIA MES"}
			]
});

