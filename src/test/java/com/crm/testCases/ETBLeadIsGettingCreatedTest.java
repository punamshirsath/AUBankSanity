package com.crm.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.CSEHomePage;
import com.AU.pages.LeadPage;


public class ETBLeadIsGettingCreatedTest extends SetUp {

	AULoginPage au=new AULoginPage();
	 LeadPage lp=new LeadPage();
	CSEHomePage cp=new CSEHomePage();

	@Test
	public void ETBLeadCreationTest() throws Exception {
		
		String sheetName = "ETBLeadCreationTest";
		String sheetName1 = "BMLogin";
		String sheetName2="BOLogin";
		String sheetName3="DVULogin";
		
		if (!(CommonMethods.isTestRunnable("ETBLeadCreationTest", sheetName))) {

			throw new SkipException(
					"Skipping the test " + "ETBLeadCreationTest".toUpperCase() + "as the Run mode is NO");
		}
		
		au.login(sheetName);
		log.info("Login as a CSE User");
		
        
        //open ETB
        lp.openleadPage();
        
        //Select ETB LEad
        lp.searchETBLead(sheetName);
       //lp.clickOnIgnoreandCreate();
       // lp.clickOnIgnoreandUpdate();
        
      //edit lead
      	lp.clickOnToggleBtn();
      	lp.editLead();
      		
      		///enter all details for document collection stage
      		lp.fillDataAtDocCollectedStage(sheetName);
      		Thread.sleep(3000);
      		//lp.clickOnIgnoreandCreate();
      		Thread.sleep(3000);
      		lp.clickOnToggleBtn();
      		Thread.sleep(3000);
      		au.Logout();
      		
      		
      		//login as a Branch Manager
      		au.login(sheetName1);
      		log.info("Login as a Branch Manager User");
      		lp.editLeadAtBMStage();
      		Thread.sleep(3000);
      		au.Logout();
      		
      		
      		//login AS Back office
      		au.login(sheetName2);
      		log.info("Login as a Back Office User");
      		lp.editLeadAtBOStage();
      		Thread.sleep(2000);
      		au.Logout();
      		
      		
      		//login as DVu user
      		au.login(sheetName3);
      		log.info("Login as a Document Verification Unit");
      		lp.editLeadAtDVUStage(sheetName);
      		Thread.sleep(2000);
      		lp.clickOnToggleBtn();
      		Thread.sleep(4000);
      		String typeofCustomer=driver.findElement(By.xpath(CommonMethods.readPropertyFile("TypeOfCustomer_XPATH"))).getText();
      		Assert.assertEquals("Existing Customer", typeofCustomer,"Customer Mismatched");
      		//lp.VerifyHistoryTab();
      		au.Logout();
      	}


}