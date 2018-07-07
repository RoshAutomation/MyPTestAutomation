package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class ThirdForm extends TestBase {
	
	//Page Factory - OR:
		@FindBy(xpath="//*[@id='pay_choice6']")
		WebElement Domiciliation;
		
		@FindBy(xpath="//*[@id='payncompt']")
		WebElement IBAN;
		
		@FindBy(xpath="//a[@id='Tab3']")
		WebElement Tool_Click;
		
		@FindBy(xpath="//button[contains(text(),'Enregistrer')]")
		WebElement Enregister;
	
	public ThirdForm(){
		PageFactory.initElements(driver, this);
	}
	
	public void PaymentOptions(){
		Domiciliation.click();
		IBAN.sendKeys("BE68539007547034");
		Enregister.click();
	}

}
