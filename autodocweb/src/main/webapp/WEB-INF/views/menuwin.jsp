<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
	<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" language="java" %>
    
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<meta name="_csrf" content="${_csrf.token}"/>
		<meta name="_csrf_header" content="${_csrf.headerName}"/>
	
		<title>SIGEM-AUTODOC</title>
		
	<link rel="stylesheet" type="text/css" href="./resources/css/desktop.css" />
	<link rel="stylesheet" type="text/css" href="./resources/css/shortcuts.css" />
	<link rel="stylesheet" type="text/css" href="./resources/css/iconos.css" />
	
	<link rel="stylesheet" type="text/css" href="./resources/css/css_botones_menu.css" />	
	<link rel="stylesheet" type="text/css" href="./resources/css/opcionesmenu.css" />
	<link rel="stylesheet" type="text/css" href="./resources/css_estatus/estatus.css" />
    <script type="text/javascript" src="./resources/ext-4.2.1/examples/shared/include-ext.js"></script>
    <script type="text/javascript" src="./resources/ext-4.2.1/examples/shared/options-toolbar.js"></script>
    <script type="text/javascript" src="./resources/ext-4.2.1/examples/ux/grid/FiltersFeature.js"></script>
    <script type="text/javascript" src="./resources/ext-4.2.1/locate/ext-lang-es.js"></script>
    <script type="text/javascript" src="./resources/jsdesktop/objetos/menu_principla.js"></script>
	<script type="text/javascript" src="./resources/jsdesktop/objetos/Utilerias.js"></script>
	<script type="text/javascript" src="./resources/jsdesktop/objetos/vtypes_extjs.js"></script>
	<script type="text/javascript" src="./resources/jsdesktop/objetos/TitulosMensajes.js"></script>
<script type="text/javascript" src="./resources/jsdesktop/objetos/TitulosCamposColumnas.js"></script>
	
	
	<script src="./resources/jsdesktop/excel/shim.js"></script>
	<script src="./resources/jsdesktop/excel/jszip.js"></script>
	<script src="./resources/jsdesktop/excel/xlsx.js"></script>
	<!-- uncomment the next line here and in xlsxworker.js for ODS support -->
	<script src="./resources/jsdesktop/excel/ods.js"></script>

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

	<link rel="stylesheet" type="text/css" href="./resources/css_menu/icons.css" />
	<link rel="stylesheet" type="text/css" href="./resources/css_menu/normalize.css" />
	<link rel="stylesheet" type="text/css" href="./resources/css_menu/demo.css" />
	<link rel="stylesheet" type="text/css" href="./resources/css_menu/component.css" />
	<script src="./resources/js_menu/modernizr.custom.js"></script>
		
		
	
	<script type="text/javascript" 
		src="./resources/jsdesktop/objetos/sesion_usuario_inicio.js"></script>

    
	</head>
	<body>
	<spring:htmlEscape defaultHtmlEscape="true" />
		<div id='contenedor' class="container">
			<ul id="gn-menu" class="gn-menu-main">
				<li class="gn-trigger">
					<a class="gn-icon gn-icon-menu"><span>SIPA AUTO DOC</span></a>
					<nav class="gn-menu-wrapper">
						<div class="gn-scroller">
							<ul class="gn-menu">
								<li>
									<a class="gn-icon gn-icon-configuracion">Administraci&oacute;n</a>
									<ul class="gn-submenu">
										<li><a  href="#" class="gn-icon gn-icon-manifiesto"  onclick="openOpcion('manifiesto-documento-etiqueta-win');">Manifiestos</a></li>
										<li><a  href="#" class="gn-icon gn-icon-cuentascliente"  onclick="openOpcion('cartera-direcciones-win');">Cartera de Clientes</a></li>
										
										 <li><a  href="#" class="gn-icon gn-icon-template"  onclick="openOpcion('template-etiqueta-win');">Templates</a></li> 
									</ul>
								</li>
								<li>
									<a class="gn-icon gn-icon-recoleccion">Consultas</a>
									<ul class="gn-submenu">
										<li><a  href="#" class="gn-icon gn-icon-oficinas" onclick="openOpcion('consulta-oficinas-win');">Oficinas</a></li>
										<li><a  href="#" class="gn-icon gn-icon-clientesfacturacion"  onclick="openOpcion('cotizacion-envios-win');">Cotizaci&oacute;n</a></li>
									</ul>
								</li>
								
								<li>
									<a href="#"><span id='lbNombreUsuario'></span></a>
									
								</li>
							</ul>
						</div><!-- /gn-scroller -->
					</nav>
				</li>
				<li><a href="#"  class="codrops-icon codrops-icon-rotular" onclick="openOpcion('rotulador-config-etiquetas-win');">Rotular Etiquetas</a></li>
				<li><a href="#"  class="codrops-icon codrops-icon-rotular" onclick="openOpcion('documentador-etiquetas-win');">Documentar</a></li>
				<li><a href="#"  class="codrops-icon codrops-icon-rastreo" onclick="openOpcion('consulta-etiquetas-win');">Rastreo</a></li>

				<li><a href="#"  class="codrops-icon codrops-icon-report" onclick="openOpcion('ireport-web-win');">IReport-Web</a></li>
				<li><a href="#"  class="codrops-icon codrops-icon-tarifas" onclick="openOpcion('factura-resumen-win');">Facturar</a></li>
				<!-- REENVIO DE ETIQUETAS -->
				<li><a href="#"  class="codrops-icon gn-icon-template"  onclick="openOpcion('reenvio-etiquetas-win');">Reenvio Etiquetas</a></li>
				<li><a href="#"  class="codrops-icon gn-icon-template"  onclick="openOpcion('crear-ccp-win');">Crear Carta Porte</a></li>
				<li><a class="codrops-icon codrops-icon-rain" href="#" onclick="salir(); return false;"><span>Salir</span></a></li>
			</ul>
			<header>
				<h1 style='font-family: serif;'><script>document.write(siglas_sistema);</script></h1>
				<h2 style='font-family: serif;'><script>document.write(nombre_sistema);</script></h2>	
				<h3 style='font-family: serif;'><img alt="" src="./resources/images/ajax-loader.gif"></h3>
				<h3 style='font-family: serif;'>Configurando aplicaci&oacute;n espere ...</h3>
				  					
			</header> 
			<table align="right">
					<tr>
						<td><span id='tareaspendientes'></span></td>
						</tr>
				</table>	
		</div><!-- /container -->
		<script src="./resources/js_menu/classie.js"></script>
		<script src="./resources/js_menu/gnmenu.js"></script>
		<script>
			new gnMenu( document.getElementById( 'gn-menu' ) );
		</script>
		
	</body>
</html>