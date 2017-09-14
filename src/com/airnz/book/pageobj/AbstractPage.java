package com.airnz.book.pageobj;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class AbstractPage {

	WebDriver driver;
	
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver(WebDriver driver) {
		return driver;
	}
	
	public HomePage navigateToHomePage() {
		driver.navigate().to("https://www.airnewzealand.co.nz/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return new HomePage(driver);
	}
}
