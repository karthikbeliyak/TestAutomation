package com.hcl.magentopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private By myAccountLocator = By.linkText("My Account");
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickOnMyAccount()
	{
		WebElement myAccEle = driver.findElement(myAccountLocator);
		myAccEle.click();
		
	}


}
