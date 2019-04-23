package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class intializer extends LoadableComponent<intializer> {
	protected   WebDriver driver;
	public intializer(WebDriver driver)
	{
		super();
		PageFactory.initElements(driver, this);
		this.driver = driver;
		get();
	}
	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		
	}
}
