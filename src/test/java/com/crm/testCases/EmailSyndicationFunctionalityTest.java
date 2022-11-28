package com.crm.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.AU.base.SetUp;
import com.AU.commonUtilities.CommonMethods;
import com.AU.pages.AULoginPage;
import com.AU.pages.EmailSyndicationPage;

public class EmailSyndicationFunctionalityTest extends SetUp{
	
	AULoginPage au=new AULoginPage();
	EmailSyndicationPage ep=new EmailSyndicationPage();
	
	@Test
	public void EmailSyndicationTest() throws Exception {
		
		String sheetName = "EmailSyndicationTest";
		//String sheetName = "TaskLeadCreationTest";
		
		if (!(CommonMethods.isTestRunnable("EmailSyndicationTest",sheetName ))) {

			throw new SkipException(
					"Skipping the test EmailSyndicationTest as the Run mode is NO + ");
		}
		
		//driver.get("https://login.microsoftonline.com/common/oauth2/v2.0/authorize?client_id=4765445b-32c6-49b0-83e6-1d93765276ca&redirect_uri=https%3A%2F%2Fwww.office.com%2Flandingv2&response_type=code%20id_token&scope=openid%20profile%20https%3A%2F%2Fwww.office.com%2Fv2%2FOfficeHome.All&response_mode=form_post&nonce=638042777764453136.NjA3ZjVlMmYtZTllZi00YWQyLTlkN2YtZGU4ZmI5NDQxZjAxODZlNjEwN2MtOWMwYi00MTJhLWIxYjYtYWJhNDIzMDBlMDEy&ui_locales=en-US&mkt=en-US&state=K2qga-rrnPG7EfSTiL8EkJVM7fNEcQ0T2pxhHC-s7vDWFmClNmfZbmX6twNEXpnUbTnSrQcdZIBN-QWt9U89FfY5SityTuv-Y4ASyHpoqWmC_0rIbIqaNZvtkB2F79fx-MR6Fuz7hehlXW6lJKm0xL63l5Iuw99BUnhLCs85Q-QHs5oF4esa9oz2QOAgJTGOMeIelxPl2pea9mD27LN0Dz6ZhkrvHN4Fa_YienwpDKg1UdSYTQUIN0MM8AK48j949zJZ81taLdBpwERBZpHHow&x-client-SKU=ID_NETSTANDARD2_0&x-client-ver=6.16.0.0");
		driver.get("https://outlook.office.com/mail/");
		ep.loginToOutlook(sheetName);
		
		//Click ON New Mail
		ep.ClickOnnewEmailBtn();
		
		//enter mail id 
		ep.enterToEmailID(sheetName);
		
		//enter Subject
		ep.enterMailSubject(sheetName);
		
		//enter mail Body
		ep.enterMailbody(sheetName);
		
		ep.clickOnSendbutton();
		
		Thread.sleep(3000);
		
		
		driver.navigate().to("https://crmdev.aubankuat.in/sn7/app/login/login");
		//setUpTest1(sheetName);
		
		System.out.println("Instace URL Opened");
		
		au.login(sheetName);
		

}
}