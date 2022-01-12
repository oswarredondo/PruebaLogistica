
<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
		<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" language="java" %>
    
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		 
		<title>SIGEM</title>
		
		 <link rel="stylesheet" type="text/css" href="../resources/css/desktop.css" />
		 <link rel="stylesheet" type="text/css" href="../resources/css/shortcuts.css" />
		 <link rel="stylesheet" type="text/css" href="../resources/css/iconos.css" />
		  <link rel="stylesheet" type="text/css" href="../resources/css/icons.css" />
		 
		   <script type="text/javascript" src="../resources/ext-4.2.1/examples/shared/include-ext.js"></script>
    <script type="text/javascript" src="../resources/ext-4.2.1/examples/shared/options-toolbar.js"></script>
    <script type="text/javascript" src="../resources/ext-4.2.1/locate/ext-lang-es.js"></script>
	<script type="text/javascript" src="../resources/jsdesktop/objetos/Utilerias.js"></script>
	<script type="text/javascript" src="../resources/jsdesktop/objetos/ConstanteEstatus.js"></script>

	<script type="text/javascript" src="../resources/jsdesktop/objetos/vtypes_extjs.js"></script>
	<script type="text/javascript" src="../resources/jsdesktop/objetos/UtileriasRecoleccion.js"></script>
	<script type="text/javascript" src="../resources/ext-4.2.1/examples/ux/window/Notification.js"></script>		
	
	<link rel="stylesheet" type="text/css" href="../resources/css/ext_notificaciones.css" />
	 
	 	<style>
	
		.x-tip {
	    	width: auto !important;
		}
		.x-tip-body {
		    width: auto !important;
		}
		.x-tip-body span {
		    width: auto !important;
		}
		
		.x-grid-row .x-grid-cell-inner {
		    white-space: normal;
		}
		.x-grid-row-over .x-grid-cell-inner {
		    font-weight: bold;
		    white-space: normal;
		}
	</style>


    <!-- </x-bootstrap> -->
	<script type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAB0T8tEHohBEDNgZ12pYMBBcfkA7PyUfM&sensor=false"  ></script>
  
  
	
		<link rel="stylesheet" type="text/css" href="../resources/css_menu/icons.css" />
		<link rel="stylesheet" type="text/css" href="../resources/css_menu/normalize.css" />
		<link rel="stylesheet" type="text/css" href="../resources/css_menu/demo.css" />
		<link rel="stylesheet" type="text/css" href="../resources/css_menu/component.css" />
		<script src="../resources/js_menu/modernizr.custom.js"></script>
		
		  <script type="text/javascript">
		   var submodulo='';
		  <% 
			String modulo = request.getParameter("m_");  
			modulo= modulo==null|| modulo.trim().length()<=0 ? "menuadmventa":modulo.trim().toLowerCase();
		 %>
		 
		<% if("menuadmventa".equals(modulo)){ %>
				submodulo='Adminitración de la Venta';
		<% }  else  if("menurecoleccion".equals(modulo)){ %>
			submodulo='Administración de Recolecciones';
		<% }  else  if("admcatalogos".equals(modulo)){ %>
			submodulo='Administración de Cat&aacute;logos';
		<%} %>

		
		 

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
		
		var arregloModulos = [];//"<ietweb:permiteAccesoModulo permiteModulo="0.0" arregloModulos='true'/>";
	    var items_modulos=new Array();
	  
       Ext.Loader.setPath({
            'Ext.ux.desktop': '../resources/jsdesktop/js',
            'Ext.ux': '../resources/ext-4.2.1/examples/ux/',
            'Ext.ux.window': '../resources/ext-4.2.1/examples/ux/window',
            MyDesktop: '../resources/jsdesktop',
			SalesManager:'../resources/desktop_app/views'
        });

        Ext.require('MyDesktop.App');

        var myDesktopApp;
        var store_etiquetas ; //modulo 2
        var store_administracion;//modulo 1
        var store_mantenimiento;//modulo 9
        var store_logistica_transporte;//modulo 4
		var store_wallpaper;//modulo 
		var plaza_usuario;
		
        var store_pdv;//modulo P
		
		function checkEnable(id){
			//Inicializa como deshabilitado el objeto  
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
		function tieneOpcion(id){
			//Inicializa como false
			var tieneOpcion = false;
			store_administracion.each(function(record){
				if (record.get('windowId') == id){
					tieneOpcion= true;
				}
			});
			return tieneOpcion;
		}
		var treeImages = new Array();
		var index_images =0;
		var propiedadessistema;
		var arr_propiedadessistema = [];
		
        Ext.onReady(function () {

        	propiedadessistema =  Ext.create('MyDesktop.store.StoreParametrosConfiguracion',{
    			baseParams:{
    				idsistema:'SKY4SOL'
    			}
   			 });

        	propiedadessistema.each(function(record){
        		arr_propiedadessistema[record.get('idpropertie')] = record.get('valor');
			});
			
        	
        	var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Configurando menú principal..."});
    		myMask.show();
    	
		
        	if (Ext.util.Format) {
                Ext.apply(Ext.util.Format, {
                    thousandSeparator : ",",
                    decimalSeparator  : "."
                });
            }
			//Obtiene los datos del usuario
			var obj; 
			var conn = new Ext.data.Connection();
	       			conn.request({
	       				url: '../catalogos/datos/getDatosUsuario' ,
	       				success: function(response, opts) {
	       					obj = Ext.decode(response.responseText);
	       				 	//Ext.MessageBox.alert('ConfirmaciÃ³n',obj.message);
	       				 
	       				 	nombre_usuario_windows	=obj.nombre_usuario_windows;
							jerarquia_usuario_windows=obj.perfil_usuario_windows;
							perfil_usuario_windows	=obj.cliente_usuario_windows;
							cliente_usuario_windows	=obj.cliente_usuario_windows;
							login_usuario_windows	=obj.login_usuario_windows;
							usuario_wallpaper_windows= obj.usuario_wallpaper_windows;
							//wallpaper_default_windows= obj.wallpaper_default_windows;
							usuario_up=obj.usuario_up;

							
							//TODO: ELIMINAR CUANDO ESTE EN PRO
							wallpapers_own = 'desktopgreenenvia1.jpg';//usuario_wallpaper_windows;
							wallpaperStretch_own=true;
				
	
							//Opctiene opciones de menu	
							store_administracion = Ext.create('MyDesktop.store.StoreOpcionesMenu',{});
							store_administracion.getProxy().url = '../acceso/opcionesmenuadministracionventa';
							store_administracion.getProxy().setExtraParam("permiteModulo", 'A');
				
				        	//Carga las opciones del menu solo de administracion
				        	store_administracion.load({
				        		params:{},
				        	 	callback:function(r,options,success){
				        	 		var permite_modulo =false;
				        	 		store_administracion.each(function(record){
				        				if ((record.data['idopcion'] == 'A.0') || 
				        				   ((record.data['idmodulo'] == 'A'))) {
				        					permite_modulo=true;
				        				}
				        			});

					        	 	
				        			//Crea el arreglo de quickstart y shortcut
					 				var size_store = store_administracion.count();
					 				var indice_qstart =0;
					 				var indice_shortcuts=0;
					 				/*for(i=0;i<size_store;i++) {
					 					record = store_administracion.getAt( i ) ;
					 					//quickStart
					 					if (record.get('quickstart')==1){
					 						quickStart[indice_qstart] =  { name: record.get('text'), iconCls: record.get('iconCls'), module: record.get('windowId')};
					 						indice_qstart++;
					 					}
					 					if (record.get('shortcut')==1){
					 						shortcuts[indice_shortcuts] =  { name: record.get('text'), iconCls: record.get('iconCls')+'-shortcut', module: record.get('windowId')};
					 						indice_shortcuts++;
					 					}
					 				}*/
					 			
							 		//Carga el Desktop cuando es el ultimo 
									myDesktopApp = new MyDesktop.App();	
					 				myDesktopApp.openWindowsMenu(myDesktopApp,obj);
									/*var p = Ext.create('Ext.ProgressBar', {
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
												myDesktopApp.openWindowsMenu(myDesktopApp,obj);
												myMask.hide();
												
											}
										})
									);*/
				        	 	}
				        	
				        	});

				        

	       		},
	       		failure: function(response, opts) {
	       			var obj = Ext.decode(response.responseText);
	       			Ext.Msg.alert('Error',obj.message);
	       		}
	       	});
				

	       	var check_sesion = function () {
	       		var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Verificando sesión de usuario..."});
	    		myMask.show();
	    		
	       		var conn = new Ext.data.Connection();
	       		conn.request({
       				url: '../acceso/check_sesion' ,
       				params:{pa:usuario_up,lo:login_usuario_windows},
       				success: function(response, opts) {
       					myMask.hide();
       					var obj = Ext.decode(response.responseText);
       					if (obj.invalido!=undefined){
       						var myMask_invalido = new Ext.LoadMask(Ext.getBody(), {msg:"Usuario inválido o dado de baja..."});
       						myMask_invalido.show();
       						document.location.href ='../';
       						return;
           				}
       					//Ext.Msg.alert('Error',obj.message);
       				},
       				failure: function(response, opts) {
       					myMask.hide();
    	       			
    	       			if (response.responseText!=undefined){
    	       				var obj = Ext.decode(response.responseText);
    	       				if (obj.message!=undefined){
    	       					Ext.Msg.alert('Error',obj.message);
        	       			}
    	       				
        	       		}
    	       			
    	       		}
	       		});  
	       	};

	       
	       /* var runner = new Ext.util.TaskRunner();
	    	var task = runner.start({
	  		     run:  function(){
	 	        	if (gridtareaspendientes!=undefined){
	 	        		gridtareaspendientes.loadInfo();
		        	}
		        },
				interval: 60000*1 //5 minutos
	    	});*/
	    	
	 		
	        var runner = new Ext.util.TaskRunner();
	       	var task = runner.start({
	       		     run: check_sesion,
					interval: 60000*5 //2 minutos
	       });

		  var bodyElement = Ext.getBody();
		  bodyElement.setStyle({
			  'background-color':'#FFFFFF',
			  'height': '100%',
			   'background': '#34495e',
			   'background': 'url(../resources/css_menu/images/desktopgreenenvia1.jpg) no-repeat center center fixed',
			    '-webkit-background-size': 'cover',
			    '-moz-background-size': 'cover',
			    '-o-background-size': 'cover',
			    'background-size': 'cover'

		  });
	        
        });
		


	
    </script>
    
	</head>
	<body> 
		 
		<% if("menuadmventa".equals(modulo)){ %>
			<jsp:include page="menuadmventa.jsp"  />
		<% }  else  if("menurecoleccion".equals(modulo)){ %>
		 <jsp:include page="menurecoleccion.jsp"  />
		<% }  else  if("admcatalogos".equals(modulo)){ %>
		    <jsp:include page="admcatalogos.jsp"  />
		<%} else{%>
			<h1 styte="background-color':'#FFFFFF';">Men&uacute; inv&aacute;lido</h1>
		<%} %>
		
		
		
		<script src="../resources/js_menu/classie.js"></script>
		<script src="../resources/js_menu/gnmenu.js"></script>
		<script>
			new gnMenu( document.getElementById( 'gn-menu' ) );
		</script>
		
		
		
	</body>
</html>