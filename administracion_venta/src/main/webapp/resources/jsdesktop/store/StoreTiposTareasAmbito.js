Ext.define('MyDesktop.store.StoreTiposTareasAmbito', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion','image'],
		data : [
		        {"idtipo":"TODOS", "descripcion":"TODOS", "image":"Conference-All16x16Blue.png"},
		        {"idtipo":"USUARIO", "descripcion":"USUARIO", "image":"User-Profile16x16Blue.png"},
				{"idtipo":"GRUPO", "descripcion":"GRUPO", "image":"Group-Modify16x16Blue.png"},
				{"idtipo":"NIVEL", "descripcion":"PUESTO(NIVEL)", "image":"Graph-Diagram16x16Blue.png"}
			]
});