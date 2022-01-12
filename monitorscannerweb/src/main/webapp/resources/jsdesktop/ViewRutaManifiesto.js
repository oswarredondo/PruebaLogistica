Ext.define('MyDesktop.ViewRutaManifiesto', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'ruta-web-win',

    init : function(){
        this.launcher = {
        		 title:'Ruta Manifiesto',
                 iconCls: 'opcion_carteraclientes'
        }
    },
	//grid_usuarios:undefined,
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope=this;

		this.grid_direcciones= new MyDesktop.grid.GridRutaManifiesto({});


		if(!win){
				win = desktop.createWindow({
				
                id: this.id,
                title:'Ruta Manifiesto',
                iconCls: 'campos_blue',
                //animCollapse:false,
                border:false,
                constrainHeader:false,
                closable: true,
                closeAction: 'hide',
             
            	maximized :true,
				maximizable:false,
              
				layout: 'fit',
				items:[
					this.grid_direcciones
				]
            });
        }
        return win;
	
		
		
    }
});
