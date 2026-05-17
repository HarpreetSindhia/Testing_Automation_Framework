package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojos.TestData;
import com.ui.pojos.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelUtility;

public class LoginDataProvider {

	@DataProvider(name = "LoginTestDataProvider")
	public static Iterator<Object[]> loginDataProvider()
	{
		Gson gson = new Gson();
		File jsonFile = new File(System.getProperty("user.dir")+File.separator+"testData"+File.separator+"LoginData.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TestData data =	gson.fromJson(fileReader, TestData.class);
		
		List<Object[]> dataToReturn = new ArrayList<>();
		
		for(User user : data.getData())
		{
			dataToReturn.add(new Object[] {user});
		}
		
		return dataToReturn.iterator();
		
		
		
	}
	
	@DataProvider(name = "LoginCSVTestDataProvider")
	public static Iterator<User> loginCSVDataProvider()
	{
		return CSVReaderUtility.readCSVFile("LoginData.csv");
	}
	
	@DataProvider(name = "LoginExcelDataProvider")
	public static Iterator<User> loginExcelDataProvider()
	{
		return ExcelUtility.readExcel("LoginData.xlsx");
	}
}
