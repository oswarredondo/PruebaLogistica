/*!
 * Administracicion de tarifas
 */

Ext.define('MyDesktop.ViewManifiestoMovimientos', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'manifiesto-movimientos-operativos-win',

    init : function(){
        this.launcher = {
            text: 'Manifiesto Entradas',
            iconCls:'opcion_manifiestos'
        }
    },
	gridoperacion:undefined, 
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope= this;
		
		var grid_operacion_entradas = Ext.create('MyDesktop.grid.GridManifiestoEntradas',
				{
			tiporegistro:'01', title:'Entradas'
		}); 
		
		var grid_operacion_salidas = Ext.create('MyDesktop.grid.GridManifiestoEntradas',{
			tiporegistro:'02', title:'Salidas'
		}); 
		
		var grid_operacion_salidas_fxc = Ext.create('MyDesktop.grid.GridManifiestoFXC',{
			tiporegistro:'FX', title:'Salidas FXC'
		}); 	
		
		var grid_operacion_movlocal = Ext.create('MyDesktop.grid.GridManifiestoMovLocal',{
			tiporegistro:'03', title:'Movimientos Locales'
		}); 
		
		var grid_operacion_movrecolecciones = Ext.create('MyDesktop.grid.GridRecoleccionesRealizadasRuta',{
			tiporegistro:'21', title:'Recolecciones Ruta'
		}); 
		
	
		
		var tabs_manifiestos = Ext.widget('tabpanel', {
	 	        activeTab: 0,
	 	       width: 1000,
	           height: 700,
	           layout:'fit',
	 	      tabPosition: 'left',
	 	        defaults :{
	 	            autoScroll: true,
	 	            bodyPadding: 10
	 	        },
	 	        items: [grid_operacion_entradas,
	 	               grid_operacion_salidas,
	 	              grid_operacion_salidas_fxc,
	 	              grid_operacion_movlocal,
	 	              grid_operacion_movrecolecciones
	 	               
	 	        ]
	 	    });

		if(!win){
				win = desktop.createWindow({
				
                id: this.id,
                title: 'Manifiestos Movimientos. Realizar búsqueda para seleccionar las guías que no desea incluir en el Manifiesto',
                iconCls:'opcion_manifiestos',
                //animCollapse:false,
                border:false,
				resizable:true,
            	maximized :true,
				maximizable:false,
                constrainHeader:false,
                closable: true,
                closeAction: 'hide',
            
				layout: 'fit',
				items:[
				       tabs_manifiestos
				]
            });
        }
        return win;
    }
});
