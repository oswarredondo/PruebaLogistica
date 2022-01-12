package com.innovargia.documentos.dtos;

//Imports
import java.io.Serializable;

import com.innovargia.salesmanager.dtos.RemDes;

/**
 *<CODE>
 * Datos de un cliente o un remitente
 *</CODE>
 *
 * @author Adrian Morales Ruaro
 * @version $Id: $
 */
public class RemDesEnvio implements Serializable {
    
    public RemDes remitente = new RemDes();
    public RemDes destino = new RemDes();
    
   /*Objeto que de tipo generico, es utilizado inicialmente para guardar los datos
     de los productos para un embarque*/
    Objeto objeto = new Objeto();
    
    /**Contiene los datos de un envio*/
    Envio envio = new Envio();
    
    /**
     * Constructor por default
     */
    public RemDesEnvio() {  }
    
    public RemDesEnvio(RemDes rem,RemDes dest,Envio  env) {
        this.remitente = rem;
        this.destino = dest;
        this.envio = env;
    }
    /**
     * Manda un mensaje a la bitacora, como debug
     */
    private void debug(String mensaje){
       
    }//fin de debug
    
    /**
     * Configura los datos de un Producto importado para un embarque
     *
     * @param nombre del campo a actualizar
     */
    public void setValorCampoProducto(String campo,String valor){
        if (campo==null){
            return;
        }
        campo = campo.toUpperCase();
        
        if (valor==null){
            valor = "";
        }
        
        //debug("Campo:" + campo);
        //debug("Valor:" + valor);
        
        valor = valor.toUpperCase();
        
        if (campo.trim().equals("IDPRODUCTO") ){
            this.objeto.setStr_Id(valor);
            
        }else if (campo.trim().equals("CANTIDAD") ){
            try{
                Float miValor = new Float(valor);
                this.objeto.setCantidad(Math.abs(miValor.intValue()));
                this.objeto.setInt_Id(Math.abs(miValor.intValue()));
            }catch(Exception e){
                this.objeto.setCantidad(0);
                this.objeto.setInt_Id(0);
            }
        }else if (campo.trim().equals("DESCRIPCION") ){
             this.objeto.setDescripcion(valor);
        }
        
        
    }//fin de setValorCampo
   
