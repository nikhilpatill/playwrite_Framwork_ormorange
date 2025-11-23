package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;

import propertyfile.propertyfile;

public class HomePageTest {

	PlaywrightFactory bs;
	Page page;
	HomePage hm;
	propertyfile pl;

	@BeforeMethod()
	public void initBrowser() {
		bs = new PlaywrightFactory();
		page = bs.initBrowser("firefox", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@AfterMethod()
	public void closeBrowser() {
		page.close();
	}

	@Test
	public void homePageTitleTest() {

		hm = new HomePage(page);
		String actualTitle = hm.getHomePageTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}

	@Test
	public void verify_Remembertxt_show() {
		hm = new HomePage(page);
		String Remembertxt = hm.Login_txt();
		Assert.assertEquals(Remembertxt, "Login");

	}

	@Test
	public void verify_Login_fail_posible_combination() {
		hm = new HomePage(page);
		String actualUsernametxt = hm.Username_txt();
		Assert.assertEquals(actualUsernametxt, "Username");
		String Passwordtxt = hm.Password_txt();
		Assert.assertEquals(Passwordtxt, "Password");

	}

	@Test
	public void verify_Login_with_correct_Cradancial() {
		hm = new HomePage(page);
		hm.placeholder_Username_inputField();
		hm.placeholder_Password_inputField();
		hm.submitBtn();
		String dashboadTxt = hm.dashboadTxt();
		Assert.assertEquals(dashboadTxt, "Dashboard");

	}

	@Test
	public void verify_Login_with_Wrong_Cradancial() {
		hm = new HomePage(page);
		hm.placeholder_Password_inputField();
		hm.submitBtn();
		String dashboadTxt = hm.Errormessage();
		Assert.assertEquals(dashboadTxt, "Required");

	}

	@Test
	public void verify_Login_with_Wrong_Cradancial2() {
		hm = new HomePage(page);
		hm.submitBtn();
		String dashboadTxt = hm.Errormessage();
		Reporter.log("actual result" + dashboadTxt);
		Assert.assertEquals(dashboadTxt, "Required");

	}

	@Test
	public void verify_Login_with_Wrong_Cradancial1() {
		hm = new HomePage(page);
		hm.placeholder_Username_inputField();
		hm.submitBtn();
		String dashboadTxt = hm.Errormessage();
		Reporter.log("actual result" + dashboadTxt + "acpected => " + "Required");
		Assert.assertEquals(dashboadTxt, "Required");

	}

	@Test
	public void verify_Loginpage_placeholders() {
		hm = new HomePage(page);
		String actualUsernametxt = hm.Username_txt();
		Reporter.log("actual result" + actualUsernametxt + "acpected => " + "Username");
		Assert.assertEquals(actualUsernametxt, "Username");
		String Passwordtxt = hm.Password_txt();
		Reporter.log("actual result" + Passwordtxt + "acpected => " + "Password");
		Assert.assertEquals(Passwordtxt, "Password");

	}

	@Test
	public void verify_Login_page() {
		hm = new HomePage(page);
		String currentUrl = hm.getHomePageURL();
		Reporter.log("actual result" + currentUrl + "acpected => "
				+ "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Assert.assertEquals(currentUrl, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		String actualTitle = hm.getHomePageTitle();
		Reporter.log("actual result" + actualTitle + "acpected => " + "OrangeHRM");

		Assert.assertEquals(actualTitle, "OrangeHRM");

		String actualTxt = hm.Login_txt();
		Reporter.log("actual result" + actualTxt + "acpected => " + "Login");

		Assert.assertEquals(actualTxt, "Login");
		String actualUsernameTxt = hm.Username_Admin_txt();
		Reporter.log("actual result" + actualUsernameTxt + "acpected => " + "Username : Admin");

		Assert.assertEquals(actualUsernameTxt, "Username : Admin");
		String actualPasswordTxt = hm.Password_admin123_txt();
		Reporter.log("actual result" + actualPasswordTxt + "acpected => " + "Password : admin123");

		Assert.assertEquals(actualPasswordTxt, "Password : admin123");
		String actualforgetpasswordTxtTxt = hm.forgetpasswordTxt();
		Reporter.log("actual result" + actualforgetpasswordTxtTxt + "acpected => " + "Forgot your password? ");

		Assert.assertEquals(actualforgetpasswordTxtTxt, "Forgot your password? ");
	}

	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] { { "Macbook" }, { "iMac" }, { "Samsung" } };
	}

	@Test(dataProvider = "getProductData")
	public void searchTest(String productName) throws InterruptedException {
		Thread.sleep(5000);
		hm = new HomePage(page);
		String actualSearchHeader = hm.doSearch(productName);
		Assert.assertEquals(actualSearchHeader, "Search - " + productName);
	}

}
