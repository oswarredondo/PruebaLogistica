/*!
 * Administracicion de tarifas
 */

Ext.define('MyDesktop.ViewPassword', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'cambiar.password-win',

    init : function(){
        this.launcher = {
            text: 'Cambiar Password',
            iconCls:'password_blue'
        }
    },
	gridoperacion:undefined, 
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope= this;
		
		var forma_usuario_sesion_password = Ext.create('MyDesktop.view.FormPasswordUsuario',{id:'cambiar_password_usuario_sesion_grid',showReadOnly:false}); 

		if(!win){
				win = desktop.createWindow({
				
                id: this.id,
                title:'Cambiar Password',
                iconCls: 'password_blue',
                //animCollapse:false,
                border:false,
				resizable:false,
				maximizable:false, 
				minimizable:false,
                constrainHeader:false,
                closable: true,
                closeAction: 'hide',
                minWidth: 350,
            	width: 460,
    			height: 340,
				layout: 'fit',
				items:[
				       	forma_usuario_sesion_password
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
