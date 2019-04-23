package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.sun.javafx.PlatformUtil;

import components.General;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends General {


	WebDriver driver;
	objectRepository.SignInTest OR;
	@BeforeTest
	public void setUp()
	{

		setDriverPath();
		driver=new ChromeDriver();
		OR=new objectRepository.SignInTest(driver);
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
	public void signIn() {
		objectRepository.SignInTest.tripsLink.click();
		objectRepository.SignInTest.signInBtn.click();
		driver.switchTo().frame(objectRepository.SignInTest.signInFrame);

		objectRepository.SignInTest.signInBtn1.click();
		//waitFor(3000);
		String errors1 =objectRepository.SignInTest.errorMsg.getText();
		Assert.assertTrue(errors1.contains("There were errors in your submission"));
		try {
			throw new Exception(errors1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterTest
	public void tearDown()
	{

		driver.quit();
	}









}