    /**
     * Configura los datos del cliente dependiendo de los datos que el
     * usuario desea configurar
     *
     * @param nombre del campo a actualizar
     */
    public void setValorCampo(String campo,String valor){
        if (campo==null){
            return;
        }
        
        
        campo = campo.toUpperCase();
        
        if (valor==null){
            valor = "";
        }
        
      // debug("setValorCampo.Campo:" + campo);
      // debug("setValorCampo.Valor:" + valor);
        
        valor = valor.toUpperCase();
        
        
        if ((campo.trim().equals("FAX_DE")) || ((campo.trim().equals("FAX")))){
            this.remitente.setFax(valor);
            this.destino.setFax(valor);
            
        }else if (campo.trim().equals("EMPRESA_ATENCION") ){
            this.remitente.setEmpresa_remite_carta(valor);
            this.destino.setEmpresa_remite_carta(valor);
            
        }else if (campo.trim().equals("REFDOMICILIO") ){

            this.destino.setRefdomicilio(valor);
           // debug("getRefdomicilio:" +this.destino.getRefdomicilio());
            
        }else if (campo.trim().equals("OFICINA") ){
            //int peso;
            try{
                Float miValor = new Float(valor);
                this.remitente.setOficina(miValor.intValue()+"");
                this.destino.setOficina(miValor.intValue()+"");
            }catch(Exception e){
                this.remitente.setOficina(valor);
                this.destino.setOficina(valor);
            }
            
        }else if (campo.trim().equals("EMPRESA_ATENCION") ){
            this.remitente.setEmpresa_remite_carta(valor);
            this.destino.setEmpresa_remite_carta(valor);
            
        }else if (campo.trim().equals("EMPRESA_RECOL") ){
            this.remitente.setEmpresa_recolecta(valor);
            this.destino.setEmpresa_recolecta(valor);
            
        }        else if (campo.trim().equals("EMPRESA_RECOL") ){
            this.remitente.setEmpresa_recolecta(valor);
            this.destino.setEmpresa_recolecta(valor);
            
        }else  if (campo.trim().equals("VOBO") ){
            this.remitente.setVobo_carta(valor);
            this.destino.setVobo_carta(valor);
            
        }else if (campo.trim().equals("REPRESENTA") ){
            this.remitente.setRepresentate_empresa_recolecta(valor);
            this.destino.setRepresentate_empresa_recolecta(valor);
            
        }else if (campo.trim().equals("FOLIO") ){
            this.remitente.setFolio(valor);
            this.destino.setFolio(valor);
        }else  if (campo.trim().equals("NUMCLIREM") || (campo.trim().equals("EMPRESA_REM") )){
            this.remitente.setNumCliente(valor);
        }else if (campo.trim().equals("NUM_CLIDES") || (campo.trim().equals("EMPRESA_DES") )){
            this.destino.setNumCliente(valor);
        }else if (campo.trim().equals("EMPRESA_RE") || (campo.trim().equals("EMPRESA") )){
            this.remitente.setRazonSocial(valor);
        }else if (campo.trim().equals("ATENCION_RE") || (campo.trim().equals("ATENCION"))){
            this.remitente.setAtencion(valor);
        }else if (campo.trim().equals("DIRECCION_RE") || (campo.trim().equals("DIRECCION") )){
            this.remitente.setDireccion(valor);
        }else if (campo.trim().equals("COLONIA_RE") || (campo.trim().equals("COLONIA"))){
            this.remitente.setColonia(valor);
        }else if (campo.trim().equals("ESTADO_RE") ||  (campo.trim().equals("ESTADO"))){
            this.remitente.setEstado(valor);
        }else if (campo.trim().equals("CP_RE") || (campo.trim().equals("CP"))){
            this.remitente.setCp(valor);
        }else if (campo.trim().equals("MUNICIPIO_RE") || (campo.trim().equals("MUNICIPIO"))){
            this.remitente.setMunicipio(valor);
        }else if (campo.trim().equals("TELEFONO_RE") || (campo.trim().equals("TELEFONO"))){
            this.remitente.setTelefono(valor);
        }else if (campo.trim().equals("CIUDAD_RE") || (campo.trim().equals("CIUDAD"))){
            this.remitente.setCiudad(valor);
        }else if (campo.trim().equals("CORREO_RE")){
            this.remitente.setCorreoe(valor);      
        }else if (campo.trim().equals("EMPRESA_DE")){
            this.destino.setRazonSocial(valor);
        }else if (campo.trim().equals("ATENCION_DE")){
            this.destino.setAtencion(valor);
        }else if (campo.trim().equals("DIRECCION_DE")){
            this.destino.setDireccion(valor);
        }else if (campo.trim().equals("COLONIA_DE")){
            this.destino.setColonia(valor);
        }else if (campo.trim().equals("ESTADO_DE")){
            this.destino.setEstado(valor);
        }else if (campo.trim().equals("MUNICIPIO_DE")){
            this.destino.setMunicipio(valor);
        }else if (campo.trim().equals("CP_DE")){
            this.destino.setCp(valor);
        }else if (campo.trim().equals("CIUDAD_DE")){
            this.destino.setCiudad(valor);
        }else if (campo.trim().equals("TELEFONO_DE")){
            this.destino.setTelefono(valor);
        }else if (campo.trim().equals("CORREO_DE")){
            this.destino.setCorreoe(valor);    
        }else if (campo.trim().equals("CONTENIDO")){
            this.envio.setContenido(valor);
        }else if (campo.trim().equals("CON_RETORNO")){
            this.envio.setConRetorno(valor);    
        }else if (campo.trim().equals("PESO")){
           // int peso;
            try{
                Float miValor = new Float(valor);
                this.envio.setPeso(miValor.intValue());
            }catch(Exception e){
                this.envio.setPeso(0);
            }
        }else if (campo.trim().equals("MONTO") || campo.trim().equals("VALOR_DECLARADO") ){
            // int peso;
             try{
                 Float miValor = new Float(valor);
                 this.envio.setMonto(miValor.intValue());
             }catch(Exception e){
                 this.envio.setMonto(0);
             }    
        }else if (campo.trim().equals("SEGURO")){
            //float seguro;
            try{
                Float miValor = new Float(valor);
                this.envio.setCantAsegurada(miValor.floatValue());
            }catch(Exception e){
               // System.out.println("Error Seguro:" + this.envio.getCantAsegurada());
                this.envio.setCantAsegurada(0);
            }
            
        }else if (campo.trim().equals("OBSERVA1")){
            this.envio.setComentario(valor);
        }else if (campo.trim().equals("COMENTARIO")){
            this.envio.setComentario(valor);
        }else if (campo.trim().equals("OBSERVACION")){
            this.envio.setComentario(valor);    
        }else if (campo.trim().equals("REFERENCIA")){
            this.envio.setReferencia(valor);
        }else if (campo.trim().equals("MULTIPLES")){
            this.envio.setMultiples(valor);
        }else if (campo.trim().equals("TIPO_ENVIO")){
            //Verifica el tipo de envio que se desea realizar
            if (valor==null){
                this.envio.setTipo_Envio( this.envio.TIPO_ENVIO_NOR);
            }else if (valor.trim().equals("COD")){
                this.envio.setTipo_Envio( this.envio.TIPO_ENVIO_COD);
            }else if (valor.trim().equals("TC")){
                this.envio.setTipo_Envio( this.envio.TIPO_ENVIO_TC);
            }else if (valor.trim().equals("EFE")){
                this.envio.setTipo_Envio( this.envio.TIPO_ENVIO_EFE);
            }else{
                this.envio.setTipo_Envio( this.envio.TIPO_ENVIO_NOR);
            }
            
        }else if (campo.trim().equals("CANTIDAD")){
            
            try{
                Float miValor = new Float(valor);
                this.envio.setCantidad(miValor.intValue());
            }catch(Exception e){
                this.envio.setCantidad(1);
            }
        } else if (campo.trim().equals("MONTO")){
            //System.out.println("Monto:"+valor);
            try{
                //Float miValor = new Float(valor);
                this.envio.setMonto(Float.parseFloat(valor));
                this.envio.setS_monto(valor);
                //System.out.println("this.envio.getMonto:"+this.envio.getMonto());
            }catch(Exception e){ 
                //System.out.println("this.envio.getMonto:0.0");
                this.envio.setMonto(0);
                this.envio.setS_monto("0");
            }
        }else if (campo.trim().equals("MONTOMENSUALIDAD")){
            //debug("MONTOMENSUALIDAD:" + valor);
            this.envio.pagare.setMontoMensualidad(valor);
        }else if (campo.trim().equals("DIVISION")){
            //debug("DIVISION:" + valor);
            this.envio.pagare.setDivision(valor);
        }else if (campo.trim().equals("MODELO")){
            //debug("MODELO:" + valor);
            this.envio.pagare.setModelo(valor);
        }else if (campo.trim().equals("ORIGEN")){
            //debug("ORIGEN:" + valor);
            this.envio.pagare.setOrigen(valor);
        }else if (campo.trim().equals("AREA")){
            //debug("AREA:" + valor);
            this.envio.pagare.setArea(valor);
        }else if (campo.trim().equals("SKU")){
            //debug("SKU:" + valor);
            this.envio.pagare.setSku(valor);
        }else if (campo.trim().equals("NPLAN")){
            //debug("NPLAN:" + valor);
            this.envio.pagare.setNPlan(valor);
        }else if (campo.trim().equals("NUMERODESERIE")){
            //debug("NUMERODESERIE:" + valor);
            this.envio.pagare.setNumeroSerie(valor);
        }else if (campo.trim().equals("CREAPAGARE")){
            //debug("CREAPAGARE:" + valor);
            if (valor.trim().equals("S") || valor.trim().equals("SI") ||
                    valor.trim().equals("OK") || valor.trim().equals("Y") ||
                    valor.trim().equals("YES")){
                this.envio.setCrea_Pagare(true);
            }else{
                this.envio.setCrea_Pagare(false);
            }
            
            //debug("Crea_Pagare:" +  this.envio.isCrea_Pagare());
        }else if (campo.trim().equals("FOLIOPAQUETE")){
            //debug("FOLIOPAQUETE:" + valor);
            this.envio.pagare.setFolioPaquete(valor);
        }else if (campo.trim().equals("ORDENSERVICIO")){
            this.envio.pagare.setOrdenServicio(valor);
        }else if (campo.trim().equals("MESPAGARE")){
            this.envio.pagare.setMesPagare(valor);
        }else if (campo.trim().equals("RFC_PAGA")){
            this.envio.pagare.setRfc(valor);
        }else if (campo.trim().equals("ATENCION_PAGA")){
            this.envio.pagare.setAtencion(valor);
        }else if (campo.trim().equals("DIRECCION_PAGA")){
            this.envio.pagare.setDireccion(valor);
        }else if (campo.trim().equals("COLONIA_PAGA")){
            this.envio.pagare.setColonia(valor);
        }else if (campo.trim().equals("MUNICIPIO_PAGA")){
            this.envio.pagare.setMunicipio(valor);
        }else if (campo.trim().equals("ESTADO_PAGA")){
            this.envio.pagare.setEstado(valor);
        }else if (campo.trim().equals("CP_PAGA")){
            this.envio.pagare.setCp(valor);
        }
        //fin del if principal
        
    }//fin de setValorCampo
    
