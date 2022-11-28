package com.crm.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.AssetFlowPage;
import com.AU.pages.CSEHomePage;
import com.AU.pages.LeadPage;



public class AssetLeadCreationFunctionalityTest extends SetUp{
	
	AULoginPage au=new AULoginPage();
    CSEHomePage cp=new CSEHomePage();
	AssetFlowPage ap=new AssetFlowPage();
	LeadPage lp=new LeadPage();
	
 
	

	@Test
	public void AssetLeadCreationFlowTest() throws Exception {
		
		String sheetName = "AssetLeadCreationFlowTest";
		
		if (!(CommonMethods.isTestRunnable("AssetLeadCreationFlowTest",sheetName))) {

			throw new SkipException(
					"Skipping the test " + "ToVerifyAssetLeadCreation".toUpperCase() + "as the Run mode is NO");
		}
		au.login(sheetName);
		log.info("Login as a CSE User");
		cp.clickOnLeadTab();
		
		//Click on asset flow
		ap.clickOnAssetFlow();
		
		//enter key information
		ap.enterKeyInformationForAsset();
		
		//ap.enterNewLeadDetailsForAssetFlow(sheetName);
		lp.clickOnToggleBtn();
  		lp.editLead();
  		
  		///enter all details for document collection stage
  		ap.DocCollectionForAssetFlow(sheetName);
  		//lp.fillDataAtDocCollectedStage();
  		Thread.sleep(3000);
  		lp.clickOnToggleBtn();
  		lp.editLead();
  		
  		ap.verifyLeadHandOff();
		
		Thread.sleep(2000);
		
		
	}
}
