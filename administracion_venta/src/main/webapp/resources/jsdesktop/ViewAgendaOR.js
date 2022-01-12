
Ext.define('MyDesktop.ViewAgendaOR', {
    extend: 'Ext.ux.desktop.Module',
    requires: [
        'Ext.tab.Panel'
    ],
    id:'agenda-rastreo-win',
    init : function(){
        this.launcher = {
            text: 'Agenda Rastreo',
            iconCls:'opcion_consultaetiqueta'
        }
    },
    grid:undefined,
	myScope:undefined,
	organizacioncombo:undefined,
	entidadcombo:undefined,
	grid_perfiles:undefined,
	createWindow : function(parametros){
	
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
		this.myScope=this;
		var scope= this;
		

		this.grid= new MyDesktop.grid.GridAgendaOR({layout:'fit'});
	
        if(!win){

        	  win = desktop.createWindow({
        		id: this.id,
                title:'Agenda de Ordenes de Rastreo',
                iconCls: 'opcion_consultaetiqueta',
                closable: true,
                //closeAction: 'hide',
  				maximized :true,
                border:true,
                layout:'fit',
                defaults: {
                    labelWidth: 100
                },
               // width: 900,
				//maximizable:true,
                layout: {
                    type: 'fit',
                    padding: 5
                },
  				items:[this.grid]
  				
            });
        }
       
      
        win.show();  
        return win;
    }
});
