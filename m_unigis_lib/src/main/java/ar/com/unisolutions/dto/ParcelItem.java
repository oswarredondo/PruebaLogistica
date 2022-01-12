package ar.com.unisolutions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParcelItem {
	@JsonProperty("key")
	private String id; //Identificador
	private String description; //Descripción de mercancia
	private String hsTariffNumber; //Número de tarifa
	private String originCountry; //País de origen
	private int quantity; //Cantidad
	private float value = 0; //Valor
	private float weight; //Peso
	private float volume; //Peso volumetrico
	private String typeMerchandise; //Tipo de mercancia
	private String typePacking; //Tipo de empaque
	private Boolean secure; //Asegurado
	private Boolean isMultiple; //Es  multiple
	private int length; //Longitud/Largo
	private int height; //Altura  
	private int width; //Ancho
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHsTariffNumber() {
		return hsTariffNumber;
	}
	public void setHsTariffNumber(String hsTariffNumber) {
		this.hsTariffNumber = hsTariffNumber;
	}
	public String getOriginCountry() {
		return originCountry;
	}
	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getVolume() {
		return volume;
	}
	public void setVolume(float volume) {
		this.volume = volume;
	}
	public String getTypeMerchandise() {
		return typeMerchandise;
	}
	public void setTypeMerchandise(String typeMerchandise) {
		this.typeMerchandise = typeMerchandise;
	}
	public String getTypePacking() {
		return typePacking;
	}
	public void setTypePacking(String typePacking) {
		this.typePacking = typePacking;
	}
	public Boolean getSecure() {
		return secure;
	}
	public void setSecure(Boolean secure) {
		this.secure = secure;
	}
	public Boolean getIsMultiple() {
		return isMultiple;
	}
	public void setIsMultiple(Boolean isMultiple) {
		this.isMultiple = isMultiple;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
}
