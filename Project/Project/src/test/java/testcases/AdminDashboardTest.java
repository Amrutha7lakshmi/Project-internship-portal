package testcases;

import java.io.IOException;

//import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AdminDashboard;
import pages.LoginPage;

public class AdminDashboardTest extends TestBase {
	
	
	LoginPage lObj;
    AdminDashboard aObj;
	
	@BeforeClass
	public void bfClass() throws IOException
	{
		lObj=new LoginPage(driver);
		aObj=new AdminDashboard(driver); //object initialization
		
	}
	@Test
	public void projectAdd()
	{
		lObj.lgnButton();	
		aObj.addPrjct("HTML", "6 months");
		lObj.logout();
		lObj.lgnButton();
		aObj.editPrjct();
		aObj.logout();
		lObj.lgnButton();
		aObj.deletePrjct();
		aObj.addMentor();
//		//aObj.invalidAddMentor();		
		aObj.editMentor();
		aObj.deleteMentor();
		lObj.logout();
		}

}
