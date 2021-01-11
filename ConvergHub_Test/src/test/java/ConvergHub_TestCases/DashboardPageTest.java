package ConvergHub_TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ConvergHub_Base.TestBase;
import ConvergHub_Pages.DashboaardPage;
import ConvergHub_Pages.LeadsPage;
import ConvergHub_Pages.LoginPage;

public class DashboardPageTest extends TestBase{
	LoginPage lp;
	DashboaardPage dp;
	LeadsPage ld_Pages;
	
	public DashboardPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage();
		dp = lp.loginFunction(prop.getProperty("userName"), prop.getProperty("userPassword"));
	}
	
	@Test(priority=1)
	public void IsProperUserNameVisibleTest() {
		String loggedinUserName = dp.validateUserName();
		Assert.assertEquals(loggedinUserName, "Corelynx tester");	
	}
	
	@Test(priority=2)
	public void IsSalesButtonWorkingTest() {
		ld_Pages = dp.clickOnSales();
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		dp.clickOnLogoutButon();
		driver.quit();
	}
}
