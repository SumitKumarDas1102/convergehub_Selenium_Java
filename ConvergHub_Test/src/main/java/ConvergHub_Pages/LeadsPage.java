//Sales page URL showing as /leads - so named the class as LeadsPage 

package ConvergHub_Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import ConvergHub_Base.TestBase;
import ConvergHub_Util.TestUtil;

public class LeadsPage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'+ New')]")
	private WebElement addNewLead;
	
	public LeadsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isAddNewButtonVisible() {
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		return addNewLead.isDisplayed();
	}
	
	public NewLeadAddPage clickOnAddNewButton() {
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		addNewLead.click();
		return new NewLeadAddPage();
	}
}