/**
 * 
 */
package com.administracion.dto;

/**
 * @author aruaro
 * 
 */
public class ITextObjeto {

	private int idregistro;
	private int identidad;
	private int idorganizacion;
	private int rotation=0;
	private int fontsize=0;
	private int baseline=0;
	
	
	private float x=0;
	private float y=0;
	private float width=0;
	private float heigth=0;
	private float border=0;

	private String font="";
	private String campo;
	private String type;
	private String etiqueta;
	private String idtemplate;
	private String lineaplnatilla ;
	private String idtemplateclone;
	private String bloque;
	private String estructuraguia;
	
	private String descripcion ;
	private float  ancho ;
	private float  alto ;
	
	/*** 
	 * Si el valor es 1 indica que se solo se imprime una etiqueta
	 * con la leyenda ACUSE
	 * 
	 * Si el valor es 0 indica que se agregue una segunda etiqueta
	 * para que el usuario pudeda firmar
	 * ***/
	private int acuseSoloLeyenda = 1;

	/**
	 * 
	 */
	public ITextObjeto() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idregistro
	 */
	public int getIdregistro() {
		return idregistro;
	}
	
	

	/**
	 * @param idregistro the idregistro to set
	 */
	public void setIdregistro(int idregistro) {
		this.idregistro = idregistro;
	}
	
	public void setIdregistro(String idregistro) {
		try{
			this.idregistro = Integer.parseInt(idregistro);
		}catch(Exception e){
			
		}
		
	}

	/**
	 * @return the identidad
	 */
	public int getIdentidad() {
		return identidad;
	}

	/**
	 * @param identidad the identidad to set
	 */
	public void setIdentidad(int identidad) {
		this.identidad = identidad;
	}

	/**
	 * @return the idorganizacion
	 */
	public int getIdorganizacion() {
		return idorganizacion;
	}

	/**
	 * @param idorganizacion the idorganizacion to set
	 */
	public void setIdorganizacion(int idorganizacion) {
		this.idorganizacion = idorganizacion;
	}

	/**
	 * @return the rotation
	 */
	public int getRotation() {
		return rotation;
	}

	/**
	 * @param rotation the rotation to set
	 */
	public void setRotation(int rotation) {
		this.rotation = rotation;
	}
	
	public void setRotation(String rotation) {
		try{
			this.rotation = Integer.parseInt(rotation);
		}catch(Exception e){
			
		}
		
	}

	/**
	 * @return the fontsize
	 */
	public int getFontsize() {
		return fontsize;
	}
	
	public void setFontsize(String fontsize) {
		try{
			this.fontsize = Integer.parseInt(fontsize);
		}catch(Exception e){
			
		}
		
	}

	/**
	 * @param fontsize the fontsize to set
	 */
	public void setFontsize(int fontsize) {
		this.fontsize = fontsize;
	}

	/**
	 * @return the baseline
	 */
	public int getBaseline() {
		return baseline;
	}
	
	public void setBaseline(String baseline) {
		try{
			this.baseline = Integer.parseInt(baseline);
		}catch(Exception e){
			
		}
		
	}

	/**
	 * @param baseline the baseline to set
	 */
	public void setBaseline(int baseline) {
		this.baseline = baseline;
	}

	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}
	public void setX(String x) {
		try{
			this.x = Float.parseFloat(x);
		}catch(Exception e){
			
		}
		
	}

	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}

	public void setY(String y) {
		try{
			this.y = Float.parseFloat(y);
		}catch(Exception e){
			
		}
		
	}
	/**
	 * @return the width
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(float width) {
		this.width = width;
	}

	public void setWidth(String width) {
		try{
			this.width = Float.parseFloat(width);
		}catch(Exception e){
			
		}
		
	}
	
	/**
	 * @return the heigth
	 */
	public float getHeigth() {
		return heigth;
	}

	/**
	 * @param heigth the heigth to set
	 */
	public void setHeigth(float heigth) {
		this.heigth = heigth;
	}

	public void setHeigth(String heigth) {
		try{
			this.heigth = Float.parseFloat(heigth);
		}catch(Exception e){
			
		}
		
	}
	/**
	 * @return the border
	 */
	public float getBorder() {
		return border;
	}

	/**
	 * @param border the border to set
	 */
	public void setBorder(float border) {
		this.border = border;
	}

	public void setBorder(String border) {
		try{
			this.border = Float.parseFloat(border);
		}catch(Exception e){
			
		}
		
	}
	
	/**
	 * @return the font
	 */
	public String getFont() {
		return font;
	}

	/**
	 * @param font the font to set
	 */
	public void setFont(String font) {
		this.font = font;
	}

	/**
	 * @return the campo
	 */
	public String getCampo() {
		return campo;
	}

	/**
	 * @param campo the campo to set
	 */
	public void setCampo(String campo) {
		this.campo = campo;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the etiqueta
	 */
	public String getEtiqueta() {
		return etiqueta;
	}

	/**
	 * @param etiqueta the etiqueta to set
	 */
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	/**
	 * @return the idtemplate
	 */
	public String getIdtemplate() {
		return idtemplate;
	}

	/**
	 * @param idtemplate the idtemplate to set
	 */
	public void setIdtemplate(String idtemplate) {
		this.idtemplate = idtemplate;
	}

	/**
	 * @return the lineaplnatilla
	 */
	public String getLineaplnatilla() {
		return lineaplnatilla;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the ancho
	 */
	public float getAncho() {
		return ancho;
	}

	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(float ancho) {
		this.ancho = ancho;
	}
	
	public void setAncho(String ancho) {
		try{
			this.ancho = Float.parseFloat(ancho);
		}catch(Exception e){
			
		}
		
	}


	/**
	 * @return the alto
	 */
	public float getAlto() {
		return alto;
	}

	/**
	 * @param alto the alto to set
	 */
	public void setAlto(float alto) {
		this.alto = alto;
	}

	public void setAlto(String alto) {
		try{
			this.alto = Float.parseFloat(alto);
		}catch(Exception e){
			
		}
		
	}

	/**
	 * @param lineaplnatilla the lineaplnatilla to set
	 */
	public void setLineaplnatilla(String lineaplnatilla) {
		this.lineaplnatilla = lineaplnatilla;
	}

	/**
	 * @return the idtemplateclone
	 */
	public String getIdtemplateclone() {
		return idtemplateclone;
	}

	/**
	 * @param idtemplateclone the idtemplateclone to set
	 */
	public void setIdtemplateclone(String idtemplateclone) {
		this.idtemplateclone = idtemplateclone;
	}

	/**
	 * @return the bloque
	 */
	public String getBloque() {
		return bloque;
	}

	/**
	 * @param bloque the bloque to set
	 */
	public void setBloque(String bloque) {
		this.bloque = bloque;
	}

	/**
	 * @return the acuseSoloLeyenda
	 */
	public boolean esAcuseSoloLeyenda() {
		if (acuseSoloLeyenda==1){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * @param acuseSoloLeyenda the acuseSoloLeyenda to set
	 */
	public void setAcuseSoloLeyenda(int acuseSoloLeyenda) {
		this.acuseSoloLeyenda = acuseSoloLeyenda;
	}
	public int getAcuseSoloLeyenda() {
		return acuseSoloLeyenda;
	}

	public String getEstructuraguia() {
		estructuraguia =estructuraguia==null?"":estructuraguia;
		return estructuraguia.trim().toLowerCase();
	}

	public void setEstructuraguia(String estructuraguia) {
		this.estructuraguia = estructuraguia;
	}
}
