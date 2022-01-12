var version_app ="V1.2.0-20180227";
var nombre_sistema ='Sistema Integral de Gesti&oacute;n de Mensajer&iacute;a';
var siglas_sistema = 'SIGEM';
var submodulo = 'Monitor de Scanner y Procesamiento de Informaci&oacute;n';

function getValorParametroSistema(parametro){
	var valor = "";
	propiedadessistema.each(function(record){
		if ( record.get('idpropertie') == parametro){
			valor = record.get('valor');
			return  valor;
		}
	});

	return "";
}

function openOpcion(id) {
	var id_win = id.replace('_item','');
	if (checkEnable(id_win)){
		mensajeAlert("Opción no configurada para el perfil del usuario.");
		return;
	}
	var win =myDesktopApp.openWindowsOpcionMenuId(id);
	if (win){
		win.show();
	}
	
	return false;
	
}

function salir(){
	 Ext.Msg.confirm('Cerrar Sesion', 'Desea cerrar la sesion ahora?', function(btn){
     	if ((btn=='yes') || (btn=='si')){
     		var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Cerrando Sesión de usuario espere"});
     		myMask.show();
     		
     		document.location.href ='../';
     		return;
     	}
     	
     	
     });
}
function openOpcionBtn(obj) {
	openOpcion(obj.id);
	
	
	
}

function creaVentanaEspera(mensaje){
	 if (mensaje==undefined){
		 mensaje= 'Procesando la informacion, espere...';
	 }
	  var pb = Ext.create('Ext.ProgressBar', {
	        text:mensaje
	    });

	  pb.wait({
		   interval: 500, //bar will move fast!
		   duration: 99999999999,
		   increment: 15,
		   text: mensaje,
		   scope: this,
		   fn: function(){
		      p.updateText('Terminado!');
		   }
		});  
	  
	 var ventana = Ext.create('Ext.window.Window', {
		    title: 'Aviso',
		    height: 80,
		    width: 400,
		    modal:true,
		    maximizable:false,
		    closable: false,
		    layout: 'fit',
		    items: pb
		}).show();
	 
	 return ventana;
}

function validaEsCorrecto(valor){
	if (valor==undefined){
		return false;
	}else{
		var se = valor.trim().length;
		if (se<=0){
			return false;
		}else {
			return false;
		}
	}
}

function validaSINO(valor){
	
	if (valor==undefined){
		return 'NO';
	}else{
		var se = valor.toLowerCase();
		if ((se!='si') &&  (se!='s') &&
			(se!='yes') &&  (se!='y') &&
			(se!='true') &&  (se!='t')){
			
			return 'NO';
		}else {
			return 'SI';
		}
	}
}

function validaTipoEntrega(valor){
	
	if (valor==undefined){
		return 'NACIONAL';
	}else{
		var se = valor.toLowerCase();
		if ((se!='internacional') &&  (se!='internacional') ){
			
			return 'NACIONAL';
		}else {
			return 'INTERNACIONAL';
		}
	}
}

function generateUUID() {
    var d = new Date().getTime();
    var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = (d + Math.random()*16)%16 | 0;
        d = Math.floor(d/16);
        return (c=='x' ? r : (r&0x7|0x8)).toString(16);
    });
    return uuid;
}

function childTreeItem(img) {
   return { img: img, text:getNameOfWallpaper(img), iconCls: '', leaf: true };
}
function isExtencionValida(extenciones,extencion_file){
	var n = extenciones.indexOf(extencion_file);
	if (n>-1){
		return true;
	}else{
		return false;
	}
}
function showGMapWindows(datos,idoficina,nombre){
	 var datos_url="../gmapscontroller/gmaps?" + datos; 

		//Confdigura la ventana
		var win_gmaps = new Ext.Window({
			   title: '( ' + idoficina + ' )'+ nombre,
			   width: 830,
			   height:650,
			   minimizable: false,
			   maximizable: false,
			   resizable:false,
			   modal:true,
			   closable:true,
			   html: '<iframe src="' +datos_url +'" style="width:100%;height:100%;border:none;"></iframe>'
			});
		//Muestra la ventana
		win_gmaps.show();
	
}

