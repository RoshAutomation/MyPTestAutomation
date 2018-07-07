package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;

public class SecondForm extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//input[@id='radipro670']")
	WebElement Colibri;
	
	@FindBy(xpath="//input[@id='radipro701']")
	WebElement ColibriZen;
	
	@FindBy(xpath="//input[@id='radipro671']")
	WebElement Dolphin;
	
	@FindBy(xpath="//input[@id='radipro702']")
	WebElement DolphinZen;
	
	@FindBy(xpath="//input[@id='radipro672']")
	WebElement Koala;
	
	@FindBy(xpath="//input[@id='radipro673']")
	WebElement Panther;
	
	@FindBy(xpath="//input[@id='radipro676']")
	WebElement Eagle;
	
	@FindBy(xpath="//input[@id='radipro692']")
	WebElement EaglePremium;
	
	@FindBy(xpath="//input[@id='radipro693']")
	WebElement Colibri_Smartphone;
	
	@FindBy(xpath="//input[@id='radipro700']")
	WebElement Colibri_Zen_Smartphone;
	
	@FindBy(xpath="//input[@id='radipro694']")
	WebElement Daulphin_Smartphone;
	
	@FindBy(xpath="//input[@id='radipro699']")
	WebElement Daulphin_Zen_Smartphone;
	
	@FindBy(xpath="//input[@id='radipro695']")
	WebElement Koala_Smartphone;
	
	@FindBy(xpath="//input[@id='radipro696']")
	WebElement Panther_Smartphone;
	
	@FindBy(xpath="//input[@id='radipro697']")
	WebElement Eagle_Smartphone;
	
	@FindBy(xpath="//input[@id='radipro698']")
	WebElement Eagle_Premium_Smartphone;
	
	@FindBy(xpath="//button[@data-id='id_promcode']")
	WebElement advantage;
	
	@FindBy(xpath="//span[.='No Promo']")
	WebElement noPromo;
	
	@FindBy(xpath="//button[@data-id='id_clusterizable_promotion']")
	WebElement promotion;
	
	@FindBy(xpath="//span[.='25% de réduction sur votre abonnement pendant 3 mois']")
	WebElement number_25_percent;
	
	@FindBy(xpath="//button[@data-id='id_globalloyal']")
	WebElement contractDuration;
	
	@FindBy(xpath="//span[.='Indéfinie']")
	WebElement indefinite;
	
	@FindBy(xpath="//span[.='24 mois']")
	WebElement months_24;
	
	@FindBy(xpath="//button[@id='gid6']")
	WebElement gsm_modem;
	    
	@FindBy(xpath="//span[.='IPHONE 7 BLACK 128GB - REF MN922ZD/A - HANDSET ']")
	WebElement Phone;
	
	@FindBy(xpath="//input[@id='sendNewSimCard1881']")
	WebElement noNewSimCard;
	
	@FindBy(xpath="//input[@id='deliveryMode1746']")
	WebElement domicile;
	
	@FindBy(xpath="//input[@id='address_delivry1608']")
	WebElement yes;
	
	@FindBy(xpath="//input[@id='sim']")
	WebElement orangeSim;
	
	@FindBy(xpath="//button[@data-id='id_numsource']")
	WebElement numberSource;
	
	@FindBy(xpath="//span[.='Nouveau numéro']")
	WebElement newNumber;
	
	@FindBy(xpath="//button[@data-id='id_optnum']")
	WebElement numberType;
	
	@FindBy(xpath="//span[.='A définir par Orange']")
	WebElement TBD;
	
	@FindBy(xpath="//span[.='Numéro réservé - Easy Number']")
	WebElement easyDD;
	
	@FindBy(xpath="//span[.='Numéro réservé - Gold Number']")
	WebElement goldDD;
	
	@FindBy(id="gsm")
	WebElement easyNumber;
	
	@FindBy(id="gsmb")
	WebElement goldNumber;
	
	@FindBy(xpath="//button[contains(text(),'Enregistrer')]")
	WebElement Enregister;
	
	
	public SecondForm(){
		PageFactory.initElements(driver, this);
	}
	

	public void tariffPlan(String simOnly) throws InterruptedException{
		
		if(simOnly.equalsIgnoreCase("Colibri")){
			Colibri.click(); }
		else if(simOnly.equalsIgnoreCase("ColibriZen")){
			ColibriZen.click(); }
		else if(simOnly.equalsIgnoreCase("Dolphin")){
			Dolphin.click(); }
		else if(simOnly.equalsIgnoreCase("DolphinZen")){
			DolphinZen.click(); }
		else if(simOnly.equalsIgnoreCase("Koala")){
			Koala.click(); }
		else if(simOnly.equalsIgnoreCase("Eagle")){
			Eagle.click(); }
		else if(simOnly.equalsIgnoreCase("EaglePremium")){
			EaglePremium.click(); }
		else if(simOnly.equalsIgnoreCase("Colibri_Smartphone")){
			Colibri_Smartphone.click(); }
		else if(simOnly.equalsIgnoreCase("Colibri_Zen_Smartphone")){
			Colibri_Zen_Smartphone.click(); }
		else if(simOnly.equalsIgnoreCase("Daulphin_Smartphone")){
			Daulphin_Smartphone.click(); }
		else if(simOnly.equalsIgnoreCase("Daulphin_Zen_Smartphone")){
			Daulphin_Zen_Smartphone.click(); }
		else if(simOnly.equalsIgnoreCase("Koala_Smartphone")){
			Koala_Smartphone.click(); }
		else if(simOnly.equalsIgnoreCase("Panther_Smartphone")){
			Panther_Smartphone.click(); }
		else if(simOnly.equalsIgnoreCase("Eagle_Smartphone")){
			Eagle_Smartphone.click(); }
		else if(simOnly.equalsIgnoreCase("Eagle_Premium_Smartphone")){
			Eagle_Premium_Smartphone.click(); }	
	}
	
	public void typeOfNumber(String nType,String number,String oSim) throws InterruptedException{
		orangeSim.sendKeys(oSim);
			numberSource.click();
			newNumber.click();
			numberType.click();
				if(nType.equalsIgnoreCase("Easy")){
						easyDD.click(); 
						easyNumber.sendKeys(number);}
				else if(nType.equalsIgnoreCase("Gold")){
						goldDD.click();
						goldNumber.sendKeys(number);}
				else if(nType.equalsIgnoreCase("TBD")){
						TBD.click(); }
		}
		
	
	public void mobileVoicePostpaid(String plan,String nType,String number,String oSim) throws InterruptedException{
				tariffPlan(plan);
				advantage.click();
				noPromo.click();
				promotion.click();
				number_25_percent.click();
				contractDuration.click();
				indefinite.click();		
				typeOfNumber(nType,number,oSim);
				Enregister.click();			
	}
	
	public void mobileVoiceSmartphone(String plan,String nType,String number,String oSim) throws InterruptedException {
		tariffPlan(plan);
		promotion.click();
		noPromo.click();
		contractDuration.click();
		months_24.click();	
		gsm_modem.click();
		Phone.click();
		noNewSimCard.click();
		domicile.click();
		yes.click();
		typeOfNumber(nType,number,oSim);
		Enregister.click();			
	}
	
	
	public void mobileVoice(String mainchain,String plan,String nType,String number,String oSim) throws InterruptedException {
		if(mainchain.equalsIgnoreCase("CALL IT CAMPAIGN")){
			mobileVoiceSmartphone(plan, nType, number, oSim);
		}
		else if(mainchain.equalsIgnoreCase("MP TESTGROUP")){
			mobileVoicePostpaid(plan, nType, number, oSim);
		}
		
	}

}
