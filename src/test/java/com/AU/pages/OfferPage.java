package com.AU.pages;

import java.io.IOException;
import java.util.Random;

import org.apache.commons.lang.UnhandledException;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.AU.commonUtilities.CommonMethods;
import com.AU.commonUtilities.ExcelOperation;
import com.AU.commonUtilities.ScreenShot;
import com.AU.listeners.TestListeners;




public class OfferPage extends TestListeners {
	

	

	
	public void navigateToMarketingTab() throws Exception {
		CommonMethods.mouseHover("marketingTab_XPATH");
		CommonMethods.highLight("marketingTab_XPATH");
	}
	
	public void clickOnOffer() throws Exception {
		CommonMethods.highLight("offer_XPATH");
		CommonMethods.Click("offer_XPATH");
	}
	
	public void clickOnNewBtn() throws Exception {
		CommonMethods.highLight("offerNewBtn_XPATH");
		CommonMethods.Click("offerNewBtn_XPATH");
		CommonMethods.Click("offers_XPATH");
		Thread.sleep(3000);
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("offerNameBox_XPATH"))).isDisplayed());
	}
	
	public void createOffer(String sheetName) throws Exception {
		CommonMethods.switchwindow();
		//Enter Offer Details
		
		//Enter Offer Name
		CommonMethods.input("offerName_XPATH", sheetName, "OfferName", 1);
		
		//Select Related Customer
		CommonMethods.Click("relatedCustomerSearch_XPATH");
		CommonMethods.Click("customer1_XPATH");
		
		//Enter CIF
		String cif=ExcelOperation.getCellData(sheetName, "CIF", 1);
		CommonMethods.sendkeys("cif_XPATH", cif);
		//CommonMethods.input("cif_XPATH", sheetName, "CIF", 1);
		
		//CommonMethods.input("offerCustomerName_XPATH", sheetName, "CustomerName", 1);
		// Enter Customer Name
				Random random = new Random();
				String r = "";
			    for(int i = 0; i < 4; i++) {
			        r += (char)(Math.random() * 26 + 97);
			    }
				String custname = ExcelOperation.getCellData(sheetName, "CustomerName", 1);
				String actualcustname = custname + r;
				// System.out.println();
				System.out.println("Actual name Entered:  " + actualcustname);
				System.out.println();
				// enter Customer Name
				//customerName.sendKeys(actualcustname);
				CommonMethods.sendkeys("offerCustomerName_XPATH", actualcustname);
				ExcelOperation.writeToExcel(sheetName, 1, 7, actualcustname);
	
		//Enter Mobile No
		String mobilenumber = CommonMethods.generateRandomMobileNumber();
		System.out.println("Actual mobile no: " + mobilenumber);
		System.out.println();
		ExcelOperation.writeToExcel(sheetName, 1, 9, mobilenumber);
				//CommonMethods.input("app_MobileNo_XPATH", mobilenumber);
		//CommonMethods.input("offerMobileNo_XPATH", sheetName,"Mobile",1);
		CommonMethods.sendkeys("offerMobileNo_XPATH", mobilenumber);
		log.info("Enter Mobile No: " + mobilenumber);
		
		//select product
		CommonMethods.selectByIndex("offerProduct_XPATH", 2);
		
		//Select Offer Rating
		CommonMethods.selectByIndex("offerRating_XPATH", 2);
		
		//Enter Offer Amount
		CommonMethods.scrollDown(500);
		// driver.findElement(By.xpath(CommonMethods.readPropertyFile("offerAmount_XPATH"))).clear();
		String offeramount=ExcelOperation.getCellData(sheetName, "OfferAmount", 1);
		CommonMethods.sendkeys("offerAmount_XPATH", offeramount);
		//CommonMethods.input("offerAmount_XPATH", sheetName, "OfferAmount", 1);
		
		//Select Status code
		CommonMethods.selectByIndex("offerStatusCode_XPATH", 2);
		
		//Select Offer date
		CommonMethods.Click("offerFromDate_XPATH");
		CommonMethods.Click("offerTillDateicon_XPATH");
		CommonMethods.Click("offerEndDate_XPATH");
		
		//Click on Save Btn
		CommonMethods.Click("saveBtn_XPATH");
		System.out.println("Click on Save Button");
	}
	
	/*public void verifyOfferIsCreated() throws InterruptedException, UnhandledException, IOException {
		Thread.sleep(5000);
		CommonMethods.switchToParentWin();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("offerCreated_XPATH"))).isDisplayed());
		CommonMethods.isClickable("offerCreated_XPATH", driver);
	}*/
	
	public  String getOfferID() throws UnhandledException, IOException, InterruptedException {
		Thread.sleep(2000);
		String expOfferID=driver.findElement(By.xpath(CommonMethods.readPropertyFile("offerId_XPATH"))).getText();
	    return expOfferID;
		
	}
	
	public  String getOfferName() throws UnhandledException, IOException, InterruptedException {
		Thread.sleep(2000);
		String expOfferName=driver.findElement(By.xpath(CommonMethods.readPropertyFile("offerN_XPATH"))).getText();
		System.out.println(expOfferName);
	    return expOfferName;
		
	}
	
	public String getCIF() throws UnhandledException, IOException {
		String actaulCIF=driver.findElement(By.xpath(CommonMethods.readPropertyFile("offerCIF_XPATH"))).getText();
		System.out.println(actaulCIF);
		return actaulCIF;
	}
	
	public String getCustomerName() throws UnhandledException, IOException {
		String actaulCustomerName=driver.findElement(By.xpath(CommonMethods.readPropertyFile("offercustN_XPATH"))).getText();
		System.out.println(actaulCustomerName);
		return actaulCustomerName;
		
	}
	
	public void editOffer() throws UnhandledException, IOException {
		CommonMethods.scrollAtBottom();
		//Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("editOffer_XPATH"))).isDisplayed());
		//CommonMethods.isClickable("editOffer_XPATH", driver);
		CommonMethods.Click("editOffer_XPATH");
		System.out.println(driver.getCurrentUrl());
		
		
	}
	
	
	//Verify edit offer page
	public void verifyEditOfferPage(String sheetName) throws Exception {
        //offer name
		String actualOfferName=driver.findElement(By.xpath(CommonMethods.readPropertyFile("offerName_XPATH"))).getAttribute("Value");
		System.out.println("Actual Offer Name is :: "+actualOfferName);
		String expectedofferName=ExcelOperation.getCellData(sheetName, "OfferName", 1);
		System.out.println("Expected OfferName ::" +expectedofferName);
		Assert.assertEquals(actualOfferName, expectedofferName, "Mismatched OfferName");
		
		//Cif
		String actualCIF=driver.findElement(By.xpath(CommonMethods.readPropertyFile("cif_XPATH"))).getAttribute("Value");
		System.out.println("Actual CIF is :: "+actualCIF);
		String expectedCIF=ExcelOperation.getCellData(sheetName, "CIF", 1);
		System.out.println("Expected OfferName ::" +expectedCIF);
		Assert.assertEquals(actualCIF, expectedCIF, "Mismatched CIF");
		
		//Customer Name
		String actualCustomerName=driver.findElement(By.xpath(CommonMethods.readPropertyFile("offerCustomerName_XPATH"))).getAttribute("Value");
		System.out.println("Actual Customer Name is :: "+actualCustomerName);
		String expectedCustomerName=ExcelOperation.getCellData(sheetName, "CustomerName", 1);
		System.out.println("Expected Customer Name ::" +expectedCustomerName);
		Assert.assertEquals(actualCustomerName, expectedCustomerName, "Mismatched Customer Name");
		
		ScreenShot.takeSnapShot("Offer Edit Page", "Pass");
	}
	
	//select status code not intrested
	public void verifyStatusCodeASNotIntrested() throws Exception {
		Thread.sleep(5000);
		//Select Status code as not intrested
		CommonMethods.selectByIndex("offerStatusCode_XPATH", 3);
		System.out.println("Not Intrested Status code Selected");
		//select reason of not Intressted
		CommonMethods.selectByIndex("reasonOfNotIntrested_XPATH", 19);
		System.out.println("Reason of not intrested Selected");
		CommonMethods.Click("saveBtn_XPATH");
		//String expectedStatusCode="Not InteresNotted";
		//String actualStatusCode=
		Thread.sleep(4000);
		CommonMethods.verifyTextOfElement("detailsStatusCode_XPATH", "Not Interested");
				
	}
	
	//select status code as rejected
	public void verifyStatusCodeASRejected() throws Exception {
		Thread.sleep(5000);
		//Select Status code as Rejected
		CommonMethods.selectByIndex("offerStatusCode_XPATH", 1);
		System.out.println("Rejected Status Code Selected");
		//select reason of rejected
		CommonMethods.selectByIndex("reasonOfRejected_XPATH", 8);
		System.out.println("Reason of Rejected Selected");
		CommonMethods.Click("saveBtn_XPATH");
		Thread.sleep(3000);
		CommonMethods.verifyTextOfElement("detailsStatusCode_XPATH", "Rejected");
	}
	
	//select status code as Converted
	public void verifyStatusCodeAsConverted() throws Exception {
		Thread.sleep(3000);
		log.info("Select status code As Converted");
	//select Status code as Converted
		CommonMethods.selectByIndex("offerStatusCode_XPATH", 0);
		System.out.println("Converted Status Code Selected");
		//Click On Save button
		CommonMethods.Click("saveBtn_XPATH");
		Thread.sleep(3000);
		//Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("detailsStatusCode_XPATH"))).isDisplayed());
		CommonMethods.verifyTextOfElement("detailsStatusCode_XPATH", "Converted");
	}
	
	//verify new lead created when status is Converted
	public void newLeadcreated() throws InterruptedException, UnhandledException, IOException {
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("detailsRelatedCustomer_XPATH"))).isDisplayed());
		CommonMethods.Click("detailsRelatedCustomer_XPATH");
		Thread.sleep(2000);
		System.out.println("Click on toggle Button");
		CommonMethods.Click("toggleBtn_XPATH");
		Thread.sleep(2000);
		CommonMethods.Click("moreTabs_XPATH");
		CommonMethods.Click("leadsAndCases_XPATH");
		Thread.sleep(3000);
		CommonMethods.Click("offerLeads_XPATH");  
		Thread.sleep(3000);
		CommonMethods.Click("offerlead1_XPATH");
		Thread.sleep(2000);
		CommonMethods.verifyTextOfElement("leadStatusCode_XPATH", "New Lead");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("leadIDOffer_XPATH"))).isDisplayed());
	    	
	}
	
	//click on more tabs
	public void clickOnMoreTabs() throws Exception {
		
		CommonMethods.Click("moreTabs_XPATH");
		log.info("Clicked on More Tabs of Customer");
		CommonMethods.Click("campainAndOfferTab_XPATH");
		CommonMethods.scrollDown(500);
		CommonMethods.ExWait("offerTitle_XPATH");
		
		
	}
	
	//click on new offer
	public void ClickOnNewOffer() throws Exception {
		CommonMethods.highLight("newOffer_XPATH");
		CommonMethods.Click("newOffer_XPATH");
		
	}
	
	
	public void createOfferonCustomer(String sheetName) throws Exception
	{
		CommonMethods.switchwindow();
		//Enter Offer Details
		
		//Enter Offer Name
		Thread.sleep(3000);
		CommonMethods.input("offerName_XPATH", sheetName, "OfferName", 1);
		log.info("Offer Name Entered:: ");
		
		
	     //select product
		Thread.sleep(3000);
		CommonMethods.selectByIndex("offerProduct_XPATH", 2);
		log.info("Offer Product Selected:: ");
		
		//Select Offer Rating
		Thread.sleep(3000);
		CommonMethods.selectByIndex("offerRating_XPATH", 2);
		log.info("Offer Rating Selected:: ");
		
		//Enter Offer Amount
		Thread.sleep(3000);
		CommonMethods.scrollDown(500);
	   String offeramount=ExcelOperation.getCellData(sheetName, "OfferAmount", 1);
		CommonMethods.sendkeys("offerAmount_XPATH", offeramount);
		log.info("Offer Amount Entered:: ");
		
		//Select Status code
		Thread.sleep(3000);
		CommonMethods.selectByIndex("offerStatusCode_XPATH", 2);
		log.info("Offer Status Code Selected:: ");
		
		//Select Offer date
		Thread.sleep(3000);
		CommonMethods.Click("offerFromDate_XPATH");
		CommonMethods.Click("offerTillDate_XPATH");
		CommonMethods.Click("selectDate_XPATH");
		//CommonMethods.Click("offerEndDate_XPATH");
		
		//Click on Save Btn
		Thread.sleep(3000);
		CommonMethods.Click("saveBtn_XPATH");
		System.out.println("Click on Save Button");
		extentInfo("Sucessfully Created Offer","");
		
	}
	
	//verify offer is created
	public void verifyOfferIsCreatedOnCustomer(String sheetName) throws Exception {
		CommonMethods.switchtoparentwindow();
		CommonMethods.scrollDown(500);
		CommonMethods.ExWait("offerTitle_XPATH");
		String actualOfferName=driver.findElement(By.xpath(CommonMethods.readPropertyFile("createdOffer_XPATH"))).getText();
		String expectedOfferName=ExcelOperation.getCellData(sheetName, "OfferName", 1);
		Assert.assertEquals(actualOfferName, expectedOfferName, "OfferName Mismatched");
	}
}
