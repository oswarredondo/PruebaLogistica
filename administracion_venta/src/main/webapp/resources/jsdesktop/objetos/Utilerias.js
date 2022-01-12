var version_app ="V2.0.0-20180328"; 
var nombre_sistema ='Sistema Integral de Gesti&oacute;n de Mensajer&iacute;a';
var siglas_sistema = 'SIGEM';

//// Funcion que valida el password
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
	 Ext.Msg.confirm('Cerrar Sesion', 'Desea salir de la aplicacion ahora?', function(btn){
     	if ((btn=='yes') || (btn=='si')){
     		var myMask = new Ext.LoadMask(Ext.getBody(), {msg:"Cerrando Sesion de usuario espere"});
     		myMask.show();
     		
     		document.location.href ='../';
     		return;
     	}
     	
     	
     });
}
function openOpcionBtn(obj) {
	openOpcion(obj.id);
}


function calculaPesoTotal(piezas,peso){
	return piezas*peso;

}
function calculaVolumenTotal(alto, ancho, largo, piezas){
	return (alto*ancho*largo)*piezas;
}

function getValorParametroSistema(parametro){
	var valor = arr_propiedadessistema[parametro] ;
	if (valor==undefined){
		valor = "";
	}
	return valor;
}

function getValorNumericParametroSistema(parametro){

	if (arr_propiedadessistema[parametro]==undefined){
		valor = 0;
	}else if (isNaN(arr_propiedadessistema[parametro])){
		valor = 0;
	}else{
		valor = Number(arr_propiedadessistema[parametro]);
	}
	return valor;
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
function showGMapWindows(datos){
	 var datos_url="administracion_gmaps.jsp?" + datos; 
	 var idoficina='';
		//Confdigura la ventana
		var win_gmaps = new Ext.Window({
			   title: '( ' + idoficina + ' )'+ nombre,
			   width: 650,
			   height:450,
			   minimizable: true,
			   maximizable: true,
			   resizable:true,
			   modal:true,
			   closable:true,
			   html: '<iframe src="' +datos_url +'" style="width:100%;height:100%;border:none;"></iframe>'
			});
		//Muestra la ventana
		win_gmaps.show();
	
}

function showPuntosRecoleccionRuta(datos){
	 var datos_url="../solicitudrecoleccion/puntosrecoleccion?"+datos; 

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

function getValueFieldToForm(campo, forma){
	var fields =forma.getForm().getFields( ) ; 
	return getValueFormField(campo, fields);
}

function getRawValueFieldToForm(campo, forma){
	var fields =forma.getForm().getFields( ) ; 
	return getRawValueFormField(campo, fields);
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
function getRawValueFormField(field_name, fields){
	var items = fields.items;
	var valor ="";
	for(i = 0; i < items.length; i++){
		field = items[i];
		if (field!=undefined){
			if (field.getName()==field_name){
				valor = field.getRawValue();
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
         title:'Confirmacion',
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
		width: 600,
		height: 500,
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

function creaVentanaEspera(mensaje){
	 if (mensaje==undefined){
		 mensaje= 'Procesando la informaci�n, espere...';
	 }
	  var pb = Ext.create('Ext.ProgressBar', {
	        text:mensaje
	    });

	  pb.wait({
		   interval: 500, //bar will move fast!
		   duration: 50000,
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


