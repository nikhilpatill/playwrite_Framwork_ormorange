package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import propertyfile.propertyfile;

public class PlaywrightFactory {

	public Playwright playwright;
	public Browser browser;
	public Page page;
	public LaunchOptions op;
	propertyfile pro;

	public void clickByJS1() {

		String jsScript = "document.getElementById('exampleButton').click()";
		page.evaluate(jsScript);

	}

	
	   public void Login(Page page )
	   {
		   
		    Locator s = page.locator("//input[@type='email'] |  ");
		   
		   
		   
		   
	   }
	
	public Page initBrowser(String browserName, String url) {

		switch (browserName.toLowerCase()) {

		case "chromium":
			playwright = Playwright.create();
			op = new LaunchOptions();
			op.setHeadless(false);
			browser = playwright.chromium().launch(op);

			break;
		case "firefox":
			playwright = Playwright.create();
			op = new LaunchOptions();
			op.setHeadless(false);
			browser = playwright.firefox().launch(op);

			break;

		default:
			System.out.println("please pass the right browser name......");
			break;
		}

		page = browser.newPage();
		page.navigate(url);
		return page;

	}

	public void clickByJS() {
		String jsScript = "document.getElementById('exampleButton').click()";
		page.evaluate(jsScript);

	}

}
