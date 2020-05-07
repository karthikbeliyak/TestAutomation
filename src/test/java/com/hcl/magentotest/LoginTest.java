package com.hcl.magentotest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hcl.base.WebDriverWrapper;
import com.hcl.magentopages.HomePage;
import com.hcl.magentopages.LoginPage;
import com.hcl.magentopages.MainPage;
import com.hcl.utilities.ExcelUtils;

public class LoginTest extends WebDriverWrapper {
	
	@Test(priority = 1)
	public void validCredentialTest() {
		HomePage home = new HomePage(driver);
		home.clickOnMyAccount();

		LoginPage login = new LoginPage(driver);
		login.sendEmailAddress("balaji0017@gmail.com");
		login.sendPassword("welcome@123");
		login.clickOnLoginButton();

		MainPage logout = new MainPage(driver);
		// before getting the title, need to verify the login
		logout.waitForPresenceOfLogout();
		String expectedTitle = "My Account";
		String actualTitle = logout.getCurentTitle();
		System.out.println(actualTitle);
		// Assert decides the pass/fail in the verification
		Assert.assertEquals(actualTitle, expectedTitle);
		logout.clickOnLogout();

	}
	@DataProvider
	public String[][] invlaidCredentialData() throws IOException
	{
		String[][] main = ExcelUtils.getSheetIntoArray("testdata/MagentoData.xlsx", "InvalidCredentialData");
		return main;
	}
	
	@Test(priority = 2, dataProvider = "invlaidCredentialData")
	public void invlaidCredentialTest(String username, String password, String expectedValue) throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.clickOnMyAccount();

		LoginPage login = new LoginPage(driver);
		login.sendEmailAddress(username);
		login.sendPassword(password);
		login.clickOnLoginButton();

		// before getting the title, need to verify the login
		Thread.sleep(5000);
		String actualText = login.errorMessageDisplay();
		// System.out.println(actualText);
		Assert.assertTrue(actualText.contains(expectedValue), "Assertion on invlaidCredentialTest");

	}
}
