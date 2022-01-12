	<div id='contenedor' class="container">
			<ul id="gn-menu" class="gn-menu-main">
				<li class="gn-trigger">
					<a class="gn-icon gn-icon-menu"><span>SIPA</span></a>
					<nav class="gn-menu-wrapper">
						<div class="gn-scroller">
							<ul class="gn-menu">
								<!-- 
								<li>
									<a class="gn-icon gn-icon-configuracion">Configurac&oacute;n</a>
									<ul class="gn-submenu">
										<li><a  href="#" class="gn-icon gn-icon-entidadorganizacion"  onclick="openOpcion('entidad-organizacion-win');">Entidad/Organizaci&oacute;n</a></li>
										<li><a  href="#" class="gn-icon gn-icon-cuentascliente"  onclick="openOpcion('cuentas-cliente-win');">Cuentas Cliente</a></li>
										<li><a  href="#" class="gn-icon gn-icon-perfil"  onclick="openOpcion('perfiles-win');">Perfiles</a></li>
									</ul>
								</li> -->
								<li>
									<a class="gn-icon gn-icon-catalogos">Cat&aacute;logos</a>
									<ul class="gn-submenu">
										<li><a href="#"  class="gn-icon codrops-icon-adicionales" onclick="openOpcion('adicionales-win');">Adicionales</a></li>
										<li><a href="#"  class="gn-icon codrops-icon-servicio" onclick="openOpcion('servicios-win');">Servicios</a></li>
										<li><a  href="#" class="gn-icon gn-icon-pin" onclick="openOpcion('forma-pago-win');">Formas de Pago</a></li>
										<li><a  href="#" class="gn-icon gn-icon-pin" onclick="openOpcion('metodo-pago-win');">M&eacute;todos de Pago</a></li>
										<li><a  href="#" class="gn-icon gn-icon-pin" onclick="openOpcion('poblacion-pago-win');">Pobraci&oacute;n de Pago</a></li>
										<li><a  href="#" class="gn-icon gn-icon-pin" onclick="openOpcion('condicion-pago-win');">Condiciones de Pago</a></li>
										<li><a  href="#" class="gn-icon gn-icon-pin" onclick="openOpcion('grupo-cliente-win');">Grupo Cliente</a></li>
										<li><a  href="#" class="gn-icon gn-icon-pin" onclick="openOpcion('oficina-control-win');">Oficina de Control</a></li>
										<li><a  href="#" class="gn-icon gn-icon-pin" onclick="openOpcion('unidadadministrativa-win');">Unidad Administrativa</a></li>
										<li><a  href="#" class="gn-icon gn-icon-pin" onclick="openOpcion('agrupamientos-win');">Agrupamientos</a></li>
										<!-- <li><a  href="#" class="gn-icon gn-icon-pin" onclick="openOpcion('puestos-win');">Puestos</a></li>
										<li><a  href="#" class="gn-icon gn-icon-pin" onclick="openOpcion('puestos-win');">Puestos</a></li> -->
										
									</ul>
								</li>
								<li>
									<a href="#">&nbsp;</a>
									
								</li>
							</ul>
						</div><!-- /gn-scroller -->
					</nav>
				</li>
				
				<li><a  href="#" class="codrops-icon gn-icon-entidadorganizacion"  onclick="openOpcion('entidad-organizacion-win');">Entidad/Organizaci&oacute;n</a></li>
				<li><a  href="#" class="codrops-icon gn-icon-cuentascliente"  onclick="openOpcion('cuentas-cliente-win');">Cuentas Cliente</a></li>
				<li><a  href="#" class="codrops-icon gn-icon-perfil"  onclick="openOpcion('perfiles-win');">Perfiles</a></li>
				
				<li><a  href="#" class="codrops-icon gn-icon-parametros" onclick="openOpcion('parametros_configuracion-win');">Params Sistema</a></li>
				<li><a  href="#" class="codrops-icon gn-icon-tareas" onclick="openOpcion('administracion-tarea-win');">Config. Tareas</a></li>
				<li><a  href="#" class="codrops-icon gn-icon-password" onclick="openOpcion('cambiar.password-win');">Password</a></li>
										

				<li><a class="codrops-icon codrops-icon-rain" href="#" onclick="salir(); return false;"><span>Salir</span></a></li>
			</ul>
			<header>
				<h1><script>document.write(siglas_sistema);</script></h1>
				<h2><script>document.write(nombre_sistema);</script></h2>	
				<h3><img alt="" src="../resources/images/ajax-loader.gif"></h3>
				<h3>Configurando aplicaci&oacute;n espere ...</h3>
				  					
			</header> 
			<table align="right">
					<tr>
						<td><span id='tareaspendientes'></span></td>
						</tr>
				</table>	
		</div><!-- /container -->