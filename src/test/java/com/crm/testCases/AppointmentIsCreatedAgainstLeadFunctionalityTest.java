package com.crm.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.CSEHomePage;
import com.AU.pages.LeadPage;


public class AppointmentIsCreatedAgainstLeadFunctionalityTest extends SetUp {

	AULoginPage au=new AULoginPage();
	LeadPage lp=new LeadPage();
	CSEHomePage cp=new CSEHomePage();
	
	
	@Test
	public void AppointmentCreatedAgainstLead() throws Exception {
		
		 String sheetName = "AppointmentCreatedAgainstLead";
			
		if (!(CommonMethods.isTestRunnable("AppointmentCreatedAgainstLead",sheetName))) {

			throw new SkipException(
					"Skipping the test " + "ToVerifyAppointmentCrestion".toUpperCase() + "as the Run mode is NO");
		}
	
		au.login(sheetName);
		log.info("Login as a CSE User");
		
		//Click On Recent Items
		cp.clickOnRecentItems();
		
		Thread.sleep(2000);
		lp.clickOnToggleBtn();
		
		//Click on activities
		cp.clickOnActivitiestab();
		Thread.sleep(2000);
		
		
		//Click on New Call and Meetings
		cp.clickOnNewCallAndMeetingsLink();
		
		//Create New Appointment
		cp.CreateAppointment(sheetName);
		
		cp.VerifyAppointmentIsCreated(sheetName);
		
		
		//logout
		//au.Logout();
	
}
}
