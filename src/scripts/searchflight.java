package scripts;

import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import generic.Base_Test;
import generic.excel;
import pom.welcomepage;

public class searchflight extends Base_Test{
	
	@Test
	public void testsearchflight() throws InterruptedException
	{
		
		String fplace = excel.getexceldata("searchflight", PATH, 1, 0);
		String tplace = excel.getexceldata("searchflight", PATH, 1, 1);
		String title = excel.getexceldata("searchflight", PATH, 1, 2);
		welcomepage wc=new welcomepage(driver);
		
		wc.onewaytrip();
		wc.fromplace(fplace);
		wc.toplace(tplace);
		wc.cal();
		wc.date();
		Thread.sleep(3000);
		wc.adlt();
		wc.chldren();
		wc.infts();
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(3000);
		wc.links();
		Thread.sleep(3000);
		wc.clas();
		Thread.sleep(3000);
		wc.search();
		Thread.sleep(3000);
		wc.VerifyTitle(title);
		
		
		
	}

}
