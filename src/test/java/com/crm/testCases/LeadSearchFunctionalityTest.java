package com.crm.testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.CustomerPage;
import com.AU.pages.LeadSearchPage;



public class LeadSearchFunctionalityTest extends SetUp {
    
	AULoginPage au=new AULoginPage();
	CustomerPage cp=new CustomerPage();
	LeadSearchPage lp=new LeadSearchPage();
	
	
	
	
	
	@Test
	public void LeadSearchTest() throws Exception{
		
		String sheetName = "LeadSearchTest";
		
		
		if (!(CommonMethods.isTestRunnable("LeadSearchTest", sheetName))) {

			throw new SkipException(
					"Skipping the test " + "ToVerifyLeadSearch".toUpperCase() + "as the Run mode is NO");
		}
 
		au.login(sheetName);
		log.info("Login as a CSE User");
		cp.moveToQuickLink();
		lp.clickOnLeadSearchTab();
		String actualleadID=lp.verifyLeadSearchByLeadID(sheetName);
		Thread.sleep(5000);
		System.out.println("Actual Lead ID Entered on lead Search Page: " + actualleadID);
		System.out.println();
		String expLeadID = lp.getleadID();
		System.out.println("Expected LeadID Fetched on Lead Search Page: " + expLeadID);
		Assert.assertEquals(actualleadID, expLeadID, "Lead ID Mismatched");
		lp.isLeadListingDisplayed();
}
}
