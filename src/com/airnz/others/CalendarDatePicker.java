package com.airnz.others;

import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class CalendarDatePicker {
	
		static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Eclipse WorkPlace\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.navigate().to("https://flightbookings.airnewzealand.co.nz/vbook/actions/search");
		Thread.sleep(5000);
		
		//driver.findElement(By.xpath("//*[@id='field-search-journey-type-oneway']")).click();
		driver.findElement(By.xpath("//*[@id='depart-from']")).sendKeys("Auckland");
		driver.findElement(By.xpath("//*[@id='depart-to']")).sendKeys("Wellington");
		driver.findElement(By.xpath("//*[@id='search-leavedate']/div/span")).click();
		SelectLeaveDay("21");
		
		driver.findElement(By.xpath("//*[@id='search-returndate']/div/span")).click();
		SelectReturnDay("30");
	}
	
	public static void SelectLeaveDay(String day) throws InterruptedException {
		By calendarXpath = By.xpath("//td[not(contains(@class,'unselectable notthismonth'))]/div[text()='"+ day + "']");
		driver.findElement(calendarXpath).click();
	}
	
	public static void SelectReturnDay(String day) throws InterruptedException {
		By calendarXpath = By.xpath("//td[not(contains(@class,'unselectable notthismonth'))]/div[text()='"+ day + "']");
		driver.findElement(calendarXpath).click();
	}
}
		
		
		
		
		
		
		
		
		
		
		/*
		driver.navigate().to("https://flightbookings.airnewzealand.co.nz/vbook/actions/search");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='field-search-journey-type-oneway']")).click();
		driver.findElement(By.xpath("//*[@id='depart-from']")).sendKeys("Auckland");
		driver.findElement(By.xpath("//*[@id='depart-to']")).sendKeys("Wellington");
		driver.findElement(By.xpath("//*[@id='search-leavedate']/div/span")).click();
		
	
		String date = "21-September 2017";
		String split[] = date.split("-");
		String checkMonthYear = split[1];
		String checkDay = split[0];
		System.out.println("checkMonthYear: " + checkMonthYear);
		Select monthYear = new Select(driver.findElement(By.xpath("//div[@class='main row']/div[@class='calendarcontainer clearfix']/"
				+ "div[@id='calendarpanel-0']/div[@class='monthselector row']/"
				+ "div[@class='col-xs-8 col-xs-offset-2']")));
			
		for(int i = 0; i < monthYear.getOptions().size(); i++) {
			String my = monthYear.getOptions().get(i).getText();
			System.out.println(my);
			if(my.equals(checkMonthYear)) {
				List<WebElement> days = driver.findElements(By.xpath("//div[@class='calendartable']/table/tbody/tr/td"));				
				System.out.print(days);
			}
			
		}
		
	}
	*/


