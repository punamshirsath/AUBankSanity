package com.crm.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.AssetFlowPage;
import com.AU.pages.CSEHomePage;
import com.AU.pages.LeadPage;


public class AssetLeadCreationForCCODProductsFunctionalityTest extends SetUp{
	
	AULoginPage au=new AULoginPage() ;
	LeadPage lp=new LeadPage();
	AssetFlowPage ap=new AssetFlowPage();
	CSEHomePage cp=new CSEHomePage();

	
	
	
	
	@Test
	public void LeadCreationForCCODProductsTest() throws Exception {
		
		String sheetName = "LeadCreationForCCODProductsTest";
		String sheetName1="BMLogin";
		String sheetName2="BOLogin";
		String sheetName3="DVULogin";
		String sheetName4="CHTMLogin";
		if (!(CommonMethods.isTestRunnable("LeadCreationForCCODProductsTest", sheetName ))) {

			throw new SkipException(
					"Skipping the test " + "LeadCreationForCCODProduct".toUpperCase() + "as the Run mode is NO");
		}
		/*au.login(sheetName);
		log.info("Login as a CSE User");
		
		//Click on asset flow
		ap.clickOnAssetFlow();
		ap.enterKeyInformationForAssetCCODProduct();
		ap.enterNewLeadDetailsForCCODProducts(sheetName);
		ap.searchCCODLeadInView();
		Thread.sleep(2000);
		lp.clickOnToggleBtn();
		lp.editLead();
		lp.fillDataAtDocCollectedStage(sheetName);
	
		au.Logout();*/
		
		//Login as Cluster Head/Terriority Manager
		au.login(sheetName4);
		ap.searchCCODLeadInCHTMView();
		lp.clickOnToggleBtn();
		lp.editLead();
		ap.editLeadAtCHTMStage();
		au.Logout();
		
		//login as Back office
		au.login(sheetName2);
		ap.searchLeadCCODLeadInBOView();
		au.Logout();
		
		//login DVU
		au.login(sheetName3);
		ap.searchCCODLeadInDVUView();
		Thread.sleep(3000);
		
		
		

}
}