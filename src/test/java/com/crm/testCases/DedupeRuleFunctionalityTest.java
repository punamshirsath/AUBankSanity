package com.crm.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.LeadPage;



public class DedupeRuleFunctionalityTest extends SetUp{
	
	public AULoginPage au;
	public LeadPage lp;
	//public String sheetName = "CSELogin";
	
	
@Test
public void DedupeRuleTest() throws Exception {
	
	String sheetName = "DedupeRuleTest";
	
	if (!(CommonMethods.isTestRunnable("DedupeRuleTest",sheetName))) {

		throw new SkipException(
				"Skipping the test " + "DedupeRuleTest".toUpperCase() + "as the Run mode is NO");
	}
	au=new AULoginPage();
	au.login(sheetName);
	log.info("Login as a CSE User");
	
	 lp=new LeadPage();
	  lp.openleadPage();
      
      //Select ETB LEad
      lp.searchETBLead(sheetName);
      //lp.clickOnIgnoreandCreate();
      
    //edit lead
    	lp.clickOnToggleBtn();
    	lp.editLead();
    		
    		///enter all details for document collection stage
    		lp.fillDataAtDocCollectedStage(sheetName);
    		Thread.sleep(3000);
    		Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("duplicateRecord_XPATH"))).isDisplayed());
    		log.info("Dedupe fired for new lead");
    		//lp.clickOnIgnoreandCreate();
}
}