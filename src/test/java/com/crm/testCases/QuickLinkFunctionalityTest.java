package com.crm.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.QuickLinkPage;




public class QuickLinkFunctionalityTest extends SetUp {
	
	AULoginPage au=new AULoginPage();;
	QuickLinkPage qp=new QuickLinkPage();;
	
	
	
	
	@Test
	public void QuickLinksTest() throws Exception {
		
		String sheetName = "QuickLinksTest";
		if (!(CommonMethods.isTestRunnable("QuickLinksTest", sheetName))) {

			throw new SkipException(
					"Skipping the test " + "ToverifyQuickLinks".toUpperCase() + "as the Run mode is NO");
		}
		au.login(sheetName);
		log.info("Login as a CSE User");
		qp.CSEUserAbleToClickOnQucikLinks();
		log.info("Quick Link Tab Is Clickable");
		qp.verifyQuickLinksDisplay();
		qp.verifyLeadSearchFields();
		
	}
	
	
	


}
