package com.qa.opencart.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import propertyfile.propertyfile;

public class LoginPage {

	private final Page page;
	public propertyfile pl;
	propertyfile props = new propertyfile("src/test/resources/config/config.properties");
    
    	String Login_txt = "//h5[text()='Login']";
    	String usernameInput = "//input[@name='email']";
    	String passwordInput = "//input[@name='password']";
    	String submitButton =  "//input[@type='submit']";
    	
    	
    	public LoginPage(Page page) {

    		this.page = page;

    	}
    	
    	
    	public void placeholder_Username_inputField() {

    		page.fill(usernameInput, props.getProperty("username"));

    	}

    	public void placeholder_Password_inputField() {

    		page.fill(passwordInput, props.getProperty("password"));

    	}
    	
    	public void submitBtn() {
    		page.click(submitButton);

    	}

    
    
	
    
    
    
    
}

   
