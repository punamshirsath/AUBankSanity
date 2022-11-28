package com.AU.pages;

import com.AU.commonUtilities.CommonMethods;
import com.AU.listeners.TestListeners;

public class ConditionalAlertPage extends TestListeners{
	
	
	//select sub-sub Category 
		public void selectSubSubCategory() throws Exception {
			CommonMethods.Click("subsubCategorySrch_XPATH");
			CommonMethods.ExWait("sRSubsubCategory_XPATH");
			CommonMethods.Click("sRSubsubCategory_XPATH");
			log.info("Sub-Sub Category Selected");
			
		}
		
   //select auto Assignment
		public void selectAutoAssignmentDrpdown() throws Exception {
			CommonMethods.ExWait("srAutoAssignment_XPATH");
			CommonMethods.selectByIndex("srAutoAssignment_XPATH", 2);
			log.info("Select auto assignment dropdown");
			
		}
		
		//Select Case Owner
		public void selectCaseOwner() throws Exception {
			CommonMethods.Click("srCaseOwner_XPATH");
			CommonMethods.selectByIndex("srCaseOwner_XPATH", 1);
			Thread.sleep(3000);
			CommonMethods.Click("caseOwnerQueue_XPATH");
			log.info("Case Owner is Selected");
			
	}
		
		//select request letter
		public void selectRequestLetter() throws Exception {
			CommonMethods.selectByIndex("requestLetter_XPATH", 2);
			log.info("Requested Letter Selected");
		}
		
		//click on Save & Proceed Button
		public void clickOnSaveAndProceed() {
			CommonMethods.Click("saveAndProceedBtn_XPATH");
			log.info("Click On Save And Proceed Button");
		}
		
		
	

}
