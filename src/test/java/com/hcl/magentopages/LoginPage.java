package com.hcl.magentopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private By emailLocator = By.id("email");
	private By passwordLocator = By.id("pass");	
	private By loginLocator = By.id("send2");
	private By ErrorLocator = By.xpath("//div[contains(text(),'Invalid')]");
	private By registerLocator = By.id("register");
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void sendEmailAddress(String username)
	{
		WebElement emailEle = driver.findElement(emailLocator);
		emailEle.sendKeys(username);
	}
	
	public void sendPassword(String password)
	{
		WebElement passEle = driver.findElement(passwordLocator);
		passEle.sendKeys(password);
	}
	
	public void clickOnLoginButton()
	{
		WebElement loginButtonEle = driver.findElement(loginLocator);
		loginButtonEle.click();
	}
	
	public String errorMessageDisplay()
	{
		WebElement errorEle =  driver.findElement(ErrorLocator);
		return errorEle.getText();
	}
	
	public void clickOnRegister()
	{
		driver.findElement(registerLocator).click();
	}
}
