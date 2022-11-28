package com.crm.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.AppointmentsPage;

public class AppointmentPagePagginationFunctionalityTest extends SetUp {
	
	AULoginPage au=new AULoginPage();;
	AppointmentsPage ap=new AppointmentsPage();
		
	@Test
	public void PagginationOnAppointmentTest() throws Exception {
		
		String sheetName = "PagginationOnAppointmentTest";
		
		if (!(CommonMethods.isTestRunnable("PagginationOnAppointmentTest", sheetName))) {

			throw new SkipException(
					"Skipping the test " + "PagginationOnAppointmentPage".toUpperCase() + "as the Run mode is NO");
		}
		
		au.login(sheetName);
		log.info("Login as a CSE User");
		ap.navigateToAppointmnetsTab();
		log.info("View Bucket Displayed In Appointment Page");
		//CommonMethods.scrollDown(500);
		ap.verifypaginationGoToTextBox();

}
}
