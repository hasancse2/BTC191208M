package com.bit.support;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Core {

		FirefoxDriver dr;
		public Core(FirefoxDriver dr) {
			this.dr = dr;
		}
		
		Utility u;
		
		public void globalsearchVerification() {
			u = new Utility(dr);
			u.goToAnyWebSite(Data.url);
			u.getPageTitle(Data.homePageTitle);
			u.type(By.id("search"), "Kids Shoes");
			u.click(By.xpath("//*[@id=\"headerMain\"]/div[1]/form/button[2]"));
			u.getPageTitle("Kids Toys : Target");
			dr.navigate().back();
		}
		
		public void verifyFooterLinks() throws InterruptedException {
			u = new Utility(dr);
			u.goToAnyWebSite(Data.url);
			List<WebElement> e = dr.findElements(By.cssSelector("#footer >div:nth-child(2)>ul:nth-child(1)>li"));
			u.verifyAllLinks(e);
		}
		
		public void verifyFooterCategoryLinks() {
			u = new Utility(dr);
			u.goToAnyWebSite(Data.url);
		}

}
