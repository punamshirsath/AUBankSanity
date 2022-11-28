package com.crm.testCases;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.CustomerPage;




public class CustomerSearchFunctionalityTest extends SetUp{
	AULoginPage au=new AULoginPage();
	CustomerPage cp=new CustomerPage();
	
	
  
	@Test
   	public void CustomerSearchTest() throws Exception{
		
		 String sheetName = "CustomerSearchTest";
		
		if (!(CommonMethods.isTestRunnable("CustomerSearchTest",sheetName ))) {

			throw new SkipException(
					"Skipping the test " + "ToVerifyCustomerSearch".toUpperCase() + "as the Run mode is NO");
		}
		 
		au.login(sheetName);
		log.info("Login as a CSE User");
		cp.moveToQuickLink();
		cp.clickOnCustomerSearchTab();
		String actualcif=cp.verifyCustomerSearchByCIF(sheetName);
		Thread.sleep(5000);
		System.out.println("Actual CIF Entered on Customer Search Page: " + actualcif);
		System.out.println();
		String expCif = cp.getCif();
		System.out.println("Expected CIF Fetched on Customer Search Page: " + expCif);
		Assert.assertEquals(actualcif, expCif, "CIF Mismatched");
		cp.isCustomerDisplayed();
		//cp.CifValidation(data.get("CIF"));
	}
	

}
