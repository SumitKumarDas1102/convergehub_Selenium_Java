package ConvergHub_TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ConvergHub_Base.TestBase;
import ConvergHub_Pages.DashboaardPage;
import ConvergHub_Pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage lp;
	DashboaardPage dp;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		lp = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void IsLoginPageLogoVisibleTest() {
		boolean flag = lp.validateLoginPageLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void IsLoginFunctionWorkingTest() {
		dp = lp.loginFunction(prop.getProperty("userName"), prop.getProperty("userPassword"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
