package com.qa.opencart.pages;

import com.microsoft.playwright.Page;
import propertyfile.propertyfile;

public class HomePage {

	private final Page page;
	public propertyfile pl;
	propertyfile props = new propertyfile("src/test/resources/config/config.properties");
	

	// 1. String Locators - OR
	private String Login_txt = "//h5[text()='Login']";

	private String Username_Admin_txt = "//p[text()='Username : Admin']";

	private String Password_admin123_txt = "//p[text()='Password : admin123']";

	private String Username_txt = "//label[text()='Username']";

	private String Password_txt = "//label[text()='Password']";

	private String placeholder_Username_txt = "//input[@placeholder='Username']";

	private String placeholder_Password_txt = "//input[@placeholder='Password']";

	private String submitBtn = "//button[@type='submit']";

	private String dashboadTxt = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']";

	private String Errormessage = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']";

	private String forgetpasswordTxt = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']";

	private String Reset_PasswordTxt = "//h6[text()='Reset Password']";

	private String Reset_usernameinputfiled = "//input[@placeholder=\"Username\"]";

	private String Reset_Password_link_sent_successfully = "//h6[text()	='Reset Password link sent successfully']";

	private String Reset_Passwordbtn = "//button[text(=' Reset Password ']";

	private String Reset_Cancalbtn = "//button[@type='button']";

	private String email = "//input[@type='email'] | //input[@id='Email']";
	private String password = "//input[@id='Password']";
	private String clickLoginBtn = "//button[text(='Log in']";
	private String searchPageHeader = "div#content h1";
	private String loginLink = "a:text('Login'";
	private String myAccountLink = "//h1[text(='Admin area demo']";

	// 2. page constructor:
	public HomePage(Page page) {

		this.page = page;

	}

	// 3. page actions/methods:
	public String getHomePageTitle() {
		String title = page.title();
		System.out.println("page title: " + title);
		return title;
	}

	public String Reset_Password_link_sent_successfully() {

		return page.textContent(Reset_Password_link_sent_successfully);

	}

	public String dashboadTxt() {

		return page.textContent(dashboadTxt);

	}

	public void Reset_Passwordbtn() {

		page.click(Reset_Passwordbtn);

	}

	public void Reset_Cancalbtn() {

		page.click(Reset_Cancalbtn);

	}

	public void forgetpasswordclick() {

		page.click(forgetpasswordTxt);

	}

	public void Reset_usernameinputfiled() {
		page.fill(placeholder_Username_txt, props.getProperty("email"));

	}

	public String forgetpasswordTxt() {

		return page.textContent(forgetpasswordTxt);

	}

	public String Reset_PasswordTxt() {
		return page.textContent(Reset_PasswordTxt);

	}

	public String Errormessage() {

		return page.textContent(Errormessage);

	}

	public String Username_txt() {

		return page.textContent(Username_txt);

	}

	public String Password_txt() {

		return page.textContent(Password_txt);

	}

	public String placeholder_Username_txt() {

		return page.textContent(placeholder_Username_txt);

	}

	public void placeholder_Username_inputField() {

		page.fill(placeholder_Username_txt, props.getProperty("username"));

	}

	public void placeholder_Password_inputField() {

		page.fill(placeholder_Password_txt, props.getProperty("password"));

	}

	public String placeholder_Password_txt() {

		return page.textContent(placeholder_Password_txt);

	}

	public String Username_Admin_txt() {

		return page.textContent(Username_Admin_txt);

	}

	public String Password_admin123_txt() {
		return page.textContent(Password_admin123_txt);

	}

	public void submitBtn() {
		page.click(submitBtn);

	}

	public String Login_txt1() {
		return page.textContent(Login_txt);

	}

	public void EmailInput() {

		page.fill(email, props.getProperty("username"));

	}

	public String Login_txt() {

		return page.textContent(Login_txt);

	}

	public void passwordInput() {

		page.fill(password, props.getProperty("password"));

	}

	public void clickLoginBtn() {

		page.click(clickLoginBtn);

	}

	public String getHomePageURL() {
		String url = page.url();
		System.out.println("page url : " + url);
		return url;
	}

	public String doSearch(String productName) {
		// page.fill(search, productName;
		// page.click(searchIcon;
		String header = page.textContent(searchPageHeader);
		System.out.println("search header: " + header);
		return header;
	}

	public LoginPage navigateToLoginPage() {
		page.click(myAccountLink);
		page.click(loginLink);
		return new LoginPage(page);
	}

}
