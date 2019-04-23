package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import components.intializer;

public class HotelBookingTestOR extends intializer {
	public HotelBookingTestOR(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(linkText = "Hotels")
	public WebElement hotelLink;

    @FindBy(id = "Tags")
    public WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    public WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    public WebElement travellerSelection;
    
    @FindBy(xpath = "//*[@id='ui-id-1']")
    public WebElement locationList;
}
