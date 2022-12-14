package com.crm.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.CustomerPage;
import com.AU.pages.QuickLinkPage;
import com.AU.pages.SRCreationPage;


public class SRCreartionUsingCERSAIChargesRelatedSubSubCategoryFunctionalityTest extends SetUp{
	
	AULoginPage au=new AULoginPage();
	QuickLinkPage qp=new QuickLinkPage();
	CustomerPage cp=new CustomerPage();
	SRCreationPage sp=new SRCreationPage();
	
	
	//Covered all removal CERSAI Module Testcases
	
	@Test
	public void SRCreationCERSAIChargesCatTest() throws Exception {
		
		String sheetName = "SRCreationCERSAIChargesCatTest";
		String sheetName2 = "DELogin";
		
		if (!(CommonMethods.isTestRunnable("SRCreationCERSAIChargesCatTest", sheetName))) {

			throw new SkipException(
					"Skipping the test " + "ToverifyQuickLinks".toUpperCase() + "as the Run mode is NO");
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
		sp.selectSubSubCategoryCERSAIRelatedCharges();
		Thread.sleep(4000);
		sp.verifyServiceTypeISAutoPopulated();
		sp.clickOnNextButton();
		CommonMethods.scrollDown(1000);
		sp.accountNOForSR();
		sp.enterLoanDetails(sheetName);
		sp.clickOnOKBtn();
		sp.verifyCaseNumberIsGenerated();
		sp.verifyCaseOwnerISUpdated();
		au.Logout();
		au.login(sheetName2);
		log.info("Login as a Department Engineer User");
		sp.deUserClickOnCustomerServiceTab();
		CommonMethods.scrollDown(500);
	    sp.selectViewOfDepartmentEngineer(sheetName);
	    sp.selectSRForSelfAssignment();
	    sp.editSRAsAReAssignmentFlag();
	    sp.editSRASAInProcess();
	   sp.editSRAsaResolvedStatusCode(sheetName);
	    
	    

}
}
