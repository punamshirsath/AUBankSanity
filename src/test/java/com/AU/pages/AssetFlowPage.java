package com.AU.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.AU.commonUtilities.CommonMethods;
import com.AU.commonUtilities.ExcelOperation;
import com.AU.listeners.TestListeners;

public class AssetFlowPage extends TestListeners{
	
	LeadPage lp;
	
	public String sheetName = "AssetLeadDetails";
	public String sheetName1="CCODDetails";
	
	public static String customerphoto = "C:\\Users\\Punam Shirsath\\eclipse-workspace\\AUAutomationFramework\\src\\test\\resources\\Documents\\customerphotograph.png";
	public static String customerSign = "C:\\Users\\Punam Shirsath\\eclipse-workspace\\AUAutomationFramework\\src\\test\\resources\\Documents\\signature.jpg";
	public static String accountform = "C:\\Users\\Punam Shirsath\\eclipse-workspace\\AUAutomationFramework\\src\\test\\resources\\Documents\\accountopeningform.jpg";
	
	//Click On Asset Flow
	public void clickOnAssetFlow() throws InterruptedException {
		CommonMethods.Click("leadTab_XPATH");
		CommonMethods.Click("newBtn_XPATH");
		log.info("click on New Button");
		System.out.println("clicked ON New Button");
		Thread.sleep(5000);
		CommonMethods.Click("AssetFlow_XPATH");
		log.info("Select Asset Flow");
		System.out.println("Select Asset Flow");
		Thread.sleep(1000);
	}
	
	
	   //
       public void enterKeyInformationForAsset() throws Exception {
		
		//select product category
		System.out.println("Select Product Category");
		CommonMethods.sendkeys("AssetProductCategory_XPATH", "Home Loan");
		CommonMethods.Click("AssetProduct_XPATH");
		
		//select product
		System.out.println("Select Product");
		CommonMethods.selectByIndex("newProductETBLead_XPATH", 11);
		
		//select lead rating
		System.out.println("Select Lead rating");
		CommonMethods.selectByIndex("AssetLeadRating_XPATH", 2);
		
		//select Next Button
		System.out.println("Click ON Next Button");
		CommonMethods.Click("NextBtn_XPATH");
		
	}
	
	
	//enter Key Information For Asset CCOD Product 
	public void enterKeyInformationForAssetCCODProduct() throws Exception {
		
		//select product category
		System.out.println("Select Product Category");
		CommonMethods.sendkeys("AssetProductCategory_XPATH", "NBFC");
		CommonMethods.Click("AssetCCODProductcat_XPATH");
		
		//select product
		System.out.println("Select Product");
		CommonMethods.selectByIndex("newProductETBLead_XPATH", 7);
		
		//select lead rating
		System.out.println("Select Lead rating");
		CommonMethods.selectByIndex("AssetLeadRating_XPATH", 2);
		
		//select Next Button
		System.out.println("Click ON Next Button");
		CommonMethods.Click("NextBtn_XPATH");
		
	}
	
	//enter New Lead Details for asset flow
	public void enterNewLeadDetailsForAssetFlow(String sheetName) throws Exception{
		
		//select lead type
		CommonMethods.ExWait("leadType_XPATH");
		System.out.println("Select Lead Type");
		CommonMethods.selectByIndex("leadType_XPATH", 2);
		
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
		String actualcustname = custname + c;
		System.out.println("Actual Customer name Entered:  " + actualcustname);
		System.out.println();
		CommonMethods.sendkeys("customerName_XPATH", actualcustname);
		ExcelOperation.writeToExcel(sheetName, 1, 6, actualcustname);
		log.info("Entered Customer Name " + actualcustname);

		// Enter Loan
		String loan = ExcelOperation.getCellData(sheetName, "Loan Amount", 1);
		CommonMethods.sendkeys("loanAmount_XPATH", loan);
		System.out.println("Entered Loan Amount ::" + loan);
		log.info("Enter Loan Amount " + loan);

		//Select Propert Title
		CommonMethods.sendkeys("PropertyTitle_XPATH", "City");
		CommonMethods.Click("property_XPATH");
		System.out.println("Property Title Selected::");
		log.info("Property Title Selected");
		
		//select proprty Type
		CommonMethods.selectByIndex("propertyType_XPATH", 2);
		System.out.println("Property Type Selected::");
		log.info("Property Type Selected");
		
		// Enter Branch
		CommonMethods.sendkeys("branch_XPATH", "2143");
		CommonMethods.Click("branchName_XPATH");
		System.out.println("Branch Selected::");
		log.info("Branch Selected");


		// Click on Save & Proceed
		CommonMethods.Click("saveAndProceedBtn_XPATH");
		System.out.println("Clicked On Save & Proceed");
		log.info("CSE User Click on Save & Procceed Button");
		Thread.sleep(5000);
		
	}
	
