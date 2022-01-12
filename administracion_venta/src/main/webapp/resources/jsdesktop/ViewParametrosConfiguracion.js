/*!
 * Administracicion de tarifas
 */

Ext.define('MyDesktop.ViewParametrosConfiguracion', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'parametros_configuracion-win',

    init : function(){
        this.launcher = {
            text: 'Parámetros Configuración',
            iconCls:'tools_blue'
        }
    },
	grid_operacion:undefined,
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope= this;
		
		this.grid_operacion = new MyDesktop.view.GridParametrosConfiguracion({id:this.id+'grid',
			isConsulta:false, idsistema:''}); 
		this.grid_operacion.loadInfo();
		if(!win){
				win = desktop.createWindow({
				
                id: this.id,
                title:'Parámetros Configuración',
                iconCls: 'tools_blue',
                border:false,
                constrainHeader:false,
                closable: true,
                closeAction: 'hide',
                width: 1090,
                height: 500,
				layout: 'fit',
				items:[
					this.grid_operacion
				]
            });
        }
		
        return win;
    },
	agregar:function(){
		this.grid_operacion.agregar();
	},
	modificar:function(){
		this.grid_operacion.modificar();
	},
	eliminar:function(){
		this.grid_operacion.eliminar();
	},
	showDetails:function(){
		this.grid_operacion.showDetails();
	}
});
