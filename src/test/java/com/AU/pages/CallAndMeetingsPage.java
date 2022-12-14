package com.AU.pages;

import java.util.Random;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.AU.commonUtilities.CommonMethods;
import com.AU.commonUtilities.ExcelOperation;
import com.AU.listeners.TestListeners;





public class CallAndMeetingsPage extends TestListeners{
	
	public String sheetName = "CallMeetingDetails";
	
	
	
	
	
	public void CSEUserAbleToClickOnSummary() throws Exception {
		log.info("CSE User Click On Summary");
		CommonMethods.Click("SummaryTab_XPATH");
		System.out.println(driver.getCurrentUrl());
		log.info("CSE User navigate to Summary Page");
		CommonMethods.verifyTextOfElement("pageHeading_XPATH", "Summary");
		//ScreenShot.takeSnapShot("click on summary tab","Pass");
	}
	 
	public void VerifyCSEUserAbleToClickOnLogACallAndOpenNewWindow() throws Exception {
		
		//CommonMethods.isElementDisplayed("callMeetingHeading_XPATH");
		//Assert.assertEquals(true, callMeetingHeading.isDisplayed());
		//Assert.assertEquals(true, threeDots.isDisplayed());
		//CommonMethods.isElementDisplayed("threeDots_XPATH");
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("threeDots_XPATH"))).isDisplayed());
		log.info("CSE User Click on Three Dots");
		CommonMethods.ExWait("threeDots_XPATH");
		CommonMethods.Click("threeDots_XPATH");
		CommonMethods.ExWait("logacall_XPATH");
		CommonMethods.getElementText("logacall_XPATH");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("logacall_XPATH"))).isDisplayed());
		//CommonMethods.isElementDisplayed("logacall_XPATH");
		//CommonMethods.Click(logacall);
		//CommonMethods.click("logacall_XPATH");
		CommonMethods.moveToElementAndClick("logacall_XPATH");
		CommonMethods.switchwindow();
		log.info("After Click on log a call new window opened");
		System.out.println(driver.getCurrentUrl());
		CommonMethods.ExWait("newpagecallMeeting_XPATH");
		//CommonMethods.isElementDisplayed("newpagecallMeeting_XPATH");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("newpagecallMeeting_XPATH"))).isDisplayed());
	}
	
	public void verifyIncomeAndBuisnessProfilerFieldsDisplayed() throws Exception {
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("callMeeting_XPATH"))).isDisplayed());
		//CommonMethods.isElementDisplayed("callMeeting_XPATH");
		CommonMethods.Click("appproductSearch_XPATH");
		Thread.sleep(6000);
		CommonMethods.moveToElementAndClick("appproduct_XPATH");
		CommonMethods.moveToElementAndClick("buisnessProduct_XPATH");
		CommonMethods.ExWait("app_OKBtn_XPATH");
		CommonMethods.Click("app_OKBtn_XPATH");
		System.out.println("Checkboxes Selected");
		CommonMethods.scrollDown(500);
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("incomeProfiler_XPATH"))).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("buisnessProfiler_XPATH"))).isDisplayed());
		//CommonMethods.isElementDisplayed("incomeProfiler_XPATH");
		//CommonMethods.isElementDisplayed("buisnessProfiler_XPATH");
	}
	
	public void createNewCallMeeting(String sheetName) throws Exception {
		
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("callMeeting_XPATH"))).isDisplayed());
		//CommonMethods.isElementDisplayed("callMeeting_XPATH");
		System.out.println("Enter Call And Meetings Details");
		log.info("Enter Call & Meeting Details");
		
		//Select product
		/*CommonMethods.click("appproductSearch_XPATH");
		CommonMethods.ExplicitWait("appproduct_XPATH");
		CommonMethods.selectCheckbox("appproduct_XPATH");
		CommonMethods.moveToElementAndClick("appproduct_XPATH");
		CommonMethods.moveToElementAndClick("buisnessProduct_XPATH");
		CommonMethods.ExplicitWait("app_OKBtn_XPATH");
		CommonMethods.click("app_OKBtn_XPATH");
		log.info("Select Product");*/
		
		//Enter Mobile No
		String mobilenumber = CommonMethods.generateRandomMobileNumber();
		System.out.println("Actual mobile no: " + mobilenumber);
		System.out.println();
		ExcelOperation.writeToExcel(sheetName, 1, 5, mobilenumber);
		//CommonMethods.input("app_MobileNo_XPATH", mobilenumber);
		CommonMethods.input("app_MobileNo_XPATH", sheetName,"Mobile",1);
		log.info("Enter Mobile No: " + mobilenumber);
		
		//Enter Customer Name
		Random random = new Random();
		char c = (char) (random.nextInt(26) + 'a');
		String custname = ExcelOperation.getCellData(sheetName, "Customer Name", 1);
		String actualcustname = custname + c;
		System.out.println("Actual account name Entered:  " + actualcustname);
		System.out.println();
		ExcelOperation.writeToExcel(sheetName, 1, 6, actualcustname);
		CommonMethods.input("app_CustName_XPATH",sheetName,"Customer Name",1);
		log.info("Enter Customer Name " + actualcustname);
		
		// select date
		/*CommonMethods.scrollDown(500);
		CommonMethods.Click("calender_XPATH");
		CommonMethods.Click("selectDate_XPATH");
		CommonMethods.Click("timeIcon_XPATH");
		CommonMethods.Click("selectTime_XPATH");
		log.info("Appointment Date Selected");*/
		
		// Select Mode of Interaction
		CommonMethods.selectByIndex("modeOfInteraction_XPATH", 1);
		log.info("Mode Of Interaction Selected");
		
		// select product pitched
		CommonMethods.Click("productAndSercvices_XPATH");
		Thread.sleep(3000);
		CommonMethods.selectCheckbox("appproduct_XPATH");
		CommonMethods.moveToElementAndClick("appproduct_XPATH");
		Thread.sleep(3000);
		CommonMethods.Click("app_OKBtn_XPATH");
		log.info("Product pitched selected");
		
		//select outcome of interaction
		CommonMethods.selectByIndex("status_XPATH", 1);
		log.info("Outcome of interaction Selected");
		
		//Select expected date and time
		CommonMethods.scrollDown(500);
		CommonMethods.Click("expectedDate_XPATH");
		CommonMethods.Click("selectDate_XPATH");
		CommonMethods.Click("expectedTime_XPATH");
		CommonMethods.Click("selectTime_XPATH");
		log.info("Expected Date and Time Selected");
		
		//Enter Discussion summary
		String DissSummary = ExcelOperation.getCellData(sheetName, "Discussion Summary", 1);
		CommonMethods.sendkeys("appDiscussionSummary_XPATH", DissSummary);
		log.info("Entered Discussion Summary");
		
	
		
		
		// select Employement Type
		CommonMethods.selectByIndex("empType_XPATH", 6);
		log.info("Employement Type Selected");

		// Select Employer Type/Industry
		CommonMethods.Click("industryType_XPATH");
		CommonMethods.Click("industry_XPATH");
		log.info("Employer Type/ Industry Selected");

		// select Department
		CommonMethods.Click("departmentType_XPATH");
		CommonMethods.Click("dep_XPATH");
		log.info("Department Selected");

		// select profession
		CommonMethods.Click("professionSearch_XPATH");
		CommonMethods.Click("profession_XPATH");
		log.info("Profession Selected");
		
		// Click on Save Button
		//TestUtil.takeScreenShot("Appointment Created");
		CommonMethods.Click("saveBtn_XPATH");
		log.info("Click on Save Button");
	}
	public void VerifyCallMeetingCreated(String sheetName ) throws Exception {
		log.info("Verify Call and Meeting is Sucessfully Created");
		//CommonMethods.switchtoparentwindow();
		//driver.switchTo().defaultContent();
	//	CommonMethods.ExplicitWait("callMeetingHeading_XPATH");
		CommonMethods.switchToWindowByTitle("CRMnext - Smart.Easy.Complete");
		System.out.println(CommonMethods.getElementText("callMeeting1_XPATH"));
		//CommonMethods.isElementDisplayed("callMeeting1_XPATH");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("callMeeting1_XPATH"))).isDisplayed());
		String expectedCallMeetingName =ExcelOperation.getCellData(sheetName, "Customer Name", 1);
		String actualCallMeetingName=driver.findElement(By.xpath(CommonMethods.readPropertyFile("callMeetingcustname_XPATH"))).getText();
		Assert.assertEquals(actualCallMeetingName, expectedCallMeetingName, "Call Meeting Customer Name Mismatched");
	}
	

}
