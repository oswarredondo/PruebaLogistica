/*!
 * Administracicion de tarifas
 */

Ext.define('MyDesktop.ViewMonitorRegistrosProcesados', {
    extend: 'Ext.ux.desktop.Module',
    id:'monitor-procesamiento-win',
    

    requires: [
        'Ext.chart.*',
        'Ext.data.JsonStore',
        'Ext.layout.container.Fit', 
        'Ext.window.MessageBox'
    ],



    refreshRate: 500,

    init : function() {
        // No launcher means we don't appear on the Start Menu...
//        this.launcher = {
//            text: 'SystemStatus',
//            iconCls:'cpustats'
//        };

    	  this.launcher = {
    	            text: 'Manifiesto Movimientos',
    	            iconCls:'wallpaper_blue',
    	        }
    	  
        Ext.chart.theme.Memory = Ext.extend(Ext.chart.theme.Base, {
            constructor: function(config) {
                Ext.chart.theme.Memory.superclass.constructor.call(this, Ext.apply({
                    colors: [ 'rgb(244, 16, 0)',
                              'rgb(248, 130, 1)',
                              'rgb(0, 7, 255)',
                              'rgb(84, 254, 0)']
                }, config));
            }
        });
    },

    createNewWindow: function () {
        var me = this,
            desktop = me.app.getDesktop();

        this.pie_registros_porcentajes1 = new MyDesktop.form.FormPieChart({ 
        	titulo:'',
        	 width: 600,
			 heigth:200,
			 layout:'fit',
			 tipoconsulta:1
		});
        this.pie_registros_porcentajes2 = new MyDesktop.form.FormPieChart({ 
			 titulo:'',
			 width: 600,
			 heigth:200,
			 layout:'fit',
			 tipoconsulta:2
		});
        
        this.pie_registros_porcentajes3 = new MyDesktop.form.FormPieChart({ 
        	titulo:'',
        	 width: 600,
			 heigth:200,
			 layout:'fit',
			 tipoconsulta:3
		});
       
        

    	this.grid_registros1 = new MyDesktop.grid.GridLogRegistrosProcesados({ 
			 width: 600,
			 heigth:150,
			 title:'Registros procesados',
			 border:true,
			 frame:false,
			 flex: 1,
			 layout:'fit',
			 tipoconsulta:1
		});
    	

    	this.grid_registros2 = new MyDesktop.grid.GridLogRegistrosProcesados({ 
			 width: 600,
			 heigth:150,
			 title:'Registros Estatus',
			 border:true,
			 frame:false,
			 flex: 1,
			 layout:'fit',
			 tipoconsulta:2
		});
    	
    	this.grid_registros3 = new MyDesktop.grid.GridLogRegistrosProcesados({ 
			 width: 600,
			 heigth:150,
			 title:'Registros Plaza',
			 border:true,
			 frame:false,
			 flex: 1,
			 layout:'fit',
			 tipoconsulta:3
		});
    	
    	
    	this.grid_registros = new MyDesktop.grid.GridRegistrosProcesados({ 
    		 width: 600,
			 heigth:150,
			 title:'Registros Procesados',
			 border:true,
			 frame:false,
			 flex: 1,
			 layout:'fit',
			 tipoconsulta:3
		});
    	
    	 setInterval(function () {
    		/* if (Ext.getCmp('idchkstopmonitor'+me.id).getValue()==true){
    			 me.grid_registros1.recargar();
        		 me.grid_registros2.recargar();
        		 me.grid_registros3.recargar();
        		 
        		 me.pie_registros_porcentajes1.recargar();
        		 me.pie_registros_porcentajes2.recargar();
        		 me.pie_registros_porcentajes3.recargar();
        		 
        		 
        		 me.grid_registros.recargar(Ext.getCmp('idchksoloregistrosconerror'+me.id).getValue()); 
    		 }*/
    		 
    		

    	    }, 10000);
    	
    	 // second tabs built from JS
    	   
    	var pantallaPrincipal =    {
                title: 'Monitor de Registros',
                width: 1000,
                height: 700,
                border: false,
                layout: {
                    type: 'hbox',
                    align: 'stretch'    
                },
                bodyStyle: {
                    'background-color': '#FFF'
                },
                
                items: [{
                    flex: 1,
                    xtype: 'container',
                    width: 500,
                    layout: {
                        type: 'vbox',
                        align: 'stretch'

                    },
                    items: [
                            me.pie_registros_porcentajes1,
                            me.grid_registros1
                    ]
                }, {
                	 flex: 1,
                    xtype: 'container',
                    width: 500,
                    layout: {
                        type: 'vbox',
                        align: 'stretch'
                        
                    },
                    items: [
                        me.pie_registros_porcentajes2,
                        me.grid_registros2
                    ]
                },
                {
                    flex: 1,
                    xtype: 'container',
                    layout: {
                        type: 'vbox',
                        align: 'stretch',
                        width: 500
                    },
                    items: [
                        me.pie_registros_porcentajes3,
                        me.grid_registros3
                    ]
                }
                
               
                ]
            };
    	
    	 var tabs2 = Ext.widget('tabpanel', {
 	        activeTab: 0,
 	       width: 1000,
           height: 700,
           layout:'fit',
 	      tabPosition: 'left',
 	        defaults :{
 	            autoScroll: true,
 	            bodyPadding: 10
 	        },
 	        items: [pantallaPrincipal,
 	               me.grid_registros
 	        ]
 	    });
    	 

        return desktop.createWindow({
            id: me.id,
            title: 'Resumen Procesamiento',
            layout:'fit',
            iconCls:'wallpaper_blue',
            animCollapse:false,
            constrainHeader:true,
            maximized :true,
			maximizable:false,
            border: false,
            items: [tabs2],
            dockedItems:[
                   	        {
                   	            dock: 'top',
                   	            xtype: 'toolbar',
                   	            items: [
                   	                    
                   	                   {xtype: 'checkbox',id:'idchkstopmonitor'+me.id, checked:true},
                   	                   {xtype: 'label',text:'Actualizar información'},
                   	                   {xtype: 'checkbox',id:'idchksoloregistrosconerror'+me.id, checked:true},
                	                   {xtype: 'label',text:'Ver solo registros con error'}
                   	            ]
                   	        }
                   	        ]
        });
        
           
        
        
      
    },

    createWindow : function() {
        var win = this.app.getDesktop().getWindow(this.id);
        if (!win) {
            win = this.createNewWindow();
        }
        return win;
    }

   
});
