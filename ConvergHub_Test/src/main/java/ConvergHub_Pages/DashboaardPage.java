package ConvergHub_Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ConvergHub_Base.TestBase;
import ConvergHub_Util.TestUtil;

public class DashboaardPage extends TestBase {
	
	@FindBy(xpath="//li[@class='admin-name']")
	private WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Sales')]")
	private WebElement SalesButton;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	private WebElement logOutButton;
	
	@FindBy(xpath="//button[contains(text(),'Not Now')]")
	private WebElement rejectNotificationButton;
	
	@FindBy(xpath="//div[@id = 'left-panel_menu']//ul//li[@id='lbl_leads']")
	private WebElement headerLeadButton;
	
	@FindAll(@FindBy(xpath="//div[@id='left-panel_menu']//li"))
	private List<WebElement> leftMenuitems;
	
	
	
	
	public DashboaardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateUserName() {
		return userNameLabel.getText();
	}
	
	public LeadsPage clickOnLeadButton() {
		TestUtil.threadSleep();
		headerLeadButton.click();
		return new LeadsPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public LoginPage clickOnLogoutButon() {
		Actions actions = new Actions(driver);
		actions.moveToElement(userNameLabel).perform();
		logOutButton.click();
		return new LoginPage();
	}
	
	public void rejectNotificationPopUp() {
		TestUtil.switchToActiveFrame();
		rejectNotificationButton.click();
	}

}
