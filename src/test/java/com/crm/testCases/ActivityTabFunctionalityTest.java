package com.crm.testCases;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.AppointmentsPage;





public class ActivityTabFunctionalityTest extends SetUp {
	
	AULoginPage au=new AULoginPage();;
	AppointmentsPage ap=new AppointmentsPage();
	
	
	
	
	
	//Activity Tc 1-4- are covered
	@Test
	public void ActivityCreationTest() throws Exception {
		
		String sheetName = "ActivityCreationTest";
		
		if (!(CommonMethods.isTestRunnable("ActivityCreationTest", sheetName))) {

			throw new SkipException(
					"Skipping the test " + "ToVerifyAppointmentCreationPage".toUpperCase() + "as the Run mode is NO");
		}
		
		au.login(sheetName);
		log.info("Login as a CSE User");
		ap.navigateToAppointmnetsTab();
		//ap.verifyPaginationworkingProperly();
		//ap.viewCategoryListOfAppointmentsDispalyed();
		ap.openNewAppointmentCreationPage();
		ap.CreateAppointment(sheetName);
		Thread.sleep(3000);
		ap.EditAppointment(sheetName);
		Thread.sleep(3000);
		ap.closeAppointment();
		ap.viewCategoryListOfAppointmentsDispalyed();
	}                                                            
	
	
	
	
	
	/*@Test(priority=4)
	public void TC_05ToVerifyPaginationWorkingProperly() throws Exception {
		if (!(CommonMethods.isTestRunnable("VerifyActivityTabFunctionalityTest"))) {

			throw new SkipException(
					"Skipping the test " + "ToVerifyAppointmentsPagination".toUpperCase() + "as the Run mode is NO");
		}
		ap=new AppointmentsPage(driver);
		ap.verifyPaginationworkingProperly();
		
	}*/
	
	
	
	

}
