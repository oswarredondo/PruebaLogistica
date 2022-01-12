Ext.define('MyDesktop.form.IReportFramedPanels', {
	id:'idmainpanel',
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
        bodyPadding: 10,
        frame: true
    },

    initComponent: function () {
    	var myscope = this;
    	var grid_reportes = new MyDesktop.grid.GridIReportWeb({id:this.id+'ireportwebgrid', title:'Reportes'}); 
    	
    	grid_reportes.getSelectionModel().on('selectionchange', function(sm, selectedRecord) {
    		//Obtiene los campos de la forma
    		var store_propiedades = Ext.create('MyDesktop.store.StoreIReporteWeb',
    				{
    			  		model: 'MyDesktop.models.ModeloItemExtJS',
	    				proxy: {
	    		        	type: 'ajax',
	    		        	api: {
	    		            	read: '../ireportweb/getDatosForm?idregistro=' +   selectedRecord[0].data.idregistro
	    		        	},
	    		        	reader: {
	    		                 type: 'json',
	    		                 successProperty: 'success',
	    		                 root : 'proxiArray',
	    		                 messageProperty: 'message',
	    		                 totalProperty : 'totalCount',
	    		        	},
	    		        	afterRequest: function (request, success) 
	    		        	{
	    		                 //Verifica las llamadas
	    		                 if (request.action == 'read') {
	    		                     this.readCallback(request);
	    		                 }
	    		        	},
	    		        	readCallback: function (request) {
	    		        		 propiedades_reportes.removeAll(true);
	    		        		 propiedades_reportes.update( "" );
	    		        		var jsonData = store_propiedades.data.items;
	    		        		
	    		                 if (request.operation.success) 
	    		                 {
	    		                	 	
	    		                	 var jsonData = store_propiedades.data.items;
	    		                	 propiedades_reportes.updateArrayField(jsonData);
	    		                	 
	    		                	 for(i=0;i<jsonData.length;i++){
	    		                		 propiedades_reportes.add(jsonData[i].data);
	    		                	 }
	    		                	 
	    		                	 propiedades_reportes.add({
	    		                         id:'exportType',
	    		                		 xtype: 'radiogroup',
	    		                         anchor: 'none',
	    		                         layout: {
	    		                             autoFlex: false
	    		                         },
	    		                         defaults: {
	    		                             name: 'exportType',

	    		                             margin: '0 10 0 0'
	    		                         },
	    		                         items: [{
	    		                             inputValue: 'pdf',
	    		                             boxLabel: 'PDF',
	    		                             checked: true
	    		                         }, {
	    		                             inputValue: 'csv',
	    		                             boxLabel: 'CSV'
	    		                         }, {
	    		                             inputValue: 'html',
	    		                             boxLabel: 'HTML'
	    		                         }, {
	    		                             inputValue: 'xls',
	    		                             boxLabel: 'Excel'
	    		                         }]
	    		                     });
	    		                	 

	    		                 }else{
	    		                	 mensajeAlert("Error");
	    		                 }
	    		             }
	    				}
    			
    				}
    		);

		},this);
    	
    	var propiedades_reportes = new MyDesktop.form.FormPropiedadesReporte({id:this.id+'ireportwebform'}); 
    	
    	main_previo = new Ext.Panel(
    			{
                    id:'panelframe',
    				title: 'Vista Previa',
                    collapsed: false,
                    collapsible: false,
                    width: 774,
                    height: 280,
                    colspan: 3
                }
    	);

    	
        this.items = [
            {
                //title: 'Title',
                items:[grid_reportes],
                layout:'fit',
                height: 200,
                width: 450
            },
            {
                title: 'Propiedades',
                width: 310,
                height: 200,
                layout:'fit',
                tools: [
                    { type:'save' , tooltip:'Muestra el reporte',
                    	handler:function(){
                    		var url_properties= propiedades_reportes.getValueFieldsURL();
                    		// mensajeAlert("url_properties:" + url_properties);
                    		myscope.vistaPrevia(main_previo,grid_reportes,url_properties);
                    	} 
                    }
                ],
                items:[propiedades_reportes]
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

		var exportType = Ext.getCmp('exportType').getValue().exportType;

		var url = '../ireportweb/showReport?idregistro='+
		selectedRecord.get('idregistro') +"&" + url_properties;
		
		if(exportType != 'xls'){
			
			main_previo.up('panel').setLoading("Generando Reporte espere....");
			
			el.createChild({
				tag:'iframe', 
				onload: "main_previo.up('panel').setLoading(false)",
				src:url,
				style:'border:none;width:100%;height:100%;'
			});
			
		}else{
			
		    $.fileDownload(url, {
		    	panel: this,
		        preparingMessageHtml: "Generando Reporte EXCEL espere por favor...",
		        failMessageHtml: "Hubo un error al generar su reporte, intente nuevamente."
		    });
		    return false;
		}

	},
	
	excelReport: function (url) {
	    $.ajax({
	    	scope: this,
	    	url: url,
	        method: 'GET',
	        autoAbort: false,
	        timeOut:9999999,
	        success: function(result) {
	        	
	            if(result.status == 204) {
	            	
	                Ext.Msg.alert('Empty Report', 'There is no data');
	                
	            } else if(result.status == 200) {
	            	
	            }
	        },
	        failure: function() {
	            //failure here will automatically
	            //log the user out as it should
	        }
	    });
	}
});