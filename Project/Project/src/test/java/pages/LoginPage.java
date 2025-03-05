package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Credentials;

public class LoginPage extends Credentials {
	
WebDriver driver;
	
// Constructor to initialize the WebDriver
	public LoginPage(WebDriver drv) throws IOException 
	{
		this.driver=drv;
		LocateValues();
		
	}
	//Method to check if the login and join us button are displayed in the home page or not
	public void buttonDsply() {
		driver.findElement(By.cssSelector("button[class='btn1']")).isDisplayed();
		driver.findElement(By.cssSelector("button[class='btn2']")).isDisplayed();
	}
	//Method to check the valid login 
	public void lgnButton() {
		driver.findElement(By.cssSelector("button[class='btn1']")).click();
		String em = prop.getProperty("email");
		WebElement mail=driver.findElement(By.cssSelector("input#email"));
		mail.sendKeys(em);
		String pwd = prop.getProperty("pswd");
		WebElement password=driver.findElement(By.cssSelector("input#password"));
		password.sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	//Method to check the admin successfully login to the admin dashboard
	public String AdminDashboard() {
		WebElement dashboard=driver.findElement(By.xpath("//*[text()='Dashboard']"));
		String admdash=dashboard.getText();
		return admdash;
	}
	
	public void mentorlgnButton() {
		driver.findElement(By.cssSelector("button[class='btn1']")).click();
		String em = prop.getProperty("mail");
		WebElement email=driver.findElement(By.cssSelector("input#email"));
		email.sendKeys(em);
		String pwd = prop.getProperty("pass");
		WebElement password=driver.findElement(By.cssSelector("input#password"));
		password.sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	//Method to check the mentor successfully login to the mentor dashboard
	public String mentorDashboard() {
		WebElement dashboard=driver.findElement(By.cssSelector("h4.employee-name"));
		String dash=dashboard.getText();
		return dash;
	}
	//Method to logout
	public void logout() {
		WebElement logoutButton = driver.findElement(By.xpath("//span[contains(text(), 'Logout')]"));
		logoutButton.click();
	}
	//Method to check the invalid login 
	public String invalidlgnButton() {
		driver.findElement(By.cssSelector("button[class='btn1']")).click();
		String em = prop.getProperty("email");
		WebElement mail=driver.findElement(By.cssSelector("input#email"));
		mail.sendKeys(em);
		String pwd = prop.getProperty("pswd");
		WebElement password=driver.findElement(By.cssSelector("input#password"));
		password.sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement error=driver.findElement(By.xpath("//p[text()='Invalid username or password']"));
		String mssg=error.getText();
		return mssg;
	}

}
