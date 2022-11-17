package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM1 
{
	//identify element on webpage
	
	@FindBy(xpath="//a[@id='LoginLink']") private WebElement signinbtn;
	
	public POM1(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clkbutton()
	{
		signinbtn.click();
	}

}
