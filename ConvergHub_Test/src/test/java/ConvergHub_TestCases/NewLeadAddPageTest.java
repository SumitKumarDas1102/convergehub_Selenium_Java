package ConvergHub_TestCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ConvergHub_Base.TestBase;
import ConvergHub_Pages.DashboaardPage;
import ConvergHub_Pages.LeadsPage;
import ConvergHub_Pages.LoginPage;
import ConvergHub_Pages.NewLeadAddPage;
import ConvergHub_Util.TestUtil;

public class NewLeadAddPageTest extends TestBase {
	LoginPage lp;
	DashboaardPage dp;
	LeadsPage ld_Pages;
	NewLeadAddPage addLead_page;
	
	public NewLeadAddPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage();
		dp = lp.loginFunction(prop.getProperty("userName"), prop.getProperty("userPassword"));
		dp.rejectNotificationPopUp();
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		ld_Pages = dp.clickOnSales();
		addLead_page = ld_Pages.clickOnAddNewButton();
	}
	
	@Test(priority=1)
	public void validateHeaderText() {
		String headerText = addLead_page.validateHeaderText();
		Assert.assertEquals(headerText, "Add Lead");
	}
	
	@Test(priority=2)
	public void IsUserAbleToFillGeneralData() {
		addLead_page.addLead_generalStep();
	}
	
	
	
	
	
	
	
	
//	@AfterMethod
//	public void tearDown() {
//		dp.clickOnLogoutButon();
//		driver.quit();
//	}
	
	

}
