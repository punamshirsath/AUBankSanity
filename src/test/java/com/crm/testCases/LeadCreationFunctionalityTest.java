package com.crm.testCases;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.LeadPage;


public class LeadCreationFunctionalityTest extends SetUp{
	
	AULoginPage au=new AULoginPage();;
	LeadPage lp=new LeadPage();
	//public String sheetName = "CSELogin";
	
	
	@Test 
	public void LiabilityLeadCreationTest() throws Exception {
		
		String sheetName = "LiabilityLeadCreationTest";
		String sheetName1="BMLogin";
		String sheetName2="BOLogin";
		String sheetName3="DVULogin";
		
		if (!(CommonMethods.isTestRunnable("LiabilityLeadCreationTest",sheetName))) {

			throw new SkipException(
					"Skipping the test LiabilityLeadCreationTest as the Run mode is NO + ");
		}
		
		au=new AULoginPage();
		au.login(sheetName);
		log.info("Login as a CSE User");
		lp.clickOnLeadsTab();
		lp.clickOnLiabilityFlow();
		lp.enterNewLeadDetails(sheetName);
		CommonMethods.ExWait("leadId_XPATH");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("leadId_XPATH"))).isDisplayed());
		lp.clickOnToggleBtn();
		lp.leadDetailsOnDetailsPage(sheetName);
		lp.VerifyLeadDetailsInSummaryBand();
		lp.editLead();
		lp.verifyEditPageFields();
		///enter all details for document collection stage
		lp.fillDataAtDocCollectedStage(sheetName);
		Thread.sleep(3000);
		lp.clickOnToggleBtn();
		Thread.sleep(3000);
		au.Logout();
				
				
		//login as a Branch Manager
		au.login(sheetName1);
		log.info("Login as a Branch Manager User");
		lp.editLeadAtBMStage();
		Thread.sleep(3000);
		au.Logout();
				
				
		//login AS Back office
		au.login(sheetName2);
		log.info("Login as a Back Office User");
		lp.editLeadAtBOStage();
		Thread.sleep(2000);
		au.Logout();
				
				
		//login as DVu user
		au.login(sheetName3);
		log.info("Login as a Document Verification Unit");
		lp.editLeadAtDVUStage(sheetName);
		Thread.sleep(2000);
		lp.clickOnToggleBtn();
		lp.VerifyHistoryTab();
		
		
		//au.Logout();
		
	}
	
	
	/*@Test
	public void TC_05ToVerifyPaginationAndOrderByTest() throws Exception {
		if (!(CommonMethods.isTestRunnable("VerifyLeadCreationFunctionality"))) {

			throw new SkipException(
					"Skipping the test " + "ToVerifyPaggination".toUpperCase() + "as the Run mode is NO");
		}
		au=new AULoginPage(driver);
		au.login(sheetName);
		log.info("Login as a CSE User");
		lp=new LeadPage(driver);
		lp.verifypaginationGoToTextBox();
	}*/
	
	
}