	public void DocCollectionForAssetFlow(String sheetName) throws Exception {
		CommonMethods.ExWait("docCollected_XPATH");
		CommonMethods.Click("docCollected_XPATH");

		// Select phone Extension
		CommonMethods.sendkeys("phoneExtension_XPATH", "india");
		CommonMethods.Click("ext_XPATH");
		System.out.println("Phone Extension Selected");
		log.info("Phone Extension slected");
		
		//select pdf Verified
		CommonMethods.selectByIndex("AssetPdfVerified_XPATH", 1);
		
		//select minor flag
		CommonMethods.selectByIndex("minorFlag_XPATH", 2);
		
		//// select name salutation
		CommonMethods.selectByIndex("nameSalutation_XPATH", 2);
		
		// Enter short name
		String shortname = ExcelOperation.getCellData(sheetName, "ShortName", 1);
		CommonMethods.sendkeys("shortN_XPATH", shortname);
		System.out.println("Short Name Entered ::" +shortname);
		log.info("Short Name Entered ::" +shortname);
		
		// Enter DOB
		String dob = ExcelOperation.getCellData(sheetName, "DOB", 1);
		CommonMethods.sendkeys("DOB_XPATH", dob);
		System.out.println("Date Of Birth Entered ::" + dob);
		log.info("Date Of Birth  ::" + dob);
		
		// select gender
		CommonMethods.selectByIndex("genderdrpdown_XPATH", 2);
		
		//enter Adhar No
		String AdharNo = CommonMethods.generateRandomAdharNo();
		System.out.println("Actual Adhar no: " + AdharNo);
		System.out.println();
		ExcelOperation.writeToExcel(sheetName, 1, 15, AdharNo);
		CommonMethods.sendkeys("assetadharNO_XPATH", AdharNo);
		log.info("Enter adhar No: " + AdharNo);
		
		//Enter Voter Id
		String voterid = ExcelOperation.getCellData(sheetName, "Voter Id", 1);
		CommonMethods.sendkeys("assetVoterId_XPATH", voterid);
		System.out.println("Voter ID Entered ::" +voterid);
		log.info("Voter ID Entered ::" +voterid);
		
		
		
		// Enter PAN no
		String panNo1 = CommonMethods.generatePANNumber();
		System.out.println("Actual Pan no: " + panNo1);
		System.out.println();
		CommonMethods.sendkeys("assetPANNo_XPATH", panNo1);
		ExcelOperation.writeToExcel(sheetName, 1, 16, panNo1);
		
		//Enter Driving License No
		String drivingLicenseNo = ExcelOperation.getCellData(sheetName, "Driving License No", 1);
		CommonMethods.sendkeys("assetDrivingLicenseNo_XPATH", drivingLicenseNo);
		System.out.println("Driving License No Entered ::" +drivingLicenseNo);
		log.info("Driving License No Entered  ::" +drivingLicenseNo);
		
		//Enter Driving License No
		String rationNo = ExcelOperation.getCellData(sheetName, "Ration No", 1);
		CommonMethods.sendkeys("assetRationCardNo_XPATH", rationNo);
		System.out.println("ration No Entered ::" +rationNo);
		log.info("ration No Entered  ::" +rationNo);
		
		//sorce of lead
		CommonMethods.scrollDown(500);
		CommonMethods.Click("assetSourceOfLead_XPATH");
		Thread.sleep(3000);
		CommonMethods.moveToElementAndClick("assetSource_XPATH");
		
		
		
		//loan amount
		String loan = ExcelOperation.getCellData(sheetName, "Loan Amount", 1);
		CommonMethods.sendkeys("AssetLoanAmount_XPATH", loan);
		System.out.println("Entered Loan Amount ::" + loan);
		log.info("Enter Loan Amount " + loan);

		// last kyc date
		CommonMethods.scrollDown(500);
		String kycDate1 = ExcelOperation.getCellData(sheetName, "Last KYC Date", 1);
		CommonMethods.sendkeys("assetKYCDate_XPATH", kycDate1);
		
		// enter LG, LC, RM code
		String lg = ExcelOperation.getCellData(sheetName, "LG Code", 1);
		CommonMethods.sendkeys("lgCode_XPATH", lg);

		String lc = ExcelOperation.getCellData(sheetName, "LC Code", 1);
		CommonMethods.sendkeys("lcCode_XPATH", lc);
		
		//select Cust Category
		CommonMethods.scrollDown(500);
		CommonMethods.Click("custCategorySearch_XPATH");
		Thread.sleep(3000);
		CommonMethods.moveToElementAndClick("custCategory_XPATH");
		
		//select Sector
		CommonMethods.Click("sector_XPATH");
		Thread.sleep(3000);
		CommonMethods.moveToElementAndClick("sector1_XPATH");
		
		//select industry
		CommonMethods.Click("assetIndustry_XPATH");
		Thread.sleep(3000);
		CommonMethods.moveToElementAndClick("assetindustry_XPATH");
		
		//select sub industry
		CommonMethods.Click("subIndustry_XPATH");
		Thread.sleep(3000);
		CommonMethods.moveToElementAndClick("subindustry_XPATH");
		
		//select sub industry
		CommonMethods.Click("activity_XPATH");
		Thread.sleep(3000);
		CommonMethods.moveToElementAndClick("assetActivity_XPATH");
		
		
		// attach customer photograph
		CommonMethods.scrollDown(500);
		CommonMethods.moveToElementAndClick("assetCustomerPhotograph_XPATH");
		CommonMethods.FileUpload(customerphoto);

		// attach customer sign
		CommonMethods.moveToElementAndClick("assetCustomerSignature_XPATH");
		CommonMethods.FileUpload(customerSign);

		// attach account opening form
		CommonMethods.scrollDown(500);
		CommonMethods.moveToElementAndClick("assetAccountOpeningForm_XPATH");
		CommonMethods.FileUpload(accountform);
		
		// Enter current address
		String add1 = ExcelOperation.getCellData(sheetName, "Current address Line1", 1);
		CommonMethods.sendkeys("currentaddress1_XPATH", add1);

		// select customer pin
		CommonMethods.Click("assetPinSearch_XPATH");
		CommonMethods.ExWait("pincode_XPATH");
		CommonMethods.Click("pincode_XPATH");

		// select checkbox
		Thread.sleep(3000);
		CommonMethods.scrollByVisibilityofElement("assetSameAsAbove_XPATH");
		CommonMethods.Click("assetSameAsAbove_XPATH");
		// CommonMethods.moveToElementAndClick("sameAsAbove_XPATH");
		Thread.sleep(3000);
		// Enter Permanant add
		String perAdd = ExcelOperation.getCellData(sheetName, "Permanent Address 1", 1);
		CommonMethods.sendkeys("permenantaddress1_XPATH", perAdd);
		Thread.sleep(1000);

		// select Permannt pincode
		CommonMethods.Click("assetPermanantPin_XPATH");
		CommonMethods.ExWait("pincode_XPATH");
		CommonMethods.Click("pincode_XPATH");

		Thread.sleep(2000);
		CommonMethods.Click("saveAndProceedBtn_XPATH");
		// okBtn.click();
		Thread.sleep(5000);

	}
	
