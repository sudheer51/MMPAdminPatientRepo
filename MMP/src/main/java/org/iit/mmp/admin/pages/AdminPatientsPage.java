package org.iit.mmp.admin.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPatientsPage {

	

	WebDriver driver;
 

	public AdminPatientsPage(WebDriver driver){

		this.driver = driver;
	}
	
	public void scheduleAppointment(String doctorName,String date,String time)
	{
		driver.findElement(By.xpath("//input[@value='Create Visit']"));
		driver.findElement(By.xpath("//h4[contains(text(),'"+doctorName+"')]/ancestor::ul/following-sibling::button"));
	}

}
