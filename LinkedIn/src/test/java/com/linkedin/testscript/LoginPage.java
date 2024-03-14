package com.linkedin.testscript;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.linkedin.generic.BaseClass;
import com.linkedin.pom.Login;

@Listeners(com.linkedin.generic.ListenerImplementation.class)
public class LoginPage extends BaseClass{

	@Test
	//@Parameters("browser")
	public void verifyLoginPage() throws InterruptedException {
	Reporter.log("verifyLoginPage",true);
	
	Login l=new Login(driver);
	l.getLogout().click();
	l.getSignUp().click();
	l.getSignIn().click();
	Thread.sleep(5000);
	Actions a=new Actions(driver);
	WebElement target = l.getLogin();
	Thread.sleep(5000);
	a.moveToElement(target).build().perform();
	Thread.sleep(5000);
	l.getUserfield().sendKeys("abcd");
	Thread.sleep(2000);
	l.getPassfield().sendKeys("abc@123");
	Thread.sleep(2000);
	int height = l.getUserfield1().getRect().getHeight();
	int width = l.getUserfield1().getRect().getWidth();
	System.out.println(height);
	System.out.println(width);
	int passHeight = l.getPassfield1().getRect().getHeight();
	int passWidth = l.getPassfield1().getRect().getWidth();
	System.out.println(passHeight);
	System.out.println(passWidth);
	String text = l.getLogin1().getText();
	Reporter.log(text);
	
	}
	
}
