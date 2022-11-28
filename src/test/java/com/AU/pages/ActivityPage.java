package com.AU.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.AU.commonUtilities.CommonMethods;
import com.AU.commonUtilities.ExcelOperation;
import com.AU.commonUtilities.ScreenShot;
import com.AU.listeners.TestListeners;






public class ActivityPage extends TestListeners {
	
	
	public String Activitysheet="ActivityDetails";
	public String task="TaskDetails";
	
	//Click on recent Items
	public void clickOnRecentItemsOfLead() throws Exception {
		CommonMethods.moveToElementAndClick("recent_items_XPATH");
		CommonMethods.ExWait("leadIcon_XPATH");
		//Thread.sleep(3000);
		CommonMethods.moveToElementAndClick("leadIcon_XPATH");
		CommonMethods.Click("leadIcon_XPATH");
		log.info("Click On Recent Lead");
	}
	
	//Click on recent items of customer
	public void clickOnRecentItemsOfCustomer() throws IOException, InterruptedException {
		CommonMethods.moveToElementAndClick("recent_items_XPATH");
		CommonMethods.moveToElementAndClick("customerIcon_XPATH");
		log.info("Click On Recent Customer");
	}
	
	//click on toggle button
	public void clickOnToggleBtn() {
		log.info("Click on toggle Button");
		CommonMethods.Click("toggleBtn_XPATH");
		
	}
	
	public void clickOnActivitiesLead() throws IOException, InterruptedException {
		log.info("Click on toggle Button");
		CommonMethods.Click("toggleBtn_XPATH");
		log.info("Click on activities tab");
		CommonMethods.Click("activitiesTab_XPATH");
		//log.info("Click on New Call & Meetings");
		//CommonMethods.click("newCallAndMeeting_XPATH");
	}
	
	public void clickOnActivitiesCustomer() throws Exception {
		log.info("Click on toggle Button");
		CommonMethods.Click("toggleBtn_XPATH");
		Thread.sleep(2000);
		CommonMethods.Click("moreTabs_XPATH");
		log.info("Click on activities tab");
		Thread.sleep(2000);
		CommonMethods.Click("activitiesTab1_XPATH");
		
		CommonMethods.Click("openActivity_XPATH");
		CommonMethods.ExWait("newTaskCustomer_XPATH");
		CommonMethods.Click("newTaskCustomer_XPATH");
		
	}
	
	/*public void CreateActivity() throws IOException, InterruptedException {
		CommonMethods.switchwindow();
		log.info("CSE User Create New Appointment");
		//Select product
		CommonMethods.Click("appproductSearch_XPATH");
		Thread.sleep(3000);
	
		CommonMethods.selectCheckbox("appproduct_XPATH");
		CommonMethods.moveToElementAndClick("appproduct_XPATH");
		System.out.println("Checkbox Selected");

		Thread.sleep(3000);

		CommonMethods.click("app_OKBtn_XPATH");
		log.info("CSE User Select Product Services");
		//Enter mobile no
		String mobilenumber = CommonMethods.generateRandomMobileNumber();
		System.out.println("Actual mobile no: " +mobilenumber);
		System.out.println();
		TestUtil.writeToExcel(Activitysheet, 1, 0, mobilenumber);
		CommonMethods.input("app_MobileNo_XPATH", mobilenumber);
		log.info("Enter Mobile No: " +mobilenumber);
		
		//Enter customer name
		Random random = new Random();
		char c = (char) (random.nextInt(26) + 'a');
		String custname = TestUtil.getCellData(Activitysheet, "Customer Name", 1);
		String actualcustname = custname + c;
		System.out.println("Actual account name Entered:  " + actualcustname);
		System.out.println();
		CommonMethods.input("app_CustName_XPATH", custname);
		TestUtil.writeToExcel(Activitysheet, 1, 1, actualcustname);
		log.info("Enter Customer Name " +actualcustname);
		
		//select date
		CommonMethods.scrollDown(500);
		CommonMethods.Click("calender_XPATH");
		CommonMethods.Click("selectDate_XPATH");
		CommonMethods.Click("timeIcon_XPATH");
		CommonMethods.Click("selectTime_XPATH");
		log.info("Appointment Date Selected");
		
		//Select Mode of Interaction
		CommonMethods.selectByIndex("modeOfInteraction_XPATH", 1);
		log.info("Mode Of Interaction Selected");
		
		//select product pitched
		CommonMethods.Click("productAndSercvices_XPATH");
		Thread.sleep(3000);
		CommonMethods.selectCheckbox("appproduct_XPATH");
		CommonMethods.moveToElementAndClick("appproduct_XPATH");
		Thread.sleep(3000);
		CommonMethods.Click("app_OKBtn_XPATH");
		log.info("Product pitched selected");
		
		//select Employement Type
		CommonMethods.selectByIndex("empType_XPATH", 6);
		log.info("Employement Type Selected");
		
		//Select Employer Type/Industry
		CommonMethods.Click("industryType_XPATH");
		CommonMethods.Click("industry_XPATH");
		log.info("Employer Type/ Industry Selected");
		
		//select Department
		CommonMethods.Click("departmentType_XPATH");
		CommonMethods.Click("dep_XPATH");
		log.info("Department Selected");
		
		//select profession
		CommonMethods.Click("professionSearch_XPATH");
		CommonMethods.Click("profession_XPATH");
		log.info("Profession Selected");
		
		//Click on Save Button
		TestUtil.takeScreenShot("Appointment Created");
		CommonMethods.Click("saveBtn_XPATH");
		log.info("Click on Save Button");
		
	}*/
	
	
	public void clickONNewTask() throws IOException, InterruptedException {
		log.info("CSE User Click on New Task");
		CommonMethods.Click("newTask_XPATH");
		
	}
	
