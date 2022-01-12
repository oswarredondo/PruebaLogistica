Ext.define('MyDesktop.ViewCarteraDireccionesCliente', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'cartera-direcciones-win',

    init : function(){
        this.launcher = {
        		 title:'Cartera de Direcciones',
                 iconCls: 'opcion_carteraclientes'
        }
    },
	//grid_usuarios:undefined,
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope=this;

		this.grid_direcciones= new MyDesktop.grid.GridCarteraDireccionesAdmin({});


		if(!win){
				win = desktop.createWindow({
				
                id: this.id,
                title:'Cartera de Direcciones',
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
