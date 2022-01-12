/*!
 * Administracicion de tarifas
 */

Ext.define('MyDesktop.ViewAdminManifiestoOrdenesRecoleccion', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'administracion-manifiesto-ordenes-recoleccion-win',

    init : function(){
        this.launcher = {
            text: 'Manifiesto Recolecciones',
            iconCls:'fax_blue'
        }
    },
	grid_operacion:undefined,
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope= this;

	     var formireport = new MyDesktop.form.FormManifiestosFramedPanels({}); 
	  
		if(!win){
				win = desktop.createWindow({
				
                id: this.id,
                title:'Manifiesto Recolecciones Diarias',
                iconCls: 'campos_blue',
                //animCollapse:false,
                border:false,
                width: 920,
   			    heigth:500,
                constrainHeader:false,
                closable: true,
                closeAction: 'hide',
            	maximized :false,	
				maximizable:false,
				items:[
				       	formireport
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
