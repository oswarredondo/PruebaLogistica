
Ext.define('MyDesktop.form.FormMonitorFramedPanels', {
    extend: 'Ext.Container',
    xtype: 'framed-panels',
    requires: [
               'Ext.chart.*',
           ],
    layout: {
        type: 'table',
        columns: 3,
        tdAttrs: { style: 'padding: 30px;' }
    },

    defaults: {
        xtype: 'panel',
        width: 200,
        height: 280,
        bodyPadding: 0,
        frame: true
    },

    initComponent: function () {
    	var myscope = this;
    	
    	this.grid_registros = new MyDesktop.grid.GridRegistrosProcesados({ 
			
			 width: 700,
			 heigth:500,
			
		});
    	
    	this.pie_registros_porcentajes = new MyDesktop.form.FormPieChart({ 
			 titulo:'Registros Procesados'
		});
    	
    	this.pie_tipos_errores_porcentajes = new MyDesktop.form.FormPieChart({ 
    		frame:false, border:false, titulo:'Tipos de errores'
		}); 
    	
    	this.pie_tipos_plazas_porcentajes = new MyDesktop.form.FormPieChart({ 
    		frame:false, border:false, titulo:'Plazas que envian'
		}); 
    	
		
    	
    	var main_previo = new Ext.Panel(
    			{
                    title: 'Registros en procesamiento',
                    collapsed: false,
                    collapsible: false,
                    width: 900,
                    height: 400,
                    layout: 'fit', 
                    tools: [
                            // { type:'pin' },
                             { type:'refresh',  handler:function(){
                            	 	//grid_programadas.refreshInformacionManifiesto();
                             	}
                             }
                             //{ type:'search' },
                             //{ type:'save' }
                         ],
                    items:[this.grid_registros]
                }
    	);
    	
        this.items = [
            {
            	frame:false, border:false,
                items:[this.pie_registros_porcentajes],
              
                width: 700,
                height: 450
            },
            {
            	frame:false, border:false,
                items:[this.pie_tipos_errores_porcentajes],
               
                width: 700,
                height: 450
            },
            {
            	frame:false, border:false,
                items:[this.pie_tipos_plazas_porcentajes],
               
                width: 200,
                height: 300
            },
            
            main_previo
            
        
        ];

        //Inicializa la variable global para que recargue cada minuto
        recargaDatos = true;
        this.callParent();
    },
    reload:function(){
    	this.grid_registros.recargar();
    	this.pie_registros_porcentajes.recargar();
    	this.pie_tipos_errores_porcentajes.recargar();
    	this.pie_tipos_plazas_porcentajes.recargar();
	
	}
});