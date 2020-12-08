package com.bit.project.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	FirefoxDriver dr;
	
	@BeforeClass
	public  void openBrowser() throws FileNotFoundException {
		
		
		FileInputStream file  = new FileInputStream("config.properties");
		Properties p =new Properties();
        
		System.setProperty("webdriver.gecko.driver","C:\\Users\\HASAN\\Downloads\\geckodriver.exe");
		
		dr=new FirefoxDriver();	
		
		
	
	
	
	
	
	
	}
	

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		dr.quit();
	
		
	}

}
