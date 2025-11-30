package NikhilPractice;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class Dropdownhandle {

	static Page page;
	static Base_Utility bs;

	public static void day() {

		bs = new Base_Utility();
		page = bs.init2("chrome", "https://qa-practice.netlify.app/dropdowns");
		page.setViewportSize(1920, 1080);

		Locator sc = page.locator("//Select[@id=\"dropdown-menu\"]");

		sc.click();

		sc.selectOption("Afganistan");

	}

	public static void main(String[] args) {

		day();

	}

}
