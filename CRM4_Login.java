package alchemy;

import org.testng.annotations.Test;

import Library.CRM.CRMpom;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class CRM4_Login {
	  
   	  private WebDriver driver;
	  private CRMpom CRMpom;
	  private String baseUrl;
	  private String userName;
	  private String password;
	  private static Properties properties;
	
	  @BeforeClass
	  public void beforeClass() throws IOException 
	  {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/input.properties");
			properties.load(inStream);
			driver = new FirefoxDriver();
			baseUrl = properties.getProperty("baseURL");
			userName = properties.getProperty("userName");
			password = properties.getProperty("password");
			driver.get(baseUrl);
			CRMpom = new CRMpom(driver); 
	  }
	
	  @Test
	  public void login()
	  {
		  // log into the application
		  CRMpom.sendUserName(userName);
		  CRMpom.sendPassword(password);
		  CRMpom.clickLoginBtn();
		  System.out.println(CRMpom.confirmLogIn());
	  }
	
	  @AfterClass
	  public void afterClass() 
	  {
		  driver.close();
	  }

}
