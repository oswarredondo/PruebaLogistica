/*!
 * Administracicion de tarifas
 */

Ext.define('MyDesktop.ViewIReport', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'ireport-web-win',

    init : function(){
        this.launcher = {
            text: 'IReport Web',
            iconCls:'campos_blue'
        }
    },
    formireport:undefined,
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope= this;
		
		this.formireport = new MyDesktop.form.IReportFramedPanels({id:this.id+'ireportweb'}); 
		if(!win){
				win = desktop.createWindow({
				
                id: this.id,
                title:'IReport Web',
                iconCls: 'campos_blue',
                //animCollapse:false,
                border:false,
                constrainHeader:false,
                closable: true,
                closeAction: 'hide',
                maximizable:false,
                resizable:false,
                width: 794,
                minWidth: 715,
                height: 600,
				layout: 'fit',
				items:[
					this.formireport
				]
            });
        }
        return win;
    }
});
