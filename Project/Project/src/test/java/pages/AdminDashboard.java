package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
//import java.util.List;

public class AdminDashboard {

    WebDriver driver;

    // Constructor to initialize the WebDriver
    public AdminDashboard(WebDriver drv) {
        this.driver = drv;
    }
 // Method to scroll down the page`  
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300);"); 
    }

    // Method for adding a new project
    public void addPrjct(String topic, String dura) {
        driver.findElement(By.xpath("/html/body/div/div/div[2]/main/div[1]/button")).click();
        driver.findElement(By.xpath("//input[@name='topic']")).sendKeys(topic);
        driver.findElement(By.xpath("//input[@name='duration']")).sendKeys(dura);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")).click();
        
        scrollDown();
     // Wait for a moment if needed (you may want to use WebDriverWait if necessary to ensure the content has loaded)
        try {
            Thread.sleep(1000);  // Wait for 1 second (you can replace this with WebDriverWait)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void logout() {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("MuiDialog-container")));
		WebElement logoutButton = driver.findElement(By.xpath("//span[text()='Logout']"));
		logoutButton.click();
    }
    //Method to edit an existing project
    public void editPrjct() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	WebElement button = driver.findElement(By.xpath("//tr[2]/td[2]/button"));
    	button.click();
    	
    	WebElement edit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input")));
    	edit.click();
    	Actions actions = new Actions(driver);
    	 for (int i = 0; i < 50; i++) {
    	actions.sendKeys(edit, Keys.BACK_SPACE).perform();
    	 }
    	edit.sendKeys("SQL");
    	WebElement edit1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/input")));
    	edit1.click();
    	Actions actions1 = new Actions(driver);
    	 for (int i = 0; i < 50; i++) {
    	actions1.sendKeys(edit1, Keys.BACK_SPACE).perform();
    	 }
    	edit1.sendKeys("4");
    	driver.findElement(By.xpath("//button[text()='Update']")).click();

    }
    public void deletePrjct()
    {
    	driver.findElement(By.xpath("//tr[4]/td[2]/button[2]")).click();
    	try {
			 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		        wait1.until(ExpectedConditions.alertIsPresent());  // Wait for alert

		        // Switch to the alert and accept it(webpage to pop up page)
		        Alert alert = driver.switchTo().alert();
		        System.out.println("Popup Message: " + alert.getText()); // Print alert text
		        alert.accept(); // Click OK
		        System.out.println("Popup handled successfully!");
		    } catch (NoAlertPresentException e) {
		        System.out.println("No popup appeared.");
		}
    }
    //Method to add a new mentor with all valid fields
    public void  addMentor()
    {
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("MuiDialog-container")));
    	driver.findElement(By.xpath("//span[text()='Mentors']")).click();
    	driver.findElement(By.xpath("//button[text()='+ Add Mentor']")).click();
    	driver.findElement(By.cssSelector("input.MuiInputBase-input.MuiInput-input")).sendKeys("Lakshmi");
    	driver.findElement(By.xpath("//input[@name='email']")).sendKeys("lakshmi@example.com");
    	driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("8867776578");
    	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Amrutha@07");
    	//driver.findElement(By.xpath("//input[@autocomplete='off']")).click();
    	driver.findElement(By.xpath("//div[5]/div/div/input")).click();
    	driver.findElement(By.xpath("//li[4]")).click();
    	driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")).click();
    	scrollDown();
    	
    }
    //Method to add a new mentor with invalid fields and to check if there is an error or not
//    public void invalidAddMentor()
//    {
//    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("MuiDialog-container")));
//    	driver.findElement(By.xpath("//span[text()='Mentors']")).click();
//    	driver.findElement(By.xpath("//button[text()='+ Add Mentor']")).click();
//    	driver.findElement(By.cssSelector("input.MuiInputBase-input.MuiInput-input")).sendKeys("");
//    	driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ra@gmail.com");
//    	driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("8867790975");
//    	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Abcd@123");
//    	driver.findElement(By.xpath("//input[@autocomplete='off']")).click();
//    	driver.findElement(By.xpath("//li[@id=':ra:-option-3']")).click();
//    	driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")).click();
//    	try {
//			 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
//		        wait1.until(ExpectedConditions.alertIsPresent());  // Wait for alert
//
//		        // Switch to the alert and accept it(webpage to pop up page)
//		        Alert alert = driver.switchTo().alert();
//		        System.out.println("Popup Message: " + alert.getText()); // Print alert text
//		        alert.accept(); // Click OK
//		        System.out.println("Popup handled successfully!");
//		    } catch (NoAlertPresentException e) {
//		        System.out.println("No popup appeared.");
//		}
//    }
    //Method to edit the mentor details
    public void editMentor()
    {
    	scrollDown();
    	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("MuiDialog-container")));
    	driver.findElement(By.xpath("//tr[3]/td[4]/button")).click();
    	//driver.findElement(By.xpath("//input[@autocomplete='off']")).click();
    	driver.findElement(By.xpath("//div[5]/div/div/input")).click();
    	driver.findElement(By.xpath("//li[4]")).click();    
    	driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")).click();
    }
    //Method to delete a mentor
    public void deleteMentor()
    {
    	driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='stevesmith@email.com'])[1]/following::button[2]")).click();
    	try {
			 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
		        wait1.until(ExpectedConditions.alertIsPresent());  // Wait for alert

		        // Switch to the alert and accept it(webpage to pop up page)
		        Alert alert = driver.switchTo().alert();
		        System.out.println("Popup Message: " + alert.getText()); // Print alert text
		        alert.accept(); // Click OK
		        System.out.println("Popup handled successfully!");
		        System.out.println("Deleted successfully!");
		    } catch (NoAlertPresentException e) {
		        System.out.println("No popup appeared.");
		}
    }

}

