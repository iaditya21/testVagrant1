package testCase;

import components.FlightBookingTestComp;
import components.General;
import objectRepository.FlightBookingTestOR;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlightBookingTest extends General {

	WebDriver driver;
	FlightBookingTestOR OR;
	FlightBookingTestComp flightBook;
	@BeforeTest
	public void setUp()
	{

		setDriverPath();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		OR=new FlightBookingTestOR(driver);
		flightBook=new FlightBookingTestComp();
	}

	@Test(priority=1)
	@Parameters({ "URL"})
	public void openApplication(String url)
	{
		try {
			//launch(driver, "https://www.cleartrip.com/","#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.");
			launch(driver,url,"#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Test(priority=2)
	@Parameters({ "source","destination","year","month","date"})
	public void bookFlight(String source,String destination,String year,String month,String date) {


		OR.oneWayRdBtn.click();
		flightBook.selectCity(driver, OR.fromTextBox,source,OR.fromCityList);
		flightBook.selectCity(driver, OR.toTextBox,destination,OR.toCityList);      
		flightBook.datePicker(driver, year, month ,date);

		//all fields filled in. Now click on search
		OR.srchBtn.click();
		//verify that result appears for the provided journey search
		Assert.assertTrue(OR.searchResult.isDisplayed());

	}


	@AfterTest
	public void tearDown()
	{

		driver.quit();
	}
	
}
