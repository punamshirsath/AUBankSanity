package com.AU.commonUtilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.lang.UnhandledException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.AU.base.SetUp;
import com.AU.listeners.TestListeners;
import com.aventstack.extentreports.Status;


public class CommonMethods extends SetUp 
{
	public static JavascriptExecutor js ;
	public static WebDriverWait wait ;
	public static Actions a ;
	public static Logger log = LoggerFactory.getLogger(CommonMethods.class);
	public static Properties prop=new Properties();
	public static String parentwindow;
	public static WebElement element;
	public static String parentwindowID;

	
	public static void ExWait(String locator) throws Exception
	{
		wait= new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CommonMethods.readPropertyFile(locator))));
	}
	
	//generate Random Number
	
	public static int generateRandomNumber() {
		Random random = new Random();
		int randomNum = random.nextInt(1000);
		return randomNum;
		
	}

	public static void waitForURL(String urlContains)
	{
		wait= new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.urlContains(urlContains)	);
	}
	
	public static void Click(String locator)
	{
		try {
			 ExWait(locator); 
			if (locator.endsWith("_XPATH")) {
				driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator))).click();
			} else if (locator.endsWith("_ID")) {
				driver.findElement(By.id(CommonMethods.readPropertyFile(locator))).click();
			}
			log.info("Sucessfully clicked on "+locator);
			TestListeners.extentInfo("Sucessfully clicked on ",locator);

		} catch (Exception e) {
			log.error("Not Sucessfully clicked on "+locator+" due to :"+e.getMessage());
		}
	}
	public static void input(String locator, String SheetName, String ColName, int rowNum) 
	{
		try 
		{
			 Click(locator); 
			if (locator.endsWith("_XPATH"))
			 {
				 driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator))).clear();
				 driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator))).sendKeys(ExcelOperation.getCellData(SheetName,ColName,rowNum));
			 } 
			else if (locator.endsWith("_ID")) 
			{
				driver.findElement(By.id(CommonMethods.readPropertyFile(locator))).clear();	
				driver.findElement(By.id(CommonMethods.readPropertyFile(locator))).sendKeys(ExcelOperation.getCellData(SheetName,ColName,rowNum));
			}
			log.info("Data sucessfully entered on "+locator+" = "+ExcelOperation.getCellData(SheetName,ColName,rowNum));
			 TestListeners.extentInfo("Data sucessfully entered on "+locator," = "+ExcelOperation.getCellData(SheetName,ColName,rowNum));

		} catch (Exception e) {
			log.error("Data Not Sucessfully entered on "+locator+" due to :"+e.getMessage());
		}
	}
	
	public static String getElementText(String locator) throws Exception 
	{
		 ExWait(locator);
		 String txtMsg = driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator))).getText();
		 return txtMsg;
	}

	public static String getElementValue(String locator) throws Exception
	{
		ExWait(locator);
		String elementValue = driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator))).getAttribute("value");
		//log.info("Value of WebElement :" +elementValue);
		return elementValue;

	}
	// get list of Element
		public static List<WebElement> getElements(String locator) throws Exception, IOException {
			return driver.findElements(By.xpath(CommonMethods.readPropertyFile(locator)));
			// return driver.findElements(locator);
		}
	
	// get count of list of elements
		public static int getElementsListCount(String locator) throws IOException, Exception {

			int size = getElements(locator).size();
			log.info("Element List Count" + size);
			TestListeners.extentInfo("Element List Count " + locator, " = " + size);
			return size;
		}
	
	//keys enter
    public static void KeysEnter(String locator) {
        try {
            Click(locator);
            if (locator.endsWith("_XPATH")) {



               driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator))).sendKeys(Keys.ENTER);
            } else if (locator.endsWith("_ID")) {



               driver.findElement(By.id(CommonMethods.readPropertyFile(locator))).sendKeys(Keys.ENTER);
            }
            log.info("Keys Entered on " + locator);



       } catch (Exception e) {
            log.error("Keys Entered on  " + locator);
        }



   }
	public static void ExWaitsForWebelements(List<WebElement> ele )
	{
		wait= new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	}
	
	//To highlight selected webelement
	public static void highLight(String locator) throws Exception
	{
		ExWait(locator);
		js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator)));
		js.executeScript("arguments[0].style.border='4px solid yellow'", element);
	}

	//to scroll down the page by pixel values as Y co-ordiante
	public static void scrollDown(int y) 
	{
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+y+")");
	}

	//To scroll down the page by visibility of the element
	public static void scrollByVisibilityofElement(String locator) throws Exception
	{
		js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator)));
		js.executeScript("arguments[0].scrollIntoView()",element);
	}

	//To scroll down the page at the bottom of page.
	public static void scrollAtBottom()
	{
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//Return the complete height of body (page)
	}

	//To select values from dropdown by visible text
	public static void selectByText(String locator, String sheetName, String colName, int rowNum) throws Exception 
	{
		WebElement element = driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator)));
		Select sel = new Select(element);
		try {
			ExWait(locator);
			String text = ExcelOperation.getCellData(sheetName,colName, rowNum);
			sel.selectByVisibleText(text);
			log.info("Data = "+text+" Sucessfully Selected from dropdown "+locator);
		} catch (Exception e) {
			log.error("Not able to select from dropdown "+locator+ "due to " +e.getMessage());
		} 
	}

	//To select values from dropdown by its value
	public static void selectByValue(String locator, String sheetName, String colName, int rowNum) throws InterruptedException, EncryptedDocumentException, IOException 
	{
		try {
			WebElement element = driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator)));
			String value = ExcelOperation.getCellData(sheetName,colName, rowNum);

			Select sel=  new Select(element);
			ExWait(locator);
			sel.selectByValue(value);
			log.info("Data = "+value+" Sucessfully Selected from dropdown "+locator);
		} catch (Exception e) {
			log.error("Not able to select from dropdown "+locator+ "due to " +e.getMessage());
		}
	}
	//To select values from dropdown by its index value
	public static void selectByIndex(String locator, int index) throws Exception 
	{
		try {
			WebElement element = driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator)));
			Select sel=  new Select(element);
			ExWait(locator);
			sel.selectByIndex(index);
			log.info("Data = "+index+" Sucessfully Selected from dropdown "+locator);
		} catch (Exception e) {
			log.error("Not able to select from dropdown "+locator+ "due to " +e.getMessage());
		}
	}

	//To handle mouse hover actions
	public static void mouseHover(String locator)throws Exception 
	{
		try {
			a = new Actions(driver);
			ExWait(locator);
			highLight(locator);
			WebElement element = driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator)));

			a.moveToElement(element).perform();	
			log.debug("Mouse hover on "+locator);
		} catch (Exception e) {
			log.error("Unable to mouse hover due to "+e.getMessage());
		}
		
	}
	
	//To handle move to element and click on that element
		public static void mouseClick(String locator) throws Exception 
		{
			try {
				a = new Actions(driver);
				ExWait(locator);
				highLight(locator);
				WebElement element = driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator)));

				a.moveToElement(element).click().perform();	
				log.debug("Mouse Click on "+locator);
			} catch (Exception e) {
				log.error("Not able to Mouse click due to "+e.getMessage());
			}
			
		}
		
		//Verify text of element
		public static void verifyTextOfElement(String locator, String text) {
			  try {

		            js = (JavascriptExecutor) driver;

		            element = driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator)));	         
		            js.executeScript("arguments[0].scrollIntoView(true);", element);

		            String actual = element.getText();

		            System.out.println("Actual Value is::" + actual);
		            System.out.println("Expected Value is::" + text);

		            Assert.assertTrue(actual.equals(text));
		            TestListeners.extentTest.get().log(Status.INFO, "Text is Matched: ");
		            System.out.println("Text Validation Passed::::");

		        } catch (Exception e) {

		            e.printStackTrace();
		            e.getMessage();
		            TestListeners.extentError("Text Verification Get Failed", "");
		            TestListeners.extentTest.get().log(Status.FAIL, "Element Not Displayed : " + locator);
		            log.error("Text Verification Get Failed");

		        }
		}
		
		public static void moveToElementAndClick(String locator) throws IOException, InterruptedException {
			Actions a=new Actions(driver);

			try {
				a.moveToElement(driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator)))).click().build().perform();
				log.info("clicked Successfully To_  " + locator);

			} catch (Exception e) {
				e.printStackTrace();
				//e.getMessage();
				//assertion.fail("***********Not Able To perform click action************");
				log.error("Not Able To perform click action" +e.getMessage());
				
			}

		}

	public static void AlertHandle(String action) 
	{
		try {
			if(action.equalsIgnoreCase("accept")) {
				driver.switchTo().alert().accept();
				log.info("Alert accepted succesfully");
			}else if(action.equalsIgnoreCase("dismiss")) {
				driver.switchTo().alert().dismiss();
				log.error("Alert dismissed succesfully");
			}
		}catch(Exception e){
			log.info("Not able to clicked on alert due to "+e.getMessage());
			}
	}
	
	public static void verifyEquals(String expected, String actual) throws IOException {

		try {
			System.out.println("Expected Value is::" + expected);
			System.out.println("Actual Value is::::" + actual);
			TestListeners.extentTest.get().log(Status.INFO, "Validation is Passed: ");
			log.info("Validation is Passed: ");
			Assert.assertTrue(actual.contains(expected));
			// Assert.assertEquals(actual, expected);
			System.out.println("Validation is Passed: ");

		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
			TestListeners.extentTest.get().log(Status.FAIL, " Can not Validated message due to "+e);
			System.out.println("Can not Validated::::");

		}

	}
	
	//enter  random adhar no
	public static String generateRandomAdharNo() {
		Random random = new Random();
		// int randomInt = random.nextInt(1000000000);
		String id = String.format("%011d", random.nextInt(10000));
		String Adharno = String.valueOf(id);
		String s1 = "9";
		String actualadhar = s1.concat(Adharno);
		return actualadhar;

		
	}
	
	
	public static void switchwindow() {

		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			parentwindow = driver.getWindowHandle();
			//System.out.println(parentwindow);

			for (String handle : driver.getWindowHandles()) {
				// System.out.println(handle);
				if (!parentwindow.equalsIgnoreCase(handle)) {
					//System.out.println(handle);
					driver.switchTo().window(handle);
				}
			}

		} catch (Exception e) {
             e.getMessage();
		}

	}
	
	public static boolean switchToWindowByTitle(String title)
	{
	    String currentWindow = driver.getWindowHandle(); 
	    Set<String> availableWindows = driver.getWindowHandles(); 
	    if (!availableWindows.isEmpty()) { 
	         for (String windowId : availableWindows) {
	              String switchedWindowTitle=driver.switchTo().window(windowId).getTitle();
	              if ((switchedWindowTitle.equals(title))||(switchedWindowTitle.contains(title))){ 
	                  return true; 
	              } else { 
	                driver.switchTo().window(currentWindow); 
	              } 
	          } 
	     } 
	     return false;
	}
	public static void switchtoparentwindow() {

		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.switchTo().window(parentwindow);

		}

		catch (Exception e) {
			 e.getMessage();
		}
	}
	

