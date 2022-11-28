package com.crm.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.CustomerPage;
import com.AU.pages.SRCreationPage;



public class SRCreationFunctionalityTest extends SetUp {
	
	AULoginPage au=new AULoginPage();
	SRCreationPage sp=new SRCreationPage();
	CustomerPage cp=new CustomerPage();
	
	
	
	
	@Test
	public void SRCreationTest() throws Exception {
		
		String sheetName = "SRCreationTest";
		
		if (!(CommonMethods.isTestRunnable("SRCreationTest", sheetName ))) {

			throw new SkipException(
					"Skipping the test " + "ToverifySRCreationTest".toUpperCase() + "as the Run mode is NO");
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
		sp.selectSubSubCategoryForSR();
		sp.verifySubCategoryFieldAreAutoSelected();
		sp.verifyCategoryFieldAreAutoSelected();
		sp.clickOnNextButton();
		sp.accountNOForSR();
		sp.verifyMobileNoIsAutopopulated(sheetName);
		sp.verifyDepositTypeDropdown();
		sp.selectDepositType();
		sp.selectProducteNameCodeAsFDSeniorCitizenBulkMonthlyPayout();
		sp.enterMandatoryDetailsForSR(sheetName);
		sp.clickOnOKBtn();
		sp.verifyCaseNumberIsGenerated();
		au.Logout();
		
		
	}
	
	
	
	
	
	

	/*@Test(priority=1)
	public void ToVerifyCompreshensiveSRReportGenerated() throws Exception {
		if (!(CommonMethods.isTestRunnable("VerifySRCreationFunctionalityTest"))) {

			throw new SkipException(
					"Skipping the test " + "SRCreationTest".toUpperCase() + "as the Run mode is NO");
		}
		
		
	
} */
}