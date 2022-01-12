/*!
 *Contiene el funcionamiento para la administracion de los descuentos
 */

Ext.define('MyDesktop.ViewOrdenServicio', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'orden-servicio-win',

    init : function(){
        this.launcher = {
            text: 'Orden de Servicio',
            iconCls:'ordenservicio_blue'
        }
    },
	
	grid_descuentos:undefined,
	grid_contactos:undefined,
    grid_convenios:undefined,
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope=this;
		this.combo_tipos_busqueda= Ext.create('Ext.form.ComboBox', {
					fieldLabel: '',
					disabled: false,
					editable:false,
					forceSelection:true,
					store: Ext.create('MyDesktop.store.StoreTiposBusquedaClientes',{}) ,
					queryMode: 'local',
					emptyText: 'Seleccione orden',
					displayField: 'descripcion',
					valueField: 'idtipo'
		});
		this.grid_descuentos = new MyDesktop.view.GridDescuentos({
				autoScroll: true,
				forceFit    : true,
                scrollOffset: 0,
                getTotalWidth: function() {
                    return "auto";
                }
  
		});
		
	
		
        if(!win){
		    win = desktop.createWindow({
				
                id: this.id,
                title:'Orden de Servicio',
                iconCls: 'ordenservicio_blue',
                //animCollapse:false,
                border:false,
                constrainHeader:false,
                closable: true,
                closeAction: 'hide',
                width: 1100,
                minWidth: 350,
                height: 500,
				layout: 'fit',
				tbar:[
					{xtype: 'label', text:'Buscar por:'	},
					this.combo_tipos_busqueda,
					{xtype: 'label', text:'Patrón:'	},
					{xtype: 'textfield' , id:'idpatronCliente', allowBlank: false},
					{ text: 'Filtrar',iconCls: 'buscar',handler:this.filtrar},
					{xtype: 'tbfill'},
					
						{ text: 'Mostrar Detalles',iconCls: 'detalles',handler:this.filtrar,handler:this.showDetails, scope:this.myScope },
						{xtype:'tbseparator'},
						{ text: 'Agregar',iconCls: 'agregar',handler:this.filtrar,handler:this.agregar, scope:this.myScope },
						{ text: 'Modificar',iconCls: 'editar',handler:this.modificar,scope:this.myScope },
						{ text: 'Desactivar',iconCls: 'borrar',handler:this.eliminar,scope:this.myScope }

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
	showDetails:function(){
		this.grid_descuentos.showDetails();
	}
});
