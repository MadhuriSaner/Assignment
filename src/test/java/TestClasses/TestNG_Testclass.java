package TestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import POMClasses.POM1;
import POMClasses.POM2;
import POMClasses.POMAssertAvlBal;
import POMClasses.POMSignOff;
import POMClasses.TransferFunds;

public class TestNG_Testclass extends BaseClass
{
	POM1 p1;
	POM2 p2;
	POMSignOff p3;
	POMAssertAvlBal p4;
	TransferFunds p5;
	
	@BeforeClass
	public void OpenBrowser()
	{
		initializeBrowser();
		//create object of POM Classes
		p1=new POM1(driver);
		p2=new POM2(driver);
		p3=new POMSignOff(driver);
		p4=new POMAssertAvlBal(driver);
		p5=new TransferFunds(driver);
	}
	
	@BeforeMethod
	public void Login() throws InterruptedException, IOException
	{	
	  Thread.sleep(2000);
	  p1.clkbutton();       //to click on sign in button
	  Thread.sleep(2000);
	  p2.enteruname(UtilityClass.getDataFromPF("username"));
	  Thread.sleep(2000);
	  p2.enterpwd(UtilityClass.getDataFromPF("password"));
	  Thread.sleep(2000);
	  p2.clkLogin();
	  
	}
	@Test
	public void verifyuname() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String actualuname=p2.getuname();
		Thread.sleep(2000);
		
		String expecteduname=UtilityClass.getDataFromExcel(1,0);
		Thread.sleep(2000);
		
		Assert.assertEquals(actualuname,expecteduname);
	}
	@Test(priority=1)
	public void listbox() throws InterruptedException
	{
		Thread.sleep(2000);
		Select sal=new Select(driver.findElement(By.xpath("//select[@id='listAccounts']")));
		Thread.sleep(2000);
		sal.selectByVisibleText("800001 Checking");
		Thread.sleep(2000);
		p3.clkgo();
	}
	@Test(priority=2)
	public void clkviewsummary() throws InterruptedException
	{
		String s1="";
		Thread.sleep(2000);
		Assert.assertNotEquals(s1,p4);
		Thread.sleep(2000);
		p3.clkviewsummary();    //to click on view account summary on left pane
	}
	@Test(priority=3)
	public void transferfunds() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		Thread.sleep(2000);
		p5.clktransferfunds();
		Thread.sleep(2000);
		Select act=new Select(driver.findElement(By.xpath("//select[@id='toAccount']")));
		act.selectByVisibleText("800001 Checking");
		
		Thread.sleep(2000);
		p5.amttransfer();
		Thread.sleep(2000);
		p5.transbtn();
		WebElement actualresult=driver.findElement(By.xpath("//span[@style='color: Red']"));
		String actres=actualresult.getText();
		String expectedres=UtilityClass.getDataFromExcel(0,0);
		Assert.assertEquals(actres,expectedres);
	}
	
	@AfterMethod
	public void Logout()
	{
		p3.signOff();
	}
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
	
	

}
