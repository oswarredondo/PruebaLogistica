Ext.define('MyDesktop.store.StoreTemplateFont', {
        extend: 'Ext.data.Store',
		fields: ['idtipo', 'descripcion'],
		data : [
				{"idtipo":"Courier", "descripcion":"COURIER"},
				{"idtipo":"Courier-Bold", "descripcion":"Courier-Bold"},
				{"idtipo":"Courier-Oblique", "descripcion":"Courier-Oblique"},
				{"idtipo":"Courier-BoldOblique", "descripcion":"Courier-BoldOblique"},
				{"idtipo":"Helvetica", "descripcion":"Helvetica"},
				{"idtipo":"Helvetica-Bold", "descripcion":"Helvetica-Bold"},
				{"idtipo":"Helvetica-Oblique", "descripcion":"Helvetica-Oblique"},
				{"idtipo":"Helvetica-BoldOblique", "descripcion":"Helvetica-BoldOblique"},
				{"idtipo":"Symbol", "descripcion":"Symbol"},
				{"idtipo":"Times-Roman", "descripcion":"Times-Roman"},
				{"idtipo":"Times-Bold", "descripcion":"Times-Bold"},
				{"idtipo":"Times-Italic", "descripcion":"Times-Italic"},
				{"idtipo":"Times-BoldItalic", "descripcion":"Times-BoldItalic"},
				{"idtipo":"ZapfDingbats", "descripcion":"ZapfDingbats"}
			]
});