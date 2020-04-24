package pageElements;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import supporting.PropertyFileReader;

public class DriverIntialization  extends PropertyFileReader
{
	public WebDriver dr;
	
	  public void launchPortal() throws IOException 
	  {
		  String Portal_URL=loadFile().getProperty("IMDB_URL");
		  String browser_type=loadFile().getProperty("BROWSER_TYPE");
		  String browser_exe=loadFile().getProperty("BROWSER_EXE");
				  
		  System.setProperty(browser_type,System.getProperty("user.dir") +"\\"+browser_exe);

		  dr = new ChromeDriver();
		  dr.get(Portal_URL);
		  dr.manage().window().maximize();  
	  }
}
