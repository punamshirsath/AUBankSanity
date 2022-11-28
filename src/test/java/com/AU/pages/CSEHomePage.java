package com.AU.pages;


import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.AU.commonUtilities.CommonMethods;
import com.AU.commonUtilities.ExcelOperation;
import com.AU.commonUtilities.ScreenShot;
import com.AU.listeners.TestListeners;



public class CSEHomePage extends TestListeners {
	
	public static Logger log =LogManager.getLogger(TaskPage.class.getName());

	public String sheetName = "TaskDetails";
	public String sheetName1 = "AppointmentDetails";
	public static String updatedAdharCard=System.getProperty("user.dir") +"\\src\\test\\resources\\Documents\\-AADHAAR-Card.png";


	// Move to recent items and click on recent items
	public void clickOnRecentItems() throws Exception {
		Thread.sleep(1000);
		CommonMethods.mouseHover("recentItems_XPATH");
		CommonMethods.highLight("recentItems_XPATH");
		Thread.sleep(2000);
		CommonMethods.highLight("recentfirstItems_XPATH");
		CommonMethods.Click("recentfirstItems_XPATH");

	}

	// click On Activities Tab
	public void clickOnActivitiestab() throws Exception {
		CommonMethods.mouseHover("activitiesTab_XPATH");
		CommonMethods.highLight("activitiesTab_XPATH");
		CommonMethods.Click("activitiesTab_XPATH");

	}

	// click On New Task Link
	public void clickOnNewTaskLink() throws Exception {

		// CommonMethods.highLight("newTask_XPATH");
		CommonMethods.mouseHover("newTask_XPATH");

		CommonMethods.Click("defaultTask_XPATH");
	}

	// Create new Task
	public void createNewTask() throws Exception {
		log.info("CSE User Create New activity/Task");
		CommonMethods.switchwindow();

		// Select subject
		CommonMethods.Click("subjectSearch_XPATH");
		Thread.sleep(3000);
		CommonMethods.moveToElementAndClick("subject_XPATH");

		// select Task Name
		CommonMethods.Click("taskSearch_XPATH");
		Thread.sleep(3000);
		CommonMethods.moveToElementAndClick("task_XPATH");

		// select customer contacted dropdown
		CommonMethods.selectByIndex("customerContacted_XPATH", 1);
		log.info("Customer Contacted");

		// Select Customer Interested
		CommonMethods.selectByIndex("customerInterested_XPATH", 1);
		log.info("Customer Intrested");

		// Enter Description
		String description = ExcelOperation.getCellData(sheetName, "Description", 1);
		CommonMethods.sendkeys("description_XPATH", description);
		log.info("Enter description of task");

		// Select Status
		CommonMethods.selectByIndex("status_XPATH", 2);
		log.info("status of task ");

		// Click on Save Button
		CommonMethods.Click("saveBtn_XPATH");
		log.info("Click on Save Button");

		// TestUtil.takeScreenShot("Task Created");
	}

	// verify New Task is created
	public void toVerifyTaskIsCreated() throws Exception {
		CommonMethods.switchtoparentwindow();
		Assert.assertTrue(
				driver.findElement(By.xpath(CommonMethods.readPropertyFile("newTaskCreated_XPATH"))).isDisplayed());
		ScreenShot.takeSnapShot("Task Created Sucessfully", "Pass");
	}

