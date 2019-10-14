package optionMethods;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeMethods implements optionMethod
{

	public static RemoteWebDriver driver;
	public static int i = 1;

	@Override
	public void startApp(String browser, String url) throws MalformedURLException {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			System.out.println("Before URL");
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			System.out.println("After semethods time");
			
		} catch (WebDriverException e) {
			 

		}

	}

	@Override
	public WebElement locateElement(String locator, String locValue) {
		try {
			switch (locator) {
			case ("id"):
				return driver.findElementById(locValue);
			case ("link"):
				return driver.findElementByLinkText(locValue);
			case ("xpath"):
				return driver.findElementByXPath(locValue);
			case ("name"):
				return driver.findElementByName(locValue);
			case ("class"):
				return driver.findElementByClassName(locValue);
			case ("tag"):
				return driver.findElementByTagName(locValue);
			}
		} catch (NoSuchElementException e) {
			// report
			 
		} catch (WebDriverException e) {
			// report
			
		}
		return null;
	}

	public WebElement locateElement(String locValue) {

		return driver.findElementById(locValue);
	}

	@Override
	public void type(WebElement ele, String data) {
		try {
			//highlighterMethod(driver, ele);
			ele.clear();
			ele.sendKeys(data);
			// REport
			
		} catch (Exception e) {
			// report
			
		}

	}

	@Override
	public void click(WebElement ele) {
		try {
			//highlighterMethod(driver, ele);
			System.out.println("Before 1 time");
			WebDriverWait wait = new WebDriverWait(driver, 10);
			System.out.println("Before 2 time");
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			System.out.println("time over");
			ele.click();
			// report
			
		} catch (WebDriverException e) {
			// report
			
		}

	}

	@Override
	public String getText(WebElement ele) {
		String text = "";
		try {
			//highlighterMethod(driver, ele);
			text = ele.getText();
			// report
			
		} catch (WebDriverException e) {
			// report
			
		}
		return text;
	}

	@Override
	public void selectDropDownUsingText(WebElement ele, String value) {
		try {
			//highlighterMethod(driver, ele);
			ele.click();
			Select sc = new Select(ele);
			sc.selectByValue(value);
			// report
			
		} catch (WebDriverException e) {
			// report
			
		} finally {
			//deHighlighterMethod(driver, ele);
		}

	}

	@Override
	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			//highlighterMethod(driver, ele);
			Select sc = new Select(ele);
			sc.selectByIndex(index);
			// report
			

		} catch (WebDriverException e) {
			// report
			
		} finally {
			//deHighlighterMethod(driver, ele);
		}
	}

	@Override
	public boolean verifyTitle(String expectedTitle) {
		boolean breturn = true;
		String txt = driver.getTitle();
		try {
			if (txt.equals(expectedTitle)) {
				// REPORT
				
			} else {
				// REPORT
				
			}
		} catch (WebDriverException e) {
			// report
			
		}

		return breturn;
	}

	@Override
	public void verifyExactText(WebElement ele, String expectedText) {
		try {
			//highlighterMethod(driver, ele);
			String txt = ele.getText();
			System.out.println("Text is :" + txt);
			System.out.println("The expected Text is :" + expectedText);
			String text = txt.trim();
			System.out.println("\nTHE TEXT IS :" + text);
			if (text.equals(expectedText))

			{
				// REPORT
				
			} else {
				// REPORT
				
			}
		} catch (Exception e) {
			// REPORT
			
		} finally {
			
		}

	}

	@Override
	public void verifyPartialText(WebElement ele, String expectedText) {
		try {
			//highlighterMethod(driver, ele);
			String txt = ele.getText();
			if (txt.contains(expectedText)) {
				// REPORT STEP NEED TO ADDED
				
			} else {
				// REPORT STEP NEED TO BE ADDED
				
			}
		} catch (Exception e) {
			// REPORT
			
		} finally {
			
		}

	}

	@Override
	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		try {
			//highlighterMethod(driver, ele);
			System.out.println("ELEMENT IS "+ele.getText());
			if (ele.getAttribute(attribute).equals(value)) {
				// REPORT STEP NEED TO BE ADDED
				
			} else {
				// REPORT STEP NEED TO BE ADDED
				
			}
		} catch (Exception e) {
			// REPORT STEP NEED TO BE ADDED
			
		} finally {
			//deHighlighterMethod(driver, ele);
		}
	}

	@Override
	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		try {
			//highlighterMethod(driver, ele);
			if (ele.getAttribute(attribute).contains(value)) {
				// REPORT STEP NEED TO BE ADDED
				
			} else {
				// REPORT STEP NEED TO BE ADDED
			
			}
		} catch (Exception e) {
			// REPORT STEP NEED TO BE ADDED
			
		} finally {
			//deHighlighterMethod(driver, ele);
		}

	}

	@Override
	public void verifySelected(WebElement ele) {
		try {
			//highlighterMethod(driver, ele);
			if (ele.isSelected()) {
				
			} else {
				

			}
		} catch (NoSuchElementException e) {
			
		} finally {
			//deHighlighterMethod(driver, ele);
		}

	}

	@Override
	public void verifyDisplayed(WebElement ele) {
		try {
			//highlighterMethod(driver, ele);
			if (ele.isDisplayed()) {
				
			} else {
				
			}
		} catch (NoSuchElementException e) {
			
		} catch (WebDriverException e) {
			
		} finally {
			
		}

	}

	@Override
	public void switchToWindow(int index) {
		try {
			Set<String> allWindowHandles = driver.getWindowHandles();
			ArrayList<String> windowHandle = new ArrayList<>();
			windowHandle.addAll(allWindowHandles);
			driver.switchTo().window(windowHandle.get(index));
			
		} catch (NoSuchWindowException e) {
			
		} catch (WebDriverException e) {
			
		}

	}

	@Override
	public void switchToFrame(WebElement ele) {
		try {
			//highlighterMethod(driver, ele);
			driver.switchTo().frame(ele);
			
		} catch (NoSuchFrameException e) {
			

		} catch (WebDriverException e) {
			
		} finally {
			//deHighlighterMethod(driver, ele);
		}

	}

	@Override
	public void acceptAlert() {
		String text;
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void dismissAlert() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String getAlertText() {
		String text = "";
		try {
			Alert alert = driver.switchTo().alert();
			text = alert.getText();
			
		} catch (NoAlertPresentException e) {
			
		} catch (WebDriverException e) {
			
		}
		return text;
	}

	@Override
	public int takeSnap() {
		// long number = (long) Math.floor(Math.random() * 900000000L) +
		// 10000000L;
		int number;
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("./Reports/images/" + i + ".jpg"));
			System.out.println("The snapshot images taken successfully");
		} catch (WebDriverException e) {
			System.out.println("The snapshot webdriver exception");
		} catch (IOException e) {
			System.out.println("The snapshot IOexception");
		}
		number = i;
		i++;
		return number;
	}

	@Override
	public void closeBrowser() {
		driver.close();

	}

	@Override
	public void closeAllBrowsers() {
		try {
			System.out.println("Before browser quit");
			driver.quit();
			
		} catch (Exception e) {
			
		}

	}

	@Override
	public void selectFirstDropdown(WebElement ele, String value) {
		// TODO Auto-generated method stub
		try {
			//highlighterMethod(driver, ele);
			Select se = new Select(ele);
			WebElement firstOption = se.getFirstSelectedOption();
			System.out.println("The firstoption is selected: " + firstOption.getText());
			System.out.println("\n THE VALUE IS : " + value);
		
			verifyExactText(firstOption, value);

		} catch (WebDriverException e) {
			
		} finally {
			//deHighlighterMethod(driver, ele);
		}
	}

	public void deHighlighterMethod(WebDriver driver, WebElement ele) {
		if (driver instanceof JavascriptExecutor)
			// JavascriptExecutor js= (JavascriptExecutor)driver;
			((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style','border:0px;');", ele);

	}

	public void highlighterMethod(WebDriver driver, WebElement ele) {
		// TODO Auto-generated method stub
		if (driver instanceof JavascriptExecutor)
			// JavascriptExecutor js= (JavascriptExecutor)driver;
			((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style','border:2px solid red;');",
					ele);

	}

	public void optionalisVisible(WebElement ele) {
		try {
			if (ele.isDisplayed()) {
				

			} else {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void isEnabled(WebElement ele) {
		try {
			if (ele.isEnabled()) {
				

			} else {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void mandatoryVisible(WebElement ele) {
		try {
			if (ele.isDisplayed()) {
				

			} else {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
