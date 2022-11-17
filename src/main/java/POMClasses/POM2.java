package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM2 
{
	//identify elements on webpage
	@FindBy(xpath="//input[@id='uid']") private WebElement username;
	@FindBy(xpath="//input[@id='passw']") private WebElement password;
	@FindBy(xpath="//input[@name='btnSubmit']") private WebElement loginbtn;
	
	
	public POM2(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void enteruname(String uname)
	{
		username.sendKeys(uname);
	}
	public void enterpwd(String pwd)
	{
		password.sendKeys(pwd);
	}
	public void clkLogin()
	{
		loginbtn.click();
	}
	public String getuname()
	{
		String actualuname=username.getText();
		return actualuname;
	}
	
	

}
