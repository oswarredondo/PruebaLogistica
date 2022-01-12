var vt ="";
var hv = "";
		
Ext.onReady(function(){
	 Ext.Ajax.on('beforerequest', function(conn, options) {
 	    var x = document.getElementsByTagName("META");
 	    var token = "";
 	    var headerVal = ""; 
 	    var i;
 	    for (i = 0; i < x.length; i++) {
 	        if (x[i].name == "_csrf")
 	        {
 	             token = x[i].content;
 	             vt=token;
 	        }else if (x[i].name=="_csrf_header"){
 	             headerVal = x[i].content;
 	             hv = headerVal;
 	             
 	        }
 	    }

 	    //Ext.Ajax.defaultHeaders = Ext.apply(Ext.Ajax.defaultHeaders || {}, { headerVal : token });
 	    Ext.Ajax.defaultHeaders = {
 	        headerVal : token,
 	        "_csrf_header" : token
 	    };
 	});
	 
	 var x = document.getElementsByTagName("META");
	    var token = "";
	    var headerVal = ""; 
	    var i;
	    for (i = 0; i < x.length; i++) {
	        if (x[i].name == "_csrf")
	        {
	             token = x[i].content;
	             vt=token;
	        }else if (x[i].name=="_csrf_header"){
	             headerVal = x[i].content;
	             hv = headerVal;
	             
	        }
	    }

	 
	 var menu="menuadmventa";
	 Ext.create('Ext.form.Panel', {
		    bodyPadding: 5,
		    width: 280,
		    // The form will submit an AJAX request to this URL when submitted
		   url: './acceso/updatepassword',
		    // Fields will be arranged vertically, stretched to full width
		    layout: 'anchor',
		    method:'POST',
		    defaults: {
		        anchor: '100%'
		    },

		    // The fields
		    defaultType: 'textfield',
		    items: [
		            {xtype : 'hidden', name:"_csrf", value:vt},
			    {
			        name: 'login',
			        width:150,
			        emptyText:"Usuario" ,
			        allowBlank: false
			    },{
			    	emptyText : 'Password Actual',
			        name: 'password',
			        width:150,
			        inputType:'password',
			        allowBlank: false
			    },
			    {
			    	emptyText : 'Password Nuevo',
			        name: 'passwordnuevo',
			        width:150,
			        inputType:'password',
			        allowBlank: false
			    },
			    {
			    	emptyText : 'Confirmar password',
			        name: 'passwordconfirmar',
			        width:150,
			        inputType:'password',
			        allowBlank: false
			    }
		    ],   

		    // Reset and Submit buttons
		    buttons: [

				    {
				        text: 'Reiniciar Password',
				        formBind: true, //only enabled once the form is valid
				        disabled: true,
				        handler: function() {
					            var form = this.up('form').getForm();
					            setValorFormaField('_csrf',this.up('form'),vt);
					           // var chkmodulo =  getValueFieldToForm('chk-modulo',this.up('form'));
					          //Valida que la contraseña y confirmación sean correctas
					            if (getValueFieldToForm('passwordnuevo',this.up('form')) != getValueFieldToForm('passwordconfirmar',this.up('form'))){
					            	alertMsg('Password Invalido','El password nuevo y su confirmacion no coinciden.');
					            	return;
					            }
					            
					            //Valida que la contraseña nueva cumpla con las politicas de seguridad
					            if (!validaPassword(getValueFieldToForm('passwordnuevo',this.up('form')))){
					            	alertMsg('Password Invalido','El password no cumple con la politicas de seguridad solicitadas, verifique.');
					            	return;
					            }
					            if (form.isValid()) {
					            	var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Verificando informacion espere..."});
									myMask.show();
									
					                form.submit({
					                	params:{"_csrf":vt},
					                    success: function(form, action) {
					                    		//Si la actualizacion es correcta se direcciona a la pagina de login
					                    		if (action.result.success){
					                    			mensajeConfirm("Se actualizo el password, ahora puede hacer login con su nuevo password")
					                    			var redirect = './';
					                    			window.location = redirect;
					                    		}
					                    			
					                    },
					                    failure: function(form, action) {
					                    	myMask.hide( );
											myMask.disable();
											alertMsg('Error',action.result.message);
											//Ext.Msg.alert('Failed', action.response.statusText);
					                    }
					                });
					            }
					        }
				    }
			    ],
		    renderTo: 'forma_login'
		});
	 
	 	var bodyElement = Ext.getBody();
	 	bodyElement.setStyle({'background-color':'#FFFFFF'});
	 
 });