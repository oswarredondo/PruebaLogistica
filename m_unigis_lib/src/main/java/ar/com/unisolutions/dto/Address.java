package ar.com.unisolutions.dto;

import java.util.Map;

//import com.easypost.exception.EasyPostException;
//import com.easypost.net.EasyPostResource;

public class Address {
	public String id;
	private String mode;
	private String name;
	private String company;
	private String street1;
	private String street2;
	private String inNumber;
	private String outNumber;
	private String colony;
	private String zip;
	private String city;
	private String state;
	private String country;
	private String between;
	private String reference;
	private String phone;
	private String phone2;
	private String email;
	private String message;
	private String agreement;
	private String carrierFacility;
	private String federalTaxId;
	private Boolean residential;
	private Map<String,AddressVerification> verifications;
	/*NUEVOS CAMPOS WALMART 21/09/2020*/
//	private String extIntNumber;
//	private String neighborhood;
//	private String municipality;
	
  
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getInNumber() {
		return inNumber;
	}
	public void setInNumber(String inNumber) {
		this.inNumber = inNumber;
	}
	public String getOutNumber() {
		return outNumber;
	}
	public void setOutNumber(String outNumber) {
		this.outNumber = outNumber;
	}
	public String getColony() {
		return colony;
	}
	public void setColony(String colony) {
		this.colony = colony;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getBetween() {
		return between;
	}
	public void setBetween(String between) {
		this.between = between;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAgreement() {
		return agreement;
	}
	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}
	public String getCarrierFacility() {
		return carrierFacility;
	}
	public void setCarrierFacility(String carrierFacility) {
		this.carrierFacility = carrierFacility;
	}
	public String getFederalTaxId() {
		return federalTaxId;
	}
	public void setFederalTaxId(String federalTaxId) {
		this.federalTaxId = federalTaxId;
	}
	public Boolean getResidential() {
		return residential;
	}
	public void setResidential(Boolean residential) {
		this.residential = residential;
	}
	public Map<String, AddressVerification> getVerifications() {
		return verifications;
	}
	public void setVerifications(Map<String, AddressVerification> verifications) {
		this.verifications = verifications;
	}
//	public String getExtIntNumber() {
//		return extIntNumber;
//	}
//	public void setExtIntNumber(String extIntNumber) {
//		this.extIntNumber = extIntNumber;
//	}
//	public String getNeighborhood() {
//		return neighborhood;
//	}
//	public void setNeighborhood(String neighborhood) {
//		this.neighborhood = neighborhood;
//	}
//	public String getMunicipality() {
//		return municipality;
//	}
//	public void setMunicipality(String municipality) {
//		this.municipality = municipality;
//	}
}
