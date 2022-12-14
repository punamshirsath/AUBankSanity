package com.crm.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.CustomerPage;
import com.AU.pages.LeadPage;

public class CustomerIsGettingCreatedThroughLeadsFunctionalityTest extends SetUp {

	AULoginPage au=new AULoginPage();;
	LeadPage lp=new LeadPage();
	CustomerPage cp=new CustomerPage();
	
	@Test 
	public void CustomerCreatedThroghtLeadTest() throws Exception {
		String sheetName = "CustomerCreatedThroghtLeadTest";
		String sheetName1="BMLogin";
		String sheetName2="BOLogin";
		String sheetName3="DVULogin";
		
		if (!(CommonMethods.isTestRunnable("CustomerCreatedThroghtLeadTest",sheetName))) {

			throw new SkipException(
					"Skipping the test CustomerLeadCreationTest as the Run mode is NO + ");
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
		Thread.sleep(3000);
		String cif=driver.findElement(By.xpath(CommonMethods.readPropertyFile("createdCIf_XPATH"))).getText();
		cp.moveToQuickLink();
		cp.clickOnCustomerSearchTab();
		CommonMethods.sendkeys("cifInput_XPATH", cif);
		CommonMethods.Click("fetchBtn_XPATH");
		CommonMethods.Click("firstCustomer_XPATH");
		Assert.assertTrue(
				driver.findElement(By.xpath(CommonMethods.readPropertyFile("apppageTitle_XPATH"))).isDisplayed());
		String accountNo=driver.findElement(By.xpath(CommonMethods.readPropertyFile("accountNo_XPATH"))).getText();
		System.out.println("Account No is:: " +accountNo);
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("accountNo_XPATH"))).isDisplayed());
		log.info("Customer is Creared through Leads");
		
		
		
	}
}
