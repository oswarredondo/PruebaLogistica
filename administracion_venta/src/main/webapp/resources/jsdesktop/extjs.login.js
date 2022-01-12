 Ext.onReady(function(){
	 var menu="menuadmventa";
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
		    items: [{
		        name: 'login',
		        width:150,
		        emptyText:"Usuario" ,
		        allowBlank: false
		    },{
		    	emptyText : 'Password',
		        name: 'password',
		        width:150,
		        inputType:'password',
		        allowBlank: false
		    },
		   
		    {
	            xtype: 'fieldset',
	            title: 'Seleccione Modulo de Administracion',
	            defaultType: 'radio', // each item will be a radio button
	            defaults: {
	               // anchor: '100%',
	                hideEmptyLabel: true
	            },
	            items: [ 
						{
				            xtype: 'radiogroup',
				            columns: 1,
				            vertical: true,
				            items: [
				                    { checked: true, boxLabel: 'Venta',name: 'chkmodulo',inputValue: 'menuadmventa', value: 'menuadmventa'},
				                    { boxLabel: 'Recolecciones',name: 'chkmodulo', inputValue: 'menurecoleccion',value: 'menurecoleccion'},
				                    {boxLabel: 'Catalogos',name: 'chkmodulo',inputValue: 'admcatalogos',value: 'admcatalogos'}
				            ],
				            listeners: {
				                change: function( radiogroup, newValue, oldValue, eOpts ) {
				                   menu = newValue.chkmodulo;
				                }
				            }
				        }
						] 
						
		    	}
		    ],   

		    // Reset and Submit buttons
		    buttons: [{
		        text: 'Limpiar',
		        handler: function() {
		            this.up('form').getForm().reset();
		        }
		    }, {
		        text: 'Entrar',
		        formBind: true, //only enabled once the form is valid
		        disabled: true,
		        handler: function() {
		            var form = this.up('form').getForm();
		            var chkmodulo =  getValueFieldToForm('chk-modulo',this.up('form'));
		           
		            if (form.isValid()) {
		            	var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Verificando informacion espere..."});
						myMask.show();
						
		                form.submit({
		                    success: function(form, action) {
		                    	
		                    	if (action.result.error==true){
		                    		myMask.hide( );
									myMask.disable();
		                    		alertMsg('Usuario Invalido',action.result.message);
		                    	}else{
		                    		var titulo ="";
		                    		var redirect = './acceso/menu?m_='+menu;
		                    	
		                    		
		                    		if (action.result.estado_pass=='T' ){
		                    			 redirect = './acceso/reiniciapassword';
		                    		}
		                    		if (action.result.estado_pass=='C' ){
		                    			 redirect = './acceso/caducapassword';
		                    		}
		                    		//Redirije a la pagina correcta
		                    		window.location = redirect;

		                    	}
								
		                    },
		                    failure: function(form, action) {
		                    	myMask.hide( );
								myMask.disable();
								alertMsg('Usuario Invalido',action.result.message);
								//Ext.Msg.alert('Failed', action.response.statusText);
		                    }
		                });
		            }
		        }
		    }],
		    renderTo: 'forma_login'
		});
	 
	 	var bodyElement = Ext.getBody();
	 	bodyElement.setStyle({'background-color':'#FFFFFF'});
	 
 });