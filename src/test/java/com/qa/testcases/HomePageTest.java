package com.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.MainForm;
import com.qa.util.TestUtil;

public class HomePageTest extends TestBase{

	HomePage homePage;
	MainForm mainform;
	TestUtil util=new TestUtil();
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		homePage = new HomePage();
	}
	
	
   @Test(priority=1)
	public void homePageTitleTest(){
		String title= homePage.ValidateHomePageTitle();
		mainform= homePage.NouvelAbonnement_click();
		System.out.println(title);
		Assert.assertEquals(title, "My Partner > Tools > Care @ Contact Center");
	}
	
	@Test(priority=2)
	public void mainPageTitleTest() throws InterruptedException{
		mainform= homePage.NouvelAbonnement_click();
		util.switchToWindow();
		String title= homePage.ValidateHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, ":: Webforms ::");
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
}
