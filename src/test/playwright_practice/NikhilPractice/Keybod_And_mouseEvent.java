package NikhilPractice;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Keybod_And_mouseEvent {

	static Page page;
	static Base_Utility bs;

	public static void days3() throws InterruptedException {

		bs = new Base_Utility();
		page = bs.init2("chrome", "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");

		Locator s = page.locator("//input[@type='email']");

		s.page().wait(3000);
		s.click();
		backprass(page, s);
		s.clear();

		ScrollToElement(page);

	}

	public static void slectAll() {

		bs = new Base_Utility();
		page = bs.init2("chrome", "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");

		Locator s = page.locator("//h2[text()='Defaults for admin area']");
		s.page().keyboard().press("Control+A");
		s.page().keyboard().press("Backspace");

	}

	public static void backprass(Page page, Locator ele) {

		for (int i = 0; i < ele.count(); i++) {
			ele.page().keyboard().press("Backspace");
		}

	}

	public static void pagedown() {
		
		bs = new Base_Utility();
		page = bs.init2("chrome", "https://playwright.dev/java/docs/next/api/class-keyboard");
		
	
	
		

	}

	public static void ScrollToElement(Page page) {

		for (int i = 0; i < 10; i++) {
			page.keyboard().press("ArrowDown");
		}

	}

	public static void main(String[] args) throws InterruptedException {

		days3();

	}

}
