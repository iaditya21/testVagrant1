package components;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.FlightBookingTestOR;

public class FlightBookingTestComp {

	WebDriverWait wait;
	FlightBookingTestOR OR;
	public void selectCity(WebDriver driver,WebElement element,String city,WebElement cityList)
	{
		wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(city);
		wait.until(ExpectedConditions.visibilityOf(cityList));
		element.sendKeys(Keys.ENTER);

	}

	public void datePicker(WebDriver driver,String Year,String month,String date)
	{
		OR=new FlightBookingTestOR(driver);
		OR.datePicker.click();


		while(!OR.getYear.getText().equalsIgnoreCase(Year))
		{
			if(OR.getYear.getText().equalsIgnoreCase(Year))
				break;
			else
				OR.nextBtn.click();
		}

		while(!OR.getMonth.getText().equalsIgnoreCase(month))
		{
			if(OR.getYear.getText().equalsIgnoreCase(month))
				break;
			else
				OR.nextBtn.click();
		}

		driver.findElement(By.xpath(String.format(OR.date, date))).click();
	}
}
