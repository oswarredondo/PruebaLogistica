
<html lang="es"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
   <title>Acceso</title>

<link rel="stylesheet" type="text/css" href="resources/css/estilos_login.css" />

    <link rel="stylesheet" type="text/css" href="resources/css/desktop.css" />
  	<link rel="stylesheet" type="text/css" href="resources/css_estatus/estatus.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/shortcuts.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/iconos.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/opcionesmenu.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/css_botones_menu.css" />
	<link rel="stylesheet" type="text/css" href="resources/css/opcionesmenu.css" />
	
<script type="text/javascript" src="resources/ext-4.2.1/examples/shared/include-ext.js"></script>
<script type="text/javascript" src="resources/ext-4.2.1/examples/shared/options-toolbar.js"></script>
<script type="text/javascript" src="resources/ext-4.2.1/locate/ext-lang-es.js"></script>
    <script type="text/javascript" src="resources/ext-4.2.1/examples/ux/grid/FiltersFeature.js"></script>
    
<script type="text/javascript" src="resources/jsdesktop/objetos/Utilerias.js"></script>
<script type="text/javascript" src="resources/jsdesktop/objetos/TitulosMensajes.js"></script>
<script type="text/javascript" src="resources/jsdesktop/objetos/TitulosCamposColumnas.js"></script>


<script type="text/javascript" src="resources/jsdesktop/objetos/TextFieldUpperCase.js"></script>


<script type="text/javascript" src="resources/jsdesktop/models/ModeloLogHistoria.js"></script>
<script type="text/javascript" src="resources/jsdesktop/store/StoreHistoria.js"></script>
<script type="text/javascript" src="resources/jsdesktop/grid/GridHistoria.js"></script>

<script type="text/javascript" src="resources/jsdesktop/models/ModeloAttachment.js"></script>
<script type="text/javascript" src="resources/jsdesktop/store/StoreAttachment.js"></script>
<script type="text/javascript" src="resources/jsdesktop/grid/GridAttachment.js"></script>

<script type="text/javascript" src="resources/jsdesktop/grid/GridConsultaEtiquetas.js"></script>
<script type="text/javascript" src="resources/jsdesktop/models/ModeloDestinatario.js"></script>
<script type="text/javascript" src="resources/jsdesktop/models/ModeloRemitente.js"></script>
<script type="text/javascript" src="resources/jsdesktop/models/ModeloDocumento.js"></script>
<script type="text/javascript" src="resources/jsdesktop/store/StoreDocumento.js"></script>


<script type="text/javascript" src="resources/jsdesktop/extjs.login.js"></script>
  </head>
  <body >

<style type="text/css">
.x-border-box .x-tip, .x-border-box .x-tip * {
  box-sizing: content-box;
}
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
.table {
  width: 100%;
  height:: 100%;
  background: white;
  color: white;
}
.tablebusca {
  width: 100%;
  background: F7F7F7;
}


</style>
<script type="text/javascript">

</script>
<table class="table"  border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="102" colspan="4" background="resources/images/imaencabezado.png"></td>
  </tr>
  <tr>
    <td rowspan="2" bgcolor="#F7F7F7"><table border="0" cellspacing="0" class="tablebusca">
      <tr>
        <td >&nbsp;</td>
      </tr>
      <tr>
        <td align="center"><b><font face="verdana" size="3" color="black"><center >
      Auto Documentaci&oacute;n
    </center></font><b></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td><center ><span id='forma_login'></span></center></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table></td>
    <td  rowspan="2" align="center"><img src="resources/images/envia600pxivoy.png" width="554" height="253" border="0"></td>
    <td height="219" bgcolor="#F7F7F7"><table width="300" border="0" cellspacing="0" class="tablebusca">
           <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td align="center"><b><font face="verdana" size="3" color="black"><center >
      Consulta por n&uacute;mero de gu&iacute;a
    </center></font><b></td>
      </tr>

      <tr>
        <td><center ><span id='forma_busquedaguia'></span></center><</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td><span id='grid_consultaguia'></span></td>
      </tr>
      
    </table></td>
  </tr>
  <tr>
    <td height="283" bgcolor="#F7F7F7"><table border="0" cellspacing="0" class="tablebusca">
      <tr>
       
                <td align="center"><b><font face="verdana" size="3" color="black"><center >
Consulta por referencia
    </center></font><b></td>
    
      </tr>
      <tr>
        <td><center ><span id='forma_busquedareferencia'></span></center></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
    <tr>
    <td height="47" colspan="3" bgcolor="#D6D6D6" background="resources/images/cintapie.png"><font color="#FFFFFF"><center >
      Todos los derechos reservados Copyright &copy; 2000-<script type="text/javascript">
var d = new Date();
document.write(d.getFullYear() + " -- " + version_app);
</script>
 Chavez Zamudio/Innovargia
    </center></font></td>
  </tr>
</table>



</body></html>
