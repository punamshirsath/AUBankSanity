package com.AU.pages;

import java.io.IOException;

import org.apache.commons.lang.UnhandledException;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.AU.commonUtilities.CommonMethods;
import com.AU.listeners.TestListeners;

public class adminPage extends TestListeners{
	
	public void clickOnAdministrativeSettings() throws Exception {
		CommonMethods.highLight("ProfileBtn_XPATH");
		CommonMethods.Click("setupBtn_XPATH");
		log.info("Click On Setup Button");
		CommonMethods.ExWait("adminSetting_XPATH");
		CommonMethods.Click("adminSetting_XPATH");
		log.info("Click On Administrative Setting Button");
		CommonMethods.Click("settingDrpdown_XPATH");
		CommonMethods.scrollDown(1000);
		CommonMethods.Click("notificationSetting_XPATH");
		log.info("Click On notification settings");
	}
	
	//Click on email log
	public void clickOnEmailLog() throws InterruptedException, UnhandledException, IOException {
		CommonMethods.Click("emailLog_XPATH");
		log.info("Click On Email Log");
		Thread.sleep(3000);
		String Subject = driver.findElement(By.xpath(CommonMethods.readPropertyFile("Emailsubject_XPATH"))).getText();
		System.out.println(Subject);
		Assert.assertTrue(Subject.contains("512"));
		String message = driver.findElement(By.xpath(CommonMethods.readPropertyFile("messageType_XPATH"))).getText();
		System.out.println(message);
		Assert.assertEquals("ConditionalAlert", message, "product Mismatch");
	}

}
