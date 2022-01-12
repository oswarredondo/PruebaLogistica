		<div id='contenedor' class="container">
			<ul id="gn-menu" class="gn-menu-main">
				<li class="gn-trigger">
					<a class="gn-icon gn-icon-menu"><span>SIPA</span></a>
					<nav class="gn-menu-wrapper">
						<div class="gn-scroller">
							<ul class="gn-menu">
								<li>
									<a class="gn-icon gn-icon-clientes">Clientes</a>
									<ul class="gn-submenu">
										<li><a href="#" class="gn-icon gn-icon-prospecto"  onclick="openOpcion('clientes-win');">Prospectos</a></li>
										<li><a  href="#" class="gn-icon gn-icon-clientesfacturacion"  onclick="openOpcion('clientes-facturacion-win');">Facturaci&oacute;n</a></li>
									</ul>
								</li>
								<li>
									<a class="gn-icon gn-icon-configuracion">Configurac&oacute;n</a>
									<ul class="gn-submenu">
										<li><a href="#"  class="codrops-icon codrops-icon-ordenservicio" onclick="openOpcion('orden-win');">Orden de Servicio</a></li>
										<li><a href="#"  class="codrops-icon codrops-icon-tarifas" onclick="openOpcion('tarifas-win');">Tarifa</a></li>
									 	<li><a href="#"  class="codrops-icon codrops-icon-descuento" onclick="openOpcion('descuentos-win');">Descuentos</a></li>
										<li><a  href="#" class="codrops-icon gn-icon-password" onclick="openOpcion('cambiar.password-win');">Password</a></li>
										<li><a  href="#" class="gn-icon gn-icon-tareas" onclick="openOpcion('administracion-tarea-win');">Config. Tareas</a></li>
									</ul>
								</li>
								
								<li>
									<a href="#"></a>
									
								</li>
							</ul>
						</div><!-- /gn-scroller -->
					</nav>
				</li>
				<!--<li><a href="#"  class="codrops-icon codrops-icon-tarifas" onclick="openOpcion('tarifas-win');">Tarifa</a></li>  -->
				<li><a href="#"  class="codrops-icon codrops-icon-cotizacion" onclick="openOpcion('cotizacion-pre-win');">Cotizaci&oacute;n</a></li>
				<li><a href="#"  class="codrops-icon codrops-icon-convenio" onclick="openOpcion('convenio-win');">Convenio</a></li>
				<!-- 
				<li><a href="#"  class="codrops-icon codrops-icon-ordenservicio" onclick="openOpcion('orden-win');">Orden de Servicio</a></li>
				<li><a href="#"  class="codrops-icon codrops-icon-adicionales" onclick="openOpcion('adicionales-win');">Adicionales</a></li>
				<li><a href="#"  class="codrops-icon codrops-icon-servicio" onclick="openOpcion('servicios-win');">Servicios</a></li>
				
					-->
				<li><a  href="#" class="codrops-icon codrops-icon-servicio" onclick="openOpcion('tareas-pendientes-win');">Tareas Pendientes</a></li>
				
				<li><a class="codrops-icon codrops-icon-rain" href="#" onclick="salir(); return false;"><span>Salir</span></a></li>
			</ul>
			<header>
				<h1 style='font-family: serif;'><script>document.write(siglas_sistema);</script></h1>
				<h2 style='font-family: serif;'><script>document.write(nombre_sistema);</script></h2>	
				<h3 style='font-family: serif;' ><img alt="" src="../resources/images/ajax-loader.gif"></h3>
				<h3 style='font-family: serif;'>Configurando aplicaci&oacute;n espere ...</h3>
				  					
			</header> 
		</div><!-- /container -->