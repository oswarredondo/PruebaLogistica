/*!
 * Administracicion de tarifas
 */

Ext.define('MyDesktop.ViewRegistros', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'tipos-registros-win',

    init : function(){
        this.launcher = {
            text: 'Registros Intercambio',
            iconCls:'registros_blue'
        }
    },
	grid_operacion:undefined,
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope= this;
		
		this.grid_operacion = new MyDesktop.view.GridRegistros({id:this.id+'grid'}); 
		if(!win){
				win = desktop.createWindow({
				
                id: this.id,
                title:'Registros Intercambio',
                iconCls: 'registros_blue',
                //animCollapse:false,
                border:false,
                constrainHeader:false,
                closable: true,
                closeAction: 'hide',
                width: 600,
                minWidth: 350,
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
