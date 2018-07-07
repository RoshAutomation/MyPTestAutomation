package com.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class MainForm extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//a[@id='bloc_1']")
	WebElement firstForm;
	
	//Page Factory - OR:
	@FindBy(xpath="//a[@id='bloc_2']")
	WebElement secondForm;
	
	//Page Factory - OR:
	@FindBy(xpath="//a[@id='bloc_4']")
	WebElement thirdForm;
	
	@FindBy(xpath="//*[@id='finalizeButton']")
	WebElement finalizer;
	
	@FindBy(xpath="//*[@id='link_finaliseform']")
	WebElement finalizeform;
	
	@FindBy(xpath="//*[@id='confirmationEmail']")
	WebElement confEmail;
	
	@FindBy(xpath="//*[@id='send-for-activation-button']")
	WebElement submitBtn;
	
	@FindBy(xpath="//a[contains(text(),'Offre électronique')]")	
	WebElement Offre_electronic;
	
	@FindBy(xpath="//a[@id='modal-email-offer-valid']")	
	WebElement Valider;

	public MainForm(){
		PageFactory.initElements(driver, this);
	}
	
	public FirstForm firstformClick(){
		firstForm.click();
		return new FirstForm();		
	}
	
	public SecondForm secondformClick(){
		secondForm.click();
		return new SecondForm();		
	}
	
	public ThirdForm thirdformClick(){
		thirdForm.click();
		return new ThirdForm();		
	}
	
	public void mainSubmissionPlan(){
		finalizer.click();
		finalizeform.click();
		confEmail.click();
		submitBtn.click();
	}
	
	public void mainSubmissionSmartphone(){
		Offre_electronic.click();
		Valider.click();
	}
		
		
	public void mainSubmission(String mainchain){
		
		if(mainchain.equalsIgnoreCase("CALL IT CAMPAIGN")){
			mainSubmissionSmartphone();
		}
		else if(mainchain.equalsIgnoreCase("MP TESTGROUP")){
			mainSubmissionPlan();
		}
		
	}
	
}
