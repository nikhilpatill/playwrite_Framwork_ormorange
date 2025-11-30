package NikhilPractice;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class windowhandle {

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

	public static void main(String[] args) {

		days2();

	}

}
