package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utilities.AutomationConstants;

public class LoginPageTest extends TestBase {
	
LoginPage lObj;
	
	@BeforeClass
	public void bfClass() throws IOException
	{
		lObj=new LoginPage(driver); //object initialization
		
	}
	@Test
	public void btnDisplay()
	{
		lObj.buttonDsply();
	}
	@Test
	public void login()
	{
		lObj.lgnButton();
		String actResult1=lObj.AdminDashboard();
		Assert.assertEquals(actResult1, AutomationConstants.expDash);
		lObj.logout();
		//String actResult2=lObj.mentorDashboard();
		//Assert.assertEquals(actResult2, AutomationConstants.expname);
//		String actResult3=lObj.invalidlgnButton();
//		Assert.assertEquals(actResult3, AutomationConstants.errMsg);
		
	}


}
