/*!
 * Administracicion de tarifas
 */

Ext.define('MyDesktop.ViewManifiestoMovimientoLocal', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'manifiesto-viewManifiestoMovimientoLocal-win',

    init : function(){
        this.launcher = {
            text: 'Manifiesto Movimientos Locales',
            iconCls:'opcion_manifiestos'
        }
    },
	gridoperacion:undefined, 
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope= this;
		
		var grid_operacion = Ext.create('MyDesktop.grid.GridManifiestoDocumentoEtiquetas',{
			
		}); 

		if(!win){
				win = desktop.createWindow({
				
                id: this.id,
                title: 'Manifiesto Etiquetas',
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
				       	grid_operacion
				]
            });
        }
        return win;
    },
	agregar:function(){
		this.gridoperacion.agregar();
	},
	modificar:function(){
		this.gridoperacion.modificar();
	},
	eliminar:function(){
		this.gridoperacion.eliminar();
	},
	showDetails:function(){
		this.gridoperacion.showDetails();
	}
});
