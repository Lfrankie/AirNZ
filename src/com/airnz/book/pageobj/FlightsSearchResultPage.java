package com.airnz.book.pageobj;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightsSearchResultPage extends AbstractPage {

	public FlightsSearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	public String getFlightsSearchResult() {
		String searchResult = driver.findElement(By.xpath("//div[@class='vui-si-leg-heading']/h2/span[2]")).getText();
		System.out.println(searchResult);
		return searchResult;
		
	}
}
