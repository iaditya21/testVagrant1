package testCase;

import com.sun.javafx.PlatformUtil;

import components.General;
import objectRepository.HotelBookingTestOR;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HotelBookingTest extends General{



	WebDriver driver;
	WebDriverWait wait;
	HotelBookingTestOR OR;
	@BeforeTest
	public void setUp()
	{
		setDriverPath();
		driver=new ChromeDriver();
		OR=new HotelBookingTestOR(driver);
		wait=new WebDriverWait(driver, 60);
	}
	@Test(priority=1)
	@Parameters({ "URL" })
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
	@Parameters({ "location","occupancy",})
	public void searchHotels(String location,String occupancy) throws InterruptedException {

		OR.hotelLink.click();
		wait.until(ExpectedConditions.visibilityOf(OR.localityTextBox));
		OR.localityTextBox.clear();
		OR.localityTextBox.sendKeys(location);
		wait.until(ExpectedConditions.visibilityOf(OR.locationList));
		OR.localityTextBox.sendKeys(Keys.ENTER);
		new Select(OR.travellerSelection).selectByVisibleText(occupancy);
		OR.searchButton.click();

	}
	
	@AfterTest
	public void tearDown()
	{

		driver.quit();
	}


}
