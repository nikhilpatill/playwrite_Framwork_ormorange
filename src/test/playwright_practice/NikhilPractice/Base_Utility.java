package NikhilPractice;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Base_Utility {

	public static Playwright playwright;
	public static Browser browser; //
	public static Page page;
	public static LaunchOptions op;

	public static Page init2(String bname, String url) {

		if (bname.equalsIgnoreCase("chrome") || bname.equalsIgnoreCase("ch")) {
			playwright = Playwright.create();
			op = new LaunchOptions();
			op.setHeadless(false);
			browser = playwright.chromium().launch(op);

		}

		else if (bname.equalsIgnoreCase("firefox") || bname.equalsIgnoreCase("ff")) {
			playwright = Playwright.create();
			op = new LaunchOptions();
			op.setHeadless(false);
			browser = playwright.firefox().launch(op);

		}

		page = browser.newPage();
		page.navigate(url);
		return page;
	}

	public static Page initBrowser(String browserName, String url) {

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

	public static void day2() {

		initBrowser("chromium", "https://qa-practice.netlify.app/auth_ecommerce");

		Locator email = page.locator("//input[@type='email']");

		email.fill("nikhilpatil1050@gmail.com");

		Locator password = page.locator("//input[@id='password']");

		password.fill("Welcome@123");

		Locator submit = page.locator("//button[@type='submit' and @id='submitLoginBtn']");

		submit.click();

	}

	public static void main(String[] args) {

		day2();

	}

}
