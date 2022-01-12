Ext.define('MyDesktop.models.ModeloClientes', {
        extend: 'Ext.data.Model',
		fields: [
		   {name: 'idcliente', type: 'integer'},
		   {name: 'atencion', type: 'string'},
		   {name: 'razonsocial', type: 'string'},
		   {name: 'razonSocial', type: 'string'},//Utiliado en cuentas cliente
		   {name: 'identificador', type: 'string'},//Utiliado en cuentas cliente
		   
		   {name: 'correoe', type: 'string'},
		   {name: 'estatus', type: 'string'},
		   {name: 'numcliente', type: 'string'},
		   {name: 'numCliente', type: 'string'},//Utiliado en cuentas cliente
		   {name: 'cuentaMaestra', type: 'string'},//Utiliado en cuentas cliente
		   {name: 'tipopersona', type: 'string' },
		   {name: 'tipocliente', type: 'string' },
		   {name: 'clasificacion', type: 'string' },
		   {name: 'contrato', type: 'string' },
		   {name: 'idregistro', type: 'string' },
		   {name: 'depto', type: 'string' },
		   {name: 'numcelular', type: 'string' },
		     
		  
		   {name: 'logincreador', type: 'string' },
		   
		   {name: 'nombre', type: 'string'},
		   {name: 'descripcion', type: 'string'},
		   {name: 'referencia', type: 'string'},
		   {name: 'promotor', type: 'string'},
		   {name: 'rfc', type: 'string'},
		   {name: 'status', type: 'int'},
		   {name: 'fechaalta', type: 'string'},
		   {name: 'creditolimite', type: 'float'},
		   {name: 'creditousado', type: 'float'},
		   {name: 'cuentabancaria', type: 'string'},
		   {name: 'idgrupo', type: 'string'},
		   {name: 'idformapago', type: 'string'},
		   {name: 'idterminopago', type: 'string'},
		   {name: 'idrepventas', type: 'string'},
		   {name: 'idimpuesto', type: 'string'},
		   {name: 'iddireccion', type: 'string'},
		   {name: 'tipo', type: 'string'},
		   {name: 'calle', type: 'string'},
		   {name: 'numinterior', type: 'string'},
		   {name: 'numexterior', type: 'string'},
		   {name: 'cp', type: 'string'},
			{name: 'colonia', type: 'string'},
		   {name: 'municipio', type: 'string'},
		    {name: 'estado', type: 'string'},
			{name: 'email', type: 'string'},
			{name: 'telefono', type: 'string'},
			{name: 'movil', type: 'string'},
			{name: 'idplaza', type: 'string'},
			{name: 'idprogramafactura', type: 'string'},
			{name: 'tipo', type: 'string'},
			{name: 'observacion', type: 'string'},
			
			{name: 'descripcionFormapago', type: 'string'},
			{name: 'descripcionTerminoPago', type: 'string'},
			{name: 'descripcionRepresentanteVentas', type: 'string'},
			
			{name: 'descripcionImpuesto', type: 'string'},
			{name: 'descripcionPlaza', type: 'string'},
			{name: 'descripcionPoblacionpago', type: 'string'},
			{name: 'descripcionProgramaFactura', type: 'string'},
			{name: 'descripcionRegimen', type: 'string'},
			{name: 'descripcionTipoPesona', type: 'string'},
			{name: 'clavegrupo', type: 'string'},
			{name: 'descripcionGrupoCliente', type: 'string'}
			
			

	
		]
});