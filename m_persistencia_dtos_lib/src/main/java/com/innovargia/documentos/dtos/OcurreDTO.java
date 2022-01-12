package com.innovargia.documentos.dtos;

import java.io.Serializable;

public class OcurreDTO  implements Serializable{

    
    String idoficina;
    String loginUsuarioEntrega;
    int tipoocurre=1;  //1=Normal, 2=FXC, 3=COD
    float cobro_a_realizar= 0;
    float cant_cobrada;
    int cantidad_envios_entregada;
    
    String iddocumento ;
    String fechaentrada ;
    String quienrecibe ;
    String fechaentrega ;
    String tipoidentificacion ;
    String numeroidentificacion ;
    String fechadevolucion ;
    String iddocumentodevolucion ;
    String observacion ;
    String remite ;
    String destino ;
    String tel_cel ;
    String dir_recibe ;
    String rutadevolucion;
    
    String fechaini ;
    String fechafin ;
    String ubicacion;
    String des_ubicacion;
    
    String manifentrega; // Manifiesto o identificador con el que se entrega al destino
    String manifdevolucion; //Manifiesto con el que se realiza la devolucion
    float monto; //Monto en caso de que se debe realizar algun cobro
    String ruta;  //Ruta que entrega a la aoficina
    String manifiesto_entrada_ruta; //Manifiesto con que entrega la ruta a la oficina
    String fechamanifiesto;
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public OcurreDTO() {
	// TODO Auto-generated constructor stub
    }

    /**
     * @return the idoficina
     */
    public String getIdoficina() {
        return idoficina;
    }

    /**
     * @param idoficina the idoficina to set
     */
    public void setIdoficina(String idoficina) {
        this.idoficina = idoficina;
    }

    /**
     * @return the iddocumento
     */
    public String getIddocumento() {
        return iddocumento;
    }

    /**
     * @param iddocumento the iddocumento to set
     */
    public void setIddocumento(String iddocumento) {
        this.iddocumento = iddocumento;
    }

    /**
     * @return the fechaentrada
     */
    public String getFechaentrada() {
        return fechaentrada;
    }

    /**
     * @param fechaentrada the fechaentrada to set
     */
    public void setFechaentrada(String fechaentrada) {
        this.fechaentrada = fechaentrada;
    }

    /**
     * @return the quienrecibe
     */
    public String getQuienrecibe() {
        return quienrecibe;
    }

    /**
     * @param quienrecibe the quienrecibe to set
     */
    public void setQuienrecibe(String quienrecibe) {
        this.quienrecibe = quienrecibe;
    }

    /**
     * @return the fechaentrega
     */
    public String getFechaentrega() {
        return fechaentrega;
    }

