package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class POMSignOff 
{
	
	//@FindBy(xpath="//select[@id='listAccounts']") private WebElement listbox;
	@FindBy(xpath="//input[@id='btnGetAccount']") private WebElement Go;
	@FindBy(xpath="//a[@id='MenuHyperLink1']") private WebElement viewactsummary;
	@FindBy(xpath="//a[@id='LoginLink']") private WebElement signoff;
	
	public POMSignOff(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void clkgo()
	{
		Go.click();
	}
	
	public void clkviewsummary()
	{
		viewactsummary.click();
	}
	public void signOff()
	{
		signoff.click();
	}
	

}
