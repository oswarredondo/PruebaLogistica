/*!
* Ext JS Library 4.0
* Copyright(c) 2006-2011 Sencha Inc.
* licensing@sencha.com
* http://www.sencha.com/license
*/

var windowIndex = 0;

Ext.define('MyDesktop.WindowURLModule', {
    extend: 'Ext.ux.desktop.Module',
    id:'WindowURLModule.Frame',
    init : function(){
        this.launcher = {
            text: 'Window_URL'+(++windowIndex),
            iconCls:'bogus',
            handler : this.createWindow,
            scope: this,
            windowId:windowIndex
        }
    },

    createWindow : function(src){
    	return this.createWindowFrame(src.windowId,src.text, src.iconCls);
        /*var desktop = this.app.getDesktop();
        var win = desktop.getWindow(src.windowId);
        if(!win){
            win = desktop.createWindow({
                id: src.windowId,
                title:src.text,
                width:640,
                height:480,
                html : '<iframe src="' + src.windowId + '" style="width:100%;height:100%;border:none;"></iframe>',
                iconCls: src.iconCls,
                animCollapse:false,
                maximized:true, 
                constrainHeader:true
            });
        }
        win.show();
        //win.maximize( true );
        return win;*/
    },
    
    createWindowQuickStart : function(src){
    	return this.createWindowFrame(src.module,src.overflowText, src.iconCls);
       /* var desktop = this.app.getDesktop();
        var win = desktop.getWindow(src.module);
        if(!win){
            win = desktop.createWindow({
                id: src.module,
                title:src.overflowText,
                width:640,
                height:480,
                html : '<iframe src="' + src.module + '" style="width:100%;height:100%;border:none;"></iframe>',
                iconCls: src.iconCls,
                animCollapse:false,
                maximized:true, 
                constrainHeader:true
            });
        }
        win.show();
        //win.maximize( true );
        return win;*/
    },
    
    createWindowFrame : function(module,title,iconCls){
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(module);
        if(!win){
            win = desktop.createWindow({
                id: module,
                title:title,
                width:640,
                height:480,
                html : '<iframe src="' + module + '" style="width:100%;height:100%;border:none;"></iframe>',
                iconCls: iconCls,
                animCollapse:false,
                maximized:true, 
                constrainHeader:true
            });
        }
        win.show();
        return win;
    }
});