package ConvergHub_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ConvergHub_Base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(xpath="//img[@alt='ConvergeHub']")
	private WebElement ConvergHubLogo;
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='loginb']")
	private WebElement loginButton;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean validateLoginPageLogo() {
		return ConvergHubLogo.isDisplayed();
	}
	
	public DashboaardPage loginFunction(String un, String pwd) {
		userName.isDisplayed();
		userName.clear();
		userName.sendKeys(un);
		password.isDisplayed();
		password.clear();
		password.sendKeys(pwd);
		loginButton.click();
		return new DashboaardPage();
	}
	
	
	
	
}
