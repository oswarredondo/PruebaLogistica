/*!
 * Administracicion de tarifas
 */

Ext.define('MyDesktop.ViewAdminOrdenesRecoleccion', {
    extend: 'Ext.ux.desktop.Module',

    requires: [
        'Ext.tab.Panel'
    ],

    id:'administracion-ordenes-recoleccion-win',

    init : function(){
        this.launcher = {
            text: 'Ordenes/Solicitudes de Recolecci�ns',
            iconCls:'fax_blue'
        }
    },
	grid_operacion:undefined,
	myScope:undefined,
	
	createWindow : function(){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope= this;
		
		var grid_programadas = new MyDesktop.grid.GridRecoleccionProgramada({id:this.id+'gridprogramadas',
			title:'Programadas',iconCls:'DIARECOL',  layout: 'fit'});
		var grid_esporadicas = new MyDesktop.grid.GridRecoleccionEsporadica({id:this.id+'gridesporadicas',
			title:'Esporadicas',iconCls:'CITARECOL', layout: 'fit'});

		var tab_recolecciones =  Ext.create('Ext.tab.Panel', {
		        tabPosition: 'right',
		        height: 300,
		        width: 300,
		        defaults: {
		            bodyPadding: 10
		        },
		        items: [
		                grid_programadas,
		                grid_esporadicas
		        ]
		    });
		 
		if(!win){
				win = desktop.createWindow({
				
                id: this.id,
                title:'Recolecciones Espóradicas/Ordenes de Solicitudes Recolección Programadas',
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
				       	tab_recolecciones
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
