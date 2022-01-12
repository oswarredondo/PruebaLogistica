Ext.define('MyDesktop.models.ModeloPerfil', {
    extend: 'Ext.data.Model',
	fields: [
         {name: 'idperfil'}, {name: 'identidad'},{name: 'idorganizacion'},
         {name: 'descripcion'},  {name: 'estatus'}, {name: 'nivel'},
       {name: 'descripcion_perfil'},{name: 'consecutivo'}
    ]
});