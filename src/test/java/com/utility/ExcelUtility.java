package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojos.User;

public class ExcelUtility {

	public static Iterator<User> readExcel(String fileName) {
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		Cell expectedUserName;
		User userData = null;
		XSSFWorkbook xssfWorkbook = null;
		List<User> userList = new ArrayList<>();
		File xlsxFile = new File(System.getProperty("user.dir")+File.separator+"testData"+File.separator+fileName);
		
		try {
			xssfWorkbook = new XSSFWorkbook(xlsxFile);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		XSSFSheet xssfSheet = xssfWorkbook.getSheet("LoginTestData");
		Iterator<Row> rowIterator = xssfSheet.iterator();
		rowIterator.next();
		while (rowIterator.hasNext()) {
			row = rowIterator.next();
			emailAddressCell = row.getCell(0);
			passwordCell = row.getCell(1);
			expectedUserName = row.getCell(2);

			userData = new User(emailAddressCell.toString(), passwordCell.toString(), expectedUserName.toString());
			userList.add(userData);
		}
		

		try {
			xssfWorkbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList.iterator();
	}
}
