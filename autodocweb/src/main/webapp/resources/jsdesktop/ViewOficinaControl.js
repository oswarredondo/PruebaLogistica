/*!
 * Administracicion de tarifas
 */

Ext.define('MyDesktop.ViewOficinaControl', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'consulta-oficinas-win',

    init : function(){
        this.launcher = {
            text: 'Oficina de Control',
            iconCls:'catalogos_blue'
        }
    },
	grid_operacion:undefined,
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope= this;
		
		this.grid_operacion = new MyDesktop.grid.GridOficinasReceptoras({id:this.id+'grid',isConsulta:false}); 
		if(!win){
				win = desktop.createWindow({
				
                id: this.id,
                title:'Consulta de Oficinas',
                iconCls: 'opcion_carteraclientes',
                //animCollapse:false,
                border:false,
                constrainHeader:false,
                closable: true,
                closeAction: 'hide',
                width: 1000,
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
