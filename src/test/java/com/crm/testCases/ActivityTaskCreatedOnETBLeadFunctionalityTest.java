package com.crm.testCases;


import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.ActivityPage;
import com.AU.pages.CustomerPage;



public class ActivityTaskCreatedOnETBLeadFunctionalityTest extends SetUp{
	
	AULoginPage au=new AULoginPage();
	CustomerPage cp=new CustomerPage();
	ActivityPage ap=new ActivityPage();

	
	@Test
	public void TaskCreatedOnETBLeadTest() throws Exception {
		
		String sheetName = "TaskCreatedOnETBLeadTest";
		if (!(CommonMethods.isTestRunnable("TaskCreatedOnETBLeadTest", sheetName))) {

			throw new SkipException(
					"Skipping the test " + "TaskCreatedOnETBLead".toUpperCase() + "as the Run mode is NO");
		}
		au.login(sheetName);
		log.info("Login as a CSE User");
		ap.clickOnRecentItemsOfLead();
		ap.clickOnActivitiesLead();
		ap.clickONNewTask();
		ap.clickOnDefaultTask();
		ap.createNewTask(sheetName);
		ap.toVerifyTaskIsCreated();
	}

}

