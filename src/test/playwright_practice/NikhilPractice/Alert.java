package NikhilPractice;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Alert {

	static Page page;
	static Base_Utility bs;

	public static void days2() {

		bs = new Base_Utility();
		page = bs.init2("chrome", "https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");

		Locator buttons = page.locator("//p[text()='JavaScript Alerts']/button");

		buttons.click();
		page.onceDialog(alert -> {

			String message = alert.message();

			System.out.println(message);
			alert.accept();

		});
		page.close();

	}

	public static void main(String[] args) {

		days2();

	}

}
