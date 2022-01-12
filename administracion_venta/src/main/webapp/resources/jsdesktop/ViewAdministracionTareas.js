/*!
 * Administracicion de tarifas
 */

Ext.define('MyDesktop.ViewAdministracionTareas', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'administracion-tarea-win',

    init : function(){
        this.launcher = {
            text: 'Administracion de Tareas',
            iconCls:'manwork_blue'
        }
    },
	grid_operacion:undefined,
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope= this;
		
		this.grid_operacion = new MyDesktop.view.GridAdministracionTarea({id:this.id+'grid', isConsulta:false}); 
		this.grid_operacion.loadInfo();
		if(!win){
				win = desktop.createWindow({
				
                id: this.id,
                title:'Administración de Tareas',
                iconCls: 'manwork_blue',
                //animCollapse:false,
                border:false,
                constrainHeader:false,
                closable: true,
                closeAction: 'hide',
                width: 1000,
                minWidth: 1300,
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
