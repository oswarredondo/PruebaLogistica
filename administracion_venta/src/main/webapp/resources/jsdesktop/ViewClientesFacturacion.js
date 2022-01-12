/*!
 * Administracicion de datos de cliente de facturación
 */

Ext.define('MyDesktop.ViewClientesFacturacion', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'clientes-facturacion-win',

    init : function(){
        this.launcher = {
            text: 'Datos Fact.',
            iconCls:'catalogos_blue'
        }
    },
	grid_operacion:undefined,
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope= this;
		
		this.grid_operacion = new MyDesktop.view.GridClientesRFCs({id:this.id+'grid', isConsulta:false}); 
		this.grid_operacion.buscar(0,'0');
		if(!win){
				win = desktop.createWindow({
				
                id: this.id,
                title:'Clientes Facturación',
                iconCls: 'clientes',
                //animCollapse:false,
                border:false,
                constrainHeader:false,
            	maximized :true,
				maximizable:false,
                closable: true,
                closeAction: 'hide',
              
				layout: 'fit',
				items:[
					this.grid_operacion
				]
            });
        }
		
		this.grid_operacion.buscar(0,'0');
        return win;
    },
    bloquear:function(){
    	this.grid_clientes.bloquear(3);
    },
    desbloquear:function(){
    	this.grid_clientes.bloquear(1);
    },
	desactivar:function(){
		this.grid_clientes.desactivar();

	},
	activar:function(){
		this.grid_clientes.activar();

	}
});
