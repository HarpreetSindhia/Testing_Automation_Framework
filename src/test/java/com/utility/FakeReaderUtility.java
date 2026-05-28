package com.utility;

import com.github.javafaker.Faker;
import com.ui.pojos.Address;

public class FakeReaderUtility {

	public static Address getAddress()
	{
		Faker faker = new Faker();
		
		Address addressPojo = new Address(faker.company().name(), faker.address().buildingNumber(),
				faker.address().streetAddress() , faker.address().city() , "9", faker.numerify("#####"),
				faker.phoneNumber().cellPhone() , faker.phoneNumber().cellPhone(), "other", "Office Address");
		
		return addressPojo;
	}
	
}
