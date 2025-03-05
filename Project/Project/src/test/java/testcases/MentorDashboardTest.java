package testcases;

import pages.MentorDashboard;
import utilities.AutomationConstants;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;

public class MentorDashboardTest extends TestBase {
	
	LoginPage lObj;
    MentorDashboard mObj;
    
    @BeforeClass
	public void bfClass() throws IOException
	{
		lObj=new LoginPage(driver);
		mObj=new MentorDashboard(driver); //object initialization
		
	}
    @Test
	public void prjctList()
	{
		lObj.mentorlgnButton();
		//aObj.waitForProjectListToUpdate();
		String actResult=mObj.allotedPrjct();
		Assert.assertEquals(actResult, AutomationConstants.prjct1);
		String actResult1=mObj.viewNextAllotedPrjct();
		Assert.assertEquals(actResult1, AutomationConstants.prjct2);
		mObj.addReferenceForm();
		mObj.popMssg();
		mObj.deleteReference();
		mObj.mentorLogout();
	}

}
