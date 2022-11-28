package com.crm.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.LeadPage;



public class DataPresenterEDSFunctionalityTest extends SetUp {
	
	AULoginPage au=new AULoginPage();;
	LeadPage lp=new LeadPage();
	//public String sheetName = "CSELogin";
	
	
	@Test
	public void DataPresenterEDSTest() throws Exception {
		
		String sheetName = "DataPresenterEDSTest";
		
		if (!(CommonMethods.isTestRunnable("DataPresenterEDSTest", sheetName ))) {

			throw new SkipException(
					"Skipping the test " + "ToverifyDataPresenterEDS".toUpperCase() + "as the Run mode is NO");
		}
		au.login(sheetName);
		log.info("Login as a CSE User");
		lp.openleadPage();
		lp.enterMobileNoForDataPresenter(sheetName);
		lp.verifyDataPresenterEDSIsWorking();
		

}
}