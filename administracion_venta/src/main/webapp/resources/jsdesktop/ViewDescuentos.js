/*!
 *Contiene el funcionamiento para la administracion de los descuentos
 */

Ext.define('MyDesktop.ViewDescuentos', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'descuentos-win',

    init : function(){
        this.launcher = {
            text: 'Descuentos',
            iconCls:'descuentos_blue'
        }
    },
	
	grid_descuentos:undefined,
	grid_contactos:undefined,
    grid_convenios:undefined,
	myScope:undefined,
	combo_tipos_busqueda:undefined,
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope=this;
		
        if(!win){
        	//Define las busquedas para los descuentos
			this.combo_tipos_busqueda= Ext.create('Ext.form.ComboBox', {
				fieldLabel: '',
				 width: 150,
				disabled: false,
				editable:false,
				//forceSelection:true,
				store: Ext.create('MyDesktop.store.StoreTiposBusquedaDescuentos',{}) ,
				queryMode: 'local',
				emptyText: 'Seleccione orden',
				displayField: 'descripcion',
				valueField: 'idtipo'
			});
			this.combo_tipos_busqueda.setValue("01");
			this.combo_tipos_busqueda.setRawValue("Nombre");
	
			this.grid_descuentos = new MyDesktop.view.GridDescuentos({
					autoScroll: true,
					forceFit    : true,
					scrollOffset: 0,
					getTotalWidth: function() {
						return "auto";
					}
	  
			});
		
		    win = desktop.createWindow({
				
                id: this.id,
                title:'Descuentos',
                iconCls: 'descuentos_blue',
                //animCollapse:false,
                border:false,
                constrainHeader:false,
                closable: true,
                closeAction: 'hide',
				width: 1300,
                minWidth: 350,
                height: 500,
				layout: 'fit',
				tbar:[
	  					{xtype: 'label', text:'Buscar por:'	},
	  					this.combo_tipos_busqueda,
	  					{xtype: 'label', text:'Patrón:'	},
	  					{xtype: 'myUpperCaseTextField' , id:'idpatronbusquedadescuento', allowBlank: false, width: 100},
	  					{
				            xtype: 'datefield',
				            id:'idfechainicialbusquedadescuento',
				            fieldLabel: 'Activacion',
				            name:'fechainicial',
				            format: 'd-m-Y',
				            labelWidth: 80,
				            width: 190
	  					}, 
	  					{
				            xtype: 'datefield',
				            id:'idfechafinalbusquedadescuento',
				            fieldLabel: 'Termino',
				            name:'fechafinal',
				            format: 'd-m-Y',
				            labelWidth: 80,
				            width: 190
	  					},
	  					{ iconCls: 'buscar_blue',handler:this.filtrar, scope:this.myScope}

	  				],
	  			bbar:[
	  			    { text: 'Mostrar Detalles',iconCls: 'detalles',handler:this.showDetails, scope:this.myScope },		
					{xtype: 'tbfill'},
					{xtype:'tbseparator'},
					{ text: 'Agregar',iconCls: 'agregar',handler:this.agregar, scope:this.myScope },
					{ text: 'Modificar',iconCls: 'editar',handler:this.modificar,scope:this.myScope },
					{xtype:'tbseparator'},
					{ text: 'Desactivar',iconCls: 'borrar',handler:this.desactivar,scope:this.myScope },
					{ text: 'Activar',iconCls: 'activo',handler:this.activar,scope:this.myScope },

  				],	
                items: [this.grid_descuentos]
            });
			
			
        }
        return win;
    },
	agregar:function(){
		this.grid_descuentos.agregar();
	},
	modificar:function(){
		this.grid_descuentos.modificar();
	},
	eliminar:function(){
		this.grid_descuentos.eliminar();
	},
	 filtrar:function(){
	    	var fechainicial  = Ext.getCmp('idfechainicialbusquedadescuento').getRawValue();
	    	var fechafinal  = Ext.getCmp('idfechafinalbusquedadescuento').getRawValue();
	    	var patron  = Ext.getCmp('idpatronbusquedadescuento').getRawValue();
	    	var tipo_busqueda = this.combo_tipos_busqueda.getValue();
	    	
	    	if (tipo_busqueda == '03'){
	    		if  (fechainicial.trim().length<=0){ 
	    			alertMsg("Verifique", "Capture la fecha de activación a consultar.");
	    			return;	
	    		}
	    	}
	    	if (tipo_busqueda == '04'){
	    		if  (fechainicial.trim().length<=0){ 
	    			alertMsg("Verifique", "Capture la fecha de termino a consultar.");
	    			return;	
	    		}
	    	}
	    	if (tipo_busqueda == '05'){
	    		if  ((fechafinal.trim().length<=0) ||  (fechainicial.trim().length<=0)){ 
	    			alertMsg("Verifique", "Capture la fecha de activiación y termino a consultar.");
	    			return;	
	    		}
	    	}
	    	
	    	if (tipo_busqueda != '05'){
	    		if (patron.trim().length<=0){
	    			alertMsg("Verifique", "Capture el patron de búsqueda que desea realizar.");
	    			return;
	    		}
	    	}
	    	
	    	this.grid_descuentos.buscar(tipo_busqueda,fechainicial,fechafinal,patron);
	    	this.grid_descuentos.buscar(tipo_busqueda,fechainicial,fechafinal,patron);
	    },
    desactivar:function(){
		this.grid_descuentos.desactivar();
	},
	activar:function(){
		this.grid_descuentos.activar();
	},
	showDetails:function(){
		var rows =  this.grid_descuentos.getSelectionModel().getSelection();
     	if(rows.length <=0){
     		alertMsg('Verificar',"Debe de Seleccionar solo un registro a visualizar.");
     		return;
     	}
		if(rows.length >1){
     		alertMsg('Verificar',"Seleccione solamente un registro a visualizar.");
     		return;
     	}

		if (rows[0].get('estatus')==0){
			alertMsg('Verificar',"Registro esta dado de baja no puede ser modificado.");
     		return;
		}
		//verifica el tipo de del descuento para mostrar los datos correctos  
		var win;
		var module=myDesktopApp.getModule('detalle-descuentos-tarifa-cliente-zona-win');;

		var iddescuento=rows[0].get('iddescuento');
		var idtipo=rows[0].get('tipo');
		var url_store_disponibles='../descuentodetalle/getDatosDisponibles?iddescuento='+rows[0].get('iddescuento')+"&tipo="+rows[0].get('tipo');
		var url_store_seleccionados='../descuentodetalle/getDatosDetalleTipo?iddescuento='+rows[0].get('iddescuento')+"&tipo="+rows[0].get('tipo');

		
		var title='';
		var title_disponibles='';
		var title_seleccionadose='';
		
		 if (rows[0].get('tipo') =='1'){
				title='Detalle Descuento Clientes';
				title_disponibles='Clientes Disponibles';
				title_seleccionados='Clientes Seleccionadas';
		 }else 	if (rows[0].get('tipo') =='2'){

			title='Detalle Descuento Tarifas';
			title_disponibles='Tarifas Disponibles';
			title_seleccionados='Tarifas Seleccionadas';

		}else if (rows[0].get('tipo') =='3'){
			title='Detalle Descuento Zonas';
			title_disponibles='Zonas Disponibles';
			title_seleccionados='Zonas Seleccionadas';
		}else if (rows[0].get('tipo') =='4'){	
			alertMsg('Verificar','Tipo de Descuento no puede tener detalle.');
			return;
		}else{
			alertMsg('Verificar','Tipo de Descuento inválido');
			return;
		}
		
		//Muestra la ventana
		 win = myDesktopApp.createWindowConfig(module,
					{
						iddescuento:iddescuento,
						tipo:idtipo,
						url_store_disponibles:url_store_disponibles,
						url_store_seleccionados:url_store_seleccionados,
						title:title,
						title_disponibles:title_disponibles,
						title_seleccionados:title_seleccionados
						
		});
		
	}
});
