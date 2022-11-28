package com.crm.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.ActivityPage;
import com.AU.pages.CustomerPage;



public class ActivityTaskCreatedOnETBCustomerFunctionalityTest extends SetUp{
	
	AULoginPage au=new AULoginPage();
	CustomerPage cp=new CustomerPage();
	ActivityPage ap=new ActivityPage();
	
	
	
	@Test
	public void TaskCreatedOnETBCustomerTest() throws Exception {
		
		String sheetName = "TaskCreatedOnETBCustomerTest";
		
		if (!(CommonMethods.isTestRunnable("TaskCreatedOnETBCustomerTest",sheetName ))) {

			throw new SkipException(
					"Skipping the test " + "ToVerifyTaskIsCreatedOnETBCustomer".toUpperCase() + "as the Run mode is NO");
		}
		

		au.login(sheetName);
		log.info("Login as a CSE User");
		ap.clickOnRecentItemsOfCustomer();
		ap.clickOnActivitiesCustomer();
		ap.clickONNewTask();
		ap.createNewTask(sheetName);
		ap.toVerifyTaskIsCreated();
	}
}
