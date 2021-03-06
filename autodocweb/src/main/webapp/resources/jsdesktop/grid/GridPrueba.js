Ext.define('MyDesktop.grid.GridPrueba', {
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
    showBtnSalvar:false,
    stateId: 'stateGridPrueba',
    viewConfig: {
        stripeRows: true,
        enableTextSelection: true
    },
	hidden_cp:false,  
	hidden_garmax:false,
	desc_gar_width:200,
	xtype: 'grid',
	myStore:undefined,
	id:undefined,
	isFrecuenciaCPDestino:false,
	/* Inicio de campos referentes al FormPropiedadesEtiquetas */
	guiamadre : undefined,
	_csrf : undefined,
	uuid : undefined,
	idregistro : undefined,
	tiporotulo : undefined,
	idservicio : undefined,
	numpiezas : undefined,
	contenido : undefined,
	referencia : undefined,
	nacional : undefined,
	tipoempaque : undefined,
	es_multiple : undefined,
	tiene_retorno : undefined,
	tiene_seguro : undefined,
	valordeclarado : undefined,
	valor_asegurado : undefined,
	pesofisico : undefined,
	largo : undefined,
	alto : undefined,
	ancho : undefined,
	observacion : undefined,
	descripcionServicio:undefined,
	/*  Terminana los datos referentes al form */
	/* Validador nos sirve para diferenciar si este grid lo usaremos para agregar datos o solo para observarlos */
	validador:undefined,
	/* storeVerDatos lo usamos para recibir los datos que vamos a visualizar */
	storeVerDatos:undefined,
	//tipobusqueda:1, //1=frecuencia cpdestino, 2=frecuencia origen, destino, garantia
	myScope:undefined,
	initComponent: function () {
		
		/* Para este grid se declaran 2 sotres pero dentrode un if cada uno
		 * Si validador esta indefinido quiere decir que el grid se instancio
		 * para agregar datos pero si no esta indefinido el grid se instancia
		 * para la observacionde un dato concreto */
		
		var scope_main = this;
		
		myScope = scope_main;
		
		if(this.validador == undefined){
			
			/* Se sigue el flujo normal para agregar datos */
			myStore = Ext.create('MyDesktop.store.StoreFrecuenciasEntrega');
			
			this.store = myStore;

			this.selType= 'checkboxmodel';
	        this.columns = [
	                        
//					{header:'Gu??a',dataIndex:'guiamadre',sortable: true,width:80,  menuDisabled: false},
					{header:'Csrf',dataIndex:'_csrf',hidden: true, sortable: true,width:80,  menuDisabled: false}, 
					{header:'UUID',dataIndex:'uuid',hidden: true, sortable: true,width:80,  menuDisabled: false},
					{header:'IdRegistro',dataIndex:'idregistro',hidden: true, sortable: true,width:80,  menuDisabled: false},
					{header:'Tipo Rotulo',dataIndex:'tiporotulo',hidden: true, sortable: true,width:80,  menuDisabled: false},
					
					{header:'Servicio',dataIndex:'idservicio',sortable: true,width:130,  menuDisabled: true,
//						Regresamos el nombre del servicio en lugar del ID
						renderer:function () {
							
								return descripcionServicio;
						}
								
					
					},
					{header:"Cant.", hidden: false,dataIndex:'numpiezas',sortable: true,width:70, menuDisabled: true},
					{header:'Contenido',dataIndex:'contenido',hidden: true, sortable: true,width:80,  menuDisabled: false},
					{header:"Referencia", hidden: false,dataIndex:'referencia',sortable: true,width:100,  menuDisabled: true},
					{header:"Nacional", hidden: false,dataIndex:'nacional',hidden: true, sortable: true,width:100,  menuDisabled: true},
					{header:"Tipo Empaque", hidden: false,dataIndex:'tipoempaque',sortable: true,width:130, menuDisabled: true},
					{header:"Es Multiple", hidden: false,dataIndex:'es_multiple',hidden: true, sortable: true,width:100,  menuDisabled: true},
					{header:"Tiene Retorno", hidden: false,dataIndex:'tiene_retorno',hidden: true, sortable: true,width:100,  menuDisabled: true},
					{header:"Tiene Seguro", hidden: false,dataIndex:'tiene_seguro',hidden: true, sortable: true,width:100,  menuDisabled: true},
					{header:"Valor Declarado", hidden: false,dataIndex:'valordeclarado',hidden: true, sortable: true,width:100,  menuDisabled: true},
					{header:"Valor Aseguradoo", hidden: false,dataIndex:'valor_asegurado',hidden: true, sortable: true,width:100,  menuDisabled: true},
					{header:"Peso", hidden: false,dataIndex:'pesofisico', sortable: true,width:60,  menuDisabled: true}, 
					{header:"Largo", hidden: false,dataIndex:'largo',hidden: true, sortable: true,width:100,  menuDisabled: true},
					{header:"Alto", hidden: false,dataIndex:'alto',hidden: true, sortable: true,width:100,  menuDisabled: true},
					{header:"Ancho", hidden: false,dataIndex:'ancho',hidden: true, sortable: true,width:100,  menuDisabled: true},
					{header:"Observacion", hidden: false,dataIndex:'observacion',hidden: true, sortable: true,width:100,  menuDisabled: true},
					{
					/* Se crean 2 botones, uno para ver datos y el otro para eliminar registros */	
			            xtype:'actioncolumn', 
			            header:'Acciones',
			            width:159,
			            items: [
				            {xtype:'tbseparator'},
				            {
				                icon: './resources/images48x48/Editor16x16Green.png',
				                tooltip: 'Observacion/Contenido',
				                handler: function(grid, rowIndex, colIndex) {
				                	/* se usael scope_main declarado al iniciop de init components
				                	 * para hacer referencia almetodo y row index trae la posicion
				                	 * del dato dentro del store */
				                	scope_main.verDatosGuia(rowIndex);
				                	
				                }                
				            },
				            /* Metodo para borrar los datos seleccionados */
				            {xtype:'tbseparator'},
				            {
				                icon: './resources/images48x48/CloseRed16x16.png',
				                tooltip: 'Borrar registro',
				               
				                handler: function(grid, rowIndex, colIndex) {

				                    var rows =  grid.getSelectionModel().getSelection();
				                 	if(rows.length <=0){
				                 		 Ext.Msg.alert('Verificar',"Seleccione los registros que desea eliminar");
				                 		return;
				                 	}
				            		
				                	 Ext.MessageBox.confirm('Confirmacion', '??Desea borrar el registro seleccionado?', function(id, text){
				                   		if ( (id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){ 
				                   			if(rows.length === 0){ 
				                   				return ;
				                   			}
				                   			/* Set loading nos ayuda a poner una animacion de carga
				                   			 * Esto con el fin de evitar hacer masmovimientos y prevenir
				                   			 * errores*/
				                   			scopeExtends.setLoading('Eliminando datos');			                   			
				                   			
				                   			/* Set time out nos ayuda a ponerun tiempo fijo para realizar las cosas
				                   			 * en esdte caso le damos 500 el equivalente a medio segundo */
				                   			setTimeout(function(){ 
				                   			
					                   			grid.getStore().remove(rows);  
					                   			
					                   			grid.getStore().commitChanges();
				                   				
					                   			scopeExtends.setLoading(false);
				                   				
				                   				
				                   			}, 500);
				                   			
				                   			/* Refrescamos el grid */
				                   			grid.getStore().getView().refresh();
				                   			
				                   		}
				                   	 },this);
				                	 
				                }                
				            }
				          ]
					}
				];
			
		}else{
			
			/* En este punto se sabe que el flujo sol osera para ver datos */
			
			/* Creamos una variable para almacenar el store que recibimos de verDatosGuia()
			 * al momento deinstanciar el gris. NOTA: Ver verDatosGuia() para mayor comprencion */
			var myNewStore = scope_main.storeVerDatos;
			
			/* Creamos una estructura de Store simple y provicional para no usar
			 * Ext.create('MyDesktop.store.StoreFrecuenciasEntrega'); ya que como tenemos
			 * otra instancia de este mismo grid activa para almacenar los datos si la usamos
			 * puede darnos problemas con los datos ya almacenados*/
			this.store = Ext.create('Ext.data.Store', {
			    model: 'MyDesktop.models.ModeloFrecuenciasEntrega',
			    data : [
			        {
			        	_csrf: myNewStore.get('_csrf'),
			        	uuid : myNewStore.get('uuid'),
			        	idregistro : myNewStore.get('idregistro'),
			        	tiporotulo :myNewStore.get('tiporotulo'),
			        	idservicio : myNewStore.get('idservicio'),
			        	numpiezas : myNewStore.get('numpiezas'),
			        	contenido : myNewStore.get('contenido'),
			        	referencia : myNewStore.get('referencia'),
			        	nacional : myNewStore.get('nacional'),
			        	tipoempaque : myNewStore.get('tipoempaque'),
			        	es_multiple : myNewStore.get('es_multiple'),
			        	tiene_retorno : myNewStore.get('tiene_retorno'),
			        	tiene_seguro : myNewStore.get('tiene_seguro'),
			        	valordeclarado : myNewStore.get('valordeclarado'),
			        	valor_asegurado : myNewStore.get('valor_asegurado'),
			        	pesofisico : myNewStore.get('pesofisico'),
			        	largo : myNewStore.get('largo'),
			        	alto : myNewStore.get('alto'),
			        	ancho : myNewStore.get('ancho'),
			        	observacion : myNewStore.get('observacion'),
			        	
			        }
			    ]
			});
			
			/* Se crean las columnas que tendra el grid pero esta ves mostramos mas datos ya que esa es la idea
			 * solo se cambio la propiedad  hidden a true para que las columnas se muestren y muestren los datos*/
			this.columns = [
			
//					 {header:'Gu??a',dataIndex:'guiamadre',sortable: true,width:80, menuDisabled: false}
					{
						header : 'Csrf',
						dataIndex : '_csrf',
						hidden : true,
						sortable : true,
						width : 80,
						menuDisabled : false
					}, {
						header : 'UUID',
						dataIndex : 'uuid',
						hidden : true,
						sortable : true,
						width : 80,
						menuDisabled : false
					}, {
						header : 'IdRegistro',
						dataIndex : 'idregistro',
						hidden : true,
						sortable : true,
						width : 80,
						menuDisabled : false
					}, {
						header : 'Tipo Rotulo',
						dataIndex : 'tiporotulo',
						hidden : true,
						sortable : true,
						width : 80,
						menuDisabled : false
					},
			
					{
						header : 'Servicio',
						dataIndex : 'idservicio',
						sortable : true,
						width : 130,
						menuDisabled : true,
						renderer:function () {
							
							return descripcionServicio;
					}
					}, {
						header : "Cantidad",
						hidden : false,
						dataIndex : 'numpiezas',
						sortable : true,
						width : 100,
						menuDisabled : true
					}, {
						header : 'Contenido',
						dataIndex : 'contenido',
						hidden : false,
						sortable : true,
						width : 80,
						menuDisabled : false
					}, {
						header : "Referencia",
						hidden : false,
						dataIndex : 'referencia',
						sortable : true,
						width : 100,
						menuDisabled : true
					}, {
						header : "Nacional",
						hidden : false,
						dataIndex : 'nacional',
						hidden : false,
						sortable : true,
						width : 100,
						menuDisabled : true
					}, {
						header : "Tipo Empaque",
						hidden : false,
						dataIndex : 'tipoempaque',
						sortable : true,
						width : 130,
						menuDisabled : true
					}, {
						header : "Es Multiple",
						hidden : false,
						dataIndex : 'es_multiple',
						hidden : false,
						sortable : true,
						width : 100,
						menuDisabled : true
					}, {
						header : "Tiene Retorno",
						dataIndex : 'tiene_retorno',
						hidden : false,
						sortable : true,
						width : 100,
						menuDisabled : true
					}, {
						header : "Tiene Seguro",
						dataIndex : 'tiene_seguro',
						hidden : false,
						sortable : true,
						width : 100,
						menuDisabled : true
					}, {
						header : "Valor Declarado",
						hidden : false,
						dataIndex : 'valordeclarado',
						sortable : true,
						width : 100,
						menuDisabled : true
					}, {
						header : "Valor Aseguradoo",
						hidden : false,
						dataIndex : 'valor_asegurado',
						sortable : true,
						width : 100,
						menuDisabled : true
					}, {
						header : "Peso",
						hidden : false,
						dataIndex : 'pesofisico',
						sortable : true,
						width : 60,
						menuDisabled : true
					}, {
						header : "Largo",
						hidden : false,
						dataIndex : 'largo',
						sortable : true,
						width : 100,
						menuDisabled : true
					}, {
						header : "Alto",
						hidden : false,
						dataIndex : 'alto',
						sortable : true,
						width : 100,
						menuDisabled : true
					}, {
						header : "Ancho",
						hidden : false,
						dataIndex : 'ancho',
						sortable : true,
						width : 100,
						menuDisabled : true
					}, {
						header : "Observacion",
						hidden : false,
						dataIndex : 'observacion',
						sortable : true,
						width : 100,
						menuDisabled : true
					}, 
					
					];
		}
        
			this.callParent();
    },
    addRow:function(jsonData,DS,scopeMetodo){
    	
    	scopeExtends = scopeMetodo;
    	
    	descripcionServicio = DS;
    	
    	setTimeout(function(){
    		
        	myStore.add(jsonData);
     		
        	scopeMetodo.setLoading(false);
        	
        	myStore.getView().refresh();
    		
    	}, 500);	
    	
    },
    
    obtenerStoreGrid:function(){

    	var datosGrid = this.getView().getStore();

    	return datosGrid;
    },
	verDatosGuia:function(i){
		
		/* De esta vista obtenemos el Store actual
		 * El store son todos los datos que se han 
		 * almacenado y lo igulamos en una variable*/
		var misDatos = this.getView().getStore();
		/* Creamos una variable en la que guardamos
		 * el store en la posicion "i" esto para obtener
		 * los datos espesificos a ver del store */
		var newStore = misDatos.getAt(i);
 
		try{
			
			/* Instanciamos este mismo grid pero le mandamos
			 * undatoen validador para que cuando lo cree sepa 
			 * que es solo para observar datos, le mandamos tambien
			 * los datos a observar "newStore" y la descripcion del servicio */
			var gridDatos = new MyDesktop.grid.GridDatosGuiaMadre({storeVerDatos:newStore,descripcionServicio:descripcionServicio,validador:0}); 
		
			
		}catch(error){
			
			alert(error);
			
		}
		
		/* Creamos una ventana con las siguientes propiedades
		 * y le mandamos el grid para que lo muestre */
		var datos_window = new Ext.Window({
			width    : 1000,
			height   : 150,
			title	: 'Datos de gu??a',
			closable:true,
			layout:'fit',
			resizable:false,
			modal:true,
			items: [gridDatos] ,
			headerPosition: 'right'	
		}); 
		
		/* Abrimos la ventana */
		datos_window.show();
		
	},
	loadInfo:function(){
		
		this.getView().getStore().load();
		
	},
	
	reLoadInfo:function(
			idservicio,
			numpiezas,
			referencia,
			tipoempaque,
			pesofisico){
		
		this.store.reload({
			params:{
				idservicio:idservicio,
				numpiezas:numpiezas,
				referencia:referencia,
				tipoempaque:tipoempaque,
				pesofisico:pesofisico,
			},
			callback:function(r,options,success){
				 if (r.length<=0){
					/* Ext.Msg.show({
						 title: 'Aviso',
						 msg: 'No existe informaci??n con el criterio de busqueda selecionado.',
						 modal: false,
						 icon: Ext.Msg.INFO,
						 buttons: Ext.Msg.OK						
					 });  */
					
				 }
			 }	  
		});
	
	},
	getRowsSelected:function(){
		return this.getView().getSelectionModel().getSelection();
	},
	cleanRecords:function(){
		this.store.removeAll(true);
	}
});