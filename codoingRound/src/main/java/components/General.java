package components;

import org.openqa.selenium.WebDriver;
import com.sun.javafx.PlatformUtil;

public class General {


	public void setDriverPath() {
		if (PlatformUtil.isMac()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
		}
		if (PlatformUtil.isWindows()) {
			String currentDirectory = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver",currentDirectory +"\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		}
		if (PlatformUtil.isLinux()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
		}
	}


	public void launch(WebDriver driver,String url,String title) throws Exception
	{
		driver.get(url);
		driver.manage().window().maximize();
		if(!title.equalsIgnoreCase(driver.getTitle()))
			throw new Exception("Title of the page does not match with the original value");
	}



}
