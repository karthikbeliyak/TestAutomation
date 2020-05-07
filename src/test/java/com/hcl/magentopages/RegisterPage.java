package com.hcl.magentopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
	
	private By firstnameLocator = By.id("firstname");
	private By lastnameLocator = By.id("lastname");
	private By emailaddressLocator = By.id("email_address");
	private By companytypeLocator = By.id("company_type");
	
	private WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fillRegisterForm(String firstname, String lastname, String email_address, String companyType) 
	{
		driver.findElement(firstnameLocator).sendKeys(firstname);
		driver.findElement(lastnameLocator).sendKeys(lastname);
		driver.findElement(emailaddressLocator).sendKeys(email_address);
		
		Select selectCompany = new Select(driver.findElement(companytypeLocator));
		selectCompany.selectByVisibleText(companyType);		
	}
	

}
