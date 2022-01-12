 Ext.onReady(function(){

	 Ext.create('Ext.form.Panel', {
		    bodyPadding: 5,
		    width: 280,
		   url: '../acceso/updatepassword',
		    layout: 'anchor',
		    defaults: {
		        anchor: '100%'
		    },

		    // The fields
		    defaultType: 'textfield',
		    items: [
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
					                    success: function(form, action) {
					                    		//Si la actualizacion es correcta se direcciona a la pagina de login
					                    		if (action.result.success){
					                    			mensajeConfirm("Se actualizo el password, ahora puede hacer login con su nuevo password")
					                    			var redirect = '../';
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