    /**
     * Getter for property remitente.
     * @return Value of property remitente.
     */
    public RemDes getRemitente() {
        return remitente;
    }
    
    /**
     * Setter for property remitente.
     * @param remitente New value of property remitente.
     */
    public void setRemitente(RemDes remitente) {
        this.remitente = remitente;
    }
    
    /**
     * Getter for property destino.
     * @return Value of property destino.
     */
    public RemDes getDestino() {
        return destino;
    }
    
    /**
     * Setter for property destino.
     * @param destino New value of property destino.
     */
    public void setDestino(RemDes destino) {
        this.destino = destino;
    }
    
    /**
     * Getter for property envio.
     * @return Value of property envio.
     */
    public Envio getEnvio() {
        this.envio.remitente = this.remitente;
        this.envio.destinatario = this.destino;
        //debug("getEnvio->Pagare:" + this.envio.isCrea_Pagare());
        return this.envio;
    }
    
    
    
    /**
     * Getter for property contenido.
     * @return Value of property contenido.
     */
    public java.lang.String getContenido() {
        return this.envio.getContenido();
    }
    
    /**
     * Setter for property contenido.
     * @param contenido New value of property contenido.
     */
    public void setContenido(java.lang.String contenido) {
        this.envio.setContenido(contenido);
    }
    
