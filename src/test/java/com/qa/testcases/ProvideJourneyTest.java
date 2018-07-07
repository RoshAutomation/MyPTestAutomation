package com.qa.testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.FirstForm;
import com.qa.pages.HomePage;
import com.qa.pages.MainForm;
import com.qa.pages.SecondForm;
import com.qa.pages.ThirdForm;
import com.qa.util.TestUtil;


public class ProvideJourneyTest extends TestBase {

	HomePage homePage;
	MainForm mainform;
	SecondForm sForm;
	FirstForm fForm;
	ThirdForm tForm;
	TestUtil util=new TestUtil();
	
	String sheetName="Provide";
	
	public ProvideJourneyTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		homePage = new HomePage();
		mainform=new MainForm();
		tForm=new ThirdForm();
		sForm=new SecondForm(); 
		fForm=new FirstForm();
	}
	
	@DataProvider
	public Object[][] getMyPTestData(){
		Object data[][] =TestUtil.getTestData(sheetName);
		return data;
	}
	
/*	@Test(priority=1, dataProvider="getMyPTestData")
	public void ProvideWithEasy(String mainchain, String plan, String ntype, String msisdn, String oSim) throws InterruptedException{
		homePage.Aramis_b4Selection();
		homePage.Aramis_AfterSelection(mainchain);
		mainform= homePage.NouvelAbonnement_click();
		fForm=mainform.firstformClick();
		fForm.FForm();
		sForm=mainform.secondformClick();
		sForm.mobileVoicePostpaid(plan, ntype, msisdn, oSim);
		tForm=mainform.thirdformClick();
		tForm.PaymentOptions();
		mainform.mainSubmission();
	}*/
	
	@Test(priority=1, dataProvider="getMyPTestData")
	public void ProvideWithEasy(String mainchain, String plan, String ntype, String msisdn, String oSim) throws InterruptedException{
		homePage.Aramis_b4Selection();
		homePage.Aramis_AfterSelection(mainchain);
		mainform= homePage.NouvelAbonnement_click();
		fForm=mainform.firstformClick();
		fForm.FForm();
		sForm=mainform.secondformClick();
		sForm.mobileVoice(mainchain,plan, ntype, msisdn, oSim);
		tForm=mainform.thirdformClick();
		tForm.PaymentOptions();
		mainform.mainSubmission(mainchain);
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
