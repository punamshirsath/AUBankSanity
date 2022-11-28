package com.AU.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.UnhandledException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.AU.commonUtilities.CommonMethods;
import com.AU.commonUtilities.ExcelOperation;
import com.AU.listeners.TestListeners;



public class PrimarySecondaryLeadPage extends TestListeners{
	
	LeadPage lp=new LeadPage();
	
	//public String sheetName = "PrimarySecondaryLeadDetails";
	public static String panpath = System.getProperty("user.dir")+ "\\src\\test\\resources\\Documents\\Pan card.pdf";
	public static String customerphoto = System.getProperty("user.dir")+ "\\src\\test\\resources\\Documents\\customerphotograph.png";
	public static String customerSign = System.getProperty("user.dir") + "\\src\\test\\resources\\Documents\\signature.jpg";
	public static String accountform = System.getProperty("user.dir") + "\\src\\test\\resources\\Documents\\accountopeningform.jpg";
	public static String idProof = System.getProperty("user.dir") + "\\src\\test\\resources\\Documents\\voterid.jpg";
	
	public void enterDetailsOfDocCollectionForPrimarySecondaryLead(String sheetName) throws Exception {
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
		CommonMethods.FileUpload(panpath);
		System.out.println("Pan card uploaded");

		// select gender
		CommonMethods.selectByIndex("genderdrpdown_XPATH", 2);

		// source channel
		CommonMethods.selectByIndex("sourcingChannel_XPATH", 4);

		// risk classification
		CommonMethods.selectByIndex("riskClassification_XPATH", 2);

		// secondary holder
		CommonMethods.selectByIndex("secondaryHolder_XPATH", 1);

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
		CommonMethods.FileUpload(customerphoto);

		// attach customer sign
		CommonMethods.moveToElementAndClick("customerSign_XPATH");
		CommonMethods.FileUpload(customerSign);

		// attach account opening form
		// js.executeScript("window.scrollBy(0,500)");
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
		Thread.sleep(5000);
		CommonMethods.ExWait("bmStatusCode_XPATH");
		String statusCode = driver.findElement(By.xpath(CommonMethods.readPropertyFile("bmStatusCode_XPATH"))).getText();
		System.out.println(statusCode);
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("bmStatusCode_XPATH"))).isDisplayed());
		
	}
	
	 public void AddSecondaryLead() throws Exception {
		 CommonMethods.ExWait("cardViewThreeDots_XPATH");
		   CommonMethods.Click("cardViewThreeDots_XPATH");
		   CommonMethods.mouseHover("addNew_XPATH");
		   CommonMethods.Click("secondaryLead_XPATH");
		   CommonMethods.ExWait("pageHeading_XPATH");
		   String statusCode = driver.findElement(By.xpath(CommonMethods.readPropertyFile("pageHeading_XPATH"))).getText();
			System.out.println(statusCode);
			Assert.assertEquals("Secondary Holder / Guardian", statusCode, "Title Mismatched");
		   
		   
	   }
	 
	 public void enterSecondaryHolderDetails(String sheetName ) throws Exception {
		 CommonMethods.selectByIndex("bmpdfVerified_XPATH", 1);
		 CommonMethods.Click("entitySearch_XPATH");
		 CommonMethods.moveToElementAndClick("secondaryEntity_XPATH");
		 
		// select name salutation
			CommonMethods.selectByIndex("nameSalutation_XPATH", 2);
		
			//Enter First Name
			int randomnum=CommonMethods.generateRandomNumber();
			String FirstName= "lead"+randomnum;			
			CommonMethods.sendkeys("secondaryFirstName_XPATH", FirstName);
			ExcelOperation.writeToExcel(sheetName,1, 29, FirstName);
			System.out.println("FirstName Entered: "+FirstName);
			System.out.println();
			
			//Enter Last Name
			String lastName = ExcelOperation.getCellData(sheetName, "LastName", 1);
			CommonMethods.sendkeys("secondaryLastName_XPATH", lastName);
			System.out.println("LastName Entered: "+lastName);
			System.out.println();
			
			// Enter short name
			String shortname = ExcelOperation.getCellData(sheetName, "Sec ShortName", 1);
			CommonMethods.sendkeys("secondaryShortName_XPATH", shortname);
			System.out.println("ShortName Entered: "+shortname);
			System.out.println();
			
			//select phone extension
			CommonMethods.sendkeys("phoneExtension_XPATH", "india");
			CommonMethods.Click("ext_XPATH");
			System.out.println("Phone Extension Selected");
			System.out.println();
			
			// enter mobile no
			String mobilenumber = CommonMethods.generateRandomMobileNumber();
			System.out.println("Actual mobile no: " + mobilenumber);
			System.out.println();
			ExcelOperation.writeToExcel(sheetName, 1, 38, mobilenumber);
			CommonMethods.sendkeys("secondaryMobile_XPATH", mobilenumber);
			log.info("Enter Mobile No: " + mobilenumber);
			
			// Enter DOB
			String dob = ExcelOperation.getCellData(sheetName, "Sec DOB", 1);
			CommonMethods.sendkeys("DOB_XPATH", dob);
			System.out.println("Date Of Birth Entered ::" + dob);
			log.info("Date Of Birth  ::" + dob);
			
			// select gender
			CommonMethods.selectByIndex("genderdrpdown_XPATH", 2);
			System.out.println("Gender Selected");
			log.info("Gender Selected");
			System.out.println();
			
			// Enter PAN no
			String panNo1 = CommonMethods.generatePANNumber();
			System.out.println("Actual Pan no: " + panNo1);
			log.info("PAN NO Entered  ::" + panNo1);
			System.out.println();
			// js.executeScript("window.scrollBy(0,500)");
			CommonMethods.sendkeys("panTB_XPATH", panNo1);
			ExcelOperation.writeToExcel(sheetName, 1, 31, panNo1);

			// Attach PAN
			CommonMethods.scrollDown(500);
			Thread.sleep(3000);
			CommonMethods.moveToElementAndClick("attachFile_XPATH");
			CommonMethods.FileUpload(panpath);
			System.out.println("Pan card uploaded");

			// source channel
			CommonMethods.selectByIndex("sourcingChannel_XPATH", 4);
			System.out.println("Sourcing Channel Selected");
			log.info("Sourcing Channel Selected");
			System.out.println();
			
			// Enter resident Status
			CommonMethods.selectByIndex("residentStatus_XPATH", 1);
			System.out.println("Resident Status  Selected");
			log.info("Resident Status Selected");
			System.out.println();
			
			// last kyc date
			CommonMethods.scrollDown(500);
			String kycDate1 = ExcelOperation.getCellData(sheetName, "Sec Last KYC Date", 1);
			CommonMethods.sendkeys("kycDate_XPATH", kycDate1);
			System.out.println("Entered KYC Date");
			log.info("Entered Last KYC Date ::" +kycDate1);
			System.out.println();
			
			// select Customer Relation With Account
			CommonMethods.sendkeys("customerRelation_XPATH", "Authorized");
			CommonMethods.Click("secondaryJoint_XPATH");
			System.out.println("Select Customer Relation with Account Selected");
			log.info("Select Customer Relation with Account Selected");
			System.out.println();
			
			// Select check book required
			CommonMethods.scrollDown(500);
			CommonMethods.selectByIndex("checkbookrequired_XPATH", 2);
			System.out.println("CheckBook Selected");
			log.info("CheckBook Selected");
			System.out.println();
			
			// attach customer photograph
			CommonMethods.moveToElementAndClick("CustomerPhotograph_XPATH");
			CommonMethods.FileUpload(customerphoto);
			System.out.println("Customer PhotoGraph Attached");
			log.info("Customer PhotoGraph Attached");
			System.out.println();

			// attach customer sign
			CommonMethods.moveToElementAndClick("customerSign_XPATH");
			CommonMethods.FileUpload(customerSign);
			System.out.println("Customer Sign Attached");
			log.info("Customer Sign Attached");
			System.out.println();
			
			// attach account opening form
			CommonMethods.scrollDown(500);
			CommonMethods.moveToElementAndClick("accountopeningForm_XPATH");
			CommonMethods.FileUpload(accountform);
			System.out.println("Account Opening Form Attached");
			log.info("Account Opening Form Attached");
			System.out.println();
			
			// select ID of proof
			CommonMethods.selectByIndex("proofOfID_XPATH", 4);
			CommonMethods.moveToElementAndClick("attachementOfID_XPATH");
			CommonMethods.FileUpload(idProof);
			System.out.println("Proof Of ID Selected");
			log.info("Proof Of ID Selected");
			System.out.println();

			// enter proof of POI id
			String poiDocNo1 = ExcelOperation.getCellData(sheetName, "Sec POI Doc No", 1);
			CommonMethods.sendkeys("POIDocNo_XPATH", poiDocNo1);
			System.out.println("Proof Of ID Doc No Entered :: "+poiDocNo1);
			log.info("Proof Of ID Doc No Entered :: " +poiDocNo1);
			System.out.println();

			CommonMethods.scrollDown(500);

			// select voter card
			CommonMethods.sendkeys("communicationProof_XPATH", "voter");
			CommonMethods.Click("voterID_XPATH");
			CommonMethods.moveToElementAndClick("attachmentofCommunicationProof_XPATH");
			CommonMethods.FileUpload(idProof);
			System.out.println("Communication Proof uploaded");
			log.info("Communication Proof uploaded");
			System.out.println();


			// communication doc no
			String commDocNo = ExcelOperation.getCellData(sheetName, "Sec Communication Doc No", 1);
			CommonMethods.sendkeys("communicationDocNo_XPATH", commDocNo);
			System.out.println("Communication Proof No Entered :: "+commDocNo);
			log.info("Communication Proof No Entered :: " +commDocNo);
			System.out.println();

			// select permant proof
			CommonMethods.sendkeys("permanentProof_XPATH", "voter");
			CommonMethods.Click("voterID_XPATH");
			Thread.sleep(2000);
			// Enter permant proof No
			String addNo = ExcelOperation.getCellData(sheetName, "Sec Permant Address No", 1);
			CommonMethods.sendkeys("permanentAddNo_XPATH", addNo);
			System.out.println("Permanant Address Proof Attached :: "+addNo);
			log.info("Permanant Address Proof Attached :: " +addNo);
			System.out.println();
			

			// attach permant proof document
			// CommonMethods.scrollDown(500);
			CommonMethods.moveToElementAndClick("permanentproofDoc_XPATH");
			CommonMethods.FileUpload(idProof);
			Thread.sleep(5000);

			// enter additional Document
			CommonMethods.selectByIndex("additionalDocuments_XPATH", 2);
			System.out.println("Additional Document No");
			log.info("Additional Document No");
			System.out.println();

			// Enter current address
			String add1 = ExcelOperation.getCellData(sheetName, "Sec Current address Line1", 1);
			CommonMethods.sendkeys("currentaddress1_XPATH", add1);
			// select customer pin
			CommonMethods.Click("secondaryCurrentPin_XPATH");
			CommonMethods.ExWait("pincode_XPATH");
			CommonMethods.Click("pincode_XPATH");
			
			// Marital status
			CommonMethods.selectByIndex("maritalStatus_XPATH", 1);
			System.out.println("Marital Status Selected");
			log.info("Marital Status Selected");
			System.out.println();
			
			// Enter Mother name
			String motherN = ExcelOperation.getCellData(sheetName, "Sec Mother Name", 1);
			CommonMethods.sendkeys("motherName_XPATH", motherN);
			System.out.println("Mother Name Entered :: "+motherN);
			log.info("Mother Name Entered :: "+motherN);
			System.out.println();		
			//select minoor
			CommonMethods.selectByIndex("minorFlag_XPATH", 2);

			// Enter Father Name
			String fatherN = ExcelOperation.getCellData(sheetName, "Sec Father Name", 1);
			CommonMethods.sendkeys("fatherName_XPATH", fatherN);
			System.out.println("Father Name Entered :: "+fatherN);
			log.info("Father Name Entered :: "+fatherN);
			System.out.println();
			
			// select occupation
			CommonMethods.selectByIndex("occupation_XPATH", 2);
			System.out.println("Occupation Selected");
			log.info("Occupation Selected");
			System.out.println();
			
			// Enter religion
			CommonMethods.selectByIndex("religion_XPATH", 1);

			// Enter Category
			CommonMethods.selectByIndex("category_XPATH", 1);

			// Enter Qualification
			CommonMethods.selectByIndex("qualification_XPATH", 4);

			// blood grp
			CommonMethods.selectByIndex("bloodgrp_XPATH", 5);
			
			// select checkbox
			Thread.sleep(3000);
			CommonMethods.scrollByVisibilityofElement("secondarySameAsAbove_XPATH");
			CommonMethods.Click("secondarySameAsAbove_XPATH");
			Thread.sleep(3000);
			
			// Enter Permanent add
			String perAdd = ExcelOperation.getCellData(sheetName, "Sec Permanent Address 1", 1);
			CommonMethods.sendkeys("permenantaddress1_XPATH", perAdd);
			Thread.sleep(1000);
			
			// select Permannt pincode
			CommonMethods.Click("secondaryPermanentPin_XPATH");
			CommonMethods.ExWait("pincode_XPATH");
			CommonMethods.Click("pincode_XPATH");
			
			// place of birth
			String placeofb = ExcelOperation.getCellData(sheetName, "Place Of Birth", 1);
			CommonMethods.sendkeys("placeofBirth_XPATH", placeofb);
			System.out.println("Place Of Birth Entered :: "+placeofb);
			log.info("Place Of Birth Entered :: "+placeofb);
			System.out.println();
			
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
			
			//Click on Save Button
			CommonMethods.Click("saveBtn_XPATH");

     }
	 
	 public void VerifySecondaryNewLeadCreated() throws Exception {
		 CommonMethods.ExWait("leadId_XPATH");
		 
		 Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("parentLead_XPATH"))).isDisplayed());
	 }

	 
	 public void editSecondaryLeadOfDocCollected() throws Exception {
		 CommonMethods.ExWait("pageHeading_XPATH");
		 CommonMethods.scrollDown(500);
		 System.out.println("Status Code Change As Doc Collected");
		 CommonMethods.selectByIndex("statusCodeDrpdown_XPATH", 2);
		 CommonMethods.scrollDown(500);
		//Click on Save Button
		CommonMethods.Click("saveBtn_XPATH");

	 }
	 
	 public void searchLeadInBMView() throws Exception {
		 Thread.sleep(3000);
			CommonMethods.Click("bmLeadTab_XPATH");
			log.info("Branch Manager Click On Lead Tab");
			System.out.println("Branch Manager Click On LEad Tab");
			CommonMethods.scrollDown(500);

			// Search lead in bucket
			CommonMethods.ExWait("bmViewDrpdown1_XPATH");
			CommonMethods.selectByIndex("bmViewDrpdown1_XPATH", 2);
			Thread.sleep(3000);
			CommonMethods.selectByIndex("bmViewdrpdown2_XPATH", 33);
			//CommonMethods.selectByText(bmViewdrpdown2_XPATH, customerSign, accountform, 0);
			Thread.sleep(2000);
			CommonMethods.Click("arrowbtn_XPATH");
			Thread.sleep(2000);
			// CommonMethods.Click("lead1CB_XPATH");
			CommonMethods.ExWait("lead1CB_XPATH");
			CommonMethods.moveToElementAndClick("lead1CB_XPATH");
			CommonMethods.scrollDown(500);
			CommonMethods.Click("changeOwner_XPATH");
			CommonMethods.Click("changeownerBtn_XPATH");
			CommonMethods.Click("okbtn_XPATH");

			CommonMethods.scrollDown(500);
			CommonMethods.ExWait("bmLead_XPATH");
			CommonMethods.Click("bmLead_XPATH");
			Thread.sleep(3000);
	 }
	 
	 
	 public void OpenSecondaryLead() throws Exception {
		 Actions actions = new Actions(driver);
		 CommonMethods.ExWait("childLead_XPATH");
		 WebElement childlead = driver.findElement(By.xpath(CommonMethods.readPropertyFile("childLead_XPATH")));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.open(arguments[0], '_blank');", childlead);
	        CommonMethods.switchwindow();
	        
		 /*try {
		// actions.contextClick(childlead).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
			 
			 //Keys.Chord string
			 String clickl = Keys.chord(Keys.CONTROL,Keys.ENTER);// open the link in new tab, Keys.Chord string passed to sendKeys
			 driver.findElement(By.xpath(CommonMethods.readPropertyFile("childLead_XPATH"))).sendKeys(clickl);
		 }
		 catch(Exception e) {
			 System.out.println("Exception throws " +e.getMessage());
		 }*/
		}
	 
	 public void editSecondaryLeadOfBMRecommended() throws Exception {
		 CommonMethods.ExWait("pageHeading_XPATH");
		 CommonMethods.scrollDown(500);
		 System.out.println("Status Code Change As BM Recommended");
		 CommonMethods.selectByIndex("statusCodeDrpdown_XPATH", 2);
		 CommonMethods.scrollDown(500);
		//Click on Save Button
		CommonMethods.Click("saveBtn_XPATH");

	 }
	 
	 public void editPrimaryLeadOfBMRecommended() throws Exception {
		    CommonMethods.ExWait("bmRecommended_XPATH");
			CommonMethods.moveToElementAndClick("bmRecommended_XPATH");

			CommonMethods.selectByIndex("bmpdfVerified_XPATH", 1);
			CommonMethods.scrollAtBottom();
			CommonMethods.Click("saveAndProceedBtn_XPATH");
			Thread.sleep(4000);
			CommonMethods.ExWait("StatusCode_XPATH");
			String statusCode = driver.findElement(By.xpath(CommonMethods.readPropertyFile("StatusCode_XPATH"))).getText();
			System.out.println(statusCode);
			Assert.assertEquals("DDE", statusCode,"statuscode mismatch");
	 }
	 
	 public void editSecondaryLeadOfSentToDVUStage() throws Exception {
		 CommonMethods.ExWait("pageHeading_XPATH");
		 CommonMethods.scrollDown(500);
		 System.out.println("Status Code DVU");
		 CommonMethods.selectByIndex("auFinancersEmployee_XPATH", 2);
		 CommonMethods.selectByIndex("auRelatedEmployee_XPATH", 2);
		 //PrimarySecondaryLeadPage..selectByIndex("statusCodeDrpdown_XPATH", 2);
		 CommonMethods.scrollDown(500);
		 CommonMethods.selectByIndex("secondaryPosition_XPATH", 2);
		//Click on Save Button
		CommonMethods.Click("saveBtn_XPATH");

	 }
	 
	 public void sesrchLeadInBOView() throws Exception {
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
			CommonMethods.moveToElementAndClick("lead1CB_XPATH");
			CommonMethods.scrollDown(500);

			// click on assign to me
			CommonMethods.ExWait("assignToMe_XPATH");
			CommonMethods.moveToElementAndClick("assignToMe_XPATH");
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
		 
	 }
	 
	 public void editPrimaryLeadForSentToDVU() throws Exception {
		 CommonMethods.ExWait("sentToDVU_XPATH");
			CommonMethods.moveToElementAndClick("sentToDVU_XPATH");
			CommonMethods.scrollAtBottom();
			CommonMethods.Click("saveAndProceedBtn_XPATH");
			CommonMethods.ExWait("StatusCode_XPATH");
			String statusCode3 = driver.findElement(By.xpath(CommonMethods.readPropertyFile("StatusCode_XPATH"))).getText();
			System.out.println(statusCode3);
			Thread.sleep(3000);
			Assert.assertEquals("Sent to DVU", statusCode3,"statuscode mismatch");
	 }
	 
	 public void searchLeadInDVUView() throws Exception {
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
			CommonMethods.moveToElementAndClick("lead1CB_XPATH");
			CommonMethods.scrollDown(500);
			// click on assign to me
			CommonMethods.ExWait("assignToMe_XPATH");
			CommonMethods.moveToElementAndClick("assignToMe_XPATH");
			CommonMethods.Click("updateBtn_XPATH");
			CommonMethods.Click("okbtn_XPATH");
			Thread.sleep(3000);
			CommonMethods.selectByIndex("bmViewDrpdown1_XPATH", 2);
			CommonMethods.selectByIndex("bmViewdrpdown2_XPATH", 18);
			Thread.sleep(3000);
			CommonMethods.Click("devlead_XPATH");
	 }
	 
	 public void clickOnMobilePDF() throws Exception {
		 CommonMethods.Click("bottomBtn_XPATH");
		 Thread.sleep(3000);
		 CommonMethods.Click("secondaryMobilePDF_XPATH");
			CommonMethods.switchwindow();
			Thread.sleep(3000);
		//	CommonMethods.mouseClick("downloadPDF_XPATH");
			CommonMethods.ExWait("downloadPDF_XPATH");
			Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("downloadPDF_XPATH"))).isDisplayed());
			Thread.sleep(3000);
			CommonMethods.switchtoparentwindow();
			Thread.sleep(2000);
			CommonMethods.Click("okbtn_XPATH");
			Thread.sleep(2000);
			CommonMethods.scrollAtBottom();
			CommonMethods.Click("updateLead_XPATH");
        	CommonMethods.selectByIndex("updateleadData_XPATH", 1);
			CommonMethods.Click("updateBtn_XPATH");
			Thread.sleep(3000);
			CommonMethods.ExWait("okbtn_XPATH");
			CommonMethods.Click("okbtn_XPATH");
			Thread.sleep(3000);
	 }
	 
	 public void editprimaryLeadAtDVU(String sheetName ) throws Exception {
		 CommonMethods.Click("mobilePDF_XPATH");
			CommonMethods.switchwindow();
			Thread.sleep(3000);
			CommonMethods.moveToElementAndClick("downloadPDF_XPATH");
			CommonMethods.switchtoparentwindow();
			Thread.sleep(2000);
			CommonMethods.Click("okbtn_XPATH");
		 CommonMethods.scrollAtBottom();
			// CommonMethods.Click("bottomBtn_XPATH");
			//CommonMethods.Click("updateLead_XPATH");

			//CommonMethods.selectByIndex("updateleadData_XPATH", 1);
			//CommonMethods.Click("updateBtn_XPATH");
			//CommonMethods.Click("okbtn_XPATH");
			Thread.sleep(3000);
			lp.editLead();
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
			Assert.assertEquals("Account Opened", statusCode3,"statuscode mismatch");
	 }
	 
	 }
