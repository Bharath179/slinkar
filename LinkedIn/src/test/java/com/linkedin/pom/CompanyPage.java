package com.linkedin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompanyPage {

	@FindBy(linkText = "Company")
	private WebElement company;
	
	@FindBy(name = "search")
	private WebElement companytextfield;
	
	@FindBy(id="button")
	private WebElement searchBtn;
	
	@FindBy(id="tab")
	private WebElement text;
	
	@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible fade show' and 'Your message has been successfully fetched from Database     ']")
	private WebElement companyDBMessage;
	
	public CompanyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCompany() {
		return company;
	}
	public WebElement getCompanytextfield() {
		return companytextfield;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public WebElement getText() {
		return text;
	}
	public WebElement getDBMessage() {
		return companyDBMessage;
	}
}

