package com.airnz.book.pageobj;

import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightsSearchPage extends AbstractPage {

	public FlightsSearchPage(WebDriver driver) {
		super(driver);
	}
	
	public FlightsSearchPage fillTheSearchForm() throws InterruptedException {
		
		//driver.findElement(By.xpath("//*[@id='field-search-journey-type-return']")).click();
		
		// Input departure and arrival city
		driver.findElement(By.xpath("//*[@id='depart-from']")).sendKeys("Auckland");		
		driver.findElement(By.xpath("//*[@id='depart-to']")).sendKeys("Wellington");
		
		// Select flight date from calendar
		driver.findElement(By.xpath("//*[@id='search-leavedate']/div/span")).click();
		SelectLeaveDay("21");						
		driver.findElement(By.xpath("//*[@id='search-returndate']/div/span")).click();
		SelectReturnDay("30");		
		Thread.sleep(1000);
		
		// Select number of adults, children and infants
		Select dropListAdult = new Select(driver.findElement(By.id("adultCountDisplay")));
		dropListAdult.selectByValue("2");
		Select dropListChildren = new Select(driver.findElement(By.id("childCountDisplay")));
		dropListChildren.selectByValue("1");
		Select dropListInfants = new Select(driver.findElement(By.id("paxCountInput.infants")));
		dropListInfants.selectByValue("1");		
		Thread.sleep(1000);
		return new FlightsSearchPage(driver);
		
	}
	// Select leave day from calendar
	public void SelectLeaveDay(String day) {
		By calendarXpath = By.xpath("//td[not(contains(@class,'unselectable notthismonth'))]/div[text()='"+ day + "']");
		driver.findElement(calendarXpath).click();
	}
	
	// Select return day from calendar
	public void SelectReturnDay(String day) {
		By calendarXpath = By.xpath("//td[not(contains(@class,'unselectable notthismonth'))]/div[text()='"+ day + "']");
		driver.findElement(calendarXpath).click();
	}
	
	// After filled the form click 'search' button
	public FlightsSearchResultPage onClickSearch() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='vui-submission vui-submission-actions']/button")).click();
		return new FlightsSearchResultPage(driver);
	}
	
}

