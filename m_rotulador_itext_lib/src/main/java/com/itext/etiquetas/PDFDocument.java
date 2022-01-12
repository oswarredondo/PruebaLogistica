/**
 * 
 */
package com.itext.etiquetas;


import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.Barcode128;
import com.lowagie.text.pdf.BarcodePDF417;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;

/**
 * @author dgil
 *
 */
public class PDFDocument {
	
	private String user = "";
	private String pass = "";
	
	/**
	 * Objeto que es en si el documento PDF
	 * */
	private Document documento;
	
	/**
	 * Objeto que toma el contenido del objeto documento y lo copia a otro flujo.
	 * */
	private PdfWriter escritor = null;
	
	
	/**
	 * Contiene la informacion binaria del documento pdf.
	 * */
	private ByteArrayOutputStream outStream;
	
	/**
	 * Archivo fisico sobre el cual se hace el volcado del stream binario.
	 * */
	private FileOutputStream archivo;
	
	/**
	 * Número actual de paginas en el documento PDF
	 * */
	private int numeroDePaginas;	
	
	private float dot = Coordenadas.dot;
	
	/**
	 * Manda un mensaje a la bitacora, como debug
	 */
	private void debug(String mensaje) {

	}// fin de debug
	
	/**
	 * Crea un documento tamaño oficio.
	 * */
	public PDFDocument()throws Exception{		
		try{
			documento = new Document(PageSize.LETTER);
			iniciaDocumento();
			}catch(Exception e){
				debug("DocumentoPDF(): "+e.getMessage());
				e.printStackTrace();
				throw new Exception(e.getMessage());
				}			
	}
	
	/**
	 * Crea un documento tamaño oficio.
	 * */
	public PDFDocument(Rectangle pageSize, boolean rotate )throws Exception{		
		try{

			if (rotate){
				documento = new Document(pageSize.rotate());	
			}else{
				documento = new Document(pageSize);
			}
			
			iniciaDocumento();
			}catch(Exception e){
				debug("DocumentoPDF(): "+e.getMessage());
				e.printStackTrace();
				throw new Exception(e.getMessage());
				}			
	}
	
	/**
	 * Crea un  documento con dimensiones especificadas por el rectangulo que recibe.
	 * @param r Rectangulo que inicializa las medidas del documento.
	 * */
	public PDFDocument(Rectangle r)throws Exception{				
		try{
			documento = new Document(r);
		  iniciaDocumento();
		}catch(Exception e){
			debug("DocumentoPDF(): "+e.getMessage());
		  e.printStackTrace();
		  throw new Exception(e.getMessage());
		}
	}
	
