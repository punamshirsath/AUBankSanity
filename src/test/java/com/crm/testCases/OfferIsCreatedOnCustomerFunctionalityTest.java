package com.crm.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.ActivityPage;
import com.AU.pages.CustomerPage;
import com.AU.pages.OfferPage;

public class OfferIsCreatedOnCustomerFunctionalityTest  extends SetUp {
	
	AULoginPage au=new AULoginPage();
	OfferPage op=new OfferPage();
	CustomerPage cp=new CustomerPage();
	ActivityPage ap=new ActivityPage();

	@Test
   	public void OfferOnETBCustomerTest() throws Exception {
   		
   		String sheetName = "OfferOnETBCustomerTest";
   		if (!(CommonMethods.isTestRunnable("OfferOnETBCustomerTest",sheetName ))) {

			throw new SkipException(
					"Skipping the test " + "ToVerifyOfferCreation".toUpperCase() + "as the Run mode is NO");
		}
   		

   		au.login(sheetName);
		log.info("Login as a CSE User");
		cp.moveToQuickLink();
		cp.clickOnCustomerSearchTab();
		cp.enterMobileNoForCustomerSearch(sheetName);
		cp.clickOnCustomer();
		ap.clickOnToggleBtn();
		op.clickOnMoreTabs();
		op.ClickOnNewOffer();
		op.createOfferonCustomer(sheetName);
		op.verifyOfferIsCreatedOnCustomer(sheetName);
		
}

}