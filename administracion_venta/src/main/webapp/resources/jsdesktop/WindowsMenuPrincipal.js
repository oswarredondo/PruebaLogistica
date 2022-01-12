/*!
 * Ext JS Library 4.0
 * Copyright(c) 2006-2011 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 */

Ext.define('MyDesktop.WindowsMenuPrincipal', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'menu-princial-win',

    init : function(){
        this.launcher = {
            text: 'Menú Principal',
            iconCls:'manager'
        }
    },
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope=this;
		
        if(!win){
		    win = desktop.createWindow({
                id: this.id,
                title:'Administración de Clientes',
                iconCls: 'manager',
                //animCollapse:false,
                border:false,
                constrainHeader:false,
                closable: true,
                closeAction: 'hide',
                width: 400,
                minWidth: 350,
                height: 800,
				x:0,y:0,
                layout: {
                    type: 'border',
                    padding: 5
                },
				tbar:[
					{ text: 'Mostrar Detalles',iconCls: 'detalles',handler:this.muestraVentana,scope:this.myScope }
				]
            });
			
			
        }
        return win;
    },
	muestraVentana:function(obj){
				
		var module =  myDesktopApp.getModule('clientes-win');
		myDesktopApp.createWindow(module);
	}
});
