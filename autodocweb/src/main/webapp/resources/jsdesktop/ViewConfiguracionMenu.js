/*!
 * Administracicion de tarifas
 */

Ext.define('MyDesktop.ViewConfiguracionMenu', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'configuracion-menu-win',

    init : function(){
        this.launcher = {
            //text: 'Adicionales',
            //iconCls:'catalogos_blue'
        }
    },
	grid_operacion:undefined,
	myScope:undefined,
	
	createWindow : function(config){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope= this;
		var usuariosesion_form = Ext.create('MyDesktop.view.FormUsuariosSesion',
				{usuariosesion:config});
		
		if(!win){
				win = desktop.createWindow({
				
                id: this.id,
                title:'Datos de Usuario de Sesión',
                iconCls: 'catalogos_blue',
                //animCollapse:false,
                border:false,
                constrainHeader:false,
                closable: false,
                maximizable:false,
                minimizable:true,
                closeAction: 'hide',
                width: 500,
                minWidth: 350,
                height: 350,
				layout: 'fit',
					items:[
					       	usuariosesion_form
					]
            });
        }
        return win;
    }
});