	public PDFDocument(boolean size)throws Exception{		
		try{
			if(size)
				documento = new Document(new Rectangle(280, 419),1,1,1,1);
			else
				documento = new Document(PageSize.LEGAL,1,1,1,1);
		 iniciaDocumento();
		}catch(Exception e){
			debug("DocumentoPDF(): "+e.getMessage());
		  e.printStackTrace();
		  throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * Indica el tipo de documento
	 * PageSize.LEGAL
	 * PageSize.LETTER
	 * PageSize.HALFLETTER
	 * etc
	 * 
	 * EWn esta se puede indicar el sentido 
	 * PageSize.HALFLETTER.rotate()
	 * 
	 * Los  margenes son puestos a 1
	 * @param size
	 * @throws Exception
	 */
	public PDFDocument(Rectangle pageSize,float marginLeft,
            float marginRight,
            float marginTop,
            float marginBottom)throws Exception{		
		try{
			documento = new Document(pageSize,marginLeft,marginRight,marginTop,marginBottom); 
			iniciaDocumento();
		}catch(Exception e){
			System.out.println("DocumentoPDF(): "+e.getMessage());
		  e.printStackTrace();
		  throw new Exception(e.getMessage());
		}
	}
	
	
	/**
	 * Crea un documento con las medidas especificadas por el rectangulo que recibe.
	 * @param r Rectangulo que inicializa las medidas del documento.
	 * @param rigthm Margen derecho (en puntos).
	 * @param leftm Margen izquierdo (en puntos).
	 * @param upperm Margen superior (en puntos).
	 * @param lowerm Margen inferior (en puntos).
	 * */
	public PDFDocument(Rectangle r, int rigthm, int leftm, int upperm, int lowerm)throws Exception{
		documento = new Document(r,rigthm,leftm,upperm,lowerm);
		try{
		 iniciaDocumento();
		}catch(Exception e){
			debug("DocumentoPDF(): "+e.getMessage());
		  e.printStackTrace();
		  throw new Exception(e.getMessage());
		}
	}

	/**
	 * Prepara los streams para trabajar con el objeto PDF.
	 * @return True, si se crearon y asociaron los flujos correctamente, falso en otro caso.
	 * */
	private  boolean iniciaDocumento()throws Exception{
		boolean bOk =  false;		
		try{			
			outStream = new ByteArrayOutputStream();			
			escritor = PdfWriter.getInstance(documento, outStream);			
			//escritor.setEncryption(user.getBytes(),pass.getBytes() ,PdfWriter.ALLOW_SCREENREADERS | PdfWriter.ALLOW_PRINTING, PdfWriter.STANDARD_ENCRYPTION_40);
			documento.open();
			bOk = true;
		}catch(DocumentException e){
			debug("DocumentoPDF.iniciaDocumento(): "+e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}		
		return bOk;
	}	
	
	
	/**
	 * Cierra el objeto de iText para volcar los datos al Stream asociado.
	 * @return True, si se cerro el objeto correctamente, falso en otro caso
	 * */
	public boolean cerrarDocumento()throws Exception{
		boolean bOk = false;
		try{
			if(documento != null && documento.isOpen())
			{
				documento.compress=true;				
				documento.close();				
			}
			bOk = true;
		}catch (Exception e) {
			debug("DocumentoPDF.cerrarDocumento(): "+e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return bOk;
	}
	
	/**
	 * Cierra el buffer de datos asociado al documento itext.
	 * @return True, si el buffer de datos se cerro correctamente, falso en otro caso.
	 * */
	private boolean cerrarBuffer()throws Exception{
		boolean bOk = false;
		try{
		if(outStream!=null)
		{			
			outStream.reset();
			outStream.close();
			outStream = null;
		}
		bOk = true;
		}catch (Exception e) {
			debug("DocumentoPDF.cerrarBuffer(): "+e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return bOk;
	}
	
	/**
	 * Cierra el archivo PDF generado.
	 * @return True, si el archivo se creo correctamente, falso en otro caso.
	 * */
	private boolean cerrarArchivo()throws Exception{
		boolean bOk = false;
		try{
			if(archivo != null)
				archivo.close();
			bOk = true;
		}catch (Exception e) {
			debug("DocumentoPDF.cerrarArchivo(): "+e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return bOk;
	}
	
	/**
	 * Crea un archivo en formato PDF.
	 * @return True, si se creo el archivo correctamente, falso en otro caso.
	 * @param nombre Nombre del archivo a crear.
	 * @param ext Extension del archivo a crear.
	 * */
	private boolean preparaArchivo(String nombre, String ext)throws Exception{
		boolean bOk = false;		
		try {
			if(!nombre.endsWith(ext))
				nombre+=ext;			
			archivo = new FileOutputStream(nombre);
			bOk = true;
		} catch (Exception e) {			
			debug("DocumentoPDF.preparaArchivo(): "+e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}		
		return bOk;
	}
	
	public int getNumeroDePaginas() {
		numeroDePaginas = documento.getPageNumber();
		return numeroDePaginas;
	}
	
	/**
	 * Toma la informacion del buffer asociado y la direcciona a un archivo.
	 * @param nombre Nombre absoluto o relativo del archivo donde se volcaran los datos
	 * @return True si se genero el archivo en formato PDF, falso en otro caso.
	 * */
	public boolean toPDF(String nombre)throws Exception{
		boolean bOk = false;
		try {
			preparaArchivo(nombre,".pdf");
			cerrarDocumento();						
			byte[] info= outStream.toByteArray();
			archivo.write(info);			
			archivo.close();
			bOk = true;
		} catch (Exception e) {			
			debug("DocumentoPDF.toPDF(): "+e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return bOk;
	}
	
	public byte[] toByteArray() throws Exception{
		try{
			return outStream.toByteArray();
		}catch (Exception e) {
			debug("DocumentoPDF.toByteArray(): "+e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}		
	}
	
	/**
	 * Cierra todos los flujos usados durante la creacion del documento PDF, llame a esta funcion siempre al final de la operacion.
	 * @param True si se cerraron todos los flujos correctamente, falso en otro caso.
	 * */
	public boolean cerrar()throws Exception{
		boolean bOk =  false;
	    try{	
		  bOk = cerrarDocumento();
		  bOk = bOk && cerrarBuffer();
		  bOk = bOk && cerrarArchivo();
	    }catch(Exception e){
	    	debug("DocumentoPDF.cerrar(): "+e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
	    }
		return bOk;
	}
	
	/**
	 * Escribe texto en el objeto itext.
	 * @param text Texto a escribir en el documento.
	 * @return True si escribio correctamente en el documento, falso en otro caso.
	 * */
	public boolean escribe(PdfTemplate template, String text, int size, float x,float y, int rotate)throws Exception{
	  	  boolean bOk =  false;
	  	  if(text == null || (text!=null && text.trim().length()==0))
	  	  	return true;
		  try{
		    BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
	        template.beginText();
	        template.setFontAndSize(bf, size);
	        template.showTextAligned(PdfContentByte.ALIGN_LEFT, text, x*(dot), y*(dot), rotate);
	        template.endText();	        
	        bOk=true;
		  }catch(Exception e){
		  	e.printStackTrace();
		  	throw new Exception(e.getMessage());
		  }
		  return bOk;
	  }
	
	/**
	 * Escribe texto en el objeto itext. indicando el font deseado
	 *  Utilice BaseFont para las siguientes fuentes:
	 * 
	 * COURIER
	 * COURIER_BOLD
	 * COURIER_OBLIQUE
	 * COURIER_BOLDOBLIQUE
	 * HELVETICA
	 * HELVETICA_BOLD
	 * HELVETICA_OBLIQUE
	 * HELVETICA_BOLDOBLIQUE
	 * SYMBOL
	 * TIMES_ROMAN
	 * TIMES_BOLD
	 * TIMES_ITALIC
	 * TIMES_BOLDITALIC
	 * @param text Texto a escribir en el documento.
	 * @return True si escribio correctamente en el documento, falso en otro caso.
	 * */
	public boolean escribe(PdfTemplate template, String text, int size, float x,float y, int rotate,String font)throws Exception{
	  	  boolean bOk =  false;
	  	  if(text == null || (text!=null && text.trim().length()==0))
	  	  	return true;
		  try{
		    BaseFont bf = BaseFont.createFont(font, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
	        template.beginText();
	        template.setFontAndSize(bf, size);
	        template.showTextAligned(PdfContentByte.ALIGN_LEFT, text, x*(dot), y*(dot), rotate);
	        template.endText();	        
	        bOk=true;
		  }catch(Exception e){
		  	e.printStackTrace();
		  	throw new Exception(e.getMessage());
		  }
		  return bOk;
	  }
	
	/**
	 * Escribe texto en el objeto itext.
	 * @param text Texto a escribir en el documento.
	 * @return True si escribio correctamente en el documento, falso en otro caso.
	 * */
	public boolean escribe(PdfTemplate template, String text, int size, float x,float y, int rotate, boolean bold)throws Exception{
	  	  boolean bOk =  false;
	  	if(text == null || (text!=null && text.trim().length()==0))
	  	  	return true;
		  try{			 
			  if(bold){				  
			    BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
		        template.beginText();
		        template.setFontAndSize(bf, size);
		        template.showTextAligned(PdfContentByte.ALIGN_LEFT, text, x*(dot), y*(dot), rotate);
		        template.endText();	        
		        bOk=true;
			  }
			  else
				  escribe(template,text, size, x, y, rotate);
		  }catch(Exception e){
		  	e.printStackTrace();
		  	throw new Exception(e.getMessage());
		  }
		  return bOk;
	  }
	
	/**
	 * Dibuja un rectangulo en el template especificado.
	 * @param template Template donde se creara el rectangulo.
	 * @param xLower coordenada x de la ezquina inferior izquierda (en centimetros).
	 * @param yLower coordenada y de la ezquina inferior izquierda (en centimetros).
	 * @param w ancho del rectangulo (en centimetros).
	 * @param h altura del rectangulo (en centimetros).
	 * */
	public boolean dibujaRectangulo(PdfTemplate template, float xLower, float yLower, float w, float h, float border) throws Exception{
		boolean bOk = false;
		try{			
			template.setLineWidth(border);
			template.rectangle(xLower*dot, yLower*dot, w*dot, h*dot);
			template.stroke();			
			bOk = true;
		}catch (Exception e) {
			debug("DocumentoPDF.dibujaRectangulo(): "+e.getMessage());
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return bOk;
	}

	public PdfWriter getEscritor() {
		return escritor;
	}
	
	public boolean agregaPagina(){
		boolean bOk = false;
		bOk = documento.newPage();
		return bOk;
	}
	
	/**
	  * Genera un Codigo de Barras PDF417.
	  * @param img es la imagen que retornará el CB PDF417.
	  * @param x coordenada x de la ezquina inferior izquierda (en centimetros).
	  * @param y coordenada y de la ezquina inferior izquierda (en centimetros).
	  * @param w ancho del rectangulo (en centimetros).
	  * @param h altura del rectangulo (en centimetros).
	  * */
	    public Image generaPDF417(String valorPDF, float x, float y, float w, float h, int rotacion)throws Exception{
	     Image img=null;
	     try {
	     	 BarcodePDF417 pdf417 = new BarcodePDF417();
	            pdf417.setText(valorPDF);
	            img = pdf417.getImage();
	            img.scalePercent(50, 50 * pdf417.getYHeight());
	            img.setAbsolutePosition(x*dot,y*dot);  //itext
	            img.setRotationDegrees(rotacion);
	     }
	        catch (Exception e) {
	            e.printStackTrace();
	        }    
	        
	     return img;
	    }
	    
	    /**
	     * Genera un Codigo de Barras 128.
	     * @param img es la imagen que retornará el CB 128.
	     * @param x coordenada x de la ezquina inferior izquierda (en centimetros).
	     * @param y coordenada y de la ezquina inferior izquierda (en centimetros).
	     * @param w ancho del rectangulo (en centimetros).
	     * @param h altura del rectangulo (en centimetros).
	     * @param baseline indica la ubicacion de la descripcion del codigo de barras
	     * Sets the text baseline. If positive, the text distance under the bars. If zero or negative, the text distance above the bars.
	     * */
	       public Image generaCode128(String valor128, PdfContentByte cb, float x, float y, float w, float h,int rotacion,int baseline)throws Exception{
	        Image img=null;
	           try {
	               Barcode128 code128 = new Barcode128();
	               if (baseline >0){
	        	   code128.setAltText(valor128);  
	               }else{
	        	   code128.setAltText("");  
	               }
	              
	               code128.setCode(valor128);
	               if (baseline<=0){
	            	   code128.setBaseline(baseline);
	               }
	               
	               img = code128.createImageWithBarcode(cb, null, null);
	               img.scaleAbsolute(w*dot,h*dot);
	               img.setRotationDegrees(rotacion);
	               img.setAbsolutePosition(x*dot,y*dot);
	            }
	            catch (Exception e) {
	                 e.printStackTrace();
	                 throw new Exception(e);
	            } 
	            return img;
	         }
	    
	    /**
	     * Convierte cualquier imagen en un arreglo de bytes.
	     * @param f archivo a convertir.
	     * */
	       public byte[] getImageBytes(File f) {
	           int BUFFER_SIZE = 1024;
	           byte[] result = null;
	    
	           try {
	             InputStream is= new FileInputStream(f);
	             BufferedInputStream origin = null;
	             ByteArrayOutputStream dest = new ByteArrayOutputStream();
	    
	             byte[] data = new byte[BUFFER_SIZE];
	             origin = new BufferedInputStream(is, BUFFER_SIZE);
	             int count;
	             while ((count = origin.read(data, 0, BUFFER_SIZE)) != -1) {
	               dest.write(data, 0, count);
	             }
	             origin.close();
	             dest.close();
	             result = dest.toByteArray();
	           }
	           catch (Exception e) {
	             e.printStackTrace();
	           }
	    
	           return result;
	         }


}
