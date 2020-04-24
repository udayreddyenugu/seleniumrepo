package supporting;

import java.util.concurrent.TimeUnit;

public class WaitMethods extends ExcelSheetReader
{
	public void implicit_wait()
  	{
	  dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
  	}
}
