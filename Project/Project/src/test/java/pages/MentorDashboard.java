package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;

public class MentorDashboard {
	
	WebDriver driver;

    // Constructor to initialize the WebDriver
    public MentorDashboard(WebDriver drv) {
        this.driver = drv;
    }
    
 // Method to scroll down the page`  
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300);"); 
    }
    //Method to list all the assigned projects of mentor
    public String allotedPrjct()
    {
    	WebElement projects=driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Projects'])[1]/following::h6[1]"));
    	String prjct=projects.getText();
    	return prjct;
    }
    // Method to scroll and view the next project (if needed)
    public String viewNextAllotedPrjct() {
        // Scroll down to load the next project
        scrollDown();
        
        // Wait for a moment if needed (you may want to use WebDriverWait if necessary to ensure the content has loaded)
        try {
            Thread.sleep(1000);  // Wait for 1 second (you can replace this with WebDriverWait)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     // Now retrieve the next project after scrolling down
        WebElement nextProject = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='View'])[1]/following::h6[1]"));
        String nextPrjct = nextProject.getText();
        return nextPrjct;
    }
    //Method to add a reference material
    public void addReferenceForm()
    {
    	WebElement link = driver.findElement(By.xpath("//a[@href='/reference-materials']"));
    	link.click();
    	WebElement button = driver.findElement(By.xpath("//button[contains(text(), '+ Add Reference Material')]"));
    	button.click();
    	driver.findElement(By.id("topic")).sendKeys("Software Testing");
    	driver.findElement(By.id("referenceMaterial")).sendKeys("Tutorials Point");
    	driver.findElement(By.xpath("//input[@id='postedDate' and @name='postedDate']")).sendKeys("17-02-2024");
    	driver.findElement(By.id("url")).sendKeys("https://www.tutorialspoint.com/software_testing/index.htm");
    	driver.findElement(By.id("status")).sendKeys("Completed");
    	driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
    	
    	public void  popMssg() {
    		try {
    			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    		        wait.until(ExpectedConditions.alertIsPresent());  // Wait for alert

    		        // Switch to the alert and accept it(webpage to pop up page)
    		        Alert alert = driver.switchTo().alert();
    		        System.out.println("Popup Message: " + alert.getText()); // Print alert text
    		        alert.accept(); // Click OK
    		        System.out.println("Popup handled successfully!");
    		    } catch (NoAlertPresentException e) {
    		        System.out.println("No popup appeared.");
    		}
    	
    	}
    	//Method to delete a reference material
    	public void deleteReference()
    	{
    	driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='google'])[1]/following::button[1]")).click();
    	driver.findElement(By.xpath("//button[text()='Confirm']")).click();

    	}
    	//Method for mentor logout
    	public void mentorLogout()
    	{
    		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("MuiDialog-container")));
    		driver.findElement(By.xpath("//span[text()='Logout']")).click();
    	}
    	
    	
    }
    
  
