 /**
 * Grid para la consulta de historia o mivimientos
 * de un pedido, guia, solicitud, etc
 */
Ext.define('MyDesktop.grid.GridConsultaCPs', {
	 extend: 'Ext.grid.Panel',
		numpedido:'',
		isConsulta:true,
		tipoconsulta:'cp',
		cp:undefined,
		colonia:undefined,
		municipio:undefined,
		cp_field:undefined,
		colonia_field:undefined,
		municipio_field:undefined,
		estado_field:undefined,
		ciudad_field:undefined,
		patron:undefined,
		scope_win:undefined,
		fields:undefined,
		form:undefined,
		combo_tipos_busqueda:undefined,
		showMenuBusqueda:false, //Indica si se debe mostrar la barra de busqueda
		constructor: function(config) {
			 //Configura las propiedades
			 this.callParent(arguments);
		     this.initConfig(config);
		     return this;
		},
		initComponent: function(config) {
			var sm = Ext.create('Ext.selection.CheckboxModel',{mode : 'SINGLE'});
			this.selModel= sm;
			this.loadMask=true;

			this.selType= 'rowmodel';
			this.loadMask=true;
			
			//Realiza la busqueda con los datos que el usuario selecciono
			if (!this.showMenuBusqueda){
				this.store = Ext.create('MyDesktop.store.StoreCodigoPostal',{baseParams:{cp:this.cp,colonia:this.colonia,
					municipio:this.municipio,tipobusqueda:this.tipoconsulta,patron:this.patron}});
				
				//this.store = Ext.create('com.pickin.stCPsPrueba',{baseParams:{cp:this.cp,colonia:this.colonia,municipio:this.municipio}});
				this.store.getProxy().setExtraParam("cp", this.cp);
				this.store.getProxy().setExtraParam("colonia", this.colonia);
				this.store.getProxy().setExtraParam("municipio", this.municipio);
				this.store.getProxy().setExtraParam("tipobusqueda", this.tipoconsulta);
				this.store.getProxy().setExtraParam("patron", this.patron);
			
			}else{
				this.store = Ext.create('MyDesktop.store.StoreCodigoPostal',{});
				this.combo_tipos_busqueda= Ext.create('Ext.form.ComboBox', {
					fieldLabel: '',
					disabled: false,
					editable:false,
					forceSelection:true,
					store: Ext.create('MyDesktop.store.StoreTiposBusquedaCPs',{}) ,
					queryMode: 'local',
					emptyText: 'Seleccione Tipo',
					displayField: 'descripcion',
					valueField: 'idtipo'
				});
				
				//Muestra la barra de busqueda
				this.tbar=[
						{xtype: 'label', text:'Buscar por:'	},
						this.combo_tipos_busqueda,
						{xtype: 'label', text:'Patrón:'	},
						{xtype: 'myUpperCaseTextField', id:'idpatroncpbusqueda'+this.id, allowBlank: false},
						{ iconCls: 'buscar_blue',handler:this.filtraInfo, scope:this},
						
					];
			}

			
	        this.columns = [
		        
		    	{header: 'CP', dataIndex: 'cp',width: 90 },
		    	{header: 'Colonia', dataIndex: 'colonia',width: 200 }, 	
		    	{header: 'Municipio', dataIndex: 'municipio',width: 200}, 	
				{header: 'Ciudad', dataIndex: 'ciudad',width: 160 },
		    	{header: 'Estado', dataIndex: 'estado',width: 150 },
				{
	                xtype: 'actioncolumn',
	                width: 30,
	                sortable: false,
	                menuDisabled: true,
	                items: [{
	                    iconCls: 'sky4sol_icon16',
	                    tooltip: 'Seleccionar registro',
	                    scope: this,
	                    handler: this.selectRegistro
						}]
				}
	        ];
	        this.callParent(arguments);  

	        if (!this.showMenuBusqueda){
	        	//Carga los datos despues de haber definido el grdi
	            this.on('afterlayout', this.loadStore, this, {
	                delay: 1,
	                single: true
	            });
	        }
			
			
			this.listeners={
				itemclick:this.selectRegistro
			};

		},
		
		setScopeWin: function(scopewin){
			this.scope_win=scopewin;
		},
		filtraInfo:function(){
			//verifica si se ha seleccionado el tipo
			if ((this.combo_tipos_busqueda==undefined) ||  
			   (this.combo_tipos_busqueda.getValue()=='')){
				Ext.Msg.alert('Verificar',"Seleccione tipo de búsqueda.");
	     		return;
			}
			
			if (Ext.getCmp('idpatroncpbusqueda'+this.id).getValue()==''){
				Ext.Msg.alert('Verificar',"Seleccione patrón de búsqueda.");
			    return;
			}
			
			//Obtiene los datos de busqueda
			this.store.reload({
				params:{
					tipobusqueda:this.combo_tipos_busqueda.getValue(),
					patron:Ext.getCmp('idpatroncpbusqueda'+this.id).getValue()
				},
				callback:function(r,options,success){
					 if (r.length<=0){
						 Ext.Msg.show({
							 title: 'Aviso',
							 msg: 'No existe información con el criterio de busqueda selecionado.',
							 modal: false,
							 icon: Ext.Msg.INFO,
							 buttons: Ext.Msg.OK						
						 });  
						
					 }
				 }	  
			});
			
		},
		selectRegistro:function (dv, record, item, rowIndex, e){
			//TODO: Verificar que actualice info
			var fields = this.form.getFields( ) ;

	        var row = this.getStore().getAt(rowIndex);
			if (this.cp_field!=undefined){
				//Ext.getCmp(this.cp_field).setValue(row.get('cp'));
				setValueFormField(this.cp_field,fields,row.get('cp'));
			}
		
			if (this.colonia_field!=undefined){
				//Ext.getCmp(this.colonia_field).setValue(row.get('colonia'));
				setValueFormField(this.colonia_field,fields,row.get('colonia'));
			}
		
			if (this.municipio_field!=undefined){
				//Ext.getCmp(this.municipio_field).setValue(row.get('municipio'));
				setValueFormField(this.municipio_field,fields,row.get('municipio'));
			}
	
			if (this.estado_field!=undefined){
				//Ext.getCmp(this.estado_field).setValue(row.get('estado'));
				setValueFormField(this.estado_field,fields,row.get('estado'));
			}
			
			if (this.ciudad_field!=undefined){
				//Ext.getCmp(this.ciudad_field).setValue(row.get('ciudad'));
				setValueFormField(this.ciudad_field,fields,row.get('ciudad'));
			}
			
			if (this.scope_win!=undefined){
				this.scope_win.close();
			}
	    },
	    setScopeWin:function(w){
	    	this.scope_win=  w;
	    }
		
});

