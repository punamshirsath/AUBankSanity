package com.AU.pages;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.UnhandledException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.AU.commonUtilities.CommonMethods;
import com.AU.commonUtilities.ExcelOperation;
import com.AU.commonUtilities.ScreenShot;
import com.AU.listeners.TestListeners;




public class CustomerPage extends TestListeners {
	
	public String sheetName = "CustomerDetails";
	
	
	
	// Move to Quick Link tab
			public void moveToQuickLink() throws Exception {
				CommonMethods.mouseHover("quickLink_XPATH");
				CommonMethods.highLight("quickLink_XPATH");
			}
	
	//click On Customer Search Tab Under Quick Links
	
			public void clickOnCustomerSearchTab() throws Exception {
				CommonMethods.highLight("customerSearch_XPATH");
				CommonMethods.Click("customerSearch_XPATH");
				
			}
			
			//Search Customer using Mobile no
			public String enterMobileNoForCustomerSearch(String sheetName) throws IOException, InterruptedException {

				String Mobile  =ExcelOperation.getCellData(sheetName, "Search Mobile", 1);
				CommonMethods.sendkeys("mobileSearchField_XPATH", Mobile);
				Thread.sleep(2000);
				CommonMethods.Click("fetchBtn_XPATH");
				//TestUtil.takeScreenShot("Customer Search By Customer ID");
				//TestUtil.takeScreenShot("");
				return Mobile;
				
			}
			
			//
			public void clickOnCustomer() throws Exception {
				CommonMethods.highLight("firstCustomer_XPATH");
				CommonMethods.Click("firstCustomer_XPATH");
				log.info("Click On First Customer");
				
			}
			//verify Customer Search By Customer ID
			public String verifyCustomerSearchByCIF(String sheetName) throws IOException, InterruptedException {
				
				String CIF  =ExcelOperation.getCellData(sheetName, "CIF", 1);
				CommonMethods.sendkeys("cifInput_XPATH", CIF);
				Thread.sleep(2000);
				CommonMethods.Click("fetchBtn_XPATH");
				//TestUtil.takeScreenShot("Customer Search By Customer ID");
				//TestUtil.takeScreenShot("");
				return CIF;
				
			}
			
			
			
			
			/*public void CifValidation(String ExpectedCIF) throws Exception {

		 		Thread.sleep(3000);
		 		String ActualCIF = CommonMethods.getElementText("cif_XPATH");
		 		System.out.println("Expected CIF is: " +ExpectedCIF);
		 		System.out.println("Actual CIF is: " +ActualCIF);
		 		CommonMethods.verifyEquals(ExpectedCIF, ActualCIF);
		 	}*/
			
			public static String getCif() throws UnhandledException, IOException {
				
				String expcif=driver.findElement(By.xpath(CommonMethods.readPropertyFile("cifSearch_XPATH"))).getText();
			
				
				return expcif;
				
			}
			
			public static void isCustomerDisplayed() throws Exception {
				CommonMethods.ExWait("customerDisplayed_XPATH");
				Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("customerDisplayed_XPATH"))).isDisplayed());
				Assert.assertTrue(driver.findElement(By.xpath(CommonMethods.readPropertyFile("result_XPATH"))).isDisplayed());
			}
			
			public void verifyTabsVisibleOnCustomer() throws Exception {
				
				List<WebElement> alloptions= driver.findElements(By.xpath("//ul[@class='crm-card-tab relative overflow-auto']/li/span/span"));
				int count=alloptions.size();
				System.out.println(count);
				for(WebElement ele:alloptions) {
					System.out.println("Actual Tabs Visible on Customer:"+ele.getText());
					
				}	
				CommonMethods.Click("moreTabs_XPATH");
				List<WebElement> alloptionsofTab= driver.findElements(By.xpath("//ul[@class='moreTabs__collection overflow-auto card-scroll max-ht-20']/li/span/span"));
				int count1=alloptionsofTab.size();
				System.out.println(count1);
				for(WebElement ele:alloptionsofTab) {
					System.out.println("Actual Tabs Visible on Customer:"+ele.getText());
					
				}	
				ScreenShot.takeSnapShot("Tabs Visible On Customer", "Pass");
			}
			

			

}
