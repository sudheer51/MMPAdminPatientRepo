package org.iit.mmp.admin.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminNavigationPage {
	
	WebDriver driver;
	
	By userLink             =   By.xpath("//span[contains(text(),'Users')]");
	By claimCenterLink      =   By.xpath("//span[contains(text(),'Claim Center')]");
	By patientLink 			=   By.xpath("//span[contains(text(),'Patients')]");
	
	public AdminNavigationPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void clickUserLink()	{

		driver.findElement(userLink).click();
	}
	
	public void clickClaimCenterLink()	{

		driver.findElement(claimCenterLink).click();
	}
	
	public void clickPatientsLink()	{

		driver.findElement(patientLink).click();
	}

}
