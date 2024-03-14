package com.linkedin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutFromApplication {

	@FindBy(xpath = "//button[text()='Logout']")
	private WebElement logout;
	
	public LogoutFromApplication(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void setLogout() {
		logout.click();
	}
}
