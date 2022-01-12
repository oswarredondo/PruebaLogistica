/*!
 * Administracicion de tarifas
 */

Ext.define('MyDesktop.ViewCotizacionEnvios', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'cotizacion-envios-win',

    init : function(){
        this.launcher = {
            text: 'Usuarios',
            iconCls:'usuarios_blue'
        }
    },
	gridoperacion:undefined, 
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope= this;
		
		this.gridoperacion  =  new MyDesktop.grid.GridCotizacion({isconsulta:false}); 

		

		if(!win){
				win = desktop.createWindow({
				
                id: this.id,
                title:'Cotizaciones Envios',
               // iconCls: 'usuarios_blue',
                //animCollapse:false,
                border:false,
				resizable:true,
				maximizable:true, 
                constrainHeader:false,
                closable: true,
                closeAction: 'hide',
                width: 900,
                height: 500,
				layout: 'fit',
				items:[
				this.gridoperacion
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
