package com.crm.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.CallAndMeetingsPage;




public class CallAndMeetingsFunctionalityTest extends SetUp{
	AULoginPage au=new AULoginPage();
	CallAndMeetingsPage cp=new CallAndMeetingsPage();
	
	
	
	
	//all Call & Meetings testcases covered
	 
   @Test
   public void CallAndMeetingsTest() throws Exception {
	   
	   String sheetName = "CallAndMeetingsTest";
	   
	   if (!(CommonMethods.isTestRunnable("CallAndMeetingsTest", sheetName))) {

			throw new SkipException(
					"Skipping the test " + "ToVerifyCallAndMeetings".toUpperCase() + "as the Run mode is NO");
		}
	   
	    au.login(sheetName);
		log.info("Login as a CSE User");
		cp.CSEUserAbleToClickOnSummary();
	    cp.VerifyCSEUserAbleToClickOnLogACallAndOpenNewWindow();
		cp.verifyIncomeAndBuisnessProfilerFieldsDisplayed();
		cp.createNewCallMeeting(sheetName);
	    cp.VerifyCallMeetingCreated(sheetName);
   }
   
 
   
   

}
