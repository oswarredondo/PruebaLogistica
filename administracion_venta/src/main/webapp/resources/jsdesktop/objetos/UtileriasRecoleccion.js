var css_solicitante = 'background-color:#F7D358;border-color:#0000ff;';
var css_lugarrecol =  'background-color: #F3F781;border-color:#0000ff;';
var css_recoleccion = 'background-color: #A5DF00;border-color:#0000ff;'
	
Date.prototype.addDays = function (dias){
	var today= new Date();
	return new Date(today.getTime() + (dias * 24 * 60 * 60 * 1000));
}  
Date.prototype.lessDays = function (dias){
	var today= new Date();
	return new Date(today.getTime() - (dias * 24 * 60 * 60 * 1000));
}

/**
* Da fromato a un texto para que se vea en la misma celda todo el texto
*  */
function formatoCeldaTexto(value, metaData, record, rowIndex, colIndex, store) {
	metaData.attr = 'style="white-space:normal"';
	return value;
}
function showEstatusRecol(value, metaData, record, rowIndex, colIndex, store){  
	metaData.attr = 'style="white-space:normal"';
	     var images = "";

	     var titulo = "";
		if ((record.get('estatus')=='C') ){
			titulo  +="CANCELADA";
			images+="<img src='../resources/images_extjs/bullet_red_alt.png' ></a>";
		}

	    //Solo esta ACTIVO cuando no ha sido confirmado 
	    if (record.get('estatus')=='A'){
	    	if ( (record.get('quienRecibe')==undefined) || (record.get('quienRecibe')=="")){
	    		titulo  +="ACTIVA";
					images+="<img src='../resources/images/bullet_green_alt.png' ></a>";
	    	}
		} 
	    if ((record.get('estatus')=='H') ){
			titulo  +="SOLO HISTORIA";
			images+="<img src='../resources/images/bullet_black_alt.png' ></a>";
		}
	   
	    if ((record.get('estatus')=='L') ){
			titulo  +="RECOLECCIONES DEL CLIENTE BLOQUEADAS.";
			images+="<img src='../resources/images/lock.png' ></a>";
		}
		
		titulo = "ORDEN RECOLECCION: " +titulo;
		metaData.attr = 'ext:qtip="' + titulo + '"' ;
		return images;
	} 