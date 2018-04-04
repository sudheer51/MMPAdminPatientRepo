package org.iit.mmp.admin.pages;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AdminClaimPage {
	
	WebDriver driver;
	
	By searchTxtbox = By.id("search");
	By sbutton=By.className("tfbutton");
	By gender = By.id("male");
	By worksts = By.id("worksts");
	By dos = By.id("dos");
	By pser = By.id("pser");
	By mcode = By.id("mcode");
	By npiCode = By.cssSelector("div>#pser");
	By icdCode = By.id("dia");
	By cptCode = By.id("proc");
	By balance = By.id("bal");
	By insName = By.id("insname");
	By submitButton = By.xpath("//input[@value='Submit Claim']");
	By doc = By.id("doc");
	public AdminClaimPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void searchByPatientName(String name)
	{
		driver.findElement(searchTxtbox).sendKeys(name);
		driver.findElement(sbutton).click();
	}
	public void searchBySSN(String ssn)
	{
		driver.findElement(searchTxtbox).sendKeys(ssn);
		driver.findElement(sbutton).click();
	}
	public void clickPatientUsingFName(String patientName)
	{
		driver.findElement(By.partialLinkText(patientName)).click();
	}
	 
	public String submitClaim()
	{	
		
		driver.findElement(gender).click();
		driver.findElement(worksts).click();
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		driver.findElement(dos).sendKeys( sdf.format(dt));
		driver.findElement(pser).sendKeys("US");
		new Select(driver.findElement(doc)).selectByVisibleText("Beth");
		new Select(driver.findElement(mcode)).selectByVisibleText("100");
		new Select(driver.findElement(npiCode)).selectByVisibleText("100");
		new Select(driver.findElement(icdCode)).selectByVisibleText("100");
		new Select(driver.findElement(cptCode)).selectByVisibleText("101");
		new Select(driver.findElement(insName)).selectByVisibleText("Atena");
		driver.findElement(balance).sendKeys("10000");
		driver.findElement(By.id("ch")).click();
		driver.findElement(submitButton).submit();
		 
		return driver.switchTo().alert().getText();
	}
}
