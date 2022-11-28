package com.crm.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.LeadPage;

public class ConditionalAccessFunctionalityTest extends SetUp{
	
	AULoginPage au=new AULoginPage();
	LeadPage lp=new LeadPage();
	
	
	@Test
	public void ConditionalAccessTest() throws Exception {
		String sheetName = "ConditionalAccessTest";
		
		if (!(CommonMethods.isTestRunnable("ConditionalAccessTest",sheetName))) {

			throw new SkipException(
					"Skipping the test " + "ToVerifyConditionalAccessTest".toUpperCase() + "as the Run mode is NO");
		}
		
		au.login(sheetName);
		log.info("Login as a CSE User");
		
		//Click on Leads Tab
		lp.clickOnLeadsTab();
		
		//Select View Bucket
		lp.selectLeadFromViewBucket(sheetName);
	
		//edit lead
	    lp.editLead();
	    
	    Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("updatePermission_XPATH"))).isDisplayed());

}
}
  