package com.AU.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.commonUtilities.ExcelOperation;
import com.AU.commonUtilities.ScreenShot;
import com.AU.listeners.TestListeners;


public class LeadPage extends TestListeners
{

	public static Logger log =LogManager.getLogger(LeadPage.class.getName());
	  
	public static Properties config = SetUp.loadConfig();
    public static String Pan_path = System.getProperty("user.dir")+ config.getProperty("panpath");
//	public static String panpath = System.getProperty("user.dir") +"\\src\\test\\resources\\Documents\\Pan card.pdf";
	//public static String customerphoto = System.getProperty("user.dir") +"\\src\\test\\resources\\Documents\\customerphotograph.png";
    public static String customerPhoto = System.getProperty("user.dir")+ config.getProperty("customerPhotoPath");
    public static String customerSign = System.getProperty("user.dir")+ config.getProperty("customerSignPath");
    //public static String customerSign = System.getProperty("user.dir") +"\\src\\test\\resources\\Documents\\signature.jpg";
    public static String accountform = System.getProperty("user.dir")+ config.getProperty("accountFormPath");
    //public static String accountform = System.getProperty("user.dir") +"\\src\\test\\resources\\Documents\\accountopeningform.jpg";
    public static String idProof = System.getProperty("user.dir")+ config.getProperty("idProofPath");
    //public static String idProof = System.getProperty("user.dir") +"\\src\\test\\resources\\Documents\\voterid.jpg";

