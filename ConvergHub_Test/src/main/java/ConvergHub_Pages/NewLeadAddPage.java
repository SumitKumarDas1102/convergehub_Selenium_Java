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
	
	@FindBy(xpath="//input[@id='primary_address_city']")
	private WebElement cityName;
	
	@FindBy(xpath="//input[@id='primary_address_state']")
	private WebElement stateName;
	
	@FindBy(xpath="//select[@id='primary_address_country_select_drp_dwn']")
	private WebElement selectCournty;
	
	@FindBy(xpath="//input[@id='birthdate']")
	private WebElement enterDOB;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	private WebElement selectMonth;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	private WebElement selectYear;
	
	@FindBy(xpath="//a[@class='ui-state-default']")
	private WebElement selectDay;
	
	@FindBy(xpath="//button[@class='button fresh_green save_button_from_module_add']")
	private WebElement clickOnSave;
	
	@FindBy(xpath="//div[@id = 'left-panel_menu']//ul//li[@id='lbl_leads_module_name']")
	private WebElement lftPanelLead;
	
	@FindBy(xpath="//span[@id='header_name_change']")
	private WebElement createdLeadName;
	
	
	
	public NewLeadAddPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateHeaderText() {
		return headerText.getText();
	}
	
	
	public void createLead_General(String sal, String frstName, String lastName, String industry) {
		Select select01 = new Select(salutationDropDown);
		select01.selectByValue(sal);
		
		firstNameInputField.clear();
		firstNameInputField.sendKeys(frstName);
		
		lastNameInputField.clear();
		lastNameInputField.sendKeys(lastName);
		
		Select select02 = new Select(industryDropDown);
		select02.selectByVisibleText(industry);
		
		AddressTab.click();
	}
	
	public void createLead_Address(String add, String city, String state, String country) {
		primaryAddress.clear();
		primaryAddress.sendKeys(add);
		
		cityName.clear();
		cityName.sendKeys(city);
		
		stateName.clear();
		stateName.sendKeys(state);
		
		Select select04 = new Select(selectCournty);
		select04.selectByVisibleText(country);
		
		OtherTab.click();
	}
	
	public void createLead_Other(String month, String year, String day) {
		enterDOB.click();
		
		Select selectMnth = new Select(selectMonth);
		selectMnth.selectByVisibleText(month);
		
		Select selectYr = new Select(selectYear);
		selectYr.selectByVisibleText(year);
		
		selectDay.sendKeys(day);
		
		clickOnSave.click();
		lftPanelLead.click();
	}
	
	
	public String validateCreatedLeadName() {
		return createdLeadName.getText();
	}
	
	

}
