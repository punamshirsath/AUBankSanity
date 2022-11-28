package com.crm.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.ActivityPage;
import com.AU.pages.CustomerPage;



public class TabVisibleOnCustomerFunctionalityTest extends SetUp{
	
	AULoginPage au=new AULoginPage();;
	//public String sheetName = "CSELogin";
	CustomerPage cp=new CustomerPage();
	ActivityPage ap=new ActivityPage();
	
	
	@Test(priority=1)
	public void TabVisibleOnCustomer() throws Exception {
		
		String sheetName = "TabVisibleOnCustomer";
		
		if (!(CommonMethods.isTestRunnable("TabVisibleOnCustomer", sheetName))) {

			throw new SkipException(
					"Skipping the test " + "TabVisibleOnCustomer".toUpperCase() + "as the Run mode is NO");
		}
		au.login(sheetName);
		log.info("Login as a CSE User");
		ap.clickOnRecentItemsOfCustomer();
		ap.clickOnToggleBtn();
		cp.verifyTabsVisibleOnCustomer();
		
	}

}
