package NikhilPractice;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Multiplexpath {

	static Page page;
	static Base_Utility bs;

	public static void days2() {

		bs = new Base_Utility();
		page = bs.init2("chrome", "https://qa-practice.netlify.app/auth_ecommerce");

		Locator s = page.locator("//label[@for='email'] | //label[text()='Email'] | //label[@for='password'] | //input[@id='email'] |//input[@id='password'] ");

		
		
	
		}

	

	public static void main(String[] args) {

		days2();

	}

}
