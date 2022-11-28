package com.crm.testCases;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.ActivityPage;




public class TaskActivityIsCreatedIndependentlyFunctionalityTest extends SetUp {
	
	AULoginPage au=new AULoginPage();
	ActivityPage ap=new ActivityPage();
	
	
	
	@Test
	public void TaskIsCreatedIndependentlyTest() throws Exception {
		
		String sheetName = "TaskIsCreatedIndependentlyTest";
		if (!(CommonMethods.isTestRunnable("TaskIsCreatedIndependentlyTest", sheetName))) {

			throw new SkipException(
					"Skipping the test " + "TaskIsCreatedIndependentlyTest".toUpperCase() + "as the Run mode is NO");
		}
		
		
		au.login(sheetName);
		log.info("Login as a CSE User");
		ap.clickOnTaskTab();
		ap.createNewTask(sheetName);
		ap.verifyIndependantTaskIsCreated();
		
		

}
}