function showGMapLatLongWindows(latitud,longitud){
	 var datos_url="../gmapscontroller/gmapscoordenadas?longitud=" +longitud +"&latitud=" + latitud; 

		//Confdigura la ventana
		var win_gmaps = new Ext.Window({
			   width: 830,
			   height:650,
			   minimizable: false,
			   maximizable: false,
			   resizable:false,
			   modal:true,
			   closable:true,
			   html: '<iframe src="' +datos_url +'" style="width:100%;height:100%;border:none;"></iframe>'
			});
		//Muestra la ventana
		win_gmaps.show();
	
}

function showAndHideWindows(datos_url){
		//Confdigura la ventana
		var win_hidden = new Ext.Window({
			   title: '.......',
			   width: 50,
			   height:50,
			   minimizable: false,
			   maximizable: false,
			   resizable:true,
			   modal:true,
			   closable:true,
			   html: '<iframe src="' +datos_url +'" style="width:100%;height:100%;border:none;"></iframe>'
			});
		//Muestra la ventana
		win_hidden.show();
		win_hidden.hide();
	
}
function getNameOfWallpaper (path) {
	var text = path, slash = path.lastIndexOf('/');
	if (slash >= 0) {
		text = text.substring(slash+1);
	}
	var dot = text.lastIndexOf('.');
	text = Ext.String.capitalize(text.substring(0, dot));
	text = text.replace(/[-]/g, ' ');
	return text;
}

function getValueFormField(field_name, fields){
	var items = fields.items;
	var valor ="";
	for(i = 0; i < items.length; i++){
		field = items[i];
		if (field!=undefined){
			if (field.getName()==field_name){
				valor = field.getValue();
			}
		}
	}
	return valor;
}

function setValueFormField(field_name, fields, new_value){
	var items = fields.items;
	var valor ="";
	for(i = 0; i < items.length; i++){
		field = items[i];
		if (field!=undefined){
			if (field.getName()==field_name){
				field.setValue(new_value);
			}
		}
	}
	return valor;
}

function alertMsg(titulo,msg){
	mensajeWarning(msg);
	/*Ext.MessageBox.minWidth = 350;
	if (msg.trim().length>35){
		Ext.MessageBox.minWidth = 480;
	}else if (msg.trim().length>55){
		Ext.MessageBox.minWidth = 580;
	}
	 Ext.MessageBox.alert(titulo, msg );*/
}

function mensajeConfirm(msg){
	if( !Ext.isIE ){ 
		Ext.MessageBox.minWidth = 350;
		Ext.MessageBox.height=40;
		if (msg.trim().length>35){
			Ext.MessageBox.minWidth = 480;
			
		}else if (msg.trim().length>55){
			Ext.MessageBox.minWidth = 500;
			Ext.MessageBox.height=80;
		}
	}
	
	 Ext.MessageBox.alert({
         title:'Confirmaci�n',
         msg: msg,
         autoScroll:true,
         height:210,
         buttons: Ext.MessageBox.OK,
         icon: Ext.MessageBox.INFO 
     });
	 
} 
function mensajeAlert(msg){
	if( !Ext.isIE ){ 
		Ext.MessageBox.minWidth = 350;
		Ext.MessageBox.height=40;
		if (msg.trim().length>35){
			Ext.MessageBox.minWidth = 480;
		}else if (msg.trim().length>55){
			Ext.MessageBox.minWidth = 500;
			Ext.MessageBox.height=80;
		}
	}
	
	 Ext.MessageBox.alert({
         title:'Error',
         msg: msg,
         autoScroll:true,
         height:210,
         buttons: Ext.MessageBox.OK,
         icon: Ext.MessageBox.ERROR 
     });
	 
} 
function mensajeWarning(msg){
	if( !Ext.isIE ){ 
		Ext.MessageBox.minWidth = 350;
		Ext.MessageBox.height=40;
		if (msg.trim().length>35){
			Ext.MessageBox.minWidth = 480;
		}else if (msg.trim().length>55){
			Ext.MessageBox.minWidth = 500;
			Ext.MessageBox.height=80;
		}
	}
	
	 Ext.MessageBox.alert({
         title:'Verificar',
         msg: msg,
         autoScroll:true,
         autoScroll :true,
         height:210,
         buttons: Ext.MessageBox.OK,
         icon: Ext.MessageBox.WARNING
     });
	 
} 

