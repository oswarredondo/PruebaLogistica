/*!
 * Administracicion de tarifas
 */

Ext.define('MyDesktop.ViewServicios', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'servicios-win',

    init : function(){
        this.launcher = {
            text: 'Servicios',
            iconCls:'catalogos_blue'
        }
    },
	grid_operacion:undefined,
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope= this;

		this.grid_operacion = new MyDesktop.view.GridServicio({id:this.id+'grid',isConsulta:false }); 
		if(!win){
				win = desktop.createWindow({
				
                id: this.id,
                title:'Servicios',
                iconCls: 'catalogos_blue',
                //animCollapse:false,
                border:false,
                constrainHeader:false,
                closable: true,
                closeAction: 'hide',
                width: 1000,
                minWidth: 250,
                height: 300,
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
