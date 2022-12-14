package com.AU.pages;

import java.io.IOException;

import org.apache.commons.lang.UnhandledException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.AU.commonUtilities.CommonMethods;
import com.AU.commonUtilities.ExcelOperation;
import com.AU.commonUtilities.ScreenShot;
import com.AU.listeners.TestListeners;


public class SRCreationPage extends TestListeners{
	
	public String SRCreationSheet ="SRCreation"; 
    //public String sheetName = "SRCreationDetails";
    
	//click on SR Creation button
	public void clickOnSRCreationBtn() throws Exception {
		CommonMethods.highLight("srCreationBtn_XPATH");
		CommonMethods.Click("srCreationBtn_XPATH");
		log.info("Click on SR Creation Button");
	}
		
	
	//click on Customer Service
	public void clickOnCustomerServiceTab() throws Exception {
		CommonMethods.highLight("customerServiceTab_XPATH");
		CommonMethods.Click("customerServiceTab_XPATH");
		log.info("CSE User Click On Customer Service Tab");
	}
	
	//navigate to Customer Service Layout
	public void navigateToCustomerServiceLayout() throws Exception {
		CommonMethods.ExWait("newBtn_XPATH");
		CommonMethods.Click("newBtn_XPATH");
		log.info("click on New Button");
		CommonMethods.Click("customerServiceLayout_XPATH");
		CommonMethods.ExWait("pageTitle_XPATH");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("newLayoutPage_XPATH"))).isDisplayed());
		log.info("CSE User Navigate To Customer Service Layout");
	}
	
	//select sub-sub Category 
	public void selectSubSubCategory() throws Exception {
		CommonMethods.Click("subsubCategorySrch_XPATH");
		CommonMethods.Click("filterF_XPATH");
		CommonMethods.ExWait("subSubCategory_XPATH");
		CommonMethods.Click("subSubCategory_XPATH");
		log.info("Sub-Sub Category Selected");
		
	}
	
	//check subCategory and category fields are auto populated when selected subsub category
	public void verifySubCategoryFieldAreAutoSelected() throws Exception {
		log.info("Sub Category Field are auto Selected");
		String actualsubCategory=CommonMethods.toGetAttributeValue("subCategoryValue_XPATH");
		String expectedsubCategory="Fixed Deposits/Recurring Deposits Related";
		Assert.assertEquals(expectedsubCategory, actualsubCategory);
	}
	
	//check category fields are auto selected
	public void verifyCategoryFieldAreAutoSelected() throws Exception {
		log.info("Category Field are auto Selected");
		String actualCategory=CommonMethods.toGetAttributeValue("categoryValue_XPATH");
		String expectedCategory="LI_servicing";
		Assert.assertEquals(expectedCategory, actualCategory);
	}
	
	//verify deposit type fields are displayed
	
	public void verifyDepositTypeDropdown() throws InterruptedException, UnhandledException, IOException {
		CommonMethods.scrollDown(500);
		CommonMethods.Click("srDepositType_XPATH");
		Thread.sleep(3000);
		String option1 = driver.findElement(By.xpath(CommonMethods.readPropertyFile("depositType1_XPATH"))).getText();
		CommonMethods.verifyEquals("Fixed Deposit", option1);
		String option2 = driver.findElement(By.xpath(CommonMethods.readPropertyFile("depositType2_XPATH"))).getText();
		CommonMethods.verifyEquals("Recurring Deposit", option2);
		CommonMethods.getAllOptionsFromDropdown("srDepositType_XPATH");
		log.info("Deposit Type having two Options");
		
	}
	
	//select deposit type
	public void selectDepositType() throws Exception {
		CommonMethods.selectByIndex("srDepositType_XPATH", 1);
		WebElement element = driver.findElement(By.xpath(CommonMethods.readPropertyFile("srDepositType_XPATH")));
		Select sel=  new Select(element);
		 String option = sel.getFirstSelectedOption().getText(); 
	     System.out.println("Option chosen: " +option); 
		log.info("Deposit Type Selected");
		Assert.assertEquals("Fixed Deposit", option);
	}
	
	//select product Name/code as FD-Senior Citizen Bulk Monthly Payout
	public void selectProducteNameCodeAsFDSeniorCitizenBulkMonthlyPayout() throws UnhandledException, IOException {
		CommonMethods.scrollDown(500);
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("srProductCodeName_XPATH"))).isDisplayed());
		CommonMethods.sendkeys("srProductCodeName_XPATH", "FD-");
		CommonMethods.Click("productCode_XPATH");
		
	}
	
	//Select Sub Sub Category
	public void selectSubSubCategoryForSR() {
		CommonMethods.sendkeys("subsubCategoryInput_XPATH", "FD OR");
		CommonMethods.Click("srSubSubCategory_XPATH");
		log.info("Sub Sub Category Selected");
		
	}
	
	//click on next button
	public void clickOnNextButton() throws Exception {
		CommonMethods.highLight("NextBtn_XPATH");
		CommonMethods.Click("NextBtn_XPATH");
		log.info("Click on Next Button");
		
	}
	
	//select account no
	public void accountNOForSR() throws Exception {
		CommonMethods.scrollDown(500);
		//CommonMethods.scrollByVisibilityofElement("srAccountNOSrch_XPATH");
		CommonMethods.ExWait("srAccountNOSrch_XPATH");
		CommonMethods.Click("srAccountNOSrch_XPATH");
		CommonMethods.ExWait("accountNOSR_XPATH");
		CommonMethods.Click("accountNOSR_XPATH");
		log.info("Account No Selected");
		
	}
	
	//verify mobile no
	public void verifyMobileNoIsAutopopulated(String sheetName) throws Exception {
		log.info("For Customer SR Creation Mobile no are auto populated");
		String actualMobileNo=CommonMethods.toGetAttributeValue("srMobileNo_XPATH");
		String expectedMobileNo=ExcelOperation.getCellData(sheetName, "Search Mobile", 1);
		Assert.assertEquals(expectedMobileNo, actualMobileNo);
		
	}
	
	public void enterMandatoryDetailsForSR(String sheetName) throws Exception {
		
		String comments  =ExcelOperation.getCellData(sheetName, "Comments", 1);
		CommonMethods.sendkeys("srComments_XPATH", comments);
		log.info("Comments entered");
		
		
		String ROI  =ExcelOperation.getCellData(sheetName, "ROI", 1);
		CommonMethods.sendkeys("srRateOfIntrest_XPATH", ROI);
		log.info("Rate Of Interest Entered");
		
		String tenor=ExcelOperation.getCellData(sheetName, "Tenor", 1);
		CommonMethods.sendkeys("srTenor_XPATH", tenor);
		log.info("Tenor is Entered");
		
		String amount=ExcelOperation.getCellData(sheetName, "Amount", 1);
		CommonMethods.sendkeys("srAmount_XPATH", amount);
		log.info("Amount is Entered");
		
		CommonMethods.selectByIndex("nominationRequired_XPATH", 2);
		log.info("Nomination selected");
		
		String fundsAvailableAcc=ExcelOperation.getCellData(sheetName, "FundsAvailAcc", 1);
		CommonMethods.sendkeys("fundsAvailAcc_XPATH", fundsAvailableAcc);
		log.info("Funds Availale Acc is Entered");
		
		// select date
		CommonMethods.Click("calender_XPATH");
		CommonMethods.Click("selectDate_XPATH");
		Thread.sleep(3000);
		log.info("Value Date Selected");
		
		CommonMethods.selectByIndex("maturityPaymentInstruction_XPATH", 1);
		log.info("Maturity Payment Instruction Selected");
		
		CommonMethods.Click("saveAndProceedBtn_XPATH");
		log.info("Click On Save And Proceed Button");
		
	}
	
	public void clickOnOKBtn() {
		CommonMethods.Click("app_OKBtn_XPATH");
		log.info("Click On OK Button");
		
	}
	
	public void verifyCaseNumberIsGenerated() throws Exception {
		Thread.sleep(3000);
		CommonMethods.ExWait("caseNumber_XPATH");
		String caseNumber = driver.findElement(By.xpath(CommonMethods.readPropertyFile("caseNumber_XPATH"))).getText();
		System.out.println("Case Number is Displayed " +caseNumber);
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("caseNumber_XPATH"))).isDisplayed());
	}
	
	//DE User Click On Customer service tab
	public void deUserClickOnCustomerServiceTab() throws Exception {
		
		CommonMethods.highLight("deCustomerServiceTab_XPATH");
		CommonMethods.Click("deCustomerServiceTab_XPATH");
		log.info("Department Engineer User Click On Customer Service Tab");
		
	}
	
	//select view of department Engineer
	public void selectViewOfDepartmentEngineer(String sheetName) throws Exception {
	//	CommonMethods.selectByIndex("appdropdown1_XPATH", 1);
		CommonMethods.selectByText("appdropdown1_XPATH", sheetName, "Dropdown1", 1);
		Thread.sleep(3000);
		CommonMethods.selectByText("appdropdown2_XPATH", sheetName, "Dropdown2", 1);
		//CommonMethods.selectByIndex("appdropdown2_XPATH", 6);
		Thread.sleep(3000);
		CommonMethods.Click("arrowBtn_XPATH");
		Thread.sleep(3000);
		
	}
	
	
	//select SR for Self Assign
	public void selectSRForSelfAssignment() throws Exception {
		CommonMethods.ExWait("lead1CB_XPATH");
		CommonMethods.moveToElementAndClick("lead1CB_XPATH");
		CommonMethods.scrollDown(500);
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("selfAssignment_XPATH"))).isDisplayed());
		CommonMethods.Click("selfAssignment_XPATH");
		CommonMethods.ExWait("okbtn_XPATH");
		CommonMethods.Click("okbtn_XPATH");
		CommonMethods.scrollDown(500);
		CommonMethods.selectByIndex("appdropdown1_XPATH", 1);
		CommonMethods.selectByIndex("appdropdown2_XPATH", 0);
		Thread.sleep(3000);
		CommonMethods.Click("arrowBtn_XPATH");
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("srCase_XPATH"))).isDisplayed());
		CommonMethods.Click("srCase_XPATH");
		CommonMethods.scrollAtBottom();
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("app_EditBtn_XPATH"))).isDisplayed());
		
	}
	
	//DE user edit SR for In Process
	public void editSRASAInProcess() throws Exception {
		CommonMethods.Click("app_EditBtn_XPATH");
		CommonMethods.ExWait("processMileStone_XPATH");
		CommonMethods.Click("processMileStone_XPATH");
		CommonMethods.Click("inProcessStatusCode_XPATH");
		Thread.sleep(4000);
		CommonMethods.scrollAtBottom();
		CommonMethods.Click("saveAndProceedBtn_XPATH");
		CommonMethods.ExWait("caseStatusCode_XPATH");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("caseStatusCode_XPATH"))).isDisplayed());
		String casestatusCode = driver.findElement(By.xpath(CommonMethods.readPropertyFile("caseStatusCode_XPATH"))).getText();
		System.out.println(casestatusCode);
		Thread.sleep(3000);
		Assert.assertEquals("In Progress", casestatusCode,"statuscode mismatch");
		
		
	}
	
	//DE User Edit SR As A Resolved
	public void editSRAsaResolvedStatusCode(String sheetName) throws Exception {
		CommonMethods.Click("app_EditBtn_XPATH");
		CommonMethods.ExWait("processMileStone_XPATH");
		CommonMethods.Click("resolvedStatusCode_XPATH");
		
		String resolution  =ExcelOperation.getCellData(sheetName, "Resolution", 1);
		CommonMethods.sendkeys("resolutionTB_XPATH", resolution);
		log.info("Resolution entered");
		
		CommonMethods.selectByIndex("feedback_XPATH", 2);
		
		CommonMethods.scrollDown(500);
		
		CommonMethods.selectByIndex("closureReason_XPATH", 1);
		
		CommonMethods.Click("saveAndProceedBtn_XPATH");
		Thread.sleep(4000);
		
		CommonMethods.ExWait("caseStatusCode_XPATH");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("caseStatusCode_XPATH"))).isDisplayed());
		String casestatusCode = driver.findElement(By.xpath(CommonMethods.readPropertyFile("caseStatusCode_XPATH"))).getText();
		System.out.println(casestatusCode);
		Thread.sleep(3000);
		Assert.assertEquals("Case Closed", casestatusCode,"statuscode mismatch");
		ScreenShot.takeSnapShot("SR Closed", "Pass");
	}
	
	//DE User edit SR as A Close
	public void editSRASAClose() throws Exception {
		CommonMethods.scrollAtBottom();
		CommonMethods.Click("app_EditBtn_XPATH");
		CommonMethods.ExWait("closeMilestone_XPATH");
		CommonMethods.Click("closeMilestone_XPATH");
		Thread.sleep(4000);
		CommonMethods.scrollAtBottom();
		
	}
	
	//DE User Click on Report tab
	public void clickOnReportTab() throws UnhandledException, IOException {
		CommonMethods.Click("deReportTab_XPATH");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("pageHeading_XPATH"))).isDisplayed());
		CommonMethods.Click("accountObjectreport_XPATH");
		CommonMethods.Click("deComprehensiveSRReport_XPATH");
		log.info("Click On SR Comprehensive report");
		CommonMethods.switchwindow();
		CommonMethods.Click("executeBtn");
		log.info("Click On Execute");
		log.info("After Click on Report report details displayed");
		System.out.println(driver.getCurrentUrl());
		
	}
	
	
	public void selectSubSubCategoryCERSAIRelatedCharges() {
		
		CommonMethods.sendkeys("subsubCategoryInput_XPATH", "CERSAI");
		CommonMethods.Click("CERSAISubSubCategory_XPATH");
		log.info("Sub Sub Category Selected");
	}
	
	public void verifyServiceTypeISAutoPopulated() throws Exception {
		log.info("ServiceType Field are auto Selected");
		String actualServiceType=CommonMethods.toGetAttributeValue("serviceType_XPATH");
		System.out.println(actualServiceType);
		String expectedServiceType="Request";
		Assert.assertEquals(expectedServiceType, actualServiceType);
	}
	
	
	public void enterLoanDetails(String sheetName) throws IOException, InterruptedException {
		
		String loannumber  =ExcelOperation.getCellData(sheetName, "LoanNumber", 1);
		CommonMethods.sendkeys("loanNumberForSR_XPATH", loannumber);
		log.info("Loan Number Entered");
		
		// select date
		CommonMethods.scrollDown(500);
		Thread.sleep(4000);
		CommonMethods.Click("calender_XPATH");
		Thread.sleep(3000);
		CommonMethods.Click("selectDate_XPATH");
		Thread.sleep(3000);
		log.info("Date of loan Closure Selected");
		
		CommonMethods.Click("saveAndProceedBtn_XPATH");
		log.info("Click On Save And Proceed Button");
		
	}
	
	public void verifyCaseOwnerISUpdated() throws UnhandledException, IOException {
		log.info("Verify Case Owner");
		String actualCaseOwner=driver.findElement(By.xpath(CommonMethods.readPropertyFile("caseOwner_XPATH"))).getText();
		System.out.println(actualCaseOwner);
		String expectedCaseOwner="COP_Asset_NOC_Team";
		Assert.assertEquals(expectedCaseOwner, actualCaseOwner);
	}
	
	
	//edit SR FOR Re-assignment Flag
	public void editSRAsAReAssignmentFlag() throws Exception{
		CommonMethods.Click("app_EditBtn_XPATH");
		CommonMethods.ExWait("processMileStone_XPATH");
		CommonMethods.Click("processMileStone_XPATH");
		CommonMethods.Click("reassignmentFlag_XPATH");
		CommonMethods.scrollByVisibilityofElement("reassignmentSrch_XPATH");
		CommonMethods.ExWait("reassignmentSrch_XPATH");
		CommonMethods.Click("reassignmentSrch_XPATH");
		CommonMethods.Click("reassignmentReason_XPATH");
		CommonMethods.Click("app_OKBtn_XPATH");
		Thread.sleep(4000);
		CommonMethods.Click("additionalInformationReason_XPATH");
		CommonMethods.Click("reassignmentReason_XPATH");
		CommonMethods.Click("app_OKBtn_XPATH");
		
		CommonMethods.Click("saveAndProceedBtn_XPATH");
		log.info("Click On Save And Proceed Button");
		CommonMethods.ExWait("caseStatusCode_XPATH");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("caseStatusCode_XPATH"))).isDisplayed());
		String casestatusCode = driver.findElement(By.xpath(CommonMethods.readPropertyFile("caseStatusCode_XPATH"))).getText();
		System.out.println(casestatusCode);
		Thread.sleep(3000);
		Assert.assertEquals("Re-Assignment Required", casestatusCode,"statuscode mismatch");
	}
	
	
}