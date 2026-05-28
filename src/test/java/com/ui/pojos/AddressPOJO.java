package com.ui.pojos;

public class AddressPOJO {

	
	public AddressPOJO(String company, String addressLine1, String addressLine2, String city, String state,
			String postalCode, String homePhoneNumber, String mobilePhoneNunber, String additionalInformation,
			String addressAlias) {
		super();
		this.company = company;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.homePhoneNumber = homePhoneNumber;
		this.mobilePhoneNunber = mobilePhoneNunber;
		this.additionalInformation = additionalInformation;
		this.addressAlias = addressAlias;
	}
	public String getCompany() {
		return company;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}
	public String getMobilePhoneNunber() {
		return mobilePhoneNunber;
	}
	public String getAdditionalInformation() {
		return additionalInformation;
	}
	public String getAddressAlias() {
		return addressAlias;
	}
	
	
	private String company;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postalCode;
	private String homePhoneNumber;
	private String mobilePhoneNunber;
	private String additionalInformation;
	private String addressAlias;
	
	
	@Override
	public String toString() {
		return "AddressPOJO [company=" + company + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", city=" + city + ", state=" + state + ", postalCode=" + postalCode + ", homePhoneNumber="
				+ homePhoneNumber + ", mobilePhoneNunber=" + mobilePhoneNunber + ", additionalInformation="
				+ additionalInformation + ", addressAlias=" + addressAlias + "]";
	}
	
}
