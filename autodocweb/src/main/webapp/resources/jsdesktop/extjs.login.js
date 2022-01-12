Ext.require([
    'Ext.tip.*'
]);

Ext.onReady(function(){
	 
	Ext.QuickTips.init();
	 
	 
	 Ext.create('Ext.form.Panel', {
		    bodyPadding: 5,
		    width: 280,
		    // The form will submit an AJAX request to this URL when submitted
		   url: './login',
		    // Fields will be arranged vertically, stretched to full width
		    layout: 'anchor',
		    defaults: {
		        anchor: '100%'
		    },

		    // The fields
		    defaultType: 'textfield',
		    items: [
					{
			            xtype: 'radiogroup',
			            fieldLabel: 'Busqueda por',
			            cls: 'x-check-group-alt',
			            items: [
			                {boxLabel: field_referencia, name: 'rb-auto', inputValue: 4,checked: true},
			               // {boxLabel: 'Guia', name: 'rb-auto', inputValue: 1, checked: true},
			                {boxLabel: field_consecutivo, name: 'rb-auto', inputValue: 18}
			            ]
			        },
		        	{
			        	xtype: 'myUpperCaseTextField', 
					    name: 'numcte',
					    width:150,
					    emptyText:field_numero_cliente,
					    allowBlank: false
					},
			    {
					xtype: 'myUpperCaseTextField', 
			        name: 'referencia',
			        width:150,
			        emptyText:titulo_datos_buscar ,
			        allowBlank: false
			    }
		            
		            ],

		    // Reset and Submit buttons
		    buttons: [{
		        text: titulo_btn_limpir,
		        handler: function() {
		            this.up('form').getForm().reset();
		        }
		    }, {
		        text: titulo_btn_buscar,
		        formBind: true, //only enabled once the form is valid
		        disabled: true,
		        handler: function() {
		            var form = this.up('form').getForm();
		            var fields =  this.up('form').getForm().getFields( ) ;
		        	var form = this.up('form').getForm();
			        if (!form.isValid()) {
			        	mensajeAlert(msg_datos_cliente_a_buscar);
		        		return;
			        }
		        
			    	var patron = getValueFormField('referencia',fields);
			    	var numcte = getValueFormField('numcte',fields);
			    	var tipobusqueda = form.findField('rb-auto').getGroupValue();
			    	
			    	if (patron==''){
		        		mensajeAlert(msg_datos_guia_a_buscar);
		        		return;
		        	}
		        	
			    	
			    	var url ='./busqueda_etiquetas/getDatosFueraSitio?tipoDocumento=ETIQU&'+
			    	'tipobusqueda='+ tipobusqueda+'&iddatoabuscar='+patron +'&numcte=' +numcte;
		        	consulta(url,patron);

		        }
		    }],
		    renderTo: 'forma_busquedareferencia'
		});
	 //busqueda por guia
	 Ext.create('Ext.form.Panel', {
		    bodyPadding: 5,
		    width: 280,
		    // The form will submit an AJAX request to this URL when submitted
		   url: './acceso/login',
		    // Fields will be arranged vertically, stretched to full width
		    layout: 'anchor',
		    defaults: {
		        anchor: '100%'
		    },
		   
		    // The fields
		    defaultType: 'textfield',
		    items: [
		    {
		    	xtype: 'myUpperCaseTextField', 
		        name: 'guia',
		        width:150,
		        emptyText: field_numero_guia,
		        allowBlank: false
		    }],

		    // Reset and Submit buttons
		    buttons: [{
		        text: titulo_btn_limpir,
		        handler: function() {
		            this.up('form').getForm().reset();
		        }
		    }, {
		        text: titulo_btn_buscar,
		        formBind: true, //only enabled once the form is valid
		        disabled: true,
		        handler: function() {
		        	var fields =  this.up('form').getForm().getFields( ) ;
		        	var form = this.up('form').getForm();
			        if (!form.isValid()) {
			        	mensajeAlert(msg_datos_guia_a_buscar);
		        		return;
			        }
		        
			    	var patron = getValueFormField('guia',fields);
		        	if (patron==''){
		        		mensajeAlert(msg_datos_guia_a_buscar);
		        		return;
		        	}
		        	var url ='./busqueda_etiquetas/getDatosFueraSitio?tipoDocumento=ETIQU&tipobusqueda=1&iddatoabuscar='+patron;
		        	consulta(url,patron);
		    		
		        }
		    }],
		    renderTo: 'forma_busquedaguia'
		});
	 
	 
	 	var bodyElement = Ext.getBody();
	 	bodyElement.setStyle({'background-color':'#FFFFFF'});
	 	
	 	function consulta(url,patron){
	 		var store = Ext.create('MyDesktop.store.StoreDocumento',{
  			  	model: 'MyDesktop.models.ModeloDocumento',
  			    autoSync: true,
  			    autoLoad: true,
	  			proxy: {
		  		    type: 'ajax',
		  	        timeout:99999999,
		  	        api: {
		  	            read: url
		  	        },
		  	        reader: {
		  	                 type: 'json',        successProperty: 'success',
		  	                 root : 'proxiArray', messageProperty: 'message',
		  	                 totalProperty : 'totalCount',
		  	        },
		  	        writer: {
		  	            	 type: 'json',   writeAllFields: true,
		  	                 encode: false,  root: 'proxiArray'
		  	        },
			  	      listeners: {
			              exception: function(proxy, response, operation){
			                      Ext.MessageBox.show({
			                          title: titulo_remote_exception,
			                          msg: operation.getError(),
			                          icon: Ext.MessageBox.ERROR,
			                          buttons: Ext.Msg.OK
			                      });
			                  }
			  	      	}
		  			},
		         sorters: [{
		             property: 'identificador',
		             direction: 'ASC'
		         }]
        	});
        	var grid= new MyDesktop.grid.GridConsultaEtiquetas(
        			{
        				urlVentanaPDF:"./busqueda_etiquetas/",
        				customStore:store,
        				ocultaBotonPDF:true,
        				isFueraSitio:true,
        				ocultaBotonExportar:true,
        				identidad:0, 
        				idorganizacion:0,
        				isConsulta:true,
        				isCancelar:false,
        				layout:'fit'
        			});
    	
        	
    		grid.busquedaCorta(patron,1);	
        	var busqueda = Ext.create('Ext.Window', {
    			
    			title: titulo_consulta_etiquetas,
    			width: 900,
    			height: 450,
    			modal:true,
    			 layout: 'fit',
    			items: grid
    			
    		});
    		
        	busqueda.show();
	 	}
	 
 });