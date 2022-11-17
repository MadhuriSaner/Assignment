package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFunds 
{
	
	@FindBy(xpath="//a[@id='MenuHyperLink3']") private WebElement transferfunds;
	@FindBy(xpath="//select[@id='toAccount']") private WebElement toactlist;
	@FindBy(xpath="//input[@id='transferAmount']") private WebElement amttransfer;
	@FindBy(xpath="//input[@name='transfer']")private WebElement transbtn;
	public TransferFunds(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void clktransferfunds()
	{
		transferfunds.click();
	}
	public void amttransfer()
	{
		amttransfer.sendKeys("9876");
	}
	public void transbtn()
	{
		transbtn.click();
	}
	

}