function visorPDF(idwindows, titulo, url){
	var window_pdf_file_cotizacion = Ext.create('widget.window', {
		id:idwindows,
		title:titulo,
		width: 800,
		height: 650,
		modal:true,
		plain: true,
        html : '<iframe src="' + url + '" style="width:100%;height:100%;border:none;"></iframe>',
		headerPosition: 'right',
		layout: 'fit'
	}).show();
}

/**
 * Elimina los registros del store y espera la respuesta 
 * si no se pueden eliminar da rollback
 * @param scope_this
 * @param store
 * @param rows
 */
function deleteSyncStore(scope_this,store,rows,reload ){
	store.remove(rows);  //step 4
	store.sync({ 
		    success: function (proxy, operations) {
		    	scope_this.commitInfo();
		    	if (reload){
		    		store.load();
		    	}
		    }, failure: function (proxy, operations) {
		    	 if (proxy.exceptions != undefined){
		    		 if (proxy.exceptions.length>0){
		    			 Ext.Msg.show(
                             {
                            	 title: 'Warning',
                                 msg: proxy.exceptions[0].error,
                                 buttons: Ext.Msg.OK,
                                 icon: Ext.Msg.WARNING
                             });
		    		 	}
		    		 }
		        store.rejectChanges();
		    }
		});
}

/**
 * Actualiza los registros, si l bandera reload=true, 
 * recarga el store
 * si no se pueden eliminar da rollback
 * @param scope_this
 * @param store
 * @param rows
 */
function updateSyncStore(scope_this,store,reload ){
	store.sync({ 
		    success: function (proxy, operations) {
		    	scope_this.commitInfo();
		    	if (reload){
		    		store.load();
		    	}
		    }, failure: function (proxy, operations) {
		    	 if (proxy.exceptions != undefined){
		    		 if (proxy.exceptions.length>0){
		    			 Ext.Msg.show(
                             {
                            	 title: 'Warning',
                                 msg: proxy.exceptions[0].error,
                                 buttons: Ext.Msg.OK,
                                 icon: Ext.Msg.WARNING
                             });
		    		 	}
		    		 }
		        store.rejectChanges();
		    }
		});
}
/***
 * Realiza el reload de acuerdo a la funcion indicada
 * @param scope_this
 * @param store
 * @param params
 */
function updateSyncStoreReloadParams(scope_this,store,params ){

	store.sync({ 
		    success: function (proxy, operations) {
		    	scope_this.commitInfo();
		    	store.reload(
						{
							params:params,
							callback:function(r,options,success){
							}	  
						});
		    	
		    }, failure: function (proxy, operations) {
		    	 if (proxy.exceptions != undefined){
		    		 if (proxy.exceptions.length>0){
		    			 Ext.Msg.show(
                             {
                            	 title: 'Warning',
                                 msg: proxy.exceptions[0].error,
                                 buttons: Ext.Msg.OK,
                                 icon: Ext.Msg.WARNING
                             });
		    		 	}
		    		 }
		        store.rejectChanges();
		    }
		});
}


/***
 * 
 * @param scope_this
 * @param store
 * @param rows
 * @param params
 */
