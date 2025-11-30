package NikhilPractice;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.WaitForOptions;
import com.microsoft.playwright.Page;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class daysfirst {

	static Page page;
	static Base_Utility bs;

	public static void days2() {

		bs = new Base_Utility();
		page = bs.init2("chrome", "https://qa-practice.netlify.app/auth_ecommerce");
		page.setViewportSize(1920, 1080);

		page.navigate("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
		Locator email = page.locator("//label[@for='input-email']");
		String emailtxt = email.textContent();
		String acutaltitle = page.title();
		System.out.println(page.title());

		assertThat(email).equals(emailtxt);
		assertThat(page).hasTitle("Account Login");

		page.navigate("https://qa-practice.netlify.app/tab");

// => handle window -->

		Page newindow = page.waitForPopup(() -> {

			Locator btnclickm = page.locator("//a[text()='Press me - New Tab']");
			btnclickm.click();

		});

		String newwindow = newindow.url();
		System.out.println("new_window handle " + newwindow);
		String url = page.url();
		System.out.println("parent window url " + url);

		page.navigate("http://google.com/");
		System.out.println(page.title());

		page.close();

	}

	public static void day1() {
		bs = new Base_Utility();
		page = bs.init2("chrome", "https://qa-practice.netlify.app/auth_ecommerce");

		String Email = "nikhilpatil1050@gmail.com";

		Locator emailLabel = page.locator("//label[@for='email']");
		String emailLabel1 = emailLabel.textContent();
		System.out.println(emailLabel1);
		assertThat(emailLabel).equals(emailLabel1);
		assertThat(emailLabel).isVisible();

		Locator emailfiled = page.locator("//input[@type='email']");
		emailfiled.fill(Email);

		Locator submitbtn = page.locator("//button[@type='submit' and  @id='submitLoginBtn']");
		submitbtn.click();

		// -----------------------------------------------------------------------------------

		page.navigate("https://qa-practice.netlify.app/register");
		String currenturl = page.url();
		assertThat(page).hasURL(currenturl);

		page.reload();
		page.goForward();
		page.goBack();

		assertThat(emailLabel).equals(emailLabel1);

		page.close();

	}

	public static void main(String[] args) {

		days2();

	}

}
