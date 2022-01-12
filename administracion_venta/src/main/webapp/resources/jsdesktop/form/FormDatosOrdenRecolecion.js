Ext.define('MyDesktop.form.FormDatosOrdenRecolecion', {
    extend: 'MyDesktop.form.FormDatosOrdenObjeto',

    requires: [
        'Ext.form.FieldSet',
        'Ext.form.FieldContainer',
        'Ext.form.field.ComboBox',
        'Ext.form.field.Date',
        'Ext.button.Button',
        'Ext.form.field.Number'
    ],

    height: 647,
    width: 945,
    bodyPadding: 5,
  
    accion:'insert',
   // title: 'Captura Orden de Recolecci�n',
    main_window:undefined,
    main_grid:undefined,
    initComponent: function() {
    	//var store_tipoempaque= Ext.create('MyDesktop.store.StoreTiposEmpaque',{});
    	var isupdate = this.accion=='update'?true:false;
    	var tipos_recoleccion = Ext.create('MyDesktop.store.StoreTipoRecoleccion');
    	 var me = this;
    	  this.tbar = [
                       
    	               {xtype : 'label',id:'lbHoraServer',name:'lbHoraServer',cls:'label_titulo_azul',html: 'Hora Servidor:',columnWidth:1},
                       {xtype:'tbfill'},
              			{xtype : 'label',id:'lbHoraServer_head',name:'lbHoraServer_head',html: '   ',columnWidth:1}
              ];
    	  
       
        this.bbar = [
                     
                     {text:'Guardar Direccion Recolección', scope:this, handler:this.saveDatosCliente}, 
                     {xtype:'tbfill'},
                     {text:'Guardar Datos Recolección',scope:this, handler:this.insertRecoleccion}
            ];   
            this.items= [
       			{xtype:'hidden', name:'idregistrodirrecol',  width: 100},
       			{xtype:'hidden', name:'idregistro',  width: 100},
       			{xtype:'hidden', name:'latitud',  width: 100, id:'latitud'},
       			{xtype:'hidden', name:'longitud',  width: 100, id:'longitud'},
                {
                    xtype: 'fieldset',
                    width: 845,
                    title: '<p>Información del Solicitante</p>',
                    items: [
                        {
                            xtype: 'fieldcontainer',
                            height: 28,
                            layout: 'table',
                            fieldLabel: '',
                            items: [
                                {
                                    xtype: 'myUpperCaseTextField',
                                    width: 230,
                                    enforceMaxLength:true,
                                    fieldLabel: 'Num. Empl.<font color=red>*</font>',
                                    labelWidth: 90,
                                    name: 'numempleado',
                                    allowBlank: false,
                                    emptyText: '*REQUERIDO',
                                    maxLength:10
                                },
                                {
                                    xtype: 'myUpperCaseTextField',
                                    margin: '0 5',
                                    enforceMaxLength:true,
                                    width: 351,
                                    fieldLabel: 'Quién solicita<font color=red>*</font>',
                                    labelWidth: 100,
                                    name: 'quiensolicita',
                                    allowBlank: false,
                                    emptyText: '*REQUERIDO',
                                    maxLength:40
                                },
                                {
                                    width: 230,
                                    xtype: 'textfield',
                                    enforceMaxLength:true,
                                    fieldLabel: 'Correo e',
                                    labelWidth: 60,
                                    name: 'correosolicita',
                                    vtype: 'email',
                                    maxLength:40
                                }
                            ]
                        },
                        {
                            xtype: 'fieldcontainer',
                            height: 28,
                            layout: 'table',
                            fieldLabel: '',
                            items: [
                                { 
                                    xtype: 'myUpperCaseTextField',
                                    width: 230,
                                    labelWidth: 90,
                                    enforceMaxLength:true,
                                    fieldLabel: 'Num. Tel.<font color=red>*</font>',
                                    name: 'telefonosolicita',
                                    allowBlank: false,
                                    emptyText: '*REQUERIDO',
                                    maxLength:20
                                },
                                { 
                                    xtype: 'myUpperCaseTextField',
                                    margin: '0 5',
                                    enforceMaxLength:true,
                                    width: 352,
                                    fieldLabel: 'Tel. Celular',
                                    labelWidth: 100,
                                    name: 'celularsolicita',
                                    maxLength:20
                                },
                                {
                                    xtype: 'myUpperCaseTextField',
                                    width: 230,
                                    enforceMaxLength:true,
                                    fieldLabel: '#Oficina',
                                    labelWidth: 60,
                                    name: 'numoficina',
                                    maxLength:20
                                }
                            ]
                        }
                    ]
                },
                {
                    xtype: 'fieldcontainer',
                    height: 520,
                    width: 858,
                    layout: 'table',
                    fieldLabel: '',
                    items: [
                        {
                            xtype: 'fieldset',
                            height: 470,
                            width: 410,
                            title: 'Datos del cliente',
                            items: [
                                    
								{
									xtype: 'combobox',
									name: 'idtiporecol',
									width:250,
									anchor: '100%',
									fieldLabel: 'Tipo',
									readOnly:isupdate,
									allowBlank: false,
									store: tipos_recoleccion,
									forceSelection:true,
									editable:false,
									valueField: 'idtipo',
									displayField: 'descripcion',
									typeAhead: true,
									queryMode: 'local',
									emptyText: '',
									value:'1',
									 listeners: { 
										 select: function(combo, records, eOpts ){ 
										 },
									     change:function( obj, newValue, oldValue, eOpts )	{
									     
									     }
									 }
								},
								
								  {
                                    xtype: 'fieldcontainer',
                                    height: 26,
                                    fieldLabel: '',
                                    layout: {
                                        type: 'hbox',
                                        align: 'stretch'
                                    },
                                    items: [
                                        {
                                            xtype: 'myUpperCaseTextField',
                                            width: 333,
                                            enforceMaxLength:true,
                                            fieldLabel: 'Empaque',
                                            allowBlank: false,
                                            name: 'idempaque',
                                            maxLength:20
                                        },
                                        { 
                                            xtype: 'button',
                                            margins: '0 0 0 5',
                                            width: 35,
                                            iconCls:'buscar_blue',
                                            handler: this.showTipoEmpaque,
                                            scope:this
                                        }
                                    ]
                                },
                                
							
								
                                {
                                    xtype: 'fieldcontainer',
                                    height: 27,
                                    layout: 'table',
                                    fieldLabel: '',
                                    items: [
                                            {
                                                xtype: 'datefield',
                                                width: 180,
                                                fieldLabel: 'Periodo',
                                                labelWidth: 50,
                                                allowBlank: false,
                                                id:'idfechaini',
                                                name: 'fechainicio'
                                            },
            								 {
                                                xtype: 'datefield',
                                                fieldLabel: 'Al',
                                                anchor: '100%',
                                                allowBlank: false,
                                                width: 180,
                                                labelWidth: 30,
                                                id:'idfechafinal',
                                                name: 'fechafin'

                                            }
                                    ]
                                },
                                {
                                    xtype: 'fieldcontainer',
                                    height: 26,
                                    fieldLabel: '',
                                    layout: {
                                        type: 'hbox',
                                        align: 'stretch'
                                    },
                                    items: [
                                        {
                                            xtype: 'myUpperCaseTextField',
                                            width: 333,
                                            enforceMaxLength:true,
                                            fieldLabel: 'Razón Social',
                                            allowBlank: false,
                                            name: 'razonsocial',
                                            maxLength:40
                                        },
                                        { 
                                            xtype: 'button',
                                            margins: '0 0 0 5',
                                            width: 35,
                                            iconCls:'buscar_blue',
                                            id:'btnDireBuscarRazonSocial',
                                            handler: this.showGridDireccionRecol,
                                            scope:this
                                        }
                                    ]
                                },
                                {
                                    xtype: 'myUpperCaseTextField',
                                    anchor: '100%',
                                    fieldLabel: 'Preguntar por',  
                                    allowBlank: false,
                                    name: 'preguntarpor',
                                    maxLength:40,
                                }, 
                                {
                                    xtype: 'myUpperCaseTextField',
                                    anchor: '100%',
                                    enforceMaxLength:true,
                                    fieldLabel: 'Departamento',
                                    name: 'departamento',
                                    maxLength:40
                                },
                                { 
                                    xtype: 'myUpperCaseTextField',
                                    anchor: '100%',
                                    enforceMaxLength:true,
                                    allowBlank: false,
                                    fieldLabel: 'Calle',
                                    name: 'calle',
                                    maxLength:50
                                },
                                {
                                    xtype: 'fieldcontainer',
                                    height: 26,
                                    fieldLabel: '',
                                    layout: {
                                        type: 'hbox',
                                        align: 'stretch'
                                    },
                                    items: [
                                        {  
                                            xtype: 'myUpperCaseTextField',
                                            width: 331,
                                            enforceMaxLength:true,
                                            allowBlank: false,
                                            fieldLabel: 'Código Postal',
                                            name: 'cp',
                                            maxLength:10
                                        },
                                        { 
                                            xtype: 'button',
                                            margins: '0 0 0 5',
                                            width: 35,
                                            iconCls:'buscar_blue',
                                            id:'btnBuscarCP',
                                            handler: this.showGridCps,
                                            scope:this
                                        }
                                    ]
                                },
                                {
                                    xtype: 'fieldcontainer',
                                    height: 26,
                                    fieldLabel: '',
                                    layout: {
                                        type: 'hbox',
                                        align: 'stretch'
                                    },
                                    items: [
                                        {
                                            xtype: 'myUpperCaseTextField',
                                            width: 331,
                                            enforceMaxLength:true,
                                            fieldLabel: 'Colonia',
                                            allowBlank: false,
                                            name: 'colonia',
                                            maxLength:40
                                        },
                                                                              
                                        {
                                            xtype: 'button',
                                            margins: '0 0 0 5',
                                            width: 35,
                                            iconCls:'buscar_blue',
                                            id:'btnBuscarColonia',
                                            handler: this.showGridCps,
                                            scope:this
                                            
                                        }
                                    ]
                                },
                                {
                                    xtype: 'fieldcontainer',
                                    height: 26,
                                    fieldLabel: '',
                                    layout: {
                                        type: 'hbox',
                                        align: 'stretch'
                                    },
                                    items: [
                                        {
                                            xtype: 'myUpperCaseTextField',
                                            width: 331,
                                            enforceMaxLength:true,
                                            fieldLabel: 'Municipio',
                                            allowBlank: false,
                                            name: 'municipio',
                                            	maxLength:40
                                        },  
                                        {
                                        
                                            xtype: 'button',
                                            margins: '0 0 0 5',
                                            width: 35,
                                            id:'btnBuscarMunicipio',
                                            iconCls:'buscar_blue',
                                            handler: this.showGridCps,
                                            scope:this
                                        }
                                    ]
                                },
                                {
                                    xtype: 'myUpperCaseTextField',
                                    anchor: '100%',
                                    enforceMaxLength:true,
                                    allowBlank: false,
                                    fieldLabel: 'Estado',
                                    name: 'estado', maxLength:40
        
                                }, 
                                {
                                    xtype: 'myUpperCaseTextField',
                                    anchor: '100%',
                                    enforceMaxLength:true,
                                    fieldLabel: 'Teléfono',
                                    name: 'telefono', maxLength:20
                                },
                                {
                                    xtype: 'myUpperCaseTextField',
                                    anchor: '100%',
                                    enforceMaxLength:true,
                                    fieldLabel: 'Num. Celular',
                                    name: 'celular', maxLength:20
                                },
                                {
                                	 xtype: 'textfield',
                                    anchor: '100%',
                                    enforceMaxLength:true,
                                    fieldLabel: 'Correo-e',
                                    name: 'email',
                                    vtype: 'email', maxLength:40
                                }
                            ]
                        },
                        {
                            xtype: 'fieldset',
                            height: 460,
                            margin: '0 0 0 5',
                            width: 431,
                            title: 'Datos complementarios',
                            items: [
                                {
                                    xtype: 'fieldcontainer',
                                    height: 26,
                                    fieldLabel: '',
                                    layout: {
                                        type: 'hbox',
                                        align: 'stretch'
                                    },
                                    items: [
                                        {
                                            xtype: 'myUpperCaseTextField',
                                            width: 331,
                                            enforceMaxLength:true,
                                            fieldLabel: 'Cliente',
                                            allowBlank: false,
                                            name: 'razonsocialcliente',maxLength:40
                                            	
                                        },
                                        {
                                            xtype: 'button',
                                            margins: '0 0 0 5',
                                            width: 35,
                                            iconCls:'buscar_blue',
                                            handler: this.showGridDireccionCuenta,
                                            scope:this
                                           
                                        }
                                    ]
                                },
                                {
                                    xtype: 'myUpperCaseTextField',
                                    anchor: '100%',
                                    enforceMaxLength:true,
                                    fieldLabel: 'Num. Cliente',
                                    allowBlank: false,
                                    
                                    name: 'numcliente',maxLength:10

                                },  
                                {
                                    xtype: 'myUpperCaseTextField',
                                    anchor: '100%',
                                    enforceMaxLength:true,
                                    fieldLabel: 'Contrato',
                                    allowBlank: false,
                                    name: 'contrato',maxLength:20
                                },
                                {
                                    xtype: 'fieldset',
                                    title: 'Dimensiones',
                                    items: [
                                        {
                                            xtype: 'numberfield',
                                            anchor: '100%',
                                            enforceMaxLength:true,
                                            fieldLabel: 'Num. Paquetes',
                                            allowBlank: false,
                                            name: 'cantidadpzas',
                                            value: 1,
                                            minValue: 1,
                                            listeners: {
                                            	blur:function( obj, The, eOpts ){
                                            		
                                            		me.setVolumenTotal(me);  
                                            		me.setPesoTotal(me);
                                               	}
                                            }
                                        }, 
                                        {
                                            xtype: 'numberfield',
                                            anchor: '100%',
                                            enforceMaxLength:true,
                                            fieldLabel: 'Peso Kg',
                                            allowBlank: false,
                                            name: 'pesokg',
                                            value: 1,
                                            minValue: 1,
                                            listeners: {
                                            	blur:function( obj, The, eOpts ){
                                            		
                                            		me.setVolumenTotal(me);  
                                            		me.setPesoTotal(me);
                                               	}
                                            }
                                        },
                                        {
                                            xtype: 'numberfield',
                                            anchor: '100%',
                                            fieldLabel: 'PesoTotal Kg',
                                            name: 'idpesototal',
                                            value: 1,
                                            minValue: 1,
                                            listeners: {
                                            	blur:function( obj, The, eOpts ){
                                            		
                                            		me.setVolumenTotal(me);  
                                            		me.setPesoTotal(me);
                                               	}
                                            }
                                        },
                                        {
                                            xtype: 'numberfield',
                                            anchor: '100%',
                                            enforceMaxLength:true,
                                            fieldLabel: 'Alto',
                                            labelWidth: 100,
                                            allowBlank: false,
                                            name: 'alto',
                                            value: 0,
                                            listeners: {
                                            	blur:function( obj, The, eOpts ){
                                            		
                                            		me.setVolumenTotal(me);  
                                            		me.setPesoTotal(me);
                                               	}
                                            }
                                            
                                        },
                                        {
                                            xtype: 'numberfield',
                                            anchor: '100%',
                                            enforceMaxLength:true,
                                            fieldLabel: 'Ancho',
                                            allowBlank: false,
                                            labelWidth: 100,
                                            name: 'ancho',
                                            value: 0,
                                            listeners: {
                                            	blur:function( obj, The, eOpts ){
                                            		
                                            		me.setVolumenTotal(me);  
                                            		me.setPesoTotal(me);
                                               	}
                                            }
                                        },
                                        {
                                            xtype: 'numberfield',
                                            anchor: '100%',
                                            enforceMaxLength:true,
                                            fieldLabel: 'Largo',
                                            allowBlank: false,
                                            labelWidth: 100,
                                            name: 'largo',
                                            value: 0,
                                            listeners: {
                                            	blur:function( obj, The, eOpts ){
                                            		
                                            		me.setVolumenTotal(me);  
                                            		me.setPesoTotal(me);
                                               	}
                                            }
                                        },
                                        {
                                            xtype: 'numberfield',
                                            anchor: '100%',
                                            enforceMaxLength:true,
                                            fieldLabel: 'Vol. Total',
                                            labelWidth: 100,
                                            name: 'idvolumen',
                                            listeners: {
                                            	blur:function( obj, The, eOpts ){
                                            		
                                            		me.setVolumenTotal(me);  
                                            		me.setPesoTotal(me);
                                               	}
                                            }
                                        }
                                    ]
                                },
                                {
                                    xtype: 'myUpperCaseTextField',
                                    anchor: '100%',
                                    enforceMaxLength:true,
                                    fieldLabel: 'Observación',
                                    name: 'observacion',maxLength: 50
                                },
                                {
                                    xtype: 'myUpperCaseTextField',
                                    anchor: '100%',
                                    enforceMaxLength:true,
                                    fieldLabel: 'Contenido',
                                    name: 'contenido',maxLength: 50,
                                },
                                {
                                    xtype: 'myUpperCaseTextField',
                                    anchor: '100%',
                                    enforceMaxLength:true,
                                    fieldLabel: 'Ruta',
                                    name: 'rutaasignada',maxLength: 10
                                },
                                {
                                    xtype: 'myUpperCaseTextField',
                                    enforceMaxLength:true,
                                    anchor: '100%',
                                    fieldLabel: 'Plaza',
                                    name: 'plaza',maxLength: 4
                                }
                            ]
                        }
                    ]
                }
          ];
      
        	//this.verificaHoraSistema();
        	
        me.callParent(arguments);
    },

    insertRecoleccion:function (){
		var myscope=this;
		var fields = this.getForm().getFields( ) ; 
		var datosSolicitanteForm = Ext.getCmp(this.id).getForm();
		
		var cp = getValueFormField('cp',fields);
		var colonia = getValueFormField('colonia',fields); 
		var municipio = getValueFormField('municipio',fields); 
		var estado = getValueFormField('estado',fields); 
		var numexterior = getValueFormField('numexterior',fields);
		var calle = getValueFormField('calle',fields); 
		var pais = 'MX';//getValueFormField('pais',fields); 

		var longitud = Ext.getCmp('longitud');
		var latitud = Ext.getCmp('latitud' );
		//Optiene datos de longitud y latitud
		var maps_google = Ext.create(
				'MyDesktop.objetos.GoogleMapsObject', {});
		maps_google.getCoordenadas(calle + " " + numexterior,
				colonia, municipio, cp, estado, pais, longitud,
				latitud);
		
		Ext.MessageBox.wait("Obteniendo coordenadas [LATITUD/LONGITUD]...");
	    Ext.defer(function () {
	        Ext.MessageBox.close();
	        myscope.agregaRecoleccion();
	    }, 8000);
	    
	
		
		
	},
    agregaRecoleccion:function (){
    

    	var myscope=this;
		var fields = this.getForm().getFields( ) ; 
		var datosSolicitanteForm = Ext.getCmp(this.id).getForm();
		
   	 	Ext.MessageBox.confirm('Confirmar','¿Desea generar registro de recolección?', 
			 function(id, text){
       			if ( (id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){ 
       				
       				var tipo_empaque = getValueFormField('idempaque',fields);

       				if (!datosSolicitanteForm.isValid()) {
       					mensajeAlert('Complete los datos requeridos, verifique');
       					return;
       				}
       				var tipo_recoleccion = getValueFormField('idtiporecol',fields);
       				
       				if (tipo_recoleccion==''){
       					mensajeAlert('Seleccione el tipo de recolección que desea realizar');
       					return;
       				}
       				
       				
       				if (tipo_empaque==''){
       					mensajeAlert('Seleccione el tipo de empaque');
       					return;
       				}
       				
       			
       				var mensaje_carga='';
       				if (myscope.accion=='update'){
       					mensaje_carga = "Actualizando " + mensaje_carga;
       				}else{
       					mensaje_carga = "Creando " + mensaje_carga;
       				}
       				
 
       				var conn = new Ext.data.Connection();
       		        conn.request({
       		            url: '../solicitudrecoleccion/agregarSolicitudRecoleccion',
       		            timeout:99999,
       		            params:{
       		            	idregistro:getValueFormField('idregistro',fields) ,
       		            	dispatch:'agregarSolicitudRecoleccion',accion:myscope.accion,
       		            	numcliente:getValueFormField('numcliente',fields) ,
       		            	razonsocialcliente:getValueFormField('razonsocialcliente',fields) ,
       		            	contrato:getValueFormField('contrato',fields) ,
       		            	numempleado:getValueFormField('numempleado',fields) ,
       		            	quiensolicita:getValueFormField('quiensolicita',fields), 
       		            	correosolicita:getValueFormField('correosolicita',fields) ,
       		            	telefonosolicita:getValueFormField('telefonosolicita',fields), 
       		            	celularsolicita:getValueFormField('celularsolicita',fields), 
       		            	numoficina:getValueFormField('numoficina',fields) ,
       		            	
       		            	idtiporecol:tipo_recoleccion,
       		            	idempaque:tipo_empaque,
       		            	fechainicio:getRawValueFormField('fechainicio',fields) ,
       		            	fechafin:getRawValueFormField('fechafin',fields), 
       		            	fecharecol:getRawValueFormField('fechainicio',fields) ,
       		            	
       		            	razonsocial:getValueFormField('razonsocial',fields) ,
       		            	preguntarpor: getValueFormField('preguntarpor',fields) ,
       		            	departamento:getValueFormField('departamento',fields) ,
       		            	calle:getValueFormField('calle',fields)  ,
       		            	cp:getValueFormField('cp',fields) ,
       		            	colonia:getValueFormField('colonia',fields) ,
       		            		
       		            	municipio:getValueFormField('municipio',fields) ,
       		            	estado:getValueFormField('alto',fields) ,
       		            	telefono:getValueFormField('telefono',fields) ,
       		            	celular:getValueFormField('celular',fields) ,
       		            	email:getValueFormField('email',fields) ,
       		            	
       		            	cantidadpzas:getValueFormField('cantidadpzas',fields) ,
       		            	//correosolicita:getValueFormField('correosolicita',fields) ,
       		            	 pesokg:getValueFormField('pesokg',fields) ,
       		            	 pesototal:getValueFormField('idpesototal',fields) ,
       		            	 alto:getValueFormField('alto',fields) ,
       		            	 ancho:getValueFormField('ancho',fields) ,
       		            	 largo:getValueFormField('largo',fields) ,
       		            	 volumen:getValueFormField('idvolumen',fields) ,
       		            	 
       		            	latitud:getValueFormField('latitud',fields),
       		            	longitud:getValueFormField('longitud',fields),
       		            	
       		            	contenido:getValueFormField('contenido',fields) ,
       		            	observacion:getValueFormField('observacion',fields) ,
       		            	plaza:getValueFormField('plaza',fields) ,
       		            	rutaasignada:getValueFormField('rutaasignada',fields)// , 
       						//idsolicitud:idsolicitud,
       						//idrecoleccion:idsolicitud
       						
       					},
       		            success: function(response, opts) {
       					  var obj = Ext.decode(response.responseText);
       					  
       					  if (obj.success==true){
       						  if( myscope.main_grid!=undefined){
       							  myscope.main_grid.refreshDatosCreada(obj.Idsolicitud,tipo_recoleccion);
       						  }
       						  if( myscope.main_window!=undefined){
       							  myscope.main_window.close();
       						  }
       					  }else{
       						  mensajeAlert(obj.message);
       							return;
       					  }
       					 
       				   },
       				   failure: function(response, opts) {
       					   var obj = Ext.decode(response.responseText);
       					   mensajeAlert(obj.message);
       					   return;
       				   }		
       		        });          
       				
       				
       			}
	 		}
   	 	,myscope);
    }
	
  

});