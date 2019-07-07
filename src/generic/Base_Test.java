package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import scripts.searchflight;

public class Base_Test implements Auto_const{
	
	//public static Logger Log =(Logger) LogManager.getLogger(searchflight.class.getName());

	public WebDriver driver;
	@Parameters({"browser"})
	@BeforeMethod
	public void openappl(String browser) throws IOException
	{
		/*FileInputStream fis=new FileInputStream("./properties/properties.txt");
		Properties prop=new Properties();
		prop.load(fis);
		
		String browser=prop.getProperty("browser");*/
		if(browser.equals("firefox"))
		{	
		//	Log.info("started logging");
		driver=new FirefoxDriver();
		driver.get("https://www.cleartrip.com/");
		}
		else
		{
			driver=new ChromeDriver();
			driver.get("https://www.cleartrip.com/");
		}
		
	}
	
	@AfterMethod
	public void closeappl(ITestResult r)
	{
		int i = r.getStatus();
		if(i==2)
		{
			TakesScreenshot sc=(TakesScreenshot)driver;
			File src = sc.getScreenshotAs(OutputType.FILE);
			File dst=new File("V:\\Kavya\\Sleniumnewclass\\Resources\\fail.png");
			try {
				FileUtils.copyFile(src,dst);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		driver.quit();
	}
}
