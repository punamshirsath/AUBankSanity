package com.crm.testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.commonUtilities.ExcelOperation;
import com.AU.pages.AULoginPage;
import com.AU.pages.OfferPage;


public class OfferCreationFunctionalityTest extends SetUp{
	AULoginPage au=new AULoginPage(); ;
	OfferPage op=new OfferPage();;
	
	
   
   	//Covered Offer Module  TC
   	@Test
   	public void OfferCreationTest() throws Exception {
   		
   		String sheetName = "OfferCreationTest";
   		if (!(CommonMethods.isTestRunnable("OfferCreationTest",sheetName ))) {

			throw new SkipException(
					"Skipping the test " + "ToVerifyOfferCreation".toUpperCase() + "as the Run mode is NO");
		}
   		

		au.login(sheetName);
		au.selectrole(0);
		log.info("Login as administrator");
		op.navigateToMarketingTab();
		op.clickOnOffer();
		op.clickOnNewBtn();
		//op.createOffer();
		op.createOffer(sheetName);
   		//op.verifyOfferIsCreated();
   		//Offer Id Created
   		op.getOfferID();
   		
   		//verify Offer Name
   		String actualOffername=ExcelOperation.getCellData(sheetName, "OfferName", 1);
   		String expectedoffername=op.getOfferName();
   		Assert.assertEquals(actualOffername, expectedoffername, "Offer Name Mismatched");
   		
   		//Verify CIF
   		String expectedCIF=ExcelOperation.getCellData(sheetName, "CIF", 1);
   		String actualCIF=op.getCIF();
   		Assert.assertEquals(expectedCIF, actualCIF, "CIF Mismatched");
   		
   		//verify Customer Name
   		String expectedCustName=ExcelOperation.getCellData(sheetName, "CustomerName", 1);
   		String actualCustName=op.getCustomerName();
   		Assert.assertEquals(expectedCustName, actualCustName, "CIF Mismatched");
   		
   		Thread.sleep(3000);
   		System.out.println("Offer Edit");
   		op.editOffer();
   		op.verifyEditOfferPage(sheetName);
   		op.verifyStatusCodeASNotIntrested();
   		op.editOffer();
   		op.verifyStatusCodeASRejected();
   		CommonMethods.Click("editOfferBtn_XPATH");
   		op.verifyStatusCodeAsConverted();
   		op.newLeadcreated();
		
	}
   	
  
   	
}