    /**
     * @param fechaentrega the fechaentrega to set
     */
    public void setFechaentrega(String fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    /**
     * @return the tipoidentificacion
     */
    public String getTipoidentificacion() {
        return tipoidentificacion;
    }

    /**
     * @param tipoidentificacion the tipoidentificacion to set
     */
    public void setTipoidentificacion(String tipoidentificacion) {
        this.tipoidentificacion = tipoidentificacion;
    }

    /**
     * @return the numeroidentificacion
     */
    public String getNumeroidentificacion() {
        return numeroidentificacion;
    }

    /**
     * @param numeroidentificacion the numeroidentificacion to set
     */
    public void setNumeroidentificacion(String numeroidentificacion) {
        this.numeroidentificacion = numeroidentificacion;
    }

    /**
     * @return the fechadevolucion
     */
    public String getFechadevolucion() {
        return fechadevolucion;
    }

    /**
     * @param fechadevolucion the fechadevolucion to set
     */
    public void setFechadevolucion(String fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }

    /**
     * @return the iddocumentodevolucion
     */
    public String getIddocumentodevolucion() {
        return iddocumentodevolucion;
    }

    /**
     * @param iddocumentodevolucion the iddocumentodevolucion to set
     */
    public void setIddocumentodevolucion(String iddocumentodevolucion) {
        this.iddocumentodevolucion = iddocumentodevolucion;
    }

    /**
     * @return the observacion
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * @param observacion the observacion to set
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    /**
     * @return the remite
     */
    public String getRemite() {
        return remite;
    }

    /**
     * @param remite the remite to set
     */
    public void setRemite(String remite) {
        this.remite = remite;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the fechaini
     */
    public String getFechaini() {
        return fechaini;
    }

    /**
     * @param fechaini the fechaini to set
     */
    public void setFechaini(String fechaini) {
        this.fechaini = fechaini;
    }

    /**
     * @return the fechafin
     */
    public String getFechafin() {
        return fechafin;
    }

    /**
     * @param fechafin the fechafin to set
     */
    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }

    /**
     * @return the rutadevolucion
     */
    public String getRutadevolucion() {
        return rutadevolucion;
    }

    /**
     * @param rutadevolucion the rutadevolucion to set
     */
    public void setRutadevolucion(String rutadevolucion) {
        this.rutadevolucion = rutadevolucion;
    }

    /**
     * @return the manifentrega
     */
    public String getManifentrega() {
        return manifentrega;
    }

    /**
     * @param manifentrega the manifentrega to set
     */
    public void setManifentrega(String manifentrega) {
        this.manifentrega = manifentrega;
    }

    /**
     * @return the manifdevolucion
     */
    public String getManifdevolucion() {
        return manifdevolucion;
    }

    /**
     * @param manifdevolucion the manifdevolucion to set
     */
    public void setManifdevolucion(String manifdevolucion) {
        this.manifdevolucion = manifdevolucion;
    }

    /**
     * @return the tel_cel
     */
    public String getTel_cel() {
        return tel_cel;
    }

    /**
     * @param tel_cel the tel_cel to set
     */
    public void setTel_cel(String tel_cel) {
        this.tel_cel = tel_cel;
    }

    /**
     * @return the dir_recibe
     */
    public String getDir_recibe() {
        return dir_recibe;
    }

    /**
     * @param dir_recibe the dir_recibe to set
     */
    public void setDir_recibe(String dir_recibe) {
        this.dir_recibe = dir_recibe;
    }

    /**
     * @return the monto
     */
    public float getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }

    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * @return the manifiesto_entrada_ruta
     */
    public String getManifiesto_entrada_ruta() {
        return manifiesto_entrada_ruta;
    }

    /**
     * @param manifiesto_entrada_ruta the manifiesto_entrada_ruta to set
     */
    public void setManifiesto_entrada_ruta(String manifiesto_entrada_ruta) {
        this.manifiesto_entrada_ruta = manifiesto_entrada_ruta;
    }

    /**
     * @return the loginUsuarioEntrega
     */
    public String getLoginUsuarioEntrega() {
        return loginUsuarioEntrega;
    }

    /**
     * @param loginUsuarioEntrega the loginUsuarioEntrega to set
     */
    public void setLoginUsuarioEntrega(String loginUsuarioEntrega) {
        this.loginUsuarioEntrega = loginUsuarioEntrega;
    }

    /**
     * @return the tipoocurre
     */
    public int getTipoocurre() {
        return tipoocurre;
    }

    /**
     * @param tipoocurre the tipoocurre to set
     */
    public void setTipoocurre(int tipoocurre) {
        this.tipoocurre = tipoocurre;
    }

    /**
     * @return the cobro_a_realizar
     */
    public float getCobro_a_realizar() {
        return cobro_a_realizar;
    }

    /**
     * @param cobro_a_realizar the cobro_a_realizar to set
     */
    public void setCobro_a_realizar(float cobro_a_realizar) {
        this.cobro_a_realizar = cobro_a_realizar;
    }

    /**
     * @return the cant_cobrada
     */
    public float getCant_cobrada() {
        return cant_cobrada;
    }

    /**
     * @param cant_cobrada the cant_cobrada to set
     */
    public void setCant_cobrada(float cant_cobrada) {
        this.cant_cobrada = cant_cobrada;
    }

    /**
     * @return the cantidad_envios_entregada
     */
    public int getCantidad_envios_entregada() {
        return cantidad_envios_entregada;
    }

    /**
     * @param cantidad_envios_entregada the cantidad_envios_entregada to set
     */
    public void setCantidad_envios_entregada(int cantidad_envios_entregada) {
        this.cantidad_envios_entregada = cantidad_envios_entregada;
    }

    /**
     * @return the fechamanifiesto
     */
    public String getFechamanifiesto() {
        return fechamanifiesto;
    }

    /**
     * @param fechamanifiesto the fechamanifiesto to set
     */
    public void setFechamanifiesto(String fechamanifiesto) {
        this.fechamanifiesto = fechamanifiesto;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the des_ubicacion
     */
    public String getDes_ubicacion() {
        return des_ubicacion;
    }

    /**
     * @param des_ubicacion the des_ubicacion to set
     */
    public void setDes_ubicacion(String des_ubicacion) {
        this.des_ubicacion = des_ubicacion;
    }

}
