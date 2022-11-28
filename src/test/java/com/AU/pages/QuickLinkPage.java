package com.AU.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.AU.commonUtilities.CommonMethods;
import com.AU.commonUtilities.ScreenShot;
import com.AU.listeners.TestListeners;





public class QuickLinkPage extends TestListeners{
	
	
	
	
	//Lead search Fields
	
	@FindBy(xpath="//label[@data-autoid='10001661_lbl']")
	WebElement leadNo;
	
	@FindBy(xpath="//label[@data-autoid='10001691_lbl']")
	WebElement mobile;
	
	@FindBy(xpath="//label[@data-autoid='369_lbl']")
	WebElement pan;
	
	@FindBy(xpath="//label[@data-autoid='1085_lbl']")
	WebElement voterid;
	
	@FindBy(xpath="//label[@data-autoid='921_lbl']")
	WebElement passportNo;
	
	@FindBy(xpath="//label[@data-autoid='2104_lbl']")
	WebElement migratedLeadid;
	
	@FindBy(xpath="//label[@data-autoid='1086_lbl']")
	WebElement drivinglicenseNo;
	
	@FindBy(xpath="//label[@data-autoid='3081_lbl']")
	WebElement ckyc;
	
	@FindBy(xpath="//label[@data-autoid='3080_lbl']")
	WebElement ucic;
	
	
	public void CSEUserAbleToClickOnQucikLinks() throws Exception {
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("quicklinkTab_XPATH"))).isDisplayed());
		CommonMethods.Click("quicklinkTab_XPATH");
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("quicklinktext_XPATH"))).isDisplayed());
        ScreenShot.takeSnapShot("quicklink tab", "Pass");
		
	}
	
	public void verifyQuickLinksDisplay() throws Exception {
		//CommonMethods.Click("quicklinkTab_XPATH");
		Thread.sleep(3000);
		Assert.assertEquals(true, driver.findElement(By.xpath(CommonMethods.readPropertyFile("quicklink1_XPATH"))).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(CommonMethods.readPropertyFile("quicklink2_XPATH"))).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(CommonMethods.readPropertyFile("quicklink3_XPATH"))).isDisplayed());
		 ScreenShot.takeSnapShot("quicklinks", "Pass");
	}
	
	public void verifyLeadSearchFields() throws Exception {
		CommonMethods.Click("quicklink3_XPATH");
		Thread.sleep(3000);
		Assert.assertEquals(true, driver.findElement(By.xpath(CommonMethods.readPropertyFile("leadNo_XPATH"))).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(CommonMethods.readPropertyFile("mobilesearch_XPATH"))).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(CommonMethods.readPropertyFile("pansearch_XPATH"))).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(CommonMethods.readPropertyFile("voterid_XPATH"))).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(CommonMethods.readPropertyFile("passportNo_XPATH"))).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(CommonMethods.readPropertyFile("migratedLeadid_XPATH"))).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(CommonMethods.readPropertyFile("drivinglicenseNo_XPATH"))).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(CommonMethods.readPropertyFile("ckyc_XPATH"))).isDisplayed());
		Assert.assertEquals(true, driver.findElement(By.xpath(CommonMethods.readPropertyFile("ucic_XPATH"))).isDisplayed());
	
		ScreenShot.takeSnapShot("Lead Search Fields", "Pass");
		
		
	}

}
