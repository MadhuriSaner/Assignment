package LibraryFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass 
{

	public WebDriver driver;
	
	public void initializeBrowser()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\shind\\eclipse-workspace\\11JuneMaven\\Browser\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);  //wait for whole page to load
		driver.get("http://testfire.net/");
		driver.manage().window().maximize();
		
		
	}

}
