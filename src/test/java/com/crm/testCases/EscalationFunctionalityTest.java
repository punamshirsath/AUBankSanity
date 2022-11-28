package com.crm.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.CustomerPage;
import com.AU.pages.SRCreationPage;

public class EscalationFunctionalityTest extends SetUp{
	AULoginPage au=new AULoginPage();
	SRCreationPage sp=new SRCreationPage();
	CustomerPage cp=new CustomerPage();
	
	@Test
	public void ConditionalAlertTest() throws Exception {
		
		String sheetName = "ConditionalAlertTest";
		
		if (!(CommonMethods.isTestRunnable("ConditionalAlertTest", sheetName ))) {

			throw new SkipException(
					"Skipping the test " + "ToConditionalAlertTest".toUpperCase() + "as the Run mode is NO");
		}
		

}
}