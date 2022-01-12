/*!
 * Ext JS Library 4.0
 * Copyright(c) 2006-2011 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 */

Ext.define('MyDesktop.WindowsUtilitaria', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'utilitaria-win',

    init : function(){
        this.launcher = {
            text: 'Administración de Clientes',
            iconCls:'clientes'
        }
    },

    createWindow : function(id_wind,compomente,titulo){
        return Ext.create('widget.window', {
			id:this.id,
			title: titulo,
			width: 400,
			height: 200,
			modal:true,
			plain: true,
			headerPosition: 'left',
			layout: 'fit',
			items: [compomente]
		});
    }
});
