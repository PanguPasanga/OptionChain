package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import optionMethods.SeMethods;
import utils.WeeklyNiftyExcel;

public class NseWeeklyPage 
{	
	
	public static void main(String args[]) throws IOException, InterruptedException
	{
		String CE_oi,CE_choi,CE_vol,CE_iv,CE_ltp,PE_ltp,PE_iv,PE_vol,PE_choi,PE_oi,livePrice,strikeData;
	
	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.navigate().to("https://www1.nseindia.com/");
	driver.manage().window().maximize();
	Actions act= new Actions(driver);
	WebDriverWait wt= new WebDriverWait(driver, 20);
	WebElement live=driver.findElement(By.linkText("Live Market"));
	
	act.moveToElement(live).perform();
	
	WebElement equity =driver.findElement(By.xpath("//li[@id=\"main_livewth_oc\"]/a"));
	act.moveToElement(equity);
	act.click().build().perform();
	
	//Dynamic table starts here
	WebElement optionTable = driver.findElement(By.xpath("//table[@id=\"octable\"]"));
	
	List<String> strikePrices=new ArrayList<String>();
	strikePrices.add("10800.00");
	strikePrices.add("10900.00");
	strikePrices.add("11000.00");
	strikePrices.add("11100.00");
	strikePrices.add("11200.00");
	strikePrices.add("11300.00");
	strikePrices.add("11400.00");
	strikePrices.add("11500.00");
	strikePrices.add("11600.00");
	strikePrices.add("11700.00");
	for(String s:strikePrices)
	{
		//System.out.println(s);
		WebElement strikePrice = optionTable.findElement(By.xpath("//b[contains(text(),'"+s+"')]"));
		
	
//WebElement strikePrice = optionTable.findElement(By.xpath("//b[contains(text(),'11500.00')]"));
WebElement callOpenInterest = strikePrice.findElement(By.xpath("../parent::td/preceding-sibling::td/following-sibling::td"));
WebElement callChangeInInterest = strikePrice.findElement(By.xpath("../parent::td/preceding-sibling::td/following-sibling::td[2]"));
WebElement callVolume = strikePrice.findElement(By.xpath("../parent::td/preceding-sibling::td/following-sibling::td[3]"));
WebElement callIV = strikePrice.findElement(By.xpath("../parent::td/preceding-sibling::td/following-sibling::td[4]"));
WebElement callLTP=strikePrice.findElement(By.xpath("../parent::td/preceding-sibling::td/following-sibling::td[5]"));
WebElement putLTP=strikePrice.findElement(By.xpath("../parent::td/preceding-sibling::td/following-sibling::td[17]"));
WebElement putIV = strikePrice.findElement(By.xpath("../parent::td/preceding-sibling::td/following-sibling::td[18]"));
WebElement putVolume = strikePrice.findElement(By.xpath("../parent::td/preceding-sibling::td/following-sibling::td[19]"));
WebElement putChangeInInterest=strikePrice.findElement(By.xpath("../parent::td/preceding-sibling::td/following-sibling::td[20]"));
WebElement putOpenInterest =strikePrice.findElement(By.xpath("../parent::td/preceding-sibling::td/following-sibling::td[21]"));
WebElement niftyPrice=driver.findElement(By.xpath("//nobr[contains(text(),1)]"));

/*//To Print all the values
System.out.println("----------------------------------Printing values----------------------------------------");

System.out.println("The Open Interest for CE the strike Price "+strikePrice.getText()+" is :"+callOpenInterest.getText());
System.out.println("The Change In Open Interest for CE strike Price "+strikePrice.getText()+" is :"+callChangeInInterest.getText());
System.out.println("The volume  for CE strike Price "+strikePrice.getText()+" is :"+callVolume.getText());
System.out.println("The Implied Volatility for CE strike Price "+strikePrice.getText()+" is :"+callIV.getText());
System.out.println("The Last traded price for CE strike Price "+strikePrice.getText()+" is :"+callLTP.getText());
System.out.println("The Last traded price for Put strike Price "+strikePrice.getText()+" is :"+putLTP.getText());
System.out.println("The Implied Volatility for put Strike pice "+strikePrice.getText()+" is :"+putIV.getText());
System.out.println("The volume for put Strike pice "+strikePrice.getText()+" is :"+putVolume.getText());
System.out.println("The change in Open Interest for put Strike pice "+strikePrice.getText()+" is :"+putChangeInInterest.getText());
System.out.println("The Open Interest for put Strike pice "+strikePrice.getText()+" is :"+putOpenInterest.getText());

System.out.println("---------------------------------------End of strike values------------------------------");*/
	

CE_oi=callOpenInterest.getText();
CE_choi=callChangeInInterest.getText();
CE_vol=callVolume.getText();
CE_iv=callIV.getText();
CE_ltp=callLTP.getText();
PE_ltp=putLTP.getText();
PE_iv=putIV.getText();
PE_vol=putVolume.getText();
PE_choi=putChangeInInterest.getText();
PE_oi=putOpenInterest.getText();
livePrice=niftyPrice.getText();
strikeData=strikePrice.getText();


//-----------------------------------------
List<String> optionData = new ArrayList<String>();
optionData.add(CE_oi);
optionData.add(CE_choi);
optionData.add(CE_vol);
optionData.add(CE_iv);
optionData.add(CE_ltp);
optionData.add(PE_ltp);
optionData.add(PE_iv);
optionData.add(PE_vol);
optionData.add(PE_choi);
optionData.add(PE_oi);
optionData.add(livePrice);

WeeklyNiftyExcel.writeToExcel(optionData,strikeData);
optionData.clear();
	}
}
	
}

