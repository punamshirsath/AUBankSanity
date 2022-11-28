package com.crm.testCases;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.TaskPage;



public class VerifyTaskFunctionalityUsingFOSUser extends SetUp{
	
	AULoginPage au=new AULoginPage() ;
	TaskPage tp=new TaskPage();
	
	
	
	//Fos User Task Creation Tcs Covered
	@Test(priority=1)
	public void TC_01ToVerifyFOSUserAbleToCreateTaskFunctionalityTest() throws Exception {
		
		String sheetName = "FOSLogin";
		
		if (!(CommonMethods.isTestRunnable("TC_01ToVerifyFOSUserAbleToCreateTaskFunctionalityTest", sheetName))) {

			throw new SkipException(
					"Skipping the test " + "TaskLeadCreationTestForFOSUser".toUpperCase() + "as the Run mode is NO");
		}
		

		au.login(sheetName);
		log.info("Login as FOS User");
		tp.clickOnTaskUsingFOSUser();
		tp.createNewTaskUsingFOSUser();
        tp.verifyTaskIsCreatedByFOS();
        tp.editCreatedTaskByFOS();
		//tp.editCreatedTask();
}

}