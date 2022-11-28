package com.AU.pages;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.Assert;
import com.AU.commonUtilities.CommonMethods;
import com.AU.commonUtilities.ExcelOperation;
import com.AU.listeners.TestListeners;




public class AppointmentsPage extends TestListeners {



	
	// Methods
	// navigate to appointments
	public void navigateToAppointmnetsTab() throws Exception {
		CommonMethods.Click("appointmentTab_XPATH");
		log.info("CSE User Click On Appointments Tab");
		System.out.println(driver.getCurrentUrl());
		String title = (CommonMethods.getElementText("apppageTitle_XPATH"));
		log.info("Appointments Page Open");
		Assert.assertEquals("Calls and meetings", title, "title mismatch");
		//TestUtil.takeScreenShot("Appointments");
	}

	// click on new + button
	public void openNewAppointmentCreationPage() throws IOException, InterruptedException {
		log.info("CSE User Click on New Button");
		CommonMethods.Click("appnewBtn_XPATH");
		CommonMethods.switchwindow();
		log.info("After Click on New Button  new Calls & Meeting  window opened");
		System.out.println(driver.getCurrentUrl());
		//mAssert.assertEquals(driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator))).isDisplayed());
		//CommonMethods.isElementDisplayed("newpagecallMeeting_XPATH");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("newpagecallMeeting_XPATH"))).isDisplayed());
		//TestUtil.takeScreenShot("New Window of Call And Meeting");
		//driver.close();
	}

	public void CreateAppointment(String sheetName) throws Exception {
		log.info("CSE User Create New Appointment");
		// Select product
		CommonMethods.Click("appproductSearch_XPATH");
		 Thread.sleep(6000);
		 CommonMethods.selectCheckbox("appproduct_XPATH");
			CommonMethods.moveToElementAndClick("appproduct_XPATH");
		System.out.println("Checkbox Selected");
		// Thread.sleep(3000);
		CommonMethods.ExWait("app_OKBtn_XPATH");
		CommonMethods.Click("app_OKBtn_XPATH");
		log.info("CSE User Select Product Services");
		// Enter mobile no
		String mobilenumber = CommonMethods.generateRandomMobileNumber();
		System.out.println("Actual mobile no: " + mobilenumber);
		System.out.println();
		ExcelOperation.writeToExcel(sheetName, 1, 5, mobilenumber);
		CommonMethods.input("app_MobileNo_XPATH", sheetName, "Mobile",1);
		//TestUtil.writeToExcel(sheetName, 1, 0, mobilenumber);
		//CommonMethods.input("app_MobileNo_XPATH", mobilenumber);
		log.info("Enter Mobile No: " + mobilenumber);

		// Enter customer name
		Random random = new Random();
		char c = (char) (random.nextInt(26) + 'a');
		String custname = ExcelOperation.getCellData(sheetName, "Customer Name", 1);
		String actualcustname = custname + c;
		System.out.println("Actual account name Entered:  " + actualcustname);
		System.out.println();
		CommonMethods.input("app_CustName_XPATH",sheetName,"Customer Name",1);
		ExcelOperation.writeToExcel(sheetName, 1, 6, actualcustname);
		//ExcelOperation.writeToExcel(sheetName, 1, 1, actualcustname);
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
		CommonMethods.scrollByVisibilityofElement("saveBtn_XPATH");
		CommonMethods.Click("saveBtn_XPATH");
		log.info("Click on Save Button");

	}

	public void EditAppointment(String sheetName ) throws Exception {
		CommonMethods.switchtoparentwindow();
		//CommonMethods.switchToWindowByTitle("CRMnext - Smart.Easy.Complete");
		Thread.sleep(5000);
		CommonMethods.Click("appointmentTab_XPATH");
		Thread.sleep(5000);
		 CommonMethods.Click("appointment1_XPATH");
		CommonMethods.switchwindow();
		CommonMethods.scrollDown(500);
		CommonMethods.Click("app_EditBtn_XPATH");
		Thread.sleep(3000);
		CommonMethods.scrollDown(500);
		CommonMethods.input("app_ExpectedAmount_XPATH", sheetName, "Edit Exp Amount",1);
		CommonMethods.scrollDown(500);
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("saveBtn_XPATH"))).isDisplayed());
		//CommonMethods.isElementDisplayed("saveBtn_XPATH");
		//TestUtil.takeScreenShot("Appointment edit ");
		CommonMethods.Click("saveBtn_XPATH");
		log.info("Click on Save Button");
		log.info("Edit appointment");
	}

	public void closeAppointment() throws Exception {
		CommonMethods.switchtoparentwindow();
		//CommonMethods.switchToWindowByTitle("CRMnext - Smart.Easy.Complete");
		Thread.sleep(4000);
		//CommonMethods.switchToParentWin();
		CommonMethods.Click("appointmentTab_XPATH");
		//CommonMethods.isElementDisplayed("appView_XPATH");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("appView_XPATH"))).isDisplayed());
		//TestUtil.takeScreenShot("Appointment View Listing");
		log.info("Select View in Appointment Listing");
		System.out.println("click On View Bucket");
		CommonMethods.mouseHover("appThreeDot_XPATH");
		CommonMethods.moveToElementAndClick("appClose_XPATH");
		CommonMethods.switchwindow();
		CommonMethods.scrollDown(500);
       // CommonMethods.isElementDisplayed("saveBtn_XPATH");
        Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("saveBtn_XPATH"))).isDisplayed());
	//	TestUtil.takeScreenShot("Appointment Closed");
		// Thread.sleep(3000);
		CommonMethods.ExWait("saveBtn_XPATH");
		CommonMethods.Click("saveBtn_XPATH");
		System.out.println("Click on Save Button");
		log.info("Click on Save Button");
		log.info("Close Appointment");

	}

	public void viewCategoryListOfAppointmentsDispalyed() throws IOException, InterruptedException {
		CommonMethods.switchToWindowByTitle("CRMnext - Smart.Easy.Complete");
		Thread.sleep(4000);
		log.info("View Bucket Displayed In Appointment Page");
		//CommonMethods.isElementDisplayed("appView_XPATH");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("appView_XPATH"))).isDisplayed());
		//TestUtil.takeScreenShot("Appointment View bucket");
		//CommonMethods.isElementDisplayed("appdropdown1_XPATH");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("appdropdown1_XPATH"))).isDisplayed());
		CommonMethods.getAllOptionsFromDropdown("appdropdown1_XPATH");
		//TestUtil.takeScreenShot("Category Options");
		//CommonMethods.isElementDisplayed("appdropdown2_XPATH");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("appdropdown2_XPATH"))).isDisplayed());
		CommonMethods.getAllOptionsFromDropdown("appdropdown2_XPATH");
		//TestUtil.takeScreenShot("View Options");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("appList_XPATH"))).isDisplayed());
		//CommonMethods.isElementDisplayed("appList_XPATH");
		log.info("Appointmnents list Displayed");
		//TestUtil.takeScreenShot("Appointment List Displayed");
	}


	
	// verify Go To pagination TextBox

		public void verifypaginationGoToTextBox() throws Exception {

			Thread.sleep(2000);

			// scroll to dropdown
			CommonMethods.scrollByVisibilityofElement("pageGoToTextbox_XPATH");

			// enter value in textbox
			CommonMethods.sendkeys("pageGoToTextbox_XPATH", "2");

			Thread.sleep(2000);
			// Enter
			CommonMethods.KeysEnter("pageGoToTextbox_XPATH");

			Thread.sleep(2000);
			Assert.assertTrue(driver.findElement(By.xpath("//a[@data-autoid='pagination_2']")).isEnabled());

		}


}
