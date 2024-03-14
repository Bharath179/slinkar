package com.linkedin.testscript;

import org.testng.annotations.Test;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.linkedin.generic.BaseClass;
import com.linkedin.generic.Filelib;
import com.linkedin.pom.CompanyPage;


@Listeners(com.linkedin.generic.ListenerImplementation.class)
public class Company extends BaseClass{
	
	@Test
	//@Parameters("browser")
	public void verifyCompany() throws SQLException, EncryptedDocumentException, IOException {
	CompanyPage c = new CompanyPage(driver);
	
	Filelib f=new Filelib();
	
	c.getCompany().click();
	String cmpytextfield = f.getExcelData("company", 0, 0);
	c.getCompanytextfield().sendKeys(cmpytextfield);
	c.getSearchBtn().click();
	String text = c.getText().getText();
	Reporter.log(text);
	String text1 = c.getDBMessage().getText();
	Reporter.log(text1);
	
	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/slinkrdb","root","tiger@12");
	Statement stmt = connection.createStatement();
	String s="select comp_name from linkapp_companydata1 where comp_name='Accetion'";
	ResultSet rs = stmt.executeQuery(s);
	while(rs.next()) {
		String cn = rs.getString("comp_name");
		Reporter.log("comp_name is:"+cn);
		
		
}
}
}
