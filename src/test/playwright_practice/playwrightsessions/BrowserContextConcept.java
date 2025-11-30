package playwrightsessions;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserContextConcept {
	
	static Playwright playwright;
	static Browser browser;
	static Page page ;
	static LaunchOptions op;

	
public static Page initBrowser(String browserName , String url) {


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
	
	public static void days1() {
		
		initBrowser("chromium","https://ecommerce-playground.lambdatest.io/index.php" );
		Locator myAccount = page.locator("//a[contains(.,'My account')][@role='button']");
		myAccount.hover();
//		page.click("//a[contains(.,'Login')]");
		page.locator("//a[contains(.,'Login')]").click();
		assertThat(page).hasTitle("Account Login");
		assertThat(page).hasURL("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
		page.getByPlaceholder("E-Mail Address").fill("koushik350@gmail.com");
		page.getByPlaceholder("Password").fill("Pass123$");
		page.locator("//input[@value='Login']").click();

		assertThat(page).hasTitle("My Account");
		page.close();
		browser.close();
		playwright.close();

	}

	public static void main(String[] args) {

		days1();
		
}
}
