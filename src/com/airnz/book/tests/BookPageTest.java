package com.airnz.book.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.airnz.book.pageobj.BookPage;
import com.airnz.book.pageobj.FlightsSearchPage;
import com.airnz.book.pageobj.FlightsSearchResultPage;
import com.airnz.book.pageobj.HomePage;

public class BookPageTest {

	WebDriver driver;
	
	@Before
	public void testSetUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\Eclipse WorkPlace\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@After
	public void testShutDown() {
		driver.close();
	}
	
	@Test
	public void shouldSearchBookInfo() throws Exception {
		HomePage onHomePage = new HomePage(driver);
		onHomePage.navigateToHomePage();				
		BookPage onBookPage = onHomePage.onClickBook();
		FlightsSearchPage onFlightsSearchPage1 = onBookPage.onClickFlights();		
		FlightsSearchPage fillForm = onFlightsSearchPage1.fillTheSearchForm();
		FlightsSearchResultPage onClickSearch = fillForm.onClickSearch(); 
		
		Assert.assertTrue(onClickSearch.getFlightsSearchResult().contains("Select your flight to Wellington"));
	}
}
