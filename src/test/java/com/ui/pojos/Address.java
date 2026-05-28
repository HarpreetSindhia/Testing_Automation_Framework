package com.ui.pojos;

public class Address {

	private String company;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String postalCode;
	private String homePhone;
	private String mobilePhone;
	private String additional_Information;
	private String address_Alias;
	
	public Address(String company, String address1, String address2, String city, String state, String postalCode,
			String homePhone, String mobilePhone, String additional_Information, String address_Alias) {
		super();
		this.company = company;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.additional_Information = additional_Information;
		this.address_Alias = address_Alias;
	}

	public String getCompany() {
		return company;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
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

	public String getHomePhone() {
		return homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getAdditional_Information() {
		return additional_Information;
	}

	public String getAddress_Alias() {
		return address_Alias;
	}

	@Override
	public String toString() {
		return "Address [company=" + company + ", address1=" + address1 + ", address2=" + address2 + ", city=" + city
				+ ", state=" + state + ", postalCode=" + postalCode + ", homePhone=" + homePhone + ", mobilePhone="
				+ mobilePhone + ", additional_Information=" + additional_Information + ", address_Alias="
				+ address_Alias + "]";
	}
	
	
	
	
}
