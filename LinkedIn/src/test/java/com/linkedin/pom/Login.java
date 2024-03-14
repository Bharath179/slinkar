package com.linkedin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	
	@FindBy(xpath = "//button[text()='Logout']")
	private WebElement logout;
	
	@FindBy(xpath = "//button[text()='Signup']")
	private WebElement signUp;
	
	
	@FindBy(xpath = "//button[text()='Signin']")
	private WebElement signin;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement login;
	
	@FindBy(name = "username")
	private WebElement userfield;
	
	@FindBy(name = "password")
	private WebElement passfield;
	
	@FindBy(name = "username")
	private WebElement userfield1;
	
	@FindBy(name = "password")
	private WebElement passfield1;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement login1;
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public WebElement getLogout() {
		return logout;
		}
	public WebElement getSignUp() {
		return signUp;
		}
	public WebElement getSignIn() {
		return signin;
		}
	public WebElement getLogin() {
		return login;
		}
	public WebElement getUserfield() {
		return userfield;
	}
	public WebElement getPassfield() {
		return passfield;
	}
	public WebElement getUserfield1() {
		return userfield1;
	}
	public WebElement getPassfield1() {
		return passfield1;
	}
	public WebElement getLogin1() {
		return login1;
	}

	
	
	
}
