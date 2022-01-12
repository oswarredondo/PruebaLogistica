package org.rest_tracusa_logistica.struct;

import java.util.ArrayList;

public class Guide {
	
	/* Id del LOG */
	private String idLOG;
	
	private String idGuide;
	private String idClient;
	private String login;
    private String idService;
    private String reference;
    private String trackingCode;
    private String observations;
    private String description;
    private String date;
    private String signature;
    private String typeMovement;
    private Address fromAddress;
    private Address toAddress;
    private ParcelItem parcel;
    private Delivery delivery;
    private ArrayList<Tracker> tracker;
    private String file;
    /*FECHA ESTIMADA DE ENTREGA*/
    private String maxEDD;
    
	public String getIdGuide() {
		return idGuide;
	}
	public void setIdGuide(String idGuide) {
		this.idGuide = idGuide;
	}
	public String getIdClient() {
		return idClient;
	}
	public void setIdClient(String idClient) {
		this.idClient = idClient;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getIdService() {
		return idService;
	}
	public void setIdService(String idService) {
		this.idService = idService;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getTrackingCode() {
		return trackingCode;
	}
	public void setTrackingCode(String trackingCode) {
		this.trackingCode = trackingCode;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getTypeMovement() {
		return typeMovement;
	}
	public void setTypeMovement(String typeMovement) {
		this.typeMovement = typeMovement;
	}
	public Address getToAddress() {
		return toAddress;
	}
	public void setToAddress(Address toAddress) {
		this.toAddress = toAddress;
	}
	public Address getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(Address fromAddress) {
		this.fromAddress = fromAddress;
	}
	public ParcelItem getParcel() {
		return parcel;
	}
	public void setParcel(ParcelItem parcel) {
		this.parcel = parcel;
	}
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	public ArrayList<Tracker> getTracker() {
		return tracker;
	}
	public void setTracker(ArrayList<Tracker> tracker) {
		this.tracker = tracker;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getMaxEDD() {
		return maxEDD;
	}
	public void setMaxEDD(String maxEDD) {
		this.maxEDD = maxEDD;
	}
	public String getIdLOG() {
		return idLOG;
	}
	public void setIdLOG(String idLOG) {
		this.idLOG = idLOG;
	}
}
