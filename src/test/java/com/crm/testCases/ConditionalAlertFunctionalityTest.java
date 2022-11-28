package com.crm.testCases;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.ConditionalAlertPage;
import com.AU.pages.CustomerPage;
import com.AU.pages.SRCreationPage;
import com.AU.pages.adminPage;

public class ConditionalAlertFunctionalityTest  extends SetUp{
	
	AULoginPage au=new AULoginPage();
	SRCreationPage sp=new SRCreationPage();
	CustomerPage cp=new CustomerPage();
	ConditionalAlertPage cap=new ConditionalAlertPage();
	adminPage ap=new adminPage();
	
	@Test
	public void ConditionalAlertTest() throws Exception {
		
		String sheetName = "ConditionalAlertTest";
		String sheetName1 = "AdminLogin";
		
		if (!(CommonMethods.isTestRunnable("ConditionalAlertTest", sheetName ))) {

			throw new SkipException(
					"Skipping the test " + "ToConditionalAlertTest".toUpperCase() + "as the Run mode is NO");
		}
		
		au.login(sheetName);
		log.info("Login as a CSE User");
		cp.moveToQuickLink();
		cp.clickOnCustomerSearchTab();
		cp.enterMobileNoForCustomerSearch(sheetName);
		cp.clickOnCustomer();
		Thread.sleep(4000);
		CommonMethods.scrollAtBottom();
		sp.clickOnSRCreationBtn();
		Thread.sleep(3000);
		cap.selectSubSubCategory();
		sp.clickOnNextButton();
		cap.selectAutoAssignmentDrpdown();
		cap.selectCaseOwner();
		sp.accountNOForSR();
		cap.selectRequestLetter();
		cap.clickOnSaveAndProceed();
        Thread.sleep(4000);
        String caseNo=driver.findElement(By.xpath(CommonMethods.readPropertyFile("caseNumber_XPATH"))).getText();
        System.out.println("Case Number Is Created::" +caseNo);
        au.Logout();
        
        au.login(sheetName1);
		log.info("Login as a Administrator");
		ap.clickOnAdministrativeSettings();
		ap.clickOnEmailLog();
       
}
}