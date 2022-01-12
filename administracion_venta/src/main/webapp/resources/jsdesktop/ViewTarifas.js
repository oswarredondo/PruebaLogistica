/*!
 * Administracicion de tarifas
 */

Ext.define('MyDesktop.ViewTarifas', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'tarifas-win',

    init : function(){
        this.launcher = {
            text: 'Tarifas',
            iconCls:'tarifas_blue'
        }
    },
	grid_tarifas:undefined,
	combo_tipos_busqueda:undefined,
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope=this;
		this.combo_tipos_busqueda= Ext.create('Ext.form.ComboBox', {
					fieldLabel: '',
					 width: 150,
					disabled: false,
					editable:false,
					//forceSelection:true,
					store: Ext.create('MyDesktop.store.StoreTiposBusquedaTarifas',{}) ,
					queryMode: 'local',
					emptyText: 'Seleccione orden',
					displayField: 'descripcion',
					valueField: 'idtipo'
		});
		this.combo_tipos_busqueda.setValue("01");
		this.combo_tipos_busqueda.setRawValue("Nombre");
		
		this.grid_tarifas = new MyDesktop.view.GridTarifas();
		
        if(!win){
        	
        	win = desktop.createWindow({
  				
                  id: this.id,
                  title:'Tarifas',
                  iconCls: 'tarifas_blue',
                  border:false,
                  constrainHeader:false,
                  maximized :true,
  					maximizable:false,
                  closable: true,
                  closeAction: 'hide',
                  width: 1300,
                  height: 500,
  				layout: 'fit',
  				tbar:[
  					{xtype: 'label', text:'Buscar por:'	},
  					this.combo_tipos_busqueda,
  					{xtype: 'label', text:'Patrón:'	},
  					{xtype: 'myUpperCaseTextField' , id:'idpatronbusquedatarifas', allowBlank: false, width: 100},
  					{
			            xtype: 'datefield',
			            id:'idfechainicialbusquedatarifas',
			            fieldLabel: 'Fecha Inicial',
			            name:'fechainicial',
			            format: 'd-m-Y',
			            labelWidth: 80,
			            width: 190
  					}, 
  					{
			            xtype: 'datefield',
			            id:'idfechafinalbusquedatarifas',
			            fieldLabel: 'Fecha Final',
			            name:'fechafinal',
			            format: 'd-m-Y',
			            labelWidth: 80,
			            width: 190
  					},
  					{ iconCls: 'buscar_blue',handler:this.filtrar, scope:this.myScope}

  				],
  				
  				bbar:[
    						{ text: 'Rangos Envios',iconCls: 'detalles',handler:this.showDetails, scope:this.myScope },
    						{xtype: 'tbfill'},
    						{xtype:'tbseparator'},
    						{ text: 'Agregar',iconCls: 'agregar',handler:this.agregar, scope:this.myScope },
    						{ text: 'Modificar',iconCls: 'editar',handler:this.modificar,scope:this.myScope },
    						{xtype:'tbseparator'},
    						{ text: 'Clonar',iconCls: 'entidad_blue',handler:this.clonar,scope:this.myScope },
    						{xtype:'tbseparator'},
    						{ text: 'Desactivar',iconCls: 'desactivado',handler:this.desactivar,scope:this.myScope },
    						{ text: 'Activar',iconCls: 'activo',handler:this.activar,scope:this.myScope },
    						{xtype:'tbseparator'},
    						{ text: 'Borrar',iconCls: 'desactivado',handler:this.eliminar,scope:this.myScope },

    				],
                  items: [this.grid_tarifas]
              });

        	
        	
        }
        return win;
    },
    filtrar:function(){
    	var fechainicial  = Ext.getCmp('idfechainicialbusquedatarifas').getRawValue();
    	var fechafinal  = Ext.getCmp('idfechafinalbusquedatarifas').getRawValue();
    	var patron  = Ext.getCmp('idpatronbusquedatarifas').getRawValue();
    	var tipo_busqueda = this.combo_tipos_busqueda.getValue();
    	
    	if (tipo_busqueda != '05'){
    		if (patron.trim().length<=0){
    			alertMsg("Verifique", "Capture el patron de b�squeda que desea realizar");
    			return;
    		}
    	}
    	
    	this.grid_tarifas.buscar(tipo_busqueda,fechainicial,fechafinal,patron);
    },
	agregar:function(){
		this.grid_tarifas.agregar();
	},
	modificar:function(){
		this.grid_tarifas.modificar();
	},
	clonar:function(){
		//var rows =  this.getView().getSelectionModel().getSelection();
		var rows =  this.grid_tarifas.getRowsSelectedGrid();
     	if(rows.length <=0){
     		Ext.Msg.alert('Verificar',"Debe de Seleccionar solo un registro para clonar");
     		return;
     	}
		if(rows.length >1){
     		Ext.Msg.alert('Verificar',"Seleccione solamente un registro a clonar");
     		return;
     	}

		if(rows[0].get('estatus') ==0){
     		Ext.Msg.alert('Verificar',"Tarifa esta dada de baja, operación inválida.");
     		return;
     	}
		
		//Crea una forma de clientes para agregar los datos
		var forma_modificar = Ext.create('MyDesktop.view.FormTarifas',{operacion:'clonar'}); 
		forma_modificar.updateCampos(rows[0]);
		Ext.create('widget.window', {
			
			title: "Clonar Tarifa",
			width: 400,
			height: 350,
			modal:true,
			plain: true,
			headerPosition: 'right',
			layout: 'fit',
			items: forma_modificar
			
		}).show();
	},
	desactivar:function(){
		//var rows =  this.getView().getSelectionModel().getSelection();
		var rows =  this.grid_tarifas.getRowsSelectedGrid();
		var myscope= this;
     	if(rows.length <=0){
     		 Ext.Msg.alert('Verificar',"Seleccione los registros que desea desactivar");
     		return;
     	}
		
     	 Ext.MessageBox.confirm('Confirmar','Desea desactivar las tarifas seleccionadas?', function(id, text){
	       		if ( (id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){ 
	       		//Obtiene todos los registros seleccionados
	       			var registros ='';
	       			for (i=0;i<rows.length;i++){
	       				
	       				registros = registros+  rows[i].get('idtarifa')+ "|";
	       			}
	       			var conn = new Ext.data.Connection();
	       			conn.request({
	       				url: '../tarifas/desactivar' ,
	       				params:{idstarifas:registros},
	       				success: function(response, opts) {
	       					var obj = Ext.decode(response.responseText);
	       					Ext.Msg.alert('Confirmaci�n',obj.message);
	       					myscope.filtrar();
	       				},
	       				failure: function(response, opts) {
	       					var obj = Ext.decode(response.responseText);
	       					Ext.Msg.alert('Error',obj.message);
	       				}
	       			});
	       		}
	       	 },this);
		
		
	},
	activar:function(){
		var myscope= this;
		//var rows =  this.getView().getSelectionModel().getSelection();
		var rows =  this.grid_tarifas.getRowsSelectedGrid();
     	if(rows.length <=0){
     		 Ext.MessageBox.alert('Verificar',"Seleccione los registros que desea activar");
     		return;
     	}
		
		 Ext.MessageBox.confirm('Confirmar','Desea activar las tarifas seleccionadas?', function(id, text){
	       		if ( (id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){ 
	       		//Obtiene todos los registros seleccionados
	       			var registros ='';
	       			for (i=0;i<rows.length;i++){
	       				
	       				registros = registros+  rows[i].get('idtarifa')+ "|";
	       			}
	       			var conn = new Ext.data.Connection();
	       			conn.request({
	       				url: '../tarifas/activar' ,
	       				params:{idstarifas:registros},
	       				success: function(response, opts) {
	       					var obj = Ext.decode(response.responseText);
	       				 Ext.MessageBox.alert('Confirmaci�n',obj.message);
	       				myscope.filtrar();
	       				},
	       				failure: function(response, opts) {
	       					var obj = Ext.decode(response.responseText);
	       					Ext.Msg.alert('Error',obj.message);
	       				}
	       			});
	       		}
	       	 },this);
		
		
	},
	eliminar:function(){
		var rows =  this.grid_tarifas.getRowsSelectedGrid();
		var myscope= this;
     	if(rows.length <=0){
     		 Ext.Msg.alert('Verificar',"Seleccione los registros que desea desactivar");
     		return;
     	}
    	if(rows.length >1){
     		Ext.Msg.alert('Verificar',"Seleccione solamente un registro.");
     		return;
     	}
     	 Ext.MessageBox.confirm('Confirmar','Se eliminaran datos de Zonas, Pesos '+
     			 ' y Rangos de Guías asociados a la tarifa seleccionada, ' +
     			 'desea continuar?', function(id, text){
	       		if ( (id === 'yes')  || (id === 'si') || (id === 'y' ) || (id === 's' ) ){ 
	       		//Obtiene todos los registros seleccionados
	       			var registros ='';
	       			for (i=0;i<rows.length;i++){
	       				
	       				registros = registros+  rows[i].get('idtarifa');
	       			}
	       			var conn = new Ext.data.Connection();
	       			conn.request({
	       				url: '../tarifas/delete' ,
	       				params:{identificador:registros},
	       				success: function(response, opts) {
	       					var obj = Ext.decode(response.responseText);
	       					myscope.filtrar();
	       				},
	       				failure: function(response, opts) {
	       					var obj = Ext.decode(response.responseText);
	       					Ext.Msg.alert('Error',obj.message);
	       				}
	       			});
	       		}
	       	 },this);
     	 
		//this.grid_tarifas.eliminar();

	},
	showDetails:function(){
		this.grid_tarifas.showDetails();
	},
	saveInfo:function(){
		this.grid_tarifas.saveInfo();
	}
	
	
});
