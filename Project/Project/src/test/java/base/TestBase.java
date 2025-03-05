package base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;

public class TestBase {
	
protected WebDriver driver;
protected Properties prop;


public void setup() throws IOException
{
FileReader fObj=new FileReader("E:\\Project\\Project\\src\\test\\resources\\credentials.properties");
prop=new Properties();
prop.load(fObj);
}

@BeforeTest
public void bfTest() throws IOException
{
	setup();
	if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}
	else {
		driver=new EdgeDriver();
	}
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
}


}


