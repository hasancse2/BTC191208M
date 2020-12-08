package com.bit.support;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utility {
	
		FirefoxDriver dr;
		public Utility(FirefoxDriver dr) {
			this.dr = dr;
		}
		
		void goToAnyWebSite(String url) {
			dr.get(url);
		}
		
		public void clickOnAnyElementWithText(List<WebElement> element, String text) {
			
			for(WebElement e : element) {
				if(e.getText().contains(text)) {
					e.click();
					System.out.println("Clicked on Link " + text + " and title is : " + dr.getTitle());
				}
			}
		}
		
		public void verifyAllLinks(List<WebElement> element) throws InterruptedException {
			
			int size = element.size();
			System.out.println("List size is : " + size);
			for(int i=1; i<=size; i++) {
				
				dr.findElement(By.cssSelector("div#footer>div:nth-child(2)>ul>li:nth-child("+i+")>a")).click();
				myWait(2000);
				System.out.println(dr.getTitle());
				dr.navigate().back();
				myWait(2000);
			}
			
		}
		
		public void myWait(int millis) throws InterruptedException {
			Thread.sleep(millis);
		}
		
		public void click(By by) {
			
			WebElement e = dr.findElement(by);
			if(e.isDisplayed()) {
			//	e.findElement(by).click();
				dr.findElement(by).click();
			}
			else {
				System.out.println("Element is not displayed : " + e);
			}
			
		}
		
		public void type(By by, String value) {
			
			WebElement e = dr.findElement(by);
			if(e.isDisplayed()) {
				e.clear();
				e.sendKeys(value);
				//dr.findElement(by).clear();
				//dr.findElement(by).sendKeys(value);
			}
		}
		
		public void type2(By by, String value) {
			
			WebElement e = verifyelementDisplayed(by);
			e.clear();
			e.sendKeys(value);
		}
		
		public WebElement verifyelementDisplayed(By by) {
			WebElement e = dr.findElement(by);
			if(e.isDisplayed()) {
				System.out.println("Element is displayed : " + e);
			}else {
				System.out.println("Element is not displayed :" + e);
			}
			return e;
		}
		
		void getPageTitle(String value) {
			String s = dr.getTitle();
			if(s.contains(value)) {
				System.out.println("Title matched : "+ s);
			}else {
				System.out.println("Title did't match : " + s);
			}
		}
	
		void getPageUrl(String value) {
			String s = dr.getCurrentUrl();
			if(s.contains(value)) {
				System.out.println("URL matched : "+ s);
			}else {
				System.out.println("URL did't match : " + s);
			}
		}
	
		String getTextFromSite(By by) {
			String e = dr.findElement(by).getText();
			return e;
		}
	
}
