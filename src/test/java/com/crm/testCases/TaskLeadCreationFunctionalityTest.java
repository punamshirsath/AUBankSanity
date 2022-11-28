package com.crm.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.TaskPage;



public class TaskLeadCreationFunctionalityTest extends SetUp {
	
	public AULoginPage au;
	public TaskPage tp;
 
	

	//Task Lead Creation using CSE User Are covered 
	@Test
	public void TaskLeadCreationTest() throws Exception {
		
		String sheetName = "TaskLeadCreationTest";
		
		if (!(CommonMethods.isTestRunnable("TaskLeadCreationTest",sheetName ))) {

			throw new SkipException(
					"Skipping the test TaskLeadCreationTest as the Run mode is NO + ");
		}
		au=new AULoginPage();
		au.login(sheetName);
		log.info("Login as a CSE User");
		tp=new TaskPage();
		tp.clickOnTaskTab();
		tp.clickOnNewButtonOfTask();
		tp.createNewTask();
		tp.editCreatedTask();
	}

	
	/*@Test(priority=2)
	public void TC_02CSEUserClickOnNewTaskButton() throws Exception {
		if (!(CommonMethods.isTestRunnable("VerifyTaskLeadCreationFunctionalityTest"))) {

			throw new SkipException(
					"Skipping the test " + "TaskLeadCreationTest".toUpperCase() + "as the Run mode is NO");
		}
	
	tp.clickOnNewButtonOfTask();
	}
	
	@Test(priority=3)
	public void TC_02CSEUserableToEditTask() throws Exception {
		if (!(CommonMethods.isTestRunnable("VerifyTaskLeadCreationFunctionalityTest"))) {

			throw new SkipException(
					"Skipping the test " + "TaskLeadCreationTest".toUpperCase() + "as the Run mode is NO");
		}
	
	//tp.clickOnNewButtonOfTask();
	tp.createNewTask();
	tp.editCreatedTask();
	}
	
	
	
	/*@Test(priority=4)
	public void TC_04VerifyViewSectionIsDisplayedOnTaskPage() throws Exception {
		if (!(CommonMethods.isTestRunnable("VerifyTaskLeadCreationFunctionalityTest"))) {

			throw new SkipException(
					"Skipping the test " + "TaskLeadCreationTest".toUpperCase() + "as the Run mode is NO");
		}*/
	

}	