package com.AU.pages;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.AU.commonUtilities.CommonMethods;
import com.AU.commonUtilities.ExcelOperation;
import com.AU.commonUtilities.ScreenShot;
import com.AU.listeners.TestListeners;

public class EmailSyndicationPage extends TestListeners
{
	public static Logger log =LogManager.getLogger(EmailSyndicationPage.class.getName());
	
	
	//Open outlook Link
	public void openOutlookLink() {
		
	}

//Click on New email Button
	public void ClickOnnewEmailBtn() throws Exception {
		CommonMethods.ExWait("newMailBtn_XPATH");
		CommonMethods.Click("newMailBtn_XPATH");
		extentInfo("Clicked On New Email","");
	}
	
	
	//Login to outlook
	public void loginToOutlook(String sheetName) throws Exception {
		extentInfo("Login for ", sheetName +" Intiated");
		ScreenShot.takeSnapShot("LoginPage", "Pass");
		CommonMethods.input("emailTB_XPATH", sheetName, "Emailid", 1);
		CommonMethods.Click("emailNextBtn_XPATH");    
		CommonMethods.input("emailPassword_XPATH", sheetName, "Email Password", 1);
		CommonMethods.highLight("emailSignInBtn_XPATH");
		CommonMethods.Click("emailSignInBtn_XPATH");
		CommonMethods.Click("emailyesBtn_XPATH");
		extentInfo("Sucessfully Login","Outlook");
	}
	
	//enter ToEmail Id
	public void enterToEmailID(String sheetName) throws Exception {
		
		String MailTo =ExcelOperation.getCellData(sheetName, "MailTo", 1);
		CommonMethods.sendkeys("toEmail_XPATH", MailTo);
		extentInfo("Mail Id Entered","");
		
	}
	
	//enter Subject
	public void enterMailSubject(String sheetName) throws Exception {

		String Mailsubject =ExcelOperation.getCellData(sheetName, "Mail Subject", 1);
		CommonMethods.sendkeys("mailSubject_XPATH", Mailsubject);
		extentInfo("Subject Entered","");
		
	}
	
	//enter mail body
	public void enterMailbody(String sheetName) throws Exception {
		//List<WebElement> framesList = driver.findElements(By.xpath("//iframe"));
        //int numOfFrames = framesList.size();
       // System.out.println("Size: " + numOfFrames);
       // driver.switchTo().frame(1);
		String Mailbody =ExcelOperation.getCellData(sheetName, "Mail Body", 1);
		CommonMethods.sendkeys("mailBody_XPATH", Mailbody);
		//extentInfo("Mail Body Entered","");
		
	}
	
	
	//click on send button
	public void clickOnSendbutton() throws Exception {
		CommonMethods.highLight("mailSendButton_XPATH");
		CommonMethods.Click("mailSendButton_XPATH");
		
	}
	

}
