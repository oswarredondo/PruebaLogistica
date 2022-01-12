/*!
 * Administracicion de tarifas
 */

Ext.define('MyDesktop.ViewPaquetesOcurres', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'confirma-ocurres-win',

    init : function(){
        this.launcher = {
            text: 'Envios Ocurre',
            iconCls:'campos_blue'
        }
    },
	grid_operacion:undefined,
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope= this;
		
		this.grid_operacion = new MyDesktop.grid.GridPaquetesOcurre({id:this.id+'grid'}); 
		if(!win){
				win = desktop.createWindow({
				
                id: this.id,
                title:'Envios Ocurre',
                iconCls: 'businessman16x16',
                //animCollapse:false,
                border:false,
                constrainHeader:false,
                closable: true,
                maximizable: false,
                closeAction: 'hide',
                width: 700,
                minWidth: 990,
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
