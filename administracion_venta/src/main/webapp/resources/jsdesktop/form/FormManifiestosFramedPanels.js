Ext.define('MyDesktop.form.FormManifiestosFramedPanels', {
    extend: 'Ext.Container',
    xtype: 'framed-panels',
    width: 660,

    layout: {
        type: 'table',
        columns: 2,
        tdAttrs: { style: 'padding: 5px;' }
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
    	
    	var grid_plazas = new MyDesktop.grid.GridPlazaRecoleccion({ 
			layout: 'fit', 
			ismanifiesto:true,
			 width: 350,
			 heigth:150,
			
		});
    	
    	grid_plazas.getSelectionModel().on('selectionchange', function(sm, selectedRecord) {
    		var siglas = selectedRecord[0].data.siglasplaza;
    		grid_rutas.refresInfoRutas(siglas);
    		/*grid_rutas.getStore().reload({
				params:{
					siglas:siglas
				},
				callback:function(r,options,success){
					 if (r.length<=0){
						 Ext.Msg.show({
							 title: 'Aviso',
							 msg: 'No existe información con el criterio de busqueda selecionado.',
							 modal: false,
							 icon: Ext.Msg.INFO,
							 buttons: Ext.Msg.OK						
						 });  
						
					 }
				 }	  
			});*/
    		
    		
    	});
		
		var grid_rutas = new MyDesktop.grid.GridRutaRecoleccion({ 
			layout: 'fit', 
			ismanifiesto:true
		});
		
		grid_rutas.getSelectionModel().on('selectionchange', function(sm, selectedRecord) {
			try {
				if (selectedRecord!=undefined){
					if (selectedRecord[0].data!=undefined){
						var siglas = selectedRecord[0].data.siglasplaza;
			    		var ruta = selectedRecord[0].data.idruta;
			    		var fecha='';
			    		//ruta,fecha,plaza, myscope
			    		 grid_programadas.buscaInformacionManifiesto(ruta,fecha,siglas,grid_programadas);
			    		 //idruta,plaza,fecha
			    		 grid_programadas.setRutaPlazaFecha(ruta,siglas,fecha);
					}
					
				}
			}
			catch(err) {
			  //alert( err.message);
			}
			
			

    	});
		
		var grid_programadas = new MyDesktop.grid.GridRecoleccionEsporadica(
					{
						id:this.id+'gridprogramadas_manif',
						layout: 'fit', 
						ismanifiesto:true
			});
    	
    	
    	var main_previo = new Ext.Panel(
    			{
                    title: 'Recolecciones',
                    collapsed: false,
                    collapsible: false,
                    width: 900,
                    height: 360,
                    layout: 'fit', 
                    tools: [
                            // { type:'pin' },
                             { type:'refresh',  handler:function(){
                            	 	grid_programadas.refreshInformacionManifiesto();
                             	}
                             }
                             //{ type:'search' },
                             //{ type:'save' }
                         ],
                    items:[grid_programadas],
                    colspan: 3
                }
    	);
    	
        this.items = [
            {
                title: 'Plazas existentes',
                items:[grid_plazas],
                layout:'fit',
                width: 450,
                height: 200
            },
            
            {
                title: 'Rutas disponibles',
                items:[grid_rutas],
                layout:'fit',
                width: 440,
                height: 200,
                tools: [
                       // { type:'pin' },
                        { type:'refresh',  handler:function(){
                        		var registro = grid_plazas.getRowSelected();
                        		//alert('siglas:' +registro.get('siglasplaza') );
                        		
                        		grid_rutas.refresInfoRutas(registro.get('siglasplaza'));
                    	 		
                     		}
                        }
                        //{ type:'search' },
                        //{ type:'save' }
                    ]
            },
            main_previo
            
        
        ];

        this.callParent();
    },
    vistaPrevia:function(main_previo,grid, url_properties){
		
		var rows =  grid.getSelectionModel().getSelection();
	
		if(rows.length <=0){
			mensajeAlert("Seleccione los registros que desea visualizar");
			return;
		}
		var selectedRecord = rows[0];
		//Limpia el frame
		var el = Ext.get(Ext.DomQuery.select('.x-panel-body',main_previo.el.dom)[0]);
		while (el.dom.childNodes[0]){			
			el.dom.removeChild(el.dom.childNodes[0]);	
		}
		el.createChild({
			tag:'iframe', 
			src:'../ireportweb/showReport?idregistro='+
			selectedRecord.get('idregistro') +"&" + url_properties,
			style:'border:none;width:100%;height:100%;'
		});
	}
});