/* $Id:  $
 *
 * Nombre del Proyecto:  Captura de Confirmaciones
 * Nombre del Programa: EntregaForm.java
 * Responsable: Adrián Morales Ruaro
 * Descripcion:  controla los datos de la forma de confirmaciones
 *
 * $Log: $
 */
package mensajeria.forms;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;



/**
 * Contiene las propiedades de la forma de entregas
 * @author amorales
 * @version
 */
public class DepositoForm implements Serializable  {
    /***/
    
    /** Creates a new instance of Entrega */
    public DepositoForm() {
    }
    
    
    /**IdGuia*/
    private String IdEnvio;
    /**Ficha de Deposito*/
    private String fichaDeposito;
    /**Fecha del Deposito*/
    private String fechaDeposito;
    /**Precio guia*/
    private float precioGuia;
    /**Tipo de Pago Realizado*/
    private String tipoPago;
    /**Monto de la ficha de deposito*/
    private float monto;
    

    
    /**
     * Verifica si una cadena es null o vacia, devuelve true si la cadena es
     * vacia o nula, en caso contrario devuelve false.
     * @param cadena cadena que se va a verificar
     * @return true si la cadena es nula a vacia, false en caso contrario
     */
    public boolean isNULLVACIA(String cadena){
        //Verifica si la cadena es nula
        if (cadena==null){
            return true;
        }
        //Verifica si la cadena es vacia
        if (cadena.trim().length()<=0){
            return true;
        }
        
        //Retorna false si la cadena no es nula o su largo es mayor de cero
        return false;
    }
    
    /**
     * Getter for property IdEnvio.
     * @return Value of property IdEnvio.
     */
    public java.lang.String getIdEnvio() {
        return IdEnvio;
    }    
    
    /**
     * Setter for property IdEnvio.
     * @param IdEnvio New value of property IdEnvio.
     */
    public void setIdEnvio(java.lang.String IdEnvio) {
        this.IdEnvio = IdEnvio;
    }
    
    /**
     * Getter for property fichaDeposito.
     * @return Value of property fichaDeposito.
     */
    public java.lang.String getFichaDeposito() {
        return fichaDeposito;
    }
    
    /**
     * Setter for property fichaDeposito.
     * @param fichaDeposito New value of property fichaDeposito.
     */
    public void setFichaDeposito(java.lang.String fichaDeposito) {
        this.fichaDeposito = fichaDeposito;
    }
    
    /**
     * Getter for property fechaDeposito.
     * @return Value of property fechaDeposito.
     */
    public java.lang.String getFechaDeposito() {
        return fechaDeposito;
    }
    
    /**
     * Setter for property fechaDeposito.
     * @param fechaDeposito New value of property fechaDeposito.
     */
    public void setFechaDeposito(java.lang.String fechaDeposito) {
        this.fechaDeposito = fechaDeposito;
    }
    
    /**
     * Getter for property precioGuia.
     * @return Value of property precioGuia.
     */
    public float getPrecioGuia() {
        return precioGuia;
    }
    
    /**
     * Setter for property precioGuia.
     * @param precioGuia New value of property precioGuia.
     */
    public void setPrecioGuia(float precioGuia) {
        this.precioGuia = precioGuia;
    }
    
    /**
     * Getter for property tipoPago.
     * @return Value of property tipoPago.
     */
    public java.lang.String getTipoPago() {
        return tipoPago;
    }
    
    /**
     * Setter for property tipoPago.
     * @param tipoPago New value of property tipoPago.
     */
    public void setTipoPago(java.lang.String tipoPago) {
        this.tipoPago = tipoPago;
    }
    
    /**
     * Getter for property monto.
     * @return Value of property monto.
     */
    public float getMonto() {
        return monto;
    }
    
    /**
     * Setter for property monto.
     * @param monto New value of property monto.
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }
    
    /**
     * Convierte una valor strina a un flotante y retorna su valor
     * en caso de no poder convertirlo regresa 0
     * @param valor
     * @return
     */
    public float convierte(String valor){
         //Verifica si los datos del precio son correctos
        float precio_f=0;
         
        try{
            return Float.parseFloat(valor);
        }catch(NumberFormatException nfe){
            return 0;
        }
    }
    
    //fin de setListaEnvios
}//fin de Entrega
