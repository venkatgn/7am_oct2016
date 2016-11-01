package yahoo;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })
public class ReTest 
{
	WebDriver driver;
	DesiredCapabilities ds;
	
	{
	    System.setProperty("atu.reporter.config", "e:/7am_oct_2016/atu.properties");
	}
	
  @Test
  @Parameters({"browser"})
  public void retesting(String br) throws Exception
  {
	  if(br.matches("firefox"))
	  {
		 driver=new FirefoxDriver();
		 //ds=DesiredCapabilities.firefox();
		// ds.setPlatform(Platform.WINDOWS);
		  
	  }
	  if(br.matches("ie"))
	  {
		  System.setProperty("webdriver.ie.driver","c:\\IEDriverServer.exe");
		  driver=new InternetExplorerDriver();
		  //ds=DesiredCapabilities.internetExplorer();
		  //ds.setPlatform(Platform.WINDOWS);
	  }
	  //driver=new RemoteWebDriver(new URL("http://192.168.1.186:1234/wd/hub"), ds);
	  Home h=new Home(driver);
	  h.validate_links();
	  h.createacc();
	  h.login();
	  
	  Inbox i=new Inbox(driver);
	  i.deletemail();
	  
	  Compose c=new Compose(driver);
	  c.signout();
  }
}