function deleteSyncStore(scope_this,store,rows ){
	store.remove(rows);  //step 4
	store.sync({ 
		    success: function (proxy, operations) {
		    	scope_this.commitInfo();
		    
		    }, failure: function (proxy, operations) {
		    	 if (proxy.exceptions != undefined){
		    		 if (proxy.exceptions.length>0){
		    			 Ext.Msg.show(
                             {
                            	 title: 'Warning',
                                 msg: proxy.exceptions[0].error,
                                 buttons: Ext.Msg.OK,
                                 icon: Ext.Msg.WARNING
                             });
		    		 	}
		    		 }
		        store.rejectChanges();
		    }
		});
}

/***
 * 
 * @param scope_this
 * @param store
 * @param rows
 * @param params
 */
function deleteSyncStoreReloadParams(scope_this,store,rows,params ){
	store.remove(rows);  //step 4
	store.sync({ 
		    success: function (proxy, operations) {
		    	scope_this.commitInfo();
		    	store.reload(
						{
							params:params,
							callback:function(r,options,success){
							}	  
						});

		    }, failure: function (proxy, operations) {
		    	 if (proxy.exceptions != undefined){
		    		 if (proxy.exceptions.length>0){
		    			 Ext.Msg.show(
                             {
                            	 title: 'Warning',
                                 msg: proxy.exceptions[0].error,
                                 buttons: Ext.Msg.OK,
                                 icon: Ext.Msg.WARNING
                             });
		    		 	}
		    		 }
		        store.rejectChanges();
		    }
		});
}


function windowsConsultaCPS(){
	var gridcps = Ext.create('MyDesktop.grid.GridConsultaCPs', { 
		isEditable:false,
		showMenuBusqueda:true
	}); 
	
	var buscacps_window = new Ext.Window({
		width    : 880,height   : 350,
		layout   : 'border',
		title	: 'Busqueda de códigos postales',
		closable:true,
		modal:true,
		headerPosition: 'right',
		items    : [
		   {items   : gridcps,layout :'fit',region :'center',height   : 100}
		   ],
		buttons: [
			{text   : 'Salir',handler: function(){buscacps_window.close();}}
        ]
	}); 

	buscacps_window.show();
 
}

function windowsFrecuenciaEntregaCPDestino(cpdestino){
	
	if (cpdestino==''){
		mensajeWarning("Debe capturar el CP destino");
		return;
	}
	
	var gridFrecuenciasEntrega= new MyDesktop.grid.GridFrecuenciasEntrega({
		frame:false, border:false,idRotulacion:'',isConsulta:false,
		hidden_cp:true, hidden_garmax:true, layout:'fit',
		cpdestino:cpdestino,tipobusqueda:1
	}); 

	
	var datos_window = new Ext.Window({
		width    : 700,
		height   : 300,
		title	: 'Frecuencias CP',
		closable:true,
		layout:'fit',
		resizable:false,
		modal:true,
		items: [gridFrecuenciasEntrega] ,
		headerPosition: 'right'
	}); 
	datos_window.show();
}

function validaCobetura(cp_rem,cp_des){
	
		var conn = new Ext.data.Connection();
	   		conn.request({
					url: '../rotular_etiquetas/validaCoberturaOrigenDestino' ,
					params:{cp_rem:cp_rem,cp_des:cp_des},
					success: function(response, opts) {
						var obj = Ext.decode(response.responseText);
						mensajeConfirm(obj.message)

					},
					failure: function(response, opts) {
		       			if (response.responseText!=undefined){
		       				var obj = Ext.decode(response.responseText);
		       				if (obj.message!=undefined){
		       					mensajeAlert(obj.message);
			       			}
			       		}
	       			
					}
	   		});  
}

