   var quickStart =new Array();
        var shortcuts =new Array();
		var nombre_usuario_windows='';
		var jerarquia_usuario_windows='';
		var perfil_usuario_windows='';
		var cliente_usuario_windows='';
		var login_usuario_windows='';
		var usuario_wallpaper_windows='';
		var wallpapers_own = '';
		var wallpaperStretch_own=true;	
		var usuario_up='';
		var propiedadessistema;
		
		var arregloModulos = [];//"<ietweb:permiteAccesoModulo permiteModulo="0.0" arregloModulos='true'/>";
	    var items_modulos=new Array();
	  
       Ext.Loader.setPath({
            'Ext.ux.desktop': './resources/jsdesktop/js',
            'Ext.ux.desktop': './resources/jsdesktop/js',
            'Ext.ux.grid': './resources/ext-4.2.1/examples/ux/grid',
            'Ext.ux.window': './resources/ext-4.2.1/examples/ux/window',
            'Ext.ux': './resources/ext-4.2.1/examples/ux',
            MyDesktop: './resources/jsdesktop'
        });

        Ext.require('MyDesktop.App');

        var myDesktopApp;
        //var store_etiquetas ; //modulo 2
        var store_administracion;//modulo 1
       // var store_mantenimiento;//modulo 9
        //var store_logistica_transporte;//modulo 4
		//var store_wallpaper;//modulo 

		
        var store_pdv;//modulo P
		
		function checkEnable(id){
			//Verifica en el combo si existe 
			var isdisable = true;
			store_administracion.each(function(record){
				
				if (record.get('windowId') == id){
					//alert('encontrado windowId:' + record.get('windowId')  + ", id:" + id);
					//Indica que la opcion no esta deshabilitada
					isdisable= false;
				}
			});
			//La opcion no fue encontrada en store por lo
			//que se devuelve true para que se deshabilite el boton
			return isdisable;
		}
		//var treeImages = new Array();
		//var index_images =0;
		var datosUsuario; 
		var tipo_menu='top';

		var vt ="";
		var hv = "";
        Ext.onReady(function () {
        	
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
        	
        	var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Configurando menú principal..."});
    		myMask.show();
    	
    		propiedadessistema =  Ext.create('MyDesktop.store.StoreParametrosConfiguracion',{
    			baseParams:{
    				idsistema:'SKY4SOL'
    			}
   			 });
  			 
        	if (Ext.util.Format) {
                Ext.apply(Ext.util.Format, {
                    thousandSeparator : ",",
                    decimalSeparator  : "."
                });
            }
			//Obtiene los datos del usuario

			var conn = new Ext.data.Connection();
	       			conn.request({
	       				url: './acceso/getDatosUsuario' ,
	       				success: function(response, opts) {
	       					var obj = Ext.decode(response.responseText);
	       				 	//Ext.MessageBox.alert('Confirmación',obj.message);
	       				 	datosUsuario = obj;
	       				 	
	       				 	//Redirecciona la pagina
	       				 	if (obj.estatus_pa!='A' ){
	       				 		
	       				 		var redirect="./login"
	       				 		if (obj.estatus_pa=='T' ){
	       				 			redirect = './reiniciapassword';
	       				 		}
	       				 		if (obj.estatus_pa=='C' ){
	       				 			redirect = './caducapassword';
	       				 		}
	       				
	       				 		//Redirije a la pagina correcta
	       				 		window.location = redirect;
	       				 	}
                    		
                    		//Inicializa las propiedades a desplgegar
	       				 	nombre_usuario_windows	=obj.nombre_usuario_windows;
	       				 	
							jerarquia_usuario_windows=obj.perfil_usuario_windows;
							perfil_usuario_windows	=obj.cliente_usuario_windows;
							cliente_usuario_windows	=obj.cliente_usuario_windows;
							login_usuario_windows	=obj.login_usuario_windows;
							usuario_wallpaper_windows= obj.usuario_wallpaper_windows;
							wallpaper_default_windows= obj.wallpaper_default_windows;
							tipo_menu = obj.tipo_menu;

							wallpapers_own = 'desktopgreenenvia1.jpg';//usuario_wallpaper_windows;
							wallpaperStretch_own=true;
				
							
							//Opctiene opciones de menu	
							store_administracion = Ext.create('MyDesktop.store.StoreOpcionesMenu',{});
							store_administracion.getProxy().url = './acceso/opcionesmenuadministracionventa';
							store_administracion.getProxy().setExtraParam("permiteModulo", '20');
				
				        	//Carga las opciones del menu solo de administracion
				        	store_administracion.load({
				        		params:{},
				        	 	callback:function(r,options,success){

				        	 		var permite_modulo =false;
				        	 		store_administracion.each(function(record){
				        				if ((record.data['idopcion'] == '20.0') || 
				        				   ((record.data['idmodulo'] == '2'))) {
				        					permite_modulo=true;
				        				}
				        			});

					        	 	
				        			//Crea el arreglo de quickstart y shortcut
					 				var size_store = store_administracion.count();
					 				var indice_qstart =0;
					 				var indice_shortcuts=0;

									var p = Ext.create('Ext.ProgressBar', {
									   renderTo: Ext.getBody(),
									   width: 300
									});
									
									
									Ext.window.MessageBox('Configurando Menú prioncipal, espere...','Menú principal',
										p.wait({
											interval: 500, //bar will move fast!
											duration: 3000,
											increment: 15,
											text: 'Updating...',
											scope: this,
											fn: function(){
												//p.updateText('Done!');
												myDesktopApp = new MyDesktop.App();	
												myDesktopApp.openWindowsMenu(myDesktopApp,obj);
												myMask.hide();
												
											}
										})
									);
				        	 	}
				        	
				        	});

	       		},
	       		failure: function(response, opts) {
	       			var obj = Ext.decode(response.responseText);
	       			Ext.Msg.alert('Error',obj.message);
	       		}
	       	});
				

	       	var check_sesion = function () {
	       		//var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Verificando sesión de usuario..."});
	    		//myMask.show();
	    		Ext.getCmp('idverificasesionusuario').setText('<font color="#B45F04"><b>Verificando Sesión...</b></font> ',false);
	    		
	       		var conn = new Ext.data.Connection();
	       		conn.request({
       				url: './acceso/check_sesion' ,
       				params:{pa:usuario_up,lo:login_usuario_windows},
       				success: function(response, opts) {
       					myMask.hide();
       					var obj = Ext.decode(response.responseText);
       					if (obj.invalido!=undefined){
       						Ext.getCmp('idverificasesionusuario').setText(msg_sesion_inactiva,false);
       						
       						document.location.href ='./';
       						return;
           				}
       					Ext.getCmp('idverificasesionusuario').setText(msg_sesion_activa, false);
       					//Ext.Msg.alert('Error',obj.message);
       				},
       				failure: function(response, opts) {
       					myMask.hide();
    	       			
    	       			if (response.responseText!=undefined){
    	       				var obj = Ext.decode(response.responseText);
    	       				if (obj.message!=undefined){
    	       					Ext.getCmp('idverificasesionusuario').setText(obj.message, false);
    	       					//Ext.Msg.alert('Error',obj.message);
        	       			}
    	       				
        	       		}
    	       			
    	       		}
	       		});  
	       	};

	        var runner = new Ext.util.TaskRunner();
	       	var task = runner.start({
	       		     run: check_sesion,
					interval: 60000*5 //5minutos
	       });
			

	        var bodyElement = Ext.getBody();
			  bodyElement.setStyle({
				  'background-color':'#FFFFFF',
				  'height': '100%',
				   'background': '#34495e',
				   'background': 'url(./resources/css_menu/images/desktopgreenenvia1.jpg) no-repeat center center fixed',
				    '-webkit-background-size': 'cover',
				    '-moz-background-size': 'cover',
				    '-o-background-size': 'cover',
				    'background-size': 'cover'

			  });
	        
        });