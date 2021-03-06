<!DOCTYPE html>
<html >
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
		
		<title>SIGEM-Monitor Movimientos</title>
		
	<link rel="stylesheet" type="text/css" href="../resources/css/desktop.css" />
	<link rel="stylesheet" type="text/css" href="../resources/css/shortcuts.css" />
	<link rel="stylesheet" type="text/css" href="../resources/css/iconos.css" />
	
	<link rel="stylesheet" type="text/css" href="../resources/css/css_botones_menu.css" />	
	<link rel="stylesheet" type="text/css" href="../resources/css/opcionesmenu.css" />
	<link rel="stylesheet" type="text/css" href="../resources/css_estatus/estatus.css" />
	<link rel="stylesheet" type="text/css" href="../resources/ext-4.2.1/examples/ux/css/ItemSelector.css" />
	
    <script type="text/javascript" src="../resources/ext-4.2.1/examples/shared/include-ext.js"></script>
    <script type="text/javascript" src="../resources/ext-4.2.1/examples/shared/options-toolbar.js"></script>
    <script type="text/javascript" src="../resources/ext-4.2.1/examples/ux/grid/FiltersFeature.js"></script>
    <script type="text/javascript" src="../resources/ext-4.2.1/locate/ext-lang-es.js"></script>
    <script type="text/javascript" src="../resources/jsdesktop/objetos/menu_principla.js"></script>
	<script type="text/javascript" src="../resources/jsdesktop/objetos/Utilerias.js"></script>
	<script type="text/javascript" src="../resources/jsdesktop/objetos/vtypes_extjs.js"></script>

	<script type="text/javascript" src="../resources/ext-4.2.1/JQuery.js"></script>
	<script type="text/javascript" src="../resources/ext-4.2.1/fileDownload.js"></script>
	
	<script src="../resources/jsdesktop/excel/shim.js"></script>
	<script src="../resources/jsdesktop/excel/jszip.js"></script>
	<script src="../resources/jsdesktop/excel/xlsx.js"></script>
	<!-- uncomment the next line here and in xlsxworker.js for ODS support -->
	<script src="../resources/jsdesktop/excel/ods.js"></script>

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
		    font-size: 0.900em;
		}
		.x-grid-row-over .x-grid-cell-inner {
		    font-weight: bold;
		    font-size: 0.900em;
		    white-space: normal;
		}
		
	</style>

	

    <!-- </x-bootstrap> -->
	<script type="text/javascript"
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAB0T8tEHohBEDNgZ12pYMBBcfkA7PyUfM&sensor=false"  ></script>
  
  
	  		<link rel="stylesheet" type="text/css" href="../resources/css_menu/icons.css" />
		<!-- <link rel="stylesheet" type="text/css" href="../resources/css_menu/normalize.css" /> -->
		<link rel="stylesheet" type="text/css" href="../resources/css_menu/demo.css" />
		<link rel="stylesheet" type="text/css" href="../resources/css_menu/component.css" />
				<script src="../resources/js_menu/modernizr.custom.js"></script>
		
	
		
    <script type="text/javascript">
	
	
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
            'Ext.ux.desktop': '../resources/jsdesktop/js',
            'Ext.ux.grid': '../resources/ext-4.2.1/examples/ux/grid',
            'Ext.ux.window': '../resources/ext-4.2.1/examples/ux/window',
            'Ext.ux': '../resources/ext-4.2.1/examples/ux',

           
            MyDesktop: '../resources/jsdesktop'
        });

        Ext.require('MyDesktop.App');

        
        var myDesktopApp;
        var store_etiquetas ; //modulo 2
        var store_administracion;//modulo 1
        var store_mantenimiento;//modulo 9
        var store_logistica_transporte;//modulo 4
		var store_wallpaper;//modulo 

	    var recargaDatos=false; //Se abrio el monitor y se debe recargar cada minuto
		
        var store_pdv;//modulo P
		
		function checkEnable(id){
			//Verifica en el combo si existe 
			var isdisable = false;
			//-->var isdisable = true;
			//-->store_administracion.each(function(record){
				
				//-->if (record.get('windowId') == id){
					//Indica que la opcion no esta deshabilitada
					//-->isdisable= false;
				//-->}
			//-->});
			//La opcion no fue encontrada en store por lo
			//que se devuelve true para que se deshabilite el boton
			return isdisable;
		}

        var chart;
        var store1;
		 function  generateData(n, floor){
		        var data = [],
	            p = (Math.random() *  11) + 1,
	            i;
	            
	        floor = (!floor && floor !== 0)? 20 : floor;
	        
	        for (i = 0; i < (n || 12); i++) {
	            data.push({
	                name: Ext.Date.monthNames[i % 12],
	                data1: Math.floor(Math.max((Math.random() * 100), floor)),
	                data2: Math.floor(Math.max((Math.random() * 100), floor)),
	                data3: Math.floor(Math.max((Math.random() * 100), floor)),
	                data4: Math.floor(Math.max((Math.random() * 100), floor)),
	                data5: Math.floor(Math.max((Math.random() * 100), floor)),
	                data6: Math.floor(Math.max((Math.random() * 100), floor)),
	                data7: Math.floor(Math.max((Math.random() * 100), floor)),
	                data8: Math.floor(Math.max((Math.random() * 100), floor)),
	                data9: Math.floor(Math.max((Math.random() * 100), floor))
	            });
	        }
	        return data;
	    };
	    
		var treeImages = new Array();
		var index_images =0;
		var datosUsuario; 
		var tipo_menu='top';
		var propiedadessistema;

		//Contadores
		
	
        Ext.onReady(function () {
        	var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Configurando men??? principal..."});
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
	       				url: '../acceso/getDatosUsuario' ,
	       				success: function(response, opts) {
	       					var obj = Ext.decode(response.responseText);
	       				 	//Ext.MessageBox.alert('Confirmaci???n',obj.message);
	       				 	datosUsuario = obj;
	       				 	
	       				 	nombre_usuario_windows	=obj.nombre_usuario_windows;
	       				 	
							jerarquia_usuario_windows=obj.perfil_usuario_windows;
							perfil_usuario_windows	=obj.cliente_usuario_windows;
							cliente_usuario_windows	=obj.cliente_usuario_windows;
							login_usuario_windows	=obj.login_usuario_windows;
							usuario_wallpaper_windows= obj.usuario_wallpaper_windows;
							wallpaper_default_windows= obj.wallpaper_default_windows;
							usuario_up=obj.usuario_up;
							tipo_menu = obj.tipo_menu;

							wallpapers_own = 'desktopgreenenvia1.jpg';//usuario_wallpaper_windows;
							wallpaperStretch_own=true;
				
							
							//Opctiene opciones de menu	
							store_administracion = Ext.create('MyDesktop.store.StoreOpcionesMenu',{});
							store_administracion.getProxy().url = '../acceso/opcionesmenuadministracionventa';
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
									
									
									Ext.window.MessageBox('Configurando Men??? prioncipal, espere...','Men??? principal',
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
	       		//var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Verificando sesi???n de usuario..."});
	    		//myMask.show();
	    		Ext.getCmp('idverificasesionusuario').setText('<font color="#B45F04"><b>Verificando Sesion...</b></font> ',false);
	    		
	       		var conn = new Ext.data.Connection();
	       		conn.request({
       				url: '../acceso/check_sesion' ,
       				params:{pa:usuario_up,lo:login_usuario_windows},
       				success: function(response, opts) {
       					myMask.hide();
       					var obj = Ext.decode(response.responseText);
       					if (obj.invalido!=undefined){
       						Ext.getCmp('idverificasesionusuario').setText('Sesion de usuario <font color="#8A0808"><b>Inactiva</b></font>',false);
       						
       						document.location.href ='../';
       						return;
           				}
       					Ext.getCmp('idverificasesionusuario').setText('Sesion de usuario <font color="#04B404"><b>Activa</b></font>', false);
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

	       	var check_totales = function () {
	       		var conn = new Ext.data.Connection();
	       		conn.request({
       				url: '../logproceso/getContadores' ,
       				success: function(response, opts) {
       					var obj = Ext.decode(response.responseText);
       					/*if (obj.counter_entradas!=undefined){
       						Ext.getCmp('id_counter_entradas').setText('' +obj.counter_entradas,false);
           				}
       					if (obj.counter_salidas!=undefined){
       						Ext.getCmp('id_counter_salidas').setText('' +obj.counter_salidas,false);
       					}
       					if (obj.counter_confirmaciones!=undefined){
       						Ext.getCmp('id_counter_confirmaciones').setText('' +obj.counter_confirmaciones,false);
       					}
       					if (obj.counter_movlocal!=undefined){
       						Ext.getCmp('id_counter_movlocal').setText('' +obj.counter_movlocal,false);
       					}
       					if (obj.counter_varios!=undefined){
       						Ext.getCmp('id_counter_varios').setText('' +obj.counter_varios,false);
       					}	*/
       				},
       				failure: function(response, opts) {
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

	       	
	        var runner_movimientos = new Ext.util.TaskRunner();
	       	var taskrunner_movimientos = runner_movimientos.start({
	       		     run: check_totales,
					interval: 60000*1 //1minuto
	       });

	       /*	Ext.create('Ext.form.Label', {  id: 'id_counter_entradas', text:'0', renderTo:'counter_entradas'});
	       	Ext.create('Ext.form.Label',{ id: 'id_counter_salidas', text:'0', renderTo:'counter_salidas'} );
	       	Ext.create('Ext.form.Label',{ id: 'id_counter_confirmaciones', text:'0', renderTo:'counter_confirmaciones'});
	       	Ext.create('Ext.form.Label', {  id: 'id_counter_movlocal', text:'0', renderTo:'counter_movlocal'});
	       	Ext.create('Ext.form.Label',{ id: 'id_counter_varios', text:'0', renderTo:'counter_varios'});
*/
	     
			
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
		<div id='contenedor' class="container">
			<ul id="gn-menu" class="gn-menu-main">
				<li class="gn-trigger">
					<a class="gn-icon gn-icon-menu"><span>Monitor Scanners</span></a>
					<nav class="gn-menu-wrapper">
						<div class="gn-scroller">
							<ul class="gn-menu">
								<li>
									<a class="gn-icon gn-icon-configuracion">Administraci???n</a>
									<ul class="gn-submenu">
										<li><a href="#"  class="codrops-icon codrops-icon-rastreo" onclick="openOpcion('consulta-etiquetas-win');">Rastreo</a></li>
										<li><a href="#"  class="codrops-icon codrops-icon-report" onclick="openOpcion('ireport-web-win');">IReport-Web</a></li>
			    						<li><a href="#"  class="codrops-icon codrops-icon-report" onclick="openOpcion('ireport-web-win');">Bit???cora Agregado</a></li>
			    						<li><a href="#"  class="codrops-icon codrops-icon-report" onclick="openOpcion('ruta-web-win');">Ruta Manifiesto</a></li>
			    						<li><a href="#"  class="codrops-icon codrops-icon-rain"   onclick="salir(); return false;"><span>Salir</span></a></li>
									</ul>
								</li>
								
								
								<li>
									<a href="#"><span id='lbNombreUsuario'></span></a>
									
								</li>
							</ul>
						</div><!-- /gn-scroller --> 
					</nav>
				</li>
				<!-- 
				<li><a href="#"  class="codrops-icon gn-icon-entradas" >Entradas&nbsp<span id='counter_entradas'></span></a></li>
				<li><a href="#"  class="codrops-icon gn-icon-salidas" >Salidas&nbsp<span id='counter_salidas'></span></a></li>
				<li><a href="#"  class="codrops-icon gn-icon-movlocal" >Mov. Locales&nbsp<span id='counter_movlocal'></span></a></li>
				<li><a href="#"  class="codrops-icon gn-icon-entregas" >Confirmados&nbsp<span id='counter_confirmaciones'></span></a></li>
				<li><a href="#"  class="codrops-icon gn-icon-salidasfxc" >Mov. Varios&nbsp<span id='counter_varios'></span></a></li> 
				<li><a href="#"  class="codrops-icon gn-icon-template"  onclick="openOpcion('rotulador-etiquetas-win');">Reenvio Etiquetas</a></li>
 				-->
				<li><a href="#"  class="codrops-icon gn-icon-salidasfxc"  onclick="openOpcion('monitor-procesamiento-win');">Monitor</a></li> 
				<li><a href="#"  class="codrops-icon gn-icon-entregas"  onclick="openOpcion('manifiesto-movimientos-operativos-win');">Manifiesto</a></li>
				
				<li><a href="#"  class="codrops-icon gn-icon-oficinas"  onclick="openOpcion('indicadores-procesamiento-win');">Indicadores</a></li> 
			
				<li>&nbsp</li>
				
			</ul>
			<header>
				<h1 style='font-family: serif;'><script>document.write(siglas_sistema);</script></h1>
				<h2 style='font-family: serif;'><script>document.write(nombre_sistema);</script></h2>	
				<h3 style='font-family: serif;'><img alt="" src="../resources/images/ajax-loader.gif"></h3>
				<h3 style='font-family: serif;'>Configurando aplicaci&oacute;n espere ...</h3>
				  					
			</header> 
			<table align="right">
					<tr>
						<td><span id='grafico_proceso'></span></td>
						</tr>
					<tr>
						<td><span id='tareaspendientes'></span></td>
						</tr>
				</table>	
		</div><!-- /container -->
		<script src="../resources/js_menu/classie.js"></script>
		<script src="../resources/js_menu/gnmenu.js"></script>
		<script>
			new gnMenu( document.getElementById( 'gn-menu' ) );
		</script>
		
		
		
	</body>
</html>