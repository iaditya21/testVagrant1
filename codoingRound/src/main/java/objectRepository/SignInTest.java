package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import components.intializer;

public class SignInTest extends intializer{

	public SignInTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(linkText="Your trips")
	public static WebElement tripsLink;
	
	@FindBy(id="SignIn")
	public static WebElement signInBtn;
	
	@FindBy(id="modal_window")
	public static WebElement signInFrame;
	
	@FindBy(id="signInButton")
	public static WebElement signInBtn1;
	
	@FindBy(id="errors1")
	public static WebElement errorMsg;
}
