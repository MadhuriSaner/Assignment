package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMAssertAvlBal 
{
	@FindBy(xpath="(//table//td[@align='right'])[4]") private WebElement avlbal;

	public POMAssertAvlBal(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
}
