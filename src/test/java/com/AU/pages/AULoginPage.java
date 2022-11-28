package com.AU.pages;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.AU.commonUtilities.CommonMethods;
import com.AU.commonUtilities.ScreenShot;
import com.AU.listeners.TestListeners;



public class AULoginPage extends TestListeners {

	public static Logger log =LogManager.getLogger(AULoginPage.class.getName());
	
	// CommonMethods cm=new CommonMethods();
	// login to AU
	public void login(String sheetName) throws Exception {
		extentInfo("Login for ", sheetName +" Intiated");
		ScreenShot.takeSnapShot("LoginPage", "Pass");
		CommonMethods.input("aUUserName_XPATH", sheetName, "Username", 1);
		CommonMethods.input("aUPassword_XPATH", sheetName, "Password", 1);
		CommonMethods.highLight("loginBtn_XPATH");
		CommonMethods.Click("loginBtn_XPATH");
		extentInfo("Sucessfully Login","AU");
	}

	// logout AU
	public void Logout() throws Exception {
		CommonMethods.highLight("profileimage_XPATH");
		CommonMethods.Click("profileimage_XPATH");
		CommonMethods.highLight("logoutbtn_XPATH");
		CommonMethods.Click("logoutbtn_XPATH");
		log.info("Sucessfully logout..");

	}

	// select roles
	public void selectrole(int role) throws Exception {

		CommonMethods.Click("profileimage_XPATH");
		//CommonMethods.ExplicitWait("roledrpdown_XPATH");
		log.info("select role");
		CommonMethods.selectByIndex("roledrpdown_XPATH", role);

	}

}