    /**
     * Getter for property peso.
     * @return Value of property peso.
     */
    public int getPeso() {
        return  this.envio.getPeso();
    }
    
    /**
     * Setter for property peso.
     * @param peso New value of property peso.
     */
    public void setPeso(int peso) {
        this.envio.setPeso(peso);
    }
    
    /**
     * Getter for property cantidad.
     * @return Value of property cantidad.
     */
    public int getCantidad() {
        return  this.envio.getCantidad();
    }
    
    /**
     * Setter for property cantidad.
     * @param cantidad New value of property cantidad.
     */
    public void setCantidad(int cantidad) {
        this.envio.setCantidad(cantidad);
    }
    
    /**
     * Getter for property observa1.
     * @return Value of property observa1.
     */
    public java.lang.String getObserva1() {
        return  this.envio.getObserva1();
    }
    
    /**
     * Setter for property observa1.
     * @param observa1 New value of property observa1.
     */
    public void setObserva1(java.lang.String observa1) {
        this.envio.setObserva1(observa1);
    }
    
    /**
     * Getter for property observa2.
     * @return Value of property observa2.
     */
    public java.lang.String getObserva2() {
        return this.envio.getObserva2();
    }
    
    /**
     * Setter for property observa2.
     * @param observa2 New value of property observa2.
     */
    public void setObserva2(java.lang.String observa2) {
        this.envio.setObserva2(observa2);
    }
    
    private String setNULL(String s){
        if (s==null){ return ""; }
        
        return s.trim();
    }
    //fin de setValorCampo

	/**
	 * @return the objeto
	 */
	public Objeto getObjeto() {
		return objeto;
	}

	/**
	 * @param objeto the objeto to set
	 */
	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}
}  //fin RemDesEnvio