public static boolean isTestRunnable(String testName, String sheetName) throws Exception
{
		int rows =ExcelOperation.getRowCount("TestScenario");
		//System.out.println("No of rows : "+rows + " and test name = "+testName);
	
		for(int rNum=1; rNum<=rows; rNum++){
			
			String testCase = ExcelOperation.getCellData("TestScenario", "TC Name", rNum);
			
			if(testCase.equalsIgnoreCase(testName)){
				
				String runmode = ExcelOperation.getCellData("TestScenario", "RunMode", rNum);
				
				if(runmode.equalsIgnoreCase("Yes"))
				{
					setUpTest1(sheetName);
					return true;
				}
					else
					return false;
			}
		}
		return false;
	}

public static String getModule(String methodName) throws Exception
{
		int rows =ExcelOperation.getRowCount("TestScenario");
		String module = null;
		
		for(int rNum=1; rNum<=rows; rNum++){
			
			String testCase = ExcelOperation.getCellData("TestScenario", "TC Name", rNum);
			
			if(testCase.equalsIgnoreCase(methodName)){
				
				module = ExcelOperation.getCellData("TestScenario", "Module", rNum);
			}
		}
		return module;
}

	public static String getTestTypes()
	{
		ArrayList<String> columnData = new ArrayList<String>();
		String testTypes = null;
		try {
			columnData = ExcelOperation.getcolumnData("TestScenario", "Test Type");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//To remove duplicates from the array list
	List<String> newList = columnData.stream().distinct().collect(Collectors.toList());
	
	testTypes = String.join(", ", newList);
	
	System.out.println("ArrayList with duplicates removed: "
	        + newList);
	
	return testTypes;
	}

	//To get system info
	public static String[] getSystemInfo() {
		String [] sysInfo = new String [2];
		Capabilities browserCap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = browserCap.getBrowserName();
		String browserVersion = browserCap.getBrowserVersion();
		sysInfo[0] = browserName;
		sysInfo[1]= browserVersion;
		return sysInfo;
	}

	public static int getTestScenarioRowNum(String testScenario) throws Exception
	{
		String sheetName = CommonMethods.readPropertyFile("SheetName");
		int rows =ExcelOperation.getRowCount(sheetName);
		int rNum=1;
		for( ;rNum<=rows; rNum++)
		{
			String testCase = ExcelOperation.getCellData(sheetName, "TC Name", rNum);
			if(testCase.equalsIgnoreCase(testScenario))
			{	
				log.info("Row num for TestScenario = "+testScenario+ " is = "+rNum);
				return rNum;
			}
		}
		return rNum;
	}

	public static String readPropertyFile(String propertyName)throws UnhandledException, IOException
	{
		prop = SetUp.loadConfig();
		String propertyValue=prop.getProperty(propertyName);
		
		return propertyValue;
	}

	//Method to Upload File 
	public static void FileUpload(String filepath) 
	{
		try {
			Robot robo = new Robot();
			/*
			 * element=driver.findElement(By.xpath(object)); robo.setAutoDelay(3000);
			 * element.click();
			 */
			robo.setAutoDelay(2000);
			StringSelection StringSel = new StringSelection(filepath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(StringSel, null);

			robo.setAutoDelay(3000);

			robo.keyPress(KeyEvent.VK_CONTROL);
			Thread.sleep(1000);
			robo.keyPress(KeyEvent.VK_V);
			robo.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(1000);
			robo.keyRelease(KeyEvent.VK_V);
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);

			log.info("File uploaded succesfully");
			TestListeners.extentInfo("File Uploaded Successfully ","");
		} catch (Exception e) 
		{
			log.error("File Not get upload sucessfully due to" +e.getMessage());
		}
	}
	
	// Generate Random Mobile Number 10 digit

				public static String generateRandomMobileNumber() {
					Random random = new Random();
					// int randomInt = random.nextInt(1000000000);
					String id = String.format("%09d", random.nextInt(10000));
					String mobilenumber = String.valueOf(id);

					String s1 = "9";
					String actualmobnum = s1.concat(mobilenumber);
					return actualmobnum;
				}
				
				//To enter values  (sendkeys)
				public static void sendkeys(String locator, String text) 
				{
					try 
					{
						 Click(locator); 
						if (locator.endsWith("_XPATH"))
						 {
							 driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator))).clear();
							 driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator))).sendKeys(text);
						 } 
						else if (locator.endsWith("_ID")) 
						{
							driver.findElement(By.id(CommonMethods.readPropertyFile(locator))).clear();	
							driver.findElement(By.id(CommonMethods.readPropertyFile(locator))).sendKeys(text);
						}
						log.info("Data sucessfully entered on "+locator+" = "+text);
						TestListeners.extentInfo("Data sucessfully entered on "+locator," = "+text);

					} catch (Exception e) {
						log.error("Data Not Sucessfully entered on "+locator+" due to :"+e.getMessage());
					}
				}
				
				public static String toGetAttributeValue(String locator) throws Exception {
					
				    String value="";
					if (driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator))).getAttribute("value").isEmpty()) {
						TestListeners.extentTest.get().log(Status.FAIL, " fields not autopopulated :::: ");
						ScreenShot.takeSnapShot("fields value not displayed", "Fail");
					} else {
					 value = driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator))).getAttribute("value");
						System.out.println("Fields Value " + value);
						Assert.assertEquals(true, driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator))).isDisplayed());
						ScreenShot.takeSnapShot("fields value not displayed", "Pass");
					}
	                   return value;
				}
				
				// generate random PAN Number

				public static String generatePANNumber() {
					Random random = new Random();
					String id = String.format("%04d", random.nextInt(10000));
					// int randomNum = random.nextInt(1000);
					// String pannumber= "ASDUY"+id+"Z";
					String pannumber = "CJJPS" + id + "Z";
					return pannumber;
				}
				

				
				//To select checkbox
				public static void selectCheckbox(String locator) throws Exception {
					try {
						element = driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator)));
						JavascriptExecutor je = (JavascriptExecutor) driver;
						je.executeScript("arguments[0].scrollIntoView(true);", element);
						Thread.sleep(2000);
						element.click();
						TestListeners.extentInfo("Checkbox Selected", "");
						log.info("Sucessfully selected Checkbox " + locator);
					} catch (Exception e) {
						e.printStackTrace();
						e.getMessage();
						TestListeners.extentInfo("Checkbox Not Selected","");
						log.error("CHECKBOX Not Selected " + locator + e.getMessage());
						
						
					}
				}
				
				// Get all options from Dropdown

				public static void getAllOptionsFromDropdown(String locator) throws IOException {
					Select s = new Select(driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator))));
					List<WebElement> op = s.getOptions();
					int size = op.size();
					for (int i = 0; i < size; i++) {
						String options = op.get(i).getText();
						System.out.println(options);
						//TestUtil.takeScreenShot("List of Values");
					}
				}
				
				// to verify Element is present
				public static boolean isElementPresent(String locator) throws Exception, IOException {
					try {
						driver.findElement(By.xpath(CommonMethods.readPropertyFile(locator))).isDisplayed();
						return true;
					} catch (NoSuchElementException e) {
						return false;
					}

				}
				
				public static String fetchParentWindowID()
			    {
			            String parentwindowID=driver.getWindowHandle();
			            log.info("Parent Window ID  = "+parentwindowID);
			        return parentwindowID;
			    }



			   public static void switchToParentWindowByID(String parentID) {



			       try {
			            //String parentwindow=driver.getWindowHandle();
			            //parentID= fetchParentWindowID();
			            driver.switchTo().window(parentID);
			            log.info("Swiched to parent window "+driver.getTitle()+" with ID "+parentID);



			       }catch(Exception e) {
			            log.error("Not able to switch to parent window "+e.getMessage());
			        }



			   }


}
