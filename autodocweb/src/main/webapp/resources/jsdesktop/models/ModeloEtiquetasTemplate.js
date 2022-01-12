Ext.define('MyDesktop.models.ModeloEtiquetasTemplate', {
        extend: 'Ext.data.Model',
		fields: [
			{name:'idregistro', type:'integer'},
			{name:'idtemplate', type:'string'},
			{name:'identidad', type:'integer'},
			{name:'idorganizacion', type:'integer'},
			{name:'fontsize', type:'integer'},
			{name:'baseline', type:'integer'},
			{name:'ancho', type:'float'},
			{name:'alto', type:'float'},
			{name:'rotation', type:'integer'},
			{name:'x', type:'float'},
			{name:'y', type:'float'},
			{name:'width', type:'float'},
			{name:'heigth', type:'float'},
			{name:'border', type:'float'},
			{name:'font', type:'string'},
			{name:'campo', type:'string'},
			{name:'type', type:'string'},
			{name:'etiqueta', type:'string'},
			{name:'descripcion', type:'string'},
			{name:'bloque', type:'string'},
			{name:'acuseSoloLeyenda', type:'integer'},
			{name:'estructuraguia', type:'string'}
			
			
		  
		]
});