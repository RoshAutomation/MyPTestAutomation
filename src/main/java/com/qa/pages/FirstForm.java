package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class FirstForm extends TestBase {
	
	TestUtil util= new TestUtil();

	//Page Factory - OR:
	@FindBy(xpath="//input[@id='buspriv963']")
	WebElement B2C;
		
	@FindBy(xpath=".//*[@id='form1']/div[2]/div[13]/div[2]/span/label[2]")
	WebElement Encodage_manuel;
	
	@FindBy(xpath="//*[@data-id='id_id_type']")
	WebElement IdentityDD;
	@FindBy(xpath="//span[.='Carte d’identité / passeport / titre de séjour délivré par une autorité belge']")
	WebElement IdentitySS;
	@FindBy(xpath="//input[@id='clinuidcard']")
	WebElement id;
	
	@FindBy(xpath="//*[@data-id='id_clilang']")
	WebElement Langue;
	@FindBy(xpath="//span[.='Français']")
	WebElement french;
	
	@FindBy(xpath="//*[@id='clifname']")
	WebElement firstname;
	@FindBy(xpath="//*[@id='clilname']")
	WebElement lstname;
	
	@FindBy(xpath="//*[@id='clibirthdate']")
	WebElement dob;
	 
	@FindBy(xpath="//*[@id='clizip']") //1000
	WebElement zipCode;
	
	@FindBy(xpath="//*[@id='clicity']") // BRUXELLES
	WebElement city;
	
	@FindBy(xpath="//*[@id='cliaddress']") //Avenue 's Heeren Huys
	WebElement address;
	
	@FindBy(xpath="//*[@id='cliadnum']") //2586
	WebElement num;
	
	@FindBy(xpath="//*[@id='clitel']")
	WebElement tel;
	
	@FindBy(xpath="//input[@id='clitel_tele']")
	WebElement Othertel;
	
	@FindBy(xpath="//*[@id='adslemail']")
	WebElement mail;
	@FindBy(xpath="//*[@id='adslemailConfirmation']")
	WebElement confirmationEmail;
	
	@FindBy(xpath="//input[@id='crdorderlevel939']")
	WebElement crdNO;
	
	@FindBy(xpath="//button[contains(text(),'Enregistrer')]")
	WebElement Enregister;
	
	@FindBy(xpath="//span[.='Valider']")
	WebElement Valider;
	
	public FirstForm(){
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean isElementPresent(WebElement element) {
		   try {
		       driver.findElement((By) element);
		       return true;
		   } catch (NoSuchElementException e) {
		       return false;
		   }
		}
	
	
	public void FForm(){
		B2C.click();
		boolean isElementPresent=util.isElementPresent(By.xpath(".//*[@id='form1']/div[2]/div[13]/div[2]/span/label[2]"));
		System.out.println(isElementPresent);
		if(isElementPresent==true){
			Encodage_manuel.click();
		}
		else if(isElementPresent==false){
			Othertel.sendKeys("026405908");
		}
		IdentityDD.click();
		IdentitySS.click();
		id.sendKeys("592164790654");
		Langue.click();
		french.click();
		firstname.sendKeys("Roshan");
		lstname.sendKeys("Gupta");
		dob.sendKeys("23/05/1989");
		zipCode.sendKeys("1000");
		city.sendKeys("BRUXELLES");
		address.sendKeys("Avenue 's Heeren Huys");
		num.sendKeys("2586");
		tel.sendKeys("026405908");
		mail.sendKeys("culroshan93@gmail.com");
		confirmationEmail.sendKeys("culroshan93@gmail.com");
		crdNO.click();
		Enregister.click();
		Valider.click();	
	}
}
