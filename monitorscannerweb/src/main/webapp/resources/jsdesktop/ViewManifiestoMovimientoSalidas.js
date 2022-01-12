/*!
 * Administracicion de tarifas
 */

Ext.define('MyDesktop.ViewManifiestoMovimientoSalidas', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'manifiesto-viewManifiestoMovimientoSalidas-win',

    init : function(){
        this.launcher = {
            text: 'Manifiesto Salidas',
            iconCls:'opcion_manifiestos'
        }
    },
	gridoperacion:undefined, 
	myScope:undefined,
	
	createWindow : function(){
	
		 var desktop = this.app.getDesktop();
	        var win = desktop.getWindow(this.id);
			this.myScope= this;
			
			var grid_operacion = Ext.create('MyDesktop.grid.GridManifiestoEntradas',{
				tiporegistro:'02'
			}); 

			if(!win){
					win = desktop.createWindow({
					
	                id: this.id,
	                title: 'Manifiesto Salidas',
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
    }
});
