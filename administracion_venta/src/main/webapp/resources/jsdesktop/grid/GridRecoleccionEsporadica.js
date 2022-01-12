Ext.define('MyDesktop.grid.GridRecoleccionEsporadica', {
    extend: 'Ext.grid.Panel',
    xtype: 'row-expander-grid',
    requires: [
        'Ext.grid.column.Action',
        'Ext.grid.plugin.CellEditing',
        'Ext.form.field.Text',
        'Ext.toolbar.TextItem',
        'Ext.grid.RowNumberer'
    ],
   
    collapsible: false,
    multiSelect: false,
    stateId: 'stateGridRecoleccionEsporadica',
    plugins: [{
        ptype: 'rowexpander',
        rowBodyTpl : new Ext.XTemplate(
        		'<table  id="rounded-corner"><thead>',
    			'<tr><th scope="col"><b>Identificador:</b> {idrecoleccion}({idregistro})<b>,<b>Empaque</b>:{idempaque}, Plaza:</b> {plaza}, <b>Ruta</b>:{rutaasignada}, <b>Fecha</b>:{fecharecol}, <b>Hora/Observacion</b>:{observacion}</th></tr></thead><tbody>',  
               '<tr class="odd"><td><b>Razon Social:</b> {razonsocial}, <b>Atencion</b>:{preguntarpor}</td></tr>',
    			'<tr><td><b>Direccion:</b> {calle}, <b>Colonia</b>:{colonia}, <b>C.P</b>:{cp}, <b>Municipio</b>:{municipio}, <b>Estado</b>:{estado}</td></tr>',
    			'<tr class="odd"><td><b>Telefono:</b> {telefono}, <b>Celular</b>:{celular}</td></tr>', 
    			'<tr><td><b>Cant. Piezas:</b> {cantidadpzas}, <b>Peso kg (pieza)</b>:{pesokg}, <b>Dimensiones(pieza)</b>:Ancho={ancho},Alto={alto},Largo={largo}</td></tr>',
    			'</tbody></table>',
        {
            formatChange: function(v){
                var color = v >= 0 ? 'green' : 'red';
                return '<span style="color: ' + color + ';">' + Ext.util.Format.usMoney(v) + '</span>';
            }
        })
    }],

    viewConfig: {
        stripeRows: false,
        enableTextSelection: true
    },
    stateful: false,
	idregistro:undefined,
	id:undefined,
	isConsulta:false,
	myScope:undefined,
	uuid:undefined,
	mystore:undefined,
	maniana:undefined,
	tiporecol:undefined,
	ismanifiesto:false,
	plaza:undefined,  
	idruta:undefined,
	fecha:undefined,
    initComponent: function () {
    	//Fecha del sistema
    	var myscope = this;
    	var fechaActual=new Date();
    	myscope.maniana = new Date(fechaActual.getTime() + (1 * 24 * 3600 * 1000));
    	var grid_recol;
    	
   	  // this.editing = Ext.create('Ext.grid.plugin.CellEditing',{clicksToEdit: 2});
       this.store = Ext.create('MyDesktop.store.StoreRecolecciones',{});
       
       var isadm = checkEnable('administrar.ordenes.recolecion.administrador');
       
   	
		var gridMenu = Ext.create('Ext.menu.Menu', {    
		    items: [
       	         {text:'Desbloquear',handler:myscope.ejecutaAccionDesbloquear,iconCls:'BLOQUEADO',
       	        	 itemId:'menuItemDesbloquear',name:'menuItemDesbloquear',disabled:isadm, 
       	        	 scope:myscope, hidden:this.ismanifiesto,
       	        	disabled:checkEnable("btn-menu-contextual-opcion-desbloquear-esporadica")	 
       	         },          
     	         {text:'Cancelar',handler:myscope.cancelarRecol,iconCls:'CANCELADA',
       	        		 itemId:'menuItemCamcelar',name:'menuItemCamcelar', scope:myscope, 
       	        		disabled:checkEnable("btn-menu-contextual-opcion-cancelar-esporadica"),
       	        		 hidden:this.ismanifiesto},
     	         {text:'Activar',handler:myscope.activar,iconCls:'ACTIVO',itemId:'menuItemActivar',
     	        	 name:'menuItemActivar', scope:myscope, hidden:this.ismanifiesto,
     	        	disabled:checkEnable("btn-menu-contextual-opcion-activar-esporadica")	 	 
     	         },
     	         {xtype:'menuseparator'},
     	         {text:'Reasignar ruta',handler:myscope.reasignar,iconCls:'ruta_blue',
     	        	 itemId:'menuItemReasignaRuta', 
     	        	 name:'menuItemReasignaRuta', scope:myscope,
     	        	disabled:checkEnable("btn-menu-contextual-opcion-reasignar-ruta-esporadica")		 
     	         },
     	         {text:'Reasignar fecha',handler:myscope.reasignar,iconCls:'fecha_blue',
     	        		 itemId:'menuItemReasignaFecha', name:'menuItemReasignaFecha', scope:myscope,
     	        		disabled:checkEnable("btn-menu-contextual-opcion-reasignar-fecha-esporadica")
     	         },
     	        {xtype:'menuseparator'},
     			 {text:'Reimprime Manifiesto',handler:myscope.reimprimirmanifiesto,iconCls:'IMPRESO',
     	        			 itemId:'menuItemReImprimir', scope:myscope, hidden:!this.ismanifiesto,
     	        			disabled:checkEnable("btn-menu-contextual-opcion-reimprimir-manifiesto-esporadica")
     			 },
			 {xtype:'menuseparator'},
     			 {text:'Ver Historia',handler:myscope.verHistoria,iconCls:'HISTORIA',
     				 itemId:'menuItemVerHistoria', name:'menuItemVerHistoria', scope:myscope},
     			 {xtype:'menuseparator'}
   		            
		       ]
		  }); 
		
		
		
		
		this.listeners= {
		      beforeitemcontextmenu: function(view, record, item, index, e)
		      {
		        e.stopEvent();
		        gridMenu.showAt(e.getXY());
		      }
		};
		
		if ( this.ismanifiesto){
			this.bbar= [
	      		        { iconCls:'IMPRESO',text:'Imprimir Manifiesto', handler:myscope.reimprimirmanifiesto,
	      		        	tooltip:'Genera Orden de Recoleccion', scope:myscope, itemId:'menuItemImprimir' },
     	      			 {xtype:'menuseparator'},
	      	      			 {text:'Puntos Recoleccion',handler:myscope.puntorecoleccion,iconCls:'map_blue',
	      		        			 itemId:'puntosRecoleccionRuta', scope:myscope, hidden:!this.ismanifiesto//,
	      		        			//disabled:checkEnable("btn-menu-contextual-opcion-reimprimir-manifiesto-esporadica")
	      				 },
	      		        {xtype:'tbfill'},
		      		      {
	                            xtype: 'myUpperCaseTextField',
	                            width: 260,
	                            enforceMaxLength:true,
	                            fieldLabel: 'Manifiesto.<font color=red>*</font>',
	                            labelWidth: 90,
	                            name: 'txtmanifiesto',
	                            id:'txtmanifiesto'+this.id,
	                            allowBlank: false,
	                            emptyText: '*REQUERIDO',
	                            maxLength:20
	                        },
	      		        	{ iconCls:'IMPRESO',text:'Reimprimir Manifiesto', handler:myscope.reimprimirmanifiesto,
	                        	itemId:'menuItemImprimirReimprimir' ,
		          		        	tooltip:'Genera una nueva Solicitud de Recoleccion',scope:myscope},
	      		        ];
			
		}else{	
		
			this.bbar= [
	      		        { iconCls:'agregar',itemId:'itemmenuNueva',text:'Orden Recol. Esporadica',
	      		           handler:myscope.showAgregarOrdenRecol,
	      		        	tooltip:'Genera Orden de Recoleccion', scope:myscope,
	      		        	disabled:checkEnable("btn-agregar-solicitud-recoleccion-esporadica")
	      		        },
	      		        { iconCls:'editar',itemId:'itemmenuModificar',text:'Modificar', 
	      		        	handler:myscope.showModificarOrdenRecol,
	          		        	tooltip:'Modificar una Orden de Recoleccion',scope:myscope,
	          		        	disabled:checkEnable("btn-modificar-solicitud-recoleccion-esporadica")
	      		        	 },
	      		        {xtype:'tbfill'},
	          		        	 { iconCls:'manager',text:'Generar Recolecciones del Día',
	          		        		 handler:myscope.generarRecolecciones,
	 	          		        	tooltip:'Modificar una Orden de Recoleccion',scope:myscope,
	 	          		        	disabled:checkEnable("btn-generar-recolecciones-esporadias.dia")
	 	          		        	
	          		        	 },
	      		        ];
			this.tbar= [
		             {xtype:'label', text:'Buscar por:'}, 
		         	{
							xtype: 'combobox',
							id: 'idtipobuquedaEsporadica',
							width:210,
							//labelWidth: 0,
							allowBlank: false,
							store: Ext.create('MyDesktop.store.StoreTipoBusquedaRecoleccion'),
							forceSelection:true,
							valueField: 'idtipo',
							displayField: 'descripcion',
							typeAhead: true,
							queryMode: 'local',
							emptyText: '',
							value:'7'
						},

				       {xtype:'tbseparator'},
			           {xtype:'label', text:'Tipo documento:'},
			           {
							
							xtype: 'combobox',
							id: 'idtipoDocumentoEsporadica',
							width:220,
							//labelWidth: 0,
							allowBlank: false,
							store:Ext.create('MyDesktop.store.StoreTipoRecoleccionEsporadica'),
							forceSelection:true,
							valueField: 'idtipo',
							displayField: 'descripcion',
							typeAhead: true,
							queryMode: 'local',
							emptyText: '',
							value:'3',
							
						},
						
	             
			        	 //{xtype:'hidden', id:'idencabezados', value:encabezados },   
						{xtype:'label', text:'Patrón:'},    
						{xtype:'myUpperCaseTextField', id:'iddatoabuscarEsporadica', maxLength:30,allowBlank:true,width:130 },
						
						{xtype:'tbseparator',hidden:false},
						{xtype:'label', text:'Fecha inicial:',hidden:false}, 
						{ xtype:'datefield',id:'idfechainicioEsporadico',maxLength:30,allowBlank:false,width:105, value:fechaActual,hidden:false },
						//{ xtype:'timefield',id:'idhoraInicial',allowBlank:false,width:80 , format:'H:i'},
						
						{xtype:'tbspacer',hidden:false},
				        {xtype:'label', text:'final:',hidden:false}, 
				        { xtype:'datefield',id:'idfechafinEsporadico',maxLength:30,allowBlank:false,width:105, value:fechaActual,hidden:false},
				       // { xtype:'timefield',id:'idhoraFinal',allowBlank:false,width:80 ,format:'H:i'},
				       // {xtype:'tbseparator'} //,
				        { iconCls:'buscar_blue', handler:myscope.buscaInformacionRecolecciones, scope:this}
			    ];
		
		}
	        
	    var ismenuDesabled=false;
		this.selType= 'checkboxmodel';
        this.columns = [
						{
						    xtype: 'rownumberer'
						},
                    	{
							menuDisabled: true,	sortable: false,
							xtype: 'actioncolumn',	width: 40,
							items: [
								{
									getClass: function(v, meta, rec) {
										
										if (rec.get('estatus') == 'C') {
											return 'CANCELADA' ;
										} if (rec.get('estatus') == 'A'){
											return 'ACTIVO';
										} if (rec.get('estatus') == 'H'){
											return 'HISTORIA';
										}   if (rec.get('estatus') == 'L'){
											return 'BLOQUEADO';
										}
									},
									getTip: function(v, meta, rec) {
										if (rec.get('estatus') == 'C') {
											return 'CANCELADA' ;
										} if (rec.get('estatus') == 'A'){
											return 'ACTIVO';
										} if (rec.get('estatus') == 'H'){
											return 'CON HISTORIA';
										}  if (rec.get('estatus') == 'L'){
											return 'BLOQUEADA';
										}
									},
									handler: function(grid, rowIndex, colIndex) {
										 var rec = grid.getStore().getAt(rowIndex);
										//if (rec.get('estatus') == 'H') {
										 myscope.abreVentanaHistoriaRow(rec);
										//}
									}
								}
							]
						},
						{
							menuDisabled: true,	sortable: false,
							xtype: 'actioncolumn',	width: 40,
							items: [
								{
									getClass: function(v, meta, rec) {
										
										if (rec.get('idtiporecol') == '1') {
											return 'DIARECOL' ;
										} if (rec.get('idtiporecol') == '2'){
											
											return 'DIADELMES';
										} if (rec.get('idtiporecol') == '3'){
											return 'CITARECOL';
										} 
									},
									getTip: function(v, meta, rec) {
										if (rec.get('idtiporecol') == '1') {
											return 'ORD. RECOL. X DIA SEMANA ' ;
										} if (rec.get('idtiporecol') == '2'){
											return 'ORD. RECOL. X DIA MES ';
										} if (rec.get('idtiporecol') == '3'){
											return 'ORD. RECOL. ESPORADICA ';
										} 
									},
									handler: function(grid, rowIndex, colIndex) {
										 var rec = grid.getStore().getAt(rowIndex);
										//if (rec.get('estatus') == 'H') {
												my_scope.abreVentanaHistoriaRow(rec);
										//}
									}
								}
							]
						},
						
						

                        {header   : 'Id. Recol', tooltip:'Identificador',css:css_solicitante, width: 150, sortable : true, hidden:false, dataIndex: 'idrecoleccion' ,menuDisabled: ismenuDesabled  },
                        {header   : 'Manifiesto', tooltip:'Manifiesto',css:css_solicitante, width: 150, sortable : true, hidden:false, dataIndex: 'manifiesto' ,menuDisabled: ismenuDesabled  },
                        
                        {header   : 'Fecha Recol.', tooltip:'Fecha en que se debe realizar la recolección',css:css_solicitante, width: 150, sortable : true, hidden:false, dataIndex: 'fecharecol' ,menuDisabled: ismenuDesabled  },
                        {header   : 'Ruta', tooltip:'Ruta asignada',css:css_solicitante, width: 90, sortable : true, hidden:false, dataIndex: 'rutaasignada' ,menuDisabled: ismenuDesabled  },
                        {header   : 'Quión Solicita', tooltip:'Quión Solicita',css:css_solicitante, width: 210, sortable : true, hidden:false, dataIndex: 'quiensolicita' ,menuDisabled: ismenuDesabled  },
                        { header   : 'Telefono ', tooltip:'Telefono',css:css_solicitante, width: 120, sortable : true, hidden:true, dataIndex: 'telefonosolicita' ,menuDisabled: ismenuDesabled  },
                        { header   : 'Correo E.', tooltip:'Correo E.',css:css_solicitante, width: 120, sortable : true, hidden:true, dataIndex: 'correosolicita' ,menuDisabled: ismenuDesabled  },
                       	           
                        {header   : 'Num.Cte.',tooltip:'N�mero de cliente',css:css_lugarrecol, width    : 120, sortable : true, hidden:false,dataIndex: 'numcliente',menuDisabled: ismenuDesabled },
                        {header   : 'Contrato', tooltip:'Contrato',css:css_lugarrecol,width    : 120, sortable : true, hidden:false,dataIndex: 'contrato',menuDisabled: ismenuDesabled,renderer:formatoCeldaTexto },
                        {header   : 'Razón Social ', tooltip:'Razón Social',css:css_lugarrecol,width    : 190, sortable : true, hidden:false,dataIndex: 'razonsocial',menuDisabled: ismenuDesabled,renderer:formatoCeldaTexto },
                        {header   : 'Atención', tooltip:'Atención',css:css_lugarrecol,width    : 200, sortable : true, hidden:false,dataIndex: 'preguntarpor',menuDisabled: ismenuDesabled,renderer:formatoCeldaTexto },
                        //{id :'calle', header   : 'Dirección', tooltip:'Dirección',css:css_lugarrecol,width    : 200, sortable : true, hidden:false,dataIndex: 'calle',menuDisabled: ismenuDesabled,renderer:formatoCeldaTexto },
                        //{id :'cp', header   : 'C.P', tooltip:'C.P',width    : 70,css:css_lugarrecol, sortable : true, hidden:false,dataIndex: 'cp',menuDisabled: ismenuDesabled,renderer:formatoCeldaTexto },
                        //{id :'estado', header   : 'Estado', tooltip:'Estado',css:css_lugarrecol,width    : 150, sortable : true, hidden:false,dataIndex: 'estado',menuDisabled: ismenuDesabled },
                        //{id :'telefono', header   : 'Tel�fono', tooltip:'Tel�fono',css:css_lugarrecol,width    : 100, sortable : true, hidden:true,dataIndex: 'telefono',menuDisabled: ismenuDesabled },
                        //{id :'email', header   : 'Correo E.', tooltip:'Correo E.',css:css_lugarrecol,width: 150, sortable : true, hidden:true,dataIndex: 'email',menuDisabled: ismenuDesabled },

                        //{id :'observacion', header: 'Hora/Observa',css:css_recoleccion,tooltip:'Hora/observación realizada',width: 90, sortable : true, hidden:false, dataIndex: 'observacion', menuDisabled: ismenuDesabled,menuDisabled: ismenuDesabled,renderer:formatoCeldaTexto },
                        { header   : 'Peso',css:css_recoleccion,tooltip:'Peso total a recolectar', width: 80, sortable : true, hidden:false,dataIndex: 'pesototal',menuDisabled: ismenuDesabled,
                    		renderer:function (value, metaData, record, rowIndex, colIndex, store) {
                    			metaData.attr = 'style="white-space:normal"';
                    			return (record.get('pesokg')* record.get('cantidadpzas') );
                    		} 
	                    },
	                    { header   : 'Volumen',css:css_recoleccion,tooltip:'Volumen total a recolectar', width: 80, sortable : true, hidden:false,dataIndex: 'volumen',menuDisabled: ismenuDesabled,
	                    	renderer:function (value, metaData, record, rowIndex, colIndex, store) {
	                			metaData.attr = 'style="white-space:normal"';
	                			return (record.get('alto')* record.get('ancho')* record.get('largo'))* record.get('cantidadpzas') ;
	                		} 
	                    },
	                    {header   : 'Latitud', tooltip:'Latitud',width    : 200, sortable : true, hidden:false,dataIndex: 'latitud',
	                    	menuDisabled: ismenuDesabled,renderer:formatoCeldaTexto },
	                    {header   : 'Longitud', tooltip:'Longitud',width    : 200, sortable : true, hidden:false,dataIndex: 'longitud',
	                    		menuDisabled: ismenuDesabled,renderer:formatoCeldaTexto }
			];

			this.callParent();
    },
	
    puntorecoleccion:function(){
    	var ruta=this.idruta;
    	var fecha='';
    	var plaza = this.plaza
    	
    	if ((plaza==undefined) || (plaza=='')){
    		mensajeAlert("Seleccione la plaza y ruta que desea visualizar.");
    		return;
    	}
    	
    	if ((ruta==undefined) || (ruta=='')){
    		mensajeAlert("Seleccione la Ruta que desea visualizar.");
    		return;
    	}
    	var datos='tipoconsulta=100&rutaasignada=' + ruta + "&fecha="+ fecha + '&plaza='+plaza ;
    	
    	showPuntosRecoleccionRuta(datos);
    },
   setPlaza:function(plaza){
		this.plaza=plaza;
	},
	setPlaza:function(idruta){
			this.idruta=idruta;
		},
 
	setRutaPlazaFecha:function(idruta,plaza,fecha){
				this.plaza=plaza;
				this.idruta=idruta;
				this.fecha=fecha;
				this.title = ("Busqueda: Plaza:"+ this.plaza +
						", Ruta:" +this.idruta+ ",Fecha:" + this.fecha);
	},
	 
	getRowsSelected:function(){
		return this.getView().getSelectionModel().getSelection();
	},
	reasignar:function (b, e){
		var selected = this.getView().getSelectionModel().getSelection();
		var formareasignar ;
		var tipoasignacion =''; 
		var myscope=this;
		var title ='';
		var indice=0;
		
    	if(selected.length==0){
			mensajeAlert('Seleccione los registros que desea afectar.');
			return;
		}
		if ( (b.id == 'btnReasignaRuta') || (b.itemId == 'menuItemReasignaRuta')){
			
	    	for (indice=0;indice<selected.length;indice++){
	    		if ((selected[indice].get('manifiesto')!=undefined) && (selected[indice].get('manifiesto')!='')){
	    			mensajeAlert('La recolección  [' +selected[indice].get('idrecoleccion')+ '], ' +
	    					'ya fue manifestada, operación inválida.');
	    			return;
	    		}
	    	}
	    	
			title='Indique la nueva ruta';
			formareasignar = new Ext.form.FormPanel({
				border:false,
				labelWidth:40,
				defaults: {
					xtype:'textfield',
					width: 250
				},
				items:[
					{xtype: 'myUpperCaseTextField',
						name:'idrutaasignada',allowBlank:false,maxLength:10,enforceMaxLength:true}
				]
			});

			tipoasignacion = 'btnWinReasignarRuta';
				
		}else 	if ( (b.itemId == 'menuItemReasignaFecha') || (b.itemId == 'btnReasignaFecha')){
			
			var rows = myscope.getView().getSelectionModel().getSelection();
			var indice=0;

	    	for (indice=0;indice<rows.length;indice++){
	    		if ((rows[indice].get('manifiesto')!=undefined) && (rows[indice].get('manifiesto')!='')){
	    			mensajeAlert('La recolección  [' +rows[indice].get('idrecoleccion')+ '], ' +
	    					'ya fue manifestada, operación inválida.');
	    			return;
	    		}
	    		
	    		if (rows[indice].get('idtiporecol')!='3'){
	    			mensajeAlert('La orden de recolección fue generada por una solicitud de ' + 
	    					 rows[indice].get('descripciontiposolicitud') +
	    					' , esta operación solo puede es permitida para ' +
	    					' RECOLECCION ESPORADICAS ' );
	    			return;
	    		}
	    		
	    		if ((rows[indice].get('estatus')=='C') || (rows[indice].get('estatus')=='L')){
	    			var estatus = rows[indice].get('estatus')=='C'?"CANCELADA":"BLOQUEADA";
	    			
	    			mensajeAlert('La orden de recolección ' + rows[indice].get('idrecoleccion') +' ha sido ' +
	    					estatus + ', operación inválida.'	);
	    			return;
	    		}
	    	}

			title='Indique la nueva fecha';
			formareasignar =  new Ext.form.FormPanel({
					border:false,
					labelWidth: 90,
					defaults: {
						xtype:'textfield',
						width: 150
					},
					items:[
						{xtype:'datefield',name:'fechaasignar',width: 200,
							allowBlank:false,minValue:myscope.maniana,value:myscope.maniana}
					]
			});
			tipoasignacion = 'btnWinReasignarFecha';
		}else{
			return;
		}	
		var idmotivocancela='';
		var idrutaasignada='';
		var fechaasignar='';
		
		var winreasignar = new Ext.Window({
			id:'idwinreasignar',
			title: title,
			bodyStyle: 'padding:10px;background-color:#fff;',
			width:300,
			closable:false,
			modal:true,
			height:120,
			items:[formareasignar],
			buttons: [{id:'btnWinReasignarRuta',name:'btnWinReasignarRuta',text:'Reasignar',
						handler:function(){
										var ejecuta_accion='';
							if (tipoasignacion == 'btnWinReasignarFecha'){
								if(!formareasignar.getForm().isValid()){
									mensajeAlert('Capture el valor requerido.');
									
									return;
								}
								ejecuta_accion='actualizaFechaRecoleccion';
								
								
							}else if (tipoasignacion == 'btnWinReasignarRuta'){
								if(!formareasignar.getForm().isValid()){
									alert('Indique la nueva ruta a asignar.');
									return;
								}
								ejecuta_accion='actualizaRutaRecoleccion';
							}else{
								return;
							}

							idmotivocancela=getValueFieldToForm('idmotivocancela',formareasignar);
							idrutaasignada=getValueFieldToForm('idrutaasignada',formareasignar);
							fechaasignar=getRawValueFieldToForm('fechaasignar',formareasignar);
							
							myscope.ejecutaAccion(ejecuta_accion,'',myscope,idmotivocancela,idrutaasignada,fechaasignar);
							winreasignar.close();
						},
						scope:this
					},
					{text:'Salir',handler:function(){
						formareasignar.getForm().reset();winreasignar.hide();},scope:this
					}]
		});	
		
		winreasignar.show();
		
	},
	cancelarRecol:function (obj, e){
		var myscope = this;

		var rows = this.getView().getSelectionModel().getSelection();
    	if(rows.length==0){
			mensajeAlert('Seleccione los registros que desea CANCELAR.');
			return;
		}
    	
    	var formacancelar = new Ext.form.FormPanel({
			border:false,
			labelWidth: 20,
			defaults: {
				xtype:'textfield',
				width: 200
			},
			items:[
				{xtype: 'myUpperCaseTextField',name:'idmotivocancela',
					allowBlank:false,maxLength:50,width:300,enforceMaxLength:true}
			]
		});
	
		var wincancelar  = new Ext.Window({
				id:'idwincancelar',
				title: 'Indique motivo de cancelación',
				bodyStyle: 'padding:10px;background-color:#fff;',
				width:340,
				closable:false,
				modal:true,
				height:120,
				items:[formacancelar],
				buttons: [{id:'btnWinCancelar',name:'btnWinCancelar',text:'Aceptar',
					handler:function(){
						
						myscope.activarCancelar(obj.itemId , formacancelar,rows,myscope);
						wincancelar.close();
					},
					scope:this
				},
				{text:'Salir',handler:function(){
						formacancelar.getForm().reset();wincancelar.hide();
						wincancelar.close();
					
				},scope:this}]
		});	
		wincancelar.show();
	},	
	ejecutaAccion:function (dispatch,estatus,scope,idmotivocancela,idrutaasignada,fechaasignar){
		
		var idsrecoleccion='';
		var rows = this.getView().getSelectionModel().getSelection();
		var indice=0;
    	for (indice=0;indice<rows.length;indice++){
    		idsrecoleccion+=rows[indice].get('idregistro')+','; 
    		if (rows[indice].get('estatus')=='L'){
    			mensajeAlert('Ha seleccionado registros con estatus BLOQUEADO [' +rows[indice].get('idrecoleccion')+ '], ' +
    					'debe desbloquear los registros antes de realizar cualquier otra operación.');
    			return;
    		}
    	}
    	
    	/*var idmotivocancela=Ext.getCmp('idmotivocancela')!=undefined?Ext.getCmp('idmotivocancela').getValue():'';
    	var idrutaasignada=Ext.getCmp('idrutaasignada')!=undefined?Ext.getCmp('idrutaasignada').getValue():'';
    	var fechaasignar=Ext.getCmp('fechaasignar')!=undefined?Ext.getCmp('fechaasignar').getRawValue():'';*/

		var conn = new Ext.data.Connection();
        conn.request({
            url: '../solicitudrecoleccion/'+dispatch,
            method: 'POST',
            params:{
            		idtiporecol:3,
            		idsrecoleccion:idsrecoleccion, 
					estatus:estatus,
					rutaasignada: idrutaasignada==undefined?'':idrutaasignada, 
					fecharecol:fechaasignar==undefined?'':fechaasignar,
					motivocancelacion: idmotivocancela==undefined?'':idmotivocancela
				},
            success: function(response, opts) {
            	
				var obj = Ext.decode(response.responseText);
				scope.buscaInformacionRecolecciones();
		   },
		   failure: function(response, opts) {
				
			  mensajeAlert('server-side failure with status code ' + response.status);
		   }		
        });          
	},

	ejecutaAccionDesbloquear:function (b, e){
		
		var idsrecoleccion='';
		var rows =  this.getView().getSelectionModel().getSelection();
		if (rows.length==0){
			mensajeAlert('Seleccione los registros a desbloquear.');
			return;
		}
		
		var indice=0;
    	for (indice=0;indice<rows.length;indice++){
    		idsrecoleccion+=rows[indice].get('idsolicitud')+','; 
    		if (rows[indice].get('estatus')!='L'){
    			mensajeAlert('Seleccione solo registros con estatus BLOQUEADO.');
    			return;
    		}
    	}
    	
    	 Ext.MessageBox.confirm('Confirma', '�Desea desbloquear los registros seleccionados?',
	  	        	function(btn){
	  			        	if ( (btn=='OK') || (btn=='ok')|| (btn=='YES')|| (btn=='yes') || (btn=='Yes')){
	  			        		var conn = new Ext.data.Connection();
	  			              conn.request({
	  			                  url: '../solicitudrecoleccion/desbloqueaOrdenSolicitudRecoleccion',
	  			                  method: 'POST',
	  			                  params:{
	  			                  	dispatch:'',idtiporecol:3,
	  			              		idsrecoleccion:idsrecoleccion},
	  			                  success: function(response, opts) {
	  			                  	
	  			      				var obj = Ext.decode(response.responseText);
	  			      				if (obj.isOK==false){
	  			      					mensajeAlert(obj.mensaje);
	  			      				}else{
	  			      					buscaInformacionRecolecciones();
	  			      					//alert('');
	  			      					
	  			      				}
	  			        
	  			      		   },
	  			      		   failure: function(response, opts) {
	  			      				
	  			      				mensajeAlert('server-side failure with status code ' + response.status);
	  			      		   }		
	  			              });          
		  			        		
	  			        	}
	  	        	}	
		  , this);
    	 
		
	},
	/**
	* Realiza la activación o cancelación de los registros seleccionados
	*/
	activarCancelar: function (itemId, formacancelar, rows, scope){
		var msgNoSeleccionados ='';	
		var msgConfirmacion ='';	
		var estatus ='';
		//menuItemCamcelar,menuItemActivar
		//btnActivar,btnCancelar
		if ( (itemId == 'btnActivar') || (itemId == 'menuItemActivar')){
			msgNoSeleccionados ="Seleccione los registros que desea cancelar.";
			msgConfirmacion = '�Desea activar todas las ordenes de recoleccion seleccionadas?';
			//Indica el estatus Cancelado para que el action lo cambie a A (Activado)
			estatus='C';
		}else if( (itemId == 'menuItemCamcelar') || (itemId == 'btnCancelar') || (itemId == 'btnWinCancelar' )){
			if(!formacancelar.getForm().isValid()){
				mensajeAlert('Motivo de la cancelación es invalida');
				return;
			}
		
			msgNoSeleccionados ="Seleccione los registros que desea cancelar.";
			msgConfirmacion = '�Desea cancelar todas las ordenes de recoleccion seleccionadas?';
			//Indica el estatus Activo para que el action lo cambie a C (Cancelado)
			estatus='A';
		}	else{
			return;
		}		
    	if(rows.length==0){
			mensajeAlert(msgNoSeleccionados);
			return ;
		}
    	
		var idmotivocancela=getValueFieldToForm('idmotivocancela',formacancelar);
		
		//Confirma si desea cancelar los documentos
		
		  Ext.MessageBox.confirm('Confirma', msgConfirmacion,
  	        	function(btn){
  	        	
  			        	if ( (btn=='OK') || (btn=='ok')|| (btn=='YES')|| (btn=='yes') || (btn=='Yes')){
  			        		scope.ejecutaAccion('cambiaEstatusSolicitudRecoleccion',estatus,scope,idmotivocancela,'','');	
  			        	}
  	        	}	
  	        , scope);
		  
	
	},
	
	activar: function (){
		var scope = this;
		//Indica el estatus C (Cancelado) para que el action lo cambie a A(ACTIVO)
		scope.ejecutaAccion('cambiaEstatusSolicitudRecoleccion','C',scope);	
	},
	/***
	* Genera nuevamente el PDF de un manifiesto ya impreso anteriormente
	*/
	reimprimirmanifiesto:function (b, e){
	
		var mensaje ='';
		var dispatch =''; 
		var manifiesto =  Ext.util.Format.trim(Ext.getCmp('txtmanifiesto'+this.id).getValue()); 
		
		if ( (b.itemId == 'menuItemReImprimir') || (b.id == 'btnReimprimir') || 
				(b.itemId == 'menuItemImprimirReimprimir' )){
		
			if (manifiesto.length==0){
				mensajeAlert('Indique el identificador del manifiesto que desea reimprimir.');
				return;
			}
			
			dispatch='reimprimirManifiesto';
			
		}else if ( (b.itemId == 'menuItemImprimir') || (b.id == 'btnImprimir')){
			mensaje ='Se imprimir� el manfiesto de TODOS los registros ';
			if ( this.idruta.length>0){
				mensaje = mensaje+ ' de la RUTA: ' + this.idruta;
			}else{
				mensaje = mensaje+' de TODAS las rutas.';
			}
			
			dispatch='generaManifiesto';

		}else{
			return;
		}
		
		mensaje = mensaje+' Los registros con estatus CANCELADO '+ 
		' no seran incluidos en el manifiesto '+
		'�Desea imprimir ahora el Manifiesto?';
		
		var myscope= this;
	
		var parametros ="?manifiesto="+manifiesto+
        	"&fechafin="+this.fecha+
        	"&fecharecol="+this.fecha+
        	"&fechainicio="+this.fecha+
        	"&plaza="+this.plaza+
        	"&rutaasignada="+this.idruta;
	  		var url =  '../solicitudrecoleccion/'+ dispatch+parametros;

		  Ext.MessageBox.confirm('Confirma', mensaje,
	  	        	function(btn){
	  			        	if ( (btn=='OK') || (btn=='ok')|| (btn=='YES')|| (btn=='yes') || (btn=='Yes')){
	  			        		
			  			  		
			  			  		visorPDF('utils-win-vista-pdf_reimpresion'+ parametros,
			  			  				"Visor PDF" ,url);
		  			        		
	  			        	}
	  	        	}	
		  , myscope);
		  
	
		
		/*var conn = new Ext.data.Connection();
        conn.request({
            url: '../solicitudrecoleccion/'+ dispatch,
            method: 'POST',
            params:{ 
            	manifiesto:manifiesto,
            	fechafin:this.fecha,
            	fecharecol:this.fecha,
            	fechainicio:this.fecha,
            	plaza:this.plaza,
            	rutaasignada:this.idruta
            },
            success: function(response, opts) {
				var obj = Ext.decode(response.responseText);
				//Envia la info para que se invoque la generacion del PDF con el 
				//Manifiesto indicado
				

		   },
		   failure: function(response, opts) {
			  console.debug('server-side failure with status code ' + response.status);
		   }		
        });    */    
	},
	
	refreshInformacionManifiesto :function (){
		
		this.getView().getStore().reload({
			 params:{
				 tipoconsulta: 100,
				 rutaasignada:this.idruta,
				 plaza:this.plaza
			},
				 callback:function(r,options,success){
					 if (r.length<=0){
						 Ext.Msg.show({
							 title: 'Aviso',
							 msg: 'No existen Ordenes de Recolección para la consulta realizada.',
							 modal: false,
							 icon: Ext.Msg.INFO,
							 buttons: Ext.Msg.OK						
						 });  
					 }
				 }	  
		} );
	},
	buscaInformacionManifiesto :function (ruta,fecha,plaza, myscope){
		myscope.getView().getStore().reload({
			 params:{
				 tipoconsulta: 100,
				 rutaasignada:ruta,
				 plaza:plaza,
				 fechainicio:fecha,
				 fechafin:fecha
			},
				 callback:function(r,options,success){
					 if (r.length<=0){
						 Ext.Msg.show({
							 title: 'Aviso',
							 msg: 'No existen Ordenes de Recolección para la consulta realizada.',
							 modal: false,
							 icon: Ext.Msg.INFO,
							 buttons: Ext.Msg.OK						
						 });  
					 }
				 }	  
		} );
	},
	
	buscaInformacionRecolecciones :function (obj, e){
		var myscope=this;
		//Verifica el tipo de busqueda
		var va= Ext.getCmp('iddatoabuscarEsporadica').getValue();
		var idtiporecol= 3;
		
        var datoabuscar = Ext.getCmp('iddatoabuscarEsporadica').getValue();
        var tipoconsulta = Ext.getCmp('idtipobuquedaEsporadica').getValue();
        var fechainicio = Ext.getCmp('idfechainicioEsporadico').getRawValue();
        var fechafin = Ext.getCmp('idfechafinEsporadico').getRawValue();
         
		if (tipoconsulta!='2'){
			if (datoabuscar==''){
				mensajeAlert('Indique el dato a buscar.');
				return;
			}
			
			if ((tipoconsulta=='1') || (tipoconsulta=='5') ||
				(tipoconsulta=='7') 
				){

				if (va.length<4){
					mensajeAlert('Indique al menos 4 caracteres a buscar');
					return;
				}

			}
		}else{
			if ((fechainicio=='') || (fechafin=='')){
				mensajeAlert('Seleccione fecha inicio y fecha final');
				return;
			}
		}

        
		myscope.getView().getStore().reload({
				 params:{
					 //dispatch:'busquedaSolicitudRecoleccion',
					 idtiporecol:3,
					 idsolicitud:datoabuscar,
					 idrecoleccion:datoabuscar,
					 quiensolicita:datoabuscar,
					 numcliente:datoabuscar,
					 razonsocialcliente:datoabuscar,
				     contrato:datoabuscar,
					 razonsocial:datoabuscar,
					 preguntarpor:datoabuscar,
					 tipoconsulta: tipoconsulta,
					 fechainicio:fechainicio,
					 fechafin:fechafin
				},
					 callback:function(r,options,success){
						 if (r.length<=0){
							 Ext.Msg.show({
								 title: 'Aviso',
								 msg: 'No existen Ordenes de Recolección para la consulta realizada.',
								 modal: false,
								 icon: Ext.Msg.INFO,
								 buttons: Ext.Msg.OK						
							 });  
						 }
					 }	  
		 } );
	},
	verHistoria:function(){
		var rows =  this.getView().getSelectionModel().getSelection();
     	if(rows.length <=0){
     		mensajeAlert("Debe de Seleccionar solo un registro a visualizar. ");
     		return;
     	}
		if(rows.length >1){
     		mensajeAlert("Seleccione solamente un registro a visualizar. ");
     		return;
     	}
		this.abreVentanaHistoriaRow(rows[0]);
	
    }, 
	abreVentanaHistoriaRow:function(row, scope){

		var grid_historia_= new MyDesktop.grid.GridHistoriaRecoleccion({
			autoScroll: true,
		
			forceFit    : true,
			scrollOffset: 0,
			getTotalWidth: function() {
				return "auto";
			},
			iddocumento:row.get('idrecoleccion')

		});
	

		var win_historia = Ext.create('widget.window', {
			id:'utils-win-agregar-cliente',
			title: "Historia:" + row.get('idrecoleccion'),
			width: 900,
			height: 350,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: grid_historia_
			
		});
		//var parametros = {iddocumento:rows[0].get('idDocumento')};
		//Si se desea cambiar el URL que despacha la solicitud
		//grid_historia_cotizaciones.getStore.getProxy().url = '';
		//grid_historia_.buscar(parametros);
		
		win_historia.show()
    	
    },
    
    showAgregarOrdenRecol: function (b, e) {
    	//Crea una forma de clientes para agregar los datos
		var forma_agregar = Ext.create('MyDesktop.form.FormDatosOrdenRecolecionEsporadica',
				{operacion:'agregarSolicitudRecoleccion',
				main_grid:this}); 
		
		var main_window = Ext.create('widget.window', {
			
			title: "Agregar ORD. RECOL. ESPORADICA",
			iconCls: 'agregar',
			width: 900,
			height: 680,
			modal:true,
			resizable:false,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: forma_agregar
			
		});
		main_window.show();
		forma_agregar.setMainWindow(main_window);
		forma_agregar.verificaHoraSistema();
    },
	
    showModificarOrdenRecol: function (b, e) {
    	
    	var rows =  this.getView().getSelectionModel().getSelection();
     	if(rows.length <=0){
     		mensajeAlert("Debe de Seleccionar solo un registro para modificar. ");
     		return;
     	}
		if(rows.length >1){
     		mensajeAlert("Seleccione solamente un registro para modificar. ");
     		return;
     	}
		
		
		
    	//Crea una forma de clientes para agregar los datos
		var forma_agregar = Ext.create('MyDesktop.form.FormDatosOrdenRecolecionEsporadica',
				{id:'agregar_cliente',operacion:'agregarSolicitudRecoleccion',
				main_grid:this, accion:'update'}); 
		
		forma_agregar.updateCampos(rows[0]);

		var main_window = Ext.create('widget.window', {
			id:'utils-win-agregar-cliente1',
			title: "Modificar ORD. RECOL. ESPORADICA",
			iconCls: 'editar',
			width: 900,
			height: 680,
			modal:true,
			resizable:false,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: forma_agregar
			
		});
		main_window.show();
		forma_agregar.setMainWindow(main_window);
		forma_agregar.setPesoTotal(forma_agregar);
		forma_agregar.setVolumenTotal(forma_agregar);
		forma_agregar.verificaHoraSistema();
		
    },
    refreshDatosCreada :function (idsolicitud){
		var myscope=this;
		  var datoabuscar =idsolicitud;
	      var tipoconsulta = '7';
			myscope.getView().getStore().reload({
					 params:{
						 //dispatch:'busquedaSolicitudRecoleccion',
						 idtiporecol:3,
						 idsolicitud:datoabuscar,
						 idrecoleccion:datoabuscar,
						 quiensolicita:datoabuscar,
						 numcliente:datoabuscar,
						 razonsocialcliente:datoabuscar,
					     contrato:datoabuscar,
						 razonsocial:datoabuscar,
						 preguntarpor:datoabuscar,
						 tipoconsulta: '7',
						 fechainicio:'',
						 fechafin:''
					},
						 callback:function(r,options,success){
							 if (r.length<=0){
								 Ext.Msg.show({
									 title: 'Aviso',
									 msg: 'No existen Ordenes de Recolección para la consulta realizada.',
									 modal: false,
									 icon: Ext.Msg.INFO,
									 buttons: Ext.Msg.OK						
								 });  
							 }
						 }	  
			 } );
			
	},
    
    generarRecolecciones:function (idsolicitud){
    	var conn = new Ext.data.Connection();
        conn.request({
            url: '../solicitudrecoleccion/cronGeneraOrdenesRecolecionHoy',
            success: function(response, opts) {
				var obj = Ext.decode(response.responseText);
				mensajeConfirm(obj.message);
		   },
		   failure: function(response, opts) {
				var obj = Ext.decode(response.responseText);
				mensajeAlert(obj.message);
		   }		
        });          
    }
});