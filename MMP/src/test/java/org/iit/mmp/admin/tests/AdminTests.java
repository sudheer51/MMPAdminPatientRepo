package org.iit.mmp.admin.tests;

import java.util.HashMap;
import java.util.Random;

import org.apache.log4j.Logger;
import org.iit.mmp.admin.helper.AdminLoginPage;
import org.iit.mmp.admin.helper.AdminNavigationPage;
import org.iit.mmp.admin.pages.AdminClaimPage;
import org.iit.mmp.admin.pages.AdminUsersPage;
import org.iit.mmp.patient.pages.RegisterPatientPage;
import org.iit.mmp.util.HomePage;
import org.iit.mmp.util.TestBaseClass;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdminTests  extends TestBaseClass{

	Logger logger = Logger.getLogger("AdminTests.class");
	HashMap<String,String> hMap;
	Random rnd = new Random();



	@Parameters({"adminUsername","adminPassword","adminUrl","ssn","patFName"})
	@Test(description="Schedule an appointment with Doctor")
	public void scheduleAppointment(String adminUsername,String adminPassword,String adminUrl,String ssn,String patFName)
	{
		driver.get(adminUrl);
		AdminLoginPage  adminLogin = new AdminLoginPage(driver);
		AdminNavigationPage adminNav = new AdminNavigationPage(driver);
		AdminClaimPage adminClaim = new AdminClaimPage(driver);
		
		
		//steps
		adminLogin.loginToAdmin(adminUsername, adminPassword);
		adminNav.clickPatientsLink();
		adminClaim.searchBySSN(ssn);
		adminClaim.clickPatientUsingFName(patFName);
		
		
		
	}
















@Parameters({"adminUsername","adminPassword","adminUrl","url"})
@Test(priority = 3,enabled=false)
public void validateSubmitClaim(String adminUsername,String adminPassword,String adminUrl,String url) throws InterruptedException
{
	SoftAssert sa ;
	try{
		sa = new SoftAssert();

		HomePage hPage = new HomePage(driver);
		RegisterPatientPage regPage = new RegisterPatientPage(driver);
		AdminLoginPage  adminLogin = new AdminLoginPage(driver);
		AdminNavigationPage adminNav = new AdminNavigationPage(driver);
		AdminUsersPage  userPage =new AdminUsersPage(driver);
		AdminClaimPage adminClaim = new AdminClaimPage(driver);
		//			
		//			
		//			//Open MMP Url
		//			driver.get(url);
		//			
		//			//Register the Patient
		//			hPage.navigateToPatientRegPage();
		//			String username = "test"+rnd.nextInt(90);
		//			String password = "test"+rnd.nextInt(90);
		//			Long  emailID = Calendar.getInstance().getTimeInMillis()/100000+ rnd.nextInt(90);
		//			String email = "test"+emailID+"@gmail.com";
		//			
		//			hMap = regPage.register(email,username,password);
		//			sa.assertTrue(hMap.get("message").contains("Thank you for registering with MMP."),"Error in registering the Patient");
		//			
		//Fetch SSN
		//			String ssn = hMap.get("ssn");
		//			String fName = hMap.get("firstName");
		String ssn ="960184043";
		String fName ="testFNFI";
		//Navigate to Admin Url
		driver.navigate().to(adminUrl);

		//login to admin portal
		adminLogin.loginToAdmin(adminUsername, adminPassword);

		//Accept the Patient and select Approved status
		adminNav.clickUserLink();
		String  result =userPage.getApprovedAdminModule(fName,"Pending","Accepted");
		System.out.println("Result :: " + result);
		sa.assertTrue(result.contains("updated"),"Error in login for accepted patient");

		//Submit the Claim
		adminNav.clickClaimCenterLink();
		adminClaim.searchBySSN(ssn);
		adminClaim.clickPatientUsingFName(fName);

		String actual = adminClaim.submitClaim();

		sa.assertTrue(actual.contains("submitted"),"Error in submitting the claim");


		//			1. login to Admin moule
		//			2. Select Approve 
		//			3. SSN Verify the table contains the SSN
		//			4. Navigate to ClaimCenter. Enter SSN.
		//			5. Click on Patient NAme.
		//			6. Submit The claim.
		//			 


		sa.assertAll();

	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Error in submitting the claim" + e.getMessage());
		Assert.fail("Unable to Submit the Claim");

	}
}
}
