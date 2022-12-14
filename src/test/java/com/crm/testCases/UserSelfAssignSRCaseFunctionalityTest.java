package com.crm.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.CustomerPage;
import com.AU.pages.SRCreationPage;

public class UserSelfAssignSRCaseFunctionalityTest extends SetUp{
	
	AULoginPage au=new AULoginPage();
	SRCreationPage sp=new SRCreationPage();
	CustomerPage cp=new CustomerPage();
	
	@Test
	public void SelfAssignClosedSRCaseTest() throws Exception {
		
		String sheetName = "SelfAssignClosedSRCaseTest";
		
		if (!(CommonMethods.isTestRunnable("SelfAssignClosedSRCaseTest", sheetName ))) {

			throw new SkipException(
					"Skipping the test " + "ToverifySRCreationTest".toUpperCase() + "as the Run mode is NO");
		}
		
		au.login(sheetName);
		log.info("Login as a Department Engineer User");
		sp.deUserClickOnCustomerServiceTab();
		CommonMethods.scrollDown(500);
	    sp.selectViewOfDepartmentEngineer(sheetName);
	    sp.selectSRForSelfAssignment();
	    sp.editSRASAInProcess();
		sp.editSRAsaResolvedStatusCode(sheetName);
	    au.Logout();
		
	}

}
