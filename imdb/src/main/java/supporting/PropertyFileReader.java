package supporting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader 
{
	public Properties loadFile() throws IOException
	{
	  	Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\ElementProperties.properties");
		obj.load(objfile);
		return obj;
	}
}