	public void verifyLeadHandOff() throws Exception {
		System.out.println("After Document Collection Asset Lead Needs To be Lead Handoff");
		CommonMethods.ExWait("leadHandoff_XPATH");
		CommonMethods.Click("leadHandoff_XPATH");

		Thread.sleep(2000);
		CommonMethods.Click("saveAndProceedBtn_XPATH");
		// okBtn.click();
		Thread.sleep(5000);
		String StatusCode=driver.findElement(By.xpath(CommonMethods.readPropertyFile("StatusCode_XPATH"))).getText();
  		Assert.assertEquals("Lead Handoff", StatusCode,"Status Code Mismatched");
		
	}
	
	//search lead in view
	public void searchCCODLeadInView() throws Exception {
		System.out.println("Search Lead In CCOD Product Bucket");
		CommonMethods.Click("leadTab_XPATH");
		CommonMethods.scrollDown(500);
		System.out.println("Select View Bucket");
		CommonMethods.selectByIndex("appdropdown1_XPATH", 10);
		CommonMethods.selectByIndex("appdropdown2_XPATH", 8);
		CommonMethods.Click("arrowBtn_XPATH");
		Thread.sleep(4000);
		CommonMethods.Click("leadpresent_XPATH");
		
	}
	
	public void enterNewLeadDetailsForCCODProducts(String sheetName) throws Exception {
		// Select Lead Type
		//Thread.sleep(2000);
		CommonMethods.ExWait("leadType_XPATH");
		CommonMethods.selectByIndex("leadType_XPATH", 2);
		log.info("Lead Type Selected: Self");
		System.out.println("Lead Type Selected");
		System.out.println();


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
		String expectedBuisness1 = ExcelOperation.getCellData(sheetName, "Expected Buisness", 1);
		System.out.println("Expected Buisness Amount ::" + expectedBuisness1);
		CommonMethods.sendkeys("expectedBuisness_XPATH", expectedBuisness1);
		log.info("Expected Buisness Are :" + expectedBuisness1);

		// select expected Conversion
		CommonMethods.selectByIndex("expectedconversion_XPATH", 1);
		System.out.println("Expected Date Of Conversion Selected");
		log.info("Select expected date of conversion");

		// Enter Loan
		String loan = ExcelOperation.getCellData(sheetName, "Loan Amount", 1);
		CommonMethods.sendkeys("loanAmount_XPATH", loan);
		System.out.println("Entered Loan Amount ::" + loan);
		log.info("Enter Loan Amount " + loan);

		// Enter DOB
		String dob = ExcelOperation.getCellData(sheetName, "DOB", 1);
		CommonMethods.sendkeys("DOB_XPATH", dob);
		System.out.println("Date Of Birth Entered ::" + dob);
		log.info("Date Of Birth  ::" + dob);

		// Enter Branch
		CommonMethods.sendkeys("branch_XPATH", "2143");
		CommonMethods.Click("branchName_XPATH");
		System.out.println("Branch Selected::");
		log.info("Branch Selected");

		// Enter Entity
		// entityType.sendKeys("individual");
		// entity.click();
		// log.info("Select Entity: Individual Full KYC");

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

	//search lead in view
		public void searchCCODLeadInCHTMView() throws Exception {
			System.out.println("Search Lead In CHTM Bucket");
			CommonMethods.Click("chLeadsTab_XPATH");
			CommonMethods.scrollDown(500);
			System.out.println("Select View Bucket");
			CommonMethods.selectByIndex("appdropdown1_XPATH", 8);
			CommonMethods.selectByIndex("appdropdown2_XPATH", 9);
			CommonMethods.Click("arrowBtn_XPATH");
			Thread.sleep(4000);
			CommonMethods.Click("leadpresent_XPATH");
			CommonMethods.scrollAtBottom();
			CommonMethods.Click("chtmAssignToMe_XPATH");
			CommonMethods.Click("updateBtn_XPATH");
			CommonMethods.Click("okbtn_XPATH");
			Thread.sleep(3000);
			CommonMethods.Click("okbtn_XPATH");
			Thread.sleep(3000);
			
		}
		
		public void editLeadAtCHTMStage() throws Exception {
			CommonMethods.ExWait("bmRecommended_XPATH");
			CommonMethods.Click("bmRecommended_XPATH");
			CommonMethods.scrollAtBottom();
			CommonMethods.Click("saveAndProceedBtn_XPATH");
			Thread.sleep(3000);
			CommonMethods.ExWait("StatusCode_XPATH");
			String statusCode = driver.findElement(By.xpath(CommonMethods.readPropertyFile("StatusCode_XPATH"))).getText();
			System.out.println(statusCode);
			Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("StatusCode_XPATH"))).isDisplayed());
			
		}
		
		//search lead CCOD lead in Back office view
		public void searchLeadCCODLeadInBOView() throws Exception {
			Thread.sleep(3000);
			CommonMethods.Click("bmLeadTab_XPATH");
			log.info("Back Office Click on Lead Tab");
			Thread.sleep(3000);
			CommonMethods.scrollDown(3000);
			// Search lead in bucket
			CommonMethods.selectByIndex("bmViewDrpdown1_XPATH", 3);
			CommonMethods.selectByIndex("bmViewdrpdown2_XPATH", 4);
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
			CommonMethods.selectByIndex("bmViewDrpdown1_XPATH", 3);
			CommonMethods.selectByIndex("bmViewdrpdown2_XPATH", 1);
			Thread.sleep(3000);
			CommonMethods.ExWait("boLead_XPATH");
			CommonMethods.Click("boLead_XPATH");
			Thread.sleep(3000);
			lp.clickOnToggleBtn();
			lp.editLead();
			Thread.sleep(3000);
			CommonMethods.ExWait("sentToDVU_XPATH");
			CommonMethods.moveToElementAndClick("sentToDVU_XPATH");
			CommonMethods.scrollAtBottom();
			CommonMethods.Click("saveAndProceedBtn_XPATH");
			CommonMethods.ExWait("StatusCode_XPATH");
			String statusCode3 = driver.findElement(By.xpath(CommonMethods.readPropertyFile("StatusCode_XPATH"))).getText();
			System.out.println(statusCode3);
			Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("StatusCode_XPATH"))).isDisplayed());
			Thread.sleep(3000);
		}
	
		public void searchCCODLeadInDVUView() throws Exception {
			Thread.sleep(2000);
			CommonMethods.Click("dvuLeadTab_XPATH");
			log.info("DVU User Click On Lead Tab");
			Thread.sleep(3000);
			CommonMethods.scrollDown(3000);
			CommonMethods.selectByIndex("bmViewDrpdown1_XPATH", 3);
			CommonMethods.selectByIndex("bmViewdrpdown2_XPATH", 5);
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
			CommonMethods.selectByIndex("bmViewDrpdown1_XPATH", 3);
			CommonMethods.selectByIndex("bmViewdrpdown2_XPATH", 1);
			Thread.sleep(3000);
			CommonMethods.Click("devlead_XPATH");
			CommonMethods.scrollAtBottom();
			CommonMethods.Click("mobilePDF_XPATH");
			CommonMethods.switchwindow();
			Thread.sleep(3000);
			CommonMethods.moveToElementAndClick("downloadPDF_XPATH");
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
			lp.editLead();
			CommonMethods.Click("dvuVerified_XPATH");
			CommonMethods.scrollDown(500);
			CommonMethods.selectByIndex("dvuPDFVerified_XPATH", 1);
			String pan = ExcelOperation.getCellData(sheetName, "PAN Justification", 1);
			CommonMethods.sendkeys("panJustification_XPATH", pan);
			Thread.sleep(1000);
			CommonMethods.scrollAtBottom();
			CommonMethods.Click("saveAndProceedBtn_XPATH");
			CommonMethods.ExWait("StatusCode_XPATH");
			String statusCode3 = driver.findElement(By.xpath(CommonMethods.readPropertyFile("StatusCode_XPATH"))).getText();
			System.out.println(statusCode3);
			Thread.sleep(3000);
			Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("StatusCode_XPATH"))).isDisplayed());
			

		}
	
		
	
	  
		 
		
	}
	
	
	

