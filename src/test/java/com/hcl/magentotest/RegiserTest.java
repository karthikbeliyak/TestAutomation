package com.hcl.magentotest;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hcl.base.WebDriverWrapper;
import com.hcl.magentopages.HomePage;
import com.hcl.magentopages.LoginPage;
import com.hcl.magentopages.RegisterPage;
import com.hcl.utilities.ExcelUtils;

public class RegiserTest extends WebDriverWrapper{
	
	@DataProvider
	public String[][] RegistrationData() throws IOException
	{
		String[][] main = ExcelUtils.getSheetIntoArray("testdata/MagentoData.xlsx", "RegistrationData");
		return main;
	}
	
	@Test(dataProvider = "RegistrationData")
	public void RegistrationTest(String firstname, String lastname, String email_address, String companyType) 
	{
		HomePage home = new HomePage(driver);
		home.clickOnMyAccount();
		
		LoginPage login = new LoginPage(driver);
		login.clickOnRegister();
		
		RegisterPage register = new RegisterPage(driver);
		
		register.fillRegisterForm(firstname, lastname, email_address, companyType);
		
		
				
	}

}
