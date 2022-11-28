package com.crm.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.CSEHomePage;
import com.AU.pages.LeadPage;

public class AttachDocumentOnLeadAttachmentTabFunctionalityTest extends SetUp {
	
	AULoginPage au=new AULoginPage();
	LeadPage lp=new LeadPage() ;
	CSEHomePage cp=new CSEHomePage();
	
	//public String sheetName = "CSELogin";
	
	
	@Test
	public void DocAttachmentOnDetailsPageTest() throws Exception {
	
		String sheetName = "DocAttachmentOnDetailsPageTest";
		if (!(CommonMethods.isTestRunnable("DocAttachmentOnDetailsPageTest",sheetName))) {

			throw new SkipException(
					"Skipping the test DocAttachmentOnDetailsPageTest as the Run mode is NO + ");
		}
		au.login(sheetName);
		log.info("Login as a CSE User");
		
		//Click ON LEad tab
		cp.clickOnLeadTab();
		
		//open DDE Stage LEad
		cp.selectDDEStageLead();
		
		//Click on toggle Button
		lp.clickOnToggleBtn();
		
		//Click on attachment tab
		cp.clickOnAttachmentTab();
		
		//verify document attach sucessfully
		cp.verifyDocumentAttached();
        
}
}