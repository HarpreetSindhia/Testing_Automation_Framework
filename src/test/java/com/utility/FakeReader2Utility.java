package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojos.AddressPojo2;

public class FakeReader2Utility {

	public static	AddressPojo2 getAddress()
	{
		Faker faker = new Faker(Locale.US);
		AddressPojo2 addressPojo2 = new AddressPojo2(faker.company().name(), faker.address().buildingNumber(),
				faker.address().streetAddress(), faker.address().city() , "10" , faker.numerify("#####"),
				faker.phoneNumber().cellPhone() , faker.phoneNumber().cellPhone(), "other" , "Office Address");
		
		return addressPojo2;
	}
}
