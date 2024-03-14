package com.linkedin.testscript;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.linkedin.generic.BaseClass;
import com.linkedin.generic.Filelib;
import com.linkedin.pom.Homepage;

@Listeners(com.linkedin.generic.ListenerImplementation.class)
public class Person extends BaseClass{

	@Test
	@Parameters("browser")
	public void verifyPerson() throws InterruptedException, IOException {
		Homepage h=new Homepage(driver);
		Filelib f=new Filelib();
		
		Thread.sleep(2000);
		h.getPerson().click();
		Thread.sleep(2000);
		String personurl = f.getExcelData("company", 1, 1);
		h.getPersontextfield().sendKeys(personurl);
		Thread.sleep(2000);
		h.getSearchBtn().click();
		Thread.sleep(2000);
		String text = h.getText().getText();
		Reporter.log(text);
		String name = h.getUsername().getText();
		Reporter.log("Username of user is:"+name);
		
		String timestamp = LocalDateTime.now().toString().replace(':', '-');
		File src = h.getLogout().getScreenshotAs(OutputType.FILE);
		File path = src.getAbsoluteFile();
        System.out.println(path);		
		File dest=new File("./sreenshots/"+timestamp+".png");
		FileUtils.copyFile(src, dest);
		
		String tag = h.getLogout().getTagName();
		Reporter.log("Tag name is:"+tag);
		
		String slinkr = h.getHomepagetext().getText();
		Reporter.log("Text present on HomePage is:"+slinkr);
		
		
	}
}
