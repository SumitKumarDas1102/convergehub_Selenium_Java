package ConvergHub_Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import ConvergHub_Base.TestBase;
import ConvergHub_Util.TestUtil;

public class NewLeadAddPage extends TestBase{
	
	@FindBy(xpath="//h1[contains(text(),'Add Lead')]")
	private WebElement headerText;
	
	@FindBy(xpath="//li[@id='gen_tab']")
	private WebElement GeneralTab;
	
	@FindBy(xpath="//li[@id='address_tab']")
	private WebElement AddressTab;
	
	@FindBy(xpath="//li[@id='othr_tab']")
	private WebElement OtherTab;
	
	@FindBy(xpath="//select[@id='salutation_select_drp_dwn']")
	private WebElement salutationDropDown;
	
	@FindBy(xpath="//input[@id='first_name']")
	private WebElement firstNameInputField;
	
	@FindBy(xpath="//input[@id='last_name']")
	private WebElement lastNameInputField;
	
	@FindBy(xpath="//select[@id='industry_select_drp_dwn']")
	private WebElement industryDropDown;
	
	@FindBy(xpath="//select[@title='Country code']")
	private WebElement countryDropDown;
	
	@FindBy(xpath="//input[@id='phoneNew1']")
	private WebElement phoneNumberInputField;
	
	@FindBy(xpath="//input[@id='primary_address']")
	private WebElement primaryAddress;
	
	@FindBy(xpath="//input[@id='birthdate']")
	private WebElement enterDOB;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	private WebElement selectMonth;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	private WebElement selectYear;
	
	@FindBy(xpath="//a[@class='ui-state-default']")
	private WebElement selectDay;
	
	@FindBy(xpath="//select[@id='employees_select_drp_dwn']")
	private WebElement sizeOfEmployee;
	
	@FindBy(xpath="//button[@class='button fresh_green save_button_from_module_add']")
	private WebElement clickOnSave;
	
	@FindBy(xpath="//span[@id='header_name_change']")
	private WebElement createdLeadName;
	
	public NewLeadAddPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateHeaderText() {
		return headerText.getText();
	}
	
	//Needs to modify later with proper solution
	public void addLead_generalStep() {
		
		Select select01 = new Select(salutationDropDown);
		select01.selectByValue("Mr.");
		
		firstNameInputField.clear();
		firstNameInputField.sendKeys("Corelynx");
		
		lastNameInputField.clear();
		lastNameInputField.sendKeys("tester");
		
		Select select02 = new Select(industryDropDown);
		select02.selectByVisibleText("Technology");
		
		Select select03 = new Select(countryDropDown);
		select03.selectByVisibleText("+91");
		
		phoneNumberInputField.clear();
		phoneNumberInputField.sendKeys("9586956325");
		AddressTab.click();
	}
	
	public void addLead_addressStep() {
		primaryAddress.clear();
		primaryAddress.sendKeys("Kolkata, West Bengal, India");
		OtherTab.click();
	}
	
	public void addLead_otherStep() {
		enterDOB.click();
		Select selectMnth = new Select(selectMonth);
		selectMnth.selectByVisibleText("Feb");
		
		Select selectYr = new Select(selectYear);
		selectYr.selectByVisibleText("1991");
		
		selectDay.sendKeys("11");
		
		Select selectsizeOfEmp = new Select(sizeOfEmployee);
		selectsizeOfEmp.selectByVisibleText("1 - 30");
		
		clickOnSave.click();
	}
	
	
	public String validateCreatedLeadName() {
		return createdLeadName.getText();
	}
	
	

}
