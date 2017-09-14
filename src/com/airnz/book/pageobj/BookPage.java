package com.airnz.book.pageobj;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookPage extends AbstractPage{
	

	public BookPage(WebDriver driver) {
		super(driver);
	}
	
	public FlightsSearchPage onClickFlights() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Flights")).click();
		return new FlightsSearchPage(driver);
	}
}
