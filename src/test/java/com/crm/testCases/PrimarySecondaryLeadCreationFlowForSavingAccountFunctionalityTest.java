package com.crm.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.commonUtilities.ExcelOperation;
import com.AU.pages.AULoginPage;
import com.AU.pages.AssetFlowPage;
import com.AU.pages.CSEHomePage;
import com.AU.pages.LeadPage;
import com.AU.pages.PrimarySecondaryLeadPage;


public class PrimarySecondaryLeadCreationFlowForSavingAccountFunctionalityTest extends SetUp {
	
	AULoginPage au=new AULoginPage();;
	LeadPage lp=new LeadPage();
	AssetFlowPage ap=new AssetFlowPage();
	CSEHomePage cp=new CSEHomePage();;
	PrimarySecondaryLeadPage pp=new PrimarySecondaryLeadPage();
	
	
	
	
	
	@Test
	public void PriSecLeadCreationFlowTest() throws Exception {
		
		String sheetName = "PriSecLeadCreationFlowTest";
		String sheetName1="BMLogin";
		String sheetName2="BOLogin";
		String sheetName3="DVULogin";
		String sheetName4="CHTMLogin";
		String primaryDetails="PrimarySecondaryLeadDetails";
		String secondaryHolderDetails="SecondaryHolderDetails";
		
		if (!(CommonMethods.isTestRunnable("PriSecLeadCreationFlowTest",sheetName ))) {

			throw new SkipException(
					"Skipping the test " + "PrimarySecondaryLeadCreation".toUpperCase() + "as the Run mode is NO");
		}
		
		au.login(sheetName);
		log.info("Login as a CSE User");
		
		//open new lead page
		lp.clickOnLeadsTab();
		
		//Click on liability flow
		lp.clickOnLiabilityFlow();
				 
		//enter new lead details
		lp.enterNewLeadDetails(sheetName);
				
		Thread.sleep(4000);
				
		//edit lead
		lp.clickOnToggleBtn();
	    lp.editLead();
	
			
		///enter all details for document collection stage
		pp.enterDetailsOfDocCollectionForPrimarySecondaryLead(sheetName);
		
		pp.AddSecondaryLead();
		
		pp.enterSecondaryHolderDetails(sheetName);
		pp.VerifySecondaryNewLeadCreated();
		Thread.sleep(2000);
		//edit lead
		lp.editLead();
		pp.editSecondaryLeadOfDocCollected();
		au.Logout();
		
		//login as Branch Manager
		au.login(sheetName1);
		pp.searchLeadInBMView();
		pp.OpenSecondaryLead();
		lp.editLead();
		pp.editSecondaryLeadOfBMRecommended();
		driver.close();
		CommonMethods.switchtoparentwindow();
		Thread.sleep(3000);
		lp.clickOnToggleBtn();
		lp.editLead();
		
		pp.editPrimaryLeadOfBMRecommended();
		au.Logout();
		
		 
		//login as back office
		 //CommonMethods.switchtoparentwindow();
		au.login(sheetName2);
		pp.sesrchLeadInBOView();
		pp.OpenSecondaryLead();
		//lp.clickOnToggleBtn();
		lp.editLead();
		pp.editSecondaryLeadOfSentToDVUStage();
		driver.close();
		CommonMethods.switchtoparentwindow();
		Thread.sleep(3000);
		lp.clickOnToggleBtn();
		lp.editLead();
		pp.editPrimaryLeadForSentToDVU();
		au.Logout();
		
		
		//login as DVU
	/*	au.login(sheetName3);
		pp.searchLeadInDVUView();
		pp.OpenSecondaryLead();
		pp.clickOnMobilePDF();
		Thread.sleep(3000);
		pp.OpenSecondaryLead();
		lp.editLead();
		Thread.sleep(3000);
		String pan = ExcelOperation.getCellData(sheetName, "Sec PAN Justification", 1);
		CommonMethods.sendkeys("panJustification_XPATH", pan);
		CommonMethods.scrollAtBottom();
		CommonMethods.Click("saveBtn_XPATH");
		CommonMethods.ExWait("StatusCode_XPATH");
		String statusCode3 = driver.findElement(By.xpath(CommonMethods.readPropertyFile("StatusCode_XPATH"))).getText();
		System.out.println(statusCode3);
		Thread.sleep(3000);
		Assert.assertEquals("Account Opened", statusCode3,"statuscode mismatch");
		CommonMethods.switchtoparentwindow();
		pp.editprimaryLeadAtDVU(sheetName);*/
		
}
}