	public void clickOnDefaultTask() throws Exception {
		log.info("CSE User Click on Default Task");
		CommonMethods.ExWait("defaultTask_XPATH");
		CommonMethods.Click("defaultTask_XPATH");
		
	}
	public void createNewTask(String sheetName) throws Exception {
		log.info("CSE User Create New activity/Task");
		CommonMethods.switchwindow();
		
		//Select subject
		CommonMethods.Click("subjectSearch_XPATH");
		Thread.sleep(3000);
		CommonMethods.moveToElementAndClick("subject_XPATH");
		
		//select Task Name
		CommonMethods.Click("taskSearch_XPATH");
		Thread.sleep(3000);
		CommonMethods.moveToElementAndClick("task_XPATH");
		
		//select customer contacted dropdown
		CommonMethods.selectByIndex("customerContacted_XPATH", 1);
		log.info("Customer Contacted");
		
		//Select Customer Interested
	     CommonMethods.selectByIndex("customerInterested_XPATH", 1);
		log.info("Customer Intrested");
		
		//Enter Description
		String description = ExcelOperation.getCellData(sheetName, "Description", 1);
		CommonMethods.sendkeys("description_XPATH", description);
		log.info("Enter description of task");
		
		//Select Status
		CommonMethods.selectByIndex("status_XPATH", 2);
		log.info("status of task ");
		
		//Click on Save Button
		CommonMethods.Click("saveBtn_XPATH");
		log.info("Click on Save Button");
		//ScreenShot.takeSnapShot("Task Created", "Pass");
	}
	
	public void toVerifyTaskIsCreated() throws Exception {
		CommonMethods.switchtoparentwindow();
		CommonMethods.ExWait("createdActivity_XPATH");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("createdActivity_XPATH"))).isDisplayed());
	   log.info("Activity/ Task Created On ETB Lead");
		//  ScreenShot.takeSnapShot("Task/Activity is Created", "Pass");
	}
	
	public void clickOnTaskTab() throws Exception {
		CommonMethods.Click("cseTaskTab_XPATH");
		log.info("click on task tab");
		CommonMethods.Click("newBtn_XPATH");
		log.info("Click on New Button");
		CommonMethods.ExWait("defaultTask_XPATH");
		CommonMethods.Click("defaultTask_XPATH");
		log.info("Clicked ON Default Task");
		
	}
	
	public void verifyIndependantTaskIsCreated() throws Exception {
		CommonMethods.switchtoparentwindow();
		//Thread.sleep(2000);
		CommonMethods.ExWait("dropdown1_XPATH");
		CommonMethods.selectByIndex("dropdown1_XPATH", 1);
		log.info("Category Selected");
		CommonMethods.selectByIndex("dropdown2_XPATH", 2);
		log.info("View Selected");
		CommonMethods.Click("arrowbtn_XPATH");
		CommonMethods.getElementText("taskID_XPATH");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("taskID_XPATH"))).isDisplayed());
		ScreenShot.takeSnapShot("Task Created Independantly", "Pass");
	
	}


}
