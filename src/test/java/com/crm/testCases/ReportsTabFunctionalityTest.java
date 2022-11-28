package com.crm.testCases;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.ReportsPage;




public class ReportsTabFunctionalityTest extends SetUp{

	AULoginPage au=new AULoginPage();
	ReportsPage rp=new ReportsPage();

	
	
	@Test
	public void ReportsTabTest() throws Exception {
		String sheetName = "ReportsTabTest";
		
		if (!(CommonMethods.isTestRunnable("ReportsTabTest",sheetName))) {

			throw new SkipException(
					"Skipping the test " + "ToVerifyLeadCreationPage".toUpperCase() + "as the Run mode is NO");
		}
	
		au.login(sheetName);
		log.info("Login as a Branch Manager");
		rp.navigateToReportsTab();
		rp.VerifylistOfReportsDisplay();
		rp.verifyReportsOpenProperly();
	//	rp.verifyExecuteAllRecordsDisplayed();
		rp.VerifyFieldsDisplayed();
	}
	
	
	
	
	
	
}
