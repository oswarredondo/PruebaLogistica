<!DOCTYPE html>
<html lang="es">
	<head>
	<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" language="java" %>
    
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<meta name="_csrf" content="${_csrf.token}"/>
		<meta name="_csrf_header" content="${_csrf.headerName}"/>
   	<title>Acceso</title>
	<link rel="stylesheet" type="text/css" href="./resources/css/estilos_login.css" />

    <link rel="stylesheet" type="text/css" href="./resources/css/desktop.css" />
    <link rel="stylesheet" type="text/css" href="./resources/css/icons.css" />
	<link rel="stylesheet" type="text/css" href="./resources/css/shortcuts.css" />

	<script type="text/javascript" src="./resources/ext-4.2.1/examples/shared/include-ext.js"></script>
	<script type="text/javascript" src="./resources/ext-4.2.1/examples/shared/options-toolbar.js"></script>
	<script type="text/javascript" src="./resources/ext-4.2.1/locate/ext-lang-es.js"></script>
	<script type="text/javascript" src="./resources/jsdesktop/objetos/Utilerias.js"></script>
		 
	
	<script type="text/javascript" src="./resources/jsdesktop/extjs.primer.acceso.js"></script>

 </head>
  <body background="white">
  <div class="wrapper">
  <spring:htmlEscape defaultHtmlEscape="true" />
  	<div class="google-header-bar  centered">
  		<div class="header content clearfix">
 		 	<img alt="En" class="logo" src="./resources/images/envia600px.png">  
 		</div>
  	</div>
  		<div class="main content clearfix">
			<div class="banner">
				<h2>Sistema Integral de Gestión de Mensajería</h2>
			</div>
			<div class="banner">
				<h4>Reiniciar Password Temporal</h4>
				
			</div>
			<div class="card signin-card">
				
				<p style="font-size: 90%;">Se ha detectado que su password fue asignado de forma temporal por lo que es necesario que lo reinicie.</p>
				<p style="font-size: 90%;">Su password debe tener las siguientes caracteristicas:</p>
				<ul>
				  <li style="font-size: 90%;">Debe tener minimo 7 y maximo 20 caracteres</li>
				  <li style="font-size: 90%;">Debe tener al menos un caracter entre 0 y 9</li>
				  <li style="font-size: 90%;">Debe tener al menos un caracter entre a y z</li>
				  <li style="font-size: 90%;">Debe tener al menos un caracter entre A y Z</li>
				  <li style="font-size: 90%;">Debe tener al menos un caracter de los siguientes signos @#$%</li>
				</ul>
				
	 			<span id='forma_login'></span>
	  			<a id="link-forgot-passwd" href=""></a>
	 		</div>
			<div class="one-google">
	 			<p class="switch-account">&nbsp;</p>
				<p class="tagline">Todos los derechos reservados Copyright © 2000-<script type="text/javascript">
						var d = new Date();
					document.write(d.getFullYear() + " -- " + version_app );
				</script> Chavez Zamudio/Innovargia</p>
			</div>
			
  		</div>
 
 </div>
 
 
  
</body></html>