package com.linkedin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	

	@FindBy(linkText = "Person")
	private WebElement person;
	
	@FindBy(xpath = "//input[@name='link']")
	private WebElement persontextfield;
	
	@FindBy(id="button")
	private WebElement searchBtn;
	
	@FindBy(id="tab")
	private WebElement text;
	
	@FindBy(xpath = "//span[text()='bharath']")
	private WebElement username;
	
	@FindBy(xpath = "//button[text()='Logout']")
	private WebElement logout;
	
	@FindBy(xpath = "//h2[text()='Welcome to SLINKR , a tool to gather linkedin information']")
	private WebElement slinkrtext;
	
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getPerson() {
		return person;
	}
	public WebElement getPersontextfield() {
		return persontextfield;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public WebElement getText() {
		return text;
	}
	public WebElement getUsername() {
		return username;
	}
	public WebElement getLogout() {
		return logout;
	}
	public WebElement getHomepagetext() {
		return slinkrtext;
	}
}
