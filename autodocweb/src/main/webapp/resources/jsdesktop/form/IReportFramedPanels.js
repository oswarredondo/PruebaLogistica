Ext.define('MyDesktop.form.IReportFramedPanels', {
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
	    		            	read: './ireportweb/getDatosForm?idregistro=' +   selectedRecord[0].data.idregistro
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
	    		                             boxLabel: field_pdf,
	    		                             checked: true
	    		                         }/*, {
	    		                             inputValue: 'csv',
	    		                             boxLabel: field_csv
	    		                         }, {
	    		                             inputValue: 'html',
	    		                             boxLabel: field_html
	    		                         }, {
	    		                             inputValue: 'xls',
	    		                             boxLabel:  field_excel
	    		                         }*/]
	    		                     });
	    		                	 

	    		                 }else{
	    		                	 mensajeAlert(titulo_error);
	    		                 }
	    		             }
	    				}
    			
    				}
    		);

		},this);
    	
    	var propiedades_reportes = new MyDesktop.form.FormPropiedadesReporte({id:this.id+'ireportwebform'}); 
    	
    	var main_previo = new Ext.Panel(
    			{
                    title: titulo_vista_previa,
                    collapsed: false,
                    collapsible: false,
                    width: 774,
                    height: 300,
                    html: "",
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
                title: titulo_propiedades,
                width: 310,
                height: 200,
                layout:'fit',
                tools: [
                    { type:'save' , tooltip:titulo_vista_reporte,
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
			mensajeAlert(msg_seleccione_registros_visualizar);
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
			src:'./ireportweb/showReport?idregistro='+
			selectedRecord.get('idregistro') +"&" + url_properties,
			style:'border:none;width:100%;height:100%;'
		});
	}
});