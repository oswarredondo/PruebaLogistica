	<div id='contenedor' class="container">
			<ul id="gn-menu" class="gn-menu-main">
				<li class="gn-trigger">
					<a class="gn-icon gn-icon-menu"><span>SIPA</span></a>
					<nav class="gn-menu-wrapper">
						<div class="gn-scroller">
							<ul class="gn-menu">
								<li>
									<a class="gn-icon gn-icon-recoleccion">Recolecciones</a>
									<ul class="gn-submenu">
										<li><a  href="#" class="gn-icon gn-icon-solicitud" onclick="openOpcion('administracion-ordenes-recoleccion-win');">Orden/Solicitud</a></li>
										<li><a  href="#" class="gn-icon gn-icon-manifiesto" onclick="openOpcion('administracion-manifiesto-ordenes-recoleccion-win');">Manifiesto</a></li>
									</ul>
								</li>
								<li>
									<a class="gn-icon gn-icon-utilerias">Utilerias</a>
									<ul class="gn-submenu">
									
										<li><a  href="#" class="gn-icon gn-icon-password" onclick="openOpcion('cambiar.password-win');">Contrase&ntilde;a</a></li>		
									</ul>
								</li>
								<li>
									<a href="#">&nbsp;</a>
									
								</li>
							</ul>
						</div><!-- /gn-scroller -->
					</nav>
				</li>
				<li><a  href="#" class="codrops-icon gn-icon-agenda" onclick="openOpcion('agenda-rastreo-win');">Agenda Rastreo</a></li>
				<li><a  href="#" class="codrops-icon gn-icon-solicitud" onclick="openOpcion('administracion-ordenes-recoleccion-win');">Orden/Solicitud</a></li>
				<li><a  href="#" class="codrops-icon gn-icon-manifiesto" onclick="openOpcion('administracion-manifiesto-ordenes-recoleccion-win');">Manifiesto</a></li>
				<li><a  href="#" class="codrops-icon gn-icon-password" onclick="openOpcion('cambiar.password-win');">Password</a></li>
				<li><a class="codrops-icon codrops-icon-rain" href="#" onclick="salir(); return false;"><span>Salir</span></a></li>
			</ul>
			<header>
				<h1><script>document.write(siglas_sistema);</script></h1>
				<h2><script>document.write(nombre_sistema);</script></h2>	
				<h3><img alt="" src="../resources/images/ajax-loader.gif"></h3>
				<h3>Configurando aplicaci&oacute;n espere ...</h3>
				  					
			</header> 
		</div><!-- /container -->