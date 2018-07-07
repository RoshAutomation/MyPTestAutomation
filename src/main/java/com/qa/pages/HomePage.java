package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class HomePage extends TestBase {
	
	TestUtil util=new TestUtil();
	
	//Page Factory - OR:
	@FindBy(xpath="//a[@id='Tab6']")
	WebElement Nouvel_abonnement;
	
	@FindBy(xpath="//a[@id='flow_11']")
	WebElement Telephonic_mobile;
	
	@FindBy(xpath="//a[@id='Tab3']")
	WebElement Tool_Click;
	
	@FindBy(xpath="//span[.='Change BSCS Code']")
	WebElement BSCS_clk;
	
	@FindBy(xpath="//input[@name='aramis']")
	WebElement aramisValue;
	
	@FindBy(xpath="//a/span/span/span[.='Search']")
	WebElement searchBtn;
	
	@FindBy(xpath="//a/span/span/span[.='jmichiel']")
	WebElement jmichelles;
	
	@FindBy(xpath="//a/span/span/span[.='CALLI003']")
	WebElement calli003;
	

	
	//Initializing the Page Objects:
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String ValidateHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public MainForm NouvelAbonnement_click(){
		
		try {
			Nouvel_abonnement.click();
			util.switchToWindow();
			Thread.sleep(10000);
			driver.manage().window().maximize();
			Telephonic_mobile.click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new MainForm();
	}
	
	
	public void Aramis_b4Selection() throws InterruptedException{
		Tool_Click.click();
		Thread.sleep(8000);
		BSCS_clk.click();
		Thread.sleep(8000);	
	}
	
	public void Aramis_AfterSelection(String mainchain) throws InterruptedException{	
		String parent=driver.getWindowHandle();
		util.switchToWindow();
		Thread.sleep(9000);
		
			if(mainchain.equalsIgnoreCase("MP TESTGROUP")){
				aramisValue.sendKeys("jmichiel");
				searchBtn.click();
				jmichelles.click();	
				util.alertAceept();
				}
			else if(mainchain.equalsIgnoreCase("CALL IT CAMPAIGN")){
				aramisValue.sendKeys("calli003");
				searchBtn.click();
				calli003.click();
				util.alertAceept();
			}
		util.ReturnToParent(parent);
	}
	
}
