package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import components.intializer;

public class FlightBookingTestOR extends intializer {
	public FlightBookingTestOR(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "OneWay")
	public WebElement oneWayRdBtn;

    @FindBy(id = "FromTag")
    public WebElement fromTextBox;

    @FindBy(id = "ToTag")
    public WebElement toTextBox;

    @FindBy(id = "SearchBtn")
    public WebElement srchBtn;
    
    @FindBy(xpath = "//*[@id='ORtrip']/section[2]/div[1]/dl/dd/div/a/i")
    public WebElement datePicker;
    
    @FindBy(xpath = "//*[@id='ui-id-1']")
    public WebElement fromCityList;
    
    @FindBy(xpath = "//*[@id='ui-id-2']")
    public WebElement toCityList;

    @FindBy(xpath = "//div[@class='header']/a[@title='Next']")
    public WebElement nextBtn;
    
    @FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/div/div/span[2]")
    public WebElement getYear;
    
    @FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/div/div/span[1]")
    public WebElement getMonth;
  
    @FindBy(className = "searchSummary")
    public WebElement searchResult;
    
    public String date="//a[contains(text(),%s)]";
    
}
