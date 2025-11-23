package com.qa.opencart.tests;
import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;

import propertyfile.propertyfile;


public class loginpage_Test {
	
	PlaywrightFactory bs;
	Page page;
	HomePage hm;
	propertyfile pl;

	    static  Hooks hooks;
	    LoginPage loginPage;
	    
	    
	  
	    @BeforeMethod()
		public void initBrowser() {
		
		    loginPage = new LoginPage(page);
		    hooks = new Hooks();
		    hooks.loginapplication();
		}


	    @Test
	    void dashboardPageListOfElements() {

	        Locator allOptions = hooks.page.locator("//div[@class='list-group']/a");
	        int count = allOptions.count();
	        System.out.println("Total number of options: " + count);

	        for (Locator option : allOptions.all()) {
	            System.out.println(option.textContent());
	        }
	    }


	    @Test
	    void editAccountValidateAll() {

	        Locator allOptions = page.locator("//div[@class='list-group']/a");

	        int count = allOptions.count();
	        System.out.println("Total options: " + count);

	        for (Locator option : allOptions.all()) {

	            String text = option.textContent().trim();
	            System.out.println("Clicking: " + text);

	            switch (text) {

	                case "Edit Account":
	                    option.click();
	                    Assert.assertEquals(
	                            "My Account Information",
	                            page.locator("//h1[text()='My Account Information']").textContent()
	                    );
	                    break;

	                case "Password":
	                    option.click();
	                    Assert.assertEquals(
	                            "Change Password",
	                            page.locator("//h1[text()='Change Password']").textContent()
	                    );
	                    break;

	                case "Address Book":
	                    option.click();
	                    Assert.assertEquals(
	                            "Address Book Entries",
	                            page.locator("//h2[text()='Address Book Entries']").textContent()
	                    );
	                    break;

	                case "My Wish List":
	                    option.click();
	                    Assert.assertEquals(
	                            "My Wish List",
	                            page.locator("//h2[text()='My Wish List']").textContent()
	                    );
	                    break;

	                case "Order History":
	                    option.click();
	                    Assert.assertEquals(
	                            "Order History",
	                            page.locator("//h1[text()='Order History']").textContent()
	                    );
	                    break;

	                case "Downloads":
	                    option.click();
	                    Assert.assertEquals(
	                            "Account Downloads",
	                            page.locator("//h2[text()='Account Downloads']").textContent()
	                    );
	                    break;

	                case "Recurring Payments":
	                    option.click();
	                    Assert.assertEquals(
	                            "Recurring Payments",
	                            page.locator("//h1[text()='Recurring Payments']").textContent()
	                    );
	                    break;

	                case "Reward Points":
	                    option.click();
	                    Assert.assertEquals(
	                            "Your Reward Points",
	                            page.locator("//h1[text()='Your Reward Points']").textContent()
	                    );
	                    break;

	                case "Returns":
	                    option.click();
	                    Assert.assertEquals(
	                            "Product Returns",
	                            page.locator("//h1[text()='Product Returns']").textContent()
	                    );
	                    break;

	                case "Transactions":
	                    option.click();
	                    Assert.assertEquals(
	                            "Your Transactions",
	                            page.locator("//h1[text()='Your Transactions']").textContent()
	                    );
	                    break;

	                case "Newsletter":
	                    option.click();
	                    Assert.assertEquals(
	                            "Newsletter Subscription",
	                            page.locator("//h1[text()='Newsletter Subscription']").textContent()
	                    );
	                    break;

	                case "Logout":
	                    option.click();
	                    Assert.assertEquals(
	                            "Account Logout",
	                            page.locator("//h1[text()='Account Logout']").textContent()
	                    );
	                    break;

	                default:
	                    System.out.println("Skipping: " + text);
	                    break;
	            }
	        }
	    }
	}