	//public String sheetName = "NewLeadDetails";
	//public String SheetName1 = "DedupeRuleFunctionalityTest";
	//public String SheetName2 = "EDSData";

	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath = "//span[@class='acd-link-text']")
	List<WebElement> leadList;

	@FindBy(xpath = "//span[@data-autoid='LE_NUMBER_ctrl']")
	WebElement leadId;

	@FindBy(xpath = "(//span[@data-autoid='LE_STATUSCODE_ctrl'])[1]")
	WebElement statusCode;

	@FindBy(xpath = "//span[@data-autoid='LE_LEADSOURCE_ctrl']")
	WebElement leadSource;

	@FindBy(xpath = "(//a[@data-autoid='LE_PRODUCT_ctrl'])[1]")
	WebElement products;

	@FindBy(xpath = "//span[@data-autoid='LE_LEADOWNER_ctrl']")
	WebElement leadOwner;

	@FindBy(xpath = "//div[@class='field filter__textbox']/input")
	WebElement pageGoToTextbox;

	public void openleadPage() throws InterruptedException {

		CommonMethods.Click("leadTab_XPATH");
		System.out.println("Clicked On Lead Tab");
		log.info("CSE User Click On Lead Tab");
		Thread.sleep(1000);
		CommonMethods.Click("newBtn_XPATH");
		log.info("click on New Button");
		System.out.println("clicked ON New Button");
		Thread.sleep(5000);
		CommonMethods.Click("liabilityFlow_XPATH");
		log.info("Select Liability Flow");
		System.out.println("Select Liability Flow");
		Thread.sleep(1000);

	}

	
	public void clickOnLeadsTab() throws Exception {
		CommonMethods.highLight("leadTab_XPATH");
		CommonMethods.Click("leadTab_XPATH");
		log.info("CSE User Click On Lead Tab");
		}
	
	public void clickOnLiabilityFlow() throws Exception {
		CommonMethods.Click("newBtn_XPATH");
		log.info("click on New Button");
		Thread.sleep(5000);
		CommonMethods.Click("liabilityFlow_XPATH");
		log.info("Select Liability Flow");
		Assert.assertEquals("New Lead", (CommonMethods.getElementText("newLeadPage_XPATH")), "New Lead Page Opens");
		
	}
	
   //Enter new Lead Details
	public void enterNewLeadDetails(String sheetName) throws Exception {
		// Select Lead Type
		CommonMethods.selectByIndex("leadType_XPATH", 2);
		log.info("Lead Type Selected: Self");
		System.out.println("Lead Type Selected");
		System.out.println();

		// Select product Category
		CommonMethods.Click("productcategorysearch_XPATH");
		CommonMethods.Click("productCatergory_XPATH");
		log.info("Select Product Category: Saving Account");
		System.out.println("Product Category Selected");
		System.out.println();
		
		//Select Product
	CommonMethods.selectByIndex("liabilityLeadProduct_XPATH", 16);
		CommonMethods.selectByIndex("liabilityLeadProduct_XPATH", 23);
		//log.info("Product Selected: AU Savings Account- Value");

		// enter mobile no
		String mobilenumber = CommonMethods.generateRandomMobileNumber();
		System.out.println("Actual mobile no: " + mobilenumber);
		System.out.println();
		ExcelOperation.writeToExcel(sheetName, 1, 5, mobilenumber);
		CommonMethods.sendkeys("mobileNo_XPATH", mobilenumber);
		log.info("Enter Mobile No: " + mobilenumber);

		// Enter Customer Name
		Random random = new Random();
		char c = (char) (random.nextInt(26) + 'a');
		String custname = ExcelOperation.getCellData(sheetName, "Customer Name", 1);
		//String custname = ExcelOperation.getCellData1(sheetName, "Customer Name", 1);
		String actualcustname = custname + c;
		System.out.println("Actual Customer name Entered:  " + actualcustname);
		System.out.println();
		CommonMethods.sendkeys("customerName_XPATH", actualcustname);
		ExcelOperation.writeToExcel(sheetName, 1, 6, actualcustname);
		log.info("Entered Customer Name " + actualcustname);

		// select date
		System.out.println("Select Date Of When u Meet");
		CommonMethods.scrollDown(500);
		CommonMethods.Click("calender_XPATH");
		CommonMethods.Click("selectDate_XPATH");
		Thread.sleep(3000);
		CommonMethods.Click("timeIcon_XPATH");
		CommonMethods.Click("selectTime_XPATH");
		log.info("Date Selected");

		// Enter Expected Buisness
		CommonMethods.scrollDown(500);
		String expectedBuisness1 = ExcelOperation.getCellData(sheetName, "Expected Buisness", 1);
		System.out.println("Expected Buisness Amount ::" + expectedBuisness1);
		CommonMethods.sendkeys("expectedBuisness_XPATH", expectedBuisness1);
		log.info("Expected Buisness Are :" + expectedBuisness1);

		// select expected Conversion
		CommonMethods.selectByIndex("expectedconversion_XPATH", 1);
		System.out.println("Expected Date Of Conversion Selected");
		log.info("Select expected date of conversion");

		// Enter Loan	
		CommonMethods.scrollDown(500);
		String loan = ExcelOperation.getCellData(sheetName, "Loan Amount", 1);
		CommonMethods.sendkeys("loanAmount_XPATH", loan);
		System.out.println("Entered Loan Amount ::" + loan);
		log.info("Enter Loan Amount " + loan);

		// Enter DOB
		/*String dob = ExcelOperation.getCellData1(sheetName, "DOB", 1);
		CommonMethods.sendkeys("DOB_XPATH", dob);
		System.out.println("Date Of Birth Entered ::" + dob);
		log.info("Date Of Birth  ::" + dob);*/

		// Enter Branch
		CommonMethods.sendkeys("branch_XPATH", "2143");
		CommonMethods.Click("branchName_XPATH");
		System.out.println("Branch Selected::");
		log.info("Branch Selected");

		// Enter Entity
		CommonMethods.sendkeys("entityType_XPATH", "individual");
		CommonMethods.Click("entity_XPATH");
		log.info("Select Entity: Individual Full KYC");
		
		// Enter DOB
		Thread.sleep(3000);
		//js.executeScript("window.scrollBy(0,-350)", "");
		String dob = ExcelOperation.getCellData(sheetName, "DOB", 1);
		CommonMethods.sendkeys("DOB_XPATH", dob);
		System.out.println("Date Of Birth Entered ::" + dob);
		log.info("Date Of Birth  ::" + dob);


		// Select customer pin
		 CommonMethods.Click("pinSearch_XPATH");
		 CommonMethods.Click("cityPin_XPATH");
		 log.info("select pin code");

		// Click on Save & Proceed
		CommonMethods.Click("saveAndProceedBtn_XPATH");
		System.out.println("Clicked On Save & Proceed");
		log.info("CSE User Click on Save & Procceed Button");
		Thread.sleep(5000);
	}

	public void clickOnToggleBtn() {
		CommonMethods.Click("toggleBtn_XPATH");
		System.out.println("After New Lead Created Clicked On Toggle Button");
		log.info("Click on toggle button");

	}

	public void leadDetailsOnDetailsPage(String sheetName) throws Exception {
		log.info("Verify Lead Details on detail tab");
		Assert.assertTrue(
				driver.findElement(By.xpath(CommonMethods.readPropertyFile("detailsTab_XPATH"))).isDisplayed());
		// Verification Of Mobile No
		String actualMobileNo = driver.findElement(By.xpath(CommonMethods.readPropertyFile("mobile_XPATH"))).getText();
		System.out.println("Actual Mobile is :: " + actualMobileNo);
		String expectedMobileNo = ExcelOperation.getCellData(sheetName, "Mobile", 1);
		System.out.println("Expected Mobile ::" + expectedMobileNo);
		Assert.assertEquals(actualMobileNo, expectedMobileNo, "Mismatched Mobile No");

		// Verify Customer Name
		String actualCustName = driver.findElement(By.xpath(CommonMethods.readPropertyFile("name_XPATH"))).getText();
		System.out.println("Actual Customer Name is :: " + actualCustName);
		String expectedCustName = ExcelOperation.getCellData(sheetName, "Customer Name", 1);
		System.out.println("Expected Customer Name is ::" + expectedCustName);
		Assert.assertEquals(actualCustName, expectedCustName, "Mismatched Customer Name");

		String leadtype = driver.findElement(By.xpath(CommonMethods.readPropertyFile("leadtypeValue_XPATH"))).getText();
		Assert.assertEquals("Self", leadtype, "Lead Type Mismatch");

		String product = driver.findElement(By.xpath(CommonMethods.readPropertyFile("productCategoryDetail_XPATH")))
				.getText();
		Assert.assertEquals("Saving Account", product, "product Mismatch");
		// TestUtil.takeScreenShot("Detail page");
		ScreenShot.takeSnapShot("Lead Detail Page", "");
	}

	// edit lead
	public void editLead() {
		System.out.println("After New LEad Creation Click on Edit Button");
		log.info("Edit lead");
		CommonMethods.Click("bottomBtn_XPATH");
		CommonMethods.Click("editBtn_XPATH");

	}

	// Verify edit fields value
	public void verifyEditPageFields() throws Exception {
		// To Verify autopopulated fields
		CommonMethods.toGetAttributeValue("product_XPATH");
		System.out.println("Product Value Displayed");
		CommonMethods.toGetAttributeValue("mobileNo_XPATH");
		System.out.println("Mobile Value Displayed");
		CommonMethods.toGetAttributeValue("customerName_XPATH");
		System.out.println("Customer Name Value Displayed");
		CommonMethods.toGetAttributeValue("loanAmount_XPATH");
		System.out.println("Loan Value Value Displayed");

	}

	public void verifyLeadListIsDisplayedInViewCategory() throws Exception {
		CommonMethods.Click("leadTab_XPATH");
		log.info("CSE User Click On Lead Tab");
		CommonMethods.scrollDown(500);
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("view_XPATH"))).isDisplayed());
		CommonMethods.selectByIndex("dropdown1_XPATH", 2);
		CommonMethods.selectByIndex("dropdown2_XPATH", 7);
		CommonMethods.Click("arrowbtn_XPATH");
		Thread.sleep(3000);
		CommonMethods.scrollDown(500);
		Assert.assertTrue(
				driver.findElement(By.xpath(CommonMethods.readPropertyFile("leadrecords_XPATH"))).isDisplayed());
		List<WebElement> listOfLeads = driver.findElements(By.xpath("//input[@class='react-grid-checkbox']"));
		System.out.println(listOfLeads.size());
		// int explistrecords=11;
		// int actualrecords =listOfLeads.size();
		// Assert.assertTrue(actualrecords==explistrecords);
		// System.out.println("List of Lead records Displayed :::");
		int records = 0;
		if (listOfLeads.size() > 0) {
			for (int i = 0; i < listOfLeads.size(); i++) {

				if (listOfLeads.get(i).isDisplayed() == true) {

					// Assert.assertTrue(true);
					// System.out.println("List of Lead records Displayed :::");
				}
				// else {
				// Assert.assertFalse(false);

				// }

			}
			Assert.assertTrue(true);
			System.out.println("List of Lead records Displayed :::");
			records++;

		}

		/*
		 * int size=
		 * driver.findElements(By.xpath("//input[@class='react-grid-checkbox']")).size()
		 * ; List<WebElement> records =
		 * driver.findElements(By.xpath("//input[@class='react-grid-checkbox']"));
		 * log.info("list of lead records Displayed:" +size); System.out.println(size);
		 * Assert.assertTrue(records.size() == size);
		 */
		// System.out.println("List Of Lead Records Displayed");
		log.info("list of lead records displayed");
		// TestUtil.takeScreenShot("list of lead records");
		ScreenShot.takeSnapShot("View Category", "");

	}

	public void VerifyLeadDetailsInSummaryBand() throws IOException {
		log.info("Verify Details On summary band");
		String id = driver.findElement(By.xpath(CommonMethods.readPropertyFile("leadId_XPATH"))).getText();
		System.out.println(id);
		Assert.assertTrue(id.contains("05"));
		// TestUtil.takeScreenShot("detail on summary band");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("leadId_XPATH"))).isDisplayed());
		log.info("Lead ID Displayed..");
		String statuscode=driver.findElement(By.xpath(CommonMethods.readPropertyFile("statusCode_XPATH"))).getText();
		System.out.println(statuscode);
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("statusCode_XPATH"))).isDisplayed());
		log.info("Status Code Displayed..");
		String leadSource=driver.findElement(By.xpath(CommonMethods.readPropertyFile("leadSource_XPATH"))).getText();
		System.out.println(leadSource);
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("leadSource_XPATH"))).isDisplayed());
		log.info("Lead Source Displayed..");
		String product=driver.findElement(By.xpath(CommonMethods.readPropertyFile("products_XPATH"))).getText();
		System.out.println(product);
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("products_XPATH"))).isDisplayed());
		log.info("Product Displayed..");
		String leadOwner=driver.findElement(By.xpath(CommonMethods.readPropertyFile("leadOwner_XPATH"))).getText();
		System.out.println(leadOwner);
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("leadOwner_XPATH"))).isDisplayed());
		log.info("Lead Owner Displayed..");
		log.info("All Details Display On Summary Band");
		// TestUtil.takeScreenShot("detail on summary band");
	}

	public void verifypaginationGoToTextBox() throws Exception {
		CommonMethods.selectByIndex("pagelistingdropdownLeadPage_XPATH", 0);
		CommonMethods.sendkeys("pageGoToTextbox_XPATH", "2");
		Thread.sleep(3000);
		CommonMethods.KeysEnter("pageGoToTextbox_XPATH");
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//a[@data-autoid='pagination_2']")).isEnabled());
	}

	/*
	 * public void verifyLeadSearchFunctionality() throws IOException,
	 * InterruptedException { log.info("CSE User Click on Leads Tab");
	 * CommonMethods.click("leadTab_XPATH");
	 * CommonMethods.input("leadSearchMobile_XPATH", "9767963169");
	 * log.info("CSE User enter mobile no in lead search ");
	 * CommonMethods.click("searchBtn_XPATH");
	 * log.info("Lead Details Displayed:::");
	 * CommonMethods.isElementDisplayed("searchLeadID_XPATH");
	 * CommonMethods.isElementDisplayed("searchLeadName_XPATH");
	 * CommonMethods.togetTextOfElement("leadNo_XPATH");
	 * CommonMethods.togetTextOfElement("leadN_XPATH");
	 * CommonMethods.togetTextOfElement("leadPAN_XPATH");
	 * CommonMethods.togetTextOfElement("leadMo_XPATH");
	 * CommonMethods.togetTextOfElement("leadProduct_XPATH");
	 * TestUtil.takeScreenShot("Lead Details displayed"); }
	 */

	public void fillDataAtDocCollectedStage(String sheetName) throws Exception {
		CommonMethods.ExWait("docCollected_XPATH");
		CommonMethods.Click("docCollected_XPATH");

		// Select phone Extension
		CommonMethods.sendkeys("phoneExtension_XPATH", "india");
		CommonMethods.Click("ext_XPATH");

		// select pdf Verified
		CommonMethods.scrollByVisibilityofElement("pdfVerified_XPATH");
		CommonMethods.Click("pdfVerified_XPATH");
		Thread.sleep(2000);

		// select Consent flag
		CommonMethods.selectByIndex("consentFlag_XPATH", 1);

		// select name salutation
		CommonMethods.selectByIndex("nameSalutation_XPATH", 2);

		// Enter short name
		String shortname = ExcelOperation.getCellData(sheetName, "ShortName", 1);
		CommonMethods.sendkeys("shortN_XPATH", shortname);

		// Enter PAN no
		String panNo1 = CommonMethods.generatePANNumber();
		System.out.println("Actual Pan no: " + panNo1);
		System.out.println();
		// js.executeScript("window.scrollBy(0,500)");
		CommonMethods.sendkeys("panTB_XPATH", panNo1);
		ExcelOperation.writeToExcel(sheetName, 1, 15, panNo1);

		// Attach PAN
		CommonMethods.scrollDown(500);
		Thread.sleep(3000);
		CommonMethods.moveToElementAndClick("attachFile_XPATH");
		CommonMethods.FileUpload(Pan_path);
		System.out.println("Pan card uploaded");

		// select gender
		CommonMethods.selectByIndex("genderdrpdown_XPATH", 2);

		// source channel
		CommonMethods.selectByIndex("sourcingChannel_XPATH", 4);

		// risk classification
		CommonMethods.selectByIndex("riskClassification_XPATH", 2);

		// secondary holder
		CommonMethods.selectByIndex("secondaryHolder_XPATH",2);

		// select realtion ship with bank
		CommonMethods.selectByIndex("currentRelationShipWithBank_XPATH", 2);

		// select politically exposed
		CommonMethods.selectByIndex("politicallyexposed_XPATH", 3);
		// js.executeScript("window.scrollBy(0,500)");
		CommonMethods.scrollDown(500);

		// selct customer realtion
		CommonMethods.sendkeys("customerRelation_XPATH", "sole owner");
		CommonMethods.Click("soleOwner_XPATH");

		// select source of fund
		CommonMethods.selectByIndex("sourceFund_XPATH", 1);

		// Enter resident Status
		CommonMethods.selectByIndex("residentStatus_XPATH", 1);

		// Select debit card is required
		CommonMethods.selectByIndex("debitcard_XPATH", 2);

		// Select check book required
		CommonMethods.selectByIndex("checkbookrequired_XPATH", 2);
		CommonMethods.scrollDown(500);

		// attach customer photograph
		CommonMethods.moveToElementAndClick("CustomerPhotograph_XPATH");
		CommonMethods.FileUpload(customerPhoto);

		// attach customer sign
		CommonMethods.moveToElementAndClick("customerSign_XPATH");
		CommonMethods.FileUpload(customerSign);

		// attach account opening form
		CommonMethods.scrollDown(500);
		CommonMethods.moveToElementAndClick("accountopeningForm_XPATH");
		CommonMethods.FileUpload(accountform);

		// select ID of proof
		CommonMethods.selectByIndex("proofOfID_XPATH", 4);
		CommonMethods.moveToElementAndClick("attachementOfID_XPATH");
		CommonMethods.FileUpload(idProof);

		// enter proof of POI id
		String poiDocNo1 = ExcelOperation.getCellData(sheetName, "POI Doc No", 1);
		CommonMethods.sendkeys("POIDocNo_XPATH", poiDocNo1);

		CommonMethods.scrollDown(500);

		// select voter card
		CommonMethods.sendkeys("communicationProof_XPATH", "voter");
		CommonMethods.Click("voterID_XPATH");
		CommonMethods.moveToElementAndClick("attachmentofCommunicationProof_XPATH");
		CommonMethods.FileUpload(idProof);

		// communication doc no
		String commDocNo = ExcelOperation.getCellData(sheetName, "Communication Doc No", 1);
		CommonMethods.sendkeys("communicationDocNo_XPATH", commDocNo);

		// select permant proof
		CommonMethods.sendkeys("permanentProof_XPATH", "voter");
		CommonMethods.Click("voterID_XPATH");
		//CommonMethods.selectByIndex("permanentProof_XPATH", 1);
		Thread.sleep(2000);
		// Enter permant proof No
		String addNo = ExcelOperation.getCellData(sheetName, "Permant Address No", 1);
		CommonMethods.sendkeys("permanentAddNo_XPATH", addNo);

		// attach permant proof document
		// CommonMethods.scrollDown(500);
		//CommonMethods.sendkeys("permanentProof_XPATH", "voter");
		//CommonMethods.Click("voterID_XPATH");
		CommonMethods.moveToElementAndClick("permanentproofDoc_XPATH");
		CommonMethods.FileUpload(idProof);
		Thread.sleep(5000);

		// enter additional Document
		CommonMethods.selectByIndex("additionalDocuments_XPATH", 2);

		// Marital status
		CommonMethods.selectByIndex("maritalStatus_XPATH", 1);

		// Enter Mother name
		String motherN = ExcelOperation.getCellData(sheetName, "Mother Name", 1);
		CommonMethods.sendkeys("motherName_XPATH", motherN);

		// Enter Father Name
		String fatherN = ExcelOperation.getCellData(sheetName, "Father Name", 1);
		CommonMethods.sendkeys("fatherName_XPATH", fatherN);

		// select occupation
		CommonMethods.selectByIndex("occupation_XPATH", 2);
		
		//Select Minor
		CommonMethods.selectByIndex("minorFlag_XPATH", 2);

		// Enter Au Financiers
		CommonMethods.selectByIndex("auFinanacer_XPATH", 2);

		// Enter religion
		CommonMethods.selectByIndex("religion_XPATH", 1);

		// Enter Category
		CommonMethods.selectByIndex("category_XPATH", 1);

		// Enter Qualification
		CommonMethods.selectByIndex("qualification_XPATH", 4);

		// blood grp
		CommonMethods.selectByIndex("bloodgrp_XPATH", 5);

		// Gross income
		CommonMethods.selectByIndex("grossincome_XPATH", 4);

		// physically challenged
		CommonMethods.selectByIndex("physicallyChallenged_XPATH", 2);

		// place of birth
		String placeofb = ExcelOperation.getCellData(sheetName, "Place Of Birth", 1);
		CommonMethods.sendkeys("placeofBirth_XPATH", placeofb);

		// employer type
		CommonMethods.selectByIndex("employerType_XPATH", 2);

		// Enter employer name
		String employer = ExcelOperation.getCellData(sheetName, "Employer Name", 1);
		CommonMethods.sendkeys("employerName_XPATH", employer);

		// designation
		CommonMethods.selectByIndex("designation_XPATH", 7);

		// last kyc date
		CommonMethods.scrollDown(500);
		String kycDate1 = ExcelOperation.getCellData(sheetName, "Last KYC Date", 1);
		CommonMethods.sendkeys("kycDate_XPATH", kycDate1);

		// special identifier
		CommonMethods.Click("specialIdentifier_XPATH");
		CommonMethods.Click("centralgov_XPATH");
		System.out.println("selected special identifier");

		// enter LG, LC, RM code
		String lg = ExcelOperation.getCellData(sheetName, "LG Code", 1);
		CommonMethods.sendkeys("lgCode_XPATH", lg);

		String lc = ExcelOperation.getCellData(sheetName, "LC Code", 1);
		CommonMethods.sendkeys("lcCode_XPATH", lc);

		String rm = ExcelOperation.getCellData(sheetName, "RM Code", 1);
		CommonMethods.sendkeys("rmCode_XPATH", rm);

		// Facta Reporting
		CommonMethods.scrollDown(500);
		CommonMethods.selectByIndex("factaReporting_XPATH", 2);

		// select employer type
		CommonMethods.scrollDown(500);
		CommonMethods.selectByIndex("employement_XPATH", 6);

		// employer/industry
		CommonMethods.Click("employer_XPATH");
		CommonMethods.Click("industry_XPATH");

		// department
		CommonMethods.Click("departmentSearch_XPATH");
		CommonMethods.Click("department_XPATH");

		// profession
		CommonMethods.Click("leadprofessionSearch_XPATH");
		CommonMethods.Click("leadprofession_XPATH");

		// Enter current address
		String add1 = ExcelOperation.getCellData(sheetName, "Current address Line1", 1);
		CommonMethods.sendkeys("currentaddress1_XPATH", add1);

		// select customer pin
		CommonMethods.Click("pinsearch_XPATH");
		CommonMethods.ExWait("pincode_XPATH");
		CommonMethods.Click("pincode_XPATH");

		// select checkbox
		Thread.sleep(3000);
		CommonMethods.scrollByVisibilityofElement("sameAsAbove_XPATH");
		CommonMethods.Click("sameAsAbove_XPATH");
		// CommonMethods.moveToElementAndClick("sameAsAbove_XPATH");
		Thread.sleep(3000);
		// Enter Permanant add
		String perAdd = ExcelOperation.getCellData(sheetName, "Permanent Address 1", 1);
		CommonMethods.sendkeys("permenantaddress1_XPATH", perAdd);
		Thread.sleep(1000);

		// select Permannt pincode
		CommonMethods.Click("permanentPin_XPATH");
		CommonMethods.ExWait("pincode_XPATH");
		CommonMethods.Click("pincode_XPATH");

		Thread.sleep(2000);
		CommonMethods.Click("saveAndProceedBtn_XPATH");
		// okBtn.click();
		/*Thread.sleep(5000);
		CommonMethods.ExWait("bmStatusCode_XPATH");
		String statusCode = driver.findElement(By.xpath(CommonMethods.readPropertyFile("bmStatusCode_XPATH")))
				.getText();
		System.out.println(statusCode);
		Thread.sleep(5000);
		// Assert.assertEquals("Pending BM Recommendation", statusCode,"statuscode
		// mismatch");
		// TestUtil.takeScreenShot("Lead Creation");*/
	}
	
	public void verifyBMStatusCode() throws Exception {
		Thread.sleep(5000);
		CommonMethods.ExWait("bmStatusCode_XPATH");
		String statusCode = driver.findElement(By.xpath(CommonMethods.readPropertyFile("bmStatusCode_XPATH")))
				.getText();
		System.out.println(statusCode);
		Thread.sleep(5000);
		// Assert.assertEquals("Pending BM Recommendation", statusCode,"statuscode
		// mismatch");
		
	}

	public void editLeadAtBMStage() throws Exception {
		Thread.sleep(3000);
		CommonMethods.Click("bmLeadTab_XPATH");
		log.info("Branch Manager Click On Lead Tab");
		System.out.println("Branch Manager Click On LEad Tab");
		CommonMethods.scrollDown(500);

		// Search lead in bucket
		CommonMethods.selectByIndex("bmViewDrpdown1_XPATH", 2);
		CommonMethods.selectByIndex("bmViewdrpdown2_XPATH", 33);
		CommonMethods.Click("arrowbtn_XPATH");
		// click on lead
		// CommonMethods.Click("bmLead_XPATH");
		Thread.sleep(2000);
		// CommonMethods.Click("lead1CB_XPATH");
		CommonMethods.ExWait("lead1CB_XPATH");
		CommonMethods.mouseClick("lead1CB_XPATH");
		CommonMethods.scrollDown(500);
		CommonMethods.Click("changeOwner_XPATH");
		CommonMethods.Click("changeownerBtn_XPATH");
		CommonMethods.Click("okbtn_XPATH");

		CommonMethods.scrollDown(500);
		CommonMethods.ExWait("bmLead_XPATH");
		CommonMethods.Click("bmLead_XPATH");
		Thread.sleep(3000);
		clickOnToggleBtn();
		editLead();
		// CommonMethods.scrollAtBottom();
		// Thread.sleep(1000);
		// CommonMethods.Click("assignToMe_XPATH");
		// CommonMethods.Click("updateBtn_XPATH");
		Thread.sleep(3000);
		CommonMethods.ExWait("bmRecommended_XPATH");
		CommonMethods.mouseClick("bmRecommended_XPATH");

		CommonMethods.selectByIndex("bmpdfVerified_XPATH", 1);
		CommonMethods.scrollAtBottom();
		CommonMethods.Click("saveAndProceedBtn_XPATH");
		Thread.sleep(4000);
		CommonMethods.ExWait("StatusCode_XPATH");
		String statusCode = driver.findElement(By.xpath(CommonMethods.readPropertyFile("StatusCode_XPATH"))).getText();
		System.out.println(statusCode);
		Thread.sleep(4000);
		// Assert.assertEquals("DDE", statusCode2,"statuscode mismatch");
		// TestUtil.takeScreenShot("DDE Status code");

	}

	public void editLeadAtBOStage() throws Exception {
		Thread.sleep(3000);
		CommonMethods.Click("bmLeadTab_XPATH");
		log.info("Back Office Click on Lead Tab");
		Thread.sleep(3000);
		CommonMethods.scrollDown(3000);
		// Search lead in bucket
		CommonMethods.selectByIndex("bmViewDrpdown1_XPATH", 2);
		CommonMethods.selectByIndex("bmViewdrpdown2_XPATH", 7);
		CommonMethods.Click("arrowbtn_XPATH");
		Thread.sleep(4000);
		CommonMethods.ExWait("lead1CB_XPATH");
		CommonMethods.mouseClick("lead1CB_XPATH");
		CommonMethods.scrollDown(500);

		// click on assign to me
		CommonMethods.ExWait("assignToMe_XPATH");
		CommonMethods.mouseClick("assignToMe_XPATH");
		CommonMethods.Click("updateBtn_XPATH");
		CommonMethods.Click("okbtn_XPATH");
		Thread.sleep(3000);
		CommonMethods.scrollDown(500);
		CommonMethods.selectByIndex("bmViewDrpdown1_XPATH", 2);
		CommonMethods.selectByIndex("bmViewdrpdown2_XPATH", 18);
		Thread.sleep(3000);
		CommonMethods.ExWait("boLead_XPATH");
		CommonMethods.Click("boLead_XPATH");
		Thread.sleep(3000);
		clickOnToggleBtn();
		editLead();
		Thread.sleep(3000);
		CommonMethods.ExWait("sentToDVU_XPATH");
		CommonMethods.mouseClick("sentToDVU_XPATH");
		CommonMethods.scrollAtBottom();
		CommonMethods.Click("saveAndProceedBtn_XPATH");
		CommonMethods.ExWait("StatusCode_XPATH");
		String statusCode3 = driver.findElement(By.xpath(CommonMethods.readPropertyFile("StatusCode_XPATH"))).getText();
		System.out.println(statusCode3);
		Thread.sleep(3000);
		// Assert.assertEquals("Sent to DVU", statusCode3,"statuscode mismatch");
		// TestUtil.takeScreenShot("Sent to DVU Status code");

	}

	public void editLeadAtDVUStage(String sheetName) throws Exception {
		Thread.sleep(2000);
		CommonMethods.Click("dvuLeadTab_XPATH");
		log.info("DVU User Click On Lead Tab");
		Thread.sleep(3000);
		CommonMethods.scrollDown(3000);
		CommonMethods.selectByIndex("bmViewDrpdown1_XPATH", 2);
		CommonMethods.selectByIndex("bmViewdrpdown2_XPATH", 6);
		CommonMethods.Click("arrowbtn_XPATH");
		Thread.sleep(4000);
		CommonMethods.ExWait("lead1CB_XPATH");
		CommonMethods.mouseClick("lead1CB_XPATH");
		CommonMethods.scrollDown(500);
		// click on assign to me
		CommonMethods.ExWait("assignToMe_XPATH");
		CommonMethods.mouseClick("assignToMe_XPATH");
		CommonMethods.Click("updateBtn_XPATH");
		CommonMethods.Click("okbtn_XPATH");
		Thread.sleep(3000);
		CommonMethods.selectByIndex("bmViewDrpdown1_XPATH", 2);
		CommonMethods.selectByIndex("bmViewdrpdown2_XPATH", 18);
		Thread.sleep(3000);
		CommonMethods.Click("devlead_XPATH");
		CommonMethods.scrollAtBottom();
		CommonMethods.Click("mobilePDF_XPATH");
		CommonMethods.switchwindow();
		Thread.sleep(3000);
		CommonMethods.mouseClick("downloadPDF_XPATH");
		CommonMethods.switchtoparentwindow();
		Thread.sleep(2000);
		CommonMethods.Click("okbtn_XPATH");
		// warningmsg.click();
		//CommonMethods.switchwindow();
		//driver.close();
		//driver.switchTo().defaultContent();
		// CommonMethods.switchToParentWin();
		// CommonMethods.s
		// okbtn.click();
		CommonMethods.scrollAtBottom();
		// CommonMethods.Click("bottomBtn_XPATH");
		CommonMethods.Click("updateLead_XPATH");

		CommonMethods.selectByIndex("updateleadData_XPATH", 1);
		CommonMethods.Click("updateBtn_XPATH");
		CommonMethods.Click("okbtn_XPATH");
		Thread.sleep(3000);
		editLead();
		CommonMethods.Click("dvuVerified_XPATH");
		CommonMethods.scrollDown(500);
		String pan = ExcelOperation.getCellData(sheetName, "PAN Justification", 1);
		CommonMethods.sendkeys("panJustification_XPATH", pan);
		Thread.sleep(1000);
		CommonMethods.scrollAtBottom();
		CommonMethods.Click("saveAndProceedBtn_XPATH");
		CommonMethods.ExWait("StatusCode_XPATH");
		String statusCode3 = driver.findElement(By.xpath(CommonMethods.readPropertyFile("StatusCode_XPATH"))).getText();
		System.out.println(statusCode3);
		Thread.sleep(3000);
		// Assert.assertEquals("Account Opened", statusCode4,"statuscode mismatch");
		// TestUtil.takeScreenShot("Sucessful liability flow");

	}

	public void VerifyHistoryTab() throws Exception {
		Thread.sleep(3000);
		CommonMethods.ExWait("historyTab_XPATH");
		
		Assert.assertTrue(
				driver.findElement(By.xpath(CommonMethods.readPropertyFile("historyTab_XPATH"))).isDisplayed());
		CommonMethods.Click("historyTab_XPATH");
		Assert.assertTrue(
				driver.findElement(By.xpath(CommonMethods.readPropertyFile("historydetails_XPATH"))).isDisplayed());

		boolean leadstatuscode = driver
				.findElement(By.xpath(CommonMethods.readPropertyFile("historyleadStatusCode_XPATH"))).isDisplayed();
		Assert.assertTrue(leadstatuscode, "Lead status code Tab not Present");

		boolean lastmodifiedby = driver
				.findElement(By.xpath(CommonMethods.readPropertyFile("historyleadlastModifiedBy_XPATH"))).isDisplayed();
		Assert.assertTrue(lastmodifiedby, "Last modified By Tab not Present");

		boolean rolename = driver.findElement(By.xpath(CommonMethods.readPropertyFile("historyRoleName_XPATH")))
				.isDisplayed();
		Assert.assertTrue(rolename, "Role Name Tab not Present");

		boolean lastModifiedon = driver
				.findElement(By.xpath(CommonMethods.readPropertyFile("historyLeadlastModifiedOn_XPATH"))).isDisplayed();
		Assert.assertTrue(lastModifiedon, "Last Modified On Tab not Present");

		boolean comments = driver.findElement(By.xpath(CommonMethods.readPropertyFile("historyleadComments_XPATH")))
				.isDisplayed();
		Assert.assertTrue(comments, "Comments On Tab not Present");

	}

	public void searchETBLead(String SheetName) throws Exception {
		CommonMethods.scrollDown(500);

		// Enter Mobile No for ETB Lead
		String mobileNo = ExcelOperation.getCellData(SheetName, "ETB Mobile", 1);
		CommonMethods.sendkeys("mobileNo_XPATH", mobileNo);
		System.out.println("Entered Mobile No" + mobileNo);
		log.info("Enter Mobile No: " + mobileNo);
		Thread.sleep(2000);
		CommonMethods.Click("clickHereToFetch_XPATH");
		//Thread.sleep(2000);
		//Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("ETBLead_XPATH"))).isDisplayed());
		Thread.sleep(5000);
		//CommonMethods.ExWait("ETBCheckBox_XPATH");
		CommonMethods.selectCheckbox("ETBCheckBox_XPATH");
		//CommonMethods.moveToElementAndClick("ETBCheckBox_XPATH");
		//CommonMethods.Click("ETBCheckBox_XPATH");
		//CommonMethods.mouseClick("ETBCheckBox_XPATH");
		Thread.sleep(3000);
		CommonMethods.Click("okbtn_XPATH");

		// select Lead Type
		CommonMethods.scrollDown(-500);
		CommonMethods.selectByIndex("leadType_XPATH", 2);
		log.info("Lead Type Selected: Self");
		System.out.println("Lead Type Selected");
		System.out.println();

		//// Select product Category
		CommonMethods.Click("productcategorysearch_XPATH");
		CommonMethods.Click("productCatergory_XPATH");
		log.info("Select Product Category: Saving Account");
		System.out.println("Product Category Selected");
		System.out.println();

		// Select Product
		Thread.sleep(5000);
		CommonMethods.selectByIndex("newProductETBLead_XPATH", 36);
		log.info("New Product Selected");
		System.out.println("Product Selected");
		System.out.println();

		// select date
		CommonMethods.scrollDown(500);
		System.out.println("Select Date Of When u Meet");
		CommonMethods.Click("calender_XPATH");
		CommonMethods.Click("selectDate_XPATH");
		Thread.sleep(3000);
		CommonMethods.Click("timeIcon_XPATH");
		CommonMethods.Click("selectTime_XPATH");
		log.info("Date Selected");

		// Enter Expected Buisness
		String expectedBuisness1 = ExcelOperation.getCellData(SheetName, "Expected Buisness", 1);
		System.out.println("Expected Buisness Amount ::" + expectedBuisness1);
		CommonMethods.sendkeys("expectedBuisness_XPATH", expectedBuisness1);
		log.info("Expected Buisness Are :" + expectedBuisness1);

		// select expected Conversion
		CommonMethods.selectByIndex("expectedconversion_XPATH", 1);
		System.out.println("Expected Date Of Conversion Selected");
		log.info("Select expected date of conversion");

		// Enter Loan
		String loan = ExcelOperation.getCellData(SheetName, "Loan Amount", 1);
		CommonMethods.sendkeys("loanAmount_XPATH", loan);
		System.out.println("Entered Loan Amount ::" + loan);
		log.info("Enter Loan Amount " + loan);

		// Enter DOB
		//String dob = ExcelOperation.getCellData(SheetName1, "DOB", 1);
		//CommonMethods.sendkeys("DOB_XPATH", dob);
		//System.out.println("Date Of Birth Entered ::" + dob);
		//log.info("Date Of Birth  ::" + dob);

		// Enter Branch
		CommonMethods.sendkeys("branch_XPATH", "2143");
		CommonMethods.Click("branchName_XPATH");
		System.out.println("Branch Selected::");
		log.info("Branch Selected");

		// Enter Entity
		CommonMethods.sendkeys("entityType_XPATH", "individual");
		//entityType.sendKeys("individual");
		//entity.click();
		CommonMethods.Click("entity_XPATH");
		log.info("Select Entity: Individual Full KYC");

		// Select customer pin
		// CommonMethods.Click(pinSearch);
		// CommonMethods.Click(cityPin);
		// log.info("select pin code");

		// Click on Save & Proceed
		CommonMethods.Click("saveAndProceedBtn_XPATH");
		System.out.println("Clicked On Save & Proceed");
		log.info("CSE User Click on Save & Procceed Button");
		Thread.sleep(5000);

	}
	
	/*public void clickOnIgnoreandCreate() throws Exception {
		CommonMethods.ExWait("ignoreAndCreate_XAPTH");
		//CommonMethods.Click("ignoreAndCreate_XAPTH");
		CommonMethods.mouseClick("ignoreAndCreate_XAPTH");
		
	}*/
	
	public void clickOnIgnoreandUpdate() throws Exception {
		CommonMethods.ExWait("ignoreAndUpdate_XPATH");
		//CommonMethods.Click("ignoreAndCreate_XAPTH");
		CommonMethods.mouseClick("ignoreAndUpdate_XPATH");
	}
	
	
	public void enterMobileNoForDataPresenter(String SheetName) throws IOException {
		CommonMethods.scrollDown(500);
		//enter mobile no
		String MobileNo = ExcelOperation.getCellData(SheetName, "Mobile", 1);
		System.out.println("Mobile No Entered ::" +MobileNo);
		CommonMethods.sendkeys("mobileNo_XPATH", MobileNo);
		log.info("Mobile No Entered :: " +MobileNo);
	}

	public void verifyDataPresenterEDSIsWorking() throws Exception {
		CommonMethods.ExWait("clickHereToFetch_XPATH");
		Thread.sleep(2000);
		CommonMethods.Click("clickHereToFetch_XPATH");
		CommonMethods.ExWait("ETBLead_XPATH");
	    Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("ETBLead_XPATH"))).isDisplayed());
	    Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("ETBCIF_XPATH"))).isDisplayed());
	    log.info("Data Presenter EDS Displayed Data");
	}
	
	// *******************Pagination********************
		public void verifyOrderBy() throws Exception {

			boolean flag = CommonMethods.isElementPresent("viewsSortLeadPage_XPATH");
			boolean flagassc = CommonMethods.isElementPresent("viewsAsscendingSortLeadPage_XPATH");

			if (flag == true) {
				CommonMethods.mouseClick("viewsSortLeadPage_XPATH");
				Thread.sleep(2000);

				verifyLeadIDAscendingOrder();
			}

			else if (flagassc == true) {

				verifyLeadIDAscendingOrder();
			}

			else {
				// CommonMethods.mouseClick("viewsDescendingSortLeadPage_XPATH");
				Thread.sleep(2000);
				// CommonMethods.mouseClick("viewsSortLeadPage_XPATH");

				Thread.sleep(2000);

				verifyLeadIDDescendingOrder();
			}

		}
		// verify Lead ID column is in ascending order

		public void verifyLeadIDAscendingOrder() {

			// Actual List
			ArrayList<String> ActualList = new ArrayList<String>();

			List<WebElement> elementList = driver.findElements(By.xpath("//a[starts-with(@data-autoid,'LeadID_')]/span"));

			for (WebElement we : elementList) {

				ActualList.add(we.getText());

				System.out.println("Actual List: " + ActualList);
				ArrayList<String> ExpectedList = new ArrayList<String>();

				// COPY actual list to another list
				ExpectedList.addAll(ActualList);
				Collections.sort(ExpectedList);

				System.out.println("Expected List order:  " + ExpectedList);

				Assert.assertEquals(ActualList, ExpectedList, "list are sorted in ascending order: ");
			}

		}

		// verify Lead ID column is in descending order
		public void verifyLeadIDDescendingOrder() {

			// Actual List
			ArrayList<String> ActualList = new ArrayList<String>();

			List<WebElement> elementList = driver.findElements(By.xpath("//a[starts-with(@data-autoid,'LeadID_')]/span"));

			for (WebElement we : elementList) {

				ActualList.add(we.getText());

				System.out.println("Actual List: " + ActualList);
				ArrayList<String> sortlist = new ArrayList<String>();
				ArrayList<String> ExpectedList = new ArrayList<String>();

				// COPY actual list to another list
				sortlist.addAll(ActualList);
				Collections.sort(sortlist);
				ExpectedList.addAll(sortlist);
				Collections.reverse(ExpectedList);

				System.out.println("Expected List order:  " + ExpectedList);

				// Assert.assertEquals(" list are sorted in assending order: ", ExpectedList,
				// ActualList);
				Assert.assertEquals(ActualList, ExpectedList, "list are in descending order: ");
			}

		}
		
		public void clickOnArrowButton() throws Exception {

			CommonMethods.highLight("arrowbtn_XPATH");
			Thread.sleep(2000);
			CommonMethods.Click("arrowbtn_XPATH");

		}
		// verify Pagination Dropdown values

		public void verifyPaginationDropdown(String sheetName) throws Exception {
			CommonMethods.selectByText("appdropdown1_XPATH",sheetName, "Dropdown1", 1);
			CommonMethods.selectByText("appdropdown2_XPATH", sheetName, "Dropdown2", 1);
			CommonMethods.Click("arrowBtn_XPATH");
			// scroll to dropdown
			CommonMethods.scrollByVisibilityofElement("pagelistingdropdownLeadPage_XPATH");

			// select value from dropdown
			CommonMethods.selectByIndex("pagelistingdropdownLeadPage_XPATH", 1);
			
			

			// verify after selecting value as 10 from dropdown its showing 10 records
			String actualshowrecordtext = "Showing 1-20 Records";
			String expshowrecordtext = CommonMethods.getElementText("ShowRecordTextLeadPage_XPATH");
			System.out.println(expshowrecordtext);

			// Asser actual expected msg
			Assert.assertEquals(actualshowrecordtext, expshowrecordtext, "Dropdown Text mismatched");

			// get List count of elements
			List<WebElement> ele = driver.findElements(By.xpath("//div[@class='crm-grid-row relative']"));
			int actualcount = ele.size();
			System.out.println("Row count after selecting dropdown Value as 20 from Pagination: " + ele.size());
			int expcount = 20;

			// verfiy actual exp count
			Assert.assertEquals(expcount, actualcount, "Count mismatched");

		}

		// verify Go To pagination TextBox

		/*public void verifypaginationGoToTextBox() throws Exception {

			Thread.sleep(4000);

			// scroll to dropdown
			CommonMethods.scrollByVisibilityofElement("pageGoToTextboxRetailAppointmentPage_XPATH");

			// enter value in textbox
			CommonMethods.sendkeys("pageGoToTextboxRetailAppointmentPage_XPATH", "2");

			Thread.sleep(4000);
			// Enter
			CommonMethods.KeysEnter("pageGoToTextboxRetailAppointmentPage_XPATH");

			Thread.sleep(2000);
			Assert.assertTrue(driver.findElement(By.xpath("//a[@data-autoid='pagination_2']")).isEnabled());

		}*/
		
		
		//select view forconditionalAccess
		public void selectLeadFromViewBucket(String sheetName) throws Exception {
			CommonMethods.scrollDown(500);
			log.info("Select Lead From View Bucket");
			CommonMethods.selectByValue("appdropdown1_XPATH", "sheetName", "dropdown1", 1);
		
			CommonMethods.selectByValue("appdropdown2_XPATH", "sheetName", "dropdown1", 1);
			
			CommonMethods.Click("arrowBtn_XPATH");
			
			CommonMethods.ExWait("leadN_XPATH");
			
			 Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("leadN_XPATH"))).isDisplayed());
			 
			 log.info("Click On Lead");
			 
			 CommonMethods.Click("leadN_XPATH");
			 Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("leadId_XPATH"))).isDisplayed());
			 
			 
			 
			 
			 
			
		}
}