	// click on new call & meetings
	public void clickOnNewCallAndMeetingsLink() throws Exception {
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("leadnewcallandMeetings_XPATH")))
				.isDisplayed());
		CommonMethods.highLight("leadnewcallandMeetings_XPATH");
		CommonMethods.Click("leadnewcallandMeetings_XPATH");

	}

	// create New Appointment
	public void CreateAppointment(String sheetName) throws Exception {
		CommonMethods.switchwindow();
		log.info("CSE User Create New Appointment");
		// Select product
		CommonMethods.Click("appproductSearch_XPATH");
		Thread.sleep(3000);

		CommonMethods.selectCheckbox("appproduct_XPATH");
		CommonMethods.moveToElementAndClick("appproduct_XPATH");
		System.out.println("Checkbox Selected");

		Thread.sleep(3000);

		CommonMethods.Click("app_OKBtn_XPATH");
		log.info("CSE User Select Product Services");
		// Enter mobile no
		String mobilenumber = CommonMethods.generateRandomMobileNumber();
		System.out.println("Actual mobile no: " + mobilenumber);
		System.out.println();
		ExcelOperation.writeToExcel(sheetName, 1, 5, mobilenumber);

		CommonMethods.sendkeys("app_MobileNo_XPATH", mobilenumber);
		log.info("Enter Mobile No: " + mobilenumber);

		// Enter customer name
		Random random = new Random();
		char c = (char) (random.nextInt(26) + 'a');
		String custname = ExcelOperation.getCellData(sheetName, "Customer Name", 1);
		String actualcustname = custname + c;
		System.out.println("Actual Customer name Entered:  " + actualcustname);
		System.out.println();
		// ExcelOperation.writeToExcel(sheetName1, 1, 1, actualcustname);
		// CommonMethods.sendkeys("app_CustName_XPATH", custname);
		CommonMethods.sendkeys("app_CustName_XPATH", actualcustname);
		ExcelOperation.writeToExcel(sheetName, 1, 6, actualcustname);
		log.info("Enter Customer Name " + actualcustname);

		// select date
		CommonMethods.scrollDown(500);
		CommonMethods.Click("calender_XPATH");
		CommonMethods.Click("selectDate_XPATH");
		CommonMethods.Click("timeIcon_XPATH");
		CommonMethods.Click("selectTime_XPATH");
		log.info("Appointment Date Selected");

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
		
		//Select expected date and time
		CommonMethods.scrollDown(500);
		CommonMethods.Click("expectedDate_XPATH");
		CommonMethods.Click("selectDate_XPATH");
		CommonMethods.Click("expectedTime_XPATH");
		CommonMethods.Click("selectTime_XPATH");
		log.info("Expected Date and Time Selected");
		
		//Enter Discussion Summary
		String summary = ExcelOperation.getCellData(sheetName, "Discussion Summary", 1);
		CommonMethods.sendkeys("appDiscussionSummary_XPATH", summary);
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
		// TestUtil.takeScreenShot("Appointment Created");
		CommonMethods.Click("saveBtn_XPATH");
		log.info("Click on Save Button");

	}

	public void VerifyAppointmentIsCreated(String sheetName) throws Exception {

		Thread.sleep(4000);
		CommonMethods.switchtoparentwindow();

		// Click on Appointment tab
		Thread.sleep(4000);
		CommonMethods.Click("appointmentTab_XPATH");
		System.out.println("Clicked On Appointment Tab");

		CommonMethods.ExWait("apppageTitle_XPATH");
		CommonMethods.selectByIndex("appdropdown1_XPATH", 0);
		CommonMethods.selectByIndex("appdropdown2_XPATH", 1);
		CommonMethods.Click("arrowBtn_XPATH");

		Assert.assertTrue(
				driver.findElement(By.xpath(CommonMethods.readPropertyFile("appointment1_XPATH"))).isDisplayed());
		String expectedCustName = ExcelOperation.getCellData(sheetName, "Customer Name", 1);
		String actualCustName = driver.findElement(By.xpath(CommonMethods.readPropertyFile("appcustname_XPATH")))
				.getText();
		Assert.assertEquals(actualCustName, expectedCustName, "Customer Name Mismatched");

	}

	// Click on Lead tab
	public void clickOnLeadTab() throws Exception {
		Thread.sleep(1000);
		CommonMethods.highLight("leadTab_XPATH");
		CommonMethods.Click("leadTab_XPATH");
	}

	// select DDE Stage Lead
	public void selectDDEStageLead() throws Exception {
		CommonMethods.scrollDown(500);
		CommonMethods.selectByIndex("appdropdown1_XPATH", 2);
		CommonMethods.selectByIndex("appdropdown2_XPATH", 2);
		CommonMethods.Click("arrowBtn_XPATH");
		Thread.sleep(2000);
		CommonMethods.Click("devlead_XPATH");
		Thread.sleep(3000);

	}
	
	public void clickOnAttachmentTab() throws Exception {
		   CommonMethods.ExWait("AttachmentTab_XPATH");
		   CommonMethods.Click("AttachmentTab_XPATH");
		   Thread.sleep(2000);
		  
		   Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("attachNewDocument_XPATH"))).isDisplayed());
		   CommonMethods.Click("attachNewDocument_XPATH");
		   Thread.sleep(2000);
		   CommonMethods.switchwindow();
		   System.out.println(driver.getCurrentUrl());
		   Thread.sleep(2000);
		  // Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("attachDocumentIcon_XPATH"))).isDisplayed());
		   //CommonMethods.Click("attachDocumentIcon_XPATH");
		   
		  // CommonMethods.scrollDown(500);
			CommonMethods.moveToElementAndClick("attachDocumentIcon_XPATH");
			CommonMethods.FileUpload(updatedAdharCard);
			Thread.sleep(2000);
			CommonMethods.Click("saveBtn_XPATH");
		   
	   }
	
	public void verifyDocumentAttached() throws Exception {
		System.out.println("Verify document attached sucessfully");
		CommonMethods.switchtoparentwindow();
		ScreenShot.takeSnapShot("Document Attach Sucessfully", "Pass");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("documentAttached_XPATH"))).isDisplayed());
	}

}