function formatoRemDesTipTablaRotular(metaData, record,suf, error){
	var tip = '<table border=0>'
			+ '	<tr><td bgcolor=#CCCCCC><b>Raz&oacute;n social</b><font color=red>*</font>:</td><td >'
			+ record.get('razonsocial'+suf )
			+ '</td></tr>'
			+ '	<tr><td bgcolor=#CCCCCC><b>Atenci&oacute;n</b>:</td><td >'
			+ record.get('contacto'+suf)
			+ '</td></tr>'
			+ '	<tr><td bgcolor=#CCCCCC><b>Direcci&oacute;n</b><font color=red>*</font>:</td><td >'
			+ record.get('calle'+suf )
			+ '</td></tr>'
			+ '	<tr><td bgcolor=#CCCCCC><b>Num. Interior</b><font color=red>*</font>:</td><td >'
			+ record.get('numinterior'+suf )
			+ '</td></tr>'
			+ '	<tr><td bgcolor=#CCCCCC><b>Num. Exterior</b>:</td><td >'
			+ record.get('numexterior'+suf )
			+ '</td></tr>'
			+ '	<tr><td bgcolor=#CCCCCC><b>Colonia</b><font color=red>*</font>:</td><td >'
			+ record.get('colonia'+suf) + '&nbsp;&nbsp;&nbsp;<b>C.P&nbsp;<font color=red>*</font></b>'
			+ record.get('cp'+suf)
			+ '	<tr><td bgcolor=#CCCCCC><b>Municipio</b><font color=red>*</font>:</td><td >'
			+ record.get('municipio'+suf )
			+ '</td></tr>'
			+ '	<tr><td bgcolor=#CCCCCC><b>Estado</b>:</td><td >'
			+ record.get('estado'+suf)
			+ '</td></tr>'
			+ '	<tr><td bgcolor=#CCCCCC><b>Tel.</b>:</td><td >'
			+ record.get('telefono'+suf )
			+ '</td></tr>'
			+ '	<tr><td bgcolor=#CCCCCC><b>Email</b>:</td><td >'
			+ record.get('email'+suf ) + '</td></tr>' ;
	
		//Verifica si existe algun error
		for	(index = 0; index < error.length; ++index) {
			if (record.get('esvalido') == error[index]){
				tip = tip +	'<tr><td bgcolor=#CCCCCC><b>Error</b>:</td><td >'
				+ record.get('mensajeError' ) + '</td></tr>' ;
				
				metaData.style = "background-color:#FA5858;";
				
			}
		}
	

		tip = tip + '</table>';
	
		return tip;
	
}

function formatoDatosGeneralesTabla(metaData, record, error,despliegaServicio){
	
	var servicio = '<tr><td bgcolor=#CCCCCC><b>Servicio</b>:</td><td >'
			+ record.get('descripcion_servicio' ) + '</td></tr>';
			
	if (despliegaServicio==false){
		servicio=''
	}

	var cant = "."+ record.get('numpiezas' );	
	var tip = '<table border=0>'+servicio+
			'<tr><td bgcolor=#CCCCCC><b>Num. Piezas</b>:</td><td >' +
			 record.get('numpiezas' ) + '</td></tr>' 
			+ '	<tr><td bgcolor=#CCCCCC><b>Tiene Seguro?</b>:</td><td >'
			+ record.get('tiene_seguro' )
			+ '</td></tr>'
			+ '	<tr><td bgcolor=#CCCCCC><b>Es Ocurre?</b>:</td><td >'
			+ record.get('es_ocurre' )
			+ '</td></tr>'
			+ '	<tr><td bgcolor=#CCCCCC><b>Es Multiple?</b>:</td><td >'
			+ record.get('es_multiple') + '</td></tr>'
			+ '	<tr><td bgcolor=#CCCCCC><b>Entrega </b>:</td><td >'
			+ record.get('nacional' )
			+ '</td></tr>'
			+ '	<tr><td bgcolor=#CCCCCC><b>Contenido</b>:</td><td >'
			+ record.get('contenido')
			+ '</td></tr>'
			+ '	<tr><td bgcolor=#CCCCCC><b>Referencia</b>:</td><td >'
			+ record.get('referencia' )
			+ '</td></tr>'
			+ '	<tr><td bgcolor=#CCCCCC><b>Observacion</b>:</td><td >'
			+ record.get('observacion') + '</td></tr>' 
			+ '	<tr><td bgcolor=#CCCCCC><b>Alto</b>:</td><td >'
			+ record.get('alto' ) + '</td></tr>' 
			+ '	<tr><td bgcolor=#CCCCCC><b>Ancho</b>:</td><td >'
			+ record.get('ancho' ) + '</td></tr>' 
			+ '	<tr><td bgcolor=#CCCCCC><b>Largo</b>:</td><td >'
			+ record.get('largo' ) + '</td></tr>' 
			+ '	<tr><td bgcolor=#CCCCCC><b>Peso F�sco</b>:</td><td >'
			+ record.get('pesofisico' ) + '</td></tr>' ;
	
			for	(index = 0; index < error.length; ++index) {
				if (record.get('esvalido') == error[index]){
					tip = tip +	'<tr><td bgcolor=#CCCCCC><b>Error</b>:</td><td >'
					+ record.get('mensajeError' ) + '</td></tr>' ;
					
					metaData.style = "background-color:#FA5858;";
					
				}
			}
	
			tip = tip + '</table>';

			return tip;

}

