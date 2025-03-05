package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Credentials {
	
protected Properties prop;
	
	public void LocateValues() throws IOException
	{
		FileReader fObj=new FileReader("E:\\Project\\Project\\src\\test\\resources\\credentials.properties");//FileReader is used to read an external file.here it is config.properties
		prop=new Properties();
		prop.load(fObj);
	}

}
