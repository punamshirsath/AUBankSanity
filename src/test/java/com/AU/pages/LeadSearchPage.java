package com.AU.pages;

import java.io.IOException;

import org.apache.commons.lang.UnhandledException;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.AU.commonUtilities.CommonMethods;
import com.AU.commonUtilities.ExcelOperation;
import com.AU.listeners.TestListeners;


public class LeadSearchPage extends TestListeners{
	
public String sheetName = "LeadDetails";

	
	
	
	//click On Lead Search Tab Under Quick Links
	
			public void clickOnLeadSearchTab() throws Exception {

				
				CommonMethods.highLight("leadSearch_XPATH");
				CommonMethods.Click("leadSearch_XPATH");

			}
	
	public String verifyLeadSearchByLeadID(String sheetName) throws IOException, InterruptedException {

		String atualleadid = ExcelOperation.getCellData(sheetName, "Lead Id", 1);
		CommonMethods.sendkeys("leadIDSearch_XPATH", atualleadid);
		Thread.sleep(2000);
		CommonMethods.Click("fetchBtn_XPATH");
		//TestUtil.takeScreenShot("Lead Search By Lead ID");
		return atualleadid;

	}
	
	public static String getleadID() throws UnhandledException, IOException, InterruptedException {
		Thread.sleep(2000);
		String expleadID=driver.findElement(By.xpath(CommonMethods.readPropertyFile("leadpresent_XPATH"))).getText();
	    return expleadID;
		
	}
	
	public void isLeadListingDisplayed() throws Exception {
		CommonMethods.ExWait("leadDisplayed_XPATH");
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("leadDisplayed_XPATH"))).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("result_XPATH"))).isDisplayed());
		
	}
	
	

}
