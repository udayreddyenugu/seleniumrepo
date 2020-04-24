package supporting;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import pageElements.DriverIntialization;

public class ExcelSheetReader extends DriverIntialization
{
  		String Exceel_Path;
  		
  		public HSSFWorkbook Exceel() throws Exception 
  		{
  			Exceel_Path = loadFile().getProperty("Exceel_Physical_Path");
  			System.out.println("Exceel_Path ==>"+Exceel_Path);
  			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\"+Exceel_Path);
  			HSSFWorkbook workbook = new HSSFWorkbook(fis);
  			
  			return workbook;
  		}
  		
  		public void ExceelOutput(HSSFWorkbook workbook) throws Exception
  		{
  			Exceel_Path = loadFile().getProperty("Exceel_Physical_Path");
  			System.out.println("Exceel_Path ==>"+Exceel_Path);
  			
  			FileOutputStream fos = new FileOutputStream(Exceel_Path);
  			workbook.write(fos);
  		}

}
