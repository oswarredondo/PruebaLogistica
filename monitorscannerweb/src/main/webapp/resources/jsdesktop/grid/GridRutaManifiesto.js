 /**
 * Grid para la consulta de historia o mivimientos
 * de un pedido, guia, solicitud, etc
 */
Ext.define('MyDesktop.grid.GridRutaManifiesto', {
    extend: 'Ext.grid.Panel',
    requires: [
               'Ext.grid.column.Action',
               'Ext.grid.plugin.CellEditing',
               'Ext.form.field.Text',
               'Ext.toolbar.TextItem'
           ],
           stateful: true,
           collapsible: false,
           multiSelect: true,
           stateId: 'stateGridRutaManifiesto',

           viewConfig: {
               stripeRows: true,
               enableTextSelection: true
           },
	idfolio:'',
	url:'',
	isConsulta:true,
	mainwindow:undefined,
	constructor: function(config) {
		 //Configura las propiedades
		 this.callParent(arguments);
	     this.initConfig(config);
	     return this;
	},
	
	tipo_str:undefined,
	patron_busqueda:undefined,
	tipo:undefined,
	combo_tipos_busqueda:undefined,
	combo_modalidad:undefined,
	combo_usuarios:undefined,
	initComponent: function(config) {
		var myScope = this;
		this.loadMask=true;
		this.store = Ext.create('MyDesktop.store.StoreRutaManifiesto',{});
		
//		this.selType= 'checkboxmodel';
//		var sm = Ext.create('Ext.selection.CheckboxModel',{mode : 'SINGLE'});
//		this.selModel= sm;

        this.columns = [
            { text   : 'Manifiesto',  width    : 80, sortable : true, hidden:true, dataIndex: 'manifiesto'   },
            { text   : 'Guia Madre',  width    : 100, sortable : true, hidden:false, dataIndex: 'iddocumentomadre'   },
            { text   : 'Guia',  width    : 150, sortable : true, hidden:false, dataIndex: 'idenvio'   },
            { text   : 'Estado',  width    : 200, sortable : true, hidden:false, dataIndex: 'estado'   },
            { text   : 'Ciudad',  width    : 180, sortable : true, hidden:false, dataIndex: 'ciudad'   },
			{ text   : 'Calle',  width    : 180, sortable : true, hidden:false, dataIndex: 'calle'   },
			{ text   : 'Colonia',  width    : 150, sortable : true, hidden:false, dataIndex: 'colonia'   },
			{ text   : 'Municipio',  width    : 150, sortable : true, hidden:false, dataIndex: 'municipio'   },
			{ text   : '#Exterior',  width    : 100, sortable : true, hidden:false, dataIndex: 'numexterior'   },
			{ text   : 'C.P',  width    : 70, sortable : true, hidden:false, dataIndex: 'cp'   },
			{
	            xtype:'actioncolumn', 
	            width:100,
	            header: 'Ubicación',
	            items: [
						
	    	            {xtype:'tbseparator'},
	    	            { 
//	    	                icon: '../resources/images48x48/Stationery-0232x32.png',
	    	                iconCls : 'map_blue',
	    	                tooltip: 'Ver en el mapa',
	    	                handler: function(grid, rowIndex, colIndex) {
	    	                	
	    	                	var rec = grid.getStore().getAt(rowIndex);
	    	                	
	    	                	myScope.searchGMAP(rec);
	    	                	
	    	                }
	    	            },
	                    
	    	            ]
			 }
//			{ header   : 'Ubicacion',  width    : 100, sortable : true, hidden:false, dataIndex: 'cp'   },
			
			];

	        this.tbar=[
	                    {
	                        xtype: 'textfield',
	                        id: 'idmanifiesto',
	                        name: 'Manifiesto :',
	                        fieldLabel: 'Manifiesto',
	                        allowBlank: false  // requires a non-empty value
	                    },
	                    {xtype:'tbseparator'},
						{ iconCls: 'buscar_blue',handler:this.filtraInfo, scope:this}
						
					];
	        
   		 	this.bbar=[
   		 	           
					{xtype:'tbfill'},
					
					{xtype:'tbseparator'},
					
					{
							text : 'Ver Ruta',
							iconCls : 'upload32x32',
							scope:myScope,
							handler : myScope.importar, 
							
							tooltip : 'Importa Datos de un archivo de Excel para su registro'
					},

			];
   		 
   		
        
        this.callParent(arguments);  

		//Carga los datos despues de haber definido el grdi
        this.on('afterlayout', this.loadStore, this, {
            delay: 1,
            single: true
        });
	},
	filtraInfo:function(){
		
		var manifiesto = Ext.getCmp('idmanifiesto').getValue();
		
		if (manifiesto==''){
			mensajeAlert("Debe indicar el patrón a buscar");
     		return;
		}
		
		this.getView().getStore().getProxy().setExtraParam("manifiesto", manifiesto);
		
		this.getView().getStore().reload();

	},
	
	 searchGMAP:function(datos){
			
//		 var myscope = this;
		 var latitud = "";
		 var longitud = "";
		 
		/* if ((latitud=='' ) || (longitud=='')){
			 myscope.getUbicacionMap();
			 mensajeWarning("Latitud y longitud calculadas, intente de nuevo");
			 return;
		 }*/
		
		
		 var cp = datos.get('cp');
		 var colonia = datos.get('colonia');	
		 var municipio = datos.get('municipio');
		 var estado = datos.get('estado');
		 var calle = datos.get('calle');
		 var pais = 'MX';//myscope.getValueField('pais'+ myscope.sufijo);
		
		 
		 if ((cp!='') && (colonia!='') && (municipio!='')&&(estado!='')){
			//En base al sufijo se realiza la actualizacion de los campos
			 //y la obtenci�n de datos
			var datos =  "latitud= " +latitud+"&longitud=" +longitud+ "&colonia=" +colonia +"&municipio=" +municipio+ "&cp=" +cp+ 
					"&estado=" + estado+ "&pais=MX&isadministracion=false&calle=" + calle+ 
					"&idoficina=&telefono=&nombre=";
			showGMapWindows(datos,'','');
			
			//showGMapLatLongWindows(-99.09463690268552,  19.358901156334692);//latitud,longitud);
			
			//var maps_google = Ext.create('MyDesktop.objetos.GoogleMapsObject',{});
			/*maps_google.showMapConDireccion(calle,colonia,municipio, cp, estado, pais,
		    		  longitud , latitud);*/
			//var direccion = calle +', ' + colonia +',' +municipio+',' +cp +',' + pais ;
			//maps_google.showMapConLatitudLongitud(longitud , latitud,direccion);
			
		 }else{
			 mensajeWarning(msg_dato_a_consultar);
			 return;
		 }
			
	 },

	loadInfo:function(){
		this.getView().getStore().load();
	
	},
	reloadInfo:function(){
		this.getView().getStore().reload();
	
	},
	getRowsSelected:function(){
		return this.getView().getSelectionModel().getSelection();
	},

	setScopeWin:function(win){
		this.mainwindow=win;
	},
	commitInfo:function(){
		this.getView().getStore().save( );
		this.getView().getStore().commitChanges();
	
	}
	
});

