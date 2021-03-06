package com.hcl.magentopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	private By logoutLocator = By.partialLinkText("Out");
	
	private WebDriver driver;
	
	public MainPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void waitForPresenceOfLogout() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(logoutLocator));
		
		//logoutEle.click();
	}
	
	public String getCurentTitle() 
	{
		return driver.getTitle();
	}
	
	public void clickOnLogout()
	{
		WebElement logoutEle = driver.findElement(logoutLocator);
		logoutEle.click();			
		
	}
}
