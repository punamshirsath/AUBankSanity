package com.AU.pages;

import java.io.IOException;

import org.apache.commons.lang.UnhandledException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.AU.commonUtilities.CommonMethods;
import com.AU.commonUtilities.ExcelOperation;
import com.AU.commonUtilities.ScreenShot;
import com.AU.listeners.TestListeners;






public class TaskPage extends TestListeners{
	
	public static Logger log =LogManager.getLogger(TaskPage.class.getName());
	
	
	
	public String tasksheet ="TaskLeadCreationtest";
	
	//Click On Task Tab
	public void clickOnTaskTab() throws Exception {
		CommonMethods.ExWait("cseTaskTab_XPATH");
		CommonMethods.Click("cseTaskTab_XPATH");
		System.out.println("CSE User Click On Task Tab");
		log.info("CSE User Click On Task Tab");
		System.out.println(driver.getCurrentUrl());
		String title = driver.findElement(By.xpath(CommonMethods.readPropertyFile("pageHeading_XPATH"))).getText();
		 Assert.assertEquals("Tasks", title,"Title Mismatched");
		 
	}
	
	
	//Click On New Task Button
	public void clickOnNewButtonOfTask() throws Exception {
		CommonMethods.ExWait("pageHeading_XPATH");
		//Thread.sleep(3000);
		CommonMethods.ExWait("appnewBtn_XPATH");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("appnewBtn_XPATH"))).isDisplayed());
		Thread.sleep(3000);
		CommonMethods.Click("appnewBtn_XPATH");
		Thread.sleep(3000);
		CommonMethods.Click("defaultTask_XPATH");
		CommonMethods.switchwindow();
		log.info("After Click on New Default new Task Window opened");
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("newTaskWindow_XPATH"))).isDisplayed());
		ScreenShot.takeSnapShot("Window Of New Task", "Pass");
		
	}
	
	public void viewSectionInTaskPage() throws Exception {
		log.info("CSE User Click on Task Tab");
		CommonMethods.Click("cseTaskTab_XPATH");
		System.out.println(driver.getCurrentUrl());
		String title = driver.findElement(By.xpath(CommonMethods.readPropertyFile("pageHeading_XPATH"))).getText();
		System.out.println(title);
		log.info("CSE User navigate to Task Page");
		Assert.assertEquals("Tasks", title, "title mismatch");
		Assert.assertEquals(true,driver.findElement(By.xpath(CommonMethods.readPropertyFile("view_XPATH"))).isDisplayed());
		Assert.assertEquals(true,driver.findElement(By.xpath(CommonMethods.readPropertyFile("dropdown1_XPATH"))).isDisplayed());
		Assert.assertEquals(true,driver.findElement(By.xpath(CommonMethods.readPropertyFile("dropdown2_XPATH"))).isDisplayed());
		Assert.assertEquals(true,driver.findElement(By.xpath(CommonMethods.readPropertyFile("arrowbtn_XPATH"))).isDisplayed());
		CommonMethods.Click("arrowbtn_XPATH");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("taskID_XPATH"))).isDisplayed());
		ScreenShot.takeSnapShot("View Section Dispalyed", "Pass");
	}
	
	public void createNewTask() throws Exception {
		log.info("CSE User Create New Task");
		//CommonMethods.switchwindow();
		
		//Select subject
		CommonMethods.Click("subjectSearch_XPATH");
		Thread.sleep(3000);
		CommonMethods.mouseClick("subject_XPATH");
		
		//select Task Name
		CommonMethods.Click("taskSearch_XPATH");
		Thread.sleep(3000);
		CommonMethods.mouseClick("task_XPATH");
		
		//select customer contacted dropdown
		CommonMethods.selectByIndex("customerContacted_XPATH", 1);
		log.info("Customer Contacted");
		
		//Select Customer Interested
	     CommonMethods.selectByIndex("customerInterested_XPATH", 1);
		log.info("Customer Intrested");
		
		//Enter Description
		CommonMethods.input("description_XPATH", tasksheet, "Description", 1);
		//String description = ExcelOperation.getCellData1(tasksheet, "Description", 1);
		//CommonMethods.sendkeys("description_XPATH", description);
		log.info("Enter description of task");
		
		//Select Status
		CommonMethods.selectByIndex("status_XPATH", 2);
		log.info("status of task ");
		
		//Select realated Customer
		CommonMethods.selectByIndex("relatedTo_XPATH", 1);
		log.info("Related To Field Selected");
		
		//select prospect Customer
		CommonMethods.ExWait("prospectCustomerCB_XPATH");
		CommonMethods.Click("prospectCustomerCB_XPATH");
		//CommonMethods.moveToElementAndClick("prospectCustomerCB_XPATH");
		log.info("Prospect Customer Selected");
		
		//Click on Save Button
		CommonMethods.Click("saveBtn_XPATH");
		Thread.sleep(4000);
		log.info("Click on Save Button");
		//ScreenShot.takeSnapShot("Task Created", "Pass");
	}
	
	public void editCreatedTask() throws Exception {
		CommonMethods.switchtoparentwindow();
		CommonMethods.ExWait("pageHeading_XPATH");
		CommonMethods.selectByIndex("dropdown1_XPATH", 1);
		CommonMethods.selectByIndex("dropdown2_XPATH", 2);
		CommonMethods.Click("arrowbtn_XPATH");
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("taskID_XPATH"))).isDisplayed());
		CommonMethods.mouseHover("taskThreeDots_XPATH");
		CommonMethods.Click("editTask_XPATH");
		CommonMethods.switchwindow();
		CommonMethods.scrollDown(500);
		//Change Status
		CommonMethods.selectByIndex("status_XPATH", 5);
		log.info("Change the status of Task");
		
		//Click on Save Button
		CommonMethods.Click("saveBtn_XPATH");
		Thread.sleep(4000);
		log.info("Click on Save Button");
		CommonMethods.switchtoparentwindow();
		CommonMethods.selectByIndex("dropdown1_XPATH", 1);
		CommonMethods.selectByIndex("dropdown2_XPATH", 1);
		CommonMethods.Click("arrowbtn_XPATH");
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("editedTask_XPATH"))).isDisplayed());
	}
	
	
	public void clickOnTaskUsingFOSUser() throws Exception {
		log.info("FOS User Click on Task Tab");
		CommonMethods.Click("fosTaskTab_XPATH");
		System.out.println(driver.getCurrentUrl());
		String title = driver.findElement(By.xpath(CommonMethods.readPropertyFile("pageHeading_XPATH"))).getText();
		System.out.println(title);
		log.info("FOS User navigate to Task Page");
		Assert.assertEquals("Tasks", title, "title mismatch");
		CommonMethods.ExWait("appnewBtn_XPATH");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("appnewBtn_XPATH"))).isDisplayed());
		Thread.sleep(3000);
		CommonMethods.Click("appnewBtn_XPATH");
		Thread.sleep(3000);
		CommonMethods.Click("defaultTask_XPATH");
		CommonMethods.switchwindow();
		log.info("After Click on New Default new Task Window opened");
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("newTaskWindow_XPATH"))).isDisplayed());
		ScreenShot.takeSnapShot("Window Of New Task", "Pass");
	}
	
	public void createNewTaskUsingFOSUser() throws Exception {
		
		log.info("FOS User Create New Task");
		//CommonMethods.switchwindow();
		
		//Select subject
		CommonMethods.Click("subjectSearch_XPATH");
		Thread.sleep(3000);
		CommonMethods.mouseClick("subject_XPATH");
		
		//select Task Name
		CommonMethods.Click("taskSearch_XPATH");
		Thread.sleep(3000);
		CommonMethods.mouseClick("task_XPATH");
		
		//select customer contacted dropdown
		CommonMethods.selectByIndex("customerContacted_XPATH", 1);
		log.info("Customer Contacted");
		
		//Select Customer Interested
	     CommonMethods.selectByIndex("customerInterested_XPATH", 1);
		log.info("Customer Intrested");
		
		//Enter Description
		//String description = ExcelOperation.getCellData1(tasksheet, "Description", 1);
		//CommonMethods.sendkeys("description_XPATH", description);
		CommonMethods.input("description_XPATH", tasksheet, "Description", 1);
		log.info("Enter description of task");
		
		//Select Status
		CommonMethods.selectByIndex("status_XPATH", 2);
		log.info("status of task ");
		
		//Select realated Customer
		CommonMethods.selectByIndex("relatedTo_XPATH", 1);
		log.info("Related To Field Selected");
		
		//select prospect Customer
		CommonMethods.ExWait("prospectCustomerCB_XPATH");
		CommonMethods.Click("prospectCustomerCB_XPATH");
		//CommonMethods.moveToElementAndClick("prospectCustomerCB_XPATH");
		log.info("Prospect Customer Selected");
		
		//Click on Save Button
		CommonMethods.Click("saveBtn_XPATH");
		Thread.sleep(4000);
		log.info("Click on Save Button");
		
	}
	
	public void verifyTaskIsCreatedByFOS() throws Exception {
		
		CommonMethods.switchtoparentwindow();
		CommonMethods.selectByIndex("dropdown1_XPATH", 1);
		CommonMethods.selectByIndex("dropdown2_XPATH", 1);
		CommonMethods.Click("arrowbtn_XPATH");
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("taskID_XPATH"))).isDisplayed());
		
	}
	
	public void editCreatedTaskByFOS() throws Exception {
		
		CommonMethods.mouseHover("taskThreeDots_XPATH");
		CommonMethods.Click("editTask_XPATH");
		CommonMethods.switchwindow();
		CommonMethods.scrollDown(500);
		//Change Status
		CommonMethods.selectByIndex("status_XPATH", 5);
		log.info("Change the status of Task");
		
		//Click on Save Button
		CommonMethods.Click("saveBtn_XPATH");
		Thread.sleep(4000);
		log.info("Click on Save Button");
		CommonMethods.switchtoparentwindow();
		CommonMethods.selectByIndex("dropdown1_XPATH", 1);
		CommonMethods.selectByIndex("dropdown2_XPATH", 1);
		CommonMethods.Click("arrowbtn_XPATH");
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("editedTask_XPATH"))).isDisplayed());
	}
	
	
	
	
	
	
}
