Ext.define('MyDesktop.models.ModeloUsuario', {
        extend: 'Ext.data.Model',
		fields: [
		         {name: 'identificador', type: 'string'},
		   {name: 'identidad', type: 'string'},
		   {name: 'idorganizacion', type: 'string'},
		   {name: 'idperfil', type: 'string'},
		   {name: 'nombre', type: 'string'},
		   {name: 'wallpaper', type: 'string'},
		   {name: 'wallpaperstretch', type: 'string'},
		   {name: 'stretch', type: 'string'},
		   {name: 'login', type: 'string'},
		   
		   
		   {name: 'estatus', type: 'string'},
		   {name: 'password', type: 'string'},
		   {name: 'numCliente', type: 'string'},
		   
		   {name: 'numcliente', type: 'string'},//utilizado en administracion de usuarios
		   
		   {name: 'formatoetimedia', type: 'string'},
		   {name: 'formatoetiperso', type: 'string'},
		   {name: 'role_sys', type: 'string'},
		   {name: 'depto', type: 'string'},
		   {name: 'plaza', type: 'string'},
		   {name: 'puesto', type: 'string'},
		   {name: 'idoficina', type: 'string'},
		   {name: 'logo', type: 'string'},
		   {name: 'numempleado', type: 'string'},
		   {name: 'siglasplaza', type: 'string'},
		   {name: 'nivelpuesto', type: 'string'},
		   {name: 'consecutivo', type: 'string'},
		   {name: 'email', type: 'string'},
		   {name: 'idagrupamiento', type: 'integer'},
		   {name: 'visibilidad', type: 'integer'}
		   
		 
		   

		]
}); 