function depuraCleanUUID(uuid){
		
		var conn = new Ext.data.Connection();
   		conn.request({
				url: '../rotular_etiquetas/depuraUUID' ,
				params:{uuid:uuid},
				success: function(response, opts) {
					var obj = Ext.decode(response.responseText);
				},
				failure: function(response, opts) {
	       			if (response.responseText!=undefined){
	       				var obj = Ext.decode(response.responseText);
	       				if (obj.message!=undefined){
	       					mensajeAlert(obj.message);
		       			}
		       		}
       			
				}
   		}); 
}


function isValidValueCampo(id, message){
	var valor = Ext.getCmp(id).getValue().trim();
	if ((valor.length<=0) || (!Ext.getCmp(id).validate())){
		Ext.getCmp(id).markInvalid();
		mensajeAlert(message);
		//alert(message);
		return false;
	}
	return true;
}
function isContenidoValueCampo(id, message){
	var valor = Ext.getCmp(id).getValue().trim();
	if (!Ext.getCmp(id).validate()){
		Ext.getCmp(id).markInvalid();
		mensajeAlert(message);
		//alert(message);
		return false;
	}
	return true;
}
function isContenidoValueNumeric(id, message){
	var valor = Ext.getCmp(id).getValue();
	if (!Ext.getCmp(id).validate()){
		Ext.getCmp(id).markInvalid();
		mensajeAlert( message);
		//alert(message);
		return false;
	}
	return true;
}

function isValidValueCampoRaw(id, message){
	var valor = Ext.getCmp(id).getRawValue().trim();
	if ((valor.length<=0) || (!Ext.getCmp(id).validate())){
		Ext.getCmp(id).markInvalid();
		mensajeAlert( message);
		//alert(message);
	 	return false;
	}
	return true;
}

////Funcion que valida el password
function validaPassword(cadena){
	//Checa un largo minimo de y caracteres y hasta 20
	//Al menos una minuscula
	//al menos una mayuscula
	//al menos un numero
	//al menos un signo  @#$%
	var val_pass=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?=.*[!@#$%]).{7,20}$/; 
	//Valida que cumpla con las politicas
	 if(!val_pass.test(cadena)) {
	      return false;
	}
	 return true;
	 
}
	
function getValueFieldToForm(campo, forma){
	var fields =forma.getForm().getFields( ) ; 
	return getValueFormField(campo, fields);
}

function getValueFormField(field_name, fields){
	var items = fields.items;
	var valor ="";
	for(i = 0; i < items.length; i++){
		field = items[i];
		if (field!=undefined){
			if (field.getName()==field_name){
				valor = field.getValue();
			}
		}
	}
	return valor;
}
