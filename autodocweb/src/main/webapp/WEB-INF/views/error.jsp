<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>SIGEM-AUTODOC</title>
		
	<link rel="stylesheet" type="text/css" href="../resources/css/desktop.css" />
	<link rel="stylesheet" type="text/css" href="../resources/css/shortcuts.css" />
	<link rel="stylesheet" type="text/css" href="../resources/css/iconos.css" />
	
	<link rel="stylesheet" type="text/css" href="../resources/css/css_botones_menu.css" />	
	<link rel="stylesheet" type="text/css" href="../resources/css/opcionesmenu.css" />
	<link rel="stylesheet" type="text/css" href="../resources/css_estatus/estatus.css" />
  
	
	
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
      src="https://maps.googleapis.com/maps/api/js?v=3&sensor=false"  ></script>
  
  
	
		<link rel="stylesheet" type="text/css" href="../resources/css_menu/icons.css" />
		<link rel="stylesheet" type="text/css" href="../resources/css_menu/normalize.css" />
		<link rel="stylesheet" type="text/css" href="../resources/css_menu/demo.css" />
		<link rel="stylesheet" type="text/css" href="../resources/css_menu/component.css" />
				<script src="../resources/js_menu/modernizr.custom.js"></script>

    
	</head>
	<body>
		<div id='contenedor' class="container">
			<ul id="gn-menu" class="gn-menu-main">
				<li class="gn-trigger">
					<a class="gn-icon gn-icon-menu"><span>SIPA AUTO DOC</span></a>
					<nav class="gn-menu-wrapper">
						<div class="gn-scroller">
							<ul class="gn-menu">
								<li>
									<a class="gn-icon gn-icon-configuracion">Administración</a>
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
				<li><a href="#"  class="codrops-icon codrops-icon-rastreo" onclick="openOpcion('consulta-etiquetas-win');">Rastreo</a></li>
				<li><a href="#"  class="codrops-icon codrops-icon-report" onclick="openOpcion('ireport-web-win');">IReport-Web</a></li>
			</ul>
			<header>
				<h1 style='font-family: serif;'><script>document.write(siglas_sistema);</script></h1>
				<h2 style='font-family: serif;'><script>document.write(nombre_sistema);</script></h2>	
				<h3 style='font-family: serif;'>SESION DE AUTODOCUMENTACION RECHAZADA POR UNA DE LAS SIGUIENTES RAZONES:</h3>
				<h3 style='font-family: serif;'>-USUARIO INVALIDO</h3>
				<h3 style='font-family: serif;'>-CONTRATO NO EXISTE o ESTA CANCELADO</h3>
				<h3 style='font-family: serif;'>-PLAZA NO CORRESPONDE A LA PLAZA DONDE SE GENERO EL CONVENIO</h3>
				<h3 style='font-family: serif;'></h3>
				<h3 style='font-family: serif;'>VERIFIQUE CON EL ADMINISTRADOR.</h3>

				<%=request.getParameter("error") %>
				  					
			</header> 
			<table align="right">
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