package com.crm.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.LeadPage;

public class LeadPagePagginationFunctionalityTest extends SetUp{
	
	AULoginPage au=new AULoginPage();
	LeadPage lp=new LeadPage();
	
	@Test
	public void PagginationOnLeadPageTest() throws Exception {
		
		String sheetName = "PagginationOnLeadPageTest";
		
		if (!(CommonMethods.isTestRunnable("PagginationOnLeadPageTest",sheetName))) {

			throw new SkipException(
					"Skipping the test PagginationOnLeadPageTest as the Run mode is NO + ");
		}
		
		au.login(sheetName);
		log.info("Login as a CSE User");
		lp.verifyLeadListIsDisplayedInViewCategory();
		lp.verifyOrderBy();
		lp.verifyPaginationDropdown();
		lp.verifypaginationGoToTextBox();
		

}
}
