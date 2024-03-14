package com.linkedin.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.linkedin.pom.LoginToApplication;
import com.linkedin.pom.LogoutFromApplication;

@Test

public class BaseClass {

	public static WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void openBrowser(String browser) {
		Reporter.log("openBrowser",true);
		if(browser.equals("chrome")) {
		driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@BeforeMethod
	@Parameters("browser")
	public void login() throws IOException {
		Reporter.log("login",true);
		Filelib f=new Filelib();
		String url = f.getPropertyData("url");
		driver.get(url);
		LoginToApplication l = new LoginToApplication(driver);
		String un = f.getPropertyData("username");
		String pw = f.getPropertyData("password");
		l.setLogin(un, pw);
	}
	@AfterTest
	@Parameters("browser")
	public void closeBrowser() {
		Reporter.log("closeBrowser",true);
		driver.close();
		driver.quit();
	}
	@AfterMethod
	@Parameters("browser")
	public void logout() {
		Reporter.log("logout",true);
		LogoutFromApplication lg=new LogoutFromApplication(driver);
		lg.setLogout();
			
		}
	}
	

