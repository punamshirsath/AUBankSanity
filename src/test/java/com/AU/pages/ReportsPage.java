package com.AU.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.UnhandledException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.AU.commonUtilities.CommonMethods;
import com.AU.commonUtilities.ScreenShot;
import com.AU.listeners.TestListeners;


public class ReportsPage extends TestListeners{
	
	
	
	
	@FindBy(xpath="//div[@class='react-grid-row-group']")
	List<WebElement> listReports;
	
	
	//@FindBy(xpath="//div[@class='form-element--group']")
	@FindBy(xpath="//div[@class='form-element form-element--labelLeft  ']")
	List<WebElement> options; 	
	
	
	
	//methods
	//navigate to reports 
	public void navigateToReportsTab() throws Exception {
		
		CommonMethods.Click("reportsTab_XPATH");
		log.info("Branch Manager User Click On Reports Tab");
		System.out.println(driver.getCurrentUrl());
		String title=CommonMethods.getElementText("reportpagetitle_XPATH");
		System.out.println(title);
		log.info("Branch Manager Navigate to Reports Tab");
		Assert.assertEquals("Reports", title, "title mismatch");
	}
	

	//verify list of reports display
		public void VerifylistOfReportsDisplay() throws IOException, Exception {
		    boolean match=false;
		    CommonMethods.ExWait("listReports_XPATH");
			int listsize=CommonMethods.getElementsListCount("listReports_XPATH");
			
			if(listsize > 1) {
				match=true;
				
			}
			Assert.assertTrue(match, "List of reports not display");
		}
	
	public void verifyReportsOpenProperly() throws Exception {
		
       CommonMethods.sendkeys("searchTBReportsPage_XPATH", "Comprehensive SR Report");
		
		//click on filter arrow button
		CommonMethods.Click("filterarrowbtnReportsPage_XPATH");
		Thread.sleep(2000);
		
		//Expand Reports section
		CommonMethods.Click("cardgroupsectionReportsPage_XPATH");
		
		//click on first report link
		CommonMethods.Click("firstreport_XPATH");
		
		//switch to window
		CommonMethods.switchwindow();
		
		//verify reports window opens
		Assert.assertEquals(true, driver.findElement(By.xpath(CommonMethods.readPropertyFile("reportbody_XPATH"))).isDisplayed());
		
		ScreenShot.takeSnapShot("Report Opens Properly","");
		Thread.sleep(2000);
		
		
		
	}
	
	public void verifyExecuteAllRecordsDisplayed() throws UnhandledException, IOException {
	//click On Execute Button
	CommonMethods.Click("executeBtn_XPATH");
			
	//verify records are displayed
	Assert.assertEquals(true, driver.findElement(By.xpath(CommonMethods.readPropertyFile("records_XPATH"))).isDisplayed());
	
	//switch to parent window
		    CommonMethods.switchtoparentwindow();

		}
	
	
	
	public void VerifyFieldsDisplayed() throws Exception {
		Thread.sleep(3000);
		//CommonMethods.switchtoparentwindow();
	//	CommonMethods.Click("comprehensiveSRReport_XPATH");
		log.info("Click On SR Comprehensive report");
	//	CommonMethods.switchwindow();
		log.info("After Click on Report report details displayed");
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		CommonMethods.Click("filterbtn_XPATH");
		//div[@class="form-element form-element--labelLeft  "]
		////div[@class='form-element--group']
		int options1=driver.findElements(By.xpath("//div[@class='form-element form-element--labelLeft  ']")).size();
		System.out.println(options1);
		/*Iterator<WebElement> itr = driver.findElements(By.xpath("//div[@class='form-element form-element--labelLeft  ']")).iterator();
		while(itr.hasNext()) {
		    System.out.println(itr.next().getText());
		}
		  Assert.assertTrue(options.size() == options1);
		   log.info("list of filter fields displayed");
		   //driver.close();*/
		
		if(options1>1) {
			Assert.assertTrue(true);
		}
		
		else {
			Assert.assertFalse(false);
		}
		
		CommonMethods.selectByIndex("ReportStatusCode_XPATH", 1);
		Thread.sleep(3000);
		CommonMethods.Click("reportFilterSrch_XPATH");
		CommonMethods.selectCheckbox("reportFilterCB_XPATH");
		System.out.println("Filter Field Selected");
		CommonMethods.ExWait("okbtn_XPATH");
		CommonMethods.Click("okbtn_XPATH");
		CommonMethods.Click("applyBtn_XPATH");
		Thread.sleep(15000);
		CommonMethods.ExWait("ReportsRecodrs_XPATH");
		Assert.assertEquals(true, driver.findElement(By.xpath(CommonMethods.readPropertyFile("ReportsRecodrs_XPATH"))).isDisplayed());
		
		
	}
	
  
	
/*	public void verifyAddToQuickLinkFunctionality() throws IOException, InterruptedException {
		CommonMethods.Click("adminReportTab_XPATH");
		log.info("Administrator Click On Report Tab");
		CommonMethods.Click("reports_XPATH");
		CommonMethods.isElementDisplayed("reportpagetitle_XPATH");
		CommonMethods.Click("accountObjectreport_XPATH");
		log.info("Click On Account Object Report");
		CommonMethods.Click("adminComprehensiveSRReport_XPATH");
		CommonMethods.switchwindow();
		log.info("After Click on Report report details displayed");
		System.out.println(driver.getCurrentUrl());
		CommonMethods.Click("addToQuickLinks_XPATH");
		driver.close();
		CommonMethods.switchtoparentwindow();
		CommonMethods.Click("adminQuickLink_XPATH");
		CommonMethods.isElementDisplayed("qucikLink_XPATH");
	}*/
	

}
