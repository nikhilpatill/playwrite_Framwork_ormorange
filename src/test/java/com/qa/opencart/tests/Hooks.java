package com.qa.opencart.tests;

import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;

import propertyfile.propertyfile;

public class Hooks {

    // Static login method just like TypeScript
	PlaywrightFactory bs;
	Page page;
	HomePage hm;
	propertyfile pl;
	LoginPage loginPage;
	
	
	public void loginapplication()
	{
		bs = new PlaywrightFactory();
		page = bs.initBrowser("chromium", "https://tutorialsninja.com/demo/index.php?route=account/login");
		loginPage = new LoginPage(page);
		loginPage.placeholder_Username_inputField();
		loginPage.placeholder_Password_inputField();
		loginPage.submitBtn();
		
	}

	
	
	
	
	
}
